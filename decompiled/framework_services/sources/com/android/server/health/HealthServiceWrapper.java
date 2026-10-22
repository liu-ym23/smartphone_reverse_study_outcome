package com.android.server.health;

import android.hardware.health.BatteryHealthData;
import android.hardware.health.HealthInfo;
import android.os.BatteryProperty;
import android.os.HandlerThread;
import android.os.RemoteException;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HealthServiceWrapper {
    abstract HandlerThread getHandlerThread();

    public abstract HealthInfo getHealthInfo() throws RemoteException;

    public abstract int getProperty(int r1, BatteryProperty r2) throws RemoteException;

    public abstract void scheduleUpdate() throws RemoteException;

    public HealthServiceWrapper() {
    }

    public BatteryHealthData getBatteryHealthData() throws RemoteException {
        return null;
    }

    public static HealthServiceWrapper create(HealthInfoCallback healthInfoCallback) throws RemoteException, NoSuchElementException {
        HealthHalCallbackHidl r0 = null;
        if (healthInfoCallback != null) goto L5;
        HealthRegCallbackAidl r1 = null;
    L6:
        HealthServiceWrapperAidl.ServiceManagerStub r2 = new AnonymousClass1();
        if (healthInfoCallback == null) goto L11;
        r0 = new HealthHalCallbackHidl(healthInfoCallback);
    L11:
        return create(r1, r2, r0, new AnonymousClass2(), new AnonymousClass3());
    L5:
        r1 = new HealthRegCallbackAidl(healthInfoCallback);
        goto L6
    }

    static HealthServiceWrapper create(HealthRegCallbackAidl aidlRegCallback, HealthServiceWrapperAidl.ServiceManagerStub aidlServiceManager, HealthServiceWrapperHidl.Callback hidlRegCallback, HealthServiceWrapperHidl.IServiceManagerSupplier hidlServiceManagerSupplier, HealthServiceWrapperHidl.IHealthSupplier hidlHealthSupplier) throws RemoteException, NoSuchElementException {
        return new HealthServiceWrapperAidl(aidlRegCallback, aidlServiceManager);
    L6:
        return new HealthServiceWrapperHidl(hidlRegCallback, hidlServiceManagerSupplier, hidlHealthSupplier);
    }
}
