package com.android.server.selinux;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.provider.DeviceConfig;
import android.util.EventLog;
import android.util.Slog;
import com.android.internal.hidden_from_bootclasspath.com.android.sdksandbox.flags.Flags;
import com.android.server.pm.PackageManagerService;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class SelinuxAuditLogsService extends JobService {
    static final int AUDITD_TAG_CODE = 0;
    private static final String CONFIG_SECURITY_SELINUX_AUDIT_JOB_ENABLED = "selinux_audit_job_enabled";
    private static final String CONFIG_SELINUX_AUDIT_CAP = "selinux_audit_cap";
    private static final String CONFIG_SELINUX_AUDIT_JOB_FREQUENCY_HOURS = "selinux_audit_job_frequency_hours";
    private static final String CONFIG_SELINUX_ENABLE_AUDIT_JOB = "selinux_enable_audit_job";
    private static final String DEVICE_CONFIG_SECURITY_NAMESPACE = "security";
    private static final ExecutorService EXECUTOR_SERVICE = null;
    private static final SelinuxAuditLogsJob LOGS_COLLECTOR_JOB = null;
    private static final int MAX_PERMITS_CAP_DEFAULT = 50000;
    private static final QuotaLimiter QUOTA_LIMITER = null;
    private static final Duration RATE_LIMITER_WINDOW = null;
    private static final ComponentName SELINUX_AUDIT_JOB_COMPONENT = null;
    private static final int SELINUX_AUDIT_JOB_ID = 25327386;
    private static final String SELINUX_AUDIT_NAMESPACE = "SelinuxAuditLogsNamespace";
    private static final String TAG = "SelinuxAuditLogs";

    private static final class AdServicesPropertyMonitor implements DeviceConfig.OnPropertiesChangedListener {
        private final LogsCollectorJobScheduler mScheduler;

        /* synthetic */ AdServicesPropertyMonitor(LogsCollectorJobScheduler r1, SelinuxAuditLogsServiceIA r2) {
            this(r1);
        }

        private AdServicesPropertyMonitor(LogsCollectorJobScheduler scheduler) {
            this.mScheduler = scheduler;
        }

        public void onPropertiesChanged(DeviceConfig.Properties changedProperties) {
            Set<String> keyset = changedProperties.getKeyset();
            if (keyset.contains(SelinuxAuditLogsService.CONFIG_SELINUX_AUDIT_CAP) == false) goto L6;
            SelinuxAuditLogsService.m8073$$Nest$sfgetQUOTA_LIMITER().setMaxPermits(changedProperties.getInt(SelinuxAuditLogsService.CONFIG_SELINUX_AUDIT_CAP, SelinuxAuditLogsService.MAX_PERMITS_CAP_DEFAULT));
        L6:
            if (keyset.contains(SelinuxAuditLogsService.CONFIG_SELINUX_ENABLE_AUDIT_JOB) == false) goto L17;
            boolean enabled = false;
            if (changedProperties.getBoolean(SelinuxAuditLogsService.CONFIG_SELINUX_ENABLE_AUDIT_JOB, false) == false) goto L10;
        L11:
            enabled = true;
        L12:
            if (enabled == false) goto L14;
            this.mScheduler.schedule();
            return;
        L14:
            this.mScheduler.cancel();
            return;
        L10:
            if (SelinuxAuditLogsService.enabledForAllDomains() == false) goto L12;
        L17:
            if (keyset.contains(SelinuxAuditLogsService.CONFIG_SELINUX_AUDIT_JOB_FREQUENCY_HOURS) == false) goto L22;
            this.mScheduler.schedule();
            return;
        }
    }

    private static final class LogsCollectorJobScheduler {
        private final JobScheduler mJobScheduler;

        /* synthetic */ LogsCollectorJobScheduler(JobScheduler r1, SelinuxAuditLogsServiceIA r2) {
            this(r1);
        }

        private LogsCollectorJobScheduler(JobScheduler jobScheduler) {
            this.mJobScheduler = jobScheduler;
        }

        public void cancel() {
            this.mJobScheduler.cancel(SelinuxAuditLogsService.SELINUX_AUDIT_JOB_ID);
        }

        public void schedule() {
            long frequencyMillis = TimeUnit.HOURS.toMillis(DeviceConfig.getInt("adservices", SelinuxAuditLogsService.CONFIG_SELINUX_AUDIT_JOB_FREQUENCY_HOURS, 24));
            if (this.mJobScheduler.schedule(new JobInfo.Builder(SelinuxAuditLogsService.SELINUX_AUDIT_JOB_ID, SelinuxAuditLogsService.m8074$$Nest$sfgetSELINUX_AUDIT_JOB_COMPONENT()).setPeriodic(frequencyMillis).setRequiresDeviceIdle(true).setRequiresBatteryNotLow(true).build()) != 0) goto L5;
            Slog.e(SelinuxAuditLogsService.TAG, "SelinuxAuditLogsService could not be scheduled.");
            return;
        L5:
            Slog.d(SelinuxAuditLogsService.TAG, "SelinuxAuditLogsService scheduled successfully.");
        }
    }

    private static final class SecurityPropertyMonitor implements DeviceConfig.OnPropertiesChangedListener {
        private final LogsCollectorJobScheduler mScheduler;

        /* synthetic */ SecurityPropertyMonitor(LogsCollectorJobScheduler r1, SelinuxAuditLogsServiceIA r2) {
            this(r1);
        }

        private SecurityPropertyMonitor(LogsCollectorJobScheduler scheduler) {
            this.mScheduler = scheduler;
        }

        public void onPropertiesChanged(DeviceConfig.Properties changedProperties) {
            Set<String> keyset = changedProperties.getKeyset();
            if (keyset.contains(SelinuxAuditLogsService.CONFIG_SECURITY_SELINUX_AUDIT_JOB_ENABLED) == false) goto L13;
            boolean enabled = false;
            if (changedProperties.getBoolean(SelinuxAuditLogsService.CONFIG_SECURITY_SELINUX_AUDIT_JOB_ENABLED, false) == false) goto L7;
        L8:
            enabled = true;
        L9:
            if (enabled == false) goto L11;
            this.mScheduler.schedule();
            return;
        L11:
            this.mScheduler.cancel();
            return;
        L7:
            if (SelinuxAuditLogsService.enabledForSdkSandbox() == false) goto L9;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$AJuDyeqptjfWilIl-ByvSw45K1c, reason: not valid java name */
    public static /* synthetic */ void m8072$r8$lambda$AJuDyeqptjfWilIlByvSw45K1c(SelinuxAuditLogsService r0, JobParameters r1) {
        r0.lambda$onStartJob$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetQUOTA_LIMITER, reason: not valid java name */
    static /* bridge */ /* synthetic */ QuotaLimiter m8073$$Nest$sfgetQUOTA_LIMITER() {
        return QUOTA_LIMITER;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSELINUX_AUDIT_JOB_COMPONENT, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m8074$$Nest$sfgetSELINUX_AUDIT_JOB_COMPONENT() {
        return SELINUX_AUDIT_JOB_COMPONENT;
    }

    public SelinuxAuditLogsService() {
    }

    static {
        AUDITD_TAG_CODE = EventLog.getTagCode("auditd");
        SELINUX_AUDIT_JOB_COMPONENT = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, SelinuxAuditLogsService.class.getName());
        EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();
        RATE_LIMITER_WINDOW = Duration.ofMillis(10);
        QUOTA_LIMITER = new QuotaLimiter(DeviceConfig.getInt("adservices", CONFIG_SELINUX_AUDIT_CAP, MAX_PERMITS_CAP_DEFAULT));
        LOGS_COLLECTOR_JOB = new SelinuxAuditLogsJob(new SelinuxAuditLogsCollector(new RateLimiter(RATE_LIMITER_WINDOW), QUOTA_LIMITER));
    }

    public static void schedule(Context context) {
        if (Flags.selinuxSdkSandboxAudit() == true) goto L9;
        if (enabledForAllDomains() == true) goto L9;
        Slog.d(TAG, "SelinuxAuditLogsService not enabled");
        return;
    L9:
        if (AUDITD_TAG_CODE != (-1)) goto L12;
        Slog.e(TAG, "auditd is not a registered tag on this system");
        return;
    L12:
        SelinuxAuditLogsServiceIA r2 = null;
        LogsCollectorJobScheduler scheduler = new LogsCollectorJobScheduler(((JobScheduler) context.getSystemService(JobScheduler.class)).forNamespace(SELINUX_AUDIT_NAMESPACE), r2);
        scheduler.schedule();
        AdServicesPropertyMonitor adServicesProperties = new AdServicesPropertyMonitor(scheduler, r2);
        DeviceConfig.addOnPropertiesChangedListener("adservices", context.getMainExecutor(), adServicesProperties);
        SecurityPropertyMonitor securityProperties = new SecurityPropertyMonitor(scheduler, r2);
        DeviceConfig.addOnPropertiesChangedListener(DEVICE_CONFIG_SECURITY_NAMESPACE, context.getMainExecutor(), securityProperties);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        if (params.getJobId() == SELINUX_AUDIT_JOB_ID) goto L7;
        Slog.e(TAG, "The job id does not match the expected selinux job id.");
        return false;
    L7:
        if (Flags.selinuxSdkSandboxAudit() == false) goto L9;
    L12:
        EXECUTOR_SERVICE.execute(new SelinuxAuditLogsService$$ExternalSyntheticLambda0(this, params));
        return true;
    L9:
        if (enabledForAllDomains() == true) goto L12;
        Slog.i(TAG, "Selinux audit job disabled.");
        return false;
    }

    private /* synthetic */ void lambda$onStartJob$0(JobParameters params) {
        LOGS_COLLECTOR_JOB.start(this, params);
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        if (params.getJobId() == SELINUX_AUDIT_JOB_ID) goto L6;
        return false;
    L6:
        if (LOGS_COLLECTOR_JOB.isRunning() == false) goto L9;
        LOGS_COLLECTOR_JOB.requestStop();
        return true;
    L9:
        return false;
    }

    public static final boolean enabledForAllDomains() {
        return false;
    }

    public static final boolean enabledForSdkSandbox() {
        if (Flags.selinuxSdkSandboxAudit() == true) goto L5;
        return false;
    L5:
        return DeviceConfig.getBoolean("adservices", CONFIG_SELINUX_ENABLE_AUDIT_JOB, false);
    }
}
