package com.android.server.usb.hal.port;

import android.hardware.usb.AltModeData;
import android.hardware.usb.DisplayPortAltModeInfo;
import android.hardware.usb.IUsb;
import android.hardware.usb.IUsbCallback;
import android.hardware.usb.IUsbOperationInternal;
import android.hardware.usb.PortRole;
import android.hardware.usb.PortStatus;
import android.hardware.usb.UsbPort;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.IntArray;
import android.util.LongSparseArray;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.usb.UsbPortManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbPortAidl implements UsbPortHal {
    public static final int AIDL_USB_DATA_STATUS_DISABLED_CONTAMINANT = 3;
    public static final int AIDL_USB_DATA_STATUS_DISABLED_DEBUG = 6;
    public static final int AIDL_USB_DATA_STATUS_DISABLED_DOCK = 4;
    public static final int AIDL_USB_DATA_STATUS_DISABLED_DOCK_DEVICE_MODE = 8;
    public static final int AIDL_USB_DATA_STATUS_DISABLED_DOCK_HOST_MODE = 7;
    public static final int AIDL_USB_DATA_STATUS_DISABLED_FORCE = 5;
    public static final int AIDL_USB_DATA_STATUS_DISABLED_OVERHEAT = 2;
    public static final int AIDL_USB_DATA_STATUS_ENABLED = 1;
    public static final int AIDL_USB_DATA_STATUS_UNKNOWN = 0;
    private static final String TAG = null;
    private static final String USB_AIDL_SERVICE = "android.hardware.usb.IUsb/default";
    private static final LongSparseArray<IUsbOperationInternal> sCallbacks = null;
    private IBinder mBinder;
    private HALCallback mHALCallback;
    private final Object mLock;
    private UsbPortManager mPortManager;
    private IUsb mProxy;
    public IndentingPrintWriter mPw;
    private boolean mSystemReady;
    private long mTransactionId;

    private static class HALCallback extends IUsbCallback.Stub {
        public UsbPortManager mPortManager;
        public IndentingPrintWriter mPw;
        public UsbPortAidl mUsbPortAidl;

        HALCallback(IndentingPrintWriter pw, UsbPortManager portManager, UsbPortAidl usbPortAidl) {
            this.mPw = pw;
            this.mPortManager = portManager;
            this.mUsbPortAidl = usbPortAidl;
        }

        private int toPortMode(byte aidlPortMode) {
            switch(aidlPortMode) {
                case 0: goto L16;
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L10;
                case 4: goto L8;
                case 5: goto L6;
                default: goto L4;
            };
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, "Unrecognized aidlPortMode:" + aidlPortMode);
            return 0;
        L6:
            return 8;
        L8:
            return 4;
        L10:
            return 3;
        L12:
            return 2;
        L14:
            return 1;
        L16:
            return 0;
        }

        private int toSupportedModes(byte[] aidlPortModes) {
            int supportedModes = 0;
            int r1 = aidlPortModes.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            byte aidlPortMode = aidlPortModes[r2];
            supportedModes = supportedModes | toPortMode(aidlPortMode);
            r2 = r2 + 1;
            goto L3
        L5:
            return supportedModes;
        }

        private int toContaminantProtectionStatus(byte aidlContaminantProtection) {
            switch(aidlContaminantProtection) {
                case 0: goto L14;
                case 1: goto L12;
                case 2: goto L10;
                case 3: goto L8;
                case 4: goto L6;
                default: goto L4;
            };
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, "Unrecognized aidlContaminantProtection:" + aidlContaminantProtection);
            return 0;
        L6:
            return 8;
        L8:
            return 4;
        L10:
            return 2;
        L12:
            return 1;
        L14:
            return 0;
        }

        private int toSupportedContaminantProtectionModes(byte[] aidlModes) {
            int supportedContaminantProtectionModes = 0;
            int r1 = aidlModes.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L5;
            byte aidlMode = aidlModes[r2];
            supportedContaminantProtectionModes = supportedContaminantProtectionModes | toContaminantProtectionStatus(aidlMode);
            r2 = r2 + 1;
            goto L3
        L5:
            return supportedContaminantProtectionModes;
        }

        private int toUsbDataStatusInt(byte[] usbDataStatusHal) {
            int usbDataStatus = 0;
            int i = 0;
        L4:
            if (i >= usbDataStatusHal.length) goto L17;
            switch(usbDataStatusHal[i]) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                default: goto L7;
            };
        L7:
            usbDataStatus = usbDataStatus | 0;
        L16:
            i = i + 1;
            goto L4
        L8:
            usbDataStatus = (usbDataStatus | 128) | 8;
            goto L16
        L9:
            usbDataStatus = (usbDataStatus | 64) | 8;
            goto L16
        L10:
            usbDataStatus = usbDataStatus | 32;
            goto L16
        L11:
            usbDataStatus = usbDataStatus | 16;
            goto L16
        L12:
            usbDataStatus = ((usbDataStatus | 8) | 64) | 128;
            goto L16
        L13:
            usbDataStatus = usbDataStatus | 4;
            goto L16
        L14:
            usbDataStatus = usbDataStatus | 2;
            goto L16
        L15:
            usbDataStatus = usbDataStatus | 1;
            goto L16
        L17:
            UsbPortManager.logAndPrint(4, this.mPw, "AIDL UsbDataStatus:" + usbDataStatus);
            return usbDataStatus;
        }

        private int[] formatComplianceWarnings(int[] complianceWarnings) {
            complianceWarnings.getClass();
            IntArray newComplianceWarnings = new IntArray();
            Arrays.sort(complianceWarnings);
            int r1 = complianceWarnings.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L14;
            int warning = complianceWarnings[r2];
            if (newComplianceWarnings.indexOf(warning) != (-1)) goto L12;
            if (warning < 1) goto L12;
            if (warning <= 9) goto L11;
            newComplianceWarnings.add(1);
            goto L12
        L11:
            newComplianceWarnings.add(warning);
        L12:
            r2 = r2 + 1;
            goto L3
        L14:
            return newComplianceWarnings.toArray();
        }

        private int toSupportedAltModesInt(AltModeData[] supportedAltModes) {
            int supportedAltModesInt = 0;
            int r1 = supportedAltModes.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            AltModeData altModeData = supportedAltModes[r2];
            switch(altModeData.getTag()) {
                case 0: goto L7;
                default: goto L8;
            };
        L7:
            supportedAltModesInt = supportedAltModesInt | 1;
        L8:
            r2 = r2 + 1;
            goto L3
        L9:
            return supportedAltModesInt;
        }

        private int toDisplayPortAltModeNumLanesInt(int pinAssignment) {
            switch(pinAssignment) {
                case 1: goto L7;
                case 2: goto L5;
                case 3: goto L7;
                case 4: goto L5;
                case 5: goto L7;
                case 6: goto L5;
                default: goto L3;
            };
        L3:
            return 0;
        L5:
            return 2;
        L7:
            return 4;
        }

        private DisplayPortAltModeInfo formatDisplayPortAltModeInfo(AltModeData[] supportedAltModes) {
            int r0 = supportedAltModes.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            AltModeData altModeData = supportedAltModes[r1];
            if (altModeData.getTag() == 0) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            AltModeData.DisplayPortAltModeData displayPortData = altModeData.getDisplayPortAltModeData();
            return new DisplayPortAltModeInfo(displayPortData.partnerSinkStatus, displayPortData.cableStatus, toDisplayPortAltModeNumLanesInt(displayPortData.pinAssignment), displayPortData.hpd, displayPortData.linkTrainingStatus);
        L9:
            return null;
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyPortStatusChange(PortStatus[] currentPortStatus, int retval) {
            PortStatus[] r1 = currentPortStatus;
            if (UsbPortAidl.m9209$$Nest$fgetmSystemReady(this.mUsbPortAidl) == true) goto L5;
            return;
        L5:
            if (retval == 0) goto L8;
            UsbPortManager.logAndPrint(6, this.mPw, "port status enquiry failed");
            return;
        L8:
            ArrayList<RawPortInfo> newPortInfo = new ArrayList();
            int numStatus = r1.length;
            int i = 0;
        L9:
            if (i >= numStatus) goto L11;
            PortStatus current = r1[i];
            RawPortInfo temp = new RawPortInfo(current.portName, toSupportedModes(current.supportedModes), toSupportedContaminantProtectionModes(current.supportedContaminantProtectionModes), toPortMode(current.currentMode), current.canChangeMode, current.currentPowerRole, current.canChangePowerRole, current.currentDataRole, current.canChangeDataRole, current.supportsEnableContaminantPresenceProtection, toContaminantProtectionStatus(current.contaminantProtectionStatus), current.supportsEnableContaminantPresenceDetection, current.contaminantDetectionStatus, toUsbDataStatusInt(current.usbDataStatus), current.powerTransferLimited, current.powerBrickStatus, current.supportsComplianceWarnings, formatComplianceWarnings(current.complianceWarnings), current.plugOrientation, toSupportedAltModesInt(current.supportedAltModes), formatDisplayPortAltModeInfo(current.supportedAltModes));
            newPortInfo.add(temp);
            UsbPortManager.logAndPrint(4, this.mPw, "ClientCallback AIDL V1: " + current.portName);
            i = i + 1;
            r1 = currentPortStatus;
            goto L9
        L11:
            this.mPortManager.updatePorts(newPortInfo);
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyRoleSwitchStatus(String portName, PortRole role, int retval, long operationID) {
            if (retval != 0) goto L4;
            UsbPortManager.logAndPrint(4, this.mPw, portName + " role switch successful. opID:" + operationID);
            return;
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, portName + " role switch failed. err:" + retval + "opID:" + operationID);
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyQueryPortStatus(String portName, int retval, long operationID) {
            if (retval != 0) goto L5;
            UsbPortManager.logAndPrint(4, this.mPw, portName + ": opID:" + operationID + " successful");
            return;
        L5:
            UsbPortManager.logAndPrint(6, this.mPw, portName + ": opID:" + operationID + " failed. err:" + retval);
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyEnableUsbDataStatus(String portName, boolean enable, int retval, long operationID) {
            if (retval != 0) goto L4;
            UsbPortManager.logAndPrint(4, this.mPw, "notifyEnableUsbDataStatus:" + portName + ": opID:" + operationID + " enable:" + enable);
        L14:
            IUsbOperationInternal r0 = (IUsbOperationInternal) UsbPortAidl.m9210$$Nest$sfgetsCallbacks().get(operationID);     // Catch: RemoteException -> L11
            if (retval != 0) goto L8;
            int r1 = 0;
        L9:
            r0.onOperationComplete(r1);     // Catch: RemoteException -> L11
            return;
        L8:
            r1 = 1;
        L11:
            e = move-exception;
            UsbPortManager.logAndPrintException(this.mPw, "notifyEnableUsbDataStatus: Failed to call onOperationComplete", e);
            return;
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, portName + "notifyEnableUsbDataStatus: opID:" + operationID + " failed. err:" + retval);
            goto L14
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyContaminantEnabledStatus(String portName, boolean enable, int retval, long operationID) {
            if (retval != 0) goto L4;
            UsbPortManager.logAndPrint(4, this.mPw, "notifyContaminantEnabledStatus:" + portName + ": opID:" + operationID + " enable:" + enable);
            return;
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, portName + "notifyContaminantEnabledStatus: opID:" + operationID + " failed. err:" + retval);
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyLimitPowerTransferStatus(String portName, boolean limit, int retval, long operationID) {
            if (retval != 0) goto L4;
            UsbPortManager.logAndPrint(4, this.mPw, portName + ": opID:" + operationID + " successful");
        L18:
            IUsbOperationInternal callback = (IUsbOperationInternal) UsbPortAidl.m9210$$Nest$sfgetsCallbacks().get(operationID);     // Catch: RemoteException -> L13
            if (callback == null) goto L20;
            IUsbOperationInternal r1 = (IUsbOperationInternal) UsbPortAidl.m9210$$Nest$sfgetsCallbacks().get(operationID);     // Catch: RemoteException -> L13
            if (retval != 0) goto L10;
            int r2 = 0;
        L11:
            r1.onOperationComplete(r2);     // Catch: RemoteException -> L13
            return;
        L10:
            r2 = 1;
            goto L11
        L20:
            return;
        L13:
            e = move-exception;
            UsbPortManager.logAndPrintException(this.mPw, "enableLimitPowerTransfer: Failed to call onOperationComplete", e);
            return;
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, portName + "notifyLimitPowerTransferStatus: opID:" + operationID + " failed. err:" + retval);
            goto L18
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyEnableUsbDataWhileDockedStatus(String portName, int retval, long operationID) {
            if (retval != 0) goto L4;
            UsbPortManager.logAndPrint(4, this.mPw, portName + ": opID:" + operationID + " successful");
        L18:
            IUsbOperationInternal callback = (IUsbOperationInternal) UsbPortAidl.m9210$$Nest$sfgetsCallbacks().get(operationID);     // Catch: RemoteException -> L13
            if (callback == null) goto L20;
            IUsbOperationInternal r1 = (IUsbOperationInternal) UsbPortAidl.m9210$$Nest$sfgetsCallbacks().get(operationID);     // Catch: RemoteException -> L13
            if (retval != 0) goto L10;
            int r2 = 0;
        L11:
            r1.onOperationComplete(r2);     // Catch: RemoteException -> L13
            return;
        L10:
            r2 = 1;
            goto L11
        L20:
            return;
        L13:
            e = move-exception;
            UsbPortManager.logAndPrintException(this.mPw, "notifyEnableUsbDataWhileDockedStatus: Failed to call onOperationComplete", e);
            return;
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, portName + "notifyEnableUsbDataWhileDockedStatus: opID:" + operationID + " failed. err:" + retval);
            goto L18
        }

        @Override // android.hardware.usb.IUsbCallback
        public void notifyResetUsbPortStatus(String portName, int retval, long operationID) {
            if (retval != 0) goto L4;
            UsbPortManager.logAndPrint(4, this.mPw, "notifyResetUsbPortStatus:" + portName + ": opID:" + operationID);
        L14:
            IUsbOperationInternal r0 = (IUsbOperationInternal) UsbPortAidl.m9210$$Nest$sfgetsCallbacks().get(operationID);     // Catch: RemoteException -> L11
            if (retval != 0) goto L8;
            int r1 = 0;
        L9:
            r0.onOperationComplete(r1);     // Catch: RemoteException -> L11
            return;
        L8:
            r1 = 1;
        L11:
            e = move-exception;
            UsbPortManager.logAndPrintException(this.mPw, "notifyResetUsbPortStatus: Failed to call onOperationComplete", e);
            return;
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, portName + "notifyEnableUsbDataStatus: opID:" + operationID + " failed. err:" + retval);
            goto L14
        }

        @Override // android.hardware.usb.IUsbCallback
        public String getInterfaceHash() {
            return "7fe46e9531884739d925b8caeee9dba5c411e228";
        }

        @Override // android.hardware.usb.IUsbCallback
        public int getInterfaceVersion() {
            return 3;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9209$$Nest$fgetmSystemReady(UsbPortAidl r0) {
        return r0.mSystemReady;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsCallbacks, reason: not valid java name */
    static /* bridge */ /* synthetic */ LongSparseArray m9210$$Nest$sfgetsCallbacks() {
        return sCallbacks;
    }

    static {
        TAG = UsbPortAidl.class.getSimpleName();
        sCallbacks = new LongSparseArray();
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public int getUsbHalVersion() throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy == null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        UsbPortManager.logAndPrint(4, null, "USB HAL AIDL version: USB_HAL_V2_0");
        return 20;
    L12:
        throw new RemoteException("IUsb not initialized yet");     // Catch: Throwable -> L9
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void systemReady() {
        this.mSystemReady = true;
    }

    public void serviceDied() {
        UsbPortManager.logAndPrint(6, this.mPw, "Usb AIDL hal service died");
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mProxy = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        connectToProxy(null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void connectToProxy(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy == null) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        this.mBinder = ServiceManager.waitForService(USB_AIDL_SERVICE);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mProxy = IUsb.Stub.asInterface(this.mBinder);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mBinder.linkToDeath(new UsbPortAidl$$ExternalSyntheticLambda0(this), 0);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mProxy.setCallback(this.mHALCallback);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        IUsb r1 = this.mProxy;     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        long r2 = this.mTransactionId + 1;     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mTransactionId = r2;     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        r1.queryPortStatus(r2);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L12:
        e = move-exception;
        UsbPortManager.logAndPrintException(pw, "connectToProxy: usb hal service not responding", e);     // Catch: Throwable -> L8
    L14:
        e = move-exception;
        UsbPortManager.logAndPrintException(pw, "connectToProxy: usb hal service not found. Did the service fail to start?", e);     // Catch: Throwable -> L8
        goto L19
    }

    static boolean isServicePresent(IndentingPrintWriter pw) {
        return ServiceManager.isDeclared(USB_AIDL_SERVICE);
    L4:
        e = move-exception;
        UsbPortManager.logAndPrintException(pw, "connectToProxy: usb Aidl hal service not found.", e);
        return false;
    }

    public UsbPortAidl(UsbPortManager portManager, IndentingPrintWriter pw) {
        this.mLock = new Object();
        portManager.getClass();
        this.mPortManager = portManager;
        this.mPw = pw;
        this.mHALCallback = new HALCallback(null, this.mPortManager, this);
        connectToProxy(this.mPw);
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void enableContaminantPresenceDetection(String portName, boolean enable, long operationID) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L20;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry ! opID: " + operationID);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        this.mProxy.enableContaminantPresenceDetection(portName, enable, operationID);     // Catch: Throwable -> L9 RemoteException -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L13:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set contaminant detection. opID:" + operationID, e);     // Catch: Throwable -> L9
        goto L15
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void queryPortStatus(long operationID) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L20;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry ! opID:" + operationID);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        this.mProxy.queryPortStatus(operationID);     // Catch: Throwable -> L9 RemoteException -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L13:
        e = move-exception;
        UsbPortManager.logAndPrintException(null, "ServiceStart: Failed to query port status. opID:" + operationID, e);     // Catch: Throwable -> L9
        goto L15
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void switchMode(String portId, int newMode, long operationID) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L11;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry ! opID:" + operationID);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        PortRole newRole = new PortRole();     // Catch: Throwable -> L9
        newRole.setMode((byte) newMode);     // Catch: Throwable -> L9
        this.mProxy.switchRole(portId, newRole, operationID);     // Catch: Throwable -> L9 RemoteException -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set the USB port mode: portId=" + portId + ", newMode=" + UsbPort.modeToString(newMode) + "opID:" + operationID, e);     // Catch: Throwable -> L9
        goto L16
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void switchPowerRole(String portId, int newPowerRole, long operationID) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L11;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry ! opID:" + operationID);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        PortRole newRole = new PortRole();     // Catch: Throwable -> L9
        newRole.setPowerRole((byte) newPowerRole);     // Catch: Throwable -> L9
        this.mProxy.switchRole(portId, newRole, operationID);     // Catch: Throwable -> L9 RemoteException -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set the USB power role: portId=" + portId + ", newPowerRole=" + UsbPort.powerRoleToString(newPowerRole) + "opID:" + operationID, e);     // Catch: Throwable -> L9
        goto L16
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void switchDataRole(String portId, int newDataRole, long operationID) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L11;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry ! opID:" + operationID);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        PortRole newRole = new PortRole();     // Catch: Throwable -> L9
        newRole.setDataRole((byte) newDataRole);     // Catch: Throwable -> L9
        this.mProxy.switchRole(portId, newRole, operationID);     // Catch: Throwable -> L9 RemoteException -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set the USB data role: portId=" + portId + ", newDataRole=" + UsbPort.dataRoleToString(newDataRole) + "opID:" + operationID, e);     // Catch: Throwable -> L9
        goto L16
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void resetUsbPort(String portName, long operationID, IUsbOperationInternal callback) {
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
            r9.getClass()
            r12.getClass()
            r0 = r10
            java.lang.Object r2 = r8.mLock
            monitor-enter(r2)
            android.hardware.usb.IUsb r3 = r8.mProxy     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r4 = 1
            if (r3 != 0) goto L30
            com.android.internal.util.IndentingPrintWriter r3 = r8.mPw     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r5.<init>()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r6 = "resetUsbPort: Proxy is null. Retry !opID:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r5.append(r10)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r6 = 6
            com.android.server.usb.UsbPortManager.logAndPrint(r6, r3, r5)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r12.onOperationComplete(r4)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            goto L30
        L2b:
            r3 = move-exception
            goto Lc4
        L2e:
            r3 = move-exception
            goto L9c
        L30:
            android.util.LongSparseArray<android.hardware.usb.IUsbOperationInternal> r3 = com.android.server.usb.hal.port.UsbPortAidl.sCallbacks     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.Object r3 = r3.get(r0)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            if (r3 == 0) goto L42
            java.util.concurrent.ThreadLocalRandom r3 = java.util.concurrent.ThreadLocalRandom.current()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            int r3 = r3.nextInt()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            long r0 = (long) r3     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            goto L30
        L42:
            int r3 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r3 == 0) goto L66
            com.android.internal.util.IndentingPrintWriter r3 = r8.mPw     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r5.<init>()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r6 = "resetUsbPort: operationID exists ! opID:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r5.append(r10)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r6 = " key:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r5.append(r0)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r6 = 4
            com.android.server.usb.UsbPortManager.logAndPrint(r6, r3, r5)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
        L66:
            android.util.LongSparseArray<android.hardware.usb.IUsbOperationInternal> r3 = com.android.server.usb.hal.port.UsbPortAidl.sCallbacks     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L71
            r3.put(r0, r12)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L71
            android.hardware.usb.IUsb r3 = r8.mProxy     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L71
            r3.resetUsbPort(r9, r0)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L71
            goto L9b
        L71:
            r3 = move-exception
            com.android.internal.util.IndentingPrintWriter r5 = r8.mPw     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r6.<init>()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r7 = "resetUsbPort: Failed to resetUsbPort: portID="
            r6.append(r7)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r6.append(r9)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r7 = "opId:"
            r6.append(r7)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r6.append(r10)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            com.android.server.usb.UsbPortManager.logAndPrintException(r5, r6, r3)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r12.onOperationComplete(r4)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            android.util.LongSparseArray<android.hardware.usb.IUsbOperationInternal> r4 = com.android.server.usb.hal.port.UsbPortAidl.sCallbacks     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
            r4.remove(r0)     // Catch: java.lang.Throwable -> L2b android.os.RemoteException -> L2e
        L9b:
            goto Lc2
        L9c:
            com.android.internal.util.IndentingPrintWriter r4 = r8.mPw     // Catch: java.lang.Throwable -> L2b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
            r5.<init>()     // Catch: java.lang.Throwable -> L2b
            java.lang.String r6 = "resetUsbPort: Failed to call onOperationComplete portID="
            r5.append(r6)     // Catch: java.lang.Throwable -> L2b
            r5.append(r9)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r6 = "opID:"
            r5.append(r6)     // Catch: java.lang.Throwable -> L2b
            r5.append(r10)     // Catch: java.lang.Throwable -> L2b
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2b
            com.android.server.usb.UsbPortManager.logAndPrintException(r4, r5, r3)     // Catch: java.lang.Throwable -> L2b
            android.util.LongSparseArray<android.hardware.usb.IUsbOperationInternal> r4 = com.android.server.usb.hal.port.UsbPortAidl.sCallbacks     // Catch: java.lang.Throwable -> L2b
            r4.remove(r0)     // Catch: java.lang.Throwable -> L2b
        Lc2:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            return
        Lc4:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2b
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.usb.hal.port.UsbPortAidl.resetUsbPort(java.lang.String, long, android.hardware.usb.IUsbOperationInternal):void");
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public boolean enableUsbData(String portName, boolean enable, long operationID, IUsbOperationInternal callback) {
        portName.getClass();
        callback.getClass();
        long key = operationID;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L12:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "enableUsbData: Failed to call onOperationComplete portID=" + portName + "opID:" + operationID, e);     // Catch: Throwable -> L10
        sCallbacks.remove(key);     // Catch: Throwable -> L10
        return false;
    L6:
        if (this.mProxy != null) goto L15;
        UsbPortManager.logAndPrint(6, this.mPw, "enableUsbData: Proxy is null. Retry !opID:" + operationID);     // Catch: Throwable -> L10 RemoteException -> L12
        callback.onOperationComplete(1);     // Catch: Throwable -> L10 RemoteException -> L12
        monitor-exit(r2);     // Catch: Throwable -> L10
        return false;
    L15:
        if (sCallbacks.get(key) == null) goto L18;
        key = ThreadLocalRandom.current().nextInt();     // Catch: Throwable -> L10 RemoteException -> L12
        goto L15
    L18:
        if (key == operationID) goto L34;
        UsbPortManager.logAndPrint(4, this.mPw, "enableUsbData: operationID exists ! opID:" + operationID + " key:" + key);     // Catch: Throwable -> L10 RemoteException -> L12
    L34:
        sCallbacks.put(key, callback);     // Catch: Throwable -> L10 RemoteException -> L23
        this.mProxy.enableUsbData(portName, enable, key);     // Catch: Throwable -> L10 RemoteException -> L23
        monitor-exit(r2);     // Catch: Throwable -> L10
        return true;
    L23:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "enableUsbData: Failed to invoke enableUsbData: portID=" + portName + "opID:" + operationID, e);     // Catch: Throwable -> L10 RemoteException -> L12
        callback.onOperationComplete(1);     // Catch: Throwable -> L10 RemoteException -> L12
        sCallbacks.remove(key);     // Catch: Throwable -> L10 RemoteException -> L12
        return false;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void enableLimitPowerTransfer(String portName, boolean limit, long operationID, IUsbOperationInternal callback) {
        portName.getClass();
        long key = operationID;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L11:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "enableLimitPowerTransfer: Failed to call onOperationComplete portID=" + portName + " opID:" + operationID, e);     // Catch: Throwable -> L9
    L29:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L5:
        if (this.mProxy != null) goto L14;
        UsbPortManager.logAndPrint(6, this.mPw, "enableLimitPowerTransfer: Proxy is null. Retry !opID:" + operationID);     // Catch: Throwable -> L9 RemoteException -> L11
        callback.onOperationComplete(1);     // Catch: Throwable -> L9 RemoteException -> L11
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L14:
        if (sCallbacks.get(key) == null) goto L17;
        key = ThreadLocalRandom.current().nextInt();     // Catch: Throwable -> L9 RemoteException -> L11
        goto L14
    L17:
        if (key == operationID) goto L33;
        UsbPortManager.logAndPrint(4, this.mPw, "enableUsbData: operationID exists ! opID:" + operationID + " key:" + key);     // Catch: Throwable -> L9 RemoteException -> L11
    L33:
        sCallbacks.put(key, callback);     // Catch: Throwable -> L9 RemoteException -> L21
        this.mProxy.limitPowerTransfer(portName, limit, key);     // Catch: Throwable -> L9 RemoteException -> L21
    L21:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "enableLimitPowerTransfer: Failed while invoking AIDL HAL portID=" + portName + " opID:" + operationID, e);     // Catch: Throwable -> L9 RemoteException -> L11
        if (callback == null) goto L25;
        callback.onOperationComplete(1);     // Catch: Throwable -> L9 RemoteException -> L11
    L25:
        sCallbacks.remove(key);     // Catch: Throwable -> L9 RemoteException -> L11
        goto L29
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void enableUsbDataWhileDocked(String portName, long operationID, IUsbOperationInternal callback) {
        portName.getClass();
        long key = operationID;
        Object r2 = this.mLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L11:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "enableUsbDataWhileDocked: Failed to call onOperationComplete portID=" + portName + " opID:" + operationID, e);     // Catch: Throwable -> L9
    L29:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L5:
        if (this.mProxy != null) goto L14;
        UsbPortManager.logAndPrint(6, this.mPw, "enableUsbDataWhileDocked: Proxy is null. Retry !opID:" + operationID);     // Catch: Throwable -> L9 RemoteException -> L11
        callback.onOperationComplete(1);     // Catch: Throwable -> L9 RemoteException -> L11
        monitor-exit(r2);     // Catch: Throwable -> L9
        return;
    L14:
        if (sCallbacks.get(key) == null) goto L17;
        key = ThreadLocalRandom.current().nextInt();     // Catch: Throwable -> L9 RemoteException -> L11
        goto L14
    L17:
        if (key == operationID) goto L33;
        UsbPortManager.logAndPrint(4, this.mPw, "enableUsbDataWhileDocked: operationID exists ! opID:" + operationID + " key:" + key);     // Catch: Throwable -> L9 RemoteException -> L11
    L33:
        sCallbacks.put(key, callback);     // Catch: Throwable -> L9 RemoteException -> L21
        this.mProxy.enableUsbDataWhileDocked(portName, key);     // Catch: Throwable -> L9 RemoteException -> L21
    L21:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "enableUsbDataWhileDocked: error while invoking halportID=" + portName + " opID:" + operationID, e);     // Catch: Throwable -> L9 RemoteException -> L11
        if (callback == null) goto L25;
        callback.onOperationComplete(1);     // Catch: Throwable -> L9 RemoteException -> L11
    L25:
        sCallbacks.remove(key);     // Catch: Throwable -> L9 RemoteException -> L11
        goto L29
    }
}
