package com.android.server.timezonedetector.location;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.timezone.ITimeZoneProvider;
import android.service.timezone.ITimeZoneProviderManager;
import android.service.timezone.TimeZoneProviderEvent;
import android.util.IndentingPrintWriter;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;

/* JADX INFO: loaded from: classes3.dex */
class RealLocationTimeZoneProviderProxy extends LocationTimeZoneProviderProxy implements ServiceWatcher.ServiceListener<CurrentUserServiceSupplier.BoundServiceInfo> {
    private ManagerProxy mManagerProxy;
    private TimeZoneProviderRequest mRequest;
    private final ServiceWatcher mServiceWatcher;

    private class ManagerProxy extends ITimeZoneProviderManager.Stub {
        final /* synthetic */ RealLocationTimeZoneProviderProxy this$0;

        /* synthetic */ ManagerProxy(RealLocationTimeZoneProviderProxy r1, RealLocationTimeZoneProviderProxyIA r2) {
            this(r1);
        }

        private ManagerProxy(RealLocationTimeZoneProviderProxy r1) {
            this.this$0 = r1;
        }

        public void onTimeZoneProviderEvent(TimeZoneProviderEvent event) {
            Object r0 = this.this$0.mSharedLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (RealLocationTimeZoneProviderProxy.m8617$$Nest$fgetmManagerProxy(this.this$0) == this) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.this$0.handleTimeZoneProviderEvent(event);
        }
    }

    public static /* synthetic */ void $r8$lambda$4vgil4rrYuVP86P309KGTDwoonM(TimeZoneProviderRequest r0, ManagerProxy r1, IBinder r2) {
        lambda$trySendCurrentRequest$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmManagerProxy, reason: not valid java name */
    static /* bridge */ /* synthetic */ ManagerProxy m8617$$Nest$fgetmManagerProxy(RealLocationTimeZoneProviderProxy r0) {
        return r0.mManagerProxy;
    }

    public /* bridge */ /* synthetic */ void onBind(IBinder r1, ServiceWatcher.BoundServiceInfo r2) throws RemoteException {
        onBind(r1, (CurrentUserServiceSupplier.BoundServiceInfo) r2);
    }

    RealLocationTimeZoneProviderProxy(Context context, Handler handler, ThreadingDomain threadingDomain, String action, String providerPackageName, boolean isTestProvider) {
        super(context, threadingDomain);
        this.mManagerProxy = null;
        this.mRequest = TimeZoneProviderRequest.createStopUpdatesRequest();
        providerPackageName.getClass();
        if (isTestProvider == false) goto L5;
        CurrentUserServiceSupplier serviceSupplier = CurrentUserServiceSupplier.createUnsafeForTestsOnly(context, action, providerPackageName, "android.permission.BIND_TIME_ZONE_PROVIDER_SERVICE", null);
    L6:
        this.mServiceWatcher = ServiceWatcher.create(context, handler, "RealLocationTimeZoneProviderProxy", serviceSupplier, this);
        return;
    L5:
        serviceSupplier = CurrentUserServiceSupplier.create(context, action, providerPackageName, "android.permission.BIND_TIME_ZONE_PROVIDER_SERVICE", "android.permission.INSTALL_LOCATION_TIME_ZONE_PROVIDER_SERVICE");
        goto L6
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderProxy
    void onInitialize() {
        if (register() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Unable to register binder proxy");
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderProxy
    void onDestroy() {
        this.mServiceWatcher.unregister();
    }

    private boolean register() {
        boolean resolves = this.mServiceWatcher.checkServiceResolves();
        if (resolves == false) goto L5;
        this.mServiceWatcher.register();
    L5:
        return resolves;
    }

    public void onBind(IBinder binder, CurrentUserServiceSupplier.BoundServiceInfo boundService) {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        this.mManagerProxy = new ManagerProxy(this, null);     // Catch: Throwable -> L7
        this.mListener.onProviderBound();     // Catch: Throwable -> L7
        trySendCurrentRequest();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onUnbind() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        this.mManagerProxy = null;     // Catch: Throwable -> L8
        this.mListener.onProviderUnbound();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderProxy
    final void setRequest(TimeZoneProviderRequest request) {
        this.mThreadingDomain.assertCurrentThread();
        request.getClass();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        this.mRequest = request;     // Catch: Throwable -> L7
        trySendCurrentRequest();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void trySendCurrentRequest() {
        final ManagerProxy managerProxy = this.mManagerProxy;
        final TimeZoneProviderRequest request = this.mRequest;
        this.mServiceWatcher.runOnBinder(new RealLocationTimeZoneProviderProxy$$ExternalSyntheticLambda0(request, managerProxy));
    }

    private static /* synthetic */ void lambda$trySendCurrentRequest$0(TimeZoneProviderRequest request, ManagerProxy managerProxy, IBinder binder) throws RemoteException {
        ITimeZoneProvider service = ITimeZoneProvider.Stub.asInterface(binder);
        if (request.sendUpdates() == false) goto L5;
        service.startUpdates(managerProxy, request.getInitializationTimeout().toMillis(), request.getEventFilteringAgeThreshold().toMillis());
        return;
    L5:
        service.stopUpdates();
    }

    @Override // com.android.server.timezonedetector.Dumpable
    public void dump(IndentingPrintWriter ipw, String[] args) {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ipw.println("{RealLocationTimeZoneProviderProxy}");     // Catch: Throwable -> L7
        ipw.println("mRequest=" + this.mRequest);     // Catch: Throwable -> L7
        this.mServiceWatcher.dump(ipw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
