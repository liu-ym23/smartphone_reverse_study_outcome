package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoSysEx;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Slog;
import android.view.RemoteAnimationAdapter;
import com.android.server.ISysPerfMonitorService;
import com.android.server.SysOptBridge;
import com.android.server.am.ProcessRecord;
import com.android.server.utils.TimingsTraceAndSlog;
import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityMetricsLoggerSmtBase {
    private static final String PROP_ENABLE = "persist.sys.tryDoUfsBoost.enable";
    private static final String REPORT_LOG_ENABLE = "persist.sys.report_activity_metrics_log.enable";
    private static final int SPLASH_SCREEN_HOLD_ON_THRESHOLD = 500;
    protected static final String TAG = "ActivityMetricsLoggerSmtBase";
    private static final int UFS_BOOST_MAX_TRIGGER_COUNT = 2;
    private static final long UFS_BOOST_RATE_LIMIT_WINDOW_MS = 1000;
    private static final String WRITE_NODE = "/sys/class/scsi_host/host0/../../../ufs_boost/ufs_boost";
    private static boolean sReportActivityMetrics;
    private static boolean sTryDoUfsBoostEnable;
    protected ActivityMetricsLogger mHolder;
    private final ArrayDeque<Long> mUfsBoostTriggerTimesMs;

    static {
        sTryDoUfsBoostEnable = SystemProperties.getBoolean(PROP_ENABLE, true);
        sReportActivityMetrics = SystemProperties.getBoolean(REPORT_LOG_ENABLE, true);
    }

    protected ActivityMetricsLoggerSmtBase(ActivityMetricsLogger aml) {
        this.mUfsBoostTriggerTimesMs = new ArrayDeque(2);
        this.mHolder = aml;
    }

    public void tryDoUfsBoost(String duration) {
        if (sTryDoUfsBoostEnable == true) goto L5;
        return;
    L5:
        long now = SystemClock.elapsedRealtime();
        ArrayDeque<Long> r2 = this.mUfsBoostTriggerTimesMs;
        monitor-enter(r2);
    L24:
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mUfsBoostTriggerTimesMs.isEmpty() == true) goto L15;
        if ((now - this.mUfsBoostTriggerTimesMs.peekFirst().longValue()) < 1000) goto L15;
        this.mUfsBoostTriggerTimesMs.removeFirst();     // Catch: Throwable -> L12
    L15:
        if (this.mUfsBoostTriggerTimesMs.size() < 2) goto L18;
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L18:
        this.mUfsBoostTriggerTimesMs.addLast(Long.valueOf(now));     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        TimingsTraceAndSlog t = new TimingsTraceAndSlog();
        t.traceBegin("tryDoUfsBoost duration:" + duration);
        Process.writeToSpecificNode(2, WRITE_NODE, duration);
        t.traceEnd();
    }

    public void reportWindowsDrawn(int sysPerfLaunchType, ActivityOptions options, boolean prefetchEffect, ActivityRecord lastLaunchedActivity, long transitionStartTime, long windowsDrawnTime) {
        if (options == null) goto L39;
        if (lastLaunchedActivity == null) goto L39;
        if (transitionStartTime == 0) goto L39;
        if (windowsDrawnTime == 0) goto L39;
        if (sysPerfLaunchType == 0) goto L43;
        RemoteAnimationAdapter adapter = options.getRemoteAnimationAdapter();
        if (adapter == null) goto L37;
        if (adapter.getDuration() <= 0) goto L42;
        String packageName = lastLaunchedActivity.packageName;
        if (lastLaunchedActivity.info != null) goto L19;
        String activityName = "";
    L20:
        long animStartTimeMillis = TimeUnit.NANOSECONDS.toMillis(transitionStartTime);
        long animEndTimeMillis = adapter.getDuration() + animStartTimeMillis;
        long windowDrawnTimeMillis = TimeUnit.NANOSECONDS.toMillis(windowsDrawnTime);
        long splashScreenHoldOnDuration = windowDrawnTimeMillis - animEndTimeMillis;
        if (splashScreenHoldOnDuration > 0) goto L23;
        return;
    L23:
        String startType = ISysPerfMonitorService.launchTypeToString(sysPerfLaunchType);
        boolean isSystemApp = SysOptBridge.getFactory().getAppRecordManagerService().isSystemAppByPkgName(packageName);
        if (sReportActivityMetrics == false) goto L35;
        if (isSystemApp == false) goto L27;
    L30:
        boolean shouldLog = true;
    L31:
        if (shouldLog == false) goto L41;
        Slog.d(TAG, "Splashscreen holdOnDuration: " + splashScreenHoldOnDuration + "ms, packageName: " + packageName + ", activityName: " + activityName + " startType: " + startType + ", prefetchEffect: " + prefetchEffect);
        return;
    L41:
        return;
    L27:
        if (splashScreenHoldOnDuration > 500) goto L30;
        shouldLog = false;
        goto L31
    L35:
        return;
    L19:
        activityName = lastLaunchedActivity.info.name;
        goto L20
    L42:
        return;
    L37:
        return;
    L43:
        return;
    }

    public void notifyWindowsDrawn(ApplicationInfo applicationInfo, WindowProcessController windowProcessController, int transitType, boolean prefetchEffect) {
        if (prefetchEffect == true) goto L14;
        if (applicationInfo == null) goto L15;
        if (windowProcessController == null) goto L16;
        boolean isSupportPerfWindowSyncGroup = applicationInfo.getSysEx().getFeatureFlags().get(ApplicationInfoSysEx.Feature.PERF_WINDOW_SYNC_GROUP.getBitIndex());
        if (isSupportPerfWindowSyncGroup == true) goto L9;
        return;
    L9:
        ProcessRecord processRecord = (ProcessRecord) windowProcessController.mOwner;
        if (processRecord != null) goto L12;
        return;
    L12:
        processRecord.notifyWindowsDrawn(transitType);
        return;
    L16:
        return;
    L15:
        return;
    }
}
