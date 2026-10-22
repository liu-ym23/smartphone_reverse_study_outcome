package com.android.server.backup;

import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.AlarmManager;
import android.app.AppGlobals;
import android.app.IActivityManager;
import android.app.PendingIntent;
import android.app.backup.BackupAgent;
import android.app.backup.BackupRestoreEventLogger;
import android.app.backup.IBackupManager;
import android.app.backup.IBackupManagerMonitor;
import android.app.backup.IBackupObserver;
import android.app.backup.IFullBackupRestoreObserver;
import android.app.backup.IRestoreSession;
import android.app.backup.ISelectBackupTransportCallback;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.PowerSaveState;
import android.os.RemoteException;
import android.os.SELinux;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.FeatureFlagUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.Preconditions;
import com.android.server.AppWidgetBackupBridge;
import com.android.server.EventLogTags;
import com.android.server.LocalServices;
import com.android.server.am.HostingRecord;
import com.android.server.backup.fullbackup.FullBackupEntry;
import com.android.server.backup.fullbackup.PerformFullTransportBackupTask;
import com.android.server.backup.internal.BackupHandler;
import com.android.server.backup.internal.ClearDataObserver;
import com.android.server.backup.internal.LifecycleOperationStorage;
import com.android.server.backup.internal.OnTaskFinishedListener;
import com.android.server.backup.internal.PerformInitializeTask;
import com.android.server.backup.internal.RunInitializeReceiver;
import com.android.server.backup.internal.SetupObserver;
import com.android.server.backup.keyvalue.BackupRequest;
import com.android.server.backup.params.AdbBackupParams;
import com.android.server.backup.params.AdbParams;
import com.android.server.backup.params.AdbRestoreParams;
import com.android.server.backup.params.BackupParams;
import com.android.server.backup.params.ClearParams;
import com.android.server.backup.params.ClearRetryParams;
import com.android.server.backup.params.RestoreParams;
import com.android.server.backup.restore.ActiveRestoreSession;
import com.android.server.backup.restore.PerformUnifiedRestoreTask;
import com.android.server.backup.transport.BackupTransportClient;
import com.android.server.backup.transport.TransportConnection;
import com.android.server.backup.transport.TransportNotAvailableException;
import com.android.server.backup.transport.TransportNotRegisteredException;
import com.android.server.backup.utils.BackupEligibilityRules;
import com.android.server.backup.utils.BackupManagerMonitorDumpsysUtils;
import com.android.server.backup.utils.BackupManagerMonitorEventSender;
import com.android.server.backup.utils.BackupObserverUtils;
import com.android.server.backup.utils.SparseArrayUtils;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.wm.ActivityTaskManagerService;
import com.google.android.collect.Sets;
import dalvik.annotation.optimization.NeverCompile;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/* JADX INFO: loaded from: classes.dex */
public class UserBackupManagerService {
    public static final String BACKUP_FILE_HEADER_MAGIC = "ANDROID BACKUP\n";
    public static final int BACKUP_FILE_VERSION = 5;
    private static final String BACKUP_FINISHED_ACTION = "android.intent.action.BACKUP_FINISHED";
    private static final String BACKUP_FINISHED_PACKAGE_EXTRA = "packageName";
    public static final String BACKUP_MANIFEST_FILENAME = "_manifest";
    public static final int BACKUP_MANIFEST_VERSION = 1;
    public static final String BACKUP_METADATA_FILENAME = "_meta";
    public static final int BACKUP_METADATA_VERSION = 1;
    public static final int BACKUP_WIDGET_METADATA_TOKEN = 33549569;
    private static final int BUSY_BACKOFF_FUZZ = 7200000;
    private static final long BUSY_BACKOFF_MIN_MILLIS = 3600000;
    private static final long CLEAR_DATA_TIMEOUT_INTERVAL = 30000;
    private static final int CURRENT_ANCESTRAL_RECORD_VERSION = 1;
    private static final long INITIALIZATION_DELAY_MILLIS = 3000;
    private static final String INIT_SENTINEL_FILE_NAME = "_need_init_";
    public static final String KEY_WIDGET_STATE = "￭￭widget";
    public static final String PACKAGE_MANAGER_SENTINEL = "@pm@";
    public static final String RUN_INITIALIZE_ACTION = "android.app.backup.intent.INIT";
    private static final int SCHEDULE_FILE_VERSION = 1;
    private static final String SERIAL_ID_FILE = "serial_id";
    public static final String SETTINGS_PACKAGE = "com.android.providers.settings";
    public static final String SHARED_BACKUP_AGENT_PACKAGE = "com.android.sharedstoragebackup";
    public static final String TELEPHONY_PROVIDER_PACKAGE = "com.android.providers.telephony";
    private static final long TIMEOUT_FULL_CONFIRMATION = 60000;
    private static final long TRANSPORT_RETRY_INTERVAL = 3600000;
    public static final String WALLPAPER_PACKAGE = "com.android.wallpaperbackup";
    private ActiveRestoreSession mActiveRestoreSession;
    private final IActivityManager mActivityManager;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final SparseArray<AdbParams> mAdbBackupRestoreConfirmations;
    private final BackupAgentTimeoutParameters mAgentTimeoutParameters;
    private final AlarmManager mAlarmManager;
    private volatile long mAncestralBackupDestination;
    private Set<String> mAncestralPackages;
    private File mAncestralSerialNumberFile;
    private long mAncestralToken;
    private boolean mAutoRestore;
    private final BackupAgentConnectionManager mBackupAgentConnectionManager;
    private final BackupHandler mBackupHandler;
    private final IBackupManager mBackupManagerBinder;
    private final SparseArray<HashSet<String>> mBackupParticipants;
    private final BackupPasswordManager mBackupPasswordManager;
    private final UserBackupPreferences mBackupPreferences;
    private volatile boolean mBackupRunning;
    private final File mBaseStateDir;
    private final Object mClearDataLock;
    private volatile boolean mClearingData;
    private final BackupManagerConstants mConstants;
    private final Context mContext;
    private long mCurrentToken;
    private final File mDataDir;
    private boolean mEnabled;
    private ArrayList<FullBackupEntry> mFullBackupQueue;
    private final File mFullBackupScheduleFile;
    private Runnable mFullBackupScheduleWriter;
    private boolean mIsRestoreInProgress;
    private DataChangedJournal mJournal;
    private final File mJournalDir;
    private volatile long mLastBackupPass;
    private final String mLogIdMsg;
    private final AtomicInteger mNextToken;
    private final LifecycleOperationStorage mOperationStorage;
    private final PackageManager mPackageManager;
    private final IPackageManager mPackageManagerBinder;
    private BroadcastReceiver mPackageTrackingReceiver;
    private final HashMap<String, BackupRequest> mPendingBackups;
    private final ArraySet<String> mPendingInits;
    private final Queue<PerformUnifiedRestoreTask> mPendingRestores;
    private PowerManager mPowerManager;
    private ProcessedPackagesJournal mProcessedPackagesJournal;
    private final Object mQueueLock;
    private final long mRegisterTransportsRequestedTime;
    private final SecureRandom mRng;
    private final PendingIntent mRunInitIntent;
    private final BroadcastReceiver mRunInitReceiver;
    private PerformFullTransportBackupTask mRunningFullBackupTask;
    private final BackupEligibilityRules mScheduledBackupEligibility;
    private boolean mSetupComplete;
    private final ContentObserver mSetupObserver;
    private File mTokenFile;
    private final Random mTokenGenerator;
    private final TransportManager mTransportManager;
    private final int mUserId;
    private final BackupWakeLock mWakelock;

    /* JADX INFO: renamed from: com.android.server.backup.UserBackupManagerService$2, reason: invalid class name */
    class AnonymousClass2 extends BroadcastReceiver {
        final /* synthetic */ UserBackupManagerService this$0;

        public static /* synthetic */ void $r8$lambda$FSrn3Khd_osfuiMCQcrEs0JWBao(AnonymousClass2 r0, String r1) {
            r0.lambda$onReceive$1(r1);
        }

