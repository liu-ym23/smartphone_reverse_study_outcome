package com.android.server.pm;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.Pair;
import com.android.internal.util.IndentingPrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class SilentUpdatePolicy {
    private static final long SILENT_UPDATE_THROTTLE_TIME_MS = 0;
    private String mAllowUnlimitedSilentUpdatesInstaller;
    private final ArrayMap<Pair<String, String>, Long> mSilentUpdateInfos;
    private long mSilentUpdateThrottleTimeMs;

    public SilentUpdatePolicy() {
        this.mSilentUpdateInfos = new ArrayMap();
        this.mSilentUpdateThrottleTimeMs = SILENT_UPDATE_THROTTLE_TIME_MS;
    }

    static {
        SILENT_UPDATE_THROTTLE_TIME_MS = TimeUnit.SECONDS.toMillis(30);
    }

    public boolean isSilentUpdateAllowed(String installerPackageName, String packageName) {
        if (installerPackageName != null) goto L5;
        return true;
    L5:
        long lastSilentUpdatedMs = getTimestampMs(installerPackageName, packageName);
        ArrayMap<Pair<String, String>, Long> r3 = this.mSilentUpdateInfos;
        monitor-enter(r3);
        long throttleTimeMs = this.mSilentUpdateThrottleTimeMs;     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
        if ((SystemClock.uptimeMillis() - lastSilentUpdatedMs) > throttleTimeMs) goto L19;
        return false;
    L19:
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    public void track(String installerPackageName, String packageName) {
        if (installerPackageName != null) goto L4;
        return;
    L4:
        ArrayMap<Pair<String, String>, Long> r0 = this.mSilentUpdateInfos;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mAllowUnlimitedSilentUpdatesInstaller != null) goto L9;
    L14:
        long uptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        pruneLocked(uptime);     // Catch: Throwable -> L12
        Pair<String, String> key = Pair.create(installerPackageName, packageName);     // Catch: Throwable -> L12
        this.mSilentUpdateInfos.put(key, Long.valueOf(uptime));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        if (this.mAllowUnlimitedSilentUpdatesInstaller.equals(installerPackageName) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    void setAllowUnlimitedSilentUpdates(String installerPackageName) {
        ArrayMap<Pair<String, String>, Long> r0 = this.mSilentUpdateInfos;
        monitor-enter(r0);
        if (installerPackageName == null) goto L13;
    L8:
        this.mAllowUnlimitedSilentUpdatesInstaller = installerPackageName;     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    L13:
        this.mSilentUpdateInfos.clear();     // Catch: Throwable -> L6
        goto L8
    }

    void setSilentUpdatesThrottleTime(long throttleTimeInSeconds) {
        ArrayMap<Pair<String, String>, Long> r0 = this.mSilentUpdateInfos;
        monitor-enter(r0);
        if (throttleTimeInSeconds < 0) goto L9;
        long r1 = TimeUnit.SECONDS.toMillis(throttleTimeInSeconds);     // Catch: Throwable -> L7
    L10:
        this.mSilentUpdateThrottleTimeMs = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L9:
        r1 = SILENT_UPDATE_THROTTLE_TIME_MS;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void pruneLocked(long uptime) {
        int size = this.mSilentUpdateInfos.size();
        int i = size - 1;
    L3:
        if (i < 0) goto L9;
        long lastSilentUpdatedMs = this.mSilentUpdateInfos.valueAt(i).longValue();
        if ((uptime - lastSilentUpdatedMs) <= this.mSilentUpdateThrottleTimeMs) goto L7;
        this.mSilentUpdateInfos.removeAt(i);
    L7:
        i = i - 1;
        goto L3
    }

    private long getTimestampMs(String installerPackageName, String packageName) {
        Pair<String, String> key = Pair.create(installerPackageName, packageName);
        ArrayMap<Pair<String, String>, Long> r1 = this.mSilentUpdateInfos;
        monitor-enter(r1);
        Long timestampMs = this.mSilentUpdateInfos.get(key);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (timestampMs != null) goto L15;
        return -1;
    L15:
        return timestampMs.longValue();
    L10:
        th = move-exception;
        throw th;
    }

    void dump(IndentingPrintWriter pw) {
        ArrayMap<Pair<String, String>, Long> r0 = this.mSilentUpdateInfos;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mSilentUpdateInfos.isEmpty() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        pw.println("Last silent updated Infos:");     // Catch: Throwable -> L8
        pw.increaseIndent();     // Catch: Throwable -> L8
        int size = this.mSilentUpdateInfos.size();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= size) goto L17;
        Pair<String, String> key = this.mSilentUpdateInfos.keyAt(i);     // Catch: Throwable -> L8
        if (key == null) goto L16;
        pw.printPair("installerPackageName", key.first);     // Catch: Throwable -> L8
        pw.printPair("packageName", key.second);     // Catch: Throwable -> L8
        pw.printPair("silentUpdatedMillis", this.mSilentUpdateInfos.valueAt(i));     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
    L16:
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L17:
        pw.decreaseIndent();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }
}
