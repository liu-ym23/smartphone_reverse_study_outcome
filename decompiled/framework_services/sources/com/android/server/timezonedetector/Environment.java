package com.android.server.timezonedetector;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public interface Environment {
    void addDebugLogEntry(String r1);

    long currentTimeMillis();

    void dumpDebugLog(PrintWriter r1);

    long elapsedRealtimeMillis();

    String getDeviceTimeZone();

    int getDeviceTimeZoneConfidence();

    void runAsync(Runnable r1);

    void setDeviceTimeZoneAndConfidence(String r1, int r2, String r3);
}
