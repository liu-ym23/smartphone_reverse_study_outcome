package com.android.server.hdmi;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.hardware.hdmi.DeviceFeatures;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.HdmiPortInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.tv.TvContract;
import android.media.tv.TvInputInfo;
import android.media.tv.TvInputManager;
import android.os.SystemProperties;
import android.sysprop.HdmiProperties;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecLocalDeviceAudioSystem extends HdmiCecLocalDeviceSource {
    private static final HashMap<Integer, List<Integer>> AUDIO_CODECS_MAP = null;
    private static final int MAX_CHANNELS = 8;
    private static final String SHORT_AUDIO_DESCRIPTOR_CONFIG_PATH = "/vendor/etc/sadConfig.xml";
    private static final String TAG = "HdmiCecLocalDeviceAudioSystem";
    private static final boolean WAKE_ON_HOTPLUG = false;

    @HdmiAnnotations.ServiceThreadOnly
    private boolean mArcEstablished;
    private boolean mArcIntentUsed;
    private final DelayedMessageBuffer mDelayedMessageBuffer;
    private final HashMap<Integer, String> mPortIdToTvInputs;
    private boolean mSystemAudioControlFeatureEnabled;
    private final TvInputManager.TvInputCallback mTvInputCallback;
    private final HashMap<String, HdmiDeviceInfo> mTvInputsToDeviceInfo;
    private Boolean mTvSystemAudioModeSupport;

    interface TvSystemAudioModeSupportedCallback {
        void onResult(boolean r1);
    }

    /* JADX INFO: renamed from: -$$Nest$maddOrUpdateTvInput, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4293$$Nest$maddOrUpdateTvInput(HdmiCecLocalDeviceAudioSystem r0, String r1) {
        r0.addOrUpdateTvInput(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveTvInput, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4294$$Nest$mremoveTvInput(HdmiCecLocalDeviceAudioSystem r0, String r1) {
        r0.removeTvInput(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetSystemAudioMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4295$$Nest$msetSystemAudioMode(HdmiCecLocalDeviceAudioSystem r0, boolean r1) {
        r0.setSystemAudioMode(r1);
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

    static {
        AUDIO_CODECS_MAP = mapAudioCodecWithAudioFormat();
    }

    protected HdmiCecLocalDeviceAudioSystem(HdmiControlService service) {
        super(service, 5);
        this.mTvSystemAudioModeSupport = null;
        boolean r0 = false;
        this.mArcEstablished = false;
        this.mArcIntentUsed = ((String) HdmiProperties.arc_port().orElse("0")).contains("tvinput");
        this.mPortIdToTvInputs = new HashMap();
        this.mTvInputsToDeviceInfo = new HashMap();
        this.mDelayedMessageBuffer = new DelayedMessageBuffer(this);
        this.mTvInputCallback = new AnonymousClass1(this);
        if (this.mService.getHdmiCecConfig().getIntValue("routing_control") != 1) goto L5;
        boolean r1 = true;
    L6:
        this.mRoutingControlFeatureEnabled = r1;
        if (this.mService.getHdmiCecConfig().getIntValue("system_audio_control") != 1) goto L9;
        r0 = true;
    L9:
        this.mSystemAudioControlFeatureEnabled = r0;
        this.mStandbyHandler = new HdmiCecStandbyModeHandler(service, this);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void addOrUpdateTvInput(String inputId) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        TvInputInfo tvInfo = this.mService.getTvInputManager().getTvInputInfo(inputId);     // Catch: Throwable -> L8
        if (tvInfo != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        HdmiDeviceInfo info = tvInfo.getHdmiDeviceInfo();     // Catch: Throwable -> L8
        if (info != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mPortIdToTvInputs.put(Integer.valueOf(info.getPortId()), inputId);     // Catch: Throwable -> L8
        this.mTvInputsToDeviceInfo.put(inputId, info);     // Catch: Throwable -> L8
        if (info.isCecDevice() == false) goto L17;
        processDelayedActiveSource(info.getLogicalAddress());     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void removeTvInput(String inputId) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mTvInputsToDeviceInfo.get(inputId) != null) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int portId = this.mTvInputsToDeviceInfo.get(inputId).getPortId();     // Catch: Throwable -> L8
        this.mPortIdToTvInputs.remove(Integer.valueOf(portId));     // Catch: Throwable -> L8
        this.mTvInputsToDeviceInfo.remove(inputId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected boolean isInputReady(int portId) {
        assertRunOnServiceThread();
        String tvInputId = this.mPortIdToTvInputs.get(Integer.valueOf(portId));
        HdmiDeviceInfo info = this.mTvInputsToDeviceInfo.get(tvInputId);
        if (info == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected DeviceFeatures computeDeviceFeatures() {
        boolean r0 = SystemProperties.getBoolean("persist.sys.hdmi.property_arc_support", true);
        return DeviceFeatures.NO_FEATURES_SUPPORTED.toBuilder().setArcRxSupport(r0 ? 1 : 0).build();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    void onHotplug(int portId, boolean connected) {
        assertRunOnServiceThread();
        HdmiPortInfo portInfo = this.mService.getPortInfo(portId);
        if (portInfo != null) goto L5;
    L14:
        if (connected == false) goto L16;
        return;
    L16:
        if (this.mPortIdToTvInputs.get(Integer.valueOf(portId)) == null) goto L26;
        String tvInputId = this.mPortIdToTvInputs.get(Integer.valueOf(portId));
        HdmiDeviceInfo info = this.mTvInputsToDeviceInfo.get(tvInputId);
        if (info != null) goto L20;
        return;
    L20:
        this.mService.getHdmiCecNetwork().removeCecDevice(this, info.getLogicalAddress());
        return;
    L26:
        return;
    L5:
        if (portInfo.getType() != 1) goto L14;
        this.mCecMessageCache.flushAll();
        if (connected == false) goto L9;
        return;
    L9:
        if (isSystemAudioActivated() == false) goto L12;
        this.mTvSystemAudioModeSupport = null;
        checkSupportAndSetSystemAudioMode(false);
    L12:
        if (isArcEnabled() == false) goto L23;
        setArcStatus(false);
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void disableDevice(boolean initiatedByCec, HdmiCecLocalDevice.PendingActionClearedCallback callback) {
        terminateAudioReturnChannel();
        super.disableDevice(initiatedByCec, callback);
        assertRunOnServiceThread();
        this.mService.unregisterTvInputCallback(this.mTvInputCallback);
        removeAllActions();
        checkIfPendingActionsCleared();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void onStandby(boolean initiatedByCec, int standbyAction, HdmiCecLocalDevice.StandbyCompletedCallback callback) {
        assertRunOnServiceThread();
        this.mService.setActiveSource(-1, 65535, "HdmiCecLocalDeviceAudioSystem#onStandby()");
        this.mTvSystemAudioModeSupport = null;
        Object r0 = this.mLock;
        monitor-enter(r0);
        HdmiControlService r1 = this.mService;     // Catch: Throwable -> L7
        if (isSystemAudioActivated() == false) goto L9;
        String r3 = "true";
    L10:
        r1.writeStringSystemProperty("persist.sys.hdmi.last_system_audio_control", r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        terminateSystemAudioMode(callback);
        return;
    L9:
        r3 = "false";
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void onAddressAllocated(int logicalAddress, int reason) {
        assertRunOnServiceThread();
        if (reason != 0) goto L5;
        this.mService.setAndBroadcastActiveSource(this.mService.getPhysicalAddress(), getDeviceInfo().getDeviceType(), 15, "HdmiCecLocalDeviceAudioSystem#onAddressAllocated()");
    L5:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportPhysicalAddressCommand(getDeviceInfo().getLogicalAddress(), this.mService.getPhysicalAddress(), this.mDeviceType));
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildDeviceVendorIdCommand(getDeviceInfo().getLogicalAddress(), this.mService.getVendorId()));
        this.mService.registerTvInputCallback(this.mTvInputCallback);
        initArcOnFromAvr();
        if (this.mService.isScreenOff() == true) goto L8;
        int systemAudioControlOnPowerOnProp = SystemProperties.getInt("persist.sys.hdmi.system_audio_control_on_power_on", 0);
        boolean lastSystemAudioControlStatus = SystemProperties.getBoolean("persist.sys.hdmi.last_system_audio_control", true);
        systemAudioControlOnPowerOn(systemAudioControlOnPowerOnProp, lastSystemAudioControlStatus);
    L8:
        this.mService.getHdmiCecNetwork().clearDeviceList();
        launchDeviceDiscovery();
        startQueuedActions();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int findKeyReceiverAddress() {
        if (getActiveSource().isValid() == true) goto L5;
        return -1;
    L5:
        return getActiveSource().logicalAddress;
    }

    protected void systemAudioControlOnPowerOn(int systemAudioOnPowerOnProp, boolean lastSystemAudioControlStatus) {
        if (systemAudioOnPowerOnProp == 0) goto L8;
        if (systemAudioOnPowerOnProp != 1) goto L10;
        if (lastSystemAudioControlStatus == true) goto L7;
        return;
    L7:
        if (isSystemAudioControlFeatureEnabled() == true) goto L8;
        return;
    L10:
        return;
    L8:
        addAndStartAction(new SystemAudioInitiationActionFromAvr(this), true);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int getPreferredAddress() {
        assertRunOnServiceThread();
        return SystemProperties.getInt("persist.sys.hdmi.addr.audiosystem", 15);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void setPreferredAddress(int addr) {
        assertRunOnServiceThread();
        this.mService.writeStringSystemProperty("persist.sys.hdmi.addr.audiosystem", String.valueOf(addr));
    }

    @HdmiAnnotations.ServiceThreadOnly
    void processDelayedActiveSource(int address) {
        assertRunOnServiceThread();
        this.mDelayedMessageBuffer.processActiveSource(address);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleActiveSource(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int logicalAddress = message.getSource();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        if (HdmiUtils.getLocalPortFromPhysicalAddress(physicalAddress, this.mService.getPhysicalAddress()) == (-1)) goto L5;
        HdmiDeviceInfo info = this.mService.getHdmiCecNetwork().getCecDeviceInfo(logicalAddress);
        if (info != null) goto L10;
        HdmiLogger.debug("Device info %X not found; buffering the command", new Object[]{Integer.valueOf(logicalAddress)});
        this.mDelayedMessageBuffer.add(message);
    L12:
        return -1;
    L10:
        if (isInputReady(info.getPortId()) == true) goto L13;
        HdmiLogger.debug("Input not ready for device: %X; buffering the command", new Object[]{Integer.valueOf(info.getId())});
        this.mDelayedMessageBuffer.add(message);
        goto L12
    L13:
        this.mDelayedMessageBuffer.removeActiveSource();
        return super.handleActiveSource(message);
    L5:
        return super.handleActiveSource(message);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleInitiateArc(HdmiCecMessage message) {
        assertRunOnServiceThread();
        HdmiLogger.debug("HdmiCecLocalDeviceAudioSystemStub handleInitiateArc", new Object[0]);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleReportArcInitiate(HdmiCecMessage message) {
        assertRunOnServiceThread();
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleReportArcTermination(HdmiCecMessage message) {
        assertRunOnServiceThread();
        processArcTermination();
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGiveAudioStatus(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (isSystemAudioControlFeatureEnabled() == true) goto L5;
        return 4;
    L5:
        if (this.mService.getHdmiCecVolumeControl() != 1) goto L10;
        reportAudioStatus(message.getSource());
        return -1;
    L10:
        return 4;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleGiveSystemAudioModeStatus(HdmiCecMessage message) {
        assertRunOnServiceThread();
        boolean isSystemAudioModeOnOrTurningOn = isSystemAudioActivated();
        if (isSystemAudioModeOnOrTurningOn == false) goto L5;
    L9:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportSystemAudioMode(getDeviceInfo().getLogicalAddress(), message.getSource(), isSystemAudioModeOnOrTurningOn));
        return -1;
    L5:
        if (message.getSource() != 0) goto L9;
        if (hasAction(SystemAudioInitiationActionFromAvr.class) == false) goto L9;
        isSystemAudioModeOnOrTurningOn = true;
        goto L9
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRequestArcInitiate(HdmiCecMessage message) {
        assertRunOnServiceThread();
        removeAction(ArcInitiationActionFromAvr.class);
        if (this.mService.readBooleanSystemProperty("persist.sys.hdmi.property_arc_support", true) == true) goto L6;
        return 0;
    L6:
        if (isDirectConnectToTv() == true) goto L9;
        HdmiLogger.debug("AVR device is not directly connected with TV", new Object[0]);
        return 1;
    L9:
        addAndStartAction(new ArcInitiationActionFromAvr(this));
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRequestArcTermination(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (SystemProperties.getBoolean("persist.sys.hdmi.property_arc_support", true) == true) goto L6;
        return 0;
    L6:
        if (isArcEnabled() == true) goto L10;
        HdmiLogger.debug("ARC is not established between TV and AVR device", new Object[0]);
        return 1;
    L10:
        if (getActions(ArcTerminationActionFromAvr.class).isEmpty() == false) goto L12;
    L14:
        addAndStartAction(new ArcTerminationActionFromAvr(this), true);
        return -1;
    L12:
        if (((ArcTerminationActionFromAvr) getActions(ArcTerminationActionFromAvr.class).get(0)).mCallbacks.isEmpty() == true) goto L14;
        IHdmiControlCallback callback = ((ArcTerminationActionFromAvr) getActions(ArcTerminationActionFromAvr.class).get(0)).mCallbacks.get(0);
        addAndStartAction(new ArcTerminationActionFromAvr(this, callback), true);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRequestShortAudioDescriptor(HdmiCecMessage message) {
        assertRunOnServiceThread();
        HdmiLogger.debug("HdmiCecLocalDeviceAudioSystemStub handleRequestShortAudioDescriptor", new Object[0]);
        if (isSystemAudioControlFeatureEnabled() == true) goto L7;
        return 4;
    L7:
        if (isSystemAudioActivated() == true) goto L10;
        return 1;
    L10:
        List<HdmiUtils.DeviceConfig> config = null;
        File file = new File(SHORT_AUDIO_DESCRIPTOR_CONFIG_PATH);
        if (file.exists() == true) goto L36;
    L20:
        int[] audioCodecs = parseAudioCodecs(message.getParams());
        if (config != null) goto L23;
    L25:
        AudioDeviceInfo deviceInfo = getSystemAudioDeviceInfo();
        if (deviceInfo != null) goto L29;
        return 5;
    L29:
        byte[] sadBytes = getSupportedShortAudioDescriptors(deviceInfo, audioCodecs);
    L31:
        if (sadBytes.length != 0) goto L34;
        return 3;
    L34:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportShortAudioDescriptor(getDeviceInfo().getLogicalAddress(), message.getSource(), sadBytes));
        return -1;
    L23:
        if (config.size() <= 0) goto L25;
        sadBytes = getSupportedShortAudioDescriptorsFromConfig(config, audioCodecs);
        goto L31
    L36:
        InputStream in = new FileInputStream(file);     // Catch: XmlPullParserException -> L14 IOException -> L16
        config = HdmiUtils.ShortAudioDescriptorXmlParser.parse(in);     // Catch: XmlPullParserException -> L14 IOException -> L16
        in.close();     // Catch: XmlPullParserException -> L14 IOException -> L16
    L16:
        e = move-exception;
        Slog.e(TAG, "Error reading file: " + file, e);
    L14:
        e = move-exception;
        Slog.e(TAG, "Unable to parse file: " + file, e);
        goto L20
    }

    byte[] getSupportedShortAudioDescriptors(AudioDeviceInfo deviceInfo, int[] audioCodecs) {
        ArrayList<byte[]> sads = new ArrayList(audioCodecs.length);
        int r1 = audioCodecs.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        int audioCodec = audioCodecs[r2];
        byte[] sad = getSupportedShortAudioDescriptor(deviceInfo, audioCodec);
        if (sad == null) goto L10;
        if (sad.length != 3) goto L9;
        sads.add(sad);
        goto L10
    L9:
        HdmiLogger.warning("Dropping Short Audio Descriptor with length %d for requested codec %x", new Object[]{Integer.valueOf(sad.length), Integer.valueOf(audioCodec)});
    L10:
        r2 = r2 + 1;
        goto L3
    L12:
        return getShortAudioDescriptorBytes(sads);
    }

    private byte[] getSupportedShortAudioDescriptorsFromConfig(List<HdmiUtils.DeviceConfig> deviceConfig, int[] audioCodecs) {
        HdmiUtils.DeviceConfig deviceConfigToUse = null;
        String audioDeviceName = SystemProperties.get("persist.sys.hdmi.property_sytem_audio_mode_audio_port", "VX_AUDIO_DEVICE_IN_HDMI_ARC");
        Iterator<HdmiUtils.DeviceConfig> r2 = deviceConfig.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        HdmiUtils.DeviceConfig device = r2.next();
        if (device.name.equals(audioDeviceName) == false) goto L4;
        deviceConfigToUse = device;
    L9:
        if (deviceConfigToUse != null) goto L12;
        Slog.w(TAG, "sadConfig.xml does not have required device info for " + audioDeviceName);
        return new byte[0];
    L12:
        HashMap<Integer, byte[]> map = new HashMap();
        ArrayList<byte[]> sads = new ArrayList(audioCodecs.length);
        Iterator<HdmiUtils.CodecSad> r4 = deviceConfigToUse.supportedCodecs.iterator();
    L14:
        if (r4.hasNext() == false) goto L16;
        HdmiUtils.CodecSad codecSad = r4.next();
        map.put(Integer.valueOf(codecSad.audioCodec), codecSad.sad);
        goto L14
    L16:
        int i = 0;
    L18:
        if (i >= audioCodecs.length) goto L28;
        if (map.containsKey(Integer.valueOf(audioCodecs[i])) == false) goto L26;
        byte[] sad = map.get(Integer.valueOf(audioCodecs[i]));
        if (sad == null) goto L26;
        if (sad.length != 3) goto L26;
        sads.add(sad);
    L26:
        i = i + 1;
        goto L18
    L28:
        return getShortAudioDescriptorBytes(sads);
    }

    private byte[] getShortAudioDescriptorBytes(ArrayList<byte[]> sads) {
        byte[] bytes = new byte[sads.size() * 3];
        int index = 0;
        Iterator<byte[]> r3 = sads.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        byte[] sad = r3.next();
        System.arraycopy(sad, 0, bytes, index, 3);
        index = index + 3;
        goto L4
    L6:
        return bytes;
    }

    byte[] getSupportedShortAudioDescriptor(AudioDeviceInfo deviceInfo, int audioCodec) {
        byte[] shortAudioDescriptor = new byte[3];
        int[] deviceSupportedAudioFormats = deviceInfo.getEncodings();
        if (AUDIO_CODECS_MAP.containsKey(Integer.valueOf(audioCodec)) == true) goto L5;
    L28:
        return null;
    L5:
        if (deviceSupportedAudioFormats.length == 0) goto L28;
        List<Integer> audioCodecSupportedAudioFormats = AUDIO_CODECS_MAP.get(Integer.valueOf(audioCodec));
        int r4 = deviceSupportedAudioFormats.length;
        int r6 = 0;
    L8:
        if (r6 >= r4) goto L27;
        int supportedAudioFormat = deviceSupportedAudioFormats[r6];
        if (audioCodecSupportedAudioFormats.contains(Integer.valueOf(supportedAudioFormat)) == true) goto L11;
        r6 = r6 + 1;
        goto L8
    L11:
        shortAudioDescriptor[0] = getFirstByteOfSAD(deviceInfo, audioCodec);
        shortAudioDescriptor[1] = getSecondByteOfSAD(deviceInfo);
        switch(audioCodec) {
            case 0: goto L25;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L13;
            case 9: goto L13;
            case 10: goto L14;
            case 11: goto L14;
            case 12: goto L14;
            default: goto L13;
        };
    L13:
        return null;
    L14:
        shortAudioDescriptor[2] = 0;
        return shortAudioDescriptor;
    L16:
        shortAudioDescriptor[2] = getThirdSadByteForCodecs2Through8(deviceInfo);
        return shortAudioDescriptor;
    L18:
        if (supportedAudioFormat != 2) goto L21;
        shortAudioDescriptor[2] = 1;
    L24:
        return shortAudioDescriptor;
    L21:
        if (supportedAudioFormat != 21) goto L23;
        shortAudioDescriptor[2] = 4;
        goto L24
    L23:
        shortAudioDescriptor[2] = 0;
        goto L24
    L25:
        return null;
    L27:
        return null;
    }

    private static HashMap<Integer, List<Integer>> mapAudioCodecWithAudioFormat() {
        HashMap<Integer, List<Integer>> audioCodecsMap = new HashMap();
        audioCodecsMap.put(0, List.of(1));
        audioCodecsMap.put(1, List.of(3, 2, 4, 21, 22));
        audioCodecsMap.put(2, List.of(5));
        audioCodecsMap.put(3, List.of(11));
        audioCodecsMap.put(5, List.of(12));
        audioCodecsMap.put(4, List.of(9));
        audioCodecsMap.put(6, List.of(10));
        audioCodecsMap.put(7, List.of(7));
        audioCodecsMap.put(10, List.of(6, 18));
        audioCodecsMap.put(11, List.of(8));
        audioCodecsMap.put(12, List.of(14, 19));
        return audioCodecsMap;
    }

    private byte getFirstByteOfSAD(AudioDeviceInfo deviceInfo, int audioCodec) {
        int maxNumberOfChannels = getMaxNumberOfChannels(deviceInfo);
        byte firstByte = (byte) ((maxNumberOfChannels - 1) | 0);
        return (byte) ((audioCodec << 3) | firstByte);
    }

    private byte getSecondByteOfSAD(AudioDeviceInfo deviceInfo) {
        ArrayList<Integer> samplingRates = new ArrayList(Arrays.asList(new Integer[]{32, 44, 48, 88, 96, Integer.valueOf(FrameworkStatsLog.DEVICE_POLICY_EVENT__EVENT_ID__DOCSUI_PICK_RESULT), 192}));
        int[] samplingRatesDeviceSupports = deviceInfo.getSampleRates();
        if (samplingRatesDeviceSupports.length != 0) goto L6;
        Slog.e(TAG, "Device supports arbitrary rates");
        return 127;
    L6:
        byte secondByte = 0;
        int r3 = samplingRatesDeviceSupports.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        int supportedSampleRate = samplingRatesDeviceSupports[r4];
        if (samplingRates.contains(Integer.valueOf(supportedSampleRate)) == false) goto L11;
        int index = samplingRates.indexOf(Integer.valueOf(supportedSampleRate));
        secondByte = (byte) ((1 << index) | secondByte);
    L11:
        r4 = r4 + 1;
        goto L7
    L12:
        return secondByte;
    }

    private int getMaxNumberOfChannels(AudioDeviceInfo deviceInfo) {
        int[] channelCounts = deviceInfo.getChannelCounts();
        if (channelCounts.length == 0) goto L10;
        int maxNumberOfChannels = channelCounts[channelCounts.length - 1];
        int maxNumberOfChannels2 = 8;
        if (maxNumberOfChannels > 8) goto L9;
        maxNumberOfChannels2 = maxNumberOfChannels;
    L9:
        return maxNumberOfChannels2;
    L10:
        return 8;
    }

    private byte getThirdSadByteForCodecs2Through8(AudioDeviceInfo deviceInfo) {
        int maxSamplingRate = 0;
        int[] samplingRatesDeviceSupports = deviceInfo.getSampleRates();
        if (samplingRatesDeviceSupports.length != 0) goto L5;
        maxSamplingRate = 192;
    L13:
        return (byte) (maxSamplingRate / 8);
    L5:
        int r2 = samplingRatesDeviceSupports.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        int sampleRate = samplingRatesDeviceSupports[r3];
        if (maxSamplingRate >= sampleRate) goto L11;
        maxSamplingRate = sampleRate;
    L11:
        r3 = r3 + 1;
        goto L7
    }

    private AudioDeviceInfo getSystemAudioDeviceInfo() {
        AudioManager audioManager = (AudioManager) this.mService.getContext().getSystemService(AudioManager.class);
        int r2 = 0;
        if (audioManager != null) goto L6;
        HdmiLogger.error("Error getting system audio device because AudioManager not available.", new Object[0]);
        return null;
    L6:
        AudioDeviceInfo[] devices = audioManager.getDevices(1);
        HdmiLogger.debug("Found %d audio input devices", new Object[]{Integer.valueOf(devices.length)});
        int r4 = devices.length;
    L7:
        if (r2 >= r4) goto L12;
        AudioDeviceInfo device = devices[r2];
        HdmiLogger.debug("%s at port %s", new Object[]{device.getProductName(), device.getPort()});
        HdmiLogger.debug("Supported encodings are %s", new Object[]{Arrays.stream(device.getEncodings()).mapToObj(new HdmiCecLocalDeviceAudioSystem$$ExternalSyntheticLambda0()).collect(Collectors.joining(", "))});
        if (device.getType() == 10) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return device;
    L12:
        return null;
    }

    private int[] parseAudioCodecs(byte[] params) {
        int[] audioCodecs = new int[params.length];
        int i = 0;
    L4:
        if (i >= params.length) goto L13;
        byte val = params[i];
        if (val >= 1) goto L8;
    L10:
        byte r3 = 0;
    L11:
        audioCodecs[i] = r3;
        i = i + 1;
        goto L4
    L8:
        if (val > 15) goto L10;
        r3 = val;
        goto L11
    L13:
        return audioCodecs;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSystemAudioModeRequest(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (message.getParams().length == 0) goto L5;
        boolean systemAudioStatusOn = true;
    L7:
        if (message.getSource() == 0) goto L11;
        if (systemAudioStatusOn == false) goto L13;
        return handleSystemAudioModeOnFromNonTvDevice(message);
    L13:
        if (checkSupportAndSetSystemAudioMode(systemAudioStatusOn) == true) goto L16;
        return 4;
    L16:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildSetSystemAudioMode(getDeviceInfo().getLogicalAddress(), 15, systemAudioStatusOn));
        if (systemAudioStatusOn == false) goto L24;
        int sourcePhysicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        if (HdmiUtils.getLocalPortFromPhysicalAddress(sourcePhysicalAddress, getDeviceInfo().getPhysicalAddress()) == (-1)) goto L21;
        return -1;
    L21:
        HdmiDeviceInfo safeDeviceInfoByPath = this.mService.getHdmiCecNetwork().getSafeDeviceInfoByPath(sourcePhysicalAddress);
        if (safeDeviceInfoByPath != null) goto L24;
        switchInputOnReceivingNewActivePath(sourcePhysicalAddress);
    L24:
        return -1;
    L11:
        setTvSystemAudioModeSupport(true);
        goto L13
    L5:
        systemAudioStatusOn = false;
        goto L7
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSetSystemAudioMode(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (checkSupportAndSetSystemAudioMode(HdmiUtils.parseCommandParamSystemAudioStatus(message)) == true) goto L6;
        return 4;
    L6:
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSystemAudioModeStatus(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (checkSupportAndSetSystemAudioMode(HdmiUtils.parseCommandParamSystemAudioStatus(message)) == true) goto L6;
        return 4;
    L6:
        return -1;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setArcStatus(boolean enabled) {
        assertRunOnServiceThread();
        HdmiLogger.debug("Set Arc Status[old:%b new:%b]", new Object[]{Boolean.valueOf(this.mArcEstablished), Boolean.valueOf(enabled)});
        enableAudioReturnChannel(enabled);
        notifyArcStatusToAudioService(enabled);
        this.mArcEstablished = enabled;
    }

    void processArcTermination() {
        setArcStatus(false);
        if (getLocalActivePort() != 17) goto L6;
        routeToInputFromPortId(getRoutingPort());
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void enableAudioReturnChannel(boolean enabled) {
        assertRunOnServiceThread();
        this.mService.enableAudioReturnChannel(Integer.parseInt((String) HdmiProperties.arc_port().orElse("0")), enabled);
    }

    private void notifyArcStatusToAudioService(boolean r4) {
        this.mService.getAudioManager().setWiredDeviceConnectionState(-2013265920, r4 ? 1 : 0, "", "");
    }

    void reportAudioStatus(int source) {
        assertRunOnServiceThread();
        if (this.mService.getHdmiCecVolumeControl() != 0) goto L5;
        return;
    L5:
        int volume = this.mService.getAudioManager().getStreamVolume(3);
        boolean mute = this.mService.getAudioManager().isStreamMute(3);
        int maxVolume = this.mService.getAudioManager().getStreamMaxVolume(3);
        int minVolume = this.mService.getAudioManager().getStreamMinVolume(3);
        int scaledVolume = VolumeControlAction.scaleToCecVolume(volume, maxVolume);
        HdmiLogger.debug("Reporting volume %d (%d-%d) as CEC volume %d", new Object[]{Integer.valueOf(volume), Integer.valueOf(minVolume), Integer.valueOf(maxVolume), Integer.valueOf(scaledVolume)});
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportAudioStatus(getDeviceInfo().getLogicalAddress(), source, scaledVolume, mute));
    }

    protected boolean checkSupportAndSetSystemAudioMode(boolean newSystemAudioMode) {
        if (isSystemAudioControlFeatureEnabled() == true) goto L10;
        StringBuilder r0 = new StringBuilder();
        r0.append("Cannot turn ");
        if (newSystemAudioMode == false) goto L7;
        String r1 = "on";
    L8:
        r0.append(r1);
        r0.append("system audio mode because the System Audio Control feature is disabled.");
        HdmiLogger.debug(r0.toString(), new Object[0]);
        return false;
    L7:
        r1 = "off";
        goto L8
    L10:
        HdmiLogger.debug("System Audio Mode change[old:%b new:%b]", new Object[]{Boolean.valueOf(isSystemAudioActivated()), Boolean.valueOf(newSystemAudioMode)});
        if (newSystemAudioMode == false) goto L13;
        this.mService.wakeUp();
    L13:
        setSystemAudioMode(newSystemAudioMode);
        return true;
    }

    private void setSystemAudioMode(boolean newSystemAudioMode) {
        int targetPhysicalAddress = getActiveSource().physicalAddress;
        int port = this.mService.pathToPortId(targetPhysicalAddress);
        if (newSystemAudioMode == false) goto L7;
        if (port < 0) goto L7;
        switchToAudioInput();
    L7:
        if (this.mService.getHdmiCecConfig().getIntValue("system_audio_mode_muting") != 1) goto L9;
        boolean systemAudioModeMutingEnabled = true;
    L10:
        boolean currentMuteStatus = this.mService.getAudioManager().isStreamMute(3);
        if (currentMuteStatus != newSystemAudioMode) goto L19;
        if (systemAudioModeMutingEnabled == true) goto L14;
        if (newSystemAudioMode == false) goto L19;
    L14:
        AudioManagerWrapper r7 = this.mService.getAudioManager();
        if (newSystemAudioMode == false) goto L17;
        int r8 = 100;
    L18:
        r7.adjustStreamVolume(3, r8, 0);
        goto L19
    L17:
        r8 = -100;
    L19:
        updateAudioManagerForSystemAudio(newSystemAudioMode);
        Object r3 = this.mLock;
        monitor-enter(r3);
    L24:
        th = move-exception;
        throw th;
    L22:
        if (isSystemAudioActivated() == newSystemAudioMode) goto L26;
        this.mService.setSystemAudioActivated(newSystemAudioMode);     // Catch: Throwable -> L24
        this.mService.announceSystemAudioModeChange(newSystemAudioMode);     // Catch: Throwable -> L24
    L26:
        monitor-exit(r3);     // Catch: Throwable -> L24
        if (this.mArcIntentUsed == false) goto L35;
        if (systemAudioModeMutingEnabled == true) goto L35;
        if (newSystemAudioMode == true) goto L35;
        if (getLocalActivePort() != 17) goto L35;
        routeToInputFromPortId(getRoutingPort());
    L35:
        if (SystemProperties.getBoolean("persist.sys.hdmi.property_arc_support", true) == true) goto L37;
        return;
    L37:
        if (isDirectConnectToTv() == true) goto L39;
        return;
    L39:
        if (this.mService.isSystemAudioActivated() == true) goto L41;
        return;
    L41:
        if (hasAction(ArcInitiationActionFromAvr.class) == true) goto L51;
        addAndStartAction(new ArcInitiationActionFromAvr(this));
        return;
    L51:
        return;
    L9:
        systemAudioModeMutingEnabled = false;
        goto L10
    }

    protected void switchToAudioInput() {
    }

    protected boolean isDirectConnectToTv() {
        int myPhysicalAddress = this.mService.getPhysicalAddress();
        if ((61440 & myPhysicalAddress) != myPhysicalAddress) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateAudioManagerForSystemAudio(boolean on) {
        int device = this.mService.getAudioManager().setHdmiSystemAudioSupported(on);
        HdmiLogger.debug("[A]UpdateSystemAudio mode[on=%b] output=[%X]", new Object[]{Boolean.valueOf(on), Integer.valueOf(device)});
    }

    void onSystemAudioControlFeatureSupportChanged(boolean enabled) {
        setSystemAudioControlFeatureEnabled(enabled);
        if (enabled == false) goto L6;
        addAndStartAction(new SystemAudioInitiationActionFromAvr(this), true);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setSystemAudioControlFeatureEnabled(boolean enabled) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSystemAudioControlFeatureEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void setRoutingControlFeatureEnabled(boolean enabled) {
        assertRunOnServiceThread();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRoutingControlFeatureEnabled = enabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void doManualPortSwitching(int portId, IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        if (this.mService.isValidPortId(portId) == true) goto L7;
        invokeCallback(callback, 3);
        return;
    L7:
        if (portId != getLocalActivePort()) goto L11;
        invokeCallback(callback, 0);
        return;
    L11:
        if (this.mService.isCecControlEnabled() == true) goto L15;
        setRoutingPort(portId);
        setLocalActivePort(portId);
        invokeCallback(callback, 6);
        return;
    L15:
        if (getRoutingPort() == 0) goto L17;
        int oldPath = this.mService.portIdToPath(getRoutingPort());
    L18:
        int newPath = this.mService.portIdToPath(portId);
        if (oldPath != newPath) goto L21;
        return;
    L21:
        setRoutingPort(portId);
        setLocalActivePort(portId);
        HdmiCecMessage routingChange = HdmiCecMessageBuilder.buildRoutingChange(getDeviceInfo().getLogicalAddress(), oldPath, newPath);
        this.mService.sendCecCommand(routingChange);
        return;
    L17:
        oldPath = getDeviceInfo().getPhysicalAddress();
        goto L18
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

    protected boolean isSystemAudioActivated() {
        return this.mService.isSystemAudioActivated();
    }

    protected void terminateSystemAudioMode() {
        terminateSystemAudioMode(null);
    }

    protected void terminateSystemAudioMode(final HdmiCecLocalDevice.StandbyCompletedCallback callback) {
        removeAction(SystemAudioInitiationActionFromAvr.class);
        if (isSystemAudioActivated() == true) goto L7;
        invokeStandbyCompletedCallback(callback);
        return;
    L7:
        if (checkSupportAndSetSystemAudioMode(false) == false) goto L10;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildSetSystemAudioMode(getDeviceInfo().getLogicalAddress(), 15, false), new AnonymousClass2(this, callback));
        return;
    }

    private void terminateAudioReturnChannel() {
        removeAction(ArcInitiationActionFromAvr.class);
        if (isArcEnabled() == true) goto L5;
        return;
    L5:
        if (this.mService.readBooleanSystemProperty("persist.sys.hdmi.property_arc_support", true) == false) goto L10;
        addAndStartAction(new ArcTerminationActionFromAvr(this));
        return;
    }

    void queryTvSystemAudioModeSupport(TvSystemAudioModeSupportedCallback callback) {
        if (this.mTvSystemAudioModeSupport != null) goto L5;
        addAndStartAction(new DetectTvSystemAudioModeSupportAction(this, callback));
        return;
    L5:
        callback.onResult(this.mTvSystemAudioModeSupport.booleanValue());
    }

    int handleSystemAudioModeOnFromNonTvDevice(final HdmiCecMessage message) {
        if (isSystemAudioControlFeatureEnabled() == true) goto L6;
        HdmiLogger.debug("Cannot turn onsystem audio mode because the System Audio Control feature is disabled.", new Object[0]);
        return 4;
    L6:
        this.mService.wakeUp();
        if (this.mService.pathToPortId(getActiveSource().physicalAddress) == (-1)) goto L10;
        setSystemAudioMode(true);
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildSetSystemAudioMode(getDeviceInfo().getLogicalAddress(), 15, true));
        return -1;
    L10:
        queryTvSystemAudioModeSupport(new AnonymousClass3(this, message));
        return -1;
    }

    void setTvSystemAudioModeSupport(boolean supported) {
        this.mTvSystemAudioModeSupport = Boolean.valueOf(supported);
    }

    protected boolean isArcEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mArcEstablished;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void initArcOnFromAvr() {
        removeAction(ArcTerminationActionFromAvr.class);
        if (SystemProperties.getBoolean("persist.sys.hdmi.property_arc_support", true) == true) goto L5;
        return;
    L5:
        if (isDirectConnectToTv() == true) goto L7;
        return;
    L7:
        if (isArcEnabled() == true) goto L12;
        addAndStartAction(new ArcInitiationActionFromAvr(this), true);
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource
    protected void switchInputOnReceivingNewActivePath(int physicalAddress) {
        int port = this.mService.pathToPortId(physicalAddress);
        if (isSystemAudioActivated() == false) goto L7;
        if (port >= 0) goto L7;
        routeToInputFromPortId(17);
        return;
    L7:
        if (this.mIsSwitchDevice == false) goto L12;
        if (port < 0) goto L13;
        routeToInputFromPortId(port);
        return;
    L13:
        return;
    }

    protected void routeToInputFromPortId(int portId) {
        if (isRoutingControlFeatureEnabled() == true) goto L7;
        HdmiLogger.debug("Routing Control Feature is not enabled.", new Object[0]);
        return;
    L7:
        if (this.mArcIntentUsed == false) goto L10;
        routeToTvInputFromPortId(portId);
        return;
    }

    protected void routeToTvInputFromPortId(int portId) {
        if (portId >= 0) goto L5;
    L26:
        HdmiLogger.debug("Invalid port number for Tv Input switching.", new Object[0]);
        return;
    L5:
        if (portId >= 21) goto L26;
        this.mService.wakeUp();
        if (getLocalActivePort() != portId) goto L12;
        if (portId == 17) goto L12;
        HdmiLogger.debug("Not switching to the same port " + portId + " except for arc", new Object[0]);
        return;
    L12:
        if (portId == 0) goto L14;
    L16:
        if (portId != 17) goto L19;
        switchToTvInput((String) HdmiProperties.arc_port().orElse("0"));
        setLocalActivePort(portId);
        return;
    L19:
        String uri = this.mPortIdToTvInputs.get(Integer.valueOf(portId));
        if (uri == null) goto L24;
        switchToTvInput(uri);
    L22:
        setLocalActivePort(portId);
        setRoutingPort(portId);
        return;
    L24:
        HdmiLogger.debug("Port number does not match any Tv Input.", new Object[0]);
        return;
    L14:
        if (this.mService.isPlaybackDevice() == false) goto L16;
        switchToHomeTvInput();
        goto L22
    }

    private void switchToTvInput(String uri) {
        this.mService.getContext().startActivity(new Intent("android.intent.action.VIEW", TvContract.buildChannelUriForPassthroughInput(uri)).addFlags(268435456));     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Can't find activity to switch to " + uri, e);
    }

    private void switchToHomeTvInput() {
        Intent activityIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME").setFlags(872480768);     // Catch: ActivityNotFoundException -> L4
        this.mService.getContext().startActivity(activityIntent);     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Can't find activity to switch to HOME", e);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource
    protected void handleRoutingChangeAndInformation(int physicalAddress, HdmiCecMessage message) {
        int port = this.mService.pathToPortId(physicalAddress);
        if (port <= 0) goto L5;
        return;
    L5:
        if (port < 0) goto L7;
    L10:
        if (port != 0) goto L13;
        handleRoutingChangeAndInformationForSwitch(message);
        return;
    L13:
        return;
    L7:
        if (isSystemAudioActivated() == false) goto L10;
        handleRoutingChangeAndInformationForSystemAudio();
    }

    private void handleRoutingChangeAndInformationForSystemAudio() {
        routeToInputFromPortId(17);
    }

    private void handleRoutingChangeAndInformationForSwitch(HdmiCecMessage message) {
        if (getRoutingPort() == 0) goto L5;
    L8:
        int routingInformationPath = this.mService.portIdToPath(getRoutingPort());
        if (routingInformationPath != this.mService.getPhysicalAddress()) goto L12;
        HdmiLogger.debug("Current device can't assign valid physical addressto devices under it any more. It's physical address is " + routingInformationPath, new Object[0]);
        return;
    L12:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildRoutingInformation(getDeviceInfo().getLogicalAddress(), routingInformationPath));
        routeToInputFromPortId(getRoutingPort());
        return;
    L5:
        if (this.mService.isPlaybackDevice() == false) goto L8;
        routeToInputFromPortId(0);
        this.mService.setAndBroadcastActiveSourceFromOneDeviceType(message.getSource(), this.mService.getPhysicalAddress(), "HdmiCecLocalDeviceAudioSystem#handleRoutingChangeAndInformationForSwitch()");
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void launchDeviceDiscovery() {
        assertRunOnServiceThread();
        if (this.mService.isDeviceDiscoveryHandledByPlayback() == false) goto L5;
        return;
    L5:
        DeviceDiscoveryAction action = new DeviceDiscoveryAction(this, new AnonymousClass4(this));
        addAndStartAction(action, true);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected void dump(IndentingPrintWriter pw) {
        pw.println("HdmiCecLocalDeviceAudioSystem:");
        pw.increaseIndent();
        pw.println("isRoutingFeatureEnabled " + isRoutingControlFeatureEnabled());
        pw.println("mSystemAudioControlFeatureEnabled: " + this.mSystemAudioControlFeatureEnabled);
        pw.println("mTvSystemAudioModeSupport: " + this.mTvSystemAudioModeSupport);
        pw.println("mArcEstablished: " + this.mArcEstablished);
        pw.println("mArcIntentUsed: " + this.mArcIntentUsed);
        pw.println("mRoutingPort: " + getRoutingPort());
        pw.println("mLocalActivePort: " + getLocalActivePort());
        HdmiUtils.dumpMap(pw, "mPortIdToTvInputs:", this.mPortIdToTvInputs);
        HdmiUtils.dumpMap(pw, "mTvInputsToDeviceInfo:", this.mTvInputsToDeviceInfo);
        pw.decreaseIndent();
        super.dump(pw);
    }
}
