package com.android.server.hdmi;

import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.util.Slog;
import com.android.internal.util.Preconditions;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes2.dex */
final class DeviceDiscoveryAction extends HdmiCecFeatureAction {
    private static final int STATE_WAITING_FOR_DEVICES = 5;
    private static final int STATE_WAITING_FOR_DEVICE_POLLING = 1;
    private static final int STATE_WAITING_FOR_OSD_NAME = 3;
    private static final int STATE_WAITING_FOR_PHYSICAL_ADDRESS = 2;
    private static final int STATE_WAITING_FOR_POWER = 6;
    private static final int STATE_WAITING_FOR_VENDOR_ID = 4;
    private static final String TAG = "DeviceDiscoveryAction";
    private final DeviceDiscoveryCallback mCallback;
    private final int mDelayPeriod;
    private final ArrayList<DeviceInfo> mDevices;
    private boolean mIsTvDevice;
    private int mProcessedDeviceCount;
    private int mTimeoutRetry;

    interface DeviceDiscoveryCallback {
        void onDeviceDiscoveryDone(List<HdmiDeviceInfo> r1);
    }

    private static final class DeviceInfo {
        private int mDeviceType;
        private String mDisplayName;
        private final int mLogicalAddress;
        private int mPhysicalAddress;
        private int mPortId;
        private int mPowerStatus;
        private int mVendorId;

        /* JADX INFO: renamed from: -$$Nest$fgetmDeviceType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4267$$Nest$fgetmDeviceType(DeviceInfo r0) {
            return r0.mDeviceType;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLogicalAddress, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4268$$Nest$fgetmLogicalAddress(DeviceInfo r0) {
            return r0.mLogicalAddress;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPhysicalAddress, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4269$$Nest$fgetmPhysicalAddress(DeviceInfo r0) {
            return r0.mPhysicalAddress;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDeviceType, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4270$$Nest$fputmDeviceType(DeviceInfo r0, int r1) {
            r0.mDeviceType = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDisplayName, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4271$$Nest$fputmDisplayName(DeviceInfo r0, String r1) {
            r0.mDisplayName = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmPhysicalAddress, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4272$$Nest$fputmPhysicalAddress(DeviceInfo r0, int r1) {
            r0.mPhysicalAddress = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmPortId, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4273$$Nest$fputmPortId(DeviceInfo r0, int r1) {
            r0.mPortId = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmPowerStatus, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4274$$Nest$fputmPowerStatus(DeviceInfo r0, int r1) {
            r0.mPowerStatus = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmVendorId, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4275$$Nest$fputmVendorId(DeviceInfo r0, int r1) {
            r0.mVendorId = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mtoHdmiDeviceInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ HdmiDeviceInfo m4276$$Nest$mtoHdmiDeviceInfo(DeviceInfo r0) {
            return r0.toHdmiDeviceInfo();
        }

        /* synthetic */ DeviceInfo(int r1, DeviceDiscoveryActionIA r2) {
            this(r1);
        }

        private DeviceInfo(int logicalAddress) {
            this.mPhysicalAddress = 65535;
            this.mPortId = -1;
            this.mVendorId = AudioFormat.SUB_MASK;
            this.mPowerStatus = -1;
            this.mDisplayName = "";
            this.mDeviceType = -1;
            this.mLogicalAddress = logicalAddress;
        }

