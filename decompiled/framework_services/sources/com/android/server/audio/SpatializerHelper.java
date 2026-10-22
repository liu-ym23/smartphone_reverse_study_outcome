package com.android.server.audio;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.audio.common.V2_0.AudioChannelMask;
import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioSystem;
import android.media.INativeSpatializerCallback;
import android.media.ISpatializer;
import android.media.ISpatializerCallback;
import android.media.ISpatializerHeadToSoundStagePoseCallback;
import android.media.ISpatializerHeadTrackerAvailableCallback;
import android.media.ISpatializerHeadTrackingCallback;
import android.media.ISpatializerHeadTrackingModeCallback;
import android.media.ISpatializerOutputCallback;
import android.media.MediaMetrics;
import android.media.Spatializer;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class SpatializerHelper {
    private static final boolean DEBUG = true;
    private static final boolean DEBUG_MORE = false;
    private static final AudioAttributes DEFAULT_ATTRIBUTES = null;
    private static final AudioFormat DEFAULT_FORMAT = null;
    private static final String METRICS_DEVICE_PREFIX = "audio.spatializer.device.";
    static final SparseIntArray SPAT_MODE_FOR_DEVICE_TYPE = null;
    static final int STATE_DISABLED_AVAILABLE = 6;
    static final int STATE_DISABLED_UNAVAILABLE = 3;
    static final int STATE_ENABLED_AVAILABLE = 5;
    static final int STATE_ENABLED_UNAVAILABLE = 4;
    static final int STATE_NOT_SUPPORTED = 1;
    static final int STATE_UNINITIALIZED = 0;
    private static final String TAG = "AS.SpatializerHelper";
    private static ArrayList<AudioDeviceAttributes> sRoutingDevices;
    private final AudioSystemAdapter mASA;
    private int mActualHeadTrackingMode;
    private final AudioService mAudioService;
    boolean mBinauralEnabledDefault;
    private boolean mBinauralSupported;
    private int mCapableSpatLevel;
    private int mDesiredHeadTrackingMode;
    private int mDesiredHeadTrackingModeWhenEnabled;
    private final AudioDeviceBroker mDeviceBroker;
    private HelperDynamicSensorCallback mDynSensorCallback;
    private boolean mFeatureEnabled;
    final RemoteCallbackList<ISpatializerHeadToSoundStagePoseCallback> mHeadPoseCallbacks;
    private boolean mHeadTrackerAvailable;
    final RemoteCallbackList<ISpatializerHeadTrackerAvailableCallback> mHeadTrackerCallbacks;
    boolean mHeadTrackingEnabledDefault;
    final RemoteCallbackList<ISpatializerHeadTrackingModeCallback> mHeadTrackingModeCallbacks;
    private boolean mIsHeadTrackingSupported;
    final RemoteCallbackList<ISpatializerOutputCallback> mOutputCallbacks;
    private final ArrayList<Integer> mSACapableDeviceTypes;
    private SensorManager mSensorManager;
    private ISpatializer mSpat;
    private SpatializerCallback mSpatCallback;
    private SpatializerHeadTrackingCallback mSpatHeadTrackingCallback;
    private int mSpatLevel;
    private int mSpatOutput;
    private List<Integer> mSpatializedChannelMasks;
    private int mState;
    final RemoteCallbackList<ISpatializerCallback> mStateCallbacks;
    private int[] mSupportedHeadTrackingModes;
    boolean mTransauralEnabledDefault;
    private boolean mTransauralSupported;

    private static class HeadtrackerInfo {
        private final int mVersion;

        HeadtrackerInfo(Sensor sensor) {
            this.mVersion = sensor.getVersion();
        }

        int getMajorVersion() {
            return (this.mVersion & android.hardware.audio.common.V2_0.AudioFormat.MAIN_MASK) >> 24;
        }

        int getMinorVersion() {
            return (this.mVersion & 16711680) >> 16;
        }

        boolean hasAclTransport() {
            if (getMajorVersion() == 2) goto L5;
            return false;
        L5:
            if ((this.mVersion & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean hasIsoTransport() {
            if (getMajorVersion() == 2) goto L5;
            return false;
        L5:
            if ((this.mVersion & 2) == 0) goto L9;
            return true;
        L9:
            return false;
        }
    }

    private final class HelperDynamicSensorCallback extends SensorManager.DynamicSensorCallback {
        final /* synthetic */ SpatializerHelper this$0;

        /* synthetic */ HelperDynamicSensorCallback(SpatializerHelper r1, SpatializerHelperIA r2) {
            this(r1);
        }

        private HelperDynamicSensorCallback(SpatializerHelper r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.SensorManager.DynamicSensorCallback
        public void onDynamicSensorConnected(Sensor sensor) {
            SpatializerHelper.m2218$$Nest$mpostInitSensors(this.this$0);
        }

        @Override // android.hardware.SensorManager.DynamicSensorCallback
        public void onDynamicSensorDisconnected(Sensor sensor) {
            SpatializerHelper.m2218$$Nest$mpostInitSensors(this.this$0);
        }
    }

    private final class SpatializerCallback extends INativeSpatializerCallback.Stub {
        final /* synthetic */ SpatializerHelper this$0;

        /* synthetic */ SpatializerCallback(SpatializerHelper r1, SpatializerHelperIA r2) {
            this(r1);
        }

        private SpatializerCallback(SpatializerHelper r1) {
            this.this$0 = r1;
        }

        public void onLevelChanged(byte level) {
            SpatializerHelper.m2220$$Nest$smloglogi("SpatializerCallback.onLevelChanged level:" + level);
            SpatializerHelper r0 = this.this$0;
            monitor-enter(r0);
            SpatializerHelper.m2213$$Nest$fputmSpatLevel(this.this$0, SpatializerHelper.m2221$$Nest$smspatializationLevelToSpatializerInt(level));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            SpatializerHelper.m2218$$Nest$mpostInitSensors(this.this$0);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void onOutputChanged(int output) {
            SpatializerHelper.m2220$$Nest$smloglogi("SpatializerCallback.onOutputChanged output:" + output);
            SpatializerHelper r0 = this.this$0;
            monitor-enter(r0);
            int oldOutput = SpatializerHelper.m2211$$Nest$fgetmSpatOutput(this.this$0);     // Catch: Throwable -> L9
            SpatializerHelper.m2214$$Nest$fputmSpatOutput(this.this$0, output);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (oldOutput == output) goto L14;
            SpatializerHelper.m2216$$Nest$mdispatchOutputUpdate(this.this$0, output);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private final class SpatializerHeadTrackingCallback extends ISpatializerHeadTrackingCallback.Stub {
        final /* synthetic */ SpatializerHelper this$0;

        /* synthetic */ SpatializerHeadTrackingCallback(SpatializerHelper r1, SpatializerHelperIA r2) {
            this(r1);
        }

        private SpatializerHeadTrackingCallback(SpatializerHelper r1) {
            this.this$0 = r1;
        }

        public void onHeadTrackingModeChanged(byte mode) {
            monitor-enter(this);
            int oldMode = SpatializerHelper.m2210$$Nest$fgetmActualHeadTrackingMode(this.this$0);     // Catch: Throwable -> L9
            SpatializerHelper.m2212$$Nest$fputmActualHeadTrackingMode(this.this$0, SpatializerHelper.m2219$$Nest$smheadTrackingModeTypeToSpatializerInt(mode));     // Catch: Throwable -> L9
            int newMode = SpatializerHelper.m2210$$Nest$fgetmActualHeadTrackingMode(this.this$0);     // Catch: Throwable -> L9
            monitor-exit(this);     // Catch: Throwable -> L9
            SpatializerHelper.m2220$$Nest$smloglogi("SpatializerHeadTrackingCallback.onHeadTrackingModeChanged mode:" + Spatializer.headtrackingModeToString(newMode));
            if (oldMode == newMode) goto L14;
            SpatializerHelper.m2215$$Nest$mdispatchActualHeadTrackingMode(this.this$0, newMode);
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void onHeadToSoundStagePoseUpdated(float[] headToStage) {
            if (headToStage != null) goto L7;
            Log.e(SpatializerHelper.TAG, "SpatializerHeadTrackingCallback.onHeadToStagePoseUpdatednull transform");
            return;
        L7:
            if (headToStage.length == 6) goto L10;
            Log.e(SpatializerHelper.TAG, "SpatializerHeadTrackingCallback.onHeadToStagePoseUpdated invalid transform length" + headToStage.length);
            return;
        L10:
            SpatializerHelper.m2217$$Nest$mdispatchPoseUpdate(this.this$0, headToStage);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActualHeadTrackingMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2210$$Nest$fgetmActualHeadTrackingMode(SpatializerHelper r0) {
        return r0.mActualHeadTrackingMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSpatOutput, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2211$$Nest$fgetmSpatOutput(SpatializerHelper r0) {
        return r0.mSpatOutput;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActualHeadTrackingMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2212$$Nest$fputmActualHeadTrackingMode(SpatializerHelper r0, int r1) {
        r0.mActualHeadTrackingMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSpatLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2213$$Nest$fputmSpatLevel(SpatializerHelper r0, int r1) {
        r0.mSpatLevel = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSpatOutput, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2214$$Nest$fputmSpatOutput(SpatializerHelper r0, int r1) {
        r0.mSpatOutput = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchActualHeadTrackingMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2215$$Nest$mdispatchActualHeadTrackingMode(SpatializerHelper r0, int r1) {
        r0.dispatchActualHeadTrackingMode(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchOutputUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2216$$Nest$mdispatchOutputUpdate(SpatializerHelper r0, int r1) {
        r0.dispatchOutputUpdate(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchPoseUpdate, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2217$$Nest$mdispatchPoseUpdate(SpatializerHelper r0, float[] r1) {
        r0.dispatchPoseUpdate(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostInitSensors, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2218$$Nest$mpostInitSensors(SpatializerHelper r0) {
        r0.postInitSensors();
    }

    /* JADX INFO: renamed from: -$$Nest$smheadTrackingModeTypeToSpatializerInt, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2219$$Nest$smheadTrackingModeTypeToSpatializerInt(byte r0) {
        return headTrackingModeTypeToSpatializerInt(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smloglogi, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2220$$Nest$smloglogi(String r0) {
        loglogi(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smspatializationLevelToSpatializerInt, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2221$$Nest$smspatializationLevelToSpatializerInt(byte r0) {
        return spatializationLevelToSpatializerInt(r0);
    }

    private static void logd(String s) {
        Log.i(TAG, s);
    }

    static {
        final int r1 = 14;
        SPAT_MODE_FOR_DEVICE_TYPE = new AnonymousClass1(r1);
        DEFAULT_ATTRIBUTES = new AudioAttributes.Builder().setUsage(1).build();
        DEFAULT_FORMAT = new AudioFormat.Builder().setEncoding(2).setSampleRate(48000).setChannelMask(AudioChannelMask.IN_6).build();
        sRoutingDevices = new ArrayList(0);
    }

    SpatializerHelper(AudioService mother, AudioSystemAdapter asa, AudioDeviceBroker deviceBroker, boolean binauralEnabledDefault, boolean transauralEnabledDefault, boolean headTrackingEnabledDefault) {
        this.mState = 0;
        this.mFeatureEnabled = false;
        this.mSpatLevel = 0;
        this.mCapableSpatLevel = 0;
        this.mSpatializedChannelMasks = Collections.emptyList();
        this.mTransauralSupported = false;
        this.mBinauralSupported = false;
        this.mIsHeadTrackingSupported = false;
        this.mSupportedHeadTrackingModes = new int[0];
        this.mActualHeadTrackingMode = -2;
        this.mDesiredHeadTrackingMode = 1;
        this.mHeadTrackerAvailable = false;
        this.mDesiredHeadTrackingModeWhenEnabled = 1;
        this.mSpatOutput = 0;
        this.mSpatHeadTrackingCallback = new SpatializerHeadTrackingCallback(this, null);
        this.mSACapableDeviceTypes = new ArrayList(0);
        this.mStateCallbacks = new RemoteCallbackList();
        this.mHeadTrackingModeCallbacks = new RemoteCallbackList();
        this.mHeadTrackerCallbacks = new RemoteCallbackList();
        this.mHeadPoseCallbacks = new RemoteCallbackList();
        this.mOutputCallbacks = new RemoteCallbackList();
        this.mAudioService = mother;
        this.mASA = asa;
        this.mDeviceBroker = deviceBroker;
        this.mBinauralEnabledDefault = binauralEnabledDefault;
        this.mTransauralEnabledDefault = transauralEnabledDefault;
        this.mHeadTrackingEnabledDefault = headTrackingEnabledDefault;
    }

    synchronized void init(boolean effectExpected) {
        monitor-enter(this);
        loglogi("init effectExpected=" + effectExpected);     // Catch: Throwable -> L8
        if (effectExpected == true) goto L11;
        loglogi("init(): setting state to STATE_NOT_SUPPORTED due to effect not expected");     // Catch: Throwable -> L8
        this.mState = 1;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (this.mState != 0) goto L127;
        this.mSpatCallback = new SpatializerCallback(this, null);     // Catch: Throwable -> L8
        ISpatializer spat = AudioSystem.getSpatializer(this.mSpatCallback);     // Catch: Throwable -> L8
        if (spat != null) goto L138;
        loglogi("init(): No Spatializer found");     // Catch: Throwable -> L8
        this.mState = 1;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L138:
        resetCapabilities();     // Catch: Throwable -> L8
        byte[] levels = spat.getSupportedLevels();     // Catch: Throwable -> L72 RemoteException -> L74
        if (levels == null) goto L101;
    L27:
        th = th;
    L135:
        spat.release();     // Catch: Throwable -> L8 RemoteException -> L123
    L125:
        throw th;     // Catch: Throwable -> L8
    L21:
        if (levels.length == 0) goto L101;
        if (levels.length == 1) goto L25;
    L31:
        int r3 = levels.length;     // Catch: Throwable -> L27 RemoteException -> L29
        int r5 = 0;
    L32:
        if (r5 >= r3) goto L37;
        byte level = levels[r5];     // Catch: Throwable -> L27 RemoteException -> L29
        loglogi("init(): found support for level: " + level);     // Catch: Throwable -> L27 RemoteException -> L29
        if (level == 1) goto L35;
        r5 = r5 + 1;     // Catch: Throwable -> L27 RemoteException -> L29
        goto L32
    L35:
        loglogi("init(): setting capable level to LEVEL_MULTICHANNEL");     // Catch: Throwable -> L27 RemoteException -> L29
        this.mCapableSpatLevel = level;     // Catch: Throwable -> L27 RemoteException -> L29
    L37:
        this.mIsHeadTrackingSupported = spat.isHeadTrackingSupported();     // Catch: Throwable -> L27 RemoteException -> L29
        if (this.mIsHeadTrackingSupported == false) goto L52;
        byte[] values = spat.getSupportedHeadTrackingModes();     // Catch: Throwable -> L27 RemoteException -> L29
        ArrayList<Integer> list = new ArrayList(0);     // Catch: Throwable -> L27 RemoteException -> L29
        int r6 = values.length;     // Catch: Throwable -> L27 RemoteException -> L29
        int r7 = 0;
    L40:
        if (r7 >= r6) goto L47;
        byte value = values[r7];     // Catch: Throwable -> L27 RemoteException -> L29
        switch(value) {
            case 0: goto L46;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L44;
            default: goto L43;
        };     // Catch: Throwable -> L27 RemoteException -> L29
    L43:
        Log.e(TAG, "Unexpected head tracking mode:" + value, new IllegalArgumentException("invalid mode"));     // Catch: Throwable -> L27 RemoteException -> L29
        goto L46
    L44:
        list.add(Integer.valueOf(headTrackingModeTypeToSpatializerInt(value)));     // Catch: Throwable -> L27 RemoteException -> L29
    L46:
        r7 = r7 + 1;     // Catch: Throwable -> L27 RemoteException -> L29
        goto L40
    L47:
        this.mSupportedHeadTrackingModes = new int[list.size()];     // Catch: Throwable -> L27 RemoteException -> L29
        int i = 0;
    L49:
        if (i >= list.size()) goto L51;
        this.mSupportedHeadTrackingModes[i] = list.get(i).intValue();     // Catch: Throwable -> L27 RemoteException -> L29
        i = i + 1;     // Catch: Throwable -> L27 RemoteException -> L29
        goto L49
    L51:
        this.mActualHeadTrackingMode = headTrackingModeTypeToSpatializerInt(spat.getActualHeadTrackingMode());     // Catch: Throwable -> L27 RemoteException -> L29
    L53:
        byte[] spatModes = spat.getSupportedModes();     // Catch: Throwable -> L27 RemoteException -> L29
        int r8 = spatModes.length;     // Catch: Throwable -> L27 RemoteException -> L29
        int r9 = 0;
    L54:
        if (r9 >= r8) goto L62;
        byte mode = spatModes[r9];     // Catch: Throwable -> L27 RemoteException -> L29
        switch(mode) {
            case 0: goto L59;
            case 1: goto L58;
            default: goto L57;
        };     // Catch: Throwable -> L27 RemoteException -> L29
    L57:
        logloge("init(): Spatializer reports unknown supported mode:" + mode);     // Catch: Throwable -> L27 RemoteException -> L29
    L60:
        r9 = r9 + 1;     // Catch: Throwable -> L27 RemoteException -> L29
        goto L54
    L58:
        this.mTransauralSupported = true;     // Catch: Throwable -> L27 RemoteException -> L29
        goto L60
    L59:
        this.mBinauralSupported = true;     // Catch: Throwable -> L27 RemoteException -> L29
        goto L60
    L62:
        if (this.mBinauralSupported == false) goto L64;
    L76:
        int i2 = 0;
    L78:
        if (i2 >= SPAT_MODE_FOR_DEVICE_TYPE.size()) goto L89;
        int mode2 = SPAT_MODE_FOR_DEVICE_TYPE.valueAt(i2);     // Catch: Throwable -> L72 RemoteException -> L74
        if (mode2 == 0) goto L82;
    L83:
        if (mode2 != 1) goto L87;
        if (this.mTransauralSupported == false) goto L87;
    L86:
        this.mSACapableDeviceTypes.add(Integer.valueOf(SPAT_MODE_FOR_DEVICE_TYPE.keyAt(i2)));     // Catch: Throwable -> L72 RemoteException -> L74
    L87:
        i2 = i2 + 1;
        goto L78
    L82:
        if (this.mBinauralSupported == true) goto L86;
    L89:
        Iterator<AdiDeviceState> r10 = this.mDeviceBroker.getImmutableDeviceInventory().iterator();     // Catch: Throwable -> L27 RemoteException -> L29
    L91:
        if (r10.hasNext() == false) goto L96;
        AdiDeviceState deviceState = r10.next();     // Catch: Throwable -> L72 RemoteException -> L74
        if (isSADevice(deviceState) == false) goto L91;
        logDeviceState(deviceState, "setSADeviceSettings");     // Catch: Throwable -> L72 RemoteException -> L74
        goto L91
    L96:
        addCompatibleAudioDevice(new AudioDeviceAttributes(2, ""), false, false);     // Catch: Throwable -> L27 RemoteException -> L29
        addCompatibleAudioDevice(new AudioDeviceAttributes(8, ""), false, false);     // Catch: Throwable -> L27 RemoteException -> L29
        spat.release();     // Catch: Throwable -> L8 RemoteException -> L99
    L137:
        goto L113
    L64:
        if (this.mTransauralSupported == true) goto L76;
        this.mState = 1;     // Catch: Throwable -> L72 RemoteException -> L74
        spat.release();     // Catch: Throwable -> L8 RemoteException -> L68
    L70:
        monitor-exit(this);
        return;
    L52:
        this.mDesiredHeadTrackingModeWhenEnabled = -2;     // Catch: Throwable -> L27 RemoteException -> L29
        this.mDesiredHeadTrackingMode = -2;     // Catch: Throwable -> L27 RemoteException -> L29
        goto L53
    L25:
        if (levels[0] != 0) goto L31;
    L101:
        logloge("init(): found Spatializer is useless");     // Catch: Throwable -> L72 RemoteException -> L74
        this.mState = 1;     // Catch: Throwable -> L72 RemoteException -> L74
        spat.release();     // Catch: Throwable -> L8 RemoteException -> L104
    L106:
        monitor-exit(this);
        return;
    L72:
        th = th;
    L109:
        resetCapabilities();     // Catch: Throwable -> L27
        spat.release();     // Catch: Throwable -> L8 RemoteException -> L99
    L113:
        if (this.mCapableSpatLevel != 0) goto L118;
        this.mState = 1;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L118:
        this.mState = 3;     // Catch: Throwable -> L8
        sRoutingDevices = getRoutingDevices(DEFAULT_ATTRIBUTES);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L127:
        throw new IllegalStateException(logloge("init() called in state " + this.mState));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void reset(boolean featureEnabled) {
        monitor-enter(this);
        loglogi("Resetting featureEnabled=" + featureEnabled);     // Catch: Throwable -> L6
        releaseSpat();     // Catch: Throwable -> L6
        this.mState = 0;     // Catch: Throwable -> L6
        this.mSpatLevel = 0;     // Catch: Throwable -> L6
        this.mActualHeadTrackingMode = -2;     // Catch: Throwable -> L6
        init(true);     // Catch: Throwable -> L6
        setSpatializerEnabledInt(featureEnabled);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void resetCapabilities() {
        this.mCapableSpatLevel = 0;
        this.mBinauralSupported = false;
        this.mTransauralSupported = false;
        this.mIsHeadTrackingSupported = false;
        this.mSupportedHeadTrackingModes = new int[0];
    }

    synchronized void onRoutingUpdated() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        switch(this.mState) {
            case 0: goto L49;
            case 1: goto L49;
            default: goto L5;
        };     // Catch: Throwable -> L10
    L5:
        sRoutingDevices = getRoutingDevices(DEFAULT_ATTRIBUTES);     // Catch: Throwable -> L10
        byte level = 0;
        if (sRoutingDevices.isEmpty() == false) goto L12;
        logloge("onRoutingUpdated: no device, no Spatial Audio");     // Catch: Throwable -> L10
        setDispatchAvailableState(false);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L12:
        AudioDeviceAttributes currentDevice = sRoutingDevices.get(0);     // Catch: Throwable -> L10
        if (AudioSystem.isBluetoothDevice(currentDevice.getInternalType()) == false) goto L15;
        addWirelessDeviceIfNew(currentDevice);     // Catch: Throwable -> L10
    L15:
        Pair<Boolean, Boolean> enabledAvailable = evaluateState(currentDevice);     // Catch: Throwable -> L10
        boolean able = false;
        if (((Boolean) enabledAvailable.second).booleanValue() == false) goto L18;
        able = canBeSpatializedOnDevice(DEFAULT_ATTRIBUTES, DEFAULT_FORMAT, sRoutingDevices);     // Catch: Throwable -> L10
        loglogi("onRoutingUpdated: can spatialize media 5.1:" + able + " on device:" + currentDevice);     // Catch: Throwable -> L10
        setDispatchAvailableState(able);     // Catch: Throwable -> L10
    L20:
        if (this.mFeatureEnabled == false) goto L25;
        if (able == false) goto L25;
        if (((Boolean) enabledAvailable.first).booleanValue() == false) goto L25;
        boolean enabled = true;
    L27:
        if (enabled == false) goto L29;
        loglogi("Enabling Spatial Audio since enabled for media device:" + currentDevice);     // Catch: Throwable -> L10
    L31:
        if (this.mSpat == null) goto L42;
        if (enabled == false) goto L35;
        level = 1;
    L35:
        loglogi("Setting spatialization level to: " + level);     // Catch: Throwable -> L10
        this.mSpat.setLevel(level);     // Catch: Throwable -> L10 RemoteException -> L38
    L38:
        e = move-exception;
        Log.e(TAG, "onRoutingUpdated() Can't set spatializer level", e);     // Catch: Throwable -> L10
        postReset();     // Catch: Throwable -> L10
        return;
    L42:
        setDispatchFeatureEnabledState(enabled, "onRoutingUpdated");     // Catch: Throwable -> L10
        if (this.mDesiredHeadTrackingMode != (-2)) goto L45;
    L47:
        monitor-exit(this);
        return;
    L45:
        if (this.mDesiredHeadTrackingMode == (-1)) goto L47;
        postInitSensors();     // Catch: Throwable -> L10
        goto L47
    L29:
        loglogi("Disabling Spatial Audio since disabled for media device:" + currentDevice);     // Catch: Throwable -> L10
    L25:
        enabled = false;
        goto L27
    L18:
        loglogi("onRoutingUpdated: device:" + currentDevice + " not available for Spatial Audio");     // Catch: Throwable -> L10
        setDispatchAvailableState(false);     // Catch: Throwable -> L10
        goto L20
    L49:
        monitor-exit(this);
    }

    private void postReset() {
        this.mAudioService.postResetSpatializer();
    }

    synchronized List<AudioDeviceAttributes> getCompatibleAudioDevices() {
        monitor-enter(this);
        ArrayList<AudioDeviceAttributes> compatList = new ArrayList();     // Catch: Throwable -> L12
        Iterator<AdiDeviceState> r1 = this.mDeviceBroker.getImmutableDeviceInventory().iterator();     // Catch: Throwable -> L12
    L5:
        if (r1.hasNext() == false) goto L15;
        AdiDeviceState deviceState = r1.next();     // Catch: Throwable -> L12
        if (deviceState.isSAEnabled() == false) goto L5;
        if (isSADevice(deviceState) == false) goto L5;
        compatList.add(deviceState.getAudioDeviceAttributes());     // Catch: Throwable -> L12
        goto L5
    L15:
        monitor-exit(this);
        return compatList;
    L12:
        th = move-exception;
        throw th;
    }

    synchronized void addCompatibleAudioDevice(AudioDeviceAttributes ada) {
        monitor-enter(this);
        addCompatibleAudioDevice(ada, true, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void addCompatibleAudioDevice(AudioDeviceAttributes ada, boolean forceEnable, boolean forceInit) {
        if (isDeviceCompatibleWithSpatializationModes(ada) == true) goto L5;
        return;
    L5:
        loglogi("addCompatibleAudioDevice: dev=" + ada);
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);
        AdiDeviceState updatedDevice = null;
        if (deviceState == null) goto L13;
        if (forceInit == false) goto L9;
        initSAState(deviceState);
    L9:
        if (forceEnable == true) goto L11;
    L18:
        if (updatedDevice == null) goto L21;
        onRoutingUpdated();
        this.mDeviceBroker.postPersistAudioDeviceSettings();
        logDeviceState(updatedDevice, "addCompatibleAudioDevice");
        return;
    L21:
        return;
    L11:
        if (deviceState.isSAEnabled() == true) goto L18;
        updatedDevice = deviceState;
        updatedDevice.setSAEnabled(true);
        goto L18
    L13:
        int canonicalDeviceType = getCanonicalDeviceType(ada.getType(), ada.getInternalType());
        if (canonicalDeviceType != 0) goto L17;
        Log.e(TAG, "addCompatibleAudioDevice with incompatible AudioDeviceAttributes " + ada);
        return;
    L17:
        updatedDevice = new AdiDeviceState(canonicalDeviceType, ada.getInternalType(), ada.getAddress());
        initSAState(updatedDevice);
        this.mDeviceBroker.addOrUpdateDeviceSAStateInInventory(updatedDevice, true);
        goto L18
    }

    private void initSAState(AdiDeviceState device) {
        if (device != null) goto L4;
        return;
    L4:
        int spatMode = SPAT_MODE_FOR_DEVICE_TYPE.get(device.getDeviceType(), Integer.MIN_VALUE);
        if (spatMode != 0) goto L8;
        boolean r1 = this.mBinauralEnabledDefault;
    L11:
        device.setSAEnabled(r1);
        device.setHeadTrackerEnabled(this.mHeadTrackingEnabledDefault);
        return;
    L8:
        if (spatMode != 1) goto L10;
        r1 = this.mTransauralEnabledDefault;
        goto L11
    L10:
        r1 = false;
        goto L11
    }

    static void logDeviceState(AdiDeviceState deviceState, String event) {
        int deviceType = AudioDeviceInfo.convertDeviceTypeToInternalDevice(deviceState.getDeviceType());
        String deviceName = AudioSystem.getDeviceName(deviceType);
        MediaMetrics.Item r2 = new MediaMetrics.Item(METRICS_DEVICE_PREFIX + deviceName).set(MediaMetrics.Property.ADDRESS, deviceState.getDeviceAddress());
        MediaMetrics.Key r3 = MediaMetrics.Property.ENABLED;
        String r5 = "false";
        if (deviceState.isSAEnabled() == false) goto L5;
        Object r4 = "true";
    L6:
        MediaMetrics.Item r6 = r2.set(r3, r4).set(MediaMetrics.Property.EVENT, TextUtils.emptyIfNull(event));
        MediaMetrics.Key r7 = MediaMetrics.Property.HAS_HEAD_TRACKER;
        if (deviceState.hasHeadTracker() == false) goto L9;
        Object r8 = "true";
    L10:
        MediaMetrics.Item r9 = r6.set(r7, r8);
        MediaMetrics.Key r10 = MediaMetrics.Property.HEAD_TRACKER_ENABLED;
        if (deviceState.isHeadTrackerEnabled() == false) goto L13;
        r5 = "true";
    L13:
        r9.set(r10, r5).record();
        return;
    L9:
        r8 = "false";
        goto L10
    L5:
        r4 = "false";
        goto L6
    }

    synchronized void removeCompatibleAudioDevice(AudioDeviceAttributes ada) {
        monitor-enter(this);
        loglogi("removeCompatibleAudioDevice: dev=" + ada);     // Catch: Throwable -> L9
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);     // Catch: Throwable -> L9
        if (deviceState != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (deviceState.isSAEnabled() == false) goto L11;
        deviceState.setSAEnabled(false);     // Catch: Throwable -> L9
        onRoutingUpdated();     // Catch: Throwable -> L9
        this.mDeviceBroker.postPersistAudioDeviceSettings();     // Catch: Throwable -> L9
        logDeviceState(deviceState, "removeCompatibleAudioDevice");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private static int getCanonicalDeviceType(int deviceType, int internalDeviceType) {
        if (AudioSystem.isBluetoothDevice(internalDeviceType) == false) goto L5;
        return deviceType;
    L5:
        int spatMode = SPAT_MODE_FOR_DEVICE_TYPE.get(deviceType, Integer.MIN_VALUE);
        if (spatMode != 1) goto L9;
        return 2;
    L9:
        if (spatMode != 0) goto L12;
        return 4;
    L12:
        return 0;
    }

    private AdiDeviceState findSACompatibleDeviceStateForAudioDeviceAttributes(AudioDeviceAttributes ada) {
        AdiDeviceState deviceState = this.mDeviceBroker.findDeviceStateForAudioDeviceAttributes(ada, getCanonicalDeviceType(ada.getType(), ada.getInternalType()));
        if (deviceState != null) goto L6;
        return null;
    L6:
        if (isSADevice(deviceState) == true) goto L8;
        return null;
    L8:
        return deviceState;
    }

    private synchronized Pair<Boolean, Boolean> evaluateState(AudioDeviceAttributes ada) {
        monitor-enter(this);
        int deviceType = ada.getType();     // Catch: Throwable -> L8
        boolean r2 = false;
        if (this.mSACapableDeviceTypes.contains(Integer.valueOf(deviceType)) == true) goto L10;
        Log.i(TAG, "Device incompatible with Spatial Audio dev:" + ada);     // Catch: Throwable -> L8
        Pair<Boolean, Boolean> r1 = new Pair(false, false);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    L10:
        int spatMode = SPAT_MODE_FOR_DEVICE_TYPE.get(deviceType, Integer.MIN_VALUE);     // Catch: Throwable -> L8
        if (spatMode != Integer.MIN_VALUE) goto L15;
        Log.e(TAG, "no spatialization mode found for device type:" + deviceType);     // Catch: Throwable -> L8
        Pair<Boolean, Boolean> r3 = new Pair(false, false);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r3;
    L15:
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);     // Catch: Throwable -> L8
        if (deviceState != null) goto L20;
        Log.i(TAG, "no spatialization device state found for Spatial Audio device:" + ada);     // Catch: Throwable -> L8
        Pair<Boolean, Boolean> r4 = new Pair(false, false);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r4;
    L20:
        boolean available = true;
        if (AudioSystem.isBluetoothDevice(deviceType) == true) goto L24;
    L34:
        Pair<Boolean, Boolean> r5 = new Pair(Boolean.valueOf(deviceState.isSAEnabled()), Boolean.valueOf(available));     // Catch: Throwable -> L8
        monitor-exit(this);
        return r5;
    L24:
        if (deviceState.getAudioDeviceCategory() != 0) goto L26;
    L29:
        if (spatMode == 0) goto L31;
    L33:
        available = r2;
        goto L34
    L31:
        if (this.mBinauralSupported == false) goto L33;
        r2 = true;
        goto L33
    L26:
        if (deviceState.getAudioDeviceCategory() == 3) goto L29;
        available = false;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized void addWirelessDeviceIfNew(AudioDeviceAttributes ada) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (isDeviceCompatibleWithSpatializationModes(ada) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (findSACompatibleDeviceStateForAudioDeviceAttributes(ada) != null) goto L17;
        int canonicalDeviceType = getCanonicalDeviceType(ada.getType(), ada.getInternalType());     // Catch: Throwable -> L14
        if (canonicalDeviceType != 0) goto L16;
        Log.e(TAG, "addWirelessDeviceIfNew with incompatible AudioDeviceAttributes " + ada);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L16:
        AdiDeviceState deviceState = new AdiDeviceState(canonicalDeviceType, ada.getInternalType(), ada.getAddress());     // Catch: Throwable -> L14
        initSAState(deviceState);     // Catch: Throwable -> L14
        this.mDeviceBroker.addOrUpdateDeviceSAStateInInventory(deviceState, true);     // Catch: Throwable -> L14
        this.mDeviceBroker.postPersistAudioDeviceSettings();     // Catch: Throwable -> L14
        logDeviceState(deviceState, "addWirelessDeviceIfNew");     // Catch: Throwable -> L14
    L17:
        monitor-exit(this);
    }

    synchronized boolean isEnabled() {
        monitor-enter(this);
        switch(this.mState) {
            case 0: goto L8;
            case 1: goto L8;
            case 2: goto L5;
            case 3: goto L8;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L8;
            default: goto L5;
        };
    L5:
        monitor-exit(this);
        return true;
    L8:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized boolean isAvailable() {
        monitor-enter(this);
        switch(this.mState) {
            case 0: goto L8;
            case 1: goto L8;
            case 2: goto L5;
            case 3: goto L8;
            case 4: goto L8;
            default: goto L5;
        };
    L5:
        monitor-exit(this);
        return true;
    L8:
        monitor-exit(this);
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void refreshDevice(AudioDeviceAttributes ada, boolean initState) {
        monitor-enter(this);
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);     // Catch: Throwable -> L6
        if (isAvailableForAdiDeviceState(deviceState) == false) goto L8;
        addCompatibleAudioDevice(ada, deviceState.isSAEnabled(), initState);     // Catch: Throwable -> L6
        setHeadTrackerEnabled(deviceState.isHeadTrackerEnabled(), ada);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return;
    L8:
        removeCompatibleAudioDevice(ada);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    synchronized boolean isAvailableForDevice(AudioDeviceAttributes ada) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (ada.getRole() == 2) goto L10;
        monitor-exit(this);
        return false;
    L10:
        boolean r0 = isAvailableForAdiDeviceState(findSACompatibleDeviceStateForAudioDeviceAttributes(ada));     // Catch: Throwable -> L13
        monitor-exit(this);
        return r0;
    }

    private boolean isAvailableForAdiDeviceState(AdiDeviceState deviceState) {
        if (deviceState != null) goto L6;
        return false;
    L6:
        if (AudioSystem.isBluetoothDevice(deviceState.getInternalDeviceType()) == true) goto L8;
        return true;
    L8:
        if (deviceState.getAudioDeviceCategory() != 0) goto L10;
        return true;
    L10:
        if (deviceState.getAudioDeviceCategory() == 3) goto L15;
        return false;
    L15:
        return true;
    }

    private synchronized boolean canBeSpatializedOnDevice(AudioAttributes attributes, AudioFormat format, ArrayList<AudioDeviceAttributes> devices) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (devices.isEmpty() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (isDeviceCompatibleWithSpatializationModes(devices.get(0)) == false) goto L15;
        AudioDeviceAttributes[] devArray = new AudioDeviceAttributes[devices.size()];     // Catch: Throwable -> L13
        boolean r1 = AudioSystem.canBeSpatialized(attributes, format, (AudioDeviceAttributes[]) devices.toArray(devArray));     // Catch: Throwable -> L13
        monitor-exit(this);
        return r1;
    L15:
        monitor-exit(this);
        return false;
    }

    private boolean isDeviceCompatibleWithSpatializationModes(AudioDeviceAttributes ada) {
        byte modeForDevice = (byte) SPAT_MODE_FOR_DEVICE_TYPE.get(ada.getType(), -1);
        if (modeForDevice == 0) goto L5;
    L6:
        if (modeForDevice == 1) goto L8;
        return false;
    L8:
        if (this.mTransauralSupported == false) goto L12;
    L9:
        return true;
    L12:
        return false;
    L5:
        if (this.mBinauralSupported == true) goto L9;
        goto L6
    }

    boolean isSADevice(AdiDeviceState deviceState) {
        if (deviceState.getDeviceType() == getCanonicalDeviceType(deviceState.getDeviceType(), deviceState.getInternalDeviceType())) goto L5;
    L7:
        return false;
    L5:
        if (isDeviceCompatibleWithSpatializationModes(deviceState.getAudioDeviceAttributes()) == false) goto L7;
        return true;
    }

    synchronized void setFeatureEnabled(boolean enabled) {
        monitor-enter(this);
        loglogi("setFeatureEnabled(" + enabled + ") was featureEnabled:" + this.mFeatureEnabled);     // Catch: Throwable -> L14
        if (this.mFeatureEnabled != enabled) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mFeatureEnabled = enabled;     // Catch: Throwable -> L14
        if (this.mFeatureEnabled == true) goto L10;
        setSpatializerEnabledInt(false);     // Catch: Throwable -> L14
    L21:
        monitor-exit(this);
        return;
    L10:
        if (this.mState != 1) goto L17;
        Log.e(TAG, "Can't enabled Spatial Audio, unsupported");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L17:
        if (this.mState != 0) goto L19;
        init(true);     // Catch: Throwable -> L14
    L19:
        setSpatializerEnabledInt(true);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    synchronized void setSpatializerEnabledInt(boolean enabled) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        switch(this.mState) {
            case 0: goto L15;
            case 1: goto L12;
            case 2: goto L16;
            case 3: goto L10;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L10;
            default: goto L16;
        };     // Catch: Throwable -> L8
    L6:
        if (enabled == true) goto L16;
        releaseSpat();     // Catch: Throwable -> L8
        setDispatchFeatureEnabledState(false, "setSpatializerEnabledInt");     // Catch: Throwable -> L8
        goto L16
    L10:
        if (enabled == false) goto L16;
        createSpat();     // Catch: Throwable -> L8
        onRoutingUpdated();     // Catch: Throwable -> L8
        goto L16
    L12:
        if (enabled == false) goto L16;
        Log.e(TAG, "Can't enable when unsupported");     // Catch: Throwable -> L8
        goto L16
    L15:
        if (enabled == false) goto L16;
        throw new IllegalStateException("Can't enable when uninitialized");     // Catch: Throwable -> L8
    L16:
        monitor-exit(this);
    }

    synchronized int getCapableImmersiveAudioLevel() {
        monitor-enter(this);
        int r0 = this.mCapableSpatLevel;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void registerStateCallback(ISpatializerCallback callback) {
        monitor-enter(this);
        this.mStateCallbacks.register(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void unregisterStateCallback(ISpatializerCallback callback) {
        monitor-enter(this);
        this.mStateCallbacks.unregister(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void setDispatchFeatureEnabledState(boolean featureEnabled, String source) {
        monitor-enter(this);
        if (featureEnabled == false) goto L17;
        switch(this.mState) {
            case 3: goto L15;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L7;
        };     // Catch: Throwable -> L8
    L10:
        this.mState = 5;     // Catch: Throwable -> L8
    L22:
        loglogi("setDispatchFeatureEnabledState(" + featureEnabled + ") mState:" + spatStateString(this.mState));     // Catch: Throwable -> L8
        int nbCallbacks = this.mStateCallbacks.beginBroadcast();     // Catch: Throwable -> L8
        int i = 0;
    L24:
        if (i >= nbCallbacks) goto L30;
        this.mStateCallbacks.getBroadcastItem(i).dispatchSpatializerEnabledChanged(featureEnabled);     // Catch: Throwable -> L8 RemoteException -> L27
    L29:
        i = i + 1;     // Catch: Throwable -> L8
    L27:
        e = move-exception;
        Log.e(TAG, "Error in dispatchSpatializerEnabledChanged", e);     // Catch: Throwable -> L8
        goto L29
    L30:
        this.mStateCallbacks.finishBroadcast();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        loglogi("setDispatchFeatureEnabledState(" + featureEnabled + ") no dispatch: mState:" + spatStateString(this.mState) + " src:" + source);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L7:
        throw new IllegalStateException("Invalid mState:" + this.mState + " for enabled true");     // Catch: Throwable -> L8
    L15:
        this.mState = 4;     // Catch: Throwable -> L8
        goto L22
    L17:
        switch(this.mState) {
            case 3: goto L33;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L33;
            default: goto L19;
        };     // Catch: Throwable -> L8
    L20:
        this.mState = 6;     // Catch: Throwable -> L8
        goto L22
    L21:
        this.mState = 3;     // Catch: Throwable -> L8
        goto L22
    L33:
        loglogi("setDispatchFeatureEnabledState(" + featureEnabled + ") no dispatch: mState:" + spatStateString(this.mState) + " src:" + source);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L19:
        throw new IllegalStateException("Invalid mState:" + this.mState + " for enabled false");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized void setDispatchAvailableState(boolean available) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        switch(this.mState) {
            case 0: goto L43;
            case 1: goto L43;
            case 2: goto L28;
            case 3: goto L25;
            case 4: goto L20;
            case 5: goto L14;
            case 6: goto L6;
            default: goto L28;
        };     // Catch: Throwable -> L10
    L6:
        if (available == false) goto L13;
        loglogi("setDispatchAvailableState(" + available + ") no dispatch: mState:" + spatStateString(this.mState));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L13:
        this.mState = 3;     // Catch: Throwable -> L10
        goto L28
    L14:
        if (available == false) goto L19;
        loglogi("setDispatchAvailableState(" + available + ") no dispatch: mState:" + spatStateString(this.mState));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L19:
        this.mState = 4;     // Catch: Throwable -> L10
        goto L28
    L20:
        if (available == false) goto L22;
        this.mState = 5;     // Catch: Throwable -> L10
        goto L28
    L22:
        loglogi("setDispatchAvailableState(" + available + ") no dispatch: mState:" + spatStateString(this.mState));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L25:
        if (available == true) goto L27;
        loglogi("setDispatchAvailableState(" + available + ") no dispatch: mState:" + spatStateString(this.mState));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L27:
        this.mState = 6;     // Catch: Throwable -> L10
    L28:
        loglogi("setDispatchAvailableState(" + available + ") mState:" + spatStateString(this.mState));     // Catch: Throwable -> L10
        int nbCallbacks = this.mStateCallbacks.beginBroadcast();     // Catch: Throwable -> L10
        int i = 0;
    L30:
        if (i >= nbCallbacks) goto L36;
        this.mStateCallbacks.getBroadcastItem(i).dispatchSpatializerAvailableChanged(available);     // Catch: Throwable -> L10 RemoteException -> L33
    L35:
        i = i + 1;     // Catch: Throwable -> L10
    L33:
        e = move-exception;
        Log.e(TAG, "Error in dispatchSpatializerEnabledChanged", e);     // Catch: Throwable -> L10
        goto L35
    L36:
        this.mStateCallbacks.finishBroadcast();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L43:
        throw new IllegalStateException("Should not update available state in state:" + this.mState);     // Catch: Throwable -> L10
    }

    private void createSpat() {
        if (this.mSpat != null) goto L31;
        this.mSpatCallback = new SpatializerCallback(this, null);
        this.mSpat = AudioSystem.getSpatializer(this.mSpatCallback);
        if (this.mSpat != null) goto L28;
        Log.e(TAG, "createSpat(): No Spatializer found");
        postReset();
        return;
    L28:
        int[] nativeMasks = this.mSpat.getSpatializedChannelMasks();     // Catch: Exception -> L12
        int i = 0;
    L10:
        if (i >= nativeMasks.length) goto L14;
        nativeMasks[i] = AudioFormat.convertNativeChannelMaskToOutMask(nativeMasks[i]);     // Catch: Exception -> L12
        i = i + 1;     // Catch: Exception -> L12
        goto L10
    L14:
        this.mSpatializedChannelMasks = Arrays.stream(nativeMasks).boxed().toList();     // Catch: Exception -> L12
    L26:
    L21:
        e = move-exception;
        Log.e(TAG, "Can't configure head tracking", e);
        this.mState = 1;
        this.mCapableSpatLevel = 0;
        this.mActualHeadTrackingMode = -2;
        return;
    L18:
        if (this.mIsHeadTrackingSupported == false) goto L32;
        this.mActualHeadTrackingMode = headTrackingModeTypeToSpatializerInt(this.mSpat.getActualHeadTrackingMode());     // Catch: RemoteException -> L21
        this.mSpat.registerHeadTrackingCallback(this.mSpatHeadTrackingCallback);     // Catch: RemoteException -> L21
        return;
    L32:
        return;
    L12:
        e = move-exception;
        Log.e(TAG, "Error calling getSpatializedChannelMasks", e);
        this.mSpatializedChannelMasks = Collections.emptyList();
        goto L26
    }

    private void releaseSpat() {
        if (this.mSpat == null) goto L17;
        this.mSpatCallback = null;
    L8:
        e = move-exception;
        Log.e(TAG, "Can't set release spatializer cleanly", e);
    L13:
        this.mSpat = null;
        return;
    L6:
        if (this.mIsHeadTrackingSupported == false) goto L10;
        this.mSpat.registerHeadTrackingCallback(null);     // Catch: RemoteException -> L8
    L10:
        this.mHeadTrackerAvailable = false;     // Catch: RemoteException -> L8
        this.mSpat.release();     // Catch: RemoteException -> L8
        goto L13
    }

    synchronized boolean canBeSpatialized(AudioAttributes attributes, AudioFormat format) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        switch(this.mState) {
            case 0: goto L21;
            case 1: goto L21;
            case 2: goto L6;
            case 3: goto L21;
            case 4: goto L21;
            default: goto L6;
        };     // Catch: Throwable -> L10
    L21:
        logd("canBeSpatialized false due to state:" + this.mState);     // Catch: Throwable -> L10
        monitor-exit(this);
        return false;
    L6:
        switch(attributes.getUsage()) {
            case 1: goto L13;
            case 14: goto L13;
            default: goto L7;
        };     // Catch: Throwable -> L10
    L7:
        logd("canBeSpatialized false due to usage:" + attributes.getUsage());     // Catch: Throwable -> L10
        monitor-exit(this);
        return false;
    L13:
        ArrayList<AudioDeviceAttributes> devices = getRoutingDevices(attributes);     // Catch: Throwable -> L10
        if (devices.isEmpty() == false) goto L18;
        logloge("canBeSpatialized got no device for " + attributes);     // Catch: Throwable -> L10
        monitor-exit(this);
        return false;
    L18:
        boolean able = canBeSpatializedOnDevice(attributes, format, devices);     // Catch: Throwable -> L10
        logd("canBeSpatialized usage:" + attributes.getUsage() + " format:" + format.toLogFriendlyString() + " returning " + able);     // Catch: Throwable -> L10
        monitor-exit(this);
        return able;
    }

    synchronized List<Integer> getSpatializedChannelMasks() {
        monitor-enter(this);
        List<Integer> r0 = this.mSpatializedChannelMasks;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void registerHeadTrackingModeCallback(ISpatializerHeadTrackingModeCallback callback) {
        monitor-enter(this);
        this.mHeadTrackingModeCallbacks.register(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void unregisterHeadTrackingModeCallback(ISpatializerHeadTrackingModeCallback callback) {
        monitor-enter(this);
        this.mHeadTrackingModeCallbacks.unregister(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void registerHeadTrackerAvailableCallback(ISpatializerHeadTrackerAvailableCallback cb, boolean register) {
        monitor-enter(this);
        if (register == false) goto L7;
        this.mHeadTrackerCallbacks.register(cb);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return;
    L7:
        this.mHeadTrackerCallbacks.unregister(cb);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    synchronized int[] getSupportedHeadTrackingModes() {
        monitor-enter(this);
        int[] r0 = this.mSupportedHeadTrackingModes;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int getActualHeadTrackingMode() {
        monitor-enter(this);
        int r0 = this.mActualHeadTrackingMode;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int getDesiredHeadTrackingMode() {
        monitor-enter(this);
        int r0 = this.mDesiredHeadTrackingMode;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void setGlobalTransform(float[] transform) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (transform.length != 6) goto L18;
        if (checkSpatializerForHeadTracking("setGlobalTransform") == true) goto L22;
        monitor-exit(this);
        return;
    L22:
        this.mSpat.setGlobalTransform(transform);     // Catch: Throwable -> L11 RemoteException -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        e = move-exception;
        Log.e(TAG, "Error calling setGlobalTransform", e);     // Catch: Throwable -> L11
        goto L15
    L18:
        throw new IllegalArgumentException("invalid array size" + transform.length);     // Catch: Throwable -> L11
    }

    synchronized void recenterHeadTracker() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (checkSpatializerForHeadTracking("recenterHeadTracker") == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        this.mSpat.recenterHeadTracker();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Error calling recenterHeadTracker", e);     // Catch: Throwable -> L9
        goto L13
    }

    synchronized void setDisplayOrientation(float displayOrientation) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (checkSpatializer("setDisplayOrientation") == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        this.mSpat.setDisplayOrientation(displayOrientation);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Error calling setDisplayOrientation", e);     // Catch: Throwable -> L9
        goto L13
    }

    synchronized void setFoldState(boolean folded) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (checkSpatializer("setFoldState") == true) goto L18;
        monitor-exit(this);
        return;
    L18:
        this.mSpat.setFoldState(folded);     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Error calling setFoldState", e);     // Catch: Throwable -> L9
        goto L13
    }

    synchronized void setDesiredHeadTrackingMode(int mode) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r3)
            java.lang.String r0 = "setDesiredHeadTrackingMode"
            boolean r0 = r3.checkSpatializerForHeadTracking(r0)     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto Lc
            monitor-exit(r3)
            return
        Lc:
            r0 = -1
            if (r4 == r0) goto L14
            r3.mDesiredHeadTrackingModeWhenEnabled = r4     // Catch: java.lang.Throwable -> L12
            goto L14
        L12:
            r4 = move-exception
            goto L54
        L14:
            int r0 = r3.mDesiredHeadTrackingMode     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            if (r0 == r4) goto L20
            r3.mDesiredHeadTrackingMode = r4     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            r3.dispatchDesiredHeadTrackingMode(r4)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            goto L20
        L1e:
            r0 = move-exception
            goto L4a
        L20:
            java.lang.String r0 = "AS.SpatializerHelper"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            r1.<init>()     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            java.lang.String r2 = "setDesiredHeadTrackingMode("
            r1.append(r2)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            java.lang.String r2 = android.media.Spatializer.headtrackingModeToString(r4)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            r1.append(r2)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            android.util.Log.i(r0, r1)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            android.media.ISpatializer r0 = r3.mSpat     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            byte r1 = spatializerIntToHeadTrackingModeType(r4)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            r0.setDesiredHeadTrackingMode(r1)     // Catch: java.lang.Throwable -> L12 android.os.RemoteException -> L1e
            goto L52
        L4a:
            java.lang.String r1 = "AS.SpatializerHelper"
            java.lang.String r2 = "Error calling setDesiredHeadTrackingMode"
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L12
        L52:
            monitor-exit(r3)
            return
        L54:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.audio.SpatializerHelper.setDesiredHeadTrackingMode(int):void");
    }

    synchronized void setHeadTrackerEnabled(boolean enabled, AudioDeviceAttributes ada) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsHeadTrackingSupported == true) goto L8;
        Log.v(TAG, "no headtracking support, ignoring setHeadTrackerEnabled to " + enabled + " for " + ada);     // Catch: Throwable -> L6
    L8:
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);     // Catch: Throwable -> L6
        if (deviceState != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (deviceState.hasHeadTracker() == true) goto L17;
        Log.e(TAG, "Called setHeadTrackerEnabled enabled:" + enabled + " device:" + ada + " on a device without headtracker");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L17:
        Log.i(TAG, "setHeadTrackerEnabled enabled:" + enabled + " device:" + ada);     // Catch: Throwable -> L6
        deviceState.setHeadTrackerEnabled(enabled);     // Catch: Throwable -> L6
        this.mDeviceBroker.postPersistAudioDeviceSettings();     // Catch: Throwable -> L6
        logDeviceState(deviceState, "setHeadTrackerEnabled");     // Catch: Throwable -> L6
        if (sRoutingDevices.isEmpty() == false) goto L22;
        logloge("setHeadTrackerEnabled: no device, bailing");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L22:
        AudioDeviceAttributes currentDevice = sRoutingDevices.get(0);     // Catch: Throwable -> L6
        if (currentDevice.getType() == ada.getType()) goto L25;
    L34:
        monitor-exit(this);
        return;
    L25:
        if (currentDevice.getAddress().equals(ada.getAddress()) == false) goto L34;
        if (enabled == false) goto L28;
        int r2 = this.mDesiredHeadTrackingModeWhenEnabled;     // Catch: Throwable -> L6
    L29:
        setDesiredHeadTrackingMode(r2);     // Catch: Throwable -> L6
        if (enabled == false) goto L34;
        if (this.mHeadTrackerAvailable == true) goto L34;
        postInitSensors();     // Catch: Throwable -> L6
        goto L34
    L28:
        r2 = -1;
        goto L29
    }

    synchronized boolean hasHeadTracker(AudioDeviceAttributes ada) {
        monitor-enter(this);
        boolean r1 = false;
        if (this.mIsHeadTrackingSupported == true) goto L10;
        Log.v(TAG, "no headtracking support, hasHeadTracker always false for " + ada);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L10:
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);     // Catch: Throwable -> L8
        if (deviceState != null) goto L13;
    L15:
        monitor-exit(this);
        return r1;
    L13:
        if (deviceState.hasHeadTracker() == false) goto L15;
        r1 = true;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized boolean setHasHeadTracker(AudioDeviceAttributes ada) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsHeadTrackingSupported == true) goto L10;
        Log.v(TAG, "no headtracking support, setHasHeadTracker always false for " + ada);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L10:
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);     // Catch: Throwable -> L8
        if (deviceState != null) goto L13;
        Log.e(TAG, "setHasHeadTracker: device not found for:" + ada);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L13:
        if (deviceState.hasHeadTracker() == true) goto L15;
        deviceState.setHasHeadTracker(true);     // Catch: Throwable -> L8
        this.mDeviceBroker.postPersistAudioDeviceSettings();     // Catch: Throwable -> L8
        logDeviceState(deviceState, "setHasHeadTracker");     // Catch: Throwable -> L8
    L15:
        boolean r1 = deviceState.isHeadTrackerEnabled();     // Catch: Throwable -> L8
        monitor-exit(this);
        return r1;
    }

    synchronized boolean isHeadTrackerEnabled(AudioDeviceAttributes ada) {
        monitor-enter(this);
        boolean r1 = false;
        if (this.mIsHeadTrackingSupported == true) goto L10;
        Log.v(TAG, "no headtracking support, isHeadTrackerEnabled always false for " + ada);     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L10:
        AdiDeviceState deviceState = findSACompatibleDeviceStateForAudioDeviceAttributes(ada);     // Catch: Throwable -> L8
        if (deviceState != null) goto L13;
    L18:
        monitor-exit(this);
        return r1;
    L13:
        if (deviceState.hasHeadTracker() == false) goto L18;
        if (deviceState.isHeadTrackerEnabled() == false) goto L18;
        r1 = true;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized boolean isHeadTrackerAvailable() {
        monitor-enter(this);
        boolean r0 = this.mHeadTrackerAvailable;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean checkSpatializer(String funcName) {
        switch(this.mState) {
            case 0: goto L11;
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L6;
            case 6: goto L6;
            default: goto L12;
        };
    L11:
        return false;
    L12:
        return true;
    L6:
        if (this.mSpat != null) goto L9;
        Log.e(TAG, "checkSpatializer(): called from " + funcName + "(), native spatializer should not be null in state: " + this.mState);
        postReset();
        return false;
    L9:
        return true;
    }

    private boolean checkSpatializerForHeadTracking(String funcName) {
        if (checkSpatializer(funcName) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mIsHeadTrackingSupported == false) goto L7;
        return true;
    }

    private void dispatchActualHeadTrackingMode(int newMode) {
        int nbCallbacks = this.mHeadTrackingModeCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbCallbacks) goto L9;
        this.mHeadTrackingModeCallbacks.getBroadcastItem(i).dispatchSpatializerActualHeadTrackingModeChanged(newMode);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Log.e(TAG, "Error in dispatchSpatializerActualHeadTrackingModeChanged(" + newMode + ")", e);
        goto L8
    L9:
        this.mHeadTrackingModeCallbacks.finishBroadcast();
    }

    private void dispatchDesiredHeadTrackingMode(int newMode) {
        int nbCallbacks = this.mHeadTrackingModeCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbCallbacks) goto L9;
        this.mHeadTrackingModeCallbacks.getBroadcastItem(i).dispatchSpatializerDesiredHeadTrackingModeChanged(newMode);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Log.e(TAG, "Error in dispatchSpatializerDesiredHeadTrackingModeChanged(" + newMode + ")", e);
        goto L8
    L9:
        this.mHeadTrackingModeCallbacks.finishBroadcast();
    }

    private void dispatchHeadTrackerAvailable(boolean available) {
        int nbCallbacks = this.mHeadTrackerCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbCallbacks) goto L9;
        this.mHeadTrackerCallbacks.getBroadcastItem(i).dispatchSpatializerHeadTrackerAvailable(available);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Log.e(TAG, "Error in dispatchSpatializerHeadTrackerAvailable(" + available + ")", e);
        goto L8
    L9:
        this.mHeadTrackerCallbacks.finishBroadcast();
    }

    synchronized void registerHeadToSoundstagePoseCallback(ISpatializerHeadToSoundStagePoseCallback callback) {
        monitor-enter(this);
        this.mHeadPoseCallbacks.register(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void unregisterHeadToSoundstagePoseCallback(ISpatializerHeadToSoundStagePoseCallback callback) {
        monitor-enter(this);
        this.mHeadPoseCallbacks.unregister(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void dispatchPoseUpdate(float[] pose) {
        int nbCallbacks = this.mHeadPoseCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbCallbacks) goto L9;
        this.mHeadPoseCallbacks.getBroadcastItem(i).dispatchPoseChanged(pose);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Log.e(TAG, "Error in dispatchPoseChanged", e);
        goto L8
    L9:
        this.mHeadPoseCallbacks.finishBroadcast();
    }

    synchronized void setEffectParameter(int key, byte[] value) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        switch(this.mState) {
            case 0: goto L20;
            case 1: goto L20;
            case 2: goto L24;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L24;
        };     // Catch: Throwable -> L11
    L24:
        this.mSpat.setParameter(key, value);     // Catch: Throwable -> L11 RemoteException -> L15
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Error in setParameter for key:" + key, e);     // Catch: Throwable -> L11
        goto L17
    L7:
        if (this.mSpat != null) goto L24;
        Log.e(TAG, "setParameter(" + key + "): null spatializer in state: " + this.mState);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L20:
        throw new IllegalStateException("Can't set parameter key:" + key + " without a spatializer");     // Catch: Throwable -> L11
    }

    synchronized void getEffectParameter(int key, byte[] value) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        switch(this.mState) {
            case 0: goto L20;
            case 1: goto L20;
            case 2: goto L24;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L24;
        };     // Catch: Throwable -> L11
    L24:
        this.mSpat.getParameter(key, value);     // Catch: Throwable -> L11 RemoteException -> L15
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Error in getParameter for key:" + key, e);     // Catch: Throwable -> L11
        goto L17
    L7:
        if (this.mSpat != null) goto L24;
        Log.e(TAG, "getParameter(" + key + "): null spatializer in state: " + this.mState);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L20:
        throw new IllegalStateException("Can't get parameter key:" + key + " without a spatializer");     // Catch: Throwable -> L11
    }

    synchronized int getOutput() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        switch(this.mState) {
            case 0: goto L21;
            case 1: goto L21;
            case 2: goto L25;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L7;
            default: goto L25;
        };     // Catch: Throwable -> L11
    L25:
        int r0 = this.mSpat.getOutput();     // Catch: Throwable -> L11 RemoteException -> L13
        monitor-exit(this);
        return r0;
    L13:
        e = move-exception;
        Log.e(TAG, "Error in getOutput", e);     // Catch: Throwable -> L11
        return 0;
    L7:
        if (this.mSpat != null) goto L25;
        throw new IllegalStateException("null Spatializer for getOutput");     // Catch: Throwable -> L11
    L21:
        throw new IllegalStateException("Can't get output without a spatializer");     // Catch: Throwable -> L11
    }

    synchronized void registerSpatializerOutputCallback(ISpatializerOutputCallback callback) {
        monitor-enter(this);
        this.mOutputCallbacks.register(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void unregisterSpatializerOutputCallback(ISpatializerOutputCallback callback) {
        monitor-enter(this);
        this.mOutputCallbacks.unregister(callback);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void dispatchOutputUpdate(int output) {
        int nbCallbacks = this.mOutputCallbacks.beginBroadcast();
        int i = 0;
    L3:
        if (i >= nbCallbacks) goto L9;
        this.mOutputCallbacks.getBroadcastItem(i).dispatchSpatializerOutputChanged(output);     // Catch: RemoteException -> L6
    L8:
        i = i + 1;
    L6:
        e = move-exception;
        Log.e(TAG, "Error in dispatchOutputUpdate", e);
        goto L8
    L9:
        this.mOutputCallbacks.finishBroadcast();
    }

    private void postInitSensors() {
        this.mAudioService.postInitSpatializerHeadTrackingSensors();
    }

    synchronized void onInitSensors() {
        monitor-enter(this);
        boolean r1 = false;
        if (this.mFeatureEnabled == true) goto L6;
    L10:
        boolean init = false;
    L12:
        if (init == false) goto L14;
        String action = "initializing";
    L16:
        if (this.mSpat != null) goto L21;
        logloge("not " + action + " sensors, null spatializer");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L21:
        if (this.mIsHeadTrackingSupported == true) goto L25;
        logloge("not " + action + " sensors, spatializer doesn't support headtracking");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L25:
        int headHandle = -1;
        int screenHandle = -1;
        SpatializerHelperIA r6 = null;
        if (init == false) goto L37;
        if (this.mSensorManager == null) goto L66;
    L35:
        headHandle = getHeadSensorHandleUpdateTracker();     // Catch: Throwable -> L8
        loglogi("head tracker sensor handle initialized to " + headHandle);     // Catch: Throwable -> L8
        screenHandle = getScreenSensorHandle();     // Catch: Throwable -> L8
        Log.i(TAG, "found screen sensor handle initialized to " + screenHandle);     // Catch: Throwable -> L8
    L64:
        Log.i(TAG, "setScreenSensor:" + screenHandle);     // Catch: Throwable -> L8 Exception -> L43
        this.mSpat.setScreenSensor(screenHandle);     // Catch: Throwable -> L8 Exception -> L43
    L68:
        Log.i(TAG, "setHeadSensor:" + headHandle);     // Catch: Throwable -> L8 Exception -> L54
        this.mSpat.setHeadSensor(headHandle);     // Catch: Throwable -> L8 Exception -> L54
        boolean r7 = this.mHeadTrackerAvailable;     // Catch: Throwable -> L8 Exception -> L54
        if (headHandle == (-1)) goto L48;
        boolean r8 = true;
    L49:
        if (r7 == r8) goto L59;
        if (headHandle == (-1)) goto L52;
        r1 = true;
    L52:
        this.mHeadTrackerAvailable = r1;     // Catch: Throwable -> L8 Exception -> L54
        dispatchHeadTrackerAvailable(this.mHeadTrackerAvailable);     // Catch: Throwable -> L8 Exception -> L54
    L59:
        setDesiredHeadTrackingMode(this.mDesiredHeadTrackingMode);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L48:
        r8 = false;
    L54:
        e = move-exception;
        Log.e(TAG, "Error calling setHeadSensor:" + headHandle, e);     // Catch: Throwable -> L8
    L43:
        e = move-exception;
        Log.e(TAG, "Error calling setScreenSensor:" + screenHandle, e);     // Catch: Throwable -> L8
        goto L68
    L66:
        this.mSensorManager = (SensorManager) this.mAudioService.mContext.getSystemService("sensor");     // Catch: Throwable -> L8 Exception -> L31
        this.mDynSensorCallback = new HelperDynamicSensorCallback(this, r6);     // Catch: Throwable -> L8 Exception -> L31
        this.mSensorManager.registerDynamicSensorCallback(this.mDynSensorCallback);     // Catch: Throwable -> L8 Exception -> L31
    L31:
        e = move-exception;
        Log.e(TAG, "Error with SensorManager, can't initialize sensors", e);     // Catch: Throwable -> L8
        this.mSensorManager = null;     // Catch: Throwable -> L8
        this.mDynSensorCallback = null;     // Catch: Throwable -> L8
        return;
    L37:
        if (this.mSensorManager == null) goto L64;
        if (this.mDynSensorCallback == null) goto L64;
        this.mSensorManager.unregisterDynamicSensorCallback(this.mDynSensorCallback);     // Catch: Throwable -> L8
        this.mSensorManager = null;     // Catch: Throwable -> L8
        this.mDynSensorCallback = null;     // Catch: Throwable -> L8
        goto L64
    L14:
        action = "releasing";
        goto L16
    L6:
        if (this.mSpatLevel == 0) goto L10;
        init = true;
    L8:
        th = move-exception;
        throw th;
    }

    private static int headTrackingModeTypeToSpatializerInt(byte mode) {
        switch(mode) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return 2;
    L7:
        return 1;
    L9:
        return -1;
    L11:
        return 0;
    L4:
        throw new IllegalArgumentException("Unexpected head tracking mode:" + mode);
    }

    private static byte spatializerIntToHeadTrackingModeType(int sdkMode) {
        switch(sdkMode) {
            case -1: goto L11;
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 0;
    L11:
        return 1;
    L4:
        throw new IllegalArgumentException("Unexpected head tracking mode:" + sdkMode);
    }

    private static int spatializationLevelToSpatializerInt(byte level) {
        switch(level) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return 2;
    L7:
        return 1;
    L9:
        return 0;
    L4:
        throw new IllegalArgumentException("Unexpected spatializer level:" + level);
    }

    void dump(PrintWriter pw) {
        pw.println("SpatializerHelper:");
        pw.println("\tmState:" + this.mState);
        pw.println("\tmSpatLevel:" + this.mSpatLevel);
        pw.println("\tmCapableSpatLevel:" + this.mCapableSpatLevel);
        List<Integer> speakerMasks = getSpatializedChannelMasks();
        if (speakerMasks.isEmpty() == false) goto L5;
        StringBuilder masks = new StringBuilder("none");
    L6:
        Iterator<Integer> r2 = speakerMasks.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Integer mask = r2.next();
        masks.append(AudioFormat.javaChannelOutMaskToString(mask.intValue()));
        masks.append(" ");
        goto L8
    L10:
        pw.println("\tspatialized speaker masks: " + masks);
        pw.println("\tmIsHeadTrackingSupported:" + this.mIsHeadTrackingSupported);
        StringBuilder modesString = new StringBuilder();
        int[] r3 = this.mSupportedHeadTrackingModes;
        int r5 = r3.length;
        int r6 = 0;
    L11:
        if (r6 >= r5) goto L13;
        int mode = r3[r6];
        modesString.append(Spatializer.headtrackingModeToString(mode));
        modesString.append(" ");
        r6 = r6 + 1;
        goto L11
    L13:
        pw.println("\tsupported head tracking modes:" + modesString);
        pw.println("\tmDesiredHeadTrackingMode:" + Spatializer.headtrackingModeToString(this.mDesiredHeadTrackingMode));
        pw.println("\tmActualHeadTrackingMode:" + Spatializer.headtrackingModeToString(this.mActualHeadTrackingMode));
        pw.println("\theadtracker available:" + this.mHeadTrackerAvailable);
        pw.println("\tsupports binaural:" + this.mBinauralSupported + " / transaural:" + this.mTransauralSupported);
        StringBuilder r4 = new StringBuilder();
        r4.append("\tmSpatOutput:");
        r4.append(this.mSpatOutput);
        pw.println(r4.toString());
        pw.println("\thas FEATURE_AUDIO_SPATIAL_HEADTRACKING_LOW_LATENCY:" + this.mAudioService.mContext.getPackageManager().hasSystemFeature("android.hardware.audio.spatial.headtracking.low_latency"));
        return;
    L5:
        masks = new StringBuilder("");
        goto L6
    }

    private static String spatStateString(int state) {
        switch(state) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L3;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return "invalid state";
    L5:
        return "STATE_DISABLED_AVAILABLE";
    L7:
        return "STATE_ENABLED_AVAILABLE";
    L9:
        return "STATE_ENABLED_UNAVAILABLE";
    L11:
        return "STATE_DISABLED_UNAVAILABLE";
    L13:
        return "STATE_NOT_SUPPORTED";
    L15:
        return "STATE_UNINITIALIZED";
    }

    private int getHeadSensorHandleUpdateTracker() {
        Sensor htSensor = null;
        if (sRoutingDevices.isEmpty() == false) goto L6;
        logloge("getHeadSensorHandleUpdateTracker: no device, no head tracker");
        return -1;
    L6:
        AudioDeviceAttributes currentDevice = sRoutingDevices.get(0);
        List<String> deviceAddresses = this.mAudioService.getDeviceIdentityAddresses(currentDevice);
        List<Sensor> sensors = this.mSensorManager.getDynamicSensorList(37);
        Iterator<String> r5 = deviceAddresses.iterator();
    L8:
        if (r5.hasNext() == false) goto L36;
        String address = r5.next();
        UUID routingDeviceUuid = UuidUtils.uuidFromAudioDeviceAttributes(new AudioDeviceAttributes(currentDevice.getInternalType(), address));
        Iterator<Sensor> r8 = sensors.iterator();
    L11:
        if (r8.hasNext() == false) goto L27;
        Sensor sensor = r8.next();
        UUID uuid = sensor.getUuid();
        if (uuid.equals(routingDeviceUuid) == false) goto L22;
        htSensor = sensor;
        HeadtrackerInfo info = new HeadtrackerInfo(sensor);
        if (AudioSystem.isBluetoothLeDevice(currentDevice.getInternalType()) == false) goto L20;
        if (info.getMajorVersion() != 2) goto L22;
    L20:
        if (info.getMajorVersion() == 1) goto L27;
    L22:
        if (htSensor != null) goto L11;
        if (uuid.equals(UuidUtils.STANDALONE_UUID) == false) goto L11;
        htSensor = sensor;
    L27:
        if (htSensor == null) goto L8;
        if (htSensor.getUuid().equals(UuidUtils.STANDALONE_UUID) == true) goto L36;
        if (setHasHeadTracker(currentDevice) == true) goto L36;
        htSensor = null;
    L36:
        if (htSensor != null) goto L38;
        return -1;
    L38:
        return htSensor.getHandle();
    }

    private int getScreenSensorHandle() {
        Sensor screenSensor = this.mSensorManager.getDefaultSensor(11);
        if (screenSensor == null) goto L6;
        int screenHandle = screenSensor.getHandle();
        return screenHandle;
    L6:
        return -1;
    }

    private ArrayList<AudioDeviceAttributes> getRoutingDevices(AudioAttributes aa) {
        ArrayList<AudioDeviceAttributes> devices = this.mASA.getDevicesForAttributes(aa, false);
        Iterator<AudioDeviceAttributes> r2 = devices.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        AudioDeviceAttributes ada = r2.next();
        if (ada != null) goto L4;
        return new ArrayList(0);
    L10:
        return devices;
    }

    private static void loglogi(String msg) {
        AudioService.sSpatialLogger.enqueueAndLog(msg, 0, TAG);
    }

    private static String logloge(String msg) {
        AudioService.sSpatialLogger.enqueueAndLog(msg, 1, TAG);
        return msg;
    }

    synchronized void forceStateForTest(int state) {
        monitor-enter(this);
        this.mState = state;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void initForTest(boolean hasBinaural, boolean hasTransaural) {
        monitor-enter(this);
        this.mBinauralSupported = hasBinaural;     // Catch: Throwable -> L6
        this.mTransauralSupported = hasTransaural;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
