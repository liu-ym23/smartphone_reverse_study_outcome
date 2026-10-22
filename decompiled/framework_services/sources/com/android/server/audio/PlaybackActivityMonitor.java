package com.android.server.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioSystem;
import android.media.FadeManagerConfiguration;
import android.media.IPlaybackConfigDispatcher;
import android.media.PlayerBase;
import android.media.PlayerProxy;
import android.media.VolumeShaper;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import android.util.SparseIntArray;
import com.android.internal.util.ArrayUtils;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackActivityMonitor implements AudioPlaybackConfiguration.PlayerDeathMonitor, PlayerFocusEnforcer {
    static final boolean DEBUG = false;
    private static final VolumeShaper.Configuration DUCK_ID = null;
    private static final VolumeShaper.Configuration DUCK_VSHAPE = null;
    static final String EVENT_TYPE_FADE_IN = "fading in";
    static final String EVENT_TYPE_FADE_OUT = "fading out";
    private static final int FLAGS_FOR_SILENCE_OVERRIDE = 192;
    private static final int MSG_IIL_UPDATE_PLAYER_FORMAT = 3;
    private static final int MSG_IIL_UPDATE_PLAYER_MUTED_EVENT = 2;
    private static final int MSG_L_TIMEOUT_MUTE_AWAIT_CONNECTION = 1;
    private static final VolumeShaper.Configuration MUTE_AWAIT_CONNECTION_VSHAPE = null;
    private static final VolumeShaper.Operation PLAY_CREATE_IF_NEEDED = null;
    private static final VolumeShaper.Operation PLAY_SKIP_RAMP = null;
    private static final VolumeShaper.Configuration STRONG_DUCK_ID = null;
    private static final VolumeShaper.Configuration STRONG_DUCK_VSHAPE = null;
    public static final String TAG = "AS.PlaybackActivityMon";
    private static final int[] UNDUCKABLE_PLAYER_TYPES = null;
    private static final long UNMUTE_DURATION_MS = 100;
    static final int VOLUME_SHAPER_SYSTEM_DUCK_ID = 1;
    static final int VOLUME_SHAPER_SYSTEM_FADEOUT_ID = 2;
    static final int VOLUME_SHAPER_SYSTEM_MUTE_AWAIT_CONNECTION_ID = 3;
    static final int VOLUME_SHAPER_SYSTEM_STRONG_DUCK_ID = 4;
    private static final String mMetricsId = "audio.service.";
    static final EventLogger sEventLogger = null;
    private final HashMap<Integer, Integer> mAllowedCapturePolicies;
    private final ArrayList<Integer> mBannedUids;
    private final ConcurrentLinkedQueue<PlayMonitorClient> mClients;
    private final Context mContext;
    private ArrayList<Integer> mDoNotLogPiidList;
    private final DuckingManager mDuckingManager;
    private Handler mEventHandler;
    private HandlerThread mEventThread;
    private final FadeOutManager mFadeOutManager;
    private final Function<Integer, Boolean> mIsStreamMutedCb;
    private final int mMaxAlarmVolume;
    private final Consumer<AudioDeviceAttributes> mMuteAwaitConnectionTimeoutCb;
    private final ArrayList<Integer> mMutedPlayers;
    private final ArrayList<Integer> mMutedPlayersAwaitingConnection;
    private int[] mMutedUsagesAwaitingConnection;
    private final SparseIntArray mPiidToPortId;
    private final PlaybackActivityMonitorExt mPlaybackActivityMonitorExt;
    private final Object mPlayerLock;
    private final HashMap<Integer, AudioPlaybackConfiguration> mPlayers;
    private int mPrivilegedAlarmActiveCount;
    private boolean mSavedAlarmMuted;
    private int mSavedAlarmVolume;

    private static final class AudioAttrEvent extends EventLogger.Event {
        private final AudioAttributes mPlayerAttr;
        private final int mPlayerIId;

        AudioAttrEvent(int piid, AudioAttributes attr) {
            this.mPlayerIId = piid;
            this.mPlayerAttr = attr;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return new String("player piid:" + this.mPlayerIId + " new AudioAttributes:" + this.mPlayerAttr);
        }
    }

    static final class DuckEvent extends VolumeShaperEvent {
        final boolean mUseStrongDuck;

        @Override // com.android.server.audio.PlaybackActivityMonitor.VolumeShaperEvent
        String getVSAction() {
            if (this.mUseStrongDuck == false) goto L5;
            return "ducking (strong)";
        L5:
            return "ducking";
        }

        DuckEvent(AudioPlaybackConfiguration apc, boolean skipRamp, boolean useStrongDuck, VolumeShaper.Configuration config, VolumeShaper.Operation operation) {
            super(apc, skipRamp, config, operation);
            this.mUseStrongDuck = useStrongDuck;
        }
    }

    private static final class DuckingManager {
        private final HashMap<Integer, DuckedApp> mDuckers;

        private static final class DuckedApp {
            private final ArrayList<Integer> mDuckedPlayers;
            private final int mUid;
            private final boolean mUseStrongDuck;

            DuckedApp(int uid, boolean useStrongDuck) {
                this.mDuckedPlayers = new ArrayList();
                this.mUid = uid;
                this.mUseStrongDuck = useStrongDuck;
            }

            void dump(PrintWriter pw) {
                pw.print("\t uid:" + this.mUid + " piids:");
                Iterator<Integer> r0 = this.mDuckedPlayers.iterator();
            L4:
                if (r0.hasNext() == false) goto L6;
                int piid = r0.next().intValue();
                pw.print(" " + piid);
                goto L4
            L6:
                pw.println("");
            }

            void addDuck(AudioPlaybackConfiguration apc, boolean skipRamp) {
                int piid = new Integer(apc.getPlayerInterfaceId()).intValue();
                if (this.mDuckedPlayers.contains(Integer.valueOf(piid)) == false) goto L31;
                return;
            L31:
            L23:
                e = e;
            L25:
                Log.e(PlaybackActivityMonitor.TAG, "Error ducking player piid:" + piid + " uid:" + this.mUid, e);
                return;
            L6:
                if (this.mUseStrongDuck == true) goto L29;
                VolumeShaper.Configuration r0 = PlaybackActivityMonitor.m2177$$Nest$sfgetDUCK_VSHAPE();     // Catch: Exception -> L23
            L12:
                VolumeShaper.Configuration config = r0;
                if (skipRamp == false) goto L16;
                VolumeShaper.Operation r1 = PlaybackActivityMonitor.m2179$$Nest$sfgetPLAY_SKIP_RAMP();     // Catch: Exception -> L9
            L15:
                VolumeShaper.Operation operation = r1;
                PlaybackActivityMonitor.sEventLogger.enqueue(new DuckEvent(apc, skipRamp, this.mUseStrongDuck, config, operation).printLog(PlaybackActivityMonitor.TAG));     // Catch: Exception -> L21
                apc.getPlayerProxy().applyVolumeShaper(config, operation);     // Catch: Exception -> L21
                this.mDuckedPlayers.add(Integer.valueOf(piid));     // Catch: Exception -> L21
                return;
            L21:
                e = e;
            L9:
                e = e;
                goto L25
            L16:
                r1 = PlaybackActivityMonitor.m2178$$Nest$sfgetPLAY_CREATE_IF_NEEDED();     // Catch: Exception -> L23
                goto L15
            L29:
                r0 = PlaybackActivityMonitor.m2181$$Nest$sfgetSTRONG_DUCK_VSHAPE();     // Catch: Exception -> L9
                goto L12
            }

            void removeUnduckAll(HashMap<Integer, AudioPlaybackConfiguration> players) {
                Iterator<Integer> r1 = this.mDuckedPlayers.iterator();
            L4:
                if (r1.hasNext() == false) goto L17;
                int piid = r1.next().intValue();
                AudioPlaybackConfiguration apc = players.get(Integer.valueOf(piid));
                if (apc == null) goto L4;
                PlaybackActivityMonitor.sEventLogger.enqueue(new EventLogger.StringEvent("unducking piid:" + piid).printLog(PlaybackActivityMonitor.TAG));     // Catch: Exception -> L10
                PlayerProxy r4 = apc.getPlayerProxy();     // Catch: Exception -> L10
                if (this.mUseStrongDuck == false) goto L12;
                VolumeShaper.Configuration r5 = PlaybackActivityMonitor.m2180$$Nest$sfgetSTRONG_DUCK_ID();     // Catch: Exception -> L10
            L13:
                r4.applyVolumeShaper(r5, VolumeShaper.Operation.REVERSE);     // Catch: Exception -> L10
                goto L4
            L12:
                r5 = PlaybackActivityMonitor.m2176$$Nest$sfgetDUCK_ID();     // Catch: Exception -> L10
            L10:
                e = move-exception;
                Log.e(PlaybackActivityMonitor.TAG, "Error unducking player piid:" + piid + " uid:" + this.mUid, e);
                goto L4
            L17:
                this.mDuckedPlayers.clear();
            }

            void removeReleased(AudioPlaybackConfiguration apc) {
                this.mDuckedPlayers.remove(new Integer(apc.getPlayerInterfaceId()));
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDuckers, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m2182$$Nest$fgetmDuckers(DuckingManager r0) {
            return r0.mDuckers;
        }

        /* synthetic */ DuckingManager(PlaybackActivityMonitorIA r1) {
            this();
        }

        private DuckingManager() {
            this.mDuckers = new HashMap();
        }

        synchronized void duckUid(int uid, ArrayList<AudioPlaybackConfiguration> apcsToDuck, boolean requestCausesStrongDuck) {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mDuckers.containsKey(Integer.valueOf(uid)) == true) goto L8;
            this.mDuckers.put(Integer.valueOf(uid), new DuckedApp(uid, requestCausesStrongDuck));     // Catch: Throwable -> L6
        L8:
            DuckedApp da = this.mDuckers.get(Integer.valueOf(uid));     // Catch: Throwable -> L6
            Iterator<AudioPlaybackConfiguration> r1 = apcsToDuck.iterator();     // Catch: Throwable -> L6
        L9:
            if (r1.hasNext() == false) goto L13;
            AudioPlaybackConfiguration apc = r1.next();     // Catch: Throwable -> L6
            da.addDuck(apc, false);     // Catch: Throwable -> L6
            goto L9
        L13:
            monitor-exit(this);
        }

        synchronized void unduckUid(int uid, HashMap<Integer, AudioPlaybackConfiguration> players) {
            monitor-enter(this);
            DuckedApp da = this.mDuckers.remove(Integer.valueOf(uid));     // Catch: Throwable -> L10
            if (da != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            da.removeUnduckAll(players);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        synchronized void checkDuck(AudioPlaybackConfiguration apc) {
            monitor-enter(this);
            DuckedApp da = this.mDuckers.get(Integer.valueOf(apc.getClientUid()));     // Catch: Throwable -> L11
            if (da != null) goto L8;
            monitor-exit(this);
            return;
        L8:
            da.addDuck(apc, true);     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        synchronized void dump(PrintWriter pw) {
            monitor-enter(this);
            Iterator<DuckedApp> r0 = this.mDuckers.values().iterator();     // Catch: Throwable -> L8
        L5:
            if (r0.hasNext() == false) goto L10;
            DuckedApp da = r0.next();     // Catch: Throwable -> L8
            da.dump(pw);     // Catch: Throwable -> L8
            goto L5
        L10:
            monitor-exit(this);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        synchronized void removeReleased(AudioPlaybackConfiguration apc) {
            monitor-enter(this);
            int uid = apc.getClientUid();     // Catch: Throwable -> L10
            DuckedApp da = this.mDuckers.get(Integer.valueOf(uid));     // Catch: Throwable -> L10
            if (da != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            da.removeReleased(apc);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    static final class FadeInEvent extends VolumeShaperEvent {
        @Override // com.android.server.audio.PlaybackActivityMonitor.VolumeShaperEvent
        String getVSAction() {
            return PlaybackActivityMonitor.EVENT_TYPE_FADE_IN;
        }

        FadeInEvent(AudioPlaybackConfiguration apc, boolean skipRamp, VolumeShaper.Configuration config, VolumeShaper.Operation operation) {
            super(apc, skipRamp, config, operation);
        }
    }

    static final class FadeOutEvent extends VolumeShaperEvent {
        @Override // com.android.server.audio.PlaybackActivityMonitor.VolumeShaperEvent
        String getVSAction() {
            return PlaybackActivityMonitor.EVENT_TYPE_FADE_OUT;
        }

        FadeOutEvent(AudioPlaybackConfiguration apc, boolean skipRamp, VolumeShaper.Configuration config, VolumeShaper.Operation operation) {
            super(apc, skipRamp, config, operation);
        }
    }

    private static final class MuteAwaitConnectionEvent extends EventLogger.Event {
        private final int[] mUsagesToMute;

        MuteAwaitConnectionEvent(int[] usagesToMute) {
            this.mUsagesToMute = usagesToMute;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "muteAwaitConnection muting usages " + Arrays.toString(this.mUsagesToMute);
        }
    }

    private static final class NewPlayerEvent extends EventLogger.Event {
        private final String mClientPackageName;
        private final int mClientPid;
        private final int mClientUid;
        private final AudioAttributes mPlayerAttr;
        private final int mPlayerIId;
        private final int mPlayerType;
        private final int mSessionId;

        NewPlayerEvent(AudioPlaybackConfiguration apc, String packageName) {
            this.mPlayerIId = apc.getPlayerInterfaceId();
            this.mPlayerType = apc.getPlayerType();
            this.mClientUid = apc.getClientUid();
            this.mClientPackageName = packageName;
            this.mClientPid = apc.getClientPid();
            this.mPlayerAttr = apc.getAudioAttributes();
            this.mSessionId = apc.getSessionId();
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return new String("new player piid:" + this.mPlayerIId + " uid/pid:" + this.mClientUid + SliceClientPermissions.SliceAuthority.DELIMITER + this.mClientPid + " package:" + this.mClientPackageName + " type:" + AudioPlaybackConfiguration.toLogFriendlyPlayerType(this.mPlayerType) + " attr:" + this.mPlayerAttr + " session:" + this.mSessionId);
        }
    }

    private static final class PlayMonitorClient implements IBinder.DeathRecipient {
        private static final int MAX_ERRORS = 5;
        static PlaybackActivityMonitor sListenerDeathMonitor;
        private final IPlaybackConfigDispatcher mDispatcherCb;
        private int mErrorCount;
        private final boolean mIsPrivileged;
        private boolean mIsReleased;
        private final int mPid;
        private final int mUid;

        PlayMonitorClient(IPlaybackConfigDispatcher pcdb, boolean isPrivileged, int uid, int pid) {
            this.mIsReleased = false;
            this.mErrorCount = 0;
            this.mDispatcherCb = pcdb;
            this.mIsPrivileged = isPrivileged;
            this.mUid = uid;
            this.mPid = pid;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("PlayMonitorClient:");
            if (isPrivileged() == false) goto L5;
            String r1 = "S";
        L6:
            r0.append(r1);
            r0.append(" uid:");
            r0.append(this.mUid);
            r0.append(" pid:");
            r0.append(this.mPid);
            return r0.toString();
        L5:
            r1 = "P";
            goto L6
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.w(PlaybackActivityMonitor.TAG, "client died");
            sListenerDeathMonitor.unregisterPlaybackCallback(this.mDispatcherCb);
        }

        synchronized boolean init() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (this.mIsReleased == false) goto L21;
            monitor-exit(this);
            return false;
        L21:
            this.mDispatcherCb.asBinder().linkToDeath(this, 0);     // Catch: Throwable -> L12 RemoteException -> L14
            monitor-exit(this);
            return true;
        L14:
            e = move-exception;
            Log.w(PlaybackActivityMonitor.TAG, "Could not link to client death", e);     // Catch: Throwable -> L12
            return false;
        }

        synchronized void release() {
            monitor-enter(this);
            this.mDispatcherCb.asBinder().unlinkToDeath(this, 0);     // Catch: Throwable -> L6
            this.mIsReleased = true;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        void dispatchPlaybackConfigChange(List<AudioPlaybackConfiguration> configs, boolean flush) {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mIsReleased == false) goto L9;
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L9:
            monitor-exit(this);     // Catch: Throwable -> L7
            this.mDispatcherCb.dispatchPlaybackConfigChange(configs, flush);     // Catch: RemoteException -> L12
            return;
        L12:
            e = move-exception;
            monitor-enter(this);
            this.mErrorCount++;     // Catch: Throwable -> L17
            Log.e(PlaybackActivityMonitor.TAG, "Error (" + this.mErrorCount + ") trying to dispatch playback config change to " + this, e);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        synchronized boolean isPrivileged() {
            monitor-enter(this);
            boolean r0 = this.mIsPrivileged;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean reachedMaxErrorCount() {
            monitor-enter(this);
            if (this.mErrorCount < 5) goto L7;
            boolean r0 = true;
        L8:
            monitor-exit(this);
            return r0;
        L7:
            r0 = false;
        L10:
            th = move-exception;
            throw th;
        }

        synchronized boolean equalsDispatcher(IPlaybackConfigDispatcher pcdb) {
            monitor-enter(this);
            if (pcdb != null) goto L13;
            monitor-exit(this);
            return false;
        L13:
            boolean r0 = pcdb.asBinder().equals(this.mDispatcherCb.asBinder());     // Catch: Throwable -> L10
            monitor-exit(this);
            return r0;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private static final class PlayerEvent extends EventLogger.Event {
        final int mEvent;
        final int[] mEventValues;
        final int mPlayerIId;

        PlayerEvent(int piid, int event, int[] eventValues) {
            this.mPlayerIId = piid;
            this.mEvent = event;
            this.mEventValues = eventValues;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            StringBuilder r0 = new StringBuilder("player piid:");
            r0.append(this.mPlayerIId);
            r0.append(" event:");
            StringBuilder builder = r0.append(AudioPlaybackConfiguration.toLogFriendlyPlayerState(this.mEvent));
            switch(this.mEvent) {
                case 5: goto L38;
                case 6: goto L36;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            builder.append(" source:");
            int eventValue = this.mEventValues[0];
            if (eventValue > 0) goto L10;
            builder.append("none ");
        L34:
            return builder.toString();
        L10:
            if ((eventValue & 1) == 0) goto L13;
            builder.append("masterMute ");
        L13:
            if ((eventValue & 2) == 0) goto L16;
            builder.append("streamVolume ");
        L16:
            if ((eventValue & 4) == 0) goto L19;
            builder.append("streamMute ");
        L19:
            if ((eventValue & 8) == 0) goto L22;
            builder.append("opPlayAudio ");
        L22:
            if ((eventValue & 16) == 0) goto L25;
            builder.append("clientVolume ");
        L25:
            if ((eventValue & 32) == 0) goto L28;
            builder.append("volumeShaper ");
        L28:
            if ((eventValue & 64) == 0) goto L31;
            builder.append("portVolume ");
        L31:
            if ((eventValue & 128) == 0) goto L34;
            builder.append("opControlAudio ");
            goto L34
        L5:
            return builder.toString();
        L36:
            return AudioPlaybackConfiguration.toLogFriendlyPlayerState(this.mEvent) + " portId:" + Arrays.toString(this.mEventValues) + " mapped to player piid:" + this.mPlayerIId;
        L38:
            if (this.mEventValues.length <= 0) goto L43;
            if (this.mEventValues[0] == 0) goto L43;
            builder.append(" deviceIds:");
            builder.append(Arrays.toString(this.mEventValues));
        L43:
            return builder.toString();
        }
    }

    private static final class PlayerFormatEvent extends EventLogger.Event {
        private final AudioPlaybackConfiguration.FormatInfo mFormat;
        private final int mPlayerIId;

        PlayerFormatEvent(int piid, AudioPlaybackConfiguration.FormatInfo format) {
            this.mPlayerIId = piid;
            this.mFormat = format;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return new String("player piid:" + this.mPlayerIId + " format update:" + this.mFormat);
        }
    }

    private static final class PlayerOpPlayAudioEvent extends EventLogger.Event {
        final boolean mHasOp;
        final int mPlayerIId;
        final int mUid;

        PlayerOpPlayAudioEvent(int piid, boolean hasOp, int uid) {
            this.mPlayerIId = piid;
            this.mHasOp = hasOp;
            this.mUid = uid;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return "player piid:" + this.mPlayerIId + " has OP_PLAY_AUDIO:" + this.mHasOp + " in uid:" + this.mUid;
        }
    }

    private static abstract class VolumeShaperEvent extends EventLogger.Event {
        private final int mClientPid;
        private final int mClientUid;
        private final VolumeShaper.Configuration mConfig;
        private final VolumeShaper.Operation mOperation;
        private final AudioAttributes mPlayerAttr;
        private final int mPlayerIId;
        private final int mPlayerType;
        private final boolean mSkipRamp;

        abstract String getVSAction();

        VolumeShaperEvent(AudioPlaybackConfiguration apc, boolean skipRamp, VolumeShaper.Configuration config, VolumeShaper.Operation operation) {
            this.mPlayerIId = apc.getPlayerInterfaceId();
            this.mSkipRamp = skipRamp;
            this.mClientUid = apc.getClientUid();
            this.mClientPid = apc.getClientPid();
            this.mPlayerAttr = apc.getAudioAttributes();
            this.mPlayerType = apc.getPlayerType();
            this.mConfig = config;
            this.mOperation = operation;
        }

        @Override // com.android.server.utils.EventLogger.Event
        public String eventToString() {
            return getVSAction() + " player piid:" + this.mPlayerIId + " uid/pid:" + this.mClientUid + SliceClientPermissions.SliceAuthority.DELIMITER + this.mClientPid + " skip ramp:" + this.mSkipRamp + " player type:" + AudioPlaybackConfiguration.toLogFriendlyPlayerType(this.mPlayerType) + " attr:" + this.mPlayerAttr + " config:" + this.mConfig + " operation:" + this.mOperation;
        }
    }

    public static /* synthetic */ AudioPlaybackConfiguration $r8$lambda$W9MinIk0Ruh6YztYb0dairozPFc(PlaybackActivityMonitor r0, int r1) {
        return r0.getPlaybackConfigByPiid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMuteAwaitConnectionTimeoutCb, reason: not valid java name */
    static /* bridge */ /* synthetic */ Consumer m2170$$Nest$fgetmMuteAwaitConnectionTimeoutCb(PlaybackActivityMonitor r0) {
        return r0.mMuteAwaitConnectionTimeoutCb;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlaybackActivityMonitorExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ PlaybackActivityMonitorExt m2171$$Nest$fgetmPlaybackActivityMonitorExt(PlaybackActivityMonitor r0) {
        return r0.mPlaybackActivityMonitorExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlayerLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2172$$Nest$fgetmPlayerLock(PlaybackActivityMonitor r0) {
        return r0.mPlayerLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPlayers, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m2173$$Nest$fgetmPlayers(PlaybackActivityMonitor r0) {
        return r0.mPlayers;
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchPlaybackChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2174$$Nest$mdispatchPlaybackChange(PlaybackActivityMonitor r0, boolean r1) {
        r0.dispatchPlaybackChange(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$munmutePlayersExpectingDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2175$$Nest$munmutePlayersExpectingDevice(PlaybackActivityMonitor r0) {
        r0.unmutePlayersExpectingDevice();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDUCK_ID, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeShaper.Configuration m2176$$Nest$sfgetDUCK_ID() {
        return DUCK_ID;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDUCK_VSHAPE, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeShaper.Configuration m2177$$Nest$sfgetDUCK_VSHAPE() {
        return DUCK_VSHAPE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPLAY_CREATE_IF_NEEDED, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeShaper.Operation m2178$$Nest$sfgetPLAY_CREATE_IF_NEEDED() {
        return PLAY_CREATE_IF_NEEDED;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPLAY_SKIP_RAMP, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeShaper.Operation m2179$$Nest$sfgetPLAY_SKIP_RAMP() {
        return PLAY_SKIP_RAMP;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSTRONG_DUCK_ID, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeShaper.Configuration m2180$$Nest$sfgetSTRONG_DUCK_ID() {
        return STRONG_DUCK_ID;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSTRONG_DUCK_VSHAPE, reason: not valid java name */
    static /* bridge */ /* synthetic */ VolumeShaper.Configuration m2181$$Nest$sfgetSTRONG_DUCK_VSHAPE() {
        return STRONG_DUCK_VSHAPE;
    }

    static {
        DUCK_VSHAPE = new VolumeShaper.Configuration.Builder().setId(1).setCurve(new float[]{0.0f, 1.0f}, new float[]{1.0f, 0.2f}).setOptionFlags(2).setDuration(MediaFocusControl.getFocusRampTimeMs(3, new AudioAttributes.Builder().setUsage(5).build())).build();
        DUCK_ID = new VolumeShaper.Configuration(1);
        STRONG_DUCK_VSHAPE = new VolumeShaper.Configuration.Builder().setId(4).setCurve(new float[]{0.0f, 1.0f}, new float[]{1.0f, 0.017783f}).setOptionFlags(2).setDuration(MediaFocusControl.getFocusRampTimeMs(3, new AudioAttributes.Builder().setUsage(5).build())).build();
        STRONG_DUCK_ID = new VolumeShaper.Configuration(4);
        PLAY_CREATE_IF_NEEDED = new VolumeShaper.Operation.Builder(VolumeShaper.Operation.PLAY).createIfNeeded().build();
        MUTE_AWAIT_CONNECTION_VSHAPE = new VolumeShaper.Configuration.Builder().setId(3).setCurve(new float[]{0.0f, 1.0f}, new float[]{1.0f, 0.0f}).setOptionFlags(2).setDuration(UNMUTE_DURATION_MS).build();
        UNDUCKABLE_PLAYER_TYPES = new int[]{13, 3};
        PLAY_SKIP_RAMP = new VolumeShaper.Operation.Builder(PLAY_CREATE_IF_NEEDED).setXOffset(1.0f).build();
        sEventLogger = new EventLogger(100, "playback activity as reported through PlayerBase");
    }

    PlaybackActivityMonitor(Context context, int maxAlarmVolume, Consumer<AudioDeviceAttributes> muteTimeoutCallback, Function<Integer, Boolean> isStreamMutedCb) {
        this.mClients = new ConcurrentLinkedQueue();
        this.mPlayerLock = new Object();
        this.mPlayers = new HashMap();
        this.mPiidToPortId = new SparseIntArray();
        this.mSavedAlarmVolume = -1;
        this.mSavedAlarmMuted = false;
        this.mPrivilegedAlarmActiveCount = 0;
        this.mFadeOutManager = new FadeOutManager();
        this.mBannedUids = new ArrayList();
        this.mDoNotLogPiidList = new ArrayList();
        this.mAllowedCapturePolicies = new HashMap();
        this.mMutedPlayers = new ArrayList();
        this.mDuckingManager = new DuckingManager(null);
        this.mMutedPlayersAwaitingConnection = new ArrayList();
        this.mMutedUsagesAwaitingConnection = null;
        this.mContext = context;
        this.mMaxAlarmVolume = maxAlarmVolume;
        PlayMonitorClient.sListenerDeathMonitor = this;
        AudioPlaybackConfiguration.sPlayerDeathMonitor = this;
        this.mMuteAwaitConnectionTimeoutCb = muteTimeoutCallback;
        this.mIsStreamMutedCb = isStreamMutedCb;
        this.mPlaybackActivityMonitorExt = PlaybackActivityMonitorExt.get(this);
        this.mPlaybackActivityMonitorExt.init_beforeInitEventHandler(context, new PlaybackActivityMonitor$$ExternalSyntheticLambda0(this));
        initEventHandler();
    }

    private AudioPlaybackConfiguration getPlaybackConfigByPiid(int piid) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        AudioPlaybackConfiguration r1 = this.mPlayers.get(new Integer(piid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void disableAudioForUid(boolean disable, int uid) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        int index = this.mBannedUids.indexOf(new Integer(uid));     // Catch: Throwable -> L8
        if (index < 0) goto L10;
        if (disable == true) goto L16;
        this.mBannedUids.remove(index);     // Catch: Throwable -> L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        if (disable == false) goto L16;
        Iterator<AudioPlaybackConfiguration> r2 = this.mPlayers.values().iterator();     // Catch: Throwable -> L8
    L13:
        if (r2.hasNext() == false) goto L15;
        AudioPlaybackConfiguration apc = r2.next();     // Catch: Throwable -> L8
        checkBanPlayer(apc, uid);     // Catch: Throwable -> L8
        goto L13
    L15:
        this.mBannedUids.add(new Integer(uid));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private boolean checkBanPlayer(AudioPlaybackConfiguration apc, int uid) {
        if (apc.getClientUid() != uid) goto L5;
        boolean toBan = true;
    L6:
        if (toBan == false) goto L12;
        int piid = apc.getPlayerInterfaceId();
        Log.v(TAG, "banning player " + piid + " uid:" + uid);     // Catch: Exception -> L10
        apc.getPlayerProxy().pause();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e(TAG, "error banning player " + piid + " uid:" + uid, e);
    L12:
        return toBan;
    L5:
        toBan = false;
        goto L6
    }

    void ignorePlayerIId(int doNotLogPiid) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        this.mDoNotLogPiidList.add(Integer.valueOf(doNotLogPiid));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public int trackPlayer(PlayerBase.PlayerIdCard pic) {
        int newPiid = AudioSystem.newAudioPlayerId();
        if (newPiid != (-1)) goto L6;
        Log.w(TAG, "invalid piid assigned from AudioSystem");
        return newPiid;
    L6:
        AudioPlaybackConfiguration apc = new AudioPlaybackConfiguration(pic, newPiid, Binder.getCallingUid(), Binder.getCallingPid());
        apc.init();
        HashMap<Integer, Integer> r2 = this.mAllowedCapturePolicies;
        monitor-enter(r2);
        int uid = apc.getClientUid();     // Catch: Throwable -> L11
        if (this.mAllowedCapturePolicies.containsKey(Integer.valueOf(uid)) == false) goto L13;
        updateAllowedCapturePolicy(apc, this.mAllowedCapturePolicies.get(Integer.valueOf(uid)).intValue());     // Catch: Throwable -> L11
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(apc.getClientUid());
        EventLogger r3 = sEventLogger;
        if (packages != null) goto L17;
    L19:
        String r5 = null;
    L20:
        r3.enqueue(new NewPlayerEvent(apc, r5));
        Object r4 = this.mPlayerLock;
        monitor-enter(r4);
        this.mPlayers.put(Integer.valueOf(newPiid), apc);     // Catch: Throwable -> L26
        maybeMutePlayerAwaitingConnection(apc);     // Catch: Throwable -> L26
        monitor-exit(r4);     // Catch: Throwable -> L26
        this.mPlaybackActivityMonitorExt.trackPlayer_onEnd(newPiid);
        return newPiid;
    L26:
        th = move-exception;
        throw th;
    L17:
        if (packages.length <= 0) goto L19;
        r5 = packages[0];
    L11:
        th = move-exception;
        throw th;
    }

    public void playerAttributes(int piid, AudioAttributes attr, int binderUid) {
        HashMap<Integer, Integer> r0 = this.mAllowedCapturePolicies;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mAllowedCapturePolicies.containsKey(Integer.valueOf(binderUid)) == true) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        Object r1 = this.mPlayerLock;
        monitor-enter(r1);
        AudioPlaybackConfiguration apc = this.mPlayers.get(new Integer(piid));     // Catch: Throwable -> L17
        if (checkConfigurationCaller(piid, apc, binderUid) == false) goto L19;
        sEventLogger.enqueue(new AudioAttrEvent(piid, attr));     // Catch: Throwable -> L17
        boolean change = apc.handleAudioAttributesEvent(attr);     // Catch: Throwable -> L17
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L17
        if (change == false) goto L32;
        this.mPlaybackActivityMonitorExt.playerAttributes_beforeDispatchPlaybackChange(piid);
        dispatchPlaybackChange(false);
        return;
    L32:
        return;
    L19:
        Log.e(TAG, "Error updating audio attributes");     // Catch: Throwable -> L17
        change = false;
    L17:
        th = move-exception;
        throw th;
    L7:
        if (attr.getAllowedCapturePolicy() >= this.mAllowedCapturePolicies.get(Integer.valueOf(binderUid)).intValue()) goto L11;
        attr = new AudioAttributes.Builder(attr).setAllowedCapturePolicy(this.mAllowedCapturePolicies.get(Integer.valueOf(binderUid)).intValue()).build();     // Catch: Throwable -> L9
        goto L11
    }

    public void playerSessionId(int piid, int sessionId, int binderUid) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        AudioPlaybackConfiguration apc = this.mPlayers.get(new Integer(piid));     // Catch: Throwable -> L7
        if (checkConfigurationCaller(piid, apc, binderUid) == false) goto L9;
        boolean change = apc.handleSessionIdEvent(sessionId);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (change == false) goto L18;
        this.mPlaybackActivityMonitorExt.playerSessionId_beforeDispatchPlaybackChange(piid);
        dispatchPlaybackChange(false);
        return;
    L18:
        return;
    L9:
        Log.e(TAG, "Error updating audio session");     // Catch: Throwable -> L7
        change = false;
    L7:
        th = move-exception;
        throw th;
    }

    private void checkVolumeForPrivilegedAlarm(AudioPlaybackConfiguration apc, int event) {
        if (event != 5) goto L6;
        return;
    L6:
        if (event == 2) goto L10;
        if (apc.getPlayerState() == 2) goto L10;
        return;
    L10:
        if ((apc.getAudioAttributes().getAllFlags() & 192) == 192) goto L12;
        return;
    L12:
        if (apc.getAudioAttributes().getUsage() == 4) goto L14;
        return;
    L14:
        if (this.mContext.checkPermission("android.permission.MODIFY_PHONE_STATE", apc.getClientPid(), apc.getClientUid()) != 0) goto L33;
        if (event == 2) goto L17;
    L21:
        if (event != 2) goto L23;
        return;
    L23:
        if (apc.getPlayerState() != 2) goto L37;
        int r1 = this.mPrivilegedAlarmActiveCount - 1;
        this.mPrivilegedAlarmActiveCount = r1;
        if (r1 == 0) goto L27;
        return;
    L27:
        if (AudioSystem.getStreamVolumeIndex(4, 2) != this.mMaxAlarmVolume) goto L39;
        AudioSystem.setStreamVolumeIndexAS(4, this.mSavedAlarmVolume, this.mSavedAlarmMuted, 2);
        return;
    L39:
        return;
    L37:
        return;
    L17:
        if (apc.getPlayerState() == 2) goto L21;
        int r2 = this.mPrivilegedAlarmActiveCount;
        this.mPrivilegedAlarmActiveCount = r2 + 1;
        if (r2 != 0) goto L34;
        this.mSavedAlarmVolume = AudioSystem.getStreamVolumeIndex(4, 2);
        this.mSavedAlarmMuted = this.mIsStreamMutedCb.apply(4).booleanValue();
        AudioSystem.setStreamVolumeIndexAS(4, this.mMaxAlarmVolume, false, 2);
        return;
    L34:
        return;
    }

    public void playerEvent(int piid, int event, int[] eventValues, int binderUid) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        AudioPlaybackConfiguration apc = this.mPlayers.get(new Integer(piid));     // Catch: Throwable -> L8
        if (apc != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        boolean doNotLog = this.mDoNotLogPiidList.contains(Integer.valueOf(piid));     // Catch: Throwable -> L8
        if (doNotLog == false) goto L15;
        if (event == 0) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L15:
        sEventLogger.enqueue(new PlayerEvent(piid, event, eventValues));     // Catch: Throwable -> L8
        boolean r4 = false;
        if (event != 6) goto L21;
        this.mPiidToPortId.put(piid, eventValues[0]);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L21:
        if (event != 2) goto L32;
        Iterator<Integer> r5 = this.mBannedUids.iterator();     // Catch: Throwable -> L8
    L24:
        if (r5.hasNext() == false) goto L32;
        Integer uidInteger = r5.next();     // Catch: Throwable -> L8
        if (checkBanPlayer(apc, uidInteger.intValue()) == false) goto L24;
        sEventLogger.enqueue(new EventLogger.StringEvent("not starting piid:" + piid + ", is banned"));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L32:
        if (apc.getPlayerType() != 3) goto L37;
        if (event == 0) goto L37;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L37:
        if (checkConfigurationCaller(piid, apc, binderUid) == false) goto L39;
        checkVolumeForPrivilegedAlarm(apc, event);     // Catch: Throwable -> L8
        boolean change = apc.handleStateEvent(event, eventValues);     // Catch: Throwable -> L8
    L40:
        if (change == false) goto L46;
        if (event != 2) goto L43;
        this.mDuckingManager.checkDuck(apc);     // Catch: Throwable -> L8
        this.mFadeOutManager.checkFade(apc);     // Catch: Throwable -> L8
    L43:
        if (doNotLog == false) goto L45;
        change = false;
        goto L46
    L45:
        this.mPlaybackActivityMonitorExt.playerEvent_beforeDispatchPlaybackChange(event, piid);     // Catch: Throwable -> L8
    L46:
        monitor-exit(r0);     // Catch: Throwable -> L8
        if (change == false) goto L57;
        if (event != 0) goto L50;
        r4 = true;
    L50:
        dispatchPlaybackChange(r4);
        return;
    L57:
        return;
    L39:
        Log.e(TAG, "Error handling event " + event);     // Catch: Throwable -> L8
        change = false;
    L8:
        th = move-exception;
        throw th;
    }

    public void portMuteEvent(int portId, int event, int binderUid) {
        if (UserHandle.isCore(binderUid) == true) goto L6;
        Log.e(TAG, "Forbidden operation from uid " + binderUid);
        return;
    L6:
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        int idxOfPiid = this.mPiidToPortId.indexOfValue(portId);     // Catch: Throwable -> L13
        if (idxOfPiid >= 0) goto L15;
        Log.w(TAG, "No piid assigned for invalid/internal port id " + portId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        int piid = this.mPiidToPortId.keyAt(idxOfPiid);     // Catch: Throwable -> L13
        AudioPlaybackConfiguration apc = this.mPlayers.get(Integer.valueOf(piid));     // Catch: Throwable -> L13
        if (apc != null) goto L21;
        Log.w(TAG, "No AudioPlaybackConfiguration assigned for piid " + piid);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L21:
        if (apc.getPlayerType() != 3) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L24:
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(2, piid, event, null));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void portEvent(int portId, int event, PersistableBundle extras, int binderUid) {
        if (UserHandle.isCore(binderUid) == true) goto L6;
        Log.e(TAG, "Forbidden operation from uid " + binderUid);
        return;
    L6:
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        int idxOfPiid = this.mPiidToPortId.indexOfValue(portId);     // Catch: Throwable -> L13
        if (idxOfPiid >= 0) goto L15;
        Log.w(TAG, "No piid assigned for invalid/internal port id " + portId);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        int piid = this.mPiidToPortId.keyAt(idxOfPiid);     // Catch: Throwable -> L13
        AudioPlaybackConfiguration apc = this.mPlayers.get(Integer.valueOf(piid));     // Catch: Throwable -> L13
        if (apc != null) goto L21;
        Log.w(TAG, "No AudioPlaybackConfiguration assigned for piid " + piid);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L21:
        if (apc.getPlayerType() != 3) goto L25;
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L25:
        if (event != 8) goto L27;
        this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(3, piid, -1, extras));     // Catch: Throwable -> L13
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void playerHasOpPlayAudio(int piid, boolean hasOpPlayAudio, int binderUid) {
        sEventLogger.enqueue(new PlayerOpPlayAudioEvent(piid, hasOpPlayAudio, binderUid));
    }

    public void releasePlayer(int piid, int binderUid) {
        boolean change = false;
        if (piid != (-1)) goto L6;
        Log.w(TAG, "Received releasePlayer with invalid piid: " + piid);
        sEventLogger.enqueue(new EventLogger.StringEvent("releasePlayer with invalid piid:" + piid + ", uid:" + binderUid));
        return;
    L6:
        Object r1 = this.mPlayerLock;
        monitor-enter(r1);
        AudioPlaybackConfiguration apc = this.mPlayers.get(new Integer(piid));     // Catch: Throwable -> L15
        if (checkConfigurationCaller(piid, apc, binderUid) == false) goto L17;
        sEventLogger.enqueue(new EventLogger.StringEvent("releasing player piid:" + piid + ", uid:" + binderUid));     // Catch: Throwable -> L15
        this.mPlayers.remove(new Integer(piid));     // Catch: Throwable -> L15
        this.mDuckingManager.removeReleased(apc);     // Catch: Throwable -> L15
        this.mFadeOutManager.removeReleased(apc);     // Catch: Throwable -> L15
        this.mMutedPlayersAwaitingConnection.remove(Integer.valueOf(piid));     // Catch: Throwable -> L15
        checkVolumeForPrivilegedAlarm(apc, 0);     // Catch: Throwable -> L15
        change = apc.handleStateEvent(0, AudioPlaybackConfiguration.PLAYER_DEVICEIDS_INVALID);     // Catch: Throwable -> L15
        this.mPiidToPortId.delete(piid);     // Catch: Throwable -> L15
        if (change == false) goto L17;
        if (this.mDoNotLogPiidList.contains(Integer.valueOf(piid)) == false) goto L17;
        change = false;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (change == false) goto L25;
        this.mPlaybackActivityMonitorExt.releasePlayer_beforeDispatchPlaybackChange(piid);
        dispatchPlaybackChange(true);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    void onAudioServerDied() {
        sEventLogger.enqueue(new EventLogger.StringEvent("clear port id to piid map"));
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        this.mPiidToPortId.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAllowedCapturePolicy(int uid, int capturePolicy) {
        HashMap<Integer, Integer> r0 = this.mAllowedCapturePolicies;
        monitor-enter(r0);
        if (capturePolicy != 1) goto L11;
        this.mAllowedCapturePolicies.remove(Integer.valueOf(uid));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mAllowedCapturePolicies.put(Integer.valueOf(uid), Integer.valueOf(capturePolicy));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        Object r1 = this.mPlayerLock;
        monitor-enter(r1);
        Iterator<AudioPlaybackConfiguration> r2 = this.mPlayers.values().iterator();     // Catch: Throwable -> L21
    L17:
        if (r2.hasNext() == false) goto L24;
        AudioPlaybackConfiguration apc = r2.next();     // Catch: Throwable -> L21
        if (apc.getClientUid() != uid) goto L17;
        updateAllowedCapturePolicy(apc, capturePolicy);     // Catch: Throwable -> L21
        goto L17
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }

    public int getAllowedCapturePolicy(int uid) {
        return this.mAllowedCapturePolicies.getOrDefault(Integer.valueOf(uid), 1).intValue();
    }

    public HashMap<Integer, Integer> getAllAllowedCapturePolicies() {
        HashMap<Integer, Integer> r0 = this.mAllowedCapturePolicies;
        monitor-enter(r0);
        HashMap<Integer, Integer> r1 = (HashMap) this.mAllowedCapturePolicies.clone();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateAllowedCapturePolicy(AudioPlaybackConfiguration apc, int capturePolicy) {
        AudioAttributes attr = apc.getAudioAttributes();
        if (attr.getAllowedCapturePolicy() < capturePolicy) goto L5;
        return;
    L5:
        apc.handleAudioAttributesEvent(new AudioAttributes.Builder(apc.getAudioAttributes()).setAllowedCapturePolicy(capturePolicy).build());
    }

    public void playerDeath(int piid) {
        releasePlayer(piid, 0);
    }

    public boolean isPlaybackActiveForUid(int uid) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        Iterator<AudioPlaybackConfiguration> r1 = this.mPlayers.values().iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L17;
        AudioPlaybackConfiguration apc = r1.next();     // Catch: Throwable -> L14
        if (apc.isActive() == false) goto L6;
        if (apc.getClientUid() != uid) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean hasActiveMediaPlaybackOnSubmixWithAddress(String address) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        Iterator<AudioPlaybackConfiguration> r1 = this.mPlayers.values().iterator();     // Catch: Throwable -> L18
    L6:
        if (r1.hasNext() == false) goto L21;
        AudioPlaybackConfiguration apc = r1.next();     // Catch: Throwable -> L18
        AudioDeviceInfo device = apc.getAudioDeviceInfo();     // Catch: Throwable -> L18
        if (apc.getAudioAttributes().getUsage() != 1) goto L6;
        if (apc.isActive() == false) goto L6;
        if (device == null) goto L6;
        if (device.getInternalType() != 32768) goto L6;
        if (address.equals(device.getAddress()) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return true;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    protected void dump(PrintWriter pw) {
        pw.println("\nPlaybackActivityMonitor dump time: " + DateFormat.getTimeInstance().format(new Date()));
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        pw.println("\n  playback listeners:");     // Catch: Throwable -> L8
        Iterator<PlayMonitorClient> r1 = this.mClients.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        PlayMonitorClient pmc = r1.next();     // Catch: Throwable -> L8
        pw.println(" " + pmc);     // Catch: Throwable -> L8
        goto L6
    L10:
        pw.println("\n");     // Catch: Throwable -> L8
        pw.println("\n  players:");     // Catch: Throwable -> L8
        List<Integer> piidIntList = new ArrayList(this.mPlayers.keySet());     // Catch: Throwable -> L8
        Collections.sort(piidIntList);     // Catch: Throwable -> L8
        Iterator<Integer> r2 = piidIntList.iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L20;
        Integer piidInt = r2.next();     // Catch: Throwable -> L8
        AudioPlaybackConfiguration apc = this.mPlayers.get(piidInt);     // Catch: Throwable -> L8
        if (apc == null) goto L12;
        if (this.mDoNotLogPiidList.contains(Integer.valueOf(apc.getPlayerInterfaceId())) == false) goto L18;
        pw.print("(not logged)");     // Catch: Throwable -> L8
    L18:
        apc.dump(pw);     // Catch: Throwable -> L8
        goto L12
    L20:
        pw.println("\n  ducked players piids:");     // Catch: Throwable -> L8
        this.mDuckingManager.dump(pw);     // Catch: Throwable -> L8
        pw.println("\n  faded out players piids:");     // Catch: Throwable -> L8
        this.mFadeOutManager.dump(pw);     // Catch: Throwable -> L8
        pw.print("\n  muted player piids due to call/ring:");     // Catch: Throwable -> L8
        Iterator<Integer> r3 = this.mMutedPlayers.iterator();     // Catch: Throwable -> L8
    L22:
        if (r3.hasNext() == false) goto L24;
        int piid = r3.next().intValue();     // Catch: Throwable -> L8
        pw.print(" " + piid);     // Catch: Throwable -> L8
        goto L22
    L24:
        pw.println();     // Catch: Throwable -> L8
        pw.print("\n  banned uids:");     // Catch: Throwable -> L8
        Iterator<Integer> r4 = this.mBannedUids.iterator();     // Catch: Throwable -> L8
    L26:
        if (r4.hasNext() == false) goto L28;
        int uid = r4.next().intValue();     // Catch: Throwable -> L8
        pw.print(" " + uid);     // Catch: Throwable -> L8
        goto L26
    L28:
        pw.println("\n");     // Catch: Throwable -> L8
        pw.print("\n  muted players (piids) awaiting device connection:");     // Catch: Throwable -> L8
        Iterator<Integer> r5 = this.mMutedPlayersAwaitingConnection.iterator();     // Catch: Throwable -> L8
    L30:
        if (r5.hasNext() == false) goto L32;
        int piid2 = r5.next().intValue();     // Catch: Throwable -> L8
        pw.print(" " + piid2);     // Catch: Throwable -> L8
        goto L30
    L32:
        pw.println("\n");     // Catch: Throwable -> L8
        pw.println("\n  current piid to portId map:");     // Catch: Throwable -> L8
        int i = 0;
    L34:
        if (i >= this.mPiidToPortId.size()) goto L36;
        pw.println("  piid: " + this.mPiidToPortId.keyAt(i) + " portId: " + this.mPiidToPortId.valueAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L34
    L36:
        pw.println("\n");     // Catch: Throwable -> L8
        sEventLogger.dump(pw);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        HashMap<Integer, Integer> r6 = this.mAllowedCapturePolicies;
        monitor-enter(r6);
        pw.println("\n  allowed capture policies:");     // Catch: Throwable -> L44
        Iterator<Map.Entry<Integer, Integer>> r7 = this.mAllowedCapturePolicies.entrySet().iterator();     // Catch: Throwable -> L44
    L42:
        if (r7.hasNext() == false) goto L46;
        Map.Entry<Integer, Integer> entry = r7.next();     // Catch: Throwable -> L44
        pw.println("  uid: " + entry.getKey() + " policy: " + entry.getValue());     // Catch: Throwable -> L44
        goto L42
    L46:
        monitor-exit(r6);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        throw th;
    }

    private static boolean checkConfigurationCaller(int piid, AudioPlaybackConfiguration apc, int binderUid) {
        if (apc != null) goto L5;
        return false;
    L5:
        if (binderUid != 0) goto L7;
        return true;
    L7:
        if (binderUid != 1041) goto L9;
        return true;
    L9:
        if (apc.getClientUid() == binderUid) goto L15;
        Log.e(TAG, "Forbidden operation from uid " + binderUid + " for player " + piid);
        return false;
    L15:
        return true;
    }

    private void dispatchPlaybackChange(boolean iplayerReleased) {
        List<AudioPlaybackConfiguration> configsPublic = null;
        Object r1 = this.mPlayerLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPlayers.isEmpty() == false) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        List<AudioPlaybackConfiguration> configsSystem = new ArrayList(this.mPlayers.values());     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        Iterator<PlayMonitorClient> clientIterator = this.mClients.iterator();
    L14:
        if (clientIterator.hasNext() == false) goto L24;
        PlayMonitorClient pmc = clientIterator.next();
        if (pmc.reachedMaxErrorCount() == true) goto L14;
        if (pmc.isPrivileged() == true) goto L19;
        if (configsPublic != null) goto L22;
        configsPublic = anonymizeForPublicConsumption(configsSystem);
    L22:
        pmc.dispatchPlaybackConfigChange(configsPublic, false);
        goto L14
    L19:
        pmc.dispatchPlaybackConfigChange(configsSystem, iplayerReleased);
        goto L14
    }

    private ArrayList<AudioPlaybackConfiguration> anonymizeForPublicConsumption(List<AudioPlaybackConfiguration> sysConfigs) {
        ArrayList<AudioPlaybackConfiguration> publicConfigs = new ArrayList();
        Iterator<AudioPlaybackConfiguration> r1 = sysConfigs.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        AudioPlaybackConfiguration config = r1.next();
        if (config.isActive() == false) goto L4;
        publicConfigs.add(AudioPlaybackConfiguration.anonymizedCopy(config));
        goto L4
    L9:
        return publicConfigs;
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public boolean duckPlayers(FocusRequester winner, FocusRequester loser, boolean forceDuck) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPlayers.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L10:
        Iterator<AudioPlaybackConfiguration> apcIterator = this.mPlayers.values().iterator();     // Catch: Throwable -> L8
        ArrayList<AudioPlaybackConfiguration> apcsToDuck = new ArrayList();     // Catch: Throwable -> L8
    L12:
        if (apcIterator.hasNext() == false) goto L33;
        AudioPlaybackConfiguration apc = apcIterator.next();     // Catch: Throwable -> L8
        if (winner.hasSameUid(apc.getClientUid()) == true) goto L12;
        if (loser.hasSameUid(apc.getClientUid()) == false) goto L12;
        if (apc.getPlayerState() != 2) goto L12;
        if (forceDuck == true) goto L27;
        if (apc.getAudioAttributes().getContentType() != 1) goto L27;
        Log.v(TAG, "not ducking player " + apc.getPlayerInterfaceId() + " uid:" + apc.getClientUid() + " pid:" + apc.getClientPid() + " - SPEECH");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L27:
        if (ArrayUtils.contains(UNDUCKABLE_PLAYER_TYPES, apc.getPlayerType()) == true) goto L28;
        apcsToDuck.add(apc);     // Catch: Throwable -> L8
        goto L12
    L28:
        Log.v(TAG, "not ducking player " + apc.getPlayerInterfaceId() + " uid:" + apc.getClientUid() + " pid:" + apc.getClientPid() + " due to type:" + AudioPlaybackConfiguration.toLogFriendlyPlayerType(apc.getPlayerType()));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L33:
        this.mDuckingManager.duckUid(loser.getClientUid(), apcsToDuck, reqCausesStrongDuck(winner));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    }

    private boolean reqCausesStrongDuck(FocusRequester requester) {
        if (requester.getGainRequest() == 3) goto L5;
        return false;
    L5:
        int reqUsage = requester.getAudioAttributes().getUsage();
        if (reqUsage != 16) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void restoreVShapedPlayers(FocusRequester winner) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        this.mDuckingManager.unduckUid(winner.getClientUid(), this.mPlayers);     // Catch: Throwable -> L7
        this.mFadeOutManager.unfadeOutUid(winner.getClientUid(), this.mPlayers);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void mutePlayersForCall(int[] usagesToMute) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        Set<Integer> piidSet = this.mPlayers.keySet();     // Catch: Throwable -> L16
        Iterator<Integer> piidIterator = piidSet.iterator();     // Catch: Throwable -> L16
    L6:
        if (piidIterator.hasNext() == false) goto L25;
        Integer piid = piidIterator.next();     // Catch: Throwable -> L16
        AudioPlaybackConfiguration apc = this.mPlayers.get(piid);     // Catch: Throwable -> L16
        if (apc == null) goto L6;
        int playerUsage = apc.getAudioAttributes().getUsage();     // Catch: Throwable -> L16
        boolean mute = false;
        int r7 = usagesToMute.length;     // Catch: Throwable -> L16
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L18;
        int usageToMute = usagesToMute[r8];     // Catch: Throwable -> L16
        if (playerUsage == usageToMute) goto L14;
        r8 = r8 + 1;
        goto L11
    L14:
        mute = true;
    L18:
        if (mute == false) goto L6;
        sEventLogger.enqueue(new EventLogger.StringEvent("call: muting piid:" + piid + " uid:" + apc.getClientUid()).printLog(TAG));     // Catch: Throwable -> L16 Exception -> L21
        apc.getPlayerProxy().setVolume(0.0f);     // Catch: Throwable -> L16 Exception -> L21
        this.mMutedPlayers.add(new Integer(piid.intValue()));     // Catch: Throwable -> L16 Exception -> L21
    L21:
        e = move-exception;
        Log.e(TAG, "call: error muting player " + piid, e);     // Catch: Throwable -> L16
        goto L6
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void unmutePlayersForCall() {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mMutedPlayers.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        Iterator<Integer> r1 = this.mMutedPlayers.iterator();     // Catch: Throwable -> L8
    L12:
        if (r1.hasNext() == false) goto L20;
        int piid = r1.next().intValue();     // Catch: Throwable -> L8
        AudioPlaybackConfiguration apc = this.mPlayers.get(Integer.valueOf(piid));     // Catch: Throwable -> L8
        if (apc == null) goto L12;
        sEventLogger.enqueue(new EventLogger.StringEvent("call: unmuting piid:" + piid).printLog(TAG));     // Catch: Throwable -> L8 Exception -> L17
        apc.getPlayerProxy().setVolume(1.0f);     // Catch: Throwable -> L8 Exception -> L17
    L17:
        e = move-exception;
        Log.e(TAG, "call: error unmuting player " + piid + " uid:" + apc.getClientUid(), e);     // Catch: Throwable -> L8
        goto L12
    L20:
        this.mMutedPlayers.clear();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public boolean fadeOutPlayers(FocusRequester winner, FocusRequester loser) {
        boolean loserHasActivePlayers = false;
        Object r1 = this.mPlayerLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPlayers.isEmpty() == false) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return false;
    L11:
        if (this.mFadeOutManager.canCauseFadeOut(winner, loser) == true) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return false;
    L14:
        Iterator<AudioPlaybackConfiguration> apcIterator = this.mPlayers.values().iterator();     // Catch: Throwable -> L8
        ArrayList<AudioPlaybackConfiguration> apcsToFadeOut = new ArrayList();     // Catch: Throwable -> L8
    L16:
        if (apcIterator.hasNext() == false) goto L30;
        AudioPlaybackConfiguration apc = apcIterator.next();     // Catch: Throwable -> L8
        if (winner.hasSameUid(apc.getClientUid()) == true) goto L16;
        if (loser.hasSameUid(apc.getClientUid()) == false) goto L16;
        if (apc.getPlayerState() != 2) goto L16;
        if (this.mFadeOutManager.canBeFadedOut(apc) == false) goto L25;
        loserHasActivePlayers = true;
        apcsToFadeOut.add(apc);     // Catch: Throwable -> L8
        goto L16
    L25:
        Log.v(TAG, "not fading out player " + apc.getPlayerInterfaceId() + " uid:" + apc.getClientUid() + " pid:" + apc.getClientPid() + " type:" + AudioPlaybackConfiguration.toLogFriendlyPlayerType(apc.getPlayerType()) + " attr:" + apc.getAudioAttributes());     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return false;
    L30:
        if (loserHasActivePlayers == false) goto L32;
        this.mFadeOutManager.fadeOutUid(loser.getClientUid(), apcsToFadeOut);     // Catch: Throwable -> L8
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return loserHasActivePlayers;
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public void forgetUid(int uid) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        HashMap<Integer, AudioPlaybackConfiguration> players = (HashMap) this.mPlayers.clone();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mFadeOutManager.unfadeOutUid(uid, players);
        this.mDuckingManager.unduckUid(uid, players);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public long getFadeOutDurationMillis(AudioAttributes aa) {
        return this.mFadeOutManager.getFadeOutDurationOnFocusLossMillis(aa);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public long getFadeInDelayForOffendersMillis(AudioAttributes aa) {
        return this.mFadeOutManager.getFadeInDelayForOffendersMillis(aa);
    }

    @Override // com.android.server.audio.PlayerFocusEnforcer
    public boolean shouldEnforceFade() {
        return this.mFadeOutManager.isFadeEnabled();
    }

    void registerPlaybackCallback(IPlaybackConfigDispatcher pcdb, boolean isPrivileged) {
        if (pcdb != null) goto L4;
        return;
    L4:
        PlayMonitorClient pmc = new PlayMonitorClient(pcdb, isPrivileged, Binder.getCallingUid(), Binder.getCallingPid());
        if (pmc.init() == false) goto L8;
        this.mClients.add(pmc);
        return;
    }

    void unregisterPlaybackCallback(IPlaybackConfigDispatcher pcdb) {
        if (pcdb != null) goto L4;
        return;
    L4:
        Iterator<PlayMonitorClient> clientIterator = this.mClients.iterator();
    L6:
        if (clientIterator.hasNext() == false) goto L11;
        PlayMonitorClient pmc = clientIterator.next();
        if (pmc.equalsDispatcher(pcdb) == false) goto L6;
        pmc.release();
        clientIterator.remove();
        goto L6
    }

    List<AudioPlaybackConfiguration> getActivePlaybackConfigurations(boolean isPrivileged) {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        if (isPrivileged == false) goto L10;
        ArrayList r1 = new ArrayList(this.mPlayers.values());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L10:
        ArrayList<AudioPlaybackConfiguration> r2 = anonymizeForPublicConsumption(new ArrayList(this.mPlayers.values()));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    int setFadeManagerConfiguration(int focusType, FadeManagerConfiguration fadeMgrConfig) {
        return this.mFadeOutManager.setFadeManagerConfiguration(fadeMgrConfig);
    }

    int clearFadeManagerConfiguration(int focusType) {
        return this.mFadeOutManager.clearFadeManagerConfiguration();
    }

    FadeManagerConfiguration getFadeManagerConfiguration(int focusType) {
        return this.mFadeOutManager.getFadeManagerConfiguration();
    }

    int setTransientFadeManagerConfiguration(int focusType, FadeManagerConfiguration fadeMgrConfig) {
        return this.mFadeOutManager.setTransientFadeManagerConfiguration(fadeMgrConfig);
    }

    int clearTransientFadeManagerConfiguration(int focusType) {
        return this.mFadeOutManager.clearTransientFadeManagerConfiguration();
    }

    protected List<Integer> getFocusDuckedUids() {
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        ArrayList<Integer> duckedUids = new ArrayList(DuckingManager.m2182$$Nest$fgetmDuckers(this.mDuckingManager).keySet());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return duckedUids;
    L7:
        th = move-exception;
        throw th;
    }

    void muteAwaitConnection(int[] usagesToMute, AudioDeviceAttributes dev, long timeOutMs) {
        sEventLogger.enqueueAndLog("muteAwaitConnection() dev:" + dev + " timeOutMs:" + timeOutMs, 0, TAG);
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        mutePlayersExpectingDevice(usagesToMute);     // Catch: Throwable -> L7
        this.mEventHandler.removeMessages(1);     // Catch: Throwable -> L7
        this.mEventHandler.sendMessageDelayed(this.mEventHandler.obtainMessage(1, dev), timeOutMs);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void cancelMuteAwaitConnection(String source) {
        sEventLogger.enqueueAndLog("cancelMuteAwaitConnection() from:" + source, 0, TAG);
        Object r0 = this.mPlayerLock;
        monitor-enter(r0);
        this.mEventHandler.removeMessages(1);     // Catch: Throwable -> L7
        unmutePlayersExpectingDevice();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void mutePlayersExpectingDevice(int[] usagesToMute) {
        sEventLogger.enqueue(new MuteAwaitConnectionEvent(usagesToMute));
        this.mMutedUsagesAwaitingConnection = usagesToMute;
        Set<Integer> piidSet = this.mPlayers.keySet();
        Iterator<Integer> piidIterator = piidSet.iterator();
    L4:
        if (piidIterator.hasNext() == false) goto L9;
        Integer piid = piidIterator.next();
        AudioPlaybackConfiguration apc = this.mPlayers.get(piid);
        if (apc == null) goto L4;
        maybeMutePlayerAwaitingConnection(apc);
        goto L4
    }

    private void maybeMutePlayerAwaitingConnection(AudioPlaybackConfiguration apc) {
        if (this.mMutedUsagesAwaitingConnection != null) goto L5;
        return;
    L5:
        int[] r1 = this.mMutedUsagesAwaitingConnection;
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L14;
        int usage = r1[r3];
        if (usage != apc.getAudioAttributes().getUsage()) goto L13;
        sEventLogger.enqueue(new EventLogger.StringEvent("awaiting connection: muting piid:" + apc.getPlayerInterfaceId() + " uid:" + apc.getClientUid()).printLog(TAG));     // Catch: Exception -> L11
        apc.getPlayerProxy().applyVolumeShaper(MUTE_AWAIT_CONNECTION_VSHAPE, PLAY_SKIP_RAMP);     // Catch: Exception -> L11
        this.mMutedPlayersAwaitingConnection.add(Integer.valueOf(apc.getPlayerInterfaceId()));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e(TAG, "awaiting connection: error muting player " + apc.getPlayerInterfaceId(), e);
    L13:
        r3 = r3 + 1;
        goto L6
    }

    private void unmutePlayersExpectingDevice() {
        this.mMutedUsagesAwaitingConnection = null;
        Iterator<Integer> r1 = this.mMutedPlayersAwaitingConnection.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        int piid = r1.next().intValue();
        AudioPlaybackConfiguration apc = this.mPlayers.get(Integer.valueOf(piid));
        if (apc == null) goto L4;
        sEventLogger.enqueue(new EventLogger.StringEvent("unmuting piid:" + piid).printLog(TAG));     // Catch: Exception -> L10
        apc.getPlayerProxy().applyVolumeShaper(MUTE_AWAIT_CONNECTION_VSHAPE, VolumeShaper.Operation.REVERSE);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e(TAG, "Error unmuting player " + piid + " uid:" + apc.getClientUid(), e);
        goto L4
    L13:
        this.mMutedPlayersAwaitingConnection.clear();
    }

    private void initEventHandler() {
        this.mEventThread = new HandlerThread(TAG);
        this.mEventThread.start();
        final Looper r1 = this.mEventThread.getLooper();
        this.mEventHandler = new AnonymousClass1(this, r1);
    }
}
