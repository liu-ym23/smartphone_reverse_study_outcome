package com.android.server.timezonedetector.location;

import android.util.IndentingPrintWriter;
import java.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
class BinderLocationTimeZoneProvider extends LocationTimeZoneProvider {
    private final LocationTimeZoneProviderProxy mProxy;

    /* JADX INFO: renamed from: -$$Nest$mhandleOnProviderBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8599$$Nest$mhandleOnProviderBound(BinderLocationTimeZoneProvider r0) {
        r0.handleOnProviderBound();
    }

    BinderLocationTimeZoneProvider(LocationTimeZoneProvider.ProviderMetricsLogger providerMetricsLogger, ThreadingDomain threadingDomain, String providerName, LocationTimeZoneProviderProxy proxy, boolean recordStateChanges) {
        super(providerMetricsLogger, threadingDomain, providerName, new ZoneInfoDbTimeZoneProviderEventPreProcessor(), recordStateChanges);
        proxy.getClass();
        this.mProxy = proxy;
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    boolean onInitialize() {
        this.mProxy.initialize(new AnonymousClass1(this));
        return true;
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    void onDestroy() {
        this.mProxy.destroy();
    }

    private void handleOnProviderBound() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        LocationTimeZoneProvider.ProviderState currentState = this.mCurrentState.get();     // Catch: Throwable -> L8
        switch(currentState.stateEnum) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            default: goto L7;
        };     // Catch: Throwable -> L8
    L10:
        LocationTimeZoneManagerService.debugLog("handleOnProviderBound, mProviderName=" + this.mProviderName + ", currentState=" + currentState + ": No state change required, provider is terminated.");     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        LocationTimeZoneManagerService.debugLog("handleOnProviderBound mProviderName=" + this.mProviderName + ", currentState=" + currentState + ": Provider is stopped.");     // Catch: Throwable -> L8
        goto L13
    L12:
        LocationTimeZoneManagerService.debugLog("handleOnProviderBound mProviderName=" + this.mProviderName + ", currentState=" + currentState + ": Provider is started.");     // Catch: Throwable -> L8
        goto L13
    L7:
        throw new IllegalStateException("Unknown currentState=" + currentState);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    void onStartUpdates(Duration initializationTimeout, Duration eventFilteringAgeThreshold) {
        TimeZoneProviderRequest request = TimeZoneProviderRequest.createStartUpdatesRequest(initializationTimeout, eventFilteringAgeThreshold);
        this.mProxy.setRequest(request);
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    void onStopUpdates() {
        TimeZoneProviderRequest request = TimeZoneProviderRequest.createStopUpdatesRequest();
        this.mProxy.setRequest(request);
    }

    @Override // com.android.server.timezonedetector.Dumpable
    public void dump(IndentingPrintWriter ipw, String[] args) {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ipw.println("{BinderLocationTimeZoneProvider}");     // Catch: Throwable -> L7
        ipw.println("mProviderName=" + this.mProviderName);     // Catch: Throwable -> L7
        ipw.println("mCurrentState=" + this.mCurrentState);     // Catch: Throwable -> L7
        ipw.println("mProxy=" + this.mProxy);     // Catch: Throwable -> L7
        ipw.println("State history:");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        this.mCurrentState.dump(ipw);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        ipw.println("Proxy details:");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        this.mProxy.dump(ipw, args);     // Catch: Throwable -> L7
        ipw.decreaseIndent();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        String r1 = "BinderLocationTimeZoneProvider{mProviderName=" + this.mProviderName + ", mCurrentState=" + this.mCurrentState + ", mProxy=" + this.mProxy + '}';     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
