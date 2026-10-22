package com.android.server.timezonedetector;

import android.os.Handler;
import android.os.SystemClock;
import android.os.SystemProperties;
import com.android.server.AlarmManagerInternal;
import com.android.server.LocalServices;
import com.android.server.SystemTimeZone;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
final class EnvironmentImpl implements Environment {
    private static final String TIMEZONE_PROPERTY = "persist.sys.timezone";
    private final Handler mHandler;

    EnvironmentImpl(Handler handler) {
        handler.getClass();
        this.mHandler = handler;
    }

    @Override // com.android.server.timezonedetector.Environment
    public String getDeviceTimeZone() {
        return SystemProperties.get(TIMEZONE_PROPERTY);
    }

    @Override // com.android.server.timezonedetector.Environment
    public int getDeviceTimeZoneConfidence() {
        return SystemTimeZone.getTimeZoneConfidence();
    }

    @Override // com.android.server.timezonedetector.Environment
    public void setDeviceTimeZoneAndConfidence(String zoneId, int confidence, String logInfo) {
        AlarmManagerInternal alarmManagerInternal = (AlarmManagerInternal) LocalServices.getService(AlarmManagerInternal.class);
        alarmManagerInternal.setTimeZone(zoneId, confidence, logInfo);
    }

    @Override // com.android.server.timezonedetector.Environment
    public long elapsedRealtimeMillis() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.android.server.timezonedetector.Environment
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    @Override // com.android.server.timezonedetector.Environment
    public void addDebugLogEntry(String logMsg) {
        SystemTimeZone.addDebugLogEntry(logMsg);
    }

    @Override // com.android.server.timezonedetector.Environment
    public void dumpDebugLog(PrintWriter printWriter) {
        SystemTimeZone.dump(printWriter);
    }

    @Override // com.android.server.timezonedetector.Environment
    public void runAsync(Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
