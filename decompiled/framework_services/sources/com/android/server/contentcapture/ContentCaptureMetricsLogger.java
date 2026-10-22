package com.android.server.contentcapture;

import android.content.ComponentName;
import android.content.ContentCaptureOptions;
import android.service.contentcapture.FlushMetrics;
import com.android.internal.util.FrameworkStatsLog;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ContentCaptureMetricsLogger {
    private ContentCaptureMetricsLogger() {
    }

    public static void writeServiceEvent(int eventType, String serviceName) {
        FrameworkStatsLog.write(207, eventType, serviceName, null, 0, 0);
    }

    public static void writeServiceEvent(int eventType, ComponentName service) {
        writeServiceEvent(eventType, ComponentName.flattenToShortString(service));
    }

    public static void writeSetWhitelistEvent(ComponentName service, List<String> packages, List<ComponentName> activities) {
        String serviceName = ComponentName.flattenToShortString(service);
        int r0 = 0;
        if (packages == null) goto L5;
        int packageCount = packages.size();
    L6:
        if (activities == null) goto L8;
        r0 = activities.size();
    L8:
        int activityCount = r0;
        FrameworkStatsLog.write(207, 3, serviceName, null, packageCount, activityCount);
        return;
    L5:
        packageCount = 0;
        goto L6
    }

    public static void writeSessionEvent(int sessionId, int event, int flags, ComponentName service, boolean isChildSession) {
        FrameworkStatsLog.write(208, sessionId, event, flags, ComponentName.flattenToShortString(service), null, isChildSession);
    }

    public static void writeSessionFlush(int sessionId, ComponentName service, FlushMetrics fm, ContentCaptureOptions options, int flushReason) {
        FrameworkStatsLog.write(209, sessionId, ComponentName.flattenToShortString(service), null, fm.sessionStarted, fm.sessionFinished, fm.viewAppearedCount, fm.viewDisappearedCount, fm.viewTextChangedCount, options.maxBufferSize, options.idleFlushingFrequencyMs, options.textChangeFlushingFrequencyMs, flushReason);
    }
}
