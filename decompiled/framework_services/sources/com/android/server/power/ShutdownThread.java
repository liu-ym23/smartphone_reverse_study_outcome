package com.android.server.power;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.AlertDialog;
import android.app.BroadcastOptions;
import android.app.Dialog;
import android.app.IActivityManager;
import android.app.ProgressDialog;
import android.app.admin.SecurityLog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManagerInternal;
import android.os.Bundle;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.os.RecoverySystem;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.SystemVibrator;
import android.os.UserManager;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.vibrator.persistence.VibrationXmlParser;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.util.TimingsTraceLog;
import android.view.SurfaceControl;
import com.android.server.LocalServices;
import com.android.server.PackageWatchdog;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.am.HostingRecord;
import com.android.server.job.controllers.JobStatus;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public final class ShutdownThread extends Thread {
    private static final int ACTION_DONE_POLL_WAIT_MS = 500;
    public static final String ACTION_PRE_SHUTDOWN = "android.intent.action.ACTION_PRE_SHUTDOWN";
    private static final int ACTIVITY_MANAGER_STOP_PERCENT = 4;
    private static final int BROADCAST_STOP_PERCENT = 2;
    private static final String CHECK_POINTS_FILE_BASENAME = "/data/system/shutdown-checkpoints/checkpoints";
    private static final boolean DEBUG = false;
    static final int DEFAULT_SHUTDOWN_VIBRATE_MS = 500;
    private static final int DELAY_SHUT_DOWN_EVENT = 100;
    private static final int MAX_BROADCAST_TIME = 15000;
    private static final int MAX_CHECK_POINTS_DUMP_WAIT_TIME = 10000;
    private static final int MAX_RADIO_WAIT_TIME = 17000;
    private static final int MAX_SHUTDOWN_WAIT_TIME = 25000;
    private static final int MAX_UNCRYPT_WAIT_TIME = 900000;
    private static final String METRICS_FILE_BASENAME = "/data/system/shutdown-metrics";
    private static String METRIC_AM = null;
    private static String METRIC_PM = null;
    private static String METRIC_RADIO = null;
    private static String METRIC_RADIOS = null;
    private static String METRIC_SEND_BROADCAST = null;
    private static String METRIC_SHUTDOWN_TIME_START = null;
    private static String METRIC_SYSTEM_SERVER = null;
    private static final int MOUNT_SERVICE_STOP_PERCENT = 20;
    private static final int PACKAGE_MANAGER_STOP_PERCENT = 6;
    private static final int RADIOS_STATE_POLL_SLEEP_MS = 100;
    private static final int RADIO_STOP_PERCENT = 18;
    public static final String REBOOT_SAFEMODE_PROPERTY = "persist.sys.safemode";
    private static final String REQUEST_SEND_PHONENUM = "REQUEST_SEND_PHONENUM";
    public static final String RO_SAFEMODE_PROPERTY = "ro.sys.safemode";
    private static final String SENT_SMS_ACTION = "SENT_SMS_ACTION";
    public static final String SHUTDOWN_ACTION_PROPERTY = "sys.shutdown.requested";
    private static final int STABD_NOTIFY_REBOOT_REASON_IS_NULL_TRANSACTION = 25;
    private static final String STAB_INTERFACE_TOKEN = "android.stab.IBStabService";
    private static final String STAB_SERVICE_NAME = "stabservice";
    private static final String TAG = "ShutdownThread";
    private static final ArrayMap<String, Long> TRON_METRICS = null;
    private static final int VENDOR_SUBSYS_MAX_WAIT_MS = 10000;
    private static final int VENDOR_SUBSYS_STATE_CHECK_INTERVAL_MS = 100;
    private static String mReason;
    private static boolean mReboot;
    private static boolean mRebootHasProgressBar;
    private static boolean mRebootSafeMode;
    private static AlertDialog sConfirmDialog;
    private static final ShutdownThread sInstance = null;
    private static boolean sIsStarted;
    private static final Object sIsStartedGuard = null;
    private final String CALLING_SHUT_DOWN_FLAG;
    private boolean mActionDone;
    private final Object mActionDoneSync;
    private boolean mActionPreDone;
    private final Object mActionPreDoneSync;
    private Context mContext;
    private PowerManager.WakeLock mCpuWakeLock;
    private Handler mHandler;
    private final Injector mInjector;
    private PowerManager mPowerManager;
    private ProgressDialog mProgressDialog;
    private PowerManager.WakeLock mScreenWakeLock;
    private ShutdownThreadSmtEx mSmtEx;

    /* JADX INFO: renamed from: com.android.server.power.ShutdownThread$8, reason: invalid class name */
    class AnonymousClass8 extends IIntentReceiver.Stub {
        final /* synthetic */ ShutdownThread this$0;

        public static /* synthetic */ void $r8$lambda$1HgpInBtAJhjxr1gDEbfv8Scwx0(ShutdownThread r0) {
            ShutdownThread.m7557$$Nest$mactionPreDone(r0);
        }

        AnonymousClass8(ShutdownThread this$0) {
            this.this$0 = this$0;
        }

        public void performReceive(Intent intent, int resultCode, String data, Bundle extras, boolean ordered, boolean sticky, int sendingUser) {
            Handler r0 = ShutdownThread.m7555$$Nest$fgetmHandler(this.this$0);
            final ShutdownThread r1 = this.this$0;
            r0.post(new ShutdownThread$8$$ExternalSyntheticLambda0(r1));
        }
    }

    private static class CloseDialogReceiver extends BroadcastReceiver implements DialogInterface.OnDismissListener {
        public Dialog dialog;
        private Context mContext;

        CloseDialogReceiver(Context context) {
            this.mContext = context;
            IntentFilter filter = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            context.registerReceiver(this, filter, 2);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.dialog.cancel();
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface unused) {
            this.mContext.unregisterReceiver(this);
        }
    }

    static class Injector {
        Injector() {
        }

        public Vibrator getVibrator(Context context) {
            return new SystemVibrator(context);
        }

        public void sleep(long durationMs) {
            Thread.sleep(durationMs);     // Catch: InterruptedException -> L4
            return;
        }

        public String getDefaultShutdownVibrationEffectFilePath(Context context) {
            return context.getResources().getString(R.string.config_headlineFontFamilyMedium);
        }

        public boolean isShutdownVibrationDisabled(Context context) {
            boolean disabledInConfig = context.getResources().getBoolean(R.bool.config_disableUsbPermissionDialogs);
            if (Settings.Global.getInt(context.getContentResolver(), "zen_mode", 0) == 0) goto L5;
            boolean isZenMode = true;
        L6:
            if (disabledInConfig == false) goto L10;
            if (isZenMode == true) goto L9;
            return false;
        L9:
            return true;
        L10:
            return false;
        L5:
            isZenMode = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7554$$Nest$fgetmContext(ShutdownThread r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7555$$Nest$fgetmHandler(ShutdownThread r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProgressDialog, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProgressDialog m7556$$Nest$fgetmProgressDialog(ShutdownThread r0) {
        return r0.mProgressDialog;
    }

    /* JADX INFO: renamed from: -$$Nest$mactionPreDone, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7557$$Nest$mactionPreDone(ShutdownThread r0) {
        r0.actionPreDone();
    }

    /* JADX INFO: renamed from: -$$Nest$msetRebootProgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7558$$Nest$msetRebootProgress(ShutdownThread r0, int r1, CharSequence r2) {
        r0.setRebootProgress(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMETRIC_RADIO, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m7559$$Nest$sfgetMETRIC_RADIO() {
        return METRIC_RADIO;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTRON_METRICS, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m7560$$Nest$sfgetTRON_METRICS() {
        return TRON_METRICS;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmRebootHasProgressBar, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7561$$Nest$sfgetmRebootHasProgressBar() {
        return mRebootHasProgressBar;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsInstance, reason: not valid java name */
    static /* bridge */ /* synthetic */ ShutdownThread m7562$$Nest$sfgetsInstance() {
        return sInstance;
    }

    /* JADX INFO: renamed from: -$$Nest$smbeginShutdownSequence, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7563$$Nest$smbeginShutdownSequence(Context r0) {
        beginShutdownSequence(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smmetricEnded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7564$$Nest$smmetricEnded(String r0) {
        metricEnded(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smmetricStarted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7565$$Nest$smmetricStarted(String r0) {
        metricStarted(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smnewTimingsLog, reason: not valid java name */
    static /* bridge */ /* synthetic */ TimingsTraceLog m7566$$Nest$smnewTimingsLog() {
        return newTimingsLog();
    }

    static {
        sIsStartedGuard = new Object();
        sIsStarted = false;
        sInstance = new ShutdownThread();
        TRON_METRICS = new ArrayMap();
        METRIC_SYSTEM_SERVER = "shutdown_system_server";
        METRIC_SEND_BROADCAST = "shutdown_send_shutdown_broadcast";
        METRIC_AM = "shutdown_activity_manager";
        METRIC_PM = "shutdown_package_manager";
        METRIC_RADIOS = "shutdown_radios";
        METRIC_RADIO = "shutdown_radio";
        METRIC_SHUTDOWN_TIME_START = "begin_shutdown";
    }

    private ShutdownThread() {
        this(new Injector());
        this.mSmtEx = new ShutdownThreadSmtEx(this);
    }

    ShutdownThread(Injector injector) {
        this.mActionDoneSync = new Object();
        this.CALLING_SHUT_DOWN_FLAG = "callingshutdownflag";
        this.mActionPreDoneSync = new Object();
        this.mActionPreDone = false;
        this.mInjector = injector;
    }

    private void notifyRebootReasonIsNull() {
        Parcel data = null;
        IBinder stabd = ServiceManager.getService(STAB_SERVICE_NAME);     // Catch: Throwable -> L9 RemoteException -> L11
        if (stabd != null) goto L13;
        Slog.w(TAG, "[RebootReasonNull] stabservice not found");     // Catch: Throwable -> L9 RemoteException -> L11
        if (0 == 0) goto L24;
        data.recycle();
        return;
    L24:
        return;
    L13:
        data = Parcel.obtain();     // Catch: Throwable -> L9 RemoteException -> L11
        data.writeInterfaceToken(STAB_INTERFACE_TOKEN);     // Catch: Throwable -> L9 RemoteException -> L11
        String stack = Log.getStackTraceString(new Throwable());     // Catch: Throwable -> L9 RemoteException -> L11
        data.writeString16(stack);     // Catch: Throwable -> L9 RemoteException -> L11
        int uid = Process.myUid();     // Catch: Throwable -> L9 RemoteException -> L11
        int pid = Process.myPid();     // Catch: Throwable -> L9 RemoteException -> L11
        data.writeInt(uid);     // Catch: Throwable -> L9 RemoteException -> L11
        data.writeInt(pid);     // Catch: Throwable -> L9 RemoteException -> L11
        long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L9 RemoteException -> L11
        data.writeLong(currentTime);     // Catch: Throwable -> L9 RemoteException -> L11
        Slog.i(TAG, "[RebootReasonNull] uid=" + uid + ", pid=" + pid + ", time=" + currentTime);     // Catch: Throwable -> L9 RemoteException -> L11
        stabd.transact(25, data, null, 0);     // Catch: Throwable -> L9 RemoteException -> L11
    L14:
        data.recycle();
        return;
    L9:
        th = move-exception;
        if (0 == 0) goto L22;
        data.recycle();
    L22:
        throw th;
    L11:
        e = move-exception;
        Slog.e(TAG, "[RebootReasonNull] notifyRebootReasonIsNull failure: " + e);     // Catch: Throwable -> L9
        if (0 != 0) goto L14;
    }

    public static void shutdown(Context context, String reason, boolean confirm) {
        Slog.d(TAG, "shutdown reason=" + reason + " confirm=" + confirm);
        mReboot = false;
        mRebootSafeMode = false;
        mReason = reason;
        shutdownInner(context, confirm);
    }

    private static void shutdownInner(final Context context, boolean confirm) {
        context.assertRuntimeOverlayThemable();
        if (mRebootSafeMode == true) goto L8;
        if (mReboot == true) goto L8;
        PowerUtils.checkShipMode(context);
    L8:
        if (mRebootSafeMode == false) goto L10;
    L12:
        Object r0 = sIsStartedGuard;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L15:
        if (sIsStarted == false) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L18
        ShutdownCheckPoints.recordCheckPoint(null);
        int longPressBehavior = context.getResources().getInteger(R.integer.config_maxScanTasksForHomeVisibility);
        if (mRebootSafeMode == false) goto L25;
        int resourceId = R.string.sim_done_button;
    L29:
        if (confirm == false) goto L38;
        CloseDialogReceiver closer = new CloseDialogReceiver(context);
        if (sConfirmDialog == null) goto L33;
        sConfirmDialog.dismiss();
    L33:
        AlertDialog.Builder r4 = new AlertDialog.Builder(context);
        if (mRebootSafeMode == false) goto L36;
        int r5 = R.string.sim_removed_message;
    L37:
        sConfirmDialog = r4.setTitle(r5).setMessage(resourceId).setPositiveButton(R.string.yes, new AnonymousClass1(context)).setNegativeButton(R.string.no, null).create();
        closer.dialog = sConfirmDialog;
        sConfirmDialog.setOnDismissListener(closer);
        sConfirmDialog.getWindow().setType(2009);
        sConfirmDialog.show();
        return;
    L36:
        r5 = R.string.select_minutes;
        goto L37
    L38:
        beginShutdownSequence(context);
        return;
    L25:
        if (longPressBehavior != 2) goto L27;
        resourceId = R.string.wfcSpnFormat_vowifi;
        goto L29
    L27:
        resourceId = R.string.wfcSpnFormat_spn_wlan_call;
        goto L29
    L10:
        if (mReboot == true) goto L12;
        PowerUtils.setPowerOffMode();
        goto L12
    }

    public static void reboot(Context context, String reason, boolean confirm) {
        Slog.d(TAG, "reboot reason=" + reason + " confirm=" + confirm);
        mReboot = true;
        mRebootSafeMode = false;
        mRebootHasProgressBar = false;
        mReason = reason;
        shutdownInner(context, confirm);
    }

    public static void rebootSafeMode(Context context, boolean confirm) {
        UserManager um = (UserManager) context.getSystemService("user");
        if (um.hasUserRestriction("no_safe_boot") == false) goto L5;
        return;
    L5:
        Slog.d(TAG, "rebootSafeMode confirm=" + confirm);
        mReboot = true;
        mRebootSafeMode = true;
        mRebootHasProgressBar = false;
        mReason = null;
        shutdownInner(context, confirm);
    }

    private static ProgressDialog showShutdownDialog(Context context) {
        ProgressDialog pd = new ProgressDialog(context);
        if (mReason == null) goto L23;
        if (mReason.startsWith("recovery-update") == false) goto L23;
        if (RecoverySystem.UNCRYPT_PACKAGE_FILE.exists() == true) goto L9;
    L11:
        boolean r1 = false;
    L12:
        mRebootHasProgressBar = r1;
        pd.setTitle(context.getText(R.string.skip_button_label));
        if (mRebootHasProgressBar == false) goto L19;
        pd.setMax(100);
        pd.setProgress(0);
        pd.setIndeterminate(false);
        boolean showPercent = context.getResources().getBoolean(R.bool.config_skipScreenOnBrightnessRamp);
        if (showPercent == true) goto L17;
        pd.setProgressPercentFormat(null);
    L17:
        pd.setProgressNumberFormat(null);
        pd.setProgressStyle(1);
        pd.setMessage(context.getText(R.string.sipAddressTypeOther));
    L37:
        pd.setCancelable(false);
        pd.getWindow().setType(2009);
        pd.show();
        return pd;
    L19:
        if (showSysuiReboot() == false) goto L21;
        return null;
    L21:
        pd.setIndeterminate(true);
        pd.setMessage(context.getText(R.string.sipAddressTypeWork));
        goto L37
    L9:
        if (RecoverySystem.BLOCK_MAP_FILE.exists() == true) goto L11;
        r1 = true;
    L23:
        if (mReason == null) goto L34;
        if (mReason.equals("recovery") == false) goto L34;
        if (PackageWatchdog.isRecoveryTriggeredReboot() == false) goto L30;
        pd.setTitle(context.getText(R.string.select_minutes));
        pd.setMessage(context.getText(R.string.wfcSpnFormat_wifi));
        pd.setIndeterminate(true);
        goto L37
    L30:
        if (showSysuiReboot() == false) goto L32;
        return null;
    L32:
        pd.setTitle(context.getText(R.string.sipAddressTypeCustom));
        pd.setMessage(context.getText(R.string.sim_restart_button));
        pd.setIndeterminate(true);
    L34:
        if (showSysuiReboot() == false) goto L36;
        return null;
    L36:
        pd.setTitle(context.getText(R.string.select_minutes));
        pd.setMessage(context.getText(R.string.wfcSpnFormat_wifi));
        pd.setIndeterminate(true);
        goto L37
    }

    private static boolean showSysuiReboot() {
        StatusBarManagerInternal service = (StatusBarManagerInternal) LocalServices.getService(StatusBarManagerInternal.class);     // Catch: Exception -> L7
        if (service.showShutdownUi(mReboot, mReason) == false) goto L12;
        return true;
    L12:
        return false;
    L8:
        return false;
    }

    private static void beginShutdownSequence(Context context) {
        Object r0 = sIsStartedGuard;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sIsStarted == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        sIsStarted = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        if ("recovery-update".equals(mReason) == true) goto L15;
    L21:
        sInstance.mProgressDialog = showShutdownDialog(context);
        sInstance.mContext = context;
        sInstance.mPowerManager = (PowerManager) context.getSystemService("power");
        sInstance.mCpuWakeLock = null;
        sInstance.mCpuWakeLock = sInstance.mPowerManager.newWakeLock(1, "ShutdownThread-cpu");     // Catch: SecurityException -> L24
        sInstance.mCpuWakeLock.setReferenceCounted(false);     // Catch: SecurityException -> L24
        sInstance.mCpuWakeLock.acquire();     // Catch: SecurityException -> L24
    L26:
        sInstance.mScreenWakeLock = null;
        if (sInstance.mPowerManager.isScreenOn() == false) goto L33;
        sInstance.mScreenWakeLock = sInstance.mPowerManager.newWakeLock(26, "ShutdownThread-screen");     // Catch: SecurityException -> L30
        sInstance.mScreenWakeLock.setReferenceCounted(false);     // Catch: SecurityException -> L30
        sInstance.mScreenWakeLock.acquire();     // Catch: SecurityException -> L30
    L30:
        e = move-exception;
        Log.w(TAG, "No permission to acquire wake lock", e);
        sInstance.mScreenWakeLock = null;
    L33:
        if (SecurityLog.isLoggingEnabled() == false) goto L35;
        SecurityLog.writeEvent(210010, new Object[0]);
    L35:
        sInstance.mHandler = new AnonymousClass2();
        sInstance.start();
        return;
    L24:
        e = move-exception;
        Log.w(TAG, "No permission to acquire wake lock", e);
        sInstance.mCpuWakeLock = null;
        goto L26
    L15:
        if (RecoverySystem.UNCRYPT_PACKAGE_FILE.exists() == true) goto L17;
    L19:
        boolean r1 = false;
    L20:
        mRebootHasProgressBar = r1;
        goto L21
    L17:
        if (RecoverySystem.BLOCK_MAP_FILE.exists() == true) goto L19;
        r1 = true;
        goto L20
    }

    void actionDone() {
        Object r0 = this.mActionDoneSync;
        monitor-enter(r0);
        this.mActionDone = true;     // Catch: Throwable -> L8
        this.mActionDoneSync.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        TimingsTraceLog shutdownTimingLog = newTimingsLog();
        shutdownTimingLog.traceBegin("SystemServerShutdown");
        metricShutdownStart();
        metricStarted(METRIC_SYSTEM_SERVER);
        sendPreShutdownBroadcast();
        SurfaceControl.notifyShutdown();
        Thread dumpCheckPointsThread = ShutdownCheckPoints.newDumpThread(new File(CHECK_POINTS_FILE_BASENAME));
        dumpCheckPointsThread.start();
        StringBuilder r0 = new StringBuilder();
        if (mReboot == false) goto L5;
        String r4 = "1";
    L6:
        r0.append(r4);
        if (mReason == null) goto L9;
        String r5 = mReason;
    L10:
        r0.append(r5);
        String reason = r0.toString();
        SystemProperties.set(SHUTDOWN_ACTION_PROPERTY, reason);
        String reason2 = mReason;
        if (TextUtils.isEmpty(reason2) == false) goto L14;
        notifyRebootReasonIsNull();
    L14:
        if (mRebootSafeMode == false) goto L16;
        SystemProperties.set(REBOOT_SAFEMODE_PROPERTY, "1");
    L16:
        shutdownTimingLog.traceBegin("DumpPreRebootInfo");
        Slog.i(TAG, "Logging pre-reboot information...");     // Catch: Exception -> L19
        PreRebootLogger.log(this.mContext);     // Catch: Exception -> L19
    L21:
        shutdownTimingLog.traceEnd();
        metricStarted(METRIC_SEND_BROADCAST);
        shutdownTimingLog.traceBegin("SendShutdownBroadcast");
        Log.i(TAG, "Sending shutdown broadcast...");
        this.mActionDone = false;
        Intent intent = new Intent("android.intent.action.ACTION_SHUTDOWN");
        intent.addFlags(1342177280);
        Bundle opts = BroadcastOptions.makeBasic().setDeferralPolicy(2).toBundle();
        ActivityManagerInternal activityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        activityManagerInternal.broadcastIntentWithCallback(intent, new AnonymousClass3(this), null, -1, null, null, opts);
        long r9 = 15000;
        long endTime = SystemClock.elapsedRealtime() + 15000;
        Object r11 = this.mActionDoneSync;
        monitor-enter(r11);
    L76:
    L28:
        th = move-exception;
        throw th;
    L24:
        if (this.mActionDone == true) goto L39;
        long delay = endTime - SystemClock.elapsedRealtime();     // Catch: Throwable -> L28
        if (delay <= 0) goto L27;
        if (mRebootHasProgressBar == false) goto L34;
        long r16 = r9;
        int status = (int) ((((r16 - delay) * 1.0d) * 2.0d) / 15000.0d);     // Catch: Throwable -> L28
        sInstance.setRebootProgress(status, null);     // Catch: Throwable -> L28
    L80:
        this.mActionDoneSync.wait(Math.min(delay, 500));     // Catch: Throwable -> L28 InterruptedException -> L37
    L38:
        r9 = r16;
        goto L76
    L34:
        r16 = r9;
        goto L80
    L27:
        Log.w(TAG, "Shutdown broadcast timed out");     // Catch: Throwable -> L28
    L39:
        monitor-exit(r11);     // Catch: Throwable -> L28
        if (mRebootHasProgressBar == false) goto L43;
        sInstance.setRebootProgress(2, null);
    L43:
        shutdownTimingLog.traceEnd();
        metricEnded(METRIC_SEND_BROADCAST);
        Log.i(TAG, "Shutting down activity manager...");
        shutdownTimingLog.traceBegin("ShutdownActivityManager");
        metricStarted(METRIC_AM);
        IActivityManager am = IActivityManager.Stub.asInterface(ServiceManager.checkService(HostingRecord.HOSTING_TYPE_ACTIVITY));
        if (am == null) goto L50;
        am.shutdown(15000);     // Catch: RemoteException -> L48
    L50:
        if (mRebootHasProgressBar == false) goto L52;
        sInstance.setRebootProgress(4, null);
    L52:
        shutdownTimingLog.traceEnd();
        metricEnded(METRIC_AM);
        Log.i(TAG, "Shutting down package manager...");
        shutdownTimingLog.traceBegin("ShutdownPackageManager");
        metricStarted(METRIC_PM);
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (pm == null) goto L56;
        pm.shutdown();
    L56:
        if (mRebootHasProgressBar == false) goto L58;
        sInstance.setRebootProgress(6, null);
    L58:
        shutdownTimingLog.traceEnd();
        metricEnded(METRIC_PM);
        shutdownTimingLog.traceBegin("ShutdownRadios");
        metricStarted(METRIC_RADIOS);
        shutdownRadios(MAX_RADIO_WAIT_TIME);
        if (mRebootHasProgressBar == false) goto L61;
        sInstance.setRebootProgress(18, null);
    L61:
        shutdownTimingLog.traceEnd();
        metricEnded(METRIC_RADIOS);
        if (mRebootHasProgressBar == false) goto L64;
        sInstance.setRebootProgress(20, null);
        uncrypt();
    L64:
        shutdownTimingLog.traceBegin("ShutdownCheckPointsDumpWait");
        dumpCheckPointsThread.join(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);     // Catch: InterruptedException -> L67
    L68:
        shutdownTimingLog.traceEnd();
        shutdownTimingLog.traceEnd();
        metricEnded(METRIC_SYSTEM_SERVER);
        saveMetrics(mReboot, mReason);
        rebootOrShutdown(this.mContext, mReboot, mReason);
        return;
    L19:
        e = move-exception;
        Slog.e(TAG, "Failed to log pre-reboot information", e);
        goto L21
    L9:
        r5 = "";
        goto L10
    L5:
        r4 = "0";
        goto L6
    }

    private static TimingsTraceLog newTimingsLog() {
        return new TimingsTraceLog("ShutdownTiming", 524288);
    }

    private static void metricStarted(String metricKey) {
        ArrayMap<String, Long> r0 = TRON_METRICS;
        monitor-enter(r0);
        TRON_METRICS.put(metricKey, Long.valueOf(SystemClock.elapsedRealtime() * (-1)));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void metricEnded(String metricKey) {
        ArrayMap<String, Long> r0 = TRON_METRICS;
        monitor-enter(r0);
        TRON_METRICS.put(metricKey, Long.valueOf(SystemClock.elapsedRealtime() + TRON_METRICS.get(metricKey).longValue()));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void metricShutdownStart() {
        ArrayMap<String, Long> r0 = TRON_METRICS;
        monitor-enter(r0);
        TRON_METRICS.put(METRIC_SHUTDOWN_TIME_START, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void setRebootProgress(final int progress, final CharSequence message) {
        this.mHandler.post(new AnonymousClass4(this, progress, message));
    }

    private void shutdownRadios(final int timeout) {
        final long endTime = SystemClock.elapsedRealtime() + ((long) timeout);
        final boolean[] done = new boolean[1];
        Thread t = new AnonymousClass5(this, endTime, timeout, done);
        t.start();
        t.join(timeout);     // Catch: InterruptedException -> L5
    L7:
        if (done[0] == true) goto L12;
        Log.w(TAG, "Timed out waiting for Radio shutdown.");
        return;
    }

    public static void rebootOrShutdown(Context context, boolean reboot, String reason) {
        String subsysProp = SystemProperties.get("vendor.peripheral.shutdown_critical_list", "ERROR");
        if (subsysProp.equals("ERROR") == true) goto L29;
        Log.i(TAG, "Shutdown critical subsyslist is :" + subsysProp + ": ");
        Log.i(TAG, "Waiting for a maximum of 10000ms");
        String[] subsysList = subsysProp.split(" ");
        int wait_count = 0;
        int subsysListLength = subsysList.length;
    L5:
        boolean okToShutdown = true;
        int i = 0;
    L7:
        if (i >= subsysListLength) goto L13;
        String subsysState = SystemProperties.get("vendor.peripheral." + subsysList[i] + ".state", "ERROR");
        if (subsysState.equals("ONLINE") == false) goto L11;
        okToShutdown = false;
    L11:
        i = i + 1;
        goto L7
    L13:
        if (okToShutdown == true) goto L16;
        SystemClock.sleep(100);
        wait_count = wait_count + 1;
    L16:
        if (okToShutdown == true) goto L19;
        if (wait_count < 100) goto L5;
    L19:
        if (okToShutdown == true) goto L28;
        int i2 = 0;
    L22:
        if (i2 >= subsysList.length) goto L29;
        String subsysState2 = SystemProperties.get("vendor.peripheral." + subsysList[i2] + ".state", "ERROR");
        if (subsysState2.equals("ONLINE") == false) goto L26;
        Log.w(TAG, "Subsystem " + subsysList[i2] + "did not shut down within timeout");
    L26:
        i2 = i2 + 1;
        goto L22
    L28:
        Log.i(TAG, "Vendor subsystem(s) shutdown successful");
    L29:
        if (reboot == false) goto L32;
        Log.i(TAG, "Rebooting, reason: " + reason);
        PowerManagerService.lowLevelReboot(reason);
        Log.e(TAG, "Reboot failed, will attempt shutdown instead");
        String reason2 = null;
    L38:
        Log.i(TAG, "Performing low-level shutdown...");
        PowerManagerService.lowLevelShutdown(reason2);
        return;
    L32:
        if (context != null) goto L40;
    L37:
        reason2 = reason;
        goto L38
    L40:
        sInstance.playShutdownVibration(context);     // Catch: Exception -> L35
    L35:
        e = move-exception;
        Log.w(TAG, "Failed to vibrate during shutdown.", e);
        goto L37
    }

    void playShutdownVibration(Context context) {
        if (this.mInjector.isShutdownVibrationDisabled(context) == false) goto L6;
        Log.i(TAG, "Vibration disabled in config");
        return;
    L6:
        Vibrator vibrator = this.mInjector.getVibrator(context);
        if (vibrator.hasVibrator() == true) goto L9;
        return;
    L9:
        VibrationEffect vibrationEffect = getValidShutdownVibration(context, vibrator);
        vibrator.vibrate(vibrationEffect, VibrationAttributes.createForUsage(18));
        long vibrationDuration = vibrationEffect.getDuration();
        Injector r4 = this.mInjector;
        if (vibrationDuration >= 0) goto L12;
        long r5 = 500;
    L13:
        r4.sleep(r5);
        return;
    L12:
        r5 = vibrationDuration;
        goto L13
    }

    private static void saveMetrics(boolean reboot, String reason) {
        StringBuilder metricValue = new StringBuilder();
        metricValue.append("reboot:");
        if (reboot == false) goto L5;
        String r1 = "y";
    L6:
        metricValue.append(r1);
        metricValue.append(",");
        metricValue.append("reason:");
        metricValue.append(reason);
        int metricsSize = TRON_METRICS.size();
        int i = 0;
    L8:
        if (i >= metricsSize) goto L14;
        String name = TRON_METRICS.keyAt(i);
        long value = TRON_METRICS.valueAt(i).longValue();
        if (value >= 0) goto L12;
        Log.e(TAG, "metricEnded wasn't called for " + name);
    L13:
        i = i + 1;
        goto L8
    L12:
        metricValue.append(',');
        metricValue.append(name);
        metricValue.append(':');
        metricValue.append(value);
        goto L13
    L14:
        File tmp = new File("/data/system/shutdown-metrics.tmp");
        boolean saved = false;
        FileOutputStream fos = new FileOutputStream(tmp);     // Catch: IOException -> L20
        fos.write(metricValue.toString().getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L22
        saved = true;
        fos.close();     // Catch: IOException -> L20
    L29:
        if (saved == false) goto L40;
        tmp.renameTo(new File("/data/system/shutdown-metrics.txt"));
        return;
    L40:
        return;
    L22:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: IOException -> L20
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Log.e(TAG, "Cannot save shutdown metrics", e);
        goto L29
    L5:
        r1 = "n";
        goto L6
    }

    private void uncrypt() {
        Log.i(TAG, "Calling uncrypt and monitoring the progress...");
        final RecoverySystem.ProgressListener progressListener = new AnonymousClass6(this);
        final boolean[] done = {false};
        Thread t = new AnonymousClass7(this, progressListener, done);
        t.start();
        t.join(HeartbeatStats.MAX_NAT_TIME_MS);     // Catch: InterruptedException -> L5
    L7:
        if (done[0] == true) goto L18;
        Log.w(TAG, "Timed out waiting for uncrypt.");
        String timeoutMessage = String.format("uncrypt_time: %d\nuncrypt_error: %d\n", new Object[]{900, 100});
        FileUtils.stringToFile(RecoverySystem.UNCRYPT_STATUS_FILE, timeoutMessage);     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        Log.e(TAG, "Failed to write timeout message to uncrypt status", e);
        return;
    }

    private VibrationEffect getValidShutdownVibration(Context context, Vibrator vibrator) {
        VibrationEffect parsedEffect = parseVibrationEffectFromFile(this.mInjector.getDefaultShutdownVibrationEffectFilePath(context), vibrator);
        if (parsedEffect == null) goto L5;
        long parsedEffectDuration = parsedEffect.getDuration();
        if (parsedEffectDuration != Long.MAX_VALUE) goto L10;
        Log.w(TAG, "The parsed shutdown vibration is indefinite.");
        return createDefaultVibrationEffect();
    L10:
        return parsedEffect;
    L5:
        return createDefaultVibrationEffect();
    }

    private static VibrationEffect parseVibrationEffectFromFile(String filePath, Vibrator vibrator) {
        if (TextUtils.isEmpty(filePath) == true) goto L12;
        return VibrationXmlParser.parseDocument(new FileReader(filePath)).resolve(vibrator);
    L6:
        e = move-exception;
        Log.e(TAG, "Error parsing default shutdown vibration effect.", e);
        return null;
    L12:
        return null;
    }

    private static VibrationEffect createDefaultVibrationEffect() {
        return VibrationEffect.createOneShot(500, -1);
    }

    public ShutdownThreadSmtEx getSmtEx() {
        return this.mSmtEx;
    }

    private void actionPreDone() {
        Object r0 = this.mActionPreDoneSync;
        monitor-enter(r0);
        Log.d(TAG, "actionPreDone");     // Catch: Throwable -> L7
        this.mActionPreDone = true;     // Catch: Throwable -> L7
        this.mActionPreDoneSync.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void sendPreShutdownBroadcast() {
        if (mReboot == false) goto L5;
        return;
    L5:
        if (mRebootSafeMode == true) goto L36;
        Log.d(TAG, "sendPreShutdownBroadcast");
        this.mActionPreDone = false;
        Intent intent = new Intent(ACTION_PRE_SHUTDOWN);
        intent.addFlags(1342177280);
        Bundle opts = BroadcastOptions.makeBasic().setDeferralPolicy(2).toBundle();
        ActivityManagerInternal activityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        String[] requiredPermissions = {"android.permission.WRITE_SECURE_SETTINGS"};
        activityManagerInternal.broadcastIntentWithCallback(intent, new AnonymousClass8(this), requiredPermissions, -1, null, null, opts);
        long endTime = 15000 + SystemClock.elapsedRealtime();
        Object r1 = this.mActionPreDoneSync;
        monitor-enter(r1);
    L29:
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.mActionPreDone == true) goto L21;
        long delay = endTime - SystemClock.elapsedRealtime();     // Catch: Throwable -> L15
        if (delay <= 0) goto L13;
        this.mActionPreDoneSync.wait(Math.min(delay, 500));     // Catch: Throwable -> L15 InterruptedException -> L19
        goto L29
    L13:
        Log.w(TAG, "pre shutdown broadcast timed out");     // Catch: Throwable -> L15
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L15
        Log.d(TAG, "sendPreShutdownBroadcast, DONE");
        return;
    }
}
