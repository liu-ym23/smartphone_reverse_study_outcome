package com.android.server.hdmi;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.display.DeviceProductInfo;
import android.hardware.display.DisplayManager;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.HdmiHotplugEvent;
import android.hardware.hdmi.HdmiPortInfo;
import android.hardware.hdmi.IHdmiCecSettingChangeListener;
import android.hardware.hdmi.IHdmiCecVolumeControlFeatureListener;
import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.hdmi.IHdmiControlService;
import android.hardware.hdmi.IHdmiControlStatusChangeListener;
import android.hardware.hdmi.IHdmiDeviceEventListener;
import android.hardware.hdmi.IHdmiHotplugEventListener;
import android.hardware.hdmi.IHdmiInputChangeListener;
import android.hardware.hdmi.IHdmiMhlVendorCommandListener;
import android.hardware.hdmi.IHdmiRecordListener;
import android.hardware.hdmi.IHdmiSystemAudioModeChangeListener;
import android.hardware.hdmi.IHdmiVendorCommandListener;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.media.AudioAttributes;
import android.media.AudioDescriptor;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceVolumeManager;
import android.media.VolumeInfo;
import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.sysprop.HdmiProperties;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Display;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.SystemService;
import com.android.server.power.ShutdownThread;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiControlService extends SystemService {
    private static final List<Integer> ABSOLUTE_VOLUME_BEHAVIORS = null;
    static final AudioDeviceAttributes AUDIO_OUTPUT_DEVICE_HDMI = null;
    static final AudioDeviceAttributes AUDIO_OUTPUT_DEVICE_HDMI_ARC = null;
    static final AudioDeviceAttributes AUDIO_OUTPUT_DEVICE_HDMI_EARC = null;
    static final AudioDeviceAttributes AUDIO_OUTPUT_DEVICE_LINE_DIGITAL = null;
    private static final List<AudioDeviceAttributes> AVB_AUDIO_OUTPUT_DEVICES = null;
    static final int DEVICE_CLEANUP_TIMEOUT = 5000;
    private static final int EARC_TRIGGER_START_ARC_ACTION_DELAY = 500;
    private static final List<Integer> FULL_AND_ABSOLUTE_VOLUME_BEHAVIORS = null;
    private static final Locale HONG_KONG = null;
    private static final String HONG_KONG_HantLanguageTag = "zh-Hant-HK";
    private static final String HONG_KONG_YUE_HantLanguageTag = "yue-Hant-HK";
    static final int INITIATED_BY_BOOT_UP = 1;
    static final int INITIATED_BY_ENABLE_CEC = 0;
    static final int INITIATED_BY_ENABLE_EARC = 6;
    static final int INITIATED_BY_HOTPLUG = 4;
    static final int INITIATED_BY_SCREEN_ON = 2;
    static final int INITIATED_BY_SOUNDBAR_MODE = 5;
    static final int INITIATED_BY_WAKE_UP_MESSAGE = 3;
    private static final Locale MACAU = null;
    private static final String MACAU_HantLanguageTag = "zh-Hant-MO";
    static final String PERMISSION = "android.permission.HDMI_CEC";
    private static final List<AudioDeviceAttributes> PLAYBACK_AVB_AUDIO_OUTPUT_DEVICES = null;
    static final int STANDBY_SCREEN_OFF = 0;
    static final int STANDBY_SHUTDOWN = 1;
    static final AudioAttributes STREAM_MUSIC_ATTRIBUTES = null;
    private static final String TAG = "HdmiControlService";
    private static final String TAIWAN_HantLanguageTag = "zh-Hant-TW";
    private static final List<AudioDeviceAttributes> TV_AVB_AUDIO_OUTPUT_DEVICES = null;
    static final int WAKE_UP_BOOT_UP = 1;
    static final int WAKE_UP_SCREEN_ON = 0;
    private static final Map<String, String> sTerminologyToBibliographicMap = null;
    private AbsoluteVolumeChangedListener mAbsoluteVolumeChangedListener;

    @HdmiAnnotations.ServiceThreadOnly
    private int mActivePortId;
    protected final HdmiCecLocalDevice.ActiveSource mActiveSource;
    private boolean mAddressAllocated;
    private HdmiCecAtomWriter mAtomWriter;
    private Map<AudioDeviceAttributes, Integer> mAudioDeviceVolumeBehaviors;
    private AudioDeviceVolumeManagerWrapper mAudioDeviceVolumeManager;
    private AudioManagerWrapper mAudioManager;
    private HdmiCecController mCecController;
    private final List<Integer> mCecLocalDevices;
    private CecMessageBuffer mCecMessageBuffer;
    private int mCecVersion;
    private DeviceConfigWrapper mDeviceConfig;
    private final ArrayList<DeviceEventListenerRecord> mDeviceEventListenerRecords;
    private DisplayManager mDisplayManager;
    private IHdmiControlCallback mDisplayStatusCallback;
    private HdmiEarcController mEarcController;
    private boolean mEarcEnabled;
    private HdmiEarcLocalDevice mEarcLocalDevice;
    private int mEarcPortId;
    private boolean mEarcSupported;

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mEarcTxFeatureFlagEnabled;
    private final Handler mHandler;
    private HdmiCecConfig mHdmiCecConfig;
    private HdmiCecNetwork mHdmiCecNetwork;
    private final ArrayMap<String, RemoteCallbackList<IHdmiCecSettingChangeListener>> mHdmiCecSettingChangeListenerRecords;
    private int mHdmiCecVolumeControl;
    private final RemoteCallbackList<IHdmiCecVolumeControlFeatureListener> mHdmiCecVolumeControlFeatureListenerRecords;
    private final HdmiControlBroadcastReceiver mHdmiControlBroadcastReceiver;
    private int mHdmiControlEnabled;
    private final ArrayList<HdmiControlStatusChangeListenerRecord> mHdmiControlStatusChangeListenerRecords;
    private final ArrayList<HotplugEventListenerRecord> mHotplugEventListenerRecords;
    private InputChangeListenerRecord mInputChangeListenerRecord;
    private Looper mIoLooper;
    private final HandlerThread mIoThread;
    private boolean mIsCecAvailable;

    @HdmiAnnotations.ServiceThreadOnly
    private int mLastInputMhl;
    private final Object mLock;

    @HdmiAnnotations.ServiceThreadOnly
    private String mMenuLanguage;
    private HdmiMhlControllerStub mMhlController;
    private List<HdmiDeviceInfo> mMhlDevices;
    private boolean mMhlInputChangeEnabled;
    private final ArrayList<HdmiMhlVendorCommandListenerRecord> mMhlVendorCommandListenerRecords;

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mNumericSoundbarVolumeUiOnTvFeatureFlagEnabled;
    private IHdmiControlCallback mOtpCallbackPendingAddressAllocation;
    private PowerManagerWrapper mPowerManager;
    private PowerManagerInternalWrapper mPowerManagerInternal;
    protected HdmiCecPowerStatusController mPowerStatusController;
    private boolean mProhibitMode;
    private HdmiRecordListenerRecord mRecordListenerRecord;
    private final SelectRequestBuffer mSelectRequestBuffer;
    private final Executor mServiceThreadExecutor;
    private HdmiCecConfig.SettingChangeListener mSettingChangeListener;
    private final SettingsObserver mSettingsObserver;

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mSoundbarModeFeatureFlagEnabled;

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mStandbyMessageReceived;
    private int mStreamMusicMaxVolume;
    private boolean mSystemAudioActivated;
    private final ArrayList<SystemAudioModeChangeListenerRecord> mSystemAudioModeChangeListenerRecords;

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mTransitionFromArcToEarcTxEnabled;
    private TvInputManager mTvInputManager;
    private final ArrayList<VendorCommandListenerRecord> mVendorCommandListenerRecords;
    private WakeLockWrapper mWakeLock;

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mWakeUpMessageReceived;

    /* JADX INFO: renamed from: com.android.server.hdmi.HdmiControlService$34, reason: invalid class name */
    class AnonymousClass34 implements HdmiCecConfig.SettingChangeListener {
        final /* synthetic */ HdmiControlService this$0;

        public static /* synthetic */ void $r8$lambda$0I2VyMOtt3cUrQXGEunL8x9BKEw(AnonymousClass34 r0, String r1, IHdmiCecSettingChangeListener r2) {
            r0.lambda$onChange$0(r1, r2);
        }

        AnonymousClass34(HdmiControlService this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.hdmi.HdmiCecConfig.SettingChangeListener
        public void onChange(final String name) {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (HdmiControlService.m4349$$Nest$fgetmHdmiCecSettingChangeListenerRecords(this.this$0).containsKey(name) == true) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            ((RemoteCallbackList) HdmiControlService.m4349$$Nest$fgetmHdmiCecSettingChangeListenerRecords(this.this$0).get(name)).broadcast(new HdmiControlService$34$$ExternalSyntheticLambda0(this, name));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$onChange$0(String name, IHdmiCecSettingChangeListener listener) {
            HdmiControlService.m4393$$Nest$minvokeCecSettingChangeListenerLocked(this.this$0, name, listener);
        }
    }

    /* JADX INFO: renamed from: com.android.server.hdmi.HdmiControlService$38, reason: invalid class name */
    static /* synthetic */ class AnonymousClass38 {
        static final /* synthetic */ int[] $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values = null;

        static {
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values = new int[HdmiProperties.cec_device_types_values.values().length];
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.TV.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L40:
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.RECORDING_DEVICE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L30:
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.RESERVED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L28:
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.TUNER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L32:
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.PLAYBACK_DEVICE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L36:
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.AUDIO_SYSTEM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L42:
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.PURE_CEC_SWITCH.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L38:
            $SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[HdmiProperties.cec_device_types_values.VIDEO_PROCESSOR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
            return;
        }
    }

    class AbsoluteVolumeChangedListener implements AudioDeviceVolumeManager.OnAudioDeviceVolumeChangedListener {
        private HdmiCecLocalDevice mLocalDevice;
        private HdmiDeviceInfo mSystemAudioDevice;
        final /* synthetic */ HdmiControlService this$0;

        public static /* synthetic */ void $r8$lambda$KAvlIl7BsGr8ey2W1wBKmI7cYpU(AbsoluteVolumeChangedListener r0, VolumeInfo r1, int r2, int r3) {
            r0.lambda$onAudioDeviceVolumeChanged$0(r1, r2, r3);
        }

        /* synthetic */ AbsoluteVolumeChangedListener(HdmiControlService r1, HdmiCecLocalDevice r2, HdmiDeviceInfo r3, HdmiControlServiceIA r4) {
            this(r1, r2, r3);
        }

        private AbsoluteVolumeChangedListener(HdmiControlService this$0, HdmiCecLocalDevice localDevice, HdmiDeviceInfo systemAudioDevice) {
            this.this$0 = this$0;
            this.mLocalDevice = localDevice;
            this.mSystemAudioDevice = systemAudioDevice;
        }

        public void onAudioDeviceVolumeChanged(AudioDeviceAttributes audioDevice, final VolumeInfo volumeInfo) {
            final int localDeviceAddress = this.mLocalDevice.getDeviceInfo().getLogicalAddress();
            if (this.mSystemAudioDevice.getDeviceFeatures().getSetAudioVolumeLevelSupport() != 1) goto L5;
            this.this$0.sendCecCommand(SetAudioVolumeLevelMessage.build(localDeviceAddress, this.mSystemAudioDevice.getLogicalAddress(), volumeInfo.getVolumeIndex()), new HdmiControlService$AbsoluteVolumeChangedListener$$ExternalSyntheticLambda0(this, volumeInfo, localDeviceAddress));
            return;
        L5:
            if (this.this$0.isTvDevice() == false) goto L7;
            HdmiCecLocalDevice avbDevice = this.this$0.tv();
        L8:
            avbDevice.updateAvbVolume(volumeInfo.getVolumeIndex());
            this.this$0.sendCecCommand(HdmiCecMessageBuilder.buildGiveAudioStatus(localDeviceAddress, this.mSystemAudioDevice.getLogicalAddress()));
            return;
        L7:
            avbDevice = this.this$0.playback();
            goto L8
        }

        private /* synthetic */ void lambda$onAudioDeviceVolumeChanged$0(VolumeInfo volumeInfo, int localDeviceAddress, int errorCode) {
            if (errorCode == 0) goto L4;
            this.this$0.sendCecCommand(HdmiCecMessageBuilder.buildGiveAudioStatus(localDeviceAddress, this.mSystemAudioDevice.getLogicalAddress()));
            return;
        L4:
            if (this.this$0.isTvDevice() == false) goto L6;
            HdmiCecLocalDevice avbDevice = this.this$0.tv();
        L7:
            avbDevice.updateAvbVolume(volumeInfo.getVolumeIndex());
            return;
        L6:
            avbDevice = this.this$0.playback();
            goto L7
        }

        public void onAudioDeviceVolumeAdjusted(AudioDeviceAttributes audioDevice, VolumeInfo volumeInfo, int direction, int mode) {
            switch(direction) {
                case -100: goto L10;
                case -1: goto L9;
                case 0: goto L6;
                case 1: goto L4;
                case 100: goto L10;
                case 101: goto L10;
                default: goto L3;
            };
        L3:
            return;
        L4:
            int keyCode = 24;
        L12:
            switch(mode) {
                case 0: goto L16;
                case 1: goto L15;
                case 2: goto L14;
                default: goto L13;
            };
        L13:
            return;
        L14:
            this.mLocalDevice.sendVolumeKeyEvent(keyCode, false);
            return;
        L15:
            this.mLocalDevice.sendVolumeKeyEvent(keyCode, true);
            return;
        L16:
            this.mLocalDevice.sendVolumeKeyEvent(keyCode, true);
            this.mLocalDevice.sendVolumeKeyEvent(keyCode, false);
            return;
        L9:
            keyCode = 25;
            goto L12
        L10:
            keyCode = 164;
            goto L12
        L6:
            if (this.this$0.tv() == null) goto L18;
            this.this$0.tv().requestAndUpdateAvbAudioStatus();
            return;
        }
    }

    private final class BinderService extends IHdmiControlService.Stub {
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: $r8$lambda$WRe-8h7_GOrGRgga9uOHczOYE-I, reason: not valid java name */
        public static /* synthetic */ int m4410$r8$lambda$WRe8h7_GOrGRgga9uOHczOYEI(Integer r0) {
            return lambda$getAllowedCecSettingIntValues$0(r0);
        }

        /* synthetic */ BinderService(HdmiControlService r1, HdmiControlServiceIA r2) {
            this(r1);
        }

        private BinderService(HdmiControlService r1) {
            this.this$0 = r1;
        }

        public int[] getSupportedTypes() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            int[] localDevices = new int[HdmiControlService.m4338$$Nest$fgetmCecLocalDevices(this.this$0).size()];
            int i = 0;
        L4:
            if (i >= localDevices.length) goto L7;
            localDevices[i] = ((Integer) HdmiControlService.m4338$$Nest$fgetmCecLocalDevices(this.this$0).get(i)).intValue();
            i = i + 1;
            goto L4
        L7:
            return localDevices;
        }

        public HdmiDeviceInfo getActiveSource() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            return this.this$0.getActiveSource();
        }

        public void deviceSelect(final int deviceId, final IHdmiControlCallback callback) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass1(this, callback, deviceId));
        }

        public void portSelect(final int portId, final IHdmiControlCallback callback) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass2(this, callback, portId));
        }

        public void sendKeyEvent(final int deviceType, final int keyCode, final boolean isPressed) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass3(this, keyCode, isPressed, deviceType));
        }

        public void sendVolumeKeyEvent(final int deviceType, final int keyCode, final boolean isPressed) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass4(this, deviceType, keyCode, isPressed));
        }

        public void oneTouchPlay(final IHdmiControlCallback callback) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            int pid = Binder.getCallingPid();
            Slog.d(HdmiControlService.TAG, "Process pid: " + pid + " is calling oneTouchPlay.");
            this.this$0.runOnServiceThread(new AnonymousClass5(this, callback));
        }

        public void toggleAndFollowTvPower() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            int pid = Binder.getCallingPid();
            Slog.d(HdmiControlService.TAG, "Process pid: " + pid + " is calling toggleAndFollowTvPower.");
            this.this$0.runOnServiceThread(new AnonymousClass6(this));
        }

        public boolean shouldHandleTvPowerKey() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            return this.this$0.shouldHandleTvPowerKey();
        }

        public void queryDisplayStatus(final IHdmiControlCallback callback) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass7(this, callback));
        }

        public void addHdmiControlStatusChangeListener(IHdmiControlStatusChangeListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.addHdmiControlStatusChangeListener(listener);
        }

        public void removeHdmiControlStatusChangeListener(IHdmiControlStatusChangeListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4402$$Nest$mremoveHdmiControlStatusChangeListener(this.this$0, listener);
        }

        public void addHdmiCecVolumeControlFeatureListener(IHdmiCecVolumeControlFeatureListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.addHdmiCecVolumeControlFeatureListener(listener);
        }

        public void removeHdmiCecVolumeControlFeatureListener(IHdmiCecVolumeControlFeatureListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.removeHdmiControlVolumeControlStatusChangeListener(listener);
        }

        public void addHotplugEventListener(IHdmiHotplugEventListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4381$$Nest$maddHotplugEventListener(this.this$0, listener);
        }

        public void removeHotplugEventListener(IHdmiHotplugEventListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4403$$Nest$mremoveHotplugEventListener(this.this$0, listener);
        }

        public void addDeviceEventListener(IHdmiDeviceEventListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4379$$Nest$maddDeviceEventListener(this.this$0, listener);
        }

        public List<HdmiPortInfo> getPortInfo() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            if (this.this$0.getPortInfo() != null) goto L6;
            return Collections.emptyList();
        L6:
            return this.this$0.getPortInfo();
        }

        public boolean canChangeSystemAudioMode() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiCecLocalDeviceTv tv = this.this$0.tv();
            if (tv != null) goto L7;
            return false;
        L7:
            return tv.hasSystemAudioDevice();
        }

        public boolean getSystemAudioMode() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiCecLocalDeviceTv tv = this.this$0.tv();
            HdmiCecLocalDeviceAudioSystem audioSystem = this.this$0.audioSystem();
            if (tv != null) goto L5;
        L6:
            if (audioSystem != null) goto L8;
        L10:
            return false;
        L8:
            if (audioSystem.isSystemAudioActivated() == false) goto L10;
        L9:
            return true;
        L5:
            if (tv.isSystemAudioActivated() == true) goto L9;
            goto L6
        }

        public int getPhysicalAddress() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int r1 = HdmiControlService.m4348$$Nest$fgetmHdmiCecNetwork(this.this$0).getPhysicalAddress();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void setSystemAudioMode(final boolean enabled, final IHdmiControlCallback callback) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass8(this, callback, enabled));
        }

        public void addSystemAudioModeChangeListener(IHdmiSystemAudioModeChangeListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4382$$Nest$maddSystemAudioModeChangeListner(this.this$0, listener);
        }

        public void removeSystemAudioModeChangeListener(IHdmiSystemAudioModeChangeListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4404$$Nest$mremoveSystemAudioModeChangeListener(this.this$0, listener);
        }

        public void setInputChangeListener(IHdmiInputChangeListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4408$$Nest$msetInputChangeListener(this.this$0, listener);
        }

        public List<HdmiDeviceInfo> getInputDevices() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            return HdmiUtils.mergeToUnmodifiableList(HdmiControlService.m4348$$Nest$fgetmHdmiCecNetwork(this.this$0).getSafeExternalInputsLocked(), HdmiControlService.m4387$$Nest$mgetMhlDevicesLocked(this.this$0));
        }

        public List<HdmiDeviceInfo> getDeviceList() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            return HdmiControlService.m4348$$Nest$fgetmHdmiCecNetwork(this.this$0).getSafeCecDevicesLocked();
        }

        public void powerOffRemoteDevice(final int logicalAddress, final int powerStatus) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass9(this, logicalAddress, powerStatus));
        }

        public void powerOnRemoteDevice(final int logicalAddress, final int powerStatus) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass10(this, logicalAddress, powerStatus));
        }

        public void askRemoteDeviceToBecomeActiveSource(final int physicalAddress) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass11(this, physicalAddress));
        }

        public void setSystemAudioVolume(final int oldIndex, final int newIndex, final int maxIndex) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass12(this, oldIndex, newIndex, maxIndex));
        }

        public void setSystemAudioMute(final boolean mute) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass13(this, mute));
        }

        public void setArcMode(final boolean enabled) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass14(this, enabled));
        }

        public void setProhibitMode(boolean enabled) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            if (this.this$0.isTvDevice() == true) goto L5;
            return;
        L5:
            this.this$0.setProhibitMode(enabled);
        }

        public void addVendorCommandListener(IHdmiVendorCommandListener listener, int vendorId) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.addVendorCommandListener(listener, vendorId);
        }

        public void sendVendorCommand(final int deviceType, final int targetAddress, final byte[] params, final boolean hasVendorId) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass15(this, deviceType, hasVendorId, targetAddress, params));
        }

        public void sendStandby(final int deviceType, final int deviceId) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass16(this, deviceId, deviceType));
        }

        public void setHdmiRecordListener(IHdmiRecordListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4407$$Nest$msetHdmiRecordListener(this.this$0, listener);
        }

        public void startOneTouchRecord(final int recorderAddress, final byte[] recordSource) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass17(this, recorderAddress, recordSource));
        }

        public void stopOneTouchRecord(final int recorderAddress) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass18(this, recorderAddress));
        }

        public void startTimerRecording(final int recorderAddress, final int sourceType, final byte[] recordSource) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass19(this, recorderAddress, sourceType, recordSource));
        }

        public void clearTimerRecording(final int recorderAddress, final int sourceType, final byte[] recordSource) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass20(this, recorderAddress, sourceType, recordSource));
        }

        public void sendMhlVendorCommand(final int portId, final int offset, final int length, final byte[] data) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass21(this, portId, offset, length, data));
        }

        public void addHdmiMhlVendorCommandListener(IHdmiMhlVendorCommandListener listener) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            HdmiControlService.m4380$$Nest$maddHdmiMhlVendorCommandListener(this.this$0, listener);
        }

        public void setStandbyMode(final boolean isStandbyModeOn) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass22(this, isStandbyModeOn));
        }

        public void reportAudioStatus(final int deviceType, int volume, int maxVolume, boolean isMute) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass23(this, deviceType));
        }

        public void setSystemAudioModeOnForAudioOnlySource() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            this.this$0.runOnServiceThread(new AnonymousClass24(this));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            new HdmiControlShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
        }

        protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), HdmiControlService.TAG, writer) == true) goto L5;
            return;
        L5:
            IndentingPrintWriter pw = new IndentingPrintWriter(writer, "  ");
            Object r1 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r1);
            pw.println("mProhibitMode: " + HdmiControlService.m4362$$Nest$fgetmProhibitMode(this.this$0));     // Catch: Throwable -> L35
            monitor-exit(r1);     // Catch: Throwable -> L35
            pw.println("mPowerStatus: " + this.this$0.mPowerStatusController.getPowerStatus());
            pw.println("mIsCecAvailable: " + HdmiControlService.m4355$$Nest$fgetmIsCecAvailable(this.this$0));
            pw.println("mCecVersion: " + HdmiControlService.m4340$$Nest$fgetmCecVersion(this.this$0));
            pw.println("mIsAbsoluteVolumeBehaviorEnabled: " + this.this$0.isAbsoluteVolumeBehaviorEnabled());
            pw.println("System_settings:");
            pw.increaseIndent();
            pw.println("mMhlInputChangeEnabled: " + this.this$0.isMhlInputChangeEnabled());
            pw.println("mSystemAudioActivated: " + this.this$0.isSystemAudioActivated());
            pw.println("mHdmiCecVolumeControlEnabled: " + this.this$0.getHdmiCecVolumeControl());
            pw.decreaseIndent();
            pw.println("CEC settings:");
            pw.increaseIndent();
            HdmiCecConfig hdmiCecConfig = this.this$0.getHdmiCecConfig();
            List<String> allSettings = hdmiCecConfig.getAllSettings();
            Set<String> userSettings = new HashSet(hdmiCecConfig.getUserSettings());
            Iterator<String> r4 = allSettings.iterator();
        L11:
            if (r4.hasNext() == false) goto L27;
            String setting = r4.next();
            if (hdmiCecConfig.isStringValueType(setting) == true) goto L14;
            if (hdmiCecConfig.isIntValueType(setting) == false) goto L11;
            StringBuilder r6 = new StringBuilder();
            r6.append(setting);
            r6.append(" (int): ");
            r6.append(hdmiCecConfig.getIntValue(setting));
            r6.append(" (default: ");
            r6.append(hdmiCecConfig.getDefaultIntValue(setting));
            r6.append(")");
            if (userSettings.contains(setting) == false) goto L24;
            String r7 = " [modifiable]";
        L25:
            r6.append(r7);
            pw.println(r6.toString());
            goto L11
        L24:
            r7 = "";
            goto L25
        L14:
            StringBuilder r8 = new StringBuilder();
            r8.append(setting);
            r8.append(" (string): ");
            r8.append(hdmiCecConfig.getStringValue(setting));
            r8.append(" (default: ");
            r8.append(hdmiCecConfig.getDefaultStringValue(setting));
            r8.append(")");
            if (userSettings.contains(setting) == false) goto L17;
            String r9 = " [modifiable]";
        L18:
            r8.append(r9);
            pw.println(r8.toString());
            goto L11
        L17:
            r9 = "";
            goto L18
        L27:
            pw.decreaseIndent();
            pw.println("mMhlController: ");
            pw.increaseIndent();
            HdmiControlService.m4358$$Nest$fgetmMhlController(this.this$0).dump(pw);
            pw.decreaseIndent();
            pw.print("eARC local device: ");
            pw.increaseIndent();
            if (HdmiControlService.m4344$$Nest$fgetmEarcLocalDevice(this.this$0) != null) goto L30;
            pw.println("None. eARC is either disabled or not available.");
        L31:
            pw.decreaseIndent();
            HdmiControlService.m4348$$Nest$fgetmHdmiCecNetwork(this.this$0).dump(pw);
            if (HdmiControlService.m4337$$Nest$fgetmCecController(this.this$0) == null) goto L48;
            pw.println("mCecController: ");
            pw.increaseIndent();
            HdmiControlService.m4337$$Nest$fgetmCecController(this.this$0).dump(pw);
            pw.decreaseIndent();
            return;
        L48:
            return;
        L30:
            HdmiControlService.m4344$$Nest$fgetmEarcLocalDevice(this.this$0).dump(pw);
        L35:
            th = move-exception;
            throw th;
        }

        public boolean setMessageHistorySize(int newSize) {
            HdmiControlService.m4386$$Nest$menforceAccessPermission(this.this$0);
            if (HdmiControlService.m4337$$Nest$fgetmCecController(this.this$0) != null) goto L7;
            return false;
        L7:
            return HdmiControlService.m4337$$Nest$fgetmCecController(this.this$0).setMessageHistorySize(newSize);
        }

        public int getMessageHistorySize() {
            HdmiControlService.m4386$$Nest$menforceAccessPermission(this.this$0);
            if (HdmiControlService.m4337$$Nest$fgetmCecController(this.this$0) != null) goto L5;
            return 0;
        L5:
            return HdmiControlService.m4337$$Nest$fgetmCecController(this.this$0).getMessageHistorySize();
        }

        public void addCecSettingChangeListener(String name, IHdmiCecSettingChangeListener listener) {
            HdmiControlService.m4386$$Nest$menforceAccessPermission(this.this$0);
            HdmiControlService.m4378$$Nest$maddCecSettingChangeListener(this.this$0, name, listener);
        }

        public void removeCecSettingChangeListener(String name, IHdmiCecSettingChangeListener listener) {
            HdmiControlService.m4386$$Nest$menforceAccessPermission(this.this$0);
            HdmiControlService.m4401$$Nest$mremoveCecSettingChangeListener(this.this$0, name, listener);
        }

        public List<String> getUserCecSettings() {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            long token = Binder.clearCallingIdentity();
            List<String> r2 = this.this$0.getHdmiCecConfig().getUserSettings();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public List<String> getAllowedCecSettingStringValues(String name) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            long token = Binder.clearCallingIdentity();
            List<String> r2 = this.this$0.getHdmiCecConfig().getAllowedStringValues(name);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int[] getAllowedCecSettingIntValues(String name) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            long token = Binder.clearCallingIdentity();
            List<Integer> allowedValues = this.this$0.getHdmiCecConfig().getAllowedIntValues(name);     // Catch: Throwable -> L6
            int[] r3 = allowedValues.stream().mapToInt(new HdmiControlService$BinderService$$ExternalSyntheticLambda0()).toArray();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        private static /* synthetic */ int lambda$getAllowedCecSettingIntValues$0(Integer i) {
            return i.intValue();
        }

        public String getCecSettingStringValue(String name) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            long token = Binder.clearCallingIdentity();
            String r2 = this.this$0.getHdmiCecConfig().getStringValue(name);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setCecSettingStringValue(String name, String value) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            long token = Binder.clearCallingIdentity();
            this.this$0.getHdmiCecConfig().setStringValue(name, value);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getCecSettingIntValue(String name) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            long token = Binder.clearCallingIdentity();
            int r2 = this.this$0.getHdmiCecConfig().getIntValue(name);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setCecSettingIntValue(String name, int value) {
            HdmiControlService.m4390$$Nest$minitBinderCall(this.this$0);
            long token = Binder.clearCallingIdentity();
            this.this$0.getHdmiCecConfig().setIntValue(name, value);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }
    }

    private final class DeviceEventListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiDeviceEventListener mListener;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiDeviceEventListener m4411$$Nest$fgetmListener(DeviceEventListenerRecord r0) {
            return r0.mListener;
        }

        public DeviceEventListenerRecord(HdmiControlService r1, IHdmiDeviceEventListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            HdmiControlService.m4341$$Nest$fgetmDeviceEventListenerRecords(this.this$0).remove(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    interface DevicePollingCallback {
        void onPollingFinished(List<Integer> r1);
    }

    private class HdmiControlBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ HdmiControlService this$0;

        /* synthetic */ HdmiControlBroadcastReceiver(HdmiControlService r1, HdmiControlServiceIA r2) {
            this(r1);
        }

        private HdmiControlBroadcastReceiver(HdmiControlService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        @HdmiAnnotations.ServiceThreadOnly
        public void onReceive(Context context, Intent intent) {
            HdmiControlService.m4384$$Nest$massertRunOnServiceThread(this.this$0);
            boolean isReboot = SystemProperties.get(ShutdownThread.SHUTDOWN_ACTION_PROPERTY).contains("1");
            String r1 = intent.getAction();
            switch(r1.hashCode()) {
                case -2128145023: goto L15;
                case -1454123155: goto L12;
                case 158859398: goto L9;
                case 1947666138: goto L6;
                default: goto L17;
            };
        L17:
            byte r2 = -1;
        L18:
            switch(r2) {
                case 0: goto L31;
                case 1: goto L28;
                case 2: goto L24;
                case 3: goto L21;
                default: goto L44;
            };
        L24:
            String language = HdmiControlService.localeToMenuLanguage(Locale.getDefault());
            if (HdmiControlService.m4357$$Nest$fgetmMenuLanguage(this.this$0).equals(language) == true) goto L38;
            HdmiControlService.m4400$$Nest$monLanguageChanged(this.this$0, language);
            return;
        L38:
            return;
        L44:
            return;
        L21:
            if (this.this$0.isPowerOnOrTransient() == false) goto L35;
            if (isReboot == true) goto L36;
            this.this$0.onStandby(1);
            return;
        L36:
            return;
        L35:
            return;
        L28:
            if (this.this$0.isPowerStandbyOrTransient() == false) goto L40;
            this.this$0.onWakeUp(0);
            return;
        L40:
            return;
        L31:
            if (this.this$0.isPowerOnOrTransient() == false) goto L42;
            if (isReboot == true) goto L43;
            this.this$0.onStandby(0);
            return;
        L43:
            return;
        L42:
            return;
        L6:
            if (r1.equals("android.intent.action.ACTION_SHUTDOWN") == false) goto L17;
            r2 = 3;
            goto L18
        L9:
            if (r1.equals("android.intent.action.CONFIGURATION_CHANGED") == false) goto L17;
            r2 = 2;
            goto L18
        L12:
            if (r1.equals("android.intent.action.SCREEN_ON") == false) goto L17;
            r2 = 1;
            goto L18
        L15:
            if (r1.equals("android.intent.action.SCREEN_OFF") == false) goto L17;
            r2 = 0;
            goto L18
        }
    }

    private final class HdmiControlStatusChangeListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiControlStatusChangeListener mListener;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiControlStatusChangeListener m4412$$Nest$fgetmListener(HdmiControlStatusChangeListenerRecord r0) {
            return r0.mListener;
        }

        HdmiControlStatusChangeListenerRecord(HdmiControlService r1, IHdmiControlStatusChangeListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            HdmiControlService.m4352$$Nest$fgetmHdmiControlStatusChangeListenerRecords(this.this$0).remove(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof HdmiControlStatusChangeListenerRecord) == true) goto L6;
            return false;
        L6:
            if (obj != this) goto L8;
            return true;
        L8:
            HdmiControlStatusChangeListenerRecord other = (HdmiControlStatusChangeListenerRecord) obj;
            if (other.mListener == this.mListener) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }
    }

    private class HdmiMhlVendorCommandListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiMhlVendorCommandListener mListener;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiMhlVendorCommandListener m4413$$Nest$fgetmListener(HdmiMhlVendorCommandListenerRecord r0) {
            return r0.mListener;
        }

        public HdmiMhlVendorCommandListenerRecord(HdmiControlService r1, IHdmiMhlVendorCommandListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            HdmiControlService.m4359$$Nest$fgetmMhlVendorCommandListenerRecords(this.this$0).remove(this);
        }
    }

    private class HdmiRecordListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiRecordListener mListener;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiRecordListener m4414$$Nest$fgetmListener(HdmiRecordListenerRecord r0) {
            return r0.mListener;
        }

        public HdmiRecordListenerRecord(HdmiControlService r1, IHdmiRecordListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (HdmiControlService.m4363$$Nest$fgetmRecordListenerRecord(this.this$0) != this) goto L9;
            HdmiControlService.m4375$$Nest$fputmRecordListenerRecord(this.this$0, null);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    private final class HotplugEventListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiHotplugEventListener mListener;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiHotplugEventListener m4415$$Nest$fgetmListener(HotplugEventListenerRecord r0) {
            return r0.mListener;
        }

        public HotplugEventListenerRecord(HdmiControlService r1, IHdmiHotplugEventListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            HdmiControlService.m4353$$Nest$fgetmHotplugEventListenerRecords(this.this$0).remove(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof HotplugEventListenerRecord) == true) goto L6;
            return false;
        L6:
            if (obj != this) goto L8;
            return true;
        L8:
            HotplugEventListenerRecord other = (HotplugEventListenerRecord) obj;
            if (other.mListener == this.mListener) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }
    }

    private final class InputChangeListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiInputChangeListener mListener;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiInputChangeListener m4416$$Nest$fgetmListener(InputChangeListenerRecord r0) {
            return r0.mListener;
        }

        public InputChangeListenerRecord(HdmiControlService r1, IHdmiInputChangeListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (HdmiControlService.m4354$$Nest$fgetmInputChangeListenerRecord(this.this$0) != this) goto L9;
            HdmiControlService.m4371$$Nest$fputmInputChangeListenerRecord(this.this$0, null);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    interface SendMessageCallback {
        void onSendCompleted(int r1);
    }

    private class SettingsObserver extends ContentObserver {
        final /* synthetic */ HdmiControlService this$0;

        public SettingsObserver(HdmiControlService r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            String option = uri.getLastPathSegment();
            byte r2 = 1;
            boolean enabled = this.this$0.readBooleanSetting(option, true);
            switch(option.hashCode()) {
                case -1543071020: goto L12;
                case -1262529811: goto L9;
                case -885757826: goto L6;
                default: goto L14;
            };
        L14:
            r2 = -1;
        L15:
            switch(r2) {
                case 0: goto L19;
                case 1: goto L18;
                case 2: goto L17;
                default: goto L23;
            };
        L17:
            String deviceName = this.this$0.readStringSetting(option, Build.MODEL);
            HdmiControlService.m4406$$Nest$msetDisplayName(this.this$0, deviceName);
            return;
        L18:
            HdmiControlService.m4358$$Nest$fgetmMhlController(this.this$0).setOption(102, HdmiControlService.m4409$$Nest$smtoInt(enabled));
            return;
        L19:
            this.this$0.setMhlInputChangeEnabled(enabled);
            return;
        L23:
            return;
        L6:
            if (option.equals("mhl_power_charge_enabled") == false) goto L14;
        L9:
            if (option.equals("mhl_input_switching_enabled") == false) goto L14;
            r2 = 0;
            goto L15
        L12:
            if (option.equals("device_name") == false) goto L14;
            r2 = 2;
            goto L15
        }
    }

    private final class SystemAudioModeChangeListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiSystemAudioModeChangeListener mListener;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiSystemAudioModeChangeListener m4417$$Nest$fgetmListener(SystemAudioModeChangeListenerRecord r0) {
            return r0.mListener;
        }

        public SystemAudioModeChangeListenerRecord(HdmiControlService r1, IHdmiSystemAudioModeChangeListener listener) {
            this.this$0 = r1;
            this.mListener = listener;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            HdmiControlService.m4366$$Nest$fgetmSystemAudioModeChangeListenerRecords(this.this$0).remove(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    class VendorCommandListenerRecord implements IBinder.DeathRecipient {
        private final IHdmiVendorCommandListener mListener;
        private final int mVendorId;
        final /* synthetic */ HdmiControlService this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IHdmiVendorCommandListener m4418$$Nest$fgetmListener(VendorCommandListenerRecord r0) {
            return r0.mListener;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmVendorId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4419$$Nest$fgetmVendorId(VendorCommandListenerRecord r0) {
            return r0.mVendorId;
        }

        VendorCommandListenerRecord(HdmiControlService this$0, IHdmiVendorCommandListener listener, int vendorId) {
            this.this$0 = this$0;
            this.mListener = listener;
            this.mVendorId = vendorId;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = HdmiControlService.m4356$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            HdmiControlService.m4367$$Nest$fgetmVendorCommandListenerRecords(this.this$0).remove(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WakeReason {
    }

    /* JADX INFO: renamed from: $r8$lambda$4TGpcTfQ-0nycahPYw9eIU6kZAU, reason: not valid java name */
    public static /* synthetic */ void m4332$r8$lambda$4TGpcTfQ0nycahPYw9eIU6kZAU(HdmiControlService r0) {
        r0.lambda$updatePowerStatusOnInitializeCecComplete$0();
    }

    public static /* synthetic */ void $r8$lambda$IvTeXB55Gkwf58evruAI2Pj8MUI(int r0, IHdmiCecVolumeControlFeatureListener r1) {
        lambda$announceHdmiCecVolumeControlFeatureChange$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$P3HIkbYfYUGmhPTvOuww1u-33dU, reason: not valid java name */
    public static /* synthetic */ Integer m4333$r8$lambda$P3HIkbYfYUGmhPTvOuww1u33dU(HdmiProperties.cec_device_types_values r0) {
        return enumToIntDeviceType(r0);
    }

    public static /* synthetic */ void $r8$lambda$SFmjLm0i6A5mR2wKcIywsBrI9P4(HdmiControlService r0) {
        r0.bootCompleted();
    }

    /* JADX INFO: renamed from: $r8$lambda$rlSLA0-1wAjlGPGxvWXu0mxoFC4, reason: not valid java name */
    public static /* synthetic */ void m4334$r8$lambda$rlSLA01wAjlGPGxvWXu0mxoFC4(HdmiControlService r0) {
        r0.lambda$updatePowerStatusOnInitializeCecComplete$1();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivePortId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4335$$Nest$fgetmActivePortId(HdmiControlService r0) {
        return r0.mActivePortId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAddressAllocated, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4336$$Nest$fgetmAddressAllocated(HdmiControlService r0) {
        return r0.mAddressAllocated;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCecController, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiCecController m4337$$Nest$fgetmCecController(HdmiControlService r0) {
        return r0.mCecController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCecLocalDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4338$$Nest$fgetmCecLocalDevices(HdmiControlService r0) {
        return r0.mCecLocalDevices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCecMessageBuffer, reason: not valid java name */
    static /* bridge */ /* synthetic */ CecMessageBuffer m4339$$Nest$fgetmCecMessageBuffer(HdmiControlService r0) {
        return r0.mCecMessageBuffer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCecVersion, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4340$$Nest$fgetmCecVersion(HdmiControlService r0) {
        return r0.mCecVersion;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceEventListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m4341$$Nest$fgetmDeviceEventListenerRecords(HdmiControlService r0) {
        return r0.mDeviceEventListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayStatusCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IHdmiControlCallback m4342$$Nest$fgetmDisplayStatusCallback(HdmiControlService r0) {
        return r0.mDisplayStatusCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEarcController, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiEarcController m4343$$Nest$fgetmEarcController(HdmiControlService r0) {
        return r0.mEarcController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEarcLocalDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiEarcLocalDevice m4344$$Nest$fgetmEarcLocalDevice(HdmiControlService r0) {
        return r0.mEarcLocalDevice;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEarcPortId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4345$$Nest$fgetmEarcPortId(HdmiControlService r0) {
        return r0.mEarcPortId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEarcTxFeatureFlagEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4346$$Nest$fgetmEarcTxFeatureFlagEnabled(HdmiControlService r0) {
        return r0.mEarcTxFeatureFlagEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiCecConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiCecConfig m4347$$Nest$fgetmHdmiCecConfig(HdmiControlService r0) {
        return r0.mHdmiCecConfig;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiCecNetwork, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiCecNetwork m4348$$Nest$fgetmHdmiCecNetwork(HdmiControlService r0) {
        return r0.mHdmiCecNetwork;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiCecSettingChangeListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m4349$$Nest$fgetmHdmiCecSettingChangeListenerRecords(HdmiControlService r0) {
        return r0.mHdmiCecSettingChangeListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiCecVolumeControl, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4350$$Nest$fgetmHdmiCecVolumeControl(HdmiControlService r0) {
        return r0.mHdmiCecVolumeControl;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiControlEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4351$$Nest$fgetmHdmiControlEnabled(HdmiControlService r0) {
        return r0.mHdmiControlEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHdmiControlStatusChangeListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m4352$$Nest$fgetmHdmiControlStatusChangeListenerRecords(HdmiControlService r0) {
        return r0.mHdmiControlStatusChangeListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHotplugEventListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m4353$$Nest$fgetmHotplugEventListenerRecords(HdmiControlService r0) {
        return r0.mHotplugEventListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputChangeListenerRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputChangeListenerRecord m4354$$Nest$fgetmInputChangeListenerRecord(HdmiControlService r0) {
        return r0.mInputChangeListenerRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCecAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4355$$Nest$fgetmIsCecAvailable(HdmiControlService r0) {
        return r0.mIsCecAvailable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4356$$Nest$fgetmLock(HdmiControlService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMenuLanguage, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4357$$Nest$fgetmMenuLanguage(HdmiControlService r0) {
        return r0.mMenuLanguage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMhlController, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiMhlControllerStub m4358$$Nest$fgetmMhlController(HdmiControlService r0) {
        return r0.mMhlController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMhlVendorCommandListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m4359$$Nest$fgetmMhlVendorCommandListenerRecords(HdmiControlService r0) {
        return r0.mMhlVendorCommandListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOtpCallbackPendingAddressAllocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ IHdmiControlCallback m4360$$Nest$fgetmOtpCallbackPendingAddressAllocation(HdmiControlService r0) {
        return r0.mOtpCallbackPendingAddressAllocation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerWrapper m4361$$Nest$fgetmPowerManager(HdmiControlService r0) {
        return r0.mPowerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProhibitMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4362$$Nest$fgetmProhibitMode(HdmiControlService r0) {
        return r0.mProhibitMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecordListenerRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiRecordListenerRecord m4363$$Nest$fgetmRecordListenerRecord(HdmiControlService r0) {
        return r0.mRecordListenerRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSelectRequestBuffer, reason: not valid java name */
    static /* bridge */ /* synthetic */ SelectRequestBuffer m4364$$Nest$fgetmSelectRequestBuffer(HdmiControlService r0) {
        return r0.mSelectRequestBuffer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSoundbarModeFeatureFlagEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4365$$Nest$fgetmSoundbarModeFeatureFlagEnabled(HdmiControlService r0) {
        return r0.mSoundbarModeFeatureFlagEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemAudioModeChangeListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m4366$$Nest$fgetmSystemAudioModeChangeListenerRecords(HdmiControlService r0) {
        return r0.mSystemAudioModeChangeListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVendorCommandListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m4367$$Nest$fgetmVendorCommandListenerRecords(HdmiControlService r0) {
        return r0.mVendorCommandListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAddressAllocated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4368$$Nest$fputmAddressAllocated(HdmiControlService r0, boolean r1) {
        r0.mAddressAllocated = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayStatusCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4369$$Nest$fputmDisplayStatusCallback(HdmiControlService r0, IHdmiControlCallback r1) {
        r0.mDisplayStatusCallback = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEarcTxFeatureFlagEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4370$$Nest$fputmEarcTxFeatureFlagEnabled(HdmiControlService r0, boolean r1) {
        r0.mEarcTxFeatureFlagEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmInputChangeListenerRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4371$$Nest$fputmInputChangeListenerRecord(HdmiControlService r0, InputChangeListenerRecord r1) {
        r0.mInputChangeListenerRecord = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCecAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4372$$Nest$fputmIsCecAvailable(HdmiControlService r0, boolean r1) {
        r0.mIsCecAvailable = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNumericSoundbarVolumeUiOnTvFeatureFlagEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4373$$Nest$fputmNumericSoundbarVolumeUiOnTvFeatureFlagEnabled(HdmiControlService r0, boolean r1) {
        r0.mNumericSoundbarVolumeUiOnTvFeatureFlagEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOtpCallbackPendingAddressAllocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4374$$Nest$fputmOtpCallbackPendingAddressAllocation(HdmiControlService r0, IHdmiControlCallback r1) {
        r0.mOtpCallbackPendingAddressAllocation = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRecordListenerRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4375$$Nest$fputmRecordListenerRecord(HdmiControlService r0, HdmiRecordListenerRecord r1) {
        r0.mRecordListenerRecord = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSoundbarModeFeatureFlagEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4376$$Nest$fputmSoundbarModeFeatureFlagEnabled(HdmiControlService r0, boolean r1) {
        r0.mSoundbarModeFeatureFlagEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTransitionFromArcToEarcTxEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4377$$Nest$fputmTransitionFromArcToEarcTxEnabled(HdmiControlService r0, boolean r1) {
        r0.mTransitionFromArcToEarcTxEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddCecSettingChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4378$$Nest$maddCecSettingChangeListener(HdmiControlService r0, String r1, IHdmiCecSettingChangeListener r2) {
        r0.addCecSettingChangeListener(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$maddDeviceEventListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4379$$Nest$maddDeviceEventListener(HdmiControlService r0, IHdmiDeviceEventListener r1) {
        r0.addDeviceEventListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maddHdmiMhlVendorCommandListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4380$$Nest$maddHdmiMhlVendorCommandListener(HdmiControlService r0, IHdmiMhlVendorCommandListener r1) {
        r0.addHdmiMhlVendorCommandListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maddHotplugEventListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4381$$Nest$maddHotplugEventListener(HdmiControlService r0, IHdmiHotplugEventListener r1) {
        r0.addHotplugEventListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maddSystemAudioModeChangeListner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4382$$Nest$maddSystemAudioModeChangeListner(HdmiControlService r0, IHdmiSystemAudioModeChangeListener r1) {
        r0.addSystemAudioModeChangeListner(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mannounceHdmiControlStatusChange, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4383$$Nest$mannounceHdmiControlStatusChange(HdmiControlService r0, int r1) {
        r0.announceHdmiControlStatusChange(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$massertRunOnServiceThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4384$$Nest$massertRunOnServiceThread(HdmiControlService r0) {
        r0.assertRunOnServiceThread();
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateDeviceInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiDeviceInfo m4385$$Nest$mcreateDeviceInfo(HdmiControlService r0, int r1, int r2, int r3, int r4) {
        return r0.createDeviceInfo(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceAccessPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4386$$Nest$menforceAccessPermission(HdmiControlService r0) {
        r0.enforceAccessPermission();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMhlDevicesLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4387$$Nest$mgetMhlDevicesLocked(HdmiControlService r0) {
        return r0.getMhlDevicesLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetRemoteControlSourceAddress, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4388$$Nest$mgetRemoteControlSourceAddress(HdmiControlService r0) {
        return r0.getRemoteControlSourceAddress();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSwitchDevice, reason: not valid java name */
    static /* bridge */ /* synthetic */ HdmiCecLocalDeviceSource m4389$$Nest$mgetSwitchDevice(HdmiControlService r0) {
        return r0.getSwitchDevice();
    }

    /* JADX INFO: renamed from: -$$Nest$minitBinderCall, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4390$$Nest$minitBinderCall(HdmiControlService r0) {
        r0.initBinderCall();
    }

    /* JADX INFO: renamed from: -$$Nest$minitializeCec, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4391$$Nest$minitializeCec(HdmiControlService r0, int r1) {
        r0.initializeCec(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minvokeCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4392$$Nest$minvokeCallback(HdmiControlService r0, IHdmiControlCallback r1, int r2) {
        r0.invokeCallback(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$minvokeCecSettingChangeListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4393$$Nest$minvokeCecSettingChangeListenerLocked(HdmiControlService r0, String r1, IHdmiCecSettingChangeListener r2) {
        r0.invokeCecSettingChangeListenerLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$minvokeHdmiControlStatusChangeListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4394$$Nest$minvokeHdmiControlStatusChangeListenerLocked(HdmiControlService r0, IHdmiControlStatusChangeListener r1, int r2) {
        r0.invokeHdmiControlStatusChangeListenerLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$minvokeHdmiControlStatusChangeListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4395$$Nest$minvokeHdmiControlStatusChangeListenerLocked(HdmiControlService r0, Collection r1, int r2, boolean r3) {
        r0.invokeHdmiControlStatusChangeListenerLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$minvokeHotplugEventListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4396$$Nest$minvokeHotplugEventListenerLocked(HdmiControlService r0, IHdmiHotplugEventListener r1, HdmiHotplugEvent r2) {
        r0.invokeHotplugEventListenerLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monDisableCec, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4397$$Nest$monDisableCec(HdmiControlService r0) {
        r0.onDisableCec();
    }

    /* JADX INFO: renamed from: -$$Nest$monDisableEarc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4398$$Nest$monDisableEarc(HdmiControlService r0) {
        r0.onDisableEarc();
    }

    /* JADX INFO: renamed from: -$$Nest$monInitializeCecComplete, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4399$$Nest$monInitializeCecComplete(HdmiControlService r0, int r1) {
        r0.onInitializeCecComplete(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monLanguageChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4400$$Nest$monLanguageChanged(HdmiControlService r0, String r1) {
        r0.onLanguageChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveCecSettingChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4401$$Nest$mremoveCecSettingChangeListener(HdmiControlService r0, String r1, IHdmiCecSettingChangeListener r2) {
        r0.removeCecSettingChangeListener(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveHdmiControlStatusChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4402$$Nest$mremoveHdmiControlStatusChangeListener(HdmiControlService r0, IHdmiControlStatusChangeListener r1) {
        r0.removeHdmiControlStatusChangeListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveHotplugEventListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4403$$Nest$mremoveHotplugEventListener(HdmiControlService r0, IHdmiHotplugEventListener r1) {
        r0.removeHotplugEventListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveSystemAudioModeChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4404$$Nest$mremoveSystemAudioModeChangeListener(HdmiControlService r0, IHdmiSystemAudioModeChangeListener r1) {
        r0.removeSystemAudioModeChangeListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mreportFeatures, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4405$$Nest$mreportFeatures(HdmiControlService r0, boolean r1) {
        r0.reportFeatures(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayName, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4406$$Nest$msetDisplayName(HdmiControlService r0, String r1) {
        r0.setDisplayName(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetHdmiRecordListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4407$$Nest$msetHdmiRecordListener(HdmiControlService r0, IHdmiRecordListener r1) {
        r0.setHdmiRecordListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetInputChangeListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4408$$Nest$msetInputChangeListener(HdmiControlService r0, IHdmiInputChangeListener r1) {
        r0.setInputChangeListener(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smtoInt, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4409$$Nest$smtoInt(boolean r0) {
        return toInt(r0);
    }

    static {
        HONG_KONG = new Locale("zh", "HK");
        MACAU = new Locale("zh", "MO");
        sTerminologyToBibliographicMap = createsTerminologyToBibliographicMap();
        AUDIO_OUTPUT_DEVICE_HDMI = new AudioDeviceAttributes(2, 9, "");
        AUDIO_OUTPUT_DEVICE_HDMI_ARC = new AudioDeviceAttributes(2, 10, "");
        AUDIO_OUTPUT_DEVICE_HDMI_EARC = new AudioDeviceAttributes(2, 29, "");
        AUDIO_OUTPUT_DEVICE_LINE_DIGITAL = new AudioDeviceAttributes(2, 6, "");
        AVB_AUDIO_OUTPUT_DEVICES = List.of(AUDIO_OUTPUT_DEVICE_HDMI, AUDIO_OUTPUT_DEVICE_HDMI_ARC, AUDIO_OUTPUT_DEVICE_HDMI_EARC, AUDIO_OUTPUT_DEVICE_LINE_DIGITAL);
        TV_AVB_AUDIO_OUTPUT_DEVICES = List.of(AUDIO_OUTPUT_DEVICE_HDMI_ARC, AUDIO_OUTPUT_DEVICE_HDMI_EARC, AUDIO_OUTPUT_DEVICE_LINE_DIGITAL);
        PLAYBACK_AVB_AUDIO_OUTPUT_DEVICES = List.of(AUDIO_OUTPUT_DEVICE_HDMI);
        ABSOLUTE_VOLUME_BEHAVIORS = List.of(3, 5);
        FULL_AND_ABSOLUTE_VOLUME_BEHAVIORS = List.of(1, 3, 5);
        STREAM_MUSIC_ATTRIBUTES = new AudioAttributes.Builder().setLegacyStreamType(3).build();
    }

    private static Map<String, String> createsTerminologyToBibliographicMap() {
        Map<String, String> temp = new HashMap();
        temp.put("sqi", "alb");
        temp.put("hye", "arm");
        temp.put("eus", "baq");
        temp.put("mya", "bur");
        temp.put("ces", "cze");
        temp.put("nld", "dut");
        temp.put("kat", "geo");
        temp.put("deu", "ger");
        temp.put("ell", "gre");
        temp.put("fra", "fre");
        temp.put("isl", "ice");
        temp.put("mkd", "mac");
        temp.put("mri", "mao");
        temp.put("msa", "may");
        temp.put("fas", "per");
        temp.put("ron", "rum");
        temp.put("slk", "slo");
        temp.put("bod", "tib");
        temp.put("cym", "wel");
        return Collections.unmodifiableMap(temp);
    }

    static String localeToMenuLanguage(Locale locale) {
        if (locale.equals(Locale.TAIWAN) == false) goto L5;
        return "chi";
    L5:
        if (locale.equals(HONG_KONG) == false) goto L7;
        return "chi";
    L7:
        if (locale.equals(MACAU) == false) goto L9;
        return "chi";
    L9:
        if (locale.toLanguageTag().equals(TAIWAN_HantLanguageTag) == false) goto L11;
        return "chi";
    L11:
        if (locale.toLanguageTag().equals(HONG_KONG_HantLanguageTag) == false) goto L13;
        return "chi";
    L13:
        if (locale.toLanguageTag().equals(HONG_KONG_YUE_HantLanguageTag) == false) goto L15;
        return "chi";
    L15:
        if (locale.toLanguageTag().equals(MACAU_HantLanguageTag) == true) goto L29;
        String language = locale.getISO3Language();
        if (sTerminologyToBibliographicMap.containsKey(language) == true) goto L20;
        return language;
    L20:
        return sTerminologyToBibliographicMap.get(language);
    L29:
        return "chi";
    }

    Executor getServiceThreadExecutor() {
        return this.mServiceThreadExecutor;
    }

    HdmiControlService(Context context, List<Integer> deviceTypes, AudioManagerWrapper audioManager, AudioDeviceVolumeManagerWrapper audioDeviceVolumeManager) {
        super(context);
        this.mServiceThreadExecutor = new AnonymousClass1(this);
        this.mActiveSource = new HdmiCecLocalDevice.ActiveSource();
        this.mSystemAudioActivated = false;
        this.mAudioDeviceVolumeBehaviors = new HashMap();
        this.mIoThread = new HandlerThread("Hdmi Control Io Thread");
        this.mLock = new Object();
        this.mHdmiControlStatusChangeListenerRecords = new ArrayList();
        this.mHdmiCecVolumeControlFeatureListenerRecords = new RemoteCallbackList();
        this.mHotplugEventListenerRecords = new ArrayList();
        this.mDeviceEventListenerRecords = new ArrayList();
        this.mVendorCommandListenerRecords = new ArrayList();
        this.mHdmiCecSettingChangeListenerRecords = new ArrayMap();
        this.mEarcPortId = -1;
        this.mSystemAudioModeChangeListenerRecords = new ArrayList();
        this.mHandler = new Handler();
        this.mHdmiControlBroadcastReceiver = new HdmiControlBroadcastReceiver(this, null);
        this.mDisplayStatusCallback = null;
        this.mOtpCallbackPendingAddressAllocation = null;
        this.mMenuLanguage = localeToMenuLanguage(Locale.getDefault());
        this.mStandbyMessageReceived = false;
        this.mWakeUpMessageReceived = false;
        this.mSoundbarModeFeatureFlagEnabled = false;
        this.mEarcTxFeatureFlagEnabled = false;
        this.mNumericSoundbarVolumeUiOnTvFeatureFlagEnabled = false;
        this.mTransitionFromArcToEarcTxEnabled = false;
        this.mActivePortId = -1;
        this.mMhlVendorCommandListenerRecords = new ArrayList();
        this.mLastInputMhl = -1;
        this.mAddressAllocated = false;
        this.mIsCecAvailable = false;
        this.mAtomWriter = new HdmiCecAtomWriter();
        this.mSelectRequestBuffer = new SelectRequestBuffer();
        this.mSettingChangeListener = new AnonymousClass34(this);
        this.mCecLocalDevices = deviceTypes;
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mHdmiCecConfig = new HdmiCecConfig(context);
        this.mDeviceConfig = new DeviceConfigWrapper();
        this.mAudioManager = audioManager;
        this.mAudioDeviceVolumeManager = audioDeviceVolumeManager;
    }

    public HdmiControlService(Context context) {
        super(context);
        this.mServiceThreadExecutor = new AnonymousClass1(this);
        this.mActiveSource = new HdmiCecLocalDevice.ActiveSource();
        this.mSystemAudioActivated = false;
        this.mAudioDeviceVolumeBehaviors = new HashMap();
        this.mIoThread = new HandlerThread("Hdmi Control Io Thread");
        this.mLock = new Object();
        this.mHdmiControlStatusChangeListenerRecords = new ArrayList();
        this.mHdmiCecVolumeControlFeatureListenerRecords = new RemoteCallbackList();
        this.mHotplugEventListenerRecords = new ArrayList();
        this.mDeviceEventListenerRecords = new ArrayList();
        this.mVendorCommandListenerRecords = new ArrayList();
        this.mHdmiCecSettingChangeListenerRecords = new ArrayMap();
        this.mEarcPortId = -1;
        this.mSystemAudioModeChangeListenerRecords = new ArrayList();
        this.mHandler = new Handler();
        this.mHdmiControlBroadcastReceiver = new HdmiControlBroadcastReceiver(this, null);
        this.mDisplayStatusCallback = null;
        this.mOtpCallbackPendingAddressAllocation = null;
        this.mMenuLanguage = localeToMenuLanguage(Locale.getDefault());
        this.mStandbyMessageReceived = false;
        this.mWakeUpMessageReceived = false;
        this.mSoundbarModeFeatureFlagEnabled = false;
        this.mEarcTxFeatureFlagEnabled = false;
        this.mNumericSoundbarVolumeUiOnTvFeatureFlagEnabled = false;
        this.mTransitionFromArcToEarcTxEnabled = false;
        this.mActivePortId = -1;
        this.mMhlVendorCommandListenerRecords = new ArrayList();
        this.mLastInputMhl = -1;
        this.mAddressAllocated = false;
        this.mIsCecAvailable = false;
        this.mAtomWriter = new HdmiCecAtomWriter();
        this.mSelectRequestBuffer = new SelectRequestBuffer();
        this.mSettingChangeListener = new AnonymousClass34(this);
        this.mCecLocalDevices = readDeviceTypes();
        this.mSettingsObserver = new SettingsObserver(this, this.mHandler);
        this.mHdmiCecConfig = new HdmiCecConfig(context);
        this.mDeviceConfig = new DeviceConfigWrapper();
    }

    protected List<HdmiProperties.cec_device_types_values> getCecDeviceTypes() {
        return HdmiProperties.cec_device_types();
    }

    protected List<Integer> getDeviceTypes() {
        return HdmiProperties.device_type();
    }

    protected List<Integer> readDeviceTypes() {
        List<HdmiProperties.cec_device_types_values> cecDeviceTypes = getCecDeviceTypes();
        if (cecDeviceTypes.isEmpty() == false) goto L5;
        List<Integer> deviceTypes = getDeviceTypes();
        if (deviceTypes.contains(null) == false) goto L13;
        Slog.w(TAG, "Error parsing ro.hdmi.device_type: " + SystemProperties.get("ro.hdmi.device_type"));
    L13:
        return (List) deviceTypes.stream().filter(new HdmiControlService$$ExternalSyntheticLambda4()).collect(Collectors.toList());
    L5:
        if (cecDeviceTypes.contains(null) == false) goto L8;
        Slog.w(TAG, "Error parsing ro.hdmi.cec_device_types: " + SystemProperties.get("ro.hdmi.cec_device_types"));
    L8:
        return (List) cecDeviceTypes.stream().map(new HdmiControlService$$ExternalSyntheticLambda3()).filter(new HdmiControlService$$ExternalSyntheticLambda4()).collect(Collectors.toList());
    }

    private static Integer enumToIntDeviceType(HdmiProperties.cec_device_types_values cecDeviceType) {
        if (cecDeviceType != null) goto L6;
        return null;
    L6:
        switch(AnonymousClass38.$SwitchMap$android$sysprop$HdmiProperties$cec_device_types_values[cecDeviceType.ordinal()]) {
            case 1: goto L24;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            default: goto L7;
        };
    L7:
        Slog.w(TAG, "Unrecognized device type in ro.hdmi.cec_device_types: " + cecDeviceType.getPropValue());
        return null;
    L10:
        return 7;
    L12:
        return 6;
    L14:
        return 5;
    L16:
        return 4;
    L18:
        return 3;
    L20:
        return 2;
    L22:
        return 1;
    L24:
        return 0;
    }

    protected static List<Integer> getIntList(String string) {
        ArrayList<Integer> list = new ArrayList();
        TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(',');
        splitter.setString(string);
        Iterator<String> r2 = splitter.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        String item = r2.next();
        list.add(Integer.valueOf(Integer.parseInt(item)));     // Catch: NumberFormatException -> L8
    L9:
        Slog.w(TAG, "Can't parseInt: " + item);
        goto L4
    L12:
        return Collections.unmodifiableList(list);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        initService();
        publishBinderService("hdmi_control", new BinderService(this, null));
        if (this.mCecController == null) goto L6;
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.ACTION_SHUTDOWN");
        filter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        getContext().registerReceiver(this.mHdmiControlBroadcastReceiver, filter);
        registerContentObserver();
    L6:
        if (this.mMhlController == null) goto L9;
        this.mMhlController.setOption(104, 1);
        return;
    }

    void initService() {
        if (this.mIoLooper != null) goto L6;
        this.mIoThread.start();
        this.mIoLooper = this.mIoThread.getLooper();
    L6:
        if (this.mPowerStatusController != null) goto L8;
        this.mPowerStatusController = new HdmiCecPowerStatusController(this);
    L8:
        this.mPowerStatusController.setPowerStatus(getInitialPowerStatus());
        setProhibitMode(false);
        if (isTvDevice() == true) goto L11;
    L13:
        this.mHdmiControlEnabled = this.mHdmiCecConfig.getIntValue("hdmi_cec_enabled");
        this.mSoundbarModeFeatureFlagEnabled = this.mDeviceConfig.getBoolean("enable_soundbar_mode", true);
        this.mEarcTxFeatureFlagEnabled = this.mDeviceConfig.getBoolean("enable_earc_tx", true);
        this.mTransitionFromArcToEarcTxEnabled = this.mDeviceConfig.getBoolean("transition_arc_to_earc_tx", true);
        this.mNumericSoundbarVolumeUiOnTvFeatureFlagEnabled = this.mDeviceConfig.getBoolean("enable_numeric_soundbar_volume_ui_on_tv", true);
        Object r1 = this.mLock;
        monitor-enter(r1);
    L22:
        th = move-exception;
        throw th;
    L16:
        if (this.mHdmiCecConfig.getIntValue("earc_enabled") != 1) goto L18;
        boolean r3 = true;
    L19:
        this.mEarcEnabled = r3;     // Catch: Throwable -> L22
        if (isTvDevice() == false) goto L24;
        this.mEarcEnabled &= this.mEarcTxFeatureFlagEnabled;     // Catch: Throwable -> L22
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L22
        setHdmiCecVolumeControlEnabledInternal(getHdmiCecConfig().getIntValue("volume_control_enabled"));
        this.mMhlInputChangeEnabled = readBooleanSetting("mhl_input_switching_enabled", true);
        if (this.mCecMessageBuffer != null) goto L29;
        this.mCecMessageBuffer = new CecMessageBuffer(this);
    L29:
        if (this.mCecController != null) goto L32;
        this.mCecController = HdmiCecController.create(this, getAtomWriter());
    L32:
        if (this.mCecController != null) goto L36;
        Slog.i(TAG, "Device does not support HDMI-CEC.");
        return;
    L36:
        if (this.mMhlController != null) goto L39;
        this.mMhlController = HdmiMhlControllerStub.create(this);
    L39:
        if (this.mMhlController.isReady() == true) goto L42;
        Slog.i(TAG, "Device does not support MHL-control.");
    L42:
        if (this.mEarcController != null) goto L45;
        this.mEarcController = HdmiEarcController.create(this);
    L45:
        if (this.mEarcController != null) goto L47;
        Slog.i(TAG, "Device does not support eARC.");
    L47:
        this.mHdmiCecNetwork = new HdmiCecNetwork(this, this.mCecController, this.mMhlController);
        if (isCecControlEnabled() == false) goto L50;
        initializeCec(1);
    L51:
        Object r4 = this.mLock;
        monitor-enter(r4);
        this.mMhlDevices = Collections.emptyList();     // Catch: Throwable -> L92
        monitor-exit(r4);     // Catch: Throwable -> L92
        this.mHdmiCecNetwork.initPortInfo();
        List<HdmiPortInfo> ports = getPortInfo();
        Object r5 = this.mLock;
        monitor-enter(r5);
        this.mEarcSupported = false;     // Catch: Throwable -> L65
        Iterator<HdmiPortInfo> r6 = ports.iterator();     // Catch: Throwable -> L65
    L59:
        if (r6.hasNext() == false) goto L70;
        HdmiPortInfo port = r6.next();     // Catch: Throwable -> L65
        boolean earcSupportedOnPort = port.isEarcSupported();     // Catch: Throwable -> L65
        if (earcSupportedOnPort == true) goto L63;
    L67:
        if (earcSupportedOnPort == false) goto L59;
        this.mEarcPortId = port.getId();     // Catch: Throwable -> L65
        this.mEarcSupported = earcSupportedOnPort;     // Catch: Throwable -> L65
        goto L59
    L63:
        if (this.mEarcSupported == false) goto L67;
        Slog.e(TAG, "HDMI eARC supported on more than 1 port.");     // Catch: Throwable -> L65
        this.mEarcSupported = false;     // Catch: Throwable -> L65
        this.mEarcPortId = -1;     // Catch: Throwable -> L65
    L70:
        boolean r7 = this.mEarcSupported;     // Catch: Throwable -> L65
        if (this.mEarcController == null) goto L73;
        boolean r8 = true;
    L74:
        this.mEarcSupported = r7 & r8;     // Catch: Throwable -> L65
        monitor-exit(r5);     // Catch: Throwable -> L65
        if (isEarcSupported() == true) goto L79;
    L82:
        this.mHdmiCecConfig.registerChangeListener("hdmi_cec_enabled", new AnonymousClass2(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("hdmi_cec_version", new AnonymousClass3(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("routing_control", new AnonymousClass4(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("system_audio_control", new AnonymousClass5(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("volume_control_enabled", new AnonymousClass6(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("tv_wake_on_one_touch_play", new AnonymousClass7(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("rc_profile_tv", new AnonymousClass8(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("rc_profile_source_handles_root_menu", new AnonymousClass9(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("rc_profile_source_handles_setup_menu", new AnonymousClass10(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("rc_profile_source_handles_contents_menu", new AnonymousClass11(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("rc_profile_source_handles_top_menu", new AnonymousClass12(this), this.mServiceThreadExecutor);
        this.mHdmiCecConfig.registerChangeListener("rc_profile_source_handles_media_context_sensitive_menu", new AnonymousClass13(this), this.mServiceThreadExecutor);
        if (isTvDevice() == false) goto L85;
        this.mDeviceConfig.addOnPropertiesChangedListener(getContext().getMainExecutor(), new AnonymousClass14(this));
    L85:
        this.mHdmiCecConfig.registerChangeListener("earc_enabled", new AnonymousClass15(this), this.mServiceThreadExecutor);
        this.mDeviceConfig.addOnPropertiesChangedListener(getContext().getMainExecutor(), new AnonymousClass16(this));
        this.mHdmiCecConfig.registerChangeListener("soundbar_mode", new AnonymousClass17(this), this.mServiceThreadExecutor);
        if (isPlaybackDevice() == false) goto L88;
        this.mHdmiCecConfig.registerChangeListener("power_state_change_on_active_source_lost", new AnonymousClass18(this), this.mServiceThreadExecutor);
    L88:
        this.mDeviceConfig.addOnPropertiesChangedListener(getContext().getMainExecutor(), new AnonymousClass19(this));
        this.mDeviceConfig.addOnPropertiesChangedListener(getContext().getMainExecutor(), new AnonymousClass20(this));
        return;
    L79:
        if (isEarcEnabled() == false) goto L81;
        initializeEarc(1);
        goto L82
    L81:
        setEarcEnabledInHal(false, false);
        goto L82
    L73:
        r8 = false;
    L65:
        th = move-exception;
        throw th;
    L92:
        th = move-exception;
        throw th;
    L50:
        this.mCecController.enableCec(false);
        goto L51
    L18:
        r3 = false;
        goto L19
    L11:
        if (getWasCecDisabledOnStandbyByLowEnergyMode() == false) goto L13;
        Slog.w(TAG, "Re-enable CEC on boot-up since it was disabled due to low energy  mode.");
        this.mHdmiCecConfig.setIntValue("hdmi_cec_enabled", 1);
        setWasCecDisabledOnStandbyByLowEnergyMode(false);
        goto L13
    }

    boolean isScreenOff() {
        if (this.mDisplayManager.getDisplay(0).getState() == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void bootCompleted() {
        if (this.mPowerManager.isInteractive() == true) goto L5;
        return;
    L5:
        if (isPowerStandbyOrTransient() == false) goto L14;
        this.mPowerStatusController.setPowerStatus(0);
        if (this.mAddressAllocated == false) goto L15;
        Iterator<HdmiCecLocalDevice> r0 = getAllCecLocalDevices().iterator();
    L10:
        if (r0.hasNext() == false) goto L16;
        HdmiCecLocalDevice localDevice = r0.next();
        localDevice.startQueuedActions();
        goto L10
    L16:
        return;
    L15:
        return;
    }

    private void reportFeatures(boolean isTvDeviceSetting) {
        if (getCecVersion() >= 6) goto L5;
        return;
    L5:
        if (isTvDeviceSetting == false) goto L10;
        if (isTvDeviceEnabled() == false) goto L16;
        tv().reportFeatures();
        return;
    L16:
        return;
    L10:
        if (isAudioSystemDevice() == false) goto L12;
        HdmiCecLocalDeviceSource source = audioSystem();
    L13:
        if (source == null) goto L18;
        source.reportFeatures();
        return;
    L18:
        return;
    L12:
        source = playback();
        goto L13
    }

    int getInitialPowerStatus() {
        return 3;
    }

    void setCecController(HdmiCecController cecController) {
        this.mCecController = cecController;
    }

    void setEarcController(HdmiEarcController earcController) {
        this.mEarcController = earcController;
    }

    void setHdmiCecNetwork(HdmiCecNetwork hdmiCecNetwork) {
        this.mHdmiCecNetwork = hdmiCecNetwork;
    }

    void setHdmiCecConfig(HdmiCecConfig hdmiCecConfig) {
        this.mHdmiCecConfig = hdmiCecConfig;
    }

    public HdmiCecNetwork getHdmiCecNetwork() {
        return this.mHdmiCecNetwork;
    }

    void setHdmiMhlController(HdmiMhlControllerStub hdmiMhlController) {
        this.mMhlController = hdmiMhlController;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L12;
        this.mDisplayManager = (DisplayManager) getContext().getSystemService(DisplayManager.class);
        this.mTvInputManager = (TvInputManager) getContext().getSystemService("tv_input");
        this.mPowerManager = new PowerManagerWrapper(getContext());
        this.mPowerManagerInternal = new PowerManagerInternalWrapper();
        if (this.mAudioManager != null) goto L7;
        this.mAudioManager = new DefaultAudioManagerWrapper(getContext());
    L7:
        this.mStreamMusicMaxVolume = getAudioManager().getStreamMaxVolume(3);
        if (this.mAudioDeviceVolumeManager != null) goto L10;
        this.mAudioDeviceVolumeManager = new DefaultAudioDeviceVolumeManagerWrapper(getContext());
    L10:
        getAudioDeviceVolumeManager().addOnDeviceVolumeBehaviorChangedListener(this.mServiceThreadExecutor, new HdmiControlService$$ExternalSyntheticLambda0(this));
        return;
    L12:
        if (phase != 1000) goto L16;
        runOnServiceThread(new HdmiControlService$$ExternalSyntheticLambda1(this));
        return;
    }

    TvInputManager getTvInputManager() {
        return this.mTvInputManager;
    }

    void registerTvInputCallback(TvInputManager.TvInputCallback callback) {
        if (this.mTvInputManager != null) goto L5;
        return;
    L5:
        this.mTvInputManager.registerCallback(callback, this.mHandler);
    }

    void unregisterTvInputCallback(TvInputManager.TvInputCallback callback) {
        if (this.mTvInputManager != null) goto L5;
        return;
    L5:
        this.mTvInputManager.unregisterCallback(callback);
    }

    void setDeviceConfig(DeviceConfigWrapper deviceConfig) {
        this.mDeviceConfig = deviceConfig;
    }

    void setPowerManager(PowerManagerWrapper powerManager) {
        this.mPowerManager = powerManager;
    }

    void setPowerManagerInternal(PowerManagerInternalWrapper powerManagerInternal) {
        this.mPowerManagerInternal = powerManagerInternal;
    }

    DeviceConfigWrapper getDeviceConfig() {
        return this.mDeviceConfig;
    }

    PowerManagerWrapper getPowerManager() {
        return this.mPowerManager;
    }

    PowerManagerInternalWrapper getPowerManagerInternal() {
        return this.mPowerManagerInternal;
    }

    public void setSoundbarMode(int settingValue) {
        boolean isArcSupported = isArcSupported();
        HdmiCecLocalDevicePlayback playback = playback();
        HdmiCecLocalDeviceAudioSystem audioSystem = audioSystem();
        HdmiCecAtomWriter r3 = getAtomWriter();
        if (settingValue != 1) goto L5;
        boolean r6 = true;
    L6:
        r3.dsmStatusChanged(isArcSupported, r6, 2);
        if (playback != null) goto L10;
        Slog.w(TAG, "Device type not compatible to change soundbar mode.");
        return;
    L10:
        if (isArcSupported == true) goto L13;
        Slog.w(TAG, "Device type doesn't support ARC.");
        return;
    L13:
        boolean isArcEnabled = false;
        if (settingValue != 0) goto L21;
        if (audioSystem == null) goto L21;
        isArcEnabled = audioSystem.isArcEnabled();
        if (isSystemAudioActivated() == false) goto L19;
        audioSystem.terminateSystemAudioMode();
    L19:
        if (isArcEnabled == false) goto L21;
        audioSystem.addAndStartAction(new ArcTerminationActionFromAvr(audioSystem, new AnonymousClass21(this)), true);
    L21:
        if (isArcEnabled == true) goto L24;
        this.mAddressAllocated = false;
        initializeCecLocalDevices(5);
        return;
    L24:
        return;
    L5:
        r6 = false;
        goto L6
    }

    public boolean isDeviceDiscoveryHandledByPlayback() {
        HdmiCecLocalDevicePlayback playback = playback();
        if (playback != null) goto L5;
        return false;
    L5:
        if (playback.hasAction(DeviceDiscoveryAction.class) == false) goto L7;
        return true;
    L7:
        if (playback.hasAction(HotplugDetectionAction.class) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private void onInitializeCecComplete(int initiatedBy) {
        updatePowerStatusOnInitializeCecComplete();
        this.mWakeUpMessageReceived = false;
        if (isTvDeviceEnabled() == false) goto L5;
        this.mCecController.enableWakeupByOtp(tv().getAutoWakeup());
    L5:
        int reason = -1;
        switch(initiatedBy) {
            case 0: goto L15;
            case 1: goto L14;
            case 2: goto L9;
            case 3: goto L8;
            default: goto L17;
        };
    L8:
        reason = 2;
        goto L17
    L9:
        reason = 2;
        List<HdmiCecLocalDevice> devices = getAllCecLocalDevices();
        Iterator<HdmiCecLocalDevice> r2 = devices.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        HdmiCecLocalDevice device = r2.next();
        device.onInitializeCecComplete(initiatedBy);
        goto L11
    L14:
        reason = 0;
        goto L17
    L15:
        reason = 1;
    L17:
        if (reason == (-1)) goto L21;
        invokeVendorCommandListenersOnControlStateChanged(true, reason);
        announceHdmiControlStatusChange(1);
        return;
    }

    private void updatePowerStatusOnInitializeCecComplete() {
        if (this.mPowerStatusController.isPowerStatusTransientToOn() == false) goto L6;
        this.mHandler.post(new HdmiControlService$$ExternalSyntheticLambda5(this));
        return;
    L6:
        if (this.mPowerStatusController.isPowerStatusTransientToStandby() == false) goto L10;
        this.mHandler.post(new HdmiControlService$$ExternalSyntheticLambda6(this));
        return;
    }

    private /* synthetic */ void lambda$updatePowerStatusOnInitializeCecComplete$0() {
        this.mPowerStatusController.setPowerStatus(0);
    }

    private /* synthetic */ void lambda$updatePowerStatusOnInitializeCecComplete$1() {
        this.mPowerStatusController.setPowerStatus(1);
    }

    private void registerContentObserver() {
        ContentResolver resolver = getContext().getContentResolver();
        String[] settings = {"mhl_input_switching_enabled", "mhl_power_charge_enabled", "device_name"};
        int r2 = settings.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        String s = settings[r4];
        resolver.registerContentObserver(Settings.Global.getUriFor(s), false, this.mSettingsObserver, -1);
        r4 = r4 + 1;
        goto L3
    }

    private static int toInt(boolean r0) {
        return r0 ? 1 : 0;
    }

    boolean readBooleanSetting(String key, boolean defVal) {
        ContentResolver cr = getContext().getContentResolver();
        if (Settings.Global.getInt(cr, key, toInt(defVal)) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    int readIntSetting(String key, int defVal) {
        ContentResolver cr = getContext().getContentResolver();
        return Settings.Global.getInt(cr, key, defVal);
    }

    void writeBooleanSetting(String key, boolean value) {
        ContentResolver cr = getContext().getContentResolver();
        Settings.Global.putInt(cr, key, toInt(value));
    }

    protected void writeStringSystemProperty(String key, String value) {
        SystemProperties.set(key, value);
    }

    boolean readBooleanSystemProperty(String key, boolean defVal) {
        return SystemProperties.getBoolean(key, defVal);
    }

    String readStringSetting(String key, String defVal) {
        ContentResolver cr = getContext().getContentResolver();
        String content = Settings.Global.getString(cr, key);
        if (TextUtils.isEmpty(content) == false) goto L5;
        return defVal;
    L5:
        return content;
    }

    void writeStringSetting(String key, String value) {
        ContentResolver cr = getContext().getContentResolver();
        Settings.Global.putString(cr, key, value);
    }

    private void initializeCec(int initiatedBy) {
        this.mAddressAllocated = false;
        int settingsCecVersion = getHdmiCecConfig().getIntValue("hdmi_cec_version");
        int supportedCecVersion = this.mCecController.getVersion();
        this.mCecVersion = Math.max(5, Math.min(settingsCecVersion, supportedCecVersion));
        this.mCecController.enableSystemCecControl(true);
        this.mCecController.setLanguage(this.mMenuLanguage);
        initializeCecLocalDevices(initiatedBy);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private List<Integer> getCecLocalDeviceTypes() {
        ArrayList<Integer> allLocalDeviceTypes = new ArrayList(this.mCecLocalDevices);
        if (isTvDevice() == false) goto L5;
    L13:
        return allLocalDeviceTypes;
    L5:
        if (isDsmEnabled() == false) goto L13;
        if (allLocalDeviceTypes.contains(5) == true) goto L13;
        if (isArcSupported() == false) goto L13;
        if (this.mSoundbarModeFeatureFlagEnabled == false) goto L13;
        allLocalDeviceTypes.add(5);
        goto L13
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void initializeCecLocalDevices(int initiatedBy) {
        assertRunOnServiceThread();
        ArrayList<HdmiCecLocalDevice> localDevices = new ArrayList();
        Iterator<Integer> r1 = getCecLocalDeviceTypes().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        int type = r1.next().intValue();
        HdmiCecLocalDevice localDevice = this.mHdmiCecNetwork.getLocalDevice(type);
        if (localDevice != null) goto L8;
        localDevice = HdmiCecLocalDevice.create(this, type);
    L8:
        localDevice.init();
        localDevices.add(localDevice);
        goto L4
    L9:
        this.mHdmiCecNetwork.clearDeviceList();
        allocateLogicalAddress(localDevices, initiatedBy);
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void allocateLogicalAddress(final ArrayList<HdmiCecLocalDevice> allocatingDevices, final int initiatedBy) {
        assertRunOnServiceThread();
        this.mCecController.clearLogicalAddress();
        final ArrayList<HdmiCecLocalDevice> allocatedDevices = new ArrayList();
        final int[] finished = new int[1];
        this.mAddressAllocated = allocatingDevices.isEmpty();
        this.mSelectRequestBuffer.clear();
        Iterator<HdmiCecLocalDevice> r0 = allocatingDevices.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        final HdmiCecLocalDevice localDevice = r0.next();
        this.mCecController.allocateLogicalAddress(localDevice.getType(), localDevice.getPreferredAddress(), new AnonymousClass22(this, localDevice, allocatedDevices, allocatingDevices, finished, initiatedBy));
        goto L4
    }

    @HdmiAnnotations.ServiceThreadOnly
    public void notifyAddressAllocated(ArrayList<HdmiCecLocalDevice> devices, int initiatedBy) {
        assertRunOnServiceThread();
        if (devices != null) goto L5;
    L15:
        Slog.w(TAG, "No local device to notify.");
        return;
    L5:
        if (devices.isEmpty() == true) goto L15;
        List<HdmiCecMessage> bufferedMessages = this.mCecMessageBuffer.getBuffer();
        Iterator<HdmiCecLocalDevice> r1 = devices.iterator();
    L9:
        if (r1.hasNext() == false) goto L12;
        HdmiCecLocalDevice device = r1.next();
        int address = device.getDeviceInfo().getLogicalAddress();
        device.handleAddressAllocated(address, bufferedMessages, initiatedBy);
        goto L9
    L12:
        if (isTvDeviceEnabled() == false) goto L18;
        tv().setSelectRequestBuffer(this.mSelectRequestBuffer);
        return;
    }

    boolean isAddressAllocated() {
        return this.mAddressAllocated;
    }

    List<HdmiPortInfo> getPortInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<HdmiPortInfo> r1 = this.mHdmiCecNetwork.getPortInfo();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    HdmiPortInfo getPortInfo(int portId) {
        return this.mHdmiCecNetwork.getPortInfo(portId);
    }

    int portIdToPath(int portId) {
        return this.mHdmiCecNetwork.portIdToPath(portId);
    }

    int pathToPortId(int path) {
        return this.mHdmiCecNetwork.physicalAddressToPortId(path);
    }

    boolean isValidPortId(int portId) {
        if (this.mHdmiCecNetwork.getPortInfo(portId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    protected Looper getIoLooper() {
        return this.mIoLooper;
    }

    void setIoLooper(Looper ioLooper) {
        this.mIoLooper = ioLooper;
    }

    void setCecMessageBuffer(CecMessageBuffer cecMessageBuffer) {
        this.mCecMessageBuffer = cecMessageBuffer;
    }

    List<HdmiCecMessage> getCecMessageWithOpcode(int opcode) {
        List<HdmiCecMessage> cecMessagesWithOpcode = new ArrayList();
        List<HdmiCecMessage> cecMessages = this.mCecMessageBuffer.getBuffer();
        Iterator<HdmiCecMessage> r2 = cecMessages.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        HdmiCecMessage message = r2.next();
        if (message.getOpcode() != opcode) goto L4;
        cecMessagesWithOpcode.add(message);
        goto L4
    L9:
        return cecMessagesWithOpcode;
    }

    protected Looper getServiceLooper() {
        return this.mHandler.getLooper();
    }

    int getPhysicalAddress() {
        return this.mHdmiCecNetwork.getPhysicalAddress();
    }

    int getVendorId() {
        return this.mCecController.getVendorId();
    }

    @HdmiAnnotations.ServiceThreadOnly
    HdmiDeviceInfo getDeviceInfo(int logicalAddress) {
        assertRunOnServiceThread();
        return this.mHdmiCecNetwork.getCecDeviceInfo(logicalAddress);
    }

    @HdmiAnnotations.ServiceThreadOnly
    HdmiDeviceInfo getDeviceInfoByPort(int port) {
        assertRunOnServiceThread();
        HdmiMhlLocalDeviceStub info = this.mMhlController.getLocalDevice(port);
        if (info != null) goto L5;
        return null;
    L5:
        return info.getInfo();
    }

    protected int getCecVersion() {
        return this.mCecVersion;
    }

    boolean isConnectedToArcPort(int physicalAddress) {
        return this.mHdmiCecNetwork.isConnectedToArcPort(physicalAddress);
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isConnected(int portId) {
        assertRunOnServiceThread();
        return this.mCecController.isConnected(portId);
    }

    void runOnServiceThread(Runnable runnable) {
        this.mHandler.post(new WorkSourceUidPreservingRunnable(runnable));
    }

    void runOnServiceThreadDelayed(Runnable runnable, long delay) {
        this.mHandler.postDelayed(new WorkSourceUidPreservingRunnable(runnable), delay);
    }

    private void assertRunOnServiceThread() {
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Should run on service thread.");
    }

    @HdmiAnnotations.ServiceThreadOnly
    void sendCecCommand(HdmiCecMessage command) {
        sendCecCommand(command, null);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void sendCecCommand(HdmiCecMessage command, SendMessageCallback callback) {
        switch(command.getOpcode()) {
            case 4: goto L6;
            case 13: goto L6;
            case 128: goto L6;
            case 130: goto L6;
            case 134: goto L6;
            case 157: goto L6;
            default: goto L4;
        };
    L4:
        sendCecCommandWithoutRetries(command, callback);
        return;
    L6:
        if (isTvDeviceEnabled() == false) goto L8;
        tv().removeAction(RequestActiveSourceAction.class);
    L8:
        sendCecCommandWithRetries(command, callback);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void sendCecCommandWithRetries(final HdmiCecMessage command, final SendMessageCallback callback) {
        assertRunOnServiceThread();
        List<HdmiCecLocalDevice> devices = getAllCecLocalDevices();
        if (devices.isEmpty() == false) goto L5;
        return;
    L5:
        final HdmiCecLocalDevice localDevice = devices.get(0);
        if (localDevice == null) goto L9;
        sendCecCommandWithoutRetries(command, new AnonymousClass23(this, localDevice, command, callback));
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void sendCecCommandWithoutRetries(HdmiCecMessage command, SendMessageCallback callback) {
        assertRunOnServiceThread();
        if (command.getValidationResult() == 0) goto L5;
    L7:
        HdmiLogger.error("Invalid message type:" + command, new Object[0]);
        if (callback == null) goto L12;
        callback.onSendCompleted(3);
        return;
    L12:
        return;
    L5:
        if (verifyPhysicalAddresses(command) == false) goto L7;
        this.mCecController.sendCommand(command, callback);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void maySendFeatureAbortCommand(HdmiCecMessage command, int reason) {
        assertRunOnServiceThread();
        this.mCecController.maySendFeatureAbortCommand(command, reason);
    }

    boolean verifyPhysicalAddresses(HdmiCecMessage message) {
        byte[] params = message.getParams();
        switch(message.getOpcode()) {
            case 112: goto L17;
            case 128: goto L10;
            case 129: goto L8;
            case 130: goto L8;
            case 132: goto L8;
            case 134: goto L8;
            case 157: goto L8;
            case 161: goto L6;
            case 162: goto L6;
            default: goto L4;
        };
    L4:
        return true;
    L6:
        return verifyExternalSourcePhysicalAddress(params, 7);
    L8:
        return verifyPhysicalAddress(params, 0);
    L10:
        if (verifyPhysicalAddress(params, 0) == false) goto L15;
        if (verifyPhysicalAddress(params, 2) == false) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (params.length != 0) goto L19;
        return true;
    L19:
        if (verifyPhysicalAddress(params, 0) == false) goto L22;
        return true;
    L22:
        return false;
    }

    private boolean verifyPhysicalAddress(byte[] params, int offset) {
        if (isTvDevice() == true) goto L6;
        return true;
    L6:
        if (params.length >= (offset + 2)) goto L8;
        return false;
    L8:
        int path = HdmiUtils.twoBytesToInt(params, offset);
        if (path != 65535) goto L11;
    L13:
        int portId = pathToPortId(path);
        if (portId != (-1)) goto L16;
        return false;
    L16:
        return true;
    L11:
        if (path != getPhysicalAddress()) goto L13;
        return true;
    }

    private boolean verifyExternalSourcePhysicalAddress(byte[] params, int offset) {
        int externalSourceSpecifier = params[offset];
        int offset2 = offset + 1;
        if (externalSourceSpecifier == 5) goto L5;
    L8:
        return true;
    L5:
        if ((params.length - offset2) < 2) goto L8;
        return verifyPhysicalAddress(params, offset2);
    }

    private boolean sourceAddressIsLocal(HdmiCecMessage message) {
        Iterator<HdmiCecLocalDevice> r0 = getAllCecLocalDevices().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        HdmiCecLocalDevice device = r0.next();
        if (message.getSource() != device.getDeviceInfo().getLogicalAddress()) goto L4;
        if (message.getSource() == 15) goto L4;
        HdmiLogger.warning("Unexpected source: message sent from device itself, " + message, new Object[0]);
        return true;
    L12:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleCecCommand(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int validationResult = message.getValidationResult();
        if (validationResult != 3) goto L5;
    L21:
        return 3;
    L5:
        if (validationResult == 5) goto L21;
        if (verifyPhysicalAddresses(message) == false) goto L21;
        if (validationResult == 0) goto L12;
    L20:
        return -1;
    L12:
        if (sourceAddressIsLocal(message) == true) goto L20;
        getHdmiCecNetwork().handleCecMessage(message);
        int handleMessageResult = dispatchMessageToLocalDevice(message);
        if (this.mAddressAllocated == false) goto L17;
    L19:
        return handleMessageResult;
    L17:
        if (this.mCecMessageBuffer.bufferMessage(message) == false) goto L19;
        return -1;
    }

    void enableAudioReturnChannel(int portId, boolean enabled) {
        if (this.mTransitionFromArcToEarcTxEnabled == true) goto L8;
        if (enabled == false) goto L8;
        if (this.mEarcController == null) goto L8;
        setEarcEnabledInHal(false, false);
    L8:
        this.mCecController.enableAudioReturnChannel(portId, enabled);
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int dispatchMessageToLocalDevice(HdmiCecMessage message) {
        assertRunOnServiceThread();
        Iterator<HdmiCecLocalDevice> r0 = this.mHdmiCecNetwork.getLocalDeviceList().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        HdmiCecLocalDevice device = r0.next();
        int messageResult = device.dispatchMessage(message);
        if (messageResult == (-2)) goto L4;
        if (message.getDestination() == 15) goto L4;
        return messageResult;
    L12:
        if (message.getDestination() != 15) goto L15;
        return -1;
    L15:
        HdmiLogger.warning("Unhandled cec command:" + message, new Object[0]);
        return -2;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void onHotplug(int portId, boolean connected) {
        assertRunOnServiceThread();
        this.mHdmiCecNetwork.initPortInfo();
        HdmiPortInfo portInfo = getPortInfo(portId);
        if (connected == true) goto L5;
    L17:
        Iterator<HdmiCecLocalDevice> r1 = this.mHdmiCecNetwork.getLocalDeviceList().iterator();
    L19:
        if (r1.hasNext() == false) goto L21;
        HdmiCecLocalDevice device = r1.next();
        device.onHotplug(portId, connected);
        goto L19
    L21:
        announceHotplugEvent(portId, connected);
        return;
    L5:
        if (isTvDevice() == true) goto L17;
        if (portInfo == null) goto L17;
        if (portInfo.getType() != 1) goto L17;
        ArrayList<HdmiCecLocalDevice> localDevices = new ArrayList();
        Iterator<Integer> r2 = getCecLocalDeviceTypes().iterator();
    L11:
        if (r2.hasNext() == false) goto L16;
        int type = r2.next().intValue();
        HdmiCecLocalDevice localDevice = this.mHdmiCecNetwork.getLocalDevice(type);
        if (localDevice != null) goto L15;
        localDevice = HdmiCecLocalDevice.create(this, type);
        localDevice.init();
    L15:
        localDevices.add(localDevice);
        goto L11
    L16:
        allocateLogicalAddress(localDevices, 4);
        goto L17
    }

    @HdmiAnnotations.ServiceThreadOnly
    void pollDevices(DevicePollingCallback callback, int sourceAddress, int pickStrategy, int retryCount, long pollingMessageInterval) {
        assertRunOnServiceThread();
        this.mCecController.pollDevices(callback, sourceAddress, checkPollStrategy(pickStrategy), retryCount, pollingMessageInterval);
    }

    private int checkPollStrategy(int pickStrategy) {
        int strategy = pickStrategy & 3;
        if (strategy == 0) goto L11;
        int iterationStrategy = 196608 & pickStrategy;
        if (iterationStrategy == 0) goto L9;
        return strategy | iterationStrategy;
    L9:
        throw new IllegalArgumentException("Invalid iteration strategy:" + pickStrategy);
    L11:
        throw new IllegalArgumentException("Invalid poll strategy:" + pickStrategy);
    }

    List<HdmiCecLocalDevice> getAllCecLocalDevices() {
        assertRunOnServiceThread();
        return this.mHdmiCecNetwork.getLocalDeviceList();
    }

    protected void checkLogicalAddressConflictAndReallocate(int logicalAddress, int physicalAddress) {
        if (physicalAddress != getPhysicalAddress()) goto L5;
        return;
    L5:
        Iterator<HdmiCecLocalDevice> r0 = getAllCecLocalDevices().iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        HdmiCecLocalDevice device = r0.next();
        if (device.getDeviceInfo().getLogicalAddress() != logicalAddress) goto L7;
        HdmiLogger.debug("allocate logical address for " + device.getDeviceInfo(), new Object[0]);
        ArrayList<HdmiCecLocalDevice> localDevices = new ArrayList();
        localDevices.add(device);
        allocateLogicalAddress(localDevices, 4);
        return;
    }

    Object getServiceLock() {
        return this.mLock;
    }

    void setAudioStatus(boolean mute, int volume) {
        if (isTvDeviceEnabled() == true) goto L5;
        return;
    L5:
        if (tv().isSystemAudioActivated() == true) goto L7;
        return;
    L7:
        if (getHdmiCecVolumeControl() == 0) goto L27;
        AudioManagerWrapper audioManager = getAudioManager();
        boolean muted = audioManager.isStreamMute(3);
        if (mute == false) goto L13;
        if (muted == true) goto L22;
        audioManager.setStreamMute(3, true);
        return;
    L22:
        return;
    L13:
        if (muted == false) goto L16;
        audioManager.setStreamMute(3, false);
    L16:
        if (volume >= 0) goto L18;
        return;
    L18:
        if (volume > 100) goto L25;
        Slog.i(TAG, "volume: " + volume);
        int flag = 1 | 256;
        audioManager.setStreamVolume(3, volume, flag);
        return;
    L25:
        return;
    }

    void announceSystemAudioModeChange(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<SystemAudioModeChangeListenerRecord> r1 = this.mSystemAudioModeChangeListenerRecords.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        SystemAudioModeChangeListenerRecord record = r1.next();     // Catch: Throwable -> L8
        invokeSystemAudioModeChangeLocked(SystemAudioModeChangeListenerRecord.m4417$$Nest$fgetmListener(record), enabled);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private HdmiDeviceInfo createDeviceInfo(int logicalAddress, int deviceType, int powerStatus, int cecVersion) {
        String displayName = readStringSetting("device_name", Build.MODEL);
        return HdmiDeviceInfo.cecDeviceBuilder().setLogicalAddress(logicalAddress).setPhysicalAddress(getPhysicalAddress()).setPortId(pathToPortId(getPhysicalAddress())).setDeviceType(deviceType).setVendorId(getVendorId()).setDisplayName(displayName).setDevicePowerStatus(powerStatus).setCecVersion(cecVersion).build();
    }

    private void setDisplayName(String newDisplayName) {
        Iterator<HdmiCecLocalDevice> r0 = getAllCecLocalDevices().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        HdmiCecLocalDevice device = r0.next();
        HdmiDeviceInfo deviceInfo = device.getDeviceInfo();
        if (deviceInfo.getDisplayName().equals(newDisplayName) == true) goto L4;
        device.setDeviceInfo(deviceInfo.toBuilder().setDisplayName(newDisplayName).build());
        sendCecCommand(HdmiCecMessageBuilder.buildSetOsdNameCommand(deviceInfo.getLogicalAddress(), 0, newDisplayName));
        goto L4
    }

    @HdmiAnnotations.ServiceThreadOnly
    void handleMhlHotplugEvent(int portId, boolean connected) {
        assertRunOnServiceThread();
        if (connected == false) goto L8;
        HdmiMhlLocalDeviceStub newDevice = new HdmiMhlLocalDeviceStub(this, portId);
        HdmiMhlLocalDeviceStub oldDevice = this.mMhlController.addLocalDevice(newDevice);
        if (oldDevice == null) goto L7;
        oldDevice.onDeviceRemoved();
        Slog.i(TAG, "Old device of port " + portId + " is removed");
    L7:
        invokeDeviceEventListeners(newDevice.getInfo(), 1);
        updateSafeMhlInput();
    L12:
        announceHotplugEvent(portId, connected);
        return;
    L8:
        HdmiMhlLocalDeviceStub device = this.mMhlController.removeLocalDevice(portId);
        if (device == null) goto L11;
        device.onDeviceRemoved();
        invokeDeviceEventListeners(device.getInfo(), 2);
        updateSafeMhlInput();
        goto L12
    L11:
        Slog.w(TAG, "No device to remove:[portId=" + portId);
        goto L12
    }

    @HdmiAnnotations.ServiceThreadOnly
    void handleMhlBusModeChanged(int portId, int busmode) {
        assertRunOnServiceThread();
        HdmiMhlLocalDeviceStub device = this.mMhlController.getLocalDevice(portId);
        if (device == null) goto L5;
        device.setBusMode(busmode);
        return;
    L5:
        Slog.w(TAG, "No mhl device exists for bus mode change[portId:" + portId + ", busmode:" + busmode + "]");
    }

    @HdmiAnnotations.ServiceThreadOnly
    void handleMhlBusOvercurrent(int portId, boolean on) {
        assertRunOnServiceThread();
        HdmiMhlLocalDeviceStub device = this.mMhlController.getLocalDevice(portId);
        if (device == null) goto L5;
        device.onBusOvercurrentDetected(on);
        return;
    L5:
        Slog.w(TAG, "No mhl device exists for bus overcurrent event[portId:" + portId + "]");
    }

    @HdmiAnnotations.ServiceThreadOnly
    void handleMhlDeviceStatusChanged(int portId, int adopterId, int deviceId) {
        assertRunOnServiceThread();
        HdmiMhlLocalDeviceStub device = this.mMhlController.getLocalDevice(portId);
        if (device == null) goto L5;
        device.setDeviceStatusChange(adopterId, deviceId);
        return;
    L5:
        Slog.w(TAG, "No mhl device exists for device status event[portId:" + portId + ", adopterId:" + adopterId + ", deviceId:" + deviceId + "]");
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void updateSafeMhlInput() {
        assertRunOnServiceThread();
        List<HdmiDeviceInfo> inputs = Collections.emptyList();
        SparseArray<HdmiMhlLocalDeviceStub> devices = this.mMhlController.getAllLocalDevices();
        int i = 0;
    L4:
        if (i >= devices.size()) goto L12;
        HdmiMhlLocalDeviceStub device = devices.valueAt(i);
        HdmiDeviceInfo info = device.getInfo();
        if (info == null) goto L11;
        if (inputs.isEmpty() == false) goto L10;
        inputs = new ArrayList();
    L10:
        inputs.add(device.getInfo());
    L11:
        i = i + 1;
        goto L4
    L12:
        Object r2 = this.mLock;
        monitor-enter(r2);
        this.mMhlDevices = inputs;     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private List<HdmiDeviceInfo> getMhlDevicesLocked() {
        return this.mMhlDevices;
    }

    private void setWorkSourceUidToCallingUid() {
        Binder.setCallingWorkSourceUid(Binder.getCallingUid());
    }

    private void enforceAccessPermission() {
        getContext().enforceCallingOrSelfPermission(PERMISSION, TAG);
    }

    private void initBinderCall() {
        enforceAccessPermission();
        setWorkSourceUidToCallingUid();
    }

    void setHdmiCecVolumeControlEnabledInternal(int hdmiCecVolumeControl) {
        this.mHdmiCecVolumeControl = hdmiCecVolumeControl;
        announceHdmiCecVolumeControlFeatureChange(hdmiCecVolumeControl);
        runOnServiceThread(new HdmiControlService$$ExternalSyntheticLambda2(this));
    }

    private int getRemoteControlSourceAddress() {
        if (isAudioSystemDevice() == false) goto L7;
        return audioSystem().getDeviceInfo().getLogicalAddress();
    L7:
        if (isPlaybackDevice() == true) goto L9;
        return 15;
    L9:
        return playback().getDeviceInfo().getLogicalAddress();
    }

    private HdmiCecLocalDeviceSource getSwitchDevice() {
        if (isAudioSystemDevice() == false) goto L7;
        return audioSystem();
    L7:
        if (isPlaybackDevice() == true) goto L9;
        return null;
    L9:
        return playback();
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void oneTouchPlay(IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        if (this.mAddressAllocated == true) goto L6;
        this.mOtpCallbackPendingAddressAllocation = callback;
        Slog.d(TAG, "Local device is under address allocation. Save OTP callback for later process.");
        return;
    L6:
        HdmiCecLocalDeviceSource source = playback();
        if (source != null) goto L9;
        source = audioSystem();
    L10:
        if (source != null) goto L13;
        Slog.w(TAG, "Local source device not available");
        invokeCallback(callback, 2);
        return;
    L13:
        source.oneTouchPlay(callback);
        return;
    L9:
        playback().mDelayedStandbyOnActiveSourceLostHandler.removeCallbacksAndMessages(null);
        playback().setIsActiveSourceLostPopupLaunched(false);
        goto L10
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void toggleAndFollowTvPower() {
        assertRunOnServiceThread();
        HdmiCecLocalDeviceSource source = playback();
        if (source != null) goto L5;
        source = audioSystem();
    L5:
        if (source != null) goto L8;
        Slog.w(TAG, "Local source device not available");
        return;
    L8:
        source.toggleAndFollowTvPower();
    }

    protected boolean shouldHandleTvPowerKey() {
        if (isTvDevice() == false) goto L5;
        return false;
    L5:
        String powerControlMode = getHdmiCecConfig().getStringValue("power_control_mode");
        if (powerControlMode.equals("none") == false) goto L8;
        return false;
    L8:
        int hdmiCecEnabled = getHdmiCecConfig().getIntValue("hdmi_cec_enabled");
        if (hdmiCecEnabled == 1) goto L12;
        return false;
    L12:
        return this.mIsCecAvailable;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void queryDisplayStatus(IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        if (this.mAddressAllocated == true) goto L6;
        this.mDisplayStatusCallback = callback;
        Slog.d(TAG, "Local device is under address allocation. Queue display callback for later process.");
        return;
    L6:
        HdmiCecLocalDeviceSource source = playback();
        if (source != null) goto L9;
        source = audioSystem();
    L9:
        if (source != null) goto L12;
        Slog.w(TAG, "Local source device not available");
        invokeCallback(callback, -1);
        return;
    L12:
        source.queryDisplayStatus(callback);
    }

    protected HdmiDeviceInfo getActiveSource() {
        if (playback() != null) goto L5;
    L8:
        HdmiCecLocalDevice.ActiveSource activeSource = getLocalActiveSource();
        if (activeSource.isValid() == false) goto L16;
        HdmiDeviceInfo activeSourceInfo = this.mHdmiCecNetwork.getSafeCecDeviceInfo(activeSource.logicalAddress);
        if (activeSourceInfo == null) goto L14;
        return activeSourceInfo;
    L14:
        return HdmiDeviceInfo.hardwarePort(activeSource.physicalAddress, pathToPortId(activeSource.physicalAddress));
    L16:
        if (tv() == null) goto L24;
        int activePath = tv().getActivePath();
        if (activePath == 65535) goto L27;
        HdmiDeviceInfo info = this.mHdmiCecNetwork.getSafeDeviceInfoByPath(activePath);
        if (info == null) goto L23;
        return info;
    L23:
        return HdmiDeviceInfo.hardwarePort(activePath, tv().getActivePortId());
    L27:
        return null;
    L24:
        return null;
    L5:
        if (playback().isActiveSource() == false) goto L8;
        return playback().getDeviceInfo();
    }

    void addHdmiControlStatusChangeListener(final IHdmiControlStatusChangeListener listener) {
        final HdmiControlStatusChangeListenerRecord record = new HdmiControlStatusChangeListenerRecord(this, listener);
        listener.asBinder().linkToDeath(record, 0);     // Catch: RemoteException -> L13
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mHdmiControlStatusChangeListenerRecords.add(record);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        runOnServiceThread(new AnonymousClass24(this, record, listener));
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        Slog.w(TAG, "Listener already died");
    }

    private void removeHdmiControlStatusChangeListener(IHdmiControlStatusChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<HdmiControlStatusChangeListenerRecord> r1 = this.mHdmiControlStatusChangeListenerRecords.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        HdmiControlStatusChangeListenerRecord record = r1.next();     // Catch: Throwable -> L10
        if (HdmiControlStatusChangeListenerRecord.m4412$$Nest$fgetmListener(record).asBinder() != listener.asBinder()) goto L6;
        listener.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L10
        this.mHdmiControlStatusChangeListenerRecords.remove(record);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void addHdmiCecVolumeControlFeatureListener(final IHdmiCecVolumeControlFeatureListener listener) {
        this.mHdmiCecVolumeControlFeatureListenerRecords.register(listener);
        runOnServiceThread(new AnonymousClass25(this, listener));
    }

    void removeHdmiControlVolumeControlStatusChangeListener(IHdmiCecVolumeControlFeatureListener listener) {
        this.mHdmiCecVolumeControlFeatureListenerRecords.unregister(listener);
    }

    private void addHotplugEventListener(final IHdmiHotplugEventListener listener) {
        final HotplugEventListenerRecord record = new HotplugEventListenerRecord(this, listener);
        listener.asBinder().linkToDeath(record, 0);     // Catch: RemoteException -> L13
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mHotplugEventListenerRecords.add(record);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        runOnServiceThread(new AnonymousClass26(this, record, listener));
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        Slog.w(TAG, "Listener already died");
    }

    private void removeHotplugEventListener(IHdmiHotplugEventListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<HotplugEventListenerRecord> r1 = this.mHotplugEventListenerRecords.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        HotplugEventListenerRecord record = r1.next();     // Catch: Throwable -> L10
        if (HotplugEventListenerRecord.m4415$$Nest$fgetmListener(record).asBinder() != listener.asBinder()) goto L6;
        listener.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L10
        this.mHotplugEventListenerRecords.remove(record);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void addDeviceEventListener(IHdmiDeviceEventListener listener) {
        DeviceEventListenerRecord record = new DeviceEventListenerRecord(this, listener);
        listener.asBinder().linkToDeath(record, 0);     // Catch: RemoteException -> L12
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mDeviceEventListenerRecords.add(record);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        Slog.w(TAG, "Listener already died");
    }

    void invokeDeviceEventListeners(HdmiDeviceInfo device, int status) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<DeviceEventListenerRecord> r1 = this.mDeviceEventListenerRecords.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L15;
        DeviceEventListenerRecord record = r1.next();     // Catch: Throwable -> L10
        DeviceEventListenerRecord.m4411$$Nest$fgetmListener(record).onStatusChanged(device, status);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to report device event:" + e);     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void addSystemAudioModeChangeListner(IHdmiSystemAudioModeChangeListener listener) {
        SystemAudioModeChangeListenerRecord record = new SystemAudioModeChangeListenerRecord(this, listener);
        listener.asBinder().linkToDeath(record, 0);     // Catch: RemoteException -> L12
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mSystemAudioModeChangeListenerRecords.add(record);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        Slog.w(TAG, "Listener already died");
    }

    private void removeSystemAudioModeChangeListener(IHdmiSystemAudioModeChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<SystemAudioModeChangeListenerRecord> r1 = this.mSystemAudioModeChangeListenerRecords.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        SystemAudioModeChangeListenerRecord record = r1.next();     // Catch: Throwable -> L10
        if (SystemAudioModeChangeListenerRecord.m4417$$Nest$fgetmListener(record).asBinder() != listener) goto L6;
        listener.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L10
        this.mSystemAudioModeChangeListenerRecords.remove(record);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void setInputChangeListener(IHdmiInputChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mInputChangeListenerRecord = new InputChangeListenerRecord(this, listener);     // Catch: Throwable -> L8
        listener.asBinder().linkToDeath(this.mInputChangeListenerRecord, 0);     // Catch: Throwable -> L8 RemoteException -> L10
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        Slog.w(TAG, "Listener already died");     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void invokeInputChangeListener(HdmiDeviceInfo info) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputChangeListenerRecord != null) goto L18;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        InputChangeListenerRecord.m4416$$Nest$fgetmListener(this.mInputChangeListenerRecord).onChanged(info);     // Catch: Throwable -> L8 RemoteException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "Exception thrown by IHdmiInputChangeListener: " + e);     // Catch: Throwable -> L8
        goto L12
    }

    private void setHdmiRecordListener(IHdmiRecordListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRecordListenerRecord = new HdmiRecordListenerRecord(this, listener);     // Catch: Throwable -> L7
        listener.asBinder().linkToDeath(this.mRecordListenerRecord, 0);     // Catch: Throwable -> L7 RemoteException -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        e = move-exception;
        Slog.w(TAG, "Listener already died.", e);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    byte[] invokeRecordRequestListener(int recorderAddress) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRecordListenerRecord != null) goto L19;
    L13:
        byte[] r1 = EmptyArray.BYTE;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L19:
        byte[] r2 = HdmiRecordListenerRecord.m4414$$Nest$fgetmListener(this.mRecordListenerRecord).getOneTouchRecordSource(recorderAddress);     // Catch: Throwable -> L9 RemoteException -> L11
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        e = move-exception;
        Slog.w(TAG, "Failed to start record.", e);     // Catch: Throwable -> L9
        goto L13
    }

    void invokeOneTouchRecordResult(int recorderAddress, int result) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mRecordListenerRecord != null) goto L18;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        HdmiRecordListenerRecord.m4414$$Nest$fgetmListener(this.mRecordListenerRecord).onOneTouchRecordResult(recorderAddress, result);     // Catch: Throwable -> L8 RemoteException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to call onOneTouchRecordResult.", e);     // Catch: Throwable -> L8
        goto L12
    }

    void invokeTimerRecordingResult(int recorderAddress, int result) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mRecordListenerRecord != null) goto L18;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        HdmiRecordListenerRecord.m4414$$Nest$fgetmListener(this.mRecordListenerRecord).onTimerRecordingResult(recorderAddress, result);     // Catch: Throwable -> L8 RemoteException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to call onTimerRecordingResult.", e);     // Catch: Throwable -> L8
        goto L12
    }

    void invokeClearTimerRecordingResult(int recorderAddress, int result) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mRecordListenerRecord != null) goto L18;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L18:
        HdmiRecordListenerRecord.m4414$$Nest$fgetmListener(this.mRecordListenerRecord).onClearTimerRecordingResult(recorderAddress, result);     // Catch: Throwable -> L8 RemoteException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "Failed to call onClearTimerRecordingResult.", e);     // Catch: Throwable -> L8
        goto L12
    }

    private void invokeCallback(IHdmiControlCallback callback, int result) {
        if (callback != null) goto L9;
        return;
    L9:
        callback.onComplete(result);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "Invoking callback failed:" + e);
    }

    private void invokeSystemAudioModeChangeLocked(IHdmiSystemAudioModeChangeListener listener, boolean enabled) {
        listener.onStatusChanged(enabled);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Invoking callback failed:" + e);
    }

    private void announceHotplugEvent(int portId, boolean connected) {
        HdmiHotplugEvent event = new HdmiHotplugEvent(portId, connected);
        Object r1 = this.mLock;
        monitor-enter(r1);
        Iterator<HotplugEventListenerRecord> r2 = this.mHotplugEventListenerRecords.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        HotplugEventListenerRecord record = r2.next();     // Catch: Throwable -> L8
        invokeHotplugEventListenerLocked(HotplugEventListenerRecord.m4415$$Nest$fgetmListener(record), event);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void invokeHotplugEventListenerLocked(IHdmiHotplugEventListener listener, HdmiHotplugEvent event) {
        listener.onReceived(event);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to report hotplug event:" + event.toString(), e);
    }

    private void announceHdmiControlStatusChange(int isEnabled) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<IHdmiControlStatusChangeListener> listeners = new ArrayList(this.mHdmiControlStatusChangeListenerRecords.size());     // Catch: Throwable -> L8
        Iterator<HdmiControlStatusChangeListenerRecord> r2 = this.mHdmiControlStatusChangeListenerRecords.iterator();     // Catch: Throwable -> L8
    L6:
        if (r2.hasNext() == false) goto L10;
        HdmiControlStatusChangeListenerRecord record = r2.next();     // Catch: Throwable -> L8
        listeners.add(HdmiControlStatusChangeListenerRecord.m4412$$Nest$fgetmListener(record));     // Catch: Throwable -> L8
        goto L6
    L10:
        invokeHdmiControlStatusChangeListenerLocked(listeners, isEnabled);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void invokeHdmiControlStatusChangeListenerLocked(IHdmiControlStatusChangeListener listener, int isEnabled) {
        invokeHdmiControlStatusChangeListenerLocked(Collections.singletonList(listener), isEnabled);
    }

    private void invokeHdmiControlStatusChangeListenerLocked(final Collection<IHdmiControlStatusChangeListener> listeners, final int isEnabled) {
        if (isEnabled != 1) goto L5;
        queryDisplayStatus(new AnonymousClass27(this, listeners, isEnabled));
        return;
    L5:
        this.mIsCecAvailable = false;
        if (listeners.isEmpty() == true) goto L10;
        invokeHdmiControlStatusChangeListenerLocked(listeners, isEnabled, this.mIsCecAvailable);
        return;
    }

    private void invokeHdmiControlStatusChangeListenerLocked(Collection<IHdmiControlStatusChangeListener> listeners, int isEnabled, boolean isCecAvailable) {
        Iterator<IHdmiControlStatusChangeListener> r0 = listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        IHdmiControlStatusChangeListener listener = r0.next();
        listener.onStatusChange(isEnabled, isCecAvailable);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to report HdmiControlStatusChange: " + isEnabled + " isAvailable: " + isCecAvailable, e);
        goto L4
    }

    private void announceHdmiCecVolumeControlFeatureChange(final int hdmiCecVolumeControl) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHdmiCecVolumeControlFeatureListenerRecords.broadcast(new HdmiControlService$$ExternalSyntheticLambda7(hdmiCecVolumeControl));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$announceHdmiCecVolumeControlFeatureChange$2(int hdmiCecVolumeControl, IHdmiCecVolumeControlFeatureListener listener) {
        listener.onHdmiCecVolumeControlFeature(hdmiCecVolumeControl);     // Catch: RemoteException -> L4
        return;
    L5:
        Slog.e(TAG, "Failed to report HdmiControlVolumeControlStatusChange: " + hdmiCecVolumeControl);
    }

    public HdmiCecLocalDeviceTv tv() {
        return (HdmiCecLocalDeviceTv) this.mHdmiCecNetwork.getLocalDevice(0);
    }

    boolean isTvDevice() {
        return this.mCecLocalDevices.contains(0);
    }

    boolean isAudioSystemDevice() {
        return this.mCecLocalDevices.contains(5);
    }

    boolean isPlaybackDevice() {
        return this.mCecLocalDevices.contains(4);
    }

    boolean isSwitchDevice() {
        return ((Boolean) HdmiProperties.is_switch().orElse(false)).booleanValue();
    }

    boolean isTvDeviceEnabled() {
        if (isTvDevice() == true) goto L5;
    L7:
        return false;
    L5:
        if (tv() == null) goto L7;
        return true;
    }

    protected HdmiCecLocalDevicePlayback playback() {
        return (HdmiCecLocalDevicePlayback) this.mHdmiCecNetwork.getLocalDevice(4);
    }

    public HdmiCecLocalDeviceAudioSystem audioSystem() {
        return (HdmiCecLocalDeviceAudioSystem) this.mHdmiCecNetwork.getLocalDevice(5);
    }

    AudioManagerWrapper getAudioManager() {
        return this.mAudioManager;
    }

    private AudioDeviceVolumeManagerWrapper getAudioDeviceVolumeManager() {
        return this.mAudioDeviceVolumeManager;
    }

    boolean isCecControlEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.mHdmiControlEnabled == 1) goto L8;
        r2 = false;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isEarcEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mEarcEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected boolean isEarcSupported() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mEarcSupported;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isDsmEnabled() {
        if (this.mHdmiCecConfig.getIntValue("soundbar_mode") == 1) goto L7;
        return false;
    L7:
        return true;
    }

    protected boolean isArcSupported() {
        return SystemProperties.getBoolean("persist.sys.hdmi.property_arc_support", true);
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getPowerStatus() {
        assertRunOnServiceThread();
        return this.mPowerStatusController.getPowerStatus();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setPowerStatus(int powerStatus) {
        assertRunOnServiceThread();
        this.mPowerStatusController.setPowerStatus(powerStatus);
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isPowerOnOrTransient() {
        assertRunOnServiceThread();
        if (this.mPowerStatusController.isPowerStatusOn() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mPowerStatusController.isPowerStatusTransientToOn() == true) goto L8;
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isPowerStandbyOrTransient() {
        assertRunOnServiceThread();
        if (this.mPowerStatusController.isPowerStatusStandby() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mPowerStatusController.isPowerStatusTransientToStandby() == true) goto L8;
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isPowerStandby() {
        assertRunOnServiceThread();
        return this.mPowerStatusController.isPowerStatusStandby();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void wakeUp() {
        assertRunOnServiceThread();
        this.mWakeUpMessageReceived = true;
        this.mPowerManager.wakeUp(SystemClock.uptimeMillis(), 8, "android.server.hdmi:WAKE");
    }

    @HdmiAnnotations.ServiceThreadOnly
    void standby() {
        assertRunOnServiceThread();
        if (canGoToStandby() == true) goto L5;
        return;
    L5:
        this.mStandbyMessageReceived = true;
        this.mPowerManager.goToSleep(SystemClock.uptimeMillis(), 5, 0);
    }

    boolean isWakeUpMessageReceived() {
        return this.mWakeUpMessageReceived;
    }

    protected boolean isStandbyMessageReceived() {
        return this.mStandbyMessageReceived;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void onWakeUp(int wakeUpAction) {
        assertRunOnServiceThread();
        this.mPowerStatusController.setPowerStatus(2, false);
        if (this.mCecController != null) goto L5;
        Slog.i(TAG, "Device does not support HDMI-CEC.");
    L29:
        if (isEarcSupported() == false) goto L41;
        if (isEarcEnabled() == true) goto L33;
        setEarcEnabledInHal(false, false);
        goto L41
    L33:
        switch(wakeUpAction) {
            case 0: goto L37;
            case 1: goto L36;
            default: goto L34;
        };
    L34:
        Slog.e(TAG, "wakeUpAction " + wakeUpAction + " not defined.");
        return;
    L36:
        int startReason = 1;
    L38:
        initializeEarc(startReason);
        goto L41
    L37:
        startReason = 2;
    L41:
        if (isTvDevice() == false) goto L45;
        int earcStatus = getEarcStatus();
        getAtomWriter().earcStatusChanged(isEarcSupported(), isEarcEnabled(), earcStatus, earcStatus, 1);
        return;
    L45:
        if (isPlaybackDevice() == false) goto L49;
        getAtomWriter().dsmStatusChanged(isArcSupported(), isDsmEnabled(), 1);
        return;
    L49:
        return;
    L5:
        if (isTvDevice() == false) goto L17;
        if (getWasCecDisabledOnStandbyByLowEnergyMode() == false) goto L17;
        Slog.w(TAG, "Re-enable CEC on wake-up since it was disabled due to low energy  mode.");
        getHdmiCecConfig().setIntValue("hdmi_cec_enabled", 1);
        setWasCecDisabledOnStandbyByLowEnergyMode(false);
        switch(wakeUpAction) {
            case 0: goto L13;
            case 1: goto L12;
            default: goto L10;
        };
    L10:
        Slog.e(TAG, "wakeUpAction " + wakeUpAction + " not defined.");
        return;
    L12:
        int controlStateChangedReason = 0;
    L14:
        invokeVendorCommandListenersOnControlStateChanged(true, controlStateChangedReason);
        goto L29
    L13:
        controlStateChangedReason = 2;
    L17:
        if (isCecControlEnabled() == false) goto L29;
        switch(wakeUpAction) {
            case 0: goto L23;
            case 1: goto L22;
            default: goto L20;
        };
    L20:
        Slog.e(TAG, "wakeUpAction " + wakeUpAction + " not defined.");
        return;
    L22:
        int startReason2 = 1;
    L26:
        initializeCec(startReason2);
        goto L29
    L23:
        startReason2 = 2;
        if (this.mWakeUpMessageReceived == false) goto L26;
        startReason2 = 3;
        goto L26
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void onStandby(final int standbyAction) {
        if (shouldAcquireWakeLockOnStandby() == false) goto L5;
        acquireWakeLock();
    L5:
        this.mWakeUpMessageReceived = false;
        assertRunOnServiceThread();
        this.mPowerStatusController.setPowerStatus(3, false);
        invokeVendorCommandListenersOnControlStateChanged(false, 3);
        final List<HdmiCecLocalDevice> devices = getAllCecLocalDevices();
        if (isStandbyMessageReceived() == false) goto L8;
    L14:
        disableCecLocalDevices(new AnonymousClass28(this, devices, standbyAction));
        checkAndUpdateAbsoluteVolumeBehavior();
        return;
    L8:
        if (canGoToStandby() == true) goto L14;
        this.mPowerStatusController.setPowerStatus(1);
        Iterator<HdmiCecLocalDevice> r1 = devices.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        HdmiCecLocalDevice device = r1.next();
        device.onStandby(this.mStandbyMessageReceived, standbyAction);
        goto L11
    }

    boolean canGoToStandby() {
        Iterator<HdmiCecLocalDevice> r0 = this.mHdmiCecNetwork.getLocalDeviceList().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        HdmiCecLocalDevice device = r0.next();
        if (device.canGoToStandby() == true) goto L4;
        return false;
    L10:
        return true;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void onLanguageChanged(String language) {
        assertRunOnServiceThread();
        this.mMenuLanguage = language;
        if (isTvDeviceEnabled() == false) goto L6;
        tv().broadcastMenuLanguage(language);
        this.mCecController.setLanguage(language);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    String getLanguage() {
        assertRunOnServiceThread();
        return this.mMenuLanguage;
    }

    protected void disableCecLocalDevices(HdmiCecLocalDevice.PendingActionClearedCallback callback) {
        if (this.mCecController == null) goto L8;
        Iterator<HdmiCecLocalDevice> r0 = this.mHdmiCecNetwork.getLocalDeviceList().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        HdmiCecLocalDevice device = r0.next();
        device.disableDevice(this.mStandbyMessageReceived, callback);
    L8:
        this.mMhlController.clearAllLocalDevices();
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void clearCecLocalDevices() {
        assertRunOnServiceThread();
        if (this.mCecController != null) goto L5;
        return;
    L5:
        this.mCecController.clearLogicalAddress();
        this.mHdmiCecNetwork.clearLocalDevices();
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void onPendingActionsCleared(int standbyAction) {
        assertRunOnServiceThread();
        Slog.v(TAG, "onPendingActionsCleared");
        final int localDevicesCount = getAllCecLocalDevices().size();
        final int[] countStandbyCompletedDevices = new int[1];
        HdmiCecLocalDevice.StandbyCompletedCallback callback = new AnonymousClass29(this, localDevicesCount, countStandbyCompletedDevices);
        if (this.mPowerStatusController.isPowerStatusTransientToStandby() == false) goto L8;
        this.mPowerStatusController.setPowerStatus(1);
        Iterator<HdmiCecLocalDevice> r1 = this.mHdmiCecNetwork.getLocalDeviceList().iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        HdmiCecLocalDevice device = r1.next();
        device.onStandby(this.mStandbyMessageReceived, standbyAction, callback);
    L8:
        this.mStandbyMessageReceived = false;
    }

    private boolean shouldAcquireWakeLockOnStandby() {
        boolean sendStandbyOnSleep = false;
        if (tv() == null) goto L10;
        if (this.mHdmiCecConfig.getIntValue("tv_send_standby_on_sleep") != 1) goto L7;
        boolean r1 = true;
    L8:
        sendStandbyOnSleep = r1;
    L13:
        if (isCecControlEnabled() == true) goto L15;
        return false;
    L15:
        if (isPowerOnOrTransient() == false) goto L20;
        if (sendStandbyOnSleep == true) goto L18;
        return false;
    L18:
        return true;
    L20:
        return false;
    L7:
        r1 = false;
        goto L8
    L10:
        if (playback() == null) goto L13;
        sendStandbyOnSleep = !this.mHdmiCecConfig.getStringValue("power_control_mode").equals("none");
        goto L13
    }

    protected void acquireWakeLock() {
        releaseWakeLock();
        this.mWakeLock = this.mPowerManager.newWakeLock(1, TAG);
        this.mWakeLock.acquire(5000);
    }

    protected void releaseWakeLock() {
        if (this.mWakeLock == null) goto L16;
        if (this.mWakeLock.isHeld() == false) goto L12;
        this.mWakeLock.release();     // Catch: RuntimeException -> L8
    L12:
        this.mWakeLock = null;
        return;
    L11:
        Slog.w(TAG, "Exception when releasing wake lock.");
        goto L12
    }

    void addVendorCommandListener(IHdmiVendorCommandListener listener, int vendorId) {
        VendorCommandListenerRecord record = new VendorCommandListenerRecord(this, listener, vendorId);
        listener.asBinder().linkToDeath(record, 0);     // Catch: RemoteException -> L12
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mVendorCommandListenerRecords.add(record);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        Slog.w(TAG, "Listener already died");
    }

    boolean invokeVendorCommandListenersOnReceived(int deviceType, int srcAddress, int destAddress, byte[] params, boolean hasVendorId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mVendorCommandListenerRecords.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return false;
    L10:
        boolean notifiedVendorCommandToListeners = false;
        Iterator<VendorCommandListenerRecord> r3 = this.mVendorCommandListenerRecords.iterator();     // Catch: Throwable -> L8
    L12:
        if (r3.hasNext() == false) goto L23;
        VendorCommandListenerRecord record = r3.next();     // Catch: Throwable -> L8
        if (hasVendorId == false) goto L27;
        int vendorId = (((params[0] & CecDeviceType.INACTIVE) << 16) + ((params[1] & CecDeviceType.INACTIVE) << 8)) + (params[2] & CecDeviceType.INACTIVE);     // Catch: Throwable -> L8
        if (VendorCommandListenerRecord.m4419$$Nest$fgetmVendorId(record) != vendorId) goto L12;
    L27:
        VendorCommandListenerRecord.m4418$$Nest$fgetmListener(record).onReceived(srcAddress, destAddress, params, hasVendorId);     // Catch: Throwable -> L8 RemoteException -> L20
        notifiedVendorCommandToListeners = true;
        goto L12
    L20:
        e = move-exception;
        Slog.e(TAG, "Failed to notify vendor command reception", e);     // Catch: Throwable -> L8
        goto L12
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return notifiedVendorCommandToListeners;
    }

    boolean invokeVendorCommandListenersOnControlStateChanged(boolean enabled, int reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVendorCommandListenerRecords.isEmpty() == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        Iterator<VendorCommandListenerRecord> r1 = this.mVendorCommandListenerRecords.iterator();     // Catch: Throwable -> L9
    L13:
        if (r1.hasNext() == false) goto L20;
        VendorCommandListenerRecord record = r1.next();     // Catch: Throwable -> L9
        VendorCommandListenerRecord.m4418$$Nest$fgetmListener(record).onControlStateChanged(enabled, reason);     // Catch: Throwable -> L9 RemoteException -> L17
    L17:
        e = move-exception;
        Slog.e(TAG, "Failed to notify control-state-changed to vendor handler", e);     // Catch: Throwable -> L9
        goto L13
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return true;
    }

    private void addHdmiMhlVendorCommandListener(IHdmiMhlVendorCommandListener listener) {
        HdmiMhlVendorCommandListenerRecord record = new HdmiMhlVendorCommandListenerRecord(this, listener);
        listener.asBinder().linkToDeath(record, 0);     // Catch: RemoteException -> L12
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mMhlVendorCommandListenerRecords.add(record);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        Slog.w(TAG, "Listener already died.");
    }

    void invokeMhlVendorCommandListeners(int portId, int offest, int length, byte[] data) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<HdmiMhlVendorCommandListenerRecord> r1 = this.mMhlVendorCommandListenerRecords.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L15;
        HdmiMhlVendorCommandListenerRecord record = r1.next();     // Catch: Throwable -> L10
        HdmiMhlVendorCommandListenerRecord.m4413$$Nest$fgetmListener(record).onReceived(portId, offest, length, data);     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        e = move-exception;
        Slog.e(TAG, "Failed to notify MHL vendor command", e);     // Catch: Throwable -> L10
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void setStandbyMode(boolean isStandbyModeOn) {
        assertRunOnServiceThread();
        if (isPowerOnOrTransient() == false) goto L9;
        if (isStandbyModeOn == false) goto L9;
        this.mPowerManager.goToSleep(SystemClock.uptimeMillis(), 5, 0);
        if (playback() == null) goto L15;
        playback().sendStandby(0);
        return;
    L15:
        return;
    L9:
        if (isPowerStandbyOrTransient() == false) goto L17;
        if (isStandbyModeOn == true) goto L18;
        this.mPowerManager.wakeUp(SystemClock.uptimeMillis(), 8, "android.server.hdmi:WAKE");
        if (playback() == null) goto L19;
        oneTouchPlay(new AnonymousClass30(this));
        return;
    L19:
        return;
    L18:
        return;
    }

    int getHdmiCecVolumeControl() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mHdmiCecVolumeControl;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isProhibitMode() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mProhibitMode;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setProhibitMode(boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mProhibitMode = enabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isSystemAudioActivated() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSystemAudioActivated;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setSystemAudioActivated(boolean on) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemAudioActivated = on;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        runOnServiceThread(new HdmiControlService$$ExternalSyntheticLambda2(this));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setCecEnabled(int enabled) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mHdmiControlEnabled = enabled;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (enabled != 1) goto L10;
        onEnableCec();
        setHdmiCecVolumeControlEnabledInternal(getHdmiCecConfig().getIntValue("volume_control_enabled"));
        return;
    L10:
        setHdmiCecVolumeControlEnabledInternal(0);
        invokeVendorCommandListenersOnControlStateChanged(false, 1);
        runOnServiceThread(new AnonymousClass31(this));
        announceHdmiControlStatusChange(enabled);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void onEnableCec() {
        this.mCecController.enableCec(true);
        this.mCecController.enableSystemCecControl(true);
        this.mMhlController.setOption(103, 1);
        initializeCec(0);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void onDisableCec() {
        disableCecLocalDevices(new AnonymousClass32(this));
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setActivePortId(int portId) {
        assertRunOnServiceThread();
        this.mActivePortId = portId;
        setLastInputForMhl(-1);
    }

    HdmiCecLocalDevice.ActiveSource getLocalActiveSource() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        HdmiCecLocalDevice.ActiveSource r1 = this.mActiveSource;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void pauseActiveMediaSessions() {
        MediaSessionManager mediaSessionManager = (MediaSessionManager) getContext().getSystemService(MediaSessionManager.class);
        List<MediaController> mediaControllers = mediaSessionManager.getActiveSessions(null);
        Iterator<MediaController> r2 = mediaControllers.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        MediaController mediaController = r2.next();
        mediaController.getTransportControls().pause();
        goto L4
    }

    void setActiveSource(int logicalAddress, int physicalAddress, String caller) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActiveSource.logicalAddress = logicalAddress;     // Catch: Throwable -> L18
        this.mActiveSource.physicalAddress = physicalAddress;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        getAtomWriter().activeSourceChanged(logicalAddress, physicalAddress, HdmiUtils.pathRelationship(getPhysicalAddress(), physicalAddress));
        Iterator<HdmiCecLocalDevice> r1 = getAllCecLocalDevices().iterator();
    L8:
        if (r1.hasNext() == false) goto L16;
        HdmiCecLocalDevice device = r1.next();
        if (logicalAddress == device.getDeviceInfo().getLogicalAddress()) goto L12;
    L14:
        boolean deviceIsActiveSource = false;
    L15:
        device.addActiveSourceHistoryItem(new HdmiCecLocalDevice.ActiveSource(logicalAddress, physicalAddress), deviceIsActiveSource, caller);
        goto L8
    L12:
        if (physicalAddress != getPhysicalAddress()) goto L14;
        deviceIsActiveSource = true;
        goto L15
    L16:
        runOnServiceThread(new HdmiControlService$$ExternalSyntheticLambda2(this));
        return;
    L18:
        th = move-exception;
        throw th;
    }

    protected void setAndBroadcastActiveSource(int physicalAddress, int deviceType, int source, String caller) {
        if (deviceType != 4) goto L6;
        HdmiCecLocalDevicePlayback playback = playback();
        playback.dismissUiOnActiveSourceStatusRecovered();
        playback.removeAction(RequestActiveSourceAction.class);
        playback.setActiveSource(playback.getDeviceInfo().getLogicalAddress(), physicalAddress, caller);
        playback.wakeUpIfActiveSource();
        playback.maySendActiveSource(source);
        playback.mDelayedStandbyOnActiveSourceLostHandler.removeCallbacksAndMessages(null);
    L6:
        if (deviceType != 5) goto L11;
        HdmiCecLocalDeviceAudioSystem audioSystem = audioSystem();
        if (playback() != null) goto L12;
        audioSystem.setActiveSource(audioSystem.getDeviceInfo().getLogicalAddress(), physicalAddress, caller);
        audioSystem.wakeUpIfActiveSource();
        audioSystem.maySendActiveSource(source);
        return;
    L12:
        return;
    }

    protected void setAndBroadcastActiveSourceFromOneDeviceType(int sourceAddress, int physicalAddress, String caller) {
        HdmiCecLocalDevicePlayback playback = playback();
        HdmiCecLocalDeviceAudioSystem audioSystem = audioSystem();
        if (playback == null) goto L5;
        playback.dismissUiOnActiveSourceStatusRecovered();
        playback.setActiveSource(playback.getDeviceInfo().getLogicalAddress(), physicalAddress, caller);
        playback.wakeUpIfActiveSource();
        playback.maySendActiveSource(sourceAddress);
        return;
    L5:
        if (audioSystem == null) goto L9;
        audioSystem.setActiveSource(audioSystem.getDeviceInfo().getLogicalAddress(), physicalAddress, caller);
        audioSystem.wakeUpIfActiveSource();
        audioSystem.maySendActiveSource(sourceAddress);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setLastInputForMhl(int portId) {
        assertRunOnServiceThread();
        this.mLastInputMhl = portId;
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getLastInputForMhl() {
        assertRunOnServiceThread();
        return this.mLastInputMhl;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void changeInputForMhl(int portId, boolean contentOn) {
        assertRunOnServiceThread();
        if (tv() != null) goto L6;
        return;
    L6:
        if (contentOn == false) goto L8;
        final int lastInput = tv().getActivePortId();
    L9:
        if (portId == (-1)) goto L11;
        tv().doManualPortSwitching(portId, new AnonymousClass33(this, lastInput));
    L11:
        tv().setActivePortId(portId);
        HdmiMhlLocalDeviceStub device = this.mMhlController.getLocalDevice(portId);
        if (device == null) goto L14;
        HdmiDeviceInfo info = device.getInfo();
    L15:
        invokeInputChangeListener(info);
        return;
    L14:
        info = this.mHdmiCecNetwork.getDeviceForPortId(portId);
        goto L15
    L8:
        lastInput = -1;
        goto L9
    }

    void setMhlInputChangeEnabled(boolean enabled) {
        this.mMhlController.setOption(101, toInt(enabled));
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mMhlInputChangeEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected HdmiCecAtomWriter getAtomWriter() {
        return this.mAtomWriter;
    }

    boolean isMhlInputChangeEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mMhlInputChangeEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void displayOsd(int messageId) {
        assertRunOnServiceThread();
        Intent intent = new Intent("android.hardware.hdmi.action.OSD_MESSAGE");
        intent.putExtra("android.hardware.hdmi.extra.MESSAGE_ID", messageId);
        sendBroadcastAsUser(intent);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void displayOsd(int messageId, int extra) {
        assertRunOnServiceThread();
        Intent intent = new Intent("android.hardware.hdmi.action.OSD_MESSAGE");
        intent.putExtra("android.hardware.hdmi.extra.MESSAGE_ID", messageId);
        intent.putExtra("android.hardware.hdmi.extra.MESSAGE_EXTRA_PARAM1", extra);
        sendBroadcastAsUser(intent);
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void sendBroadcastAsUser(Intent intent) {
        assertRunOnServiceThread();
        getContext().sendBroadcastAsUser(intent, UserHandle.ALL, PERMISSION);
    }

    protected HdmiCecConfig getHdmiCecConfig() {
        return this.mHdmiCecConfig;
    }

    private void addCecSettingChangeListener(String name, IHdmiCecSettingChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mHdmiCecSettingChangeListenerRecords.containsKey(name) == true) goto L9;
        this.mHdmiCecSettingChangeListenerRecords.put(name, new RemoteCallbackList());     // Catch: Throwable -> L7
        this.mHdmiCecConfig.registerChangeListener(name, this.mSettingChangeListener);     // Catch: Throwable -> L7
    L9:
        this.mHdmiCecSettingChangeListenerRecords.get(name).register(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    private void removeCecSettingChangeListener(String name, IHdmiCecSettingChangeListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHdmiCecSettingChangeListenerRecords.containsKey(name) == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mHdmiCecSettingChangeListenerRecords.get(name).unregister(listener);     // Catch: Throwable -> L8
        if (this.mHdmiCecSettingChangeListenerRecords.get(name).getRegisteredCallbackCount() != 0) goto L13;
        this.mHdmiCecSettingChangeListenerRecords.remove(name);     // Catch: Throwable -> L8
        this.mHdmiCecConfig.removeChangeListener(name, this.mSettingChangeListener);     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void invokeCecSettingChangeListenerLocked(String name, IHdmiCecSettingChangeListener listener) {
        listener.onChange(name);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Failed to report setting change", e);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void onDeviceVolumeBehaviorChanged(AudioDeviceAttributes device, int volumeBehavior) {
        assertRunOnServiceThread();
        if (AVB_AUDIO_OUTPUT_DEVICES.contains(device) == false) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAudioDeviceVolumeBehaviors.put(device, Integer.valueOf(volumeBehavior));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        checkAndUpdateAbsoluteVolumeBehavior();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private int getDeviceVolumeBehavior(AudioDeviceAttributes device) {
        if (AVB_AUDIO_OUTPUT_DEVICES.contains(device) == false) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mAudioDeviceVolumeBehaviors.containsKey(device) == false) goto L13;
        int r1 = this.mAudioDeviceVolumeBehaviors.get(device).intValue();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L18:
        return getAudioDeviceVolumeManager().getDeviceVolumeBehavior(device);
    }

    public boolean isAbsoluteVolumeBehaviorEnabled() {
        if (isTvDevice() == false) goto L5;
    L7:
        Iterator<AudioDeviceAttributes> r0 = getAvbCapableAudioOutputDevices().iterator();
    L9:
        if (r0.hasNext() == false) goto L15;
        AudioDeviceAttributes device = r0.next();
        if (ABSOLUTE_VOLUME_BEHAVIORS.contains(Integer.valueOf(getDeviceVolumeBehavior(device))) == false) goto L9;
        return true;
    L15:
        return false;
    L5:
        if (isPlaybackDevice() == true) goto L7;
        return false;
    }

    private List<AudioDeviceAttributes> getAvbCapableAudioOutputDevices() {
        if (tv() == null) goto L7;
        return TV_AVB_AUDIO_OUTPUT_DEVICES;
    L7:
        if (playback() == null) goto L11;
        return PLAYBACK_AVB_AUDIO_OUTPUT_DEVICES;
    L11:
        return Collections.emptyList();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void checkAndUpdateAbsoluteVolumeBehavior() {
        assertRunOnServiceThread();
        if (getAudioManager() != null) goto L6;
        return;
    L6:
        if (this.mPowerStatusController == null) goto L12;
        if (isPowerStandbyOrTransient() == false) goto L12;
        switchToFullVolumeBehavior();
        return;
    L12:
        if (isTvDevice() == false) goto L20;
        if (tv() == null) goto L20;
        HdmiCecLocalDevice localCecDevice = tv();
        if (isSystemAudioActivated() == true) goto L24;
        switchToFullVolumeBehavior();
        return;
    L24:
        HdmiDeviceInfo systemAudioDeviceInfo = getDeviceInfo(localCecDevice.findAudioReceiverAddress());
        boolean cecVolumeEnabled = false;
        int currentVolumeBehavior = getDeviceVolumeBehavior(getAvbCapableAudioOutputDevices().get(0));
        boolean alreadyUsingFullOrAbsoluteVolume = FULL_AND_ABSOLUTE_VOLUME_BEHAVIORS.contains(Integer.valueOf(currentVolumeBehavior));
        if (getHdmiCecVolumeControl() != 1) goto L27;
        cecVolumeEnabled = true;
    L27:
        if (cecVolumeEnabled == false) goto L57;
        if (alreadyUsingFullOrAbsoluteVolume == false) goto L57;
        if (systemAudioDeviceInfo != null) goto L34;
        switchToFullVolumeBehavior();
        return;
    L34:
        switch(systemAudioDeviceInfo.getDeviceFeatures().getSetAudioVolumeLevelSupport()) {
            case 0: goto L44;
            case 1: goto L40;
            case 2: goto L36;
            default: goto L61;
        };
    L36:
        if (currentVolumeBehavior != 3) goto L38;
        switchToFullVolumeBehavior();
    L38:
        localCecDevice.querySetAudioVolumeLevelSupport(systemAudioDeviceInfo.getLogicalAddress());
        return;
    L40:
        if (currentVolumeBehavior == 3) goto L62;
        localCecDevice.startNewAvbAudioStatusAction(systemAudioDeviceInfo.getLogicalAddress());
        return;
    L62:
        return;
    L61:
        return;
    L44:
        if (tv() != null) goto L46;
    L55:
        switchToFullVolumeBehavior();
        return;
    L46:
        if (this.mNumericSoundbarVolumeUiOnTvFeatureFlagEnabled == false) goto L55;
        if (currentVolumeBehavior == 5) goto L63;
        if (currentVolumeBehavior != 3) goto L54;
        Iterator<AudioDeviceAttributes> r5 = getAvbCapableAudioOutputDevices().iterator();
    L52:
        if (r5.hasNext() == false) goto L54;
        AudioDeviceAttributes device = r5.next();
        getAudioDeviceVolumeManager().setDeviceVolumeBehavior(device, 1);
    L54:
        localCecDevice.startNewAvbAudioStatusAction(systemAudioDeviceInfo.getLogicalAddress());
        return;
    L63:
        return;
    L57:
        switchToFullVolumeBehavior();
        return;
    L20:
        if (isPlaybackDevice() == true) goto L22;
        return;
    L22:
        if (playback() == null) goto L65;
        localCecDevice = playback();
        goto L24
    }

    private void switchToFullVolumeBehavior() {
        Slog.d(TAG, "Switching to full volume behavior");
        if (playback() == null) goto L6;
        playback().removeAvbAudioStatusAction();
    L8:
        Iterator<AudioDeviceAttributes> r0 = getAvbCapableAudioOutputDevices().iterator();
    L10:
        if (r0.hasNext() == false) goto L15;
        AudioDeviceAttributes device = r0.next();
        if (ABSOLUTE_VOLUME_BEHAVIORS.contains(Integer.valueOf(getDeviceVolumeBehavior(device))) == false) goto L10;
        getAudioDeviceVolumeManager().setDeviceVolumeBehavior(device, 1);
        goto L10
    L15:
        return;
    L6:
        if (tv() == null) goto L8;
        tv().removeAvbAudioStatusAction();
        goto L8
    }

    void enableAbsoluteVolumeBehavior(AudioStatus audioStatus) {
        if (isPlaybackDevice() == false) goto L5;
        HdmiCecLocalDevice localDevice = playback();
    L6:
        HdmiDeviceInfo systemAudioDevice = getDeviceInfo(localDevice.findAudioReceiverAddress());
        VolumeInfo volumeInfo = new VolumeInfo.Builder(3).setMuted(audioStatus.getMute()).setVolumeIndex(audioStatus.getVolume()).setMaxVolumeIndex(100).setMinVolumeIndex(0).build();
        this.mAbsoluteVolumeChangedListener = new AbsoluteVolumeChangedListener(this, localDevice, systemAudioDevice, null);
        notifyAvbMuteChange(audioStatus.getMute());
        if (systemAudioDevice.getDeviceFeatures().getSetAudioVolumeLevelSupport() != 1) goto L14;
        Slog.d(TAG, "Enabling absolute volume behavior");
        Iterator<AudioDeviceAttributes> r2 = getAvbCapableAudioOutputDevices().iterator();
    L10:
        if (r2.hasNext() == false) goto L22;
        AudioDeviceAttributes device = r2.next();
        getAudioDeviceVolumeManager().setDeviceAbsoluteVolumeBehavior(device, volumeInfo, true, this.mServiceThreadExecutor, this.mAbsoluteVolumeChangedListener);
        goto L10
    L22:
        return;
    L14:
        if (tv() == null) goto L19;
        Slog.d(TAG, "Enabling adjust-only absolute volume behavior");
        Iterator<AudioDeviceAttributes> r3 = getAvbCapableAudioOutputDevices().iterator();
    L17:
        if (r3.hasNext() == false) goto L23;
        AudioDeviceAttributes device2 = r3.next();
        getAudioDeviceVolumeManager().setDeviceAbsoluteVolumeAdjustOnlyBehavior(device2, volumeInfo, true, this.mServiceThreadExecutor, this.mAbsoluteVolumeChangedListener);
        goto L17
    L23:
        return;
    L19:
        return;
    L5:
        localDevice = tv();
        goto L6
    }

    AbsoluteVolumeChangedListener getAbsoluteVolumeChangedListener() {
        return this.mAbsoluteVolumeChangedListener;
    }

    void notifyAvbVolumeChange(int volume) {
        if (isAbsoluteVolumeBehaviorEnabled() == true) goto L5;
        return;
    L5:
        List<AudioDeviceAttributes> streamMusicDevices = getAudioManager().getDevicesForAttributes(STREAM_MUSIC_ATTRIBUTES);
        Iterator<AudioDeviceAttributes> r1 = streamMusicDevices.iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        AudioDeviceAttributes streamMusicDevice = r1.next();
        if (getAvbCapableAudioOutputDevices().contains(streamMusicDevice) == false) goto L7;
        int flags = 8192;
        if (isTvDevice() == false) goto L13;
        flags = 8192 | 1;
    L13:
        setStreamMusicVolume(volume, flags);
        return;
    }

    void notifyAvbMuteChange(boolean mute) {
        if (isAbsoluteVolumeBehaviorEnabled() == true) goto L5;
        return;
    L5:
        List<AudioDeviceAttributes> streamMusicDevices = getAudioManager().getDevicesForAttributes(STREAM_MUSIC_ATTRIBUTES);
        Iterator<AudioDeviceAttributes> r1 = streamMusicDevices.iterator();
    L7:
        if (r1.hasNext() == false) goto L19;
        AudioDeviceAttributes streamMusicDevice = r1.next();
        if (getAvbCapableAudioOutputDevices().contains(streamMusicDevice) == false) goto L7;
        if (mute == false) goto L12;
        int direction = -100;
    L13:
        int flags = 8192;
        if (isTvDevice() == false) goto L16;
        flags = 8192 | 1;
    L16:
        getAudioManager().adjustStreamVolume(3, direction, flags);
        return;
    L12:
        direction = 100;
        goto L13
    }

    void setStreamMusicVolume(int volume, int flags) {
        getAudioManager().setStreamVolume(3, (this.mStreamMusicMaxVolume * volume) / 100, flags);
    }

    private void initializeEarc(int initiatedBy) {
        Slog.i(TAG, "eARC initialized, reason = " + initiatedBy);
        initializeEarcLocalDevice(initiatedBy);
        if (initiatedBy != 6) goto L5;
        setEarcEnabledInHal(true, true);
        return;
    L5:
        setEarcEnabledInHal(true, false);
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void initializeEarcLocalDevice(int initiatedBy) {
        assertRunOnServiceThread();
        if (this.mEarcLocalDevice != null) goto L6;
        this.mEarcLocalDevice = HdmiEarcLocalDevice.create(this, 0);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void setEarcEnabled(int enabled) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = true;
        if (enabled == 1) goto L25;
        r1 = false;
    L25:
        this.mEarcEnabled = r1;     // Catch: Throwable -> L13
        if (isEarcSupported() == true) goto L16;
        Slog.i(TAG, "Enabled/disabled eARC setting, but the hardware doesn´t support eARC. This settings change doesn´t have an effect.");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
        if (this.mEarcEnabled == false) goto L20;
        onEnableEarc();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L13
        runOnServiceThread(new AnonymousClass35(this));
        return;
    L13:
        th = move-exception;
        throw th;
    }

    protected void setEarcSupported(boolean supported) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mEarcSupported = supported;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void onEnableEarc() {
        initializeEarc(6);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void onDisableEarc() {
        disableEarcLocalDevice();
        setEarcEnabledInHal(false, false);
        clearEarcLocalDevice();
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void clearEarcLocalDevice() {
        assertRunOnServiceThread();
        this.mEarcLocalDevice = null;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void addEarcLocalDevice(HdmiEarcLocalDevice localDevice) {
        assertRunOnServiceThread();
        this.mEarcLocalDevice = localDevice;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private int getEarcStatus() {
        assertRunOnServiceThread();
        if (this.mEarcLocalDevice == null) goto L12;
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mEarcLocalDevice.mEarcStatus;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L12:
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    HdmiEarcLocalDevice getEarcLocalDevice() {
        assertRunOnServiceThread();
        return this.mEarcLocalDevice;
    }

    private void disableEarcLocalDevice() {
        if (this.mEarcLocalDevice != null) goto L5;
        return;
    L5:
        this.mEarcLocalDevice.disableDevice();
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void setEarcEnabledInHal(final boolean r3, boolean r4) {
        assertRunOnServiceThread();
        if (r4 == false) goto L5;
        startArcAction(false, new AnonymousClass36(this, r3));
        return;
    L5:
        this.mEarcController.setEarcEnabled(r3);
        HdmiCecController r0 = this.mCecController;
        int r1 = this.mEarcPortId;
        r0.setHpdSignalType(r3 ? 1 : 0, r1);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void handleEarcStateChange(int status, int portId) {
        assertRunOnServiceThread();
        int oldEarcStatus = getEarcStatus();
        if (getPortInfo(portId).isEarcSupported() == true) goto L7;
        Slog.w(TAG, "Tried to update eARC status on a port that doesn't support eARC.");
        getAtomWriter().earcStatusChanged(isEarcSupported(), isEarcEnabled(), oldEarcStatus, status, 3);
        return;
    L7:
        if (this.mEarcLocalDevice == null) goto L10;
        this.mEarcLocalDevice.handleEarcStateChange(status);
        getAtomWriter().earcStatusChanged(isEarcSupported(), isEarcEnabled(), oldEarcStatus, status, 2);
        return;
    L10:
        if (status != 2) goto L12;
        HdmiLogger.debug("eARC state change [new: HDMI_EARC_STATUS_ARC_PENDING(2)]", new Object[0]);
        notifyEarcStatusToAudioService(false, new ArrayList());
        this.mHandler.postDelayed(new AnonymousClass37(this), 500);
        getAtomWriter().earcStatusChanged(isEarcSupported(), isEarcEnabled(), oldEarcStatus, status, 2);
        return;
    L12:
        getAtomWriter().earcStatusChanged(isEarcSupported(), isEarcEnabled(), oldEarcStatus, status, 4);
    }

    protected void notifyEarcStatusToAudioService(boolean r8, List<AudioDescriptor> r9) {
        AudioDeviceAttributes r0 = new AudioDeviceAttributes(2, 29, "", "", new ArrayList(), r9);
        if (isCecControlEnabled() == true) goto L5;
        setSystemAudioActivated(true);
    L5:
        getAudioManager().setWiredDeviceConnectionState(r0, r8 ? 1 : 0);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void handleEarcCapabilitiesReported(byte[] rawCapabilities, int portId) {
        assertRunOnServiceThread();
        if (getPortInfo(portId).isEarcSupported() == true) goto L7;
        Slog.w(TAG, "Tried to process eARC capabilities from a port that doesn't support eARC.");
        return;
    L7:
        if (this.mEarcLocalDevice == null) goto L10;
        this.mEarcLocalDevice.handleEarcCapabilitiesReported(rawCapabilities);
        return;
    }

    protected boolean earcBlocksArcConnection() {
        boolean r1 = false;
        if (this.mEarcLocalDevice != null) goto L5;
        return false;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mEarcLocalDevice.mEarcStatus == 2) goto L10;
        r1 = true;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    }

    protected void startArcAction(boolean enabled, IHdmiControlCallback callback) {
        if (isTvDeviceEnabled() == true) goto L5;
        invokeCallback(callback, 6);
        return;
    L5:
        tv().startArcAction(enabled, callback);
    }

    protected boolean isHdmiControlEnhancedBehaviorFlagEnabled() {
        return true;
    }

    protected boolean getDisableCecOnStandbyByLowEnergyMode() {
        return SystemProperties.getBoolean("persist.sys.hdmi.property_disable_cec_on_standby_in_low_energy_mode", false);
    }

    protected boolean getWasCecDisabledOnStandbyByLowEnergyMode() {
        return SystemProperties.getBoolean("persist.sys.hdmi.property_was_cec_disabled_on_standby_by_low_energy_mode", false);
    }

    protected void setWasCecDisabledOnStandbyByLowEnergyMode(boolean value) {
        writeStringSystemProperty("persist.sys.hdmi.property_was_cec_disabled_on_standby_by_low_energy_mode", String.valueOf(value));
    }

    protected void writePowerStateChangeOnActiveSourceLostAtom(boolean isSettingEnabled) {
        Display display = getContext().getDisplay();
        if (display == null) goto L5;
        DeviceProductInfo deviceProductInfo = display.getDeviceProductInfo();
        String manufacturerPnpId = deviceProductInfo.getManufacturerPnpId();
        int manufactureYear = deviceProductInfo.getManufactureYear();
        String manufacturerPnpId2 = manufacturerPnpId;
        int manufactureYear2 = manufactureYear;
    L7:
        if (playback() != null) goto L9;
        int enumLogReason = 0;
    L13:
        getAtomWriter().powerStateChangeOnActiveSourceLostChanged(isSettingEnabled, enumLogReason, manufacturerPnpId2, manufactureYear2, -1);
        return;
    L9:
        if (playback().isActiveSourceLostPopupLaunched() == false) goto L11;
        enumLogReason = 1;
        goto L13
    L11:
        enumLogReason = 2;
        goto L13
    L5:
        manufacturerPnpId2 = "undefined";
        manufactureYear2 = -1;
        goto L7
    }

    protected boolean userEnabledCecInOfflineMode() {
        return SystemProperties.getBoolean("persist.sys.hdmi.property_user_action_keep_cec_enabled_in_offline_mode", false);
    }
}
