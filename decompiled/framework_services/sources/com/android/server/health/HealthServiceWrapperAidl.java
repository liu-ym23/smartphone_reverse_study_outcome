package com.android.server.health;

import android.hardware.health.BatteryHealthData;
import android.hardware.health.HealthInfo;
import android.hardware.health.IHealth;
import android.os.BatteryProperty;
import android.os.Binder;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IServiceCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ServiceSpecificException;
import android.os.Trace;
import android.pico.utils.ExtImplFactory;
import android.util.Slog;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class HealthServiceWrapperAidl extends HealthServiceWrapper {
    static final String SERVICE_NAME = null;
    private static final String TAG = "HealthServiceWrapperAidl";
    private IExtHealthServiceWrapperAidl mExt;
    private final HandlerThread mHandlerThread;
    private final AtomicReference<IHealth> mLastService;
    private final HealthRegCallbackAidl mRegCallback;
    private final IServiceCallback mServiceCallback;

    private class ServiceCallback extends IServiceCallback.Stub {
        final /* synthetic */ HealthServiceWrapperAidl this$0;

        /* JADX INFO: renamed from: $r8$lambda$G_xjW-zTuBz0FJQbymKloWh0CU8, reason: not valid java name */
        public static /* synthetic */ void m4439$r8$lambda$G_xjWzTuBz0FJQbymKloWh0CU8(ServiceCallback r0, IBinder r1) {
            r0.lambda$onRegistration$0(r1);
        }

        /* synthetic */ ServiceCallback(HealthServiceWrapperAidl r1, HealthServiceWrapperAidlIA r2) {
            this(r1);
        }

        private ServiceCallback(HealthServiceWrapperAidl r1) {
            this.this$0 = r1;
        }

        public void onRegistration(String name, final IBinder newBinder) throws RemoteException {
            if (HealthServiceWrapperAidl.SERVICE_NAME.equals(name) == true) goto L5;
            return;
        L5:
            this.this$0.getHandlerThread().getThreadHandler().post(new HealthServiceWrapperAidl$ServiceCallback$$ExternalSyntheticLambda0(this, newBinder));
        }

        private /* synthetic */ void lambda$onRegistration$0(IBinder newBinder) {
            IHealth newService = IHealth.Stub.asInterface(Binder.allowBlocking(newBinder));
            IHealth oldService = (IHealth) HealthServiceWrapperAidl.m4437$$Nest$fgetmLastService(this.this$0).getAndSet(newService);
            if (oldService == null) goto L5;
            IBinder oldBinder = oldService.asBinder();
        L7:
            if (Objects.equals(newBinder, oldBinder) == false) goto L9;
            return;
        L9:
            Slog.i(HealthServiceWrapperAidl.TAG, "New health AIDL HAL service registered");
            if (HealthServiceWrapperAidl.m4438$$Nest$fgetmRegCallback(this.this$0) == null) goto L13;
            HealthServiceWrapperAidl.m4438$$Nest$fgetmRegCallback(this.this$0).onRegistration(oldService, newService);
            return;
        L13:
            return;
        L5:
            oldBinder = null;
            goto L7
        }
    }

    interface ServiceManagerStub {
        default IHealth waitForDeclaredService(String name) {
            return IHealth.Stub.asInterface(ServiceManager.waitForDeclaredService(name));
        }

        default void registerForNotifications(String name, IServiceCallback callback) throws RemoteException {
            ServiceManager.registerForNotifications(name, callback);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-oplhFZ3XbYCRctwu9K5sMMyz8U, reason: not valid java name */
    public static /* synthetic */ void m4436$r8$lambda$oplhFZ3XbYCRctwu9K5sMMyz8U(HealthServiceWrapperAidl r0) {
        r0.lambda$scheduleUpdate$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastService, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicReference m4437$$Nest$fgetmLastService(HealthServiceWrapperAidl r0) {
        return r0.mLastService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRegCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ HealthRegCallbackAidl m4438$$Nest$fgetmRegCallback(HealthServiceWrapperAidl r0) {
        return r0.mRegCallback;
    }

    static {
        SERVICE_NAME = IHealth.DESCRIPTOR + "/default";
    }

    HealthServiceWrapperAidl(HealthRegCallbackAidl regCallback, ServiceManagerStub serviceManager) throws RemoteException, NoSuchElementException {
        this.mHandlerThread = new HandlerThread("HealthServiceBinder");
        this.mLastService = new AtomicReference();
        this.mServiceCallback = new ServiceCallback(this, null);
        this.mExt = (IExtHealthServiceWrapperAidl) ExtImplFactory.getImpl(IExtHealthServiceWrapperAidl.class, new Object[]{this});
        traceBegin("HealthInitGetServiceAidl");
        IHealth newService = serviceManager.waitForDeclaredService(SERVICE_NAME);     // Catch: Throwable -> L18
        traceEnd();
        if (newService == null) goto L17;
        this.mLastService.set(newService);
        this.mRegCallback = regCallback;
        if (this.mRegCallback == null) goto L9;
        this.mRegCallback.onRegistration(null, newService);
    L9:
        traceBegin("HealthInitRegisterNotificationAidl");
        this.mHandlerThread.start();
        serviceManager.registerForNotifications(SERVICE_NAME, this.mServiceCallback);     // Catch: Throwable -> L13
        traceEnd();
        Slog.i(TAG, "health: HealthServiceWrapper listening to AIDL HAL");
        return;
    L13:
        th = move-exception;
        traceEnd();
        throw th;
    L17:
        throw new NoSuchElementException("IHealth service instance isn't available. Perhaps no permission?");
    L18:
        th = move-exception;
        traceEnd();
        throw th;
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public HandlerThread getHandlerThread() {
        return this.mHandlerThread;
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public int getProperty(int id, BatteryProperty prop) throws RemoteException {
        traceBegin("HealthGetPropertyAidl");
        int r0 = getPropertyInternal(id, prop);     // Catch: Throwable -> L6
        traceEnd();
        return r0;
    L6:
        th = move-exception;
        traceEnd();
        throw th;
    }

    private int getPropertyInternal(int id, BatteryProperty prop) throws RemoteException {
        IHealth service = this.mLastService.get();
        if (service == null) goto L30;
        switch(id) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L6;
            default: goto L34;
        };
    L6:
        this.mExt.setSohProp(prop);     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
    L31:
        return 0;
    L11:
        BatteryHealthData healthData = service.getBatteryHealthData();     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        prop.setLong(healthData.batteryPartStatus);     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L12:
        BatteryHealthData healthData2 = service.getBatteryHealthData();     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        prop.setString(healthData2.batterySerialNumber);     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L13:
        BatteryHealthData healthData3 = service.getBatteryHealthData();     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        prop.setLong(healthData3.batteryStateOfHealth);     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L14:
        prop.setLong(service.getChargingPolicy());     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L15:
        BatteryHealthData healthData4 = service.getBatteryHealthData();     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        prop.setLong(healthData4.batteryFirstUsageSeconds);     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L16:
        BatteryHealthData healthData5 = service.getBatteryHealthData();     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        prop.setLong(healthData5.batteryManufacturingDateSeconds);     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L17:
        prop.setLong(service.getChargeStatus());     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L18:
        prop.setLong(service.getEnergyCounterNwh());     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L19:
        prop.setLong(service.getCapacity());     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L20:
        prop.setLong(service.getCurrentAverageMicroamps());     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L21:
        prop.setLong(service.getCurrentNowMicroamps());     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L22:
        prop.setLong(service.getChargeCounterUah());     // Catch: ServiceSpecificException -> L7 UnsupportedOperationException -> L9
        goto L31
    L34:
        return 0;
    L25:
        return -2;
    L27:
        return -1;
    L30:
        throw new RemoteException("no health service");
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public void scheduleUpdate() throws RemoteException {
        getHandlerThread().getThreadHandler().post(new HealthServiceWrapperAidl$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$scheduleUpdate$0() {
        traceBegin("HealthScheduleUpdate");
        IHealth service = this.mLastService.get();     // Catch: Throwable -> L8 Throwable -> L10
        if (service != null) goto L12;
        Slog.e(TAG, "no health service");     // Catch: Throwable -> L8 Throwable -> L10
        traceEnd();
        return;
    L12:
        service.update();     // Catch: Throwable -> L8 Throwable -> L10 Throwable -> L10
    L13:
        traceEnd();
        return;
    L8:
        th = move-exception;
        traceEnd();
        throw th;
    L10:
        ex = move-exception;
        Slog.e(TAG, "Cannot call update on health AIDL HAL", ex);     // Catch: Throwable -> L8
        goto L13
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public HealthInfo getHealthInfo() throws RemoteException {
        IHealth service = this.mLastService.get();
        if (service != null) goto L9;
        return null;
    L9:
        return service.getHealthInfo();
    L8:
        return null;
    }

    @Override // com.android.server.health.HealthServiceWrapper
    public BatteryHealthData getBatteryHealthData() throws RemoteException {
        IHealth service = this.mLastService.get();
        if (service != null) goto L9;
        return null;
    L9:
        return service.getBatteryHealthData();
    L8:
        return null;
    }

    public void setChargingPolicy(int policy) throws RemoteException {
        IHealth service = this.mLastService.get();
        if (service != null) goto L9;
        return;
    L9:
        service.setChargingPolicy(policy);     // Catch: Throwable -> L7
        return;
    }

    private static void traceBegin(String name) {
        Trace.traceBegin(524288, name);
    }

    private static void traceEnd() {
        Trace.traceEnd(524288);
    }

    public IExtHealthServiceWrapperAidl getExtImpl() {
        return this.mExt;
    }
}