        private HdmiDeviceInfo toHdmiDeviceInfo() {
            return HdmiDeviceInfo.cecDeviceBuilder().setLogicalAddress(this.mLogicalAddress).setPhysicalAddress(this.mPhysicalAddress).setPortId(this.mPortId).setVendorId(this.mVendorId).setDeviceType(this.mDeviceType).setDisplayName(this.mDisplayName).setDevicePowerStatus(this.mPowerStatus).build();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDelayPeriod, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4262$$Nest$fgetmDelayPeriod(DeviceDiscoveryAction r0) {
        return r0.mDelayPeriod;
    }

    /* JADX INFO: renamed from: -$$Nest$mallocateDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4263$$Nest$mallocateDevices(DeviceDiscoveryAction r0, List r1) {
        r0.allocateDevices(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartPhysicalAddressStage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4264$$Nest$mstartPhysicalAddressStage(DeviceDiscoveryAction r0) {
        r0.startPhysicalAddressStage();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartToDelayAction, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4265$$Nest$mstartToDelayAction(DeviceDiscoveryAction r0) {
        r0.startToDelayAction();
    }

    /* JADX INFO: renamed from: -$$Nest$mwrapUpAndFinish, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4266$$Nest$mwrapUpAndFinish(DeviceDiscoveryAction r0) {
        r0.wrapUpAndFinish();
    }

    DeviceDiscoveryAction(HdmiCecLocalDevice source, DeviceDiscoveryCallback callback, int delay) {
        super(source);
        this.mDevices = new ArrayList();
        this.mProcessedDeviceCount = 0;
        this.mTimeoutRetry = 0;
        this.mIsTvDevice = localDevice().mService.isTvDevice();
        callback.getClass();
        this.mCallback = callback;
        this.mDelayPeriod = delay;
    }

    DeviceDiscoveryAction(HdmiCecLocalDevice source, DeviceDiscoveryCallback callback) {
        this(source, callback, 0);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        this.mDevices.clear();
        this.mState = 1;
        pollDevices(new AnonymousClass1(this), 131073, 1);
        return true;
    }

    private void allocateDevices(List<Integer> addresses) {
        Iterator<Integer> r0 = addresses.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Integer i = r0.next();
        DeviceInfo info = new DeviceInfo(i.intValue(), null);
        this.mDevices.add(info);
        goto L4
    }

    private void startToDelayAction() {
        Slog.v(TAG, "Waiting for connected devices to be ready");
        this.mState = 5;
        checkAndProceedStage();
    }

    private void startPhysicalAddressStage() {
        Slog.v(TAG, "Start [Physical Address Stage]:" + this.mDevices.size());
        this.mProcessedDeviceCount = 0;
        this.mState = 2;
        checkAndProceedStage();
    }

    private boolean verifyValidLogicalAddress(int address) {
        if (address >= 0) goto L4;
    L6:
        return false;
    L4:
        if (address >= 15) goto L6;
        return true;
    }

    private void queryPhysicalAddress(int address) {
        if (verifyValidLogicalAddress(address) == true) goto L6;
        checkAndProceedStage();
        return;
    L6:
        this.mActionTimer.clearTimerMessage();
        if (mayProcessMessageIfCached(address, 132) == false) goto L9;
        return;
    L9:
        sendCommand(HdmiCecMessageBuilder.buildGivePhysicalAddress(getSourceAddress(), address));
        addTimer(this.mState, 2000);
    }

    private void delayActionWithTimePeriod(int timeDelay) {
        this.mActionTimer.clearTimerMessage();
        addTimer(this.mState, timeDelay);
    }

    private void startOsdNameStage() {
        Slog.v(TAG, "Start [Osd Name Stage]:" + this.mDevices.size());
        this.mProcessedDeviceCount = 0;
        this.mState = 3;
        checkAndProceedStage();
    }

    private void queryOsdName(int address) {
        if (verifyValidLogicalAddress(address) == true) goto L6;
        checkAndProceedStage();
        return;
    L6:
        this.mActionTimer.clearTimerMessage();
        if (mayProcessMessageIfCached(address, 71) == false) goto L9;
        return;
    L9:
        sendCommand(HdmiCecMessageBuilder.buildGiveOsdNameCommand(getSourceAddress(), address));
        addTimer(this.mState, 2000);
    }

    private void startVendorIdStage() {
        Slog.v(TAG, "Start [Vendor Id Stage]:" + this.mDevices.size());
        this.mProcessedDeviceCount = 0;
        this.mState = 4;
        checkAndProceedStage();
    }

    private void queryVendorId(int address) {
        if (verifyValidLogicalAddress(address) == true) goto L6;
        checkAndProceedStage();
        return;
    L6:
        this.mActionTimer.clearTimerMessage();
        if (mayProcessMessageIfCached(address, 135) == false) goto L9;
        return;
    L9:
        sendCommand(HdmiCecMessageBuilder.buildGiveDeviceVendorIdCommand(getSourceAddress(), address));
        addTimer(this.mState, 2000);
    }

    private void startPowerStatusStage() {
        Slog.v(TAG, "Start [Power Status Stage]:" + this.mDevices.size());
        this.mProcessedDeviceCount = 0;
        this.mState = 6;
        checkAndProceedStage();
    }

    private void queryPowerStatus(int address) {
        if (verifyValidLogicalAddress(address) == true) goto L6;
        checkAndProceedStage();
        return;
    L6:
        this.mActionTimer.clearTimerMessage();
        if (mayProcessMessageIfCached(address, 144) == false) goto L9;
        return;
    L9:
        sendCommand(HdmiCecMessageBuilder.buildGiveDevicePowerStatus(getSourceAddress(), address));
        addTimer(this.mState, 2000);
    }

    private boolean mayProcessMessageIfCached(int address, int opcode) {
        HdmiCecMessage message = getCecMessageCache().getMessage(address, opcode);
        if (message == null) goto L6;
        processCommand(message);
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        switch(this.mState) {
            case 2: goto L39;
            case 3: goto L28;
            case 4: goto L17;
            case 5: goto L4;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        if (cmd.getOpcode() != 144) goto L10;
        handleReportPowerStatus(cmd);
        return true;
    L10:
        if (cmd.getOpcode() == 0) goto L12;
    L15:
        return false;
    L12:
        if ((cmd.getParams()[0] & CecDeviceType.INACTIVE) != 144) goto L15;
        handleReportPowerStatus(cmd);
        return true;
    L17:
        if (cmd.getOpcode() != 135) goto L21;
        handleVendorId(cmd);
        return true;
    L21:
        if (cmd.getOpcode() == 0) goto L23;
    L26:
        return false;
    L23:
        if ((cmd.getParams()[0] & CecDeviceType.INACTIVE) != 140) goto L26;
        handleVendorId(cmd);
        return true;
    L28:
        if (cmd.getOpcode() != 71) goto L32;
        handleSetOsdName(cmd);
        return true;
    L32:
        if (cmd.getOpcode() == 0) goto L34;
    L37:
        return false;
    L34:
        if ((cmd.getParams()[0] & CecDeviceType.INACTIVE) != 70) goto L37;
        handleSetOsdName(cmd);
        return true;
    L39:
        if (cmd.getOpcode() != 132) goto L42;
        handleReportPhysicalAddress(cmd);
        return true;
    L42:
        return false;
    }

    private void handleReportPhysicalAddress(HdmiCecMessage cmd) {
        if (this.mProcessedDeviceCount >= this.mDevices.size()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        DeviceInfo current = this.mDevices.get(this.mProcessedDeviceCount);
        if (DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) == cmd.getSource()) goto L10;
        Slog.w(TAG, "Unmatched address[expected:" + DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) + ", actual:" + cmd.getSource());
        return;
    L10:
        byte[] params = cmd.getParams();
        DeviceInfo.m4272$$Nest$fputmPhysicalAddress(current, HdmiUtils.twoBytesToInt(params));
        DeviceInfo.m4273$$Nest$fputmPortId(current, getPortId(DeviceInfo.m4269$$Nest$fgetmPhysicalAddress(current)));
        DeviceInfo.m4270$$Nest$fputmDeviceType(current, params[2] & CecDeviceType.INACTIVE);
        DeviceInfo.m4271$$Nest$fputmDisplayName(current, "");
        if (this.mIsTvDevice == false) goto L13;
        localDevice().mService.getHdmiCecNetwork().updateCecSwitchInfo(DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current), DeviceInfo.m4267$$Nest$fgetmDeviceType(current), DeviceInfo.m4269$$Nest$fgetmPhysicalAddress(current));
    L13:
        increaseProcessedDeviceCount();
        checkAndProceedStage();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int getPortId(int physicalAddress) {
        if (this.mIsTvDevice == false) goto L6;
        return tv().getPortId(physicalAddress);
    L6:
        return source().getPortId(physicalAddress);
    }

    private void handleSetOsdName(HdmiCecMessage cmd) {
        if (this.mProcessedDeviceCount >= this.mDevices.size()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        DeviceInfo current = this.mDevices.get(this.mProcessedDeviceCount);
        if (DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) == cmd.getSource()) goto L10;
        Slog.w(TAG, "Unmatched address[expected:" + DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) + ", actual:" + cmd.getSource());
        return;
    L10:
        String displayName = "";
        if (cmd.getOpcode() == 0) goto L19;
        displayName = new String(cmd.getParams(), CharsetNames.US_ASCII);     // Catch: UnsupportedEncodingException -> L15
    L19:
        DeviceInfo.m4271$$Nest$fputmDisplayName(current, displayName);
        increaseProcessedDeviceCount();
        checkAndProceedStage();
        return;
    L18:
        Slog.w(TAG, "Failed to decode display name: " + cmd.toString());
        goto L19
    L5:
        r0 = false;
        goto L6
    }

    private void handleVendorId(HdmiCecMessage cmd) {
        if (this.mProcessedDeviceCount >= this.mDevices.size()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        DeviceInfo current = this.mDevices.get(this.mProcessedDeviceCount);
        if (DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) == cmd.getSource()) goto L11;
        Slog.w(TAG, "Unmatched address[expected:" + DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) + ", actual:" + cmd.getSource());
        return;
    L11:
        if (cmd.getOpcode() == 0) goto L13;
        byte[] params = cmd.getParams();
        int vendorId = HdmiUtils.threeBytesToInt(params);
        DeviceInfo.m4275$$Nest$fputmVendorId(current, vendorId);
    L13:
        increaseProcessedDeviceCount();
        checkAndProceedStage();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void handleReportPowerStatus(HdmiCecMessage cmd) {
        if (this.mProcessedDeviceCount >= this.mDevices.size()) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        DeviceInfo current = this.mDevices.get(this.mProcessedDeviceCount);
        if (DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) == cmd.getSource()) goto L11;
        Slog.w(TAG, "Unmatched address[expected:" + DeviceInfo.m4268$$Nest$fgetmLogicalAddress(current) + ", actual:" + cmd.getSource());
        return;
    L11:
        if (cmd.getOpcode() == 0) goto L13;
        byte[] params = cmd.getParams();
        int powerStatus = params[0] & CecDeviceType.INACTIVE;
        DeviceInfo.m4274$$Nest$fputmPowerStatus(current, powerStatus);
    L13:
        increaseProcessedDeviceCount();
        checkAndProceedStage();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void increaseProcessedDeviceCount() {
        this.mProcessedDeviceCount++;
        this.mTimeoutRetry = 0;
    }

    private void removeDevice(int index) {
        this.mDevices.remove(index);
    }

    private void wrapUpAndFinish() {
        Slog.v(TAG, "---------Wrap up Device Discovery:[" + this.mDevices.size() + "]---------");
        ArrayList<HdmiDeviceInfo> result = new ArrayList();
        Iterator<DeviceInfo> r2 = this.mDevices.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        DeviceInfo info = r2.next();
        HdmiDeviceInfo cecDeviceInfo = DeviceInfo.m4276$$Nest$mtoHdmiDeviceInfo(info);
        Slog.v(TAG, " DeviceInfo: " + cecDeviceInfo);
        result.add(cecDeviceInfo);
        goto L4
    L6:
        Slog.v(TAG, "--------------------------------------------");
        this.mCallback.onDeviceDiscoveryDone(result);
        finish();
        if (this.mIsTvDevice == false) goto L11;
        tv().processAllDelayedMessages();
        return;
    }

    private void checkAndProceedStage() {
        if (this.mDevices.isEmpty() == false) goto L7;
        wrapUpAndFinish();
        return;
    L7:
        if (this.mProcessedDeviceCount != this.mDevices.size()) goto L19;
        this.mProcessedDeviceCount = 0;
        switch(this.mState) {
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L11;
            default: goto L10;
        };
    L10:
        return;
    L11:
        wrapUpAndFinish();
        return;
    L13:
        startPowerStatusStage();
        return;
    L15:
        startVendorIdStage();
        return;
    L17:
        startOsdNameStage();
        return;
    L19:
        sendQueryCommand();
    }

    private void sendQueryCommand() {
        int address = DeviceInfo.m4268$$Nest$fgetmLogicalAddress(this.mDevices.get(this.mProcessedDeviceCount));
        switch(this.mState) {
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        queryPowerStatus(address);
        return;
    L7:
        delayActionWithTimePeriod(this.mDelayPeriod);
        return;
    L9:
        queryVendorId(address);
        return;
    L11:
        queryOsdName(address);
        return;
    L13:
        queryPhysicalAddress(address);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState != 0) goto L5;
        return;
    L5:
        if (this.mState == state) goto L8;
        return;
    L8:
        if (this.mState != 5) goto L11;
        startPhysicalAddressStage();
        return;
    L11:
        int r0 = this.mTimeoutRetry + 1;
        this.mTimeoutRetry = r0;
        if (r0 >= 5) goto L15;
        sendQueryCommand();
        return;
    L15:
        this.mTimeoutRetry = 0;
        Slog.v(TAG, "Timeout[State=" + this.mState + ", Processed=" + this.mProcessedDeviceCount);
        if (this.mState != 6) goto L18;
    L20:
        increaseProcessedDeviceCount();
    L21:
        checkAndProceedStage();
        return;
    L18:
        if (this.mState == 3) goto L20;
        removeDevice(this.mProcessedDeviceCount);
        goto L21
    }
}
