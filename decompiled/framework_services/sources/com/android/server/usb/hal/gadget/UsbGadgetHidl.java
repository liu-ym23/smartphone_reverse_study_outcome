package com.android.server.usb.hal.gadget;

import android.hardware.usb.gadget.V1_0.IUsbGadget;
import android.hardware.usb.gadget.V1_2.IUsbGadgetCallback;
import android.hidl.manager.V1_0.IServiceManager;
import android.hidl.manager.V1_0.IServiceNotification;
import android.os.IHwBinder;
import android.os.RemoteException;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.ISmtResourceControl;
import com.android.server.usb.UsbDeviceManager;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbGadgetHidl implements UsbGadgetHal {
    private static final int USB_GADGET_HAL_DEATH_COOKIE = 2000;
    private UsbDeviceManager mDeviceManager;
    private IUsbGadget mGadgetProxy;
    private final Object mGadgetProxyLock;
    private final IndentingPrintWriter mPw;
    private UsbGadgetCallback mUsbGadgetCallback;

    final class DeathRecipient implements IHwBinder.DeathRecipient {
        private final IndentingPrintWriter mPw;
        final /* synthetic */ UsbGadgetHidl this$0;

        DeathRecipient(UsbGadgetHidl this$0, IndentingPrintWriter pw) {
            this.this$0 = this$0;
            this.mPw = pw;
        }

        public void serviceDied(long cookie) {
            if (cookie != ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME) goto L12;
            UsbDeviceManager.logAndPrint(6, this.mPw, "Usb Gadget hal service died cookie: " + cookie);
            Object r0 = UsbGadgetHidl.m9205$$Nest$fgetmGadgetProxyLock(this.this$0);
            monitor-enter(r0);
            UsbGadgetHidl.m9207$$Nest$fputmGadgetProxy(this.this$0, null);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    final class ServiceNotification extends IServiceNotification.Stub {
        final /* synthetic */ UsbGadgetHidl this$0;

        ServiceNotification(UsbGadgetHidl this$0) {
            this.this$0 = this$0;
        }

        @Override // android.hidl.manager.V1_0.IServiceNotification
        public void onRegistration(String fqName, String name, boolean preexisting) {
            UsbDeviceManager.logAndPrint(4, UsbGadgetHidl.m9206$$Nest$fgetmPw(this.this$0), "Usb gadget hal service started " + fqName + " " + name);
            UsbGadgetHidl.m9208$$Nest$mconnectToProxy(this.this$0, null);
        }
    }

    private class UsbGadgetCallback extends IUsbGadgetCallback.Stub {
        public boolean mChargingFunctions;
        public long mFunctions;
        public int mRequest;
        final /* synthetic */ UsbGadgetHidl this$0;

        UsbGadgetCallback(UsbGadgetHidl r1) {
            this.this$0 = r1;
        }

        UsbGadgetCallback(UsbGadgetHidl r1, IndentingPrintWriter pw, int request, long functions, boolean chargingFunctions) {
            this.this$0 = r1;
            this.mRequest = request;
            this.mFunctions = functions;
            this.mChargingFunctions = chargingFunctions;
        }

        public void setCurrentUsbFunctionsCb(long functions, int status) {
            UsbGadgetHidl.m9204$$Nest$fgetmDeviceManager(this.this$0).setCurrentUsbFunctionsCb(functions, status, this.mRequest, this.mFunctions, this.mChargingFunctions);
        }

        public void getCurrentUsbFunctionsCb(long functions, int status) {
            UsbGadgetHidl.m9204$$Nest$fgetmDeviceManager(this.this$0).getCurrentUsbFunctionsCb(functions, status);
        }

        public void getUsbSpeedCb(int speed) {
            UsbGadgetHidl.m9204$$Nest$fgetmDeviceManager(this.this$0).getUsbSpeedCb(speed);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsbDeviceManager m9204$$Nest$fgetmDeviceManager(UsbGadgetHidl r0) {
        return r0.mDeviceManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGadgetProxyLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m9205$$Nest$fgetmGadgetProxyLock(UsbGadgetHidl r0) {
        return r0.mGadgetProxyLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPw, reason: not valid java name */
    static /* bridge */ /* synthetic */ IndentingPrintWriter m9206$$Nest$fgetmPw(UsbGadgetHidl r0) {
        return r0.mPw;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmGadgetProxy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9207$$Nest$fputmGadgetProxy(UsbGadgetHidl r0, IUsbGadget r1) {
        r0.mGadgetProxy = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectToProxy, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9208$$Nest$mconnectToProxy(UsbGadgetHidl r0, IndentingPrintWriter r1) {
        r0.connectToProxy(r1);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public int getGadgetHalVersion() throws RemoteException {
        Object r0 = this.mGadgetProxyLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mGadgetProxy == null) goto L19;
        if (android.hardware.usb.gadget.V1_2.IUsbGadget.castFrom(this.mGadgetProxy) == null) goto L10;
        int version = 12;
    L13:
        UsbDeviceManager.logAndPrint(4, this.mPw, "USB Gadget HAL HIDL version: " + version);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return version;
    L10:
        if (android.hardware.usb.gadget.V1_1.IUsbGadget.castFrom(this.mGadgetProxy) == null) goto L12;
        version = 11;
        goto L13
    L12:
        version = 10;
        goto L13
    L19:
        throw new RemoteException("IUsbGadget not initialized yet");     // Catch: Throwable -> L16
    }

    private void connectToProxy(IndentingPrintWriter pw) {
        Object r0 = this.mGadgetProxyLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mGadgetProxy == null) goto L24;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L24:
        this.mGadgetProxy = IUsbGadget.getService();     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
        this.mGadgetProxy.linkToDeath(new DeathRecipient(this, pw), ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);     // Catch: Throwable -> L8 RemoteException -> L12 NoSuchElementException -> L14
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L12:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(pw, "connectToProxy: usb gadget hal service not responding", e);     // Catch: Throwable -> L8
    L14:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(pw, "connectToProxy: usb gadget hal service not found. Did the service fail to start?", e);     // Catch: Throwable -> L8
        goto L19
    }

    static boolean isServicePresent(IndentingPrintWriter pw) {
        IUsbGadget.getService(true);     // Catch: RemoteException -> L5 NoSuchElementException -> L8
    L7:
        return true;
    L5:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(pw, "IUSBGadget hal service present but failed to get service", e);
    L8:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(pw, "connectToProxy: usb gadget hidl hal service not found.", e);
        return false;
    }

    public UsbGadgetHidl(UsbDeviceManager deviceManager, IndentingPrintWriter pw) {
        this.mGadgetProxyLock = new Object();
        deviceManager.getClass();
        this.mDeviceManager = deviceManager;
        this.mPw = pw;
        ServiceNotification serviceNotification = new ServiceNotification(this);     // Catch: RemoteException -> L7
        boolean ret = IServiceManager.getService().registerForNotifications("android.hardware.usb.gadget@1.0::IUsbGadget", "", serviceNotification);     // Catch: RemoteException -> L7
        if (ret == true) goto L9;
        UsbDeviceManager.logAndPrint(6, pw, "Failed to register service start notification");     // Catch: RemoteException -> L7
    L9:
        connectToProxy(this.mPw);
        return;
    L7:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(pw, "Failed to register service start notification", e);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void getCurrentUsbFunctions(long transactionId) {
        Object r0 = this.mGadgetProxyLock;     // Catch: RemoteException -> L10
        monitor-enter(r0);     // Catch: RemoteException -> L10
        this.mGadgetProxy.getCurrentUsbFunctions(new UsbGadgetCallback(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L10
    L10:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(this.mPw, "RemoteException while calling getCurrentUsbFunctions", e);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void getUsbSpeed(long transactionId) {
        Object r0 = this.mGadgetProxyLock;     // Catch: RemoteException -> L13
        monitor-enter(r0);     // Catch: RemoteException -> L13
    L7:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L5:
        if (android.hardware.usb.gadget.V1_2.IUsbGadget.castFrom(this.mGadgetProxy) == null) goto L9;
        android.hardware.usb.gadget.V1_2.IUsbGadget gadgetProxy = android.hardware.usb.gadget.V1_2.IUsbGadget.castFrom(this.mGadgetProxy);     // Catch: Throwable -> L7
        gadgetProxy.getUsbSpeed(new UsbGadgetCallback(this));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    L19:
        return;
    L13:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(this.mPw, "get UsbSpeed failed", e);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void reset(long transactionId) {
        Object r0 = this.mGadgetProxyLock;     // Catch: RemoteException -> L13
        monitor-enter(r0);     // Catch: RemoteException -> L13
    L7:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L5:
        if (android.hardware.usb.gadget.V1_1.IUsbGadget.castFrom(this.mGadgetProxy) == null) goto L9;
        android.hardware.usb.gadget.V1_1.IUsbGadget gadgetProxy = android.hardware.usb.gadget.V1_1.IUsbGadget.castFrom(this.mGadgetProxy);     // Catch: Throwable -> L7
        gadgetProxy.reset();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L13:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(this.mPw, "RemoteException while calling reset", e);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void setCurrentUsbFunctions(int mRequest, long mFunctions, boolean mChargingFunctions, int timeout, long operationId) {
        this.mUsbGadgetCallback = new UsbGadgetCallback(this, null, mRequest, mFunctions, mChargingFunctions);     // Catch: RemoteException -> L11
        Object r2 = this.mGadgetProxyLock;     // Catch: RemoteException -> L11
        monitor-enter(r2);     // Catch: RemoteException -> L11
        this.mGadgetProxy.setCurrentUsbFunctions(mFunctions, this.mUsbGadgetCallback, timeout);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L11
    L11:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(this.mPw, "RemoteException while calling setCurrentUsbFunctions mRequest = " + mRequest + ", mFunctions = " + mFunctions + ", timeout = " + timeout + ", mChargingFunctions = " + mChargingFunctions + ", operationId =" + operationId, e);
    }
}