        public static /* synthetic */ void $r8$lambda$GXD1lh2DRbXZk3YfuMD1mEBa0H8(AnonymousClass2 r0, String r1, String[] r2) {
            r0.lambda$onReceive$0(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$vXK9N_a7d_goTyZJ8YiMwNjzmFg(AnonymousClass2 r0, String r1) {
            r0.lambda$onReceive$2(r1);
        }

        AnonymousClass2(UserBackupManagerService this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            String[] packageList = null;
            if ("android.intent.action.PACKAGE_ADDED".equals(action) == false) goto L5;
        L16:
            Uri uri = intent.getData();
            if (uri != null) goto L19;
            return;
        L19:
            final String packageName = uri.getSchemeSpecificPart();
            if (packageName == null) goto L22;
            packageList = new String[]{packageName};
        L22:
            boolean changed = "android.intent.action.PACKAGE_CHANGED".equals(action);
            if (changed == false) goto L26;
            final String[] components = intent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
            UserBackupManagerService.m2506$$Nest$fgetmBackupHandler(this.this$0).post(new UserBackupManagerService$2$$ExternalSyntheticLambda0(this, packageName, components));
            return;
        L26:
            boolean added = "android.intent.action.PACKAGE_ADDED".equals(action);
            boolean replacing = extras.getBoolean("android.intent.extra.REPLACING", false);
            String[] packageList2 = packageList;
            boolean changed2 = added;
            boolean added2 = replacing;
        L27:
            if (packageList2 == null) goto L93;
            if (packageList2.length == 0) goto L116;
            int uid = extras.getInt("android.intent.extra.UID");
            if (changed2 == false) goto L78;
            SparseArray r11 = UserBackupManagerService.m2507$$Nest$fgetmBackupParticipants(this.this$0);
            monitor-enter(r11);
            if (added2 == false) goto L106;
            UserBackupManagerService.m2519$$Nest$mremovePackageParticipantsLocked(this.this$0, packageList2, uid);     // Catch: Throwable -> L38
        L38:
            th = th;
        L94:
            monitor-exit(r11);     // Catch: Throwable -> L75
            throw th;
        L75:
            th = th;
        L106:
            UserBackupManagerService.m2516$$Nest$maddPackageParticipantsLocked(this.this$0, packageList2);     // Catch: Throwable -> L71
            monitor-exit(r11);     // Catch: Throwable -> L71
            long now = System.currentTimeMillis();
            int r13 = packageList2.length;
            int r14 = 0;
        L43:
            if (r14 >= r13) goto L70;
            final String packageName2 = packageList2[r14];
            PackageInfo app = UserBackupManagerService.m2511$$Nest$fgetmPackageManager(this.this$0).getPackageInfoAsUser(packageName2, 0, UserBackupManagerService.m2515$$Nest$fgetmUserId(this.this$0));     // Catch: PackageManager.NameNotFoundException -> L54
            if (UserBackupManagerService.m2513$$Nest$fgetmScheduledBackupEligibility(this.this$0).appGetsFullBackup(app) == false) goto L58;
            if (UserBackupManagerService.m2513$$Nest$fgetmScheduledBackupEligibility(this.this$0).appIsEligibleForBackup(app.applicationInfo) == false) goto L58;
            this.this$0.enqueueFullBackup(packageName2, now);     // Catch: PackageManager.NameNotFoundException -> L54
            action = action;
            this.this$0.scheduleNextFullBackupJob(0);     // Catch: PackageManager.NameNotFoundException -> L52
        L63:
            UserBackupManagerService.m2506$$Nest$fgetmBackupHandler(this.this$0).post(new UserBackupManagerService$2$$ExternalSyntheticLambda1(this, packageName2));     // Catch: PackageManager.NameNotFoundException -> L52
        L69:
            r14 = r14 + 1;
            action = action;
        L68:
            Slog.w(BackupManagerService.TAG, UserBackupManagerService.m2510$$Nest$fgetmLogIdMsg(this.this$0) + "Can't resolve new app " + packageName2);
        L58:
            Object r2 = UserBackupManagerService.m2512$$Nest$fgetmQueueLock(this.this$0);     // Catch: PackageManager.NameNotFoundException -> L52
            monitor-enter(r2);     // Catch: PackageManager.NameNotFoundException -> L52
            UserBackupManagerService.m2518$$Nest$mdequeueFullBackupLocked(this.this$0, packageName2);     // Catch: Throwable -> L65
            monitor-exit(r2);     // Catch: Throwable -> L65
            UserBackupManagerService.m2520$$Nest$mwriteFullBackupScheduleAsync(this.this$0);     // Catch: PackageManager.NameNotFoundException -> L52
            goto L63
        L65:
            th = move-exception;
            throw th;     // Catch: PackageManager.NameNotFoundException -> L52
        L55:
            action = action;
            goto L68
        L70:
            this.this$0.dataChangedImpl(UserBackupManagerService.PACKAGE_MANAGER_SENTINEL);
            return;
        L71:
            th = th;
            goto L94
        L78:
            if (added2 == true) goto L87;
            SparseArray r3 = UserBackupManagerService.m2507$$Nest$fgetmBackupParticipants(this.this$0);
            monitor-enter(r3);
            UserBackupManagerService.m2519$$Nest$mremovePackageParticipantsLocked(this.this$0, packageList2, uid);     // Catch: Throwable -> L84
            monitor-exit(r3);     // Catch: Throwable -> L84
        L84:
            th = move-exception;
            throw th;
        L87:
            int r0 = packageList2.length;
            int r9 = 0;
        L89:
            if (r9 >= r0) goto L115;
            final String packageName3 = packageList2[r9];
            UserBackupManagerService.m2506$$Nest$fgetmBackupHandler(this.this$0).post(new UserBackupManagerService$2$$ExternalSyntheticLambda2(this, packageName3));
            r9 = r9 + 1;
            goto L89
        L115:
            return;
        L116:
            return;
        L93:
            return;
        L5:
            if ("android.intent.action.PACKAGE_REMOVED".equals(action) == true) goto L16;
            if ("android.intent.action.PACKAGE_CHANGED".equals(action) == true) goto L16;
            if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(action) == false) goto L13;
            String[] packageList3 = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
            packageList2 = packageList3;
            changed2 = true;
            added2 = false;
            goto L27
        L13:
            if ("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(action) == false) goto L15;
            String[] packageList4 = intent.getStringArrayExtra("android.intent.extra.changed_package_list");
            packageList2 = packageList4;
            changed2 = false;
            added2 = false;
            goto L27
        L15:
            packageList2 = null;
            changed2 = false;
            added2 = false;
            goto L27
        }

        private /* synthetic */ void lambda$onReceive$0(String packageName, String[] components) {
            UserBackupManagerService.m2514$$Nest$fgetmTransportManager(this.this$0).onPackageChanged(packageName, components);
        }

        private /* synthetic */ void lambda$onReceive$1(String packageName) {
            UserBackupManagerService.m2514$$Nest$fgetmTransportManager(this.this$0).onPackageAdded(packageName);
        }

        private /* synthetic */ void lambda$onReceive$2(String packageName) {
            UserBackupManagerService.m2514$$Nest$fgetmTransportManager(this.this$0).onPackageRemoved(packageName);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-KeIODdAvPmos3bdWDD5LaVtUqQ, reason: not valid java name */
    public static /* synthetic */ void m2501$r8$lambda$KeIODdAvPmos3bdWDD5LaVtUqQ(UserBackupManagerService r0) {
        r0.lambda$endFullBackup$5();
    }

    /* JADX INFO: renamed from: $r8$lambda$-Nl6Xiw8yfJ7D2vCPI9wyL_p4I0, reason: not valid java name */
    public static /* synthetic */ void m2502$r8$lambda$Nl6Xiw8yfJ7D2vCPI9wyL_p4I0(int r0) {
        lambda$cancelBackups$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$60zOjkfZNFT-L6ih-nuCamP1L9M, reason: not valid java name */
    public static /* synthetic */ void m2503$r8$lambda$60zOjkfZNFTL6ihnuCamP1L9M(UserBackupManagerService r0, String r1, String r2) {
        r0.onTransportRegistered(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$NIvmZ36Ki2SZ7dC9RGBULCgHPxQ(UserBackupManagerService r0, TransportConnection r1, String r2) {
        r0.lambda$restoreAtInstall$10(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$OApO0S-wMjS6q95k8nj4LVV5O2k, reason: not valid java name */
    public static /* synthetic */ void m2504$r8$lambda$OApO0SwMjS6q95k8nj4LVV5O2k(UserBackupManagerService r0, List r1, List r2, String r3) {
        r0.lambda$updateStateOnBackupEnabled$8(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$SuEH1txNNm3-ByR9qj_SQr65vNk, reason: not valid java name */
    public static /* synthetic */ void m2505$r8$lambda$SuEH1txNNm3ByR9qj_SQr65vNk(UserBackupManagerService r0, int r1) {
        r0.lambda$handleCancel$4(r1);
    }

    public static /* synthetic */ void $r8$lambda$ZLqNZtUkSBsOtZe7HeCEhyxKIKw(UserBackupManagerService r0, long r1, BackupRestoreTask r3) {
        r0.lambda$opComplete$11(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$heFkS8m3IlrBwPfiAIdWm8iF68E(UserBackupManagerService r0, Set r1, String r2) {
        r0.lambda$parseLeftoverJournals$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$j8xf05DwP1CSEzNDMZWjz097Lww(UserBackupManagerService r0, ComponentName r1, ISelectBackupTransportCallback r2) {
        r0.lambda$selectBackupTransportAsync$9(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$jjxDOhvibaIEDHWNziXaqrWNaHQ(UserBackupManagerService r0, TransportConnection r1, String r2) {
        r0.lambda$clearBackupData$7(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$jlvTzCdMbgZz9CFLb9dJhfbHtPM(UserBackupManagerService r0, int r1) {
        r0.lambda$waitUntilOperationComplete$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$qmyqqN_oMikkXxYcMY9KUtmLjwk(UserBackupManagerService r0) {
        r0.parseLeftoverJournals();
    }

    public static /* synthetic */ void $r8$lambda$vj0KzEzwo54sYXvz53rLbY7FwqE(UserBackupManagerService r0, String r1) {
        r0.lambda$initializeTransports$6(r1);
    }

    public static /* synthetic */ void $r8$lambda$yQopjB01hrvZz2RQKVRou3uIi5I(UserBackupManagerService r0, TransportConnection r1, String r2) {
        r0.lambda$requestBackup$1(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupHandler m2506$$Nest$fgetmBackupHandler(UserBackupManagerService r0) {
        return r0.mBackupHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBackupParticipants, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m2507$$Nest$fgetmBackupParticipants(UserBackupManagerService r0) {
        return r0.mBackupParticipants;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFullBackupQueue, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2508$$Nest$fgetmFullBackupQueue(UserBackupManagerService r0) {
        return r0.mFullBackupQueue;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFullBackupScheduleFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m2509$$Nest$fgetmFullBackupScheduleFile(UserBackupManagerService r0) {
        return r0.mFullBackupScheduleFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLogIdMsg, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m2510$$Nest$fgetmLogIdMsg(UserBackupManagerService r0) {
        return r0.mLogIdMsg;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m2511$$Nest$fgetmPackageManager(UserBackupManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQueueLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2512$$Nest$fgetmQueueLock(UserBackupManagerService r0) {
        return r0.mQueueLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScheduledBackupEligibility, reason: not valid java name */
    static /* bridge */ /* synthetic */ BackupEligibilityRules m2513$$Nest$fgetmScheduledBackupEligibility(UserBackupManagerService r0) {
        return r0.mScheduledBackupEligibility;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTransportManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ TransportManager m2514$$Nest$fgetmTransportManager(UserBackupManagerService r0) {
        return r0.mTransportManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2515$$Nest$fgetmUserId(UserBackupManagerService r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$maddPackageParticipantsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2516$$Nest$maddPackageParticipantsLocked(UserBackupManagerService r0, String[] r1) {
        r0.addPackageParticipantsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdataChangedImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2517$$Nest$mdataChangedImpl(UserBackupManagerService r0, String r1, HashSet r2) {
        r0.dataChangedImpl(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdequeueFullBackupLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2518$$Nest$mdequeueFullBackupLocked(UserBackupManagerService r0, String r1) {
        r0.dequeueFullBackupLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremovePackageParticipantsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2519$$Nest$mremovePackageParticipantsLocked(UserBackupManagerService r0, String[] r1, int r2) {
        r0.removePackageParticipantsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteFullBackupScheduleAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2520$$Nest$mwriteFullBackupScheduleAsync(UserBackupManagerService r0) {
        r0.writeFullBackupScheduleAsync();
    }

    static UserBackupManagerService createAndInitializeService(int userId, Context context, BackupManagerService backupManagerService, Set<ComponentName> transportWhitelist) {
        String currentTransport = Settings.Secure.getStringForUser(context.getContentResolver(), "backup_transport", userId);
        if (TextUtils.isEmpty(currentTransport) == false) goto L5;
        currentTransport = null;
    L5:
        Slog.d(BackupManagerService.TAG, "Starting with transport " + currentTransport + " for user " + userId);
        TransportManager transportManager = new TransportManager(userId, context, transportWhitelist, currentTransport);
        File baseStateDir = UserBackupManagerFiles.getBaseStateDir(userId);
        File dataDir = UserBackupManagerFiles.getDataDir(userId);
        HandlerThread userBackupThread = new HandlerThread("backup-" + userId, 10);
        userBackupThread.start();
        Slog.d(BackupManagerService.TAG, "Started thread " + userBackupThread.getName() + " for user " + userId);
        return createAndInitializeService(userId, context, backupManagerService, userBackupThread, baseStateDir, dataDir, transportManager);
    }

    public static UserBackupManagerService createAndInitializeService(int userId, Context context, BackupManagerService backupManagerService, HandlerThread userBackupThread, File baseStateDir, File dataDir, TransportManager transportManager) {
        BackupManagerMonitorDumpsysUtils backupManagerMonitorDumpsysUtils = new BackupManagerMonitorDumpsysUtils();
        if (backupManagerMonitorDumpsysUtils.deleteExpiredBMMEvents() == false) goto L6;
        Slog.d(BackupManagerService.TAG, "BMM Events recorded for dumpsys have expired");
    L6:
        return new UserBackupManagerService(userId, context, backupManagerService, userBackupThread, baseStateDir, dataDir, transportManager);
    }

    public static boolean getSetupCompleteSettingForUser(Context context, int userId) {
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "user_setup_complete", 0, userId) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    UserBackupManagerService(Context context, PackageManager packageManager, LifecycleOperationStorage operationStorage, TransportManager transportManager, BackupHandler backupHandler, BackupManagerConstants backupManagerConstants, IActivityManager activityManager, ActivityManagerInternal activityManagerInternal) {
        this.mPendingInits = new ArraySet();
        this.mBackupParticipants = new SparseArray();
        this.mPendingBackups = new HashMap();
        this.mQueueLock = new Object();
        this.mClearDataLock = new Object();
        this.mAdbBackupRestoreConfirmations = new SparseArray();
        this.mRng = new SecureRandom();
        this.mPendingRestores = new ArrayDeque();
        this.mTokenGenerator = new Random();
        this.mNextToken = new AtomicInteger();
        this.mAncestralPackages = null;
        this.mAncestralToken = 0;
        this.mCurrentToken = 0;
        this.mFullBackupScheduleWriter = new AnonymousClass1(this);
        this.mPackageTrackingReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mUserId = 0;
        this.mLogIdMsg = "[UserID:" + this.mUserId + "] ";
        this.mRegisterTransportsRequestedTime = 0;
        this.mPackageManager = packageManager;
        this.mOperationStorage = operationStorage;
        this.mBackupAgentConnectionManager = new BackupAgentConnectionManager(this.mOperationStorage, this.mPackageManager, this, this.mUserId);
        this.mTransportManager = transportManager;
        this.mFullBackupQueue = new ArrayList();
        this.mBackupHandler = backupHandler;
        this.mConstants = backupManagerConstants;
        this.mActivityManager = activityManager;
        this.mActivityManagerInternal = activityManagerInternal;
        this.mBaseStateDir = null;
        this.mDataDir = null;
        this.mJournalDir = null;
        this.mFullBackupScheduleFile = null;
        this.mSetupObserver = null;
        this.mRunInitReceiver = null;
        this.mRunInitIntent = null;
        this.mAgentTimeoutParameters = null;
        this.mAlarmManager = null;
        this.mWakelock = null;
        this.mBackupPreferences = null;
        this.mBackupPasswordManager = null;
        this.mPackageManagerBinder = null;
        this.mBackupManagerBinder = null;
        this.mScheduledBackupEligibility = null;
    }

    private UserBackupManagerService(int userId, Context context, BackupManagerService parent, HandlerThread userBackupThread, File baseStateDir, File dataDir, TransportManager transportManager) {
        this.mPendingInits = new ArraySet();
        this.mBackupParticipants = new SparseArray();
        this.mPendingBackups = new HashMap();
        this.mQueueLock = new Object();
        this.mClearDataLock = new Object();
        this.mAdbBackupRestoreConfirmations = new SparseArray();
        this.mRng = new SecureRandom();
        this.mPendingRestores = new ArrayDeque();
        this.mTokenGenerator = new Random();
        this.mNextToken = new AtomicInteger();
        this.mAncestralPackages = null;
        this.mAncestralToken = 0;
        this.mCurrentToken = 0;
        this.mFullBackupScheduleWriter = new AnonymousClass1(this);
        this.mPackageTrackingReceiver = new AnonymousClass2(this);
        this.mUserId = userId;
        this.mLogIdMsg = "[UserID:" + this.mUserId + "] ";
        context.getClass();
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mPackageManagerBinder = AppGlobals.getPackageManager();
        this.mActivityManager = ActivityManager.getService();
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mScheduledBackupEligibility = getEligibilityRules(this.mPackageManager, userId, this.mContext, 0);
        this.mAlarmManager = (AlarmManager) context.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mPowerManager = (PowerManager) context.getSystemService("power");
        parent.getClass();
        this.mBackupManagerBinder = IBackupManager.Stub.asInterface(parent.asBinder());
        this.mAgentTimeoutParameters = new BackupAgentTimeoutParameters(Handler.getMain(), this.mContext.getContentResolver());
        this.mAgentTimeoutParameters.start();
        this.mOperationStorage = new LifecycleOperationStorage(this.mUserId);
        this.mBackupAgentConnectionManager = new BackupAgentConnectionManager(this.mOperationStorage, this.mPackageManager, this, this.mUserId);
        userBackupThread.getClass();
        this.mBackupHandler = new BackupHandler(this, this.mOperationStorage, userBackupThread);
        ContentResolver resolver = context.getContentResolver();
        this.mSetupComplete = getSetupCompleteSettingForUser(context, userId);
        if (Settings.Secure.getIntForUser(resolver, "backup_auto_restore", 1, userId) == 0) goto L5;
        boolean r3 = true;
    L6:
        this.mAutoRestore = r3;
        this.mSetupObserver = new SetupObserver(this, this.mBackupHandler);
        resolver.registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, this.mSetupObserver, this.mUserId);
        baseStateDir.getClass();
        this.mBaseStateDir = baseStateDir;
        if (userId != 0) goto L11;
        this.mBaseStateDir.mkdirs();
        if (SELinux.restorecon(this.mBaseStateDir) == true) goto L11;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "SELinux restorecon failed on " + this.mBaseStateDir);
    L11:
        dataDir.getClass();
        this.mDataDir = dataDir;
        this.mBackupPasswordManager = new BackupPasswordManager(this.mContext, this.mBaseStateDir, this.mRng);
        this.mRunInitReceiver = new RunInitializeReceiver(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction(RUN_INITIALIZE_ACTION);
        context.registerReceiverAsUser(this.mRunInitReceiver, UserHandle.of(userId), filter, "android.permission.BACKUP", null);
        Intent initIntent = new Intent(RUN_INITIALIZE_ACTION);
        initIntent.addFlags(1073741824);
        this.mRunInitIntent = PendingIntent.getBroadcastAsUser(context, 0, initIntent, 67108864, UserHandle.of(userId));
        this.mJournalDir = new File(this.mBaseStateDir, "pending");
        this.mJournalDir.mkdirs();
        this.mJournal = null;
        this.mConstants = new BackupManagerConstants(this.mBackupHandler, this.mContext.getContentResolver());
        this.mConstants.start();
        SparseArray<HashSet<String>> r4 = this.mBackupParticipants;
        monitor-enter(r4);
        addPackageParticipantsLocked(null);     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        transportManager.getClass();
        this.mTransportManager = transportManager;
        this.mTransportManager.setOnTransportRegisteredListener(new UserBackupManagerService$$ExternalSyntheticLambda2(this));
        this.mRegisterTransportsRequestedTime = SystemClock.elapsedRealtime();
        BackupHandler r0 = this.mBackupHandler;
        final TransportManager r5 = this.mTransportManager;
        r5.getClass();
        r0.postDelayed(new UserBackupManagerService$$ExternalSyntheticLambda3(r5), 3000);
        this.mBackupHandler.postDelayed(new UserBackupManagerService$$ExternalSyntheticLambda4(this), 3000);
        final BackupManagerMonitorDumpsysUtils backupManagerMonitorDumpsysUtils = new BackupManagerMonitorDumpsysUtils();
        this.mBackupHandler.postDelayed(new UserBackupManagerService$$ExternalSyntheticLambda5(backupManagerMonitorDumpsysUtils), 3000);
        this.mBackupPreferences = new UserBackupPreferences(this.mContext, this.mBaseStateDir);
        this.mWakelock = new BackupWakeLock(this.mPowerManager.newWakeLock(1, "*backup*-" + userId + "-" + userBackupThread.getThreadId()), userId, this.mConstants);
        this.mFullBackupScheduleFile = new File(this.mBaseStateDir, "fb-schedule");
        initPackageTracking();
        return;
    L17:
        th = th;
    L25:
        throw th;
    L21:
        th = th;
        goto L25
    L5:
        r3 = false;
        goto L6
    }

    void initializeBackupEnableState() {
        boolean isEnabled = readEnabledState();
        setBackupEnabled(isEnabled, false);
    }

    protected void tearDownService() {
        this.mAgentTimeoutParameters.stop();
        this.mConstants.stop();
        this.mContext.getContentResolver().unregisterContentObserver(this.mSetupObserver);
        this.mContext.unregisterReceiver(this.mRunInitReceiver);
        this.mContext.unregisterReceiver(this.mPackageTrackingReceiver);
        this.mBackupHandler.stop();
    }

    public int getUserId() {
        return this.mUserId;
    }

    public BackupManagerConstants getConstants() {
        return this.mConstants;
    }

    public BackupAgentTimeoutParameters getAgentTimeoutParameters() {
        return this.mAgentTimeoutParameters;
    }

    public Context getContext() {
        return this.mContext;
    }

    public PackageManager getPackageManager() {
        return this.mPackageManager;
    }

    public IPackageManager getPackageManagerBinder() {
        return this.mPackageManagerBinder;
    }

    public IActivityManager getActivityManager() {
        return this.mActivityManager;
    }

    public AlarmManager getAlarmManager() {
        return this.mAlarmManager;
    }

    void setPowerManager(PowerManager powerManager) {
        this.mPowerManager = powerManager;
    }

    public TransportManager getTransportManager() {
        return this.mTransportManager;
    }

    public OperationStorage getOperationStorage() {
        return this.mOperationStorage;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.mEnabled = enabled;
    }

    public boolean isSetupComplete() {
        return this.mSetupComplete;
    }

    public void setSetupComplete(boolean setupComplete) {
        this.mSetupComplete = setupComplete;
    }

    public BackupWakeLock getWakeLock() {
        return this.mWakelock;
    }

    public Handler getBackupHandler() {
        return this.mBackupHandler;
    }

    public PendingIntent getRunInitIntent() {
        return this.mRunInitIntent;
    }

    public HashMap<String, BackupRequest> getPendingBackups() {
        return this.mPendingBackups;
    }

    public Object getQueueLock() {
        return this.mQueueLock;
    }

    public boolean isBackupRunning() {
        return this.mBackupRunning;
    }

    public void setBackupRunning(boolean backupRunning) {
        this.mBackupRunning = backupRunning;
    }

    public void setLastBackupPass(long lastBackupPass) {
        this.mLastBackupPass = lastBackupPass;
    }

    public Object getClearDataLock() {
        return this.mClearDataLock;
    }

    public void setClearingData(boolean clearingData) {
        this.mClearingData = clearingData;
    }

    public boolean isRestoreInProgress() {
        return this.mIsRestoreInProgress;
    }

    public void setRestoreInProgress(boolean restoreInProgress) {
        this.mIsRestoreInProgress = restoreInProgress;
    }

    public Queue<PerformUnifiedRestoreTask> getPendingRestores() {
        return this.mPendingRestores;
    }

    public ActiveRestoreSession getActiveRestoreSession() {
        return this.mActiveRestoreSession;
    }

    public SparseArray<AdbParams> getAdbBackupRestoreConfirmations() {
        return this.mAdbBackupRestoreConfirmations;
    }

    public File getBaseStateDir() {
        return this.mBaseStateDir;
    }

    public File getDataDir() {
        return this.mDataDir;
    }

    BroadcastReceiver getPackageTrackingReceiver() {
        return this.mPackageTrackingReceiver;
    }

    public DataChangedJournal getJournal() {
        return this.mJournal;
    }

    public void setJournal(DataChangedJournal journal) {
        this.mJournal = journal;
    }

    public SecureRandom getRng() {
        return this.mRng;
    }

    public void setAncestralPackages(Set<String> ancestralPackages) {
        this.mAncestralPackages = ancestralPackages;
    }

    public void setAncestralToken(long ancestralToken) {
        this.mAncestralToken = ancestralToken;
    }

    public void setAncestralBackupDestination(int backupDestination) {
        this.mAncestralBackupDestination = backupDestination;
    }

    public long getCurrentToken() {
        return this.mCurrentToken;
    }

    public void setCurrentToken(long currentToken) {
        this.mCurrentToken = currentToken;
    }

    public ArraySet<String> getPendingInits() {
        return this.mPendingInits;
    }

    public void clearPendingInits() {
        this.mPendingInits.clear();
    }

    public void setRunningFullBackupTask(PerformFullTransportBackupTask runningFullBackupTask) {
        this.mRunningFullBackupTask = runningFullBackupTask;
    }

    public int generateRandomIntegerToken() {
        int token = this.mTokenGenerator.nextInt();
        if (token >= 0) goto L6;
        token = -token;
    L6:
        return (token & (-256)) | (this.mNextToken.incrementAndGet() & 255);
    }

    public BackupAgent makeMetadataAgent() {
        return makeMetadataAgentWithEligibilityRules(this.mScheduledBackupEligibility);
    }

    public BackupAgent makeMetadataAgentWithEligibilityRules(BackupEligibilityRules backupEligibilityRules) {
        PackageManagerBackupAgent pmAgent = new PackageManagerBackupAgent(this.mPackageManager, this.mUserId, backupEligibilityRules);
        pmAgent.attach(this.mContext);
        pmAgent.onCreate(UserHandle.of(this.mUserId));
        return pmAgent;
    }

    public PackageManagerBackupAgent makeMetadataAgent(List<PackageInfo> packages) {
        PackageManagerBackupAgent pmAgent = new PackageManagerBackupAgent(this.mPackageManager, packages, this.mUserId);
        pmAgent.attach(this.mContext);
        pmAgent.onCreate(UserHandle.of(this.mUserId));
        return pmAgent;
    }

    private void initPackageTracking() {
        this.mTokenFile = new File(this.mBaseStateDir, "ancestral");
        DataInputStream tokenStream = new DataInputStream(new BufferedInputStream(new FileInputStream(this.mTokenFile)));     // Catch: IOException -> L17 FileNotFoundException -> L19
        int version = tokenStream.readInt();     // Catch: Throwable -> L13
        if (version != 1) goto L15;
        this.mAncestralToken = tokenStream.readLong();     // Catch: Throwable -> L13
        this.mCurrentToken = tokenStream.readLong();     // Catch: Throwable -> L13
        int numPackages = tokenStream.readInt();     // Catch: Throwable -> L13
        if (numPackages < 0) goto L15;
        this.mAncestralPackages = new HashSet();     // Catch: Throwable -> L13
        int i = 0;
    L10:
        if (i >= numPackages) goto L15;
        String pkgName = tokenStream.readUTF();     // Catch: Throwable -> L13
        this.mAncestralPackages.add(pkgName);     // Catch: Throwable -> L13
        i = i + 1;
        goto L10
    L15:
        tokenStream.close();     // Catch: IOException -> L17 FileNotFoundException -> L19
    L28:
        this.mProcessedPackagesJournal = new ProcessedPackagesJournal(this.mBaseStateDir);
        this.mProcessedPackagesJournal.init();
        Object r1 = this.mQueueLock;
        monitor-enter(r1);
        this.mFullBackupQueue = readFullBackupSchedule();     // Catch: Throwable -> L34
        monitor-exit(r1);     // Catch: Throwable -> L34
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addDataScheme(com.android.server.pm.Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mPackageTrackingReceiver, UserHandle.of(this.mUserId), filter, null, null);
        IntentFilter sdFilter = new IntentFilter();
        sdFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
        sdFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
        this.mContext.registerReceiverAsUser(this.mPackageTrackingReceiver, UserHandle.of(this.mUserId), sdFilter, null, null);
        return;
    L34:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        tokenStream.close();     // Catch: Throwable -> L23
        goto L27
    L45:
        throw th;     // Catch: IOException -> L17 FileNotFoundException -> L19
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L17 FileNotFoundException -> L19
        throw th;     // Catch: IOException -> L17 FileNotFoundException -> L19
    L17:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Unable to read token file", e);
    L27:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "No ancestral data");
        goto L28
    }

    private ArrayList<FullBackupEntry> readFullBackupSchedule() {
        boolean changed = false;
        ArrayList<FullBackupEntry> schedule = null;
        List<PackageInfo> apps = PackageManagerBackupAgent.getStorableApplications(this.mPackageManager, this.mUserId, this.mScheduledBackupEligibility);
        if (this.mFullBackupScheduleFile.exists() == false) goto L109;
        FileInputStream fstream = new FileInputStream(this.mFullBackupScheduleFile);     // Catch: Exception -> L105
        BufferedInputStream bufStream = new BufferedInputStream(fstream);     // Catch: Throwable -> L98
        DataInputStream in = new DataInputStream(bufStream);     // Catch: Throwable -> L91
        int version = in.readInt();     // Catch: Throwable -> L79
        if (version != 1) goto L81;
        int numPackages = in.readInt();     // Catch: Throwable -> L79
        schedule = new ArrayList(numPackages);     // Catch: Throwable -> L79
        HashSet<String> foundApps = new HashSet(numPackages);     // Catch: Throwable -> L79
        int i = 0;
    L14:
        if (i >= numPackages) goto L44;
        String pkgName = in.readUTF();     // Catch: Throwable -> L37
        long lastBackup = in.readLong();     // Catch: Throwable -> L37
        foundApps.add(pkgName);     // Catch: Throwable -> L37
        boolean changed2 = changed;
        PackageInfo pkg = this.mPackageManager.getPackageInfoAsUser(pkgName, 0, this.mUserId);     // Catch: Throwable -> L29 PackageManager.NameNotFoundException -> L31
        if (this.mScheduledBackupEligibility.appGetsFullBackup(pkg) == false) goto L35;
        if (this.mScheduledBackupEligibility.appIsEligibleForBackup(pkg.applicationInfo) == false) goto L35;
        fstream = fstream;
        schedule.add(new FullBackupEntry(pkgName, lastBackup));     // Catch: Throwable -> L25 PackageManager.NameNotFoundException -> L27
    L43:
        i = i + 1;
        changed = changed2;
        fstream = fstream;
    L25:
        th = move-exception;
        Throwable r2 = th;
        BufferedInputStream bufStream2 = bufStream;
        changed = changed2;
    L144:
        in.close();     // Catch: Throwable -> L88
    L173:
        throw r2;     // Catch: Throwable -> L75
    L88:
        th = move-exception;
        r2.addSuppressed(th);     // Catch: Throwable -> L75
        throw r2;     // Catch: Throwable -> L75
    L27:
        e = e;
    L42:
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Package " + pkgName + " not installed; dropping from full backup");     // Catch: Throwable -> L25
        goto L43
    L35:
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Package " + pkgName + " no longer eligible for full backup");     // Catch: Throwable -> L25 PackageManager.NameNotFoundException -> L27
    L31:
        e = e;
        fstream = fstream;
    L29:
        th = move-exception;
        fstream = fstream;
        r2 = th;
        bufStream2 = bufStream;
        changed = changed2;
        goto L144
    L39:
        e = e;
        changed2 = changed;
        fstream = fstream;
    L37:
        th = move-exception;
        fstream = fstream;
        r2 = th;
        bufStream2 = bufStream;
        goto L144
    L44:
        boolean changed3 = changed;
        fstream = fstream;
        Iterator<PackageInfo> r0 = apps.iterator();     // Catch: Throwable -> L77
        changed = changed3;
    L124:
    L60:
        th = move-exception;
        bufStream2 = bufStream;
        r2 = th;
        goto L144
    L48:
        if (r0.hasNext() == false) goto L66;
        PackageInfo app = r0.next();     // Catch: Throwable -> L60
        if (this.mScheduledBackupEligibility.appGetsFullBackup(app) == true) goto L52;
        bufStream2 = bufStream;
    L65:
        bufStream = bufStream2;
        goto L124
    L52:
        if (this.mScheduledBackupEligibility.appIsEligibleForBackup(app.applicationInfo) == true) goto L54;
        bufStream2 = bufStream;
        goto L65
    L54:
        if (foundApps.contains(app.packageName) == true) goto L62;
        bufStream2 = bufStream;
        schedule.add(new FullBackupEntry(app.packageName, 0));     // Catch: Throwable -> L58
        changed = true;
    L58:
        th = move-exception;
        r2 = th;
        goto L144
    L62:
        bufStream2 = bufStream;
        goto L65
    L66:
        bufStream2 = bufStream;
        Collections.sort(schedule);     // Catch: Throwable -> L58
        in.close();     // Catch: Throwable -> L75
        bufStream2.close();     // Catch: Throwable -> L73
        fstream.close();     // Catch: Exception -> L71
    L77:
        th = move-exception;
        bufStream2 = bufStream;
        r2 = th;
        changed = changed3;
        goto L144
    L81:
        fstream = fstream;
        bufStream2 = bufStream;
    L84:
        th = move-exception;
        r2 = th;
        changed = false;
        goto L144
    L83:
        throw new IllegalArgumentException("Unknown backup schedule version " + version);     // Catch: Throwable -> L84
    L75:
        th = move-exception;
        Throwable r3 = th;
    L129:
        bufStream2.close();     // Catch: Throwable -> L95
    L174:
        throw r3;     // Catch: Throwable -> L73
    L95:
        th = move-exception;
        r3.addSuppressed(th);     // Catch: Throwable -> L73
        throw r3;     // Catch: Throwable -> L73
    L79:
        th = move-exception;
        fstream = fstream;
        bufStream2 = bufStream;
        r2 = th;
    L91:
        th = move-exception;
        fstream = fstream;
        bufStream2 = bufStream;
        r3 = th;
    L73:
        th = move-exception;
        Throwable r4 = th;
    L141:
        fstream.close();     // Catch: Throwable -> L102
    L175:
        throw r4;     // Catch: Exception -> L71
    L102:
        th = move-exception;
        r4.addSuppressed(th);     // Catch: Exception -> L71
        throw r4;     // Catch: Exception -> L71
    L98:
        th = move-exception;
        fstream = fstream;
        r4 = th;
    L71:
        e = e;
    L107:
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to read backup schedule", e);
        this.mFullBackupScheduleFile.delete();
        schedule = null;
    L105:
        e = e;
    L109:
        if (schedule != null) goto L121;
        changed = true;
        schedule = new ArrayList(apps.size());
        Iterator<PackageInfo> r1 = apps.iterator();
    L112:
        if (r1.hasNext() == false) goto L121;
        PackageInfo info = r1.next();
        if (this.mScheduledBackupEligibility.appGetsFullBackup(info) == false) goto L112;
        if (this.mScheduledBackupEligibility.appIsEligibleForBackup(info.applicationInfo) == false) goto L112;
        schedule.add(new FullBackupEntry(info.packageName, 0));
    L121:
        if (changed == false) goto L123;
        writeFullBackupScheduleAsync();
    L123:
        return schedule;
    }

    private void writeFullBackupScheduleAsync() {
        this.mBackupHandler.removeCallbacks(this.mFullBackupScheduleWriter);
        this.mBackupHandler.post(this.mFullBackupScheduleWriter);
    }

    private void parseLeftoverJournals() {
        ArrayList<DataChangedJournal> journals = DataChangedJournal.listJournals(this.mJournalDir);
        journals.removeAll(Collections.singletonList(this.mJournal));
        if (journals.isEmpty() == true) goto L5;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Found " + journals.size() + " stale backup journal(s), scheduling.");
    L5:
        final Set<String> packageNames = new LinkedHashSet();
        Iterator<DataChangedJournal> r3 = journals.iterator();
    L7:
        if (r3.hasNext() == false) goto L15;
        DataChangedJournal journal = r3.next();
        journal.forEach(new UserBackupManagerService$$ExternalSyntheticLambda8(this, packageNames));     // Catch: IOException -> L11
    L11:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Can't read " + journal, e);
        goto L7
    L15:
        if (packageNames.isEmpty() == true) goto L24;
        String msg = "Stale backup journals: Scheduled " + packageNames.size() + " package(s) total";
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + msg);
        return;
    }

    private /* synthetic */ void lambda$parseLeftoverJournals$0(Set packageNames, String packageName) {
        if (packageNames.add(packageName) == false) goto L6;
        dataChangedImpl(packageName);
        return;
    }

    public Set<String> getExcludedRestoreKeys(String packageName) {
        return this.mBackupPreferences.getExcludedRestoreKeysForPackage(packageName);
    }

    public byte[] randomBytes(int bits) {
        byte[] array = new byte[bits / 8];
        this.mRng.nextBytes(array);
        return array;
    }

    public boolean setBackupPassword(String currentPw, String newPw) {
        return this.mBackupPasswordManager.setBackupPassword(currentPw, newPw);
    }

    public boolean hasBackupPassword() {
        return this.mBackupPasswordManager.hasBackupPassword();
    }

    public boolean backupPasswordMatches(String currentPw) {
        return this.mBackupPasswordManager.backupPasswordMatches(currentPw);
    }

    public void recordInitPending(boolean isPending, String transportName, String transportDirName) {
        Object r0 = this.mQueueLock;
        monitor-enter(r0);
        File stateDir = new File(this.mBaseStateDir, transportDirName);     // Catch: Throwable -> L9
        File initPendingFile = new File(stateDir, INIT_SENTINEL_FILE_NAME);     // Catch: Throwable -> L9
        if (isPending == false) goto L13;
        this.mPendingInits.add(transportName);     // Catch: Throwable -> L9
        new FileOutputStream(initPendingFile).close();     // Catch: Throwable -> L9 IOException -> L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L13:
        initPendingFile.delete();     // Catch: Throwable -> L9
        this.mPendingInits.remove(transportName);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void resetBackupState(File stateFileDir) {
        Object r0 = this.mQueueLock;
        monitor-enter(r0);
        this.mProcessedPackagesJournal.reset();     // Catch: Throwable -> L9
        this.mCurrentToken = 0;     // Catch: Throwable -> L9
        writeRestoreTokens();     // Catch: Throwable -> L9
        File[] r1 = stateFileDir.listFiles();     // Catch: Throwable -> L9
        int r2 = r1.length;     // Catch: Throwable -> L9
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L12;
        File sf = r1[r3];     // Catch: Throwable -> L9
        if (sf.getName().equals(INIT_SENTINEL_FILE_NAME) == true) goto L11;
        sf.delete();     // Catch: Throwable -> L9
    L11:
        r3 = r3 + 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        SparseArray<HashSet<String>> r4 = this.mBackupParticipants;
        monitor-enter(r4);
        int numParticipants = this.mBackupParticipants.size();     // Catch: Throwable -> L23
        int i = 0;
    L16:
        if (i >= numParticipants) goto L27;
        HashSet<String> participants = this.mBackupParticipants.valueAt(i);     // Catch: Throwable -> L23
        if (participants == null) goto L25;
        Iterator<String> r5 = participants.iterator();     // Catch: Throwable -> L23
    L21:
        if (r5.hasNext() == false) goto L25;
        String packageName = r5.next();     // Catch: Throwable -> L23
        dataChangedImpl(packageName);     // Catch: Throwable -> L23
    L25:
        i = i + 1;     // Catch: Throwable -> L23
        goto L16
    L27:
        monitor-exit(r4);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }

    private void onTransportRegistered(String transportName, String transportDirName) {
        long timeMs = SystemClock.elapsedRealtime() - this.mRegisterTransportsRequestedTime;
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Transport " + transportName + " registered " + timeMs + "ms after first request (delay = 3000ms)");
        File stateDir = new File(this.mBaseStateDir, transportDirName);
        stateDir.mkdirs();
        File initSentinel = new File(stateDir, INIT_SENTINEL_FILE_NAME);
        if (initSentinel.exists() == false) goto L12;
        Object r4 = this.mQueueLock;
        monitor-enter(r4);
        this.mPendingInits.add(transportName);     // Catch: Throwable -> L9
        this.mAlarmManager.set(0, System.currentTimeMillis() + 60000, this.mRunInitIntent);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void addPackageParticipantsLocked(String[] packageNames) {
        List<PackageInfo> targetApps = allAgentPackages();
        if (packageNames == null) goto L8;
        int r1 = packageNames.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        String packageName = packageNames[r2];
        addPackageParticipantsLockedInner(packageName, targetApps);
        r2 = r2 + 1;
        goto L6
    L11:
        return;
    L8:
        addPackageParticipantsLockedInner(null, targetApps);
    }

    private void addPackageParticipantsLockedInner(String packageName, List<PackageInfo> targetPkgs) {
        Iterator<PackageInfo> r0 = targetPkgs.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        PackageInfo pkg = r0.next();
        if (packageName == null) goto L9;
        if (pkg.packageName.equals(packageName) == false) goto L4;
    L9:
        int uid = pkg.applicationInfo.uid;
        HashSet<String> set = this.mBackupParticipants.get(uid);
        if (set != null) goto L12;
        set = new HashSet();
        this.mBackupParticipants.put(uid, set);
    L12:
        set.add(pkg.packageName);
        Message msg = this.mBackupHandler.obtainMessage(16, pkg.packageName);
        this.mBackupHandler.sendMessage(msg);
        goto L4
    }

    private void removePackageParticipantsLocked(String[] packageNames, int oldUid) {
        if (packageNames != null) goto L5;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "removePackageParticipants with null list");
        return;
    L5:
        int r0 = packageNames.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L15;
        String pkg = packageNames[r1];
        HashSet<String> set = this.mBackupParticipants.get(oldUid);
        if (set == null) goto L14;
        if (set.contains(pkg) == false) goto L14;
        removePackageFromSetLocked(set, pkg);
        if (set.isEmpty() == false) goto L14;
        this.mBackupParticipants.remove(oldUid);
    L14:
        r1 = r1 + 1;
        goto L6
    }

    private void removePackageFromSetLocked(HashSet<String> set, String packageName) {
        if (set.contains(packageName) == false) goto L6;
        set.remove(packageName);
        this.mPendingBackups.remove(packageName);
        return;
    }

    private List<PackageInfo> allAgentPackages() {
        List<PackageInfo> packages = this.mPackageManager.getInstalledPackagesAsUser(134217728, this.mUserId);
        int numPackages = packages.size();
        int a = numPackages - 1;
    L3:
        if (a < 0) goto L20;
        PackageInfo pkg = packages.get(a);
        ApplicationInfo app = pkg.applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L13
        if ((app.flags & 32768) == 0) goto L15;
        if (app.backupAgentName == null) goto L15;
        if ((app.flags & 67108864) != 0) goto L15;
        ApplicationInfo app2 = this.mPackageManager.getApplicationInfoAsUser(pkg.packageName, 1024, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L13
        pkg.applicationInfo.sharedLibraryFiles = app2.sharedLibraryFiles;     // Catch: PackageManager.NameNotFoundException -> L13
        pkg.applicationInfo.sharedLibraryInfos = app2.sharedLibraryInfos;     // Catch: PackageManager.NameNotFoundException -> L13
    L18:
        a = a - 1;
    L15:
        packages.remove(a);     // Catch: PackageManager.NameNotFoundException -> L13
    L17:
        packages.remove(a);
        goto L18
    L20:
        return packages;
    }

    public void logBackupComplete(String packageName) {
        if (packageName.equals(PACKAGE_MANAGER_SENTINEL) == false) goto L5;
        return;
    L5:
        String[] r0 = this.mConstants.getBackupFinishedNotificationReceivers();
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        String receiver = r0[r2];
        Intent notification = new Intent();
        notification.setAction(BACKUP_FINISHED_ACTION);
        notification.setPackage(receiver);
        notification.addFlags(268435488);
        notification.putExtra("packageName", packageName);
        this.mContext.sendBroadcastAsUser(notification, UserHandle.of(this.mUserId));
        r2 = r2 + 1;
        goto L6
    L8:
        this.mProcessedPackagesJournal.addPackage(packageName);
    }

    public void writeRestoreTokens() {
        RandomAccessFile af = new RandomAccessFile(this.mTokenFile, "rwd");     // Catch: IOException -> L17
        af.writeInt(1);     // Catch: Throwable -> L8
        af.writeLong(this.mAncestralToken);     // Catch: Throwable -> L8
        af.writeLong(this.mCurrentToken);     // Catch: Throwable -> L8
        if (this.mAncestralPackages != null) goto L10;
        af.writeInt(-1);     // Catch: Throwable -> L8
    L15:
        af.close();     // Catch: IOException -> L17
        return;
    L10:
        af.writeInt(this.mAncestralPackages.size());     // Catch: Throwable -> L8
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Ancestral packages:  " + this.mAncestralPackages.size());     // Catch: Throwable -> L8
        Iterator<String> r2 = this.mAncestralPackages.iterator();     // Catch: Throwable -> L8
    L12:
        if (r2.hasNext() == false) goto L15;
        String pkgName = r2.next();     // Catch: Throwable -> L8
        af.writeUTF(pkgName);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        af.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: IOException -> L17
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L17
    L17:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Unable to write token file:", e);
    }

    public void clearApplicationDataAfterRestoreFailure(String packageName) {
        clearApplicationDataSynchronous(packageName, true, false);
    }

    public void clearApplicationDataBeforeRestore(String packageName) {
        clearApplicationDataSynchronous(packageName, false, true);
    }

    private void clearApplicationDataSynchronous(String packageName, boolean checkFlagAllowClearUserDataOnFailedRestore, boolean keepSystemState) {
        ApplicationInfo applicationInfo = this.mPackageManager.getPackageInfoAsUser(packageName, 0, this.mUserId).applicationInfo;     // Catch: PackageManager.NameNotFoundException -> L49
        if (checkFlagAllowClearUserDataOnFailedRestore == true) goto L57;
    L15:
        if ((applicationInfo.flags & 64) == 0) goto L19;
        boolean r3 = true;
    L20:
        boolean shouldClearData = r3;
    L21:
        if (shouldClearData == true) goto L23;
        return;
    L23:
        ClearDataObserver observer = new ClearDataObserver(this);
        Object r9 = this.mClearDataLock;
        monitor-enter(r9);
        this.mClearingData = true;     // Catch: Throwable -> L45
        this.mActivityManagerInternal.clearApplicationUserData(packageName, keepSystemState, true, observer, this.mUserId);     // Catch: Throwable -> L35
        long timeoutMark = System.currentTimeMillis() + 30000;     // Catch: Throwable -> L35
    L29:
        if (this.mClearingData == false) goto L41;
        if (System.currentTimeMillis() >= timeoutMark) goto L41;
        this.mClearDataLock.wait(5000);     // Catch: Throwable -> L35 InterruptedException -> L37
    L37:
        e = move-exception;
        this.mClearingData = false;     // Catch: Throwable -> L35
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Interrupted while waiting for " + packageName + " data to be cleared", e);     // Catch: Throwable -> L35
    L41:
        if (this.mClearingData == false) goto L43;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Clearing app data for " + packageName + " timed out");     // Catch: Throwable -> L35
    L43:
        monitor-exit(r9);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        Throwable r13 = th;
    L47:
        monitor-exit(r9);     // Catch: Throwable -> L35
        throw r13;
    L45:
        th = move-exception;
        r13 = th;
        goto L47
    L19:
        r3 = false;
        goto L20
    L57:
        if (applicationInfo.targetSdkVersion < 29) goto L15;
        if ((applicationInfo.privateFlags & 67108864) == 0) goto L11;
        shouldClearData = true;
        goto L21
    L11:
        shouldClearData = false;
    L51:
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Tried to clear data for " + packageName + " but not found");
    }

    private BackupEligibilityRules getEligibilityRulesForRestoreAtInstall(long restoreToken) {
        if (this.mAncestralBackupDestination != 1) goto L9;
        if (restoreToken != this.mAncestralToken) goto L9;
        return getEligibilityRulesForOperation(1);
    L9:
        return this.mScheduledBackupEligibility;
    }

    public long getAvailableRestoreToken(String packageName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "getAvailableRestoreToken");
        long token = this.mAncestralToken;
        Object r2 = this.mQueueLock;
        monitor-enter(r2);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentToken != 0) goto L7;
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L9
        return token;
    L7:
        if (this.mProcessedPackagesJournal.hasBeenProcessed(packageName) == false) goto L11;
        token = this.mCurrentToken;     // Catch: Throwable -> L9
        goto L11
    }

    public int requestBackup(String[] packages, IBackupObserver observer, int flags) {
        return requestBackup(packages, observer, null, flags);
    }

    public int requestBackup(String[] packages, IBackupObserver observer, IBackupManagerMonitor monitor, int flags) {
        BackupManagerMonitorEventSender mBackupManagerMonitorEventSender = getBMMEventSender(monitor);
        this.mContext.enforceCallingPermission("android.permission.BACKUP", "requestBackup");
        if (packages != null) goto L5;
    L23:
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "No packages named for backup request");
        BackupObserverUtils.sendBackupFinished(observer, -1000);
        mBackupManagerMonitorEventSender.monitorEvent(49, null, 1, null);
        throw new IllegalArgumentException("No packages are provided for backup");
    L5:
        if (packages.length < 1) goto L23;
        if (this.mEnabled == true) goto L9;
    L17:
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Backup requested but enabled=" + this.mEnabled + " setupComplete=" + this.mSetupComplete);
        BackupObserverUtils.sendBackupFinished(observer, -2001);
        if (this.mSetupComplete == false) goto L20;
        int logTag = 13;
    L21:
        mBackupManagerMonitorEventSender.monitorEvent(logTag, null, 3, null);
        return -2001;
    L20:
        logTag = 14;
        goto L21
    L9:
        if (this.mSetupComplete == false) goto L17;
        String transportDirName = this.mTransportManager.getTransportDirName(this.mTransportManager.getCurrentTransportName());     // Catch: Throwable -> L14
        final TransportConnection transportConnection = this.mTransportManager.getCurrentTransportClientOrThrow("BMS.requestBackup()");     // Catch: Throwable -> L14
        int backupDestination = getBackupDestinationFromTransport(transportConnection);     // Catch: Throwable -> L14
        OnTaskFinishedListener listener = new UserBackupManagerService$$ExternalSyntheticLambda7(this, transportConnection);
        BackupEligibilityRules backupEligibilityRules = getEligibilityRulesForOperation(backupDestination);
        Message msg = this.mBackupHandler.obtainMessage(15);
        msg.obj = getRequestBackupParams(packages, observer, monitor, flags, backupEligibilityRules, transportConnection, transportDirName, listener);
        this.mBackupHandler.sendMessage(msg);
        return 0;
    L15:
        BackupObserverUtils.sendBackupFinished(observer, -1000);
        mBackupManagerMonitorEventSender.monitorEvent(50, null, 1, null);
        return -1000;
    }

    private /* synthetic */ void lambda$requestBackup$1(TransportConnection transportConnection, String caller) {
        this.mTransportManager.disposeOfTransportClient(transportConnection, caller);
    }

    BackupParams getRequestBackupParams(String[] packages, IBackupObserver observer, IBackupManagerMonitor monitor, int flags, BackupEligibilityRules backupEligibilityRules, TransportConnection transportConnection, String transportDirName, OnTaskFinishedListener listener) {
        ArrayList<String> fullBackupList = new ArrayList();
        ArrayList<String> kvBackupList = new ArrayList();
        int r1 = packages.length;
        boolean r2 = false;
        int r5 = 0;
    L3:
        if (r5 >= r1) goto L19;
        String packageName = packages[r5];
        if (PACKAGE_MANAGER_SENTINEL.equals(packageName) == false) goto L24;
        kvBackupList.add(packageName);
    L18:
        r5 = r5 + 1;
        goto L3
    L24:
        PackageInfo packageInfo = this.mPackageManager.getPackageInfoAsUser(packageName, 134217728, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L10
        if (backupEligibilityRules.appIsEligibleForBackup(packageInfo.applicationInfo) == true) goto L13;
        BackupObserverUtils.sendBackupOnPackageResult(observer, packageName, -2001);     // Catch: PackageManager.NameNotFoundException -> L10
        goto L18
    L13:
        if (backupEligibilityRules.appGetsFullBackup(packageInfo) == false) goto L15;
        fullBackupList.add(packageInfo.packageName);     // Catch: PackageManager.NameNotFoundException -> L10
        goto L18
    L15:
        kvBackupList.add(packageInfo.packageName);     // Catch: PackageManager.NameNotFoundException -> L10
    L17:
        BackupObserverUtils.sendBackupOnPackageResult(observer, packageName, -2002);
        goto L18
    L19:
        EventLog.writeEvent(EventLogTags.BACKUP_REQUESTED, new Object[]{Integer.valueOf(packages.length), Integer.valueOf(kvBackupList.size()), Integer.valueOf(fullBackupList.size())});
        if ((flags & 1) == 0) goto L22;
        r2 = true;
    L22:
        boolean nonIncrementalBackup = r2;
        return new BackupParams(transportConnection, transportDirName, kvBackupList, fullBackupList, observer, monitor, listener, true, nonIncrementalBackup, backupEligibilityRules);
    }

    public void cancelBackups() {
        this.mContext.enforceCallingPermission("android.permission.BACKUP", "cancelBackups");
        long oldToken = Binder.clearCallingIdentity();
        Set<Integer> operationsToCancel = this.mOperationStorage.operationTokensForOpType(2);     // Catch: Throwable -> L7
        Iterator<Integer> r4 = operationsToCancel.iterator();     // Catch: Throwable -> L7
    L5:
        if (r4.hasNext() == false) goto L9;
        Integer token = r4.next();     // Catch: Throwable -> L7
        this.mOperationStorage.cancelOperation(token.intValue(), new UserBackupManagerService$$ExternalSyntheticLambda15(), 2);     // Catch: Throwable -> L7
        goto L5
    L9:
        KeyValueBackupJob.schedule(this.mUserId, this.mContext, 3600000, this);     // Catch: Throwable -> L7
        FullBackupJob.schedule(this.mUserId, this.mContext, 7200000, this);     // Catch: Throwable -> L7
        Binder.restoreCallingIdentity(oldToken);
        return;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(oldToken);
        throw th;
    }

    private static /* synthetic */ void lambda$cancelBackups$2(int operationType) {
    }

    public void prepareOperationTimeout(int token, long interval, BackupRestoreTask callback, int operationType) {
        if (operationType != 0) goto L4;
    L7:
        this.mOperationStorage.registerOperation(token, 0, callback, operationType);
        Message msg = this.mBackupHandler.obtainMessage(getMessageIdForOperationType(operationType), token, 0, callback);
        this.mBackupHandler.sendMessageDelayed(msg, interval);
        return;
    L4:
        if (operationType == 1) goto L7;
        Slog.wtf(BackupManagerService.TAG, this.mLogIdMsg + "prepareOperationTimeout() doesn't support operation " + Integer.toHexString(token) + " of type " + operationType);
    }

    private int getMessageIdForOperationType(int operationType) {
        switch(operationType) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L3;
        };
    L3:
        Slog.wtf(BackupManagerService.TAG, this.mLogIdMsg + "getMessageIdForOperationType called on invalid operation type: " + operationType);
        return -1;
    L5:
        return 18;
    L7:
        return 17;
    }

    public boolean waitUntilOperationComplete(int token) {
        return this.mOperationStorage.waitUntilOperationComplete(token, new UserBackupManagerService$$ExternalSyntheticLambda14(this));
    }

    private /* synthetic */ void lambda$waitUntilOperationComplete$3(int operationType) {
        this.mBackupHandler.removeMessages(getMessageIdForOperationType(operationType));
    }

    public void handleCancel(int token, int cancellationReason) {
        IntConsumer timeoutCallback = new UserBackupManagerService$$ExternalSyntheticLambda6(this);
        this.mOperationStorage.cancelOperation(token, timeoutCallback, cancellationReason);
    }

    private /* synthetic */ void lambda$handleCancel$4(int opType) {
        if (opType != 0) goto L4;
    L5:
        this.mBackupHandler.removeMessages(getMessageIdForOperationType(opType));
        return;
    L4:
        if (opType == 1) goto L5;
    }

    public boolean isBackupOperationInProgress() {
        return this.mOperationStorage.isBackupOperationInProgress();
    }

    public void scheduleNextFullBackupJob(long transportMinLatency) {
        Object r0 = this.mQueueLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFullBackupQueue.size() <= 0) goto L13;
        long upcomingLastBackup = this.mFullBackupQueue.get(0).lastBackup;     // Catch: Throwable -> L11
        long timeSinceLast = System.currentTimeMillis() - upcomingLastBackup;     // Catch: Throwable -> L11
        long interval = this.mConstants.getFullBackupIntervalMilliseconds();     // Catch: Throwable -> L11
        if (timeSinceLast >= interval) goto L9;
        long appLatency = interval - timeSinceLast;     // Catch: Throwable -> L11
    L10:
        long latency = Math.max(transportMinLatency, appLatency);     // Catch: Throwable -> L11
        FullBackupJob.schedule(this.mUserId, this.mContext, latency, this);     // Catch: Throwable -> L11
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L9:
        appLatency = 0;
        goto L10
    L13:
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Full backup queue empty; not scheduling");     // Catch: Throwable -> L11
        goto L14
    }

    private void dequeueFullBackupLocked(String packageName) {
        int numPackages = this.mFullBackupQueue.size();
        int i = numPackages - 1;
    L3:
        if (i < 0) goto L9;
        FullBackupEntry e = this.mFullBackupQueue.get(i);
        if (packageName.equals(e.packageName) == false) goto L7;
        this.mFullBackupQueue.remove(i);
    L7:
        i = i - 1;
        goto L3
    }

    public void enqueueFullBackup(String packageName, long lastBackedUp) {
        FullBackupEntry newEntry = new FullBackupEntry(packageName, lastBackedUp);
        Object r1 = this.mQueueLock;
        monitor-enter(r1);
        dequeueFullBackupLocked(packageName);     // Catch: Throwable -> L11
        int which = -1;
        if (lastBackedUp <= 0) goto L14;
        which = this.mFullBackupQueue.size() - 1;     // Catch: Throwable -> L11
    L7:
        if (which < 0) goto L14;
        FullBackupEntry entry = this.mFullBackupQueue.get(which);     // Catch: Throwable -> L11
        if (entry.lastBackup <= lastBackedUp) goto L10;
        which = which - 1;     // Catch: Throwable -> L11
        goto L7
    L10:
        this.mFullBackupQueue.add(which + 1, newEntry);     // Catch: Throwable -> L11
    L14:
        if (which >= 0) goto L16;
        this.mFullBackupQueue.add(0, newEntry);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        writeFullBackupScheduleAsync();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean fullBackupAllowable(String transportName) {
        if (this.mTransportManager.isTransportRegistered(transportName) == true) goto L16;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Transport not registered; full data backup not performed");
        return false;
    L16:
        String transportDirName = this.mTransportManager.getTransportDirName(transportName);     // Catch: Exception -> L10
        File stateDir = new File(this.mBaseStateDir, transportDirName);     // Catch: Exception -> L10
        File pmState = new File(stateDir, PACKAGE_MANAGER_SENTINEL);     // Catch: Exception -> L10
        if (pmState.length() > 0) goto L12;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Full backup requested but dataset not yet initialized");     // Catch: Exception -> L10
        return false;
    L12:
        return true;
    L10:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Unable to get transport name: " + e.getMessage());
        return false;
    }

    public boolean beginFullBackup(FullBackupJob r32) {
        long r13 = System.currentTimeMillis();
        BackupManagerConstants r2 = this.mConstants;
        monitor-enter(r2);
        long r3 = this.mConstants.getFullBackupIntervalMilliseconds();     // Catch: Throwable -> L137
        long r4 = this.mConstants.getKeyValueBackupIntervalMilliseconds();     // Catch: Throwable -> L137
        monitor-exit(r2);     // Catch: Throwable -> L137
        FullBackupEntry r5 = null;
        long r6 = r3;
        int r7 = 0;
        if (this.mEnabled == false) goto L135;
        if (this.mSetupComplete == false) goto L180;
        PowerSaveState r8 = this.mPowerManager.getPowerSaveState(4);
        if (r8.batterySaverEnabled == false) goto L15;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Deferring scheduled full backups in battery saver mode");
        FullBackupJob.schedule(this.mUserId, this.mContext, r4, this);
        return false;
    L15:
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Beginning scheduled full backup operation");
        Object r9 = this.mQueueLock;
        monitor-enter(r9);
    L128:
        th = th;
        Object r24 = r9;
    L159:
        monitor-exit(r24);     // Catch: Throwable -> L132
        throw th;
    L132:
        th = th;
        goto L159
    L151:
        if (this.mRunningFullBackupTask == null) goto L24;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Backup triggered but one already/still running!");     // Catch: Throwable -> L22
        monitor-exit(r9);     // Catch: Throwable -> L22
        return false;
    L24:
        boolean r0 = true;
    L26:
        if (this.mFullBackupQueue.size() == 0) goto L27;
        boolean r10 = false;
        if (fullBackupAllowable(this.mTransportManager.getCurrentTransportName()) == true) goto L33;
        r0 = false;
        r6 = r4;
    L33:
        if (r0 == true) goto L162;
        long r20 = r4;
        long r22 = r6;
        PowerSaveState r12 = r8;
    L92:
        if (r10 == false) goto L93;
        r4 = r20;
        r6 = r22;
        r8 = r12;
        r7 = 0;
        goto L26
    L93:
        boolean r19 = r0;
        r6 = r22;
    L94:
        if (r19 == true) goto L145;
        r24 = r9;
        boolean r23 = true;
        boolean r25 = false;
        long r14 = r6;
    L120:
        if (r19 == true) goto L124;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Nothing pending full backup or failed to start the operation; rescheduling +" + r14);     // Catch: Throwable -> L103
        FullBackupJob.schedule(this.mUserId, this.mContext, r14, this);     // Catch: Throwable -> L103
        monitor-exit(r24);     // Catch: Throwable -> L103
        return r25;
    L124:
        this.mFullBackupQueue.remove(r25 ? 1 : 0);     // Catch: Throwable -> L103
        this.mWakelock.acquire();     // Catch: Throwable -> L103
        new Thread(this.mRunningFullBackupTask).start();     // Catch: Throwable -> L103
        monitor-exit(r24);     // Catch: Throwable -> L103
        return r23;
    L145:
        CountDownLatch r11 = new CountDownLatch(1);     // Catch: Throwable -> L117
    L172:
        r24 = r9;
        r25 = false;
        r23 = true;
        r14 = r6;
        this.mRunningFullBackupTask = PerformFullTransportBackupTask.newWithCurrentTransport(this, this.mOperationStorage, null, new String[]{r5.packageName}, true, r32, r11, null, null, false, "BMS.beginFullBackup()", getEligibilityRulesForOperation(0));     // Catch: Throwable -> L103 IllegalStateException -> L105
    L105:
        e = e;
    L116:
        Slog.w(BackupManagerService.TAG, "Failed to start backup", e);     // Catch: Throwable -> L103
        r19 = false;
    L103:
        th = th;
        goto L159
    L109:
        e = e;
        r23 = true;
        r24 = r9;
        r25 = false;
        r14 = r6;
    L107:
        th = th;
        r24 = r9;
    L113:
        e = e;
        r23 = true;
        r24 = r9;
        r25 = false;
        r14 = r6;
    L111:
        th = th;
        r24 = r9;
    L117:
        th = th;
        r24 = r9;
        goto L159
    L162:
        r5 = this.mFullBackupQueue.get(r7);     // Catch: Throwable -> L89
        r12 = r8;
    L78:
        th = th;
        r24 = r9;
        goto L159
    L37:
        long r15 = r13 - r5.lastBackup;
        if (r15 < r3) goto L40;
        r19 = true;
    L41:
        if (r19 == false) goto L42;
        r20 = r4;
        r22 = r6;
        PackageInfo r1 = this.mPackageManager.getPackageInfoAsUser(r5.packageName, 0, this.mUserId);     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L70
        if (this.mScheduledBackupEligibility.appGetsFullBackup(r1) == true) goto L57;
        this.mFullBackupQueue.remove(0);     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L53
        r10 = true;
        r0 = r19;
        goto L92
    L57:
        if ((r1.applicationInfo.privateFlags & 8192) == 0) goto L59;
    L61:
        boolean r16 = false;
    L62:
        r10 = r16;
        if (r10 == false) goto L73;
        long r17 = (System.currentTimeMillis() + 3600000) + ((long) this.mTokenGenerator.nextInt(7200000));     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L70
        SimpleDateFormat r18 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L70
        StringBuilder r21 = new StringBuilder();     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L70
        r21.append(this.mLogIdMsg);     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L68
        r21.append("Full backup time but ");     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L68
        r21.append(r5.packageName);     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L68
        r21.append(" is busy; deferring to ");     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L68
        r21.append(r18.format(new Date(r17)));     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L68
        Slog.i(BackupManagerService.TAG, r21.toString());     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L68
        enqueueFullBackup(r5.packageName, r17 - r3);     // Catch: Throwable -> L51 PackageManager.NameNotFoundException -> L68
    L73:
        r0 = r19;
        goto L92
    L59:
        if (this.mActivityManagerInternal.isAppForeground(r1.applicationInfo.uid) == false) goto L61;
        r16 = true;
    L51:
        th = th;
        r24 = r9;
    L85:
        if (this.mFullBackupQueue.size() <= 1) goto L87;
        boolean r26 = true;
    L88:
        r0 = r26;
        goto L92
    L87:
        r26 = false;
        goto L88
    L74:
        th = th;
        r24 = r9;
    L77:
        r22 = r6;
        goto L85
    L81:
        r20 = r4;
        r22 = r6;
        goto L85
    L42:
        r6 = r3 - r15;
        goto L94
    L40:
        r19 = false;
    L89:
        th = th;
        r24 = r9;
        goto L159
    L27:
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Backup queue empty; doing nothing");     // Catch: Throwable -> L22
        r19 = false;
        r12 = r8;
    L22:
        th = th;
        r24 = r9;
        goto L159
    L180:
        return false;
    L135:
        return false;
    L137:
        th = th;
    L143:
        throw th;
    L141:
        th = th;
        goto L143
    }

    public void endFullBackup() {
        Runnable endFullBackupRunnable = new UserBackupManagerService$$ExternalSyntheticLambda1(this);
        new Thread(endFullBackupRunnable, "end-full-backup").start();
    }

    private /* synthetic */ void lambda$endFullBackup$5() {
        PerformFullTransportBackupTask pftbt = null;
        Object r1 = this.mQueueLock;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mRunningFullBackupTask == null) goto L9;
        pftbt = this.mRunningFullBackupTask;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L7
        if (pftbt == null) goto L17;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Telling running backup to stop");
        pftbt.handleCancel(3);
        return;
    }

    public void restoreWidgetData(String packageName, byte[] widgetData) {
        AppWidgetBackupBridge.restoreWidgetState(packageName, widgetData, this.mUserId);
    }

    public void dataChangedImpl(String packageName) {
        HashSet<String> targets = dataChangedTargets(packageName);
        dataChangedImpl(packageName, targets);
    }

    private void dataChangedImpl(String packageName, HashSet<String> targets) {
        if (targets != null) goto L5;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "dataChanged but no participant pkg='" + packageName + "' uid=" + Binder.getCallingUid());
        return;
    L5:
        Object r0 = this.mQueueLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (targets.contains(packageName) == false) goto L14;
        BackupRequest req = new BackupRequest(packageName);     // Catch: Throwable -> L12
        if (this.mPendingBackups.put(packageName, req) != null) goto L14;
        writeToJournalLocked(packageName);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        KeyValueBackupJob.schedule(this.mUserId, this.mContext, this);
    }

    private HashSet<String> dataChangedTargets(String packageName) {
        if (this.mContext.checkPermission("android.permission.BACKUP", Binder.getCallingPid(), Binder.getCallingUid()) != (-1)) goto L13;
        SparseArray<HashSet<String>> r0 = this.mBackupParticipants;
        monitor-enter(r0);
        HashSet<String> r1 = this.mBackupParticipants.get(Binder.getCallingUid());     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        if (PACKAGE_MANAGER_SENTINEL.equals(packageName) == true) goto L15;
        SparseArray<HashSet<String>> r2 = this.mBackupParticipants;
        monitor-enter(r2);
        HashSet<String> r3 = SparseArrayUtils.union(this.mBackupParticipants);     // Catch: Throwable -> L21
        monitor-exit(r2);     // Catch: Throwable -> L21
        return r3;
    L21:
        th = move-exception;
        throw th;
    L15:
        return Sets.newHashSet(new String[]{PACKAGE_MANAGER_SENTINEL});
    }

    private void writeToJournalLocked(String str) {
    L5:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Can't write " + str + " to backup journal", e);
        this.mJournal = null;
        return;
    L3:
        if (this.mJournal != null) goto L7;
        this.mJournal = DataChangedJournal.newJournal(this.mJournalDir);     // Catch: IOException -> L5
    L7:
        this.mJournal.addPackage(str);     // Catch: IOException -> L5
    }

    public void dataChanged(final String packageName) {
        final HashSet<String> targets = dataChangedTargets(packageName);
        if (targets != null) goto L6;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "dataChanged but no participant pkg='" + packageName + "' uid=" + Binder.getCallingUid());
        return;
    L6:
        this.mBackupHandler.post(new AnonymousClass3(this, packageName, targets));
    }

    public void initializeTransports(String[] transportNames, IBackupObserver observer) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "initializeTransport");
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "initializeTransport(): " + Arrays.asList(transportNames));
        long oldId = Binder.clearCallingIdentity();
        this.mWakelock.acquire();     // Catch: Throwable -> L6
        OnTaskFinishedListener listener = new UserBackupManagerService$$ExternalSyntheticLambda13(this);     // Catch: Throwable -> L6
        this.mBackupHandler.post(new PerformInitializeTask(this, transportNames, observer, listener));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(oldId);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    private /* synthetic */ void lambda$initializeTransports$6(String caller) {
        this.mWakelock.release();
    }

    public void setAncestralSerialNumber(long ancestralSerialNumber) {
        this.mContext.enforceCallingPermission("android.permission.BACKUP", "setAncestralSerialNumber");
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Setting ancestral work profile id to " + ancestralSerialNumber);
        RandomAccessFile af = new RandomAccessFile(getAncestralSerialNumberFile(), "rwd");     // Catch: IOException -> L7
        af.writeLong(ancestralSerialNumber);     // Catch: Throwable -> L9
        af.close();     // Catch: IOException -> L7
        return;
    L9:
        th = move-exception;
        af.close();     // Catch: Throwable -> L12
    L14:
        throw th;     // Catch: IOException -> L7
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Unable to write to work profile serial mapping file:", e);
    }

    public long getAncestralSerialNumber() {
        RandomAccessFile af = new RandomAccessFile(getAncestralSerialNumberFile(), ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);     // Catch: IOException -> L6 FileNotFoundException -> L8
        long r1 = af.readLong();     // Catch: Throwable -> L10
        af.close();     // Catch: IOException -> L6 FileNotFoundException -> L8
        return r1;
    L10:
        th = move-exception;
        af.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: IOException -> L6 FileNotFoundException -> L8
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L6 FileNotFoundException -> L8
    L6:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Unable to read work profile serial number file:", e);
        return -1;
    L25:
        return -1;
    }

    private File getAncestralSerialNumberFile() {
        if (this.mAncestralSerialNumberFile != null) goto L6;
        this.mAncestralSerialNumberFile = new File(UserBackupManagerFiles.getBaseStateDir(getUserId()), SERIAL_ID_FILE);
    L6:
        return this.mAncestralSerialNumberFile;
    }

    void setAncestralSerialNumberFile(File ancestralSerialNumberFile) {
        this.mAncestralSerialNumberFile = ancestralSerialNumberFile;
    }

    public void clearBackupData(String transportName, String packageName) {
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "clearBackupData() of " + packageName + " on " + transportName);
        PackageInfo info = this.mPackageManager.getPackageInfoAsUser(packageName, 134217728, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L30
        if (this.mContext.checkPermission("android.permission.BACKUP", Binder.getCallingPid(), Binder.getCallingUid()) != (-1)) goto L7;
        HashSet<String> apps = this.mBackupParticipants.get(Binder.getCallingUid());
    L9:
        if (apps.contains(packageName) == false) goto L29;
        this.mBackupHandler.removeMessages(12);
        Object r2 = this.mQueueLock;
        monitor-enter(r2);
        final TransportConnection transportConnection = this.mTransportManager.getTransportClient(transportName, "BMS.clearBackupData()");     // Catch: Throwable -> L17
        if (transportConnection != null) goto L19;
        Message msg = this.mBackupHandler.obtainMessage(12, new ClearRetryParams(transportName, packageName));     // Catch: Throwable -> L17
        this.mBackupHandler.sendMessageDelayed(msg, 3600000);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L19:
        long oldId = Binder.clearCallingIdentity();     // Catch: Throwable -> L17
        OnTaskFinishedListener listener = new UserBackupManagerService$$ExternalSyntheticLambda10(this, transportConnection);     // Catch: Throwable -> L24
        this.mWakelock.acquire();     // Catch: Throwable -> L24
        Message msg2 = this.mBackupHandler.obtainMessage(4, new ClearParams(transportConnection, info, listener));     // Catch: Throwable -> L24
        this.mBackupHandler.sendMessage(msg2);     // Catch: Throwable -> L24
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        return;
    L24:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L29:
        return;
    L7:
        apps = this.mProcessedPackagesJournal.getPackagesCopy();
    L31:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "No such package '" + packageName + "' - not clearing backup data");
    }

    private /* synthetic */ void lambda$clearBackupData$7(TransportConnection transportConnection, String caller) {
        this.mTransportManager.disposeOfTransportClient(transportConnection, caller);
    }

    public void backupNow() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "backupNow");
        long oldId = Binder.clearCallingIdentity();
        PowerSaveState result = this.mPowerManager.getPowerSaveState(5);     // Catch: Throwable -> L6
        if (result.batterySaverEnabled == false) goto L8;
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Not running backup while in battery save mode");     // Catch: Throwable -> L6
        KeyValueBackupJob.schedule(this.mUserId, this.mContext, this);     // Catch: Throwable -> L6
    L28:
        Binder.restoreCallingIdentity(oldId);
        return;
    L8:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Scheduling immediate backup pass");     // Catch: Throwable -> L6
        Object r3 = getQueueLock();     // Catch: Throwable -> L6
        monitor-enter(r3);     // Catch: Throwable -> L6
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L6
    L11:
        if (getPendingInits().size() > 0) goto L38;
        monitor-exit(r3);     // Catch: Throwable -> L14
        if (isEnabled() == false) goto L30;
        if (isSetupComplete() == false) goto L30;
        Message message = this.mBackupHandler.obtainMessage(1);     // Catch: Throwable -> L6
        this.mBackupHandler.sendMessage(message);     // Catch: Throwable -> L6
        KeyValueBackupJob.cancel(this.mUserId, this.mContext);     // Catch: Throwable -> L6
    L30:
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Backup pass but enabled=" + isEnabled() + " setupComplete=" + isSetupComplete());     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(oldId);
        return;
    L38:
        getAlarmManager().cancel(this.mRunInitIntent);     // Catch: Throwable -> L14 PendingIntent.CanceledException -> L16
        this.mRunInitIntent.send();     // Catch: Throwable -> L14 PendingIntent.CanceledException -> L16
    L18:
        monitor-exit(r3);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(oldId);
        return;
    L17:
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Run init intent cancelled");     // Catch: Throwable -> L14
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    public void adbBackup(ParcelFileDescriptor fd, boolean includeApks, boolean includeObbs, boolean includeShared, boolean doWidgets, boolean doAllApps, boolean includeSystem, boolean compress, boolean doKeyValue, String[] pkgList) {
        this.mContext.enforceCallingPermission("android.permission.BACKUP", "adbBackup");
        int callingUserHandle = UserHandle.getCallingUserId();
        if (callingUserHandle != 0) goto L54;
        if (doAllApps == true) goto L12;
        if (includeShared == true) goto L12;
        if (pkgList == null) goto L11;
        if (pkgList.length != 0) goto L12;
    L11:
        throw new IllegalArgumentException("Backup requested but neither shared nor any apps named");
    L12:
        long oldId = Binder.clearCallingIdentity();
    L22:
        th = move-exception;
        fd.close();     // Catch: IOException -> L49
    L51:
        Binder.restoreCallingIdentity(oldId);
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Adb backup processing complete.");
        throw th;
    L49:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "IO error closing output for adb backup: " + e.getMessage());
        goto L51
    L14:
        if (this.mSetupComplete == true) goto L24;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Backup not supported before setup");     // Catch: Throwable -> L22
        fd.close();     // Catch: IOException -> L18
    L20:
        Binder.restoreCallingIdentity(oldId);
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Adb backup processing complete.");
        return;
    L18:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "IO error closing output for adb backup: " + e.getMessage());
        goto L20
    L24:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Requesting backup: apks=" + includeApks + " obb=" + includeObbs + " shared=" + includeShared + " all=" + doAllApps + " system=" + includeSystem + " includekeyvalue=" + doKeyValue + " pkgs=" + Arrays.toString(pkgList));     // Catch: Throwable -> L22
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L22
        r2.append(this.mLogIdMsg);     // Catch: Throwable -> L22
        r2.append("Beginning adb backup...");     // Catch: Throwable -> L22
        Slog.i(BackupManagerService.TAG, r2.toString());     // Catch: Throwable -> L22
        BackupEligibilityRules eligibilityRules = getEligibilityRulesForOperation(2);     // Catch: Throwable -> L22
        AdbBackupParams params = new AdbBackupParams(fd, includeApks, includeObbs, includeShared, doWidgets, doAllApps, includeSystem, compress, doKeyValue, pkgList, eligibilityRules);     // Catch: Throwable -> L22
        int token = generateRandomIntegerToken();     // Catch: Throwable -> L22
        SparseArray<AdbParams> r4 = this.mAdbBackupRestoreConfirmations;     // Catch: Throwable -> L22
        monitor-enter(r4);     // Catch: Throwable -> L22
        this.mAdbBackupRestoreConfirmations.put(token, params);     // Catch: Throwable -> L44
        monitor-exit(r4);     // Catch: Throwable -> L44
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Starting backup confirmation UI");     // Catch: Throwable -> L22
        if (startConfirmationUi(token, "fullback") == true) goto L37;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to launch backup confirmation UI");     // Catch: Throwable -> L22
        this.mAdbBackupRestoreConfirmations.delete(token);     // Catch: Throwable -> L22
        fd.close();     // Catch: IOException -> L33
    L35:
        Binder.restoreCallingIdentity(oldId);
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Adb backup processing complete.");
        return;
    L33:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "IO error closing output for adb backup: " + e.getMessage());
        goto L35
    L37:
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), 0, 0);     // Catch: Throwable -> L22
        startConfirmationTimeout(token, params);     // Catch: Throwable -> L22
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Waiting for backup completion...");     // Catch: Throwable -> L22
        waitForCompletion(params);     // Catch: Throwable -> L22
        fd.close();     // Catch: IOException -> L40
    L42:
        Binder.restoreCallingIdentity(oldId);
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Adb backup processing complete.");
        return;
    L40:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "IO error closing output for adb backup: " + e.getMessage());
        goto L42
    L44:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L54:
        throw new IllegalStateException("Backup supported only for the device owner");
    }

    public void fullTransportBackup(String[] pkgNames) {
        this.mContext.enforceCallingPermission("android.permission.BACKUP", "fullTransportBackup");
        int callingUserHandle = UserHandle.getCallingUserId();
        if (callingUserHandle != 0) goto L36;
        String transportName = this.mTransportManager.getCurrentTransportName();
        if (fullBackupAllowable(transportName) == true) goto L7;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Full backup not possible. Key/value backup not yet run?");
    L21:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Done with full transport backup.");
        return;
    L7:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "fullTransportBackup()");
        long oldId = Binder.clearCallingIdentity();
        CountDownLatch latch = new CountDownLatch(1);     // Catch: Throwable -> L25 IllegalStateException -> L27
    L40:
        Runnable task = PerformFullTransportBackupTask.newWithCurrentTransport(this, this.mOperationStorage, null, pkgNames, false, null, latch, null, null, false, "BMS.fullTransportBackup()", getEligibilityRulesForOperation(0));     // Catch: Throwable -> L16 IllegalStateException -> L18
        this.mWakelock.acquire();     // Catch: Throwable -> L16 IllegalStateException -> L18
        new Thread(task, "full-transport-master").start();     // Catch: Throwable -> L16 IllegalStateException -> L18
    L37:
        latch.await();     // Catch: Throwable -> L16 IllegalStateException -> L18 InterruptedException -> L23
        long now = System.currentTimeMillis();     // Catch: Throwable -> L16 IllegalStateException -> L18
        int r0 = pkgNames.length;     // Catch: Throwable -> L16 IllegalStateException -> L18
        int r3 = 0;
    L13:
        if (r3 >= r0) goto L20;
        String pkg = pkgNames[r3];     // Catch: Throwable -> L16 IllegalStateException -> L18
        enqueueFullBackup(pkg, now);     // Catch: Throwable -> L16 IllegalStateException -> L18
        r3 = r3 + 1;
        goto L13
    L20:
        Binder.restoreCallingIdentity(oldId);
    L18:
        e = e;
    L30:
        Slog.w(BackupManagerService.TAG, "Failed to start backup: ", e);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(oldId);
        return;
    L16:
        e = th;
    L33:
        Binder.restoreCallingIdentity(oldId);
        throw e;
    L27:
        e = e;
    L25:
        e = th;
        goto L33
    L36:
        throw new IllegalStateException("Restore supported only for the device owner");
    }

    public void adbRestore(ParcelFileDescriptor fd) {
        this.mContext.enforceCallingPermission("android.permission.BACKUP", "adbRestore");
        int callingUserHandle = UserHandle.getCallingUserId();
        if (callingUserHandle != 0) goto L46;
        long oldId = Binder.clearCallingIdentity();
    L14:
        th = move-exception;
        fd.close();     // Catch: IOException -> L41
    L43:
        Binder.restoreCallingIdentity(oldId);
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "adb restore processing complete.");
        throw th;
    L41:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Error trying to close fd after adb restore: " + e);
        goto L43
    L6:
        if (this.mSetupComplete == true) goto L16;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Full restore not permitted before setup");     // Catch: Throwable -> L14
        fd.close();     // Catch: IOException -> L10
    L12:
        Binder.restoreCallingIdentity(oldId);
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "adb restore processing complete.");
        return;
    L10:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Error trying to close fd after adb restore: " + e);
        goto L12
    L16:
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Beginning restore...");     // Catch: Throwable -> L14
        AdbRestoreParams params = new AdbRestoreParams(fd);     // Catch: Throwable -> L14
        int token = generateRandomIntegerToken();     // Catch: Throwable -> L14
        SparseArray<AdbParams> r5 = this.mAdbBackupRestoreConfirmations;     // Catch: Throwable -> L14
        monitor-enter(r5);     // Catch: Throwable -> L14
        this.mAdbBackupRestoreConfirmations.put(token, params);     // Catch: Throwable -> L36
        monitor-exit(r5);     // Catch: Throwable -> L36
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Starting restore confirmation UI, token=" + token);     // Catch: Throwable -> L14
        if (startConfirmationUi(token, "fullrest") == true) goto L29;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to launch restore confirmation");     // Catch: Throwable -> L14
        this.mAdbBackupRestoreConfirmations.delete(token);     // Catch: Throwable -> L14
        fd.close();     // Catch: IOException -> L25
    L27:
        Binder.restoreCallingIdentity(oldId);
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "adb restore processing complete.");
        return;
    L25:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Error trying to close fd after adb restore: " + e);
        goto L27
    L29:
        this.mPowerManager.userActivity(SystemClock.uptimeMillis(), 0, 0);     // Catch: Throwable -> L14
        startConfirmationTimeout(token, params);     // Catch: Throwable -> L14
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Waiting for restore completion...");     // Catch: Throwable -> L14
        waitForCompletion(params);     // Catch: Throwable -> L14
        fd.close();     // Catch: IOException -> L32
    L34:
        Binder.restoreCallingIdentity(oldId);
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "adb restore processing complete.");
        return;
    L32:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Error trying to close fd after adb restore: " + e);
        goto L34
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L46:
        throw new IllegalStateException("Restore supported only for the device owner");
    }

    public void excludeKeysFromRestore(String packageName, List<String> keys) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "excludeKeysFromRestore");
        this.mBackupPreferences.addExcludedKeys(packageName, keys);
    }

    public void reportDelayedRestoreResult(String packageName, List<BackupRestoreEventLogger.DataTypeResult> results) {
        String transport = this.mTransportManager.getCurrentTransportName();
        if (transport != null) goto L6;
        Slog.w(BackupManagerService.TAG, "Failed to send delayed restore logs as no transport selected");
        return;
    L6:
        TransportConnection transportConnection = null;
        PackageInfo packageInfo = getPackageManager().getPackageInfoAsUser(packageName, PackageManager.PackageInfoFlags.of(0), getUserId());     // Catch: Throwable -> L9 Throwable -> L11
        transportConnection = this.mTransportManager.getTransportClientOrThrow(transport, "BMS.reportDelayedRestoreResult");     // Catch: Throwable -> L9 Throwable -> L11
        BackupTransportClient transportClient = transportConnection.connectOrThrow("BMS.reportDelayedRestoreResult");     // Catch: Throwable -> L9 Throwable -> L11
        IBackupManagerMonitor monitor = transportClient.getBackupManagerMonitor();     // Catch: Throwable -> L9 Throwable -> L11
        BackupManagerMonitorEventSender mBackupManagerMonitorEventSender = getBMMEventSender(monitor);     // Catch: Throwable -> L9 Throwable -> L11
        mBackupManagerMonitorEventSender.sendAgentLoggingResults(packageInfo, results, 1);     // Catch: Throwable -> L9 Throwable -> L11
    L8:
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.reportDelayedRestoreResult");
        return;
    L9:
        th = move-exception;
        if (transportConnection == null) goto L18;
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.reportDelayedRestoreResult");
    L18:
        throw th;
    L11:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Failed to send delayed restore logs: " + e);     // Catch: Throwable -> L9
        if (transportConnection != null) goto L8;
    }

    private boolean startConfirmationUi(int token, String action) {
        Intent confIntent = new Intent(action);     // Catch: ActivityNotFoundException -> L5
        confIntent.setClassName("com.android.backupconfirm", "com.android.backupconfirm.BackupRestoreConfirmation");     // Catch: ActivityNotFoundException -> L5
        confIntent.putExtra("conftoken", token);     // Catch: ActivityNotFoundException -> L5
        confIntent.addFlags(536870912);     // Catch: ActivityNotFoundException -> L5
        this.mContext.startActivityAsUser(confIntent, UserHandle.SYSTEM);     // Catch: ActivityNotFoundException -> L5
        return true;
    L6:
        return false;
    }

    private void startConfirmationTimeout(int token, AdbParams params) {
        Message msg = this.mBackupHandler.obtainMessage(9, token, 0, params);
        this.mBackupHandler.sendMessageDelayed(msg, 60000);
    }

    private void waitForCompletion(AdbParams params) {
        AtomicBoolean r0 = params.latch;
        monitor-enter(r0);
    L16:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (params.latch.get() == true) goto L12;
        params.latch.wait();     // Catch: Throwable -> L8 InterruptedException -> L10
        goto L16
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void signalAdbBackupRestoreCompletion(AdbParams params) {
        AtomicBoolean r0 = params.latch;
        monitor-enter(r0);
        params.latch.set(true);     // Catch: Throwable -> L7
        params.latch.notifyAll();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void acknowledgeAdbBackupOrRestore(int token, boolean allow, String curPassword, String encPpassword, IFullBackupRestoreObserver observer) {
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "acknowledgeAdbBackupOrRestore : token=" + token + " allow=" + allow);
        this.mContext.enforceCallingPermission("android.permission.BACKUP", "acknowledgeAdbBackupOrRestore");
        long oldId = Binder.clearCallingIdentity();
        SparseArray<AdbParams> r2 = this.mAdbBackupRestoreConfirmations;     // Catch: Throwable -> L23
        monitor-enter(r2);     // Catch: Throwable -> L23
        AdbParams params = this.mAdbBackupRestoreConfirmations.get(token);     // Catch: Throwable -> L14
        if (params == null) goto L17;
        this.mBackupHandler.removeMessages(9, params);     // Catch: Throwable -> L14
        this.mAdbBackupRestoreConfirmations.delete(token);     // Catch: Throwable -> L14
        if (allow == true) goto L10;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "User rejected full backup/restore operation");     // Catch: Throwable -> L14
        signalAdbBackupRestoreCompletion(params);     // Catch: Throwable -> L14
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(oldId);
        return;
    L10:
        if ((params instanceof AdbBackupParams) == false) goto L12;
        int verb = 2;
    L13:
        params.observer = observer;     // Catch: Throwable -> L14
        params.curPassword = curPassword;     // Catch: Throwable -> L14
        params.encryptPassword = encPpassword;     // Catch: Throwable -> L14
        this.mWakelock.acquire();     // Catch: Throwable -> L14
        Message msg = this.mBackupHandler.obtainMessage(verb, params);     // Catch: Throwable -> L14
        this.mBackupHandler.sendMessage(msg);     // Catch: Throwable -> L14
        goto L18
    L12:
        verb = 10;
        goto L13
    L17:
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Attempted to ack full backup/restore with invalid token");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    BackupManagerMonitorEventSender getBMMEventSender(IBackupManagerMonitor monitor) {
        return new BackupManagerMonitorEventSender(monitor);
    }

    public void setBackupEnabled(boolean enable) {
        setBackupEnabled(enable, true);
    }

    private void setBackupEnabled(boolean enable, boolean persistToDisk) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "setBackupEnabled");
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Backup enabled => " + enable);
        long oldId = Binder.clearCallingIdentity();
        boolean wasEnabled = this.mEnabled;     // Catch: Throwable -> L14
        monitor-enter(this);     // Catch: Throwable -> L14
        if (persistToDisk == true) goto L20;
    L9:
        this.mEnabled = enable;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        updateStateOnBackupEnabled(wasEnabled, enable);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(oldId);
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L20:
        writeEnabledState(enable);     // Catch: Throwable -> L7
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    synchronized void setFrameworkSchedulingEnabled(boolean isEnabled) {
        monitor-enter(this);
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "setFrameworkSchedulingEnabled");     // Catch: Throwable -> L10
        boolean wasEnabled = isFrameworkSchedulingEnabled();     // Catch: Throwable -> L10
        if (wasEnabled != isEnabled) goto L7;
        monitor-exit(this);
        return;
    L7:
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L10
        r2.append(this.mLogIdMsg);     // Catch: Throwable -> L10
        if (isEnabled == false) goto L12;
        String r3 = "Enabling";
    L13:
        r2.append(r3);     // Catch: Throwable -> L10
        r2.append(" backup scheduling");     // Catch: Throwable -> L10
        Slog.i(BackupManagerService.TAG, r2.toString());     // Catch: Throwable -> L10
        long oldId = Binder.clearCallingIdentity();     // Catch: Throwable -> L10
        ContentResolver r4 = this.mContext.getContentResolver();     // Catch: Throwable -> L21
        if (isEnabled == false) goto L17;
        int r5 = 1;
    L18:
        Settings.Secure.putIntForUser(r4, "backup_scheduling_enabled", r5, this.mUserId);     // Catch: Throwable -> L21
        if (isEnabled == true) goto L23;
        KeyValueBackupJob.cancel(this.mUserId, this.mContext);     // Catch: Throwable -> L21
        FullBackupJob.cancel(this.mUserId, this.mContext);     // Catch: Throwable -> L21
    L24:
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L23:
        KeyValueBackupJob.schedule(this.mUserId, this.mContext, this);     // Catch: Throwable -> L21
        scheduleNextFullBackupJob(0);     // Catch: Throwable -> L21
        goto L24
    L17:
        r5 = 0;
    L21:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    L12:
        r3 = "Disabling";
    L10:
        th = move-exception;
        throw th;
    }

    synchronized boolean isFrameworkSchedulingEnabled() {
        monitor-enter(this);
        boolean r4 = true;
        int isEnabled = Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "backup_scheduling_enabled", 1, this.mUserId);     // Catch: Throwable -> L10
        if (isEnabled == 1) goto L8;
        r4 = false;
    L8:
        monitor-exit(this);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    void updateStateOnBackupEnabled(boolean wasEnabled, boolean enable) {
        Object r0 = this.mQueueLock;
        monitor-enter(r0);
        if (enable == false) goto L11;
        if (wasEnabled == true) goto L11;
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mSetupComplete == false) goto L11;
        KeyValueBackupJob.schedule(this.mUserId, this.mContext, this);     // Catch: Throwable -> L9
        scheduleNextFullBackupJob(0);     // Catch: Throwable -> L9
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        if (enable == true) goto L21;
        KeyValueBackupJob.cancel(this.mUserId, this.mContext);     // Catch: Throwable -> L9
        if (wasEnabled == false) goto L21;
        if (this.mSetupComplete == false) goto L21;
        final List<String> transportNames = new ArrayList();     // Catch: Throwable -> L9
        final List<String> transportDirNames = new ArrayList();     // Catch: Throwable -> L9
        this.mTransportManager.forEachRegisteredTransport(new UserBackupManagerService$$ExternalSyntheticLambda11(this, transportNames, transportDirNames));     // Catch: Throwable -> L9
        int i = 0;
    L18:
        if (i >= transportNames.size()) goto L20;
        recordInitPending(true, transportNames.get(i), transportDirNames.get(i));     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L18
    L20:
        this.mAlarmManager.set(0, System.currentTimeMillis(), this.mRunInitIntent);     // Catch: Throwable -> L9
        goto L21
    }

    private /* synthetic */ void lambda$updateStateOnBackupEnabled$8(List transportNames, List transportDirNames, String name) {
        String dirName = this.mTransportManager.getTransportDirName(name);     // Catch: TransportNotRegisteredException -> L5
        transportNames.add(name);
        transportDirNames.add(dirName);
        return;
    L5:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unexpected unregistered transport", e);
    }

    void writeEnabledState(boolean enable) {
        UserBackupManagerFilePersistedSettings.writeBackupEnableState(this.mUserId, enable);
    }

    boolean readEnabledState() {
        return UserBackupManagerFilePersistedSettings.readBackupEnableState(this.mUserId);
    }

    public void setAutoRestore(boolean doAutoRestore) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "setAutoRestore");
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Auto restore => " + doAutoRestore);
        long oldId = Binder.clearCallingIdentity();
        monitor-enter(this);     // Catch: Throwable -> L15
        ContentResolver r2 = this.mContext.getContentResolver();     // Catch: Throwable -> L12
        if (doAutoRestore == false) goto L7;
        int r4 = 1;
    L8:
        Settings.Secure.putIntForUser(r2, "backup_auto_restore", r4, this.mUserId);     // Catch: Throwable -> L12
        this.mAutoRestore = doAutoRestore;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(oldId);
        return;
    L7:
        r4 = 0;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    public boolean isBackupEnabled() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "isBackupEnabled");
        return this.mEnabled;
    }

    public String getCurrentTransport() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "getCurrentTransport");
        String currentTransport = this.mTransportManager.getCurrentTransportName();
        return currentTransport;
    }

    public ComponentName getCurrentTransportComponent() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "getCurrentTransportComponent");
        long oldId = Binder.clearCallingIdentity();
        ComponentName r2 = this.mTransportManager.getCurrentTransportComponent();     // Catch: Throwable -> L6 TransportNotRegisteredException -> L8
        Binder.restoreCallingIdentity(oldId);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    L12:
        Binder.restoreCallingIdentity(oldId);
        return null;
    }

    public String[] listAllTransports() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "listAllTransports");
        return this.mTransportManager.getRegisteredTransportNames();
    }

