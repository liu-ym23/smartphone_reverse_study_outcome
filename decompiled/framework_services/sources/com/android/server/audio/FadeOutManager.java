package com.android.server.audio;

import android.media.AudioAttributes;
import android.media.AudioPlaybackConfiguration;
import android.media.FadeManagerConfiguration;
import android.media.VolumeShaper;
import android.os.SystemProperties;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Utils;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class FadeOutManager {
    private static final boolean DEBUG = false;
    public static final String TAG = "AS.FadeOutManager";
    private final FadeConfigurations mFadeConfigurations;
    private final boolean mFadeOutDisabled;
    private final Object mLock;
    private final SparseArray<FadedOutApp> mUidToFadedAppsMap;

    private static final class FadedOutApp {
        private static final VolumeShaper.Operation PLAY_CREATE_IF_NEEDED = null;
        private static final VolumeShaper.Operation PLAY_SKIP_RAMP = null;
        private final SparseArray<VolumeShaper.Configuration> mFadedPlayers;
        private final int mUid;

        static {
            PLAY_CREATE_IF_NEEDED = new VolumeShaper.Operation.Builder(VolumeShaper.Operation.PLAY).createIfNeeded().build();
            PLAY_SKIP_RAMP = new VolumeShaper.Operation.Builder(PLAY_CREATE_IF_NEEDED).setXOffset(1.0f).build();
        }

        FadedOutApp(int uid) {
            this.mFadedPlayers = new SparseArray();
            this.mUid = uid;
        }

        void dump(PrintWriter pw) {
            pw.print("\t uid:" + this.mUid + " piids:");
            int index = 0;
        L4:
            if (index >= this.mFadedPlayers.size()) goto L6;
            pw.print("piid: " + this.mFadedPlayers.keyAt(index) + " Volume shaper: " + this.mFadedPlayers.valueAt(index));
            index = index + 1;
            goto L4
        L6:
            pw.println("");
        }

        void addFade(AudioPlaybackConfiguration apc, boolean skipRamp, VolumeShaper.Configuration volShaper) {
            int piid = Integer.valueOf(apc.getPlayerInterfaceId()).intValue();
            if (this.mFadedPlayers.indexOfKey(piid) < 0) goto L6;
            return;
        L6:
            if (apc.getPlayerProxy() == null) goto L13;
            if (skipRamp == false) goto L10;
            VolumeShaper.Operation r0 = PLAY_SKIP_RAMP;
        L11:
            applyVolumeShaperInternal(apc, piid, volShaper, r0, skipRamp, "fading out");
            this.mFadedPlayers.put(piid, volShaper);
            return;
        L10:
            r0 = PLAY_CREATE_IF_NEEDED;
            goto L11
        }

        void removeUnfadeAll(Map<Integer, AudioPlaybackConfiguration> players) {
            int index = 0;
        L4:
            if (index >= this.mFadedPlayers.size()) goto L12;
            int piid = this.mFadedPlayers.keyAt(index);
            AudioPlaybackConfiguration apc = players.get(Integer.valueOf(piid));
            if (apc == null) goto L11;
            if (apc.getPlayerProxy() == null) goto L11;
            applyVolumeShaperInternal(apc, piid, null, VolumeShaper.Operation.REVERSE, false, "fading in");
        L11:
            index = index + 1;
            goto L4
        L12:
            this.mFadedPlayers.clear();
        }

        void fadeInPlayer(AudioPlaybackConfiguration apc, VolumeShaper.Configuration config) {
            int piid = Integer.valueOf(apc.getPlayerInterfaceId()).intValue();
            if (this.mFadedPlayers.contains(piid) == true) goto L5;
            return;
        L5:
            VolumeShaper.Operation operation = VolumeShaper.Operation.REVERSE;
            if (config == null) goto L8;
            VolumeShaper.Operation operation2 = new VolumeShaper.Operation.Builder().replace(this.mFadedPlayers.get(piid).getId(), true).build();
            VolumeShaper.Operation operation3 = operation2;
        L9:
            this.mFadedPlayers.remove(piid);
            if (apc.getPlayerProxy() == null) goto L13;
            applyVolumeShaperInternal(apc, piid, config, operation3, false, "fading in");
            return;
        L13:
            return;
        L8:
            operation3 = operation;
            goto L9
        }

        void clear() {
            this.mFadedPlayers.size();
            this.mFadedPlayers.clear();
        }

        void removeReleased(AudioPlaybackConfiguration apc) {
            this.mFadedPlayers.delete(Integer.valueOf(apc.getPlayerInterfaceId()).intValue());
        }

        private void applyVolumeShaperInternal(AudioPlaybackConfiguration apc, int piid, VolumeShaper.Configuration volShaperConfig, VolumeShaper.Operation operation, boolean skipRamp, String eventType) {
            if (operation.equals(VolumeShaper.Operation.REVERSE) == false) goto L5;
            VolumeShaper.Configuration config = this.mFadedPlayers.get(piid);
            VolumeShaper.Configuration config2 = config;
        L16:
            logFadeEvent(apc, piid, volShaperConfig, operation, skipRamp, eventType);     // Catch: Exception -> L12
            apc.getPlayerProxy().applyVolumeShaper(config2, operation);     // Catch: Exception -> L10
            return;
        L10:
            e = e;
        L14:
            Slog.e(FadeOutManager.TAG, "Error " + eventType + " piid:" + piid + " uid:" + this.mUid, e);
            return;
        L12:
            e = e;
            goto L14
        L5:
            config2 = volShaperConfig;
            goto L16
        }

        private void logFadeEvent(AudioPlaybackConfiguration apc, int piid, VolumeShaper.Configuration config, VolumeShaper.Operation operation, boolean skipRamp, String eventType) {
            if (eventType.equals("fading out") == false) goto L7;
            PlaybackActivityMonitor.sEventLogger.enqueue(new PlaybackActivityMonitor.FadeOutEvent(apc, skipRamp, config, operation).printLog(FadeOutManager.TAG));
            return;
        L7:
            if (eventType.equals("fading in") == false) goto L10;
            PlaybackActivityMonitor.sEventLogger.enqueue(new PlaybackActivityMonitor.FadeInEvent(apc, skipRamp, config, operation).printLog(FadeOutManager.TAG));
            return;
        L10:
            PlaybackActivityMonitor.sEventLogger.enqueue(new EventLogger.StringEvent(eventType + " piid:" + piid).printLog(FadeOutManager.TAG));
        }
    }

    public FadeOutManager() {
        this.mLock = new Object();
        this.mUidToFadedAppsMap = new SparseArray();
        this.mFadeConfigurations = new FadeConfigurations();
        this.mFadeOutDisabled = SystemProperties.getBoolean("audio.disable.fadeout", false);
    }

    int setFadeManagerConfiguration(FadeManagerConfiguration fadeManagerConfig) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mFadeConfigurations.setFadeManagerConfiguration(fadeManagerConfig);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int clearFadeManagerConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mFadeConfigurations.clearFadeManagerConfiguration();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    FadeManagerConfiguration getFadeManagerConfiguration() {
        return this.mFadeConfigurations.getFadeManagerConfiguration();
    }

    int setTransientFadeManagerConfiguration(FadeManagerConfiguration fadeManagerConfig) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mFadeConfigurations.setTransientFadeManagerConfiguration(fadeManagerConfig);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int clearTransientFadeManagerConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mFadeConfigurations.clearTransientFadeManagerConfiguration();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isFadeEnabled() {
        return this.mFadeConfigurations.isFadeEnabled();
    }

    boolean canCauseFadeOut(FocusRequester requester, FocusRequester loser) {
        if (requester.getAudioAttributes().getContentType() != 1) goto L6;
        return false;
    L6:
        if ((loser.getGrantFlags() & 2) == 0) goto L9;
        return false;
    L9:
        if (this.mFadeOutDisabled == true) goto L11;
    L14:
        return true;
    L11:
        if (Utils.isXtsPkg(requester.getPackageName()) == true) goto L14;
        Slog.d(TAG, "not fading out: disable by property");
        return false;
    }

    boolean canBeFadedOut(AudioPlaybackConfiguration apc) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mFadeConfigurations.isFadeable(apc.getAudioAttributes(), apc.getClientUid(), apc.getPlayerType());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    long getFadeOutDurationOnFocusLossMillis(AudioAttributes aa) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mFadeConfigurations.getFadeOutDuration(aa);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    long getFadeInDelayForOffendersMillis(AudioAttributes aa) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = this.mFadeConfigurations.getDelayFadeInOffenders(aa);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void fadeOutUid(int uid, List<AudioPlaybackConfiguration> players) {
        Slog.i(TAG, "fadeOutUid() uid:" + uid);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUidToFadedAppsMap.contains(uid) == true) goto L9;
        this.mUidToFadedAppsMap.put(uid, new FadedOutApp(uid));     // Catch: Throwable -> L7
    L9:
        FadedOutApp fa = this.mUidToFadedAppsMap.get(uid);     // Catch: Throwable -> L7
        Iterator<AudioPlaybackConfiguration> r2 = players.iterator();     // Catch: Throwable -> L7
    L11:
        if (r2.hasNext() == false) goto L16;
        AudioPlaybackConfiguration apc = r2.next();     // Catch: Throwable -> L7
        VolumeShaper.Configuration volShaper = this.mFadeConfigurations.getFadeOutVolumeShaperConfig(apc.getAudioAttributes());     // Catch: Throwable -> L7
        if (volShaper == null) goto L11;
        fa.addFade(apc, false, volShaper);     // Catch: Throwable -> L7
        goto L11
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void unfadeOutUid(int uid, Map<Integer, AudioPlaybackConfiguration> players) {
        Slog.i(TAG, "unfadeOutUid() uid:" + uid);
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadedOutApp fa = this.mUidToFadedAppsMap.get(uid);     // Catch: Throwable -> L8
        if (fa != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mUidToFadedAppsMap.remove(uid);     // Catch: Throwable -> L8
        ArrayList<AudioPlaybackConfiguration> apcs = new ArrayList(players.values());     // Catch: Throwable -> L8
        int index = 0;
    L12:
        if (index >= apcs.size()) goto L14;
        AudioPlaybackConfiguration apc = apcs.get(index);     // Catch: Throwable -> L8
        VolumeShaper.Configuration config = this.mFadeConfigurations.getFadeInVolumeShaperConfig(apc.getAudioAttributes());     // Catch: Throwable -> L8
        fa.fadeInPlayer(apc, config);     // Catch: Throwable -> L8
        index = index + 1;     // Catch: Throwable -> L8
        goto L12
    L14:
        fa.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void checkFade(AudioPlaybackConfiguration apc) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VolumeShaper.Configuration volShaper = this.mFadeConfigurations.getFadeOutVolumeShaperConfig(apc.getAudioAttributes());     // Catch: Throwable -> L11
        FadedOutApp fa = this.mUidToFadedAppsMap.get(apc.getClientUid());     // Catch: Throwable -> L11
        if (fa == null) goto L13;
        if (volShaper == null) goto L13;
        fa.addFade(apc, true, volShaper);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void removeReleased(AudioPlaybackConfiguration apc) {
        int uid = apc.getClientUid();
        Object r1 = this.mLock;
        monitor-enter(r1);
        FadedOutApp fa = this.mUidToFadedAppsMap.get(uid);     // Catch: Throwable -> L8
        if (fa != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        fa.removeReleased(apc);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    boolean isUidFadedOut(int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mUidToFadedAppsMap.contains(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int index = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (index >= this.mUidToFadedAppsMap.size()) goto L11;
        this.mUidToFadedAppsMap.valueAt(index).dump(pw);     // Catch: Throwable -> L8
        index = index + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }
}
