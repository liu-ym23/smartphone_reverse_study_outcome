package com.android.server.hdmi;

import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.hdmi.DeviceFeatures;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.HdmiPortInfo;
import android.hardware.hdmi.HdmiRecordSources;
import android.hardware.hdmi.HdmiTimerRecordSources;
import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.media.AudioDescriptor;
import android.media.AudioDeviceAttributes;
import android.media.tv.TvInputManager;
import android.os.Handler;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.ISmtResourceControl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecLocalDeviceTv extends HdmiCecLocalDevice {
    private static final String TAG = "HdmiCecLocalDeviceTv";

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mArcEstablished;
    private final SparseBooleanArray mArcFeatureEnabled;
    private final DelayedMessageBuffer mDelayedMessageBuffer;
    private int mPrevPortId;
    private final Runnable mResetSkipRoutingControlRunnable;
    private SelectRequestBuffer mSelectRequestBuffer;
    private boolean mSkipRoutingControl;
    private final Handler mSkipRoutingControlHandler;
    private List<byte[]> mSupportedSads;
    private boolean mSystemAudioControlFeatureEnabled;
    private boolean mSystemAudioMute;
    private int mSystemAudioVolume;
    private final TvInputManager.TvInputCallback mTvInputCallback;
    private final HashMap<String, Integer> mTvInputs;
    private boolean mWasActiveSourceSetToConnectedDevice;

    /* JADX INFO: renamed from: $r8$lambda$cEYRPTpiM-jb-VsvIFvoe3ptUjU, reason: not valid java name */
    public static /* synthetic */ AudioDescriptor m4298$r8$lambda$cEYRPTpiMjbVsvIFvoe3ptUjU(byte[] r0) {
        return lambda$notifyArcStatusToAudioService$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$tYJXVRUT_KZMhp1bilR1dNV0KLI(HdmiCecLocalDeviceTv r0) {
        r0.lambda$new$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSelectRequestBuffer, reason: not valid java name */
    static /* bridge */ /* synthetic */ SelectRequestBuffer m4299$$Nest$fgetmSelectRequestBuffer(HdmiCecLocalDeviceTv r0) {
        return r0.mSelectRequestBuffer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportedSads, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m4300$$Nest$fgetmSupportedSads(HdmiCecLocalDeviceTv r0) {
        return r0.mSupportedSads;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSupportedSads, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4301$$Nest$fputmSupportedSads(HdmiCecLocalDeviceTv r0, List r1) {
        r0.mSupportedSads = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddTvInput, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4302$$Nest$maddTvInput(HdmiCecLocalDeviceTv r0, String r1, int r2) {
        r0.addTvInput(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyArcStatusToAudioService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4303$$Nest$mnotifyArcStatusToAudioService(HdmiCecLocalDeviceTv r0, boolean r1, List r2) {
        r0.notifyArcStatusToAudioService(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveTvInput, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4304$$Nest$mremoveTvInput(HdmiCecLocalDeviceTv r0, String r1) {
        r0.removeTvInput(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresetSelectRequestBuffer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4305$$Nest$mresetSelectRequestBuffer(HdmiCecLocalDeviceTv r0) {
        r0.resetSelectRequestBuffer();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    public /* bridge */ /* synthetic */ ArrayBlockingQueue getActiveSourceHistory() {
        return super.getActiveSourceHistory();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    public /* bridge */ /* synthetic */ void invokeStandbyCompletedCallback(HdmiCecLocalDevice.StandbyCompletedCallback r1) {
        super.invokeStandbyCompletedCallback(r1);
    }

    private /* synthetic */ void lambda$new$0() {
        this.mSkipRoutingControl = false;
    }

    protected boolean getWasActivePathSetToConnectedDevice() {
        return this.mWasActiveSourceSetToConnectedDevice;
    }

    protected void setWasActivePathSetToConnectedDevice(boolean wasActiveSourceSetToConnectedDevice) {
        this.mWasActiveSourceSetToConnectedDevice = wasActiveSourceSetToConnectedDevice;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void addTvInput(String inputId, int deviceId) {
        assertRunOnServiceThread();
        this.mTvInputs.put(inputId, Integer.valueOf(deviceId));
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void removeTvInput(String inputId) {
        assertRunOnServiceThread();
        this.mTvInputs.remove(inputId);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected boolean isInputReady(int deviceId) {
        assertRunOnServiceThread();
        return this.mTvInputs.containsValue(Integer.valueOf(deviceId));
    }

    HdmiCecLocalDeviceTv(HdmiControlService service) {
        boolean r0 = false;
        super(service, 0);
        this.mArcEstablished = false;
        this.mArcFeatureEnabled = new SparseBooleanArray();
        this.mSupportedSads = new ArrayList();
        this.mSystemAudioVolume = -1;
        this.mSystemAudioMute = false;
        this.mResetSkipRoutingControlRunnable = new HdmiCecLocalDeviceTv$$ExternalSyntheticLambda0(this);
        this.mDelayedMessageBuffer = new DelayedMessageBuffer(this);
        this.mWasActiveSourceSetToConnectedDevice = false;
        this.mTvInputCallback = new AnonymousClass1(this);
        this.mTvInputs = new HashMap();
        this.mPrevPortId = -1;
        if (service.getHdmiCecConfig().getIntValue("system_audio_control") != 1) goto L5;
        r0 = true;
    L5:
        this.mSystemAudioControlFeatureEnabled = r0;
        this.mStandbyHandler = new HdmiCecStandbyModeHandler(service, this);
        this.mSkipRoutingControlHandler = new Handler(service.getServiceLooper());
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void onAddressAllocated(int logicalAddress, int reason) {
        assertRunOnServiceThread();
        List<HdmiPortInfo> ports = this.mService.getPortInfo();
        Iterator<HdmiPortInfo> r1 = ports.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        HdmiPortInfo port = r1.next();
        this.mArcFeatureEnabled.put(port.getId(), port.isArcSupported());
        goto L4
    L6:
        this.mService.registerTvInputCallback(this.mTvInputCallback);
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportPhysicalAddressCommand(getDeviceInfo().getLogicalAddress(), this.mService.getPhysicalAddress(), this.mDeviceType));
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildDeviceVendorIdCommand(getDeviceInfo().getLogicalAddress(), this.mService.getVendorId()));
        this.mService.getHdmiCecNetwork().addCecSwitch(this.mService.getHdmiCecNetwork().getPhysicalAddress());
        this.mTvInputs.clear();
        if (reason != 3) goto L9;
        boolean r2 = true;
    L10:
        this.mSkipRoutingControl = r2;
        this.mSkipRoutingControlHandler.removeCallbacks(this.mResetSkipRoutingControlRunnable);
        if (this.mSkipRoutingControl == false) goto L13;
        this.mSkipRoutingControlHandler.postDelayed(this.mResetSkipRoutingControlRunnable, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
    L13:
        resetSelectRequestBuffer();
        launchDeviceDiscovery();
        startQueuedActions();
        if (reason == 0) goto L17;
        if (reason == 1) goto L17;
        final boolean routingForBootup = true;
    L18:
        List<HdmiCecMessage> bufferedActiveSource = this.mDelayedMessageBuffer.getBufferedMessagesWithOpcode(130);
        List<HdmiCecMessage> bufferedActiveSourceFromService = this.mService.getCecMessageWithOpcode(130);
        if (bufferedActiveSource.isEmpty() == true) goto L21;
    L23:
        addCecDeviceForBufferedActiveSource(bufferedActiveSource.get(0));
        return;
    L21:
        if (bufferedActiveSourceFromService.isEmpty() == false) goto L23;
        addAndStartAction(new RequestActiveSourceAction(this, new AnonymousClass2(this, routingForBootup)), true);
        return;
    L17:
        routingForBootup = false;
        goto L18
    L9:
        r2 = false;
        goto L10
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void addCecDeviceForBufferedActiveSource(HdmiCecMessage bufferedActiveSource) {
        assertRunOnServiceThread();
        if (bufferedActiveSource != null) goto L5;
        return;
    L5:
        int source = bufferedActiveSource.getSource();
        int physicalAddress = HdmiUtils.twoBytesToInt(bufferedActiveSource.getParams());
        List<Integer> deviceTypes = HdmiUtils.getTypeFromAddress(source);
        HdmiDeviceInfo newDevice = HdmiDeviceInfo.cecDeviceBuilder().setLogicalAddress(source).setPhysicalAddress(physicalAddress).setDisplayName(HdmiUtils.getDefaultDeviceName(source)).setDeviceType(deviceTypes.get(0).intValue()).setVendorId(AudioFormat.SUB_MASK).setPortId(this.mService.getHdmiCecNetwork().physicalAddressToPortId(physicalAddress)).build();
        this.mService.getHdmiCecNetwork().addCecDevice(newDevice);
    }

    @HdmiAnnotations.ServiceThreadOnly
    public void setSelectRequestBuffer(SelectRequestBuffer requestBuffer) {
        assertRunOnServiceThread();
        this.mSelectRequestBuffer = requestBuffer;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void resetSelectRequestBuffer() {
        assertRunOnServiceThread();
        setSelectRequestBuffer(SelectRequestBuffer.EMPTY_BUFFER);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int getPreferredAddress() {
        return 0;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected void setPreferredAddress(int addr) {
        Slog.w(TAG, "Preferred addres will not be stored for TV");
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int dispatchMessage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (this.mService.isPowerStandby() == false) goto L11;
        if (this.mService.isWakeUpMessageReceived() == true) goto L11;
        if (this.mStandbyHandler.handleCommand(message) == false) goto L11;
        return -1;
    L11:
        return super.onMessage(message);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void deviceSelect(int id, IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        HdmiDeviceInfo targetDevice = this.mService.getHdmiCecNetwork().getDeviceInfo(id);
        if (targetDevice != null) goto L6;
        invokeCallback(callback, 3);
        return;
    L6:
        int targetAddress = targetDevice.getLogicalAddress();
        if (isAlreadyActiveSource(targetDevice, targetAddress, callback) == false) goto L9;
        return;
    L9:
        removeAction(RequestActiveSourceAction.class);
        if (targetAddress != 0) goto L14;
        handleSelectInternalSource();
        setActiveSource(targetAddress, this.mService.getPhysicalAddress(), "HdmiCecLocalDeviceTv#deviceSelect()");
        setActivePath(this.mService.getPhysicalAddress());
        invokeCallback(callback, 0);
        return;
    L14:
        if (this.mService.isCecControlEnabled() == true) goto L17;
        setActiveSource(targetDevice, "HdmiCecLocalDeviceTv#deviceSelect()");
        invokeCallback(callback, 6);
        return;
    L17:
        List<DeviceSelectActionFromTv> actions = getActions(DeviceSelectActionFromTv.class);
        if (actions.isEmpty() == true) goto L22;
        DeviceSelectActionFromTv action = actions.get(0);
        if (action.getTargetAddress() != targetDevice.getLogicalAddress()) goto L22;
        return;
    L22:
        addAndStartAction(new DeviceSelectActionFromTv(this, targetDevice, callback), true);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleSelectInternalSource() {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L5;
        return;
    L5:
        if (getActiveSource().logicalAddress == getDeviceInfo().getLogicalAddress()) goto L13;
        updateActiveSource(getDeviceInfo().getLogicalAddress(), this.mService.getPhysicalAddress(), "HdmiCecLocalDeviceTv#handleSelectInternalSource()");
        if (this.mSkipRoutingControl == false) goto L10;
        this.mSkipRoutingControl = false;
        return;
    L10:
        HdmiCecMessage activeSource = HdmiCecMessageBuilder.buildActiveSource(getDeviceInfo().getLogicalAddress(), this.mService.getPhysicalAddress());
        this.mService.sendCecCommand(activeSource);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void updateActiveSource(int logicalAddress, int physicalAddress, String caller) {
        assertRunOnServiceThread();
        updateActiveSource(HdmiCecLocalDevice.ActiveSource.of(logicalAddress, physicalAddress), caller);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void updateActiveSource(HdmiCecLocalDevice.ActiveSource newActive, String caller) {
        assertRunOnServiceThread();
        if (getActiveSource().equals(newActive) == false) goto L5;
        return;
    L5:
        setActiveSource(newActive, caller);
        int logicalAddress = newActive.logicalAddress;
        if (this.mService.getHdmiCecNetwork().getCecDeviceInfo(logicalAddress) != null) goto L8;
        return;
    L8:
        if (logicalAddress != getDeviceInfo().getLogicalAddress()) goto L10;
        return;
    L10:
        if (this.mService.pathToPortId(newActive.physicalAddress) != getActivePortId()) goto L15;
        setPrevPortId(getActivePortId());
        return;
    }

    int getPrevPortId() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mPrevPortId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void setPrevPortId(int portId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPrevPortId = portId;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    void setActivePath(int path) {
        super.setActivePath(path);
        if (path == 65535) goto L7;
        if (path == 0) goto L8;
        setWasActivePathSetToConnectedDevice(true);
        return;
    L8:
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void updateActiveInput(int path, boolean notifyInputChange) {
        assertRunOnServiceThread();
        setActivePath(path);
        if (notifyInputChange == false) goto L11;
        HdmiCecLocalDevice.ActiveSource activeSource = getActiveSource();
        HdmiDeviceInfo info = this.mService.getHdmiCecNetwork().getCecDeviceInfo(activeSource.logicalAddress);
        if (info != null) goto L9;
        info = this.mService.getDeviceInfoByPort(getActivePortId());
        if (info != null) goto L9;
        info = HdmiDeviceInfo.hardwarePort(path, getActivePortId());
    L9:
        this.mService.invokeInputChangeListener(info);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void doManualPortSwitching(int portId, IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        if (this.mService.isValidPortId(portId) == true) goto L7;
        invokeCallback(callback, 6);
        return;
    L7:
        if (portId != getActivePortId()) goto L10;
        invokeCallback(callback, 0);
        return;
    L10:
        getActiveSource().invalidate();
        if (this.mService.isCecControlEnabled() == true) goto L15;
        setActivePortId(portId);
        invokeCallback(callback, 6);
        return;
    L15:
        if (getActivePortId() != (-1)) goto L17;
    L19:
        int oldPath = getDeviceInfo().getPhysicalAddress();
    L20:
        setActivePath(oldPath);
        if (this.mSkipRoutingControl == false) goto L24;
        this.mSkipRoutingControl = false;
        return;
    L24:
        int newPath = this.mService.portIdToPath(portId);
        startRoutingControl(oldPath, newPath, callback);
        return;
    L17:
        if (getActivePortId() == 0) goto L19;
        oldPath = this.mService.portIdToPath(getActivePortId());
        goto L20
    }

    @HdmiAnnotations.ServiceThreadOnly
    void startRoutingControl(int oldPath, int newPath, IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        if (oldPath != newPath) goto L6;
        HdmiCecMessage setStreamPath = HdmiCecMessageBuilder.buildSetStreamPath(getDeviceInfo().getLogicalAddress(), oldPath);
        this.mService.sendCecCommand(setStreamPath);
        return;
    L6:
        HdmiCecMessage routingChange = HdmiCecMessageBuilder.buildRoutingChange(getDeviceInfo().getLogicalAddress(), oldPath, newPath);
        this.mService.sendCecCommand(routingChange);
        addAndStartAction(new RoutingControlAction(this, newPath, callback), true);
    }

    @HdmiAnnotations.ServiceThreadOnly
    int getPowerStatus() {
        assertRunOnServiceThread();
        return this.mService.getPowerStatus();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int findKeyReceiverAddress() {
        if (getActiveSource().isValid() == true) goto L5;
        HdmiDeviceInfo info = this.mService.getHdmiCecNetwork().getDeviceInfoByPath(getActivePath());
        if (info != null) goto L9;
        return -1;
    L9:
        return info.getLogicalAddress();
    L5:
        return getActiveSource().logicalAddress;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int findAudioReceiverAddress() {
        return 5;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleActiveSource(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int logicalAddress = message.getSource();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        HdmiDeviceInfo info = this.mService.getHdmiCecNetwork().getCecDeviceInfo(logicalAddress);
        if (info != null) goto L8;
        if (handleNewDeviceAtTheTailOfActivePath(physicalAddress) == true) goto L16;
        HdmiLogger.debug("Device info %X not found; buffering the command", new Object[]{Integer.valueOf(logicalAddress)});
        this.mDelayedMessageBuffer.add(message);
        return -1;
    L16:
        return -1;
    L8:
        if (isInputReady(info.getId()) == false) goto L10;
    L13:
        this.mService.getHdmiCecNetwork().updateDevicePowerStatus(logicalAddress, 0);
        HdmiCecLocalDevice.ActiveSource activeSource = HdmiCecLocalDevice.ActiveSource.of(logicalAddress, physicalAddress);
        ActiveSourceHandler.create(this, null).process(activeSource, info.getDeviceType());
        return -1;
    L10:
        if (info.getDeviceType() == 5) goto L13;
        HdmiLogger.debug("Input not ready for device: %X; buffering the command", new Object[]{Integer.valueOf(info.getId())});
        this.mDelayedMessageBuffer.add(message);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleStandby(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (getWasActivePathSetToConnectedDevice() == true) goto L5;
    L8:
        setWasActivePathSetToConnectedDevice(false);
        return super.handleStandby(message);
    L5:
        if (getActiveSource().logicalAddress == message.getSource()) goto L8;
        Slog.d(TAG, "<Standby> was not sent by the current active source, ignoring. Current active source has logical address " + getActiveSource().logicalAddress);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleInactiveSource(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (getActiveSource().logicalAddress == message.getSource()) goto L6;
        return -1;
    L6:
        if (isProhibitMode() == false) goto L8;
        return -1;
    L8:
        int portId = getPrevPortId();
        if (portId == (-1)) goto L17;
        HdmiDeviceInfo inactiveSource = this.mService.getHdmiCecNetwork().getCecDeviceInfo(message.getSource());
        if (inactiveSource != null) goto L14;
        return -1;
    L14:
        if (this.mService.pathToPortId(inactiveSource.getPhysicalAddress()) != portId) goto L16;
        return -1;
    L16:
        doManualPortSwitching(portId, null);
        setPrevPortId(-1);
    L18:
        return -1;
    L17:
        getActiveSource().invalidate();
        setActivePath(65535);
        this.mService.invokeInputChangeListener(HdmiDeviceInfo.INACTIVE_DEVICE);
        goto L18
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRequestActiveSource(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (getDeviceInfo().getLogicalAddress() != getActiveSource().logicalAddress) goto L7;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildActiveSource(getDeviceInfo().getLogicalAddress(), getActivePath()));
        return -1;
    L7:
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGetMenuLanguage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (broadcastMenuLanguage(this.mService.getLanguage()) == true) goto L7;
        Slog.w(TAG, "Failed to respond to <Get Menu Language>: " + message.toString());
        return -1;
    L7:
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean broadcastMenuLanguage(String language) {
        assertRunOnServiceThread();
        HdmiCecMessage command = HdmiCecMessageBuilder.buildSetMenuLanguageCommand(getDeviceInfo().getLogicalAddress(), language);
        if (command == null) goto L6;
        this.mService.sendCecCommand(command);
        return true;
    L6:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleReportPhysicalAddress(HdmiCecMessage message) {
        super.handleReportPhysicalAddress(message);
        if (hasAction(DeviceDiscoveryAction.class) == false) goto L5;
        return -1;
    L5:
        int path = HdmiUtils.twoBytesToInt(message.getParams());
        int address = message.getSource();
        int type = message.getParams()[2];
        if (getActiveSource().logicalAddress != address) goto L8;
    L10:
        startNewDeviceAction(HdmiCecLocalDevice.ActiveSource.of(address, path), type);
        return -1;
    L8:
        if (getActivePath() != path) goto L10;
        HdmiLogger.debug("New logical address detected on the current active path.", new Object[0]);
        startRoutingControl(path, path, null);
        goto L10
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleTimerStatus(HdmiCecMessage message) {
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleRecordStatus(HdmiCecMessage message) {
        return -1;
    }

    void startNewDeviceAction(HdmiCecLocalDevice.ActiveSource activeSource, int deviceType) {
        Iterator r0 = getActions(NewDeviceAction.class).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        NewDeviceAction action = (NewDeviceAction) r0.next();
        if (action.isActionOf(activeSource) == false) goto L4;
        return;
    L9:
        addAndStartAction(new NewDeviceAction(this, activeSource.logicalAddress, activeSource.physicalAddress, deviceType));
    }

    private boolean handleNewDeviceAtTheTailOfActivePath(int path) {
        if (isTailOfActivePath(path, getActivePath()) == false) goto L6;
        int newPath = this.mService.portIdToPath(getActivePortId());
        setActivePath(newPath);
        startRoutingControl(getActivePath(), newPath, null);
        return true;
    L6:
        return false;
    }

    static boolean isTailOfActivePath(int path, int activePath) {
        if (activePath != 0) goto L5;
        return false;
    L5:
        int i = 12;
    L6:
        if (i < 0) goto L16;
        int curActivePath = (activePath >> i) & 15;
        if (curActivePath == 0) goto L9;
        int curPath = (path >> i) & 15;
        if (curPath != curActivePath) goto L13;
        i = i - 4;
        goto L6
    L13:
        return false;
    L9:
        return true;
    L16:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRoutingChange(HdmiCecMessage message) {
        assertRunOnServiceThread();
        byte[] params = message.getParams();
        int currentPath = HdmiUtils.twoBytesToInt(params);
        if (HdmiUtils.isAffectingActiveRoutingPath(getActivePath(), currentPath) == false) goto L7;
        getActiveSource().invalidate();
        removeAction(RoutingControlAction.class);
        int newPath = HdmiUtils.twoBytesToInt(params, 2);
        addAndStartAction(new RoutingControlAction(this, newPath, null));
        return -1;
    L7:
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleReportAudioStatus(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (this.mService.getHdmiCecVolumeControl() != 0) goto L6;
        return 4;
    L6:
        boolean mute = HdmiUtils.isAudioStatusMute(message);
        int volume = HdmiUtils.getAudioStatusVolume(message);
        setAudioStatus(mute, volume);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleTextViewOn(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (getAutoWakeup() == false) goto L7;
        this.mService.wakeUp();
        return -1;
    L7:
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleImageViewOn(HdmiCecMessage message) {
        assertRunOnServiceThread();
        return handleTextViewOn(message);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void launchDeviceDiscovery() {
        assertRunOnServiceThread();
        DeviceDiscoveryAction action = new DeviceDiscoveryAction(this, new AnonymousClass3(this));
        addAndStartAction(action);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void onNewAvrAdded(HdmiDeviceInfo avr) {
        assertRunOnServiceThread();
        addAndStartAction(new SystemAudioAutoInitiationAction(this, avr.getLogicalAddress()));
        if (isDirectConnectAddress(avr.getPhysicalAddress()) == true) goto L6;
        startArcAction(false);
        return;
    L6:
        if (isConnected(avr.getPortId()) == true) goto L8;
        return;
    L8:
        if (isArcFeatureEnabled(avr.getPortId()) == true) goto L10;
        return;
    L10:
        if (hasAction(SetArcTransmissionStateAction.class) == true) goto L16;
        startArcAction(true);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void changeSystemAudioMode(boolean enabled, IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L5;
    L13:
        setSystemAudioMode(false);
        invokeCallback(callback, 6);
        return;
    L5:
        if (hasAction(DeviceDiscoveryAction.class) == true) goto L13;
        HdmiDeviceInfo avr = getAvrDeviceInfo();
        if (avr != null) goto L11;
        setSystemAudioMode(false);
        invokeCallback(callback, 3);
        return;
    L11:
        addAndStartAction(new SystemAudioActionFromTv(this, avr.getLogicalAddress(), enabled, callback));
    }

    void clearSads() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSupportedSads.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void setSystemAudioMode(boolean on) {
        if (isSystemAudioControlFeatureEnabled() == true) goto L7;
        if (on == false) goto L7;
        HdmiLogger.debug("Cannot turn on system audio mode because the System Audio Control feature is disabled.", new Object[0]);
        return;
    L7:
        HdmiLogger.debug("System Audio Mode change[old:%b new:%b]", new Object[]{Boolean.valueOf(this.mService.isSystemAudioActivated()), Boolean.valueOf(on)});
        updateAudioManagerForSystemAudio(on);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L10:
        if (this.mService.isSystemAudioActivated() == on) goto L14;
        this.mService.setSystemAudioActivated(on);     // Catch: Throwable -> L12
        this.mService.announceSystemAudioModeChange(on);     // Catch: Throwable -> L12
    L14:
        if (on == true) goto L16;
    L18:
        if (on == true) goto L20;
        startArcAction(false);     // Catch: Throwable -> L12
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L16:
        if (this.mArcEstablished == true) goto L18;
        startArcAction(true);     // Catch: Throwable -> L12
        goto L20
    }

    private void updateAudioManagerForSystemAudio(boolean on) {
        int device = this.mService.getAudioManager().setHdmiSystemAudioSupported(on);
        HdmiLogger.debug("[A]UpdateSystemAudio mode[on=%b] output=[%X]", new Object[]{Boolean.valueOf(on), Integer.valueOf(device)});
    }

    boolean isSystemAudioActivated() {
        if (hasSystemAudioDevice() == true) goto L7;
        return false;
    L7:
        return this.mService.isSystemAudioActivated();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setSystemAudioControlFeatureEnabled(boolean enabled) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemAudioControlFeatureEnabled = enabled;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (hasSystemAudioDevice() == false) goto L15;
        changeSystemAudioMode(enabled, null);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    boolean isSystemAudioControlFeatureEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mSystemAudioControlFeatureEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void enableArc() {
        assertRunOnServiceThread();
        HdmiLogger.debug("Set Arc Status[old:%b new:true]", new Object[]{Boolean.valueOf(this.mArcEstablished)});
        enableAudioReturnChannel(true);
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mSupportedSads.clear();     // Catch: Throwable -> L11
        notifyArcStatusToAudioService(true, this.mSupportedSads);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        this.mArcEstablished = true;
        if (hasAction(RequestSadAction.class) == false) goto L9;
        return;
    L9:
        RequestSadAction action = new RequestSadAction(this, 5, new AnonymousClass4(this));
        addAndStartAction(action);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void disableArc() {
        assertRunOnServiceThread();
        HdmiLogger.debug("Set Arc Status[old:%b new:false]", new Object[]{Boolean.valueOf(this.mArcEstablished)});
        enableAudioReturnChannel(false);
        notifyArcStatusToAudioService(false, new ArrayList());
        this.mArcEstablished = false;
        clearSads();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void enableAudioReturnChannel(boolean enabled) {
        assertRunOnServiceThread();
        HdmiDeviceInfo avr = getAvrDeviceInfo();
        if (avr != null) goto L5;
        return;
    L5:
        if (avr.getPortId() == (-1)) goto L9;
        this.mService.enableAudioReturnChannel(avr.getPortId(), enabled);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isConnected(int portId) {
        assertRunOnServiceThread();
        return this.mService.isConnected(portId);
    }

    private void notifyArcStatusToAudioService(boolean r8, List<byte[]> r9) {
        AudioDeviceAttributes r0 = new AudioDeviceAttributes(2, 10, "", "", new ArrayList(), (List) r9.stream().map(new HdmiCecLocalDeviceTv$$ExternalSyntheticLambda1()).collect(Collectors.toList()));
        this.mService.getAudioManager().setWiredDeviceConnectionState(r0, r8 ? 1 : 0);
    }

    private static /* synthetic */ AudioDescriptor lambda$notifyArcStatusToAudioService$1(byte[] sad) {
        return new AudioDescriptor(1, 0, sad);
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isArcEstablished() {
        assertRunOnServiceThread();
        if (this.mArcEstablished == false) goto L12;
        int i = 0;
    L6:
        if (i >= this.mArcFeatureEnabled.size()) goto L16;
        if (this.mArcFeatureEnabled.valueAt(i) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return true;
    L16:
        return false;
    L12:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void changeArcFeatureEnabled(int portId, boolean enabled) {
        assertRunOnServiceThread();
        if (this.mArcFeatureEnabled.get(portId) != enabled) goto L5;
        return;
    L5:
        this.mArcFeatureEnabled.put(portId, enabled);
        HdmiDeviceInfo avr = getAvrDeviceInfo();
        if (avr != null) goto L8;
        return;
    L8:
        if (avr.getPortId() != portId) goto L23;
        if (enabled == true) goto L12;
    L14:
        if (enabled == false) goto L16;
        return;
    L16:
        if (this.mArcEstablished == false) goto L22;
        startArcAction(false);
        return;
    L22:
        return;
    L12:
        if (this.mArcEstablished == true) goto L14;
        startArcAction(true);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isArcFeatureEnabled(int portId) {
        assertRunOnServiceThread();
        return this.mArcFeatureEnabled.get(portId);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void startArcAction(boolean enabled) {
        startArcAction(enabled, null);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void startArcAction(boolean enabled, IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        HdmiDeviceInfo info = getAvrDeviceInfo();
        if (info != null) goto L7;
        Slog.w(TAG, "Failed to start arc action; No AVR device.");
        invokeCallback(callback, 3);
        return;
    L7:
        if (canStartArcUpdateAction(info.getLogicalAddress(), enabled) == true) goto L15;
        Slog.w(TAG, "Failed to start arc action; ARC configuration check failed.");
        if (enabled == true) goto L11;
    L13:
        invokeCallback(callback, 6);
        return;
    L11:
        if (isConnectedToArcPort(info.getPhysicalAddress()) == true) goto L13;
        displayOsd(1);
        goto L13
    L15:
        if (enabled == false) goto L21;
        if (this.mService.earcBlocksArcConnection() == false) goto L21;
        Slog.i(TAG, "ARC connection blocked because eARC connection is established or being established.");
        invokeCallback(callback, 6);
        return;
    L21:
        if (enabled == false) goto L26;
        removeAction(RequestArcTerminationAction.class);
        if (hasAction(RequestArcInitiationAction.class) == false) goto L25;
        RequestArcInitiationAction existingInitiationAction = (RequestArcInitiationAction) getActions(RequestArcInitiationAction.class).get(0);
        existingInitiationAction.addCallback(callback);
        return;
    L25:
        addAndStartAction(new RequestArcInitiationAction(this, info.getLogicalAddress(), callback));
        return;
    L26:
        removeAction(RequestArcInitiationAction.class);
        if (hasAction(RequestArcTerminationAction.class) == false) goto L29;
        RequestArcTerminationAction existingTerminationAction = (RequestArcTerminationAction) getActions(RequestArcTerminationAction.class).get(0);
        existingTerminationAction.addCallback(callback);
        return;
    L29:
        addAndStartAction(new RequestArcTerminationAction(this, info.getLogicalAddress(), callback));
    }

    private boolean isDirectConnectAddress(int physicalAddress) {
        if ((61440 & physicalAddress) != physicalAddress) goto L5;
        return true;
    L5:
        return false;
    }

    void setAudioStatus(boolean mute, int volume) {
        if (isSystemAudioActivated() == true) goto L5;
        return;
    L5:
        if (this.mService.getHdmiCecVolumeControl() == 0) goto L22;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemAudioMute = mute;     // Catch: Throwable -> L16
        this.mSystemAudioVolume = volume;     // Catch: Throwable -> L16
        if (mute == false) goto L12;
        int r1 = 101;
    L13:
        displayOsd(2, r1);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L12:
        r1 = volume;
    L16:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void changeVolume(int curVolume, int delta, int maxVolume) {
        assertRunOnServiceThread();
        if (getAvrDeviceInfo() != null) goto L5;
        return;
    L5:
        if (delta != 0) goto L7;
        return;
    L7:
        if (isSystemAudioActivated() == true) goto L9;
        return;
    L9:
        if (this.mService.getHdmiCecVolumeControl() == 0) goto L38;
        int targetVolume = curVolume + delta;
        int cecVolume = VolumeControlAction.scaleToCecVolume(targetVolume, maxVolume);
        Object r2 = this.mLock;
        monitor-enter(r2);
        boolean r4 = false;
        if (cecVolume != this.mSystemAudioVolume) goto L20;
        this.mService.setAudioStatus(false, VolumeControlAction.scaleToCustomVolume(this.mSystemAudioVolume, maxVolume));     // Catch: Throwable -> L18
        monitor-exit(r2);     // Catch: Throwable -> L18
        return;
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L18
        List<VolumeControlAction> actions = getActions(VolumeControlAction.class);
        if (actions.isEmpty() == false) goto L27;
        int r6 = getAvrDeviceInfo().getLogicalAddress();
        if (delta <= 0) goto L26;
        r4 = true;
    L26:
        addAndStartAction(new VolumeControlAction(this, r6, r4));
        return;
    L27:
        VolumeControlAction r3 = actions.get(0);
        if (delta <= 0) goto L30;
        r4 = true;
    L30:
        r3.handleVolumeChange(r4);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void changeMute(boolean mute) {
        assertRunOnServiceThread();
        if (getAvrDeviceInfo() != null) goto L5;
        return;
    L5:
        if (this.mService.getHdmiCecVolumeControl() == 0) goto L27;
        HdmiLogger.debug("[A]:Change mute:%b", new Object[]{Boolean.valueOf(mute)});
        Object r0 = this.mLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (this.mSystemAudioMute != mute) goto L16;
        HdmiLogger.debug("No need to change mute.", new Object[0]);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (isSystemAudioActivated() == true) goto L21;
        HdmiLogger.debug("[A]:System audio is not activated.", new Object[0]);
        return;
    L21:
        removeAction(VolumeControlAction.class);
        sendUserControlPressedAndReleased(getAvrDeviceInfo().getLogicalAddress(), HdmiCecKeycode.getMuteKey(mute));
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleInitiateArc(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (this.mService.earcBlocksArcConnection() == false) goto L7;
        Slog.i(TAG, "ARC connection blocked because eARC connection is established or being established.");
        return 1;
    L7:
        if (canStartArcUpdateAction(message.getSource(), true) == true) goto L18;
        HdmiDeviceInfo avrDeviceInfo = getAvrDeviceInfo();
        if (avrDeviceInfo != null) goto L13;
        this.mDelayedMessageBuffer.add(message);
        return -1;
    L13:
        if (isConnectedToArcPort(avrDeviceInfo.getPhysicalAddress()) == true) goto L23;
        displayOsd(1);
        return 4;
    L23:
        return 4;
    L18:
        if (this.mArcEstablished == false) goto L21;
        HdmiLogger.debug("ARC is already established.", new Object[0]);
        HdmiCecMessage command = HdmiCecMessageBuilder.buildReportArcInitiated(getDeviceInfo().getLogicalAddress(), message.getSource());
        this.mService.sendCecCommand(command);
        return -1;
    L21:
        SetArcTransmissionStateAction action = new SetArcTransmissionStateAction(this, message.getSource(), true);
        addAndStartAction(action);
        return -1;
    }

    private boolean canStartArcUpdateAction(int avrAddress, boolean enabled) {
        HdmiDeviceInfo avr = getAvrDeviceInfo();
        if (avr != null) goto L5;
    L20:
        return false;
    L5:
        if (avrAddress != avr.getLogicalAddress()) goto L20;
        if (isConnectedToArcPort(avr.getPhysicalAddress()) == false) goto L20;
        if (enabled == true) goto L11;
        return true;
    L11:
        if (isConnected(avr.getPortId()) == true) goto L13;
        return false;
    L13:
        if (isArcFeatureEnabled(avr.getPortId()) == true) goto L15;
        return false;
    L15:
        if (isDirectConnectAddress(avr.getPhysicalAddress()) == true) goto L18;
        return false;
    L18:
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleTerminateArc(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (this.mService.isPowerStandbyOrTransient() == false) goto L6;
        disableArc();
        return -1;
    L6:
        SetArcTransmissionStateAction action = new SetArcTransmissionStateAction(this, message.getSource(), false);
        addAndStartAction(action);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSetSystemAudioMode(HdmiCecMessage message) {
        assertRunOnServiceThread();
        boolean systemAudioStatus = HdmiUtils.parseCommandParamSystemAudioStatus(message);
        if (isMessageForSystemAudio(message) == false) goto L5;
        if (systemAudioStatus == true) goto L11;
    L14:
        removeAction(SystemAudioAutoInitiationAction.class);
        SystemAudioActionFromAvr action = new SystemAudioActionFromAvr(this, message.getSource(), systemAudioStatus, null);
        addAndStartAction(action);
        return -1;
    L11:
        if (isSystemAudioControlFeatureEnabled() == true) goto L14;
        HdmiLogger.debug("Ignoring <Set System Audio Mode> message because the System Audio Control feature is disabled: %s", new Object[]{message});
        return 4;
    L5:
        if (getAvrDeviceInfo() != null) goto L7;
        this.mDelayedMessageBuffer.add(message);
        goto L14
    L7:
        HdmiLogger.warning("Invalid <Set System Audio Mode> message:" + message, new Object[0]);
        return 4;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSystemAudioModeStatus(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (isMessageForSystemAudio(message) == true) goto L6;
        HdmiLogger.warning("Invalid <System Audio Mode Status> message:" + message, new Object[0]);
        return -1;
    L6:
        boolean tvSystemAudioMode = isSystemAudioControlFeatureEnabled();
        boolean avrSystemAudioMode = HdmiUtils.parseCommandParamSystemAudioStatus(message);
        HdmiDeviceInfo avr = getAvrDeviceInfo();
        if (avr != null) goto L10;
        setSystemAudioMode(false);
    L17:
        return -1;
    L10:
        if (avrSystemAudioMode != tvSystemAudioMode) goto L16;
        if (avrSystemAudioMode == true) goto L13;
    L15:
        setSystemAudioMode(tvSystemAudioMode);
        goto L17
    L13:
        if (avr.getDevicePowerStatus() != 1) goto L15;
    L16:
        addAndStartAction(new SystemAudioActionFromTv(this, avr.getLogicalAddress(), tvSystemAudioMode, null));
        goto L17
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRecordTvScreen(HdmiCecMessage message) {
        List<OneTouchRecordAction> actions = getActions(OneTouchRecordAction.class);
        if (actions.isEmpty() == true) goto L9;
        OneTouchRecordAction action = actions.get(0);
        if (action.getRecorderAddress() == message.getSource()) goto L11;
        announceOneTouchRecordResult(message.getSource(), 48);
        return 2;
    L11:
        return 2;
    L9:
        int recorderAddress = message.getSource();
        byte[] recordSource = this.mService.invokeRecordRequestListener(recorderAddress);
        return startOneTouchRecord(recorderAddress, recordSource);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleTimerClearedStatus(HdmiCecMessage message) {
        byte[] params = message.getParams();
        int timerClearedStatusData = params[0] & CecDeviceType.INACTIVE;
        announceTimerRecordingResult(message.getSource(), timerClearedStatusData);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleSetAudioVolumeLevel(SetAudioVolumeLevelMessage message) {
        if (this.mService.isSystemAudioActivated() == false) goto L6;
        return 1;
    L6:
        int audioVolumeLevel = message.getAudioVolumeLevel();
        if (audioVolumeLevel >= 0) goto L9;
        return -1;
    L9:
        if (audioVolumeLevel > 100) goto L14;
        this.mService.setStreamMusicVolume(audioVolumeLevel, 0);
        return -1;
    L14:
        return -1;
    }

    void announceOneTouchRecordResult(int recorderAddress, int result) {
        this.mService.invokeOneTouchRecordResult(recorderAddress, result);
    }

    void announceTimerRecordingResult(int recorderAddress, int result) {
        this.mService.invokeTimerRecordingResult(recorderAddress, result);
    }

    void announceClearTimerRecordingResult(int recorderAddress, int result) {
        this.mService.invokeClearTimerRecordingResult(recorderAddress, result);
    }

    private boolean isMessageForSystemAudio(HdmiCecMessage message) {
        if (this.mService.isCecControlEnabled() == true) goto L5;
    L13:
        return false;
    L5:
        if (message.getSource() != 5) goto L13;
        if (message.getDestination() == 0) goto L11;
        if (message.getDestination() != 15) goto L13;
    L11:
        if (getAvrDeviceInfo() == null) goto L13;
        return true;
    }

    @HdmiAnnotations.ServiceThreadOnly
    HdmiDeviceInfo getAvrDeviceInfo() {
        assertRunOnServiceThread();
        return this.mService.getHdmiCecNetwork().getCecDeviceInfo(5);
    }

    boolean hasSystemAudioDevice() {
        if (getSafeAvrDeviceInfo() == null) goto L5;
        return true;
    L5:
        return false;
    }

    HdmiDeviceInfo getSafeAvrDeviceInfo() {
        return this.mService.getHdmiCecNetwork().getSafeCecDeviceInfo(5);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void handleRemoveActiveRoutingPath(int path) {
        assertRunOnServiceThread();
        if (isTailOfActivePath(path, getActivePath()) == false) goto L6;
        int newPath = this.mService.portIdToPath(getActivePortId());
        startRoutingControl(getActivePath(), newPath, null);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void launchRoutingControl(boolean routingForBootup) {
        assertRunOnServiceThread();
        if (getActivePortId() != (-1)) goto L5;
    L10:
        int activePath = this.mService.getPhysicalAddress();
        setActivePath(activePath);
        if (this.mDelayedMessageBuffer.isBuffered(130) == true) goto L17;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildActiveSource(getDeviceInfo().getLogicalAddress(), activePath));
        updateActiveSource(getDeviceInfo().getLogicalAddress(), activePath, "HdmiCecLocalDeviceTv#launchRoutingControl()");
        return;
    L17:
        return;
    L5:
        if (getActivePortId() == 0) goto L10;
        if (routingForBootup == false) goto L8;
        return;
    L8:
        if (isProhibitMode() == true) goto L15;
        int newPath = this.mService.portIdToPath(getActivePortId());
        setActivePath(newPath);
        startRoutingControl(getActivePath(), newPath, null);
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    void onHotplug(int portId, boolean connected) {
        assertRunOnServiceThread();
        if (connected == true) goto L6;
        this.mService.getHdmiCecNetwork().removeCecSwitches(portId);
    L6:
        if (this.mService.isEarcEnabled() == true) goto L8;
    L9:
        HdmiDeviceInfo avr = getAvrDeviceInfo();
        if (avr != null) goto L12;
    L22:
        List<HotplugDetectionAction> hotplugActions = getActions(HotplugDetectionAction.class);
        if (hotplugActions.isEmpty() == true) goto L26;
        hotplugActions.get(0).pollAllDevicesNow();
        return;
    L26:
        return;
    L12:
        if (portId != avr.getPortId()) goto L22;
        if (isConnectedToArcPort(avr.getPhysicalAddress()) == false) goto L22;
        HdmiLogger.debug("Port ID:%d, 5v=%b", new Object[]{Integer.valueOf(portId), Boolean.valueOf(connected)});
        if (connected == true) goto L18;
        enableAudioReturnChannel(false);
        goto L22
    L18:
        if (this.mArcEstablished == false) goto L20;
        enableAudioReturnChannel(true);
        goto L22
    L20:
        HdmiLogger.debug("Restart ARC again", new Object[0]);
        onNewAvrAdded(getAvrDeviceInfo());
        goto L22
    L8:
        if (this.mService.isEarcSupported() == true) goto L22;
        goto L9
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean getAutoWakeup() {
        assertRunOnServiceThread();
        if (this.mService.getHdmiCecConfig().getIntValue("tv_wake_on_one_touch_play") == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void disableDevice(boolean initiatedByCec, HdmiCecLocalDevice.PendingActionClearedCallback callback) {
        assertRunOnServiceThread();
        this.mService.unregisterTvInputCallback(this.mTvInputCallback);
        this.mTvInputs.clear();
        removeAction(DeviceDiscoveryAction.class);
        removeAction(HotplugDetectionAction.class);
        removeAction(PowerStatusMonitorAction.class);
        removeAction(OneTouchRecordAction.class);
        removeAction(TimerRecordingAction.class);
        removeAction(NewDeviceAction.class);
        removeAction(RequestActiveSourceAction.class);
        if (initiatedByCec == false) goto L5;
    L6:
        disableSystemAudioIfExist();
    L7:
        disableArcIfExist();
        super.disableDevice(initiatedByCec, callback);
        clearDeviceInfoList();
        getActiveSource().invalidate();
        setActivePath(65535);
        checkIfPendingActionsCleared();
        return;
    L5:
        if (this.mService.isEarcEnabled() == true) goto L7;
        goto L6
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void disableSystemAudioIfExist() {
        assertRunOnServiceThread();
        if (getAvrDeviceInfo() != null) goto L5;
        return;
    L5:
        removeAction(SystemAudioActionFromAvr.class);
        removeAction(SystemAudioActionFromTv.class);
        removeAction(SystemAudioAutoInitiationAction.class);
        removeAction(VolumeControlAction.class);
        if (this.mService.isCecControlEnabled() == true) goto L9;
        setSystemAudioMode(false);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void forceDisableArcOnAllPins() {
        List<HdmiPortInfo> ports = this.mService.getPortInfo();
        Iterator<HdmiPortInfo> r1 = ports.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        HdmiPortInfo port = r1.next();
        if (isArcFeatureEnabled(port.getId()) == false) goto L4;
        this.mService.enableAudioReturnChannel(port.getId(), false);
        goto L4
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void disableArcIfExist() {
        assertRunOnServiceThread();
        HdmiDeviceInfo avr = getAvrDeviceInfo();
        if (avr != null) goto L5;
        return;
    L5:
        removeAllRunningArcAction();
        if (hasAction(RequestArcTerminationAction.class) == false) goto L8;
    L10:
        forceDisableArcOnAllPins();
        return;
    L8:
        if (isArcEstablished() == false) goto L10;
        addAndStartAction(new RequestArcTerminationAction(this, avr.getLogicalAddress()));
        goto L10
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void removeAllRunningArcAction() {
        removeAction(RequestArcTerminationAction.class);
        removeAction(RequestArcInitiationAction.class);
        removeAction(SetArcTransmissionStateAction.class);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void onStandby(boolean initiatedByCec, int standbyAction, final HdmiCecLocalDevice.StandbyCompletedCallback callback) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L6;
        invokeStandbyCompletedCallback(callback);
        return;
    L6:
        boolean sendStandbyOnSleep = false;
        setWasActivePathSetToConnectedDevice(false);
        if (this.mService.getHdmiCecConfig().getIntValue("tv_send_standby_on_sleep") != 1) goto L9;
        sendStandbyOnSleep = true;
    L9:
        if (initiatedByCec == true) goto L12;
        if (sendStandbyOnSleep == false) goto L12;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 15), new AnonymousClass5(this, callback));
        return;
    L12:
        invokeStandbyCompletedCallback(callback);
    }

    boolean isProhibitMode() {
        return this.mService.isProhibitMode();
    }

    boolean isPowerStandbyOrTransient() {
        return this.mService.isPowerStandbyOrTransient();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void displayOsd(int messageId) {
        assertRunOnServiceThread();
        this.mService.displayOsd(messageId);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void displayOsd(int messageId, int extra) {
        assertRunOnServiceThread();
        this.mService.displayOsd(messageId, extra);
    }

    @HdmiAnnotations.ServiceThreadOnly
    int startOneTouchRecord(int recorderAddress, byte[] recordSource) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L7;
        Slog.w(TAG, "Can not start one touch record. CEC control is disabled.");
        announceOneTouchRecordResult(recorderAddress, 51);
        return 1;
    L7:
        if (checkRecorder(recorderAddress) == true) goto L11;
        Slog.w(TAG, "Invalid recorder address:" + recorderAddress);
        announceOneTouchRecordResult(recorderAddress, 49);
        return 1;
    L11:
        if (checkRecordSource(recordSource) == true) goto L14;
        Slog.w(TAG, "Invalid record source." + Arrays.toString(recordSource));
        announceOneTouchRecordResult(recorderAddress, 50);
        return 2;
    L14:
        addAndStartAction(new OneTouchRecordAction(this, recorderAddress, recordSource));
        Slog.i(TAG, "Start new [One Touch Record]-Target:" + recorderAddress + ", recordSource:" + Arrays.toString(recordSource));
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void stopOneTouchRecord(int recorderAddress) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L7;
        Slog.w(TAG, "Can not stop one touch record. CEC control is disabled.");
        announceOneTouchRecordResult(recorderAddress, 51);
        return;
    L7:
        if (checkRecorder(recorderAddress) == true) goto L10;
        Slog.w(TAG, "Invalid recorder address:" + recorderAddress);
        announceOneTouchRecordResult(recorderAddress, 49);
        return;
    L10:
        removeAction(OneTouchRecordAction.class);
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildRecordOff(getDeviceInfo().getLogicalAddress(), recorderAddress));
        Slog.i(TAG, "Stop [One Touch Record]-Target:" + recorderAddress);
    }

    private boolean checkRecorder(int recorderAddress) {
        HdmiDeviceInfo device = this.mService.getHdmiCecNetwork().getCecDeviceInfo(recorderAddress);
        if (device != null) goto L5;
    L7:
        return false;
    L5:
        if (HdmiUtils.isEligibleAddressForDevice(1, recorderAddress) == false) goto L7;
        return true;
    }

    private boolean checkRecordSource(byte[] recordSource) {
        if (recordSource != null) goto L4;
    L6:
        return false;
    L4:
        if (HdmiRecordSources.checkRecordSource(recordSource) == false) goto L6;
        return true;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void startTimerRecording(int recorderAddress, int sourceType, byte[] recordSource) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L7;
        Slog.w(TAG, "Can not start one touch record. CEC control is disabled.");
        announceTimerRecordingResult(recorderAddress, 3);
        return;
    L7:
        if (checkRecorder(recorderAddress) == true) goto L11;
        Slog.w(TAG, "Invalid recorder address:" + recorderAddress);
        announceTimerRecordingResult(recorderAddress, 1);
        return;
    L11:
        if (checkTimerRecordingSource(sourceType, recordSource) == true) goto L14;
        Slog.w(TAG, "Invalid record source." + Arrays.toString(recordSource));
        announceTimerRecordingResult(recorderAddress, 2);
        return;
    L14:
        addAndStartAction(new TimerRecordingAction(this, recorderAddress, sourceType, recordSource));
        Slog.i(TAG, "Start [Timer Recording]-Target:" + recorderAddress + ", SourceType:" + sourceType + ", RecordSource:" + Arrays.toString(recordSource));
    }

    private boolean checkTimerRecordingSource(int sourceType, byte[] recordSource) {
        if (recordSource != null) goto L4;
    L6:
        return false;
    L4:
        if (HdmiTimerRecordSources.checkTimerRecordSource(sourceType, recordSource) == false) goto L6;
        return true;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void clearTimerRecording(int recorderAddress, int sourceType, byte[] recordSource) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L7;
        Slog.w(TAG, "Can not start one touch record. CEC control is disabled.");
        announceClearTimerRecordingResult(recorderAddress, 162);
        return;
    L7:
        if (checkRecorder(recorderAddress) == true) goto L11;
        Slog.w(TAG, "Invalid recorder address:" + recorderAddress);
        announceClearTimerRecordingResult(recorderAddress, 160);
        return;
    L11:
        if (checkTimerRecordingSource(sourceType, recordSource) == true) goto L14;
        Slog.w(TAG, "Invalid record source." + Arrays.toString(recordSource));
        announceClearTimerRecordingResult(recorderAddress, 161);
        return;
    L14:
        sendClearTimerMessage(recorderAddress, sourceType, recordSource);
    }

    private void sendClearTimerMessage(final int recorderAddress, int sourceType, byte[] recordSource) {
        switch(sourceType) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        Slog.w(TAG, "Invalid source type:" + recorderAddress);
        announceClearTimerRecordingResult(recorderAddress, 161);
        return;
    L6:
        HdmiCecMessage message = HdmiCecMessageBuilder.buildClearExternalTimer(getDeviceInfo().getLogicalAddress(), recorderAddress, recordSource);
    L9:
        this.mService.sendCecCommand(message, new AnonymousClass6(this, recorderAddress));
        return;
    L7:
        message = HdmiCecMessageBuilder.buildClearAnalogueTimer(getDeviceInfo().getLogicalAddress(), recorderAddress, recordSource);
        goto L9
    L8:
        message = HdmiCecMessageBuilder.buildClearDigitalTimer(getDeviceInfo().getLogicalAddress(), recorderAddress, recordSource);
        goto L9
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleMenuStatus(HdmiCecMessage message) {
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int getRcProfile() {
        return 0;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected List<Integer> getRcFeatures() {
        List<Integer> features = new ArrayList();
        int profile = this.mService.getHdmiCecConfig().getIntValue("rc_profile_tv");
        features.add(Integer.valueOf(profile));
        return features;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected DeviceFeatures computeDeviceFeatures() {
        int r0 = 0;
        List<HdmiPortInfo> ports = this.mService.getPortInfo();
        Iterator<HdmiPortInfo> r2 = ports.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        HdmiPortInfo port = r2.next();
        if (isArcFeatureEnabled(port.getId()) == false) goto L4;
        r0 = 1;
    L10:
        return DeviceFeatures.NO_FEATURES_SUPPORTED.toBuilder().setRecordTvScreenSupport(1).setArcTxSupport(r0).setSetAudioVolumeLevelSupport(1).build();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected void sendStandby(int deviceId) {
        HdmiDeviceInfo targetDevice = this.mService.getHdmiCecNetwork().getDeviceInfo(deviceId);
        if (targetDevice != null) goto L5;
        return;
    L5:
        int targetAddress = targetDevice.getLogicalAddress();
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), targetAddress));
    }

    @HdmiAnnotations.ServiceThreadOnly
    void processAllDelayedMessages() {
        assertRunOnServiceThread();
        this.mDelayedMessageBuffer.processAllMessages();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void processDelayedMessages(int address) {
        assertRunOnServiceThread();
        this.mDelayedMessageBuffer.processMessagesForDevice(address);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void processDelayedActiveSource(int address) {
        assertRunOnServiceThread();
        this.mDelayedMessageBuffer.processActiveSource(address);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected void dump(IndentingPrintWriter pw) {
        super.dump(pw);
        pw.println("mArcEstablished: " + this.mArcEstablished);
        pw.println("mArcFeatureEnabled: " + this.mArcFeatureEnabled);
        pw.println("mSystemAudioMute: " + this.mSystemAudioMute);
        pw.println("mSystemAudioControlFeatureEnabled: " + this.mSystemAudioControlFeatureEnabled);
        pw.println("mSkipRoutingControl: " + this.mSkipRoutingControl);
        pw.println("mPrevPortId: " + this.mPrevPortId);
    }
}
