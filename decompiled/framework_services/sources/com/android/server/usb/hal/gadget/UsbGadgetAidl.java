package com.android.server.usb.hal.gadget;

import android.hardware.usb.gadget.IUsbGadget;
import android.hardware.usb.gadget.IUsbGadgetCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.usb.UsbDeviceManager;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class UsbGadgetAidl implements UsbGadgetHal {
    private static final String TAG = null;
    private static final String USB_GADGET_AIDL_SERVICE = null;
    private final UsbDeviceManager mDeviceManager;
    private IUsbGadget mGadgetProxy;
    private final Object mGadgetProxyLock;
    public final IndentingPrintWriter mPw;
    private UsbGadgetCallback mUsbGadgetCallback;

    private class UsbGadgetCallback extends IUsbGadgetCallback.Stub {
        public boolean mChargingFunctions;
        public long mFunctions;
        public IndentingPrintWriter mPw;
        public int mRequest;
        final /* synthetic */ UsbGadgetAidl this$0;

        UsbGadgetCallback(UsbGadgetAidl r1) {
            this.this$0 = r1;
        }

        UsbGadgetCallback(UsbGadgetAidl r1, IndentingPrintWriter pw, int request, long functions, boolean chargingFunctions) {
            this.this$0 = r1;
            this.mPw = pw;
            this.mRequest = request;
            this.mFunctions = functions;
            this.mChargingFunctions = chargingFunctions;
        }

        public void setCurrentUsbFunctionsCb(long functions, int status, long transactionId) {
            if (status != 0) goto L5;
            UsbDeviceManager.logAndPrint(4, this.mPw, "Usb setCurrentUsbFunctionsCb ,functions:" + functions + " ,status:" + status + " ,transactionId:" + transactionId);
        L6:
            UsbGadgetAidl.m9203$$Nest$fgetmDeviceManager(this.this$0).setCurrentUsbFunctionsCb(functions, status, this.mRequest, this.mFunctions, this.mChargingFunctions);
            return;
        L5:
            UsbDeviceManager.logAndPrint(6, this.mPw, "Usb setCurrentUsbFunctionsCb failed ,functions:" + functions + " ,status:" + status + " ,transactionId:" + transactionId);
            goto L6
        }

        public void getCurrentUsbFunctionsCb(long functions, int status, long transactionId) {
            if (status != 0) goto L5;
            UsbDeviceManager.logAndPrint(4, this.mPw, "Usb getCurrentUsbFunctionsCb ,functions:" + functions + " ,status:" + status + " ,transactionId:" + transactionId);
        L6:
            UsbGadgetAidl.m9203$$Nest$fgetmDeviceManager(this.this$0).getCurrentUsbFunctionsCb(functions, status);
            return;
        L5:
            UsbDeviceManager.logAndPrint(6, this.mPw, "Usb getCurrentUsbFunctionsCb failed ,functions:" + functions + " ,status:" + status + " ,transactionId:" + transactionId);
            goto L6
        }

        public void getUsbSpeedCb(int speed, long transactionId) {
            UsbDeviceManager.logAndPrint(4, this.mPw, "getUsbSpeedCb speed:" + speed + " ,transactionId:" + transactionId);
            UsbGadgetAidl.m9203$$Nest$fgetmDeviceManager(this.this$0).getUsbSpeedCb(speed);
        }

        public void resetCb(int status, long transactionId) {
            if (status != 0) goto L5;
            UsbDeviceManager.logAndPrint(4, this.mPw, "Usb resetCb status:" + status + " ,transactionId:" + transactionId);
        L6:
            UsbGadgetAidl.m9203$$Nest$fgetmDeviceManager(this.this$0).resetCb(status);
            return;
        L5:
            UsbDeviceManager.logAndPrint(6, this.mPw, "Usb resetCb status" + status + " ,transactionId:" + transactionId);
            goto L6
        }

        public String getInterfaceHash() {
            return "cb628c69682659911bca5c1d04042adba7f0de4b";
        }

        public int getInterfaceVersion() {
            return 1;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeviceManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ UsbDeviceManager m9203$$Nest$fgetmDeviceManager(UsbGadgetAidl r0) {
        return r0.mDeviceManager;
    }

    static {
        TAG = UsbGadgetAidl.class.getSimpleName();
        USB_GADGET_AIDL_SERVICE = IUsbGadget.DESCRIPTOR + "/default";
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public int getGadgetHalVersion() throws RemoteException {
        Object r0 = this.mGadgetProxyLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mGadgetProxy == null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        Slog.i(TAG, "USB Gadget HAL AIDL version: GADGET_HAL_V2_0");
        return 20;
    L12:
        throw new RemoteException("IUsb not initialized yet");     // Catch: Throwable -> L9
    }

    public void serviceDied() {
        UsbDeviceManager.logAndPrint(6, this.mPw, "Usb Gadget AIDL hal service died");
        Object r0 = this.mGadgetProxyLock;
        monitor-enter(r0);
        this.mGadgetProxy = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        connectToProxy(null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void connectToProxy(IndentingPrintWriter pw) {
        Object r0 = this.mGadgetProxyLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mGadgetProxy == null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mGadgetProxy = IUsbGadget.Stub.asInterface(ServiceManager.waitForService(USB_GADGET_AIDL_SERVICE));     // Catch: Throwable -> L8 NoSuchElementException -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L12:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(pw, "connectToProxy: usb gadget hal service not found. Did the service fail to start?", e);     // Catch: Throwable -> L8
        goto L14
    }

    static boolean isServicePresent(IndentingPrintWriter pw) {
        return ServiceManager.isDeclared(USB_GADGET_AIDL_SERVICE);
    L4:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(pw, "connectToProxy: usb gadget Aidl hal service not found.", e);
        return false;
    }

    public UsbGadgetAidl(UsbDeviceManager deviceManager, IndentingPrintWriter pw) {
        this.mGadgetProxyLock = new Object();
        deviceManager.getClass();
        this.mDeviceManager = deviceManager;
        this.mPw = pw;
        connectToProxy(this.mPw);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void getCurrentUsbFunctions(long operationId) {
        Object r0 = this.mGadgetProxyLock;
        monitor-enter(r0);
        this.mGadgetProxy.getCurrentUsbFunctions(new UsbGadgetCallback(this), operationId);     // Catch: Throwable -> L7 RemoteException -> L9
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(this.mPw, "RemoteException while calling getCurrentUsbFunctions, opID:" + operationId, e);     // Catch: Throwable -> L7
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void getUsbSpeed(long operationId) {
        Object r0 = this.mGadgetProxyLock;     // Catch: RemoteException -> L10
        monitor-enter(r0);     // Catch: RemoteException -> L10
        this.mGadgetProxy.getUsbSpeed(new UsbGadgetCallback(this), operationId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L10
    L10:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(this.mPw, "RemoteException while calling getUsbSpeed, opID:" + operationId, e);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void reset(long operationId) {
        Object r0 = this.mGadgetProxyLock;     // Catch: RemoteException -> L10
        monitor-enter(r0);     // Catch: RemoteException -> L10
        this.mGadgetProxy.reset(new UsbGadgetCallback(this), operationId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L10
    L10:
        e = move-exception;
        UsbDeviceManager.logAndPrintException(this.mPw, "RemoteException while calling getUsbSpeed, opID:" + operationId, e);
    }

    @Override // com.android.server.usb.hal.gadget.UsbGadgetHal
    public void setCurrentUsbFunctions(int mRequest, long mFunctions, boolean mChargingFunctions, int timeout, long operationId) {
        UsbGadgetAidl r1 = this;
        r1.mUsbGadgetCallback = new UsbGadgetCallback(r1, null, mRequest, mFunctions, mChargingFunctions);     // Catch: RemoteException -> L13
        Object r2 = r1.mGadgetProxyLock;     // Catch: RemoteException -> L13
        monitor-enter(r2);     // Catch: RemoteException -> L13
        r1.mGadgetProxy.setCurrentUsbFunctions(mFunctions, r1.mUsbGadgetCallback, timeout, operationId);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = e;
    L17:
        UsbDeviceManager.logAndPrintException(r1.mPw, "RemoteException while calling setCurrentUsbFunctions: mRequest=" + mRequest + ", mFunctions=" + mFunctions + ", mChargingFunctions=" + mChargingFunctions + ", timeout=" + timeout + ", opID:" + operationId, e);
        return;
    L15:
        e = e;
        r1 = this;
        goto L17
    }
}
