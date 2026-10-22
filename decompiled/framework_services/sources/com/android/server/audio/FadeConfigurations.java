package com.android.server.audio;

import android.media.AudioAttributes;
import android.media.FadeManagerConfiguration;
import android.media.VolumeShaper;
import com.android.server.ISmtResourceControl;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FadeConfigurations {
    private static final boolean DEBUG = false;
    private static final long DEFAULT_DELAY_FADE_IN_OFFENDERS_MS = 2000;
    private static final List<Integer> DEFAULT_FADEABLE_USAGES = null;
    private static final VolumeShaper.Configuration DEFAULT_FADEOUT_VSHAPE = null;
    private static final long DEFAULT_FADE_OUT_DURATION_MS = 2000;
    private static final List<Integer> DEFAULT_UNFADEABLE_CONTENT_TYPES = null;
    private static final List<Integer> DEFAULT_UNFADEABLE_PLAYER_TYPES = null;
    private static final int INVALID_UID = -1;
    public static final String TAG = "AS.FadeConfigurations";
    private FadeManagerConfiguration mActiveFadeManagerConfig;
    private FadeManagerConfiguration mDefaultFadeManagerConfig;
    private final Object mLock;
    private FadeManagerConfiguration mTransientFadeManagerConfig;
    private FadeManagerConfiguration mUpdatedFadeManagerConfig;

    public FadeConfigurations() {
        this.mLock = new Object();
    }

    static {
        DEFAULT_UNFADEABLE_PLAYER_TYPES = List.of(13, 3);
        DEFAULT_UNFADEABLE_CONTENT_TYPES = List.of(1);
        DEFAULT_FADEABLE_USAGES = List.of(14, 1);
        DEFAULT_FADEOUT_VSHAPE = new VolumeShaper.Configuration.Builder().setId(2).setCurve(new float[]{0.0f, 0.25f, 1.0f}, new float[]{1.0f, 0.65f, 0.0f}).setOptionFlags(2).setDuration(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME).build();
    }

    public int setFadeManagerConfiguration(FadeManagerConfiguration fadeManagerConfig) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        fadeManagerConfig.getClass();     // Catch: Throwable -> L8
        this.mUpdatedFadeManagerConfig = fadeManagerConfig;     // Catch: Throwable -> L8
        this.mActiveFadeManagerConfig = getActiveFadeMgrConfigLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L8:
        th = move-exception;
        throw th;
    }

    public int clearFadeManagerConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUpdatedFadeManagerConfig = null;     // Catch: Throwable -> L9
        this.mActiveFadeManagerConfig = getActiveFadeMgrConfigLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    public FadeManagerConfiguration getFadeManagerConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration r1 = this.mActiveFadeManagerConfig;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int setTransientFadeManagerConfiguration(FadeManagerConfiguration fadeManagerConfig) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        fadeManagerConfig.getClass();     // Catch: Throwable -> L8
        this.mTransientFadeManagerConfig = fadeManagerConfig;     // Catch: Throwable -> L8
        this.mActiveFadeManagerConfig = getActiveFadeMgrConfigLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L8:
        th = move-exception;
        throw th;
    }

    public int clearTransientFadeManagerConfiguration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTransientFadeManagerConfig = null;     // Catch: Throwable -> L9
        this.mActiveFadeManagerConfig = getActiveFadeMgrConfigLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean isFadeEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = getUpdatedFadeManagerConfigLocked().isFadeEnabled();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Integer> getFadeableUsages() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L7
        if (fadeManagerConfig.isFadeEnabled() == false) goto L9;
        List<Integer> r2 = fadeManagerConfig.getFadeableUsages();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = Collections.EMPTY_LIST;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public List<Integer> getUnfadeableContentTypes() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L7
        if (fadeManagerConfig.isFadeEnabled() == false) goto L9;
        List<Integer> r2 = fadeManagerConfig.getUnfadeableContentTypes();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = Collections.EMPTY_LIST;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public List<Integer> getUnfadeablePlayerTypes() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L7
        if (fadeManagerConfig.isFadeEnabled() == false) goto L9;
        List<Integer> r2 = fadeManagerConfig.getUnfadeablePlayerTypes();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = Collections.EMPTY_LIST;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public VolumeShaper.Configuration getFadeOutVolumeShaperConfig(AudioAttributes aa) {
        return getOptimalFadeOutVolShaperConfig(aa);
    }

    public VolumeShaper.Configuration getFadeInVolumeShaperConfig(AudioAttributes aa) {
        return getOptimalFadeInVolShaperConfig(aa);
    }

    public long getFadeOutDuration(AudioAttributes aa) {
        if (isFadeable(aa, -1, -1) == true) goto L7;
        return 0;
    L7:
        return getOptimalFadeOutDuration(aa);
    }

    public long getDelayFadeInOffenders(AudioAttributes aa) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r1 = getUpdatedFadeManagerConfigLocked().getFadeInDelayForOffenders();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<AudioAttributes> getUnfadeableAudioAttributes() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L7
        if (fadeManagerConfig.isFadeEnabled() == false) goto L9;
        List<AudioAttributes> r2 = fadeManagerConfig.getUnfadeableAudioAttributes();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = Collections.EMPTY_LIST;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public List<Integer> getUnfadeableUids() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L7
        if (fadeManagerConfig.isFadeEnabled() == false) goto L9;
        List<Integer> r2 = fadeManagerConfig.getUnfadeableUids();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = Collections.EMPTY_LIST;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isFadeable(AudioAttributes aa, int uid, int playerType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (isPlayerTypeUnfadeableLocked(playerType) == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L11:
        if (isContentTypeUnfadeableLocked(aa.getContentType()) == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L15:
        if (isUsageFadeableLocked(aa.getSystemUsage()) == true) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L19:
        if (isUnfadeableForFadeMgrConfigLocked(aa, uid) == false) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    }

    private VolumeShaper.Configuration getOptimalFadeOutVolShaperConfig(AudioAttributes aa) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L8
        VolumeShaper.Configuration volShaperConfig = fadeManagerConfig.getFadeOutVolumeShaperConfigForAudioAttributes(aa);     // Catch: Throwable -> L8
        if (volShaperConfig == null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return volShaperConfig;
    L10:
        VolumeShaper.Configuration r3 = fadeManagerConfig.getFadeOutVolumeShaperConfigForUsage(aa.getSystemUsage());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    private VolumeShaper.Configuration getOptimalFadeInVolShaperConfig(AudioAttributes aa) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L8
        VolumeShaper.Configuration volShaperConfig = fadeManagerConfig.getFadeInVolumeShaperConfigForAudioAttributes(aa);     // Catch: Throwable -> L8
        if (volShaperConfig == null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return volShaperConfig;
    L10:
        VolumeShaper.Configuration r3 = fadeManagerConfig.getFadeInVolumeShaperConfigForUsage(aa.getSystemUsage());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r3;
    L8:
        th = move-exception;
        throw th;
    }

    private long getOptimalFadeOutDuration(AudioAttributes aa) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FadeManagerConfiguration fadeManagerConfig = getUpdatedFadeManagerConfigLocked();     // Catch: Throwable -> L8
        long duration = fadeManagerConfig.getFadeOutDurationForAudioAttributes(aa);     // Catch: Throwable -> L8
        if (duration == 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return duration;
    L10:
        long r4 = fadeManagerConfig.getFadeOutDurationForUsage(aa.getSystemUsage());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r4;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isUnfadeableForFadeMgrConfigLocked(AudioAttributes aa, int uid) {
        if (isAudioAttributesUnfadeableLocked(aa) == false) goto L6;
        return true;
    L6:
        if (isUidUnfadeableLocked(uid) == false) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean isUsageFadeableLocked(int usage) {
        return getUpdatedFadeManagerConfigLocked().isUsageFadeable(usage);
    }

    private boolean isContentTypeUnfadeableLocked(int contentType) {
        return getUpdatedFadeManagerConfigLocked().isContentTypeUnfadeable(contentType);
    }

    private boolean isPlayerTypeUnfadeableLocked(int playerType) {
        return getUpdatedFadeManagerConfigLocked().isPlayerTypeUnfadeable(playerType);
    }

    private boolean isAudioAttributesUnfadeableLocked(AudioAttributes aa) {
        return getUpdatedFadeManagerConfigLocked().isAudioAttributesUnfadeable(aa);
    }

    private boolean isUidUnfadeableLocked(int uid) {
        return getUpdatedFadeManagerConfigLocked().isUidUnfadeable(uid);
    }

    private FadeManagerConfiguration getUpdatedFadeManagerConfigLocked() {
        if (this.mActiveFadeManagerConfig != null) goto L6;
        this.mActiveFadeManagerConfig = getActiveFadeMgrConfigLocked();
    L6:
        return this.mActiveFadeManagerConfig;
    }

    private FadeManagerConfiguration getActiveFadeMgrConfigLocked() {
        if (this.mTransientFadeManagerConfig == null) goto L7;
        return this.mTransientFadeManagerConfig;
    L7:
        if (this.mUpdatedFadeManagerConfig == null) goto L11;
        return this.mUpdatedFadeManagerConfig;
    L11:
        return getDefaultFadeManagerConfigLocked();
    }

    private FadeManagerConfiguration getDefaultFadeManagerConfigLocked() {
        if (this.mDefaultFadeManagerConfig != null) goto L6;
        this.mDefaultFadeManagerConfig = new FadeManagerConfiguration.Builder().build();
    L6:
        return this.mDefaultFadeManagerConfig;
    }
}
