package com.android.server.timezonedetector.location;

import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes3.dex */
final class RealControllerMetricsLogger implements LocationTimeZoneProviderController.MetricsLogger {
    RealControllerMetricsLogger() {
    }

    @Override // com.android.server.timezonedetector.location.LocationTimeZoneProviderController.MetricsLogger
    public void onStateChange(String state) {
        FrameworkStatsLog.write(FrameworkStatsLog.LOCATION_TIME_ZONE_PROVIDER_CONTROLLER_STATE_CHANGED, metricsState(state));
    }

    private static int metricsState(String state) {
        switch(state.hashCode()) {
            case -1166336595: goto L27;
            case -468307734: goto L24;
            case 433141802: goto L21;
            case 478389753: goto L18;
            case 872357833: goto L15;
            case 1386911874: goto L12;
            case 1917201485: goto L9;
            case 2066319421: goto L6;
            default: goto L29;
        };
    L29:
        byte r0 = -1;
    L30:
        switch(r0) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L31;
        };
    L31:
        return 0;
    L32:
        return 7;
    L33:
        return 6;
    L34:
        return 5;
    L35:
        return 4;
    L36:
        return 3;
    L37:
        return 2;
    L38:
        return 1;
    L6:
        if (state.equals("FAILED") == false) goto L29;
        r0 = 6;
        goto L30
    L9:
        if (state.equals("INITIALIZING") == false) goto L29;
        r0 = 2;
        goto L30
    L12:
        if (state.equals("CERTAIN") == false) goto L29;
        r0 = 3;
        goto L30
    L15:
        if (state.equals("UNCERTAIN") == false) goto L29;
        r0 = 4;
        goto L30
    L18:
        if (state.equals("DESTROYED") == false) goto L29;
        r0 = 5;
        goto L30
    L21:
        if (state.equals("UNKNOWN") == false) goto L29;
        r0 = 7;
        goto L30
    L24:
        if (state.equals("PROVIDERS_INITIALIZING") == false) goto L29;
        r0 = 0;
        goto L30
    L27:
        if (state.equals("STOPPED") == false) goto L29;
        r0 = 1;
        goto L30
    }
}
