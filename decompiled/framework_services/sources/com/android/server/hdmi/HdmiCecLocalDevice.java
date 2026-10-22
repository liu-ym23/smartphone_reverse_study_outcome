package com.android.server.hdmi;

import android.hardware.hdmi.DeviceFeatures;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.input.InputManagerGlobal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Slog;
import android.view.KeyEvent;
import com.android.internal.util.IndentingPrintWriter;
import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
abstract class HdmiCecLocalDevice extends HdmiLocalDevice {
    private static final int FOLLOWER_SAFETY_TIMEOUT = 550;
    private static final int MAX_HDMI_ACTIVE_SOURCE_HISTORY = 10;
    private static final int MSG_DISABLE_DEVICE_TIMEOUT = 1;
    private static final int MSG_USER_CONTROL_RELEASE_TIMEOUT = 2;
    private static final String TAG = "HdmiCecLocalDevice";
    final ArrayList<HdmiCecFeatureAction> mActions;
    private int mActiveRoutingPath;
    private final ArrayBlockingQueue<HdmiCecController.Dumpable> mActiveSourceHistory;
    protected final HdmiCecMessageCache mCecMessageCache;
    private HdmiDeviceInfo mDeviceInfo;
    private final Handler mHandler;
    protected int mLastKeyRepeatCount;
    protected int mLastKeycode;
    protected PendingActionClearedCallback mPendingActionClearedCallback;
    protected int mPreferredAddress;
    HdmiCecStandbyModeHandler mStandbyHandler;

    static class ActiveSource {
        int logicalAddress;
        int physicalAddress;

        public ActiveSource() {
            invalidate();
        }

        public ActiveSource(int logical, int physical) {
            this.logicalAddress = logical;
            this.physicalAddress = physical;
        }

        public static ActiveSource of(ActiveSource source) {
            return new ActiveSource(source.logicalAddress, source.physicalAddress);
        }

        public static ActiveSource of(int logical, int physical) {
            return new ActiveSource(logical, physical);
        }

        public boolean isValid() {
            return HdmiUtils.isValidAddress(this.logicalAddress);
        }

        public void invalidate() {
            this.logicalAddress = -1;
            this.physicalAddress = 65535;
        }

