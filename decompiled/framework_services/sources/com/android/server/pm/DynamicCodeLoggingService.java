package com.android.server.pm;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.os.Process;
import android.util.EventLog;
import android.util.Log;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.art.DexUseManagerLocal;
import com.android.server.art.model.DexContainerFileUseInfo;
import com.android.server.pm.dex.DynamicCodeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.util.HexEncoding;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicCodeLoggingService extends JobService {
    private static final int AUDIT_AVC = 1400;
    private static final int AUDIT_WATCHING_JOB_ID = 203142925;
    private static final long AUDIT_WATCHING_PERIOD_MILLIS = 0;
    private static final String AVC_PREFIX = "type=1400 ";
    private static final boolean DEBUG = false;
    private static final Pattern EXECUTE_NATIVE_AUDIT_PATTERN = null;
    private static final int IDLE_LOGGING_JOB_ID = 2030028;
    private static final long IDLE_LOGGING_PERIOD_MILLIS = 0;
    private static final String TAG = null;
    private volatile boolean mAuditWatchingStopRequested;
    private volatile boolean mIdleLoggingStopRequested;

    private class AuditWatchingThread extends Thread {
        private final JobParameters mParams;
        final /* synthetic */ DynamicCodeLoggingService this$0;

        AuditWatchingThread(DynamicCodeLoggingService r1, JobParameters params) {
            this.this$0 = r1;
            super("DynamicCodeLoggingService_AuditWatchingJob");
            this.mParams = params;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (processAuditEvents() == false) goto L6;
            this.this$0.jobFinished(this.mParams, false);
            return;
        }

        private boolean processAuditEvents() {
            int[] tags = {EventLog.getTagCode("auditd")};     // Catch: Exception -> L13
            if (tags[0] != (-1)) goto L6;
            return true;
        L6:
            DynamicCodeLogger dynamicCodeLogger = DynamicCodeLoggingService.m6644$$Nest$smgetDynamicCodeLogger();     // Catch: Exception -> L13
            List<EventLog.Event> events = new ArrayList();     // Catch: Exception -> L13
            EventLog.readEvents(tags, events);     // Catch: Exception -> L13
            Matcher matcher = DynamicCodeLoggingService.m6642$$Nest$sfgetEXECUTE_NATIVE_AUDIT_PATTERN().matcher("");     // Catch: Exception -> L13
            int i = 0;
        L8:
            if (i >= events.size()) goto L33;
            if (DynamicCodeLoggingService.m6640$$Nest$fgetmAuditWatchingStopRequested(this.this$0) == true) goto L11;
            EventLog.Event event = events.get(i);     // Catch: Exception -> L13
            int uid = event.getUid();     // Catch: Exception -> L13
            if (Process.isApplicationUid(uid) == false) goto L31;
            Object data = event.getData();     // Catch: Exception -> L13
            if ((data instanceof String) == false) goto L31;
            String message = (String) data;     // Catch: Exception -> L13
            if (message.startsWith(DynamicCodeLoggingService.AVC_PREFIX) == false) goto L31;
            matcher.reset(message);     // Catch: Exception -> L13
            if (matcher.matches() == false) goto L31;
            String path = matcher.group(1);     // Catch: Exception -> L13
            if (path != null) goto L30;
            path = DynamicCodeLoggingService.m6646$$Nest$smunhex(matcher.group(2));     // Catch: Exception -> L13
        L30:
            dynamicCodeLogger.recordNative(uid, path);     // Catch: Exception -> L13
        L31:
            i = i + 1;
            goto L8
        L11:
            Log.w(DynamicCodeLoggingService.m6643$$Nest$sfgetTAG(), "Stopping AuditWatchingJob run at scheduler request");     // Catch: Exception -> L13
            return false;
        L33:
            return true;
        L13:
            e = move-exception;
            Log.e(DynamicCodeLoggingService.m6643$$Nest$sfgetTAG(), "AuditWatchingJob failed", e);
            return true;
        }
    }

    private class IdleLoggingThread extends Thread {
        private final JobParameters mParams;
        final /* synthetic */ DynamicCodeLoggingService this$0;

        IdleLoggingThread(DynamicCodeLoggingService r1, JobParameters params) {
            this.this$0 = r1;
            super("DynamicCodeLoggingService_IdleLoggingJob");
            this.mParams = params;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            DynamicCodeLogger dynamicCodeLogger = DynamicCodeLoggingService.m6644$$Nest$smgetDynamicCodeLogger();
            DynamicCodeLoggingService.m6645$$Nest$smsyncDataFromArtService(dynamicCodeLogger);
            Iterator<String> r1 = dynamicCodeLogger.getAllPackagesWithDynamicCodeLoading().iterator();
        L4:
            if (r1.hasNext() == false) goto L10;
            String packageName = r1.next();
            if (DynamicCodeLoggingService.m6641$$Nest$fgetmIdleLoggingStopRequested(this.this$0) == true) goto L7;
            dynamicCodeLogger.logDynamicCodeLoading(packageName);
            goto L4
        L7:
            Log.w(DynamicCodeLoggingService.m6643$$Nest$sfgetTAG(), "Stopping IdleLoggingJob run at scheduler request");
            return;
        L10:
            this.this$0.jobFinished(this.mParams, false);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuditWatchingStopRequested, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6640$$Nest$fgetmAuditWatchingStopRequested(DynamicCodeLoggingService r0) {
        return r0.mAuditWatchingStopRequested;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIdleLoggingStopRequested, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6641$$Nest$fgetmIdleLoggingStopRequested(DynamicCodeLoggingService r0) {
        return r0.mIdleLoggingStopRequested;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetEXECUTE_NATIVE_AUDIT_PATTERN, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pattern m6642$$Nest$sfgetEXECUTE_NATIVE_AUDIT_PATTERN() {
        return EXECUTE_NATIVE_AUDIT_PATTERN;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6643$$Nest$sfgetTAG() {
        return TAG;
    }

    /* JADX INFO: renamed from: -$$Nest$smgetDynamicCodeLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ DynamicCodeLogger m6644$$Nest$smgetDynamicCodeLogger() {
        return getDynamicCodeLogger();
    }

    /* JADX INFO: renamed from: -$$Nest$smsyncDataFromArtService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6645$$Nest$smsyncDataFromArtService(DynamicCodeLogger r0) {
        syncDataFromArtService(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smunhex, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6646$$Nest$smunhex(String r0) {
        return unhex(r0);
    }

    public DynamicCodeLoggingService() {
        this.mIdleLoggingStopRequested = false;
        this.mAuditWatchingStopRequested = false;
    }

    static {
        TAG = DynamicCodeLoggingService.class.getName();
        IDLE_LOGGING_PERIOD_MILLIS = TimeUnit.DAYS.toMillis(1);
        AUDIT_WATCHING_PERIOD_MILLIS = TimeUnit.HOURS.toMillis(2);
        EXECUTE_NATIVE_AUDIT_PATTERN = Pattern.compile(".*\\bavc: +granted +\\{ execute(?:_no_trans|) \\} .*\\bpath=(?:\"([^\" ]*)\"|([0-9A-F]+)) .*\\bscontext=u:r:untrusted_app(?:_25|_27)?:.*\\btcontext=u:object_r:app_data_file:.*\\btclass=file\\b.*");
    }

    public static void schedule(Context context) {
        ComponentName serviceName = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, DynamicCodeLoggingService.class.getName());
        JobScheduler js = (JobScheduler) context.getSystemService("jobscheduler");
        js.schedule(new JobInfo.Builder(IDLE_LOGGING_JOB_ID, serviceName).setRequiresDeviceIdle(true).setRequiresCharging(true).setPeriodic(IDLE_LOGGING_PERIOD_MILLIS).build());
        js.schedule(new JobInfo.Builder(AUDIT_WATCHING_JOB_ID, serviceName).setRequiresDeviceIdle(true).setRequiresBatteryNotLow(true).setPeriodic(AUDIT_WATCHING_PERIOD_MILLIS).build());
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters params) {
        int jobId = params.getJobId();
        switch(jobId) {
            case 2030028: goto L7;
            case 203142925: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        this.mAuditWatchingStopRequested = false;
        new AuditWatchingThread(this, params).start();
        return true;
    L7:
        this.mIdleLoggingStopRequested = false;
        new IdleLoggingThread(this, params).start();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        int jobId = params.getJobId();
        switch(jobId) {
            case 2030028: goto L8;
            case 203142925: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        this.mAuditWatchingStopRequested = true;
        return true;
    L8:
        this.mIdleLoggingStopRequested = true;
        return true;
    }

    private static DynamicCodeLogger getDynamicCodeLogger() {
        return ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getDynamicCodeLogger();
    }

    private static void syncDataFromArtService(DynamicCodeLogger dynamicCodeLogger) {
        DexUseManagerLocal dexUseManagerLocal = DexOptHelper.getDexUseManagerLocal();
        if (dexUseManagerLocal != null) goto L5;
        return;
    L5:
        PackageManagerLocal packageManagerLocal = (PackageManagerLocal) LocalManagerRegistry.getManager(PackageManagerLocal.class);
        packageManagerLocal.getClass();
        PackageManagerLocal.UnfilteredSnapshot snapshot = packageManagerLocal.withUnfilteredSnapshot();
        Iterator<String> r3 = snapshot.getPackageStates().keySet().iterator();     // Catch: Throwable -> L17
    L8:
        if (r3.hasNext() == false) goto L21;
        String owningPackageName = r3.next();     // Catch: Throwable -> L17
        Iterator r5 = dexUseManagerLocal.getSecondaryDexContainerFileUseInfo(owningPackageName).iterator();     // Catch: Throwable -> L17
    L11:
        if (r5.hasNext() == false) goto L8;
        DexContainerFileUseInfo info = (DexContainerFileUseInfo) r5.next();     // Catch: Throwable -> L17
        Iterator r7 = info.getLoadingPackages().iterator();     // Catch: Throwable -> L17
    L14:
        if (r7.hasNext() == false) goto L11;
        String loadingPackageName = (String) r7.next();     // Catch: Throwable -> L17
        dynamicCodeLogger.recordDex(info.getUserHandle().getIdentifier(), info.getDexContainerFile(), owningPackageName, loadingPackageName);     // Catch: Throwable -> L17
        goto L14
    L21:
        snapshot.close();
        return;
    L17:
        th = move-exception;
        if (snapshot != null) goto L29;
    L28:
        throw th;
    L29:
        snapshot.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    }

    private static String unhex(String hexEncodedPath) {
        if (hexEncodedPath != null) goto L4;
        return "";
    L4:
        if (hexEncodedPath.length() == 0) goto L10;
        byte[] bytes = HexEncoding.decode(hexEncodedPath, false);
        return new String(bytes);
    L10:
        return "";
    }
}
