package com.android.server.usb.hal.port;

import android.hardware.usb.IUsbOperationInternal;
import android.hardware.usb.UsbPort;
import android.hardware.usb.V1_0.IUsb;
import android.hardware.usb.V1_0.PortRole;
import android.hardware.usb.V1_0.PortStatus;
import android.hardware.usb.V1_1.PortStatus_1_1;
import android.hardware.usb.V1_2.IUsbCallback;
import android.hidl.manager.V1_0.IServiceManager;
import android.hidl.manager.V1_0.IServiceNotification;
import android.os.IHwBinder;
import android.os.RemoteException;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.usb.UsbPortManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbPortHidl implements UsbPortHal {
    private static final String TAG = null;
    private static final int USB_HAL_DEATH_COOKIE = 1000;
    private static int sUsbDataStatus;
    private HALCallback mHALCallback;
    private final Object mLock;
    private UsbPortManager mPortManager;
    private IUsb mProxy;
    public IndentingPrintWriter mPw;
    private boolean mSystemReady;

    final class DeathRecipient implements IHwBinder.DeathRecipient {
        public IndentingPrintWriter pw;
        final /* synthetic */ UsbPortHidl this$0;

        DeathRecipient(UsbPortHidl this$0, IndentingPrintWriter pw) {
            this.this$0 = this$0;
            this.pw = pw;
        }

        public void serviceDied(long cookie) {
            if (cookie != 1000) goto L12;
            UsbPortManager.logAndPrint(6, this.pw, "Usb hal service died cookie: " + cookie);
            Object r0 = UsbPortHidl.m9211$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            UsbPortHidl.m9213$$Nest$fputmProxy(this.this$0, null);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    private static class HALCallback extends IUsbCallback.Stub {
        public UsbPortManager mPortManager;
        public IndentingPrintWriter mPw;
        public UsbPortHidl mUsbPortHidl;

        HALCallback(IndentingPrintWriter pw, UsbPortManager portManager, UsbPortHidl usbPortHidl) {
            this.mPw = pw;
            this.mPortManager = portManager;
            this.mUsbPortHidl = usbPortHidl;
        }

        @Override // android.hardware.usb.V1_0.IUsbCallback
        public void notifyPortStatusChange(ArrayList<PortStatus> currentPortStatus, int retval) {
            if (UsbPortHidl.m9212$$Nest$fgetmSystemReady(this.mUsbPortHidl) == true) goto L5;
            return;
        L5:
            if (retval == 0) goto L8;
            UsbPortManager.logAndPrint(6, this.mPw, "port status enquiry failed");
            return;
        L8:
            ArrayList<RawPortInfo> newPortInfo = new ArrayList();
            Iterator<PortStatus> r2 = currentPortStatus.iterator();
        L10:
            if (r2.hasNext() == false) goto L12;
            PortStatus current = r2.next();
            RawPortInfo temp = new RawPortInfo(current.portName, current.supportedModes, 0, current.currentMode, current.canChangeMode, current.currentPowerRole, current.canChangePowerRole, current.currentDataRole, current.canChangeDataRole, false, 0, false, 0, UsbPortHidl.m9215$$Nest$sfgetsUsbDataStatus(), false, 0, false, new int[0], 0, 0, null);
            newPortInfo.add(temp);
            UsbPortManager.logAndPrint(4, this.mPw, "ClientCallback V1_0: " + current.portName);
            goto L10
        L12:
            this.mPortManager.updatePorts(newPortInfo);
        }

        @Override // android.hardware.usb.V1_1.IUsbCallback
        public void notifyPortStatusChange_1_1(ArrayList<PortStatus_1_1> currentPortStatus, int retval) {
            if (UsbPortHidl.m9212$$Nest$fgetmSystemReady(this.mUsbPortHidl) == true) goto L5;
            return;
        L5:
            if (retval == 0) goto L8;
            UsbPortManager.logAndPrint(6, this.mPw, "port status enquiry failed");
            return;
        L8:
            ArrayList<RawPortInfo> newPortInfo = new ArrayList();
            int numStatus = currentPortStatus.size();
            int i = 0;
        L9:
            if (i >= numStatus) goto L11;
            PortStatus_1_1 current = currentPortStatus.get(i);
            RawPortInfo temp = new RawPortInfo(current.status.portName, current.supportedModes, 0, current.currentMode, current.status.canChangeMode, current.status.currentPowerRole, current.status.canChangePowerRole, current.status.currentDataRole, current.status.canChangeDataRole, false, 0, false, 0, UsbPortHidl.m9215$$Nest$sfgetsUsbDataStatus(), false, 0, false, new int[0], 0, 0, null);
            newPortInfo.add(temp);
            UsbPortManager.logAndPrint(4, this.mPw, "ClientCallback V1_1: " + current.status.portName);
            i = i + 1;
            goto L9
        L11:
            this.mPortManager.updatePorts(newPortInfo);
        }

        @Override // android.hardware.usb.V1_2.IUsbCallback
        public void notifyPortStatusChange_1_2(ArrayList<android.hardware.usb.V1_2.PortStatus> currentPortStatus, int retval) {
            if (UsbPortHidl.m9212$$Nest$fgetmSystemReady(this.mUsbPortHidl) == true) goto L5;
            return;
        L5:
            if (retval == 0) goto L8;
            UsbPortManager.logAndPrint(6, this.mPw, "port status enquiry failed");
            return;
        L8:
            ArrayList<RawPortInfo> newPortInfo = new ArrayList();
            int numStatus = currentPortStatus.size();
            int i = 0;
        L9:
            if (i >= numStatus) goto L11;
            android.hardware.usb.V1_2.PortStatus current = currentPortStatus.get(i);
            int numStatus2 = numStatus;
            RawPortInfo temp = new RawPortInfo(current.status_1_1.status.portName, current.status_1_1.supportedModes, current.supportedContaminantProtectionModes, current.status_1_1.currentMode, current.status_1_1.status.canChangeMode, current.status_1_1.status.currentPowerRole, current.status_1_1.status.canChangePowerRole, current.status_1_1.status.currentDataRole, current.status_1_1.status.canChangeDataRole, current.supportsEnableContaminantPresenceProtection, current.contaminantProtectionStatus, current.supportsEnableContaminantPresenceDetection, current.contaminantDetectionStatus, UsbPortHidl.m9215$$Nest$sfgetsUsbDataStatus(), false, 0, false, new int[0], 0, 0, null);
            newPortInfo.add(temp);
            UsbPortManager.logAndPrint(4, this.mPw, "ClientCallback V1_2: " + current.status_1_1.status.portName);
            i = i + 1;
            numStatus = numStatus2;
            goto L9
        L11:
            this.mPortManager.updatePorts(newPortInfo);
        }

        @Override // android.hardware.usb.V1_0.IUsbCallback
        public void notifyRoleSwitchStatus(String portName, PortRole role, int retval) {
            if (retval != 0) goto L4;
            UsbPortManager.logAndPrint(4, this.mPw, portName + " role switch successful");
            return;
        L4:
            UsbPortManager.logAndPrint(6, this.mPw, portName + " role switch failed");
        }
    }

    final class ServiceNotification extends IServiceNotification.Stub {
        final /* synthetic */ UsbPortHidl this$0;

        ServiceNotification(UsbPortHidl this$0) {
            this.this$0 = this$0;
        }

        @Override // android.hidl.manager.V1_0.IServiceNotification
        public void onRegistration(String fqName, String name, boolean preexisting) {
            UsbPortManager.logAndPrint(4, null, "Usb hal service started " + fqName + " " + name);
            UsbPortHidl.m9214$$Nest$mconnectToProxy(this.this$0, null);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9211$$Nest$fgetmLock(UsbPortHidl r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSystemReady, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m9212$$Nest$fgetmSystemReady(UsbPortHidl r0) {
        return r0.mSystemReady;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProxy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9213$$Nest$fputmProxy(UsbPortHidl r0, IUsb r1) {
        r0.mProxy = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectToProxy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9214$$Nest$mconnectToProxy(UsbPortHidl r0, IndentingPrintWriter r1) {
        r0.connectToProxy(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsUsbDataStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9215$$Nest$sfgetsUsbDataStatus() {
        return sUsbDataStatus;
    }

    static {
        TAG = UsbPortHidl.class.getSimpleName();
        sUsbDataStatus = 0;
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public int getUsbHalVersion() throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy == null) goto L22;
        if (android.hardware.usb.V1_3.IUsb.castFrom(this.mProxy) == null) goto L10;
        int version = 13;
    L16:
        UsbPortManager.logAndPrint(4, null, "USB HAL HIDL version: " + version);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return version;
    L10:
        if (android.hardware.usb.V1_2.IUsb.castFrom(this.mProxy) == null) goto L13;
        version = 12;
        goto L16
    L13:
        if (android.hardware.usb.V1_1.IUsb.castFrom(this.mProxy) == null) goto L15;
        version = 11;
        goto L16
    L15:
        version = 10;
        goto L16
    L22:
        throw new RemoteException("IUsb not initialized yet");     // Catch: Throwable -> L19
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
        this.mProxy = IUsb.getService();     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mProxy.linkToDeath(new DeathRecipient(this, pw), 1000);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mProxy.setCallback(this.mHALCallback);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mProxy.queryPortStatus();     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
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

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void systemReady() {
        this.mSystemReady = true;
    }

    static boolean isServicePresent(IndentingPrintWriter pw) {
        IUsb.getService(true);     // Catch: RemoteException -> L5 NoSuchElementException -> L8
    L7:
        return true;
    L5:
        e = move-exception;
        UsbPortManager.logAndPrintException(pw, "IUSB hal service present but failed to get service", e);
    L8:
        e = move-exception;
        UsbPortManager.logAndPrintException(pw, "connectToProxy: usb hidl hal service not found.", e);
        return false;
    }

    public UsbPortHidl(UsbPortManager portManager, IndentingPrintWriter pw) {
        this.mLock = new Object();
        portManager.getClass();
        this.mPortManager = portManager;
        this.mPw = pw;
        this.mHALCallback = new HALCallback(null, this.mPortManager, this);
        ServiceNotification serviceNotification = new ServiceNotification(this);     // Catch: RemoteException -> L7
        boolean ret = IServiceManager.getService().registerForNotifications(IUsb.kInterfaceName, "", serviceNotification);     // Catch: RemoteException -> L7
        if (ret == true) goto L9;
        UsbPortManager.logAndPrint(6, null, "Failed to register service start notification");     // Catch: RemoteException -> L7
    L9:
        connectToProxy(this.mPw);
        return;
    L7:
        e = move-exception;
        UsbPortManager.logAndPrintException(null, "Failed to register service start notification", e);
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void enableContaminantPresenceDetection(String portName, boolean enable, long transactionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L25;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry !");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L25:
        android.hardware.usb.V1_2.IUsb proxy = android.hardware.usb.V1_2.IUsb.castFrom(this.mProxy);     // Catch: Throwable -> L9 ClassCastException -> L13 RemoteException -> L15
        proxy.enableContaminantPresenceDetection(portName, enable);     // Catch: Throwable -> L9 ClassCastException -> L13 RemoteException -> L15
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set contaminant detection", e);     // Catch: Throwable -> L9
    L13:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Method only applicable to V1.2 or above implementation", e);     // Catch: Throwable -> L9
        goto L20
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void queryPortStatus(long transactionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L20;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry !");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        this.mProxy.queryPortStatus();     // Catch: Throwable -> L9 RemoteException -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L13:
        e = move-exception;
        UsbPortManager.logAndPrintException(null, "ServiceStart: Failed to query port status", e);     // Catch: Throwable -> L9
        goto L15
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void switchMode(String portId, int newMode, long transactionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L11;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry !");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        PortRole newRole = new PortRole();     // Catch: Throwable -> L9
        newRole.type = 2;     // Catch: Throwable -> L9
        newRole.role = newMode;     // Catch: Throwable -> L9
        this.mProxy.switchRole(portId, newRole);     // Catch: Throwable -> L9 RemoteException -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set the USB port mode: portId=" + portId + ", newMode=" + UsbPort.modeToString(newRole.role), e);     // Catch: Throwable -> L9
        goto L16
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void switchPowerRole(String portId, int newPowerRole, long transactionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L11;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry !");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        PortRole newRole = new PortRole();     // Catch: Throwable -> L9
        newRole.type = 1;     // Catch: Throwable -> L9
        newRole.role = newPowerRole;     // Catch: Throwable -> L9
        this.mProxy.switchRole(portId, newRole);     // Catch: Throwable -> L9 RemoteException -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set the USB power role: portId=" + portId + ", newPowerRole=" + UsbPort.powerRoleToString(newRole.role), e);     // Catch: Throwable -> L9
        goto L16
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void enableLimitPowerTransfer(String portName, boolean limit, long transactionId, IUsbOperationInternal callback) {
        callback.onOperationComplete(2);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to call onOperationComplete", e);
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void enableUsbDataWhileDocked(String portName, long transactionId, IUsbOperationInternal callback) {
        callback.onOperationComplete(2);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to call onOperationComplete", e);
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void switchDataRole(String portId, int newDataRole, long transactionId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mProxy != null) goto L11;
        UsbPortManager.logAndPrint(6, this.mPw, "Proxy is null. Retry !");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        PortRole newRole = new PortRole();     // Catch: Throwable -> L9
        newRole.type = 0;     // Catch: Throwable -> L9
        newRole.role = newDataRole;     // Catch: Throwable -> L9
        this.mProxy.switchRole(portId, newRole);     // Catch: Throwable -> L9 RemoteException -> L14
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L14:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to set the USB data role: portId=" + portId + ", newDataRole=" + UsbPort.dataRoleToString(newRole.role), e);     // Catch: Throwable -> L9
        goto L16
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public void resetUsbPort(String portName, long transactionId, IUsbOperationInternal callback) {
        callback.onOperationComplete(2);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to call onOperationComplete. opID:" + transactionId + " portId:" + portName, e);
    }

    @Override // com.android.server.usb.hal.port.UsbPortHal
    public boolean enableUsbData(String portName, boolean enable, long transactionId, IUsbOperationInternal callback) {
        int halVersion = getUsbHalVersion();     // Catch: RemoteException -> L42
        if (halVersion != 13) goto L48;
        Object r2 = this.mLock;
        monitor-enter(r2);
        int r3 = 1;
        android.hardware.usb.V1_3.IUsb proxy = android.hardware.usb.V1_3.IUsb.castFrom(this.mProxy);     // Catch: Throwable -> L30 RemoteException -> L32
        boolean success = proxy.enableUsbDataSignal(enable);     // Catch: Throwable -> L30 RemoteException -> L32
        monitor-exit(r2);     // Catch: Throwable -> L30
        if (success == false) goto L22;
        if (enable == false) goto L20;
        int r4 = 0;
    L21:
        sUsbDataStatus = r4;
        goto L22
    L20:
        r4 = 16;
    L22:
        if (success == false) goto L46;
        r3 = 0;
    L46:
        callback.onOperationComplete(r3);     // Catch: RemoteException -> L27
    L29:
        return false;
    L27:
        r = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to call onOperationComplete. opID:" + transactionId + " portId:" + portName, r);
        goto L29
    L30:
        th = move-exception;
        throw th;
    L32:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed enableUsbData: opId:" + transactionId + " portId=" + portName, e);     // Catch: Throwable -> L30
        callback.onOperationComplete(1);     // Catch: Throwable -> L30 RemoteException -> L36
    L39:
        return false;
    L36:
        r = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to call onOperationComplete. opID:" + transactionId + " portId:" + portName, r);     // Catch: Throwable -> L30
        goto L39
    L48:
        callback.onOperationComplete(2);     // Catch: RemoteException -> L9
    L11:
        return false;
    L9:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to call onOperationComplete. opID:" + transactionId + " portId:" + portName, e);
    L42:
        e = move-exception;
        UsbPortManager.logAndPrintException(this.mPw, "Failed to query USB HAL version. opID:" + transactionId + " portId:" + portName, e);
        return false;
    }
}