        public boolean equals(int logical, int physical) {
            if (this.logicalAddress == logical) goto L5;
        L7:
            return false;
        L5:
            if (this.physicalAddress != physical) goto L7;
            return true;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ActiveSource) == false) goto L10;
            ActiveSource that = (ActiveSource) obj;
            if (that.logicalAddress == this.logicalAddress) goto L7;
            return false;
        L7:
            if (that.physicalAddress != this.physicalAddress) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.logicalAddress * 29) + this.physicalAddress;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            String physicalAddressString = "invalid";
            if (this.logicalAddress != (-1)) goto L5;
            String logicalAddressString = "invalid";
        L6:
            s.append("(");
            s.append(logicalAddressString);
            if (this.physicalAddress == 65535) goto L10;
            physicalAddressString = String.format("0x%04x", new Object[]{Integer.valueOf(this.physicalAddress)});
        L10:
            s.append(", ");
            s.append(physicalAddressString);
            s.append(")");
            return s.toString();
        L5:
            logicalAddressString = String.format("0x%02x", new Object[]{Integer.valueOf(this.logicalAddress)});
            goto L6
        }
    }

    private static final class ActiveSourceHistoryRecord extends HdmiCecController.Dumpable {
        private final ActiveSource mActiveSource;
        private final String mCaller;
        private final boolean mIsActiveSource;

        /* synthetic */ ActiveSourceHistoryRecord(ActiveSource r1, boolean r2, String r3, HdmiCecLocalDeviceIA r4) {
            this(r1, r2, r3);
        }

        private ActiveSourceHistoryRecord(ActiveSource mActiveSource, boolean mIsActiveSource, String caller) {
            this.mActiveSource = mActiveSource;
            this.mIsActiveSource = mIsActiveSource;
            this.mCaller = caller;
        }

        @Override // com.android.server.hdmi.HdmiCecController.Dumpable
        void dump(IndentingPrintWriter pw, SimpleDateFormat sdf) {
            pw.print("time=");
            pw.print(sdf.format(new Date(this.mTime)));
            pw.print(" active source=");
            pw.print(this.mActiveSource);
            pw.print(" isActiveSource=");
            pw.print(this.mIsActiveSource);
            pw.print(" from=");
            pw.println(this.mCaller);
        }
    }

    interface PendingActionClearedCallback {
        void onCleared(HdmiCecLocalDevice r1);
    }

    interface StandbyCompletedCallback {
        void onStandbyCompleted();
    }

    /* JADX INFO: renamed from: $r8$lambda$TP-Yg52jDlcLq4bvJArGa_JY-zo, reason: not valid java name */
    public static /* synthetic */ boolean m4290$r8$lambda$TPYg52jDlcLq4bvJArGa_JYzo(int r0, SetAudioVolumeLevelDiscoveryAction r1) {
        return lambda$querySetAudioVolumeLevelSupport$0(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$ntQiDh_QCwksfaP8Majl5DYq4Sk(int r0, HdmiCecLocalDevice r1) {
        return lambda$sendVolumeKeyEvent$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4291$$Nest$fgetmHandler(HdmiCecLocalDevice r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleDisableDeviceTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4292$$Nest$mhandleDisableDeviceTimeout(HdmiCecLocalDevice r0) {
        r0.handleDisableDeviceTimeout();
    }

    protected abstract int getPreferredAddress();

    protected abstract List<Integer> getRcFeatures();

    protected abstract int getRcProfile();

    protected abstract void onAddressAllocated(int r1, int r2);

    protected abstract void setPreferredAddress(int r1);

    protected HdmiCecLocalDevice(HdmiControlService service, int deviceType) {
        super(service, deviceType);
        this.mLastKeycode = -1;
        this.mLastKeyRepeatCount = 0;
        this.mActiveSourceHistory = new ArrayBlockingQueue(10);
        this.mCecMessageCache = new HdmiCecMessageCache();
        this.mActions = new ArrayList();
        this.mHandler = new AnonymousClass1(this);
    }

    static HdmiCecLocalDevice create(HdmiControlService service, int deviceType) {
        switch(deviceType) {
            case 0: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return new HdmiCecLocalDeviceAudioSystem(service);
    L8:
        return new HdmiCecLocalDevicePlayback(service);
    L10:
        return new HdmiCecLocalDeviceTv(service);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void init() {
        assertRunOnServiceThread();
        this.mPreferredAddress = getPreferredAddress();
        if (this.mHandler.hasMessages(1) == false) goto L5;
        this.mHandler.removeMessages(1);
        handleDisableDeviceTimeout();
    L5:
        this.mPendingActionClearedCallback = null;
    }

    protected boolean isInputReady(int deviceId) {
        return true;
    }

    protected boolean canGoToStandby() {
        return true;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int dispatchMessage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int dest = message.getDestination();
        if (dest == this.mDeviceInfo.getLogicalAddress()) goto L9;
        if (dest == 15) goto L9;
        return -2;
    L9:
        if (this.mService.isPowerStandby() == true) goto L11;
    L16:
        this.mCecMessageCache.cacheMessage(message);
        return onMessage(message);
    L11:
        if (this.mService.isWakeUpMessageReceived() == true) goto L16;
        if (this.mStandbyHandler.handleCommand(message) == false) goto L16;
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected boolean isAlreadyActiveSource(HdmiDeviceInfo targetDevice, int targetAddress, IHdmiControlCallback callback) {
        ActiveSource active = getActiveSource();
        if (targetDevice.getDevicePowerStatus() == 0) goto L5;
    L10:
        return false;
    L5:
        if (active.isValid() == false) goto L10;
        if (targetAddress != active.logicalAddress) goto L10;
        invokeCallback(callback, 0);
        return true;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void clearDeviceInfoList() {
        assertRunOnServiceThread();
        this.mService.getHdmiCecNetwork().clearDeviceList();
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected final int onMessage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (dispatchMessageToAction(message) == false) goto L7;
        return -1;
    L7:
        if ((message instanceof SetAudioVolumeLevelMessage) == false) goto L11;
        return handleSetAudioVolumeLevel((SetAudioVolumeLevelMessage) message);
    L11:
        switch(message.getOpcode()) {
            case 4: goto L103;
            case 10: goto L101;
            case 13: goto L99;
            case 15: goto L97;
            case 50: goto L95;
            case 53: goto L93;
            case 54: goto L91;
            case 67: goto L89;
            case 68: goto L87;
            case 69: goto L85;
            case 70: goto L83;
            case 71: goto L81;
            case 112: goto L79;
            case 113: goto L77;
            case 114: goto L75;
            case 122: goto L73;
            case 125: goto L71;
            case 126: goto L69;
            case 128: goto L67;
            case 129: goto L65;
            case 130: goto L63;
            case 131: goto L61;
            case 132: goto L59;
            case 133: goto L57;
            case 134: goto L55;
            case 137: goto L53;
            case 140: goto L51;
            case 141: goto L49;
            case 142: goto L47;
            case 143: goto L45;
            case 144: goto L43;
            case 145: goto L41;
            case 157: goto L39;
            case 158: goto L37;
            case 159: goto L35;
            case 160: goto L33;
            case 163: goto L31;
            case 164: goto L29;
            case 165: goto L27;
            case 192: goto L25;
            case 193: goto L23;
            case 194: goto L21;
            case 195: goto L19;
            case 196: goto L17;
            case 197: goto L15;
            default: goto L12;
        };
    L12:
        return -2;
    L15:
        return handleTerminateArc(message);
    L17:
        return handleRequestArcTermination(message);
    L19:
        return handleRequestArcInitiate(message);
    L21:
        return handleReportArcTermination(message);
    L23:
        return handleReportArcInitiate(message);
    L25:
        return handleInitiateArc(message);
    L27:
        return handleGiveFeatures(message);
    L29:
        return handleRequestShortAudioDescriptor(message);
    L31:
        return handleReportShortAudioDescriptor(message);
    L33:
        return handleVendorCommandWithId(message);
    L35:
        return handleGetCecVersion(message);
    L37:
        return handleCecVersion();
    L39:
        return handleInactiveSource(message);
    L41:
        return handleGetMenuLanguage(message);
    L43:
        return handleReportPowerStatus(message);
    L45:
        return handleGiveDevicePowerStatus(message);
    L47:
        return handleMenuStatus(message);
    L49:
        return handleMenuRequest(message);
    L51:
        return handleGiveDeviceVendorId(message);
    L53:
        return handleVendorCommand(message);
    L55:
        return handleSetStreamPath(message);
    L57:
        return handleRequestActiveSource(message);
    L59:
        return handleReportPhysicalAddress(message);
    L61:
        return handleGivePhysicalAddress(message);
    L63:
        return handleActiveSource(message);
    L65:
        return handleRoutingInformation(message);
    L67:
        return handleRoutingChange(message);
    L69:
        return handleSystemAudioModeStatus(message);
    L71:
        return handleGiveSystemAudioModeStatus(message);
    L73:
        return handleReportAudioStatus(message);
    L75:
        return handleSetSystemAudioMode(message);
    L77:
        return handleGiveAudioStatus(message);
    L79:
        return handleSystemAudioModeRequest(message);
    L81:
        return handleSetOsdName(message);
    L83:
        return handleGiveOsdName(message);
    L85:
        return handleUserControlReleased();
    L87:
        return handleUserControlPressed(message);
    L89:
        return handleTimerClearedStatus(message);
    L91:
        return handleStandby(message);
    L93:
        return handleTimerStatus(message);
    L95:
        return handleSetMenuLanguage(message);
    L97:
        return handleRecordTvScreen(message);
    L99:
        return handleTextViewOn(message);
    L101:
        return handleRecordStatus(message);
    L103:
        return handleImageViewOn(message);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private boolean dispatchMessageToAction(HdmiCecMessage message) {
        assertRunOnServiceThread();
        boolean processed = false;
        Iterator r1 = new ArrayList(this.mActions).iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        HdmiCecFeatureAction action = (HdmiCecFeatureAction) r1.next();
        boolean result = action.processCommand(message);
        if (processed == true) goto L10;
        if (result == true) goto L10;
        boolean r4 = false;
    L11:
        processed = r4;
    L10:
        r4 = true;
        goto L11
    L12:
        return processed;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGivePhysicalAddress(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int physicalAddress = this.mService.getPhysicalAddress();
        if (physicalAddress != 65535) goto L5;
        this.mService.maySendFeatureAbortCommand(message, 5);
        return -1;
    L5:
        HdmiCecMessage cecMessage = HdmiCecMessageBuilder.buildReportPhysicalAddressCommand(this.mDeviceInfo.getLogicalAddress(), physicalAddress, this.mDeviceType);
        this.mService.sendCecCommand(cecMessage);
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGiveDeviceVendorId(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int vendorId = this.mService.getVendorId();
        if (vendorId != 1) goto L5;
        this.mService.maySendFeatureAbortCommand(message, 5);
        return -1;
    L5:
        HdmiCecMessage cecMessage = HdmiCecMessageBuilder.buildDeviceVendorIdCommand(this.mDeviceInfo.getLogicalAddress(), vendorId);
        this.mService.sendCecCommand(cecMessage);
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGetCecVersion(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int version = this.mService.getCecVersion();
        HdmiCecMessage cecMessage = HdmiCecMessageBuilder.buildCecVersion(message.getDestination(), message.getSource(), version);
        this.mService.sendCecCommand(cecMessage);
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleCecVersion() {
        assertRunOnServiceThread();
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleActiveSource(HdmiCecMessage message) {
        return -2;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleInactiveSource(HdmiCecMessage message) {
        return -2;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRequestActiveSource(HdmiCecMessage message) {
        return -2;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGetMenuLanguage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        Slog.w(TAG, "Only TV can handle <Get Menu Language>:" + message.toString());
        return -2;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSetMenuLanguage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        Slog.w(TAG, "Only Playback device can handle <Set Menu Language>:" + message.toString());
        return -2;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGiveOsdName(HdmiCecMessage message) {
        assertRunOnServiceThread();
        buildAndSendSetOsdName(message.getSource());
        return -1;
    }

    protected void buildAndSendSetOsdName(int dest) {
        final HdmiCecMessage cecMessage = HdmiCecMessageBuilder.buildSetOsdNameCommand(this.mDeviceInfo.getLogicalAddress(), dest, this.mDeviceInfo.getDisplayName());
        if (cecMessage == null) goto L5;
        this.mService.sendCecCommand(cecMessage, new AnonymousClass2(this, cecMessage));
        return;
    L5:
        Slog.w(TAG, "Failed to build <Get Osd Name>:" + this.mDeviceInfo.getDisplayName());
    }

    protected int handleRoutingChange(HdmiCecMessage message) {
        return -2;
    }

    protected int handleRoutingInformation(HdmiCecMessage message) {
        return -2;
    }

    protected int handleReportPhysicalAddress(HdmiCecMessage message) {
        int address = message.getSource();
        if (hasAction(DeviceDiscoveryAction.class) == false) goto L6;
        Slog.i(TAG, "Ignored while Device Discovery Action is in progress: " + message);
        return -1;
    L6:
        HdmiDeviceInfo cecDeviceInfo = this.mService.getHdmiCecNetwork().getCecDeviceInfo(address);
        if (this.mService.isTvDevice() == true) goto L12;
        if (cecDeviceInfo == null) goto L12;
        if (cecDeviceInfo.getDisplayName().equals(HdmiUtils.getDefaultDeviceName(address)) == false) goto L12;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildGiveOsdNameCommand(this.mDeviceInfo.getLogicalAddress(), address));
    L12:
        return -1;
    }

    protected int handleSystemAudioModeStatus(HdmiCecMessage message) {
        return -2;
    }

    protected int handleGiveSystemAudioModeStatus(HdmiCecMessage message) {
        return -2;
    }

    protected int handleSetSystemAudioMode(HdmiCecMessage message) {
        return -2;
    }

    protected int handleSystemAudioModeRequest(HdmiCecMessage message) {
        return -2;
    }

    protected int handleTerminateArc(HdmiCecMessage message) {
        return -2;
    }

    protected int handleInitiateArc(HdmiCecMessage message) {
        return -2;
    }

    protected int handleRequestArcInitiate(HdmiCecMessage message) {
        return -2;
    }

    protected int handleRequestArcTermination(HdmiCecMessage message) {
        return -2;
    }

    protected int handleReportArcInitiate(HdmiCecMessage message) {
        return -2;
    }

    protected int handleReportArcTermination(HdmiCecMessage message) {
        return -2;
    }

    protected int handleReportAudioStatus(HdmiCecMessage message) {
        return -2;
    }

    protected int handleGiveAudioStatus(HdmiCecMessage message) {
        return -2;
    }

    protected int handleRequestShortAudioDescriptor(HdmiCecMessage message) {
        return -2;
    }

    protected int handleReportShortAudioDescriptor(HdmiCecMessage message) {
        return -2;
    }

    protected int handleSetAudioVolumeLevel(SetAudioVolumeLevelMessage message) {
        return -2;
    }

    protected void preprocessBufferedMessages(List<HdmiCecMessage> bufferedMessages) {
    }

    protected DeviceFeatures computeDeviceFeatures() {
        return DeviceFeatures.NO_FEATURES_SUPPORTED;
    }

    private void updateDeviceFeatures() {
        setDeviceInfo(getDeviceInfo().toBuilder().setDeviceFeatures(computeDeviceFeatures()).build());
    }

    protected final DeviceFeatures getDeviceFeatures() {
        updateDeviceFeatures();
        return getDeviceInfo().getDeviceFeatures();
    }

    protected int handleGiveFeatures(HdmiCecMessage message) {
        if (this.mService.getCecVersion() >= 6) goto L6;
        return 0;
    L6:
        reportFeatures();
        return -1;
    }

    protected void reportFeatures() {
        List<Integer> localDeviceTypes = new ArrayList();
        Iterator<HdmiCecLocalDevice> r0 = this.mService.getAllCecLocalDevices().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        HdmiCecLocalDevice localDevice = r0.next();
        localDeviceTypes.add(Integer.valueOf(localDevice.mDeviceType));
        goto L4
    L6:
        int rcProfile = getRcProfile();
        List<Integer> rcFeatures = getRcFeatures();
        DeviceFeatures deviceFeatures = getDeviceFeatures();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int logicalAddress = this.mDeviceInfo.getLogicalAddress();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        this.mService.sendCecCommand(ReportFeaturesMessage.build(logicalAddress, this.mService.getCecVersion(), localDeviceTypes, rcProfile, rcFeatures, deviceFeatures));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleStandby(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L5;
        return 1;
    L5:
        if (this.mService.isProhibitMode() == false) goto L7;
        return 1;
    L7:
        if (this.mService.isPowerOnOrTransient() == false) goto L13;
        this.mService.standby();
        return -1;
    L13:
        return 1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleUserControlPressed(HdmiCecMessage message) {
        assertRunOnServiceThread();
        this.mHandler.removeMessages(2);
        if (this.mService.isPowerOnOrTransient() == false) goto L9;
        if (isPowerOffOrToggleCommand(message) == false) goto L9;
        this.mService.standby();
        return -1;
    L9:
        if (this.mService.isPowerStandbyOrTransient() == false) goto L15;
        if (isPowerOnOrToggleCommand(message) == false) goto L15;
        this.mService.wakeUp();
        return -1;
    L15:
        if (this.mService.getHdmiCecVolumeControl() != 0) goto L21;
        if (isVolumeOrMuteCommand(message) == false) goto L21;
        return 4;
    L21:
        if (isPowerOffOrToggleCommand(message) == false) goto L23;
    L41:
        return -1;
    L23:
        if (isPowerOnOrToggleCommand(message) == true) goto L41;
        long downTime = SystemClock.uptimeMillis();
        byte[] params = message.getParams();
        int keycode = HdmiCecKeycode.cecKeycodeAndParamsToAndroidKey(params);
        int keyRepeatCount = 0;
        if (this.mLastKeycode != (-1)) goto L28;
    L31:
        this.mLastKeycode = keycode;
        this.mLastKeyRepeatCount = keyRepeatCount;
        if (keycode == (-1)) goto L36;
        injectKeyEvent(downTime, 0, keycode, keyRepeatCount);
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 2), 550);
        return -1;
    L36:
        if (params.length > 0) goto L38;
        return 3;
    L38:
        return handleUnmappedCecKeycode(params[0]);
    L28:
        if (keycode != this.mLastKeycode) goto L30;
        keyRepeatCount = this.mLastKeyRepeatCount + 1;
        goto L31
    L30:
        injectKeyEvent(downTime, 1, this.mLastKeycode, 0);
        goto L31
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleUnmappedCecKeycode(int cecKeycode) {
        if (cecKeycode != 101) goto L7;
        this.mService.getAudioManager().adjustStreamVolume(3, -100, 1);
        return -1;
    L7:
        if (cecKeycode != 102) goto L10;
        this.mService.getAudioManager().adjustStreamVolume(3, 100, 1);
        return -1;
    L10:
        return 3;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected int handleUserControlReleased() {
        assertRunOnServiceThread();
        this.mHandler.removeMessages(2);
        this.mLastKeyRepeatCount = 0;
        if (this.mLastKeycode == (-1)) goto L5;
        long upTime = SystemClock.uptimeMillis();
        injectKeyEvent(upTime, 1, this.mLastKeycode, 0);
        this.mLastKeycode = -1;
    L5:
        return -1;
    }

    static void injectKeyEvent(long time, int action, int keycode, int repeat) {
        KeyEvent keyEvent = KeyEvent.obtain(time, time, action, keycode, repeat, 0, -1, 0, 8, 33554433, null);
        InputManagerGlobal.getInstance().injectInputEvent(keyEvent, 0);
        keyEvent.recycle();
    }

    static boolean isPowerOnOrToggleCommand(HdmiCecMessage message) {
        byte[] params = message.getParams();
        if (message.getOpcode() == 68) goto L5;
        return false;
    L5:
        if (params[0] != 64) goto L7;
    L10:
        return true;
    L7:
        if (params[0] == 109) goto L10;
        if (params[0] == 107) goto L10;
        return false;
    }

    static boolean isPowerOffOrToggleCommand(HdmiCecMessage message) {
        byte[] params = message.getParams();
        if (message.getOpcode() == 68) goto L5;
        return false;
    L5:
        if (params[0] != 108) goto L7;
    L8:
        return true;
    L7:
        if (params[0] == 107) goto L8;
        return false;
    }

    static boolean isVolumeOrMuteCommand(HdmiCecMessage message) {
        byte[] params = message.getParams();
        if (message.getOpcode() == 68) goto L5;
        return false;
    L5:
        if (params[0] != 66) goto L7;
    L14:
        return true;
    L7:
        if (params[0] == 65) goto L14;
        if (params[0] == 67) goto L14;
        if (params[0] == 101) goto L14;
        if (params[0] == 102) goto L14;
        return false;
    }

    protected int handleTextViewOn(HdmiCecMessage message) {
        return -2;
    }

    protected int handleImageViewOn(HdmiCecMessage message) {
        return -2;
    }

    protected int handleSetStreamPath(HdmiCecMessage message) {
        return -2;
    }

    protected int handleGiveDevicePowerStatus(HdmiCecMessage message) {
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportPowerStatus(this.mDeviceInfo.getLogicalAddress(), message.getSource(), this.mService.getPowerStatus()));
        return -1;
    }

    protected int handleMenuRequest(HdmiCecMessage message) {
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportMenuStatus(this.mDeviceInfo.getLogicalAddress(), message.getSource(), 0));
        return -1;
    }

    protected int handleMenuStatus(HdmiCecMessage message) {
        return -2;
    }

    protected int handleVendorCommand(HdmiCecMessage message) {
        if (this.mService.invokeVendorCommandListenersOnReceived(this.mDeviceType, message.getSource(), message.getDestination(), message.getParams(), false) == true) goto L6;
        return 4;
    L6:
        return -1;
    }

    protected int handleVendorCommandWithId(HdmiCecMessage message) {
        byte[] params = message.getParams();
        HdmiUtils.threeBytesToInt(params);
        if (this.mService.invokeVendorCommandListenersOnReceived(this.mDeviceType, message.getSource(), message.getDestination(), params, true) == false) goto L5;
        return -1;
    L5:
        if (message.getDestination() != 15) goto L7;
    L11:
        Slog.v(TAG, "Broadcast vendor command with no listeners. Ignoring");
        return -1;
    L7:
        if (message.getSource() == 15) goto L11;
        return 4;
    }

    protected void sendStandby(int deviceId) {
    }

    protected int handleSetOsdName(HdmiCecMessage message) {
        return -1;
    }

    protected int handleRecordTvScreen(HdmiCecMessage message) {
        return -2;
    }

    protected int handleTimerClearedStatus(HdmiCecMessage message) {
        return -2;
    }

    protected int handleReportPowerStatus(HdmiCecMessage message) {
        return -1;
    }

    protected int handleTimerStatus(HdmiCecMessage message) {
        return -2;
    }

    protected int handleRecordStatus(HdmiCecMessage message) {
        return -2;
    }

    @HdmiAnnotations.ServiceThreadOnly
    final void handleAddressAllocated(int logicalAddress, List<HdmiCecMessage> bufferedMessages, int reason) {
        assertRunOnServiceThread();
        preprocessBufferedMessages(bufferedMessages);
        this.mPreferredAddress = logicalAddress;
        updateDeviceFeatures();
        if (this.mService.getCecVersion() < 6) goto L5;
        reportFeatures();
    L5:
        onAddressAllocated(logicalAddress, reason);
        setPreferredAddress(logicalAddress);
    }

    int getType() {
        return this.mDeviceType;
    }

    HdmiDeviceInfo getDeviceInfo() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        HdmiDeviceInfo r1 = this.mDeviceInfo;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setDeviceInfo(HdmiDeviceInfo info) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDeviceInfo = info;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isAddressOf(int addr) {
        assertRunOnServiceThread();
        if (addr != this.mDeviceInfo.getLogicalAddress()) goto L5;
        return true;
    L5:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void addAndStartAction(HdmiCecFeatureAction action) {
        assertRunOnServiceThread();
        this.mActions.add(action);
        if (this.mService.isPowerStandby() == true) goto L10;
        if (this.mService.isAddressAllocated() == false) goto L10;
        action.start();
        return;
    L10:
        if (action.getClass() != ResendCecCommandAction.class) goto L13;
        Slog.i(TAG, "Not ready to start ResendCecCommandAction. This action is cancelled.");
        removeAction(action);
        return;
    L13:
        Slog.i(TAG, "Not ready to start action. Queued for deferred start:" + action);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void addAndStartAction(HdmiCecFeatureAction action, boolean remove) {
        assertRunOnServiceThread();
        if (hasAction(action.getClass()) == false) goto L6;
        if (remove == false) goto L6;
        Slog.i(TAG, action.getClass().getName() + " is in progress. Restarting.");
        removeAction(action.getClass());
    L6:
        addAndStartAction(action);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void startNewAvbAudioStatusAction(int targetAddress) {
        assertRunOnServiceThread();
        addAndStartAction(new AbsoluteVolumeAudioStatusAction(this, targetAddress), true);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void removeAvbAudioStatusAction() {
        assertRunOnServiceThread();
        removeAction(AbsoluteVolumeAudioStatusAction.class);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void updateAvbVolume(int volumeIndex) {
        assertRunOnServiceThread();
        Iterator r0 = getActions(AbsoluteVolumeAudioStatusAction.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AbsoluteVolumeAudioStatusAction action = (AbsoluteVolumeAudioStatusAction) r0.next();
        action.updateVolume(volumeIndex);
        goto L4
    }

    @HdmiAnnotations.ServiceThreadOnly
    void requestAndUpdateAvbAudioStatus() {
        assertRunOnServiceThread();
        Iterator r0 = getActions(AbsoluteVolumeAudioStatusAction.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AbsoluteVolumeAudioStatusAction action = (AbsoluteVolumeAudioStatusAction) r0.next();
        action.requestAndUpdateAudioStatus();
        goto L4
    }

    @HdmiAnnotations.ServiceThreadOnly
    void querySetAudioVolumeLevelSupport(final int targetAddress) {
        assertRunOnServiceThread();
        if (this.mService.getCecVersion() < 6) goto L5;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildGiveFeatures(getDeviceInfo().getLogicalAddress(), targetAddress));
    L5:
        List<SetAudioVolumeLevelDiscoveryAction> savlDiscoveryActions = getActions(SetAudioVolumeLevelDiscoveryAction.class);
        if (savlDiscoveryActions.stream().noneMatch(new HdmiCecLocalDevice$$ExternalSyntheticLambda0(targetAddress)) == false) goto L9;
        addAndStartAction(new SetAudioVolumeLevelDiscoveryAction(this, targetAddress, new AnonymousClass3(this)));
        return;
    }

    private static /* synthetic */ boolean lambda$querySetAudioVolumeLevelSupport$0(int targetAddress, SetAudioVolumeLevelDiscoveryAction a) {
        if (a.getTargetAddress() != targetAddress) goto L5;
        return true;
    L5:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void startQueuedActions() {
        assertRunOnServiceThread();
        Iterator r0 = new ArrayList(this.mActions).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        HdmiCecFeatureAction action = (HdmiCecFeatureAction) r0.next();
        if (action.started() == true) goto L4;
        Slog.i(TAG, "Starting queued action:" + action);
        action.start();
        goto L4
    }

    @HdmiAnnotations.ServiceThreadOnly
    <T extends HdmiCecFeatureAction> boolean hasAction(Class<T> clazz) {
        assertRunOnServiceThread();
        Iterator<HdmiCecFeatureAction> r0 = this.mActions.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        HdmiCecFeatureAction action = r0.next();
        if (action.getClass().equals(clazz) == false) goto L4;
        return true;
    L10:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    <T extends HdmiCecFeatureAction> List<T> getActions(Class<T> r5) {
        assertRunOnServiceThread();
        ArrayList r0 = (List<T>) Collections.emptyList();
        Iterator<HdmiCecFeatureAction> r1 = this.mActions.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        HdmiCecFeatureAction r2 = r1.next();
        if (r2.getClass().equals(r5) == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = new ArrayList();
    L10:
        r0.add(r2);
        goto L4
    L12:
        return (List<T>) r0;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void removeAction(HdmiCecFeatureAction action) {
        assertRunOnServiceThread();
        action.finish(false);
        this.mActions.remove(action);
        checkIfPendingActionsCleared();
    }

    @HdmiAnnotations.ServiceThreadOnly
    <T extends HdmiCecFeatureAction> void removeAction(Class<T> clazz) {
        assertRunOnServiceThread();
        removeActionExcept(clazz, null);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void removeAllActions() {
        assertRunOnServiceThread();
        Iterator<HdmiCecFeatureAction> r0 = this.mActions.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        HdmiCecFeatureAction action = r0.next();
        action.finish(false);
        goto L4
    L6:
        this.mActions.clear();
    }

    @HdmiAnnotations.ServiceThreadOnly
    <T extends HdmiCecFeatureAction> void removeActionExcept(Class<T> clazz, HdmiCecFeatureAction exception) {
        assertRunOnServiceThread();
        Iterator<HdmiCecFeatureAction> iter = this.mActions.iterator();
    L4:
        if (iter.hasNext() == false) goto L11;
        HdmiCecFeatureAction action = iter.next();
        if (action == exception) goto L4;
        if (action.getClass().equals(clazz) == false) goto L4;
        action.finish(false);
        iter.remove();
        goto L4
    L11:
        checkIfPendingActionsCleared();
    }

    protected void checkIfPendingActionsCleared() {
        if (this.mActions.isEmpty() == true) goto L5;
        return;
    L5:
        if (this.mPendingActionClearedCallback == null) goto L9;
        PendingActionClearedCallback callback = this.mPendingActionClearedCallback;
        this.mPendingActionClearedCallback = null;
        callback.onCleared(this);
        return;
    }

    protected void assertRunOnServiceThread() {
        if (Looper.myLooper() != this.mService.getServiceLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Should run on service thread.");
    }

    void onHotplug(int portId, boolean connected) {
    }

    final HdmiControlService getService() {
        return this.mService;
    }

    @HdmiAnnotations.ServiceThreadOnly
    final boolean isConnectedToArcPort(int path) {
        assertRunOnServiceThread();
        return this.mService.isConnectedToArcPort(path);
    }

    ActiveSource getActiveSource() {
        return this.mService.getLocalActiveSource();
    }

    void setActiveSource(ActiveSource newActive, String caller) {
        setActiveSource(newActive.logicalAddress, newActive.physicalAddress, caller);
    }

    void setActiveSource(HdmiDeviceInfo info, String caller) {
        setActiveSource(info.getLogicalAddress(), info.getPhysicalAddress(), caller);
    }

    void setActiveSource(int logicalAddress, int physicalAddress, String caller) {
        this.mService.setActiveSource(logicalAddress, physicalAddress, caller);
        this.mService.setLastInputForMhl(-1);
    }

    int getActivePath() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mActiveRoutingPath;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setActivePath(int path) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mActiveRoutingPath = path;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mService.setActivePortId(pathToPortId(path));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    int getActivePortId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mService.pathToPortId(this.mActiveRoutingPath);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setActivePortId(int portId) {
        setActivePath(this.mService.portIdToPath(portId));
    }

    int getPortId(int physicalAddress) {
        return this.mService.pathToPortId(physicalAddress);
    }

    @HdmiAnnotations.ServiceThreadOnly
    HdmiCecMessageCache getCecMessageCache() {
        assertRunOnServiceThread();
        return this.mCecMessageCache;
    }

    @HdmiAnnotations.ServiceThreadOnly
    int pathToPortId(int newPath) {
        assertRunOnServiceThread();
        return this.mService.pathToPortId(newPath);
    }

    protected void onStandby(boolean initiatedByCec, int standbyAction, StandbyCompletedCallback callback) {
    }

    protected void onStandby(boolean initiatedByCec, int standbyAction) {
        onStandby(initiatedByCec, standbyAction, null);
    }

    protected void onInitializeCecComplete(int initiatedBy) {
    }

    protected void disableDevice(boolean initiatedByCec, final PendingActionClearedCallback originalCallback) {
        removeAction(SetAudioVolumeLevelDiscoveryAction.class);
        removeAction(ActiveSourceAction.class);
        removeAction(ResendCecCommandAction.class);
        this.mPendingActionClearedCallback = new AnonymousClass4(this, originalCallback);
        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 1), 5000);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleDisableDeviceTimeout() {
        assertRunOnServiceThread();
        Iterator<HdmiCecFeatureAction> iter = this.mActions.iterator();
    L4:
        if (iter.hasNext() == false) goto L7;
        HdmiCecFeatureAction action = iter.next();
        action.finish(false);
        iter.remove();
        goto L4
    L7:
        if (this.mPendingActionClearedCallback == null) goto L11;
        PendingActionClearedCallback callback = this.mPendingActionClearedCallback;
        this.mPendingActionClearedCallback = null;
        callback.onCleared(this);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void sendKeyEvent(int keyCode, boolean isPressed) {
        assertRunOnServiceThread();
        if (HdmiCecKeycode.isSupportedKeycode(keyCode) == true) goto L6;
        Slog.w(TAG, "Unsupported key: " + keyCode);
        return;
    L6:
        List<SendKeyAction> action = getActions(SendKeyAction.class);
        int logicalAddress = findKeyReceiverAddress();
        if (logicalAddress != (-1)) goto L9;
    L16:
        Slog.w(TAG, "Discard key event: " + keyCode + ", pressed:" + isPressed + ", receiverAddr=" + logicalAddress);
        return;
    L9:
        if (logicalAddress == this.mDeviceInfo.getLogicalAddress()) goto L16;
        if (action.isEmpty() == true) goto L14;
        action.get(0).processKeyEvent(keyCode, isPressed);
        return;
    L14:
        if (isPressed == false) goto L19;
        addAndStartAction(new SendKeyAction(this, logicalAddress, keyCode));
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void sendVolumeKeyEvent(int keyCode, boolean isPressed) {
        assertRunOnServiceThread();
        if (this.mService.getHdmiCecVolumeControl() != 0) goto L6;
        return;
    L6:
        if (HdmiCecKeycode.isVolumeKeycode(keyCode) == true) goto L9;
        Slog.w(TAG, "Not a volume key: " + keyCode);
        return;
    L9:
        List<SendKeyAction> action = getActions(SendKeyAction.class);
        final int logicalAddress = findAudioReceiverAddress();
        if (logicalAddress != (-1)) goto L12;
    L19:
        Slog.w(TAG, "Discard volume key event: " + keyCode + ", pressed:" + isPressed + ", receiverAddr=" + logicalAddress);
        return;
    L12:
        if (this.mService.getAllCecLocalDevices().stream().anyMatch(new HdmiCecLocalDevice$$ExternalSyntheticLambda1(logicalAddress)) == true) goto L19;
        if (action.isEmpty() == true) goto L17;
        action.get(0).processKeyEvent(keyCode, isPressed);
        return;
    L17:
        if (isPressed == false) goto L22;
        addAndStartAction(new SendKeyAction(this, logicalAddress, keyCode));
        return;
    }

    private static /* synthetic */ boolean lambda$sendVolumeKeyEvent$1(int logicalAddress, HdmiCecLocalDevice device) {
        if (device.getDeviceInfo().getLogicalAddress() != logicalAddress) goto L5;
        return true;
    L5:
        return false;
    }

    protected int findKeyReceiverAddress() {
        Slog.w(TAG, "findKeyReceiverAddress is not implemented");
        return -1;
    }

    protected int findAudioReceiverAddress() {
        Slog.w(TAG, "findAudioReceiverAddress is not implemented");
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void invokeCallback(IHdmiControlCallback callback, int result) {
        assertRunOnServiceThread();
        if (callback != null) goto L10;
        return;
    L10:
        callback.onComplete(result);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Invoking callback failed:" + e);
    }

    @HdmiAnnotations.ServiceThreadOnly
    public void invokeStandbyCompletedCallback(StandbyCompletedCallback callback) {
        assertRunOnServiceThread();
        if (callback != null) goto L5;
        return;
    L5:
        callback.onStandbyCompleted();
    }

    void sendUserControlPressedAndReleased(int targetAddress, int cecKeycode) {
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildUserControlPressed(this.mDeviceInfo.getLogicalAddress(), targetAddress, cecKeycode));
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildUserControlReleased(this.mDeviceInfo.getLogicalAddress(), targetAddress));
    }

    void addActiveSourceHistoryItem(ActiveSource activeSource, boolean isActiveSource, String caller) {
        ActiveSourceHistoryRecord record = new ActiveSourceHistoryRecord(activeSource, isActiveSource, caller, null);
        if (this.mActiveSourceHistory.offer(record) == true) goto L6;
        this.mActiveSourceHistory.poll();
        this.mActiveSourceHistory.offer(record);
        return;
    }

    public ArrayBlockingQueue<HdmiCecController.Dumpable> getActiveSourceHistory() {
        return this.mActiveSourceHistory;
    }

    protected void dump(IndentingPrintWriter pw) {
        pw.println("mDeviceType: " + this.mDeviceType);
        pw.println("mPreferredAddress: " + this.mPreferredAddress);
        pw.println("mDeviceInfo: " + this.mDeviceInfo);
        pw.println("mActiveSource: " + getActiveSource());
        pw.println(String.format("mActiveRoutingPath: 0x%04x", new Object[]{Integer.valueOf(this.mActiveRoutingPath)}));
    }

    protected int getActivePathOnSwitchFromActivePortId(int activePortId) {
        int myPhysicalAddress = this.mService.getPhysicalAddress();
        int finalMask = activePortId << 8;
        int mask = CaeNfcCardInfo.LIFE_CYCLE_INACTIVE;
    L4:
        if (mask <= 15) goto L10;
        if ((myPhysicalAddress & mask) == 0) goto L10;
        finalMask = finalMask >> 4;
        mask = mask >> 4;
    L10:
        return finalMask | myPhysicalAddress;
    }
}
