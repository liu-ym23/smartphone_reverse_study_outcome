package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.util.Slog;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class HotplugDetectionAction extends HdmiCecFeatureAction {
    private static final int AVR_COUNT_MAX = 3;
    private static final int NUM_OF_ADDRESS = 15;
    public static final int POLLING_BATCH_INTERVAL_MS_FOR_PLAYBACK = 60000;
    public static final int POLLING_BATCH_INTERVAL_MS_FOR_TV = 5000;
    public static final long POLLING_MESSAGE_INTERVAL_MS_FOR_PLAYBACK = 500;
    public static final long POLLING_MESSAGE_INTERVAL_MS_FOR_TV = 0;
    private static final int STATE_WAIT_FOR_NEXT_POLLING = 1;
    private static final String TAG = "HotPlugDetectionAction";
    public static final int TIMEOUT_COUNT = 3;
    private int mAvrStatusCount;
    private final boolean mIsTvDevice;
    private int mTimeoutCount;

    /* JADX INFO: renamed from: -$$Nest$mcheckHotplug, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4422$$Nest$mcheckHotplug(HotplugDetectionAction r0, List r1, boolean r2) {
        r0.checkHotplug(r1, r2);
    }

    HotplugDetectionAction(HdmiCecLocalDevice source) {
        super(source);
        this.mTimeoutCount = 0;
        this.mAvrStatusCount = 0;
        this.mIsTvDevice = localDevice().mService.isTvDevice();
    }

    private int getPollingBatchInterval() {
        if (this.mIsTvDevice == false) goto L5;
        return 5000;
    L5:
        return 60000;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean start() {
        Slog.v(TAG, "Hot-plug detection started.");
        this.mState = 1;
        this.mTimeoutCount = 0;
        addTimer(this.mState, getPollingBatchInterval());
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    boolean processCommand(HdmiCecMessage cmd) {
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecFeatureAction
    void handleTimerEvent(int state) {
        if (this.mState == state) goto L6;
        return;
    L6:
        if (this.mState == 1) goto L8;
        return;
    L8:
        if (this.mIsTvDevice == false) goto L17;
        this.mTimeoutCount = (this.mTimeoutCount + 1) % 3;
        if (this.mTimeoutCount != 0) goto L13;
        pollAllDevices();
    L15:
        addTimer(this.mState, 5000);
        return;
    L13:
        if (tv().isSystemAudioActivated() == false) goto L15;
        pollAudioSystem();
        goto L15
    L17:
        pollAllDevices();
        addTimer(this.mState, 60000);
    }

    void pollAllDevicesNow() {
        this.mActionTimer.clearTimerMessage();
        this.mTimeoutCount = 0;
        this.mState = 1;
        pollAllDevices();
        addTimer(this.mState, getPollingBatchInterval());
    }

    private void pollAllDevices() {
        Slog.v(TAG, "Poll all devices.");
        HdmiControlService.DevicePollingCallback r3 = new AnonymousClass1(this);
        if (this.mIsTvDevice == false) goto L5;
        long r6 = 0;
    L6:
        pollDevices(r3, 65537, 1, r6);
        return;
    L5:
        r6 = 500;
        goto L6
    }

    private void pollAudioSystem() {
        Slog.v(TAG, "Poll audio system.");
        pollDevices(new AnonymousClass2(this), 65538, 1);
    }

    private void checkHotplug(List<Integer> ackedAddress, boolean audioOnly) {
        List<HdmiDeviceInfo> deviceInfoList = localDevice().mService.getHdmiCecNetwork().getDeviceInfoList(false);
        BitSet currentInfos = infoListToBitSet(deviceInfoList, audioOnly, false);
        BitSet polledResult = addressListToBitSet(ackedAddress);
        BitSet removed = complement(currentInfos, polledResult);
        int index = -1;
    L3:
        int r6 = removed.nextSetBit(index + 1);
        index = r6;
        if (r6 == (-1)) goto L17;
        if (this.mIsTvDevice == false) goto L15;
        if (index != 5) goto L15;
        HdmiDeviceInfo avr = tv().getAvrDeviceInfo();
        if (avr == null) goto L15;
        if (tv().isConnected(avr.getPortId()) == false) goto L15;
        this.mAvrStatusCount++;
        Slog.w(TAG, "Ack not returned from AVR. count: " + this.mAvrStatusCount);
        if (this.mAvrStatusCount < 3) goto L3;
    L15:
        Slog.v(TAG, "Remove device by hot-plug detection:" + index);
        removeDevice(index);
        goto L3
    L17:
        if (removed.get(5) == true) goto L19;
        this.mAvrStatusCount = 0;
    L19:
        BitSet currentInfosWithPhysicalAddress = infoListToBitSet(deviceInfoList, audioOnly, true);
        BitSet added = complement(polledResult, currentInfosWithPhysicalAddress);
        int index2 = -1;
    L20:
        int r7 = added.nextSetBit(index2 + 1);
        index2 = r7;
        if (r7 == (-1)) goto L23;
        Slog.v(TAG, "Add device by hot-plug detection:" + index2);
        addDevice(index2);
        goto L20
    }

    private static BitSet infoListToBitSet(List<HdmiDeviceInfo> infoList, boolean audioOnly, boolean requirePhysicalAddress) {
        BitSet set = new BitSet(15);
        Iterator<HdmiDeviceInfo> r1 = infoList.iterator();
    L4:
        if (r1.hasNext() == false) goto L24;
        HdmiDeviceInfo info = r1.next();
        boolean requirePhysicalAddressConditionMet = true;
        if (audioOnly == true) goto L8;
    L11:
        boolean audioOnlyConditionMet = true;
    L13:
        if (requirePhysicalAddress == true) goto L15;
    L20:
        if (audioOnlyConditionMet == false) goto L4;
        if (requirePhysicalAddressConditionMet == false) goto L4;
        set.set(info.getLogicalAddress());
        goto L4
    L15:
        if (info.getPhysicalAddress() != 65535) goto L20;
        requirePhysicalAddressConditionMet = false;
        goto L20
    L8:
        if (info.getDeviceType() == 5) goto L11;
        audioOnlyConditionMet = false;
        goto L13
    L24:
        return set;
    }

    private static BitSet addressListToBitSet(List<Integer> list) {
        BitSet set = new BitSet(15);
        Iterator<Integer> r1 = list.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Integer value = r1.next();
        set.set(value.intValue());
        goto L4
    L6:
        return set;
    }

    private static BitSet complement(BitSet first, BitSet second) {
        BitSet clone = (BitSet) first.clone();
        clone.andNot(second);
        return clone;
    }

    private void addDevice(int addedAddress) {
        sendCommand(HdmiCecMessageBuilder.buildGivePhysicalAddress(getSourceAddress(), addedAddress));
    }

    private void removeDevice(int removedAddress) {
        if (this.mIsTvDevice == false) goto L5;
        mayChangeRoutingPath(removedAddress);
        mayCancelOneTouchRecord(removedAddress);
        mayDisableSystemAudioAndARC(removedAddress);
    L5:
        mayCancelDeviceSelect(removedAddress);
        localDevice().mService.getHdmiCecNetwork().removeCecDevice(localDevice(), removedAddress);
    }

    private void mayChangeRoutingPath(int address) {
        HdmiDeviceInfo info = localDevice().mService.getHdmiCecNetwork().getCecDeviceInfo(address);
        if (info == null) goto L6;
        tv().handleRemoveActiveRoutingPath(info.getPhysicalAddress());
        return;
    }

    private void mayCancelDeviceSelect(int address) {
        List<DeviceSelectActionFromTv> actionsFromTv = getActions(DeviceSelectActionFromTv.class);
        Iterator<DeviceSelectActionFromTv> r2 = actionsFromTv.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        DeviceSelectActionFromTv action = r2.next();
        if (action.getTargetAddress() != address) goto L4;
        removeAction(DeviceSelectActionFromTv.class);
        goto L4
    L9:
        List<DeviceSelectActionFromPlayback> actionsFromPlayback = getActions(DeviceSelectActionFromPlayback.class);
        Iterator<DeviceSelectActionFromPlayback> r3 = actionsFromPlayback.iterator();
    L11:
        if (r3.hasNext() == false) goto L16;
        DeviceSelectActionFromPlayback action2 = r3.next();
        if (action2.getTargetAddress() != address) goto L11;
        removeAction(DeviceSelectActionFromTv.class);
        goto L11
    }

    private void mayCancelOneTouchRecord(int address) {
        List<OneTouchRecordAction> actions = getActions(OneTouchRecordAction.class);
        Iterator<OneTouchRecordAction> r1 = actions.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        OneTouchRecordAction action = r1.next();
        if (action.getRecorderAddress() != address) goto L4;
        removeAction(action);
        goto L4
    }

    private void mayDisableSystemAudioAndARC(int address) {
        if (HdmiUtils.isEligibleAddressForDevice(5, address) == true) goto L5;
        return;
    L5:
        tv().setSystemAudioMode(false);
        if (tv().isArcEstablished() == false) goto L9;
        tv().enableAudioReturnChannel(false);
        addAndStartAction(new RequestArcTerminationAction(localDevice(), address));
        return;
    }
}
