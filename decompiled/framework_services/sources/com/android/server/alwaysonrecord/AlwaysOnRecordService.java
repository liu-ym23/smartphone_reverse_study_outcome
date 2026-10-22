package com.android.server.alwaysonrecord;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.alwaysonrecord.AlwaysOnRecordConfig;
import android.media.alwaysonrecord.IAlwaysOnRecordService;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.Log;
import android.util.Slog;
import com.android.server.SystemService;
import com.android.server.pm.PackageManagerService;
import com.android.server.utils.EventLogger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AlwaysOnRecordService extends IAlwaysOnRecordService.Stub {
    public static final String ALWAYS_ON_RECORD_SERVICE = "alwaysonrecord";
    private static final int DEFAULT_FILE_RECYCLE_CHECK_PERIOD_IN_MINUTE = 1440;
    private static final int DEFAULT_FILE_RECYCLE_PERIOD_IN_MINUTE = 4320;
    public static final boolean DISABLE_ALWAYS_ON_RECORD_SERVICE_DEFAULT_VALUE = false;
    public static final String DISABLE_ALWAYS_ON_RECORD_SERVICE_PROP = "persist.audio.alwaysonrecord.disable_service";
    static final int LOG_NB_EVENTS_FIRE = 256;
    static final int LOG_NB_EVENTS_SERVICE = 256;
    private static final int MAX_FILE_RECYCLE_PERIOD_IN_MINUTE = 10080;
    private static final long MAX_WAKE_UP_PERIOD_IN_DAYS = 1;
    private static final long MAX_WAKE_UP_PERIOD_IN_SECOND = 86400;
    private static final String SETTINS_FILE_RECYCLE_PERIOD_NAME = "AOR_FILE_RECYCLE_PERIOD_IN_MIN";
    private final boolean DEBUG;
    private final String TAG;
    private HashMap<Integer, RequestHolder> mActiveClients;
    private AlarmManager mAlarmManager;
    private AlwaysOnRecordReceiver mBroadcastReceiver;
    private ContentResolver mContentResolver;
    private Context mContext;
    private AudioDataArchiver mDataArchiver;
    private boolean mDeviceStorageLow;
    private final AlarmManager.OnAlarmListener mExpiredListener;
    private final AlarmManager.OnAlarmListener mFileRecycleExpiredListener;
    private int mFileRecyclePeriodInMinute;
    private final EventLogger mFireEventLogger;
    private AlarmHandler mHandler;
    private HandlerThread mHandlerThread;
    private AlwaysOnRecordHwWrapper mHwWrapper;
    private SessinIdGenerator mIdGenerator;
    private final EventLogger mServiceEventLogger;

    class AlarmHandler extends Handler {
        public static final int FIRE_EVENT = 0;
        public static final int FIRE_REASON_ALARM = 1;
        public static final int FIRE_REASON_FORCE_SYNC = 2;
        public static final int FIRE_REASON_START_RECORD = 0;
        public static final int FORCE_SYNC_RECORD = 4;
        public static final int PERSIST_FILE_RECYCLE_PERIOD = 3;
        public static final int RECYCLE_HISTORY_FILES = 2;
        public static final int UPDATE_ALARM_TIMER = 1;
        public static final int UPDATE_LAUNCH_TIME = 5;
        final /* synthetic */ AlwaysOnRecordService this$0;

        AlarmHandler(AlwaysOnRecordService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Log.v("AlwaysOnRecordService", "handleMessage " + msg.what);
            switch(msg.what) {
                case 0: goto L26;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L5;
                default: goto L4;
            };
        L4:
            Log.v("AlwaysOnRecordService", "Not recognized event:" + msg.what);
            return;
        L5:
            HashMap r0 = AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0);
            monitor-enter(r0);
            AlwaysOnRecordService.m1083$$Nest$mupdateLaunchTime(this.this$0);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L16:
            AlwaysOnRecordService.m1078$$Nest$mpersistFileRecyclePeriod(this.this$0, msg.arg1);
            return;
        L17:
            AlwaysOnRecordService.m1069$$Nest$fgetmDataArchiver(this.this$0).deleteOlderFiles(msg.arg1);
            AlwaysOnRecordService.m1082$$Nest$mupdateFileRecycleExpiredTimer(this.this$0);
            return;
        L18:
            HashMap r1 = AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0);
            monitor-enter(r1);
            AlwaysOnRecordService.m1081$$Nest$mupdateExpiredTimer(this.this$0);     // Catch: Throwable -> L23
            monitor-exit(r1);     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            throw th;
        L26:
            int fireReason = msg.arg1;
            if (msg.obj != null) goto L36;
            HashMap r2 = AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0);
            monitor-enter(r2);
            AlwaysOnRecordService.m1074$$Nest$mfireIntent(this.this$0, AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0).values(), fireReason);     // Catch: Throwable -> L33
            monitor-exit(r2);     // Catch: Throwable -> L33
            return;
        L33:
            th = move-exception;
            throw th;
        L36:
            AlwaysOnRecordService.m1074$$Nest$mfireIntent(this.this$0, (Collection) msg.obj, fireReason);
            return;
        L14:
            if (AlwaysOnRecordService.m1075$$Nest$mforceSyncRecordInBackground(this.this$0) == 0) goto L46;
            Log.e("AlwaysOnRecordService", "forceSyncRecordInBackground failed");
            return;
        }
    }

    private class AlwaysOnRecordReceiver extends BroadcastReceiver {
        final /* synthetic */ AlwaysOnRecordService this$0;

        public AlwaysOnRecordReceiver(AlwaysOnRecordService r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.v("AlwaysOnRecordService", "intent is received " + intent.toString());
            if ("android.intent.action.DEVICE_STORAGE_LOW".equals(intent.getAction()) == false) goto L16;
            AlwaysOnRecordService.m1073$$Nest$fputmDeviceStorageLow(this.this$0, true);
            HashMap r0 = AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0).size() <= 0) goto L11;
            AlwaysOnRecordService.m1077$$Nest$mnotifyStoragLow(this.this$0, true);     // Catch: Throwable -> L9
            AlwaysOnRecordService.m1080$$Nest$mstopAlwaysRecordMiddleware(this.this$0);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L16:
            if ("android.intent.action.DEVICE_STORAGE_OK".equals(intent.getAction()) == false) goto L29;
            AlwaysOnRecordService.m1073$$Nest$fputmDeviceStorageLow(this.this$0, false);
            HashMap r1 = AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0);
            monitor-enter(r1);
        L22:
            th = move-exception;
            throw th;
        L20:
            if (AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0).size() <= 0) goto L24;
            AlwaysOnRecordService.m1077$$Nest$mnotifyStoragLow(this.this$0, false);     // Catch: Throwable -> L22
            AlwaysOnRecordService.m1079$$Nest$mstartAlwaysRecordMiddleware(this.this$0);     // Catch: Throwable -> L22
        L24:
            monitor-exit(r1);     // Catch: Throwable -> L22
            return;
        L29:
            if ("android.intent.action.TIME_SET".equals(intent.getAction()) == false) goto L31;
        L34:
            HashMap r2 = AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0);
            monitor-enter(r2);
        L41:
            th = move-exception;
            throw th;
        L37:
            if (AlwaysOnRecordService.m1068$$Nest$fgetmActiveClients(this.this$0).size() > 0) goto L39;
        L47:
            monitor-exit(r2);     // Catch: Throwable -> L41
            return;
        L39:
            if (AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).hasMessages(4) == true) goto L44;
            AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).sendMessage(AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).obtainMessage(4));     // Catch: Throwable -> L41
        L44:
            if (AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).hasMessages(5) == true) goto L46;
            AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).sendMessage(AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).obtainMessage(5));     // Catch: Throwable -> L41
        L46:
            AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).sendMessage(AlwaysOnRecordService.m1071$$Nest$fgetmHandler(this.this$0).obtainMessage(1));     // Catch: Throwable -> L41
            AlwaysOnRecordService.m1072$$Nest$fgetmServiceEventLogger(this.this$0).enqueue(new AlwaysOnRecordEvents.ServiceEvent(intent.getAction(), 0, PackageManagerService.PLATFORM_PACKAGE_NAME));     // Catch: Throwable -> L41
            goto L47
        L31:
            if ("android.intent.action.TIMEZONE_CHANGED".equals(intent.getAction()) == true) goto L34;
            if ("android.intent.action.DATE_CHANGED".equals(intent.getAction()) == true) goto L34;
        }
    }

    public static final class Lifecycle extends SystemService {
        private AlwaysOnRecordService mService;

        public Lifecycle(Context context) {
            super(context);
            this.mService = new AlwaysOnRecordService(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            publishBinderService(AlwaysOnRecordService.ALWAYS_ON_RECORD_SERVICE, this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 520) goto L6;
            AlwaysOnRecordService.m1076$$Nest$minitializeHardare(this.mService);
            return;
        }
    }

    private class SessinIdGenerator {
        private final int SESSION_ID_BASE;
        private int mCurrentId;

        public SessinIdGenerator(AlwaysOnRecordService r1) {
            this.SESSION_ID_BASE = 1;
            this.mCurrentId = 1;
        }

        synchronized int generateNewId() {
            monitor-enter(this);
            int r0 = this.mCurrentId;     // Catch: Throwable -> L6
            this.mCurrentId = r0 + 1;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean idValidSessionId(int id) {
            monitor-enter(this);
            if (id <= this.mCurrentId) goto L6;
            boolean r0 = true;
        L7:
            monitor-exit(this);
            return r0;
        L6:
            r0 = false;
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveClients, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m1068$$Nest$fgetmActiveClients(AlwaysOnRecordService r0) {
        return r0.mActiveClients;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataArchiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioDataArchiver m1069$$Nest$fgetmDataArchiver(AlwaysOnRecordService r0) {
        return r0.mDataArchiver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFileRecyclePeriodInMinute, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1070$$Nest$fgetmFileRecyclePeriodInMinute(AlwaysOnRecordService r0) {
        return r0.mFileRecyclePeriodInMinute;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ AlarmHandler m1071$$Nest$fgetmHandler(AlwaysOnRecordService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventLogger m1072$$Nest$fgetmServiceEventLogger(AlwaysOnRecordService r0) {
        return r0.mServiceEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDeviceStorageLow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1073$$Nest$fputmDeviceStorageLow(AlwaysOnRecordService r0, boolean r1) {
        r0.mDeviceStorageLow = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mfireIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1074$$Nest$mfireIntent(AlwaysOnRecordService r0, Collection r1, int r2) {
        r0.fireIntent(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mforceSyncRecordInBackground, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1075$$Nest$mforceSyncRecordInBackground(AlwaysOnRecordService r0) {
        return r0.forceSyncRecordInBackground();
    }

    /* JADX INFO: renamed from: -$$Nest$minitializeHardare, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1076$$Nest$minitializeHardare(AlwaysOnRecordService r0) {
        r0.initializeHardare();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyStoragLow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1077$$Nest$mnotifyStoragLow(AlwaysOnRecordService r0, boolean r1) {
        r0.notifyStoragLow(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpersistFileRecyclePeriod, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1078$$Nest$mpersistFileRecyclePeriod(AlwaysOnRecordService r0, int r1) {
        r0.persistFileRecyclePeriod(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartAlwaysRecordMiddleware, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1079$$Nest$mstartAlwaysRecordMiddleware(AlwaysOnRecordService r0) {
        return r0.startAlwaysRecordMiddleware();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopAlwaysRecordMiddleware, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1080$$Nest$mstopAlwaysRecordMiddleware(AlwaysOnRecordService r0) {
        return r0.stopAlwaysRecordMiddleware();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateExpiredTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1081$$Nest$mupdateExpiredTimer(AlwaysOnRecordService r0) {
        r0.updateExpiredTimer();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateFileRecycleExpiredTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1082$$Nest$mupdateFileRecycleExpiredTimer(AlwaysOnRecordService r0) {
        r0.updateFileRecycleExpiredTimer();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateLaunchTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1083$$Nest$mupdateLaunchTime(AlwaysOnRecordService r0) {
        r0.updateLaunchTime();
    }

    public AlwaysOnRecordService(Context context) {
        this.TAG = "AlwaysOnRecordService";
        this.DEBUG = true;
        this.mServiceEventLogger = new EventLogger(256, "Service event");
        this.mFireEventLogger = new EventLogger(256, "Fire event");
        this.mActiveClients = new HashMap();
        this.mExpiredListener = new AnonymousClass1(this);
        this.mFileRecycleExpiredListener = new AnonymousClass2(this);
        this.mContext = context;
        this.mIdGenerator = new SessinIdGenerator(this);
        AlarmManager r1 = (AlarmManager) this.mContext.getSystemService(AlarmManager.class);
        r1.getClass();
        this.mAlarmManager = r1;
        this.mHandlerThread = new HandlerThread("AlwaysOnRecordService");
        this.mHandlerThread.start();
        this.mHandler = new AlarmHandler(this, this.mHandlerThread.getLooper());
        this.mContentResolver = context.getContentResolver();
        this.mFileRecyclePeriodInMinute = retrieveFileRecyclePeriod();
        this.mDeviceStorageLow = false;
        this.mBroadcastReceiver = new AlwaysOnRecordReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.DATE_CHANGED");
        this.mContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
    }

    private void initializeHardare() {
        if (isFeatureDisabled() == false) goto L5;
        return;
    L5:
        this.mHwWrapper = new AlwaysOnRecordHwWrapper();
        this.mDataArchiver = new AudioDataArchiver();
        this.mHwWrapper.registerListener(this.mDataArchiver);
    }

    public int generateSessionId() {
        if (checkPermission(new String("generateSessionId")) == false) goto L7;
        return this.mIdGenerator.generateNewId();
    L7:
        throw new SecurityException("Missing permission");
    }

    public boolean validateSessionId(int sessionId) {
        if (checkPermission(new String("validateSessionId")) == false) goto L18;
        HashMap<Integer, RequestHolder> r1 = this.mActiveClients;
        monitor-enter(r1);
        boolean isUsed = this.mActiveClients.containsKey(Integer.valueOf(sessionId));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (this.mIdGenerator.idValidSessionId(sessionId) == false) goto L12;
        if (isUsed == false) goto L12;
        return true;
    L12:
        return false;
    L14:
        th = move-exception;
        throw th;
    L18:
        throw new SecurityException("Missing permission");
    }

    public int getSessionId(PendingIntent callbackIntent) {
        if (checkPermission(new String("getSessionId")) == false) goto L39;
        long ident = Binder.clearCallingIdentity();
        if (callbackIntent != null) goto L41;
    L34:
        Log.e("AlwaysOnRecordService", "Pending intent or intent is null");     // Catch: Throwable -> L30
        throw new IllegalArgumentException("Invalid pending intent");     // Catch: Throwable -> L30
    L41:
    L30:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L7:
        if (callbackIntent.getIntent() == null) goto L34;
        if (callbackIntent.isImmutable() == true) goto L33;
        HashMap<Integer, RequestHolder> r2 = this.mActiveClients;     // Catch: Throwable -> L30
        monitor-enter(r2);     // Catch: Throwable -> L30
        Iterator<Map.Entry<Integer, RequestHolder>> iterator = this.mActiveClients.entrySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (iterator.hasNext() == false) goto L25;
        Map.Entry<Integer, RequestHolder> entry = iterator.next();     // Catch: Throwable -> L21
        if (entry.getValue().getPendingIntent().getIntent().filterEquals(callbackIntent.getIntent()) == false) goto L14;
        int r5 = entry.getKey().intValue();     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(ident);
        return r5;
    L25:
        monitor-exit(r2);     // Catch: Throwable -> L21
        Binder.restoreCallingIdentity(ident);
        return 0;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L33:
        throw new IllegalArgumentException("Invalid pending intent flags, mutable is required");     // Catch: Throwable -> L30
    L39:
        throw new SecurityException("Missing permission");
    }

    public void setFileRecyclePeriod(int periodInMin) {
        if (isFeatureDisabled() == false) goto L6;
        return;
    L6:
        if (checkPermission(new String("setFileRecyclePeriod")) == false) goto L23;
        if (periodInMin >= this.mHwWrapper.getMinWakeupPeriodInMinute()) goto L10;
    L20:
        Log.e("AlwaysOnRecordService", "Invalid recycle period: " + periodInMin);
        throw new IllegalArgumentException("Invalid recycle period");
    L10:
        if (periodInMin > 10080) goto L20;
        if (periodInMin != this.mFileRecyclePeriodInMinute) goto L15;
        Log.w("AlwaysOnRecordService", "No change on file recycle period");
        return;
    L15:
        this.mFileRecyclePeriodInMinute = periodInMin;
        if (isRecordActive() == false) goto L18;
        this.mHandler.removeMessages(2);
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, periodInMin, 0));
    L18:
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, periodInMin, 0));
        return;
    L23:
        throw new SecurityException("Missing permission");
    }

    public int getFileRecyclePeriod() {
        return this.mFileRecyclePeriodInMinute;
    }

    public int startRecordInBackgroundWithoutAutoClean(int sessionId, AlwaysOnRecordConfig config, PendingIntent callbackIntent, String packageName) {
        Slog.i("AlwaysOnRecordService", "startRecordInBackgroundWithoutAutoClean: " + sessionId);
        if (isFeatureDisabled() == false) goto L7;
        return -3;
    L7:
        if (checkPermission(new String("startRecordInBackgroundWithoutAutoClean")) == false) goto L51;
        if (isValidRecordMode(config.getRecordingMode()) == false) goto L49;
        if (isValidWakeupPeriod(config.getWakeUpPeriod()) == false) goto L49;
        if (callbackIntent.isImmutable() == true) goto L45;
        RequestHolder holder = new RequestHolder(this.mContext, sessionId, config, callbackIntent, packageName);
        if (holder.verifyFireWorks() == false) goto L43;
        if (this.mDeviceStorageLow == false) goto L20;
        Log.e("AlwaysOnRecordService", "Device storage is low, cannot start record");
        return -4;
    L20:
        this.mServiceEventLogger.enqueue(new AlwaysOnRecordEvents.ServiceEvent("startRecordInBackgroundWithoutAutoClean", sessionId, packageName));
        HashMap<Integer, RequestHolder> r8 = this.mActiveClients;
        monitor-enter(r8);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (this.mActiveClients.containsKey(Integer.valueOf(sessionId)) == false) goto L30;
        Log.w("AlwaysOnRecordService", "This session has been started before: " + sessionId);     // Catch: Throwable -> L27
        monitor-exit(r8);     // Catch: Throwable -> L27
        return 0;
    L30:
        if (this.mActiveClients.size() != 0) goto L35;
        int status = startAlwaysRecordMiddleware();     // Catch: Throwable -> L27
        if (status == 0) goto L35;
        monitor-exit(r8);     // Catch: Throwable -> L27
        return status;
    L35:
        this.mDataArchiver.registArchiveListener(holder);     // Catch: Throwable -> L27
        this.mActiveClients.put(Integer.valueOf(sessionId), holder);     // Catch: Throwable -> L27
        holder.logConstructorMetrics();     // Catch: Throwable -> L27
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));     // Catch: Throwable -> L27
        this.mHandler.sendMessage(this.mHandler.obtainMessage(0, 0, 0));     // Catch: Throwable -> L27
        if (this.mHandler.hasMessages(2) == true) goto L38;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, this.mFileRecyclePeriodInMinute, 0));     // Catch: Throwable -> L27
    L38:
        monitor-exit(r8);     // Catch: Throwable -> L27
        return 0;
    L43:
        throw new IllegalArgumentException("Invalid pending intent to send");
    L45:
        throw new IllegalArgumentException("Invalid pending intent flags, mutable is required");
    L49:
        throw new IllegalArgumentException("Invalid recording mode: " + config.getRecordingMode() + ", or wake up period:" + config.getWakeUpPeriod());
    L51:
        throw new SecurityException("Missing permission");
    }

    public int stopRecordInBackground(int sessionId) {
        Slog.i("AlwaysOnRecordService", "stopRecordInBackground: " + sessionId);
        if (isFeatureDisabled() == false) goto L7;
        return -3;
    L7:
        if (checkPermission(new String("stopRecordInBackground")) == false) goto L25;
        HashMap<Integer, RequestHolder> r0 = this.mActiveClients;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L11:
        if (this.mActiveClients.containsKey(Integer.valueOf(sessionId)) == true) goto L18;
        Log.w("AlwaysOnRecordService", "Invalid session Id:" + sessionId);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return -2;
    L18:
        this.mServiceEventLogger.enqueue(new AlwaysOnRecordEvents.ServiceEvent("stopRecordInBackground", sessionId, this.mActiveClients.get(Integer.valueOf(sessionId)).getPackageName()));     // Catch: Throwable -> L16
        forceSyncRecordInBackground();     // Catch: Throwable -> L16
        removeClientsAndUpdate(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(sessionId)})), true);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return 0;
    L25:
        throw new SecurityException("Missing permission");
    }

    private int forceSyncRecordInBackground() {
        return this.mHwWrapper.forceSyncRecord();
    }

    public boolean isRecordActive() {
        if (isFeatureDisabled() == false) goto L7;
        return false;
    L7:
        return this.mHwWrapper.isStarted();
    }

    public boolean isRecordSessionActive(int sessionId) {
        Log.d("AlwaysOnRecordService", "isRecordSessionActive: " + sessionId);
        if (isFeatureDisabled() == false) goto L6;
        return false;
    L6:
        HashMap<Integer, RequestHolder> r0 = this.mActiveClients;
        monitor-enter(r0);
        boolean r1 = this.mActiveClients.containsKey(Integer.valueOf(sessionId));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private void broadcastRecordStateChanged(boolean isActive) {
        Intent intent = new Intent("android.media.alwaysonrecord.ACTION_ALWAYS_ON_RECORD_STATE_CHANGED").putExtra("android.media.EXTRA_RECORD_STATE", isActive);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        long ident = Binder.clearCallingIdentity();
        this.mContext.sendBroadcastAsUser(intent, UserHandle.ALL, null, null);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private boolean checkPermission(String method) {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        if (this.mContext.checkPermission("android.permission.MANAGE_ALWAYS_ON_RECORD", pid, uid) != 0) goto L5;
        boolean granted = true;
    L6:
        if (granted == true) goto L8;
        Log.e("AlwaysOnRecordService", "Missing permission for uid:" + uid + ", pid:" + pid + " when calling " + method);
    L8:
        return granted;
    L5:
        granted = false;
        goto L6
    }

    private boolean isValidRecordMode(int mode) {
        if (mode != 0) goto L4;
        return true;
    L4:
        return false;
    }

    private boolean isValidWakeupPeriod(long periodInSec) {
        if (periodInSec > 0) goto L5;
    L7:
        return false;
    L5:
        if (periodInSec >= MAX_WAKE_UP_PERIOD_IN_SECOND) goto L7;
        return true;
    }

    private int startAlwaysRecordMiddleware() {
        if (this.mHwWrapper.isStarted() == false) goto L6;
        Log.w("AlwaysOnRecordService", "HAL is already started");
        return 0;
    L6:
        int status = this.mHwWrapper.prepare();
        if (status == 0) goto L10;
        Log.e("AlwaysOnRecordService", "prepare Record failed, status: " + status);
        return status;
    L10:
        int status2 = this.mHwWrapper.startRecord();
        if (status2 == 0) goto L13;
        Log.e("AlwaysOnRecordService", "start Record failed, status: " + status2);
        this.mHwWrapper.destroy();
    L14:
        return status2;
    L13:
        broadcastRecordStateChanged(true);
        goto L14
    }

    private int stopAlwaysRecordMiddleware() {
        if (this.mHwWrapper.isReady() == true) goto L7;
        Log.e("AlwaysOnRecordService", "HAL is not ready, cannot stop record");
        return -1;
    L7:
        if (this.mHwWrapper.isStarted() == true) goto L10;
        Log.w("AlwaysOnRecordService", "HAL is not started before");
        return 0;
    L10:
        this.mHwWrapper.stopRecord();
        this.mHwWrapper.destroy();
        broadcastRecordStateChanged(false);
        return 0;
    }

    private boolean isFeatureDisabled() {
        return SystemProperties.getBoolean(DISABLE_ALWAYS_ON_RECORD_SERVICE_PROP, false);
    }

    private int retrieveFileRecyclePeriod() {
        return Settings.System.getIntForUser(this.mContentResolver, SETTINS_FILE_RECYCLE_PERIOD_NAME, DEFAULT_FILE_RECYCLE_PERIOD_IN_MINUTE, -2);
    }

    private void persistFileRecyclePeriod(int periodInMin) {
        long callingIdentity = Binder.clearCallingIdentity();
        Settings.System.putIntForUser(this.mContentResolver, SETTINS_FILE_RECYCLE_PERIOD_NAME, periodInMin, -2);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(callingIdentity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    }

    private void updateFileRecycleExpiredTimer() {
        int periodInMin = Math.min(this.mFileRecyclePeriodInMinute, DEFAULT_FILE_RECYCLE_CHECK_PERIOD_IN_MINUTE);
        Log.v("AlwaysOnRecordService", "updateFileRecycleExpiredTimer: " + periodInMin);
        long targetMillis = System.currentTimeMillis() + (((long) (periodInMin * 60)) * 1000);
        this.mAlarmManager.setExact(0, targetMillis, "AlwaysOnRecordService-FileRecycle", this.mFileRecycleExpiredListener, this.mHandler);
    }

    private void cancelFileRecycleExpiredTimer() {
        Log.v("AlwaysOnRecordService", "cancelFileRecycleExpiredTimer");
        this.mAlarmManager.cancel(this.mFileRecycleExpiredListener);
        this.mHandler.removeMessages(2);
    }

    private void updateExpiredTimer() {
        Log.v("AlwaysOnRecordService", "updateExpiredTimer");
        long expiredTimeInMillis = 86400000;
        if (this.mActiveClients.size() != 0) goto L5;
        return;
    L5:
        Iterator<RequestHolder> r0 = this.mActiveClients.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L16;
        RequestHolder client = r0.next();
        if (client.supportToFireIntent() == false) goto L7;
        long expectedTimeMillis = client.getNextExpiredTimeMillis();
        if (expiredTimeInMillis <= expectedTimeMillis) goto L7;
        expiredTimeInMillis = expectedTimeMillis;
        goto L7
    L16:
        if (expiredTimeInMillis != 86400000) goto L19;
        Log.v("AlwaysOnRecordService", "no need to update AlarmManager");
        return;
    L19:
        long targetMillis = System.currentTimeMillis() + expiredTimeInMillis;
        Log.v("AlwaysOnRecordService", "targetMillis:" + targetMillis + ", expiredTimeInMillis:" + expiredTimeInMillis);
        this.mAlarmManager.setExact(0, targetMillis, "AlwaysOnRecordService", this.mExpiredListener, this.mHandler);
    }

    private void cancelExpiredTimer() {
        Log.v("AlwaysOnRecordService", "cancelExpiredTimer");
        this.mAlarmManager.cancel(this.mExpiredListener);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(0);
    }

    private void fireIntent(Collection<RequestHolder> clients, int fireReason) {
        ArrayList<Integer> succeedClientSessionIds = new ArrayList();
        ArrayList<Integer> retryClientSessionIds = new ArrayList();
        ArrayList<Integer> failedClientSessionIds = new ArrayList();
        if (clients.size() != 0) goto L6;
        this.mFireEventLogger.enqueue(new AlwaysOnRecordEvents.FireEvent(fireReason, succeedClientSessionIds, retryClientSessionIds, failedClientSessionIds));
        return;
    L6:
        boolean shouldForceSync = false;
        ArrayList<RequestHolder> retryClients = new ArrayList();
        Iterator<RequestHolder> r6 = clients.iterator();
    L8:
        if (r6.hasNext() == false) goto L19;
        RequestHolder client = r6.next();
        if (client.readyToFire() == false) goto L8;
        switch(client.fire(getStatusCode())) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L15;
            default: goto L8;
        };
    L15:
        failedClientSessionIds.add(Integer.valueOf(client.getSessionId()));
        goto L8
    L16:
        retryClients.add(client);
        shouldForceSync = true;
        retryClientSessionIds.add(Integer.valueOf(client.getSessionId()));
        goto L8
    L17:
        succeedClientSessionIds.add(Integer.valueOf(client.getSessionId()));
        goto L8
    L19:
        this.mFireEventLogger.enqueue(new AlwaysOnRecordEvents.FireEvent(fireReason, succeedClientSessionIds, retryClientSessionIds, failedClientSessionIds));
        if (shouldForceSync == false) goto L22;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, 2, 0, retryClients), 300);
    L22:
        removeClientsAndUpdate(failedClientSessionIds, false);
    }

    private void removeClientsAndUpdate(ArrayList<Integer> clientSessionIds, boolean shouldFireEvent) {
        if (clientSessionIds.size() != 0) goto L5;
        return;
    L5:
        Iterator<Integer> r0 = clientSessionIds.iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        Integer sessionId = r0.next();
        RequestHolder holder = this.mActiveClients.remove(sessionId);
        if (shouldFireEvent == false) goto L11;
        holder.fire(getStatusCode());
    L11:
        this.mDataArchiver.unregistArchiveListener(holder);
        holder.logDestructorMetrics();
        goto L7
    L13:
        if (this.mActiveClients.isEmpty() == false) goto L15;
        stopAlwaysRecordMiddleware();
        cancelExpiredTimer();
        cancelFileRecycleExpiredTimer();
        return;
    L15:
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
    }

    private void updateLaunchTime() {
        if (this.mActiveClients.size() != 0) goto L5;
        return;
    L5:
        Iterator<RequestHolder> r0 = this.mActiveClients.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        RequestHolder client = r0.next();
        client.fire(getStatusCode());
        client.updateLaunchTime();
        goto L7
    }

    private void notifyStoragLow(boolean isStoragelow) {
        if (this.mActiveClients.size() != 0) goto L5;
        return;
    L5:
        Iterator<RequestHolder> r0 = this.mActiveClients.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        RequestHolder client = r0.next();
        client.fireStorageLowStateEvent(isStoragelow);
        goto L7
    }

    private int getStatusCode() {
        if (this.mDeviceStorageLow == false) goto L6;
        return -4;
    L6:
        return 0;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (isFeatureDisabled() == false) goto L5;
        return;
    L5:
        pw.println("Always on record service:");
        pw.println("\nmFileRecyclePeriodInMinute: " + this.mFileRecyclePeriodInMinute);
        pw.println("DeviceStorageLow: " + this.mDeviceStorageLow);
        pw.println("\nClients:");
        Iterator<RequestHolder> r0 = this.mActiveClients.values().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        RequestHolder client = r0.next();
        client.dump(pw);
        goto L7
    L9:
        pw.println("\nAudio data archiver: ");
        this.mDataArchiver.dump(pw);
        pw.println("\nHW wrapper: ");
        this.mHwWrapper.dump(pw);
        pw.println("\nEvent Logs:");
        this.mServiceEventLogger.dump(pw);
        pw.println("\n");
        this.mFireEventLogger.dump(pw);
        pw.println("\n");
        this.mHwWrapper.mDataAvailableEventLogger.dump(pw);
        pw.println("\n");
        this.mDataArchiver.mDataRecycleEventLogger.dump(pw);
    }
}
