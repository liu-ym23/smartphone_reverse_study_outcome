package com.android.server.hdmi;

import android.hardware.hdmi.HdmiPortInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.sysprop.HdmiProperties;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class HdmiCecLocalDeviceSource extends HdmiCecLocalDevice {
    private static final String TAG = "HdmiCecLocalDeviceSource";
    protected boolean mIsSwitchDevice;
    protected int mLocalActivePort;
    protected boolean mRoutingControlFeatureEnabled;
    private int mRoutingPort;

    protected HdmiCecLocalDeviceSource(HdmiControlService service, int deviceType) {
        super(service, deviceType);
        this.mIsSwitchDevice = ((Boolean) HdmiProperties.is_switch().orElse(false)).booleanValue();
        this.mRoutingPort = 0;
        this.mLocalActivePort = 0;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void queryDisplayStatus(IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        List<DevicePowerStatusAction> actions = getActions(DevicePowerStatusAction.class);
        if (actions.isEmpty() == true) goto L6;
        Slog.i(TAG, "queryDisplayStatus already in progress");
        actions.get(0).addCallback(callback);
        return;
    L6:
        DevicePowerStatusAction action = DevicePowerStatusAction.create(this, 0, callback);
        if (action != null) goto L10;
        Slog.w(TAG, "Cannot initiate queryDisplayStatus");
        invokeCallback(callback, -1);
        return;
    L10:
        addAndStartAction(action);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    void onHotplug(int portId, boolean connected) {
        assertRunOnServiceThread();
        HdmiPortInfo portInfo = this.mService.getPortInfo(portId);
        if (portInfo != null) goto L5;
    L7:
        if (connected == false) goto L10;
        this.mService.wakeUp();
        return;
    L10:
        return;
    L5:
        if (portInfo.getType() != 1) goto L7;
        this.mCecMessageCache.flushAll();
        goto L7
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void sendStandby(int deviceId) {
        assertRunOnServiceThread();
        String powerControlMode = this.mService.getHdmiCecConfig().getStringValue("power_control_mode");
        if (powerControlMode.equals("broadcast") == false) goto L6;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 15));
        return;
    L6:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 0));
        if (powerControlMode.equals("to_tv_and_audio_system") == false) goto L10;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 5));
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void oneTouchPlay(IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        List<OneTouchPlayAction> actions = getActions(OneTouchPlayAction.class);
        if (actions.isEmpty() == true) goto L6;
        Slog.i(TAG, "oneTouchPlay already in progress");
        actions.get(0).addCallback(callback);
        return;
    L6:
        OneTouchPlayAction action = OneTouchPlayAction.create(this, 0, callback);
        if (action != null) goto L10;
        Slog.w(TAG, "Cannot initiate oneTouchPlay");
        invokeCallback(callback, 5);
        return;
    L10:
        addAndStartAction(action);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void toggleAndFollowTvPower() {
        assertRunOnServiceThread();
        if (this.mService.getPowerManager().isInteractive() == false) goto L5;
        this.mService.pauseActiveMediaSessions();
    L6:
        this.mService.queryDisplayStatus(new AnonymousClass1(this));
        return;
    L5:
        this.mService.wakeUp();
        goto L6
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void onActiveSourceLost() {
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    void setActiveSource(int logicalAddress, int physicalAddress, String caller) {
        boolean wasActiveSource = isActiveSource();
        super.setActiveSource(logicalAddress, physicalAddress, caller);
        if (wasActiveSource == true) goto L5;
        return;
    L5:
        if (isActiveSource() == true) goto L9;
        removeAction(ActiveSourceAction.class);
        onActiveSourceLost();
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected void setActiveSource(int physicalAddress, String caller) {
        assertRunOnServiceThread();
        HdmiCecLocalDevice.ActiveSource activeSource = HdmiCecLocalDevice.ActiveSource.of(-1, physicalAddress);
        setActiveSource(activeSource, caller);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleActiveSource(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int logicalAddress = message.getSource();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        HdmiCecLocalDevice.ActiveSource activeSource = HdmiCecLocalDevice.ActiveSource.of(logicalAddress, physicalAddress);
        if (getActiveSource().equals(activeSource) == true) goto L5;
        setActiveSource(activeSource, "HdmiCecLocalDeviceSource#handleActiveSource()");
    L5:
        updateDevicePowerStatus(logicalAddress, 0);
        if (isRoutingControlFeatureEnabled() == false) goto L10;
        switchInputOnReceivingNewActivePath(physicalAddress);
        return -1;
    L10:
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRequestActiveSource(HdmiCecMessage message) {
        assertRunOnServiceThread();
        maySendActiveSource(message.getSource());
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSetStreamPath(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        if (physicalAddress != this.mService.getPhysicalAddress()) goto L8;
        if (this.mService.isPlaybackDevice() == false) goto L8;
        setAndBroadcastActiveSource(message, physicalAddress, "HdmiCecLocalDeviceSource#handleSetStreamPath()");
    L12:
        switchInputOnReceivingNewActivePath(physicalAddress);
        return -1;
    L8:
        if (physicalAddress == this.mService.getPhysicalAddress()) goto L10;
    L11:
        setActiveSource(physicalAddress, "HdmiCecLocalDeviceSource#handleSetStreamPath()");
        goto L12
    L10:
        if (isActiveSource() == true) goto L12;
        goto L11
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRoutingChange(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams(), 2);
        if (physicalAddress == this.mService.getPhysicalAddress()) goto L5;
    L6:
        setActiveSource(physicalAddress, "HdmiCecLocalDeviceSource#handleRoutingChange()");
    L8:
        if (isRoutingControlFeatureEnabled() == true) goto L11;
        return 4;
    L11:
        handleRoutingChangeAndInformation(physicalAddress, message);
        return -1;
    L5:
        if (isActiveSource() == true) goto L8;
        goto L6
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRoutingInformation(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        if (physicalAddress == this.mService.getPhysicalAddress()) goto L5;
    L6:
        setActiveSource(physicalAddress, "HdmiCecLocalDeviceSource#handleRoutingInformation()");
    L8:
        if (isRoutingControlFeatureEnabled() == true) goto L11;
        return 4;
    L11:
        handleRoutingChangeAndInformation(physicalAddress, message);
        return -1;
    L5:
        if (isActiveSource() == true) goto L8;
        goto L6
    }

    protected void switchInputOnReceivingNewActivePath(int physicalAddress) {
    }

    protected void handleRoutingChangeAndInformation(int physicalAddress, HdmiCecMessage message) {
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void disableDevice(boolean initiatedByCec, HdmiCecLocalDevice.PendingActionClearedCallback callback) {
        removeAction(OneTouchPlayAction.class);
        removeAction(DevicePowerStatusAction.class);
        super.disableDevice(initiatedByCec, callback);
    }

    protected void updateDevicePowerStatus(int logicalAddress, int newPowerStatus) {
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int getRcProfile() {
        return 1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected List<Integer> getRcFeatures() {
        List<Integer> features = new ArrayList();
        HdmiCecConfig hdmiCecConfig = this.mService.getHdmiCecConfig();
        if (hdmiCecConfig.getIntValue("rc_profile_source_handles_root_menu") != 1) goto L6;
        features.add(4);
    L6:
        if (hdmiCecConfig.getIntValue("rc_profile_source_handles_setup_menu") != 1) goto L9;
        features.add(3);
    L9:
        if (hdmiCecConfig.getIntValue("rc_profile_source_handles_contents_menu") != 1) goto L12;
        features.add(2);
    L12:
        if (hdmiCecConfig.getIntValue("rc_profile_source_handles_top_menu") != 1) goto L15;
        features.add(1);
    L15:
        if (hdmiCecConfig.getIntValue("rc_profile_source_handles_media_context_sensitive_menu") != 1) goto L17;
        features.add(0);
    L17:
        return features;
    }

    protected void setAndBroadcastActiveSource(HdmiCecMessage message, int physicalAddress, String caller) {
        this.mService.setAndBroadcastActiveSource(physicalAddress, getDeviceInfo().getDeviceType(), message.getSource(), caller);
    }

    @HdmiAnnotations.ServiceThreadOnly
    protected boolean isActiveSource() {
        if (getDeviceInfo() != null) goto L7;
        return false;
    L7:
        return getActiveSource().equals(getDeviceInfo().getLogicalAddress(), getDeviceInfo().getPhysicalAddress());
    }

    protected void wakeUpIfActiveSource() {
        if (isActiveSource() == true) goto L5;
        return;
    L5:
        this.mService.wakeUp();
    }

    protected void maySendActiveSource(int dest) {
        if (isActiveSource() == true) goto L5;
        return;
    L5:
        addAndStartAction(new ActiveSourceAction(this, dest));
    }

    protected void setRoutingPort(int portId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRoutingPort = portId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected int getRoutingPort() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mRoutingPort;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected int getLocalActivePort() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mLocalActivePort;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected void setLocalActivePort(int activePort) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLocalActivePort = activePort;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isRoutingControlFeatureEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mRoutingControlFeatureEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected boolean isSwitchingToTheSameInput(int activePort) {
        if (activePort != getLocalActivePort()) goto L5;
        return true;
    L5:
        return false;
    }
}
