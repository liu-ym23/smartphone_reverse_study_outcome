package com.android.server.accounts;

import android.R;
import android.accounts.Account;
import android.accounts.AccountAndUser;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.AccountManagerInternal;
import android.accounts.AccountManagerResponse;
import android.accounts.AuthenticatorDescription;
import android.accounts.CantAddAccountActivity;
import android.accounts.ChooseAccountActivity;
import android.accounts.GrantCredentialsPermissionActivity;
import android.accounts.IAccountAuthenticator;
import android.accounts.IAccountAuthenticatorResponse;
import android.accounts.IAccountManager;
import android.accounts.IAccountManagerResponse;
import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.AppOpsManager;
import android.app.BroadcastOptions;
import android.app.INotificationManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyManagerInternal;
import android.app.compat.CompatChanges;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.RegisteredServicesCache;
import android.content.pm.RegisteredServicesCacheListener;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.UserInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteException;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.os.Binder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.StrictMode;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.SeempLog;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.android.internal.content.PackageMonitor;
import com.android.internal.notification.SystemNotificationChannels;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.modules.expresslog.Histogram;
import com.android.server.LocalServices;
import com.android.server.ServiceThread;
import com.android.server.SystemService;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.autofill.HintsHelper;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.google.android.collect.Lists;
import com.google.android.collect.Sets;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class AccountManagerService extends IAccountManager.Stub implements RegisteredServicesCacheListener<AuthenticatorDescription> {
    private static final Intent ACCOUNTS_CHANGED_INTENT = null;
    private static final Bundle ACCOUNTS_CHANGED_OPTIONS = null;
    private static final Account[] EMPTY_ACCOUNT_ARRAY = null;
    private static final long ENFORCE_PACKAGE_VISIBILITY_FILTERING = 154726397;
    private static final int[] INTERESTING_APP_OPS = null;
    private static final int MAXIMUM_PASSWORD_LENGTH = 1000000;
    private static final int MESSAGE_COPY_SHARED_ACCOUNT = 4;
    private static final int MESSAGE_TIMED_OUT = 3;
    private static final String PRE_N_DATABASE_NAME = "accounts.db";
    private static final int SIGNATURE_CHECK_MATCH = 1;
    private static final int SIGNATURE_CHECK_MISMATCH = 0;
    private static final int SIGNATURE_CHECK_UID_MATCH = 2;
    private static final int STORAGE_LIMIT_PER_USER = 30000000;
    private static final String TAG = "AccountManagerService";
    private static final int TIMEOUT_DELAY_MS = 900000;
    private static Histogram sResponseLatency;
    private static AtomicReference<AccountManagerService> sThis;
    private final AppOpsManager mAppOpsManager;
    private CopyOnWriteArrayList<AccountManagerInternal.OnAppPermissionChangeListener> mAppPermissionChangeListeners;
    private final IAccountAuthenticatorCache mAuthenticatorCache;
    final Context mContext;
    private final SimpleDateFormat mDateFormat;
    final MessageHandler mHandler;
    private final Injector mInjector;
    private final SparseBooleanArray mLocalUnlockedUsers;
    private final PackageManager mPackageManager;
    final PackageMonitor mPackageMonitor;
    private final LinkedHashMap<String, Session> mSessions;
    private UserManager mUserManager;
    private final SparseArray<UserAccounts> mUsers;

    private final class AccountManagerInternalImpl extends AccountManagerInternal {
        private AccountManagerBackupHelper mBackupHelper;
        private final Object mLock;
        final /* synthetic */ AccountManagerService this$0;

        /* synthetic */ AccountManagerInternalImpl(AccountManagerService r1, AccountManagerServiceIA r2) {
            this(r1);
        }

        private AccountManagerInternalImpl(AccountManagerService r1) {
            this.this$0 = r1;
            this.mLock = new Object();
        }

        public void requestAccountAccess(Account account, String packageName, int userId, RemoteCallback callback) {
            if (account != null) goto L6;
            Slog.w(AccountManagerService.TAG, "account cannot be null");
            return;
        L6:
            if (packageName != null) goto L9;
            Slog.w(AccountManagerService.TAG, "packageName cannot be null");
            return;
        L9:
            if (userId >= 0) goto L12;
            Slog.w(AccountManagerService.TAG, "user id must be concrete");
            return;
        L12:
            if (callback != null) goto L15;
            Slog.w(AccountManagerService.TAG, "callback cannot be null");
            return;
        L15:
            int visibility = AccountManagerService.m917$$Nest$mresolveAccountVisibility(this.this$0, account, packageName, this.this$0.getUserAccounts(userId)).intValue();
            if (visibility != 3) goto L20;
            Slog.w(AccountManagerService.TAG, "requestAccountAccess: account is hidden");
            return;
        L20:
            if (this.this$0.hasAccountAccess(account, packageName, new UserHandle(userId)) == false) goto L45;
            Bundle result = new Bundle();
            result.putBoolean("booleanResult", true);
            callback.sendResult(result);
            return;
        L45:
            long identityToken = Binder.clearCallingIdentity();     // Catch: PackageManager.NameNotFoundException -> L36
            int uid = AccountManagerService.m895$$Nest$fgetmPackageManager(this.this$0).getPackageUidAsUser(packageName, userId);     // Catch: Throwable -> L38
            goto L41
        L26:
            Binder.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L36
            Intent intent = AccountManagerService.m912$$Nest$mnewRequestAccountAccessIntent(this.this$0, account, packageName, uid, callback);
            SparseArray r1 = AccountManagerService.m897$$Nest$fgetmUsers(this.this$0);
            monitor-enter(r1);
            UserAccounts userAccounts = (UserAccounts) AccountManagerService.m897$$Nest$fgetmUsers(this.this$0).get(userId);     // Catch: Throwable -> L33
            monitor-exit(r1);     // Catch: Throwable -> L33
            SystemNotificationChannels.createAccountChannelForPackage(packageName, uid, this.this$0.mContext);
            AccountManagerService.m902$$Nest$mdoNotification(this.this$0, userAccounts, account, null, intent, packageName, userId);
            return;
        L33:
            th = move-exception;
            throw th;
        L38:
            th = move-exception;
            Binder.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L36
            throw th;     // Catch: PackageManager.NameNotFoundException -> L36
        L41:
            Slog.e(AccountManagerService.TAG, "Unknown package " + packageName);
        }

        public void addOnAppPermissionChangeListener(AccountManagerInternal.OnAppPermissionChangeListener listener) {
            AccountManagerService.m892$$Nest$fgetmAppPermissionChangeListeners(this.this$0).add(listener);
        }

        public boolean hasAccountAccess(Account account, int uid) {
            return AccountManagerService.m906$$Nest$mhasAccountAccess(this.this$0, account, null, uid);
        }

        public byte[] backupAccountAccessPermissions(int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mBackupHelper != null) goto L9;
            this.mBackupHelper = new AccountManagerBackupHelper(this.this$0, this);     // Catch: Throwable -> L7
        L9:
            byte[] r1 = this.mBackupHelper.backupAccountAccessPermissions(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        }

        public void restoreAccountAccessPermissions(byte[] data, int userId) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mBackupHelper != null) goto L9;
            this.mBackupHelper = new AccountManagerBackupHelper(this.this$0, this);     // Catch: Throwable -> L7
        L9:
            this.mBackupHelper.restoreAccountAccessPermissions(data, userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }
    }

    private class GetAccountsByTypeAndFeatureSession extends Session {
        private volatile Account[] mAccountsOfType;
        private volatile ArrayList<Account> mAccountsWithFeatures;
        private final int mCallingUid;
        private volatile int mCurrentAccount;
        private final String[] mFeatures;
        private final boolean mIncludeManagedNotVisible;
        private final String mPackageName;
        final /* synthetic */ AccountManagerService this$0;

        public GetAccountsByTypeAndFeatureSession(AccountManagerService r10, UserAccounts accounts, IAccountManagerResponse response, String type, String[] features, int callingUid, String packageName, boolean includeManagedNotVisible) {
            this.this$0 = r10;
            super(r10, accounts, response, type, false, true, null, false);
            this.mAccountsOfType = null;
            this.mAccountsWithFeatures = null;
            this.mCurrentAccount = 0;
            this.mCallingUid = callingUid;
            this.mFeatures = features;
            this.mPackageName = packageName;
            this.mIncludeManagedNotVisible = includeManagedNotVisible;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        public void run() throws RemoteException {
            this.mAccountsOfType = this.this$0.getAccountsFromCache(this.mAccounts, this.mAccountType, this.mCallingUid, this.mPackageName, this.mIncludeManagedNotVisible);
            this.mAccountsWithFeatures = new ArrayList(this.mAccountsOfType.length);
            this.mCurrentAccount = 0;
            checkAccount();
        }

        public void checkAccount() {
            if (this.mCurrentAccount < this.mAccountsOfType.length) goto L6;
            sendResult();
            return;
        L6:
            IAccountAuthenticator accountAuthenticator = this.mAuthenticator;
            if (accountAuthenticator == null) goto L9;
            accountAuthenticator.hasFeatures(this, this.mAccountsOfType[this.mCurrentAccount], this.mFeatures);     // Catch: RemoteException -> L14
            return;
        L15:
            onError(1, "remote exception");
            return;
        L9:
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L19;
            Log.v(AccountManagerService.TAG, "checkAccount: aborting session since we are no longer connected to the authenticator, " + toDebugString());
            return;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        public void onResult(Bundle result) {
            Bundle.setDefusable(result, true);
            this.mNumResults++;
            if (result != null) goto L7;
            onError(5, "null bundle");
            return;
        L7:
            if (result.getBoolean("booleanResult", false) == false) goto L9;
            this.mAccountsWithFeatures.add(this.mAccountsOfType[this.mCurrentAccount]);
        L9:
            this.mCurrentAccount++;
            checkAccount();
        }

        public void sendResult() {
            IAccountManagerResponse response = getResponseAndClose();
            if (response != null) goto L20;
            return;
        L20:
            Account[] accounts = new Account[this.mAccountsWithFeatures.size()];     // Catch: RemoteException -> L9
            int i = 0;
        L7:
            if (i >= accounts.length) goto L12;
            accounts[i] = this.mAccountsWithFeatures.get(i);     // Catch: RemoteException -> L9
            i = i + 1;     // Catch: RemoteException -> L9
            goto L7
        L12:
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L14;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onResult() on response " + response);     // Catch: RemoteException -> L9
        L14:
            Bundle result = new Bundle();     // Catch: RemoteException -> L9
            result.putParcelableArray("accounts", accounts);     // Catch: RemoteException -> L9
            response.onResult(result);     // Catch: RemoteException -> L9
            return;
        L9:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L24;
            Log.v(AccountManagerService.TAG, "failure while notifying response", e);
            return;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        protected String toDebugString(long now) {
            StringBuilder r0 = new StringBuilder();
            r0.append(super.toDebugString(now));
            r0.append(", getAccountsByTypeAndFeatures, ");
            if (this.mFeatures == null) goto L5;
            String r1 = TextUtils.join(",", this.mFeatures);
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = null;
            goto L6
        }
    }

    static class Injector {
        private final Context mContext;

        public Injector(Context context) {
            this.mContext = context;
        }

        Looper getMessageHandlerLooper() {
            ServiceThread serviceThread = new ServiceThread(AccountManagerService.TAG, -2, true);
            serviceThread.start();
            return serviceThread.getLooper();
        }

        Context getContext() {
            return this.mContext;
        }

        void addLocalService(AccountManagerInternal service) {
            LocalServices.addService(AccountManagerInternal.class, service);
        }

        String getDeDatabaseName(int userId) {
            File databaseFile = new File(Environment.getDataSystemDeDirectory(userId), "accounts_de.db");
            return databaseFile.getPath();
        }

        String getCeDatabaseName(int userId) {
            File databaseFile = new File(Environment.getDataSystemCeDirectory(userId), "accounts_ce.db");
            return databaseFile.getPath();
        }

        String getPreNDatabaseName(int userId) {
            File systemDir = Environment.getDataSystemDirectory();
            File databaseFile = new File(Environment.getUserSystemDirectory(userId), AccountManagerService.PRE_N_DATABASE_NAME);
            if (userId != 0) goto L21;
            File oldFile = new File(systemDir, AccountManagerService.PRE_N_DATABASE_NAME);
            if (oldFile.exists() == false) goto L21;
            if (databaseFile.exists() == true) goto L21;
            File userDir = Environment.getUserSystemDirectory(userId);
            if (userDir.exists() == true) goto L16;
            if (userDir.mkdirs() == true) goto L16;
            throw new IllegalStateException("User dir cannot be created: " + userDir);
        L16:
            if (oldFile.renameTo(databaseFile) == true) goto L21;
            throw new IllegalStateException("User dir cannot be migrated: " + databaseFile);
        L21:
            return databaseFile.getPath();
        }

        IAccountAuthenticatorCache getAccountAuthenticatorCache() {
            return new AccountAuthenticatorCache(this.mContext);
        }

        INotificationManager getNotificationManager() {
            return NotificationManager.getService();
        }
    }

    public static class Lifecycle extends SystemService {
        private AccountManagerService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            this.mService = new AccountManagerService(new Injector(getContext()));
            publishBinderService("account", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onUserUnlocking(SystemService.TargetUser user) {
            this.mService.onUnlockUser(user.getUserIdentifier());
        }

        @Override // com.android.server.SystemService
        public void onUserStopped(SystemService.TargetUser user) {
            Slog.i(AccountManagerService.TAG, "onUserStopped " + user);
            AccountManagerService.m914$$Nest$mpurgeUserData(this.mService, user.getUserIdentifier());
        }
    }

    class MessageHandler extends Handler {
        final /* synthetic */ AccountManagerService this$0;

        MessageHandler(AccountManagerService this$0, Looper looper) {
            this.this$0 = this$0;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 3: goto L7;
                case 4: goto L6;
                default: goto L5;
            };
        L6:
            this.this$0.copyAccountToUser(null, (Account) msg.obj, msg.arg1, msg.arg2);
            return;
        L7:
            Session session = (Session) msg.obj;
            session.onTimedOut();
            return;
        L5:
            throw new IllegalStateException("unhandled message: " + msg.what);
        }
    }

    private static class NotificationId {
        private final int mId;
        final String mTag;

        /* JADX INFO: renamed from: -$$Nest$fgetmId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m924$$Nest$fgetmId(NotificationId r0) {
            return r0.mId;
        }

        NotificationId(String tag, int type) {
            this.mTag = tag;
            this.mId = type;
        }
    }

    private class OnInterestingAppOpChangedListener extends AppOpsManager.OnOpChangedInternalListener {
        final /* synthetic */ AccountManagerService this$0;

        /* synthetic */ OnInterestingAppOpChangedListener(AccountManagerService r1, AccountManagerServiceIA r2) {
            this(r1);
        }

        private OnInterestingAppOpChangedListener(AccountManagerService r1) {
            this.this$0 = r1;
        }

        public void onOpChanged(int op, String packageName) {
            int userId = ActivityManager.getCurrentUser();
            int packageUid = AccountManagerService.m895$$Nest$fgetmPackageManager(this.this$0).getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L18
            int mode = AccountManagerService.m891$$Nest$fgetmAppOpsManager(this.this$0).checkOpNoThrow(op, packageUid, packageName);
            if (mode == 0) goto L7;
            return;
        L7:
            long identity = Binder.clearCallingIdentity();
            AccountManagerService.m899$$Nest$mcancelAccountAccessRequestNotificationIfNeeded(this.this$0, packageName, packageUid, true, this.this$0.getUserAccounts(userId));     // Catch: Throwable -> L10 SQLiteCantOpenDatabaseException -> L12
        L9:
            Binder.restoreCallingIdentity(identity);
            return;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        L12:
            e = move-exception;
            Log.w(AccountManagerService.TAG, "Can't read accounts database", e);     // Catch: Throwable -> L10
        }
    }

    private class RemoveAccountSession extends Session {
        final Account mAccount;
        final /* synthetic */ AccountManagerService this$0;

        public RemoveAccountSession(AccountManagerService r10, UserAccounts accounts, IAccountManagerResponse response, Account account, boolean expectActivityLaunch) {
            this.this$0 = r10;
            super(r10, accounts, response, account.type, expectActivityLaunch, true, account.name, false);
            this.mAccount = account;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        protected String toDebugString(long now) {
            return super.toDebugString(now) + ", removeAccount, account " + this.mAccount;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        public void run() throws RemoteException {
            this.mAuthenticator.getAccountRemovalAllowed(this, this.mAccount);
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        public void onResult(Bundle result) {
            Bundle.setDefusable(result, true);
            if (result != null) goto L5;
        L20:
            super.onResult(result);
            return;
        L5:
            if (result.containsKey("booleanResult") == false) goto L20;
            if (result.containsKey("intent") == true) goto L20;
            boolean removalAllowed = result.getBoolean("booleanResult");
            if (removalAllowed == false) goto L11;
            AccountManagerService.m915$$Nest$mremoveAccountInternal(this.this$0, this.mAccounts, this.mAccount, IAccountAuthenticatorResponse.Stub.getCallingUid());
        L11:
            IAccountManagerResponse response = getResponseAndClose();
            if (response == null) goto L20;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L22;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onResult() on response " + response);
        L22:
            response.onResult(result);     // Catch: RemoteException -> L18
        L18:
            e = move-exception;
            Slog.e(AccountManagerService.TAG, "Error calling onResult()", e);
            goto L20
        }
    }

    private abstract class Session extends IAccountAuthenticatorResponse.Stub implements IBinder.DeathRecipient, ServiceConnection {
        final String mAccountName;
        final String mAccountType;
        protected final UserAccounts mAccounts;
        final boolean mAuthDetailsRequired;
        IAccountAuthenticator mAuthenticator;
        private int mAuthenticatorUid;
        private long mBindingStartTime;
        protected boolean mCanStartAccountManagerActivity;
        final long mCreationTime;
        final boolean mExpectActivityLaunch;
        protected boolean mIsAllowAppColdStart;
        protected boolean mIsSelfRescue;
        private int mNumErrors;
        private int mNumRequestContinued;
        public int mNumResults;
        IAccountManagerResponse mResponse;
        private final Object mSessionLock;
        private final boolean mStripAuthTokenFromResult;
        final boolean mUpdateLastAuthenticatedTime;
        final /* synthetic */ AccountManagerService this$0;

        public abstract void run() throws RemoteException;

        public Session(AccountManagerService r11, UserAccounts accounts, IAccountManagerResponse response, String accountType, boolean expectActivityLaunch, boolean stripAuthTokenFromResult, String accountName, boolean authDetailsRequired) {
            this(r11, accounts, response, accountType, expectActivityLaunch, stripAuthTokenFromResult, accountName, authDetailsRequired, false);
        }

        public Session(AccountManagerService r12, UserAccounts accounts, IAccountManagerResponse response, String accountType, boolean expectActivityLaunch, boolean stripAuthTokenFromResult, String accountName, boolean authDetailsRequired, boolean updateLastAuthenticatedTime) {
            this(r12, accounts, response, accountType, expectActivityLaunch, stripAuthTokenFromResult, accountName, authDetailsRequired, updateLastAuthenticatedTime, false);
        }

        public Session(AccountManagerService r4, UserAccounts accounts, IAccountManagerResponse response, String accountType, boolean expectActivityLaunch, boolean stripAuthTokenFromResult, String accountName, boolean authDetailsRequired, boolean updateLastAuthenticatedTime, boolean isSelfRescue) {
            this.this$0 = r4;
            this.mSessionLock = new Object();
            this.mNumResults = 0;
            this.mNumRequestContinued = 0;
            this.mNumErrors = 0;
            this.mAuthenticator = null;
            this.mCanStartAccountManagerActivity = false;
            this.mIsAllowAppColdStart = true;
            this.mIsSelfRescue = false;
            if (accountType == null) goto L19;
            this.mAccounts = accounts;
            this.mStripAuthTokenFromResult = stripAuthTokenFromResult;
            this.mAccountType = accountType;
            this.mExpectActivityLaunch = expectActivityLaunch;
            this.mCreationTime = SystemClock.elapsedRealtime();
            this.mAccountName = accountName;
            this.mAuthDetailsRequired = authDetailsRequired;
            this.mUpdateLastAuthenticatedTime = updateLastAuthenticatedTime;
            this.mIsSelfRescue = isSelfRescue;
            LinkedHashMap r1 = AccountManagerService.m896$$Nest$fgetmSessions(r4);
            monitor-enter(r1);
            AccountManagerService.m896$$Nest$fgetmSessions(r4).put(toString(), this);     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
            scheduleTimeout();
            if (response == null) goto L24;
            response.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L12
            this.mResponse = response;     // Catch: RemoteException -> L12
            return;
        L13:
            binderDied();
            return;
        L24:
            return;
        L15:
            th = move-exception;
            throw th;
        L19:
            throw new IllegalArgumentException("accountType is null");
        }

        IAccountManagerResponse getResponseAndClose() {
            if (this.mAuthenticatorUid == 0) goto L8;
            if (this.mBindingStartTime <= 0) goto L8;
            AccountManagerService.m923$$Nest$sfgetsResponseLatency().logSampleWithUid(this.mAuthenticatorUid, SystemClock.uptimeMillis() - this.mBindingStartTime);
        L8:
            if (this.mResponse != null) goto L11;
            close();
            return null;
        L11:
            IAccountManagerResponse response = this.mResponse;
            close();
            return response;
        }

        protected boolean checkKeyIntent(int authUid, Bundle bundle) {
            if (checkKeyIntentParceledCorrectly(bundle) == true) goto L6;
            EventLog.writeEvent(1397638484, new Object[]{"250588548", Integer.valueOf(authUid), ""});
            return false;
        L6:
            Intent intent = (Intent) bundle.getParcelable("intent", Intent.class);
            if (intent != null) goto L10;
            return true;
        L10:
            if (intent.getClipData() != null) goto L12;
            intent.setClipData(ClipData.newPlainText(null, null));
        L12:
            long bid = Binder.clearCallingIdentity();
            PackageManager pm = this.this$0.mContext.getPackageManager();     // Catch: Throwable -> L35
            ResolveInfo resolveInfo = pm.resolveActivityAsUser(intent, 0, UserAccounts.m933$$Nest$fgetuserId(this.mAccounts));     // Catch: Throwable -> L35
            if (resolveInfo != null) goto L18;
            Binder.restoreCallingIdentity(bid);
            return false;
        L18:
            if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(intent.getScheme()) == false) goto L21;
            Binder.restoreCallingIdentity(bid);
            return false;
        L21:
            ActivityInfo targetActivityInfo = resolveInfo.activityInfo;     // Catch: Throwable -> L35
            int targetUid = targetActivityInfo.applicationInfo.uid;     // Catch: Throwable -> L35
            PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Throwable -> L35
            if (isExportedSystemActivity(targetActivityInfo) == true) goto L32;
        L29:
            th = th;
        L37:
            Binder.restoreCallingIdentity(bid);
            throw th;
        L25:
            if (pmi.hasSignatureCapability(targetUid, authUid, 16) == true) goto L32;
            String pkgName = targetActivityInfo.packageName;     // Catch: Throwable -> L29
            String activityName = targetActivityInfo.name;     // Catch: Throwable -> L29
            Log.e(AccountManagerService.TAG, String.format("KEY_INTENT resolved to an Activity (%s) in a package (%s) that does not share a signature with the supplying authenticator (%s).", new Object[]{activityName, pkgName, this.mAccountType}));     // Catch: Throwable -> L29
            Binder.restoreCallingIdentity(bid);
            return false;
        L32:
            intent.setComponent(targetActivityInfo.getComponentName());     // Catch: Throwable -> L29
            bundle.putParcelable("intent", intent);     // Catch: Throwable -> L29
            Binder.restoreCallingIdentity(bid);
            return true;
        L35:
            th = th;
            goto L37
        }

        private boolean checkKeyIntentParceledCorrectly(Bundle bundle) {
            Parcel p = Parcel.obtain();
            p.writeBundle(bundle);
            p.setDataPosition(0);
            Bundle simulateBundle = p.readBundle();
            p.recycle();
            Intent intent = (Intent) bundle.getParcelable("intent", Intent.class);
            Intent simulateIntent = (Intent) simulateBundle.getParcelable("intent", Intent.class);
            if (intent != null) goto L8;
            if (simulateIntent == null) goto L6;
            return false;
        L6:
            return true;
        L8:
            if (intent.getClass() == Intent.class) goto L10;
        L22:
            return false;
        L10:
            if (simulateIntent.getClass() != Intent.class) goto L22;
            if (intent.filterEquals(simulateIntent) == true) goto L16;
            return false;
        L16:
            if (intent.getSelector() == simulateIntent.getSelector()) goto L19;
            return false;
        L19:
            if ((simulateIntent.getFlags() & 195) == 0) goto L21;
            return false;
        L21:
            return true;
        }

        private boolean isExportedSystemActivity(ActivityInfo activityInfo) {
            String className = activityInfo.name;
            if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(activityInfo.packageName) == true) goto L6;
            return false;
        L6:
            if (this.mCanStartAccountManagerActivity == false) goto L10;
            if (GrantCredentialsPermissionActivity.class.getName().equals(className) == false) goto L10;
        L11:
            return true;
        L10:
            if (CantAddAccountActivity.class.getName().equals(className) == true) goto L11;
            return false;
        }

        private void close() {
            LinkedHashMap r0 = AccountManagerService.m896$$Nest$fgetmSessions(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (AccountManagerService.m896$$Nest$fgetmSessions(this.this$0).remove(toString()) != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            if (this.mResponse == null) goto L14;
            this.mResponse.asBinder().unlinkToDeath(this, 0);
            this.mResponse = null;
        L14:
            cancelTimeout();
            unbind();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mResponse = null;
            close();
        }

        protected String toDebugString() {
            return toDebugString(SystemClock.elapsedRealtime());
        }

        protected String toDebugString(long now) {
            StringBuilder r0 = new StringBuilder();
            r0.append("Session: expectLaunch ");
            r0.append(this.mExpectActivityLaunch);
            r0.append(", connected ");
            if (this.mAuthenticator == null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            r0.append(", stats (");
            r0.append(this.mNumResults);
            r0.append(SliceClientPermissions.SliceAuthority.DELIMITER);
            r0.append(this.mNumRequestContinued);
            r0.append(SliceClientPermissions.SliceAuthority.DELIMITER);
            r0.append(this.mNumErrors);
            r0.append("), lifetime ");
            r0.append((now - this.mCreationTime) / 1000.0d);
            return r0.toString();
        L5:
            r1 = false;
            goto L6
        }

        void bind() {
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L6;
            Log.v(AccountManagerService.TAG, "initiating bind to authenticator type " + this.mAccountType);
        L6:
            if (bindToAuthenticator(this.mAccountType, this.mIsAllowAppColdStart, this.mIsSelfRescue) == true) goto L9;
            Log.w(AccountManagerService.TAG, "bind attempt failed for " + toDebugString());
            onError(1, "bind failure");
            return;
        }

        private void unbind() {
            Object r0 = this.mSessionLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mAuthenticator == null) goto L9;
            this.mAuthenticator = null;     // Catch: Throwable -> L7
            this.this$0.mContext.unbindService(this);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private void scheduleTimeout() {
            this.this$0.mHandler.sendMessageDelayed(this.this$0.mHandler.obtainMessage(3, this), HeartbeatStats.MAX_NAT_TIME_MS);
        }

        public void cancelTimeout() {
            this.this$0.mHandler.removeMessages(3, this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Object r0 = this.mSessionLock;
            monitor-enter(r0);
            this.mAuthenticator = IAccountAuthenticator.Stub.asInterface(service);     // Catch: Throwable -> L7
            run();     // Catch: Throwable -> L7 RemoteException -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L10:
            onError(1, "remote exception");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            IAccountManagerResponse response = getResponseAndClose();
            if (response == null) goto L13;
            response.onError(1, "disconnected");     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L14;
            Log.v(AccountManagerService.TAG, "Session.onServiceDisconnected: caught RemoteException while responding", e);
            return;
        L14:
            return;
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName name) {
            IAccountManagerResponse response = getResponseAndClose();
            if (response == null) goto L13;
            response.onError(1, "disconnected");     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L14;
            Log.v(AccountManagerService.TAG, "Session.onNullBinding: caught RemoteException while responding", e);
            return;
        L14:
            return;
        }

        public void onTimedOut() {
            IAccountManagerResponse response = getResponseAndClose();
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L5;
            Log.v(AccountManagerService.TAG, "Session.onTimedOut");
        L5:
            if (response == null) goto L15;
            response.onError(1, "timeout");     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L16;
            Log.v(AccountManagerService.TAG, "Session.onTimedOut: caught RemoteException while responding", e);
            return;
        L16:
            return;
        }

        public void onResult(Bundle result) {
            boolean needUpdate = true;
            Bundle.setDefusable(result, true);
            this.mNumResults++;
            if (result == null) goto L30;
            boolean isSuccessfulConfirmCreds = result.getBoolean("booleanResult", false);
            if (result.containsKey("authAccount") == true) goto L7;
        L9:
            boolean isSuccessfulUpdateCredsOrAddAccount = false;
        L11:
            if (this.mUpdateLastAuthenticatedTime == false) goto L15;
            if (isSuccessfulConfirmCreds == true) goto L16;
            if (isSuccessfulUpdateCredsOrAddAccount == false) goto L15;
        L16:
            if (needUpdate == false) goto L18;
        L19:
            boolean accountPresent = AccountManagerService.m907$$Nest$misAccountPresentForCaller(this.this$0, this.mAccountName, this.mAccountType);
            if (needUpdate == false) goto L24;
            if (accountPresent == false) goto L24;
            AccountManagerService.m922$$Nest$mupdateLastAuthenticatedTime(this.this$0, new Account(this.mAccountName, this.mAccountType));
        L24:
            if (this.mAuthDetailsRequired == false) goto L30;
            long lastAuthenticatedTime = -1;
            if (accountPresent == false) goto L28;
            lastAuthenticatedTime = this.mAccounts.accountsDb.findAccountLastAuthenticatedTime(new Account(this.mAccountName, this.mAccountType));
        L28:
            result.putLong("lastAuthenticatedTime", lastAuthenticatedTime);
            goto L30
        L18:
            if (this.mAuthDetailsRequired == false) goto L30;
        L15:
            needUpdate = false;
            goto L16
        L7:
            if (result.containsKey("accountType") == false) goto L9;
            isSuccessfulUpdateCredsOrAddAccount = true;
        L30:
            if (result == null) goto L36;
            if (checkKeyIntent(Binder.getCallingUid(), result) == true) goto L36;
            onError(5, "invalid intent in bundle returned");
            return;
        L36:
            if (result == null) goto L45;
            if (TextUtils.isEmpty(result.getString("authtoken")) == true) goto L45;
            String accountName = result.getString("authAccount");
            String accountType = result.getString("accountType");
            if (TextUtils.isEmpty(accountName) == true) goto L45;
            if (TextUtils.isEmpty(accountType) == true) goto L45;
            Account account = new Account(accountName, accountType);
            AccountManagerService.m900$$Nest$mcancelNotification(this.this$0, AccountManagerService.m904$$Nest$mgetSigninRequiredNotificationId(this.this$0, this.mAccounts, account), this.mAccounts);
        L45:
            if (this.mExpectActivityLaunch == false) goto L50;
            if (result == null) goto L50;
            if (result.containsKey("intent") == false) goto L50;
            IAccountManagerResponse response = this.mResponse;
        L51:
            if (response != null) goto L79;
            return;
        L79:
            if (result != null) goto L61;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L59;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onError() on response " + response);     // Catch: RemoteException -> L57
        L59:
            response.onError(5, "null bundle returned");     // Catch: RemoteException -> L57
            return;
        L61:
            if (this.mStripAuthTokenFromResult == false) goto L67;
            result.remove("authtoken");     // Catch: RemoteException -> L57
            if (checkKeyIntent(Binder.getCallingUid(), result) == true) goto L67;
            onError(5, "invalid intent in bundle returned");     // Catch: RemoteException -> L57
            return;
        L67:
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L70;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onResult() on response " + response);     // Catch: RemoteException -> L57
        L70:
            if (result.getInt("errorCode", -1) <= 0) goto L73;
            if (0 != 0) goto L73;
            response.onError(result.getInt("errorCode"), result.getString("errorMessage"));     // Catch: RemoteException -> L57
            return;
        L73:
            response.onResult(result);     // Catch: RemoteException -> L57
            return;
        L57:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L81;
            Log.v(AccountManagerService.TAG, "failure while notifying response", e);
            return;
        L81:
            return;
        L50:
            response = getResponseAndClose();
            goto L51
        }

        public void onRequestContinued() {
            this.mNumRequestContinued++;
        }

        public void onError(int errorCode, String errorMessage) {
            this.mNumErrors++;
            IAccountManagerResponse response = getResponseAndClose();
            if (response == null) goto L14;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L17;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onError() on response " + response);
        L17:
            response.onError(errorCode, errorMessage);     // Catch: RemoteException -> L9
            return;
        L9:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L21;
            Log.v(AccountManagerService.TAG, "Session.onError: caught RemoteException while responding", e);
            return;
        L21:
            return;
        L14:
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L19;
            Log.v(AccountManagerService.TAG, "Session.onError: already closed");
            return;
        }

        private boolean bindToAuthenticator(String authenticatorType) {
            return bindToAuthenticator(authenticatorType, true, false);
        }

        private boolean bindToAuthenticator(String authenticatorType, boolean isAllowAppColdStart, boolean isSelfRescue) {
            RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> authenticatorInfo = AccountManagerService.m893$$Nest$fgetmAuthenticatorCache(this.this$0).getServiceInfo(AuthenticatorDescription.newKey(authenticatorType), UserAccounts.m933$$Nest$fgetuserId(this.mAccounts));
            if (authenticatorInfo != null) goto L7;
            Log.w(AccountManagerService.TAG, "there is no authenticator for " + authenticatorType + ", bailing out");
            return false;
        L7:
            if (AccountManagerService.m908$$Nest$misLocalUnlockedUser(this.this$0, UserAccounts.m933$$Nest$fgetuserId(this.mAccounts)) == false) goto L9;
        L12:
            Intent intent = new Intent();
            intent.setAction("android.accounts.AccountAuthenticator");
            intent.setComponent(authenticatorInfo.componentName);
            intent.putExtra("isAllowAppColdStart", isAllowAppColdStart);
            intent.putExtra("isSelfRescue", isSelfRescue);
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L15;
            Log.v(AccountManagerService.TAG, "performing bindService to " + authenticatorInfo.componentName);
        L15:
            long flags = 1;
            if (AccountManagerService.m893$$Nest$fgetmAuthenticatorCache(this.this$0).getBindInstantServiceAllowed(UserAccounts.m933$$Nest$fgetuserId(this.mAccounts)) == false) goto L19;
            flags = 1 | 4194304;
        L19:
            if (this.this$0.mContext.bindServiceAsUser(intent, this, Context.BindServiceFlags.of(flags), UserHandle.of(UserAccounts.m933$$Nest$fgetuserId(this.mAccounts))) == true) goto L22;
            Log.w(AccountManagerService.TAG, "bindService to " + authenticatorInfo.componentName + " failed");
            this.this$0.mContext.unbindService(this);
            return false;
        L22:
            this.mAuthenticatorUid = authenticatorInfo.uid;
            this.mBindingStartTime = SystemClock.uptimeMillis();
            return true;
        L9:
            if (authenticatorInfo.componentInfo.directBootAware == true) goto L12;
            Slog.w(AccountManagerService.TAG, "Blocking binding to authenticator " + authenticatorInfo.componentName + " which isn't encryption aware");
            return false;
        }
    }

    private abstract class StartAccountSession extends Session {
        private final boolean mIsPasswordForwardingAllowed;
        final /* synthetic */ AccountManagerService this$0;

        public StartAccountSession(AccountManagerService r11, UserAccounts accounts, IAccountManagerResponse response, String accountType, boolean expectActivityLaunch, String accountName, boolean authDetailsRequired, boolean updateLastAuthenticationTime, boolean isPasswordForwardingAllowed) {
            this.this$0 = r11;
            super(r11, accounts, response, accountType, expectActivityLaunch, true, accountName, authDetailsRequired, updateLastAuthenticationTime);
            this.mIsPasswordForwardingAllowed = isPasswordForwardingAllowed;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        public void onResult(Bundle result) {
            Bundle.setDefusable(result, true);
            this.mNumResults++;
            if (result == null) goto L9;
            if (checkKeyIntent(Binder.getCallingUid(), result) == true) goto L9;
            onError(5, "invalid intent in bundle returned");
            return;
        L9:
            if (this.mExpectActivityLaunch == false) goto L14;
            if (result == null) goto L14;
            if (result.containsKey("intent") == false) goto L14;
            IAccountManagerResponse response = this.mResponse;
        L15:
            if (response != null) goto L18;
            return;
        L18:
            if (result != null) goto L25;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L22;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onError() on response " + response);
        L22:
            AccountManagerService.m920$$Nest$msendErrorResponse(this.this$0, response, 5, "null bundle returned");
            return;
        L25:
            if (result.getInt("errorCode", -1) <= 0) goto L30;
            if (0 != 0) goto L30;
            AccountManagerService.m920$$Nest$msendErrorResponse(this.this$0, response, result.getInt("errorCode"), result.getString("errorMessage"));
            return;
        L30:
            if (this.mIsPasswordForwardingAllowed == true) goto L32;
            result.remove(HintsHelper.AUTOFILL_HINT_PASSWORD);
        L32:
            result.remove("authtoken");
            if (checkKeyIntent(Binder.getCallingUid(), result) == true) goto L37;
            onError(5, "invalid intent in bundle returned");
            return;
        L37:
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L39;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onResult() on response " + response);
        L39:
            Bundle sessionBundle = result.getBundle("accountSessionBundle");
            if (sessionBundle == null) goto L55;
            String accountType = sessionBundle.getString("accountType");
            if (TextUtils.isEmpty(accountType) == false) goto L44;
        L45:
            Log.w(AccountManagerService.TAG, "Account type in session bundle doesn't match request.");
        L46:
            sessionBundle.putString("accountType", this.mAccountType);
            CryptoHelper cryptoHelper = CryptoHelper.getInstance();     // Catch: GeneralSecurityException -> L49
            Bundle encryptedBundle = cryptoHelper.encryptBundle(sessionBundle);     // Catch: GeneralSecurityException -> L49
            result.putBundle("accountSessionBundle", encryptedBundle);     // Catch: GeneralSecurityException -> L49
        L49:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 3) == false) goto L53;
            Log.v(AccountManagerService.TAG, "Failed to encrypt session bundle!", e);
        L53:
            AccountManagerService.m920$$Nest$msendErrorResponse(this.this$0, response, 5, "failed to encrypt session bundle");
            return;
        L44:
            if (this.mAccountType.equalsIgnoreCase(accountType) == true) goto L46;
        L55:
            AccountManagerService.m921$$Nest$msendResponse(this.this$0, response, result);
            return;
        L14:
            response = getResponseAndClose();
            goto L15
        }
    }

    private class TestFeaturesSession extends Session {
        private final Account mAccount;
        private final String[] mFeatures;

        public TestFeaturesSession(AccountManagerService r10, UserAccounts accounts, IAccountManagerResponse response, Account account, String[] features) {
            super(r10, accounts, response, account.type, false, true, account.name, false);
            this.mFeatures = features;
            this.mAccount = account;
            this.mIsAllowAppColdStart = false;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        public void run() throws RemoteException {
            this.mAuthenticator.hasFeatures(this, this.mAccount, this.mFeatures);     // Catch: RemoteException -> L4
            return;
        L5:
            onError(1, "remote exception");
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        public void onResult(Bundle result) {
            Bundle.setDefusable(result, true);
            IAccountManagerResponse response = getResponseAndClose();
            if (response != null) goto L19;
            return;
        L19:
            if (result != null) goto L11;
            response.onError(5, "null bundle");     // Catch: RemoteException -> L8
            return;
        L11:
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L13;
            Log.v(AccountManagerService.TAG, getClass().getSimpleName() + " calling onResult() on response " + response);     // Catch: RemoteException -> L8
        L13:
            Bundle newResult = new Bundle();     // Catch: RemoteException -> L8
            newResult.putBoolean("booleanResult", result.getBoolean("booleanResult", false));     // Catch: RemoteException -> L8
            response.onResult(newResult);     // Catch: RemoteException -> L8
            return;
        L8:
            e = move-exception;
            if (Log.isLoggable(AccountManagerService.TAG, 2) == false) goto L21;
            Log.v(AccountManagerService.TAG, "failure while notifying response", e);
            return;
        }

        @Override // com.android.server.accounts.AccountManagerService.Session
        protected String toDebugString(long now) {
            StringBuilder r0 = new StringBuilder();
            r0.append(super.toDebugString(now));
            r0.append(", hasFeatures, ");
            r0.append(this.mAccount);
            r0.append(", ");
            if (this.mFeatures == null) goto L5;
            String r1 = TextUtils.join(",", this.mFeatures);
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = null;
            goto L6
        }
    }

    static class UserAccounts {
        final HashMap<String, Account[]> accountCache;
        private final TokenCache accountTokenCaches;
        final AccountsDb accountsDb;
        private final Map<Account, Map<String, String>> authTokenCache;
        final Object cacheLock;
        private final HashMap<Pair<Pair<Account, String>, Integer>, NotificationId> credentialsPermissionNotificationIds;
        final Object dbLock;
        private final Map<Account, Integer> mCacheSizeForAccount;
        private final Map<String, Map<String, Integer>> mReceiversForType;
        private final HashMap<Account, AtomicReference<String>> previousNameCache;
        private final HashMap<Account, NotificationId> signinRequiredNotificationIds;
        private final Map<Account, Map<String, String>> userDataCache;
        private final int userId;
        private final Map<Account, Map<String, Integer>> visibilityCache;

        /* JADX INFO: renamed from: -$$Nest$fgetaccountTokenCaches, reason: not valid java name */
        static /* bridge */ /* synthetic */ TokenCache m925$$Nest$fgetaccountTokenCaches(UserAccounts r0) {
            return r0.accountTokenCaches;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetauthTokenCache, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m926$$Nest$fgetauthTokenCache(UserAccounts r0) {
            return r0.authTokenCache;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetcredentialsPermissionNotificationIds, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m927$$Nest$fgetcredentialsPermissionNotificationIds(UserAccounts r0) {
            return r0.credentialsPermissionNotificationIds;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCacheSizeForAccount, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m928$$Nest$fgetmCacheSizeForAccount(UserAccounts r0) {
            return r0.mCacheSizeForAccount;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmReceiversForType, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m929$$Nest$fgetmReceiversForType(UserAccounts r0) {
            return r0.mReceiversForType;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetpreviousNameCache, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m930$$Nest$fgetpreviousNameCache(UserAccounts r0) {
            return r0.previousNameCache;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetsigninRequiredNotificationIds, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m931$$Nest$fgetsigninRequiredNotificationIds(UserAccounts r0) {
            return r0.signinRequiredNotificationIds;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuserDataCache, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m932$$Nest$fgetuserDataCache(UserAccounts r0) {
            return r0.userDataCache;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetuserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m933$$Nest$fgetuserId(UserAccounts r0) {
            return r0.userId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetvisibilityCache, reason: not valid java name */
        static /* bridge */ /* synthetic */ Map m934$$Nest$fgetvisibilityCache(UserAccounts r0) {
            return r0.visibilityCache;
        }

        UserAccounts(Context context, int userId, File preNDbFile, File deDbFile) {
            this.credentialsPermissionNotificationIds = new HashMap();
            this.signinRequiredNotificationIds = new HashMap();
            this.cacheLock = new Object();
            this.dbLock = new Object();
            this.accountCache = new LinkedHashMap();
            this.userDataCache = new HashMap();
            this.authTokenCache = new HashMap();
            this.accountTokenCaches = new TokenCache();
            this.visibilityCache = new HashMap();
            this.mCacheSizeForAccount = new HashMap();
            this.mReceiversForType = new HashMap();
            this.previousNameCache = new HashMap();
            this.userId = userId;
            Object r0 = this.dbLock;
            monitor-enter(r0);
            Object r1 = this.cacheLock;     // Catch: Throwable -> L10
            monitor-enter(r1);     // Catch: Throwable -> L10
            this.accountsDb = AccountsDb.create(context, userId, preNDbFile, deDbFile);     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-4efAQFdLKmPHtIOc3lnA6yNExA, reason: not valid java name */
    public static /* synthetic */ void m890$r8$lambda$4efAQFdLKmPHtIOc3lnA6yNExA(AccountManagerService r0, Account r1, int r2, UserAccounts r3) {
        r0.lambda$removeAccountInternal$2(r1, r2, r3);
    }

    public static /* synthetic */ Boolean $r8$lambda$63D9HM8l97WLPV4lVWcCR3b0vjM(AccountManagerService r0, int r1, int r2, String r3) {
        return r0.lambda$canUserModifyAccountsForType$3(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$M4PeVorSM8yDtrZvtwtSZIVFtgg(AccountManagerService r0, int r1) {
        r0.lambda$onUnlockUser$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$Pk_rPF2hnOUnFTjJ14OQgpNTjqc(AccountManagerInternal.OnAppPermissionChangeListener r0, Account r1, int r2) {
        lambda$revokeAppPermission$5(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$a7rqkt8n8S6g9ZoPslveXQWtqJI(AccountManagerInternal.OnAppPermissionChangeListener r0, Account r1, int r2) {
        lambda$grantAppPermission$4(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$dCHM6IInw0xoOkvZVEoLU1YHIzg(String r0) {
        return lambda$resolveAccountVisibility$6(r0);
    }

    public static /* synthetic */ void $r8$lambda$xYCkZ9ihDuMHHecg__N7KAaQLJU(int r0) {
        lambda$new$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppOpsManager m891$$Nest$fgetmAppOpsManager(AccountManagerService r0) {
        return r0.mAppOpsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppPermissionChangeListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ CopyOnWriteArrayList m892$$Nest$fgetmAppPermissionChangeListeners(AccountManagerService r0) {
        return r0.mAppPermissionChangeListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAuthenticatorCache, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAccountAuthenticatorCache m893$$Nest$fgetmAuthenticatorCache(AccountManagerService r0) {
        return r0.mAuthenticatorCache;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDateFormat, reason: not valid java name */
    static /* bridge */ /* synthetic */ SimpleDateFormat m894$$Nest$fgetmDateFormat(AccountManagerService r0) {
        return r0.mDateFormat;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManager m895$$Nest$fgetmPackageManager(AccountManagerService r0) {
        return r0.mPackageManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessions, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedHashMap m896$$Nest$fgetmSessions(AccountManagerService r0) {
        return r0.mSessions;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m897$$Nest$fgetmUsers(AccountManagerService r0) {
        return r0.mUsers;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelAccountAccessRequestNotificationIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m898$$Nest$mcancelAccountAccessRequestNotificationIfNeeded(AccountManagerService r0, int r1, boolean r2, UserAccounts r3) {
        r0.cancelAccountAccessRequestNotificationIfNeeded(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelAccountAccessRequestNotificationIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m899$$Nest$mcancelAccountAccessRequestNotificationIfNeeded(AccountManagerService r0, String r1, int r2, boolean r3, UserAccounts r4) {
        r0.cancelAccountAccessRequestNotificationIfNeeded(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m900$$Nest$mcancelNotification(AccountManagerService r0, NotificationId r1, UserAccounts r2) {
        r0.cancelNotification(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mcompleteCloningAccount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m901$$Nest$mcompleteCloningAccount(AccountManagerService r0, IAccountManagerResponse r1, Bundle r2, Account r3, UserAccounts r4, int r5) {
        r0.completeCloningAccount(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mdoNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m902$$Nest$mdoNotification(AccountManagerService r0, UserAccounts r1, Account r2, CharSequence r3, Intent r4, String r5, int r6) {
        r0.doNotification(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCredentialPermissionNotificationId, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationId m903$$Nest$mgetCredentialPermissionNotificationId(AccountManagerService r0, Account r1, String r2, int r3, UserAccounts r4) {
        return r0.getCredentialPermissionNotificationId(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetSigninRequiredNotificationId, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationId m904$$Nest$mgetSigninRequiredNotificationId(AccountManagerService r0, UserAccounts r1, Account r2) {
        return r0.getSigninRequiredNotificationId(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleGetAccountsResult, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m905$$Nest$mhandleGetAccountsResult(AccountManagerService r0, IAccountManagerResponse r1, Account[] r2, String r3) {
        r0.handleGetAccountsResult(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasAccountAccess, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m906$$Nest$mhasAccountAccess(AccountManagerService r0, Account r1, String r2, int r3) {
        return r0.hasAccountAccess(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$misAccountPresentForCaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m907$$Nest$misAccountPresentForCaller(AccountManagerService r0, String r1, String r2) {
        return r0.isAccountPresentForCaller(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misLocalUnlockedUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m908$$Nest$misLocalUnlockedUser(AccountManagerService r0, int r1) {
        return r0.isLocalUnlockedUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogAddAccountMetrics, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m909$$Nest$mlogAddAccountMetrics(AccountManagerService r0, String r1, String r2, String[] r3, String r4) {
        r0.logAddAccountMetrics(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogGetAuthTokenMetrics, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m910$$Nest$mlogGetAuthTokenMetrics(AccountManagerService r0, String r1, String r2) {
        r0.logGetAuthTokenMetrics(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mnewGrantCredentialsPermissionIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m911$$Nest$mnewGrantCredentialsPermissionIntent(AccountManagerService r0, Account r1, String r2, int r3, AccountAuthenticatorResponse r4, String r5, boolean r6) {
        return r0.newGrantCredentialsPermissionIntent(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mnewRequestAccountAccessIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m912$$Nest$mnewRequestAccountAccessIntent(AccountManagerService r0, Account r1, String r2, int r3, RemoteCallback r4) {
        return r0.newRequestAccountAccessIntent(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mpurgeOldGrantsAll, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m913$$Nest$mpurgeOldGrantsAll(AccountManagerService r0) {
        r0.purgeOldGrantsAll();
    }

    /* JADX INFO: renamed from: -$$Nest$mpurgeUserData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m914$$Nest$mpurgeUserData(AccountManagerService r0, int r1) {
        r0.purgeUserData(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveAccountInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m915$$Nest$mremoveAccountInternal(AccountManagerService r0, UserAccounts r1, Account r2, int r3) {
        return r0.removeAccountInternal(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveVisibilityValuesForPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m916$$Nest$mremoveVisibilityValuesForPackage(AccountManagerService r0, String r1) {
        r0.removeVisibilityValuesForPackage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mresolveAccountVisibility, reason: not valid java name */
    static /* bridge */ /* synthetic */ Integer m917$$Nest$mresolveAccountVisibility(AccountManagerService r0, Account r1, String r2, UserAccounts r3) {
        return r0.resolveAccountVisibility(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msaveAuthTokenToDatabase, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m918$$Nest$msaveAuthTokenToDatabase(AccountManagerService r0, UserAccounts r1, Account r2, String r3, String r4) {
        return r0.saveAuthTokenToDatabase(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$msaveCachedToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m919$$Nest$msaveCachedToken(AccountManagerService r0, UserAccounts r1, Account r2, String r3, byte[] r4, String r5, String r6, long r7) {
        r0.saveCachedToken(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$msendErrorResponse, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m920$$Nest$msendErrorResponse(AccountManagerService r0, IAccountManagerResponse r1, int r2, String r3) {
        r0.sendErrorResponse(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msendResponse, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m921$$Nest$msendResponse(AccountManagerService r0, IAccountManagerResponse r1, Bundle r2) {
        r0.sendResponse(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateLastAuthenticatedTime, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m922$$Nest$mupdateLastAuthenticatedTime(AccountManagerService r0, Account r1) {
        return r0.updateLastAuthenticatedTime(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsResponseLatency, reason: not valid java name */
    static /* bridge */ /* synthetic */ Histogram m923$$Nest$sfgetsResponseLatency() {
        return sResponseLatency;
    }

    public /* bridge */ /* synthetic */ void onServiceChanged(Object r1, int r2, boolean r3) {
        onServiceChanged((AuthenticatorDescription) r1, r2, r3);
    }

    static {
        INTERESTING_APP_OPS = new int[]{62, 4, 5};
        ACCOUNTS_CHANGED_OPTIONS = new BroadcastOptions().setDeliveryGroupPolicy(1).toBundle();
        ACCOUNTS_CHANGED_INTENT = new Intent("android.accounts.LOGIN_ACCOUNTS_CHANGED");
        ACCOUNTS_CHANGED_INTENT.setFlags(AudioFormat.HE_AAC_V1);
        sThis = new AtomicReference();
        EMPTY_ACCOUNT_ARRAY = new Account[0];
        sResponseLatency = new Histogram("app.value_high_authenticator_response_latency", new Histogram.ScaledRangeOptions(20, 10000, 10000.0f, 1.5f));
    }

    public static AccountManagerService getSingleton() {
        return sThis.get();
    }

    public AccountManagerService(Injector injector) {
        this.mSessions = new LinkedHashMap();
        this.mUsers = new SparseArray();
        this.mLocalUnlockedUsers = new SparseBooleanArray();
        this.mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.mAppPermissionChangeListeners = new CopyOnWriteArrayList();
        this.mInjector = injector;
        this.mContext = injector.getContext();
        this.mPackageManager = this.mContext.getPackageManager();
        this.mAppOpsManager = (AppOpsManager) this.mContext.getSystemService(AppOpsManager.class);
        this.mHandler = new MessageHandler(this, injector.getMessageHandlerLooper());
        this.mAuthenticatorCache = this.mInjector.getAccountAuthenticatorCache();
        this.mAuthenticatorCache.setListener(this, this.mHandler);
        sThis.set(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiver(new AnonymousClass1(this), intentFilter);
        AccountManagerServiceIA r2 = null;
        injector.addLocalService(new AccountManagerInternalImpl(this, r2));
        IntentFilter userFilter = new IntentFilter();
        userFilter.addAction("android.intent.action.USER_REMOVED");
        this.mContext.registerReceiverAsUser(new AnonymousClass2(this), UserHandle.ALL, userFilter, null, null);
        this.mPackageMonitor = new AnonymousClass3(this);
        this.mPackageMonitor.register(this.mContext, this.mHandler.getLooper(), UserHandle.ALL, true);
        int i = 0;
    L4:
        if (i >= INTERESTING_APP_OPS.length) goto L6;
        this.mAppOpsManager.startWatchingMode(INTERESTING_APP_OPS[i], null, new OnInterestingAppOpChangedListener(this, r2));
        i = i + 1;
        goto L4
    L6:
        this.mPackageManager.addOnPermissionsChangeListener(new AccountManagerService$$ExternalSyntheticLambda7());
    }

    private static /* synthetic */ void lambda$new$0(int uid) {
        AccountManager.invalidateLocalAccountsDataCaches();
    }

    boolean getBindInstantServiceAllowed(int userId) {
        return this.mAuthenticatorCache.getBindInstantServiceAllowed(userId);
    }

    void setBindInstantServiceAllowed(int userId, boolean allowed) {
        this.mAuthenticatorCache.setBindInstantServiceAllowed(userId, allowed);
    }

    private void cancelAccountAccessRequestNotificationIfNeeded(int uid, boolean checkAccess, UserAccounts userAccounts) {
        Account[] accounts = getAccountsOrEmptyArray(null, UserHandle.getUserId(uid), PackageManagerService.PLATFORM_PACKAGE_NAME);
        int r1 = accounts.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Account account = accounts[r2];
        cancelAccountAccessRequestNotificationIfNeeded(account, uid, checkAccess, userAccounts);
        r2 = r2 + 1;
        goto L3
    }

    private void cancelAccountAccessRequestNotificationIfNeeded(String packageName, int uid, boolean checkAccess, UserAccounts userAccounts) {
        Account[] accounts = getAccountsOrEmptyArray(null, UserHandle.getUserId(uid), PackageManagerService.PLATFORM_PACKAGE_NAME);
        int r1 = accounts.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Account account = accounts[r2];
        cancelAccountAccessRequestNotificationIfNeeded(account, uid, packageName, checkAccess, userAccounts);
        r2 = r2 + 1;
        goto L3
    }

    private void cancelAccountAccessRequestNotificationIfNeeded(Account account, int uid, boolean checkAccess, UserAccounts accounts) {
        String[] packageNames = this.mPackageManager.getPackagesForUid(uid);
        if (packageNames == null) goto L9;
        int r1 = packageNames.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        String packageName = packageNames[r2];
        cancelAccountAccessRequestNotificationIfNeeded(account, uid, packageName, checkAccess, accounts);
        r2 = r2 + 1;
        goto L5
    L11:
        return;
    }

    private void cancelAccountAccessRequestNotificationIfNeeded(Account account, int uid, String packageName, boolean checkAccess, UserAccounts accounts) {
        if (checkAccess == true) goto L4;
    L5:
        cancelNotification(getCredentialPermissionNotificationId(account, "com.android.AccountManager.ACCOUNT_ACCESS_TOKEN_TYPE", uid, accounts), accounts);
        return;
    L4:
        if (hasAccountAccess(account, packageName, UserHandle.getUserHandleForUid(uid)) == true) goto L5;
    }

    public boolean addAccountExplicitlyWithVisibility(Account account, String password, Bundle extras, Map packageToVisibility, String opPackageName) {
        Bundle.setDefusable(extras, true);
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        account.getClass();
        Log.v(TAG, "addAccountExplicitly: caller's uid=" + callingUid + ", pid=" + Binder.getCallingPid() + ", packageName=" + opPackageName + ", accountType=" + account.type);
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L11;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L8
        boolean r0 = addAccountInternal(accounts, account, password, extras, callingUid, packageToVisibility, opPackageName);     // Catch: Throwable -> L8
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r0;
    L8:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L11:
        String msg = String.format("uid=%s, package=%s cannot explicitly add accounts of type: %s", new Object[]{Integer.valueOf(callingUid), opPackageName, account.type});
        throw new SecurityException(msg);
    }

    public Map<Account, Integer> getAccountsAndVisibilityForPackage(String packageName, String accountType) {
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        boolean isSystemUid = UserHandle.isSameApp(callingUid, 1000);
        List<String> managedTypes = getTypesForCaller(callingUid, userId, isSystemUid);
        if (accountType != null) goto L5;
    L6:
        if (accountType != null) goto L11;
        if (isSystemUid == true) goto L11;
    L10:
        throw new SecurityException("getAccountsAndVisibilityForPackage() called from unauthorized uid " + callingUid + " with packageName=" + packageName);
    L11:
        if (accountType == null) goto L13;
        managedTypes = new ArrayList();
        managedTypes.add(accountType);
    L13:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L17
        Map<Account, Integer> r7 = getAccountsAndVisibilityForPackage(packageName, managedTypes, Integer.valueOf(callingUid), accounts);     // Catch: Throwable -> L17
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r7;
    L17:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L5:
        if (managedTypes.contains(accountType) == false) goto L10;
        goto L6
    }

    private Map<Account, Integer> getAccountsAndVisibilityForPackage(String packageName, List<String> accountTypes, Integer callingUid, UserAccounts accounts) {
        if (canCallerAccessPackage(packageName, callingUid.intValue(), UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L6;
        Log.w(TAG, "getAccountsAndVisibilityForPackage#Package not found " + packageName);
        return new LinkedHashMap();
    L6:
        Map<Account, Integer> result = new LinkedHashMap();
        Iterator<String> r1 = accountTypes.iterator();
    L8:
        if (r1.hasNext() == false) goto L30;
        String accountType = r1.next();
        Object r3 = accounts.dbLock;
        monitor-enter(r3);
        Object r4 = accounts.cacheLock;     // Catch: Throwable -> L23
        monitor-enter(r4);     // Catch: Throwable -> L23
        Account[] accountsOfType = accounts.accountCache.get(accountType);     // Catch: Throwable -> L18
        if (accountsOfType == null) goto L20;
        int r6 = accountsOfType.length;     // Catch: Throwable -> L18
        int r7 = 0;
    L16:
        if (r7 >= r6) goto L20;
        Account account = accountsOfType[r7];     // Catch: Throwable -> L18
        result.put(account, resolveAccountVisibility(account, packageName, callingUid.intValue(), accounts));     // Catch: Throwable -> L18
        r7 = r7 + 1;     // Catch: Throwable -> L18
    L20:
        monitor-exit(r4);     // Catch: Throwable -> L18
        monitor-exit(r3);     // Catch: Throwable -> L23
        goto L8
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L30:
        return filterSharedAccounts(accounts, result, callingUid.intValue(), packageName);
    }

    public Map<String, Integer> getPackagesAndVisibilityForAccount(Account account) {
        account.getClass();
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L5;
    L9:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L26
        Object r5 = accounts.dbLock;     // Catch: Throwable -> L26
        monitor-enter(r5);     // Catch: Throwable -> L26
        Object r6 = accounts.cacheLock;     // Catch: Throwable -> L19
        monitor-enter(r6);     // Catch: Throwable -> L19
        Map<String, Integer> r7 = getPackagesAndVisibilityForAccountLocked(account, accounts);     // Catch: Throwable -> L21
        monitor-exit(r6);     // Catch: Throwable -> L21
        monitor-exit(r5);     // Catch: Throwable -> L19
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r7;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L5:
        if (isSystemUid(callingUid) == true) goto L9;
        String msg = String.format("uid %s cannot get secrets for account %s", new Object[]{Integer.valueOf(callingUid), account});
        throw new SecurityException(msg);
    }

    private Map<String, Integer> getPackagesAndVisibilityForAccountLocked(Account account, UserAccounts accounts) {
        Map<String, Integer> accountVisibility = (Map) UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).get(account);
        if (accountVisibility != null) goto L6;
        Log.d(TAG, "Visibility was not initialized");
        HashMap r1 = new HashMap();
        UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).put(account, r1);
        AccountManager.invalidateLocalAccountsDataCaches();
        return r1;
    L6:
        return accountVisibility;
    }

    public int getAccountVisibility(Account account, String packageName) {
        account.getClass();
        packageName.getClass();
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L5;
    L9:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L18
        if ("android:accounts:key_legacy_visible".equals(packageName) == false) goto L21;
        int visibility = getAccountVisibilityFromCache(account, packageName, accounts);     // Catch: Throwable -> L18
        if (visibility == 0) goto L16;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return visibility;
    L16:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return 2;
    L21:
        if ("android:accounts:key_legacy_not_visible".equals(packageName) == false) goto L29;
        int visibility2 = getAccountVisibilityFromCache(account, packageName, accounts);     // Catch: Throwable -> L18
        if (visibility2 == 0) goto L26;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return visibility2;
    L26:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return 4;
    L29:
        if (canCallerAccessPackage(packageName, callingUid, UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L32;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return 3;
    L32:
        int r5 = resolveAccountVisibility(account, packageName, callingUid, accounts).intValue();     // Catch: Throwable -> L18
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r5;
    L18:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L5:
        if (isSystemUid(callingUid) == true) goto L9;
        String msg = String.format("uid %s cannot get secrets for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    }

    private int getAccountVisibilityFromCache(Account account, String packageName, UserAccounts accounts) {
        Object r0 = accounts.cacheLock;
        monitor-enter(r0);
        Map<String, Integer> accountVisibility = getPackagesAndVisibilityForAccountLocked(account, accounts);     // Catch: Throwable -> L7
        Integer visibility = accountVisibility.get(packageName);     // Catch: Throwable -> L7
        if (visibility == null) goto L9;
        int r3 = visibility.intValue();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r3;
    L9:
        r3 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    private Integer resolveAccountVisibility(Account account, String packageName, UserAccounts accounts) {
        packageName.getClass();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();     // Catch: PackageManager.NameNotFoundException -> L42
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, UserAccounts.m933$$Nest$fgetuserId(accounts));     // Catch: Throwable -> L44
    L6:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L42
        if (UserHandle.isSameApp(uid, 1000) == true) goto L10;
        int signatureCheckResult = checkPackageSignature(account.type, uid, UserAccounts.m933$$Nest$fgetuserId(accounts));
        if (signatureCheckResult == 2) goto L14;
        int visibility = getAccountVisibilityFromCache(account, packageName, accounts);
        if (visibility != 0) goto L18;
        boolean isPrivileged = isPermittedForPackage(packageName, UserAccounts.m933$$Nest$fgetuserId(accounts), new String[]{"android.permission.GET_ACCOUNTS_PRIVILEGED"});
        if (isProfileOwner(uid) == true) goto L22;
        boolean preO = isPreOApplication(packageName);
        if (signatureCheckResult != 0) goto L37;
        if (preO == false) goto L29;
        if (checkGetAccountsPermission(packageName, UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L37;
    L29:
        if (checkReadContactsPermission(packageName, UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L31;
    L32:
        if (isPrivileged == true) goto L37;
        int visibility2 = getAccountVisibilityFromCache(account, "android:accounts:key_legacy_not_visible", accounts);
        if (visibility2 != 0) goto L41;
        visibility2 = 4;
    L41:
        return Integer.valueOf(visibility2);
    L31:
        if (accountTypeManagesContacts(account.type, UserAccounts.m933$$Nest$fgetuserId(accounts)) == false) goto L32;
    L37:
        visibility2 = getAccountVisibilityFromCache(account, "android:accounts:key_legacy_visible", accounts);
        if (visibility2 != 0) goto L41;
        visibility2 = 2;
        goto L41
    L22:
        return 1;
    L18:
        return Integer.valueOf(visibility);
    L14:
        return 1;
    L10:
        return 1;
    L44:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L42
        throw th;     // Catch: PackageManager.NameNotFoundException -> L42
    L42:
        e = move-exception;
        Log.w(TAG, "resolveAccountVisibility#Package not found " + e.getMessage());
        return 3;
    }

    private boolean isPreOApplication(String packageName) {
        long identityToken = IAccountManager.Stub.clearCallingIdentity();     // Catch: PackageManager.NameNotFoundException -> L12
        ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(packageName, 0);     // Catch: Throwable -> L15
        IAccountManager.Stub.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L12
        if (applicationInfo == null) goto L14;
        int version = applicationInfo.targetSdkVersion;     // Catch: PackageManager.NameNotFoundException -> L12
        if (version >= 26) goto L11;
        return true;
    L11:
        return false;
    L14:
        return true;
    L15:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L12
        throw th;     // Catch: PackageManager.NameNotFoundException -> L12
    L12:
        e = move-exception;
        Log.w(TAG, "isPreOApplication#Package not found " + e.getMessage());
        return true;
    }

    public boolean setAccountVisibility(Account account, String packageName, int newVisibility) {
        account.getClass();
        packageName.getClass();
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L5;
    L9:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L17
        boolean r12 = setAccountVisibility(account, packageName, newVisibility, true, accounts, callingUid);     // Catch: Throwable -> L15
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r12;
    L15:
        th = move-exception;
        Throwable r13 = th;
    L19:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw r13;
    L17:
        th = move-exception;
        r13 = th;
        goto L19
    L5:
        if (isSystemUid(callingUid) == true) goto L9;
        String msg = String.format("uid %s cannot get secrets for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    }

    private boolean isVisible(int visibility) {
        if (visibility != 1) goto L5;
        return true;
    L5:
        if (visibility == 2) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean setAccountVisibility(Account account, String packageName, int newVisibility, boolean notify, UserAccounts accounts, int callingUid) {
        Object r7 = accounts.dbLock;
        monitor-enter(r7);
        Object r8 = accounts.cacheLock;     // Catch: Throwable -> L18
        monitor-enter(r8);     // Catch: Throwable -> L18
        if (notify == false) goto L24;
        if (isSpecialPackageKey(packageName) == false) goto L14;
        Map<String, Integer> packagesToVisibility = getRequestingPackages(account, accounts);     // Catch: Throwable -> L11
        List<String> accountRemovedReceivers = getAccountRemovedReceivers(account, accounts);     // Catch: Throwable -> L11
    L31:
        if (notify == false) goto L37;
        Integer oldVisibility = accounts.accountsDb.findAccountVisibility(account, packageName);     // Catch: Throwable -> L11
        if (oldVisibility == null) goto L37;
        if (oldVisibility.intValue() != newVisibility) goto L37;
        boolean notify2 = false;
    L39:
        if (updateAccountVisibilityLocked(account, packageName, newVisibility, accounts) == true) goto L47;
        monitor-exit(r8);     // Catch: Throwable -> L45
        monitor-exit(r7);     // Catch: Throwable -> L43
        return false;
    L47:
        if (notify2 == false) goto L63;
        Log.i(TAG, "Notifying visibility changed for package=" + packageName);     // Catch: Throwable -> L45
        Iterator<Map.Entry<String, Integer>> r0 = packagesToVisibility.entrySet().iterator();     // Catch: Throwable -> L45
    L50:
        if (r0.hasNext() == false) goto L55;
        Map.Entry<String, Integer> packageToVisibility = r0.next();     // Catch: Throwable -> L45
        int oldVisibility2 = packageToVisibility.getValue().intValue();     // Catch: Throwable -> L45
        int currentVisibility = resolveAccountVisibility(account, packageName, accounts).intValue();     // Catch: Throwable -> L45
        Iterator<Map.Entry<String, Integer>> r20 = r0;
        if (isVisible(oldVisibility2) == isVisible(currentVisibility)) goto L54;
        notifyPackage(packageToVisibility.getKey(), accounts);     // Catch: Throwable -> L45
    L54:
        r0 = r20;
        goto L50
    L55:
        Iterator<String> r1 = accountRemovedReceivers.iterator();     // Catch: Throwable -> L45
    L57:
        if (r1.hasNext() == false) goto L62;
        String packageNameToNotify = r1.next();     // Catch: Throwable -> L45
        int currentVisibility2 = resolveAccountVisibility(account, packageNameToNotify, accounts).intValue();     // Catch: Throwable -> L45
        if (isVisible(currentVisibility2) == true) goto L57;
        sendAccountRemovedBroadcast(account, packageNameToNotify, UserAccounts.m933$$Nest$fgetuserId(accounts), "setAccountVisibility");     // Catch: Throwable -> L45
        goto L57
    L62:
        sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), account.type, "setAccountVisibility");     // Catch: Throwable -> L45
    L63:
        monitor-exit(r8);     // Catch: Throwable -> L45
        monitor-exit(r7);     // Catch: Throwable -> L43
        return true;
    L37:
        notify2 = notify;
        goto L39
    L14:
        if (canCallerAccessPackage(packageName, callingUid, UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L20;
        monitor-exit(r8);     // Catch: Throwable -> L11
        monitor-exit(r7);     // Catch: Throwable -> L18
        return false;
    L20:
        packagesToVisibility = new HashMap();     // Catch: Throwable -> L11
        packagesToVisibility.put(packageName, resolveAccountVisibility(account, packageName, accounts));     // Catch: Throwable -> L11
        accountRemovedReceivers = new ArrayList();     // Catch: Throwable -> L11
        if (shouldNotifyPackageOnAccountRemoval(account, packageName, accounts) == false) goto L31;
        accountRemovedReceivers.add(packageName);     // Catch: Throwable -> L11
        goto L31
    L24:
        if (isSpecialPackageKey(packageName) == false) goto L26;
    L30:
        packagesToVisibility = Collections.emptyMap();     // Catch: Throwable -> L11
        accountRemovedReceivers = Collections.emptyList();     // Catch: Throwable -> L11
        goto L31
    L26:
        if (canCallerAccessPackage(packageName, callingUid, UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L30;
        monitor-exit(r8);     // Catch: Throwable -> L11
        monitor-exit(r7);     // Catch: Throwable -> L18
        return false;
    L45:
        th = th;
    L67:
        monitor-exit(r8);     // Catch: Throwable -> L45
        throw th;     // Catch: Throwable -> L43
    L11:
        th = th;
    L43:
        th = th;
    L69:
        monitor-exit(r7);     // Catch: Throwable -> L43
        throw th;
    L18:
        th = th;
        goto L69
    }

    private boolean updateAccountVisibilityLocked(Account account, String packageName, int newVisibility, UserAccounts accounts) {
        long accountId = accounts.accountsDb.findDeAccountId(account);
        if (accountId >= 0) goto L5;
        return false;
    L5:
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskWrites();
        if (accounts.accountsDb.setAccountVisibility(accountId, packageName, newVisibility) == true) goto L10;
        StrictMode.setThreadPolicy(oldPolicy);
        return false;
    L10:
        StrictMode.setThreadPolicy(oldPolicy);
        Map<String, Integer> accountVisibility = getPackagesAndVisibilityForAccountLocked(account, accounts);
        accountVisibility.put(packageName, Integer.valueOf(newVisibility));
        AccountManager.invalidateLocalAccountsDataCaches();
        return true;
    L12:
        th = move-exception;
        StrictMode.setThreadPolicy(oldPolicy);
        throw th;
    }

    public void registerAccountListener(String[] accountTypes, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        int userId = UserHandle.getCallingUserId();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L6
        registerAccountListener(accountTypes, opPackageName, accounts);     // Catch: Throwable -> L6
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L6:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    private void registerAccountListener(String[] accountTypes, String opPackageName, UserAccounts accounts) {
        Map r0 = UserAccounts.m929$$Nest$fgetmReceiversForType(accounts);
        monitor-enter(r0);
        if (accountTypes == null) goto L22;
    L9:
        int r1 = accountTypes.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L18;
        String type = accountTypes[r2];     // Catch: Throwable -> L7
        Map<String, Integer> receivers = (Map) UserAccounts.m929$$Nest$fgetmReceiversForType(accounts).get(type);     // Catch: Throwable -> L7
        if (receivers != null) goto L14;
        receivers = new HashMap();     // Catch: Throwable -> L7
        UserAccounts.m929$$Nest$fgetmReceiversForType(accounts).put(type, receivers);     // Catch: Throwable -> L7
    L14:
        Integer cnt = receivers.get(opPackageName);     // Catch: Throwable -> L7
        int r6 = 1;
        if (cnt == null) goto L17;
        r6 = 1 + cnt.intValue();     // Catch: Throwable -> L7
    L17:
        receivers.put(opPackageName, Integer.valueOf(r6));     // Catch: Throwable -> L7
        r2 = r2 + 1;     // Catch: Throwable -> L7
        goto L10
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L22:
        accountTypes = new String[]{null};     // Catch: Throwable -> L7
        goto L9
    }

    public void unregisterAccountListener(String[] accountTypes, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        int userId = UserHandle.getCallingUserId();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L6
        unregisterAccountListener(accountTypes, opPackageName, accounts);     // Catch: Throwable -> L6
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L6:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    private void unregisterAccountListener(String[] accountTypes, String opPackageName, UserAccounts accounts) {
        Map r0 = UserAccounts.m929$$Nest$fgetmReceiversForType(accounts);
        monitor-enter(r0);
        if (accountTypes == null) goto L26;
    L9:
        int r1 = accountTypes.length;     // Catch: Throwable -> L7
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L22;
        String type = accountTypes[r2];     // Catch: Throwable -> L7
        Map<String, Integer> receivers = (Map) UserAccounts.m929$$Nest$fgetmReceiversForType(accounts).get(type);     // Catch: Throwable -> L7
        if (receivers == null) goto L21;
        if (receivers.get(opPackageName) == null) goto L21;
        Integer cnt = receivers.get(opPackageName);     // Catch: Throwable -> L7
        if (cnt.intValue() != 1) goto L18;
        receivers.remove(opPackageName);     // Catch: Throwable -> L7
    L19:
        r2 = r2 + 1;     // Catch: Throwable -> L7
        goto L10
    L18:
        receivers.put(opPackageName, Integer.valueOf(cnt.intValue() - 1));     // Catch: Throwable -> L7
    L21:
        throw new IllegalArgumentException("attempt to unregister wrong receiver");     // Catch: Throwable -> L7
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L26:
        accountTypes = new String[]{null};     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void sendNotificationAccountUpdated(Account account, UserAccounts accounts) {
        Map<String, Integer> packagesToVisibility = getRequestingPackages(account, accounts);
        Iterator<Map.Entry<String, Integer>> r1 = packagesToVisibility.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<String, Integer> packageToVisibility = r1.next();
        if (packageToVisibility.getValue().intValue() == 3) goto L4;
        if (packageToVisibility.getValue().intValue() == 4) goto L4;
        notifyPackage(packageToVisibility.getKey(), accounts);
        goto L4
    }

    private void notifyPackage(String packageName, UserAccounts accounts) {
        Log.i(TAG, "notifying package=" + packageName + " for userId=" + UserAccounts.m933$$Nest$fgetuserId(accounts) + ", sending broadcast of android.accounts.action.VISIBLE_ACCOUNTS_CHANGED");
        Intent intent = new Intent("android.accounts.action.VISIBLE_ACCOUNTS_CHANGED");
        intent.setPackage(packageName);
        intent.setFlags(1073741824);
        this.mContext.sendBroadcastAsUser(intent, new UserHandle(UserAccounts.m933$$Nest$fgetuserId(accounts)));
    }

    private Map<String, Integer> getRequestingPackages(Account account, UserAccounts accounts) {
        Set<String> packages = new HashSet();
        Map r1 = UserAccounts.m929$$Nest$fgetmReceiversForType(accounts);
        monitor-enter(r1);
        String[] r2 = {account.type, null};     // Catch: Throwable -> L10
        int r3 = 0;
    L6:
        if (r3 >= 2) goto L13;
        String type = r2[r3];     // Catch: Throwable -> L10
        Map<String, Integer> receivers = (Map) UserAccounts.m929$$Nest$fgetmReceiversForType(accounts).get(type);     // Catch: Throwable -> L10
        if (receivers == null) goto L12;
        packages.addAll(receivers.keySet());     // Catch: Throwable -> L10
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        Map<String, Integer> result = new HashMap();
        Iterator<String> r4 = packages.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        String packageName = r4.next();
        result.put(packageName, resolveAccountVisibility(account, packageName, accounts));
        goto L16
    L18:
        return result;
    L10:
        th = move-exception;
        throw th;
    }

    private List<String> getAccountRemovedReceivers(Account account, UserAccounts accounts) {
        Intent intent = new Intent("android.accounts.action.ACCOUNT_REMOVED");
        intent.setFlags(16777216);
        List<ResolveInfo> receivers = this.mPackageManager.queryBroadcastReceiversAsUser(intent, 0, UserAccounts.m933$$Nest$fgetuserId(accounts));
        List<String> result = new ArrayList();
        if (receivers != null) goto L5;
        return result;
    L5:
        Iterator<ResolveInfo> r3 = receivers.iterator();
    L7:
        if (r3.hasNext() == false) goto L14;
        ResolveInfo resolveInfo = r3.next();
        String packageName = resolveInfo.activityInfo.applicationInfo.packageName;
        int visibility = resolveAccountVisibility(account, packageName, resolveInfo.activityInfo.applicationInfo.uid, accounts).intValue();
        if (visibility == 1) goto L12;
        if (visibility != 2) goto L7;
    L12:
        result.add(packageName);
        goto L7
    L14:
        return result;
    }

    private boolean shouldNotifyPackageOnAccountRemoval(Account account, String packageName, UserAccounts accounts) {
        int visibility = resolveAccountVisibility(account, packageName, accounts).intValue();
        if (visibility != 1) goto L5;
    L7:
        Intent intent = new Intent("android.accounts.action.ACCOUNT_REMOVED");
        intent.setFlags(16777216);
        intent.setPackage(packageName);
        List<ResolveInfo> receivers = this.mPackageManager.queryBroadcastReceiversAsUser(intent, 0, UserAccounts.m933$$Nest$fgetuserId(accounts));
        if (receivers != null) goto L10;
        return false;
    L10:
        if (receivers.size() > 0) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (visibility == 2) goto L7;
        return false;
    }

    private boolean isSpecialPackageKey(String packageName) {
        if ("android:accounts:key_legacy_visible".equals(packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if ("android:accounts:key_legacy_not_visible".equals(packageName) == true) goto L8;
        return false;
    }

    private void sendAccountsChangedBroadcast(int userId, String accountType, String useCase) {
        useCase.getClass();
        StringBuilder r0 = new StringBuilder();
        r0.append("the accountType= ");
        if (accountType != null) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        r0.append(" changed with useCase=");
        r0.append(useCase);
        r0.append(" for userId=");
        r0.append(userId);
        r0.append(", sending broadcast of ");
        r0.append(ACCOUNTS_CHANGED_INTENT.getAction());
        Log.i(TAG, r0.toString());
        this.mContext.sendBroadcastAsUser(ACCOUNTS_CHANGED_INTENT, new UserHandle(userId), null, ACCOUNTS_CHANGED_OPTIONS);
        return;
    L5:
        r1 = accountType;
        goto L6
    }

    private void sendAccountRemovedBroadcast(Account account, String packageName, int userId, String useCase) {
        useCase.getClass();
        Log.i(TAG, "the account with type=" + account.type + " removed while useCase=" + useCase + " for userId=" + userId + ", sending broadcast of android.accounts.action.ACCOUNT_REMOVED");
        Intent intent = new Intent("android.accounts.action.ACCOUNT_REMOVED");
        intent.setFlags(16777216);
        intent.setPackage(packageName);
        intent.putExtra("authAccount", account.name);
        intent.putExtra("accountType", account.type);
        this.mContext.sendBroadcastAsUser(intent, new UserHandle(userId));
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    L4:
        e = move-exception;
        if ((e instanceof SecurityException) == false) goto L8;
    L10:
        throw e;
    L8:
        if ((e instanceof IllegalArgumentException) == true) goto L10;
        Slog.wtf(TAG, "Account Manager Crash", e);
        goto L10
    }

    private UserManager getUserManager() {
        if (this.mUserManager != null) goto L6;
        this.mUserManager = UserManager.get(this.mContext);
    L6:
        return this.mUserManager;
    }

    public void validateAccounts(int userId) {
        UserAccounts accounts = getUserAccounts(userId);
        validateAccountsInternal(accounts, true);
    }

    private int computeEntrySize(String key, String value) {
        int valueSize = 1;
        if (key == null) goto L5;
        int keySize = key.length();
    L6:
        if (value == null) goto L9;
        valueSize = value.length();
    L9:
        return (keySize + valueSize) + 20;
    L5:
        keySize = 1;
        goto L6
    }

    private boolean shouldBlockDatabaseWrite(UserAccounts accounts, Account account, String key, String value) {
        int usedStorage = ((Integer) UserAccounts.m928$$Nest$fgetmCacheSizeForAccount(accounts).getOrDefault(account, 0)).intValue() + computeEntrySize(key, value);
        UserAccounts.m928$$Nest$fgetmCacheSizeForAccount(accounts).put(account, Integer.valueOf(usedStorage));
        if (usedStorage >= 300000) goto L5;
        return false;
    L5:
        long numberOfAccounts = 0;
        Iterator<Account[]> r5 = accounts.accountCache.values().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Account[] accountsPerType = r5.next();
        if (accountsPerType == null) goto L7;
        numberOfAccounts = numberOfAccounts + ((long) accountsPerType.length);
        goto L7
    L13:
        if (numberOfAccounts == 0) goto L15;
        long numberOfAccounts2 = numberOfAccounts;
    L16:
        long numberOfAccounts3 = usedStorage;
        if (numberOfAccounts3 >= (30000000 / numberOfAccounts2)) goto L19;
        return false;
    L19:
        recomputeCacheSizeForAccountLocked(accounts, account);
        int usedStorage2 = ((Integer) UserAccounts.m928$$Nest$fgetmCacheSizeForAccount(accounts).getOrDefault(account, 0)).intValue() + computeEntrySize(key, value);
        UserAccounts.m928$$Nest$fgetmCacheSizeForAccount(accounts).put(account, Integer.valueOf(usedStorage2));
        if (usedStorage2 >= (30000000 / numberOfAccounts2)) goto L22;
        return false;
    L22:
        Log.w(TAG, "Account of type=" + account.type + " uses too much storage: " + usedStorage2);
        return true;
    L15:
        numberOfAccounts2 = 1;
        goto L16
    }

    private void recomputeCacheSizeForAccountLocked(UserAccounts accounts, Account account) {
        Map<String, String> userDataForAccount = (Map) UserAccounts.m932$$Nest$fgetuserDataCache(accounts).get(account);
        Map<String, String> authTokensForAccount = (Map) UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).get(account);
        int usedStorage = 0;
        if (userDataForAccount == null) goto L8;
        Iterator<Map.Entry<String, String>> r3 = userDataForAccount.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<String, String> entry = r3.next();
        usedStorage = usedStorage + computeEntrySize(entry.getKey(), entry.getValue());
    L8:
        if (authTokensForAccount == null) goto L13;
        Iterator<Map.Entry<String, String>> r4 = authTokensForAccount.entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        Map.Entry<String, String> entry2 = r4.next();
        usedStorage = usedStorage + computeEntrySize(entry2.getKey(), entry2.getValue());
    L13:
        UserAccounts.m928$$Nest$fgetmCacheSizeForAccount(accounts).put(account, Integer.valueOf(usedStorage));
    }

    private void validateAccountsInternal(UserAccounts accounts, boolean invalidateAuthenticatorCache) {
        AccountManagerService r1 = this;
        if (Log.isLoggable(TAG, 3) == false) goto L5;
        Log.d(TAG, "validateAccountsInternal " + UserAccounts.m933$$Nest$fgetuserId(accounts) + " isCeDatabaseAttached=" + accounts.accountsDb.isCeDatabaseAttached() + " userLocked=" + r1.mLocalUnlockedUsers.get(UserAccounts.m933$$Nest$fgetuserId(accounts)));
    L5:
        if (invalidateAuthenticatorCache == false) goto L7;
        r1.mAuthenticatorCache.invalidateCache(UserAccounts.m933$$Nest$fgetuserId(accounts));
    L7:
        HashMap<String, Integer> knownAuth = getAuthenticatorTypeAndUIDForUser(r1.mAuthenticatorCache, UserAccounts.m933$$Nest$fgetuserId(accounts));
        boolean userUnlocked = r1.isLocalUnlockedUser(UserAccounts.m933$$Nest$fgetuserId(accounts));
        Object r9 = accounts.dbLock;
        monitor-enter(r9);
        Object r10 = accounts.cacheLock;     // Catch: Throwable -> L121
        monitor-enter(r10);     // Catch: Throwable -> L121
        boolean accountDeleted = false;
        AccountsDb accountsDb = accounts.accountsDb;     // Catch: Throwable -> L117
        Map<String, Integer> metaAuthUid = accountsDb.findMetaAuthUid();     // Catch: Throwable -> L117
        HashSet<String> obsoleteAuthType = Sets.newHashSet();     // Catch: Throwable -> L117
        Iterator<Map.Entry<String, Integer>> r3 = metaAuthUid.entrySet().iterator();     // Catch: Throwable -> L117
        SparseBooleanArray knownUids = null;
    L14:
        if (r3.hasNext() == false) goto L35;
        Map.Entry<String, Integer> authToUidEntry = r3.next();     // Catch: Throwable -> L20
        String type = authToUidEntry.getKey();     // Catch: Throwable -> L20
        int uid = authToUidEntry.getValue().intValue();     // Catch: Throwable -> L20
        Integer knownUid = knownAuth.get(type);     // Catch: Throwable -> L20
        if (knownUid == null) goto L23;
        if (uid != knownUid.intValue()) goto L23;
        knownAuth.remove(type);     // Catch: Throwable -> L20
    L34:
        accountDeleted = accountDeleted;
        r3 = r3;
    L23:
        if (knownUids != null) goto L26;
        knownUids = r1.getUidsOfInstalledOrUpdatedPackagesAsUser(UserAccounts.m933$$Nest$fgetuserId(accounts));     // Catch: Throwable -> L20
    L26:
        if (knownUids.get(uid) == true) goto L28;
        obsoleteAuthType.add(type);     // Catch: Throwable -> L20
        accountsDb.deleteMetaByAuthTypeAndUid(type, uid);     // Catch: Throwable -> L20
        goto L34
    L28:
        if (knownUid == null) goto L34;
        if (knownUid.intValue() == uid) goto L34;
        Slog.w(TAG, "authenticator no longer exist for type " + type);     // Catch: Throwable -> L20
        obsoleteAuthType.add(type);     // Catch: Throwable -> L20
        accountsDb.deleteMetaByAuthTypeAndUid(type, uid);     // Catch: Throwable -> L20
    L20:
        th = th;
    L119:
        monitor-exit(r10);     // Catch: Throwable -> L106
        throw th;     // Catch: Throwable -> L111
    L35:
        boolean accountDeleted2 = accountDeleted;
        Iterator<Map.Entry<String, Integer>> r0 = knownAuth.entrySet().iterator();     // Catch: Throwable -> L117
    L38:
        if (r0.hasNext() == false) goto L45;
        Map.Entry<String, Integer> entry = r0.next();     // Catch: Throwable -> L20
        String type2 = entry.getKey();     // Catch: Throwable -> L20
        Integer newUid = entry.getValue();     // Catch: Throwable -> L20
        if (Objects.equals(metaAuthUid.get(type2), newUid) == true) goto L43;
        FrameworkStatsLog.write(FrameworkStatsLog.ACCOUNT_MANAGER_EVENT, type2, newUid.intValue(), 1);     // Catch: Throwable -> L20
    L43:
        accountsDb.insertOrReplaceMetaAuthTypeAndUid(type2, newUid.intValue());     // Catch: Throwable -> L20
        r0 = r0;
        goto L38
    L45:
        Map<Long, Account> accountsMap = accountsDb.findAllDeAccounts();     // Catch: Throwable -> L117
        accounts.accountCache.clear();     // Catch: Throwable -> L88
        HashMap<String, ArrayList<String>> accountNamesByType = new LinkedHashMap();     // Catch: Throwable -> L88
        Iterator<Map.Entry<Long, Account>> r2 = accountsMap.entrySet().iterator();     // Catch: Throwable -> L88
    L49:
        if (r2.hasNext() == false) goto L95;
        Map.Entry<Long, Account> accountEntry = r2.next();     // Catch: Throwable -> L88
        long accountId = accountEntry.getKey().longValue();     // Catch: Throwable -> L88
        Account account = accountEntry.getValue();     // Catch: Throwable -> L88
        Iterator<Map.Entry<Long, Account>> r18 = r2;
        if (obsoleteAuthType.contains(account.type) == false) goto L90;
        HashMap<String, ArrayList<String>> accountNamesByType2 = accountNamesByType;
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L88
        r4.append("deleting account ");     // Catch: Throwable -> L82
        r4.append(account.toSafeString());     // Catch: Throwable -> L82
        r4.append(" because type ");     // Catch: Throwable -> L82
        r4.append(account.type);     // Catch: Throwable -> L82
        r4.append("'s registered authenticator no longer exist.");     // Catch: Throwable -> L82
        Slog.w(TAG, r4.toString());     // Catch: Throwable -> L82
        Map<String, Integer> packagesToVisibility = r1.getRequestingPackages(account, accounts);     // Catch: Throwable -> L82
        List<String> accountRemovedReceivers = r1.getAccountRemovedReceivers(account, accounts);     // Catch: Throwable -> L82
        accountsDb.beginTransaction();     // Catch: Throwable -> L82
        accountsDb.deleteDeAccount(accountId);     // Catch: Throwable -> L84
        if (userUnlocked == true) goto L141;
    L61:
        accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L84
        accountsDb.endTransaction();     // Catch: Throwable -> L82
        accountDeleted2 = true;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L82
        r5.append("validateAccountsInternal#Deleted UserId=");     // Catch: Throwable -> L79
        r5.append(UserAccounts.m933$$Nest$fgetuserId(accounts));     // Catch: Throwable -> L79
        r5.append(", AccountId=");     // Catch: Throwable -> L79
        r5.append(accountId);     // Catch: Throwable -> L79
        Log.i(TAG, r5.toString());     // Catch: Throwable -> L79
        HashMap<String, ArrayList<String>> accountNamesByType3 = accountNamesByType2;
        r1 = this;
        r1.logRecord(AccountsDb.DEBUG_ACTION_AUTHENTICATOR_REMOVE, "accounts", accountId, accounts);     // Catch: Throwable -> L71
        UserAccounts.m932$$Nest$fgetuserDataCache(accounts).remove(account);     // Catch: Throwable -> L71
        UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).remove(account);     // Catch: Throwable -> L71
        UserAccounts.m925$$Nest$fgetaccountTokenCaches(accounts).remove(account);     // Catch: Throwable -> L71
        UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).remove(account);     // Catch: Throwable -> L71
        UserAccounts.m928$$Nest$fgetmCacheSizeForAccount(accounts).remove(account);     // Catch: Throwable -> L71
        Iterator<Map.Entry<String, Integer>> r6 = packagesToVisibility.entrySet().iterator();     // Catch: Throwable -> L71
    L67:
        if (r6.hasNext() == false) goto L74;
        Map.Entry<String, Integer> packageToVisibility = r6.next();     // Catch: Throwable -> L71
        if (r1.isVisible(packageToVisibility.getValue().intValue()) == false) goto L67;
        r1.notifyPackage(packageToVisibility.getKey(), accounts);     // Catch: Throwable -> L71
        goto L67
    L74:
        Iterator<String> r7 = accountRemovedReceivers.iterator();     // Catch: Throwable -> L71
    L76:
        if (r7.hasNext() == false) goto L94;
        String packageName = r7.next();     // Catch: Throwable -> L71
        r1.sendAccountRemovedBroadcast(account, packageName, UserAccounts.m933$$Nest$fgetuserId(accounts), "validateAccounts");     // Catch: Throwable -> L71
        r7 = r7;
    L94:
        accountNamesByType = accountNamesByType3;
        r2 = r18;
        userUnlocked = userUnlocked;
        knownAuth = knownAuth;
    L71:
        th = th;
        boolean accountDeleted3 = true;
    L113:
        if (accountDeleted3 == false) goto L116;
        r1.sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), "ambiguous", "validateAccounts");     // Catch: Throwable -> L106
    L116:
        throw th;     // Catch: Throwable -> L106
    L79:
        th = th;
        r1 = this;
    L81:
        accountDeleted3 = accountDeleted2;
        goto L113
    L141:
        accountsDb.deleteCeAccount(accountId);     // Catch: Throwable -> L59
    L59:
        th = th;
    L86:
        accountsDb.endTransaction();     // Catch: Throwable -> L71
        throw th;     // Catch: Throwable -> L71
    L84:
        th = th;
    L82:
        th = th;
        goto L81
    L90:
        accountNamesByType3 = accountNamesByType;
        ArrayList<String> accountNames = accountNamesByType3.get(account.type);     // Catch: Throwable -> L71
        if (accountNames != null) goto L93;
        accountNames = new ArrayList();     // Catch: Throwable -> L71
        accountNamesByType3.put(account.type, accountNames);     // Catch: Throwable -> L71
    L93:
        accountNames.add(account.name);     // Catch: Throwable -> L71
        goto L94
    L95:
        Iterator<Map.Entry<String, ArrayList<String>>> r8 = accountNamesByType.entrySet().iterator();     // Catch: Throwable -> L71
    L97:
        if (r8.hasNext() == false) goto L103;
        Map.Entry<String, ArrayList<String>> cur = r8.next();     // Catch: Throwable -> L71
        String accountType = cur.getKey();     // Catch: Throwable -> L71
        ArrayList<String> accountNames2 = cur.getValue();     // Catch: Throwable -> L71
        Account[] accountsForType = new Account[accountNames2.size()];     // Catch: Throwable -> L71
        int i = 0;
    L99:
        Iterator<Map.Entry<String, ArrayList<String>>> r16 = r8;
        if (i >= accountsForType.length) goto L102;
        accountsForType[i] = new Account(accountNames2.get(i), accountType, UUID.randomUUID().toString());     // Catch: Throwable -> L71
        i = i + 1;     // Catch: Throwable -> L71
        r8 = r16;
        cur = cur;
        accountNames2 = accountNames2;
        goto L99
    L102:
        accounts.accountCache.put(accountType, accountsForType);     // Catch: Throwable -> L71
        r8 = r16;
        goto L97
    L103:
        UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).putAll(accountsDb.findAllVisibilityValues());     // Catch: Throwable -> L71
        AccountManager.invalidateLocalAccountsDataCaches();     // Catch: Throwable -> L71
        if (accountDeleted2 == false) goto L108;
        r1.sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), "ambiguous", "validateAccounts");     // Catch: Throwable -> L106
    L108:
        monitor-exit(r10);     // Catch: Throwable -> L106
        monitor-exit(r9);     // Catch: Throwable -> L111
        return;
    L88:
        th = th;
        accountDeleted3 = accountDeleted2;
    L106:
        th = th;
    L117:
        th = th;
    L121:
        th = th;
    L123:
        monitor-exit(r9);     // Catch: Throwable -> L111
        throw th;
    L111:
        th = th;
        goto L123
    }

    private SparseBooleanArray getUidsOfInstalledOrUpdatedPackagesAsUser(int userId) {
        List<PackageInfo> pkgsWithData = this.mPackageManager.getInstalledPackagesAsUser(8192, userId);
        SparseBooleanArray knownUids = new SparseBooleanArray(pkgsWithData.size());
        Iterator<PackageInfo> r2 = pkgsWithData.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        PackageInfo pkgInfo = r2.next();
        if (pkgInfo.applicationInfo == null) goto L4;
        if ((pkgInfo.applicationInfo.flags & 8388608) == 0) goto L4;
        knownUids.put(pkgInfo.applicationInfo.uid, true);
        goto L4
    L11:
        return knownUids;
    }

    static HashMap<String, Integer> getAuthenticatorTypeAndUIDForUser(Context context, int userId) {
        AccountAuthenticatorCache authCache = new AccountAuthenticatorCache(context);
        return getAuthenticatorTypeAndUIDForUser(authCache, userId);
    }

    private static HashMap<String, Integer> getAuthenticatorTypeAndUIDForUser(IAccountAuthenticatorCache authCache, int userId) {
        HashMap<String, Integer> knownAuth = new LinkedHashMap();
        Iterator<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> r1 = authCache.getAllServices(userId).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> service = r1.next();
        knownAuth.put(((AuthenticatorDescription) service.type).type, Integer.valueOf(service.uid));
        goto L4
    L6:
        return knownAuth;
    }

    private UserAccounts getUserAccountsForCaller() {
        return getUserAccounts(UserHandle.getCallingUserId());
    }

    protected UserAccounts getUserAccounts(int userId) {
        return getUserAccountsNotChecked(userId);
    L4:
        e = move-exception;
        if (this.mPackageManager.hasSystemFeature("android.hardware.type.automotive") == false) goto L19;
        Slog.wtf(TAG, "Removing user " + userId + " due to exception (" + e + ") reading its account database");
        if (userId != ActivityManager.getCurrentUser()) goto L16;
        if (userId == 0) goto L16;
        Slog.i(TAG, "Switching to system user first");
        ActivityManager.getService().switchUser(0);     // Catch: RemoteException -> L13
    L13:
        re = move-exception;
        Slog.e(TAG, "Could not switch to 0: " + re);
    L16:
        if (getUserManager().removeUserEvenWhenDisallowed(userId) == true) goto L24;
        Slog.e(TAG, "could not remove user " + userId);
        throw e;
    L24:
        throw e;
    L19:
        throw e;
    }

    private UserAccounts getUserAccountsNotChecked(int userId) {
        SparseArray<UserAccounts> r0 = this.mUsers;
        monitor-enter(r0);
        UserAccounts accounts = this.mUsers.get(userId);     // Catch: Throwable -> L7
        boolean validateAccounts = false;
        if (accounts != null) goto L10;
        File preNDbFile = new File(this.mInjector.getPreNDatabaseName(userId));     // Catch: Throwable -> L7
        File deDbFile = new File(this.mInjector.getDeDatabaseName(userId));     // Catch: Throwable -> L7
        accounts = new UserAccounts(this.mContext, userId, preNDbFile, deDbFile);     // Catch: Throwable -> L7
        this.mUsers.append(userId, accounts);     // Catch: Throwable -> L7
        purgeOldGrants(accounts);     // Catch: Throwable -> L7
        AccountManager.invalidateLocalAccountsDataCaches();     // Catch: Throwable -> L7
        validateAccounts = true;
    L10:
        if (accounts.accountsDb.isCeDatabaseAttached() == false) goto L12;
    L29:
        if (validateAccounts == false) goto L31;
        validateAccountsInternal(accounts, true);     // Catch: Throwable -> L7
    L31:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return accounts;
    L12:
        if (this.mLocalUnlockedUsers.get(userId) == false) goto L29;
        Log.i(TAG, "User " + userId + " is unlocked - opening CE database");     // Catch: Throwable -> L7
        Object r3 = accounts.dbLock;     // Catch: Throwable -> L7
        monitor-enter(r3);     // Catch: Throwable -> L7
        Object r4 = accounts.cacheLock;     // Catch: Throwable -> L22
        monitor-enter(r4);     // Catch: Throwable -> L22
        File ceDatabaseFile = new File(this.mInjector.getCeDatabaseName(userId));     // Catch: Throwable -> L24
        accounts.accountsDb.attachCeDatabase(ceDatabaseFile);     // Catch: Throwable -> L24
        monitor-exit(r4);     // Catch: Throwable -> L24
        monitor-exit(r3);     // Catch: Throwable -> L22
        syncDeCeAccountsLocked(accounts);     // Catch: Throwable -> L7
        goto L29
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private void syncDeCeAccountsLocked(UserAccounts accounts) {
        Preconditions.checkState(Thread.holdsLock(this.mUsers), "mUsers lock must be held");
        List<Account> accountsToRemove = accounts.accountsDb.findCeAccountsNotInDe();
        if (accountsToRemove.isEmpty() == true) goto L8;
        Slog.i(TAG, accountsToRemove.size() + " accounts were previously deleted while user " + UserAccounts.m933$$Nest$fgetuserId(accounts) + " was locked. Removing accounts from CE tables");
        logRecord(accounts, AccountsDb.DEBUG_ACTION_SYNC_DE_CE_ACCOUNTS, "accounts");
        Iterator<Account> r1 = accountsToRemove.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Account account = r1.next();
        removeAccountInternal(accounts, account, 1000);
        goto L6
    L10:
        return;
    }

    private void purgeOldGrantsAll() {
        SparseArray<UserAccounts> r0 = this.mUsers;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mUsers.size()) goto L11;
        purgeOldGrants(this.mUsers.valueAt(i));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void purgeOldGrants(UserAccounts accounts) {
        Object r0 = accounts.dbLock;
        monitor-enter(r0);
        Object r1 = accounts.cacheLock;     // Catch: Throwable -> L22
        monitor-enter(r1);     // Catch: Throwable -> L22
        List<Integer> uids = accounts.accountsDb.findAllUidGrants();     // Catch: Throwable -> L17 SQLiteException -> L24
        Iterator<Integer> r3 = uids.iterator();     // Catch: Throwable -> L17
    L9:
        if (r3.hasNext() == false) goto L19;
        int uid = r3.next().intValue();     // Catch: Throwable -> L17
        if (this.mPackageManager.getPackagesForUid(uid) == null) goto L13;
        boolean packageExists = true;
    L14:
        if (packageExists == true) goto L9;
        Log.d(TAG, "deleting grants for UID " + uid + " because its package is no longer installed");     // Catch: Throwable -> L17
        accounts.accountsDb.deleteGrantsByUid(uid);     // Catch: Throwable -> L17
        goto L9
    L13:
        packageExists = false;
        goto L14
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        Log.w(TAG, "Could not delete grants for user = " + UserAccounts.m933$$Nest$fgetuserId(accounts), e);     // Catch: Throwable -> L17
        return;
    L22:
        th = move-exception;
        throw th;
    }

    private void removeVisibilityValuesForPackage(String packageName) {
        if (isSpecialPackageKey(packageName) == false) goto L5;
        return;
    L5:
        SparseArray<UserAccounts> r0 = this.mUsers;
        monitor-enter(r0);
        int numberOfUsers = this.mUsers.size();     // Catch: Throwable -> L12
        int i = 0;
    L8:
        if (i >= numberOfUsers) goto L40;
        UserAccounts accounts = this.mUsers.valueAt(i);     // Catch: Throwable -> L12
        this.mPackageManager.getPackageUidAsUser(packageName, UserAccounts.m933$$Nest$fgetuserId(accounts));     // Catch: Throwable -> L12 PackageManager.NameNotFoundException -> L14
    L38:
        i = i + 1;     // Catch: Throwable -> L12
    L49:
        accounts.accountsDb.deleteAccountVisibilityForPackage(packageName);     // Catch: Throwable -> L12 SQLiteCantOpenDatabaseException -> L36
    L17:
        monitor-enter(accounts.dbLock);     // Catch: Throwable -> L12
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L19:
        monitor-enter(accounts.cacheLock);     // Catch: Throwable -> L30
        Iterator r7 = UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).keySet().iterator();     // Catch: Throwable -> L24
    L22:
        if (r7.hasNext() == false) goto L26;
        Account account = (Account) r7.next();     // Catch: Throwable -> L24
        Map<String, Integer> accountVisibility = getPackagesAndVisibilityForAccountLocked(account, accounts);     // Catch: Throwable -> L24
        accountVisibility.remove(packageName);     // Catch: Throwable -> L24
        goto L22
    L26:
        AccountManager.invalidateLocalAccountsDataCaches();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L36:
        sqlException = move-exception;
        Log.w(TAG, "Could not delete account visibility for user = " + UserAccounts.m933$$Nest$fgetuserId(accounts), sqlException);     // Catch: Throwable -> L12
        goto L38
    L40:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void purgeUserData(int userId) {
        SparseArray<UserAccounts> r0 = this.mUsers;
        monitor-enter(r0);
        UserAccounts accounts = this.mUsers.get(userId);     // Catch: Throwable -> L23
        this.mUsers.remove(userId);     // Catch: Throwable -> L23
        this.mLocalUnlockedUsers.delete(userId);     // Catch: Throwable -> L23
        AccountManager.invalidateLocalAccountsDataCaches();     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        if (accounts == null) goto L22;
        Object r1 = accounts.dbLock;
        monitor-enter(r1);
        Object r2 = accounts.cacheLock;     // Catch: Throwable -> L15
        monitor-enter(r2);     // Catch: Throwable -> L15
        accounts.accountsDb.closeDebugStatement();     // Catch: Throwable -> L17
        accounts.accountsDb.close();     // Catch: Throwable -> L17
        monitor-exit(r2);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L22:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    void onUserUnlocked(Intent intent) {
        onUnlockUser(intent.getIntExtra("android.intent.extra.user_handle", -1));
    }

    void onUnlockUser(final int userId) {
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "onUserUnlocked " + userId);
    L5:
        SparseArray<UserAccounts> r0 = this.mUsers;
        monitor-enter(r0);
        this.mLocalUnlockedUsers.put(userId, true);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (userId >= 1) goto L11;
        return;
    L11:
        this.mHandler.post(new AccountManagerService$$ExternalSyntheticLambda0(this, userId));
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onUnlockUser$1(int userId) {
        syncSharedAccounts(userId);
    }

    private void syncSharedAccounts(int userId) {
        Account[] sharedAccounts = getSharedAccountsAsUser(userId);
        if (sharedAccounts != null) goto L5;
        return;
    L5:
        if (sharedAccounts.length == 0) goto L19;
        Account[] accounts = getAccountsAsUser(null, userId, this.mContext.getOpPackageName());
        int r4 = sharedAccounts.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L14;
        Account sa = sharedAccounts[r5];
        if (ArrayUtils.contains(accounts, sa) == true) goto L13;
        copyAccountToUser(null, sa, 0, userId);
    L13:
        r5 = r5 + 1;
        goto L8
    L14:
        return;
    }

    public void onServiceChanged(AuthenticatorDescription desc, int userId, boolean removed) {
        UserInfo user = getUserManager().getUserInfo(userId);
        if (user != null) goto L6;
        Log.w(TAG, "onServiceChanged: ignore removed user " + userId);
        return;
    L6:
        validateAccountsInternal(getUserAccounts(userId), false);
    }

    public String getPassword(Account account) {
        SeempLog.record(14);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "getPassword: " + account + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
    L5:
        if (account == null) goto L18;
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L15;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L12
        String r5 = readPasswordInternal(accounts, account);     // Catch: Throwable -> L12
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r5;
    L12:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L15:
        String msg = String.format("uid %s cannot get secrets for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    L18:
        throw new IllegalArgumentException("account is null");
    }

    private String readPasswordInternal(UserAccounts accounts, Account account) {
        if (account != null) goto L6;
        return null;
    L6:
        if (isLocalUnlockedUser(UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L9;
        Log.w(TAG, "Password is not available - user " + UserAccounts.m933$$Nest$fgetuserId(accounts) + " data is locked");
        return null;
    L9:
        Object r0 = accounts.dbLock;
        monitor-enter(r0);
        Object r1 = accounts.cacheLock;     // Catch: Throwable -> L17
        monitor-enter(r1);     // Catch: Throwable -> L17
        String r2 = accounts.accountsDb.findAccountPasswordByNameAndType(account.name, account.type);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r2;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public String getPreviousName(Account account) {
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "getPreviousName: " + account + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
    L5:
        account.getClass();
        int userId = UserHandle.getCallingUserId();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L9
        String r4 = readPreviousNameInternal(accounts, account);     // Catch: Throwable -> L9
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r4;
    L9:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    private String readPreviousNameInternal(UserAccounts accounts, Account account) {
        if (account != null) goto L5;
        return null;
    L5:
        Object r0 = accounts.dbLock;
        monitor-enter(r0);
        Object r1 = accounts.cacheLock;     // Catch: Throwable -> L15
        monitor-enter(r1);     // Catch: Throwable -> L15
        AtomicReference<String> previousNameRef = (AtomicReference) UserAccounts.m930$$Nest$fgetpreviousNameCache(accounts).get(account);     // Catch: Throwable -> L17
        if (previousNameRef != null) goto L19;
        String previousName = accounts.accountsDb.findDeAccountPreviousName(account);     // Catch: Throwable -> L17
        AtomicReference<String> previousNameRef2 = new AtomicReference(previousName);     // Catch: Throwable -> L17
        UserAccounts.m930$$Nest$fgetpreviousNameCache(accounts).put(account, previousNameRef2);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L15
        return previousName;
    L19:
        String r3 = previousNameRef.get();     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r3;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public String getUserData(Account account, String key) {
        SeempLog.record(15);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        String msg = String.format("getUserData( account: %s, key: %s, callerUid: %s, pid: %s", new Object[]{account, key, Integer.valueOf(callingUid), Integer.valueOf(Binder.getCallingPid())});
        Log.v(TAG, msg);
    L5:
        account.getClass();
        key.getClass();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == true) goto L8;
        String msg2 = String.format("uid %s cannot get user data for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg2);
    L8:
        if (isLocalUnlockedUser(userId) == true) goto L11;
        Log.w(TAG, "User " + userId + " data is locked. callingUid " + callingUid);
        return null;
    L11:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L19
        if (accountExistsCache(accounts, account) == true) goto L16;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return null;
    L16:
        String r4 = readUserDataInternal(accounts, account, key);     // Catch: Throwable -> L19
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r4;
    L19:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public AuthenticatorDescription[] getAuthenticatorTypes(int userId) {
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L6;
        Log.v(TAG, "getAuthenticatorTypes: for user id " + userId + " caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L6:
        if (isCrossUser(callingUid, userId) == true) goto L15;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        AuthenticatorDescription[] r3 = getAuthenticatorTypesInternal(userId, callingUid);     // Catch: Throwable -> L11
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r3;
    L11:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L15:
        throw new SecurityException(String.format("User %s tying to get authenticator types for %s", new Object[]{Integer.valueOf(UserHandle.getCallingUserId()), Integer.valueOf(userId)}));
    }

    private AuthenticatorDescription[] getAuthenticatorTypesInternal(int userId, int callingUid) {
        this.mAuthenticatorCache.updateServices(userId);
        Collection<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> authenticatorCollection = this.mAuthenticatorCache.getAllServices(userId);
        List<AuthenticatorDescription> types = new ArrayList(authenticatorCollection.size());
        Iterator<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> r2 = authenticatorCollection.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> authenticator = r2.next();
        if (canCallerAccessPackage(((AuthenticatorDescription) authenticator.type).packageName, callingUid, userId) == false) goto L4;
        types.add((AuthenticatorDescription) authenticator.type);
        goto L4
    L10:
        return (AuthenticatorDescription[]) types.toArray(new AuthenticatorDescription[types.size()]);
    }

    private boolean isCrossUser(int callingUid, int userId) {
        if (userId != UserHandle.getCallingUserId()) goto L5;
    L9:
        return false;
    L5:
        if (callingUid == 1000) goto L9;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) goto L9;
        return true;
    }

    public boolean addAccountExplicitly(Account account, String password, Bundle extras, String opPackageName) {
        return addAccountExplicitlyWithVisibility(account, password, extras, null, opPackageName);
    }

    public void copyAccountToUser(final IAccountManagerResponse response, final Account account, final int userFrom, int userTo) {
        int callingUid = Binder.getCallingUid();
        if (isCrossUser(callingUid, -1) == true) goto L5;
    L9:
        final UserAccounts fromAccounts = getUserAccounts(userFrom);
        final UserAccounts toAccounts = getUserAccounts(userTo);
        if (fromAccounts == null) goto L30;
        if (toAccounts == null) goto L30;
        Slog.d(TAG, "Copying account " + account.toSafeString() + " from user " + userFrom + " to user " + userTo);
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final String r4 = account.type;     // Catch: Throwable -> L25
        final String r7 = account.name;     // Catch: Throwable -> L25
        final boolean r8 = false;
        final boolean r5 = false;
        final boolean r6 = false;
        new AnonymousClass4(this, fromAccounts, response, r4, r5, r6, r7, r8, account, response, toAccounts, userFrom).bind();     // Catch: Throwable -> L21
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L21:
        th = th;
    L27:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L23:
        th = th;
    L25:
        th = th;
    L30:
        if (response == 0) goto L45;
        Bundle result = new Bundle();
        result.putBoolean("booleanResult", false);
        response.onResult(result);     // Catch: RemoteException -> L34
        return;
    L34:
        e = move-exception;
        Slog.w(TAG, "Failed to report error back to the client." + e);
        return;
    L45:
        return;
    L5:
        if (hasCopyAccountsPermission() == true) goto L9;
        throw new SecurityException("Calling copyAccountToUser requires android.permission.INTERACT_ACROSS_USERS_FULL or android.permission.COPY_ACCOUNTS");
    }

    private boolean hasCopyAccountsPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.COPY_ACCOUNTS") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean accountAuthenticated(Account account) {
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        String msg = String.format("accountAuthenticated( account: %s, callerUid: %s)", new Object[]{account, Integer.valueOf(callingUid)});
        Log.v(TAG, msg);
    L5:
        account.getClass();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == true) goto L8;
        String msg2 = String.format("uid %s cannot notify authentication for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg2);
    L8:
        if (canUserModifyAccounts(userId, callingUid) == true) goto L10;
        return false;
    L10:
        if (canUserModifyAccountsForType(userId, account.type, callingUid) == false) goto L25;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        getUserAccounts(userId);     // Catch: Throwable -> L16
        boolean r5 = updateLastAuthenticatedTime(account);     // Catch: Throwable -> L16
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r5;
    L16:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L25:
        return false;
    }

    private boolean updateLastAuthenticatedTime(Account account) {
        UserAccounts accounts = getUserAccountsForCaller();
        Object r1 = accounts.dbLock;
        monitor-enter(r1);
        Object r2 = accounts.cacheLock;     // Catch: Throwable -> L10
        monitor-enter(r2);     // Catch: Throwable -> L10
        boolean r3 = accounts.accountsDb.updateAccountLastAuthenticatedTime(account);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L10
        return r3;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void completeCloningAccount(final IAccountManagerResponse response, final Bundle accountCredentials, final Account account, final UserAccounts targetUser, final int parentUserId) {
        Bundle.setDefusable(accountCredentials, true);
        long id = IAccountManager.Stub.clearCallingIdentity();
        final String r4 = account.type;     // Catch: Throwable -> L6
        final String r7 = account.name;     // Catch: Throwable -> L6
        final boolean r8 = false;
        final boolean r5 = false;
        final boolean r6 = false;
        new AnonymousClass5(this, targetUser, response, r4, r5, r6, r7, r8, account, parentUserId, accountCredentials).bind();     // Catch: Throwable -> L6
        IAccountManager.Stub.restoreCallingIdentity(id);
        return;
    L6:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(id);
        throw th;
    }

    private boolean addAccountInternal(UserAccounts accounts, Account account, String password, Bundle extras, int callingUid, Map<String, Integer> packageToVisibility, String opPackageName) {
        AccountManagerService r1 = this;
        Account r2 = account;
        boolean r0 = true;
        Bundle.setDefusable(extras, true);
        boolean r3 = false;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.name == null) goto L12;
        if (r2.name.length() <= 200) goto L12;
        Log.w(TAG, "Account cannot be added - Name longer than 200 chars");
        return false;
    L12:
        if (r2.type != null) goto L14;
    L17:
        if (password == null) goto L23;
        if (password.length() <= MAXIMUM_PASSWORD_LENGTH) goto L23;
        Log.w(TAG, "Account cannot be added - password is too long");
        return false;
    L23:
        if (r1.isLocalUnlockedUser(UserAccounts.m933$$Nest$fgetuserId(accounts)) == true) goto L26;
        Log.w(TAG, "Account " + r2.toSafeString() + " cannot be added - user " + UserAccounts.m933$$Nest$fgetuserId(accounts) + " is locked. callingUid=" + callingUid);
        return false;
    L26:
        Object r11 = accounts.dbLock;
        monitor-enter(r11);
        Object r12 = accounts.cacheLock;     // Catch: Throwable -> L38
        monitor-enter(r12);     // Catch: Throwable -> L38
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L41
        long r13 = 0;
        if (accounts.accountsDb.findCeAccountId(r2) < 0) goto L48;
        Log.w(TAG, "insertAccountIntoDatabase: " + r2.toSafeString() + ", skipping since the account already exists");     // Catch: Throwable -> L44
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L41
        monitor-exit(r12);     // Catch: Throwable -> L41
        monitor-exit(r11);     // Catch: Throwable -> L38
        return false;
    L48:
        if (accounts.accountsDb.findAllDeAccounts().size() <= 100) goto L54;
        Log.w(TAG, "insertAccountIntoDatabase: " + r2.toSafeString() + ", skipping since more than 100 accounts on device exist");     // Catch: Throwable -> L44
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L41
        monitor-exit(r12);     // Catch: Throwable -> L41
        monitor-exit(r11);     // Catch: Throwable -> L38
        return false;
    L54:
        long accountId = accounts.accountsDb.insertCeAccount(r2, password);     // Catch: Throwable -> L44
        if (accountId >= 0) goto L62;
        Log.w(TAG, "insertAccountIntoDatabase: " + r2.toSafeString() + ", skipping the DB insert failed");     // Catch: Throwable -> L44
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L41
        monitor-exit(r12);     // Catch: Throwable -> L41
        monitor-exit(r11);     // Catch: Throwable -> L38
        return false;
    L62:
        if (accounts.accountsDb.insertDeAccount(r2, accountId) >= 0) goto L68;
        Log.w(TAG, "insertAccountIntoDatabase: " + r2.toSafeString() + ", skipping the DB insert failed");     // Catch: Throwable -> L44
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L41
        monitor-exit(r12);     // Catch: Throwable -> L41
        monitor-exit(r11);     // Catch: Throwable -> L38
        return false;
    L68:
        if (extras == null) goto L82;
        Iterator<String> r15 = extras.keySet().iterator();     // Catch: Throwable -> L44
    L71:
        if (r15.hasNext() == false) goto L81;
        String key = r15.next();     // Catch: Throwable -> L44
        boolean r16 = r0;
        String value = extras.getString(key);     // Catch: Throwable -> L44
        boolean r17 = r3;
        long r19 = r13;
        if (accounts.accountsDb.insertExtra(accountId, key, value) < r19) goto L74;
        AccountManager.invalidateLocalAccountUserDataCaches();     // Catch: Throwable -> L44
        r0 = r16;
        r3 = r17;
        r13 = r19;
        goto L71
    L74:
        Log.w(TAG, "insertAccountIntoDatabase: " + r2.toSafeString() + ", skipping since insertExtra failed for key " + key);     // Catch: Throwable -> L44
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L41
        monitor-exit(r12);     // Catch: Throwable -> L41
        monitor-exit(r11);     // Catch: Throwable -> L38
        return r17;
    L81:
        boolean r18 = r0;
    L83:
        if (packageToVisibility != null) goto L133;
        Account r14 = r2;
        long accountId2 = accountId;
    L131:
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L111
        FrameworkStatsLog.write(FrameworkStatsLog.ACCOUNT_MANAGER_EVENT, r14.type, callingUid, 2);     // Catch: Throwable -> L111
        logRecord(AccountsDb.DEBUG_ACTION_ACCOUNT_ADD, "accounts", accountId2, accounts, callingUid);     // Catch: Throwable -> L109
        insertAccountIntoCacheLocked(accounts, account);     // Catch: Throwable -> L109
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L107
        monitor-exit(r12);     // Catch: Throwable -> L107
        monitor-exit(r11);     // Catch: Throwable -> L105
        if (getUserManager().getUserInfo(UserAccounts.m933$$Nest$fgetuserId(accounts)).canHaveProfile() == false) goto L103;
        addAccountToLinkedRestrictedUsers(r14, UserAccounts.m933$$Nest$fgetuserId(accounts));
    L103:
        sendNotificationAccountUpdated(r14, accounts);
        Log.i(TAG, "callingUid=" + callingUid + ", userId=" + UserAccounts.m933$$Nest$fgetuserId(accounts) + " added account");
        sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), r14.type, "addAccount");
        logAddAccountExplicitlyMetrics(opPackageName, r14.type, packageToVisibility);
        return r18;
    L105:
        th = th;
    L119:
        monitor-exit(r11);     // Catch: Throwable -> L118
        throw th;
    L107:
        th = th;
    L116:
        monitor-exit(r12);     // Catch: Throwable -> L115
        throw th;     // Catch: Throwable -> L118
    L109:
        th = th;
    L113:
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L115
        throw th;     // Catch: Throwable -> L115
    L111:
        th = th;
        goto L113
    L133:
        Iterator<Map.Entry<String, Integer>> r4 = packageToVisibility.entrySet().iterator();     // Catch: Throwable -> L89
    L86:
        if (r4.hasNext() == false) goto L92;
        Map.Entry<String, Integer> entry = r4.next();     // Catch: Throwable -> L89
        long accountId3 = accountId;
        r1.setAccountVisibility(r2, entry.getKey(), entry.getValue().intValue(), false, accounts, callingUid);     // Catch: Throwable -> L89
        r1 = this;
        r2 = r2;
        accountId = accountId3;
        goto L86
    L92:
        r14 = r2;
        accountId2 = accountId;
    L89:
        th = th;
        goto L113
    L82:
        r18 = true;
    L44:
        th = th;
    L41:
        th = th;
    L115:
        th = th;
    L118:
        th = th;
    L38:
        th = th;
        goto L119
    L14:
        if (r2.type.length() <= 200) goto L17;
        Log.w(TAG, "Account cannot be added - Name longer than 200 chars");
        return false;
    }

    private void logAddAccountExplicitlyMetrics(String callerPackage, String accountType, Map<String, Integer> accountVisibility) {
        DevicePolicyEventLogger.createEvent(203).setStrings(TextUtils.emptyIfNull(accountType), TextUtils.emptyIfNull(callerPackage), findPackagesPerVisibility(accountVisibility)).write();
    }

    private String[] findPackagesPerVisibility(Map<String, Integer> accountVisibility) {
        Map<Integer, Set<String>> packagesPerVisibility = new HashMap();
        if (accountVisibility == null) goto L11;
        Iterator<Map.Entry<String, Integer>> r1 = accountVisibility.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        Map.Entry<String, Integer> entry = r1.next();
        if (packagesPerVisibility.containsKey(entry.getValue()) == true) goto L10;
        packagesPerVisibility.put(entry.getValue(), new HashSet());
    L10:
        packagesPerVisibility.get(entry.getValue()).add(entry.getKey());
    L11:
        String[] packagesPerVisibilityStr = {getPackagesForVisibilityStr(0, packagesPerVisibility), getPackagesForVisibilityStr(1, packagesPerVisibility), getPackagesForVisibilityStr(2, packagesPerVisibility), getPackagesForVisibilityStr(3, packagesPerVisibility), getPackagesForVisibilityStr(4, packagesPerVisibility)};
        return packagesPerVisibilityStr;
    }

    private String getPackagesForVisibilityStr(int visibility, Map<Integer, Set<String>> packagesPerVisibility) {
        StringBuilder r0 = new StringBuilder();
        r0.append(visibility);
        r0.append(":");
        if (packagesPerVisibility.containsKey(Integer.valueOf(visibility)) == false) goto L5;
        String r1 = TextUtils.join(",", packagesPerVisibility.get(Integer.valueOf(visibility)));
    L6:
        r0.append(r1);
        return r0.toString();
    L5:
        r1 = "";
        goto L6
    }

    private boolean isLocalUnlockedUser(int userId) {
        SparseArray<UserAccounts> r0 = this.mUsers;
        monitor-enter(r0);
        boolean r1 = this.mLocalUnlockedUsers.get(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void addAccountToLinkedRestrictedUsers(Account account, int parentUserId) {
        List<UserInfo> users = getUserManager().getUsers();
        Iterator<UserInfo> r1 = users.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        UserInfo user = r1.next();
        if (user.isRestricted() == false) goto L4;
        if (parentUserId != user.restrictedProfileParentId) goto L4;
        addSharedAccountAsUser(account, user.id);
        if (isLocalUnlockedUser(user.id) == false) goto L4;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, parentUserId, user.id, account));
        goto L4
    }

    public void hasFeatures(IAccountManagerResponse response, Account account, String[] features, int userId, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "hasFeatures: " + account + ", response " + response + ", features " + Arrays.toString(features) + ", caller's uid " + callingUid + ", userId " + userId + ", pid " + Binder.getCallingPid());
    L5:
        boolean r0 = false;
        if (account == null) goto L8;
        boolean r3 = true;
    L9:
        Preconditions.checkArgument(r3, "account cannot be null");
        if (response == null) goto L12;
        boolean r4 = true;
    L13:
        Preconditions.checkArgument(r4, "response cannot be null");
        if (features == null) goto L16;
        r0 = true;
    L16:
        Preconditions.checkArgument(r0, "features cannot be null");
        if (userId != UserHandle.getCallingUserId()) goto L19;
    L25:
        checkReadAccountsPermitted(callingUid, account.type, userId, opPackageName);
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L33
        new TestFeaturesSession(this, accounts, response, account, features).bind();     // Catch: Throwable -> L31
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L31:
        th = move-exception;
        Throwable r11 = th;
    L35:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw r11;
    L33:
        th = move-exception;
        r11 = th;
        goto L35
    L19:
        if (callingUid == 1000) goto L25;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) goto L25;
        throw new SecurityException("User " + UserHandle.getCallingUserId() + " trying to check account features for " + userId);
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    }

    public void renameAccount(IAccountManagerResponse response, Account accountToRename, String newName) {
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "renameAccount: " + accountToRename + " -> " + newName + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        if (accountToRename == null) goto L32;
        if (newName != null) goto L8;
    L12:
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(accountToRename.type, callingUid, userId) == false) goto L29;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L21
        Log.i(TAG, "callingUid=" + callingUid + ", userId=" + UserAccounts.m933$$Nest$fgetuserId(accounts) + " performing rename account");     // Catch: Throwable -> L21
        Account resultingAccount = renameAccountInternal(accounts, accountToRename, newName);     // Catch: Throwable -> L21
        if (resultingAccount != null) goto L18;
        resultingAccount = accountToRename;
    L18:
        Bundle result = new Bundle();     // Catch: Throwable -> L21
        result.putString("authAccount", resultingAccount.name);     // Catch: Throwable -> L21
        result.putString("accountType", resultingAccount.type);     // Catch: Throwable -> L21
        result.putString("accountAccessId", resultingAccount.getAccessId());     // Catch: Throwable -> L21
        response.onResult(result);     // Catch: Throwable -> L21 RemoteException -> L23
    L25:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L23:
        e = move-exception;
        Log.w(TAG, e.getMessage());     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L29:
        String msg = String.format("uid %s cannot rename accounts of type: %s", new Object[]{Integer.valueOf(callingUid), accountToRename.type});
        throw new SecurityException(msg);
    L8:
        if (newName.length() <= 200) goto L12;
        Log.e(TAG, "renameAccount failed - account name longer than 200");
        throw new IllegalArgumentException("account name longer than 200");
    L32:
        throw new IllegalArgumentException("account is null");
    }

    private Account renameAccountInternal(UserAccounts accounts, Account accountToRename, String newName) {
        cancelNotification(getSigninRequiredNotificationId(accounts, accountToRename), accounts);
        HashMap r6 = UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts);
        monitor-enter(r6);
        Iterator r0 = UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts).keySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r0.hasNext() == false) goto L13;
        Pair<Pair<Account, String>, Integer> pair = (Pair) r0.next();     // Catch: Throwable -> L10
        if (accountToRename.equals(((Pair) pair.first).first) == false) goto L6;
        NotificationId id = (NotificationId) UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts).get(pair);     // Catch: Throwable -> L10
        cancelNotification(id, accounts);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r6);     // Catch: Throwable -> L10
        Object r7 = accounts.dbLock;
        monitor-enter(r7);
        Object r8 = accounts.cacheLock;     // Catch: Throwable -> L27
        monitor-enter(r8);     // Catch: Throwable -> L27
        List<String> accountRemovedReceivers = getAccountRemovedReceivers(accountToRename, accounts);     // Catch: Throwable -> L29
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L29
        Account renamedAccount = new Account(newName, accountToRename.type);     // Catch: Throwable -> L29
    L31:
        th = move-exception;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L21:
        if (accounts.accountsDb.findCeAccountId(renamedAccount) < 0) goto L33;
        Log.e(TAG, "renameAccount failed - account with new name already exists");     // Catch: Throwable -> L31
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L29
        monitor-exit(r8);     // Catch: Throwable -> L29
        monitor-exit(r7);     // Catch: Throwable -> L27
        return null;
    L33:
        long accountId = accounts.accountsDb.findDeAccountId(accountToRename);     // Catch: Throwable -> L31
        if (accountId < 0) goto L65;
        accounts.accountsDb.renameCeAccount(accountId, newName);     // Catch: Throwable -> L31
        if (accounts.accountsDb.renameDeAccount(accountId, newName, accountToRename.name) == false) goto L60;
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L31
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L29
        Account renamedAccount2 = insertAccountIntoCacheLocked(accounts, renamedAccount);     // Catch: Throwable -> L29
        Map<String, String> tmpData = (Map) UserAccounts.m932$$Nest$fgetuserDataCache(accounts).get(accountToRename);     // Catch: Throwable -> L29
        Map<String, String> tmpTokens = (Map) UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).get(accountToRename);     // Catch: Throwable -> L29
        Map<String, Integer> tmpVisibility = (Map) UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).get(accountToRename);     // Catch: Throwable -> L29
        removeAccountFromCacheLocked(accounts, accountToRename);     // Catch: Throwable -> L29
        UserAccounts.m932$$Nest$fgetuserDataCache(accounts).put(renamedAccount2, tmpData);     // Catch: Throwable -> L29
        UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).put(renamedAccount2, tmpTokens);     // Catch: Throwable -> L29
        UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).put(renamedAccount2, tmpVisibility);     // Catch: Throwable -> L29
        UserAccounts.m930$$Nest$fgetpreviousNameCache(accounts).put(renamedAccount2, new AtomicReference(accountToRename.name));     // Catch: Throwable -> L29
        recomputeCacheSizeForAccountLocked(accounts, renamedAccount2);     // Catch: Throwable -> L29
        int parentUserId = UserAccounts.m933$$Nest$fgetuserId(accounts);     // Catch: Throwable -> L29
        if (canHaveProfile(parentUserId) == false) goto L52;
        List<UserInfo> users = getUserManager().getAliveUsers();     // Catch: Throwable -> L29
        Iterator<UserInfo> r14 = users.iterator();     // Catch: Throwable -> L29
    L42:
        if (r14.hasNext() == false) goto L52;
        UserInfo user = r14.next();     // Catch: Throwable -> L29
        if (user.isRestricted() == false) goto L48;
        Account renamedAccount3 = renamedAccount2;
        if (user.restrictedProfileParentId != parentUserId) goto L49;
        renameSharedAccountAsUser(accountToRename, newName, user.id);     // Catch: Throwable -> L29
    L49:
        renamedAccount2 = renamedAccount3;
        goto L42
    L48:
        renamedAccount3 = renamedAccount2;
    L52:
        sendNotificationAccountUpdated(renamedAccount2, accounts);     // Catch: Throwable -> L29
        sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), accountToRename.type, "renameAccount");     // Catch: Throwable -> L29
        Iterator<String> r1 = accountRemovedReceivers.iterator();     // Catch: Throwable -> L29
    L54:
        if (r1.hasNext() == false) goto L56;
        String packageName = r1.next();     // Catch: Throwable -> L29
        sendAccountRemovedBroadcast(accountToRename, packageName, UserAccounts.m933$$Nest$fgetuserId(accounts), "renameAccount");     // Catch: Throwable -> L29
        goto L54
    L56:
        AccountManager.invalidateLocalAccountsDataCaches();     // Catch: Throwable -> L29
        AccountManager.invalidateLocalAccountUserDataCaches();     // Catch: Throwable -> L29
        monitor-exit(r8);     // Catch: Throwable -> L29
        monitor-exit(r7);     // Catch: Throwable -> L27
        return renamedAccount2;
    L60:
        Log.e(TAG, "renameAccount failed");     // Catch: Throwable -> L31
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L29
        monitor-exit(r8);     // Catch: Throwable -> L29
        monitor-exit(r7);     // Catch: Throwable -> L27
        return null;
    L65:
        Log.e(TAG, "renameAccount failed - old account does not exist");     // Catch: Throwable -> L31
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L29
        monitor-exit(r8);     // Catch: Throwable -> L29
        monitor-exit(r7);     // Catch: Throwable -> L27
        return null;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean canHaveProfile(int parentUserId) {
        UserInfo userInfo = getUserManager().getUserInfo(parentUserId);
        if (userInfo != null) goto L5;
    L7:
        return false;
    L5:
        if (userInfo.canHaveProfile() == false) goto L7;
        return true;
    }

    public void removeAccountAsUser(IAccountManagerResponse response, Account account, boolean expectActivityLaunch, int userId) {
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "removeAccount: " + account + ", response " + response + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid() + ", for user id " + userId);
    L5:
        boolean r0 = false;
        if (account == null) goto L8;
        boolean r3 = true;
    L9:
        Preconditions.checkArgument(r3, "account cannot be null");
        if (response == null) goto L12;
        r0 = true;
    L12:
        Preconditions.checkArgument(r0, "response cannot be null");
        if (isCrossUser(callingUid, userId) == true) goto L78;
        UserHandle user = UserHandle.of(userId);
        if (isAccountManagedByCaller(account.type, callingUid, user.getIdentifier()) == true) goto L26;
        if (isSystemUid(callingUid) == true) goto L26;
        if (isProfileOwner(callingUid) == true) goto L26;
        if (hasRemoveAccountsPermission() == true) goto L26;
        String msg = String.format("uid %s cannot remove accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    L26:
        if (canUserModifyAccounts(userId, callingUid) == true) goto L32;
        response.onError(100, "User cannot modify accounts");     // Catch: RemoteException -> L29
        return;
    L30:
        return;
    L32:
        if (canUserModifyAccountsForType(userId, account.type, callingUid) == true) goto L39;
        response.onError(101, "User cannot modify accounts of this type (policy).");     // Catch: RemoteException -> L35
        return;
    L35:
        re = move-exception;
        Log.w(TAG, "RemoteException while removing account", re);
        return;
    L39:
        if (isFirstAccountRemovalDisabled(account) == true) goto L79;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);
        cancelNotification(getSigninRequiredNotificationId(accounts, account), accounts);
        HashMap r4 = UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts);
        monitor-enter(r4);
        Iterator r1 = UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts).keySet().iterator();     // Catch: Throwable -> L71
    L49:
        if (r1.hasNext() == false) goto L57;
        Pair<Pair<Account, String>, Integer> pair = (Pair) r1.next();     // Catch: Throwable -> L54
        if (account.equals(((Pair) pair.first).first) == false) goto L49;
        NotificationId id = (NotificationId) UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts).get(pair);     // Catch: Throwable -> L54
        cancelNotification(id, accounts);     // Catch: Throwable -> L54
    L54:
        th = th;
    L83:
        monitor-exit(r4);     // Catch: Throwable -> L75
        throw th;
    L75:
        th = th;
        goto L83
    L57:
        monitor-exit(r4);     // Catch: Throwable -> L71
        long accountId = accounts.accountsDb.findDeAccountId(account);
        logRecord(AccountsDb.DEBUG_ACTION_CALLED_ACCOUNT_REMOVE, "accounts", accountId, accounts, callingUid);
    L65:
        th = th;
    L69:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L87:
        new RemoveAccountSession(this, accounts, response, account, expectActivityLaunch).bind();     // Catch: Throwable -> L65
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L67:
        th = th;
    L71:
        th = th;
        goto L83
    L79:
        response.onError(101, "User cannot remove the first " + account.type + " account on the device.");     // Catch: RemoteException -> L42
        return;
    L42:
        re = move-exception;
        Log.w(TAG, "RemoteException while removing account", re);
        return;
    L78:
        throw new SecurityException(String.format("User %s tying remove account for %s", new Object[]{Integer.valueOf(UserHandle.getCallingUserId()), Integer.valueOf(userId)}));
    L8:
        r3 = false;
        goto L9
    }

    private boolean hasRemoveAccountsPermission() {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.REMOVE_ACCOUNTS") != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean removeAccountExplicitly(Account account) {
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "removeAccountExplicitly: " + account + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        int userId = Binder.getCallingUserHandle().getIdentifier();
        if (account != null) goto L10;
        Log.e(TAG, "account is null");
        return false;
    L10:
        if (isAccountManagedByCaller(account.type, callingUid, userId) == true) goto L12;
        String msg = String.format("uid %s cannot explicitly remove accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    L12:
        if (isFirstAccountRemovalDisabled(account) == false) goto L15;
        Log.e(TAG, "Cannot remove the first " + account.type + " account on the device.");
        return false;
    L15:
        UserAccounts accounts = getUserAccountsForCaller();
        long accountId = accounts.accountsDb.findDeAccountId(account);
        logRecord(AccountsDb.DEBUG_ACTION_CALLED_ACCOUNT_REMOVE, "accounts", accountId, accounts, callingUid);
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        boolean r0 = removeAccountInternal(accounts, account, callingUid);     // Catch: Throwable -> L19
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r0;
    L19:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    protected void removeAccountInternal(Account account) {
        removeAccountInternal(getUserAccountsForCaller(), account, IAccountManager.Stub.getCallingUid());
    }

    private boolean removeAccountInternal(final UserAccounts accounts, final Account account, int callingUid) {
        boolean userUnlocked = isLocalUnlockedUser(UserAccounts.m933$$Nest$fgetuserId(accounts));
        if (userUnlocked == true) goto L5;
        Slog.i(TAG, "Removing account " + account.toSafeString() + " while user " + UserAccounts.m933$$Nest$fgetuserId(accounts) + " is still locked. CE data will be removed later");
    L5:
        Object r10 = accounts.dbLock;
        monitor-enter(r10);
        Object r11 = accounts.cacheLock;     // Catch: Throwable -> L96
        monitor-enter(r11);     // Catch: Throwable -> L96
        Map<String, Integer> packagesToVisibility = getRequestingPackages(account, accounts);     // Catch: Throwable -> L93
        List<String> accountRemovedReceivers = getAccountRemovedReceivers(account, accounts);     // Catch: Throwable -> L93
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L93
        long accountId = accounts.accountsDb.findDeAccountId(account);     // Catch: Throwable -> L90
        if (accountId >= 0) goto L111;
        boolean isChanged = false;
    L19:
        if (userUnlocked == true) goto L99;
    L25:
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L23
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L36
        if (isChanged == false) goto L48;
        removeAccountFromCacheLocked(accounts, account);     // Catch: Throwable -> L36
        Iterator<Map.Entry<String, Integer>> r0 = packagesToVisibility.entrySet().iterator();     // Catch: Throwable -> L36
    L30:
        if (r0.hasNext() == false) goto L40;
        Map.Entry<String, Integer> packageToVisibility = r0.next();     // Catch: Throwable -> L36
        if (packageToVisibility.getValue().intValue() != 1) goto L34;
    L38:
        notifyPackage(packageToVisibility.getKey(), accounts);     // Catch: Throwable -> L36
        goto L30
    L34:
        if (packageToVisibility.getValue().intValue() != 2) goto L30;
    L40:
        Log.i(TAG, "callingUid=" + callingUid + ", userId=" + UserAccounts.m933$$Nest$fgetuserId(accounts) + " removed account");     // Catch: Throwable -> L36
        sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), account.type, "removeAccount");     // Catch: Throwable -> L36
        Iterator<String> r1 = accountRemovedReceivers.iterator();     // Catch: Throwable -> L36
    L42:
        if (r1.hasNext() == false) goto L44;
        String packageName = r1.next();     // Catch: Throwable -> L36
        sendAccountRemovedBroadcast(account, packageName, UserAccounts.m933$$Nest$fgetuserId(accounts), "removeAccount");     // Catch: Throwable -> L36
        goto L42
    L44:
        if (userUnlocked == false) goto L46;
        String action = AccountsDb.DEBUG_ACTION_ACCOUNT_REMOVE;     // Catch: Throwable -> L36
    L47:
        FrameworkStatsLog.write(FrameworkStatsLog.ACCOUNT_MANAGER_EVENT, account.type, callingUid, 3);     // Catch: Throwable -> L36
        logRecord(action, "accounts", accountId, accounts);     // Catch: Throwable -> L36
        goto L48
    L46:
        action = AccountsDb.DEBUG_ACTION_ACCOUNT_REMOVE_DE;     // Catch: Throwable -> L36
    L48:
        monitor-exit(r11);     // Catch: Throwable -> L36
        monitor-exit(r10);     // Catch: Throwable -> L88
        long id = Binder.clearCallingIdentity();
        int parentUserId = UserAccounts.m933$$Nest$fgetuserId(accounts);     // Catch: Throwable -> L62
        if (canHaveProfile(parentUserId) == false) goto L65;
        List<UserInfo> users = getUserManager().getAliveUsers();     // Catch: Throwable -> L62
        Iterator<UserInfo> r5 = users.iterator();     // Catch: Throwable -> L62
    L55:
        if (r5.hasNext() == false) goto L65;
        UserInfo user = r5.next();     // Catch: Throwable -> L62
        if (user.isRestricted() == false) goto L55;
        if (parentUserId != user.restrictedProfileParentId) goto L55;
        removeSharedAccountAsUser(account, user.id, callingUid);     // Catch: Throwable -> L62
    L65:
        Binder.restoreCallingIdentity(id);
        if (isChanged == false) goto L84;
        HashMap r4 = UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts);
        monitor-enter(r4);
        Iterator r2 = UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts).keySet().iterator();     // Catch: Throwable -> L77
    L71:
        if (r2.hasNext() == false) goto L80;
        Pair<Pair<Account, String>, Integer> key = (Pair) r2.next();     // Catch: Throwable -> L77
        if (account.equals(((Pair) key.first).first) == false) goto L71;
        if ("com.android.AccountManager.ACCOUNT_ACCESS_TOKEN_TYPE".equals(((Pair) key.first).second) == false) goto L71;
        final int uid = ((Integer) key.second).intValue();     // Catch: Throwable -> L77
        this.mHandler.post(new AccountManagerService$$ExternalSyntheticLambda3(this, account, uid, accounts));     // Catch: Throwable -> L77
        goto L71
    L80:
        monitor-exit(r4);     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        throw th;
    L84:
        AccountManager.invalidateLocalAccountUserDataCaches();
        return isChanged;
    L62:
        th = move-exception;
        Binder.restoreCallingIdentity(id);
        throw th;
    L88:
        th = th;
    L97:
        monitor-exit(r10);     // Catch: Throwable -> L96
        throw th;
    L36:
        th = th;
    L94:
        monitor-exit(r11);     // Catch: Throwable -> L93
        throw th;     // Catch: Throwable -> L96
    L23:
        th = th;
    L91:
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L93
        throw th;     // Catch: Throwable -> L93
    L99:
        long ceAccountId = accounts.accountsDb.findCeAccountId(account);     // Catch: Throwable -> L23
        if (ceAccountId < 0) goto L25;
        accounts.accountsDb.deleteCeAccount(ceAccountId);     // Catch: Throwable -> L23
        goto L25
    L111:
        boolean isChanged2 = accounts.accountsDb.deleteDeAccount(accountId);     // Catch: Throwable -> L16
        isChanged = isChanged2;
    L16:
        th = th;
    L90:
        th = th;
    L93:
        th = th;
    L96:
        th = th;
        goto L97
    }

    private /* synthetic */ void lambda$removeAccountInternal$2(Account account, int uid, UserAccounts accounts) {
        cancelAccountAccessRequestNotificationIfNeeded(account, uid, false, accounts);
    }

    public void invalidateAuthToken(String accountType, String authToken) {
        int callerUid = Binder.getCallingUid();
        accountType.getClass();
        authToken.getClass();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "invalidateAuthToken: accountType " + accountType + ", caller's uid " + callerUid + ", pid " + Binder.getCallingPid());
    L5:
        int userId = UserHandle.getCallingUserId();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L32
        Object r5 = accounts.dbLock;     // Catch: Throwable -> L32
        monitor-enter(r5);     // Catch: Throwable -> L32
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L23
        List<Pair<Account, String>> deletedTokens = invalidateAuthTokenLocked(accounts, accountType, authToken);     // Catch: Throwable -> L27
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L27
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L23
        Object r7 = accounts.cacheLock;     // Catch: Throwable -> L23
        monitor-enter(r7);     // Catch: Throwable -> L23
        Iterator<Pair<Account, String>> r8 = deletedTokens.iterator();     // Catch: Throwable -> L16
    L14:
        if (r8.hasNext() == false) goto L18;
        Pair<Account, String> tokenInfo = r8.next();     // Catch: Throwable -> L16
        Account act = (Account) tokenInfo.first;     // Catch: Throwable -> L16
        String tokenType = (String) tokenInfo.second;     // Catch: Throwable -> L16
        writeAuthTokenIntoCacheLocked(accounts, act, tokenType, null);     // Catch: Throwable -> L16
        goto L14
    L18:
        UserAccounts.m925$$Nest$fgetaccountTokenCaches(accounts).remove(accountType, authToken);     // Catch: Throwable -> L16
        monitor-exit(r7);     // Catch: Throwable -> L16
        monitor-exit(r5);     // Catch: Throwable -> L23
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L27:
        th = move-exception;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    private List<Pair<Account, String>> invalidateAuthTokenLocked(UserAccounts accounts, String accountType, String authToken) {
        List<Pair<Account, String>> results = new ArrayList();
        Cursor cursor = accounts.accountsDb.findAuthtokenForAllAccounts(accountType, authToken);
    L13:
    L7:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        String authTokenId = cursor.getString(0);     // Catch: Throwable -> L7
        String accountName = cursor.getString(1);     // Catch: Throwable -> L7
        String authTokenType = cursor.getString(2);     // Catch: Throwable -> L7
        accounts.accountsDb.deleteAuthToken(authTokenId);     // Catch: Throwable -> L7
        results.add(Pair.create(new Account(accountName, accountType), authTokenType));     // Catch: Throwable -> L7
        goto L13
    L9:
        cursor.close();
        return results;
    }

    private void saveCachedToken(UserAccounts accounts, Account account, String callerPkg, byte[] callerSigDigest, String tokenType, String token, long expiryMillis) {
        if (account == null) goto L15;
        if (tokenType == null) goto L18;
        if (callerPkg == null) goto L19;
        if (callerSigDigest == null) goto L20;
        cancelNotification(getSigninRequiredNotificationId(accounts, account), accounts);
        Object r1 = accounts.cacheLock;
        monitor-enter(r1);
        UserAccounts.m925$$Nest$fgetaccountTokenCaches(accounts).put(account, token, tokenType, callerPkg, callerSigDigest, expiryMillis);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    private boolean saveAuthTokenToDatabase(UserAccounts accounts, Account account, String type, String authToken) {
        if (account == null) goto L96;
        if (type == null) goto L96;
        cancelNotification(getSigninRequiredNotificationId(accounts, account), accounts);
        Object r1 = accounts.dbLock;
        monitor-enter(r1);
        Object r3 = accounts.cacheLock;     // Catch: Throwable -> L28
        monitor-enter(r3);     // Catch: Throwable -> L28
        boolean shouldBlockWrite = shouldBlockDatabaseWrite(accounts, account, type, authToken);     // Catch: Throwable -> L91
        monitor-exit(r3);     // Catch: Throwable -> L91
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L28
        long accountId = accounts.accountsDb.findDeAccountId(account);     // Catch: Throwable -> L48
        if (accountId >= 0) goto L32;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L28
        if (0 == 0) goto L30;
        Object r6 = accounts.cacheLock;     // Catch: Throwable -> L28
        monitor-enter(r6);     // Catch: Throwable -> L28
        writeAuthTokenIntoCacheLocked(accounts, account, type, authToken);     // Catch: Throwable -> L25
        monitor-exit(r6);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return false;
    L32:
        accounts.accountsDb.deleteAuthtokensByAccountIdAndType(accountId, type);     // Catch: Throwable -> L48
        if (authToken == null) goto L51;
        if (shouldBlockWrite == false) goto L51;
        Log.w(TAG, "Too much storage is used - block token update for accountType=" + account.type);     // Catch: Throwable -> L48
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L28
        if (0 == 0) goto L46;
        Object r7 = accounts.cacheLock;     // Catch: Throwable -> L28
        monitor-enter(r7);     // Catch: Throwable -> L28
        writeAuthTokenIntoCacheLocked(accounts, account, type, authToken);     // Catch: Throwable -> L43
        monitor-exit(r7);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L46:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return false;
    L51:
        if (accounts.accountsDb.insertAuthToken(accountId, type, authToken) < 0) goto L67;
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L48
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L28
        if (1 == 0) goto L64;
        Object r4 = accounts.cacheLock;     // Catch: Throwable -> L28
        monitor-enter(r4);     // Catch: Throwable -> L28
        writeAuthTokenIntoCacheLocked(accounts, account, type, authToken);     // Catch: Throwable -> L61
        monitor-exit(r4);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L64:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return true;
    L67:
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L28
        if (0 == 0) goto L77;
        Object r8 = accounts.cacheLock;     // Catch: Throwable -> L28
        monitor-enter(r8);     // Catch: Throwable -> L28
        writeAuthTokenIntoCacheLocked(accounts, account, type, authToken);     // Catch: Throwable -> L74
        monitor-exit(r8);     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L77:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return false;
    L48:
        th = move-exception;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L28
        if (0 != 0) goto L82;
    L90:
        throw th;     // Catch: Throwable -> L28
    L82:
        monitor-enter(accounts.cacheLock);     // Catch: Throwable -> L28
        writeAuthTokenIntoCacheLocked(accounts, account, type, authToken);     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L91:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L96:
        return false;
    }

    public String peekAuthToken(Account account, String authTokenType) {
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "peekAuthToken: " + account + ", authTokenType " + authTokenType + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        account.getClass();
        authTokenType.getClass();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == true) goto L8;
        String msg = String.format("uid %s cannot peek the authtokens associated with accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    L8:
        if (isLocalUnlockedUser(userId) == true) goto L11;
        Log.w(TAG, "Authtoken not available - user " + userId + " data is locked. callingUid " + callingUid);
        return null;
    L11:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L15
        String r5 = readAuthTokenInternal(accounts, account, authTokenType);     // Catch: Throwable -> L15
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r5;
    L15:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    }

    public void setAuthToken(Account account, String authTokenType, String authToken) {
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "setAuthToken: " + account + ", authTokenType " + authTokenType + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        account.getClass();
        authTokenType.getClass();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L14;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L11
        saveAuthTokenToDatabase(accounts, account, authTokenType, authToken);     // Catch: Throwable -> L11
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L11:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L14:
        String msg = String.format("uid %s cannot set auth tokens associated with accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    }

    public void setPassword(Account account, String password) {
        SeempLog.record(18);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "setAuthToken: " + account + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        account.getClass();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L14;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L11
        setPasswordInternal(accounts, account, password, callingUid);     // Catch: Throwable -> L11
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L11:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L14:
        String msg = String.format("uid %s cannot set secrets for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    }

    private void setPasswordInternal(UserAccounts accounts, Account account, String password, int callingUid) {
        if (account != null) goto L5;
        return;
    L5:
        if (password != null) goto L7;
    L10:
        boolean isChanged = false;
        Object r10 = accounts.dbLock;
        monitor-enter(r10);
        Object r11 = accounts.cacheLock;     // Catch: Throwable -> L60
        monitor-enter(r11);     // Catch: Throwable -> L60
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L56
        long accountId = accounts.accountsDb.findDeAccountId(account);     // Catch: Throwable -> L38
        if (accountId < 0) goto L40;
        accounts.accountsDb.updateCeAccountPassword(accountId, password);     // Catch: Throwable -> L38
        accounts.accountsDb.deleteAuthTokensByAccountId(accountId);     // Catch: Throwable -> L38
        UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).remove(account);     // Catch: Throwable -> L38
        UserAccounts.m925$$Nest$fgetaccountTokenCaches(accounts).remove(account);     // Catch: Throwable -> L38
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L38
        if (password == null) goto L27;
    L24:
        th = th;
        int r9 = callingUid;
    L26:
        isChanged = true;
    L51:
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L44
        if (isChanged == false) goto L55;
        sendNotificationAccountUpdated(account, accounts);     // Catch: Throwable -> L44
        Log.i(TAG, "callingUid=" + r9 + " changed password");     // Catch: Throwable -> L44
        sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), account.type, "setPassword");     // Catch: Throwable -> L44
    L55:
        throw th;     // Catch: Throwable -> L44
    L21:
        if (password.length() == 0) goto L27;
        String action = AccountsDb.DEBUG_ACTION_SET_PASSWORD;     // Catch: Throwable -> L24
    L28:
        r9 = callingUid;
        logRecord(action, "accounts", accountId, accounts, r9);     // Catch: Throwable -> L36
        String r3 = account.type;     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(password) == false) goto L33;
        int r5 = 5;
    L34:
        FrameworkStatsLog.write(FrameworkStatsLog.ACCOUNT_MANAGER_EVENT, r3, r9, r5);     // Catch: Throwable -> L36
        isChanged = true;
    L41:
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L44
        if (isChanged == false) goto L46;
        sendNotificationAccountUpdated(account, accounts);     // Catch: Throwable -> L44
        Log.i(TAG, "callingUid=" + r9 + " changed password");     // Catch: Throwable -> L44
        sendAccountsChangedBroadcast(UserAccounts.m933$$Nest$fgetuserId(accounts), account.type, "setPassword");     // Catch: Throwable -> L44
    L46:
        monitor-exit(r11);     // Catch: Throwable -> L44
        monitor-exit(r10);     // Catch: Throwable -> L49
        return;
    L33:
        r5 = 4;
    L36:
        th = th;
    L27:
        action = AccountsDb.DEBUG_ACTION_CLEAR_PASSWORD;     // Catch: Throwable -> L24
        goto L28
    L40:
        r9 = callingUid;
    L38:
        th = th;
        r9 = callingUid;
    L56:
        th = th;
    L58:
        monitor-exit(r11);     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L49
    L44:
        th = th;
    L49:
        th = th;
    L62:
        monitor-exit(r10);     // Catch: Throwable -> L49
        throw th;
    L60:
        th = th;
        goto L62
    L7:
        if (password.length() <= MAXIMUM_PASSWORD_LENGTH) goto L10;
        Log.w(TAG, "New password is too long for accountType=" + account.type);
    }

    public void clearPassword(Account account) {
        SeempLog.record(19);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "clearPassword: " + account + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        account.getClass();
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L14;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L11
        setPasswordInternal(accounts, account, null, callingUid);     // Catch: Throwable -> L11
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L11:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L14:
        String msg = String.format("uid %s cannot clear passwords for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    }

    public void setUserData(Account account, String key, String value) {
        SeempLog.record(20);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "setUserData: " + account + ", key " + key + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        if (key == null) goto L29;
        if (account == null) goto L27;
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(account.type, callingUid, userId) == false) goto L24;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L20
        if (accountExistsCache(accounts, account) == true) goto L30;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L30:
        setUserdataInternal(accounts, account, key, value, callingUid);     // Catch: Throwable -> L18
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L18:
        th = move-exception;
        Throwable r11 = th;
    L22:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw r11;
    L20:
        th = move-exception;
        r11 = th;
        goto L22
    L24:
        String msg = String.format("uid %s cannot set user data for accounts of type: %s", new Object[]{Integer.valueOf(callingUid), account.type});
        throw new SecurityException(msg);
    L27:
        throw new IllegalArgumentException("account is null");
    L29:
        throw new IllegalArgumentException("key is null");
    }

    private boolean accountExistsCache(UserAccounts accounts, Account account) {
        Object r0 = accounts.cacheLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (accounts.accountCache.containsKey(account.type) == false) goto L16;
        Account[] r1 = accounts.accountCache.get(account.type);     // Catch: Throwable -> L13
        int r3 = r1.length;     // Catch: Throwable -> L13
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L16;
        Account acc = r1[r4];     // Catch: Throwable -> L13
        if (acc.name.equals(account.name) == true) goto L10;
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return false;
    }

    private void setUserdataInternal(UserAccounts accounts, Account account, String key, String value, int callingUid) {
        Object r0 = accounts.dbLock;
        monitor-enter(r0);
        Object r1 = accounts.cacheLock;     // Catch: Throwable -> L13
        monitor-enter(r1);     // Catch: Throwable -> L13
        if (value != null) goto L62;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L15
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L13
        long accountId = accounts.accountsDb.findDeAccountId(account);     // Catch: Throwable -> L33
        if (accountId >= 0) goto L25;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L25:
        long extrasId = accounts.accountsDb.findExtrasIdByAccountId(accountId, key);     // Catch: Throwable -> L33
        if (extrasId >= 0) goto L36;
        if (accounts.accountsDb.insertExtra(accountId, key, value) >= 0) goto L40;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L40:
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L33
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L13
        Object r2 = accounts.cacheLock;     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        writeUserDataIntoCacheLocked(accounts, account, key, value);     // Catch: Throwable -> L48
        AccountManager.invalidateLocalAccountUserDataCaches();     // Catch: Throwable -> L48
        monitor-exit(r2);     // Catch: Throwable -> L48
        monitor-exit(r0);     // Catch: Throwable -> L13
        FrameworkStatsLog.write(FrameworkStatsLog.ACCOUNT_MANAGER_EVENT, account.type, callingUid, 6);
        return;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L36:
        if (accounts.accountsDb.updateExtra(extrasId, value) == true) goto L40;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L33:
        th = move-exception;
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L62:
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L8:
        if (shouldBlockDatabaseWrite(accounts, account, key, value) == false) goto L17;
        Log.w(TAG, "Too much storage is used - block user data update for accountType=" + account.type);     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void onResult(IAccountManagerResponse response, Bundle result) {
        if (result != null) goto L6;
        Log.e(TAG, "the result is unexpectedly null", new Exception());
    L6:
        if (Log.isLoggable(TAG, 2) == false) goto L15;
        Log.v(TAG, getClass().getSimpleName() + " calling onResult() on response " + response);
    L15:
        response.onResult(result);     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L17;
        Log.v(TAG, "failure while notifying response", e);
        return;
    }

    public void getAuthTokenLabel(final IAccountManagerResponse response, final String accountType, final String authTokenType) throws RemoteException {
        boolean r0 = false;
        if (accountType == null) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "accountType cannot be null");
        if (authTokenType == null) goto L9;
        r0 = true;
    L9:
        Preconditions.checkArgument(r0, "authTokenType cannot be null");
        int callingUid = IAccountManager.Stub.getCallingUid();
        IAccountManager.Stub.clearCallingIdentity();
        if (UserHandle.getAppId(callingUid) != 1000) goto L19;
        int userId = UserHandle.getUserId(callingUid);
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L15
        final String r12 = null;
        final boolean r13 = false;
        final boolean r10 = false;
        final boolean r11 = false;
        new AnonymousClass6(this, accounts, response, accountType, r10, r11, r12, r13, accountType, authTokenType).bind();     // Catch: Throwable -> L15
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L15:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L19:
        throw new SecurityException("can only call from system");
    L5:
        r2 = false;
        goto L6
    }

    public void getAuthToken(final IAccountManagerResponse response, Account account, final String authTokenType, final boolean notifyOnAuthFailure, boolean expectActivityLaunch, final Bundle loginOptions) {
        Bundle.setDefusable(loginOptions, true);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("getAuthToken: ");
        r2.append(account);
        r2.append(", response ");
        r2.append(response);
        r2.append(", authTokenType ");
        r2.append(authTokenType);
        r2.append(", notifyOnAuthFailure ");
        r2.append(notifyOnAuthFailure);
        r2.append(", expectActivityLaunch ");
        boolean r14 = expectActivityLaunch;
        r2.append(r14);
        r2.append(", caller's uid ");
        r2.append(Binder.getCallingUid());
        r2.append(", pid ");
        r2.append(Binder.getCallingPid());
        Log.v(TAG, r2.toString());
    L6:
        boolean r3 = false;
        if (response == null) goto L9;
        boolean r4 = true;
    L10:
        Preconditions.checkArgument(r4, "response cannot be null");
        if (account != null) goto L16;
        Slog.w(TAG, "getAuthToken called with null account");     // Catch: RemoteException -> L14
        response.onError(7, "account is null");     // Catch: RemoteException -> L14
        return;
    L16:
        if (authTokenType != null) goto L21;
        Slog.w(TAG, "getAuthToken called with null authTokenType");     // Catch: RemoteException -> L14
        response.onError(7, "authTokenType is null");     // Catch: RemoteException -> L14
        return;
    L21:
        int userId = UserHandle.getCallingUserId();
        long ident = Binder.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L107
        RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> authenticatorInfo = this.mAuthenticatorCache.getServiceInfo(AuthenticatorDescription.newKey(account.type), UserAccounts.m933$$Nest$fgetuserId(accounts));     // Catch: Throwable -> L107
        Binder.restoreCallingIdentity(ident);
        if (authenticatorInfo != null) goto L26;
    L28:
        final boolean customTokens = false;
    L29:
        final int callerUid = Binder.getCallingUid();
        if (customTokens == false) goto L32;
    L33:
        r3 = true;
    L34:
        final boolean permissionGranted = r3;
        String callerPkg = loginOptions.getString("androidPackageName");
        long ident2 = Binder.clearCallingIdentity();
        String[] callerOwnedPackageNames = this.mPackageManager.getPackagesForUid(callerUid);     // Catch: Throwable -> L104
        Binder.restoreCallingIdentity(ident2);
        if (callerPkg == null) goto L102;
        if (callerOwnedPackageNames == null) goto L102;
        if (ArrayUtils.contains(callerOwnedPackageNames, callerPkg) == false) goto L102;
        loginOptions.putInt("callerUid", callerUid);
        loginOptions.putInt("callerPid", Binder.getCallingPid());
        if (notifyOnAuthFailure == false) goto L44;
        loginOptions.putBoolean("notifyOnAuthFailure", true);
    L44:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        byte[] callerPkgSigDigest = calculatePackageSignatureDigest(callerPkg, userId);     // Catch: Throwable -> L96
        if (customTokens == true) goto L62;
        if (permissionGranted == false) goto L62;
        String authToken = readAuthTokenInternal(accounts, account, authTokenType);     // Catch: Throwable -> L58
        if (authToken == null) goto L62;
        logGetAuthTokenMetrics(callerPkg, account.type);     // Catch: Throwable -> L58
        Bundle result = new Bundle();     // Catch: Throwable -> L58
        result.putString("authtoken", authToken);     // Catch: Throwable -> L56
        result.putString("authAccount", account.name);     // Catch: Throwable -> L56
        result.putString("accountType", account.type);     // Catch: Throwable -> L56
        onResult(response, result);     // Catch: Throwable -> L56
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L56:
        th = th;
    L98:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L58:
        th = th;
    L62:
        if (customTokens == false) goto L82;
        final UserAccounts accounts2 = accounts;
        Account r5 = account;
        int userId2 = userId;
        TokenCache.Value cachedToken = readCachedTokenInternal(accounts2, r5, authTokenType, callerPkg, callerPkgSigDigest);     // Catch: Throwable -> L79
        if (cachedToken == null) goto L81;
        logGetAuthTokenMetrics(callerPkg, r5.type);     // Catch: Throwable -> L79
        if (Log.isLoggable(TAG, 2) == true) goto L124;
    L72:
        Bundle result2 = new Bundle();     // Catch: Throwable -> L79
        result2.putString("authtoken", cachedToken.token);     // Catch: Throwable -> L79
        result2.putLong("android.accounts.expiry", cachedToken.expiryEpochMillis);     // Catch: Throwable -> L77
        result2.putString("authAccount", r5.name);     // Catch: Throwable -> L77
        result2.putString("accountType", r5.type);     // Catch: Throwable -> L77
        onResult(response, result2);     // Catch: Throwable -> L77
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L77:
        th = th;
        goto L98
    L124:
        Log.v(TAG, "getAuthToken: cache hit ofr custom token authenticator.");     // Catch: Throwable -> L70
    L70:
        th = th;
        goto L98
    L81:
        String callerPkg2 = callerPkg;
        byte[] callerPkgSigDigest2 = callerPkgSigDigest;
    L114:
        final String r6 = r5.type;     // Catch: Throwable -> L94
        final String r7 = r5.name;     // Catch: Throwable -> L94
        final boolean r8 = false;
        final boolean r9 = false;
        final byte[] callerPkgSigDigest3 = callerPkgSigDigest2;
        final UserAccounts r18 = accounts2;
        final boolean r10 = r14;
        final Account r11 = r5;
        final String callerPkg3 = callerPkg2;
        new AnonymousClass7(this, accounts2, response, r6, r10, r9, r7, r8, loginOptions, r11, authTokenType, notifyOnAuthFailure, permissionGranted, callerPkg3, callerUid, customTokens, callerPkgSigDigest3, r18).bind();     // Catch: Throwable -> L90
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L90:
        th = th;
    L92:
        th = th;
    L94:
        th = th;
    L79:
        th = th;
        goto L98
    L82:
        accounts2 = accounts;
        r5 = account;
        userId2 = userId;
        callerPkgSigDigest2 = callerPkgSigDigest;
        callerPkg2 = callerPkg;
    L96:
        th = th;
    L102:
        String msg = String.format("Uid %s is attempting to illegally masquerade as package %s!", new Object[]{Integer.valueOf(callerUid), callerPkg});
        throw new SecurityException(msg);
    L104:
        th = move-exception;
        Binder.restoreCallingIdentity(ident2);
        throw th;
    L32:
        if (permissionIsGranted(account, authTokenType, callerUid, userId) == false) goto L34;
    L26:
        if (((AuthenticatorDescription) authenticatorInfo.type).customTokens == false) goto L28;
        customTokens = true;
    L107:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L14:
        e = move-exception;
        Slog.w(TAG, "Failed to report error back to the client." + e);
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r14 = expectActivityLaunch;
        goto L6
    }

    private void logGetAuthTokenMetrics(String callerPackage, String accountType) {
        DevicePolicyEventLogger.createEvent(204).setStrings(new String[]{TextUtils.emptyIfNull(callerPackage), TextUtils.emptyIfNull(accountType)}).write();
    }

    private byte[] calculatePackageSignatureDigest(String callerPkg, int userId) {
        MessageDigest digester = MessageDigest.getInstance("SHA-256");     // Catch: PackageManager.NameNotFoundException -> L7 NoSuchAlgorithmException -> L9
        PackageInfo pkgInfo = this.mPackageManager.getPackageInfoAsUser(callerPkg, 64, userId);     // Catch: PackageManager.NameNotFoundException -> L7 NoSuchAlgorithmException -> L9
        Signature[] r3 = pkgInfo.signatures;     // Catch: PackageManager.NameNotFoundException -> L7 NoSuchAlgorithmException -> L9
        int r4 = r3.length;     // Catch: PackageManager.NameNotFoundException -> L7 NoSuchAlgorithmException -> L9
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L15;
        Signature sig = r3[r5];     // Catch: PackageManager.NameNotFoundException -> L7 NoSuchAlgorithmException -> L9
        digester.update(sig.toByteArray());     // Catch: PackageManager.NameNotFoundException -> L7 NoSuchAlgorithmException -> L9
        r5 = r5 + 1;
        goto L4
    L15:
        if (digester != null) goto L18;
        return null;
    L18:
        return digester.digest();
    L9:
        x = move-exception;
        Log.wtf(TAG, "SHA-256 should be available", x);
        digester = null;
    L13:
        Log.w(TAG, "Could not find packageinfo for: " + callerPkg);
        digester = null;
        goto L15
    }

    private void createNoCredentialsPermissionNotification(Account account, Intent intent, String packageName, UserAccounts accounts) {
        int userId = UserAccounts.m933$$Nest$fgetuserId(accounts);
        int uid = intent.getIntExtra("uid", -1);
        String authTokenType = intent.getStringExtra("authTokenType");
        String titleAndSubtitle = this.mContext.getString(R.string.phoneTypeCompanyMain, new Object[]{getApplicationLabel(packageName, userId), account.name});
        int index = titleAndSubtitle.indexOf(10);
        if (index <= 0) goto L5;
        String title = titleAndSubtitle.substring(0, index);
        String subtitle = titleAndSubtitle.substring(index + 1);
        String title2 = title;
        String subtitle2 = subtitle;
    L6:
        UserHandle user = UserHandle.of(userId);
        Context contextForUser = getContextForUser(user);
        Notification n = new Notification.Builder(contextForUser, "ACCOUNT").setSmallIcon(R.drawable.stat_sys_warning).setWhen(0).setColor(contextForUser.getColor(R.color.system_notification_accent_color)).setContentTitle(title2).setContentText(subtitle2).setContentIntent(PendingIntent.getActivityAsUser(this.mContext, 0, intent, AudioFormat.AAC_ADIF, null, user)).build();
        installNotification(getCredentialPermissionNotificationId(account, authTokenType, uid, accounts), n, PackageManagerService.PLATFORM_PACKAGE_NAME, user.getIdentifier());
        return;
    L5:
        title2 = titleAndSubtitle;
        subtitle2 = "";
        goto L6
    }

    private String getApplicationLabel(String packageName, int userId) {
        return this.mPackageManager.getApplicationLabel(this.mPackageManager.getApplicationInfoAsUser(packageName, 0, userId)).toString();
    L5:
        return packageName;
    }

    private Intent newGrantCredentialsPermissionIntent(Account account, String packageName, int uid, AccountAuthenticatorResponse response, String authTokenType, boolean startInNewTask) {
        Intent intent = new Intent(this.mContext, GrantCredentialsPermissionActivity.class);
        if (startInNewTask == false) goto L5;
        intent.setFlags(268435456);
    L5:
        UserAccounts accounts = getUserAccounts(UserHandle.getUserId(uid));
        StringBuilder r2 = new StringBuilder();
        r2.append(getCredentialPermissionNotificationId(account, authTokenType, uid, accounts).mTag);
        if (packageName == null) goto L8;
        String r3 = packageName;
    L9:
        r2.append(r3);
        intent.addCategory(r2.toString());
        intent.putExtra("account", account);
        intent.putExtra("authTokenType", authTokenType);
        intent.putExtra("response", response);
        intent.putExtra("uid", uid);
        return intent;
    L8:
        r3 = "";
        goto L9
    }

    private NotificationId getCredentialPermissionNotificationId(Account account, String authTokenType, int uid, UserAccounts accounts) {
        HashMap r0 = UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts);
        monitor-enter(r0);
        Pair<Pair<Account, String>, Integer> key = new Pair(new Pair(account, authTokenType), Integer.valueOf(uid));     // Catch: Throwable -> L7
        NotificationId nId = (NotificationId) UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts).get(key);     // Catch: Throwable -> L7
        if (nId != null) goto L9;
        String tag = "AccountManagerService:38:" + account.hashCode() + ":" + authTokenType.hashCode() + ":" + uid;     // Catch: Throwable -> L7
        nId = new NotificationId(tag, 38);     // Catch: Throwable -> L7
        UserAccounts.m927$$Nest$fgetcredentialsPermissionNotificationIds(accounts).put(key, nId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return nId;
    L7:
        th = move-exception;
        throw th;
    }

    private NotificationId getSigninRequiredNotificationId(UserAccounts accounts, Account account) {
        HashMap r0 = UserAccounts.m931$$Nest$fgetsigninRequiredNotificationIds(accounts);
        monitor-enter(r0);
        NotificationId nId = (NotificationId) UserAccounts.m931$$Nest$fgetsigninRequiredNotificationIds(accounts).get(account);     // Catch: Throwable -> L7
        if (nId != null) goto L9;
        String tag = "AccountManagerService:37:" + account.hashCode();     // Catch: Throwable -> L7
        nId = new NotificationId(tag, 37);     // Catch: Throwable -> L7
        UserAccounts.m931$$Nest$fgetsigninRequiredNotificationIds(accounts).put(account, nId);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return nId;
    L7:
        th = move-exception;
        throw th;
    }

    public void addAccount(IAccountManagerResponse response, String accountType, String authTokenType, String[] requiredFeatures, boolean expectActivityLaunch, Bundle optionsIn) {
        SeempLog.record(16);
        Bundle.setDefusable(optionsIn, true);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "addAccount: accountType " + accountType + ", response " + response + ", authTokenType " + authTokenType + ", requiredFeatures " + Arrays.toString(requiredFeatures) + ", expectActivityLaunch " + expectActivityLaunch + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
    L5:
        if (response == null) goto L28;
        if (accountType == null) goto L26;
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getUserId(uid);
        if (canUserModifyAccounts(userId, uid) == true) goto L16;
        response.onError(100, "User is not allowed to add an account!");     // Catch: RemoteException -> L12
    L13:
        showCantAddAccount(100, userId);
        return;
    L16:
        if (canUserModifyAccountsForType(userId, accountType, uid) == false) goto L29;
        addAccountAndLogMetrics(response, accountType, authTokenType, requiredFeatures, expectActivityLaunch, optionsIn, userId);
        return;
    L29:
        response.onError(101, "User cannot modify accounts of this type (policy).");     // Catch: RemoteException -> L20
    L21:
        showCantAddAccount(101, userId);
        return;
    L26:
        throw new IllegalArgumentException("accountType is null");
    L28:
        throw new IllegalArgumentException("response is null");
    }

    public void addAccountAsUser(IAccountManagerResponse response, String accountType, String authTokenType, String[] requiredFeatures, boolean expectActivityLaunch, Bundle optionsIn, int userId) {
        boolean r0 = true;
        Bundle.setDefusable(optionsIn, true);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L6;
        Log.v(TAG, "addAccount: accountType " + accountType + ", response " + response + ", authTokenType " + authTokenType + ", requiredFeatures " + Arrays.toString(requiredFeatures) + ", expectActivityLaunch " + expectActivityLaunch + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid() + ", for user id " + userId);
    L6:
        if (response == null) goto L8;
        boolean r3 = true;
    L9:
        Preconditions.checkArgument(r3, "response cannot be null");
        if (accountType != null) goto L13;
        r0 = false;
    L13:
        Preconditions.checkArgument(r0, "accountType cannot be null");
        if (isCrossUser(callingUid, userId) == true) goto L34;
        if (canUserModifyAccounts(userId, callingUid) == true) goto L24;
        response.onError(100, "User is not allowed to add an account!");     // Catch: RemoteException -> L20
    L21:
        showCantAddAccount(100, userId);
        return;
    L24:
        if (canUserModifyAccountsForType(userId, accountType, callingUid) == false) goto L37;
        addAccountAndLogMetrics(response, accountType, authTokenType, requiredFeatures, expectActivityLaunch, optionsIn, userId);
        return;
    L37:
        response.onError(101, "User cannot modify accounts of this type (policy).");     // Catch: RemoteException -> L28
    L29:
        showCantAddAccount(101, userId);
        return;
    L34:
        throw new SecurityException(String.format("User %s trying to add account for %s", new Object[]{Integer.valueOf(UserHandle.getCallingUserId()), Integer.valueOf(userId)}));
    L8:
        r3 = false;
        goto L9
    }

    private void addAccountAndLogMetrics(final IAccountManagerResponse response, final String accountType, final String authTokenType, final String[] requiredFeatures, final boolean expectActivityLaunch, Bundle optionsIn, int userId) {
        int pid = Binder.getCallingPid();
        int uid = Binder.getCallingUid();
        if (optionsIn != null) goto L5;
        final Bundle options = new Bundle();
    L6:
        options.putInt("callerUid", uid);
        options.putInt("callerPid", pid);
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L22
        logRecordWithUid(accounts, AccountsDb.DEBUG_ACTION_CALLED_ACCOUNT_ADD, "accounts", uid);     // Catch: Throwable -> L22
        if (pid != 0) goto L11;
        final boolean isSelfRescue = true;
    L28:
        final boolean r8 = false;
        final boolean r9 = true;
        final boolean r6 = true;
        final String r7 = null;
        new AnonymousClass8(this, accounts, response, accountType, expectActivityLaunch, r6, r7, r8, r9, isSelfRescue, authTokenType, requiredFeatures, options, accountType).bind();     // Catch: Throwable -> L18
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L18:
        th = th;
    L24:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L20:
        th = th;
        goto L24
    L11:
        isSelfRescue = false;
    L22:
        th = th;
        goto L24
    L5:
        options = optionsIn;
        goto L6
    }

    private void logAddAccountMetrics(String callerPackage, String accountType, String[] requiredFeatures, String authTokenType) {
        DevicePolicyEventLogger r0 = DevicePolicyEventLogger.createEvent(202);
        String r1 = TextUtils.emptyIfNull(accountType);
        String r2 = TextUtils.emptyIfNull(callerPackage);
        String r3 = TextUtils.emptyIfNull(authTokenType);
        if (requiredFeatures != null) goto L5;
        String r4 = "";
    L6:
        r0.setStrings(new String[]{r1, r2, r3, r4}).write();
        return;
    L5:
        r4 = TextUtils.join(";", requiredFeatures);
        goto L6
    }

    public void startAddAccountSession(final IAccountManagerResponse response, final String accountType, String authTokenType, final String[] requiredFeatures, final boolean expectActivityLaunch, Bundle optionsIn) {
        boolean r0 = true;
        Bundle.setDefusable(optionsIn, true);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        StringBuilder r2 = new StringBuilder();
        r2.append("startAddAccountSession: accountType ");
        r2.append(accountType);
        r2.append(", response ");
        r2.append(response);
        r2.append(", authTokenType ");
        final String r10 = authTokenType;
        r2.append(r10);
        r2.append(", requiredFeatures ");
        r2.append(Arrays.toString(requiredFeatures));
        r2.append(", expectActivityLaunch ");
        r2.append(expectActivityLaunch);
        r2.append(", caller's uid ");
        r2.append(Binder.getCallingUid());
        r2.append(", pid ");
        r2.append(Binder.getCallingPid());
        Log.v(TAG, r2.toString());
    L7:
        if (response == null) goto L9;
        boolean r5 = true;
    L10:
        Preconditions.checkArgument(r5, "response cannot be null");
        if (accountType != null) goto L14;
        r0 = false;
    L14:
        Preconditions.checkArgument(r0, "accountType cannot be null");
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getUserId(uid);
        if (canUserModifyAccounts(userId, uid) == true) goto L23;
        response.onError(100, "User is not allowed to add an account!");     // Catch: RemoteException -> L19
    L20:
        showCantAddAccount(100, userId);
        return;
    L23:
        if (canUserModifyAccountsForType(userId, accountType, uid) == false) goto L52;
        int pid = Binder.getCallingPid();
        if (optionsIn != null) goto L33;
        final Bundle options = new Bundle();
    L34:
        options.putInt("callerUid", uid);
        options.putInt("callerPid", pid);
        final String callerPkg = options.getString("androidPackageName");
        final boolean isPasswordForwardingAllowed = checkPermissionAndNote(callerPkg, uid, new String[]{"android.permission.GET_PASSWORD"});
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L46
        logRecordWithUid(accounts, AccountsDb.DEBUG_ACTION_CALLED_START_ACCOUNT_ADD, "accounts", uid);     // Catch: Throwable -> L46
        final boolean r7 = false;
        final boolean r8 = true;
        final String r6 = null;
        new AnonymousClass9(this, accounts, response, accountType, expectActivityLaunch, r6, r7, r8, isPasswordForwardingAllowed, r10, requiredFeatures, options, callerPkg, accountType).bind();     // Catch: Throwable -> L42
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L42:
        th = th;
    L48:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L44:
        th = th;
    L46:
        th = th;
        goto L48
    L33:
        options = optionsIn;
        goto L34
    L52:
        response.onError(101, "User cannot modify accounts of this type (policy).");     // Catch: RemoteException -> L27
    L28:
        showCantAddAccount(101, userId);
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        r10 = authTokenType;
        goto L7
    }

    public void finishSessionAsUser(final IAccountManagerResponse response, Bundle sessionBundle, final boolean expectActivityLaunch, Bundle appInfo, int userId) {
        boolean r0 = true;
        Bundle.setDefusable(sessionBundle, true);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L6;
        Log.v(TAG, "finishSession: response " + response + ", expectActivityLaunch " + expectActivityLaunch + ", caller's uid " + callingUid + ", caller's user id " + UserHandle.getCallingUserId() + ", pid " + Binder.getCallingPid() + ", for user id " + userId);
    L6:
        if (response != null) goto L9;
        r0 = false;
    L9:
        Preconditions.checkArgument(r0, "response cannot be null");
        if (sessionBundle == null) goto L59;
        if (sessionBundle.size() == 0) goto L59;
        if (isCrossUser(callingUid, userId) == true) goto L57;
        if (canUserModifyAccounts(userId, callingUid) == true) goto L19;
        sendErrorResponse(response, 100, "User is not allowed to add an account!");
        showCantAddAccount(100, userId);
        return;
    L19:
        int pid = Binder.getCallingPid();
        CryptoHelper cryptoHelper = CryptoHelper.getInstance();     // Catch: GeneralSecurityException -> L49
        final Bundle decryptedBundle = cryptoHelper.decryptBundle(sessionBundle);     // Catch: GeneralSecurityException -> L49
        if (decryptedBundle != null) goto L26;
        sendErrorResponse(response, 8, "failed to decrypt session bundle");     // Catch: GeneralSecurityException -> L24
        return;
    L26:
        final String accountType = decryptedBundle.getString("accountType");     // Catch: GeneralSecurityException -> L49
        if (TextUtils.isEmpty(accountType) == false) goto L30;
        sendErrorResponse(response, 7, "accountType is empty");     // Catch: GeneralSecurityException -> L24
        return;
    L30:
        if (appInfo == null) goto L32;
        decryptedBundle.putAll(appInfo);     // Catch: GeneralSecurityException -> L24
    L32:
        decryptedBundle.putInt("callerUid", callingUid);     // Catch: GeneralSecurityException -> L49
        decryptedBundle.putInt("callerPid", pid);     // Catch: GeneralSecurityException -> L49
        if (canUserModifyAccountsForType(userId, accountType, callingUid) == true) goto L37;
        sendErrorResponse(response, 101, "User cannot modify accounts of this type (policy).");
        showCantAddAccount(101, userId);
        return;
    L37:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L45
        logRecordWithUid(accounts, AccountsDb.DEBUG_ACTION_CALLED_ACCOUNT_SESSION_FINISH, "accounts", callingUid);     // Catch: Throwable -> L45
        final boolean r8 = false;
        final boolean r9 = true;
        final boolean r6 = true;
        final String r7 = null;
        new AnonymousClass10(this, accounts, response, accountType, expectActivityLaunch, r6, r7, r8, r9, decryptedBundle, accountType).bind();     // Catch: Throwable -> L43
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L43:
        th = th;
    L47:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L45:
        th = th;
    L24:
        e = e;
    L52:
        if (Log.isLoggable(TAG, 3) == false) goto L54;
        Log.v(TAG, "Failed to decrypt session bundle!", e);
    L54:
        sendErrorResponse(response, 8, "failed to decrypt session bundle");
        return;
    L49:
        e = e;
        goto L52
    L57:
        throw new SecurityException(String.format("User %s trying to finish session for %s without cross user permission", new Object[]{Integer.valueOf(UserHandle.getCallingUserId()), Integer.valueOf(userId)}));
    L59:
        throw new IllegalArgumentException("sessionBundle is empty");
    }

    private void showCantAddAccount(int errorCode, int userId) {
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        Intent intent = null;
        if (dpmi != null) goto L6;
        intent = getDefaultCantAddAccountIntent(errorCode);
    L11:
        if (intent != null) goto L13;
        intent = getDefaultCantAddAccountIntent(errorCode);
    L13:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        this.mContext.startActivityAsUser(intent, new UserHandle(userId));     // Catch: Throwable -> L17
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L17:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L6:
        if (errorCode != 100) goto L9;
        intent = dpmi.createUserRestrictionSupportIntent(userId, "no_modify_accounts");
        goto L11
    L9:
        if (errorCode != 101) goto L11;
        intent = dpmi.createShowAdminSupportIntent(userId, false);
        goto L11
    }

    private Intent getDefaultCantAddAccountIntent(int errorCode) {
        Intent cantAddAccount = new Intent(this.mContext, CantAddAccountActivity.class);
        cantAddAccount.putExtra("android.accounts.extra.ERROR_CODE", errorCode);
        cantAddAccount.addFlags(268435456);
        return cantAddAccount;
    }

    public void confirmCredentialsAsUser(final IAccountManagerResponse response, final Account account, final Bundle options, boolean expectActivityLaunch, int userId) {
        Bundle.setDefusable(options, true);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("confirmCredentials: ");
        r0.append(account);
        r0.append(", response ");
        r0.append(response);
        r0.append(", expectActivityLaunch ");
        final boolean r5 = expectActivityLaunch;
        r0.append(r5);
        r0.append(", caller's uid ");
        r0.append(callingUid);
        r0.append(", pid ");
        r0.append(Binder.getCallingPid());
        Log.v(TAG, r0.toString());
    L7:
        if (isCrossUser(callingUid, userId) == true) goto L22;
        if (response == null) goto L20;
        if (account == null) goto L18;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L14
        final String r4 = account.type;     // Catch: Throwable -> L14
        final String r7 = account.name;     // Catch: Throwable -> L14
        final boolean r8 = true;
        final boolean r9 = true;
        final boolean r6 = true;
        new AnonymousClass11(this, accounts, response, r4, r5, r6, r7, r8, r9, account, options).bind();     // Catch: Throwable -> L14
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L14:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L18:
        throw new IllegalArgumentException("account is null");
    L20:
        throw new IllegalArgumentException("response is null");
    L22:
        throw new SecurityException(String.format("User %s trying to confirm account credentials for %s", new Object[]{Integer.valueOf(UserHandle.getCallingUserId()), Integer.valueOf(userId)}));
    L5:
        r5 = expectActivityLaunch;
        goto L7
    }

    public void updateCredentials(final IAccountManagerResponse response, final Account account, String authTokenType, boolean expectActivityLaunch, final Bundle loginOptions) {
        Bundle.setDefusable(loginOptions, true);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("updateCredentials: ");
        r0.append(account);
        r0.append(", response ");
        r0.append(response);
        r0.append(", authTokenType ");
        final String r11 = authTokenType;
        r0.append(r11);
        r0.append(", expectActivityLaunch ");
        final boolean r5 = expectActivityLaunch;
        r0.append(r5);
        r0.append(", caller's uid ");
        r0.append(Binder.getCallingUid());
        r0.append(", pid ");
        r0.append(Binder.getCallingPid());
        Log.v(TAG, r0.toString());
    L6:
        if (response == null) goto L18;
        if (account == null) goto L16;
        int userId = UserHandle.getCallingUserId();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L12
        final String r4 = account.type;     // Catch: Throwable -> L12
        final String r7 = account.name;     // Catch: Throwable -> L12
        final boolean r8 = false;
        final boolean r9 = true;
        final boolean r6 = true;
        new AnonymousClass12(this, accounts, response, r4, r5, r6, r7, r8, r9, account, r11, loginOptions).bind();     // Catch: Throwable -> L12
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L12:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L16:
        throw new IllegalArgumentException("account is null");
    L18:
        throw new IllegalArgumentException("response is null");
    L5:
        r11 = authTokenType;
        r5 = expectActivityLaunch;
        goto L6
    }

    public void startUpdateCredentialsSession(final IAccountManagerResponse response, final Account account, String authTokenType, boolean expectActivityLaunch, final Bundle loginOptions) {
        Bundle.setDefusable(loginOptions, true);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("startUpdateCredentialsSession: ");
        r0.append(account);
        r0.append(", response ");
        r0.append(response);
        r0.append(", authTokenType ");
        final String r11 = authTokenType;
        r0.append(r11);
        r0.append(", expectActivityLaunch ");
        final boolean r5 = expectActivityLaunch;
        r0.append(r5);
        r0.append(", caller's uid ");
        r0.append(Binder.getCallingUid());
        r0.append(", pid ");
        r0.append(Binder.getCallingPid());
        Log.v(TAG, r0.toString());
    L6:
        if (response == null) goto L18;
        if (account == null) goto L16;
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        String callerPkg = loginOptions.getString("androidPackageName");
        final boolean isPasswordForwardingAllowed = checkPermissionAndNote(callerPkg, uid, new String[]{"android.permission.GET_PASSWORD"});
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L12
        final String r4 = account.type;     // Catch: Throwable -> L12
        final String r6 = account.name;     // Catch: Throwable -> L12
        final boolean r7 = false;
        final boolean r8 = true;
        new AnonymousClass13(this, accounts, response, r4, r5, r6, r7, r8, isPasswordForwardingAllowed, account, r11, loginOptions).bind();     // Catch: Throwable -> L12
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L12:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L16:
        throw new IllegalArgumentException("account is null");
    L18:
        throw new IllegalArgumentException("response is null");
    L5:
        r11 = authTokenType;
        r5 = expectActivityLaunch;
        goto L6
    }

    public void isCredentialsUpdateSuggested(final IAccountManagerResponse response, final Account account, final String statusToken) {
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "isCredentialsUpdateSuggested: " + account + ", response " + response + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
    L5:
        if (response == null) goto L21;
        if (account == null) goto L19;
        if (TextUtils.isEmpty(statusToken) == true) goto L17;
        int usrId = UserHandle.getCallingUserId();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(usrId);     // Catch: Throwable -> L13
        final String r4 = account.type;     // Catch: Throwable -> L13
        final String r7 = account.name;     // Catch: Throwable -> L13
        final boolean r8 = false;
        final boolean r5 = false;
        final boolean r6 = false;
        new AnonymousClass14(this, accounts, response, r4, r5, r6, r7, r8, account, statusToken).bind();     // Catch: Throwable -> L13
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L13:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L17:
        throw new IllegalArgumentException("status token is empty");
    L19:
        throw new IllegalArgumentException("account is null");
    L21:
        throw new IllegalArgumentException("response is null");
    }

    public void editProperties(final IAccountManagerResponse response, final String accountType, boolean expectActivityLaunch) {
        SeempLog.record(21);
        int callingUid = Binder.getCallingUid();
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        r0.append("editProperties: accountType ");
        r0.append(accountType);
        r0.append(", response ");
        r0.append(response);
        r0.append(", expectActivityLaunch ");
        final boolean r5 = expectActivityLaunch;
        r0.append(r5);
        r0.append(", caller's uid ");
        r0.append(callingUid);
        r0.append(", pid ");
        r0.append(Binder.getCallingPid());
        Log.v(TAG, r0.toString());
    L6:
        if (response == null) goto L25;
        if (accountType == null) goto L23;
        int userId = UserHandle.getCallingUserId();
        if (isAccountManagedByCaller(accountType, callingUid, userId) == false) goto L11;
    L15:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        final UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L19
        final String r7 = null;
        final boolean r8 = false;
        final boolean r6 = true;
        new AnonymousClass15(this, accounts, response, accountType, r5, r6, r7, r8, accountType).bind();     // Catch: Throwable -> L19
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L19:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L11:
        if (isSystemUid(callingUid) == true) goto L15;
        String msg = String.format("uid %s cannot edit authenticator properites for account type: %s", new Object[]{Integer.valueOf(callingUid), accountType});
        throw new SecurityException(msg);
    L23:
        throw new IllegalArgumentException("accountType is null");
    L25:
        throw new IllegalArgumentException("response is null");
    L5:
        r5 = expectActivityLaunch;
        goto L6
    }

    public boolean hasAccountAccess(Account account, String packageName, UserHandle userHandle) {
        if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L11;
        account.getClass();
        packageName.getClass();
        userHandle.getClass();
        int userId = userHandle.getIdentifier();
        Preconditions.checkArgumentInRange(userId, 0, Integer.MAX_VALUE, "user must be concrete");
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L7
        return hasAccountAccess(account, packageName, uid);
    L7:
        e = move-exception;
        Log.w(TAG, "hasAccountAccess#Package not found " + e.getMessage());
        return false;
    L11:
        throw new SecurityException("Can be called only by system UID");
    }

    private String getPackageNameForUid(int uid) {
        String[] packageNames = this.mPackageManager.getPackagesForUid(uid);
        if (ArrayUtils.isEmpty(packageNames) == false) goto L6;
        return null;
    L6:
        String packageName = packageNames[0];
        if (packageNames.length != 1) goto L9;
        return packageName;
    L9:
        int oldestVersion = Integer.MAX_VALUE;
        int r4 = packageNames.length;
        int r5 = 0;
    L10:
        if (r5 >= r4) goto L21;
        String name = packageNames[r5];
        ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(name, 0);     // Catch: PackageManager.NameNotFoundException -> L17
        if (applicationInfo == null) goto L20;
        int version = applicationInfo.targetSdkVersion;     // Catch: PackageManager.NameNotFoundException -> L17
        if (version >= oldestVersion) goto L20;
        oldestVersion = version;
        packageName = name;
    L20:
        r5 = r5 + 1;
        goto L10
    L21:
        return packageName;
    }

    private boolean hasAccountAccess(Account account, String packageName, int uid) {
        if (packageName != null) goto L8;
        packageName = getPackageNameForUid(uid);
        if (packageName != null) goto L8;
        return false;
    L8:
        if (permissionIsGranted(account, null, uid, UserHandle.getUserId(uid)) == false) goto L10;
        return true;
    L10:
        int visibility = resolveAccountVisibility(account, packageName, uid, getUserAccounts(UserHandle.getUserId(uid))).intValue();
        if (visibility == 1) goto L15;
        if (visibility == 2) goto L15;
        return false;
    L15:
        return true;
    }

    public IntentSender createRequestAccountAccessIntentSenderAsUser(Account account, String packageName, UserHandle userHandle) {
        if (UserHandle.getAppId(Binder.getCallingUid()) != 1000) goto L17;
        account.getClass();
        packageName.getClass();
        userHandle.getClass();
        int userId = userHandle.getIdentifier();
        Preconditions.checkArgumentInRange(userId, 0, Integer.MAX_VALUE, "user must be concrete");
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L13
        Intent intent = newRequestAccountAccessIntent(account, packageName, uid, null);
        long identity = Binder.clearCallingIdentity();
        IntentSender r0 = PendingIntent.getActivityAsUser(this.mContext, 0, intent, 1409286144, null, new UserHandle(userId)).getIntentSender();     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return r0;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L14:
        Slog.e(TAG, "Unknown package " + packageName);
        return null;
    L17:
        throw new SecurityException("Can be called only by system UID");
    }

    private Intent newRequestAccountAccessIntent(final Account account, String packageName, final int uid, final RemoteCallback callback) {
        return newGrantCredentialsPermissionIntent(account, packageName, uid, new AccountAuthenticatorResponse(new AnonymousClass16(this, uid, account, callback)), "com.android.AccountManager.ACCOUNT_ACCESS_TOKEN_TYPE", false);
    }

    public boolean someUserHasAccount(Account account) {
        if (UserHandle.isSameApp(1000, Binder.getCallingUid()) == false) goto L19;
        long token = Binder.clearCallingIdentity();
        AccountAndUser[] allAccounts = getAllAccountsForSystemProcess();     // Catch: Throwable -> L12
        int i = allAccounts.length - 1;     // Catch: Throwable -> L12
    L6:
        if (i < 0) goto L14;
        if (allAccounts[i].account.equals(account) == true) goto L9;
        i = i - 1;
        goto L6
    L9:
        Binder.restoreCallingIdentity(token);
        return true;
    L14:
        Binder.restoreCallingIdentity(token);
        return false;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L19:
        throw new SecurityException("Only system can check for accounts across users");
    }

    public Account[] getAccounts(int userId, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        List<String> visibleAccountTypes = getTypesVisibleToCaller(callingUid, userId, opPackageName);
        if (visibleAccountTypes.isEmpty() == true) goto L5;
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L16 SQLiteException -> L18
    L27:
        Account[] r11 = getAccountsInternal(accounts, callingUid, opPackageName, visibleAccountTypes, false);     // Catch: Throwable -> L12 SQLiteException -> L14
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r11;
    L14:
        e = move-exception;
        SQLiteException e = e;
    L21:
        Log.w(TAG, "Could not get accounts for user " + userId, e);     // Catch: Throwable -> L12
        Account[] r0 = new Account[0];     // Catch: Throwable -> L12
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r0;
    L12:
        th = move-exception;
        SQLiteException e2 = th;
    L24:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw e2;
    L18:
        e = move-exception;
        e = e;
    L16:
        th = move-exception;
        e2 = th;
        goto L24
    L5:
        return EMPTY_ACCOUNT_ARRAY;
    }

    public AccountAndUser[] getRunningAccountsForSystem() {
        int[] runningUserIds = ActivityManager.getService().getRunningUserIds();     // Catch: RemoteException -> L5
        return getAccountsForSystem(runningUserIds);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public AccountAndUser[] getAllAccountsForSystemProcess() {
        List<UserInfo> users = getUserManager().getAliveUsers();
        int[] userIds = new int[users.size()];
        int i = 0;
    L4:
        if (i >= userIds.length) goto L7;
        userIds[i] = users.get(i).id;
        i = i + 1;
        goto L4
    L7:
        return getAccountsForSystem(userIds);
    }

    private AccountAndUser[] getAccountsForSystem(int[] userIds) {
        ArrayList<AccountAndUser> runningAccounts = Lists.newArrayList();
        int r2 = userIds.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L17;
        int userId = userIds[r4];
        UserAccounts userAccounts = getUserAccounts(userId);
        if (userAccounts == null) goto L16;
        Account[] accounts = getAccountsFromCache(userAccounts, null, Binder.getCallingUid(), PackageManagerService.PLATFORM_PACKAGE_NAME, false);     // Catch: SQLiteException -> L12
        int r6 = accounts.length;     // Catch: SQLiteException -> L12
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L16;
        Account account = accounts[r8];     // Catch: SQLiteException -> L12
        runningAccounts.add(new AccountAndUser(account, userId));     // Catch: SQLiteException -> L12
        r8 = r8 + 1;
    L12:
        e = move-exception;
        Log.w(TAG, "Could not get accounts for user " + userId, e);
    L16:
        r4 = r4 + 1;
        goto L3
    L17:
        AccountAndUser[] accountsArray = new AccountAndUser[runningAccounts.size()];
        return (AccountAndUser[]) runningAccounts.toArray(accountsArray);
    }

    public Account[] getAccountsAsUser(String type, int userId, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        return getAccountsAsUserForPackage(type, userId, opPackageName, -1, opPackageName, false);
    L5:
        e = move-exception;
        Log.e(TAG, "Could not get accounts for user " + userId, e);
        return new Account[0];
    }

    private Account[] getAccountsOrEmptyArray(String type, int userId, String opPackageName) {
        return getAccountsAsUser(type, userId, opPackageName);
    L4:
        e = move-exception;
        Log.w(TAG, "Could not get accounts for user " + userId, e);
        return new Account[0];
    }

    private Account[] getAccountsAsUserForPackage(String type, int userId, String callingPackage, int packageUid, String opPackageName, boolean includeUserManagedNotVisible) {
        int callingUid = Binder.getCallingUid();
        if (userId == UserHandle.getCallingUserId()) goto L11;
        if (callingUid == 1000) goto L11;
        if (this.mContext.checkCallingOrSelfPermission("android.permission.INTERACT_ACROSS_USERS_FULL") == 0) goto L11;
        throw new SecurityException("User " + UserHandle.getCallingUserId() + " trying to get account for " + userId);
    L11:
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        Log.v(TAG, "getAccounts: accountType " + type + ", caller's uid " + Binder.getCallingUid() + ", pid " + Binder.getCallingPid());
    L13:
        List<String> managedTypes = getTypesManagedByCaller(callingUid, UserHandle.getUserId(callingUid));
        if (packageUid != (-1)) goto L16;
    L21:
        String opPackageName2 = opPackageName;
        int callingUid2 = callingUid;
    L22:
        List<String> visibleAccountTypes = getTypesVisibleToCaller(callingUid2, userId, opPackageName2);
        if (visibleAccountTypes.isEmpty() == true) goto L45;
        if (type == null) goto L29;
        if (visibleAccountTypes.contains(type) == false) goto L45;
    L29:
        if (visibleAccountTypes.contains(type) == false) goto L31;
        List<String> visibleAccountTypes2 = new ArrayList();
        visibleAccountTypes2.add(type);
        List<String> visibleAccountTypes3 = visibleAccountTypes2;
    L32:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts accounts = getUserAccounts(userId);     // Catch: Throwable -> L36 SQLiteException -> L38
        Account[] r0 = getAccountsInternal(accounts, callingUid2, opPackageName2, visibleAccountTypes3, includeUserManagedNotVisible);     // Catch: Throwable -> L36 SQLiteException -> L38
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r0;
    L36:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L38:
        e = move-exception;
        Log.w(TAG, "Could not get accounts for user " + userId, e);     // Catch: Throwable -> L36
        Account[] r1 = new Account[0];     // Catch: Throwable -> L36
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return r1;
    L31:
        visibleAccountTypes3 = visibleAccountTypes;
    L45:
        return EMPTY_ACCOUNT_ARRAY;
    L16:
        if (UserHandle.isSameApp(callingUid, 1000) == true) goto L20;
        if (type == null) goto L21;
        if (managedTypes.contains(type) == false) goto L21;
    L20:
        opPackageName2 = callingPackage;
        callingUid2 = packageUid;
        goto L22
    }

    private Account[] getAccountsInternal(UserAccounts userAccounts, int callingUid, String callingPackage, List<String> visibleAccountTypes, boolean includeUserManagedNotVisible) {
        ArrayList<Account> visibleAccounts = new ArrayList();
        Iterator<String> r1 = visibleAccountTypes.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        String visibleType = r1.next();
        UserAccounts userAccounts2 = userAccounts;
        int callingUid2 = callingUid;
        String callingPackage2 = callingPackage;
        boolean includeUserManagedNotVisible2 = includeUserManagedNotVisible;
        Account[] accountsForType = getAccountsFromCache(userAccounts2, visibleType, callingUid2, callingPackage2, includeUserManagedNotVisible2);
        if (accountsForType == null) goto L8;
        visibleAccounts.addAll(Arrays.asList(accountsForType));
    L8:
        userAccounts = userAccounts2;
        callingUid = callingUid2;
        callingPackage = callingPackage2;
        includeUserManagedNotVisible = includeUserManagedNotVisible2;
        goto L4
    L9:
        Account[] result = new Account[visibleAccounts.size()];
        int i = 0;
    L11:
        if (i >= visibleAccounts.size()) goto L14;
        result[i] = visibleAccounts.get(i);
        i = i + 1;
        goto L11
    L14:
        return result;
    }

    public void addSharedAccountsFromParentUser(int parentUserId, int userId, String opPackageName) {
        checkManageOrCreateUsersPermission("addSharedAccountsFromParentUser");
        Account[] accounts = getAccountsOrEmptyArray(null, parentUserId, opPackageName);
        int r1 = accounts.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Account account = accounts[r2];
        addSharedAccountAsUser(account, userId);
        r2 = r2 + 1;
        goto L3
    }

    private boolean addSharedAccountAsUser(Account account, int userId) {
        UserAccounts accounts = getUserAccounts(handleIncomingUser(userId));
        accounts.accountsDb.deleteSharedAccount(account);
        long accountId = accounts.accountsDb.insertSharedAccount(account);
        if (accountId >= 0) goto L6;
        Log.w(TAG, "insertAccountIntoDatabase: " + account.toSafeString() + ", skipping the DB insert failed");
        return false;
    L6:
        logRecord(AccountsDb.DEBUG_ACTION_ACCOUNT_ADD, "shared_accounts", accountId, accounts);
        return true;
    }

    public boolean renameSharedAccountAsUser(Account account, String newName, int userId) {
        UserAccounts accounts = getUserAccounts(handleIncomingUser(userId));
        long sharedTableAccountId = accounts.accountsDb.findSharedAccountId(account);
        int r = accounts.accountsDb.renameSharedAccount(account, newName);
        if (r <= 0) goto L6;
        int callingUid = IAccountManager.Stub.getCallingUid();
        logRecord(AccountsDb.DEBUG_ACTION_ACCOUNT_RENAME, "shared_accounts", sharedTableAccountId, accounts, callingUid);
        renameAccountInternal(accounts, account, newName);
    L6:
        if (r <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean removeSharedAccountAsUser(Account account, int userId) {
        return removeSharedAccountAsUser(account, userId, IAccountManager.Stub.getCallingUid());
    }

    private boolean removeSharedAccountAsUser(Account account, int userId, int callingUid) {
        UserAccounts accounts = getUserAccounts(handleIncomingUser(userId));
        long sharedTableAccountId = accounts.accountsDb.findSharedAccountId(account);
        boolean deleted = accounts.accountsDb.deleteSharedAccount(account);
        if (deleted == false) goto L6;
        logRecord(AccountsDb.DEBUG_ACTION_ACCOUNT_REMOVE, "shared_accounts", sharedTableAccountId, accounts, callingUid);
        removeAccountInternal(accounts, account, callingUid);
    L6:
        return deleted;
    }

    public Account[] getSharedAccountsAsUser(int userId) {
        int userId2 = handleIncomingUser(userId);
        UserAccounts accounts = getUserAccounts(userId2);     // Catch: SQLiteException -> L11
        Object r1 = accounts.dbLock;     // Catch: SQLiteException -> L11
        monitor-enter(r1);     // Catch: SQLiteException -> L11
        List<Account> accountList = accounts.accountsDb.getSharedAccounts();     // Catch: Throwable -> L8
        Account[] accountArray = new Account[accountList.size()];     // Catch: Throwable -> L8
        accountList.toArray(accountArray);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return accountArray;
    L8:
        th = move-exception;
        throw th;     // Catch: SQLiteException -> L11
    L11:
        e = move-exception;
        Log.w(TAG, "Could not get shared accounts for user " + userId2, e);
        return new Account[0];
    }

    public Account[] getAccountsForPackage(String packageName, int uid, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        if (UserHandle.isSameApp(callingUid, 1000) == false) goto L7;
        return getAccountsAsUserForPackage(null, UserHandle.getCallingUserId(), packageName, uid, opPackageName, true);
    L7:
        throw new SecurityException("getAccountsForPackage() called from unauthorized uid " + callingUid + " with uid=" + uid);
    }

    public Account[] getAccountsByTypeForPackage(String type, String packageName, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        int userId = UserHandle.getCallingUserId();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        int packageUid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L18
        if (UserHandle.isSameApp(callingUid, 1000) == true) goto L12;
        if (type == null) goto L12;
        if (isAccountManagedByCaller(type, callingUid, userId) == true) goto L12;
        return EMPTY_ACCOUNT_ARRAY;
    L12:
        if (UserHandle.isSameApp(callingUid, 1000) == true) goto L17;
        if (type != null) goto L17;
        return getAccountsAsUserForPackage(type, userId, packageName, packageUid, opPackageName, false);
    L17:
        return getAccountsAsUserForPackage(type, userId, packageName, packageUid, opPackageName, true);
    L18:
        re = move-exception;
        Slog.e(TAG, "Couldn't determine the packageUid for " + packageName + re);
        return EMPTY_ACCOUNT_ARRAY;
    }

    private boolean needToStartChooseAccountActivity(Account[] accounts, String callingPackage) {
        if (accounts.length >= 1) goto L6;
        return false;
    L6:
        if (accounts.length <= 1) goto L8;
        return true;
    L8:
        Account account = accounts[0];
        UserAccounts userAccounts = getUserAccounts(UserHandle.getCallingUserId());
        int visibility = resolveAccountVisibility(account, callingPackage, Binder.getCallingUid(), userAccounts).intValue();
        if (visibility != 4) goto L11;
        return true;
    L11:
        return false;
    }

    private void startChooseAccountActivityWithAccounts(IAccountManagerResponse response, Account[] accounts, String callingPackage) {
        Intent intent = new Intent(this.mContext, ChooseAccountActivity.class);
        intent.putExtra("accounts", accounts);
        intent.putExtra("accountManagerResponse", new AccountManagerResponse(response));
        intent.putExtra("androidPackageName", callingPackage);
        this.mContext.startActivityAsUser(intent, UserHandle.of(UserHandle.getCallingUserId()));
    }

    private void handleGetAccountsResult(IAccountManagerResponse response, Account[] accounts, String callingPackage) {
        if (needToStartChooseAccountActivity(accounts, callingPackage) == false) goto L7;
        startChooseAccountActivityWithAccounts(response, accounts, callingPackage);
        return;
    L7:
        if (accounts.length != 1) goto L10;
        Bundle bundle = new Bundle();
        bundle.putString("authAccount", accounts[0].name);
        bundle.putString("accountType", accounts[0].type);
        onResult(response, bundle);
        return;
    L10:
        onResult(response, new Bundle());
    }

    public void getAccountByTypeAndFeatures(final IAccountManagerResponse response, String accountType, String[] features, final String opPackageName) {
        int callingUid = Binder.getCallingUid();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "getAccount: accountType " + accountType + ", response " + response + ", features " + Arrays.toString(features) + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        if (response == null) goto L29;
        if (accountType == null) goto L27;
        int userId = UserHandle.getCallingUserId();
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts userAccounts = getUserAccounts(userId);     // Catch: Throwable -> L13
        if (ArrayUtils.isEmpty(features) == false) goto L30;
        Account[] accountsWithManagedNotVisible = getAccountsFromCache(userAccounts, accountType, callingUid, opPackageName, true);     // Catch: Throwable -> L13
        handleGetAccountsResult(response, accountsWithManagedNotVisible, opPackageName);     // Catch: Throwable -> L13
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L30:
        new GetAccountsByTypeAndFeatureSession(this, userAccounts, new AnonymousClass17(this, response, opPackageName), accountType, features, callingUid, opPackageName, true).bind();     // Catch: Throwable -> L13
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L22:
        th = th;
    L24:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L13:
        th = th;
        goto L24
    L27:
        throw new IllegalArgumentException("accountType is null");
    L29:
        throw new IllegalArgumentException("response is null");
    }

    public void getAccountsByFeatures(IAccountManagerResponse response, String type, String[] features, String opPackageName) {
        int callingUid = Binder.getCallingUid();
        this.mAppOpsManager.checkPackage(callingUid, opPackageName);
        if (Log.isLoggable(TAG, 2) == false) goto L5;
        Log.v(TAG, "getAccounts: accountType " + type + ", response " + response + ", features " + Arrays.toString(features) + ", caller's uid " + callingUid + ", pid " + Binder.getCallingPid());
    L5:
        if (response == null) goto L41;
        if (type == null) goto L39;
        int userId = UserHandle.getCallingUserId();
        List<String> visibleAccountTypes = getTypesVisibleToCaller(callingUid, userId, opPackageName);
        if (visibleAccountTypes.contains(type) == true) goto L15;
        Bundle result = new Bundle();
        result.putParcelableArray("accounts", EMPTY_ACCOUNT_ARRAY);
        response.onResult(result);     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Log.e(TAG, "Cannot respond to caller do to exception.", e);
        return;
    L15:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        UserAccounts userAccounts = getUserAccounts(userId);     // Catch: Throwable -> L28
        if (features == null) goto L33;
        if (features.length == 0) goto L33;
        new GetAccountsByTypeAndFeatureSession(this, userAccounts, response, type, features, callingUid, opPackageName, false).bind();     // Catch: Throwable -> L28
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L30:
        th = th;
    L36:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L33:
        Account[] accounts = getAccountsFromCache(userAccounts, type, callingUid, opPackageName, false);     // Catch: Throwable -> L28
        Bundle result2 = new Bundle();     // Catch: Throwable -> L28
        result2.putParcelableArray("accounts", accounts);     // Catch: Throwable -> L28
        onResult(response, result2);     // Catch: Throwable -> L28
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L28:
        th = th;
        goto L36
    L39:
        throw new IllegalArgumentException("accountType is null");
    L41:
        throw new IllegalArgumentException("response is null");
    }

    public void onAccountAccessed(String token) throws RemoteException {
        int uid = Binder.getCallingUid();
        if (UserHandle.getAppId(uid) != 1000) goto L5;
        return;
    L5:
        int userId = UserHandle.getCallingUserId();
        long identity = Binder.clearCallingIdentity();
        Account[] r4 = getAccounts(userId, this.mContext.getOpPackageName());     // Catch: Throwable -> L14
        int r5 = r4.length;     // Catch: Throwable -> L14
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L17;
        Account account = r4[r6];     // Catch: Throwable -> L14
        if (Objects.equals(account.getAccessId(), token) == false) goto L16;
        if (hasAccountAccess(account, null, uid) == true) goto L16;
        updateAppPermission(account, "com.android.AccountManager.ACCOUNT_ACCESS_TOKEN_TYPE", uid, true);     // Catch: Throwable -> L14
    L16:
        r6 = r6 + 1;
        goto L7
    L17:
        Binder.restoreCallingIdentity(identity);
        return;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new AccountManagerServiceShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    private void logRecord(UserAccounts accounts, String action, String tableName) {
        logRecord(action, tableName, -1, accounts);
    }

    private void logRecordWithUid(UserAccounts accounts, String action, String tableName, int uid) {
        logRecord(action, tableName, -1, accounts, uid);
    }

    private void logRecord(String action, String tableName, long accountId, UserAccounts userAccount) {
        logRecord(action, tableName, accountId, userAccount, IAccountManager.Stub.getCallingUid());
    }

    private void logRecord(final String action, final String tableName, final long accountId, final UserAccounts userAccount, final int callingUid) {
        final long insertionPoint = userAccount.accountsDb.reserveDebugDbInsertionPoint();
        if (insertionPoint == (-1)) goto L6;
        Runnable r0 = new C1LogRecordTask(this, action, tableName, accountId, userAccount, callingUid, insertionPoint);
        this.mHandler.post(r0);
        return;
    }

    public IBinder onBind(Intent intent) {
        return asBinder();
    }

    private static boolean scanArgs(String[] args, String value) {
        if (args == null) goto L12;
        int r1 = args.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        String arg = args[r2];
        if (value.equals(arg) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, fout) == true) goto L6;
        return;
    L6:
        if (scanArgs(args, "--checkin") == false) goto L8;
    L11:
        boolean r0 = true;
    L12:
        boolean isCheckinRequest = r0;
        IndentingPrintWriter ipw = new IndentingPrintWriter(fout, "  ");
        List<UserInfo> users = getUserManager().getUsers();
        Iterator<UserInfo> r7 = users.iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        UserInfo user = r7.next();
        ipw.println("User " + user + ":");
        ipw.increaseIndent();
        dumpUser(getUserAccounts(user.id), fd, ipw, args, isCheckinRequest);
        ipw.println();
        ipw.decreaseIndent();
        goto L14
    L16:
        return;
    L8:
        if (scanArgs(args, "-c") == true) goto L11;
        r0 = false;
        goto L12
    }

    private void dumpUser(UserAccounts userAccounts, FileDescriptor fd, PrintWriter fout, String[] args, boolean isCheckinRequest) {
        if (isCheckinRequest == false) goto L12;
        Object r1 = userAccounts.dbLock;
        monitor-enter(r1);
        userAccounts.accountsDb.dumpDeAccountsTable(fout);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        Account[] accounts = getAccountsFromCache(userAccounts, null, 1000, PackageManagerService.PLATFORM_PACKAGE_NAME, false);
        fout.println("Accounts: " + accounts.length);
        int r0 = accounts.length;
        int r4 = 0;
    L13:
        if (r4 >= r0) goto L15;
        fout.println("  " + accounts[r4].toString());
        r4 = r4 + 1;
        goto L13
    L15:
        fout.println();
        Object r5 = userAccounts.dbLock;
        monitor-enter(r5);
        userAccounts.accountsDb.dumpDebugTable(fout);     // Catch: Throwable -> L57
        monitor-exit(r5);     // Catch: Throwable -> L57
        fout.println();
        LinkedHashMap<String, Session> r6 = this.mSessions;
        monitor-enter(r6);
        long now = SystemClock.elapsedRealtime();     // Catch: Throwable -> L25
        fout.println("Active Sessions: " + this.mSessions.size());     // Catch: Throwable -> L25
        Iterator<Session> r2 = this.mSessions.values().iterator();     // Catch: Throwable -> L25
    L23:
        if (r2.hasNext() == false) goto L27;
        Session session = r2.next();     // Catch: Throwable -> L25
        fout.println("  " + session.toDebugString(now));     // Catch: Throwable -> L25
        goto L23
    L27:
        monitor-exit(r6);     // Catch: Throwable -> L25
        fout.println();
        this.mAuthenticatorCache.dump(fd, fout, args, UserAccounts.m933$$Nest$fgetuserId(userAccounts));
        SparseArray<UserAccounts> r7 = this.mUsers;
        monitor-enter(r7);
        boolean isUserUnlocked = isLocalUnlockedUser(UserAccounts.m933$$Nest$fgetuserId(userAccounts));     // Catch: Throwable -> L50
        monitor-exit(r7);     // Catch: Throwable -> L50
        if (isUserUnlocked == true) goto L34;
        return;
    L34:
        fout.println();
        Object r9 = userAccounts.dbLock;
        monitor-enter(r9);
        Map<Account, Map<String, Integer>> allVisibilityValues = userAccounts.accountsDb.findAllVisibilityValues();     // Catch: Throwable -> L43
        fout.println("Account visibility:");     // Catch: Throwable -> L43
        Iterator<Account> r8 = allVisibilityValues.keySet().iterator();     // Catch: Throwable -> L43
    L38:
        if (r8.hasNext() == false) goto L46;
        Account account = r8.next();     // Catch: Throwable -> L43
        fout.println("  " + account.name);     // Catch: Throwable -> L43
        Map<String, Integer> visibilities = allVisibilityValues.get(account);     // Catch: Throwable -> L43
        Iterator<Map.Entry<String, Integer>> r12 = visibilities.entrySet().iterator();     // Catch: Throwable -> L43
    L41:
        if (r12.hasNext() == false) goto L38;
        Map.Entry<String, Integer> entry = r12.next();     // Catch: Throwable -> L43
        fout.println("    " + entry.getKey() + ", " + entry.getValue());     // Catch: Throwable -> L43
        goto L41
    L46:
        monitor-exit(r9);     // Catch: Throwable -> L43
        return;
    L43:
        th = move-exception;
        throw th;
    L50:
        th = move-exception;
        throw th;
    L25:
        th = th;
    L75:
        throw th;
    L55:
        th = th;
    L57:
        th = th;
    L67:
        throw th;
    L61:
        th = th;
        goto L67
    }

    private void doNotification(UserAccounts accounts, Account account, CharSequence message, Intent intent, String packageName, int userId) {
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
    L6:
        th = th;
    L21:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw th;
    L4:
        if (Log.isLoggable(TAG, 2) == false) goto L25;
        Log.v(TAG, "doNotification: " + message + " intent:" + intent);     // Catch: Throwable -> L6
    L25:
        if (intent.getComponent() == null) goto L18;
        if (GrantCredentialsPermissionActivity.class.getName().equals(intent.getComponent().getClassName()) == false) goto L18;
        createNoCredentialsPermissionNotification(account, intent, packageName, accounts);     // Catch: Throwable -> L14
    L19:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        return;
    L18:
        Context contextForUser = getContextForUser(new UserHandle(userId));     // Catch: Throwable -> L14
        NotificationId id = getSigninRequiredNotificationId(accounts, account);     // Catch: Throwable -> L14
        intent.addCategory(id.mTag);     // Catch: Throwable -> L14
        String notificationTitleFormat = contextForUser.getText(R.string.permdesc_scene_understanding_fine).toString();     // Catch: Throwable -> L14
        Notification n = new Notification.Builder(contextForUser, "ACCOUNT").setWhen(0).setSmallIcon(R.drawable.stat_sys_warning).setColor(contextForUser.getColor(R.color.system_notification_accent_color)).setContentTitle(String.format(notificationTitleFormat, new Object[]{account.name})).setContentText(message).setContentIntent(PendingIntent.getActivityAsUser(this.mContext, 0, intent, AudioFormat.AAC_ADIF, null, new UserHandle(userId))).build();     // Catch: Throwable -> L14
        installNotification(id, n, packageName, userId);     // Catch: Throwable -> L14
    L14:
        th = th;
        goto L21
    }

    private void installNotification(NotificationId id, Notification notification, String packageName, int userId) {
        long token = IAccountManager.Stub.clearCallingIdentity();
        INotificationManager notificationManager = this.mInjector.getNotificationManager();     // Catch: Throwable -> L13
        goto L17
    L24:
        notificationManager.enqueueNotificationWithTag(packageName, PackageManagerService.PLATFORM_PACKAGE_NAME, id.mTag, NotificationId.m924$$Nest$fgetmId(id), notification, userId);     // Catch: Throwable -> L9 RemoteException -> L11
    L9:
        th = move-exception;
        Throwable r12 = th;
    L19:
        Binder.restoreCallingIdentity(token);
        throw r12;
    L17:
        Binder.restoreCallingIdentity(token);
        return;
    L13:
        th = move-exception;
        r12 = th;
        goto L19
    }

    private void cancelNotification(NotificationId id, UserAccounts accounts) {
        cancelNotification(id, this.mContext.getPackageName(), accounts);
    }

    private void cancelNotification(NotificationId id, String packageName, UserAccounts accounts) {
        long identityToken = IAccountManager.Stub.clearCallingIdentity();
        INotificationManager service = this.mInjector.getNotificationManager();     // Catch: Throwable -> L11 RemoteException -> L13
        goto L6
    L20:
        service.cancelNotificationWithTag(packageName, PackageManagerService.PLATFORM_PACKAGE_NAME, id.mTag, NotificationId.m924$$Nest$fgetmId(id), UserHandle.of(UserAccounts.m933$$Nest$fgetuserId(accounts)).getIdentifier());     // Catch: Throwable -> L7 RemoteException -> L9
    L7:
        th = move-exception;
        Throwable r11 = th;
    L15:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
        throw r11;
    L11:
        th = move-exception;
        r11 = th;
    L6:
        IAccountManager.Stub.restoreCallingIdentity(identityToken);
    }

    private boolean isPermittedForPackage(String packageName, int userId, String... permissions) {
        long identity = Binder.clearCallingIdentity();
        int uid = this.mPackageManager.getPackageUidAsUser(packageName, userId);     // Catch: Throwable -> L12 Throwable -> L14
        IPackageManager pm = ActivityThread.getPackageManager();     // Catch: Throwable -> L12 Throwable -> L14
        int r5 = permissions.length;     // Catch: Throwable -> L12 Throwable -> L14
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L20;
        String perm = permissions[r6];     // Catch: Throwable -> L12 Throwable -> L14
        if (pm.checkPermission(perm, packageName, userId) != 0) goto L18;
        int opCode = AppOpsManager.permissionToOpCode(perm);     // Catch: Throwable -> L12 Throwable -> L14
        if (opCode == (-1)) goto L16;
        if (this.mAppOpsManager.checkOpNoThrow(opCode, uid, packageName) != 0) goto L18;
    L16:
        Binder.restoreCallingIdentity(identity);
        return true;
    L18:
        r6 = r6 + 1;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L20:
        Binder.restoreCallingIdentity(identity);
        return false;
    }

    private boolean checkPermissionAndNote(String opPackageName, int callingUid, String... permissions) {
        int r0 = permissions.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L16;
        String perm = permissions[r2];
        if (this.mContext.checkCallingOrSelfPermission(perm) != 0) goto L15;
        if (Log.isLoggable(TAG, 2) == false) goto L9;
        Log.v(TAG, "  caller uid " + callingUid + " has " + perm);
    L9:
        int opCode = AppOpsManager.permissionToOpCode(perm);
        if (opCode == (-1)) goto L13;
        if (this.mAppOpsManager.noteOpNoThrow(opCode, callingUid, opPackageName) != 0) goto L15;
        return true;
    L13:
        return true;
    L15:
        r2 = r2 + 1;
        goto L3
    L16:
        return false;
    }

    private int handleIncomingUser(int userId) {
        return ActivityManager.getService().handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, true, "", null);
    L15:
        return userId;
    L10:
        return userId;
    }

    private boolean isPrivileged(int callingUid) {
        long identityToken = Binder.clearCallingIdentity();
        String[] packages = this.mPackageManager.getPackagesForUid(callingUid);     // Catch: Throwable -> L9
        if (packages != null) goto L11;
        Log.d(TAG, "No packages for callingUid " + callingUid);     // Catch: Throwable -> L9
        Binder.restoreCallingIdentity(identityToken);
        return false;
    L11:
        int r5 = packages.length;     // Catch: Throwable -> L9
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L27;
        String name = packages[r6];     // Catch: Throwable -> L9
        PackageInfo packageInfo = this.mPackageManager.getPackageInfo(name, 0);     // Catch: Throwable -> L9 PackageManager.NameNotFoundException -> L21
        if (packageInfo == null) goto L26;
    L18:
        if ((packageInfo.applicationInfo.privateFlags & 8) == 0) goto L26;
        Binder.restoreCallingIdentity(identityToken);
        return true;
    L26:
        r6 = r6 + 1;
    L21:
        e = move-exception;
        Log.w(TAG, "isPrivileged#Package not found " + e.getMessage());     // Catch: Throwable -> L9
        goto L26
    L27:
        Binder.restoreCallingIdentity(identityToken);
        return false;
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    }

    private boolean permissionIsGranted(Account account, String authTokenType, int callerUid, int userId) {
        if (UserHandle.getAppId(callerUid) != 1000) goto L9;
        if (Log.isLoggable(TAG, 2) == false) goto L7;
        Log.v(TAG, "Access to " + account + " granted calling uid is system");
    L7:
        return true;
    L9:
        if (isPrivileged(callerUid) == true) goto L11;
        if (account != null) goto L16;
    L21:
        if (account == null) goto L29;
        if (hasExplicitlyGrantedPermission(account, authTokenType, callerUid) == false) goto L29;
        if (Log.isLoggable(TAG, 2) == false) goto L27;
        Log.v(TAG, "Access to " + account + " granted calling uid " + callerUid + " user granted access");
    L27:
        return true;
    L29:
        if (Log.isLoggable(TAG, 2) == false) goto L33;
        Log.v(TAG, "Access to " + account + " not granted for uid " + callerUid);
        return false;
    L33:
        return false;
    L16:
        if (isAccountManagedByCaller(account.type, callerUid, userId) == false) goto L21;
        if (Log.isLoggable(TAG, 2) == false) goto L20;
        Log.v(TAG, "Access to " + account + " granted calling uid " + callerUid + " manages the account");
    L20:
        return true;
    L11:
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        Log.v(TAG, "Access to " + account + " granted calling uid " + callerUid + " privileged");
    L13:
        return true;
    }

    private boolean isAccountVisibleToCaller(String accountType, int callingUid, int userId, String opPackageName) {
        if (accountType != null) goto L6;
        return false;
    L6:
        return getTypesVisibleToCaller(callingUid, userId, opPackageName).contains(accountType);
    }

    private boolean checkGetAccountsPermission(String packageName, int userId) {
        return isPermittedForPackage(packageName, userId, new String[]{"android.permission.GET_ACCOUNTS", "android.permission.GET_ACCOUNTS_PRIVILEGED"});
    }

    private boolean checkReadContactsPermission(String packageName, int userId) {
        return isPermittedForPackage(packageName, userId, new String[]{"android.permission.READ_CONTACTS"});
    }

    private boolean accountTypeManagesContacts(String accountType, int userId) {
        if (accountType != null) goto L5;
        return false;
    L5:
        long identityToken = Binder.clearCallingIdentity();
        Collection<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> serviceInfos = this.mAuthenticatorCache.getAllServices(userId);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(identityToken);
        Iterator<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> r4 = serviceInfos.iterator();
    L9:
        if (r4.hasNext() == false) goto L15;
        RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> serviceInfo = r4.next();
        if (accountType.equals(((AuthenticatorDescription) serviceInfo.type).type) == false) goto L9;
        return isPermittedForPackage(((AuthenticatorDescription) serviceInfo.type).packageName, userId, new String[]{"android.permission.WRITE_CONTACTS"});
    L15:
        return false;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    }

    private int checkPackageSignature(String accountType, int callingUid, int userId) {
        if (accountType != null) goto L5;
        return 0;
    L5:
        long identityToken = Binder.clearCallingIdentity();
        Collection<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> serviceInfos = this.mAuthenticatorCache.getAllServices(userId);     // Catch: Throwable -> L22
        Binder.restoreCallingIdentity(identityToken);
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        Iterator<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> r5 = serviceInfos.iterator();
    L9:
        if (r5.hasNext() == false) goto L21;
        RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> serviceInfo = r5.next();
        if (accountType.equals(((AuthenticatorDescription) serviceInfo.type).type) == false) goto L9;
        if (serviceInfo.uid == callingUid) goto L14;
        if (pmi.hasSignatureCapability(serviceInfo.uid, callingUid, 16) == false) goto L9;
        return 1;
    L14:
        return 2;
    L21:
        return 0;
    L22:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    }

    private boolean isAccountManagedByCaller(String accountType, int callingUid, int userId) {
        if (accountType != null) goto L6;
        return false;
    L6:
        return getTypesManagedByCaller(callingUid, userId).contains(accountType);
    }

    private List<String> getTypesVisibleToCaller(int callingUid, int userId, String opPackageName) {
        return getTypesForCaller(callingUid, userId, true);
    }

    private List<String> getTypesManagedByCaller(int callingUid, int userId) {
        return getTypesForCaller(callingUid, userId, false);
    }

    private List<String> getTypesForCaller(int callingUid, int userId, boolean isOtherwisePermitted) {
        List<String> managedAccountTypes = new ArrayList();
        long identityToken = Binder.clearCallingIdentity();
        Collection<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> serviceInfos = this.mAuthenticatorCache.getAllServices(userId);     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(identityToken);
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        Iterator<RegisteredServicesCache.ServiceInfo<AuthenticatorDescription>> r5 = serviceInfos.iterator();
    L6:
        if (r5.hasNext() == false) goto L13;
        RegisteredServicesCache.ServiceInfo<AuthenticatorDescription> serviceInfo = r5.next();
        if (isOtherwisePermitted == true) goto L11;
        if (pmi.hasSignatureCapability(serviceInfo.uid, callingUid, 16) == false) goto L6;
    L11:
        managedAccountTypes.add(((AuthenticatorDescription) serviceInfo.type).type);
        goto L6
    L13:
        return managedAccountTypes;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(identityToken);
        throw th;
    }

    private boolean isAccountPresentForCaller(String accountName, String accountType) {
        if (getUserAccountsForCaller().accountCache.containsKey(accountType) == false) goto L12;
        Account[] r0 = getUserAccountsForCaller().accountCache.get(accountType);
        int r2 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        Account account = r0[r3];
        if (account.name.equals(accountName) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private static void checkManageUsersPermission(String message) {
        if (ActivityManager.checkComponentPermission("android.permission.MANAGE_USERS", Binder.getCallingUid(), -1, true) != 0) goto L6;
        return;
    L6:
        throw new SecurityException("You need MANAGE_USERS permission to: " + message);
    }

    private static void checkManageOrCreateUsersPermission(String message) {
        if (ActivityManager.checkComponentPermission("android.permission.MANAGE_USERS", Binder.getCallingUid(), -1, true) != 0) goto L5;
        return;
    L5:
        if (ActivityManager.checkComponentPermission("android.permission.CREATE_USERS", Binder.getCallingUid(), -1, true) != 0) goto L8;
        return;
    L8:
        throw new SecurityException("You need MANAGE_USERS or CREATE_USERS permission to: " + message);
    }

    private boolean hasExplicitlyGrantedPermission(Account account, String authTokenType, int callerUid) {
        if (UserHandle.getAppId(callerUid) != 1000) goto L5;
        return true;
    L5:
        UserAccounts accounts = getUserAccounts(UserHandle.getUserId(callerUid));
        Object r1 = accounts.dbLock;
        monitor-enter(r1);
        Object r3 = accounts.cacheLock;     // Catch: Throwable -> L25
        monitor-enter(r3);     // Catch: Throwable -> L25
        if (authTokenType == null) goto L13;
        long grantsCount = accounts.accountsDb.findMatchingGrantsCount(callerUid, authTokenType, account);     // Catch: Throwable -> L11
    L15:
        if (grantsCount <= 0) goto L17;
        boolean permissionGranted = true;
    L18:
        if (permissionGranted == false) goto L20;
    L27:
        monitor-exit(r3);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L25
        return permissionGranted;
    L20:
        if (ActivityManager.isRunningInTestHarness() == false) goto L27;
        Log.d(TAG, "no credentials permission for usage of " + account.toSafeString() + ", " + authTokenType + " by uid " + callerUid + " but ignoring since device is in test harness.");     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L25
        return true;
    L17:
        permissionGranted = false;
        goto L18
    L13:
        grantsCount = accounts.accountsDb.findMatchingGrantsCountAnyToken(callerUid, account);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private boolean isSystemUid(int callingUid) {
        if (Process.isSdkSandboxUid(callingUid) == false) goto L5;
        return false;
    L5:
        long ident = Binder.clearCallingIdentity();
        String[] packages = this.mPackageManager.getPackagesForUid(callingUid);     // Catch: Throwable -> L19
        if (packages == null) goto L27;
        int r5 = packages.length;     // Catch: Throwable -> L19
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L28;
        String name = packages[r6];     // Catch: Throwable -> L19
        PackageInfo packageInfo = this.mPackageManager.getPackageInfo(name, 0);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        if (packageInfo == null) goto L26;
    L16:
        if ((packageInfo.applicationInfo.flags & 1) == 0) goto L26;
        Binder.restoreCallingIdentity(ident);
        return true;
    L26:
        r6 = r6 + 1;     // Catch: Throwable -> L19
    L21:
        e = move-exception;
        Log.w(TAG, String.format("Could not find package [%s]", new Object[]{name}), e);     // Catch: Throwable -> L19
    L28:
        Binder.restoreCallingIdentity(ident);
        return false;
    L27:
        Log.w(TAG, "No known packages with uid " + callingUid);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void checkReadAccountsPermitted(int callingUid, String accountType, int userId, String opPackageName) {
        if (isAccountVisibleToCaller(accountType, callingUid, userId, opPackageName) == false) goto L5;
        return;
    L5:
        String msg = String.format("caller uid %s cannot access %s accounts", new Object[]{Integer.valueOf(callingUid), accountType});
        Log.w(TAG, "  " + msg);
        throw new SecurityException(msg);
    }

    private boolean canUserModifyAccounts(int userId, int callingUid) {
        if (isProfileOwner(callingUid) == false) goto L6;
        return true;
    L6:
        if (getUserManager().getUserRestrictions(new UserHandle(userId)).getBoolean("no_modify_accounts") == false) goto L9;
        return false;
    L9:
        return true;
    }

    private boolean canUserModifyAccountsForType(final int userId, final String accountType, final int callingUid) {
        return ((Boolean) Binder.withCleanCallingIdentity(new AccountManagerService$$ExternalSyntheticLambda4(this, callingUid, userId, accountType))).booleanValue();
    }

    private /* synthetic */ Boolean lambda$canUserModifyAccountsForType$3(int callingUid, int userId, String accountType) throws Exception {
        if (isProfileOwner(callingUid) == false) goto L5;
        return true;
    L5:
        DevicePolicyManager dpm = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        String[] typesArray = dpm.getAccountTypesWithManagementDisabledAsUser(userId);
        if (typesArray != null) goto L8;
        return true;
    L8:
        int r3 = typesArray.length;
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L15;
        String forbiddenType = typesArray[r5];
        if (forbiddenType.equals(accountType) == true) goto L13;
        r5 = r5 + 1;
        goto L9
    L13:
        return false;
    L15:
        return true;
    }

    private boolean isProfileOwner(int uid) {
        DevicePolicyManagerInternal dpmi = (DevicePolicyManagerInternal) LocalServices.getService(DevicePolicyManagerInternal.class);
        if (dpmi != null) goto L5;
    L9:
        return false;
    L5:
        if (dpmi.isActiveProfileOwner(uid) == false) goto L7;
    L8:
        return true;
    L7:
        if (dpmi.isActiveDeviceOwner(uid) == false) goto L9;
        goto L8
    }

    private boolean canCallerAccessPackage(String targetPkgName, int callingUid, int userId) {
        PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (CompatChanges.isChangeEnabled(ENFORCE_PACKAGE_VISIBILITY_FILTERING, callingUid) == false) goto L5;
        boolean canAccess = !pmInternal.filterAppAccess(targetPkgName, callingUid, userId);
        if (canAccess == false) goto L12;
    L14:
        return canAccess;
    L12:
        if (Log.isLoggable(TAG, 3) == false) goto L14;
        Log.d(TAG, "Package " + targetPkgName + " is not visible to caller " + callingUid + " for user " + userId);
        goto L14
    L5:
        if (pmInternal.getPackageUid(targetPkgName, 0, userId) != (-1)) goto L15;
        return false;
    L15:
        return true;
    }

    public void updateAppPermission(Account account, String authTokenType, int uid, boolean value) throws RemoteException {
        int callingUid = IAccountManager.Stub.getCallingUid();
        if (UserHandle.getAppId(callingUid) != 1000) goto L9;
        if (value == false) goto L6;
        grantAppPermission(account, authTokenType, uid);
        return;
    L6:
        revokeAppPermission(account, authTokenType, uid);
        return;
    L9:
        throw new SecurityException();
    }

    void grantAppPermission(final Account account, String authTokenType, final int uid) {
        if (account == null) goto L28;
        if (authTokenType == null) goto L28;
        UserAccounts accounts = getUserAccounts(UserHandle.getUserId(uid));
        Object r1 = accounts.dbLock;
        monitor-enter(r1);
        Object r2 = accounts.cacheLock;     // Catch: Throwable -> L22
        monitor-enter(r2);     // Catch: Throwable -> L22
        long accountId = accounts.accountsDb.findDeAccountId(account);     // Catch: Throwable -> L12
        if (accountId < 0) goto L14;
        accounts.accountsDb.insertGrant(accountId, authTokenType, uid);     // Catch: Throwable -> L12
    L14:
        cancelNotification(getCredentialPermissionNotificationId(account, authTokenType, uid, accounts), accounts);     // Catch: Throwable -> L12
        cancelAccountAccessRequestNotificationIfNeeded(account, uid, true, accounts);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L22
        Iterator<AccountManagerInternal.OnAppPermissionChangeListener> r3 = this.mAppPermissionChangeListeners.iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        final AccountManagerInternal.OnAppPermissionChangeListener listener = r3.next();
        this.mHandler.post(new AccountManagerService$$ExternalSyntheticLambda1(listener, account, uid));
        goto L19
    L21:
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L28:
        Log.e(TAG, "grantAppPermission: called with invalid arguments", new Exception());
    }

    private static /* synthetic */ void lambda$grantAppPermission$4(AccountManagerInternal.OnAppPermissionChangeListener listener, Account account, int uid) {
        listener.onAppPermissionChanged(account, uid);
    }

    private void revokeAppPermission(final Account account, String authTokenType, final int uid) {
        if (account == null) goto L44;
        if (authTokenType == null) goto L44;
        UserAccounts accounts = getUserAccounts(UserHandle.getUserId(uid));
        Object r2 = accounts.dbLock;
        monitor-enter(r2);
        Object r3 = accounts.cacheLock;     // Catch: Throwable -> L39
        monitor-enter(r3);     // Catch: Throwable -> L39
        accounts.accountsDb.beginTransaction();     // Catch: Throwable -> L35
        long accountId = accounts.accountsDb.findDeAccountId(account);     // Catch: Throwable -> L18
        if (accountId < 0) goto L20;
        String authTokenType2 = authTokenType;
        accounts.accountsDb.deleteGrantsByAccountIdAuthTokenTypeAndUid(accountId, authTokenType2, uid);     // Catch: Throwable -> L16
        accounts.accountsDb.setTransactionSuccessful();     // Catch: Throwable -> L16
    L21:
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L31
        cancelNotification(getCredentialPermissionNotificationId(account, authTokenType2, uid, accounts), accounts);     // Catch: Throwable -> L31
        monitor-exit(r3);     // Catch: Throwable -> L31
        monitor-exit(r2);     // Catch: Throwable -> L29
        Iterator<AccountManagerInternal.OnAppPermissionChangeListener> r14 = this.mAppPermissionChangeListeners.iterator();
    L26:
        if (r14.hasNext() == false) goto L28;
        final AccountManagerInternal.OnAppPermissionChangeListener listener = r14.next();
        this.mHandler.post(new AccountManagerService$$ExternalSyntheticLambda2(listener, account, uid));
        goto L26
    L28:
        return;
    L16:
        th = move-exception;
        Throwable r15 = th;
    L33:
        accounts.accountsDb.endTransaction();     // Catch: Throwable -> L31
        throw r15;     // Catch: Throwable -> L31
    L20:
        authTokenType2 = authTokenType;
    L18:
        th = move-exception;
        r15 = th;
    L35:
        th = move-exception;
        Throwable r16 = th;
    L37:
        monitor-exit(r3);     // Catch: Throwable -> L31
        throw r16;     // Catch: Throwable -> L29
    L31:
        th = move-exception;
        r16 = th;
    L29:
        th = move-exception;
        Throwable r17 = th;
    L41:
        monitor-exit(r2);     // Catch: Throwable -> L29
        throw r17;
    L39:
        th = move-exception;
        r17 = th;
    L44:
        Log.e(TAG, "revokeAppPermission: called with invalid arguments", new Exception());
    }

    private static /* synthetic */ void lambda$revokeAppPermission$5(AccountManagerInternal.OnAppPermissionChangeListener listener, Account account, int uid) {
        listener.onAppPermissionChanged(account, uid);
    }

    private void removeAccountFromCacheLocked(UserAccounts accounts, Account account) {
        Account[] oldAccountsForType = accounts.accountCache.get(account.type);
        if (oldAccountsForType == null) goto L14;
        ArrayList<Account> newAccountsList = new ArrayList();
        int r2 = oldAccountsForType.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        Account curAccount = oldAccountsForType[r3];
        if (curAccount.equals(account) == true) goto L9;
        newAccountsList.add(curAccount);
    L9:
        r3 = r3 + 1;
        goto L5
    L11:
        if (newAccountsList.isEmpty() == false) goto L13;
        accounts.accountCache.remove(account.type);
        goto L14
    L13:
        Account[] newAccountsForType = new Account[newAccountsList.size()];
        Account[] newAccountsForType2 = (Account[]) newAccountsList.toArray(newAccountsForType);
        accounts.accountCache.put(account.type, newAccountsForType2);
    L14:
        UserAccounts.m932$$Nest$fgetuserDataCache(accounts).remove(account);
        UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).remove(account);
        UserAccounts.m930$$Nest$fgetpreviousNameCache(accounts).remove(account);
        UserAccounts.m934$$Nest$fgetvisibilityCache(accounts).remove(account);
        UserAccounts.m928$$Nest$fgetmCacheSizeForAccount(accounts).remove(account);
        AccountManager.invalidateLocalAccountsDataCaches();
    }

    private Account insertAccountIntoCacheLocked(UserAccounts accounts, Account account) {
        Account[] accountsForType = accounts.accountCache.get(account.type);
        if (accountsForType == null) goto L5;
        int oldLength = accountsForType.length;
    L6:
        Account[] newAccountsForType = new Account[oldLength + 1];
        if (accountsForType == null) goto L10;
        System.arraycopy(accountsForType, 0, newAccountsForType, 0, oldLength);
    L10:
        if (account.getAccessId() == null) goto L12;
        String token = account.getAccessId();
    L13:
        newAccountsForType[oldLength] = new Account(account, token);
        accounts.accountCache.put(account.type, newAccountsForType);
        AccountManager.invalidateLocalAccountsDataCaches();
        return newAccountsForType[oldLength];
    L12:
        token = UUID.randomUUID().toString();
        goto L13
    L5:
        oldLength = 0;
        goto L6
    }

    private Account[] filterAccounts(UserAccounts accounts, Account[] unfiltered, int callingUid, String callingPackage, boolean includeManagedNotVisible) {
        String visibilityFilterPackage = callingPackage;
        if (visibilityFilterPackage != null) goto L5;
        visibilityFilterPackage = getPackageNameForUid(callingUid);
    L5:
        Map<Account, Integer> firstPass = new LinkedHashMap();
        int r2 = unfiltered.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L16;
        Account account = unfiltered[r3];
        int visibility = resolveAccountVisibility(account, visibilityFilterPackage, callingUid, accounts).intValue();
        if (visibility != 1) goto L10;
    L14:
        firstPass.put(account, Integer.valueOf(visibility));
    L15:
        r3 = r3 + 1;
        goto L6
    L10:
        if (visibility == 2) goto L14;
        if (includeManagedNotVisible == false) goto L15;
        if (visibility != 4) goto L15;
    L16:
        Map<Account, Integer> secondPass = filterSharedAccounts(accounts, firstPass, callingUid, callingPackage);
        Account[] filtered = new Account[secondPass.size()];
        return (Account[]) secondPass.keySet().toArray(filtered);
    }

    private Map<Account, Integer> filterSharedAccounts(UserAccounts userAccounts, Map<Account, Integer> unfiltered, int callingUid, String callingPackage) {
        if (getUserManager() == null) goto L66;
        if (userAccounts == null) goto L66;
        if (UserAccounts.m933$$Nest$fgetuserId(userAccounts) < 0) goto L66;
        if (callingUid == 1000) goto L66;
        UserInfo user = getUserManager().getUserInfo(UserAccounts.m933$$Nest$fgetuserId(userAccounts));
        if (user != null) goto L13;
    L65:
        return unfiltered;
    L13:
        if (user.isRestricted() == false) goto L65;
        String[] packages = this.mPackageManager.getPackagesForUid(callingUid);
        int r5 = 0;
        if (packages != null) goto L17;
        String[] packages2 = new String[0];
    L18:
        String visibleList = this.mContext.getResources().getString(R.string.config_defaultContextualSearchPackageName);
        int r0 = packages2.length;
        int r8 = 0;
    L19:
        if (r8 >= r0) goto L24;
        String packageName = packages2[r8];
        if (visibleList.contains(";" + packageName + ";") == true) goto L22;
        r8 = r8 + 1;
        goto L19
    L22:
        return unfiltered;
    L24:
        Account[] sharedAccounts = getSharedAccountsAsUser(UserAccounts.m933$$Nest$fgetuserId(userAccounts));
        if (ArrayUtils.isEmpty(sharedAccounts) == false) goto L27;
        return unfiltered;
    L27:
        String requiredAccountType = "";
        if (callingPackage == null) goto L37;
        PackageInfo pi = this.mPackageManager.getPackageInfo(callingPackage, 0);     // Catch: PackageManager.NameNotFoundException -> L34
        if (pi == null) goto L48;
        if (pi.restrictedAccountType == null) goto L48;
        requiredAccountType = pi.restrictedAccountType;     // Catch: PackageManager.NameNotFoundException -> L34
    L48:
        Map<Account, Integer> filtered = new LinkedHashMap();
        Iterator<Map.Entry<Account, Integer>> r10 = unfiltered.entrySet().iterator();
    L50:
        if (r10.hasNext() == false) goto L64;
        Map.Entry<Account, Integer> entry = r10.next();
        Account account = entry.getKey();
        if (account.type.equals(requiredAccountType) == false) goto L54;
        filtered.put(account, entry.getValue());
    L63:
        r5 = 0;
        goto L50
    L54:
        boolean found = false;
        int r14 = sharedAccounts.length;
        int r15 = r5;
    L56:
        if (r15 >= r14) goto L61;
        Account shared = sharedAccounts[r15];
        if (shared.equals(account) == true) goto L59;
        r15 = r15 + 1;
        goto L56
    L59:
        found = true;
    L61:
        if (found == true) goto L63;
        filtered.put(account, entry.getValue());
        goto L63
    L64:
        return filtered;
    L37:
        int r1 = packages2.length;     // Catch: PackageManager.NameNotFoundException -> L34
        int r11 = 0;
    L38:
        if (r11 >= r1) goto L48;
        String packageName2 = packages2[r11];     // Catch: PackageManager.NameNotFoundException -> L34
        PackageInfo pi2 = this.mPackageManager.getPackageInfo(packageName2, 0);     // Catch: PackageManager.NameNotFoundException -> L34
        if (pi2 == null) goto L45;
        if (pi2.restrictedAccountType == null) goto L45;
        requiredAccountType = pi2.restrictedAccountType;     // Catch: PackageManager.NameNotFoundException -> L34
    L45:
        r11 = r11 + 1;
    L34:
        e = move-exception;
        Log.w(TAG, "filterSharedAccounts#Package not found " + e.getMessage());
        goto L48
    L17:
        packages2 = packages;
    L66:
        return unfiltered;
    }

    protected Account[] getAccountsFromCache(UserAccounts userAccounts, String accountType, int callingUid, String callingPackage, boolean includeManagedNotVisible) {
        Preconditions.checkState(!Thread.holdsLock(userAccounts.cacheLock), "Method should not be called with cacheLock");
        if (accountType == null) goto L19;
        Object r1 = userAccounts.cacheLock;
        monitor-enter(r1);
        Account[] accounts = userAccounts.accountCache.get(accountType);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        if (accounts != null) goto L12;
        return EMPTY_ACCOUNT_ARRAY;
    L12:
        return filterAccounts(userAccounts, (Account[]) Arrays.copyOf(accounts, accounts.length), callingUid, callingPackage, includeManagedNotVisible);
    L13:
        th = th;
    L43:
        throw th;
    L17:
        th = th;
        goto L43
    L19:
        int totalLength = 0;
        Object r11 = userAccounts.cacheLock;
        monitor-enter(r11);
        Iterator<Account[]> r12 = userAccounts.accountCache.values().iterator();     // Catch: Throwable -> L25
    L23:
        if (r12.hasNext() == false) goto L27;
        totalLength = totalLength + r12.next().length;     // Catch: Throwable -> L25
        goto L23
    L27:
        if (totalLength != 0) goto L31;
        Account[] r13 = EMPTY_ACCOUNT_ARRAY;     // Catch: Throwable -> L25
        monitor-exit(r11);     // Catch: Throwable -> L25
        return r13;
    L31:
        Account[] accountsArray = new Account[totalLength];     // Catch: Throwable -> L25
        int totalLength2 = 0;
        Iterator<Account[]> r14 = userAccounts.accountCache.values().iterator();     // Catch: Throwable -> L25
    L33:
        if (r14.hasNext() == false) goto L35;
        Account[] accountsOfType = r14.next();     // Catch: Throwable -> L25
        System.arraycopy(accountsOfType, 0, accountsArray, totalLength2, accountsOfType.length);     // Catch: Throwable -> L25
        totalLength2 = totalLength2 + accountsOfType.length;     // Catch: Throwable -> L25
        goto L33
    L35:
        monitor-exit(r11);     // Catch: Throwable -> L25
        return filterAccounts(userAccounts, accountsArray, callingUid, callingPackage, includeManagedNotVisible);
    L25:
        th = move-exception;
        throw th;
    }

    protected void writeUserDataIntoCacheLocked(UserAccounts accounts, Account account, String key, String value) {
        Map<String, String> userDataForAccount = (Map) UserAccounts.m932$$Nest$fgetuserDataCache(accounts).get(account);
        boolean updateCacheSize = false;
        if (userDataForAccount != null) goto L5;
        userDataForAccount = accounts.accountsDb.findUserExtrasForAccount(account);
        UserAccounts.m932$$Nest$fgetuserDataCache(accounts).put(account, userDataForAccount);
        updateCacheSize = true;
    L5:
        if (value != null) goto L7;
        userDataForAccount.remove(key);
    L8:
        if (updateCacheSize == false) goto L11;
        recomputeCacheSizeForAccountLocked(accounts, account);
        return;
    L11:
        return;
    L7:
        userDataForAccount.put(key, value);
        goto L8
    }

    protected TokenCache.Value readCachedTokenInternal(UserAccounts accounts, Account account, String tokenType, String callingPackage, byte[] pkgSigDigest) {
        Object r0 = accounts.cacheLock;
        monitor-enter(r0);
        TokenCache.Value r1 = UserAccounts.m925$$Nest$fgetaccountTokenCaches(accounts).get(account, tokenType, callingPackage, pkgSigDigest);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected void writeAuthTokenIntoCacheLocked(UserAccounts accounts, Account account, String key, String value) {
        Map<String, String> authTokensForAccount = (Map) UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).get(account);
        boolean updateCacheSize = false;
        if (authTokensForAccount != null) goto L5;
        authTokensForAccount = accounts.accountsDb.findAuthTokensByAccount(account);
        UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).put(account, authTokensForAccount);
        updateCacheSize = true;
    L5:
        if (value != null) goto L7;
        authTokensForAccount.remove(key);
    L8:
        if (updateCacheSize == false) goto L11;
        recomputeCacheSizeForAccountLocked(accounts, account);
        return;
    L11:
        return;
    L7:
        authTokensForAccount.put(key, value);
        goto L8
    }

    protected String readAuthTokenInternal(UserAccounts accounts, Account account, String authTokenType) {
        Object r0 = accounts.cacheLock;
        monitor-enter(r0);
        Map<String, String> authTokensForAccount = (Map) UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).get(account);     // Catch: Throwable -> L9
        if (authTokensForAccount == null) goto L12;
        String r2 = authTokensForAccount.get(authTokenType);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        Object r1 = accounts.dbLock;
        monitor-enter(r1);
        Object r3 = accounts.cacheLock;     // Catch: Throwable -> L26
        monitor-enter(r3);     // Catch: Throwable -> L26
        Map<String, String> authTokensForAccount2 = (Map) UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).get(account);     // Catch: Throwable -> L20
        if (authTokensForAccount2 != null) goto L22;
        authTokensForAccount2 = accounts.accountsDb.findAuthTokensByAccount(account);     // Catch: Throwable -> L20
        UserAccounts.m926$$Nest$fgetauthTokenCache(accounts).put(account, authTokensForAccount2);     // Catch: Throwable -> L20
        recomputeCacheSizeForAccountLocked(accounts, account);     // Catch: Throwable -> L20
    L22:
        String r4 = authTokensForAccount2.get(authTokenType);     // Catch: Throwable -> L20
        monitor-exit(r3);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L26
        return r4;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    }

    private String readUserDataInternal(UserAccounts accounts, Account account, String key) {
        Object r0 = accounts.cacheLock;
        monitor-enter(r0);
        Map<String, String> userDataForAccount = (Map) UserAccounts.m932$$Nest$fgetuserDataCache(accounts).get(account);     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        if (userDataForAccount != null) goto L26;
        Object r1 = accounts.dbLock;
        monitor-enter(r1);
        Object r2 = accounts.cacheLock;     // Catch: Throwable -> L19
        monitor-enter(r2);     // Catch: Throwable -> L19
        userDataForAccount = (Map) UserAccounts.m932$$Nest$fgetuserDataCache(accounts).get(account);     // Catch: Throwable -> L14
        if (userDataForAccount != null) goto L16;
        userDataForAccount = accounts.accountsDb.findUserExtrasForAccount(account);     // Catch: Throwable -> L14
        UserAccounts.m932$$Nest$fgetuserDataCache(accounts).put(account, userDataForAccount);     // Catch: Throwable -> L14
        recomputeCacheSizeForAccountLocked(accounts, account);     // Catch: Throwable -> L14
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L19
        goto L26
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L26:
        return userDataForAccount.get(key);
    L27:
        th = move-exception;
        throw th;
    }

    private Context getContextForUser(UserHandle user) {
        return this.mContext.createPackageContextAsUser(this.mContext.getPackageName(), 0, user);
    L6:
        return this.mContext;
    }

    private void sendResponse(IAccountManagerResponse response, Bundle result) {
        response.onResult(result);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L11;
        Log.v(TAG, "failure while notifying response", e);
        return;
    }

    private void sendErrorResponse(IAccountManagerResponse response, int errorCode, String errorMessage) {
        response.onError(errorCode, errorMessage);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L11;
        Log.v(TAG, "failure while notifying response", e);
        return;
    }

    private boolean isFirstAccountRemovalDisabled(Account account) {
        int userId = UserHandle.getCallingUserId();
        if (userId == 0) goto L6;
        return false;
    L6:
        if (this.mContext.getResources().getBoolean(R.bool.config_carrier_volte_available) == false) goto L9;
        return false;
    L9:
        if (android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "allow_primary_gaia_account_removal_for_tests", 0, 0) == 0) goto L11;
        return false;
    L11:
        String typeToKeep = this.mContext.getResources().getString(R.string.config_defaultContentSuggestionsService);
        if (typeToKeep.isEmpty() == false) goto L14;
    L22:
        return false;
    L14:
        if (typeToKeep.equals(account.type) == false) goto L22;
        UserAccounts accounts = getUserAccounts(0);
        Account[] accountsOfType = getAccountsFromCache(accounts, typeToKeep, 1000, PackageManagerService.PLATFORM_PACKAGE_NAME, false);
        if (accountsOfType.length > 0) goto L19;
        return false;
    L19:
        if (accountsOfType[0].equals(account) == false) goto L24;
        return true;
    L24:
        return false;
    }

    private Integer resolveAccountVisibility(Account account, String packageName, int callingUid, UserAccounts accounts) {
        packageName.getClass();
        int uid = callingUid;
        long token = IAccountManager.Stub.clearCallingIdentity();
        String[] callingPkgs = this.mPackageManager.getPackagesForUid(callingUid);     // Catch: Throwable -> L10
        if (callingPkgs != null) goto L6;
    L13:
        boolean isCalledFromXtsApp = false;
    L14:
        IAccountManager.Stub.restoreCallingIdentity(token);
        if (uid == (-1)) goto L69;
        if (isCalledFromXtsApp == true) goto L69;
    L22:
        if (UserHandle.isSameApp(uid, 1000) == true) goto L24;
        int signatureCheckResult = checkPackageSignature(account.type, uid, UserAccounts.m933$$Nest$fgetuserId(accounts));
        if (signatureCheckResult == 2) goto L28;
        int visibility = getAccountVisibilityFromCache(account, packageName, accounts);
        if (visibility != 0) goto L32;
        boolean isPrivileged = isPermittedForPackage(packageName, UserHandle.getUserId(uid), new String[]{"android.permission.GET_ACCOUNTS_PRIVILEGED"});
        if (isProfileOwner(uid) == true) goto L36;
        boolean preO = isPreOApplication(packageName);
        if (signatureCheckResult != 0) goto L51;
        if (preO == false) goto L43;
        if (checkGetAccountsPermission(packageName, UserHandle.getUserId(uid)) == true) goto L51;
    L43:
        if (checkReadContactsPermission(packageName, UserHandle.getUserId(uid)) == true) goto L45;
    L46:
        if (isPrivileged == true) goto L51;
        int visibility2 = getAccountVisibilityFromCache(account, "android:accounts:key_legacy_not_visible", accounts);
        if (visibility2 != 0) goto L55;
        visibility2 = 4;
    L55:
        return Integer.valueOf(visibility2);
    L45:
        if (accountTypeManagesContacts(account.type, UserAccounts.m933$$Nest$fgetuserId(accounts)) == false) goto L46;
    L51:
        visibility2 = getAccountVisibilityFromCache(account, "android:accounts:key_legacy_visible", accounts);
        if (visibility2 != 0) goto L55;
        visibility2 = 2;
        goto L55
    L36:
        return 1;
    L32:
        return Integer.valueOf(visibility);
    L28:
        return 1;
    L24:
        return 1;
    L69:
        long identityToken = IAccountManager.Stub.clearCallingIdentity();     // Catch: PackageManager.NameNotFoundException -> L56
        uid = this.mPackageManager.getPackageUidAsUser(packageName, UserAccounts.m933$$Nest$fgetuserId(accounts));     // Catch: Throwable -> L58
        IAccountManager.Stub.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L56
        goto L22
    L58:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(identityToken);     // Catch: PackageManager.NameNotFoundException -> L56
        throw th;     // Catch: PackageManager.NameNotFoundException -> L56
    L56:
        e = move-exception;
        Log.w(TAG, "resolveAccountVisibility#Package not found " + e.getMessage());
        return 3;
    L6:
        if (Arrays.stream(callingPkgs).anyMatch(new AccountManagerService$$ExternalSyntheticLambda5()) == true) goto L12;
        if (Arrays.stream(callingPkgs).anyMatch(new AccountManagerService$$ExternalSyntheticLambda6()) == false) goto L13;
    L12:
        isCalledFromXtsApp = true;
    L10:
        th = move-exception;
        IAccountManager.Stub.restoreCallingIdentity(token);
        throw th;
    }

    private static /* synthetic */ boolean lambda$resolveAccountVisibility$6(String s) {
        return s.equals("com.android.shell");
    }
}
