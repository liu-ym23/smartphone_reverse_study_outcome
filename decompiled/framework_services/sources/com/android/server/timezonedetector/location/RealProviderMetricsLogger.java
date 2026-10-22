package com.android.server.timezonedetector.location;

import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes3.dex */
final class RealProviderMetricsLogger implements LocationTimeZoneProvider.ProviderMetricsLogger {
    private final int mProviderIndex;

    RealProviderMetricsLogger(int providerIndex) {
        this.mProviderIndex = providerIndex;
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProvider.ProviderMetricsLogger
    public void onProviderStateChanged(int stateEnum) {
        FrameworkStatsLog.write(FrameworkStatsLog.LOCATION_TIME_ZONE_PROVIDER_STATE_CHANGED, this.mProviderIndex, metricsProviderState(stateEnum));
    }

    private static int metricsProviderState(int stateEnum) {
        switch(stateEnum) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return 0;
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    }
}
