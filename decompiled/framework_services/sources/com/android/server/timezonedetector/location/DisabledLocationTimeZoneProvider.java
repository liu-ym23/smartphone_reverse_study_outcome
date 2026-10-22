package com.android.server.timezonedetector.location;

import android.service.timezone.TimeZoneProviderEvent;
import android.util.IndentingPrintWriter;
import java.time.Duration;

/* JADX INFO: loaded from: classes3.dex */
class DisabledLocationTimeZoneProvider extends LocationTimeZoneProvider {
    public static /* synthetic */ TimeZoneProviderEvent $r8$lambda$Fzbb6rSsQ_Ef7uE6__kJVVCcskE(TimeZoneProviderEvent r0) {
        return lambda$new$0(r0);
    }

    DisabledLocationTimeZoneProvider(LocationTimeZoneProvider.ProviderMetricsLogger providerMetricsLogger, ThreadingDomain threadingDomain, String providerName, boolean recordStateChanges) {
        super(providerMetricsLogger, threadingDomain, providerName, new DisabledLocationTimeZoneProvider$$ExternalSyntheticLambda0(), recordStateChanges);
    }

    private static /* synthetic */ TimeZoneProviderEvent lambda$new$0(TimeZoneProviderEvent x) {
        return x;
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    boolean onInitialize() {
        return false;
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    void onDestroy() {
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    void onStartUpdates(Duration initializationTimeout, Duration eventFilteringAgeThreshold) {
        throw new UnsupportedOperationException("Provider is disabled");
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider
    void onStopUpdates() {
        throw new UnsupportedOperationException("Provider is disabled");
    }

    @Override // com.android.server.timezonedetector.Dumpable
    public void dump(IndentingPrintWriter ipw, String[] args) {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        ipw.println("{DisabledLocationTimeZoneProvider}");     // Catch: Throwable -> L7
        ipw.println("mProviderName=" + this.mProviderName);     // Catch: Throwable -> L7
        ipw.println("mCurrentState=" + this.mCurrentState);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        String r1 = "DisabledLocationTimeZoneProvider{mProviderName=" + this.mProviderName + ", mCurrentState=" + this.mCurrentState + '}';     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
