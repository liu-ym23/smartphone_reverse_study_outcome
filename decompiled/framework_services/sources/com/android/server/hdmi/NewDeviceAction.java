package com.android.server.hdmi;

import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.util.Slog;
import java.io.UnsupportedEncodingException;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes2.dex */
final class NewDeviceAction extends HdmiCecFeatureAction {
    static final int STATE_WAITING_FOR_DEVICE_VENDOR_ID = 2;
    static final int STATE_WAITING_FOR_SET_OSD_NAME = 1;
    private static final String TAG = "NewDeviceAction";
    private final int mDeviceLogicalAddress;
    private final int mDevicePhysicalAddress;
    private final int mDeviceType;
    private String mDisplayName;
    private HdmiDeviceInfo mOldDeviceInfo;
    private int mTimeoutRetry;
    private int mVendorId;

    NewDeviceAction(HdmiCecLocalDevice source, int deviceLogicalAddress, int devicePhysicalAddress, int deviceType) {
        super(source);
        this.mDeviceLogicalAddress = deviceLogicalAddress;
        this.mDevicePhysicalAddress = devicePhysicalAddress;
        this.mDeviceType = deviceType;
        this.mVendorId = AudioFormat.SUB_MASK;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean start() {
        this.mOldDeviceInfo = localDevice().mService.getHdmiCecNetwork().getCecDeviceInfo(this.mDeviceLogicalAddress);
        if (this.mOldDeviceInfo != null) goto L5;
    L7:
        Slog.d(TAG, "Start NewDeviceAction with default deviceInfo");
        HdmiDeviceInfo deviceInfo = HdmiDeviceInfo.cecDeviceBuilder().setLogicalAddress(this.mDeviceLogicalAddress).setPhysicalAddress(this.mDevicePhysicalAddress).setPortId(tv().getPortId(this.mDevicePhysicalAddress)).setDeviceType(this.mDeviceType).setVendorId(AudioFormat.SUB_MASK).build();
        if (this.mOldDeviceInfo == null) goto L10;
        Slog.d(TAG, "Remove device by NewDeviceAction, logical address conflicts: " + this.mDevicePhysicalAddress);
        localDevice().mService.getHdmiCecNetwork().removeCecDevice(localDevice(), this.mDeviceLogicalAddress);
    L10:
        localDevice().mService.getHdmiCecNetwork().addCecDevice(deviceInfo);
    L11:
        requestOsdName(true);
        return true;
    L5:
        if (this.mOldDeviceInfo.getPhysicalAddress() != this.mDevicePhysicalAddress) goto L7;
        Slog.d(TAG, "Start NewDeviceAction with old deviceInfo:[" + this.mOldDeviceInfo.toString() + "]");
        goto L11
    }

    private void requestOsdName(boolean firstTry) {
        if (firstTry == false) goto L4;
        this.mTimeoutRetry = 0;
    L4:
        this.mState = 1;
        if (mayProcessCommandIfCached(this.mDeviceLogicalAddress, 71) == false) goto L7;
        return;
    L7:
        sendCommand(HdmiCecMessageBuilder.buildGiveOsdNameCommand(getSourceAddress(), this.mDeviceLogicalAddress));
        addTimer(this.mState, 2000);
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public boolean processCommand(HdmiCecMessage cmd) {
        int opcode = cmd.getOpcode();
        int src = cmd.getSource();
        byte[] params = cmd.getParams();
        if (this.mDeviceLogicalAddress == src) goto L6;
        return false;
    L6:
        if (this.mState != 1) goto L22;
        if (opcode == 71) goto L33;
        if (opcode != 0) goto L32;
        int requestOpcode = params[0] & 255;
        if (requestOpcode != 70) goto L32;
        requestVendorId(true);
        return true;
    L32:
        return false;
    L33:
        this.mDisplayName = new String(params, CharsetNames.US_ASCII);     // Catch: UnsupportedEncodingException -> L11
    L13:
        requestVendorId(true);
        return true;
    L11:
        e = move-exception;
        Slog.e(TAG, "Failed to get OSD name: " + e.getMessage());
        goto L13
    L22:
        if (this.mState != 2) goto L32;
        if (opcode != 135) goto L27;
        this.mVendorId = HdmiUtils.threeBytesToInt(params);
        addDeviceInfo();
        finish();
        return true;
    L27:
        if (opcode != 0) goto L32;
        int requestOpcode2 = params[0] & 255;
        if (requestOpcode2 != 140) goto L32;
        addDeviceInfo();
        finish();
        return true;
    }

    private boolean mayProcessCommandIfCached(int destAddress, int opcode) {
        HdmiCecMessage message = getCecMessageCache().getMessage(destAddress, opcode);
        if (message != null) goto L5;
        return false;
    L5:
        return processCommand(message);
    }

    private void requestVendorId(boolean firstTry) {
        if (firstTry == false) goto L4;
        this.mTimeoutRetry = 0;
    L4:
        this.mState = 2;
        if (mayProcessCommandIfCached(this.mDeviceLogicalAddress, 135) == false) goto L7;
        return;
    L7:
        sendCommand(HdmiCecMessageBuilder.buildGiveDeviceVendorIdCommand(getSourceAddress(), this.mDeviceLogicalAddress));
        addTimer(this.mState, 2000);
    }

    private void addDeviceInfo() {
        if (localDevice().mService.getHdmiCecNetwork().isInDeviceList(this.mDeviceLogicalAddress, this.mDevicePhysicalAddress) == true) goto L7;
        Slog.w(TAG, String.format("Device not found (%02x, %04x)", new Object[]{Integer.valueOf(this.mDeviceLogicalAddress), Integer.valueOf(this.mDevicePhysicalAddress)}));
        return;
    L7:
        if (this.mDisplayName != null) goto L9;
        this.mDisplayName = "";
    L9:
        HdmiDeviceInfo deviceInfo = HdmiDeviceInfo.cecDeviceBuilder().setLogicalAddress(this.mDeviceLogicalAddress).setPhysicalAddress(this.mDevicePhysicalAddress).setPortId(tv().getPortId(this.mDevicePhysicalAddress)).setDeviceType(this.mDeviceType).setVendorId(this.mVendorId).setDisplayName(this.mDisplayName).build();
        if (this.mOldDeviceInfo != null) goto L12;
    L22:
        Slog.d(TAG, "Add NewDevice:[" + deviceInfo.toString() + "]");
        localDevice().mService.getHdmiCecNetwork().addCecDevice(deviceInfo);
        tv().processDelayedMessages(this.mDeviceLogicalAddress);
        if (HdmiUtils.isEligibleAddressForDevice(5, this.mDeviceLogicalAddress) == false) goto L27;
        tv().onNewAvrAdded(deviceInfo);
        return;
    L27:
        return;
    L12:
        if (this.mOldDeviceInfo.getLogicalAddress() != this.mDeviceLogicalAddress) goto L22;
        if (this.mOldDeviceInfo.getPhysicalAddress() != this.mDevicePhysicalAddress) goto L22;
        if (this.mOldDeviceInfo.getDeviceType() != this.mDeviceType) goto L22;
        if (this.mOldDeviceInfo.getVendorId() != this.mVendorId) goto L22;
        if (this.mOldDeviceInfo.getDisplayName().equals(this.mDisplayName) == false) goto L22;
        tv().processDelayedMessages(this.mDeviceLogicalAddress);
        Slog.d(TAG, "Ignore NewDevice, deviceInfo is same as current device");
        Slog.d(TAG, "Old:[" + this.mOldDeviceInfo.toString() + "]; New:[" + deviceInfo.toString() + "]");
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    public void handleTimerEvent(int state) {
        if (this.mState != 0) goto L5;
        return;
    L5:
        if (this.mState == state) goto L8;
        return;
    L8:
        if (state != 1) goto L15;
        int r3 = this.mTimeoutRetry + 1;
        this.mTimeoutRetry = r3;
        if (r3 >= 5) goto L13;
        requestOsdName(false);
        return;
    L13:
        requestVendorId(true);
        return;
    L15:
        if (state != 2) goto L24;
        int r4 = this.mTimeoutRetry + 1;
        this.mTimeoutRetry = r4;
        if (r4 >= 5) goto L20;
        requestVendorId(false);
        return;
    L20:
        addDeviceInfo();
        finish();
        return;
    }

    boolean isActionOf(HdmiCecLocalDevice.ActiveSource activeSource) {
        if (this.mDeviceLogicalAddress == activeSource.logicalAddress) goto L5;
    L7:
        return false;
    L5:
        if (this.mDevicePhysicalAddress != activeSource.physicalAddress) goto L7;
        return true;
    }
}
