package com.android.server.memory;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.os.IMmd;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.provider.DeviceConfig;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public class ZramMaintenance extends JobService {
    private static final long DEFAULT_FIRST_DELAY_SECONDS = 3600;
    private static final long DEFAULT_PERIODIC_DELAY_SECONDS = 3600;
    private static final boolean DEFAULT_REQUIRE_BATTERY_NOT_LOW = true;
    private static final boolean DEFAULT_REQUIRE_DEVICE_IDLE = true;
    private static final String FIRST_DELAY_SECONDS_PROP = "zram.maintenance.first_delay_seconds";
    public static final int JOB_ID = 375432472;
    public static final String KEY_CHECK_STATUS = "check_status";
    private static final String PERIODIC_DELAY_SECONDS_PROP = "zram.maintenance.periodic_delay_seconds";
    private static final String REQUIRE_BATTERY_NOT_LOW_PROP = "zram.maintenance.require_battery_not_low";
    private static final String REQUIRE_DEVICE_IDLE_PROP = "zram.maintenance.require_device_idle";
    private static final String SYSTEM_PROPERTY_PREFIX = "mm.";
    private static final String TAG = null;
    private static final ComponentName sZramMaintenance = null;

    public ZramMaintenance() {
    }

    static {
        TAG = ZramMaintenance.class.getName();
        sZramMaintenance = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, ZramMaintenance.class.getName());
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters params) {
        final String r1 = "ZramMaintenance";
        new AnonymousClass1(this, r1, params).start();
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters params) {
        return false;
    }

    public static void startJob(Context context, JobParameters params, IMmd mmd) {
        boolean checkStatus = params.getExtras().getBoolean(KEY_CHECK_STATUS);
        if (mmd == null) goto L14;
        if (checkStatus == true) goto L17;
    L11:
        checkStatus = false;
        mmd.doZramMaintenanceAsync();     // Catch: RemoteException -> L9
    L15:
        Duration delay = Duration.ofSeconds(getLongProperty(PERIODIC_DELAY_SECONDS_PROP, 3600));
        scheduleZramMaintenance(context, delay, checkStatus);
        return;
    L17:
    L9:
        e = move-exception;
        Slog.e(TAG, "Failed to binder call to mmd", e);
        goto L15
    L6:
        if (mmd.isZramMaintenanceSupported() == true) goto L11;
        Slog.i(TAG, "zram maintenance is not supported");     // Catch: RemoteException -> L9
        return;
    L14:
        Slog.w(TAG, "binder not found");
        goto L15
    }

    public static void startZramMaintenance(Context context) {
        Duration delay = Duration.ofSeconds(getLongProperty(FIRST_DELAY_SECONDS_PROP, 3600));
        scheduleZramMaintenance(context, delay, true);
    }

    private static void scheduleZramMaintenance(Context context, Duration delay, boolean checkStatus) {
        JobScheduler js = (JobScheduler) context.getSystemService(JobScheduler.class);
        if (js == null) goto L6;
        PersistableBundle bundle = new PersistableBundle();
        bundle.putBoolean(KEY_CHECK_STATUS, checkStatus);
        js.schedule(new JobInfo.Builder(JOB_ID, sZramMaintenance).setMinimumLatency(delay.toMillis()).setRequiresDeviceIdle(getBooleanProperty(REQUIRE_DEVICE_IDLE_PROP, true)).setRequiresBatteryNotLow(getBooleanProperty(REQUIRE_BATTERY_NOT_LOW_PROP, true)).setExtras(bundle).build());
        return;
    }

    private static long getLongProperty(String name, long defaultValue) {
        return DeviceConfig.getLong("mm", name, SystemProperties.getLong(SYSTEM_PROPERTY_PREFIX + name, defaultValue));
    }

    private static boolean getBooleanProperty(String name, boolean defaultValue) {
        return DeviceConfig.getBoolean("mm", name, SystemProperties.getBoolean(SYSTEM_PROPERTY_PREFIX + name, defaultValue));
    }
}
