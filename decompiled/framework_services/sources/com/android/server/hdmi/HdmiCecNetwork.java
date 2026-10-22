package com.android.server.hdmi;

import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.HdmiPortInfo;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.os.Handler;
import android.os.Looper;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.android.internal.util.IndentingPrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecNetwork {
    private static final String TAG = "HdmiCecNetwork";
    private final ArraySet<Integer> mCecSwitches;
    private final SparseArray<HdmiDeviceInfo> mDeviceInfos;
    private final Handler mHandler;
    private final HdmiCecController mHdmiCecController;
    private final HdmiControlService mHdmiControlService;
    private final HdmiMhlControllerStub mHdmiMhlController;
    private final SparseArray<HdmiCecLocalDevice> mLocalDevices;
    protected final Object mLock;
    private int mPhysicalAddress;
    private UnmodifiableSparseArray<HdmiDeviceInfo> mPortDeviceMap;
    private UnmodifiableSparseIntArray mPortIdMap;
    private List<HdmiPortInfo> mPortInfo;
    private UnmodifiableSparseArray<HdmiPortInfo> mPortInfoMap;
    private List<HdmiDeviceInfo> mSafeAllDeviceInfos;
    private List<HdmiDeviceInfo> mSafeExternalInputs;

    public static /* synthetic */ boolean $r8$lambda$DO_hW05UXhCRwhfmkyDt1Ky2wzw(int r0, HdmiCecLocalDevice r1) {
        return lambda$removeUnusedLocalDevices$0(r0, r1);
    }

    HdmiCecNetwork(HdmiControlService hdmiControlService, HdmiCecController hdmiCecController, HdmiMhlControllerStub hdmiMhlController) {
        this.mLocalDevices = new SparseArray();
        this.mDeviceInfos = new SparseArray();
        this.mCecSwitches = new ArraySet();
        this.mSafeAllDeviceInfos = Collections.emptyList();
        this.mSafeExternalInputs = Collections.emptyList();
        this.mPortInfo = Collections.emptyList();
        this.mPhysicalAddress = 65535;
        this.mHdmiControlService = hdmiControlService;
        this.mHdmiCecController = hdmiCecController;
        this.mHdmiMhlController = hdmiMhlController;
        this.mHandler = new Handler(this.mHdmiControlService.getServiceLooper());
        this.mLock = this.mHdmiControlService.getServiceLock();
    }

    private static boolean isConnectedToCecSwitch(int path, Collection<Integer> switches) {
        Iterator<Integer> r0 = switches.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        int switchPath = r0.next().intValue();
        if (isParentPath(switchPath, path) == false) goto L4;
        return true;
    L10:
        return false;
    }

    private static boolean isParentPath(int parentPath, int childPath) {
        int i = 0;
    L4:
        if (i > 12) goto L15;
        int nibble = (childPath >> i) & 15;
        if (nibble != 0) goto L7;
        i = i + 4;
        goto L4
    L7:
        int parentNibble = (parentPath >> i) & 15;
        if (parentNibble == 0) goto L10;
        return false;
    L10:
        if ((childPath >> (i + 4)) != (parentPath >> (i + 4))) goto L19;
        return true;
    L19:
        return false;
    L15:
        return false;
    }

    public void addLocalDevice(int deviceType, HdmiCecLocalDevice device) {
        this.mLocalDevices.put(deviceType, device);
    }

    HdmiCecLocalDevice getLocalDevice(int deviceType) {
        return this.mLocalDevices.get(deviceType);
    }

    @HdmiAnnotations.ServiceThreadOnly
    List<HdmiCecLocalDevice> getLocalDeviceList() {
        assertRunOnServiceThread();
        return HdmiUtils.sparseArrayToList(this.mLocalDevices);
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isAllocatedLocalDeviceAddress(int address) {
        assertRunOnServiceThread();
        int i = 0;
    L4:
        if (i >= this.mLocalDevices.size()) goto L10;
        if (this.mLocalDevices.valueAt(i).isAddressOf(address) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void clearLocalDevices() {
        assertRunOnServiceThread();
        this.mLocalDevices.clear();
    }

    public HdmiDeviceInfo getDeviceInfo(int id) {
        return this.mDeviceInfos.get(id);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private HdmiDeviceInfo addDeviceInfo(HdmiDeviceInfo deviceInfo) {
        assertRunOnServiceThread();
        HdmiDeviceInfo oldDeviceInfo = getCecDeviceInfo(deviceInfo.getLogicalAddress());
        this.mHdmiControlService.checkLogicalAddressConflictAndReallocate(deviceInfo.getLogicalAddress(), deviceInfo.getPhysicalAddress());
        if (oldDeviceInfo == null) goto L5;
        removeDeviceInfo(deviceInfo.getId());
    L5:
        this.mDeviceInfos.append(deviceInfo.getId(), deviceInfo);
        updateSafeDeviceInfoList();
        return oldDeviceInfo;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private HdmiDeviceInfo removeDeviceInfo(int id) {
        assertRunOnServiceThread();
        HdmiDeviceInfo deviceInfo = this.mDeviceInfos.get(id);
        if (deviceInfo == null) goto L5;
        this.mDeviceInfos.remove(id);
    L5:
        updateSafeDeviceInfoList();
        return deviceInfo;
    }

    @HdmiAnnotations.ServiceThreadOnly
    HdmiDeviceInfo getCecDeviceInfo(int logicalAddress) {
        assertRunOnServiceThread();
        return this.mDeviceInfos.get(HdmiDeviceInfo.idForCecDevice(logicalAddress));
    }

    @HdmiAnnotations.ServiceThreadOnly
    final void addCecDevice(HdmiDeviceInfo info) {
        assertRunOnServiceThread();
        HdmiDeviceInfo old = addDeviceInfo(info);
        if (isLocalDeviceAddress(info.getLogicalAddress()) == false) goto L5;
        return;
    L5:
        this.mHdmiControlService.checkAndUpdateAbsoluteVolumeBehavior();
        if (info.getPhysicalAddress() != 65535) goto L9;
        return;
    L9:
        if (old != null) goto L11;
    L16:
        invokeDeviceEventListener(info, 1);
        return;
    L11:
        if (old.getPhysicalAddress() == 65535) goto L16;
        if (old.equals(info) == true) goto L18;
        invokeDeviceEventListener(old, 2);
        invokeDeviceEventListener(info, 1);
        return;
    }

    private void invokeDeviceEventListener(HdmiDeviceInfo info, int event) {
        if (event != 2) goto L5;
    L6:
        this.mHdmiControlService.invokeDeviceEventListeners(info, event);
        return;
    L5:
        if (hideDevicesBehindLegacySwitch(info) == false) goto L6;
    }

    @HdmiAnnotations.ServiceThreadOnly
    final void updateCecDevice(HdmiDeviceInfo info) {
        assertRunOnServiceThread();
        HdmiDeviceInfo old = addDeviceInfo(info);
        if (info.getPhysicalAddress() != 65535) goto L5;
        return;
    L5:
        if (old != null) goto L7;
    L12:
        invokeDeviceEventListener(info, 1);
        return;
    L7:
        if (old.getPhysicalAddress() == 65535) goto L12;
        if (old.equals(info) == true) goto L14;
        invokeDeviceEventListener(info, 3);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void updateSafeDeviceInfoList() {
        assertRunOnServiceThread();
        List<HdmiDeviceInfo> copiedDevices = HdmiUtils.sparseArrayToList(this.mDeviceInfos);
        List<HdmiDeviceInfo> externalInputs = getInputDevices();
        this.mSafeAllDeviceInfos = copiedDevices;
        this.mSafeExternalInputs = externalInputs;
    }

    @HdmiAnnotations.ServiceThreadOnly
    List<HdmiDeviceInfo> getDeviceInfoList(boolean includeLocalDevice) {
        assertRunOnServiceThread();
        if (includeLocalDevice == true) goto L5;
        ArrayList<HdmiDeviceInfo> infoList = new ArrayList();
        int i = 0;
    L8:
        if (i >= this.mDeviceInfos.size()) goto L14;
        HdmiDeviceInfo info = this.mDeviceInfos.valueAt(i);
        if (isLocalDeviceAddress(info.getLogicalAddress()) == true) goto L12;
        infoList.add(info);
    L12:
        i = i + 1;
        goto L8
    L14:
        return infoList;
    L5:
        return HdmiUtils.sparseArrayToList(this.mDeviceInfos);
    }

    List<HdmiDeviceInfo> getSafeExternalInputsLocked() {
        return this.mSafeExternalInputs;
    }

    private List<HdmiDeviceInfo> getInputDevices() {
        ArrayList<HdmiDeviceInfo> infoList = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mDeviceInfos.size()) goto L15;
        HdmiDeviceInfo info = this.mDeviceInfos.valueAt(i);
        if (isLocalDeviceAddress(info.getLogicalAddress()) == true) goto L13;
        if (info.isSourceType() == false) goto L13;
        if (hideDevicesBehindLegacySwitch(info) == true) goto L13;
        infoList.add(info);
    L13:
        i = i + 1;
        goto L4
    L15:
        return infoList;
    }

    private boolean hideDevicesBehindLegacySwitch(HdmiDeviceInfo info) {
        if (isLocalDeviceAddress(0) == true) goto L5;
        return false;
    L5:
        if (isConnectedToCecSwitch(info.getPhysicalAddress(), getCecSwitches()) == false) goto L7;
        return false;
    L7:
        if (info.getPhysicalAddress() == 65535) goto L13;
        return true;
    L13:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    final void removeCecDevice(HdmiCecLocalDevice localDevice, int address) {
        assertRunOnServiceThread();
        HdmiDeviceInfo info = removeDeviceInfo(HdmiDeviceInfo.idForCecDevice(address));
        this.mHdmiControlService.checkAndUpdateAbsoluteVolumeBehavior();
        localDevice.mCecMessageCache.flushMessagesFrom(address);
        if (info.getPhysicalAddress() != 65535) goto L5;
        return;
    L5:
        invokeDeviceEventListener(info, 2);
    }

    public void updateDevicePowerStatus(int logicalAddress, int newPowerStatus) {
        HdmiDeviceInfo info = getCecDeviceInfo(logicalAddress);
        if (info != null) goto L7;
        Slog.w(TAG, "Can not update power status of non-existing device:" + logicalAddress);
        return;
    L7:
        if (info.getDevicePowerStatus() != newPowerStatus) goto L9;
        return;
    L9:
        updateCecDevice(info.toBuilder().setDevicePowerStatus(newPowerStatus).build());
    }

    boolean isConnectedToArcPort(int physicalAddress) {
        int portId = physicalAddressToPortId(physicalAddress);
        if (portId == (-1)) goto L7;
        if (portId != 0) goto L6;
        return false;
    L6:
        return this.mPortInfoMap.get(portId).isArcSupported();
    L7:
        return false;
    }

    @HdmiAnnotations.ServiceThreadOnly
    public void initPortInfo() {
        assertRunOnServiceThread();
        HdmiPortInfo[] cecPortInfo = null;
        if (this.mHdmiCecController == null) goto L5;
        cecPortInfo = this.mHdmiCecController.getPortInfos();
        this.mPhysicalAddress = 65535;
    L5:
        if (cecPortInfo != null) goto L7;
        return;
    L7:
        SparseArray<HdmiPortInfo> portInfoMap = new SparseArray();
        SparseIntArray portIdMap = new SparseIntArray();
        SparseArray<HdmiDeviceInfo> portDeviceMap = new SparseArray();
        int r4 = cecPortInfo.length;
        int r5 = 0;
        int r6 = 0;
    L8:
        if (r6 >= r4) goto L10;
        HdmiPortInfo info = cecPortInfo[r6];
        portIdMap.put(info.getAddress(), info.getId());
        portInfoMap.put(info.getId(), info);
        portDeviceMap.put(info.getId(), HdmiDeviceInfo.hardwarePort(info.getAddress(), info.getId()));
        r6 = r6 + 1;
        goto L8
    L10:
        this.mPortIdMap = new UnmodifiableSparseIntArray(portIdMap);
        this.mPortInfoMap = new UnmodifiableSparseArray(portInfoMap);
        this.mPortDeviceMap = new UnmodifiableSparseArray(portDeviceMap);
        if (this.mHdmiMhlController != null) goto L13;
        return;
    L13:
        HdmiPortInfo[] mhlPortInfo = this.mHdmiMhlController.getPortInfos();
        ArraySet<Integer> mhlSupportedPorts = new ArraySet(mhlPortInfo.length);
        int r7 = mhlPortInfo.length;
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L20;
        HdmiPortInfo info2 = mhlPortInfo[r8];
        if (info2.isMhlSupported() == false) goto L18;
        mhlSupportedPorts.add(Integer.valueOf(info2.getId()));
    L18:
        r8 = r8 + 1;
        goto L14
    L20:
        if (mhlSupportedPorts.isEmpty() == false) goto L23;
        setPortInfo(Collections.unmodifiableList(Arrays.asList(cecPortInfo)));
        return;
    L23:
        ArrayList<HdmiPortInfo> result = new ArrayList(cecPortInfo.length);
        int r9 = cecPortInfo.length;
    L24:
        if (r5 >= r9) goto L30;
        HdmiPortInfo info3 = cecPortInfo[r5];
        if (mhlSupportedPorts.contains(Integer.valueOf(info3.getId())) == false) goto L28;
        result.add(new HdmiPortInfo.Builder(info3.getId(), info3.getType(), info3.getAddress()).setCecSupported(info3.isCecSupported()).setMhlSupported(true).setArcSupported(info3.isArcSupported()).setEarcSupported(info3.isEarcSupported()).build());
    L29:
        r5 = r5 + 1;
        goto L24
    L28:
        result.add(info3);
        goto L29
    L30:
        setPortInfo(Collections.unmodifiableList(result));
    }

    HdmiDeviceInfo getDeviceForPortId(int portId) {
        return this.mPortDeviceMap.get(portId, HdmiDeviceInfo.INACTIVE_DEVICE);
    }

    @HdmiAnnotations.ServiceThreadOnly
    boolean isInDeviceList(int logicalAddress, int physicalAddress) {
        assertRunOnServiceThread();
        HdmiDeviceInfo device = getCecDeviceInfo(logicalAddress);
        if (device != null) goto L6;
        return false;
    L6:
        if (device.getPhysicalAddress() != physicalAddress) goto L9;
        return true;
    L9:
        return false;
    }

    private static int logicalAddressToDeviceType(int logicalAddress) {
        switch(logicalAddress) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L7;
            case 9: goto L11;
            case 10: goto L9;
            case 11: goto L7;
            default: goto L3;
        };
    L3:
        return 2;
    L5:
        return 5;
    L7:
        return 4;
    L9:
        return 3;
    L11:
        return 1;
    L13:
        return 0;
    }

    @HdmiAnnotations.ServiceThreadOnly
    public void handleCecMessage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int sourceAddress = message.getSource();
        if (getCecDeviceInfo(sourceAddress) != null) goto L6;
        HdmiDeviceInfo newDevice = HdmiDeviceInfo.cecDeviceBuilder().setLogicalAddress(sourceAddress).setDisplayName(HdmiUtils.getDefaultDeviceName(sourceAddress)).setDeviceType(logicalAddressToDeviceType(sourceAddress)).build();
        addCecDevice(newDevice);
    L6:
        if ((message instanceof ReportFeaturesMessage) == false) goto L9;
        handleReportFeatures((ReportFeaturesMessage) message);
    L9:
        switch(message.getOpcode()) {
            case 0: goto L16;
            case 71: goto L15;
            case 132: goto L14;
            case 135: goto L13;
            case 144: goto L12;
            case 158: goto L11;
            default: goto L23;
        };
    L11:
        handleCecVersion(message);
        return;
    L12:
        handleReportPowerStatus(message);
        return;
    L13:
        handleDeviceVendorId(message);
        return;
    L14:
        handleReportPhysicalAddress(message);
        return;
    L15:
        handleSetOsdName(message);
        return;
    L16:
        handleFeatureAbort(message);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleReportFeatures(ReportFeaturesMessage message) {
        assertRunOnServiceThread();
        HdmiDeviceInfo currentDeviceInfo = getCecDeviceInfo(message.getSource());
        HdmiDeviceInfo newDeviceInfo = currentDeviceInfo.toBuilder().setCecVersion(message.getCecVersion()).updateDeviceFeatures(message.getDeviceFeatures()).build();
        updateCecDevice(newDeviceInfo);
        this.mHdmiControlService.checkAndUpdateAbsoluteVolumeBehavior();
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleFeatureAbort(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int featureSupport = 2;
        if (message.getParams().length >= 2) goto L5;
        return;
    L5:
        int originalOpcode = message.getParams()[0] & 255;
        int reason = message.getParams()[1] & 255;
        if (originalOpcode != 115) goto L12;
        if (reason != 0) goto L10;
        featureSupport = 0;
    L10:
        HdmiDeviceInfo currentDeviceInfo = getCecDeviceInfo(message.getSource());
        HdmiDeviceInfo newDeviceInfo = currentDeviceInfo.toBuilder().updateDeviceFeatures(currentDeviceInfo.getDeviceFeatures().toBuilder().setSetAudioVolumeLevelSupport(featureSupport).build()).build();
        updateCecDevice(newDeviceInfo);
        this.mHdmiControlService.checkAndUpdateAbsoluteVolumeBehavior();
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleCecVersion(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int version = Byte.toUnsignedInt(message.getParams()[0]);
        updateDeviceCecVersion(message.getSource(), version);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleReportPhysicalAddress(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int logicalAddress = message.getSource();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        int type = message.getParams()[2];
        if (updateCecSwitchInfo(logicalAddress, type, physicalAddress) == false) goto L5;
        return;
    L5:
        HdmiDeviceInfo deviceInfo = getCecDeviceInfo(logicalAddress);
        if (deviceInfo != null) goto L8;
        Slog.i(TAG, "Unknown source device info for <Report Physical Address> " + message);
        return;
    L8:
        HdmiDeviceInfo updatedDeviceInfo = deviceInfo.toBuilder().setPhysicalAddress(physicalAddress).setPortId(physicalAddressToPortId(physicalAddress)).setDeviceType(type).build();
        if (deviceInfo.getPhysicalAddress() == physicalAddress) goto L11;
        addCecDevice(updatedDeviceInfo);
        return;
    L11:
        updateCecDevice(updatedDeviceInfo);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleReportPowerStatus(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int newStatus = message.getParams()[0] & CecDeviceType.INACTIVE;
        updateDevicePowerStatus(message.getSource(), newStatus);
        if (message.getDestination() != 15) goto L6;
        updateDeviceCecVersion(message.getSource(), 6);
        return;
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void updateDeviceCecVersion(int logicalAddress, int hdmiCecVersion) {
        assertRunOnServiceThread();
        HdmiDeviceInfo deviceInfo = getCecDeviceInfo(logicalAddress);
        if (deviceInfo != null) goto L7;
        Slog.w(TAG, "Can not update CEC version of non-existing device:" + logicalAddress);
        return;
    L7:
        if (deviceInfo.getCecVersion() != hdmiCecVersion) goto L9;
        return;
    L9:
        HdmiDeviceInfo updatedDeviceInfo = deviceInfo.toBuilder().setCecVersion(hdmiCecVersion).build();
        updateCecDevice(updatedDeviceInfo);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleSetOsdName(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int logicalAddress = message.getSource();
        HdmiDeviceInfo deviceInfo = getCecDeviceInfo(logicalAddress);
        if (deviceInfo != null) goto L18;
        Slog.i(TAG, "No source device info for <Set Osd Name>." + message);
        return;
    L18:
        String osdName = new String(message.getParams(), CharsetNames.US_ASCII);     // Catch: UnsupportedEncodingException -> L15
        if (deviceInfo.getDisplayName() != null) goto L10;
    L13:
        Slog.d(TAG, "Updating device OSD name from " + deviceInfo.getDisplayName() + " to " + osdName);
        HdmiDeviceInfo updatedDeviceInfo = deviceInfo.toBuilder().setDisplayName(osdName).build();
        updateCecDevice(updatedDeviceInfo);
        return;
    L10:
        if (deviceInfo.getDisplayName().equals(osdName) == false) goto L13;
        Slog.d(TAG, "Ignore incoming <Set Osd Name> having same osd name:" + message);
        return;
    L15:
        e = move-exception;
        Slog.e(TAG, "Invalid <Set Osd Name> request:" + message, e);
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void handleDeviceVendorId(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int logicalAddress = message.getSource();
        int vendorId = HdmiUtils.threeBytesToInt(message.getParams());
        HdmiDeviceInfo deviceInfo = getCecDeviceInfo(logicalAddress);
        if (deviceInfo != null) goto L5;
        Slog.i(TAG, "Unknown source device info for <Device Vendor ID> " + message);
        return;
    L5:
        HdmiDeviceInfo updatedDeviceInfo = deviceInfo.toBuilder().setVendorId(vendorId).build();
        updateCecDevice(updatedDeviceInfo);
    }

    void addCecSwitch(int physicalAddress) {
        this.mCecSwitches.add(Integer.valueOf(physicalAddress));
    }

    public ArraySet<Integer> getCecSwitches() {
        return this.mCecSwitches;
    }

    void removeCecSwitches(int portId) {
        Iterator<Integer> it = this.mCecSwitches.iterator();
    L4:
        if (it.hasNext() == false) goto L11;
        int path = it.next().intValue();
        int devicePortId = physicalAddressToPortId(path);
        if (devicePortId == portId) goto L9;
        if (devicePortId != (-1)) goto L4;
    L9:
        it.remove();
        goto L4
    }

    void removeDevicesConnectedToPort(int portId) {
        removeCecSwitches(portId);
        List<Integer> toRemove = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mDeviceInfos.size()) goto L11;
        int key = this.mDeviceInfos.keyAt(i);
        int physicalAddress = this.mDeviceInfos.get(key).getPhysicalAddress();
        int devicePortId = physicalAddressToPortId(physicalAddress);
        if (devicePortId != portId) goto L8;
    L9:
        toRemove.add(Integer.valueOf(key));
    L10:
        i = i + 1;
        goto L4
    L8:
        if (devicePortId != (-1)) goto L10;
    L11:
        Iterator<Integer> r1 = toRemove.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        removeDeviceInfo(r1.next().intValue());
        goto L13
    }

    boolean updateCecSwitchInfo(int address, int type, int path) {
        if (address != 15) goto L9;
        if (type != 6) goto L9;
        this.mCecSwitches.add(Integer.valueOf(path));
        updateSafeDeviceInfoList();
        return true;
    L9:
        if (type != 5) goto L13;
        this.mCecSwitches.add(Integer.valueOf(path));
        return false;
    L13:
        return false;
    }

    List<HdmiDeviceInfo> getSafeCecDevicesLocked() {
        ArrayList<HdmiDeviceInfo> infoList = new ArrayList();
        Iterator<HdmiDeviceInfo> r1 = this.mSafeAllDeviceInfos.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        HdmiDeviceInfo info = r1.next();
        if (isLocalDeviceAddress(info.getLogicalAddress()) == true) goto L4;
        infoList.add(info);
        goto L4
    L9:
        return infoList;
    }

    HdmiDeviceInfo getSafeCecDeviceInfo(int logicalAddress) {
        Iterator<HdmiDeviceInfo> r0 = this.mSafeAllDeviceInfos.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        HdmiDeviceInfo info = r0.next();
        if (info.isCecDevice() == false) goto L4;
        if (info.getLogicalAddress() != logicalAddress) goto L4;
        return info;
    L11:
        return null;
    }

    @HdmiAnnotations.ServiceThreadOnly
    final HdmiDeviceInfo getDeviceInfoByPath(int path) {
        assertRunOnServiceThread();
        Iterator<HdmiDeviceInfo> r0 = getDeviceInfoList(false).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        HdmiDeviceInfo info = r0.next();
        if (info.getPhysicalAddress() != path) goto L4;
        return info;
    L9:
        return null;
    }

    HdmiDeviceInfo getSafeDeviceInfoByPath(int path) {
        Iterator<HdmiDeviceInfo> r0 = this.mSafeAllDeviceInfos.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        HdmiDeviceInfo info = r0.next();
        if (info.getPhysicalAddress() != path) goto L4;
        return info;
    L9:
        return null;
    }

    public int getPhysicalAddress() {
        if (this.mPhysicalAddress != 65535) goto L6;
        this.mPhysicalAddress = this.mHdmiCecController.getPhysicalAddress();
    L6:
        return this.mPhysicalAddress;
    }

    @HdmiAnnotations.ServiceThreadOnly
    public void clear() {
        assertRunOnServiceThread();
        initPortInfo();
        clearDeviceList();
        clearLocalDevices();
    }

    @HdmiAnnotations.ServiceThreadOnly
    void removeUnusedLocalDevices(ArrayList<HdmiCecLocalDevice> allocatedDevices) {
        ArrayList<Integer> deviceTypesToRemove = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mLocalDevices.size()) goto L9;
        final int deviceType = this.mLocalDevices.keyAt(i);
        boolean shouldRemoveLocalDevice = allocatedDevices.stream().noneMatch(new HdmiCecNetwork$$ExternalSyntheticLambda0(deviceType));
        if (shouldRemoveLocalDevice == false) goto L8;
        deviceTypesToRemove.add(Integer.valueOf(deviceType));
    L8:
        i = i + 1;
        goto L4
    L9:
        Iterator<Integer> r1 = deviceTypesToRemove.iterator();
    L11:
        if (r1.hasNext() == false) goto L13;
        Integer deviceType2 = r1.next();
        this.mLocalDevices.remove(deviceType2.intValue());
        goto L11
    }

    private static /* synthetic */ boolean lambda$removeUnusedLocalDevices$0(int deviceType, HdmiCecLocalDevice localDevice) {
        if (localDevice.getDeviceInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (localDevice.getDeviceInfo().getDeviceType() != deviceType) goto L7;
        return true;
    }

    @HdmiAnnotations.ServiceThreadOnly
    void removeLocalDeviceWithType(int deviceType) {
        this.mLocalDevices.remove(deviceType);
    }

    @HdmiAnnotations.ServiceThreadOnly
    public void clearDeviceList() {
        assertRunOnServiceThread();
        Iterator r0 = HdmiUtils.sparseArrayToList(this.mDeviceInfos).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        HdmiDeviceInfo info = (HdmiDeviceInfo) r0.next();
        if (info.getPhysicalAddress() == getPhysicalAddress()) goto L4;
        if (info.getPhysicalAddress() == 65535) goto L4;
        invokeDeviceEventListener(info, 2);
        goto L4
    L11:
        this.mDeviceInfos.clear();
        updateSafeDeviceInfoList();
    }

    HdmiPortInfo getPortInfo(int portId) {
        return this.mPortInfoMap.get(portId, null);
    }

    int portIdToPath(int portId) {
        if (portId == 0) goto L4;
        HdmiPortInfo portInfo = getPortInfo(portId);
        if (portInfo != null) goto L10;
        Slog.e(TAG, "Cannot find the port info: " + portId);
        return 65535;
    L10:
        return portInfo.getAddress();
    L4:
        return getPhysicalAddress();
    }

    int physicalAddressToPortId(int path) {
        int physicalAddress = getPhysicalAddress();
        if (path != physicalAddress) goto L6;
        return 0;
    L6:
        int mask = 61440;
        int finalMask = 61440;
        int maskedAddress = physicalAddress;
    L7:
        if (maskedAddress == 0) goto L9;
        maskedAddress = physicalAddress & mask;
        finalMask = finalMask | mask;
        mask = mask >> 4;
        goto L7
    L9:
        int portAddress = path & finalMask;
        return this.mPortIdMap.get(portAddress, -1);
    }

    List<HdmiPortInfo> getPortInfo() {
        return this.mPortInfo;
    }

    void setPortInfo(List<HdmiPortInfo> portInfo) {
        this.mPortInfo = portInfo;
    }

    private boolean isLocalDeviceAddress(int address) {
        int i = 0;
    L4:
        if (i >= this.mLocalDevices.size()) goto L10;
        int key = this.mLocalDevices.keyAt(i);
        if (this.mLocalDevices.get(key).getDeviceInfo().getLogicalAddress() == address) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private void assertRunOnServiceThread() {
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Should run on service thread.");
    }

    protected void dump(IndentingPrintWriter pw) {
        pw.println("HDMI CEC Network");
        pw.increaseIndent();
        HdmiUtils.dumpIterable(pw, "mPortInfo:", this.mPortInfo);
        int i = 0;
    L4:
        if (i >= this.mLocalDevices.size()) goto L10;
        pw.println("HdmiCecLocalDevice #" + this.mLocalDevices.keyAt(i) + ":");
        pw.increaseIndent();
        this.mLocalDevices.valueAt(i).dump(pw);
        pw.println("Active Source history:");
        pw.increaseIndent();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayBlockingQueue<HdmiCecController.Dumpable> activeSourceHistory = this.mLocalDevices.valueAt(i).getActiveSourceHistory();
        Iterator<HdmiCecController.Dumpable> r3 = activeSourceHistory.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        HdmiCecController.Dumpable activeSourceEvent = r3.next();
        activeSourceEvent.dump(pw, sdf);
        goto L7
    L9:
        pw.decreaseIndent();
        pw.decreaseIndent();
        i = i + 1;
        goto L4
    L10:
        HdmiUtils.dumpIterable(pw, "mDeviceInfos:", this.mSafeAllDeviceInfos);
        pw.decreaseIndent();
    }
}