    public ComponentName[] listAllTransportComponents() {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "listAllTransportComponents");
        return this.mTransportManager.getRegisteredTransportComponents();
    }

    public void updateTransportAttributes(ComponentName transportComponent, String name, Intent configurationIntent, String currentDestinationString, Intent dataManagementIntent, CharSequence dataManagementLabel) {
        updateTransportAttributes(Binder.getCallingUid(), transportComponent, name, configurationIntent, currentDestinationString, dataManagementIntent, dataManagementLabel);
    }

    void updateTransportAttributes(int callingUid, ComponentName transportComponent, String name, Intent configurationIntent, String currentDestinationString, Intent dataManagementIntent, CharSequence dataManagementLabel) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "updateTransportAttributes");
        transportComponent.getClass();
        name.getClass();
        currentDestinationString.getClass();
        boolean r0 = true;
        if (dataManagementIntent != null) goto L5;
        boolean r2 = true;
    L6:
        if (dataManagementLabel != null) goto L8;
        boolean r3 = true;
    L9:
        if (r2 == r3) goto L12;
        r0 = false;
    L12:
        Preconditions.checkArgument(r0, "dataManagementLabel should be null iff dataManagementIntent is null");
        int transportUid = this.mContext.getPackageManager().getPackageUidAsUser(transportComponent.getPackageName(), 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L24
        if (callingUid != transportUid) goto L23;
        long oldId = Binder.clearCallingIdentity();
        this.mTransportManager.updateTransportAttributes(transportComponent, name, configurationIntent, currentDestinationString, dataManagementIntent, dataManagementLabel);     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(oldId);
        return;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    L23:
        throw new SecurityException("Only the transport can change its description");     // Catch: PackageManager.NameNotFoundException -> L24
    L24:
        e = move-exception;
        throw new SecurityException("Transport package not found", e);
    L8:
        r3 = false;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    @Deprecated
    public String selectBackupTransport(String transportName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "selectBackupTransport");
        long oldId = Binder.clearCallingIdentity();
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    L5:
        if (this.mTransportManager.isTransportRegistered(transportName) == true) goto L11;
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Could not select transport " + transportName + ", as the transport is not registered.");     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(oldId);
        return null;
    L11:
        String previousTransportName = this.mTransportManager.selectTransport(transportName);     // Catch: Throwable -> L9
        updateStateForTransport(transportName);     // Catch: Throwable -> L9
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "selectBackupTransport(transport = " + transportName + "): previous transport = " + previousTransportName);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(oldId);
        return previousTransportName;
    }

    public void selectBackupTransportAsync(final ComponentName transportComponent, final ISelectBackupTransportCallback listener) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "selectBackupTransportAsync");
        long oldId = Binder.clearCallingIdentity();
        String transportString = transportComponent.flattenToShortString();     // Catch: Throwable -> L6
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "selectBackupTransportAsync(transport = " + transportString + ")");     // Catch: Throwable -> L6
        this.mBackupHandler.post(new UserBackupManagerService$$ExternalSyntheticLambda9(this, transportComponent, listener));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(oldId);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(oldId);
        throw th;
    }

    private /* synthetic */ void lambda$selectBackupTransportAsync$9(ComponentName transportComponent, ISelectBackupTransportCallback listener) {
        String transportName = null;
        int result = this.mTransportManager.registerAndSelectTransport(transportComponent);
        if (result == 0) goto L19;
    L17:
        if (transportName == null) goto L12;
        listener.onSuccess(transportName);     // Catch: RemoteException -> L10
    L16:
        return;
    L12:
        listener.onFailure(result);     // Catch: RemoteException -> L10
    L14:
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "ISelectBackupTransportCallback listener not available");
        return;
    L19:
        transportName = this.mTransportManager.getTransportName(transportComponent);     // Catch: TransportNotRegisteredException -> L6
        updateStateForTransport(transportName);     // Catch: TransportNotRegisteredException -> L6
    L7:
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Transport got unregistered");
        result = -1;
        goto L17
    }

    private void updateStateForTransport(String newTransportName) {
        Settings.Secure.putStringForUser(this.mContext.getContentResolver(), "backup_transport", newTransportName, this.mUserId);
        TransportConnection transportConnection = this.mTransportManager.getTransportClient(newTransportName, "BMS.updateStateForTransport()");
        if (transportConnection != null) goto L11;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Transport " + newTransportName + " not registered: current token = 0");
        this.mCurrentToken = 0;
        return;
    L11:
        BackupTransportClient transport = transportConnection.connectOrThrow("BMS.updateStateForTransport()");     // Catch: Exception -> L6
        this.mCurrentToken = transport.getCurrentRestoreSet();     // Catch: Exception -> L6
    L8:
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.updateStateForTransport()");
        return;
    L7:
        this.mCurrentToken = 0;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Transport " + newTransportName + " not available: current token = 0");
        goto L8
    }

    public Intent getConfigurationIntent(String transportName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "getConfigurationIntent");
        Intent intent = this.mTransportManager.getTransportConfigurationIntent(transportName);     // Catch: TransportNotRegisteredException -> L5
        return intent;
    L5:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to get configuration intent from transport: " + e.getMessage());
        return null;
    }

    public String getDestinationString(String transportName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "getDestinationString");
        String string = this.mTransportManager.getTransportCurrentDestinationString(transportName);     // Catch: TransportNotRegisteredException -> L5
        return string;
    L5:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to get destination string from transport: " + e.getMessage());
        return null;
    }

    public Intent getDataManagementIntent(String transportName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "getDataManagementIntent");
        Intent intent = this.mTransportManager.getTransportDataManagementIntent(transportName);     // Catch: TransportNotRegisteredException -> L5
        return intent;
    L5:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to get management intent from transport: " + e.getMessage());
        return null;
    }

    public CharSequence getDataManagementLabel(String transportName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "getDataManagementLabel");
        CharSequence label = this.mTransportManager.getTransportDataManagementLabel(transportName);     // Catch: TransportNotRegisteredException -> L5
        return label;
    L5:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to get management label from transport: " + e.getMessage());
        return null;
    }

    public void restoreAtInstall(String packageName, int token) {
        if (Binder.getCallingUid() == 1000) goto L6;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Non-system process uid=" + Binder.getCallingUid() + " attemping install-time restore");
        return;
    L6:
        boolean skip = false;
        long restoreSet = getAvailableRestoreToken(packageName);
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "restoreAtInstall pkg=" + packageName + " token=" + Integer.toHexString(token) + " restoreSet=" + Long.toHexString(restoreSet));
        if (restoreSet != 0) goto L9;
        skip = true;
    L9:
        BackupManagerMonitorEventSender mBMMEventSender = getBMMEventSender(null);
        getPackageInfoForBMMLogging(packageName);
        final TransportConnection transportConnection = this.mTransportManager.getCurrentTransportClient("BMS.restoreAtInstall()");
        if (transportConnection != null) goto L14;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "No transport client");
        skip = true;
    L14:
        if (this.mAutoRestore == true) goto L16;
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Non-restorable state: auto=" + this.mAutoRestore);
        boolean skip2 = true;
    L17:
        if (skip2 == false) goto L38;
    L22:
        if (skip2 == false) goto L35;
        if (transportConnection == null) goto L25;
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.restoreAtInstall()");
    L25:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Finishing install immediately");
        this.mPackageManagerBinder.finishPackageInstall(token, false);     // Catch: RemoteException -> L30
        return;
    L44:
        return;
    L42:
        return;
    L35:
        return;
    L38:
        this.mWakelock.acquire();     // Catch: Exception -> L20
        OnTaskFinishedListener listener = new UserBackupManagerService$$ExternalSyntheticLambda0(this, transportConnection);     // Catch: Exception -> L20
        Message msg = this.mBackupHandler.obtainMessage(3);     // Catch: Exception -> L20
        msg.obj = RestoreParams.createForRestoreAtInstall(transportConnection, null, mBMMEventSender.getMonitor(), restoreSet, packageName, token, listener, getEligibilityRulesForRestoreAtInstall(restoreSet));     // Catch: Exception -> L20
        this.mBackupHandler.sendMessage(msg);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Unable to contact transport: " + e.getMessage());
        skip2 = true;
        goto L22
    L16:
        skip2 = skip;
        goto L17
    }

    private /* synthetic */ void lambda$restoreAtInstall$10(TransportConnection transportConnection, String caller) {
        this.mTransportManager.disposeOfTransportClient(transportConnection, caller);
        this.mWakelock.release();
    }

    private PackageInfo getPackageInfoForBMMLogging(String packageName) {
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = packageName;
        return packageInfo;
    }

    public IRestoreSession beginRestoreSession(String packageName, String transport) {
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "beginRestoreSession: pkg=" + packageName + " transport=" + transport);
        boolean needPermission = true;
        if (transport != null) goto L14;
        transport = this.mTransportManager.getCurrentTransportName();
        if (packageName == null) goto L14;
        PackageInfo app = this.mPackageManager.getPackageInfoAsUser(packageName, 0, this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L11
        if (app.applicationInfo.uid != Binder.getCallingUid()) goto L14;
        needPermission = false;
    L12:
        Slog.w(BackupManagerService.TAG, this.mLogIdMsg + "Asked to restore nonexistent pkg " + packageName);
        throw new IllegalArgumentException("Package " + packageName + " not found");
    L14:
        if (needPermission == false) goto L16;
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "beginRestoreSession");
    L17:
        TransportConnection transportConnection = null;
        transportConnection = this.mTransportManager.getTransportClientOrThrow(transport, "BMS.beginRestoreSession");     // Catch: Throwable -> L40 Throwable -> L42
        int backupDestination = getBackupDestinationFromTransport(transportConnection);     // Catch: Throwable -> L40 Throwable -> L42
        if (transportConnection == null) goto L21;
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.beginRestoreSession");
    L21:
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L23:
        if (this.mActiveRestoreSession == null) goto L30;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Restore session requested but one already active");     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return null;
    L30:
        if (this.mBackupRunning == false) goto L34;
        Slog.i(BackupManagerService.TAG, this.mLogIdMsg + "Restore session requested but currently running backups");     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return null;
    L34:
        this.mActiveRestoreSession = new ActiveRestoreSession(this, packageName, transport, getEligibilityRulesForOperation(backupDestination));     // Catch: Throwable -> L27
        this.mBackupHandler.sendEmptyMessageDelayed(8, this.mAgentTimeoutParameters.getRestoreSessionTimeoutMillis());     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        return this.mActiveRestoreSession;
    L40:
        th = move-exception;
        if (transportConnection == null) goto L49;
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.beginRestoreSession");
    L49:
        throw th;
    L42:
        e = move-exception;
        Slog.w(BackupManagerService.TAG, "Failed to get operation type from transport: " + e);     // Catch: Throwable -> L40
        if (transportConnection == null) goto L46;
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.beginRestoreSession");
    L46:
        return null;
    L16:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "restoring self on current transport; no permission needed");
        goto L17
    }

    public void clearRestoreSession(ActiveRestoreSession currentSession) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (currentSession == this.mActiveRestoreSession) goto L8;
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "ending non-current restore session");     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L8:
        Slog.d(BackupManagerService.TAG, this.mLogIdMsg + "Clearing restore session and halting timeout");     // Catch: Throwable -> L6
        this.mActiveRestoreSession = null;     // Catch: Throwable -> L6
        this.mBackupHandler.removeMessages(8);     // Catch: Throwable -> L6
        goto L9
    }

    public void opComplete(int token, final long result) {
        this.mOperationStorage.onOperationComplete(token, result, new UserBackupManagerService$$ExternalSyntheticLambda12(this, result));
    }

    private /* synthetic */ void lambda$opComplete$11(long result, BackupRestoreTask callback) {
        Pair<BackupRestoreTask, Long> callbackAndResult = Pair.create(callback, Long.valueOf(result));
        Message msg = this.mBackupHandler.obtainMessage(21, callbackAndResult);
        this.mBackupHandler.sendMessage(msg);
    }

    public boolean isAppEligibleForBackup(String packageName) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "isAppEligibleForBackup");
        long oldToken = Binder.clearCallingIdentity();
        TransportConnection transportConnection = this.mTransportManager.getCurrentTransportClient("BMS.isAppEligibleForBackup");     // Catch: Throwable -> L7
        boolean eligible = this.mScheduledBackupEligibility.appIsRunningAndEligibleForBackupWithTransport(transportConnection, packageName);     // Catch: Throwable -> L7
        if (transportConnection == null) goto L9;
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.isAppEligibleForBackup");     // Catch: Throwable -> L7
    L9:
        Binder.restoreCallingIdentity(oldToken);
        return eligible;
    L7:
        th = move-exception;
        Binder.restoreCallingIdentity(oldToken);
        throw th;
    }

    public String[] filterAppsEligibleForBackup(String[] packages) {
        this.mContext.enforceCallingOrSelfPermission("android.permission.BACKUP", "filterAppsEligibleForBackup");
        long oldToken = Binder.clearCallingIdentity();
        TransportConnection transportConnection = this.mTransportManager.getCurrentTransportClient("BMS.filterAppsEligibleForBackup");     // Catch: Throwable -> L8
        List<String> eligibleApps = new ArrayList();     // Catch: Throwable -> L8
        int r5 = packages.length;     // Catch: Throwable -> L8
        int r7 = 0;
    L4:
        if (r7 >= r5) goto L11;
        String packageName = packages[r7];     // Catch: Throwable -> L8
        if (this.mScheduledBackupEligibility.appIsRunningAndEligibleForBackupWithTransport(transportConnection, packageName) == false) goto L10;
        eligibleApps.add(packageName);     // Catch: Throwable -> L8
    L10:
        r7 = r7 + 1;     // Catch: Throwable -> L8
        goto L4
    L11:
        if (transportConnection == null) goto L13;
        this.mTransportManager.disposeOfTransportClient(transportConnection, "BMS.filterAppsEligibleForBackup");     // Catch: Throwable -> L8
    L13:
        String[] r6 = (String[]) eligibleApps.toArray(new String[0]);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(oldToken);
        return r6;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(oldToken);
        throw th;
    }

    public BackupEligibilityRules getEligibilityRulesForOperation(int backupDestination) {
        return getEligibilityRules(this.mPackageManager, this.mUserId, this.mContext, backupDestination);
    }

    private static BackupEligibilityRules getEligibilityRules(PackageManager packageManager, int userId, Context context, int backupDestination) {
        return new BackupEligibilityRules(packageManager, (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class), userId, context, backupDestination);
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        long identityToken = Binder.clearCallingIdentity();
        if (args != null) goto L29;
    L24:
        dumpInternal(pw);     // Catch: Throwable -> L11
        dumpBMMEvents(pw);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identityToken);
        return;
    L29:
        int r2 = args.length;     // Catch: Throwable -> L11
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L24;
        String arg = args[r3];     // Catch: Throwable -> L11
        if ("agents".startsWith(arg) == true) goto L8;
        if ("transportclients".equals(arg.toLowerCase()) == true) goto L15;
        if ("transportstats".equals(arg.toLowerCase()) == true) goto L20;
        r3 = r3 + 1;
        goto L5
    L20:
        this.mTransportManager.dumpTransportStats(pw);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identityToken);
        return;
    L15:
        this.mTransportManager.dumpTransportClients(pw);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identityToken);
        return;
    L8:
        dumpAgents(pw);     // Catch: Throwable -> L11
        Binder.restoreCallingIdentity(identityToken);
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    }

    private void dumpAgents(PrintWriter pw) {
        List<PackageInfo> agentPackages = allAgentPackages();
        pw.println("Defined backup agents:");
        Iterator<PackageInfo> r1 = agentPackages.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        PackageInfo pkg = r1.next();
        pw.print("  ");
        pw.print(pkg.packageName);
        pw.println(':');
        pw.print("      ");
        pw.println(pkg.applicationInfo.backupAgentName);
        goto L4
    }

    private void dumpBMMEvents(PrintWriter pw) {
        BackupManagerMonitorDumpsysUtils bm = new BackupManagerMonitorDumpsysUtils();
        if (bm.deleteExpiredBMMEvents() == false) goto L6;
        pw.println("BACKUP MANAGER MONITOR EVENTS HAVE EXPIRED");
        return;
    L6:
        File events = bm.getBMMEventsFile();
        if (events.length() != 0) goto L11;
        pw.println("NO BACKUP MANAGER MONITOR EVENTS");
        return;
    L11:
        if (bm.isFileLargerThanSizeLimit(events) == false) goto L13;
        pw.println("BACKUP MANAGER MONITOR EVENTS FILE OVER SIZE LIMIT - future events will not be recorded");
    L13:
        pw.println("START OF BACKUP MANAGER MONITOR EVENTS");
        BufferedReader reader = new BufferedReader(new FileReader(events));     // Catch: IOException -> L24
    L37:
        String line = reader.readLine();     // Catch: Throwable -> L19
        if (line == null) goto L22;
        pw.println(line);     // Catch: Throwable -> L19
    L22:
        reader.close();     // Catch: IOException -> L24
    L32:
        pw.println("END OF BACKUP MANAGER MONITOR EVENTS");
        return;
    L19:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L28
    L30:
        throw th;     // Catch: IOException -> L24
    L28:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L24
    L24:
        e = move-exception;
        Slog.e(BackupManagerService.TAG, "IO Exception when reading BMM events from file: " + e);
        pw.println("IO Exception when reading BMM events from file");
        goto L32
    }

    @NeverCompile
    private void dumpInternal(PrintWriter pw) {
        if (this.mUserId != 0) goto L5;
        String r0 = "";
    L6:
        String userPrefix = r0;
        Object r4 = this.mQueueLock;
        monitor-enter(r4);
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L11
        r1.append(userPrefix);     // Catch: Throwable -> L11
        r1.append("Backup Manager is ");     // Catch: Throwable -> L11
        if (this.mEnabled == false) goto L13;
        String r5 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L14:
        r1.append(r5);     // Catch: Throwable -> L11
        r1.append(" / ");     // Catch: Throwable -> L11
        if (this.mSetupComplete == true) goto L17;
        String r6 = "not ";
    L18:
        r1.append(r6);     // Catch: Throwable -> L11
        r1.append("setup complete / ");     // Catch: Throwable -> L11
        if (this.mPendingInits.size() != 0) goto L21;
        String r7 = "not ";
    L22:
        r1.append(r7);     // Catch: Throwable -> L11
        r1.append("pending init");     // Catch: Throwable -> L11
        pw.println(r1.toString());     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L11
        r2.append("Auto-restore is ");     // Catch: Throwable -> L11
        if (this.mAutoRestore == false) goto L25;
        String r8 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L26:
        r2.append(r8);     // Catch: Throwable -> L11
        pw.println(r2.toString());     // Catch: Throwable -> L11
        if (this.mBackupRunning == false) goto L30;
        pw.println("Backup currently running");     // Catch: Throwable -> L11
    L30:
        if (isBackupOperationInProgress() == false) goto L32;
        String r3 = "Backup in progress";
    L33:
        pw.println(r3);     // Catch: Throwable -> L11
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L11
        r9.append("Framework scheduling is ");     // Catch: Throwable -> L11
        if (isFrameworkSchedulingEnabled() == false) goto L36;
        String r10 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L37:
        r9.append(r10);     // Catch: Throwable -> L11
        pw.println(r9.toString());     // Catch: Throwable -> L11
        pw.println("Last backup pass started: " + this.mLastBackupPass + " (now = " + System.currentTimeMillis() + ')');     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L11
        r11.append("  next scheduled: ");     // Catch: Throwable -> L11
        r11.append(KeyValueBackupJob.nextScheduled(this.mUserId));     // Catch: Throwable -> L11
        pw.println(r11.toString());     // Catch: Throwable -> L11
        pw.println(userPrefix + "Transport whitelist:");     // Catch: Throwable -> L11
        Iterator<ComponentName> r12 = this.mTransportManager.getTransportWhitelist().iterator();     // Catch: Throwable -> L11
    L39:
        if (r12.hasNext() == false) goto L41;
        ComponentName transport = r12.next();     // Catch: Throwable -> L11
        pw.print("    ");     // Catch: Throwable -> L11
        pw.println(transport.flattenToShortString());     // Catch: Throwable -> L11
        goto L39
    L41:
        pw.println(userPrefix + "Available transports:");     // Catch: Throwable -> L11
        String[] transports = listAllTransports();     // Catch: Throwable -> L11
        if (transports == null) goto L64;
        int r13 = transports.length;     // Catch: Throwable -> L11
        int r14 = 0;
    L44:
        if (r14 >= r13) goto L64;
        String t = transports[r14];     // Catch: Throwable -> L11
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L11
        if (t.equals(this.mTransportManager.getCurrentTransportName()) == false) goto L48;
        String r16 = "  * ";
    L49:
        r15.append(r16);     // Catch: Throwable -> L11
        r15.append(t);     // Catch: Throwable -> L11
        pw.println(r15.toString());     // Catch: Throwable -> L11
        File dir = new File(this.mBaseStateDir, this.mTransportManager.getTransportDirName(t));     // Catch: Throwable -> L11 Exception -> L58
        pw.println("       destination: " + this.mTransportManager.getTransportCurrentDestinationString(t));     // Catch: Throwable -> L11 Exception -> L58
        pw.println("       intent: " + this.mTransportManager.getTransportConfigurationIntent(t));     // Catch: Throwable -> L11 Exception -> L58
        File[] r17 = dir.listFiles();     // Catch: Throwable -> L11 Exception -> L58
        int r18 = r17.length;     // Catch: Throwable -> L11 Exception -> L58
        int r19 = 0;
    L51:
        if (r19 >= r18) goto L60;
        File f = r17[r19];     // Catch: Throwable -> L11 Exception -> L58
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L11 Exception -> L58
        r110.append("       ");     // Catch: Throwable -> L11 Exception -> L58
        r110.append(f.getName());     // Catch: Throwable -> L11 Exception -> L58
        r110.append(" - ");     // Catch: Throwable -> L11 Exception -> L58
        int r111 = r14;
        r110.append(f.length());     // Catch: Throwable -> L11 Exception -> L56
        r110.append(" state bytes");     // Catch: Throwable -> L11 Exception -> L56
        pw.println(r110.toString());     // Catch: Throwable -> L11 Exception -> L56
        r19 = r19 + 1;
        r14 = r111;
    L56:
        e = e;
    L62:
        Slog.e(BackupManagerService.TAG, this.mLogIdMsg + "Error in transport", e);     // Catch: Throwable -> L11
        pw.println("        Error: " + e);     // Catch: Throwable -> L11
    L63:
        r14 = r111 + 1;     // Catch: Throwable -> L11
        goto L44
    L60:
        r111 = r14;
    L58:
        e = e;
        r111 = r14;
        goto L62
    L48:
        r16 = "    ";
    L64:
        this.mTransportManager.dumpTransportClients(pw);     // Catch: Throwable -> L11
        pw.println(userPrefix + "Pending init: " + this.mPendingInits.size());     // Catch: Throwable -> L11
        Iterator<String> r20 = this.mPendingInits.iterator();     // Catch: Throwable -> L11
    L66:
        if (r20.hasNext() == false) goto L68;
        String s = r20.next();     // Catch: Throwable -> L11
        pw.println("    " + s);     // Catch: Throwable -> L11
        goto L66
    L68:
        pw.print(userPrefix + "Ancestral: ");     // Catch: Throwable -> L11
        pw.println(Long.toHexString(this.mAncestralToken));     // Catch: Throwable -> L11
        pw.print(userPrefix + "Current:   ");     // Catch: Throwable -> L11
        pw.println(Long.toHexString(this.mCurrentToken));     // Catch: Throwable -> L11
        int numPackages = this.mBackupParticipants.size();     // Catch: Throwable -> L11
        pw.println(userPrefix + "Participants:");     // Catch: Throwable -> L11
        int i = 0;
    L69:
        if (i >= numPackages) goto L75;
        int uid = this.mBackupParticipants.keyAt(i);     // Catch: Throwable -> L11
        pw.print("  uid: ");     // Catch: Throwable -> L11
        pw.println(uid);     // Catch: Throwable -> L11
        HashSet<String> participants = this.mBackupParticipants.valueAt(i);     // Catch: Throwable -> L11
        Iterator<String> r21 = participants.iterator();     // Catch: Throwable -> L11
    L72:
        if (r21.hasNext() == false) goto L74;
        String app = r21.next();     // Catch: Throwable -> L11
        pw.println("    " + app);     // Catch: Throwable -> L11
        goto L72
    L74:
        i = i + 1;     // Catch: Throwable -> L11
        goto L69
    L75:
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L11
        r22.append(userPrefix);     // Catch: Throwable -> L11
        r22.append("Ancestral packages: ");     // Catch: Throwable -> L11
        if (this.mAncestralPackages != null) goto L78;
        Object r23 = "none";
    L79:
        r22.append(r23);     // Catch: Throwable -> L11
        pw.println(r22.toString());     // Catch: Throwable -> L11
        if (this.mAncestralPackages == null) goto L85;
        Iterator<String> r24 = this.mAncestralPackages.iterator();     // Catch: Throwable -> L11
    L83:
        if (r24.hasNext() == false) goto L85;
        String pkg = r24.next();     // Catch: Throwable -> L11
        pw.println("    " + pkg);     // Catch: Throwable -> L11
    L85:
        Set<String> processedPackages = this.mProcessedPackagesJournal.getPackagesCopy();     // Catch: Throwable -> L11
        pw.println(userPrefix + "Ever backed up: " + processedPackages.size());     // Catch: Throwable -> L11
        Iterator<String> r25 = processedPackages.iterator();     // Catch: Throwable -> L11
    L87:
        if (r25.hasNext() == false) goto L89;
        String pkg2 = r25.next();     // Catch: Throwable -> L11
        pw.println("    " + pkg2);     // Catch: Throwable -> L11
        goto L87
    L89:
        pw.println(userPrefix + "Pending key/value backup: " + this.mPendingBackups.size());     // Catch: Throwable -> L11
        Iterator<BackupRequest> r26 = this.mPendingBackups.values().iterator();     // Catch: Throwable -> L11
    L91:
        if (r26.hasNext() == false) goto L93;
        BackupRequest req = r26.next();     // Catch: Throwable -> L11
        pw.println("    " + req);     // Catch: Throwable -> L11
        goto L91
    L93:
        pw.println(userPrefix + "Full backup queue:" + this.mFullBackupQueue.size());     // Catch: Throwable -> L11
        Iterator<FullBackupEntry> r27 = this.mFullBackupQueue.iterator();     // Catch: Throwable -> L11
    L95:
        if (r27.hasNext() == false) goto L97;
        FullBackupEntry entry = r27.next();     // Catch: Throwable -> L11
        pw.print("    ");     // Catch: Throwable -> L11
        pw.print(entry.lastBackup);     // Catch: Throwable -> L11
        pw.print(" : ");     // Catch: Throwable -> L11
        pw.println(entry.packageName);     // Catch: Throwable -> L11
        goto L95
    L97:
        pw.println(userPrefix + "Agent timeouts:");     // Catch: Throwable -> L11
        pw.println("    KvBackupAgentTimeoutMillis: " + this.mAgentTimeoutParameters.getKvBackupAgentTimeoutMillis());     // Catch: Throwable -> L11
        pw.println("    FullBackupAgentTimeoutMillis: " + this.mAgentTimeoutParameters.getFullBackupAgentTimeoutMillis());     // Catch: Throwable -> L11
        pw.println("    SharedBackupAgentTimeoutMillis: " + this.mAgentTimeoutParameters.getSharedBackupAgentTimeoutMillis());     // Catch: Throwable -> L11
        pw.println("    RestoreAgentTimeoutMillis (system): " + this.mAgentTimeoutParameters.getRestoreAgentTimeoutMillis(9999));     // Catch: Throwable -> L11
        pw.println("    RestoreAgentTimeoutMillis: " + this.mAgentTimeoutParameters.getRestoreAgentTimeoutMillis(10000));     // Catch: Throwable -> L11
        pw.println("    RestoreAgentFinishedTimeoutMillis: " + this.mAgentTimeoutParameters.getRestoreAgentFinishedTimeoutMillis());     // Catch: Throwable -> L11
        pw.println("    QuotaExceededTimeoutMillis: " + this.mAgentTimeoutParameters.getQuotaExceededTimeoutMillis());     // Catch: Throwable -> L11
        monitor-exit(r4);     // Catch: Throwable -> L11
        return;
    L78:
        r23 = Integer.valueOf(this.mAncestralPackages.size());     // Catch: Throwable -> L11
        goto L79
    L36:
        r10 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L37
    L32:
        r3 = "No backups running";
        goto L33
    L25:
        r8 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L26
    L21:
        r7 = "";
        goto L22
    L17:
        r6 = "";
        goto L18
    L13:
        r5 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L11:
        th = move-exception;
        throw th;
    L5:
        r0 = "User " + this.mUserId + ":";
        goto L6
    }

    int getBackupDestinationFromTransport(TransportConnection transportConnection) throws TransportNotAvailableException, RemoteException {
        if (shouldUseNewBackupEligibilityRules() == true) goto L5;
        return 0;
    L5:
        long oldCallingId = Binder.clearCallingIdentity();
        BackupTransportClient transport = transportConnection.connectOrThrow("BMS.getBackupDestinationFromTransport");     // Catch: Throwable -> L13
        if ((transport.getTransportFlags() & 2) == 0) goto L11;
        Binder.restoreCallingIdentity(oldCallingId);
        return 1;
    L11:
        Binder.restoreCallingIdentity(oldCallingId);
        return 0;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(oldCallingId);
        throw th;
    }

    boolean shouldUseNewBackupEligibilityRules() {
        return FeatureFlagUtils.isEnabled(this.mContext, "settings_use_new_backup_eligibility_rules");
    }

    public IBackupManager getBackupManagerBinder() {
        return this.mBackupManagerBinder;
    }

    public BackupAgentConnectionManager getBackupAgentConnectionManager() {
        return this.mBackupAgentConnectionManager;
    }
}
