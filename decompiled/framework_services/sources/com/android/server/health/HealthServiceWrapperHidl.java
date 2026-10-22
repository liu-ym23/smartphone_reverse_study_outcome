package com.android.server.health;

import android.hardware.health.Translate;
import android.hardware.health.V2_0.HealthInfo;
import android.hardware.health.V2_0.IHealth;
import android.hidl.manager.V1_0.IServiceManager;
import android.hidl.manager.V1_0.IServiceNotification;
import android.os.BatteryProperty;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.os.Trace;
import android.util.MutableInt;
import android.util.Slog;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class HealthServiceWrapperHidl extends HealthServiceWrapper {
    public static final String INSTANCE_VENDOR = "default";
    private static final String TAG = "HealthServiceWrapperHidl";
    private Callback mCallback;
    private final HandlerThread mHandlerThread;
    private IHealthSupplier mHealthSupplier;
    private String mInstanceName;
    private final AtomicReference<IHealth> mLastService;
    private final IServiceNotification mNotification;

    interface Callback {
        void onRegistration(IHealth r1, IHealth r2, String r3);
    }

    interface IHealthSupplier {
        default IHealth get(String name) throws NoSuchElementException, RemoteException {
            return IHealth.getService(name, true);
        }
    }

    interface IServiceManagerSupplier {
        default IServiceManager get() throws NoSuchElementException, RemoteException {
            return IServiceManager.getService();
        }
    }

    private static class Mutable<T> {
        public T value;

        /* synthetic */ Mutable(HealthServiceWrapperHidlIA r1) {
            this();
        }

        private Mutable() {
        }
    }

    private class Notification extends IServiceNotification.Stub {
        final /* synthetic */ HealthServiceWrapperHidl this$0;

        /* synthetic */ Notification(HealthServiceWrapperHidl r1, HealthServiceWrapperHidlIA r2) {
            this(r1);
        }

        private Notification(HealthServiceWrapperHidl r1) {
            this.this$0 = r1;
        }

        @Override // android.hidl.manager.V1_0.IServiceNotification
        public final void onRegistration(String interfaceName, String instanceName, boolean preexisting) {
            if (IHealth.kInterfaceName.equals(interfaceName) == true) goto L6;
            return;
        L6:
            if (HealthServiceWrapperHidl.m4447$$Nest$fgetmInstanceName(this.this$0).equals(instanceName) == true) goto L8;
            return;
        L8:
            HealthServiceWrapperHidl.m4445$$Nest$fgetmHandlerThread(this.this$0).getThreadHandler().post(new AnonymousClass1(this));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$2YHt-2jZELpSxwyjUiIiiuewzA0, reason: not valid java name */
    public static /* synthetic */ void m4440$r8$lambda$2YHt2jZELpSxwyjUiIiiuewzA0(MutableInt r0, BatteryProperty r1, int r2, int r3) {
        lambda$getProperty$1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$LZ-bD2XWcV4TMLbh5AxrI0jkFhs, reason: not valid java name */
    public static /* synthetic */ void m4441$r8$lambda$LZbD2XWcV4TMLbh5AxrI0jkFhs(MutableInt r0, BatteryProperty r1, int r2, int r3) {
        lambda$getProperty$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ODbQkC_m4hWEnYvZuDTadL5AtzU(HealthServiceWrapperHidl r0) {
        r0.lambda$scheduleUpdate$6();
    }

    /* JADX INFO: renamed from: $r8$lambda$R-dbRgHhspu3hCc_DrxWHznvHMM, reason: not valid java name */
    public static /* synthetic */ void m4442$r8$lambda$RdbRgHhspu3hCc_DrxWHznvHMM(MutableInt r0, BatteryProperty r1, int r2, int r3) {
        lambda$getProperty$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$b2gv9MeBUyxa_BQFQrDfshOmoN0(MutableInt r0, BatteryProperty r1, int r2, int r3) {
        lambda$getProperty$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$eP45UlWIQTfMoT2M8d3kfIjLWNQ(MutableInt r0, BatteryProperty r1, int r2, long r3) {
        lambda$getProperty$5(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$eetuJn3PsYCN-V7Scb_L05ajA3Q, reason: not valid java name */
    public static /* synthetic */ void m4443$r8$lambda$eetuJn3PsYCNV7Scb_L05ajA3Q(MutableInt r0, BatteryProperty r1, int r2, int r3) {
        lambda$getProperty$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ws1fedw1eJsmMr0aREboWxvcACs(Mutable r0, int r1, HealthInfo r2) {
        lambda$getHealthInfo$7(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ Callback m4444$$Nest$fgetmCallback(HealthServiceWrapperHidl r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandlerThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ HandlerThread m4445$$Nest$fgetmHandlerThread(HealthServiceWrapperHidl r0) {
        return r0.mHandlerThread;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHealthSupplier, reason: not valid java name */
    static /* bridge */ /* synthetic */ IHealthSupplier m4446$$Nest$fgetmHealthSupplier(HealthServiceWrapperHidl r0) {
        return r0.mHealthSupplier;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInstanceName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4447$$Nest$fgetmInstanceName(HealthServiceWrapperHidl r0) {
        return r0.mInstanceName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastService, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicReference m4448$$Nest$fgetmLastService(HealthServiceWrapperHidl r0) {
        return r0.mLastService;
    }

    private static void traceBegin(String name) {
        Trace.traceBegin(524288, name);
    }

    private static void traceEnd() {
        Trace.traceEnd(524288);
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public int getProperty(int id, final BatteryProperty prop) throws RemoteException {
        traceBegin("HealthGetProperty");
        IHealth service = this.mLastService.get();     // Catch: Throwable -> L9
        if (service == null) goto L20;
        final MutableInt outResult = new MutableInt(1);     // Catch: Throwable -> L9
        switch(id) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L8;
            default: goto L16;
        };     // Catch: Throwable -> L9
    L8:
        service.getChargeStatus(new HealthServiceWrapperHidl$$ExternalSyntheticLambda5(outResult, prop));     // Catch: Throwable -> L9
        goto L16
    L11:
        service.getEnergyCounter(new HealthServiceWrapperHidl$$ExternalSyntheticLambda6(outResult, prop));     // Catch: Throwable -> L9
        goto L16
    L12:
        service.getCapacity(new HealthServiceWrapperHidl$$ExternalSyntheticLambda4(outResult, prop));     // Catch: Throwable -> L9
        goto L16
    L13:
        service.getCurrentAverage(new HealthServiceWrapperHidl$$ExternalSyntheticLambda3(outResult, prop));     // Catch: Throwable -> L9
        goto L16
    L14:
        service.getCurrentNow(new HealthServiceWrapperHidl$$ExternalSyntheticLambda2(outResult, prop));     // Catch: Throwable -> L9
        goto L16
    L15:
        service.getChargeCounter(new HealthServiceWrapperHidl$$ExternalSyntheticLambda1(outResult, prop));     // Catch: Throwable -> L9
    L16:
        int r2 = outResult.value;     // Catch: Throwable -> L9
        traceEnd();
        return r2;
    L20:
        throw new RemoteException("no health service");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        traceEnd();
        throw th;
    }

    private static /* synthetic */ void lambda$getProperty$0(MutableInt outResult, BatteryProperty prop, int result, int value) {
        outResult.value = result;
        if (result != 0) goto L6;
        prop.setLong(value);
        return;
    }

    private static /* synthetic */ void lambda$getProperty$1(MutableInt outResult, BatteryProperty prop, int result, int value) {
        outResult.value = result;
        if (result != 0) goto L6;
        prop.setLong(value);
        return;
    }

    private static /* synthetic */ void lambda$getProperty$2(MutableInt outResult, BatteryProperty prop, int result, int value) {
        outResult.value = result;
        if (result != 0) goto L6;
        prop.setLong(value);
        return;
    }

    private static /* synthetic */ void lambda$getProperty$3(MutableInt outResult, BatteryProperty prop, int result, int value) {
        outResult.value = result;
        if (result != 0) goto L6;
        prop.setLong(value);
        return;
    }

    private static /* synthetic */ void lambda$getProperty$4(MutableInt outResult, BatteryProperty prop, int result, int value) {
        outResult.value = result;
        if (result != 0) goto L6;
        prop.setLong(value);
        return;
    }

    private static /* synthetic */ void lambda$getProperty$5(MutableInt outResult, BatteryProperty prop, int result, long value) {
        outResult.value = result;
        if (result != 0) goto L6;
        prop.setLong(value);
        return;
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public void scheduleUpdate() throws RemoteException {
        getHandlerThread().getThreadHandler().post(new HealthServiceWrapperHidl$$ExternalSyntheticLambda7(this));
    }

    private /* synthetic */ void lambda$scheduleUpdate$6() {
        traceBegin("HealthScheduleUpdate");
        IHealth service = this.mLastService.get();     // Catch: Throwable -> L8 RemoteException -> L10
        if (service != null) goto L12;
        Slog.e(TAG, "no health service");     // Catch: Throwable -> L8 RemoteException -> L10
        traceEnd();
        return;
    L12:
        service.update();     // Catch: Throwable -> L8 RemoteException -> L10
    L13:
        traceEnd();
        return;
    L10:
        ex = move-exception;
        Slog.e(TAG, "Cannot call update on health HAL", ex);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        traceEnd();
        throw th;
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public android.hardware.health.HealthInfo getHealthInfo() throws RemoteException {
        IHealth service = this.mLastService.get();
        HealthServiceWrapperHidlIA r1 = null;
        if (service != null) goto L5;
        return null;
    L5:
        final Mutable<android.hardware.health.HealthInfo> ret = new Mutable(r1);
        service.getHealthInfo(new HealthServiceWrapperHidl$$ExternalSyntheticLambda0(ret));
        return ret.value;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.hardware.health.HealthInfo] */
    private static /* synthetic */ void lambda$getHealthInfo$7(Mutable ret, int result, HealthInfo value) {
        if (result != 0) goto L5;
        ret.value = Translate.h2aTranslate(value.legacy);
        return;
    }

    HealthServiceWrapperHidl(Callback callback, IServiceManagerSupplier managerSupplier, IHealthSupplier healthSupplier) throws RemoteException, NoSuchElementException, NullPointerException {
        this.mNotification = new Notification(this, null);
        this.mHandlerThread = new HandlerThread("HealthServiceHwbinder");
        this.mLastService = new AtomicReference();
        if (managerSupplier == null) goto L31;
        if (healthSupplier == null) goto L31;
        this.mHealthSupplier = healthSupplier;
        IHealth newService = null;
        traceBegin("HealthInitGetService_default");
        newService = healthSupplier.get("default");     // Catch: Throwable -> L9 NoSuchElementException -> L12
        goto L8
    L9:
        th = move-exception;
        traceEnd();
        throw th;
    L8:
        traceEnd();
        if (newService == null) goto L17;
        this.mInstanceName = "default";
        this.mLastService.set(newService);
    L17:
        if (this.mInstanceName == null) goto L29;
        if (newService == null) goto L29;
        if (callback == null) goto L21;
        this.mCallback = callback;
        this.mCallback.onRegistration(null, newService, this.mInstanceName);
    L21:
        traceBegin("HealthInitRegisterNotification");
        this.mHandlerThread.start();
        managerSupplier.get().registerForNotifications(IHealth.kInterfaceName, this.mInstanceName, this.mNotification);     // Catch: Throwable -> L25
        traceEnd();
        Slog.i(TAG, "health: HealthServiceWrapper listening to instance " + this.mInstanceName);
        return;
    L25:
        th = move-exception;
        traceEnd();
        throw th;
    L29:
        throw new NoSuchElementException(String.format("IHealth service instance %s isn't available. Perhaps no permission?", new Object[]{"default"}));
    L31:
        throw new NullPointerException();
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public HandlerThread getHandlerThread() {
        return this.mHandlerThread;
    }
}
