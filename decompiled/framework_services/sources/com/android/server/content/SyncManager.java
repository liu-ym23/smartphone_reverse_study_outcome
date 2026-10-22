package com.android.server.content;

import android.R;
import android.accounts.Account;
import android.accounts.AccountAndUser;
import android.accounts.AccountManager;
import android.accounts.AccountManagerInternal;
import android.app.ActivityManagerInternal;
import android.app.AppGlobals;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManagerInternal;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ISyncAdapter;
import android.content.ISyncContext;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PeriodicSync;
import android.content.ServiceConnection;
import android.content.SyncActivityTooManyDeletes;
import android.content.SyncAdapterType;
import android.content.SyncAdaptersCache;
import android.content.SyncInfo;
import android.content.SyncResult;
import android.content.SyncStatusInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ProviderInfo;
import android.content.pm.RegisteredServicesCache;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.pm.UserProperties;
import android.database.ContentObserver;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.WorkSource;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.TimeMigrationUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.app.IBatteryStats;
import com.android.internal.config.appcloning.AppCloningDeviceConfigHelper;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.function.QuadConsumer;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;
import com.android.server.accounts.AccountManagerService;
import com.android.server.backup.AccountSyncSettingsBackupHelper;
import com.android.server.job.JobSchedulerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import com.google.android.collect.Lists;
import com.google.android.collect.Maps;
import dalvik.annotation.optimization.NeverCompile;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class SyncManager {
    private static final boolean DEBUG_ACCOUNT_ACCESS = false;
    private static final int DELAY_RETRY_SYNC_IN_PROGRESS_IN_SECONDS = 10;
    private static final boolean ENABLE_SUSPICIOUS_CHECK = false;
    private static final String HANDLE_SYNC_ALARM_WAKE_LOCK = "SyncManagerHandleSyncAlarm";
    private static final AccountAndUser[] INITIAL_ACCOUNTS_ARRAY = null;
    private static final long LOCAL_SYNC_DELAY = 0;
    private static final Context.BindServiceFlags SYNC_ADAPTER_CONNECTION_FLAGS = null;
    private static final long SYNC_DELAY_ON_CONFLICT = 10000;
    private static final String SYNC_LOOP_WAKE_LOCK = "SyncLoopWakeLock";
    private static final int SYNC_MONITOR_PROGRESS_THRESHOLD_BYTES = 10;
    private static final long SYNC_MONITOR_WINDOW_LENGTH_MILLIS = 60000;
    private static final int SYNC_OP_STATE_INVALID_NOT_SYNCABLE = 4;
    private static final int SYNC_OP_STATE_INVALID_NO_ACCOUNT = 3;
    private static final int SYNC_OP_STATE_INVALID_NO_ACCOUNT_ACCESS = 2;
    private static final int SYNC_OP_STATE_INVALID_SYNC_DISABLED = 5;
    private static final int SYNC_OP_STATE_VALID = 0;
    private static final String SYNC_WAKE_LOCK_PREFIX = "*sync*/";
    static final String TAG = "SyncManager";
    private static final boolean USE_WTF_FOR_ACCOUNT_ERROR = true;
    private static SyncManager sInstance;
    private static final Comparator<SyncOperation> sOpDumpComparator = null;
    private static final Comparator<SyncOperation> sOpRuntimeComparator = null;
    private final AccountManager mAccountManager;
    private final AccountManagerInternal mAccountManagerInternal;
    private final Object mAccountsLock;
    private final BroadcastReceiver mAccountsUpdatedReceiver;
    protected final ArrayList<ActiveSyncContext> mActiveSyncContexts;
    private final ActivityManagerInternal mAmi;
    private final AppCloningDeviceConfigHelper mAppCloningDeviceConfigHelper;
    private final IBatteryStats mBatteryStats;
    private ConnectivityManager mConnManagerDoNotUseDirectly;
    private BroadcastReceiver mConnectivityIntentReceiver;
    private final SyncManagerConstants mConstants;
    private Context mContext;
    private volatile boolean mDataConnectionIsConnected;
    private JobScheduler mJobScheduler;
    private final SyncLogger mLogger;
    private volatile int mNextJobId;
    private final NotificationManager mNotificationMgr;
    private final BroadcastReceiver mOtherIntentsReceiver;
    private final PackageManagerInternal mPackageManagerInternal;
    private final PackageMonitorImpl mPackageMonitor;
    private final PowerManager mPowerManager;
    private volatile boolean mProvisioned;
    private volatile AccountAndUser[] mRunningAccounts;
    private BroadcastReceiver mShutdownIntentReceiver;
    protected final SyncAdaptersCache mSyncAdapters;
    private final SyncHandler mSyncHandler;
    private volatile PowerManager.WakeLock mSyncManagerWakeLock;
    private SyncStorageEngine mSyncStorageEngine;
    private final HandlerThread mThread;
    private final SparseBooleanArray mUnlockedUsers;
    private BroadcastReceiver mUserIntentReceiver;
    private final UserManager mUserManager;

    private static class AccountSyncStats {
        long elapsedTime;
        String name;
        int times;

        /* synthetic */ AccountSyncStats(String r1, SyncManagerIA r2) {
            this(r1);
        }

        private AccountSyncStats(String name) {
            this.name = name;
        }
    }

    class ActiveSyncContext extends ISyncContext.Stub implements ServiceConnection, IBinder.DeathRecipient {
        boolean mBound;
        long mBytesTransferredAtLastPoll;
        String mEventName;
        final long mHistoryRowId;
        boolean mIsLinkedToDeath;
        long mLastPolledTimeElapsed;
        final long mStartTime;
        ISyncAdapter mSyncAdapter;
        final int mSyncAdapterUid;
        SyncInfo mSyncInfo;
        final SyncOperation mSyncOperation;
        final PowerManager.WakeLock mSyncWakeLock;
        long mTimeoutStartTime;
        final /* synthetic */ SyncManager this$0;

        public ActiveSyncContext(SyncManager this$0, SyncOperation syncOperation, long historyRowId, int syncAdapterUid) {
            this.this$0 = this$0;
            this.mIsLinkedToDeath = false;
            this.mSyncAdapterUid = syncAdapterUid;
            this.mSyncOperation = syncOperation;
            this.mHistoryRowId = historyRowId;
            this.mSyncAdapter = null;
            this.mStartTime = SystemClock.elapsedRealtime();
            this.mTimeoutStartTime = this.mStartTime;
            this.mSyncWakeLock = SyncHandler.m3199$$Nest$mgetSyncWakeLock(SyncManager.m3160$$Nest$fgetmSyncHandler(this$0), this.mSyncOperation);
            this.mSyncWakeLock.setWorkSource(new WorkSource(syncAdapterUid));
            this.mSyncWakeLock.acquire();
        }

        public void sendHeartbeat() {
        }

        public void onFinished(SyncResult result) {
            if (Log.isLoggable("SyncManager", 2) == false) goto L5;
            Slog.v("SyncManager", "onFinished: " + this);
        L5:
            SyncLogger r0 = SyncManager.m3155$$Nest$fgetmLogger(this.this$0);
            if (this.mSyncOperation != null) goto L8;
            Object r1 = "null";
        L9:
            r0.log(new Object[]{"onFinished result=", result, " endpoint=", r1});
            SyncManager.m3190$$Nest$msendSyncFinishedOrCanceledMessage(this.this$0, this, result);
            return;
        L8:
            r1 = this.mSyncOperation.target;
            goto L9
        }

        public void toString(StringBuilder r3, boolean r4) {
            r3.append("startTime ");
            r3.append(this.mStartTime);
            r3.append(", mTimeoutStartTime ");
            r3.append(this.mTimeoutStartTime);
            r3.append(", mHistoryRowId ");
            r3.append(this.mHistoryRowId);
            r3.append(", syncOperation ");
            SyncOperation r0 = this.mSyncOperation;
            Object r1 = r0;
            if (r4 == false) goto L5;
            r1 = SyncLogger.logSafe(r0);
        L5:
            r3.append(r1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Message msg = SyncManager.m3160$$Nest$fgetmSyncHandler(this.this$0).obtainMessage();
            msg.what = 4;
            msg.obj = new ServiceConnectionData(this.this$0, this, service);
            SyncManager.m3160$$Nest$fgetmSyncHandler(this.this$0).sendMessage(msg);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Message msg = SyncManager.m3160$$Nest$fgetmSyncHandler(this.this$0).obtainMessage();
            msg.what = 5;
            msg.obj = new ServiceConnectionData(this.this$0, this, null);
            SyncManager.m3160$$Nest$fgetmSyncHandler(this.this$0).sendMessage(msg);
        }

        boolean bindToSyncAdapter(ComponentName serviceComponent, int userId) {
            if (Log.isLoggable("SyncManager", 2) == false) goto L5;
            Log.d("SyncManager", "bindToSyncAdapter: " + serviceComponent + ", connection " + this);
        L5:
            Intent intent = SyncManager.getAdapterBindIntent(SyncManager.m3153$$Nest$fgetmContext(this.this$0), serviceComponent, userId);
            this.mBound = true;
            boolean bindResult = SyncManager.m3153$$Nest$fgetmContext(this.this$0).bindServiceAsUser(intent, this, SyncManager.m3196$$Nest$sfgetSYNC_ADAPTER_CONNECTION_FLAGS(), new UserHandle(this.mSyncOperation.target.userId));
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"bindService() returned=", Boolean.valueOf(this.mBound), " for ", this});
            if (bindResult == true) goto L12;
            this.mBound = false;
        L11:
            return bindResult;
        L12:
            this.mEventName = this.mSyncOperation.wakeLockName();     // Catch: RemoteException -> L10
            SyncManager.m3151$$Nest$fgetmBatteryStats(this.this$0).noteSyncStart(this.mEventName, this.mSyncAdapterUid);     // Catch: RemoteException -> L10
            goto L11
        }

        protected void close() {
            if (Log.isLoggable("SyncManager", 2) == false) goto L6;
            Log.d("SyncManager", "unBindFromSyncAdapter: connection " + this);
        L6:
            if (this.mBound == false) goto L15;
            this.mBound = false;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"unbindService for ", this});     // Catch: NoSuchElementException -> L10
            SyncManager.m3153$$Nest$fgetmContext(this.this$0).unbindService(this);     // Catch: NoSuchElementException -> L10
        L17:
            SyncManager.m3151$$Nest$fgetmBatteryStats(this.this$0).noteSyncFinish(this.mEventName, this.mSyncAdapterUid);     // Catch: RemoteException -> L14
        L10:
            e = move-exception;
            Slog.wtf("SyncManager", "Failed to unlink active sync adapter on close()", e);
        L15:
            this.mSyncWakeLock.release();
            this.mSyncWakeLock.setWorkSource(null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            toString(sb, false);
            return sb.toString();
        }

        public String toSafeString() {
            StringBuilder sb = new StringBuilder();
            toString(sb, true);
            return sb.toString();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            SyncManager.m3190$$Nest$msendSyncFinishedOrCanceledMessage(this.this$0, this, null);
        }
    }

    private static class AuthoritySyncStats {
        Map<String, AccountSyncStats> accountMap;
        long elapsedTime;
        String name;
        int times;

        /* synthetic */ AuthoritySyncStats(String r1, SyncManagerIA r2) {
            this(r1);
        }

        private AuthoritySyncStats(String name) {
            this.accountMap = Maps.newHashMap();
            this.name = name;
        }
    }

    interface OnReadyCallback {
        void onReady();
    }

    private static class OnUnsyncableAccountCheck implements ServiceConnection {
        static final long SERVICE_BOUND_TIME_MILLIS = 5000;
        private final OnReadyCallback mOnReadyCallback;
        private final RegisteredServicesCache.ServiceInfo<SyncAdapterType> mSyncAdapterInfo;

        /* JADX INFO: renamed from: -$$Nest$monReady, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3197$$Nest$monReady(OnUnsyncableAccountCheck r0) {
            r0.onReady();
        }

        OnUnsyncableAccountCheck(RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo, OnReadyCallback onReadyCallback) {
            this.mSyncAdapterInfo = syncAdapterInfo;
            this.mOnReadyCallback = onReadyCallback;
        }

        private void onReady() {
            long identity = Binder.clearCallingIdentity();
            this.mOnReadyCallback.onReady();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(identity);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            ISyncAdapter adapter = ISyncAdapter.Stub.asInterface(service);
            adapter.onUnsyncableAccount(new AnonymousClass1(this));     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Slog.e("SyncManager", "Could not call onUnsyncableAccountDone " + this.mSyncAdapterInfo, e);
            onReady();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    private static class PackageMonitorImpl extends PackageMonitor {
        /* synthetic */ PackageMonitorImpl(SyncManagerIA r1) {
            this();
        }

        private PackageMonitorImpl() {
        }

        public boolean onHandleForceStop(Intent intent, String[] packageNames, int uid, boolean doit, Bundle extras) {
            boolean isLoggable = Log.isLoggable("SyncManager", 3);
            if (isLoggable == false) goto L7;
            Log.d("SyncManager", "Package force-stopped: " + Arrays.toString(packageNames) + ", uid: " + uid);
            return false;
        L7:
            return false;
        }

        public void onPackageUnstopped(String packageName, int uid, Bundle extras) {
            boolean isLoggable = Log.isLoggable("SyncManager", 3);
            if (isLoggable == false) goto L6;
            Log.d("SyncManager", "Package unstopped: " + packageName + ", uid: " + uid);
            return;
        }
    }

    static class PrintTable {
        private final int mCols;
        private ArrayList<String[]> mTable;

        PrintTable(int cols) {
            this.mTable = Lists.newArrayList();
            this.mCols = cols;
        }

        void set(int row, int col, Object... values) {
            if ((values.length + col) > this.mCols) goto L23;
            int i = this.mTable.size();
        L6:
            if (i > row) goto L12;
            String[] list = new String[this.mCols];
            this.mTable.add(list);
            int j = 0;
        L9:
            if (j >= this.mCols) goto L11;
            list[j] = "";
            j = j + 1;
            goto L9
        L11:
            i = i + 1;
            goto L6
        L12:
            String[] rowArray = this.mTable.get(row);
            int i2 = 0;
        L14:
            if (i2 >= values.length) goto L21;
            Object value = values[i2];
            int r4 = col + i2;
            if (value != null) goto L18;
            String r5 = "";
        L19:
            rowArray[r4] = r5;
            i2 = i2 + 1;
            goto L14
        L18:
            r5 = value.toString();
            goto L19
        L21:
            return;
        L23:
            throw new IndexOutOfBoundsException("Table only has " + this.mCols + " columns. can't set " + values.length + " at column " + col);
        }

        void writeTo(PrintWriter out) {
            String[] formats = new String[this.mCols];
            int totalLength = 0;
            int col = 0;
        L4:
            if (col >= this.mCols) goto L13;
            int maxLength = 0;
            Iterator<String[]> r4 = this.mTable.iterator();
        L7:
            if (r4.hasNext() == false) goto L12;
            Object[] row = r4.next();
            int length = row[col].toString().length();
            if (length <= maxLength) goto L7;
            maxLength = length;
            goto L7
        L12:
            totalLength = totalLength + maxLength;
            formats[col] = String.format("%%-%ds", new Object[]{Integer.valueOf(maxLength)});
            col = col + 1;
            goto L4
        L13:
            int col2 = this.mCols;
            formats[col2 - 1] = "%s";
            printRow(out, formats, this.mTable.get(0));
            int totalLength2 = totalLength + ((this.mCols - 1) * 2);
            int i = 0;
        L14:
            if (i >= totalLength2) goto L16;
            out.print("-");
            i = i + 1;
            goto L14
        L16:
            out.println();
            int i2 = 1;
            int mTableSize = this.mTable.size();
        L17:
            if (i2 >= mTableSize) goto L20;
            Object[] row2 = this.mTable.get(i2);
            printRow(out, formats, row2);
            i2 = i2 + 1;
            goto L17
        }

        private void printRow(PrintWriter out, String[] formats, Object[] row) {
            int j = 0;
            int rowLength = row.length;
        L3:
            if (j >= rowLength) goto L5;
            out.printf(String.format(formats[j], new Object[]{row[j].toString()}), new Object[0]);
            out.print("  ");
            j = j + 1;
            goto L3
        L5:
            out.println();
        }

        public int getNumRows() {
            return this.mTable.size();
        }
    }

    private static class ScheduleSyncMessagePayload {
        final long minDelayMillis;
        final SyncOperation syncOperation;

        ScheduleSyncMessagePayload(SyncOperation syncOperation, long minDelayMillis) {
            this.syncOperation = syncOperation;
            this.minDelayMillis = minDelayMillis;
        }
    }

    class ServiceConnectionData {
        public final ActiveSyncContext activeSyncContext;
        public final IBinder adapter;

        ServiceConnectionData(SyncManager this$0, ActiveSyncContext activeSyncContext, IBinder adapter) {
            this.activeSyncContext = activeSyncContext;
            this.adapter = adapter;
        }
    }

    private class SyncFinishedOrCancelledMessagePayload {
        public final ActiveSyncContext activeSyncContext;
        public final SyncResult syncResult;

        SyncFinishedOrCancelledMessagePayload(SyncManager r1, ActiveSyncContext syncContext, SyncResult syncResult) {
            this.activeSyncContext = syncContext;
            this.syncResult = syncResult;
        }
    }

    class SyncHandler extends Handler {
        private static final int MESSAGE_ACCOUNTS_UPDATED = 9;
        private static final int MESSAGE_CANCEL = 6;
        private static final int MESSAGE_MONITOR_SYNC = 8;
        static final int MESSAGE_REMOVE_PERIODIC_SYNC = 14;
        static final int MESSAGE_SCHEDULE_SYNC = 12;
        private static final int MESSAGE_SERVICE_CONNECTED = 4;
        private static final int MESSAGE_SERVICE_DISCONNECTED = 5;
        static final int MESSAGE_START_SYNC = 10;
        static final int MESSAGE_STOP_SYNC = 11;
        private static final int MESSAGE_SYNC_FINISHED = 1;
        static final int MESSAGE_UPDATE_PERIODIC_SYNC = 13;
        public final SyncTimeTracker mSyncTimeTracker;
        private final HashMap<String, PowerManager.WakeLock> mWakeLocks;
        final /* synthetic */ SyncManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$FX1PgS20u8M0AvhSWb-tyxkLVwo, reason: not valid java name */
        public static /* synthetic */ void m3198$r8$lambda$FX1PgS20u8M0AvhSWbtyxkLVwo(SyncHandler r0, SyncStorageEngine.EndPoint r1, long r2, long r4, Bundle r6, Bundle r7) {
            r0.lambda$updateOrAddPeriodicSyncH$0(r1, r2, r4, r6, r7);
        }

        /* JADX INFO: renamed from: -$$Nest$mgetSyncWakeLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ PowerManager.WakeLock m3199$$Nest$mgetSyncWakeLock(SyncHandler r0, SyncOperation r1) {
            return r0.getSyncWakeLock(r1);
        }

        public SyncHandler(SyncManager this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
            this.mSyncTimeTracker = new SyncTimeTracker(this.this$0, null);
            this.mWakeLocks = Maps.newHashMap();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SyncManager.m3161$$Nest$fgetmSyncManagerWakeLock(this.this$0).acquire();
            handleSyncMessage(msg);     // Catch: Throwable -> L6
            SyncManager.m3161$$Nest$fgetmSyncManagerWakeLock(this.this$0).release();
            return;
        L6:
            th = move-exception;
            SyncManager.m3161$$Nest$fgetmSyncManagerWakeLock(this.this$0).release();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [int] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v7, types: [com.android.server.content.SyncManager$SyncHandler] */
        private void handleSyncMessage(Message r11) {
            boolean r2 = Log.isLoggable("SyncManager", 2);
            SyncManager.m3163$$Nest$fputmDataConnectionIsConnected(this.this$0, SyncManager.m3185$$Nest$mreadDataConnectionState(this.this$0));     // Catch: Throwable -> L7
            ?? r3 = r11.what;     // Catch: Throwable -> L7
            boolean r5 = false;
            switch(r3) {
                case 1: goto L71;
                case 2: goto L5;
                case 3: goto L5;
                case 4: goto L65;
                case 5: goto L50;
                case 6: goto L46;
                case 7: goto L5;
                case 8: goto L39;
                case 9: goto L35;
                case 10: goto L34;
                case 11: goto L15;
                case 12: goto L14;
                case 13: goto L9;
                case 14: goto L6;
                default: goto L5;
            };     // Catch: Throwable -> L7
        L5:
            SyncHandler r4 = this;
        L78:
            r4.mSyncTimeTracker.update();
            return;
        L6:
            Pair r0 = (Pair) r11.obj;     // Catch: Throwable -> L7
            removePeriodicSyncH((SyncStorageEngine.EndPoint) r0.first, r11.getData(), (String) r0.second);     // Catch: Throwable -> L7
            r4 = this;
            goto L78
        L9:
            UpdatePeriodicSyncMessagePayload r1 = (UpdatePeriodicSyncMessagePayload) r11.obj;     // Catch: Throwable -> L7
            SyncHandler r6 = this;
            r6.updateOrAddPeriodicSyncH(r1.target, r1.pollFrequency, r1.flex, r1.extras);     // Catch: Throwable -> L12
            r4 = r6;
            goto L78
        L14:
            SyncHandler r7 = this;
            ScheduleSyncMessagePayload r8 = (ScheduleSyncMessagePayload) r11.obj;     // Catch: Throwable -> L12
            SyncManager.m3189$$Nest$mscheduleSyncOperationH(r7.this$0, r8.syncOperation, r8.minDelayMillis);     // Catch: Throwable -> L12
            r4 = r7;
            goto L78
        L15:
            SyncHandler r9 = this;
            SyncOperation r10 = (SyncOperation) r11.obj;     // Catch: Throwable -> L12
            if (r2 == false) goto L18;
            Slog.v("SyncManager", "Stop sync received.");     // Catch: Throwable -> L12
        L18:
            ActiveSyncContext r12 = findActiveSyncContextH(r10.jobId);     // Catch: Throwable -> L12
            r4 = r9;
            if (r12 == null) goto L78;
            runSyncFinishedOrCanceledH(null, r12);     // Catch: Throwable -> L12
            if (r11.arg1 == 0) goto L23;
            boolean r13 = true;
        L25:
            if (r11.arg2 == 0) goto L27;
            r5 = true;
        L27:
            if (r2 == false) goto L29;
            Slog.v("SyncManager", "Stopping sync. Reschedule: " + r13 + "Backoff: " + r5);     // Catch: Throwable -> L12
        L29:
            if (r5 == false) goto L31;
            SyncManager.m3174$$Nest$mincreaseBackoffSetting(r9.this$0, r10.target);     // Catch: Throwable -> L12
        L31:
            if (r13 == false) goto L33;
            deferStoppedSyncH(r10, 0);     // Catch: Throwable -> L12
        L33:
            r4 = r9;
            goto L78
        L23:
            r13 = false;
            goto L25
        L34:
            r4 = this;
            startSyncH((SyncOperation) r11.obj);     // Catch: Throwable -> L12
            goto L78
        L35:
            r4 = this;
            if (Log.isLoggable("SyncManager", 2) == false) goto L38;
            Slog.v("SyncManager", "handleSyncHandlerMessage: MESSAGE_ACCOUNTS_UPDATED");     // Catch: Throwable -> L12
        L38:
            updateRunningAccountsH((SyncStorageEngine.EndPoint) r11.obj);     // Catch: Throwable -> L12
            goto L78
        L39:
            SyncHandler r14 = this;
            ActiveSyncContext r15 = (ActiveSyncContext) r11.obj;     // Catch: Throwable -> L12
            if (r2 == false) goto L43;
            Log.d("SyncManager", "handleSyncHandlerMessage: MESSAGE_MONITOR_SYNC: " + r15.mSyncOperation.target);     // Catch: Throwable -> L12
        L43:
            if (isSyncNotUsingNetworkH(r15) == false) goto L45;
            Log.w("SyncManager", String.format("Detected sync making no progress for %s. cancelling.", new Object[]{SyncLogger.logSafe(r15)}));     // Catch: Throwable -> L12
            SyncJobService.callJobFinished(r15.mSyncOperation.jobId, false, "no network activity");     // Catch: Throwable -> L12
            runSyncFinishedOrCanceledH(null, r15);     // Catch: Throwable -> L12
            r4 = r14;
            goto L78
        L45:
            SyncManager.m3183$$Nest$mpostMonitorSyncProgressMessage(r14.this$0, r15);     // Catch: Throwable -> L12
            r4 = r14;
            goto L78
        L46:
            r4 = this;
            SyncStorageEngine.EndPoint r16 = (SyncStorageEngine.EndPoint) r11.obj;     // Catch: Throwable -> L12
            Bundle r17 = r11.peekData();     // Catch: Throwable -> L12
            if (r2 == false) goto L49;
            Log.d("SyncManager", "handleSyncHandlerMessage: MESSAGE_CANCEL: " + r16 + " bundle: " + r17);     // Catch: Throwable -> L12
        L49:
            cancelActiveSyncH(r16, r17, "MESSAGE_CANCEL");     // Catch: Throwable -> L12
            goto L78
        L50:
            r3 = this;
            ActiveSyncContext r18 = ((ServiceConnectionData) r11.obj).activeSyncContext;     // Catch: Throwable -> L12
            if (r2 == false) goto L53;
            Log.d("SyncManager", "handleSyncHandlerMessage: MESSAGE_SERVICE_DISCONNECTED: " + r18);     // Catch: Throwable -> L12
        L53:
            boolean r19 = SyncManager.m3178$$Nest$misSyncStillActiveH(r3.this$0, r18);     // Catch: Throwable -> L12
            r4 = r3;
            if (r19 == false) goto L78;
        L59:
            e = move-exception;
            SyncManager.m3155$$Nest$fgetmLogger(r3.this$0).log(new Object[]{"RemoteException ", Log.getStackTraceString(e)});     // Catch: Throwable -> L12
        L64:
            SyncResult r20 = new SyncResult();     // Catch: Throwable -> L12
            r20.stats.numIoExceptions++;     // Catch: Throwable -> L12
            SyncJobService.callJobFinished(r18.mSyncOperation.jobId, false, "service disconnected");     // Catch: Throwable -> L12
            runSyncFinishedOrCanceledH(r20, r18);     // Catch: Throwable -> L12
            r4 = r3;
            goto L78
        L56:
            if (r18.mSyncAdapter == null) goto L64;
            SyncManager.m3155$$Nest$fgetmLogger(r3.this$0).log(new Object[]{"Calling cancelSync for SERVICE_DISCONNECTED ", r18, " adapter=", r18.mSyncAdapter});     // Catch: Throwable -> L12 RemoteException -> L59
            r18.mSyncAdapter.cancelSync(r18);     // Catch: Throwable -> L12 RemoteException -> L59
            SyncManager.m3155$$Nest$fgetmLogger(r3.this$0).log(new Object[]{"Canceled"});     // Catch: Throwable -> L12 RemoteException -> L59
        L65:
            SyncHandler r21 = this;
            ServiceConnectionData r22 = (ServiceConnectionData) r11.obj;     // Catch: Throwable -> L12
            if (r2 == false) goto L68;
            Log.d("SyncManager", "handleSyncHandlerMessage: MESSAGE_SERVICE_CONNECTED: " + r22.activeSyncContext);     // Catch: Throwable -> L12
        L68:
            boolean r23 = SyncManager.m3178$$Nest$misSyncStillActiveH(r21.this$0, r22.activeSyncContext);     // Catch: Throwable -> L12
            r4 = r21;
            if (r23 == false) goto L78;
            runBoundToAdapterH(r22.activeSyncContext, r22.adapter);     // Catch: Throwable -> L12
            r4 = r21;
            goto L78
        L71:
            SyncHandler r24 = this;
            SyncFinishedOrCancelledMessagePayload r25 = (SyncFinishedOrCancelledMessagePayload) r11.obj;     // Catch: Throwable -> L12
            boolean r26 = SyncManager.m3178$$Nest$misSyncStillActiveH(r24.this$0, r25.activeSyncContext);     // Catch: Throwable -> L12
            r4 = r24;
            if (r26 == true) goto L75;
            if (r2 == false) goto L78;
            Log.d("SyncManager", "handleSyncHandlerMessage: dropping since the sync is no longer active: " + r25.activeSyncContext);     // Catch: Throwable -> L12
            r4 = r24;
            goto L78
        L75:
            if (r2 == false) goto L77;
            Slog.v("SyncManager", "syncFinished" + r25.activeSyncContext.mSyncOperation);     // Catch: Throwable -> L12
        L77:
            SyncJobService.callJobFinished(r25.activeSyncContext.mSyncOperation.jobId, false, "sync finished");     // Catch: Throwable -> L12
            runSyncFinishedOrCanceledH(r25.syncResult, r25.activeSyncContext);     // Catch: Throwable -> L12
            r4 = r24;
        L12:
            th = th;
            SyncHandler r27 = r3;
        L80:
            r27.mSyncTimeTracker.update();
            throw th;
        L7:
            th = th;
            r27 = this;
            goto L80
        }

        private PowerManager.WakeLock getSyncWakeLock(SyncOperation operation) {
            String wakeLockKey = operation.wakeLockName();
            PowerManager.WakeLock wakeLock = this.mWakeLocks.get(wakeLockKey);
            if (wakeLock != null) goto L6;
            String name = SyncManager.SYNC_WAKE_LOCK_PREFIX + wakeLockKey;
            PowerManager.WakeLock wakeLock2 = SyncManager.m3157$$Nest$fgetmPowerManager(this.this$0).newWakeLock(1, name);
            wakeLock2.setReferenceCounted(false);
            this.mWakeLocks.put(wakeLockKey, wakeLock2);
            return wakeLock2;
        L6:
            return wakeLock;
        }

        private void deferSyncH(SyncOperation op, long delay, String why) {
            SyncLogger r0 = SyncManager.m3155$$Nest$fgetmLogger(this.this$0);
            if (op.isPeriodic == false) goto L6;
            String r1 = "periodic ";
        L5:
            String r3 = r1;
            r0.log(new Object[]{"deferSyncH() ", r3, "sync.  op=", op, " delay=", Long.valueOf(delay), " why=", why});
            SyncJobService.callJobFinished(op.jobId, false, why);
            if (op.isPeriodic == false) goto L10;
            SyncManager.m3189$$Nest$mscheduleSyncOperationH(this.this$0, op.createOneTimeSyncOperation(), delay);
            return;
        L10:
            SyncManager.m3166$$Nest$mcancelJob(this.this$0, op, "deferSyncH()");
            SyncManager.m3189$$Nest$mscheduleSyncOperationH(this.this$0, op, delay);
            return;
        L6:
            r1 = "";
            goto L5
        }

        private void deferStoppedSyncH(SyncOperation op, long delay) {
            if (op.isPeriodic == false) goto L5;
            SyncManager.m3189$$Nest$mscheduleSyncOperationH(this.this$0, op.createOneTimeSyncOperation(), delay);
            return;
        L5:
            SyncManager.m3189$$Nest$mscheduleSyncOperationH(this.this$0, op, delay);
        }

        private void deferActiveSyncH(ActiveSyncContext asc, String why) {
            SyncOperation op = asc.mSyncOperation;
            runSyncFinishedOrCanceledH(null, asc);
            deferSyncH(op, 10000, why);
        }

        private void startSyncH(SyncOperation op) {
            boolean isLoggable = Log.isLoggable("SyncManager", 2);
            if (isLoggable == false) goto L5;
            Slog.v("SyncManager", op.toString());
        L5:
            SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).setClockValid();
            SyncJobService.markSyncStarted(op.jobId);
            if (op.isPeriodic == false) goto L27;
            List<SyncOperation> ops = SyncManager.m3170$$Nest$mgetAllPendingSyncs(this.this$0);
            Iterator<SyncOperation> r4 = ops.iterator();
        L9:
            if (r4.hasNext() == false) goto L15;
            SyncOperation syncOperation = r4.next();
            if (syncOperation.sourcePeriodicId != op.jobId) goto L9;
            SyncJobService.callJobFinished(op.jobId, false, "periodic sync, pending");
            return;
        L15:
            Iterator<ActiveSyncContext> r5 = this.this$0.mActiveSyncContexts.iterator();
        L17:
            if (r5.hasNext() == false) goto L24;
            if (r5.next().mSyncOperation.sourcePeriodicId != op.jobId) goto L17;
            SyncJobService.callJobFinished(op.jobId, false, "periodic sync, already running");
            return;
        L24:
            if (SyncManager.m3175$$Nest$misAdapterDelayed(this.this$0, op.target) == false) goto L27;
            deferSyncH(op, 0, "backing off");
            return;
        L27:
            Iterator<ActiveSyncContext> r2 = this.this$0.mActiveSyncContexts.iterator();
        L29:
            if (r2.hasNext() == false) goto L42;
            ActiveSyncContext asc = r2.next();
            if (asc.mSyncOperation.isConflict(op) == false) goto L29;
            if (asc.mSyncOperation.getJobBias() < op.getJobBias()) goto L38;
            if (isLoggable == false) goto L36;
            Slog.v("SyncManager", "Rescheduling sync due to conflict " + op.toString());
        L36:
            deferSyncH(op, 10000, "delay on conflict");
            return;
        L38:
            if (isLoggable == false) goto L40;
            Slog.v("SyncManager", "Pushing back running sync due to a higher priority sync");
        L40:
            deferActiveSyncH(asc, "preempted");
        L42:
            int syncOpState = computeSyncOpState(op);
            if (syncOpState == 0) goto L47;
            SyncJobService.callJobFinished(op.jobId, false, "invalid op state: " + syncOpState);
            return;
        L47:
            if (dispatchSyncOperation(op) == true) goto L49;
            SyncJobService.callJobFinished(op.jobId, false, "dispatchSyncOperation() failed");
        L49:
            SyncManager.m3191$$Nest$msetAuthorityPendingState(this.this$0, op.target);
        }

        private ActiveSyncContext findActiveSyncContextH(int jobId) {
            Iterator<ActiveSyncContext> r0 = this.this$0.mActiveSyncContexts.iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            ActiveSyncContext asc = r0.next();
            SyncOperation op = asc.mSyncOperation;
            if (op == null) goto L4;
            if (op.jobId != jobId) goto L4;
            return asc;
        L11:
            return null;
        }

        private void updateRunningAccountsH(SyncStorageEngine.EndPoint syncTargets) {
            Object r3 = SyncManager.m3150$$Nest$fgetmAccountsLock(this.this$0);
            monitor-enter(r3);
            AccountAndUser[] oldAccounts = SyncManager.m3159$$Nest$fgetmRunningAccounts(this.this$0);     // Catch: Throwable -> L9
            SyncManager.m3165$$Nest$fputmRunningAccounts(this.this$0, AccountManagerService.getSingleton().getRunningAccountsForSystem());     // Catch: Throwable -> L9
            if (Log.isLoggable("SyncManager", 2) == false) goto L12;
            Slog.v("SyncManager", "Accounts list: ");     // Catch: Throwable -> L9
            AccountAndUser[] r4 = SyncManager.m3159$$Nest$fgetmRunningAccounts(this.this$0);     // Catch: Throwable -> L9
            int r5 = r4.length;     // Catch: Throwable -> L9
            int r6 = 0;
        L7:
            if (r6 >= r5) goto L12;
            AccountAndUser acc = r4[r6];     // Catch: Throwable -> L9
            Slog.v("SyncManager", acc.toString());     // Catch: Throwable -> L9
            r6 = r6 + 1;     // Catch: Throwable -> L9
        L12:
            if (SyncManager.m3155$$Nest$fgetmLogger(this.this$0).enabled() == false) goto L14;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"updateRunningAccountsH: ", Arrays.toString(SyncManager.m3159$$Nest$fgetmRunningAccounts(this.this$0))});     // Catch: Throwable -> L9
        L14:
            SyncManager.m3186$$Nest$mremoveStaleAccounts(this.this$0);     // Catch: Throwable -> L9
            AccountAndUser[] accounts = SyncManager.m3159$$Nest$fgetmRunningAccounts(this.this$0);     // Catch: Throwable -> L9
            int i = 0;
            int size = this.this$0.mActiveSyncContexts.size();     // Catch: Throwable -> L9
        L15:
            if (i >= size) goto L21;
            ActiveSyncContext currentSyncContext = this.this$0.mActiveSyncContexts.get(i);     // Catch: Throwable -> L9
            if (SyncManager.m3169$$Nest$mcontainsAccountAndUser(this.this$0, accounts, currentSyncContext.mSyncOperation.target.account, currentSyncContext.mSyncOperation.target.userId) == true) goto L19;
            Log.d("SyncManager", "canceling sync since the account is no longer running");     // Catch: Throwable -> L9
            SyncManager.m3190$$Nest$msendSyncFinishedOrCanceledMessage(this.this$0, currentSyncContext, null);     // Catch: Throwable -> L9
        L19:
            i = i + 1;     // Catch: Throwable -> L9
            goto L15
        L21:
            if (syncTargets == null) goto L31;
            int i2 = 0;
            int length = SyncManager.m3159$$Nest$fgetmRunningAccounts(this.this$0).length;     // Catch: Throwable -> L9
        L23:
            if (i2 >= length) goto L31;
            AccountAndUser aau = SyncManager.m3159$$Nest$fgetmRunningAccounts(this.this$0)[i2];     // Catch: Throwable -> L9
            if (SyncManager.m3169$$Nest$mcontainsAccountAndUser(this.this$0, oldAccounts, aau.account, aau.userId) == false) goto L27;
            i2 = i2 + 1;     // Catch: Throwable -> L9
            goto L23
        L27:
            if (Log.isLoggable("SyncManager", 3) == false) goto L29;
            Log.d("SyncManager", "Account " + aau.account + " added, checking sync restore data");     // Catch: Throwable -> L9
        L29:
            AccountSyncSettingsBackupHelper.accountAdded(SyncManager.m3153$$Nest$fgetmContext(this.this$0), syncTargets.userId);     // Catch: Throwable -> L9
        L31:
            monitor-exit(r3);     // Catch: Throwable -> L9
            AccountAndUser[] allAccounts = AccountManagerService.getSingleton().getAllAccountsForSystemProcess();
            List<SyncOperation> ops = SyncManager.m3170$$Nest$mgetAllPendingSyncs(this.this$0);
            int i3 = 0;
            int opsSize = ops.size();
        L33:
            if (i3 >= opsSize) goto L39;
            SyncOperation op = ops.get(i3);
            if (SyncManager.m3169$$Nest$mcontainsAccountAndUser(this.this$0, allAccounts, op.target.account, op.target.userId) == true) goto L37;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"canceling: ", op});
            SyncManager.m3166$$Nest$mcancelJob(this.this$0, op, "updateRunningAccountsH()");
        L37:
            i3 = i3 + 1;
            goto L33
        L39:
            if (syncTargets == null) goto L55;
            this.this$0.scheduleSync(syncTargets.account, syncTargets.userId, -2, syncTargets.provider, null, -1, 0, Process.myUid(), -4, null);
            return;
        L55:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private void maybeUpdateSyncPeriodH(SyncOperation syncOperation, long pollFrequencyMillis, long flexMillis) {
            if (pollFrequencyMillis != syncOperation.periodMillis) goto L9;
            if (flexMillis != syncOperation.flexMillis) goto L9;
            return;
        L9:
            if (Log.isLoggable("SyncManager", 2) == false) goto L11;
            Slog.v("SyncManager", "updating period " + syncOperation + " to " + pollFrequencyMillis + " and flex to " + flexMillis);
        L11:
            SyncOperation newOp = new SyncOperation(syncOperation, pollFrequencyMillis, flexMillis);
            newOp.jobId = syncOperation.jobId;
            SyncManager.m3188$$Nest$mscheduleSyncOperationH(this.this$0, newOp);
        }

        private void updateOrAddPeriodicSyncH(final SyncStorageEngine.EndPoint target, final long pollFrequency, final long flex, final Bundle extras) {
            SyncHandler r0 = this;
            boolean isLoggable = Log.isLoggable("SyncManager", 2);
            SyncManager.m3194$$Nest$mverifyJobScheduler(r0.this$0);
            long pollFrequencyMillis = pollFrequency * 1000;
            long flexMillis = flex * 1000;
            if (isLoggable == false) goto L5;
            Slog.v("SyncManager", "Addition to periodic syncs requested: " + target + " period: " + pollFrequency + " flexMillis: " + flex + " extras: " + extras.toString());
        L5:
            List<SyncOperation> ops = SyncManager.m3170$$Nest$mgetAllPendingSyncs(r0.this$0);
            Iterator<SyncOperation> r14 = ops.iterator();
        L6:
            r14 = r14;
            if (r14.hasNext() == false) goto L22;
            SyncOperation op = r14.next();
            pollFrequencyMillis = pollFrequencyMillis;
            if (op.isPeriodic == false) goto L6;
            if (op.target.matchesSpec(target) == false) goto L6;
            if (op.areExtrasEqual(extras, true) == false) goto L6;
            if (SyncManager.m3177$$Nest$misPackageStopped(r0.this$0, op.owningPackage, target.userId) == false) goto L17;
            r0 = this;
            goto L6
        L17:
            maybeUpdateSyncPeriodH(op, pollFrequencyMillis, flexMillis);
            return;
        L22:
            long pollFrequencyMillis2 = pollFrequencyMillis;
            if (isLoggable == false) goto L25;
            Slog.v("SyncManager", "Adding new periodic sync: " + target + " period: " + pollFrequency + " flexMillis: " + flex + " extras: " + extras.toString());
        L25:
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = r0.this$0.mSyncAdapters.getServiceInfo(SyncAdapterType.newKey(target.provider, target.account.type), target.userId);
            if (syncAdapterInfo != null) goto L28;
            return;
        L28:
            SyncOperation op2 = new SyncOperation(target, syncAdapterInfo.uid, syncAdapterInfo.componentName.getPackageName(), -4, 4, extras, ((SyncAdapterType) syncAdapterInfo.type).allowParallelSyncs(), true, -1, pollFrequencyMillis2, flexMillis, 0);
            int syncOpState = computeSyncOpState(op2);
            if (syncOpState != 2) goto L36;
            String packageName = op2.owningPackage;
            int userId = UserHandle.getUserId(op2.owningUid);
            if (SyncManager.m3195$$Nest$mwasPackageEverLaunched(this.this$0, packageName, userId) == true) goto L33;
            return;
        L33:
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"requestAccountAccess for SYNC_OP_STATE_INVALID_NO_ACCOUNT_ACCESS"});
            SyncManager.m3149$$Nest$fgetmAccountManagerInternal(this.this$0).requestAccountAccess(op2.target.account, packageName, userId, new RemoteCallback(new SyncManager$SyncHandler$$ExternalSyntheticLambda0(this, target, pollFrequency, flex, extras)));
            return;
        L36:
            if (syncOpState == 0) goto L39;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"syncOpState=", Integer.valueOf(syncOpState)});
            return;
        L39:
            SyncManager.m3188$$Nest$mscheduleSyncOperationH(this.this$0, op2);
            SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).reportChange(1, op2.owningPackage, target.userId);
        }

        private /* synthetic */ void lambda$updateOrAddPeriodicSyncH$0(SyncStorageEngine.EndPoint target, long pollFrequency, long flex, Bundle extras, Bundle result) {
            if (result == null) goto L8;
            if (result.getBoolean("booleanResult") == false) goto L10;
            this.this$0.updateOrAddPeriodicSync(target, pollFrequency, flex, extras);
            return;
        L10:
            return;
        }

        private void removePeriodicSyncInternalH(SyncOperation syncOperation, String why) {
            List<SyncOperation> ops = SyncManager.m3170$$Nest$mgetAllPendingSyncs(this.this$0);
            Iterator<SyncOperation> r1 = ops.iterator();
        L4:
            if (r1.hasNext() == false) goto L14;
            SyncOperation op = r1.next();
            if (op.sourcePeriodicId == syncOperation.jobId) goto L9;
            if (op.jobId != syncOperation.jobId) goto L4;
        L9:
            ActiveSyncContext asc = findActiveSyncContextH(syncOperation.jobId);
            if (asc == null) goto L12;
            SyncJobService.callJobFinished(syncOperation.jobId, false, "removePeriodicSyncInternalH");
            runSyncFinishedOrCanceledH(null, asc);
        L12:
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"removePeriodicSyncInternalH-canceling: ", op});
            SyncManager.m3166$$Nest$mcancelJob(this.this$0, op, why);
            goto L4
        }

        private void removePeriodicSyncH(SyncStorageEngine.EndPoint target, Bundle extras, String why) {
            SyncManager.m3194$$Nest$mverifyJobScheduler(this.this$0);
            List<SyncOperation> ops = SyncManager.m3170$$Nest$mgetAllPendingSyncs(this.this$0);
            Iterator<SyncOperation> r1 = ops.iterator();
        L4:
            if (r1.hasNext() == false) goto L13;
            SyncOperation op = r1.next();
            if (op.isPeriodic == false) goto L4;
            if (op.target.matchesSpec(target) == false) goto L4;
            if (op.areExtrasEqual(extras, true) == false) goto L4;
            removePeriodicSyncInternalH(op, why);
            goto L4
        }

        private boolean isSyncNotUsingNetworkH(ActiveSyncContext activeSyncContext) {
            long bytesTransferredCurrent = SyncManager.m3173$$Nest$mgetTotalBytesTransferredByUid(this.this$0, activeSyncContext.mSyncAdapterUid);
            long deltaBytesTransferred = bytesTransferredCurrent - activeSyncContext.mBytesTransferredAtLastPoll;
            if (Log.isLoggable("SyncManager", 3) == false) goto L7;
            long mb = deltaBytesTransferred / DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES;
            long remainder = deltaBytesTransferred % DeviceStorageMonitorServiceSmtEx.TrafficStats.MB_IN_BYTES;
            long kb = remainder / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
            long remainder2 = remainder % DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
            Log.d("SyncManager", String.format("Time since last update: %ds. Delta transferred: %dMBs,%dKBs,%dBs", new Object[]{Long.valueOf((SystemClock.elapsedRealtime() - activeSyncContext.mLastPolledTimeElapsed) / 1000), Long.valueOf(mb), Long.valueOf(kb), Long.valueOf(remainder2)}));
        L7:
            if (deltaBytesTransferred > 10) goto L9;
            return true;
        L9:
            return false;
        }

        private int computeSyncOpState(SyncOperation op) {
            boolean isLoggable = Log.isLoggable("SyncManager", 2);
            SyncStorageEngine.EndPoint target = op.target;
            Object r4 = SyncManager.m3150$$Nest$fgetmAccountsLock(this.this$0);
            monitor-enter(r4);
            AccountAndUser[] accounts = SyncManager.m3159$$Nest$fgetmRunningAccounts(this.this$0);     // Catch: Throwable -> L8
            if (SyncManager.m3169$$Nest$mcontainsAccountAndUser(this.this$0, accounts, target.account, target.userId) == true) goto L14;
            if (isLoggable == false) goto L10;
            Slog.v("SyncManager", "    Dropping sync operation: account doesn't exist.");     // Catch: Throwable -> L8
        L10:
            logAccountError("SYNC_OP_STATE_INVALID: account doesn't exist.");     // Catch: Throwable -> L8
            monitor-exit(r4);     // Catch: Throwable -> L8
            return 3;
        L14:
            monitor-exit(r4);     // Catch: Throwable -> L8
            int state = this.this$0.computeSyncable(target.account, target.userId, target.provider, true, true);
            if (state != 3) goto L21;
            if (isLoggable == false) goto L19;
            Slog.v("SyncManager", "    Dropping sync operation: isSyncable == SYNCABLE_NO_ACCOUNT_ACCESS");
        L19:
            logAccountError("SYNC_OP_STATE_INVALID_NO_ACCOUNT_ACCESS");
            return 2;
        L21:
            if (state != 0) goto L26;
            if (isLoggable == false) goto L24;
            Slog.v("SyncManager", "    Dropping sync operation: isSyncable == NOT_SYNCABLE");
        L24:
            logAccountError("SYNC_OP_STATE_INVALID: NOT_SYNCABLE");
            return 4;
        L26:
            boolean ignoreSystemConfiguration = true;
            if (SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).getMasterSyncAutomatically(target.userId) == true) goto L29;
        L31:
            boolean syncEnabled = false;
        L33:
            if (op.isIgnoreSettings() == true) goto L37;
            if (state < 0) goto L37;
            ignoreSystemConfiguration = false;
        L37:
            if (syncEnabled == true) goto L43;
            if (ignoreSystemConfiguration == true) goto L43;
            if (isLoggable == false) goto L41;
            Slog.v("SyncManager", "    Dropping sync operation: disallowed by settings/network.");
        L41:
            logAccountError("SYNC_OP_STATE_INVALID: disallowed by settings/network");
            return 5;
        L43:
            return 0;
        L29:
            if (SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).getSyncAutomatically(target.account, target.userId, target.provider) == false) goto L31;
            syncEnabled = true;
        L8:
            th = move-exception;
            throw th;
        }

        private void logAccountError(String message) {
            Slog.wtf("SyncManager", message);
        }

        private boolean dispatchSyncOperation(SyncOperation op) {
            if (Log.isLoggable("SyncManager", 2) == false) goto L9;
            Slog.v("SyncManager", "dispatchSyncOperation: we are going to sync " + op);
            Slog.v("SyncManager", "num active syncs: " + this.this$0.mActiveSyncContexts.size());
            Iterator<ActiveSyncContext> r2 = this.this$0.mActiveSyncContexts.iterator();
        L6:
            if (r2.hasNext() == false) goto L9;
            ActiveSyncContext syncContext = r2.next();
            Slog.v("SyncManager", syncContext.toString());
        L9:
            if (op.isAppStandbyExempted() == false) goto L13;
            UsageStatsManagerInternal usmi = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
            if (usmi == null) goto L13;
            usmi.reportExemptedSyncStart(op.owningPackage, UserHandle.getUserId(op.owningUid));
        L13:
            SyncStorageEngine.EndPoint info = op.target;
            SyncAdapterType syncAdapterType = SyncAdapterType.newKey(info.provider, info.account.type);
            RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = this.this$0.mSyncAdapters.getServiceInfo(syncAdapterType, info.userId);
            if (syncAdapterInfo != null) goto L17;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"dispatchSyncOperation() failed: no sync adapter info for ", syncAdapterType});
            Log.d("SyncManager", "can't find a sync adapter for " + syncAdapterType + ", removing settings for it");
            SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).removeAuthority(info);
            return false;
        L17:
            int targetUid = syncAdapterInfo.uid;
            ComponentName targetComponent = syncAdapterInfo.componentName;
            ActiveSyncContext activeSyncContext = new ActiveSyncContext(this.this$0, op, insertStartSyncEvent(op), targetUid);
            if (Log.isLoggable("SyncManager", 2) == false) goto L20;
            Slog.v("SyncManager", "dispatchSyncOperation: starting " + activeSyncContext);
        L20:
            activeSyncContext.mSyncInfo = SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).addActiveSync(activeSyncContext);
            this.this$0.mActiveSyncContexts.add(activeSyncContext);
            SyncManager.m3183$$Nest$mpostMonitorSyncProgressMessage(this.this$0, activeSyncContext);
            if (activeSyncContext.bindToSyncAdapter(targetComponent, info.userId) == true) goto L24;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"dispatchSyncOperation() failed: bind failed. target: ", targetComponent});
            Slog.e("SyncManager", "Bind attempt failed - target: " + targetComponent);
            closeActiveSyncContext(activeSyncContext);
            return false;
        L24:
            return true;
        }

        private void runBoundToAdapterH(ActiveSyncContext activeSyncContext, IBinder syncAdapter) {
            SyncOperation syncOperation = activeSyncContext.mSyncOperation;
            activeSyncContext.mIsLinkedToDeath = true;     // Catch: RuntimeException -> L14 RemoteException -> L17
        L23:
            syncAdapter.linkToDeath(activeSyncContext, 0);     // Catch: RuntimeException -> L8 RemoteException -> L10
            if (SyncManager.m3155$$Nest$fgetmLogger(this.this$0).enabled() == false) goto L12;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"Sync start: account=" + syncOperation.target.account, " authority=", syncOperation.target.provider, " reason=", SyncOperation.reasonToString(null, syncOperation.reason), " extras=", syncOperation.getExtrasAsString(), " adapter=", activeSyncContext.mSyncAdapter});     // Catch: RuntimeException -> L8 RemoteException -> L10
        L12:
            activeSyncContext.mSyncAdapter = ISyncAdapter.Stub.asInterface(syncAdapter);     // Catch: RuntimeException -> L8 RemoteException -> L10
            activeSyncContext.mSyncAdapter.startSync(activeSyncContext, syncOperation.target.provider, syncOperation.target.account, syncOperation.getClonedExtras());     // Catch: RuntimeException -> L8 RemoteException -> L10
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"Sync is running now..."});     // Catch: RuntimeException -> L8 RemoteException -> L10
        L25:
            return;
        L10:
            remoteExc = e;
        L19:
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"Sync failed with RemoteException: ", remoteExc.toString()});
            Log.d("SyncManager", "maybeStartNextSync: caught a RemoteException, rescheduling", remoteExc);
            closeActiveSyncContext(activeSyncContext);
            SyncManager.m3174$$Nest$mincreaseBackoffSetting(this.this$0, syncOperation.target);
            SyncManager.m3188$$Nest$mscheduleSyncOperationH(this.this$0, syncOperation);
            return;
        L8:
            exc = e;
        L16:
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"Sync failed with RuntimeException: ", exc.toString()});
            closeActiveSyncContext(activeSyncContext);
            Slog.e("SyncManager", "Caught RuntimeException while starting the sync " + SyncLogger.logSafe(syncOperation), exc);
            return;
        L17:
            remoteExc = e;
        L14:
            exc = e;
            goto L16
        }

        private void cancelActiveSyncH(SyncStorageEngine.EndPoint info, Bundle extras, String why) {
            ArrayList<ActiveSyncContext> activeSyncs = new ArrayList(this.this$0.mActiveSyncContexts);
            Iterator<ActiveSyncContext> r1 = activeSyncs.iterator();
        L4:
            if (r1.hasNext() == false) goto L17;
            ActiveSyncContext activeSyncContext = r1.next();
            if (activeSyncContext == null) goto L4;
            SyncStorageEngine.EndPoint opInfo = activeSyncContext.mSyncOperation.target;
            if (opInfo.matchesSpec(info) == false) goto L4;
            if (extras == null) goto L15;
            if (activeSyncContext.mSyncOperation.areExtrasEqual(extras, false) == false) goto L4;
        L15:
            SyncJobService.callJobFinished(activeSyncContext.mSyncOperation.jobId, false, why);
            runSyncFinishedOrCanceledH(null, activeSyncContext);
            goto L4
        }

        private void reschedulePeriodicSyncH(SyncOperation syncOperation) {
            SyncOperation periodicSync = null;
            List<SyncOperation> ops = SyncManager.m3170$$Nest$mgetAllPendingSyncs(this.this$0);
            Iterator<SyncOperation> r2 = ops.iterator();
        L4:
            if (r2.hasNext() == false) goto L11;
            SyncOperation op = r2.next();
            if (op.isPeriodic == false) goto L4;
            if (syncOperation.matchesPeriodicOperation(op) == false) goto L4;
            periodicSync = op;
        L11:
            if (periodicSync != null) goto L13;
            return;
        L13:
            SyncManager.m3188$$Nest$mscheduleSyncOperationH(this.this$0, periodicSync);
        }

        private void runSyncFinishedOrCanceledH(SyncResult syncResult, ActiveSyncContext activeSyncContext) {
            boolean isLoggable = Log.isLoggable("SyncManager", 2);
            SyncOperation syncOperation = activeSyncContext.mSyncOperation;
            SyncStorageEngine.EndPoint info = syncOperation.target;
            if (activeSyncContext.mIsLinkedToDeath == true) goto L55;
        L8:
            long elapsedTime = SystemClock.elapsedRealtime() - activeSyncContext.mStartTime;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"runSyncFinishedOrCanceledH() op=", syncOperation, " result=", syncResult});
            if (syncResult == null) goto L29;
            if (isLoggable == false) goto L12;
            Slog.v("SyncManager", "runSyncFinishedOrCanceled [finished]: " + syncOperation + ", result " + syncResult);
        L12:
            closeActiveSyncContext(activeSyncContext);
            if (syncOperation.isPeriodic == true) goto L16;
            SyncManager.m3166$$Nest$mcancelJob(this.this$0, syncOperation, "runSyncFinishedOrCanceledH()-finished");
        L16:
            if (syncResult.hasError() == true) goto L20;
            String historyMessage = SyncStorageEngine.MESG_SUCCESS;
            int downstreamActivity = 0;
            int upstreamActivity = 0;
            SyncManager.m3168$$Nest$mclearBackoffSetting(this.this$0, syncOperation.target, "sync success");
            if (syncOperation.isDerivedFromFailedPeriodicSync() == false) goto L28;
            reschedulePeriodicSyncH(syncOperation);
        L28:
            SyncManager.m3192$$Nest$msetDelayUntilTime(this.this$0, syncOperation.target, syncResult.delayUntil);
            String historyMessage2 = historyMessage;
            int downstreamActivity2 = downstreamActivity;
            int upstreamActivity2 = upstreamActivity;
        L41:
            stopSyncEvent(activeSyncContext.mHistoryRowId, syncOperation, historyMessage2, upstreamActivity2, downstreamActivity2, elapsedTime);
            if (syncResult != null) goto L44;
        L46:
            SyncHandler r1 = this;
            SyncManager.m3156$$Nest$fgetmNotificationMgr(r1.this$0).cancelAsUser(Integer.toString(info.account.hashCode() ^ info.provider.hashCode()), 18, new UserHandle(info.userId));
        L47:
            if (syncResult == null) goto L52;
            if (syncResult.fullSyncRequested == false) goto L52;
            SyncManager.m3188$$Nest$mscheduleSyncOperationH(r1.this$0, new SyncOperation(info.account, info.userId, syncOperation.owningUid, syncOperation.owningPackage, syncOperation.reason, syncOperation.syncSource, info.provider, new Bundle(), syncOperation.allowParallelSyncs, syncOperation.syncExemptionFlag));
            return;
        L52:
            return;
        L44:
            if (syncResult.tooManyDeletions == false) goto L46;
            r1 = this;
            r1.installHandleTooManyDeletesNotification(info.account, info.provider, syncResult.stats.numDeletes, info.userId);
            goto L47
        L20:
            Log.w("SyncManager", "failed sync operation " + SyncLogger.logSafe(syncOperation) + ", " + syncResult);
            syncOperation.retries = syncOperation.retries + 1;
            if (syncOperation.retries <= SyncManager.m3152$$Nest$fgetmConstants(this.this$0).getMaxRetriesWithAppStandbyExemption()) goto L23;
            syncOperation.syncExemptionFlag = 0;
        L23:
            SyncManager.m3174$$Nest$mincreaseBackoffSetting(this.this$0, syncOperation.target);
            if (syncOperation.isPeriodic == true) goto L26;
            SyncManager.m3179$$Nest$mmaybeRescheduleSync(this.this$0, syncResult, syncOperation);
        L27:
            historyMessage = ContentResolver.syncErrorToString(syncResultToErrorNumber(syncResult));
            downstreamActivity = 0;
            upstreamActivity = 0;
            goto L28
        L26:
            SyncManager.m3184$$Nest$mpostScheduleSyncMessage(this.this$0, syncOperation.createOneTimeSyncOperation(), 0);
            goto L27
        L29:
            if (isLoggable == false) goto L32;
            Slog.v("SyncManager", "runSyncFinishedOrCanceled [canceled]: " + syncOperation);
        L32:
            if (syncOperation.isPeriodic == true) goto L35;
            SyncManager.m3166$$Nest$mcancelJob(this.this$0, syncOperation, "runSyncFinishedOrCanceledH()-canceled");
        L35:
            if (activeSyncContext.mSyncAdapter != null) goto L53;
        L40:
            closeActiveSyncContext(activeSyncContext);
            historyMessage2 = SyncStorageEngine.MESG_CANCELED;
            downstreamActivity2 = 0;
            upstreamActivity2 = 0;
            goto L41
        L53:
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"Calling cancelSync for runSyncFinishedOrCanceled ", activeSyncContext, "  adapter=", activeSyncContext.mSyncAdapter});     // Catch: RemoteException -> L38
            activeSyncContext.mSyncAdapter.cancelSync(activeSyncContext);     // Catch: RemoteException -> L38
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"Canceled"});     // Catch: RemoteException -> L38
        L38:
            e = move-exception;
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"RemoteException ", Log.getStackTraceString(e)});
            goto L40
        L55:
            activeSyncContext.mSyncAdapter.asBinder().unlinkToDeath(activeSyncContext, 0);     // Catch: NoSuchElementException -> L6
            activeSyncContext.mIsLinkedToDeath = false;     // Catch: NoSuchElementException -> L6
        L6:
            e = move-exception;
            Slog.wtf("SyncManager", "Failed to unlink active sync adapter to death", e);
            goto L8
        }

        private void closeActiveSyncContext(ActiveSyncContext activeSyncContext) {
            activeSyncContext.close();
            this.this$0.mActiveSyncContexts.remove(activeSyncContext);
            SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).removeActiveSync(activeSyncContext.mSyncInfo, activeSyncContext.mSyncOperation.target.userId);
            if (Log.isLoggable("SyncManager", 2) == false) goto L5;
            Slog.v("SyncManager", "removing all MESSAGE_MONITOR_SYNC & MESSAGE_SYNC_EXPIRED for " + activeSyncContext.toString());
        L5:
            SyncManager.m3160$$Nest$fgetmSyncHandler(this.this$0).removeMessages(8, activeSyncContext);
            SyncManager.m3155$$Nest$fgetmLogger(this.this$0).log(new Object[]{"closeActiveSyncContext: ", activeSyncContext});
        }

        private int syncResultToErrorNumber(SyncResult syncResult) {
            if (syncResult.syncAlreadyInProgress == false) goto L7;
            return 1;
        L7:
            if (syncResult.stats.numAuthExceptions <= 0) goto L11;
            return 2;
        L11:
            if (syncResult.stats.numIoExceptions <= 0) goto L15;
            return 3;
        L15:
            if (syncResult.stats.numParseExceptions <= 0) goto L19;
            return 4;
        L19:
            if (syncResult.stats.numConflictDetectedExceptions <= 0) goto L23;
            return 5;
        L23:
            if (syncResult.tooManyDeletions == false) goto L27;
            return 6;
        L27:
            if (syncResult.tooManyRetries == false) goto L31;
            return 7;
        L31:
            if (syncResult.databaseError == false) goto L35;
            return 8;
        L35:
            throw new IllegalStateException("we are not in an error state, " + syncResult);
        }

        private void installHandleTooManyDeletesNotification(Account account, String authority, long numDeletes, int userId) {
            if (SyncManager.m3156$$Nest$fgetmNotificationMgr(this.this$0) != null) goto L5;
            return;
        L5:
            ProviderInfo providerInfo = SyncManager.m3153$$Nest$fgetmContext(this.this$0).getPackageManager().resolveContentProvider(authority, 0);
            if (providerInfo != null) goto L8;
            return;
        L8:
            CharSequence authorityName = providerInfo.loadLabel(SyncManager.m3153$$Nest$fgetmContext(this.this$0).getPackageManager());
            Intent clickIntent = new Intent(SyncManager.m3153$$Nest$fgetmContext(this.this$0), SyncActivityTooManyDeletes.class);
            clickIntent.putExtra("account", account);
            clickIntent.putExtra("authority", authority);
            clickIntent.putExtra("provider", authorityName.toString());
            clickIntent.putExtra("numDeletes", numDeletes);
            if (isActivityAvailable(clickIntent) == true) goto L12;
            Log.w("SyncManager", "No activity found to handle too many deletes.");
            return;
        L12:
            UserHandle user = new UserHandle(userId);
            PendingIntent pendingIntent = PendingIntent.getActivityAsUser(SyncManager.m3153$$Nest$fgetmContext(this.this$0), 0, clickIntent, AudioFormat.AAC_ADIF, null, user);
            CharSequence tooManyDeletesDescFormat = SyncManager.m3153$$Nest$fgetmContext(this.this$0).getResources().getText(R.string.default_card_name);
            Context contextForUser = SyncManager.m3171$$Nest$mgetContextForUser(this.this$0, user);
            Notification notification = new Notification.Builder(contextForUser, "ACCOUNT").setSmallIcon(17305173).setTicker(SyncManager.m3153$$Nest$fgetmContext(this.this$0).getString(R.string.default_audio_route_name_usb)).setWhen(System.currentTimeMillis()).setColor(contextForUser.getColor(R.color.system_notification_accent_color)).setContentTitle(contextForUser.getString(R.string.default_browser)).setContentText(String.format(tooManyDeletesDescFormat.toString(), new Object[]{authorityName})).setContentIntent(pendingIntent).build();
            notification.flags |= 2;
            SyncManager.m3156$$Nest$fgetmNotificationMgr(this.this$0).notifyAsUser(Integer.toString(account.hashCode() ^ authority.hashCode()), 18, notification, user);
        }

        private boolean isActivityAvailable(Intent intent) {
            PackageManager pm = SyncManager.m3153$$Nest$fgetmContext(this.this$0).getPackageManager();
            List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
            int listSize = list.size();
            int i = 0;
        L3:
            if (i >= listSize) goto L9;
            ResolveInfo resolveInfo = list.get(i);
            if ((resolveInfo.activityInfo.applicationInfo.flags & 1) != 0) goto L6;
            i = i + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public long insertStartSyncEvent(SyncOperation syncOperation) {
            long now = System.currentTimeMillis();
            EventLog.writeEvent(2720, syncOperation.toEventLog(0));
            return SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).insertStartSyncEvent(syncOperation, now);
        }

        public void stopSyncEvent(long rowId, SyncOperation syncOperation, String resultMessage, int upstreamActivity, int downstreamActivity, long elapsedTime) {
            EventLog.writeEvent(2720, syncOperation.toEventLog(1));
            SyncManager.m3162$$Nest$fgetmSyncStorageEngine(this.this$0).stopSyncEvent(rowId, elapsedTime, resultMessage, downstreamActivity, upstreamActivity, syncOperation.owningPackage, syncOperation.target.userId);
        }
    }

    private class SyncTimeTracker {
        boolean mLastWasSyncing;
        private long mTimeSpentSyncing;
        long mWhenSyncStarted;
        final /* synthetic */ SyncManager this$0;

        /* synthetic */ SyncTimeTracker(SyncManager r1, SyncManagerIA r2) {
            this(r1);
        }

        private SyncTimeTracker(SyncManager r3) {
            this.this$0 = r3;
            this.mLastWasSyncing = false;
            this.mWhenSyncStarted = 0;
        }

        public synchronized void update() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (this.this$0.mActiveSyncContexts.isEmpty() == true) goto L6;
            boolean isSyncInProgress = true;
        L8:
            if (isSyncInProgress != this.mLastWasSyncing) goto L11;
            monitor-exit(this);
            return;
        L11:
            long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
            if (isSyncInProgress == false) goto L16;
            this.mWhenSyncStarted = now;     // Catch: Throwable -> L14
        L17:
            this.mLastWasSyncing = isSyncInProgress;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L16:
            this.mTimeSpentSyncing += now - this.mWhenSyncStarted;     // Catch: Throwable -> L14
            goto L17
        L6:
            isSyncInProgress = false;
            goto L8
        }

        public synchronized long timeSpentSyncing() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mLastWasSyncing == true) goto L10;
            long r0 = this.mTimeSpentSyncing;     // Catch: Throwable -> L8
            monitor-exit(this);
            return r0;
        L10:
            long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
            long r2 = this.mTimeSpentSyncing;     // Catch: Throwable -> L8
            long r3 = r2 + (now - this.mWhenSyncStarted);
            monitor-exit(this);
            return r3;
        }
    }

    private class UpdatePeriodicSyncMessagePayload {
        public final Bundle extras;
        public final long flex;
        public final long pollFrequency;
        public final SyncStorageEngine.EndPoint target;

        UpdatePeriodicSyncMessagePayload(SyncManager r1, SyncStorageEngine.EndPoint target, long pollFrequency, long flex, Bundle extras) {
            this.target = target;
            this.pollFrequency = pollFrequency;
            this.flex = flex;
            this.extras = extras;
        }
    }

    public static /* synthetic */ void $r8$lambda$1YO58nwSn0eHOg9tNr_Xtywro7s(SyncManager r0, AccountAndUser r1, int r2, int r3, String r4, Bundle r5, int r6, long r7, int r9, int r10, int r11, String r12, Bundle r13) {
        r0.lambda$scheduleSync$4(r1, r2, r3, r4, r5, r6, r7, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ String $r8$lambda$63WHLrNU8Bn_GlxGnOPyWGEkW4c(Integer r0) {
        return lambda$dumpSyncState$11(r0);
    }

    public static /* synthetic */ void $r8$lambda$7g4VRBsssPoraLECZsEgp0Bslg0(Context r0, OnUnsyncableAccountCheck r1) {
        lambda$sendOnUnsyncableAccount$12(r0, r1);
    }

    public static /* synthetic */ String $r8$lambda$93P3rL2HXSoOpBI2TxIvo2rM7ps(SyncManager r0, int r1) {
        return r0.zeroToEmpty(r1);
    }

    public static /* synthetic */ void $r8$lambda$EwwVix0RGql_2scbHj4IIN1uhyw(SyncManager r0, AccountAndUser r1, int r2, String r3, Bundle r4, int r5, long r6, int r8, int r9, int r10, String r11) {
        r0.lambda$scheduleSync$5(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11);
    }

    public static /* synthetic */ void $r8$lambda$IUINkZ7I6J3pM0vNnpLeqDAjDCk(SyncManager r0, Account r1, int r2) {
        r0.lambda$new$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$O-rCqIKduPt_pMNS4QFjC5FeAVA, reason: not valid java name */
    public static /* synthetic */ void m3145$r8$lambda$OrCqIKduPt_pMNS4QFjC5FeAVA(StringBuilder r0, PrintTable r1, String r2, SyncStatusInfo.Stats r3, Function r4, Integer r5) {
        lambda$dumpSyncState$10(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ int $r8$lambda$R0xpzWqXmkDijrMVCn91JqHTBkc(SyncOperation r0, SyncOperation r1) {
        return lambda$static$6(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$W-Rf2gPTxsU_UZt2y9rLu7Qfz_o, reason: not valid java name */
    public static /* synthetic */ void m3146$r8$lambda$WRf2gPTxsU_UZt2y9rLu7Qfz_o(SyncManager r0, int r1) {
        r0.lambda$onStartUser$1(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dPyf-q5frpsexnajfwNjG4gT3tw, reason: not valid java name */
    public static /* synthetic */ boolean m3147$r8$lambda$dPyfq5frpsexnajfwNjG4gT3tw(SyncOperation r0) {
        return lambda$dumpPendingSyncs$8(r0);
    }

    public static /* synthetic */ void $r8$lambda$jFzarcImKKFe8d2AAk_WZWxA9g4(SyncManager r0, int r1) {
        r0.lambda$onStopUser$3(r1);
    }

    public static /* synthetic */ void $r8$lambda$stKFIA2giNVVLgh3fNVz1esLG_U(SyncManager r0, int r1) {
        r0.lambda$onUnlockUser$2(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$yUPmmbaGAWh9wrCtMIlUof1muoU(SyncOperation r0) {
        return lambda$dumpPeriodicSyncs$9(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$z19hP-i8qOq4IlIaakNmxfVyuKg, reason: not valid java name */
    public static /* synthetic */ int m3148$r8$lambda$z19hPi8qOq4IlIaakNmxfVyuKg(SyncOperation r0, SyncOperation r1) {
        return lambda$static$7(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccountManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccountManagerInternal m3149$$Nest$fgetmAccountManagerInternal(SyncManager r0) {
        return r0.mAccountManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAccountsLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m3150$$Nest$fgetmAccountsLock(SyncManager r0) {
        return r0.mAccountsLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBatteryStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBatteryStats m3151$$Nest$fgetmBatteryStats(SyncManager r0) {
        return r0.mBatteryStats;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConstants, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncManagerConstants m3152$$Nest$fgetmConstants(SyncManager r0) {
        return r0.mConstants;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3153$$Nest$fgetmContext(SyncManager r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDataConnectionIsConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3154$$Nest$fgetmDataConnectionIsConnected(SyncManager r0) {
        return r0.mDataConnectionIsConnected;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncLogger m3155$$Nest$fgetmLogger(SyncManager r0) {
        return r0.mLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationMgr, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManager m3156$$Nest$fgetmNotificationMgr(SyncManager r0) {
        return r0.mNotificationMgr;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPowerManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager m3157$$Nest$fgetmPowerManager(SyncManager r0) {
        return r0.mPowerManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmProvisioned, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3158$$Nest$fgetmProvisioned(SyncManager r0) {
        return r0.mProvisioned;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRunningAccounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccountAndUser[] m3159$$Nest$fgetmRunningAccounts(SyncManager r0) {
        return r0.mRunningAccounts;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSyncHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncHandler m3160$$Nest$fgetmSyncHandler(SyncManager r0) {
        return r0.mSyncHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSyncManagerWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeLock m3161$$Nest$fgetmSyncManagerWakeLock(SyncManager r0) {
        return r0.mSyncManagerWakeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSyncStorageEngine, reason: not valid java name */
    static /* bridge */ /* synthetic */ SyncStorageEngine m3162$$Nest$fgetmSyncStorageEngine(SyncManager r0) {
        return r0.mSyncStorageEngine;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDataConnectionIsConnected, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3163$$Nest$fputmDataConnectionIsConnected(SyncManager r0, boolean r1) {
        r0.mDataConnectionIsConnected = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmProvisioned, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3164$$Nest$fputmProvisioned(SyncManager r0, boolean r1) {
        r0.mProvisioned = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRunningAccounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3165$$Nest$fputmRunningAccounts(SyncManager r0, AccountAndUser[] r1) {
        r0.mRunningAccounts = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelJob, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3166$$Nest$mcancelJob(SyncManager r0, SyncOperation r1, String r2) {
        r0.cancelJob(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearAllBackoffs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3167$$Nest$mclearAllBackoffs(SyncManager r0, String r1) {
        r0.clearAllBackoffs(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mclearBackoffSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3168$$Nest$mclearBackoffSetting(SyncManager r0, SyncStorageEngine.EndPoint r1, String r2) {
        r0.clearBackoffSetting(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mcontainsAccountAndUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3169$$Nest$mcontainsAccountAndUser(SyncManager r0, AccountAndUser[] r1, Account r2, int r3) {
        return r0.containsAccountAndUser(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetAllPendingSyncs, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m3170$$Nest$mgetAllPendingSyncs(SyncManager r0) {
        return r0.getAllPendingSyncs();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetContextForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m3171$$Nest$mgetContextForUser(SyncManager r0, UserHandle r1) {
        return r0.getContextForUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetJobStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3172$$Nest$mgetJobStats(SyncManager r0) {
        return r0.getJobStats();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTotalBytesTransferredByUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m3173$$Nest$mgetTotalBytesTransferredByUid(SyncManager r0, int r1) {
        return r0.getTotalBytesTransferredByUid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mincreaseBackoffSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3174$$Nest$mincreaseBackoffSetting(SyncManager r0, SyncStorageEngine.EndPoint r1) {
        r0.increaseBackoffSetting(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misAdapterDelayed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3175$$Nest$misAdapterDelayed(SyncManager r0, SyncStorageEngine.EndPoint r1) {
        return r0.isAdapterDelayed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misDeviceProvisioned, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3176$$Nest$misDeviceProvisioned(SyncManager r0) {
        return r0.isDeviceProvisioned();
    }

    /* JADX INFO: renamed from: -$$Nest$misPackageStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3177$$Nest$misPackageStopped(SyncManager r0, String r1, int r2) {
        return r0.isPackageStopped(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misSyncStillActiveH, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3178$$Nest$misSyncStillActiveH(SyncManager r0, ActiveSyncContext r1) {
        return r0.isSyncStillActiveH(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeRescheduleSync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3179$$Nest$mmaybeRescheduleSync(SyncManager r0, SyncResult r1, SyncOperation r2) {
        r0.maybeRescheduleSync(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3180$$Nest$monUserRemoved(SyncManager r0, int r1) {
        r0.onUserRemoved(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserStopped, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3181$$Nest$monUserStopped(SyncManager r0, int r1) {
        r0.onUserStopped(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monUserUnlocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3182$$Nest$monUserUnlocked(SyncManager r0, int r1) {
        r0.onUserUnlocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostMonitorSyncProgressMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3183$$Nest$mpostMonitorSyncProgressMessage(SyncManager r0, ActiveSyncContext r1) {
        r0.postMonitorSyncProgressMessage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mpostScheduleSyncMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3184$$Nest$mpostScheduleSyncMessage(SyncManager r0, SyncOperation r1, long r2) {
        r0.postScheduleSyncMessage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mreadDataConnectionState, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3185$$Nest$mreadDataConnectionState(SyncManager r0) {
        return r0.readDataConnectionState();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveStaleAccounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3186$$Nest$mremoveStaleAccounts(SyncManager r0) {
        r0.removeStaleAccounts();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveSyncsForAuthority, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3187$$Nest$mremoveSyncsForAuthority(SyncManager r0, SyncStorageEngine.EndPoint r1, String r2) {
        r0.removeSyncsForAuthority(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleSyncOperationH, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3188$$Nest$mscheduleSyncOperationH(SyncManager r0, SyncOperation r1) {
        r0.scheduleSyncOperationH(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleSyncOperationH, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3189$$Nest$mscheduleSyncOperationH(SyncManager r0, SyncOperation r1, long r2) {
        r0.scheduleSyncOperationH(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msendSyncFinishedOrCanceledMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3190$$Nest$msendSyncFinishedOrCanceledMessage(SyncManager r0, ActiveSyncContext r1, SyncResult r2) {
        r0.sendSyncFinishedOrCanceledMessage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetAuthorityPendingState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3191$$Nest$msetAuthorityPendingState(SyncManager r0, SyncStorageEngine.EndPoint r1) {
        r0.setAuthorityPendingState(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDelayUntilTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3192$$Nest$msetDelayUntilTime(SyncManager r0, SyncStorageEngine.EndPoint r1, long r2) {
        r0.setDelayUntilTime(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateRunningAccounts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3193$$Nest$mupdateRunningAccounts(SyncManager r0, SyncStorageEngine.EndPoint r1) {
        r0.updateRunningAccounts(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mverifyJobScheduler, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3194$$Nest$mverifyJobScheduler(SyncManager r0) {
        r0.verifyJobScheduler();
    }

    /* JADX INFO: renamed from: -$$Nest$mwasPackageEverLaunched, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m3195$$Nest$mwasPackageEverLaunched(SyncManager r0, String r1, int r2) {
        return r0.wasPackageEverLaunched(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSYNC_ADAPTER_CONNECTION_FLAGS, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context.BindServiceFlags m3196$$Nest$sfgetSYNC_ADAPTER_CONNECTION_FLAGS() {
        return SYNC_ADAPTER_CONNECTION_FLAGS;
    }

    static {
        ENABLE_SUSPICIOUS_CHECK = Build.IS_DEBUGGABLE;
        LOCAL_SYNC_DELAY = SystemProperties.getLong("sync.local_sync_delay", 30000);
        SYNC_ADAPTER_CONNECTION_FLAGS = Context.BindServiceFlags.of(21);
        INITIAL_ACCOUNTS_ARRAY = new AccountAndUser[0];
        sOpDumpComparator = new SyncManager$$ExternalSyntheticLambda2();
        sOpRuntimeComparator = new SyncManager$$ExternalSyntheticLambda3();
    }

    private boolean isJobIdInUseLockedH(int jobId, List<JobInfo> pendingJobs) {
        int i = 0;
        int size = pendingJobs.size();
    L4:
        if (i >= size) goto L9;
        JobInfo job = pendingJobs.get(i);
        if (job.getId() == jobId) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L9:
        int i2 = 0;
        int size2 = this.mActiveSyncContexts.size();
    L10:
        if (i2 >= size2) goto L15;
        ActiveSyncContext asc = this.mActiveSyncContexts.get(i2);
        if (asc.mSyncOperation.jobId == jobId) goto L13;
        i2 = i2 + 1;
        goto L10
    L13:
        return true;
    L15:
        return false;
    }

    private int getUnusedJobIdH() {
        List<JobInfo> pendingJobs = this.mJobScheduler.getAllPendingJobs();
    L4:
        if (isJobIdInUseLockedH(this.mNextJobId, pendingJobs) == false) goto L7;
        this.mNextJobId++;
        goto L4
    L7:
        return this.mNextJobId;
    }

    private List<SyncOperation> getAllPendingSyncs() {
        verifyJobScheduler();
        List<JobInfo> pendingJobs = this.mJobScheduler.getAllPendingJobs();
        int numJobs = pendingJobs.size();
        List<SyncOperation> pendingSyncs = new ArrayList(numJobs);
        int i = 0;
    L3:
        if (i >= numJobs) goto L10;
        JobInfo job = pendingJobs.get(i);
        SyncOperation op = SyncOperation.maybeCreateFromJobExtras(job.getExtras());
        if (op == null) goto L7;
        pendingSyncs.add(op);
    L8:
        i = i + 1;
        goto L3
    L7:
        Slog.wtf("SyncManager", "Non-sync job inside of SyncManager's namespace");
        goto L8
    L10:
        return pendingSyncs;
    }

    private List<UserInfo> getAllUsers() {
        return this.mUserManager.getUsers();
    }

    private boolean containsAccountAndUser(AccountAndUser[] accounts, Account account, int userId) {
        int i = 0;
    L4:
        if (i >= accounts.length) goto L16;
        if (accounts[i].userId != userId) goto L10;
        if (accounts[i].account.equals(account) == false) goto L10;
        return true;
    L10:
        i = i + 1;
        goto L4
    L16:
        return false;
    }

    private void updateRunningAccounts(SyncStorageEngine.EndPoint target) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.v("SyncManager", "sending MESSAGE_ACCOUNTS_UPDATED");
    L5:
        Message m = this.mSyncHandler.obtainMessage(9);
        m.obj = target;
        m.sendToTarget();
    }

    private void removeStaleAccounts() {
        Iterator r0 = this.mUserManager.getAliveUsers().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        UserInfo user = (UserInfo) r0.next();
        if (user.partial == true) goto L4;
        Account[] accountsForUser = AccountManagerService.getSingleton().getAccounts(user.id, this.mContext.getOpPackageName());
        this.mSyncStorageEngine.removeStaleAccounts(accountsForUser, user.id);
        goto L4
    }

    private void clearAllBackoffs(String why) {
        this.mSyncStorageEngine.clearAllBackoffsLocked();
        rescheduleSyncs(SyncStorageEngine.EndPoint.USER_ALL_PROVIDER_ALL_ACCOUNTS_ALL, why);
    }

    private boolean readDataConnectionState() {
        NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
        if (networkInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (networkInfo.isConnected() == false) goto L7;
        return true;
    }

    private String getJobStats() {
        JobSchedulerInternal js = (JobSchedulerInternal) LocalServices.getService(JobSchedulerInternal.class);
        StringBuilder r1 = new StringBuilder();
        r1.append("JobStats: ");
        if (js != null) goto L5;
        String r2 = "(JobSchedulerInternal==null)";
    L6:
        r1.append(r2);
        return r1.toString();
    L5:
        r2 = js.getPersistStats().toString();
        goto L6
    }

    private ConnectivityManager getConnectivityManager() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mConnManagerDoNotUseDirectly != null) goto L8;
        this.mConnManagerDoNotUseDirectly = (ConnectivityManager) this.mContext.getSystemService("connectivity");     // Catch: Throwable -> L6
    L8:
        ConnectivityManager r0 = this.mConnManagerDoNotUseDirectly;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    }

    private void cleanupJobs() {
        this.mSyncHandler.postAtFrontOfQueue(new AnonymousClass6(this));
    }

    private void migrateSyncJobNamespaceIfNeeded() {
        boolean namespaceMigrated = this.mSyncStorageEngine.isJobNamespaceMigrated();
        boolean attributionFixed = this.mSyncStorageEngine.isJobAttributionFixed();
        if (namespaceMigrated == false) goto L6;
        if (attributionFixed == false) goto L6;
        return;
    L6:
        JobScheduler jobSchedulerDefaultNamespace = (JobScheduler) this.mContext.getSystemService(JobScheduler.class);
        if (namespaceMigrated == true) goto L15;
        List<JobInfo> pendingJobs = jobSchedulerDefaultNamespace.getAllPendingJobs();
        boolean allSyncsMigrated = true;
        int i = pendingJobs.size() - 1;
    L9:
        if (i < 0) goto L14;
        JobInfo job = pendingJobs.get(i);
        SyncOperation op = SyncOperation.maybeCreateFromJobExtras(job.getExtras());
        if (op == null) goto L13;
        this.mJobScheduler.scheduleAsPackage(job, op.owningPackage, op.target.userId, op.wakeLockName());
        jobSchedulerDefaultNamespace.cancel(job.getId());
        allSyncsMigrated = false;
    L13:
        i = i - 1;
        goto L9
    L14:
        this.mSyncStorageEngine.setJobNamespaceMigrated(allSyncsMigrated);
    L15:
        List<JobInfo> namespacedJobs = ((JobSchedulerInternal) LocalServices.getService(JobSchedulerInternal.class)).getSystemScheduledOwnJobs(this.mJobScheduler.getNamespace());
        boolean allSyncsAttributed = true;
        int i2 = namespacedJobs.size() - 1;
    L16:
        if (i2 < 0) goto L21;
        JobInfo job2 = namespacedJobs.get(i2);
        SyncOperation op2 = SyncOperation.maybeCreateFromJobExtras(job2.getExtras());
        if (op2 == null) goto L20;
        this.mJobScheduler.scheduleAsPackage(job2, op2.owningPackage, op2.target.userId, op2.wakeLockName());
        allSyncsAttributed = false;
    L20:
        i2 = i2 - 1;
        goto L16
    L21:
        this.mSyncStorageEngine.setJobAttributionFixed(allSyncsAttributed);
    }

    private synchronized void verifyJobScheduler() {
        monitor-enter(this);
    L34:
        th = move-exception;
        throw th;
    L4:
        if (this.mJobScheduler == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L34
    L36:
        th = th;
    L37:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L9:
        if (Log.isLoggable("SyncManager", 2) == true) goto L42;
    L14:
        this.mJobScheduler = ((JobScheduler) this.mContext.getSystemService(JobScheduler.class)).forNamespace("SyncManager");     // Catch: Throwable -> L36
        migrateSyncJobNamespaceIfNeeded();     // Catch: Throwable -> L36
        List<JobInfo> pendingJobs = this.mJobScheduler.getAllPendingJobs();     // Catch: Throwable -> L36
        int numPersistedPeriodicSyncs = 0;
        int numPersistedOneshotSyncs = 0;
        Iterator<JobInfo> r5 = pendingJobs.iterator();     // Catch: Throwable -> L36
    L16:
        if (r5.hasNext() == false) goto L25;
        JobInfo job = r5.next();     // Catch: Throwable -> L12
        SyncOperation op = SyncOperation.maybeCreateFromJobExtras(job.getExtras());     // Catch: Throwable -> L12
        if (op != null) goto L20;
        Slog.wtf("SyncManager", "Non-sync job inside of SyncManager namespace");     // Catch: Throwable -> L12
        goto L16
    L20:
        if (op.isPeriodic == true) goto L21;
        numPersistedOneshotSyncs = numPersistedOneshotSyncs + 1;     // Catch: Throwable -> L12
        this.mSyncStorageEngine.markPending(op.target, true);     // Catch: Throwable -> L12
        goto L16
    L21:
        numPersistedPeriodicSyncs = numPersistedPeriodicSyncs + 1;     // Catch: Throwable -> L12
        goto L16
    L25:
        String summary = "Loaded persisted syncs: " + numPersistedPeriodicSyncs + " periodic syncs, " + numPersistedOneshotSyncs + " oneshot syncs, " + pendingJobs.size() + " total system server jobs, " + getJobStats();     // Catch: Throwable -> L36
        Slog.i("SyncManager", summary);     // Catch: Throwable -> L36
        this.mLogger.log(new Object[]{summary});     // Catch: Throwable -> L36
        cleanupJobs();     // Catch: Throwable -> L36
        if (ENABLE_SUSPICIOUS_CHECK == false) goto L31;
        if (numPersistedPeriodicSyncs != 0) goto L31;
        if (likelyHasPeriodicSyncs() == false) goto L31;
        Slog.wtf("SyncManager", "Device booted with no persisted periodic syncs: " + summary);     // Catch: Throwable -> L12
    L12:
        th = th;
    L31:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L34
        monitor-exit(this);
        return;
    L42:
        Log.d("SyncManager", "initializing JobScheduler object.");     // Catch: Throwable -> L12
        goto L14
    }

    private boolean likelyHasPeriodicSyncs() {
        if (this.mSyncStorageEngine.getAuthorityCount() < 6) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    private JobScheduler getJobScheduler() {
        verifyJobScheduler();
        return this.mJobScheduler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SyncManager(Context r12, boolean r13) {
        this.mAccountsLock = new Object();
        this.mRunningAccounts = INITIAL_ACCOUNTS_ARRAY;
        this.mDataConnectionIsConnected = false;
        this.mNextJobId = 0;
        this.mActiveSyncContexts = Lists.newArrayList();
        this.mAccountsUpdatedReceiver = new AnonymousClass1(this);
        this.mConnectivityIntentReceiver = new AnonymousClass2(this);
        this.mShutdownIntentReceiver = new AnonymousClass3(this);
        this.mOtherIntentsReceiver = new AnonymousClass4(this);
        this.mUserIntentReceiver = new AnonymousClass5(this);
        this.mUnlockedUsers = new SparseBooleanArray();
        monitor-enter(SyncManager.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = this;     // Catch: Throwable -> L7
    L10:
        monitor-exit(SyncManager.class);     // Catch: Throwable -> L7
        this.mContext = r12;
        this.mLogger = SyncLogger.getInstance();
        SyncStorageEngine.init(r12, BackgroundThread.get().getLooper());
        this.mSyncStorageEngine = SyncStorageEngine.getSingleton();
        this.mSyncStorageEngine.setOnSyncRequestListener(new AnonymousClass7(this));
        this.mSyncStorageEngine.setPeriodicSyncAddedListener(new AnonymousClass8(this));
        this.mSyncStorageEngine.setOnAuthorityRemovedListener(new AnonymousClass9(this));
        this.mSyncAdapters = new SyncAdaptersCache(this.mContext);
        this.mThread = new HandlerThread("SyncManager", 10);
        this.mThread.start();
        this.mSyncHandler = new SyncHandler(this, this.mThread.getLooper());
        this.mSyncAdapters.setListener(new AnonymousClass10(this), this.mSyncHandler);
        this.mConstants = new SyncManagerConstants(r12);
        this.mAppCloningDeviceConfigHelper = AppCloningDeviceConfigHelper.getInstance(r12);
        r12.registerReceiver(this.mConnectivityIntentReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter r2 = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        r2.setPriority(1000);
        r12.registerReceiver(this.mShutdownIntentReceiver, r2);
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.USER_REMOVED");
        r1.addAction("android.intent.action.USER_UNLOCKED");
        r1.addAction("android.intent.action.USER_STOPPED");
        this.mContext.registerReceiverAsUser(this.mUserIntentReceiver, UserHandle.ALL, r1, null, null);
        Object[] r3 = 0;
        this.mPackageMonitor = new PackageMonitorImpl(null);
        this.mPackageMonitor.register(this.mContext, null, UserHandle.ALL, false);
        r12.registerReceiver(this.mOtherIntentsReceiver, new IntentFilter("android.intent.action.TIME_SET"));
        if (r13 == true) goto L14;
        this.mNotificationMgr = (NotificationManager) r12.getSystemService("notification");
    L15:
        this.mPowerManager = (PowerManager) r12.getSystemService("power");
        this.mUserManager = (UserManager) this.mContext.getSystemService("user");
        this.mAccountManager = (AccountManager) this.mContext.getSystemService("account");
        this.mAccountManagerInternal = getAccountManagerInternal();
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mAmi = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mAccountManagerInternal.addOnAppPermissionChangeListener(new SyncManager$$ExternalSyntheticLambda1(this));
        this.mBatteryStats = IBatteryStats.Stub.asInterface(ServiceManager.getService("batterystats"));
        this.mSyncManagerWakeLock = this.mPowerManager.newWakeLock(1, SYNC_LOOP_WAKE_LOCK);
        this.mSyncManagerWakeLock.setReferenceCounted(false);
        this.mProvisioned = isDeviceProvisioned();
        if (this.mProvisioned == true) goto L28;
        final ContentResolver r4 = r12.getContentResolver();
        final Object[] r5 = r3 == true ? 1 : 0;
        ContentObserver r6 = new AnonymousClass11(this, r5, r4);
        SyncHandler r7 = this.mSyncHandler;
        monitor-enter(r7);
        r4.registerContentObserver(Settings.Global.getUriFor("device_provisioned"), false, r6);     // Catch: Throwable -> L22
        this.mProvisioned |= isDeviceProvisioned();     // Catch: Throwable -> L22
        if (this.mProvisioned == false) goto L24;
        r4.unregisterContentObserver(r6);     // Catch: Throwable -> L22
    L24:
        monitor-exit(r7);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L28:
        if (r13 == true) goto L30;
        this.mContext.registerReceiverAsUser(this.mAccountsUpdatedReceiver, UserHandle.ALL, new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"), null, null);
    L30:
        allowListExistingSyncAdaptersIfNeeded();
        this.mLogger.log(new Object[]{"Sync manager initialized: " + Build.FINGERPRINT});
        return;
    L14:
        this.mNotificationMgr = null;
        goto L15
    L9:
        Slog.wtf("SyncManager", "SyncManager instantiated multiple times");     // Catch: Throwable -> L7
        goto L10
    }

    private /* synthetic */ void lambda$new$0(Account account, int uid) {
        if (this.mAccountManagerInternal.hasAccountAccess(account, uid) == false) goto L6;
        scheduleSync(account, UserHandle.getUserId(uid), -2, null, null, 3, 0, Process.myUid(), -2, null);
        return;
    }

    protected AccountManagerInternal getAccountManagerInternal() {
        return (AccountManagerInternal) LocalServices.getService(AccountManagerInternal.class);
    }

    private /* synthetic */ void lambda$onStartUser$1(int userId) {
        this.mLogger.log(new Object[]{"onStartUser: user=", Integer.valueOf(userId)});
    }

    public void onStartUser(final int userId) {
        this.mSyncHandler.post(new SyncManager$$ExternalSyntheticLambda4(this, userId));
    }

    public void onUnlockUser(final int userId) {
        SparseBooleanArray r0 = this.mUnlockedUsers;
        monitor-enter(r0);
        this.mUnlockedUsers.put(userId, true);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mSyncHandler.post(new SyncManager$$ExternalSyntheticLambda10(this, userId));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onUnlockUser$2(int userId) {
        this.mLogger.log(new Object[]{"onUnlockUser: user=", Integer.valueOf(userId)});
    }

    public void onStopUser(final int userId) {
        SparseBooleanArray r0 = this.mUnlockedUsers;
        monitor-enter(r0);
        this.mUnlockedUsers.put(userId, false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mSyncHandler.post(new SyncManager$$ExternalSyntheticLambda9(this, userId));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onStopUser$3(int userId) {
        this.mLogger.log(new Object[]{"onStopUser: user=", Integer.valueOf(userId)});
    }

    private boolean isUserUnlocked(int userId) {
        SparseBooleanArray r0 = this.mUnlockedUsers;
        monitor-enter(r0);
        boolean r1 = this.mUnlockedUsers.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public void onBootPhase(int phase) {
        switch(phase) {
            case 550: goto L4;
            default: goto L6;
        };
    L4:
        this.mConstants.start();
        return;
    }

    private void allowListExistingSyncAdaptersIfNeeded() {
        SyncManager r0 = this;
        if (r0.mSyncStorageEngine.shouldGrantSyncAdaptersAccountAccess() == true) goto L5;
        return;
    L5:
        List<UserInfo> users = r0.mUserManager.getAliveUsers();
        int userCount = users.size();
        int i = 0;
    L6:
        if (i >= userCount) goto L20;
        UserHandle userHandle = users.get(i).getUserHandle();
        int userId = userHandle.getIdentifier();
        Iterator r6 = r0.mSyncAdapters.getAllServices(userId).iterator();
    L9:
        if (r6.hasNext() == false) goto L18;
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> service = (RegisteredServicesCache.ServiceInfo) r6.next();
        String packageName = service.componentName.getPackageName();
        Account[] r9 = r0.mAccountManager.getAccountsByTypeAsUser(((SyncAdapterType) service.type).accountType, userHandle);
        int r10 = r9.length;
        int r11 = 0;
    L12:
        if (r11 >= r10) goto L17;
        Account account = r9[r11];
        if (r0.canAccessAccount(account, packageName, userId) == true) goto L16;
        r0.mAccountManager.updateAppPermission(account, "com.android.AccountManager.ACCOUNT_ACCESS_TOKEN_TYPE", service.uid, true);
    L16:
        r11 = r11 + 1;
        r0 = this;
        goto L12
    L17:
        r0 = this;
        goto L9
    L18:
        i = i + 1;
        r0 = this;
        goto L6
    }

    private boolean isDeviceProvisioned() {
        ContentResolver resolver = this.mContext.getContentResolver();
        if (Settings.Global.getInt(resolver, "device_provisioned", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private long jitterize(long minValue, long maxValue) {
        Random random = new Random(SystemClock.elapsedRealtime());
        long spread = maxValue - minValue;
        if (spread > 2147483647L) goto L7;
        return ((long) random.nextInt((int) spread)) + minValue;
    L7:
        throw new IllegalArgumentException("the difference between the maxValue and the minValue must be less than 2147483647");
    }

    public SyncStorageEngine getSyncStorageEngine() {
        return this.mSyncStorageEngine;
    }

    private boolean areContactWritesEnabledForUser(UserInfo userInfo) {
        UserManager um = UserManager.get(this.mContext);
        UserProperties userProperties = um.getUserProperties(userInfo.getUserHandle());     // Catch: IllegalArgumentException -> L6
        return !userProperties.getUseParentsContacts();
    L7:
        Log.w("SyncManager", "Trying to fetch user properties for non-existing/partial user " + userInfo.getUserHandle());
        return false;
    }

    protected boolean isContactSharingAllowedForCloneProfile() {
        if (this.mContext.getResources().getBoolean(R.bool.config_enableBurnInProtection) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAppCloningDeviceConfigHelper.getEnableAppCloningBuildingBlocks() == false) goto L7;
        return true;
    }

    protected boolean shouldDisableSyncForUser(UserInfo userInfo, String providerName) {
        if (userInfo == null) goto L15;
        if (providerName == null) goto L15;
        if (isContactSharingAllowedForCloneProfile() == false) goto L15;
        if (providerName.equals("com.android.contacts") == true) goto L11;
        return false;
    L11:
        if (areContactWritesEnabledForUser(userInfo) == true) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    }

    private int getIsSyncable(Account account, int userId, String providerName) {
        int isSyncable = this.mSyncStorageEngine.getIsSyncable(account, userId, providerName);
        UserManager um = UserManager.get(this.mContext);
        UserInfo userInfo = um.getUserInfo(userId);
        if (shouldDisableSyncForUser(userInfo, providerName) == false) goto L6;
        Log.w("SyncManager", "Account sync is disabled for account: " + account + " userId: " + userId + " provider: " + providerName);
        return 0;
    L6:
        if (userInfo != null) goto L8;
    L25:
        return isSyncable;
    L8:
        if (userInfo.isRestricted() == false) goto L25;
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = this.mSyncAdapters.getServiceInfo(SyncAdapterType.newKey(providerName, account.type), userId);
        if (syncAdapterInfo != null) goto L26;
        return 0;
    L26:
        PackageInfo pInfo = AppGlobals.getPackageManager().getPackageInfo(syncAdapterInfo.componentName.getPackageName(), 0, userId);     // Catch: RemoteException -> L23
        if (pInfo != null) goto L18;
        return 0;
    L18:
        if (pInfo.restrictedAccountType != null) goto L20;
    L22:
        return 0;
    L20:
        if (pInfo.restrictedAccountType.equals(account.type) == false) goto L22;
        return isSyncable;
    L24:
        return 0;
    }

    private void setAuthorityPendingState(SyncStorageEngine.EndPoint info) {
        List<SyncOperation> ops = getAllPendingSyncs();
        Iterator<SyncOperation> r1 = ops.iterator();
    L4:
        if (r1.hasNext() == false) goto L12;
        SyncOperation op = r1.next();
        if (op.isPeriodic == true) goto L4;
        if (op.target.matchesSpec(info) == false) goto L4;
        getSyncStorageEngine().markPending(info, true);
        return;
    L12:
        getSyncStorageEngine().markPending(info, false);
    }

    public void scheduleSync(Account requestedAccount, int userId, int reason, String requestedAuthority, Bundle extras, int targetSyncState, int syncExemptionFlag, int callingUid, int callingPid, String callingPackage) {
        scheduleSync(requestedAccount, userId, reason, requestedAuthority, extras, targetSyncState, 0, true, syncExemptionFlag, callingUid, callingPid, callingPackage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v20 */
    private void scheduleSync(Account requestedAccount, int userId, final int reason, String requestedAuthority, Bundle extras, final int targetSyncState, final long minDelayMillis, boolean checkIfAccountReady, final int syncExemptionFlag, final int callingUid, final int callingPid, final String callingPackage) {
        final SyncManager r1 = this;
        if (extras != null) goto L5;
        Bundle extras2 = new Bundle();
    L6:
        extras2.size();
        if (Log.isLoggable("SyncManager", 2) == false) goto L9;
        Bundle extras3 = extras2;
        Account r14 = requestedAccount;
        String r15 = requestedAuthority;
        Bundle extras4 = extras3;
        r1.mLogger.log(new Object[]{"scheduleSync: account=", requestedAccount, " u", Integer.valueOf(userId), " authority=", requestedAuthority, " reason=", Integer.valueOf(reason), " extras=", extras3, " cuid=", Integer.valueOf(callingUid), " cpid=", Integer.valueOf(callingPid), " cpkg=", callingPackage, " mdm=", Long.valueOf(minDelayMillis), " ciar=", Boolean.valueOf(checkIfAccountReady), " sef=", Integer.valueOf(syncExemptionFlag)});
    L10:
        AccountAndUser[] accounts = null;
        Object r3 = r1.mAccountsLock;
        monitor-enter(r3);
        int isSyncable = -1;
        String packageName = null;
        if (r14 == null) goto L27;
        int r10 = userId;
        if (r10 == (-1)) goto L19;
        AccountAndUser[] accounts2 = {new AccountAndUser(r14, r10)};     // Catch: Throwable -> L17
    L131:
        monitor-exit(r3);     // Catch: Throwable -> L123
        if (ArrayUtils.isEmpty(accounts2) == false) goto L34;
        return;
    L34:
        boolean uploadOnly = extras4.getBoolean("upload", false);
        boolean manualSync = extras4.getBoolean("force", false);
        if (manualSync == false) goto L37;
        extras4.putBoolean("ignore_backoff", true);
        extras4.putBoolean("ignore_settings", true);
    L37:
        boolean ignoreSettings = extras4.getBoolean("ignore_settings", false);
        if (uploadOnly == false) goto L40;
        int source = 1;
    L48:
        int r12 = accounts2.length;
        int r13 = 0;
    L49:
        if (r13 >= r12) goto L122;
        final AccountAndUser account = accounts2[r13];
        if (r10 >= 0) goto L53;
    L57:
        HashSet<String> syncableAuthorities = new HashSet();
        Iterator r4 = r1.mSyncAdapters.getAllServices(account.userId).iterator();
    L59:
        if (r4.hasNext() == false) goto L61;
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapter = (RegisteredServicesCache.ServiceInfo) r4.next();
        syncableAuthorities.add(((SyncAdapterType) syncAdapter.type).authority);
        goto L59
    L61:
        if (r15 == null) goto L65;
        boolean hasSyncAdapter = syncableAuthorities.contains(r15);
        syncableAuthorities.clear();
        if (hasSyncAdapter == false) goto L65;
        syncableAuthorities.add(r15);
    L65:
        Iterator<String> r30 = syncableAuthorities.iterator();
    L67:
        if (r30.hasNext() == false) goto L120;
        final String authority = r30.next();
        AccountAndUser account2 = account;
        syncableAuthorities = syncableAuthorities;
        int isSyncable2 = r1.computeSyncable(account.account, account.userId, authority, !checkIfAccountReady, true);
        if (isSyncable2 == 0) goto L70;
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = r1.mSyncAdapters.getServiceInfo(SyncAdapterType.newKey(authority, account2.account.type), account2.userId);
        if (syncAdapterInfo == null) goto L73;
        int owningUid = syncAdapterInfo.uid;
        if (isSyncable2 == 3) goto L76;
        Bundle extras5 = extras4;
        String r39 = packageName;
        AccountAndUser[] accounts3 = accounts2;
        int r43 = r12;
        int r44 = r13;
        account = account2;
        int r16 = r10;
        boolean allowParallelSyncs = ((SyncAdapterType) syncAdapterInfo.type).allowParallelSyncs();
        boolean isAlwaysSyncable = ((SyncAdapterType) syncAdapterInfo.type).isAlwaysSyncable();
        if (checkIfAccountReady == true) goto L85;
        if (isSyncable2 >= 0) goto L85;
        if (isAlwaysSyncable == false) goto L85;
        r1.mSyncStorageEngine.setIsSyncable(account.account, account.userId, authority, 1, callingUid, callingPid);
        int isSyncable3 = 1;
    L87:
        if (targetSyncState == (-2)) goto L91;
        if (targetSyncState == isSyncable3) goto L91;
        r10 = r16;
        packageName = r39;
        extras4 = extras5;
        accounts2 = accounts3;
        r12 = r43;
        r13 = r44;
        isSyncable = -1;
    L91:
        if (((SyncAdapterType) syncAdapterInfo.type).supportsUploading() == true) goto L94;
        if (uploadOnly == false) goto L94;
        r10 = r16;
        packageName = r39;
        extras4 = extras5;
        accounts2 = accounts3;
        r12 = r43;
        r13 = r44;
        isSyncable = -1;
    L94:
        if (isSyncable3 < 0) goto L102;
        if (ignoreSettings == true) goto L102;
        if (r1.mSyncStorageEngine.getMasterSyncAutomatically(account.userId) == true) goto L99;
    L101:
        ?? r8 = r39;
    L104:
        if (r8 == 0) goto L105;
        SyncStorageEngine.EndPoint info = new SyncStorageEngine.EndPoint(account.account, authority, account.userId);
        r1.mSyncStorageEngine.getDelayUntilTime(info);
        String owningPackage = syncAdapterInfo.componentName.getPackageName();
        if (isSyncable3 != (-1)) goto L111;
        if (checkIfAccountReady == false) goto L110;
        final Bundle finalExtras = new Bundle(extras5);
        int r41 = -1;
        AccountAndUser account3 = account;
        SyncManager r17 = r1;
        sendOnUnsyncableAccount(r1.mContext, syncAdapterInfo, account.userId, new SyncManager$$ExternalSyntheticLambda7(r1, account, reason, authority, finalExtras, targetSyncState, minDelayMillis, syncExemptionFlag, callingUid, callingPid, callingPackage));
        int source2 = source;
    L119:
        r10 = userId;
        account = account3;
        source = source2;
        r1 = r17;
        packageName = r39;
        extras4 = extras5;
        isSyncable = r41;
        accounts2 = accounts3;
        r12 = r43;
        r13 = r44;
        goto L67
    L110:
        r17 = r1;
        account3 = account;
        r41 = -1;
        Bundle newExtras = new Bundle();
        newExtras.putBoolean("initialize", true);
        r17.mLogger.log(new Object[]{"scheduleSync: schedule initialisation sync ", account3, " ", authority});
        source2 = source;
        r17.postScheduleSyncMessage(new SyncOperation(account3.account, account3.userId, owningUid, owningPackage, reason, source, authority, newExtras, allowParallelSyncs, syncExemptionFlag), minDelayMillis);
        goto L119
    L111:
        int isSyncable4 = isSyncable3;
        r17 = r1;
        account3 = account;
        r41 = -1;
        source2 = source;
        if (targetSyncState == (-2)) goto L118;
        if (targetSyncState == isSyncable4) goto L118;
        r17.mLogger.log(new Object[]{"scheduleSync: not handling ", account3, " ", authority});
    L118:
        r17.mLogger.log(new Object[]{"scheduleSync: scheduling sync ", account3, " ", authority});
        r17.postScheduleSyncMessage(new SyncOperation(account3.account, account3.userId, owningUid, owningPackage, reason, source2, authority, extras5, allowParallelSyncs, syncExemptionFlag), minDelayMillis);
        goto L119
    L105:
        r1.mLogger.log(new Object[]{"scheduleSync: sync of ", account, " ", authority, " is not allowed, dropping request"});
        r10 = r16;
        packageName = r39;
        extras4 = extras5;
        accounts2 = accounts3;
        r12 = r43;
        r13 = r44;
        isSyncable = -1;
        goto L67
    L99:
        if (r1.mSyncStorageEngine.getSyncAutomatically(account.account, account.userId, authority) == false) goto L101;
    L102:
        r8 = 1;
    L85:
        isSyncable3 = isSyncable2;
        goto L87
    L76:
        r1.mLogger.log(new Object[]{"scheduleSync: Not scheduling sync operation: isSyncable == SYNCABLE_NO_ACCOUNT_ACCESS"});
        final Bundle finalExtras2 = new Bundle(extras4);
        String packageName2 = syncAdapterInfo.componentName.getPackageName();
        if (r1.wasPackageEverLaunched(packageName2, r10) == false) goto L78;
        account = account2;
        final int r5 = r10;
        r1.mAccountManagerInternal.requestAccountAccess(account2.account, packageName2, r5, new RemoteCallback(new SyncManager$$ExternalSyntheticLambda6(r1, account, r5, reason, authority, finalExtras2, targetSyncState, minDelayMillis, syncExemptionFlag, callingUid, callingPid, callingPackage)));
        r10 = r5;
        packageName = null;
        extras4 = extras4;
        accounts2 = accounts2;
        r12 = r12;
        r13 = r13;
        isSyncable = -1;
        goto L67
    L78:
        account = account2;
        isSyncable = -1;
        packageName = null;
        goto L67
    L73:
        account = account2;
        isSyncable = -1;
        goto L67
    L70:
        account = account2;
        isSyncable = -1;
        goto L67
    L120:
        int r42 = isSyncable;
    L121:
        r10 = userId;
        r15 = requestedAuthority;
        r13 = r13 + 1;
        source = source;
        r1 = r1;
        packageName = packageName;
        extras4 = extras4;
        isSyncable = r42;
        accounts2 = accounts2;
        r12 = r12;
        goto L49
    L53:
        if (account.userId < 0) goto L57;
        if (r10 == account.userId) goto L57;
        r42 = isSyncable;
        goto L121
    L122:
        return;
    L40:
        if (manualSync == false) goto L42;
        source = 3;
        goto L48
    L42:
        if (r15 != null) goto L45;
        source = 2;
        goto L48
    L45:
        if (extras4.containsKey("feed") == false) goto L47;
        source = 5;
        goto L48
    L47:
        source = 0;
    L123:
        th = th;
    L133:
        monitor-exit(r3);     // Catch: Throwable -> L129
        throw th;
    L129:
        th = th;
        goto L133
    L19:
        AccountAndUser[] r6 = r1.mRunningAccounts;     // Catch: Throwable -> L17
        int r7 = r6.length;     // Catch: Throwable -> L17
        int r9 = 0;
    L20:
        if (r9 >= r7) goto L26;
        AccountAndUser runningAccount = r6[r9];     // Catch: Throwable -> L17
        if (r14.equals(runningAccount.account) == false) goto L25;
        accounts = (AccountAndUser[]) ArrayUtils.appendElement(AccountAndUser.class, accounts, runningAccount);     // Catch: Throwable -> L17
    L25:
        r9 = r9 + 1;
        goto L20
    L26:
        accounts2 = accounts;
    L17:
        th = th;
        goto L133
    L27:
        r10 = userId;
        AccountAndUser[] accounts4 = r1.mRunningAccounts;     // Catch: Throwable -> L125
        accounts2 = accounts4;
    L125:
        th = th;
        goto L133
    L9:
        r14 = requestedAccount;
        r15 = requestedAuthority;
        extras4 = extras2;
        goto L10
    L5:
        extras2 = extras;
        goto L6
    }

    private /* synthetic */ void lambda$scheduleSync$4(AccountAndUser account, int userId, int reason, String authority, Bundle finalExtras, int targetSyncState, long minDelayMillis, int syncExemptionFlag, int callingUid, int callingPid, String callingPackage, Bundle result) {
        if (result == null) goto L9;
        if (result.getBoolean("booleanResult") == false) goto L11;
        scheduleSync(account.account, userId, reason, authority, finalExtras, targetSyncState, minDelayMillis, true, syncExemptionFlag, callingUid, callingPid, callingPackage);
        return;
    L11:
        return;
    }

    private /* synthetic */ void lambda$scheduleSync$5(AccountAndUser account, int reason, String authority, Bundle finalExtras, int targetSyncState, long minDelayMillis, int syncExemptionFlag, int callingUid, int callingPid, String callingPackage) {
        scheduleSync(account.account, account.userId, reason, authority, finalExtras, targetSyncState, minDelayMillis, false, syncExemptionFlag, callingUid, callingPid, callingPackage);
    }

    public int computeSyncable(Account account, int userId, String authority, boolean checkAccountAccess, boolean checkStoppedState) {
        int status = getIsSyncable(account, userId, authority);
        if (status != 0) goto L5;
        return 0;
    L5:
        SyncAdapterType type = SyncAdapterType.newKey(authority, account.type);
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = this.mSyncAdapters.getServiceInfo(type, userId);
        if (syncAdapterInfo != null) goto L8;
        return 0;
    L8:
        int owningUid = syncAdapterInfo.uid;
        String owningPackage = syncAdapterInfo.componentName.getPackageName();
        if (checkStoppedState == false) goto L14;
        if (isPackageStopped(owningPackage, userId) == false) goto L14;
        return 0;
    L14:
        if (this.mAmi.isAppStartModeDisabled(owningUid, owningPackage) == false) goto L17;
        Slog.w("SyncManager", "Not scheduling job " + syncAdapterInfo.uid + ":" + syncAdapterInfo.componentName + " -- package not allowed to start");
        return 0;
    L17:
        if (checkAccountAccess == true) goto L19;
    L22:
        return status;
    L19:
        if (canAccessAccount(account, owningPackage, owningUid) == true) goto L22;
        Log.w("SyncManager", "Access to " + SyncLogger.logSafe(account) + " denied for package " + owningPackage + " in UID " + syncAdapterInfo.uid);
        return 3;
    }

    private boolean isPackageStopped(String packageName, int userId) {
        return this.mPackageManagerInternal.isPackageStopped(packageName, userId);
    L5:
        Log.e("SyncManager", "Couldn't determine stopped state for unknown package: " + packageName);
        return false;
    }

    private boolean canAccessAccount(Account account, String packageName, int uid) {
        if (this.mAccountManager.hasAccountAccess(account, packageName, UserHandle.getUserHandleForUid(uid)) == false) goto L10;
        return true;
    L10:
        this.mContext.getPackageManager().getApplicationInfoAsUser(packageName, 1048576, UserHandle.getUserId(uid));     // Catch: PackageManager.NameNotFoundException -> L7
        return true;
    L8:
        return false;
    }

    private void removeSyncsForAuthority(SyncStorageEngine.EndPoint info, String why) {
        this.mLogger.log(new Object[]{"removeSyncsForAuthority: ", info, why});
        verifyJobScheduler();
        List<SyncOperation> ops = getAllPendingSyncs();
        Iterator<SyncOperation> r1 = ops.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        SyncOperation op = r1.next();
        if (op.target.matchesSpec(info) == false) goto L4;
        this.mLogger.log(new Object[]{"canceling: ", op});
        cancelJob(op, why);
        goto L4
    }

    public void removePeriodicSync(SyncStorageEngine.EndPoint target, Bundle extras, String why) {
        Message m = this.mSyncHandler.obtainMessage(14, Pair.create(target, why));
        m.setData(extras);
        m.sendToTarget();
    }

    public void updateOrAddPeriodicSync(SyncStorageEngine.EndPoint target, long pollFrequency, long flex, Bundle extras) {
        UpdatePeriodicSyncMessagePayload payload = new UpdatePeriodicSyncMessagePayload(this, target, pollFrequency, flex, extras);
        this.mSyncHandler.obtainMessage(13, payload).sendToTarget();
    }

    public List<PeriodicSync> getPeriodicSyncs(SyncStorageEngine.EndPoint target) {
        List<SyncOperation> ops = getAllPendingSyncs();
        List<PeriodicSync> periodicSyncs = new ArrayList();
        Iterator<SyncOperation> r2 = ops.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        SyncOperation op = r2.next();
        if (op.isPeriodic == false) goto L4;
        if (op.target.matchesSpec(target) == false) goto L4;
        periodicSyncs.add(new PeriodicSync(op.target.account, op.target.provider, op.getClonedExtras(), op.periodMillis / 1000, op.flexMillis / 1000));
        goto L4
    L13:
        return periodicSyncs;
    }

    public void scheduleLocalSync(Account account, int userId, int reason, String authority, int syncExemptionFlag, int callingUid, int callingPid, String callingPackage) {
        Bundle extras = new Bundle();
        extras.putBoolean("upload", true);
        scheduleSync(account, userId, reason, authority, extras, -2, LOCAL_SYNC_DELAY, true, syncExemptionFlag, callingUid, callingPid, callingPackage);
    }

    public SyncAdapterType[] getSyncAdapterTypes(int callingUid, int userId) {
        Collection<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> serviceInfos = this.mSyncAdapters.getAllServices(userId);
        List<SyncAdapterType> types = new ArrayList(serviceInfos.size());
        Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> r2 = serviceInfos.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> serviceInfo = r2.next();
        String packageName = ((SyncAdapterType) serviceInfo.type).getPackageName();
        if (TextUtils.isEmpty(packageName) == true) goto L10;
        if (this.mPackageManagerInternal.filterAppAccess(packageName, callingUid, userId) == true) goto L4;
    L10:
        types.add((SyncAdapterType) serviceInfo.type);
        goto L4
    L12:
        return (SyncAdapterType[]) types.toArray(new SyncAdapterType[0]);
    }

    public String[] getSyncAdapterPackagesForAuthorityAsUser(String authority, int callingUid, int userId) {
        String[] syncAdapterPackages = this.mSyncAdapters.getSyncAdapterPackagesForAuthority(authority, userId);
        List<String> filteredResult = new ArrayList(syncAdapterPackages.length);
        int r2 = syncAdapterPackages.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        String packageName = syncAdapterPackages[r4];
        if (TextUtils.isEmpty(packageName) == true) goto L10;
        if (this.mPackageManagerInternal.filterAppAccess(packageName, callingUid, userId) == true) goto L10;
        filteredResult.add(packageName);
    L10:
        r4 = r4 + 1;
        goto L3
    L12:
        return (String[]) filteredResult.toArray(new String[0]);
    }

    public String getSyncAdapterPackageAsUser(String accountType, String authority, int callingUid, int userId) {
        if (accountType == null) goto L16;
        if (authority == null) goto L16;
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo = this.mSyncAdapters.getServiceInfo(SyncAdapterType.newKey(authority, accountType), userId);
        if (syncAdapterInfo != null) goto L9;
        return null;
    L9:
        String packageName = ((SyncAdapterType) syncAdapterInfo.type).getPackageName();
        if (TextUtils.isEmpty(packageName) == false) goto L12;
    L15:
        return null;
    L12:
        if (this.mPackageManagerInternal.filterAppAccess(packageName, callingUid, userId) == true) goto L15;
        return packageName;
    L16:
        return null;
    }

    private void sendSyncFinishedOrCanceledMessage(ActiveSyncContext syncContext, SyncResult syncResult) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.v("SyncManager", "sending MESSAGE_SYNC_FINISHED");
    L5:
        Message msg = this.mSyncHandler.obtainMessage();
        msg.what = 1;
        msg.obj = new SyncFinishedOrCancelledMessagePayload(this, syncContext, syncResult);
        this.mSyncHandler.sendMessage(msg);
    }

    private void sendCancelSyncsMessage(SyncStorageEngine.EndPoint info, Bundle extras, String why) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.v("SyncManager", "sending MESSAGE_CANCEL");
    L5:
        this.mLogger.log(new Object[]{"sendCancelSyncsMessage() ep=", info, " why=", why});
        Message msg = this.mSyncHandler.obtainMessage();
        msg.what = 6;
        msg.setData(extras);
        msg.obj = info;
        this.mSyncHandler.sendMessage(msg);
    }

    private void postMonitorSyncProgressMessage(ActiveSyncContext activeSyncContext) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.v("SyncManager", "posting MESSAGE_SYNC_MONITOR in 60s");
    L5:
        activeSyncContext.mBytesTransferredAtLastPoll = getTotalBytesTransferredByUid(activeSyncContext.mSyncAdapterUid);
        activeSyncContext.mLastPolledTimeElapsed = SystemClock.elapsedRealtime();
        Message monitorMessage = this.mSyncHandler.obtainMessage(8, activeSyncContext);
        this.mSyncHandler.sendMessageDelayed(monitorMessage, 60000);
    }

    private void postScheduleSyncMessage(SyncOperation syncOperation, long minDelayMillis) {
        ScheduleSyncMessagePayload payload = new ScheduleSyncMessagePayload(syncOperation, minDelayMillis);
        this.mSyncHandler.obtainMessage(12, payload).sendToTarget();
    }

    private long getTotalBytesTransferredByUid(int uid) {
        return TrafficStats.getUidRxBytes(uid) + TrafficStats.getUidTxBytes(uid);
    }

    private void clearBackoffSetting(SyncStorageEngine.EndPoint target, String why) {
        Pair<Long, Long> backoff = this.mSyncStorageEngine.getBackoff(target);
        if (backoff == null) goto L10;
        if (((Long) backoff.first).longValue() != (-1)) goto L10;
        if (((Long) backoff.second).longValue() != (-1)) goto L10;
        return;
    L10:
        if (Log.isLoggable("SyncManager", 2) == false) goto L12;
        Slog.v("SyncManager", "Clearing backoffs for " + target);
    L12:
        this.mSyncStorageEngine.setBackoff(target, -1, -1);
        rescheduleSyncs(target, why);
    }

    private void increaseBackoffSetting(SyncStorageEngine.EndPoint target) {
        long now = SystemClock.elapsedRealtime();
        Pair<Long, Long> previousSettings = this.mSyncStorageEngine.getBackoff(target);
        long newDelayInMs = -1;
        if (previousSettings == null) goto L12;
        if (now < ((Long) previousSettings.first).longValue()) goto L7;
        newDelayInMs = (long) (((Long) previousSettings.second).longValue() * this.mConstants.getRetryTimeIncreaseFactor());
        goto L12
    L7:
        if (Log.isLoggable("SyncManager", 2) == false) goto L23;
        Slog.v("SyncManager", "Still in backoff, do not increase it. Remaining: " + ((((Long) previousSettings.first).longValue() - now) / 1000) + " seconds.");
        return;
    L23:
        return;
    L12:
        if (newDelayInMs > 0) goto L14;
        long initialRetryMs = this.mConstants.getInitialSyncRetryTimeInSeconds() * 1000;
        newDelayInMs = jitterize(initialRetryMs, (long) (initialRetryMs * 1.1d));
    L14:
        long maxSyncRetryTimeInSeconds = this.mConstants.getMaxSyncRetryTimeInSeconds();
        if (newDelayInMs <= (maxSyncRetryTimeInSeconds * 1000)) goto L17;
        long newDelayInMs2 = maxSyncRetryTimeInSeconds * 1000;
        long newDelayInMs3 = newDelayInMs2;
    L18:
        long newDelayInMs4 = now + newDelayInMs3;
        if (Log.isLoggable("SyncManager", 2) == false) goto L21;
        Slog.v("SyncManager", "Backoff until: " + newDelayInMs4 + ", delayTime: " + newDelayInMs3);
    L21:
        this.mSyncStorageEngine.setBackoff(target, newDelayInMs4, newDelayInMs3);
        rescheduleSyncs(target, "increaseBackoffSetting");
        return;
    L17:
        newDelayInMs3 = newDelayInMs;
        goto L18
    }

    private void rescheduleSyncs(SyncStorageEngine.EndPoint target, String why) {
        this.mLogger.log(new Object[]{"rescheduleSyncs() ep=", target, " why=", why});
        List<SyncOperation> ops = getAllPendingSyncs();
        int count = 0;
        Iterator<SyncOperation> r2 = ops.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        SyncOperation op = r2.next();
        if (op.isPeriodic == true) goto L4;
        if (op.target.matchesSpec(target) == false) goto L4;
        count = count + 1;
        cancelJob(op, why);
        postScheduleSyncMessage(op, 0);
        goto L4
    L12:
        if (Log.isLoggable("SyncManager", 2) == false) goto L22;
        Slog.v("SyncManager", "Rescheduled " + count + " syncs for " + target);
        return;
    }

    private void setDelayUntilTime(SyncStorageEngine.EndPoint target, long delayUntilSeconds) {
        long delayUntil = 1000 * delayUntilSeconds;
        long absoluteNow = System.currentTimeMillis();
        if (delayUntil <= absoluteNow) goto L5;
        long newDelayUntilTime = SystemClock.elapsedRealtime() + (delayUntil - absoluteNow);
    L6:
        this.mSyncStorageEngine.setDelayUntilTime(target, newDelayUntilTime);
        if (Log.isLoggable("SyncManager", 2) == false) goto L9;
        Slog.v("SyncManager", "Delay Until time set to " + newDelayUntilTime + " for " + target);
    L9:
        rescheduleSyncs(target, "delayUntil newDelayUntilTime: " + newDelayUntilTime);
        return;
    L5:
        newDelayUntilTime = 0;
        goto L6
    }

    private boolean isAdapterDelayed(SyncStorageEngine.EndPoint target) {
        long now = SystemClock.elapsedRealtime();
        Pair<Long, Long> backoff = this.mSyncStorageEngine.getBackoff(target);
        if (backoff == null) goto L10;
        if (((Long) backoff.first).longValue() == (-1)) goto L10;
        if (((Long) backoff.first).longValue() <= now) goto L10;
        return true;
    L10:
        if (this.mSyncStorageEngine.getDelayUntilTime(target) <= now) goto L12;
        return true;
    L12:
        return false;
    }

    public void cancelActiveSync(SyncStorageEngine.EndPoint info, Bundle extras, String why) {
        sendCancelSyncsMessage(info, extras, why);
    }

    private void scheduleSyncOperationH(SyncOperation syncOperation) {
        scheduleSyncOperationH(syncOperation, 0);
    }

    private void scheduleSyncOperationH(SyncOperation syncOperation, long minDelay) {
        boolean isLoggable = Log.isLoggable("SyncManager", 2);
        if (syncOperation != null) goto L7;
        Slog.e("SyncManager", "Can't schedule null sync operation.");
        return;
    L7:
        if (syncOperation.hasIgnoreBackoff() == true) goto L27;
        Pair<Long, Long> backoff = this.mSyncStorageEngine.getBackoff(syncOperation.target);
        if (backoff != null) goto L12;
        Slog.e("SyncManager", "Couldn't find backoff values for " + SyncLogger.logSafe(syncOperation.target));
        backoff = new Pair(-1L, -1L);
    L14:
        long now = SystemClock.elapsedRealtime();
        if (((Long) backoff.first).longValue() != (-1)) goto L17;
        long backoffDelay = 0;
    L18:
        long delayUntil = this.mSyncStorageEngine.getDelayUntilTime(syncOperation.target);
        if (delayUntil <= now) goto L21;
        long r15 = delayUntil - now;
    L22:
        long delayUntilDelay = r15;
        if (isLoggable == false) goto L25;
        StringBuilder r16 = new StringBuilder();
        long r19 = 0;
        r16.append("backoff delay:");
        r16.append(backoffDelay);
        r16.append(" delayUntil delay:");
        long delayUntilDelay2 = delayUntilDelay;
        r16.append(delayUntilDelay2);
        Slog.v("SyncManager", r16.toString());
    L26:
        long minDelay2 = Math.max(minDelay, Math.max(backoffDelay, delayUntilDelay2));
    L29:
        if (minDelay2 >= r19) goto L32;
        minDelay2 = 0;
    L35:
        if (syncOperation.isPeriodic == true) goto L92;
        int inheritedSyncExemptionFlag = 0;
        Iterator<ActiveSyncContext> r6 = this.mActiveSyncContexts.iterator();
    L38:
        if (r6.hasNext() == false) goto L45;
        ActiveSyncContext asc = r6.next();
        if (asc.mSyncOperation.key.equals(syncOperation.key) == false) goto L38;
        if (isLoggable == false) goto L155;
        Log.v("SyncManager", "Duplicate sync is already running. Not scheduling " + syncOperation);
        return;
    L155:
        return;
    L45:
        int duplicatesCount = 0;
        long now2 = SystemClock.elapsedRealtime();
        syncOperation.expectedRuntime = now2 + minDelay2;
        List<SyncOperation> pending = getAllPendingSyncs();
        SyncOperation syncToRun = syncOperation;
        Iterator<SyncOperation> r11 = pending.iterator();
    L47:
        if (r11.hasNext() == false) goto L60;
        SyncOperation op = r11.next();
        if (op.isPeriodic == true) goto L47;
        if (op.key.equals(syncOperation.key) == false) goto L58;
        if (syncToRun.expectedRuntime <= op.expectedRuntime) goto L56;
        syncToRun = op;
    L56:
        duplicatesCount = duplicatesCount + 1;
    L58:
        now2 = now2;
        goto L47
    L60:
        if (duplicatesCount <= 1) goto L66;
        StringBuilder r7 = new StringBuilder();
        r7.append("duplicates found when scheduling a sync operation: owningUid=");
        r7.append(syncOperation.owningUid);
        r7.append("; owningPackage=");
        r7.append(syncOperation.owningPackage);
        r7.append("; source=");
        r7.append(syncOperation.syncSource);
        r7.append("; adapter=");
        if (syncOperation.target == null) goto L64;
        String r8 = syncOperation.target.provider;
    L65:
        r7.append(r8);
        Slog.wtf("SyncManager", r7.toString());
        goto L66
    L64:
        r8 = "unknown";
    L66:
        if (syncOperation != syncToRun) goto L68;
    L72:
        Iterator<SyncOperation> r9 = pending.iterator();
    L74:
        if (r9.hasNext() == false) goto L85;
        SyncOperation op2 = r9.next();
        if (op2.isPeriodic == true) goto L74;
        if (op2.key.equals(syncOperation.key) == false) goto L74;
        if (op2 == syncToRun) goto L74;
        if (isLoggable == 0) goto L83;
        Slog.v("SyncManager", "Cancelling duplicate sync " + op2);
    L83:
        inheritedSyncExemptionFlag = Math.max(inheritedSyncExemptionFlag, op2.syncExemptionFlag);
        cancelJob(op2, "scheduleSyncOperationH-duplicate");
        goto L74
    L85:
        if (syncToRun == syncOperation) goto L89;
        if (isLoggable == 0) goto L156;
        Slog.v("SyncManager", "Not scheduling because a duplicate exists.");
        return;
    L156:
        return;
    L89:
        if (inheritedSyncExemptionFlag <= 0) goto L92;
        syncOperation.syncExemptionFlag = inheritedSyncExemptionFlag;
        goto L92
    L68:
        if (minDelay2 != r19) goto L72;
        if (syncToRun.syncExemptionFlag >= syncOperation.syncExemptionFlag) goto L72;
        syncToRun = syncOperation;
        inheritedSyncExemptionFlag = Math.max(0, syncToRun.syncExemptionFlag);
    L92:
        if (syncOperation.jobId != (-1)) goto L94;
        syncOperation.jobId = getUnusedJobIdH();
    L94:
        if (isLoggable == 0) goto L96;
        Slog.v("SyncManager", "scheduling sync operation " + syncOperation.toString());
    L96:
        int bias = syncOperation.getJobBias();
        if (syncOperation.isNotAllowedOnMetered() == false) goto L99;
        int networkType = 2;
    L101:
        if (syncOperation.isAppStandbyExempted() == false) goto L103;
        int jobFlags = 8;
    L104:
        JobInfo.Builder b = new JobInfo.Builder(syncOperation.jobId, new ComponentName(this.mContext, SyncJobService.class)).setExtras(syncOperation.toJobInfoExtras()).setRequiredNetworkType(networkType).setRequiresStorageNotLow(true).setPersisted(true).setBias(bias).setFlags(jobFlags);
        if (syncOperation.isPeriodic == false) goto L108;
        b.setPeriodic(syncOperation.periodMillis, syncOperation.flexMillis);
        boolean r12 = true;
    L112:
        if (syncOperation.hasRequireCharging() == false) goto L115;
        b.setRequiresCharging(r12);
    L115:
        if (syncOperation.isScheduledAsExpeditedJob() == false) goto L120;
        if (syncOperation.scheduleEjAsRegularJob == true) goto L120;
        b.setExpedited(r12);
    L120:
        if (syncOperation.syncExemptionFlag != 2) goto L124;
        DeviceIdleInternal dic = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
        if (dic == null) goto L124;
        dic.addPowerSaveTempWhitelistApp(1000, syncOperation.owningPackage, this.mConstants.getKeyExemptionTempWhitelistDurationInSeconds() * 1000, 1, UserHandle.getUserId(syncOperation.owningUid), false, 306, "sync by top app");
    L124:
        UsageStatsManagerInternal usmi = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
        if (usmi == null) goto L127;
        usmi.reportSyncScheduled(syncOperation.owningPackage, UserHandle.getUserId(syncOperation.owningUid), syncOperation.isAppStandbyExempted());
    L127:
        JobInfo ji = b.build();
        int result = getJobScheduler().scheduleAsPackage(ji, syncOperation.owningPackage, syncOperation.target.userId, syncOperation.wakeLockName());
        if (result != 0) goto L135;
        if (ji.isExpedited() == false) goto L135;
        if (isLoggable == 0) goto L133;
        Slog.i("SyncManager", "Failed to schedule EJ for " + syncOperation.owningPackage + ". Downgrading to regular");
    L133:
        syncOperation.scheduleEjAsRegularJob = true;
        b.setExpedited(false).setExtras(syncOperation.toJobInfoExtras());
        result = getJobScheduler().scheduleAsPackage(b.build(), syncOperation.owningPackage, syncOperation.target.userId, syncOperation.wakeLockName());
    L135:
        if (result != 0) goto L157;
        Slog.e("SyncManager", "Failed to schedule job for " + syncOperation.owningPackage);
        return;
    L157:
        return;
    L108:
        if (minDelay2 <= r19) goto L110;
        b.setMinimumLatency(minDelay2);
    L110:
        r12 = true;
        getSyncStorageEngine().markPending(syncOperation.target, true);
        goto L112
    L103:
        jobFlags = 0;
        goto L104
    L99:
        networkType = 1;
        goto L101
    L32:
        if (minDelay2 <= r19) goto L35;
        syncOperation.scheduleEjAsRegularJob = true;
        goto L35
    L25:
        delayUntilDelay2 = delayUntilDelay;
        r19 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        backoffDelay = ((Long) backoff.first).longValue() - now;
        goto L18
    L12:
        if (((Long) backoff.first).longValue() == (-1)) goto L14;
        syncOperation.scheduleEjAsRegularJob = true;
        goto L14
    L27:
        r19 = 0;
        minDelay2 = minDelay;
        goto L29
    }

    public void clearScheduledSyncOperations(SyncStorageEngine.EndPoint info) {
        List<SyncOperation> ops = getAllPendingSyncs();
        Iterator<SyncOperation> r1 = ops.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        SyncOperation op = r1.next();
        if (op.isPeriodic == true) goto L4;
        if (op.target.matchesSpec(info) == false) goto L4;
        cancelJob(op, "clearScheduledSyncOperations");
        getSyncStorageEngine().markPending(op.target, false);
        goto L4
    L11:
        this.mSyncStorageEngine.setBackoff(info, -1, -1);
    }

    public void cancelScheduledSyncOperation(SyncStorageEngine.EndPoint info, Bundle extras) {
        List<SyncOperation> ops = getAllPendingSyncs();
        Iterator<SyncOperation> r1 = ops.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        SyncOperation op = r1.next();
        if (op.isPeriodic == true) goto L4;
        if (op.target.matchesSpec(info) == false) goto L4;
        if (op.areExtrasEqual(extras, false) == false) goto L4;
        cancelJob(op, "cancelScheduledSyncOperation");
        goto L4
    L13:
        setAuthorityPendingState(info);
        if (this.mSyncStorageEngine.isSyncPending(info) == true) goto L17;
        this.mSyncStorageEngine.setBackoff(info, -1, -1);
        return;
    }

    private void maybeRescheduleSync(SyncResult syncResult, SyncOperation operation) {
        boolean isLoggable = Log.isLoggable("SyncManager", 3);
        if (isLoggable == false) goto L5;
        Log.d("SyncManager", "encountered error(s) during the sync: " + syncResult + ", " + operation);
    L5:
        operation.enableBackoff();
        operation.scheduleEjAsRegularJob = true;
        if (operation.hasDoNotRetry() == false) goto L12;
        if (syncResult.syncAlreadyInProgress == true) goto L12;
        if (isLoggable == false) goto L40;
        Log.d("SyncManager", "not retrying sync operation because SYNC_EXTRAS_DO_NOT_RETRY was specified " + operation);
        return;
    L40:
        return;
    L12:
        if (operation.isUpload() == false) goto L20;
        if (syncResult.syncAlreadyInProgress == true) goto L20;
        operation.enableTwoWaySync();
        if (isLoggable == false) goto L18;
        Log.d("SyncManager", "retrying sync operation as a two-way sync because an upload-only sync encountered an error: " + operation);
    L18:
        scheduleSyncOperationH(operation);
        return;
    L20:
        if (syncResult.tooManyRetries == false) goto L24;
        if (isLoggable == false) goto L43;
        Log.d("SyncManager", "not retrying sync operation because it retried too many times: " + operation);
        return;
    L43:
        return;
    L24:
        if (syncResult.madeSomeProgress() == false) goto L29;
        if (isLoggable == false) goto L27;
        Log.d("SyncManager", "retrying sync operation because even though it had an error it achieved some success");
    L27:
        scheduleSyncOperationH(operation);
        return;
    L29:
        if (syncResult.syncAlreadyInProgress == false) goto L34;
        if (isLoggable == false) goto L32;
        Log.d("SyncManager", "retrying sync operation that failed because there was already a sync in progress: " + operation);
    L32:
        scheduleSyncOperationH(operation, 10000);
        return;
    L34:
        if (syncResult.hasSoftError() == false) goto L38;
        if (isLoggable == false) goto L37;
        Log.d("SyncManager", "retrying sync operation because it encountered a soft error: " + operation);
    L37:
        scheduleSyncOperationH(operation);
        return;
    L38:
        Log.e("SyncManager", "not retrying sync operation because the error is a hard error: " + SyncLogger.logSafe(operation));
    }

    private void onUserUnlocked(int userId) {
        int r2 = userId;
        AccountManagerService.getSingleton().validateAccounts(r2);
        this.mSyncAdapters.invalidateCache(r2);
        SyncStorageEngine.EndPoint target = new SyncStorageEngine.EndPoint(null, null, r2);
        updateRunningAccounts(target);
        Account[] accounts = AccountManagerService.getSingleton().getAccounts(r2, this.mContext.getOpPackageName());
        int r13 = accounts.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        Account account = accounts[r14];
        scheduleSync(account, r2, -8, null, null, -1, 0, Process.myUid(), -3, null);
        r14 = r14 + 1;
        r2 = userId;
        goto L3
    }

    private void onUserStopped(int userId) {
        updateRunningAccounts(null);
        cancelActiveSync(new SyncStorageEngine.EndPoint(null, null, userId), null, "onUserStopped");
    }

    private void onUserRemoved(int userId) {
        this.mLogger.log(new Object[]{"onUserRemoved: u", Integer.valueOf(userId)});
        updateRunningAccounts(null);
        this.mSyncStorageEngine.removeStaleAccounts(null, userId);
        List<SyncOperation> ops = getAllPendingSyncs();
        Iterator<SyncOperation> r1 = ops.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        SyncOperation op = r1.next();
        if (op.target.userId != userId) goto L4;
        cancelJob(op, "user removed u" + userId);
        goto L4
    }

    static Intent getAdapterBindIntent(Context context, ComponentName syncAdapterComponent, int userId) {
        Intent intent = new Intent();
        intent.setAction("android.content.SyncAdapter");
        intent.setComponent(syncAdapterComponent);
        intent.putExtra("android.intent.extra.client_label", 17042204);
        intent.putExtra("android.intent.extra.client_intent", PendingIntent.getActivityAsUser(context, 0, new Intent("android.settings.SYNC_SETTINGS"), 67108864, null, UserHandle.of(userId)));
        return intent;
    }

    protected void dump(FileDescriptor fd, PrintWriter pw, boolean dumpAll) {
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        SyncAdapterStateFetcher buckets = new SyncAdapterStateFetcher();
        dumpSyncState(ipw, buckets);
        this.mConstants.dump(pw, "");
        dumpSyncAdapters(ipw);
        if (dumpAll == false) goto L6;
        ipw.println("Detailed Sync History");
        this.mLogger.dumpAll(pw);
        return;
    }

    static String formatTime(long time) {
        if (time != 0) goto L7;
        return "N/A";
    L7:
        return TimeMigrationUtils.formatMillisWithFixedFormat(time);
    }

    private static /* synthetic */ int lambda$static$6(SyncOperation op1, SyncOperation op2) {
        int res = Integer.compare(op1.target.userId, op2.target.userId);
        if (res == 0) goto L5;
        return res;
    L5:
        Comparator<String> stringComparator = String.CASE_INSENSITIVE_ORDER;
        int res2 = stringComparator.compare(op1.target.account.type, op2.target.account.type);
        if (res2 == 0) goto L8;
        return res2;
    L8:
        int res3 = stringComparator.compare(op1.target.account.name, op2.target.account.name);
        if (res3 == 0) goto L11;
        return res3;
    L11:
        int res4 = stringComparator.compare(op1.target.provider, op2.target.provider);
        if (res4 == 0) goto L14;
        return res4;
    L14:
        int res5 = Integer.compare(op1.reason, op2.reason);
        if (res5 == 0) goto L17;
        return res5;
    L17:
        int res6 = Long.compare(op1.periodMillis, op2.periodMillis);
        if (res6 == 0) goto L20;
        return res6;
    L20:
        int res7 = Long.compare(op1.expectedRuntime, op2.expectedRuntime);
        if (res7 == 0) goto L23;
        return res7;
    L23:
        int res8 = Long.compare(op1.jobId, op2.jobId);
        if (res8 == 0) goto L26;
        return res8;
    L26:
        return 0;
    }

    private static /* synthetic */ int lambda$static$7(SyncOperation op1, SyncOperation op2) {
        int res = Long.compare(op1.expectedRuntime, op2.expectedRuntime);
        if (res == 0) goto L6;
        return res;
    L6:
        return sOpDumpComparator.compare(op1, op2);
    }

    private static <T> int countIf(Collection<T> col, Predicate<T> p) {
        int ret = 0;
        Iterator<T> r1 = col.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        T item = r1.next();
        if (p.test(item) == false) goto L4;
        ret = ret + 1;
        goto L4
    L9:
        return ret;
    }

    protected void dumpPendingSyncs(PrintWriter pw, SyncAdapterStateFetcher buckets) {
        List<SyncOperation> pendingSyncs = getAllPendingSyncs();
        pw.print("Pending Syncs: ");
        pw.println(countIf(pendingSyncs, new SyncManager$$ExternalSyntheticLambda0()));
        Collections.sort(pendingSyncs, sOpRuntimeComparator);
        int count = 0;
        Iterator<SyncOperation> r2 = pendingSyncs.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        SyncOperation op = r2.next();
        if (op.isPeriodic == true) goto L4;
        pw.println(op.dump(null, false, buckets, false));
        count = count + 1;
        goto L4
    L9:
        pw.println();
    }

    private static /* synthetic */ boolean lambda$dumpPendingSyncs$8(SyncOperation op) {
        return !op.isPeriodic;
    }

    protected void dumpPeriodicSyncs(PrintWriter pw, SyncAdapterStateFetcher buckets) {
        List<SyncOperation> pendingSyncs = getAllPendingSyncs();
        pw.print("Periodic Syncs: ");
        pw.println(countIf(pendingSyncs, new SyncManager$$ExternalSyntheticLambda5()));
        Collections.sort(pendingSyncs, sOpDumpComparator);
        int count = 0;
        Iterator<SyncOperation> r2 = pendingSyncs.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        SyncOperation op = r2.next();
        if (op.isPeriodic == false) goto L4;
        pw.println(op.dump(null, false, buckets, false));
        count = count + 1;
        goto L4
    L9:
        pw.println();
    }

    private static /* synthetic */ boolean lambda$dumpPeriodicSyncs$9(SyncOperation op) {
        return op.isPeriodic;
    }

    public static StringBuilder formatDurationHMS(StringBuilder sb, long duration) {
        long duration2 = duration / 1000;
        if (duration2 >= 0) goto L5;
        sb.append('-');
        duration2 = -duration2;
    L5:
        long seconds = duration2 % 60;
        long duration3 = duration2 / 60;
        long minutes = duration3 % 60;
        long duration4 = duration3 / 60;
        long hours = duration4 % 24;
        long duration5 = duration4 / 24;
        boolean print = false;
        if (duration5 <= 0) goto L9;
        sb.append(duration5);
        sb.append('d');
        print = true;
    L9:
        if (printTwoDigitNumber(sb, seconds, 's', printTwoDigitNumber(sb, minutes, 'm', printTwoDigitNumber(sb, hours, 'h', print))) == true) goto L11;
        sb.append("0s");
    L11:
        return sb;
    }

    private static boolean printTwoDigitNumber(StringBuilder sb, long value, char unit, boolean always) {
        if (always == false) goto L4;
    L7:
        if (always == true) goto L9;
    L11:
        sb.append(value);
        sb.append(unit);
        return true;
    L9:
        if (value >= 10) goto L11;
        sb.append('0');
        goto L11
    L4:
        if (value != 0) goto L7;
        return false;
    }

    @NeverCompile
    protected void dumpSyncState(PrintWriter pw, SyncAdapterStateFetcher buckets) {
        final SyncManager r1 = this;
        final StringBuilder sb = new StringBuilder();
        pw.print("Data connected: ");
        pw.println(r1.mDataConnectionIsConnected);
        pw.print("Battery saver: ");
        boolean r5 = true;
        if (r1.mPowerManager != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        pw.println(r0);
        pw.print("Background network restriction: ");
        ConnectivityManager cm = r1.getConnectivityManager();
        if (cm != null) goto L11;
        int status = -1;
    L12:
        switch(status) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            default: goto L13;
        };
    L13:
        pw.print("Unknown(");
        pw.print(status);
        pw.println(")");
    L17:
        pw.print("Auto sync: ");
        List<UserInfo> users = r1.getAllUsers();
        if (users == null) goto L24;
        Iterator<UserInfo> r2 = users.iterator();
    L21:
        if (r2.hasNext() == false) goto L23;
        UserInfo user = r2.next();
        pw.print("u" + user.id + "=" + r1.mSyncStorageEngine.getMasterSyncAutomatically(user.id) + " ");
        goto L21
    L23:
        pw.println();
    L24:
        Intent storageLowIntent = r1.mContext.registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW"));
        pw.print("Storage low: ");
        if (storageLowIntent != null) goto L28;
        r5 = false;
    L28:
        pw.println(r5);
        pw.print("Clock valid: ");
        pw.println(r1.mSyncStorageEngine.isClockValid());
        AccountAndUser[] accounts = AccountManagerService.getSingleton().getAllAccountsForSystemProcess();
        pw.print("Accounts: ");
        if (accounts == INITIAL_ACCOUNTS_ARRAY) goto L31;
        pw.println(accounts.length);
    L32:
        long now = SystemClock.elapsedRealtime();
        pw.print("Now: ");
        pw.print(now);
        pw.println(" (" + formatTime(System.currentTimeMillis()) + ")");
        sb.setLength(0);
        pw.print("Uptime: ");
        pw.print(formatDurationHMS(sb, now));
        pw.println();
        pw.print("Time spent syncing: ");
        sb.setLength(0);
        pw.print(formatDurationHMS(sb, r1.mSyncHandler.mSyncTimeTracker.timeSpentSyncing()));
        pw.print(", sync ");
        if (r1.mSyncHandler.mSyncTimeTracker.mLastWasSyncing == false) goto L35;
        String r3 = "";
    L36:
        pw.print(r3);
        pw.println("in progress");
        pw.println();
        pw.println("Active Syncs: " + r1.mActiveSyncContexts.size());
        PackageManager pm = r1.mContext.getPackageManager();
        Iterator<ActiveSyncContext> r4 = r1.mActiveSyncContexts.iterator();
    L38:
        if (r4.hasNext() == false) goto L40;
        ActiveSyncContext activeSyncContext = r4.next();
        long durationInSeconds = now - activeSyncContext.mStartTime;
        pw.print("  ");
        sb.setLength(0);
        pw.print(formatDurationHMS(sb, durationInSeconds));
        pw.print(" - ");
        pw.print(activeSyncContext.mSyncOperation.dump(pm, false, buckets, false));
        pw.println();
        goto L38
    L40:
        pw.println();
        dumpPendingSyncs(pw, buckets);
        dumpPeriodicSyncs(pw, buckets);
        pw.println("Sync Status");
        ArrayList<Pair<SyncStorageEngine.EndPoint, SyncStatusInfo>> statuses = new ArrayList();
        r1.mSyncStorageEngine.resetTodayStats(false);
        int r6 = accounts.length;
        int r12 = 0;
    L41:
        if (r12 >= r6) goto L83;
        AccountAndUser account = accounts[r12];
        SparseBooleanArray r14 = r1.mUnlockedUsers;
        monitor-enter(r14);
        int r17 = r6;
        boolean unlocked = r1.mUnlockedUsers.get(account.userId);     // Catch: Throwable -> L77
        monitor-exit(r14);     // Catch: Throwable -> L77
        String r15 = account.account.name;
        Integer r7 = Integer.valueOf(account.userId);
        AccountAndUser[] accounts2 = accounts;
        String r8 = account.account.type;
        if (unlocked == false) goto L50;
        String r20 = "";
    L49:
        List<UserInfo> users2 = users;
        pw.printf("Account %s u%d %s%s\n", new Object[]{r15, r7, r8, r20});
        pw.println("=======================================================================");
        final PrintTable table = new PrintTable(16);
        table.set(0, 0, new Object[]{"Authority", "Syncable", "Enabled", "Stats", "Loc", "Poll", "Per", "Feed", "User", "Othr", "Tot", "Fail", "Can", "Time", "Last Sync", "Backoff"});
        List<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> sorted = Lists.newArrayList();
        sorted.addAll(r1.mSyncAdapters.getAllServices(account.userId));
        Collections.sort(sorted, new AnonymousClass12(r1));
        Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> r9 = sorted.iterator();
    L53:
        if (r9.hasNext() == false) goto L76;
        RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterType = r9.next();
        sorted = sorted;
        if (((SyncAdapterType) syncAdapterType.type).accountType.equals(account.account.type) == false) goto L53;
        int row = table.getNumRows();
        Iterator<RegisteredServicesCache.ServiceInfo<SyncAdapterType>> r22 = r9;
        Intent storageLowIntent2 = storageLowIntent;
        long now2 = now;
        Pair<SyncStorageEngine.AuthorityInfo, SyncStatusInfo> syncAuthoritySyncStatus = r1.mSyncStorageEngine.getCopyOfAuthorityWithSyncStatus(new SyncStorageEngine.EndPoint(account.account, ((SyncAdapterType) syncAdapterType.type).authority, account.userId));
        SyncStorageEngine.AuthorityInfo settings = (SyncStorageEngine.AuthorityInfo) syncAuthoritySyncStatus.first;
        SyncStatusInfo status2 = (SyncStatusInfo) syncAuthoritySyncStatus.second;
        statuses.add(Pair.create(settings.target, status2));
        String authority = settings.target.provider;
        if (authority.length() <= 50) goto L60;
        authority = authority.substring(authority.length() - 50);
    L60:
        table.set(row, 0, new Object[]{authority, Integer.valueOf(settings.syncable), Boolean.valueOf(settings.enabled)});
        QuadConsumer<String, SyncStatusInfo.Stats, Function<Integer, String>, Integer> c = new SyncManager$$ExternalSyntheticLambda11(sb, table);
        StringBuilder sb2 = sb;
        c.accept("Total", status2.totalStats, new SyncManager$$ExternalSyntheticLambda12(), Integer.valueOf(row));
        c.accept("Today", status2.todayStats, new SyncManager$$ExternalSyntheticLambda13(r1), Integer.valueOf(row + 1));
        c.accept("Yestr", status2.yesterdayStats, new SyncManager$$ExternalSyntheticLambda13(r1), Integer.valueOf(row + 2));
        if (settings.delayUntil <= now2) goto L66;
        int row1 = row + 1;
        StringBuilder r10 = new StringBuilder();
        r10.append("D: ");
        PackageManager pm2 = pm;
        r10.append((settings.delayUntil - now2) / 1000);
        table.set(row, 15, new Object[]{r10.toString()});
        if (settings.backoffTime <= now2) goto L67;
        int row2 = row1 + 1;
        table.set(row1, 15, new Object[]{"B: " + ((settings.backoffTime - now2) / 1000)});
        int r11 = row2 + 1;
        table.set(row2, 15, new Object[]{Long.valueOf(settings.backoffDelay / 1000)});
    L67:
        int row3 = row;
        if (status2.lastSuccessTime == 0) goto L72;
        int row4 = row3 + 1;
        table.set(row3, 14, new Object[]{SyncStorageEngine.SOURCES[status2.lastSuccessSource] + " SUCCESS"});
        row3 = row4 + 1;
        table.set(row4, 14, new Object[]{formatTime(status2.lastSuccessTime)});
    L72:
        if (status2.lastFailureTime == 0) goto L75;
        int row5 = row3 + 1;
        table.set(row3, 14, new Object[]{SyncStorageEngine.SOURCES[status2.lastFailureSource] + " FAILURE"});
        int row6 = row5 + 1;
        table.set(row5, 14, new Object[]{formatTime(status2.lastFailureTime)});
        int r13 = row6 + 1;
        table.set(row6, 14, new Object[]{status2.lastFailureMesg});
    L75:
        pm = pm2;
        r9 = r22;
        storageLowIntent = storageLowIntent2;
        now = now2;
        sb = sb2;
        r1 = this;
        goto L53
    L66:
        pm2 = pm;
        goto L67
    L76:
        table.writeTo(pw);
        r12 = r12 + 1;
        r6 = r17;
        accounts = accounts2;
        users = users2;
        r1 = this;
        goto L41
    L50:
        r20 = " (locked)";
    L77:
        th = th;
    L100:
        throw th;
    L81:
        th = th;
        goto L100
    L83:
        dumpSyncHistory(pw);
        pw.println();
        pw.println("Per Adapter History");
        pw.println("(SERVER is now split up to FEED and OTHER)");
        int i = 0;
    L85:
        if (i >= statuses.size()) goto L99;
        Pair<SyncStorageEngine.EndPoint, SyncStatusInfo> event = statuses.get(i);
        pw.print("  ");
        pw.print(((SyncStorageEngine.EndPoint) event.first).account.name);
        pw.print('/');
        pw.print(((SyncStorageEngine.EndPoint) event.first).account.type);
        pw.print(" u");
        pw.print(((SyncStorageEngine.EndPoint) event.first).userId);
        pw.print(" [");
        pw.print(((SyncStorageEngine.EndPoint) event.first).provider);
        pw.print("]");
        pw.println();
        pw.println("    Per source last syncs:");
        int j = 0;
    L88:
        if (j >= SyncStorageEngine.SOURCES.length) goto L90;
        pw.print("      ");
        pw.print(String.format("%8s", new Object[]{SyncStorageEngine.SOURCES[j]}));
        pw.print("  Success: ");
        pw.print(formatTime(((SyncStatusInfo) event.second).perSourceLastSuccessTimes[j]));
        pw.print("  Failure: ");
        pw.println(formatTime(((SyncStatusInfo) event.second).perSourceLastFailureTimes[j]));
        j = j + 1;
        goto L88
    L90:
        pw.println("    Last syncs:");
        int j2 = 0;
    L92:
        if (j2 >= ((SyncStatusInfo) event.second).getEventCount()) goto L95;
        pw.print("      ");
        pw.print(formatTime(((SyncStatusInfo) event.second).getEventTime(j2)));
        pw.print(' ');
        pw.print(((SyncStatusInfo) event.second).getEvent(j2));
        pw.println();
        j2 = j2 + 1;
        goto L92
    L95:
        if (((SyncStatusInfo) event.second).getEventCount() != 0) goto L97;
        pw.println("      N/A");
    L97:
        i = i + 1;
        goto L85
    L99:
        return;
    L35:
        r3 = "not ";
        goto L36
    L31:
        pw.println("not known yet");
        goto L32
    L14:
        pw.println(" enabled");
        goto L17
    L15:
        pw.println(" whitelisted");
        goto L17
    L16:
        pw.println(" disabled");
        goto L17
    L11:
        status = cm.getRestrictBackgroundStatus();
        goto L12
    L5:
        if (r1.mPowerManager.isPowerSaveMode() == false) goto L7;
        r0 = true;
        goto L8
    }

    private static /* synthetic */ void lambda$dumpSyncState$10(StringBuilder sb, PrintTable table, String label, SyncStatusInfo.Stats stats, Function filter, Integer r) {
        sb.setLength(0);
        table.set(r.intValue(), 3, new Object[]{label, filter.apply(Integer.valueOf(stats.numSourceLocal)), filter.apply(Integer.valueOf(stats.numSourcePoll)), filter.apply(Integer.valueOf(stats.numSourcePeriodic)), filter.apply(Integer.valueOf(stats.numSourceFeed)), filter.apply(Integer.valueOf(stats.numSourceUser)), filter.apply(Integer.valueOf(stats.numSourceOther)), filter.apply(Integer.valueOf(stats.numSyncs)), filter.apply(Integer.valueOf(stats.numFailures)), filter.apply(Integer.valueOf(stats.numCancels)), formatDurationHMS(sb, stats.totalElapsedTime)});
    }

    private static /* synthetic */ String lambda$dumpSyncState$11(Integer i) {
        return Integer.toString(i.intValue());
    }

    private String zeroToEmpty(int value) {
        if (value != 0) goto L6;
        return "";
    L6:
        return Integer.toString(value);
    }

    private void dumpTimeSec(PrintWriter pw, long time) {
        pw.print(time / 1000);
        pw.print('.');
        pw.print((time / 100) % 10);
        pw.print('s');
    }

    private void dumpDayStatistic(PrintWriter pw, SyncStorageEngine.DayStats ds) {
        pw.print("Success (");
        pw.print(ds.successCount);
        if (ds.successCount <= 0) goto L5;
        pw.print(" for ");
        dumpTimeSec(pw, ds.successTime);
        pw.print(" avg=");
        dumpTimeSec(pw, ds.successTime / ((long) ds.successCount));
    L5:
        pw.print(") Failure (");
        pw.print(ds.failureCount);
        if (ds.failureCount <= 0) goto L8;
        pw.print(" for ");
        dumpTimeSec(pw, ds.failureTime);
        pw.print(" avg=");
        dumpTimeSec(pw, ds.failureTime / ((long) ds.failureCount));
    L8:
        pw.println(")");
    }

    protected void dumpSyncHistory(PrintWriter pw) {
        dumpRecentHistory(pw);
        dumpDayStatistics(pw);
    }

    private void dumpRecentHistory(PrintWriter pw) {
        final SyncManager r0 = this;
        ArrayList<SyncStorageEngine.SyncHistoryItem> items = r0.mSyncStorageEngine.getSyncHistory();
        if (items == null) goto L90;
        if (items.size() <= 0) goto L90;
        Map<String, AuthoritySyncStats> authorityMap = Maps.newHashMap();
        long totalElapsedTime = 0;
        long totalTimes = 0;
        int N = items.size();
        int maxAuthority = 0;
        int maxAccount = 0;
        Iterator<SyncStorageEngine.SyncHistoryItem> r11 = items.iterator();
    L7:
        boolean r12 = r11.hasNext();
        String r13 = " u";
        String r14 = SliceClientPermissions.SliceAuthority.DELIMITER;
        if (r12 == false) goto L28;
        SyncStorageEngine.SyncHistoryItem item = r11.next();
        long totalElapsedTime2 = totalElapsedTime;
        SyncStorageEngine.AuthorityInfo authorityInfo = r0.mSyncStorageEngine.getAuthority(item.authorityId);
        if (authorityInfo == null) goto L12;
        String authorityName = authorityInfo.target.provider;
        String accountKey = authorityInfo.target.account.name + SliceClientPermissions.SliceAuthority.DELIMITER + authorityInfo.target.account.type + " u" + authorityInfo.target.userId;
        String authorityName2 = authorityName;
    L13:
        int length = authorityName2.length();
        if (length <= maxAuthority) goto L16;
        maxAuthority = length;
    L16:
        int length2 = accountKey.length();
        if (length2 <= maxAccount) goto L19;
        maxAccount = length2;
    L19:
        long totalTimes2 = totalTimes;
        long totalTimes3 = item.elapsedTime;
        long totalElapsedTime3 = totalElapsedTime2 + totalTimes3;
        long totalTimes4 = totalTimes2 + 1;
        AuthoritySyncStats authoritySyncStats = authorityMap.get(authorityName2);
        SyncManagerIA r4 = null;
        if (authoritySyncStats != null) goto L23;
        authoritySyncStats = new AuthoritySyncStats(authorityName2, r4);
        authorityMap.put(authorityName2, authoritySyncStats);
    L23:
        long elapsedTime = authoritySyncStats.elapsedTime;
        authoritySyncStats.elapsedTime = elapsedTime + totalTimes3;
        authoritySyncStats.times++;
        Map<String, AccountSyncStats> accountMap = authoritySyncStats.accountMap;
        AccountSyncStats accountSyncStats = accountMap.get(accountKey);
        if (accountSyncStats != null) goto L27;
        accountSyncStats = new AccountSyncStats(accountKey, r4);
        accountMap.put(accountKey, accountSyncStats);
    L27:
        accountSyncStats.elapsedTime += totalTimes3;
        accountSyncStats.times++;
        totalElapsedTime = totalElapsedTime3;
        totalTimes = totalTimes4;
        authorityMap = authorityMap;
        goto L7
    L12:
        authorityName2 = "Unknown";
        accountKey = "Unknown";
        goto L13
    L28:
        Map<String, AuthoritySyncStats> authorityMap2 = authorityMap;
        long totalElapsedTime4 = totalElapsedTime;
        long totalTimes5 = totalTimes;
        int r16 = 1;
        if (totalElapsedTime4 <= 0) goto L39;
        pw.println();
        pw.printf("Detailed Statistics (Recent history):  %d (# of times) %ds (sync time)\n", new Object[]{Long.valueOf(totalTimes5), Long.valueOf(totalElapsedTime4 / 1000)});
        List<AuthoritySyncStats> sortedAuthorities = new ArrayList(authorityMap2.values());
        Collections.sort(sortedAuthorities, new AnonymousClass13(r0));
        int maxLength = Math.max(maxAuthority, maxAccount + 3);
        int padLength = (((maxLength + 4) + 2) + 10) + 11;
        char[] chars = new char[padLength];
        Arrays.fill(chars, '-');
        String separator = new String(chars);
        long r25 = 1000;
        String authorityFormat = String.format("  %%-%ds: %%-9s  %%-11s\n", new Object[]{Integer.valueOf(maxLength + 2)});
        String accountFormat = String.format("    %%-%ds:   %%-9s  %%-11s\n", new Object[]{Integer.valueOf(maxLength)});
        pw.println(separator);
        Iterator<AuthoritySyncStats> r7 = sortedAuthorities.iterator();
    L32:
        if (r7.hasNext() == false) goto L38;
        List<AuthoritySyncStats> sortedAuthorities2 = sortedAuthorities;
        AuthoritySyncStats authoritySyncStats2 = r7.next();
        Iterator<AuthoritySyncStats> r23 = r7;
        String name = authoritySyncStats2.name;
        int maxLength2 = maxLength;
        int padLength2 = padLength;
        long elapsedTime2 = authoritySyncStats2.elapsedTime;
        int times = authoritySyncStats2.times;
        String timeStr = String.format("%ds/%d%%", new Object[]{Long.valueOf(elapsedTime2 / 1000), Long.valueOf((elapsedTime2 * 100) / totalElapsedTime4)});
        char[] chars2 = chars;
        String r35 = r13;
        String r37 = r14;
        String timesStr = String.format("%d/%d%%", new Object[]{Integer.valueOf(times), Long.valueOf(((long) (times * 100)) / totalTimes5)});
        pw.printf(authorityFormat, new Object[]{name, timesStr, timeStr});
        String authorityFormat2 = authorityFormat;
        List<AccountSyncStats> sortedAccounts = new ArrayList(authoritySyncStats2.accountMap.values());
        Collections.sort(sortedAccounts, new AnonymousClass14(r0));
        Iterator<AccountSyncStats> r5 = sortedAccounts.iterator();
    L35:
        if (r5.hasNext() == false) goto L37;
        Iterator<AccountSyncStats> r40 = r5;
        AccountSyncStats stats = r5.next();
        String name2 = name;
        long elapsedTime3 = stats.elapsedTime;
        AuthoritySyncStats authoritySyncStats3 = authoritySyncStats2;
        int times2 = stats.times;
        String timeStr2 = String.format("%ds/%d%%", new Object[]{Long.valueOf(elapsedTime3 / 1000), Long.valueOf((elapsedTime3 * 100) / totalElapsedTime4)});
        String timesStr2 = String.format("%d/%d%%", new Object[]{Integer.valueOf(times2), Long.valueOf(((long) (times2 * 100)) / totalTimes5)});
        pw.printf(accountFormat, new Object[]{stats.name, timesStr2, timeStr2});
        N = N;
        r5 = r40;
        name = name2;
        authoritySyncStats2 = authoritySyncStats3;
        goto L35
    L37:
        pw.println(separator);
        r7 = r23;
        sortedAuthorities = sortedAuthorities2;
        maxLength = maxLength2;
        padLength = padLength2;
        chars = chars2;
        r13 = r35;
        r14 = r37;
        authorityFormat = authorityFormat2;
        goto L32
    L38:
        int N2 = N;
        String r36 = r13;
        String r38 = r14;
    L40:
        pw.println();
        pw.println("Recent Sync History");
        String r3 = "(SERVER is now split up to FEED and OTHER)";
        pw.println("(SERVER is now split up to FEED and OTHER)");
        String format = "  %-" + maxAccount + "s  %-" + maxAuthority + "s %s\n";
        Map<String, Long> lastTimeMap = Maps.newHashMap();
        PackageManager pm = r0.mContext.getPackageManager();
        int i = 0;
    L41:
        int N3 = N2;
        if (i >= N3) goto L73;
        SyncStorageEngine.SyncHistoryItem item2 = items.get(i);
        SyncStorageEngine.AuthorityInfo authorityInfo2 = r0.mSyncStorageEngine.getAuthority(item2.authorityId);
        if (authorityInfo2 == null) goto L46;
        String authorityName3 = authorityInfo2.target.provider;
        StringBuilder r15 = new StringBuilder();
        r15.append(authorityInfo2.target.account.name);
        String r17 = r38;
        r15.append(r17);
        r15.append(authorityInfo2.target.account.type);
        String r8 = r36;
        r15.append(r8);
        r15.append(authorityInfo2.target.userId);
        String accountKey2 = r15.toString();
    L47:
        r36 = r8;
        N2 = N3;
        long elapsedTime4 = item2.elapsedTime;
        ArrayList<SyncStorageEngine.SyncHistoryItem> items2 = items;
        String r28 = r3;
        long eventTime = item2.eventTime;
        String key = authorityName3 + r17 + accountKey2;
        Long lastEventTime = lastTimeMap.get(key);
        if (lastEventTime != null) goto L50;
        String diffString = "";
    L57:
        lastTimeMap.put(key, Long.valueOf(eventTime));
        Map<String, Long> lastTimeMap2 = lastTimeMap;
        pw.printf("  #%-3d: %s %8s  %5.1fs  %8s", new Object[]{Integer.valueOf(i + 1), formatTime(eventTime), SyncStorageEngine.SOURCES[item2.source], Float.valueOf(elapsedTime4 / 1000.0f), diffString});
        pw.printf(format, new Object[]{accountKey2, authorityName3, SyncOperation.reasonToString(pm, item2.reason)});
        if (item2.event != r16) goto L65;
        PackageManager pm2 = pm;
        if (item2.upstreamActivity == r3) goto L62;
    L66:
        PackageManager pm3 = pm2;
        pw.printf("    event=%d upstreamActivity=%d downstreamActivity=%d\n", new Object[]{Integer.valueOf(item2.event), Long.valueOf(item2.upstreamActivity), Long.valueOf(item2.downstreamActivity)});
    L68:
        if (item2.mesg == null) goto L72;
        if (SyncStorageEngine.MESG_SUCCESS.equals(item2.mesg) == true) goto L72;
        pw.printf("    mesg=%s\n", new Object[]{item2.mesg});
    L72:
        i = i + 1;
        pm = pm3;
        items = items2;
        r38 = r17;
        maxAuthority = maxAuthority;
        r3 = r28;
        lastTimeMap = lastTimeMap2;
        maxAccount = maxAccount;
        r16 = 1;
        goto L41
    L62:
        if (item2.downstreamActivity != 0) goto L66;
        pm3 = pm2;
        goto L68
    L65:
        pm2 = pm;
        goto L66
    L50:
        long diff = (lastEventTime.longValue() - eventTime) / r25;
        if (diff >= 60) goto L54;
        diffString = String.valueOf(diff);
        goto L57
    L54:
        if (diff >= 3600) goto L56;
        diffString = String.format("%02d:%02d", new Object[]{Long.valueOf(diff / 60), Long.valueOf(diff % 60)});
        goto L57
    L56:
        long sec = diff % 3600;
        diffString = String.format("%02d:%02d:%02d", new Object[]{Long.valueOf(diff / 3600), Long.valueOf(sec / 60), Long.valueOf(sec % 60)});
        goto L57
    L46:
        r8 = r36;
        r17 = r38;
        authorityName3 = "Unknown";
        accountKey2 = "Unknown";
        goto L47
    L73:
        ArrayList<SyncStorageEngine.SyncHistoryItem> items3 = items;
        int N4 = N3;
        String r18 = r38;
        pw.println();
        pw.println("Recent Sync History Extras");
        pw.println(r3);
        int i2 = 0;
    L74:
        int N5 = N4;
        if (i2 >= N5) goto L104;
        SyncStorageEngine.SyncHistoryItem item3 = items3.get(i2);
        Bundle extras = item3.extras;
        if (extras != null) goto L79;
        String r19 = r36;
    L87:
        i2 = i2 + 1;
        r0 = this;
        N4 = N5;
        r36 = r19;
        goto L74
    L79:
        if (extras.size() != 0) goto L81;
        r19 = r36;
        goto L87
    L81:
        SyncStorageEngine.AuthorityInfo authorityInfo3 = r0.mSyncStorageEngine.getAuthority(item3.authorityId);
        if (authorityInfo3 == null) goto L84;
        String authorityName4 = authorityInfo3.target.provider;
        StringBuilder r9 = new StringBuilder();
        r9.append(authorityInfo3.target.account.name);
        r9.append(r18);
        r9.append(authorityInfo3.target.account.type);
        r19 = r36;
        r9.append(r19);
        r9.append(authorityInfo3.target.userId);
        String accountKey3 = r9.toString();
    L85:
        pw.printf("  #%-3d: %s %8s ", new Object[]{Integer.valueOf(i2 + 1), formatTime(item3.eventTime), SyncStorageEngine.SOURCES[item3.source]});
        pw.printf(format, new Object[]{accountKey3, authorityName4, extras});
        goto L87
    L84:
        r19 = r36;
        authorityName4 = "Unknown";
        accountKey3 = "Unknown";
        goto L85
    L104:
        return;
    L39:
        r25 = 1000;
        N2 = N;
        r36 = " u";
        r38 = SliceClientPermissions.SliceAuthority.DELIMITER;
    }

    private void dumpDayStatistics(PrintWriter pw) {
        SyncStorageEngine.DayStats[] dses = this.mSyncStorageEngine.getDayStatistics();
        if (dses != null) goto L5;
        return;
    L5:
        if (dses[0] == null) goto L52;
        pw.println();
        pw.println("Sync Statistics");
        pw.print("  Today:  ");
        dumpDayStatistic(pw, dses[0]);
        int today = dses[0].day;
        int i = 1;
    L8:
        if (i > 6) goto L18;
        if (i >= dses.length) goto L18;
        SyncStorageEngine.DayStats ds = dses[i];
        if (ds == null) goto L18;
        int delta = today - ds.day;
        if (delta > 6) goto L18;
        pw.print("  Day-");
        pw.print(delta);
        pw.print(":  ");
        dumpDayStatistic(pw, ds);
        i = i + 1;
    L18:
        int weekDay = today;
    L20:
        if (i >= dses.length) goto L53;
        SyncStorageEngine.DayStats aggr = null;
        weekDay = weekDay - 7;
    L23:
        if (i >= dses.length) goto L34;
        SyncStorageEngine.DayStats ds2 = dses[i];
        if (ds2 == null) goto L26;
        if ((weekDay - ds2.day) > 6) goto L34;
        i = i + 1;
        if (aggr != null) goto L33;
        aggr = new SyncStorageEngine.DayStats(weekDay);
    L33:
        aggr.successCount += ds2.successCount;
        aggr.successTime += ds2.successTime;
        aggr.failureCount += ds2.failureCount;
        aggr.failureTime += ds2.failureTime;
        goto L23
    L26:
        i = dses.length;
    L34:
        if (aggr == null) goto L20;
        pw.print("  Week-");
        pw.print((today - weekDay) / 7);
        pw.print(": ");
        dumpDayStatistic(pw, aggr);
        goto L20
    L53:
        return;
    }

    private void dumpSyncAdapters(IndentingPrintWriter pw) {
        pw.println();
        List<UserInfo> users = getAllUsers();
        if (users == null) goto L12;
        Iterator<UserInfo> r1 = users.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        UserInfo user = r1.next();
        pw.println("Sync adapters for " + user + ":");
        pw.increaseIndent();
        Iterator r3 = this.mSyncAdapters.getAllServices(user.id).iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        RegisteredServicesCache.ServiceInfo<?> info = (RegisteredServicesCache.ServiceInfo) r3.next();
        pw.println(info);
        goto L9
    L11:
        pw.decreaseIndent();
        pw.println();
        goto L6
    L15:
        return;
    }

    static void sendOnUnsyncableAccount(final Context context, RegisteredServicesCache.ServiceInfo<SyncAdapterType> syncAdapterInfo, int userId, OnReadyCallback onReadyCallback) {
        final OnUnsyncableAccountCheck connection = new OnUnsyncableAccountCheck(syncAdapterInfo, onReadyCallback);
        boolean isBound = context.bindServiceAsUser(getAdapterBindIntent(context, syncAdapterInfo.componentName, userId), connection, SYNC_ADAPTER_CONNECTION_FLAGS, UserHandle.of(userId));
        if (isBound == false) goto L5;
        new Handler(Looper.getMainLooper()).postDelayed(new SyncManager$$ExternalSyntheticLambda8(context, connection), 5000);
        return;
    L5:
        OnUnsyncableAccountCheck.m3197$$Nest$monReady(connection);
    }

    private static /* synthetic */ void lambda$sendOnUnsyncableAccount$12(Context context, OnUnsyncableAccountCheck connection) {
        context.unbindService(connection);
    }

    private static SyncManager getInstance() {
        monitor-enter(SyncManager.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        Slog.wtf("SyncManager", "sInstance == null");     // Catch: Throwable -> L7
    L9:
        SyncManager r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(SyncManager.class);     // Catch: Throwable -> L7
        return r1;
    }

    public static boolean readyToSync(int userId) {
        SyncManager instance = getInstance();
        if (instance != null) goto L5;
    L11:
        return false;
    L5:
        if (SyncJobService.isReady() == false) goto L11;
        if (instance.mProvisioned == false) goto L11;
        if (instance.isUserUnlocked(userId) == false) goto L11;
        return true;
    }

    public static void sendMessage(Message message) {
        SyncManager instance = getInstance();
        if (instance != null) goto L5;
        return;
    L5:
        if (instance.mSyncHandler == null) goto L9;
        instance.mSyncHandler.sendMessage(message);
        return;
    }

    private boolean isSyncStillActiveH(ActiveSyncContext activeSyncContext) {
        Iterator<ActiveSyncContext> r0 = this.mActiveSyncContexts.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ActiveSyncContext sync = r0.next();
        if (sync != activeSyncContext) goto L4;
        return true;
    L10:
        return false;
    }

    public static boolean syncExtrasEquals(Bundle b1, Bundle b2, boolean includeSyncSettings) {
        if (b1 != b2) goto L6;
        return true;
    L6:
        if (includeSyncSettings == false) goto L11;
        if (b1.size() == b2.size()) goto L11;
        return false;
    L11:
        if (b1.size() <= b2.size()) goto L13;
        Bundle bigger = b1;
    L15:
        if (b1.size() <= b2.size()) goto L17;
        Bundle smaller = b2;
    L18:
        Iterator<String> r4 = bigger.keySet().iterator();
    L20:
        if (r4.hasNext() == false) goto L33;
        String key = r4.next();
        if (includeSyncSettings == true) goto L27;
        if (isSyncSetting(key) == true) goto L20;
    L27:
        if (smaller.containsKey(key) == false) goto L28;
        if (Objects.equals(bigger.get(key), smaller.get(key)) == true) goto L20;
        return false;
    L28:
        return false;
    L33:
        return true;
    L17:
        smaller = b1;
        goto L18
    L13:
        bigger = b2;
        goto L15
    }

    private static boolean isSyncSetting(String key) {
        if (key != null) goto L6;
        return false;
    L6:
        if (key.equals("expedited") == false) goto L9;
        return true;
    L9:
        if (key.equals("schedule_as_expedited_job") == false) goto L12;
        return true;
    L12:
        if (key.equals("ignore_settings") == false) goto L15;
        return true;
    L15:
        if (key.equals("ignore_backoff") == false) goto L18;
        return true;
    L18:
        if (key.equals("do_not_retry") == false) goto L21;
        return true;
    L21:
        if (key.equals("force") == false) goto L24;
        return true;
    L24:
        if (key.equals("upload") == false) goto L27;
        return true;
    L27:
        if (key.equals("deletions_override") == false) goto L30;
        return true;
    L30:
        if (key.equals("discard_deletions") == false) goto L33;
        return true;
    L33:
        if (key.equals("expected_upload") == false) goto L36;
        return true;
    L36:
        if (key.equals("expected_download") == false) goto L39;
        return true;
    L39:
        if (key.equals("sync_priority") == false) goto L42;
        return true;
    L42:
        if (key.equals("allow_metered") == false) goto L45;
        return true;
    L45:
        if (key.equals("initialize") == false) goto L47;
        return true;
    L47:
        return false;
    }

    private Context getContextForUser(UserHandle user) {
        return this.mContext.createPackageContextAsUser(this.mContext.getPackageName(), 0, user);
    L6:
        return this.mContext;
    }

    private void cancelJob(SyncOperation op, String why) {
        if (op != null) goto L6;
        Slog.wtf("SyncManager", "Null sync operation detected.");
        return;
    L6:
        if (op.isPeriodic == false) goto L8;
        this.mLogger.log(new Object[]{"Removing periodic sync ", op, " for ", why});
    L8:
        getJobScheduler().cancel(op.jobId);
    }

    public void resetTodayStats() {
        this.mSyncStorageEngine.resetTodayStats(true);
    }

    private boolean wasPackageEverLaunched(String packageName, int userId) {
        return this.mPackageManagerInternal.wasPackageEverLaunched(packageName, userId);
    L5:
        return false;
    }
}
