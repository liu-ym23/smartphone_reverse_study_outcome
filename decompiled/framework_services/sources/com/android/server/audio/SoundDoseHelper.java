package com.android.server.audio;

import android.R;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioSystem;
import android.media.ISoundDose;
import android.media.ISoundDoseCallback;
import android.media.SoundDoseRecord;
import android.media.VolumeInfo;
import android.os.Binder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.util.MathUtils;
import android.util.SparseIntArray;
import com.android.server.am.HostingRecord;
import com.android.server.utils.EventLogger;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class SoundDoseHelper {
    static final String ACTION_CHECK_MUSIC_ACTIVE = "com.android.server.audio.action.CHECK_MUSIC_ACTIVE";
    private static final int CSD_WARNING_TIMEOUT_MS_ACCUMULATION_START = -1;
    private static final int CSD_WARNING_TIMEOUT_MS_DOSE_1X = 7000;
    private static final int CSD_WARNING_TIMEOUT_MS_DOSE_5X = 5000;
    private static final int CSD_WARNING_TIMEOUT_MS_MOMENTARY_EXPOSURE = 5000;
    private static final long GLOBAL_TIME_OFFSET_UNINITIALIZED = -1;
    private static final int MAX_NUMBER_OF_CACHED_RECORDS = 655;
    private static final int MAX_RECORDS_STRING_LENGTH = 50;
    private static final int MAX_SETTINGS_LENGTH = 32768;
    private static final int MOMENTARY_EXPOSURE_TIMEOUT_MS = 72000000;
    private static final int MOMENTARY_EXPOSURE_TIMEOUT_UNINITIALIZED = -1;
    static final int MSG_CONFIGURE_SAFE_MEDIA = 1001;
    static final int MSG_CONFIGURE_SAFE_MEDIA_FORCED = 1002;
    static final int MSG_CSD_UPDATE_ATTENUATION = 1006;
    static final int MSG_LOWER_VOLUME_TO_RS1 = 1007;
    static final int MSG_PERSIST_CSD_VALUES = 1005;
    static final int MSG_PERSIST_MUSIC_ACTIVE_MS = 1004;
    static final int MSG_PERSIST_SAFE_VOLUME_STATE = 1003;
    private static final int MUSIC_ACTIVE_POLL_PERIOD_MS = 30000;
    private static final String PERSIST_CSD_RECORD_FIELD_SEPARATOR = ",";
    private static final String PERSIST_CSD_RECORD_SEPARATOR = "\\|";
    private static final String PERSIST_CSD_RECORD_SEPARATOR_CHAR = "|";
    private static final int REQUEST_CODE_CHECK_MUSIC_ACTIVE = 1;
    private static final int SAFE_MEDIA_VOLUME_ACTIVE = 3;
    private static final int SAFE_MEDIA_VOLUME_DISABLED = 1;
    private static final int SAFE_MEDIA_VOLUME_INACTIVE = 2;
    private static final int SAFE_MEDIA_VOLUME_NOT_CONFIGURED = 0;
    private static final int SAFE_MEDIA_VOLUME_UNINITIALIZED = -1;
    private static final int SAFE_VOLUME_CONFIGURE_TIMEOUT_MS = 30000;
    private static final String SYSTEM_PROPERTY_SAFEMEDIA_BYPASS = "audio.safemedia.bypass";
    private static final String SYSTEM_PROPERTY_SAFEMEDIA_CSD_FORCE = "audio.safemedia.csd.force";
    private static final String SYSTEM_PROPERTY_SAFEMEDIA_FORCE = "audio.safemedia.force";
    private static final String TAG = "AS.SoundDoseHelper";
    private static final int UNSAFE_VOLUME_MUSIC_ACTIVE_MS_MAX = 72000000;
    private final AlarmManager mAlarmManager;
    private final AudioService.AudioHandler mAudioHandler;
    private final AudioService mAudioService;
    private final ArrayList<ISoundDose.AudioDeviceCategory> mCachedAudioDeviceCategories;
    private final Context mContext;
    private final Object mCsdAsAFeatureLock;
    private final Object mCsdStateLock;
    private float mCurrentCsd;
    private final List<SoundDoseRecord> mDoseRecords;
    private final AtomicBoolean mEnableCsd;
    private final AtomicBoolean mForceCsdProperty;
    private long mGlobalTimeOffsetInSecs;
    private boolean mIsCsdAsAFeatureAvailable;
    private boolean mIsCsdAsAFeatureEnabled;
    private long mLastMomentaryExposureTimeMs;
    private long mLastMusicActiveTimeMs;
    private final EventLogger mLogger;
    private int mMcc;
    private PendingIntent mMusicActiveIntent;
    private int mMusicActiveMs;
    private float mNextCsdWarning;
    private StreamVolumeCommand mPendingVolumeCommand;
    private float mSafeMediaVolumeDbfs;
    private final SparseIntArray mSafeMediaVolumeDevices;
    private int mSafeMediaVolumeIndex;
    private int mSafeMediaVolumeState;
    private final Object mSafeMediaVolumeStateLock;
    private final SettingsAdapter mSettings;
    private final AtomicReference<ISoundDose> mSoundDose;
    private final ISoundDoseCallback.Stub mSoundDoseCallback;
    private final SoundDoseHelperExt mSoundDoseHelperExt;
    private final AudioService.ISafeHearingVolumeController mVolumeController;

    private static class StreamVolumeCommand {
        public final int mDevice;
        public final int mFlags;
        public final int mIndex;
        public final int mStreamType;

        StreamVolumeCommand(int streamType, int index, int flags, int device) {
            this.mStreamType = streamType;
            this.mIndex = index;
            this.mFlags = flags;
            this.mDevice = device;
        }

        public String toString() {
            return "{streamType=" + this.mStreamType + ",index=" + this.mIndex + ",flags=" + this.mFlags + ",device=" + this.mDevice + "}";
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-eyX7mXE3YxFQvwPH19lwSCuwYk, reason: not valid java name */
    public static /* synthetic */ boolean m2185$r8$lambda$eyX7mXE3YxFQvwPH19lwSCuwYk(SoundDoseRecord r0, SoundDoseRecord r1) {
        return lambda$updateSoundDoseRecords_l$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$-sBXj5AnMnsGb4USPhlqVokq-ZE, reason: not valid java name */
    public static /* synthetic */ SoundDoseRecord m2186$r8$lambda$sBXj5AnMnsGb4USPhlqVokqZE(long r0, String r2) {
        return lambda$persistedStringToRecordList$2(r0, r2);
    }

    public static /* synthetic */ String $r8$lambda$rggneTbRzo8AfgNHvHRz9NFr10o(SoundDoseHelper r0, SoundDoseRecord r1) {
        return r0.lambda$onPersistSoundDoseRecords$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioService, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioService m2187$$Nest$fgetmAudioService(SoundDoseHelper r0) {
        return r0.mAudioService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCsdStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2188$$Nest$fgetmCsdStateLock(SoundDoseHelper r0) {
        return r0.mCsdStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentCsd, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m2189$$Nest$fgetmCurrentCsd(SoundDoseHelper r0) {
        return r0.mCurrentCsd;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEnableCsd, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m2190$$Nest$fgetmEnableCsd(SoundDoseHelper r0) {
        return r0.mEnableCsd;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastMomentaryExposureTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m2191$$Nest$fgetmLastMomentaryExposureTimeMs(SoundDoseHelper r2) {
        return r2.mLastMomentaryExposureTimeMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m2192$$Nest$fgetmLogger(SoundDoseHelper r0) {
        return r0.mLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNextCsdWarning, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m2193$$Nest$fgetmNextCsdWarning(SoundDoseHelper r0) {
        return r0.mNextCsdWarning;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVolumeController, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioService.ISafeHearingVolumeController m2194$$Nest$fgetmVolumeController(SoundDoseHelper r0) {
        return r0.mVolumeController;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentCsd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2195$$Nest$fputmCurrentCsd(SoundDoseHelper r0, float r1) {
        r0.mCurrentCsd = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLastMomentaryExposureTimeMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2196$$Nest$fputmLastMomentaryExposureTimeMs(SoundDoseHelper r0, long r1) {
        r0.mLastMomentaryExposureTimeMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNextCsdWarning, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2197$$Nest$fputmNextCsdWarning(SoundDoseHelper r0, float r1) {
        r0.mNextCsdWarning = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTimeoutMsForWarning, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2198$$Nest$mgetTimeoutMsForWarning(SoundDoseHelper r0, int r1) {
        return r0.getTimeoutMsForWarning(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateSoundDoseRecords_l, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2199$$Nest$mupdateSoundDoseRecords_l(SoundDoseHelper r0, SoundDoseRecord[] r1, float r2) {
        r0.updateSoundDoseRecords_l(r1, r2);
    }

    SoundDoseHelper(AudioService audioService, Context context, AudioService.AudioHandler audioHandler, SettingsAdapter settings, AudioService.ISafeHearingVolumeController volumeController) {
        this.mLogger = new EventLogger(50, "CSD updates");
        this.mMcc = 0;
        this.mSafeMediaVolumeStateLock = new Object();
        this.mSafeMediaVolumeDevices = new SparseIntArray();
        this.mLastMusicActiveTimeMs = 0;
        this.mMusicActiveIntent = null;
        this.mEnableCsd = new AtomicBoolean(false);
        this.mForceCsdProperty = new AtomicBoolean(false);
        this.mCsdAsAFeatureLock = new Object();
        this.mIsCsdAsAFeatureAvailable = false;
        this.mIsCsdAsAFeatureEnabled = false;
        this.mCachedAudioDeviceCategories = new ArrayList();
        this.mCsdStateLock = new Object();
        this.mSoundDose = new AtomicReference();
        this.mCurrentCsd = 0.0f;
        this.mLastMomentaryExposureTimeMs = -1;
        this.mNextCsdWarning = 1.0f;
        this.mDoseRecords = new ArrayList();
        this.mGlobalTimeOffsetInSecs = -1;
        this.mSoundDoseCallback = new AnonymousClass1(this);
        this.mAudioService = audioService;
        this.mAudioHandler = audioHandler;
        this.mSettings = settings;
        this.mVolumeController = volumeController;
        this.mContext = context;
        initSafeVolumes();
        this.mSafeMediaVolumeState = this.mSettings.getGlobalInt(audioService.getContentResolver(), "audio_safe_volume_state", 0);
        this.mSafeMediaVolumeIndex = this.mContext.getResources().getInteger(R.integer.config_screenBrightnessDoze) * 10;
        this.mSoundDose.set(AudioSystem.getSoundDoseInterface(this.mSoundDoseCallback));
        initCsd();
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mSoundDoseHelperExt = SoundDoseHelperExt.get(this);
        this.mSoundDoseHelperExt.init_onEnd(this.mAudioService);
    }

    void initSafeVolumes() {
        this.mSafeMediaVolumeDevices.append(4, -1);
        this.mSafeMediaVolumeDevices.append(8, -1);
        this.mSafeMediaVolumeDevices.append(67108864, -1);
        this.mSafeMediaVolumeDevices.append(536870912, -1);
        this.mSafeMediaVolumeDevices.append(536870914, -1);
        this.mSafeMediaVolumeDevices.append(256, -1);
        this.mSafeMediaVolumeDevices.append(128, -1);
    }

    float getOutputRs2UpperBound() {
        if (this.mEnableCsd.get() == true) goto L5;
        return 0.0f;
    L5:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L14;
        Log.w(TAG, "Sound dose interface not initialized");
        return 0.0f;
    L14:
        return soundDose.getOutputRs2UpperBound();
    L11:
        e = move-exception;
        Log.e(TAG, "Exception while getting the RS2 exposure value", e);
        return 0.0f;
    }

    void setOutputRs2UpperBound(float rs2Value) {
        if (this.mEnableCsd.get() == true) goto L5;
        return;
    L5:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L14;
        Log.w(TAG, "Sound dose interface not initialized");
        return;
    L14:
        soundDose.setOutputRs2UpperBound(rs2Value);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Exception while setting the RS2 exposure value", e);
    }

    private boolean updateCsdForTestApi() {
        if (this.mForceCsdProperty.get() == SystemProperties.getBoolean(SYSTEM_PROPERTY_SAFEMEDIA_CSD_FORCE, false)) goto L6;
        updateCsdEnabled("SystemPropertiesChangeCallback");
    L6:
        return this.mEnableCsd.get();
    }

    float getCsd() {
        if (this.mEnableCsd.get() == false) goto L5;
    L7:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L16;
        Log.w(TAG, "Sound dose interface not initialized");
        return -1.0f;
    L16:
        return soundDose.getCsd();
    L13:
        e = move-exception;
        Log.e(TAG, "Exception while getting the CSD value", e);
        return -1.0f;
    L5:
        if (updateCsdForTestApi() == true) goto L7;
        return -1.0f;
    }

    void setCsd(float csd) {
        if (this.mEnableCsd.get() == false) goto L5;
    L7:
        Object r0 = this.mCsdStateLock;
        monitor-enter(r0);
        this.mCurrentCsd = csd;     // Catch: Throwable -> L12
        this.mNextCsdWarning = (float) Math.floor(((double) csd) + 1.0d);     // Catch: Throwable -> L12
        this.mDoseRecords.clear();     // Catch: Throwable -> L12
        if (this.mCurrentCsd <= 0.0f) goto L14;
        SoundDoseRecord record = new SoundDoseRecord();     // Catch: Throwable -> L12
        record.timestamp = SystemClock.elapsedRealtime() / 1000;     // Catch: Throwable -> L12
        record.value = csd;     // Catch: Throwable -> L12
        this.mDoseRecords.add(record);     // Catch: Throwable -> L12
    L14:
        SoundDoseRecord[] doseRecordsArray = (SoundDoseRecord[]) this.mDoseRecords.toArray(new SoundDoseRecord[0]);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L29;
        Log.w(TAG, "Sound dose interface not initialized");
        return;
    L29:
        soundDose.resetCsd(csd, doseRecordsArray);     // Catch: RemoteException -> L22
        return;
    L22:
        e = move-exception;
        Log.e(TAG, "Exception while setting the CSD value", e);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (updateCsdForTestApi() == true) goto L7;
    }

    void resetCsdTimeouts() {
        if (this.mEnableCsd.get() == false) goto L5;
    L7:
        Object r0 = this.mCsdStateLock;
        monitor-enter(r0);
        this.mLastMomentaryExposureTimeMs = -1;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L5:
        if (updateCsdForTestApi() == true) goto L7;
    }

    void forceUseFrameworkMel(boolean useFrameworkMel) {
        if (this.mEnableCsd.get() == false) goto L5;
    L7:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L16;
        Log.w(TAG, "Sound dose interface not initialized");
        return;
    L16:
        soundDose.forceUseFrameworkMel(useFrameworkMel);     // Catch: RemoteException -> L13
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "Exception while forcing the internal MEL computation", e);
        return;
    L5:
        if (updateCsdForTestApi() == true) goto L7;
    }

    void forceComputeCsdOnAllDevices(boolean computeCsdOnAllDevices) {
        if (this.mEnableCsd.get() == false) goto L5;
    L7:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L16;
        Log.w(TAG, "Sound dose interface not initialized");
        return;
    L16:
        soundDose.forceComputeCsdOnAllDevices(computeCsdOnAllDevices);     // Catch: RemoteException -> L13
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "Exception while forcing CSD computation on all devices", e);
        return;
    L5:
        if (updateCsdForTestApi() == true) goto L7;
    }

    boolean isCsdEnabled() {
        if (this.mEnableCsd.get() == true) goto L5;
        return false;
    L5:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L14;
        Log.w(TAG, "Sound dose interface not initialized");
        return false;
    L14:
        return soundDose.isSoundDoseHalSupported();
    L11:
        e = move-exception;
        Log.e(TAG, "Exception while querying the csd enabled status", e);
        return false;
    }

    boolean isCsdAsAFeatureAvailable() {
        Object r0 = this.mCsdAsAFeatureLock;
        monitor-enter(r0);
        boolean r1 = this.mIsCsdAsAFeatureAvailable;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isCsdAsAFeatureEnabled() {
        Object r0 = this.mCsdAsAFeatureLock;
        monitor-enter(r0);
        boolean r1 = this.mIsCsdAsAFeatureEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setCsdAsAFeatureEnabled(boolean csdAsAFeatureEnabled) {
        Object r0 = this.mCsdAsAFeatureLock;
        monitor-enter(r0);
        int r2 = 0;
        if (this.mIsCsdAsAFeatureEnabled != csdAsAFeatureEnabled) goto L7;
    L11:
        boolean doUpdate = false;
    L12:
        this.mIsCsdAsAFeatureEnabled = csdAsAFeatureEnabled;     // Catch: Throwable -> L9
        long callingIdentity = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        SettingsAdapter r6 = this.mSettings;     // Catch: Throwable -> L22
        ContentResolver r7 = this.mAudioService.getContentResolver();     // Catch: Throwable -> L22
        if (this.mIsCsdAsAFeatureEnabled == false) goto L16;
        r2 = 1;
    L16:
        r6.putSecureIntForUser(r7, "audio_safe_csd_as_a_feature_enabled", r2, -2);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(callingIdentity);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (doUpdate == false) goto L30;
        updateCsdEnabled("setCsdAsAFeatureEnabled");
        return;
    L30:
        return;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L7:
        if (this.mIsCsdAsAFeatureAvailable == false) goto L11;
        doUpdate = true;
    L9:
        th = move-exception;
        throw th;
    }

    void setAudioDeviceCategory(String address, int internalAudioType, boolean isHeadphone) {
        if (this.mEnableCsd.get() == true) goto L5;
        return;
    L5:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L14;
        Log.w(TAG, "Sound dose interface not initialized");
        return;
    L14:
        ISoundDose.AudioDeviceCategory audioDeviceCategory = new ISoundDose.AudioDeviceCategory();     // Catch: RemoteException -> L11
        audioDeviceCategory.address = address;     // Catch: RemoteException -> L11
        audioDeviceCategory.internalAudioType = internalAudioType;     // Catch: RemoteException -> L11
        audioDeviceCategory.csdCompatible = isHeadphone;     // Catch: RemoteException -> L11
        soundDose.setAudioDeviceCategory(audioDeviceCategory);     // Catch: RemoteException -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Exception while setting the audio device category", e);
    }

    void initCachedAudioDeviceCategories(Collection<AdiDeviceState> deviceStates) {
        Iterator<AdiDeviceState> r0 = deviceStates.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        AdiDeviceState state = r0.next();
        if (state.getAudioDeviceCategory() == 0) goto L4;
        ISoundDose.AudioDeviceCategory audioDeviceCategory = new ISoundDose.AudioDeviceCategory();
        audioDeviceCategory.address = state.getDeviceAddress();
        audioDeviceCategory.internalAudioType = state.getInternalDeviceType();
        if (state.getAudioDeviceCategory() != 3) goto L10;
        boolean r3 = true;
    L11:
        audioDeviceCategory.csdCompatible = r3;
        this.mCachedAudioDeviceCategories.add(audioDeviceCategory);
        goto L4
    L10:
        r3 = false;
        goto L11
    }

    int safeMediaVolumeIndex(int device) {
        int vol = this.mSafeMediaVolumeDevices.get(device);
        if (vol == (-1)) goto L5;
        return vol;
    L5:
        return AudioService.MAX_STREAM_VOLUME[3];
    }

    void restoreMusicActiveMs() {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
        this.mMusicActiveMs = MathUtils.constrain(this.mSettings.getSecureIntForUser(this.mAudioService.getContentResolver(), "unsafe_volume_music_active_ms", 0, -2), 0, 72000000);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void resetMusicActiveMs() {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
        Log.d(TAG, "when user switched, change mMusicActiveMs to 0");     // Catch: Throwable -> L7
        this.mMusicActiveMs = 0;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void enforceSafeMediaVolumeIfActive(String caller) {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mSafeMediaVolumeState != 3) goto L9;
        enforceSafeMediaVolume(caller);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void enforceSafeMediaVolume(String caller) {
        AudioService.VolumeStreamState streamState = this.mAudioService.getVssForStreamOrDefault(3);
        int i = 0;
    L4:
        if (i >= this.mSafeMediaVolumeDevices.size()) goto L10;
        int deviceType = this.mSafeMediaVolumeDevices.keyAt(i);
        int index = streamState.getIndex(deviceType);
        int safeIndex = safeMediaVolumeIndex(deviceType);
        if (index <= safeIndex) goto L8;
        streamState.setIndex(safeIndex, deviceType, caller, true);
        this.mSoundDoseHelperExt.setAbsoluteVolumeForDevice(3, safeIndex, deviceType);
        this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(0, deviceType, 0, streamState));
    L8:
        i = i + 1;
        goto L4
    }

    boolean checkSafeMediaVolume(int streamType, int index, int device) {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
        boolean result = checkSafeMediaVolume_l(streamType, index, device);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return result;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean checkSafeMediaVolume_l(int streamType, int index, int device) {
        if (this.mSafeMediaVolumeState == 3) goto L5;
    L11:
        return false;
    L5:
        if (AudioService.sStreamVolumeAlias.get(streamType) != 3) goto L11;
        if (safeDevicesContains(device) == false) goto L11;
        if (index <= safeMediaVolumeIndex(device)) goto L11;
        return true;
    }

    boolean willDisplayWarningAfterCheckVolume(int streamType, int index, int device, int flags) {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (checkSafeMediaVolume_l(streamType, index, device) == false) goto L12;
        this.mVolumeController.postDisplaySafeVolumeWarning(flags);     // Catch: Throwable -> L10
        this.mPendingVolumeCommand = new StreamVolumeCommand(streamType, index, flags, device);     // Catch: Throwable -> L10
        this.mSoundDoseHelperExt.setAbsoluteVolumeForDevice(streamType, this.mAudioService.getVssForStreamOrDefault(streamType).getIndex(device), device);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    }

    void disableSafeMediaVolume(String callingPackage) {
        Object r1 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r1);
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
        setSafeMediaVolumeEnabled(false, callingPackage);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L14
        if (this.mPendingVolumeCommand == null) goto L17;
        this.mAudioService.onSetStreamVolume(this.mPendingVolumeCommand.mStreamType, this.mPendingVolumeCommand.mIndex, this.mPendingVolumeCommand.mFlags, this.mPendingVolumeCommand.mDevice, callingPackage, true, true);     // Catch: Throwable -> L12
        this.mSoundDoseHelperExt.setAbsoluteVolumeForDevice(this.mPendingVolumeCommand.mStreamType, this.mPendingVolumeCommand.mIndex, this.mPendingVolumeCommand.mDevice);     // Catch: Throwable -> L12
        this.mPendingVolumeCommand = null;     // Catch: Throwable -> L12
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Throwable r13 = th;
    L22:
        monitor-exit(r1);     // Catch: Throwable -> L12
        throw r13;
    L14:
        th = move-exception;
        r13 = th;
        goto L22
    }

    void scheduleMusicActiveCheck() {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
        cancelMusicActiveCheck();     // Catch: Throwable -> L7
        this.mMusicActiveIntent = PendingIntent.getBroadcast(this.mContext, 1, new Intent(ACTION_CHECK_MUSIC_ACTIVE), AudioFormat.DTS_HD);     // Catch: Throwable -> L7
        this.mAlarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 30000, this.mMusicActiveIntent);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onCheckMusicActive(String caller, boolean isStreamActive) {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mSafeMediaVolumeState != 2) goto L22;
        int device = this.mAudioService.getDeviceForStream(3);     // Catch: Throwable -> L14
        if (safeDevicesContains(device) == false) goto L21;
        if (isStreamActive == false) goto L21;
        scheduleMusicActiveCheck();     // Catch: Throwable -> L14
        int index = this.mAudioService.getVolumeForDeviceIgnoreMute(3, device);     // Catch: Throwable -> L14
        if (index <= safeMediaVolumeIndex(device)) goto L22;
        long curTimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (this.mLastMusicActiveTimeMs == 0) goto L16;
        this.mMusicActiveMs += (int) (curTimeMs - this.mLastMusicActiveTimeMs);     // Catch: Throwable -> L14
    L16:
        this.mLastMusicActiveTimeMs = curTimeMs;     // Catch: Throwable -> L14
        Log.i(TAG, "onCheckMusicActive() mMusicActiveMs: " + this.mMusicActiveMs);     // Catch: Throwable -> L14
        if (this.mMusicActiveMs <= 72000000) goto L19;
        setSafeMediaVolumeEnabled(true, caller);     // Catch: Throwable -> L14
        this.mMusicActiveMs = 0;     // Catch: Throwable -> L14
    L19:
        saveMusicActiveMs();     // Catch: Throwable -> L14
    L21:
        cancelMusicActiveCheck();     // Catch: Throwable -> L14
        this.mLastMusicActiveTimeMs = 0;     // Catch: Throwable -> L14
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    void configureSafeMedia(boolean forced, String caller) {
        if (forced == false) goto L4;
        int msg = 1002;
    L5:
        this.mAudioHandler.removeMessages(msg);
        long time = 0;
        if (forced == false) goto L12;
        long r4 = SystemClock.uptimeMillis();
        if (SystemProperties.getBoolean(SYSTEM_PROPERTY_SAFEMEDIA_BYPASS, false) == false) goto L10;
        int r6 = 0;
    L11:
        time = r4 + ((long) r6);
        goto L12
    L10:
        r6 = 30000;
    L12:
        this.mAudioHandler.sendMessageAtTime(this.mAudioHandler.obtainMessage(msg, 0, 0, caller), time);
        return;
    L4:
        msg = 1001;
        goto L5
    }

    void initSafeMediaVolumeIndex() {
        int i = 0;
    L4:
        if (i >= this.mSafeMediaVolumeDevices.size()) goto L10;
        int deviceType = this.mSafeMediaVolumeDevices.keyAt(i);
        if (this.mSafeMediaVolumeDevices.valueAt(i) != (-1)) goto L8;
        this.mSafeMediaVolumeDevices.put(deviceType, getSafeDeviceMediaVolumeIndex(deviceType));
    L8:
        i = i + 1;
        goto L4
    }

    int getSafeMediaVolumeIndex(int device) {
        if (this.mSafeMediaVolumeState == 3) goto L5;
        return -1;
    L5:
        if (safeDevicesContains(device) == true) goto L7;
        return -1;
    L7:
        return safeMediaVolumeIndex(device);
    }

    boolean raiseVolumeDisplaySafeMediaVolume(int streamType, int index, int device, int flags) {
        if (checkSafeMediaVolume(streamType, index, device) == true) goto L6;
        return false;
    L6:
        this.mVolumeController.postDisplaySafeVolumeWarning(flags);
        return true;
    }

    boolean safeDevicesContains(int device) {
        if (this.mSafeMediaVolumeDevices.get(device, -1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    void invalidatePendingVolumeCommand() {
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
        this.mPendingVolumeCommand = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void handleMessage(Message msg) {
        boolean isAbsoluteVolume = false;
        switch(msg.what) {
            case 1001: goto L14;
            case 1002: goto L14;
            case 1003: goto L12;
            case 1004: goto L11;
            case 1005: goto L10;
            case 1006: goto L6;
            case 1007: goto L5;
            default: goto L4;
        };
    L4:
        Log.e(TAG, "Unexpected msg to handle: " + msg.what);
        return;
    L5:
        onLowerVolumeToRs1();
        return;
    L6:
        int device = msg.arg1;
        if (msg.arg2 != 1) goto L9;
        isAbsoluteVolume = true;
    L9:
        AudioService.VolumeStreamState streamState = (AudioService.VolumeStreamState) msg.obj;
        updateDoseAttenuation(streamState.getIndex(device), device, streamState.getStreamType(), isAbsoluteVolume);
        return;
    L10:
        onPersistSoundDoseRecords();
        return;
    L11:
        int musicActiveMs = msg.arg1;
        this.mSettings.putSecureIntForUser(this.mAudioService.getContentResolver(), "unsafe_volume_music_active_ms", musicActiveMs, -2);
        return;
    L12:
        int musicActiveMs2 = msg.arg1;
        onPersistSafeVolumeState(musicActiveMs2);
        return;
    L14:
        if (msg.what != 1002) goto L16;
        isAbsoluteVolume = true;
    L16:
        onConfigureSafeMedia(isAbsoluteVolume, (String) msg.obj);
    }

    void dump(PrintWriter pw) {
        pw.print("  mEnableCsd=");
        pw.println(this.mEnableCsd.get());
        if (this.mEnableCsd.get() == false) goto L12;
        Object r0 = this.mCsdStateLock;
        monitor-enter(r0);
        pw.print("  mCurrentCsd=");     // Catch: Throwable -> L9
        pw.println(this.mCurrentCsd);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        pw.print("  mSafeMediaVolumeState=");
        pw.println(safeMediaVolumeStateToString(this.mSafeMediaVolumeState));
        pw.print("  mSafeMediaVolumeIndex=");
        pw.println(this.mSafeMediaVolumeIndex);
        int i = 0;
    L14:
        if (i >= this.mSafeMediaVolumeDevices.size()) goto L16;
        pw.print("  mSafeMediaVolumeIndex[");
        pw.print(this.mSafeMediaVolumeDevices.keyAt(i));
        pw.print("]=");
        pw.println(this.mSafeMediaVolumeDevices.valueAt(i));
        i = i + 1;
        goto L14
    L16:
        pw.print("  mSafeMediaVolumeDbfs=");
        pw.println(this.mSafeMediaVolumeDbfs);
        pw.print("  mMusicActiveMs=");
        pw.println(this.mMusicActiveMs);
        pw.print("  mMcc=");
        pw.println(this.mMcc);
        pw.print("  mPendingVolumeCommand=");
        pw.println(this.mPendingVolumeCommand);
        pw.println();
        this.mLogger.dump(pw);
        pw.println();
    }

    void reset(boolean resetISoundDose) {
        Log.d(TAG, "Reset the sound dose helper");
        if (resetISoundDose == false) goto L5;
        this.mSoundDose.set(AudioSystem.getSoundDoseInterface(this.mSoundDoseCallback));
    L5:
        Object r0 = this.mCsdStateLock;
        monitor-enter(r0);
        ISoundDose soundDose = this.mSoundDose.get();     // Catch: Throwable -> L15 RemoteException -> L17
        if (soundDose == null) goto L20;
        if (soundDose.asBinder().isBinderAlive() == false) goto L20;
        if (this.mCurrentCsd == 0.0f) goto L20;
        Log.d(TAG, "Resetting the saved sound dose value " + this.mCurrentCsd);     // Catch: Throwable -> L15 RemoteException -> L17
        SoundDoseRecord[] records = (SoundDoseRecord[]) this.mDoseRecords.toArray(new SoundDoseRecord[0]);     // Catch: Throwable -> L15 RemoteException -> L17
        soundDose.resetCsd(this.mCurrentCsd, records);     // Catch: Throwable -> L15 RemoteException -> L17
    L15:
        th = move-exception;
        throw th;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L15
    }

    private void updateDoseAttenuation(int newIndex, int device, int streamType, boolean isAbsoluteVolume) {
        if (this.mEnableCsd.get() == true) goto L5;
        return;
    L5:
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L28;
        Log.w(TAG, "Can not apply attenuation. ISoundDose itf is null.");
        return;
    L28:
        if (isAbsoluteVolume == true) goto L18;
        if (this.mSafeMediaVolumeDevices.indexOfKey(device) < 0) goto L15;
        this.mLogger.enqueue(AudioServiceEvents.SoundDoseEvent.getAbsVolumeAttenuationEvent(0.0f, device));     // Catch: RemoteException -> L13
    L15:
        soundDose.updateAttenuation(0.0f, device);     // Catch: RemoteException -> L13
        return;
    L18:
        if (AudioService.sStreamVolumeAlias.get(streamType) == 3) goto L20;
        return;
    L20:
        if (safeDevicesContains(device) == false) goto L31;
        float attenuationDb = -AudioSystem.getStreamVolumeDB(3, (newIndex + 5) / 10, device);
        if (this.mSafeMediaVolumeDevices.indexOfKey(device) < 0) goto L24;
        this.mLogger.enqueue(AudioServiceEvents.SoundDoseEvent.getAbsVolumeAttenuationEvent(attenuationDb, device));     // Catch: RemoteException -> L13
    L24:
        soundDose.updateAttenuation(attenuationDb, device);     // Catch: RemoteException -> L13
        return;
    L31:
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "Could not apply the attenuation for MEL calculation with volume index " + newIndex, e);
    }

    private void initCsd() {
        ISoundDose soundDose = this.mSoundDose.get();
        if (soundDose != null) goto L52;
        Log.w(TAG, "ISoundDose instance is null.");
        return;
    L52:
        soundDose.setCsdEnabled(this.mEnableCsd.get());     // Catch: RemoteException -> L8
    L11:
        if (this.mEnableCsd.get() == true) goto L13;
        return;
    L13:
        Log.v(TAG, "Initializing sound dose");
    L18:
        e = move-exception;
        Log.e(TAG, "Exception while initializing the cached audio device categories", e);
    L22:
        Object r2 = this.mCsdAsAFeatureLock;
        monitor-enter(r2);
    L47:
        th = move-exception;
        throw th;
    L25:
        if (this.mSettings.getSecureIntForUser(this.mAudioService.getContentResolver(), "audio_safe_csd_as_a_feature_enabled", 0, -2) == 0) goto L27;
        boolean r3 = true;
    L28:
        this.mIsCsdAsAFeatureEnabled = r3;     // Catch: Throwable -> L47
        monitor-exit(r2);     // Catch: Throwable -> L47
        Object r4 = this.mCsdStateLock;
        monitor-enter(r4);
    L35:
        th = move-exception;
        throw th;
    L33:
        if (this.mGlobalTimeOffsetInSecs != (-1)) goto L37;
        this.mGlobalTimeOffsetInSecs = System.currentTimeMillis() / 1000;     // Catch: Throwable -> L35
    L37:
        float prevCsd = this.mCurrentCsd;     // Catch: Throwable -> L35
        this.mCurrentCsd = parseGlobalSettingFloat("audio_safe_csd_current_value", 0.0f);     // Catch: Throwable -> L35
        if (this.mCurrentCsd == prevCsd) goto L42;
        this.mNextCsdWarning = parseGlobalSettingFloat("audio_safe_csd_next_warning", 1.0f);     // Catch: Throwable -> L35
        List<SoundDoseRecord> records = persistedStringToRecordList(this.mSettings.getGlobalString(this.mAudioService.getContentResolver(), "audio_safe_csd_dose_records"), this.mGlobalTimeOffsetInSecs);     // Catch: Throwable -> L35
        if (records == null) goto L42;
        this.mDoseRecords.addAll(records);     // Catch: Throwable -> L35
        sanitizeDoseRecords_l();     // Catch: Throwable -> L35
    L42:
        monitor-exit(r4);     // Catch: Throwable -> L35
        reset(false);
        return;
    L27:
        r3 = false;
        goto L28
    L15:
        if (this.mCachedAudioDeviceCategories.isEmpty() == true) goto L22;
        soundDose.initCachedAudioDeviceCategories((ISoundDose.AudioDeviceCategory[]) this.mCachedAudioDeviceCategories.toArray(new ISoundDose.AudioDeviceCategory[0]));     // Catch: RemoteException -> L18
        this.mCachedAudioDeviceCategories.clear();     // Catch: RemoteException -> L18
    L8:
        e = move-exception;
        Log.e(TAG, "Cannot disable CSD", e);
        goto L11
    }

    private void onConfigureSafeMedia(boolean force, String caller) {
        updateCsdEnabled(caller);
        Object r0 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r0);
        int mcc = this.mContext.getResources().getConfiguration().mcc;     // Catch: Throwable -> L10
        if (this.mMcc != mcc) goto L12;
        if (this.mMcc != 0) goto L13;
        if (force == true) goto L12;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        this.mSafeMediaVolumeIndex = this.mContext.getResources().getInteger(R.integer.config_screenBrightnessDoze) * 10;     // Catch: Throwable -> L10
        initSafeMediaVolumeIndex();     // Catch: Throwable -> L10
        updateSafeMediaVolume_l(caller);     // Catch: Throwable -> L10
        this.mMcc = mcc;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void updateSafeMediaVolume_l(String caller) {
        if (SystemProperties.getBoolean(SYSTEM_PROPERTY_SAFEMEDIA_BYPASS, false) == false) goto L5;
    L8:
        boolean safeMediaVolumeBypass = true;
    L9:
        boolean safeMediaVolumeForce = SystemProperties.getBoolean(SYSTEM_PROPERTY_SAFEMEDIA_FORCE, false);
        boolean mccEnforcedSafeMediaVolume = this.mContext.getResources().getBoolean(R.bool.config_sendAudioBecomingNoisy);
        if (mccEnforcedSafeMediaVolume == true) goto L12;
        if (safeMediaVolumeForce == true) goto L12;
    L14:
        boolean safeVolumeEnabled = false;
    L15:
        if (safeVolumeEnabled == false) goto L22;
        int persistedState = 3;
        if (this.mSafeMediaVolumeState != 2) goto L19;
    L23:
        this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1003, persistedState, 0, null));
        return;
    L19:
        if (this.mMusicActiveMs != 0) goto L21;
        this.mSafeMediaVolumeState = 3;
        enforceSafeMediaVolume(caller);
        goto L23
    L21:
        this.mSafeMediaVolumeState = 2;
        this.mLastMusicActiveTimeMs = 0;
        goto L23
    L22:
        this.mSafeMediaVolumeState = 1;
        persistedState = 1;
    L12:
        if (safeMediaVolumeBypass == true) goto L14;
        safeVolumeEnabled = true;
        goto L15
    L5:
        if (this.mEnableCsd.get() == true) goto L8;
        safeMediaVolumeBypass = false;
        goto L9
    }

    private void updateCsdEnabled(String caller) {
        boolean r2 = false;
        this.mForceCsdProperty.set(SystemProperties.getBoolean(SYSTEM_PROPERTY_SAFEMEDIA_CSD_FORCE, false));
        boolean mccEnforcedSafeMedia = this.mContext.getResources().getBoolean(R.bool.config_sendAudioBecomingNoisy);
        boolean csdEnable = this.mContext.getResources().getBoolean(R.bool.config_send_satellite_datagram_to_modem_in_demo_mode);
        if (mccEnforcedSafeMedia == false) goto L6;
        if (csdEnable == false) goto L6;
    L7:
        boolean newEnabledCsd = true;
    L9:
        Object r5 = this.mCsdAsAFeatureLock;
        monitor-enter(r5);
        if (mccEnforcedSafeMedia == true) goto L23;
        if (csdEnable == false) goto L23;
        this.mIsCsdAsAFeatureAvailable = true;     // Catch: Throwable -> L19
        if (this.mIsCsdAsAFeatureEnabled == true) goto L21;
        if (this.mForceCsdProperty.get() == true) goto L21;
        boolean r6 = false;
    L22:
        newEnabledCsd = r6;
        Log.v(TAG, caller + ": CSD as a feature is not enforced and enabled: " + newEnabledCsd);     // Catch: Throwable -> L19
    L24:
        monitor-exit(r5);     // Catch: Throwable -> L19
        AtomicBoolean r7 = this.mEnableCsd;
        if (newEnabledCsd == true) goto L29;
        r2 = true;
    L29:
        if (r7.compareAndSet(r2, newEnabledCsd) == false) goto L38;
        Log.i(TAG, caller + ": enabled CSD " + newEnabledCsd);
        initCsd();
        Object r3 = this.mSafeMediaVolumeStateLock;
        monitor-enter(r3);
        initSafeMediaVolumeIndex();     // Catch: Throwable -> L35
        updateSafeMediaVolume_l(caller);     // Catch: Throwable -> L35
        monitor-exit(r3);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    L38:
        return;
    L21:
        r6 = true;
    L23:
        this.mIsCsdAsAFeatureAvailable = false;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.mForceCsdProperty.get() == true) goto L7;
        newEnabledCsd = false;
        goto L9
    }

    private int getTimeoutMsForWarning(int csdWarning) {
        switch(csdWarning) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        Log.e(TAG, "Invalid CSD warning " + csdWarning, new Exception());
        return -1;
    L6:
        return -1;
    L7:
        return 5000;
    L8:
        return 5000;
    L9:
        return CSD_WARNING_TIMEOUT_MS_DOSE_1X;
    }

    private void setSafeMediaVolumeEnabled(boolean on, String caller) {
        if (this.mSafeMediaVolumeState != 0) goto L5;
        return;
    L5:
        if (this.mSafeMediaVolumeState != 1) goto L7;
        return;
    L7:
        if (on == true) goto L9;
    L11:
        if (on == false) goto L13;
        return;
    L13:
        if (this.mSafeMediaVolumeState != 3) goto L20;
        this.mSafeMediaVolumeState = 2;
        this.mMusicActiveMs = 1;
        this.mLastMusicActiveTimeMs = 0;
        saveMusicActiveMs();
        scheduleMusicActiveCheck();
        return;
    L20:
        return;
    L9:
        if (this.mSafeMediaVolumeState != 2) goto L11;
        this.mSafeMediaVolumeState = 3;
        enforceSafeMediaVolume(caller);
    }

    private void cancelMusicActiveCheck() {
        if (this.mMusicActiveIntent == null) goto L6;
        this.mAlarmManager.cancel(this.mMusicActiveIntent);
        this.mMusicActiveIntent = null;
        return;
    }

    private void saveMusicActiveMs() {
        this.mAudioHandler.obtainMessage(1004, this.mMusicActiveMs, 0).sendToTarget();
    }

    private int getSafeDeviceMediaVolumeIndex(int deviceType) {
        if (this.mEnableCsd.get() == false) goto L5;
    L23:
        int min = AudioService.MIN_STREAM_VOLUME[3];
        int max = AudioService.MAX_STREAM_VOLUME[3];
        this.mSafeMediaVolumeDbfs = this.mContext.getResources().getInteger(R.integer.config_screenBrightnessSettingDefault) / 100.0f;
    L25:
        if (Math.abs(max - min) <= 1) goto L38;
        int index = (max + min) / 2;
        float gainDB = AudioSystem.getStreamVolumeDB(3, index, deviceType);
        if (Float.isNaN(gainDB) == true) goto L38;
        if (gainDB == this.mSafeMediaVolumeDbfs) goto L31;
        if (gainDB < this.mSafeMediaVolumeDbfs) goto L34;
        max = index;
        goto L25
    L34:
        min = index;
        goto L25
    L31:
        min = index;
    L38:
        return min * 10;
    L5:
        if (deviceType == 8) goto L22;
        if (deviceType == 4) goto L22;
        if (deviceType == 128) goto L22;
        if (deviceType == 256) goto L22;
        if (deviceType == 536870912) goto L22;
        if (deviceType == 536870914) goto L22;
        if (deviceType == 67108864) goto L23;
        return -1;
    L22:
        return this.mSafeMediaVolumeIndex;
    }

    private void onPersistSafeVolumeState(int state) {
        this.mSettings.putGlobalInt(this.mAudioService.getContentResolver(), "audio_safe_volume_state", state);
    }

    private static String safeMediaVolumeStateToString(int state) {
        switch(state) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return null;
    L5:
        return "SAFE_MEDIA_VOLUME_ACTIVE";
    L7:
        return "SAFE_MEDIA_VOLUME_INACTIVE";
    L9:
        return "SAFE_MEDIA_VOLUME_DISABLED";
    L11:
        return "SAFE_MEDIA_VOLUME_NOT_CONFIGURED";
    }

    private void updateSoundDoseRecords_l(SoundDoseRecord[] newRecords, float currentCsd) {
        long totalDuration = 0;
        int r2 = newRecords.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L13;
        final SoundDoseRecord record = newRecords[r4];
        Log.i(TAG, "  new record: " + record);
        totalDuration = totalDuration + ((long) record.duration);
        if (record.value >= 0.0f) goto L10;
        if (this.mDoseRecords.removeIf(new SoundDoseHelper$$ExternalSyntheticLambda1(record)) == true) goto L12;
        Log.w(TAG, "Could not find cached record to remove: " + record);
    L12:
        r4 = r4 + 1;
        goto L3
    L10:
        if (record.value <= 0.0f) goto L12;
        this.mDoseRecords.add(record);
        goto L12
    L13:
        sanitizeDoseRecords_l();
        this.mAudioHandler.sendMessage(this.mAudioHandler.obtainMessage(1005, 0, 0, null));
        this.mLogger.enqueue(AudioServiceEvents.SoundDoseEvent.getDoseUpdateEvent(currentCsd, totalDuration));
    }

    private static /* synthetic */ boolean lambda$updateSoundDoseRecords_l$0(SoundDoseRecord record, SoundDoseRecord r) {
        if (r.value == (-record.value)) goto L5;
    L11:
        return false;
    L5:
        if (r.timestamp != record.timestamp) goto L11;
        if (r.averageMel != record.averageMel) goto L11;
        if (r.duration != record.duration) goto L11;
        return true;
    }

    private void sanitizeDoseRecords_l() {
        if (this.mDoseRecords.size() <= MAX_NUMBER_OF_CACHED_RECORDS) goto L9;
        int nrToRemove = this.mDoseRecords.size() - MAX_NUMBER_OF_CACHED_RECORDS;
        Log.w(TAG, "Removing " + nrToRemove + " records from the total of " + this.mDoseRecords.size());
        Iterator<SoundDoseRecord> recordIterator = this.mDoseRecords.iterator();
    L6:
        if (recordIterator.hasNext() == false) goto L12;
        if (nrToRemove <= 0) goto L13;
        recordIterator.next();
        recordIterator.remove();
        nrToRemove = nrToRemove - 1;
        goto L6
    L13:
        return;
    L12:
        return;
    }

    private void onPersistSoundDoseRecords() {
        Object r0 = this.mCsdStateLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mGlobalTimeOffsetInSecs != (-1)) goto L9;
        this.mGlobalTimeOffsetInSecs = System.currentTimeMillis() / 1000;     // Catch: Throwable -> L7
    L9:
        this.mSettings.putGlobalString(this.mAudioService.getContentResolver(), "audio_safe_csd_current_value", Float.toString(this.mCurrentCsd));     // Catch: Throwable -> L7
        this.mSettings.putGlobalString(this.mAudioService.getContentResolver(), "audio_safe_csd_next_warning", Float.toString(this.mNextCsdWarning));     // Catch: Throwable -> L7
        this.mSettings.putGlobalString(this.mAudioService.getContentResolver(), "audio_safe_csd_dose_records", (String) this.mDoseRecords.stream().map(new SoundDoseHelper$$ExternalSyntheticLambda0(this)).collect(Collectors.joining(PERSIST_CSD_RECORD_SEPARATOR_CHAR)));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private /* synthetic */ String lambda$onPersistSoundDoseRecords$1(SoundDoseRecord record) {
        return recordToPersistedString(record, this.mGlobalTimeOffsetInSecs);
    }

    private static String recordToPersistedString(SoundDoseRecord record, long globalTimeOffsetInSecs) {
        return convertToGlobalTime(record.timestamp, globalTimeOffsetInSecs) + PERSIST_CSD_RECORD_FIELD_SEPARATOR + record.duration + PERSIST_CSD_RECORD_FIELD_SEPARATOR + String.format("%.3f", new Object[]{Float.valueOf(record.value)}) + PERSIST_CSD_RECORD_FIELD_SEPARATOR + String.format("%.3f", new Object[]{Float.valueOf(record.averageMel)});
    }

    private static long convertToGlobalTime(long bootTimeInSecs, long globalTimeOffsetInSecs) {
        return bootTimeInSecs + globalTimeOffsetInSecs;
    }

    private static long convertToBootTime(long globalTimeInSecs, long globalTimeOffsetInSecs) {
        return globalTimeInSecs - globalTimeOffsetInSecs;
    }

    private static List<SoundDoseRecord> persistedStringToRecordList(String records, final long globalTimeOffsetInSecs) {
        if (records != null) goto L4;
        return null;
    L4:
        if (records.isEmpty() == false) goto L7;
        return null;
    L7:
        return (List) Arrays.stream(TextUtils.split(records, PERSIST_CSD_RECORD_SEPARATOR)).map(new SoundDoseHelper$$ExternalSyntheticLambda2(globalTimeOffsetInSecs)).filter(new SoundDoseHelper$$ExternalSyntheticLambda3()).collect(Collectors.toList());
    }

    private static /* synthetic */ SoundDoseRecord lambda$persistedStringToRecordList$2(long globalTimeOffsetInSecs, String record) {
        return persistedStringToRecord(record, globalTimeOffsetInSecs);
    }

    private static SoundDoseRecord persistedStringToRecord(String record, long globalTimeOffsetInSecs) {
        if (record != null) goto L5;
    L17:
        return null;
    L5:
        if (record.isEmpty() == true) goto L17;
        String[] fields = TextUtils.split(record, PERSIST_CSD_RECORD_FIELD_SEPARATOR);
        if (fields.length == 4) goto L11;
        Log.w(TAG, "Expecting 4 fields for a SoundDoseRecord, parsed " + fields.length);
        return null;
    L11:
        SoundDoseRecord sdRecord = new SoundDoseRecord();
        sdRecord.timestamp = convertToBootTime(Long.parseLong(fields[0]), globalTimeOffsetInSecs);     // Catch: NumberFormatException -> L14
        sdRecord.duration = Integer.parseInt(fields[1]);     // Catch: NumberFormatException -> L14
        sdRecord.value = Float.parseFloat(fields[2]);     // Catch: NumberFormatException -> L14
        sdRecord.averageMel = Float.parseFloat(fields[3]);     // Catch: NumberFormatException -> L14
        return sdRecord;
    L14:
        e = move-exception;
        Log.e(TAG, "Unable to parse persisted SoundDoseRecord: " + record, e);
        return null;
    }

    private float parseGlobalSettingFloat(String audioSafeCsdCurrentValue, float defaultValue) {
        String stringValue = this.mSettings.getGlobalString(this.mAudioService.getContentResolver(), audioSafeCsdCurrentValue);
        if (stringValue != null) goto L5;
    L12:
        Log.v(TAG, "No value stored in settings " + audioSafeCsdCurrentValue);
        return defaultValue;
    L5:
        if (stringValue.isEmpty() == true) goto L12;
        float value = Float.parseFloat(stringValue);     // Catch: NumberFormatException -> L9
        return value;
    L9:
        e = move-exception;
        Log.e(TAG, "Error parsing float from settings " + audioSafeCsdCurrentValue, e);
        return defaultValue;
    }

    private void onLowerVolumeToRs1() {
        ArrayList<AudioDeviceAttributes> devices = this.mAudioService.getDevicesForAttributesInt(new AudioAttributes.Builder().setUsage(1).build(), true);
        if (devices.isEmpty() == false) goto L6;
        Log.e(TAG, "Cannot lower the volume to RS1, no devices registered for USAGE_MEDIA");
        return;
    L6:
        AudioDeviceAttributes ada = devices.get(0);
        int nativeDeviceType = ada.getInternalType();
        int index = safeMediaVolumeIndex(nativeDeviceType) / 10;
        VolumeInfo curVolume = this.mAudioService.getDeviceVolume(new VolumeInfo.Builder(3).build(), ada, "sounddosehelper");
        if (index >= curVolume.getVolumeIndex()) goto L9;
        this.mLogger.enqueue(AudioServiceEvents.SoundDoseEvent.getLowerVolumeToRs1Event());
        this.mAudioService.setStreamVolumeWithAttributionInt(3, index, 0, ada, this.mContext.getOpPackageName(), null, true);
        return;
    L9:
        Log.i(TAG, "The current volume " + curVolume.getVolumeIndex() + " for device type " + nativeDeviceType + " is already smaller or equal to the safe index volume " + index);
    }
}
