package com.android.server.content;

import android.R;
import android.accounts.Account;
import android.accounts.AccountAndUser;
import android.accounts.AccountManager;
import android.app.backup.BackupManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ISyncStatusObserver;
import android.content.PeriodicSync;
import android.content.SyncInfo;
import android.content.SyncRequest;
import android.content.SyncStatusInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.EventLog;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.IntPair;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.pm.PackageManagerService;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class SyncStorageEngine {
    private static final int ACCOUNTS_VERSION = 3;
    private static final String ACCOUNT_INFO_FILE_NAME = "accounts.xml";
    private static final double DEFAULT_FLEX_PERCENT_SYNC = 0.04d;
    private static final long DEFAULT_MIN_FLEX_ALLOWED_SECS = 5;
    private static final long DEFAULT_POLL_FREQUENCY_SECONDS = 86400;
    private static final boolean DELETE_LEGACY_PARCEL_FILES = true;
    public static final int EVENT_START = 0;
    public static final int EVENT_STOP = 1;
    private static final String LEGACY_STATISTICS_FILE_NAME = "stats.bin";
    private static final String LEGACY_STATUS_FILE_NAME = "status.bin";
    public static final int MAX_HISTORY = 100;
    public static final String MESG_CANCELED = "canceled";
    public static final String MESG_SUCCESS = "success";
    static final long MILLIS_IN_4WEEKS = 2419200000L;
    private static final int MSG_WRITE_STATISTICS = 2;
    private static final int MSG_WRITE_STATUS = 1;
    public static final long NOT_IN_BACKOFF_MODE = -1;
    public static final String[] SOURCES = null;
    public static final int SOURCE_FEED = 5;
    public static final int SOURCE_LOCAL = 1;
    public static final int SOURCE_OTHER = 0;
    public static final int SOURCE_PERIODIC = 4;
    public static final int SOURCE_POLL = 2;
    public static final int SOURCE_USER = 3;
    public static final int STATISTICS_FILE_END = 0;
    public static final int STATISTICS_FILE_ITEM = 101;
    public static final int STATISTICS_FILE_ITEM_OLD = 100;
    private static final String STATISTICS_FILE_NAME = "stats";
    public static final int STATUS_FILE_END = 0;
    public static final int STATUS_FILE_ITEM = 100;
    private static final String STATUS_FILE_NAME = "status";
    private static final String SYNC_DIR_NAME = "sync";
    private static final boolean SYNC_ENABLED_DEFAULT = false;
    private static final String TAG = "SyncManager";
    private static final String TAG_FILE = "SyncManagerFile";
    private static final long WRITE_STATISTICS_DELAY = 1800000;
    private static final long WRITE_STATUS_DELAY = 600000;
    private static final String XML_ATTR_ENABLED = "enabled";
    private static final String XML_ATTR_LISTEN_FOR_TICKLES = "listen-for-tickles";
    private static final String XML_ATTR_NEXT_AUTHORITY_ID = "nextAuthorityId";
    private static final String XML_ATTR_SYNC_RANDOM_OFFSET = "offsetInSeconds";
    private static final String XML_ATTR_USER = "user";
    private static final String XML_TAG_LISTEN_FOR_TICKLES = "listenForTickles";
    private static PeriodicSyncAddedListener mPeriodicSyncAddedListener;
    private static HashMap<String, String> sAuthorityRenames;
    private static volatile SyncStorageEngine sSyncStorageEngine;
    private final AtomicFile mAccountInfoFile;
    private final HashMap<AccountAndUser, AccountInfo> mAccounts;
    final SparseArray<AuthorityInfo> mAuthorities;
    private OnAuthorityRemovedListener mAuthorityRemovedListener;
    private final Calendar mCal;
    private final RemoteCallbackList<ISyncStatusObserver> mChangeListeners;
    private final Context mContext;
    private final SparseArray<ArrayList<SyncInfo>> mCurrentSyncs;
    final DayStats[] mDayStats;
    private boolean mDefaultMasterSyncAutomatically;
    private boolean mGrantSyncAdaptersAccountAccess;
    private final MyHandler mHandler;
    private volatile boolean mIsClockValid;
    private volatile boolean mIsJobAttributionFixed;
    private volatile boolean mIsJobNamespaceMigrated;
    private final SyncLogger mLogger;
    private SparseArray<Boolean> mMasterSyncAutomatically;
    private int mNextAuthorityId;
    private int mNextHistoryId;
    private final PackageManagerInternal mPackageManagerInternal;
    private final ArrayMap<ComponentName, SparseArray<AuthorityInfo>> mServices;
    private final AtomicFile mStatisticsFile;
    private final AtomicFile mStatusFile;
    private File mSyncDir;
    private final ArrayList<SyncHistoryItem> mSyncHistory;
    private int mSyncRandomOffset;
    private OnSyncRequestListener mSyncRequestListener;
    final SparseArray<SyncStatusInfo> mSyncStatus;
    private int mYear;
    private int mYearInDays;

    private static class AccountAuthorityValidator {
        private final AccountManager mAccountManager;
        private final SparseArray<Account[]> mAccountsCache;
        private final PackageManager mPackageManager;
        private final SparseArray<ArrayMap<String, Boolean>> mProvidersPerUserCache;

        AccountAuthorityValidator(Context context) {
            this.mAccountManager = (AccountManager) context.getSystemService(AccountManager.class);
            this.mPackageManager = context.getPackageManager();
            this.mAccountsCache = new SparseArray();
            this.mProvidersPerUserCache = new SparseArray();
        }

        boolean isAccountValid(Account account, int userId) {
            Account[] accountsForUser = this.mAccountsCache.get(userId);
            if (accountsForUser != null) goto L6;
            accountsForUser = this.mAccountManager.getAccountsAsUser(userId);
            this.mAccountsCache.put(userId, accountsForUser);
        L6:
            return ArrayUtils.contains(accountsForUser, account);
        }

        boolean isAuthorityValid(String authority, int userId) {
            ArrayMap<String, Boolean> authorityMap = this.mProvidersPerUserCache.get(userId);
            if (authorityMap != null) goto L6;
            authorityMap = new ArrayMap();
            this.mProvidersPerUserCache.put(userId, authorityMap);
        L6:
            if (authorityMap.containsKey(authority) == true) goto L13;
            if (this.mPackageManager.resolveContentProviderAsUser(authority, 786432, userId) == null) goto L10;
            boolean r1 = true;
        L11:
            authorityMap.put(authority, Boolean.valueOf(r1));
            goto L13
        L10:
            r1 = false;
        L13:
            return authorityMap.get(authority).booleanValue();
        }
    }

    static class AccountInfo {
        final AccountAndUser accountAndUser;
        final HashMap<String, AuthorityInfo> authorities;

        AccountInfo(AccountAndUser accountAndUser) {
            this.authorities = new HashMap();
            this.accountAndUser = accountAndUser;
        }
    }

    public static class AuthorityInfo {
        public static final int NOT_INITIALIZED = -1;
        public static final int NOT_SYNCABLE = 0;
        public static final int SYNCABLE = 1;
        public static final int SYNCABLE_NOT_INITIALIZED = 2;
        public static final int SYNCABLE_NO_ACCOUNT_ACCESS = 3;
        public static final int UNDEFINED = -2;
        long backoffDelay;
        long backoffTime;
        long delayUntil;
        boolean enabled;
        final int ident;
        final ArrayList<PeriodicSync> periodicSyncs;
        int syncable;
        final EndPoint target;

        AuthorityInfo(AuthorityInfo toCopy) {
            this.target = toCopy.target;
            this.ident = toCopy.ident;
            this.enabled = toCopy.enabled;
            this.syncable = toCopy.syncable;
            this.backoffTime = toCopy.backoffTime;
            this.backoffDelay = toCopy.backoffDelay;
            this.delayUntil = toCopy.delayUntil;
            this.periodicSyncs = new ArrayList();
            Iterator<PeriodicSync> r0 = toCopy.periodicSyncs.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            PeriodicSync sync = r0.next();
            this.periodicSyncs.add(new PeriodicSync(sync));
            goto L4
        }

        AuthorityInfo(EndPoint info, int id) {
            this.target = info;
            this.ident = id;
            this.enabled = false;
            this.periodicSyncs = new ArrayList();
            defaultInitialisation();
        }

        private void defaultInitialisation() {
            this.syncable = -1;
            this.backoffTime = -1;
            this.backoffDelay = -1;
            if (SyncStorageEngine.m3200$$Nest$sfgetmPeriodicSyncAddedListener() == null) goto L6;
            SyncStorageEngine.m3200$$Nest$sfgetmPeriodicSyncAddedListener().onPeriodicSyncAdded(this.target, new Bundle(), SyncStorageEngine.DEFAULT_POLL_FREQUENCY_SECONDS, SyncStorageEngine.calculateDefaultFlexTime(SyncStorageEngine.DEFAULT_POLL_FREQUENCY_SECONDS));
            return;
        }

        public String toString() {
            return this.target + ", enabled=" + this.enabled + ", syncable=" + this.syncable + ", backoff=" + this.backoffTime + ", delay=" + this.delayUntil;
        }

        public String toSafeString() {
            return this.target.toSafeString() + ", enabled=" + this.enabled + ", syncable=" + this.syncable + ", backoff=" + this.backoffTime + ", delay=" + this.delayUntil;
        }
    }

    public static class DayStats {
        public final int day;
        public int failureCount;
        public long failureTime;
        public int successCount;
        public long successTime;

        public DayStats(int day) {
            this.day = day;
        }
    }

    public static class EndPoint {
        public static final EndPoint USER_ALL_PROVIDER_ALL_ACCOUNTS_ALL = null;
        final Account account;
        final String provider;
        final int userId;

        static {
            USER_ALL_PROVIDER_ALL_ACCOUNTS_ALL = new EndPoint(null, null, -1);
        }

        public EndPoint(Account account, String provider, int userId) {
            this.account = account;
            this.provider = provider;
            this.userId = userId;
        }

        public boolean matchesSpec(EndPoint spec) {
            if (this.userId == spec.userId) goto L10;
            if (this.userId == (-1)) goto L10;
            if (spec.userId == (-1)) goto L10;
            return false;
        L10:
            if (spec.account != null) goto L12;
            boolean accountsMatch = true;
        L14:
            if (spec.provider != null) goto L16;
            boolean providersMatch = true;
        L17:
            if (accountsMatch == false) goto L21;
            if (providersMatch == false) goto L22;
            return true;
        L22:
            return false;
        L21:
            return false;
        L16:
            providersMatch = this.provider.equals(spec.provider);
            goto L17
        L12:
            accountsMatch = this.account.equals(spec.account);
            goto L14
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.account != null) goto L5;
            String r1 = "ALL ACCS";
        L6:
            sb.append(r1);
            sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
            if (this.provider != null) goto L9;
            String r2 = "ALL PDRS";
        L10:
            sb.append(r2);
            sb.append(":u" + this.userId);
            return sb.toString();
        L9:
            r2 = this.provider;
            goto L10
        L5:
            r1 = this.account.name;
            goto L6
        }

        public String toSafeString() {
            StringBuilder sb = new StringBuilder();
            if (this.account != null) goto L5;
            String r1 = "ALL ACCS";
        L6:
            sb.append(r1);
            sb.append(SliceClientPermissions.SliceAuthority.DELIMITER);
            if (this.provider != null) goto L9;
            String r2 = "ALL PDRS";
        L10:
            sb.append(r2);
            sb.append(":u" + this.userId);
            return sb.toString();
        L9:
            r2 = this.provider;
            goto L10
        L5:
            r1 = SyncLogger.logSafe(this.account);
            goto L6
        }
    }

    private class MyHandler extends Handler {
        final /* synthetic */ SyncStorageEngine this$0;

        public MyHandler(SyncStorageEngine r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what != 1) goto L13;
            SparseArray<AuthorityInfo> r0 = this.this$0.mAuthorities;
            monitor-enter(r0);
            this.this$0.writeStatusLocked();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L13:
            if (msg.what != 2) goto L27;
            SparseArray<AuthorityInfo> r1 = this.this$0.mAuthorities;
            monitor-enter(r1);
            this.this$0.writeStatisticsLocked();     // Catch: Throwable -> L19
            monitor-exit(r1);     // Catch: Throwable -> L19
            return;
        L19:
            th = move-exception;
            throw th;
        }
    }

    interface OnAuthorityRemovedListener {
        void onAuthorityRemoved(EndPoint r1);
    }

    interface OnSyncRequestListener {
        void onSyncRequest(EndPoint r1, int r2, Bundle r3, int r4, int r5, int r6);
    }

    interface PeriodicSyncAddedListener {
        void onPeriodicSyncAdded(EndPoint r1, Bundle r2, long r3, long r5);
    }

    public static class SyncHistoryItem {
        int authorityId;
        long downstreamActivity;
        long elapsedTime;
        int event;
        long eventTime;
        Bundle extras;
        int historyId;
        boolean initialization;
        String mesg;
        int reason;
        int source;
        int syncExemptionFlag;
        long upstreamActivity;

        public SyncHistoryItem() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetmPeriodicSyncAddedListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ PeriodicSyncAddedListener m3200$$Nest$sfgetmPeriodicSyncAddedListener() {
        return mPeriodicSyncAddedListener;
    }

    static {
        SOURCES = new String[]{"OTHER", "LOCAL", "POLL", "USER", "PERIODIC", "FEED"};
        sAuthorityRenames = new HashMap();
        sAuthorityRenames.put("contacts", "com.android.contacts");
        sAuthorityRenames.put("calendar", "com.android.calendar");
        sSyncStorageEngine = null;
    }

    private SyncStorageEngine(Context context, File dataDir, Looper looper) {
        this.mAuthorities = new SparseArray();
        this.mAccounts = new HashMap();
        this.mCurrentSyncs = new SparseArray();
        this.mSyncStatus = new SparseArray();
        this.mSyncHistory = new ArrayList();
        this.mChangeListeners = new RemoteCallbackList();
        this.mServices = new ArrayMap();
        this.mNextAuthorityId = 0;
        this.mDayStats = new DayStats[28];
        this.mNextHistoryId = 0;
        this.mMasterSyncAutomatically = new SparseArray();
        this.mHandler = new MyHandler(this, looper);
        this.mContext = context;
        sSyncStorageEngine = this;
        this.mLogger = SyncLogger.getInstance();
        this.mCal = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        this.mDefaultMasterSyncAutomatically = this.mContext.getResources().getBoolean(R.bool.config_unfoldTransitionHingeAngle);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        File systemDir = new File(dataDir, "system");
        this.mSyncDir = new File(systemDir, SYNC_DIR_NAME);
        this.mSyncDir.mkdirs();
        maybeDeleteLegacyPendingInfoLocked(this.mSyncDir);
        this.mAccountInfoFile = new AtomicFile(new File(this.mSyncDir, ACCOUNT_INFO_FILE_NAME), "sync-accounts");
        this.mStatusFile = new AtomicFile(new File(this.mSyncDir, STATUS_FILE_NAME), "sync-status");
        this.mStatisticsFile = new AtomicFile(new File(this.mSyncDir, STATISTICS_FILE_NAME), "sync-stats");
        readAccountInfoLocked();
        readStatusLocked();
        readStatisticsLocked();
        if (this.mLogger.enabled() == false) goto L7;
        int size = this.mAuthorities.size();
        this.mLogger.log(new Object[]{"Loaded ", Integer.valueOf(size), " items"});
        int i = 0;
    L5:
        if (i >= size) goto L9;
        this.mLogger.log(new Object[]{this.mAuthorities.valueAt(i).toSafeString()});
        i = i + 1;
        goto L5
    L9:
        return;
    }

    public static SyncStorageEngine newTestInstance(Context context) {
        return new SyncStorageEngine(context, context.getFilesDir(), Looper.getMainLooper());
    }

    public static void init(Context context, Looper looper) {
        if (sSyncStorageEngine == null) goto L5;
        return;
    L5:
        File dataDir = Environment.getDataDirectory();
        sSyncStorageEngine = new SyncStorageEngine(context, dataDir, looper);
    }

    public static SyncStorageEngine getSingleton() {
        if (sSyncStorageEngine == null) goto L7;
        return sSyncStorageEngine;
    L7:
        throw new IllegalStateException("not initialized");
    }

    protected void setOnSyncRequestListener(OnSyncRequestListener listener) {
        if (this.mSyncRequestListener != null) goto L6;
        this.mSyncRequestListener = listener;
        return;
    }

    protected void setOnAuthorityRemovedListener(OnAuthorityRemovedListener listener) {
        if (this.mAuthorityRemovedListener != null) goto L6;
        this.mAuthorityRemovedListener = listener;
        return;
    }

    protected void setPeriodicSyncAddedListener(PeriodicSyncAddedListener listener) {
        if (mPeriodicSyncAddedListener != null) goto L6;
        mPeriodicSyncAddedListener = listener;
        return;
    }

    public int getSyncRandomOffset() {
        return this.mSyncRandomOffset;
    }

    public void addStatusChangeListener(int mask, int callingUid, ISyncStatusObserver callback) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        long cookie = IntPair.of(callingUid, mask);     // Catch: Throwable -> L7
        this.mChangeListeners.register(callback, Long.valueOf(cookie));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeStatusChangeListener(ISyncStatusObserver callback) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        this.mChangeListeners.unregister(callback);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static long calculateDefaultFlexTime(long syncTimeSeconds) {
        if (syncTimeSeconds >= 5) goto L7;
        return 0;
    L7:
        if (syncTimeSeconds < DEFAULT_POLL_FREQUENCY_SECONDS) goto L9;
        return 3456;
    L9:
        return (long) (syncTimeSeconds * DEFAULT_FLEX_PERCENT_SYNC);
    }

    void reportChange(int which, EndPoint target) {
        if (target.account != null) goto L5;
    L8:
        String syncAdapterPackageName = null;
    L9:
        reportChange(which, syncAdapterPackageName, target.userId);
        return;
    L5:
        if (target.provider == null) goto L8;
        syncAdapterPackageName = ContentResolver.getSyncAdapterPackageAsUser(target.account.type, target.provider, target.userId);
        goto L9
    }

    void reportChange(int which, String callingPackageName, int callingUserId) {
        ArrayList<ISyncStatusObserver> reports = null;
        SparseArray<AuthorityInfo> r1 = this.mAuthorities;
        monitor-enter(r1);
        int i = this.mChangeListeners.beginBroadcast();     // Catch: Throwable -> L14
    L5:
        if (i <= 0) goto L19;
        i = i - 1;     // Catch: Throwable -> L14
        long cookie = ((Long) this.mChangeListeners.getBroadcastCookie(i)).longValue();     // Catch: Throwable -> L14
        int registerUid = IntPair.first(cookie);     // Catch: Throwable -> L14
        int registerUserId = UserHandle.getUserId(registerUid);     // Catch: Throwable -> L14
        int mask = IntPair.second(cookie);     // Catch: Throwable -> L14
        if ((which & mask) == 0) goto L5;
        if (callingUserId != registerUserId) goto L5;
        if (callingPackageName == null) goto L16;
        if (this.mPackageManagerInternal.filterAppAccess(callingPackageName, registerUid, callingUserId) == true) goto L5;
    L16:
        if (reports != null) goto L18;
        reports = new ArrayList(i);     // Catch: Throwable -> L14
    L18:
        reports.add(this.mChangeListeners.getBroadcastItem(i));     // Catch: Throwable -> L14
        goto L5
    L19:
        this.mChangeListeners.finishBroadcast();     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        if (Log.isLoggable("SyncManager", 2) == false) goto L24;
        Slog.v("SyncManager", "reportChange " + which + " to: " + reports);
    L24:
        if (reports == null) goto L32;
        int i2 = reports.size();
    L26:
        if (i2 <= 0) goto L55;
        i2 = i2 - 1;
        reports.get(i2).onStatusChanged(which);     // Catch: RemoteException -> L30
        goto L26
    L55:
        return;
    L32:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean getSyncAutomatically(Account account, int userId, String providerName) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        boolean r1 = false;
        if (account == null) goto L15;
        AuthorityInfo authority = getAuthorityLocked(new EndPoint(account, providerName, userId), "getSyncAutomatically");     // Catch: Throwable -> L11
        if (authority != null) goto L9;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L9:
        if (authority.enabled == false) goto L13;
        r1 = true;
        goto L13
    L15:
        int i = this.mAuthorities.size();     // Catch: Throwable -> L11
    L16:
        if (i <= 0) goto L24;
        i = i - 1;     // Catch: Throwable -> L11
        AuthorityInfo authorityInfo = this.mAuthorities.valueAt(i);     // Catch: Throwable -> L11
        if (authorityInfo.target.matchesSpec(new EndPoint(account, providerName, userId)) == false) goto L16;
        if (authorityInfo.enabled == false) goto L16;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return true;
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        throw th;
    }

    public void setSyncAutomatically(Account account, int userId, String providerName, boolean sync, int syncExemptionFlag, int callingUid, int callingPid) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.d("SyncManager", "setSyncAutomatically:  provider " + providerName + ", user " + userId + " -> " + sync);
    L5:
        this.mLogger.log(new Object[]{"Set sync auto account=", account.toSafeString(), " user=", Integer.valueOf(userId), " authority=", providerName, " value=", Boolean.toString(sync), " cuid=", Integer.valueOf(callingUid), " cpid=", Integer.valueOf(callingPid)});
        SparseArray<AuthorityInfo> r4 = this.mAuthorities;
        monitor-enter(r4);
        AuthorityInfo authority = getOrCreateAuthorityLocked(new EndPoint(account, providerName, userId), -1, false);     // Catch: Throwable -> L12
        if (authority.enabled != sync) goto L17;
        if (Log.isLoggable("SyncManager", 2) == false) goto L14;
        Slog.d("SyncManager", "setSyncAutomatically: already set to " + sync + ", doing nothing");     // Catch: Throwable -> L12
    L14:
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L17:
        if (sync == true) goto L19;
    L21:
        authority.enabled = sync;     // Catch: Throwable -> L12
        writeAccountInfoLocked();     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
        if (sync == false) goto L25;
        requestSync(account, userId, -6, providerName, new Bundle(), syncExemptionFlag, callingUid, callingPid);
    L25:
        reportChange(1, authority.target);
        queueBackup();
        return;
    L19:
        if (authority.syncable != 2) goto L21;
        authority.syncable = -1;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public int getIsSyncable(Account account, int userId, String providerName) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        if (account == null) goto L15;
        AuthorityInfo authority = getAuthorityLocked(new EndPoint(account, providerName, userId), "get authority syncable");     // Catch: Throwable -> L10
        if (authority != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L10
        return -1;
    L12:
        int r1 = authority.syncable;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L15:
        int i = this.mAuthorities.size();     // Catch: Throwable -> L10
    L16:
        if (i <= 0) goto L25;
        i = i - 1;     // Catch: Throwable -> L10
        AuthorityInfo authorityInfo = this.mAuthorities.valueAt(i);     // Catch: Throwable -> L10
        if (authorityInfo.target == null) goto L16;
        if (authorityInfo.target.provider.equals(providerName) == false) goto L16;
        int r2 = authorityInfo.syncable;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return -1;
    L10:
        th = move-exception;
        throw th;
    }

    public void setIsSyncable(Account account, int userId, String providerName, int syncable, int callingUid, int callingPid) {
        setSyncableStateForEndPoint(new EndPoint(account, providerName, userId), syncable, callingUid, callingPid);
    }

    private void setSyncableStateForEndPoint(EndPoint target, int syncable, int callingUid, int callingPid) {
        this.mLogger.log(new Object[]{"Set syncable ", target.toSafeString(), " value=", Integer.toString(syncable), " cuid=", Integer.valueOf(callingUid), " cpid=", Integer.valueOf(callingPid)});
        SparseArray<AuthorityInfo> r1 = this.mAuthorities;
        monitor-enter(r1);
        AuthorityInfo aInfo = getOrCreateAuthorityLocked(target, -1, false);     // Catch: Throwable -> L29
        if (syncable >= (-1)) goto L9;
        syncable = -1;
    L9:
        if (Log.isLoggable("SyncManager", 2) == false) goto L15;
        Slog.d("SyncManager", "setIsSyncable: " + aInfo.toString() + " -> " + syncable);     // Catch: Throwable -> L12
    L12:
        th = th;
    L39:
        monitor-exit(r1);     // Catch: Throwable -> L33
        throw th;
    L33:
        th = th;
    L15:
        if (aInfo.syncable == syncable) goto L17;
        aInfo.syncable = syncable;     // Catch: Throwable -> L29
        writeAccountInfoLocked();     // Catch: Throwable -> L29
        monitor-exit(r1);     // Catch: Throwable -> L29
        if (syncable != 1) goto L27;
        requestSync(aInfo, -5, new Bundle(), 0, callingUid, callingPid);
    L27:
        reportChange(1, target);
        return;
    L17:
        if (Log.isLoggable("SyncManager", 2) == false) goto L19;
        Slog.d("SyncManager", "setIsSyncable: already set to " + syncable + ", doing nothing");     // Catch: Throwable -> L12
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L29:
        th = th;
        goto L39
    }

    void setJobNamespaceMigrated(boolean migrated) {
        if (this.mIsJobNamespaceMigrated != migrated) goto L5;
        return;
    L5:
        this.mIsJobNamespaceMigrated = migrated;
        this.mHandler.sendEmptyMessageDelayed(1, 600000);
    }

    boolean isJobNamespaceMigrated() {
        return this.mIsJobNamespaceMigrated;
    }

    void setJobAttributionFixed(boolean fixed) {
        if (this.mIsJobAttributionFixed != fixed) goto L5;
        return;
    L5:
        this.mIsJobAttributionFixed = fixed;
        this.mHandler.sendEmptyMessageDelayed(1, 600000);
    }

    boolean isJobAttributionFixed() {
        return this.mIsJobAttributionFixed;
    }

    public Pair<Long, Long> getBackoff(EndPoint info) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        AuthorityInfo authority = getAuthorityLocked(info, "getBackoff");     // Catch: Throwable -> L9
        if (authority == null) goto L11;
        Pair<Long, Long> r2 = Pair.create(Long.valueOf(authority.backoffTime), Long.valueOf(authority.backoffDelay));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public void setBackoff(EndPoint info, long nextSyncTime, long nextDelay) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.v("SyncManager", "setBackoff: " + info + " -> nextSyncTime " + nextSyncTime + ", nextDelay " + nextDelay);
    L5:
        SparseArray<AuthorityInfo> r9 = this.mAuthorities;
        monitor-enter(r9);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (info.account == null) goto L20;
        if (info.provider == null) goto L20;
        AuthorityInfo authorityInfo = getOrCreateAuthorityLocked(info, -1, true);     // Catch: Throwable -> L17
        if (authorityInfo.backoffTime == nextSyncTime) goto L15;
    L19:
        authorityInfo.backoffTime = nextSyncTime;     // Catch: Throwable -> L17
        authorityInfo.backoffDelay = nextDelay;     // Catch: Throwable -> L17
        boolean changed = true;
    L21:
        monitor-exit(r9);     // Catch: Throwable -> L17
        if (changed == false) goto L29;
        reportChange(1, info);
        return;
    L29:
        return;
    L15:
        if (authorityInfo.backoffDelay != nextDelay) goto L19;
        changed = false;
    L20:
        changed = setBackoffLocked(info.account, info.userId, info.provider, nextSyncTime, nextDelay);     // Catch: Throwable -> L17
        goto L21
    }

    private boolean setBackoffLocked(Account account, int userId, String providerName, long nextSyncTime, long nextDelay) {
        boolean changed = false;
        Iterator<AccountInfo> r1 = this.mAccounts.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L27;
        AccountInfo accountInfo = r1.next();
        if (account == null) goto L12;
        if (account.equals(accountInfo.accountAndUser.account) == true) goto L12;
        if (userId != accountInfo.accountAndUser.userId) goto L4;
    L12:
        Iterator<AuthorityInfo> r3 = accountInfo.authorities.values().iterator();
    L14:
        if (r3.hasNext() == false) goto L4;
        AuthorityInfo authorityInfo = r3.next();
        if (providerName == null) goto L21;
        if (providerName.equals(authorityInfo.target.provider) == false) goto L14;
    L21:
        if (authorityInfo.backoffTime != nextSyncTime) goto L24;
        if (authorityInfo.backoffDelay == nextDelay) goto L14;
    L24:
        authorityInfo.backoffTime = nextSyncTime;
        authorityInfo.backoffDelay = nextDelay;
        changed = true;
        goto L14
    L27:
        return changed;
    }

    public void clearAllBackoffsLocked() {
        ArraySet<Integer> changedUserIds = new ArraySet();
        SparseArray<AuthorityInfo> r1 = this.mAuthorities;
        monitor-enter(r1);
        Iterator<AccountInfo> r2 = this.mAccounts.values().iterator();     // Catch: Throwable -> L15
    L6:
        if (r2.hasNext() == false) goto L23;
        AccountInfo accountInfo = r2.next();     // Catch: Throwable -> L15
        Iterator<AuthorityInfo> r4 = accountInfo.authorities.values().iterator();     // Catch: Throwable -> L15
    L9:
        if (r4.hasNext() == false) goto L6;
        AuthorityInfo authorityInfo = r4.next();     // Catch: Throwable -> L15
        if (authorityInfo.backoffTime != (-1)) goto L18;
        if (authorityInfo.backoffDelay == (-1)) goto L9;
    L18:
        if (Log.isLoggable("SyncManager", 2) == false) goto L20;
        Slog.v("SyncManager", "clearAllBackoffsLocked: authority:" + authorityInfo.target + " account:" + accountInfo.accountAndUser.account.name + " user:" + accountInfo.accountAndUser.userId + " backoffTime was: " + authorityInfo.backoffTime + " backoffDelay was: " + authorityInfo.backoffDelay);     // Catch: Throwable -> L15
    L20:
        authorityInfo.backoffTime = -1;     // Catch: Throwable -> L15
        authorityInfo.backoffDelay = -1;     // Catch: Throwable -> L15
        changedUserIds.add(Integer.valueOf(accountInfo.accountAndUser.userId));     // Catch: Throwable -> L15
        goto L9
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        int i = changedUserIds.size() - 1;
    L25:
        if (i <= 0) goto L28;
        reportChange(1, null, changedUserIds.valueAt(i).intValue());
        i = i - 1;
        goto L25
    L28:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public long getDelayUntilTime(EndPoint info) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        AuthorityInfo authority = getAuthorityLocked(info, "getDelayUntil");     // Catch: Throwable -> L9
        if (authority != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        long r2 = authority.delayUntil;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public void setDelayUntilTime(EndPoint info, long delayUntil) {
        if (Log.isLoggable("SyncManager", 2) == false) goto L5;
        Slog.v("SyncManager", "setDelayUntil: " + info + " -> delayUntil " + delayUntil);
    L5:
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        AuthorityInfo authority = getOrCreateAuthorityLocked(info, -1, true);     // Catch: Throwable -> L12
        if (authority.delayUntil != delayUntil) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        authority.delayUntil = delayUntil;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        reportChange(1, info);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    boolean restoreAllPeriodicSyncs() {
        if (mPeriodicSyncAddedListener != null) goto L6;
        return false;
    L6:
        SparseArray<AuthorityInfo> r1 = this.mAuthorities;
        monitor-enter(r1);
        int i = 0;
    L24:
    L15:
        th = move-exception;
        throw th;
    L10:
        if (i >= this.mAuthorities.size()) goto L18;
        AuthorityInfo authority = this.mAuthorities.valueAt(i);     // Catch: Throwable -> L15
        Iterator<PeriodicSync> r3 = authority.periodicSyncs.iterator();     // Catch: Throwable -> L15
    L13:
        if (r3.hasNext() == false) goto L17;
        PeriodicSync periodicSync = r3.next();     // Catch: Throwable -> L15
        mPeriodicSyncAddedListener.onPeriodicSyncAdded(authority.target, periodicSync.extras, periodicSync.period, periodicSync.flexTime);     // Catch: Throwable -> L15
        goto L13
    L17:
        authority.periodicSyncs.clear();     // Catch: Throwable -> L15
        i = i + 1;     // Catch: Throwable -> L15
        goto L24
    L18:
        writeAccountInfoLocked();     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        return true;
    }

    public void setMasterSyncAutomatically(boolean flag, int userId, int syncExemptionFlag, int callingUid, int callingPid) {
        this.mLogger.log(new Object[]{"Set master enabled=", Boolean.valueOf(flag), " user=", Integer.valueOf(userId), " cuid=", Integer.valueOf(callingUid), " cpid=", Integer.valueOf(callingPid)});
        SparseArray<AuthorityInfo> r2 = this.mAuthorities;
        monitor-enter(r2);
        Boolean auto = this.mMasterSyncAutomatically.get(userId);     // Catch: Throwable -> L10
        if (auto != null) goto L7;
    L12:
        this.mMasterSyncAutomatically.put(userId, Boolean.valueOf(flag));     // Catch: Throwable -> L10
        writeAccountInfoLocked();     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        if (flag == false) goto L16;
        requestSync(null, userId, -7, null, new Bundle(), syncExemptionFlag, callingUid, callingPid);
    L16:
        reportChange(1, null, userId);
        this.mContext.sendBroadcast(ContentResolver.ACTION_SYNC_CONN_STATUS_CHANGED);
        queueBackup();
        return;
    L7:
        if (auto.equals(Boolean.valueOf(flag)) == false) goto L12;
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean getMasterSyncAutomatically(int userId) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        Boolean auto = this.mMasterSyncAutomatically.get(userId);     // Catch: Throwable -> L7
        if (auto != null) goto L9;
        boolean r2 = this.mDefaultMasterSyncAutomatically;     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L9:
        r2 = auto.booleanValue();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public int getAuthorityCount() {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        int r1 = this.mAuthorities.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public AuthorityInfo getAuthority(int authorityId) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        AuthorityInfo r1 = this.mAuthorities.get(authorityId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSyncActive(EndPoint info) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        Iterator<SyncInfo> r1 = getCurrentSyncs(info.userId).iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L17;
        SyncInfo syncInfo = r1.next();     // Catch: Throwable -> L14
        AuthorityInfo ainfo = getAuthority(syncInfo.authorityId);     // Catch: Throwable -> L14
        if (ainfo == null) goto L6;
        if (ainfo.target.matchesSpec(info) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;
    }

    public void markPending(EndPoint info, boolean pendingValue) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        AuthorityInfo authority = getOrCreateAuthorityLocked(info, -1, true);     // Catch: Throwable -> L9
        if (authority != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);     // Catch: Throwable -> L9
        status.pending = pendingValue;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        reportChange(2, info);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void removeStaleAccounts(Account[] currentAccounts, int userId) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Log.isLoggable("SyncManager", 2) == false) goto L9;
        Slog.v("SyncManager", "Updating for new accounts...");     // Catch: Throwable -> L7
    L9:
        SparseArray<AuthorityInfo> removing = new SparseArray();     // Catch: Throwable -> L7
        Iterator<AccountInfo> accIt = this.mAccounts.values().iterator();     // Catch: Throwable -> L7
    L11:
        if (accIt.hasNext() == false) goto L27;
        AccountInfo acc = accIt.next();     // Catch: Throwable -> L7
        if (acc.accountAndUser.userId != userId) goto L11;
        if (currentAccounts == null) goto L19;
        if (ArrayUtils.contains(currentAccounts, acc.accountAndUser.account) == true) goto L11;
    L19:
        if (Log.isLoggable("SyncManager", 2) == false) goto L21;
        Slog.v("SyncManager", "Account removed: " + acc.accountAndUser);     // Catch: Throwable -> L7
    L21:
        Iterator<AuthorityInfo> r5 = acc.authorities.values().iterator();     // Catch: Throwable -> L7
    L23:
        if (r5.hasNext() == false) goto L25;
        AuthorityInfo auth = r5.next();     // Catch: Throwable -> L7
        removing.put(auth.ident, auth);     // Catch: Throwable -> L7
        goto L23
    L25:
        accIt.remove();     // Catch: Throwable -> L7
        goto L11
    L27:
        int i = removing.size();     // Catch: Throwable -> L7
        if (i <= 0) goto L45;
    L29:
        if (i <= 0) goto L44;
        i = i - 1;     // Catch: Throwable -> L7
        int ident = removing.keyAt(i);     // Catch: Throwable -> L7
        AuthorityInfo auth2 = removing.valueAt(i);     // Catch: Throwable -> L7
        if (this.mAuthorityRemovedListener == null) goto L33;
        this.mAuthorityRemovedListener.onAuthorityRemoved(auth2.target);     // Catch: Throwable -> L7
    L33:
        this.mAuthorities.remove(ident);     // Catch: Throwable -> L7
        int j = this.mSyncStatus.size();     // Catch: Throwable -> L7
    L34:
        if (j <= 0) goto L38;
        j = j - 1;     // Catch: Throwable -> L7
        if (this.mSyncStatus.keyAt(j) != ident) goto L34;
        this.mSyncStatus.remove(this.mSyncStatus.keyAt(j));     // Catch: Throwable -> L7
        goto L34
    L38:
        int j2 = this.mSyncHistory.size();     // Catch: Throwable -> L7
    L39:
        if (j2 <= 0) goto L29;
        j2 = j2 - 1;     // Catch: Throwable -> L7
        if (this.mSyncHistory.get(j2).authorityId != ident) goto L39;
        this.mSyncHistory.remove(j2);     // Catch: Throwable -> L7
        goto L39
    L44:
        writeAccountInfoLocked();     // Catch: Throwable -> L7
        writeStatusLocked();     // Catch: Throwable -> L7
        writeStatisticsLocked();     // Catch: Throwable -> L7
    L45:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public SyncInfo addActiveSync(SyncManager.ActiveSyncContext activeSyncContext) {
        SparseArray<AuthorityInfo> r1 = this.mAuthorities;
        monitor-enter(r1);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Log.isLoggable("SyncManager", 2) == false) goto L9;
        Slog.v("SyncManager", "setActiveSync: account= auth=" + activeSyncContext.mSyncOperation.target + " src=" + activeSyncContext.mSyncOperation.syncSource + " extras=" + activeSyncContext.mSyncOperation.getExtrasAsString());     // Catch: Throwable -> L7
    L9:
        EndPoint info = activeSyncContext.mSyncOperation.target;     // Catch: Throwable -> L7
        AuthorityInfo authorityInfo = getOrCreateAuthorityLocked(info, -1, true);     // Catch: Throwable -> L7
        SyncInfo syncInfo = new SyncInfo(authorityInfo.ident, authorityInfo.target.account, authorityInfo.target.provider, activeSyncContext.mStartTime);     // Catch: Throwable -> L7
        getCurrentSyncs(authorityInfo.target.userId).add(syncInfo);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        reportActiveChange(activeSyncContext.mSyncOperation.target);
        return syncInfo;
    }

    public void removeActiveSync(SyncInfo syncInfo, int userId) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Log.isLoggable("SyncManager", 2) == false) goto L9;
        Slog.v("SyncManager", "removeActiveSync: account=" + syncInfo.account + " user=" + userId + " auth=" + syncInfo.authority);     // Catch: Throwable -> L7
    L9:
        getCurrentSyncs(userId).remove(syncInfo);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        reportActiveChange(new EndPoint(syncInfo.account, syncInfo.authority, userId));
    }

    public void reportActiveChange(EndPoint target) {
        reportChange(4, target);
    }

    public long insertStartSyncEvent(SyncOperation op, long now) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (Log.isLoggable("SyncManager", 2) == false) goto L9;
        Slog.v("SyncManager", "insertStartSyncEvent: " + op);     // Catch: Throwable -> L7
    L9:
        AuthorityInfo authority = getAuthorityLocked(op.target, "insertStartSyncEvent");     // Catch: Throwable -> L7
        if (authority != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L7
        return -1;
    L14:
        SyncHistoryItem item = new SyncHistoryItem();     // Catch: Throwable -> L7
        item.initialization = op.isInitialization();     // Catch: Throwable -> L7
        item.authorityId = authority.ident;     // Catch: Throwable -> L7
        int r4 = this.mNextHistoryId;     // Catch: Throwable -> L7
        this.mNextHistoryId = r4 + 1;     // Catch: Throwable -> L7
        item.historyId = r4;     // Catch: Throwable -> L7
        if (this.mNextHistoryId >= 0) goto L17;
        this.mNextHistoryId = 0;     // Catch: Throwable -> L7
    L17:
        item.eventTime = now;     // Catch: Throwable -> L7
        item.source = op.syncSource;     // Catch: Throwable -> L7
        item.reason = op.reason;     // Catch: Throwable -> L7
        item.extras = op.getClonedExtras();     // Catch: Throwable -> L7
        item.event = 0;     // Catch: Throwable -> L7
        item.syncExemptionFlag = op.syncExemptionFlag;     // Catch: Throwable -> L7
        this.mSyncHistory.add(0, item);     // Catch: Throwable -> L7
    L19:
        if (this.mSyncHistory.size() <= 100) goto L21;
        this.mSyncHistory.remove(this.mSyncHistory.size() - 1);     // Catch: Throwable -> L7
        goto L19
    L21:
        long id = item.historyId;     // Catch: Throwable -> L7
        if (Log.isLoggable("SyncManager", 2) == false) goto L24;
        Slog.v("SyncManager", "returning historyId " + id);     // Catch: Throwable -> L7
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L7
        reportChange(8, op.owningPackage, op.target.userId);
        return id;
    }

    public void stopSyncEvent(long historyId, long elapsedTime, String resultMessage, long downstreamActivity, long upstreamActivity, String opPackageName, int userId) {
        SparseArray<AuthorityInfo> r7 = this.mAuthorities;
        monitor-enter(r7);
    L7:
        th = th;
    L87:
        monitor-exit(r7);     // Catch: Throwable -> L83
        throw th;
    L83:
        th = th;
        goto L87
    L5:
        if (Log.isLoggable("SyncManager", 2) == false) goto L10;
        Slog.v("SyncManager", "stopSyncEvent: historyId=" + historyId);     // Catch: Throwable -> L7
    L10:
        SyncHistoryItem item = null;
        int i = this.mSyncHistory.size();     // Catch: Throwable -> L7
    L11:
        if (i <= 0) goto L16;
        i = i - 1;     // Catch: Throwable -> L7
        item = this.mSyncHistory.get(i);     // Catch: Throwable -> L7
        if (item.historyId == historyId) goto L16;
        item = null;
    L16:
        if (item != null) goto L20;
        Slog.w("SyncManager", "stopSyncEvent: no history for id " + historyId);     // Catch: Throwable -> L7
        monitor-exit(r7);     // Catch: Throwable -> L7
        return;
    L20:
        item.elapsedTime = elapsedTime;     // Catch: Throwable -> L7
        item.event = 1;     // Catch: Throwable -> L7
        item.mesg = resultMessage;     // Catch: Throwable -> L7
        item.downstreamActivity = downstreamActivity;     // Catch: Throwable -> L7
        item.upstreamActivity = upstreamActivity;     // Catch: Throwable -> L26
        SyncStatusInfo status = getOrCreateSyncStatusLocked(item.authorityId);     // Catch: Throwable -> L26
        status.maybeResetTodayStats(isClockValid(), false);     // Catch: Throwable -> L26
        char r17 = 0;
        status.totalStats.numSyncs++;     // Catch: Throwable -> L26
        status.todayStats.numSyncs++;     // Catch: Throwable -> L26
        status.totalStats.totalElapsedTime += elapsedTime;     // Catch: Throwable -> L26
        status.todayStats.totalElapsedTime += elapsedTime;     // Catch: Throwable -> L26
        switch(item.source) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L25;
            default: goto L33;
        };     // Catch: Throwable -> L26
    L25:
        status.totalStats.numSourceFeed++;     // Catch: Throwable -> L26
        status.todayStats.numSourceFeed++;     // Catch: Throwable -> L26
        goto L33
    L28:
        status.totalStats.numSourcePeriodic++;     // Catch: Throwable -> L26
        status.todayStats.numSourcePeriodic++;     // Catch: Throwable -> L26
        goto L33
    L29:
        status.totalStats.numSourceUser++;     // Catch: Throwable -> L26
        status.todayStats.numSourceUser++;     // Catch: Throwable -> L26
        goto L33
    L30:
        status.totalStats.numSourcePoll++;     // Catch: Throwable -> L26
        status.todayStats.numSourcePoll++;     // Catch: Throwable -> L26
        goto L33
    L31:
        status.totalStats.numSourceLocal++;     // Catch: Throwable -> L26
        status.todayStats.numSourceLocal++;     // Catch: Throwable -> L26
        goto L33
    L32:
        status.totalStats.numSourceOther++;     // Catch: Throwable -> L26
        status.todayStats.numSourceOther++;     // Catch: Throwable -> L26
    L33:
        int day = getCurrentDayLocked();     // Catch: Throwable -> L26
        if (this.mDayStats[0] != null) goto L37;
        this.mDayStats[0] = new DayStats(day);     // Catch: Throwable -> L26
    L40:
        boolean writeStatisticsNow = false;
    L41:
        DayStats ds = this.mDayStats[r17];     // Catch: Throwable -> L26
        long lastSyncTime = item.eventTime + elapsedTime;     // Catch: Throwable -> L26
        if (MESG_SUCCESS.equals(resultMessage) == false) goto L52;
        if (status.lastSuccessTime == 0) goto L49;
        if (status.lastFailureTime != 0) goto L49;
        boolean writeStatusNow = false;
    L50:
        status.setLastSuccess(item.source, lastSyncTime);     // Catch: Throwable -> L26
        ds.successCount++;     // Catch: Throwable -> L26
        ds.successTime += elapsedTime;     // Catch: Throwable -> L26
        boolean writeStatusNow2 = writeStatusNow;
    L59:
        StringBuilder event = new StringBuilder();     // Catch: Throwable -> L26
        event.append("" + resultMessage + " Source=" + SOURCES[item.source] + " Elapsed=");     // Catch: Throwable -> L26
        SyncManager.formatDurationHMS(event, elapsedTime);     // Catch: Throwable -> L26
        event.append(" Reason=");     // Catch: Throwable -> L26
        event.append(SyncOperation.reasonToString(null, item.reason));     // Catch: Throwable -> L26
        if (item.syncExemptionFlag == 0) goto L66;
        event.append(" Exemption=");     // Catch: Throwable -> L26
        switch(item.syncExemptionFlag) {
            case 1: goto L65;
            case 2: goto L64;
            default: goto L63;
        };     // Catch: Throwable -> L26
    L63:
        event.append(item.syncExemptionFlag);     // Catch: Throwable -> L26
        goto L66
    L64:
        event.append("top");     // Catch: Throwable -> L26
        goto L66
    L65:
        event.append("fg");     // Catch: Throwable -> L26
    L66:
        event.append(" Extras=");     // Catch: Throwable -> L26
        SyncOperation.extrasToStringBuilder(item.extras, event);     // Catch: Throwable -> L26
        status.addEvent(event.toString());     // Catch: Throwable -> L26
        if (writeStatusNow2 == false) goto L70;
        writeStatusLocked();     // Catch: Throwable -> L26
    L73:
        if (writeStatisticsNow == false) goto L76;
        writeStatisticsLocked();     // Catch: Throwable -> L26
    L78:
        monitor-exit(r7);     // Catch: Throwable -> L26
        reportChange(8, opPackageName, userId);
        return;
    L76:
        if (this.mHandler.hasMessages(2) == true) goto L78;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 1800000);     // Catch: Throwable -> L26
        goto L78
    L70:
        if (this.mHandler.hasMessages(1) == true) goto L73;
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 600000);     // Catch: Throwable -> L26
    L49:
        writeStatusNow = true;
        goto L50
    L52:
        if (MESG_CANCELED.equals(resultMessage) == false) goto L54;
        status.totalStats.numCancels++;     // Catch: Throwable -> L26
        status.todayStats.numCancels++;     // Catch: Throwable -> L26
        writeStatusNow2 = true;
        goto L59
    L54:
        if (status.lastFailureTime != 0) goto L56;
        writeStatusNow2 = true;
    L57:
        status.totalStats.numFailures++;     // Catch: Throwable -> L26
        status.todayStats.numFailures++;     // Catch: Throwable -> L26
        status.setLastFailure(item.source, lastSyncTime, resultMessage);     // Catch: Throwable -> L26
        ds.failureCount++;     // Catch: Throwable -> L26
        ds.failureTime += elapsedTime;     // Catch: Throwable -> L26
        goto L59
    L56:
        writeStatusNow2 = false;
        goto L57
    L37:
        if (day == this.mDayStats[0].day) goto L39;
        System.arraycopy(this.mDayStats, 0, this.mDayStats, 1, this.mDayStats.length - 1);     // Catch: Throwable -> L26
        this.mDayStats[0] = new DayStats(day);     // Catch: Throwable -> L26
        writeStatisticsNow = true;
        r17 = 0;
        goto L41
    L39:
        r17 = 0;
        DayStats r2 = this.mDayStats[0];     // Catch: Throwable -> L26
    L26:
        th = th;
        goto L87
    }

    private List<SyncInfo> getCurrentSyncs(int userId) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        List<SyncInfo> r1 = getCurrentSyncsLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<SyncInfo> getCurrentSyncsCopy(int userId, boolean canAccessAccounts) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        List<SyncInfo> syncs = getCurrentSyncsLocked(userId);     // Catch: Throwable -> L10
        List<SyncInfo> syncsCopy = new ArrayList();     // Catch: Throwable -> L10
        Iterator<SyncInfo> r3 = syncs.iterator();     // Catch: Throwable -> L10
    L6:
        if (r3.hasNext() == false) goto L14;
        SyncInfo sync = r3.next();     // Catch: Throwable -> L10
        if (canAccessAccounts == true) goto L12;
        SyncInfo copy = SyncInfo.createAccountRedacted(sync.authorityId, sync.authority, sync.startTime);     // Catch: Throwable -> L10
    L13:
        syncsCopy.add(copy);     // Catch: Throwable -> L10
        goto L6
    L12:
        copy = new SyncInfo(sync);     // Catch: Throwable -> L10
        goto L13
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return syncsCopy;
    L10:
        th = move-exception;
        throw th;
    }

    private List<SyncInfo> getCurrentSyncsLocked(int userId) {
        ArrayList<SyncInfo> syncs = this.mCurrentSyncs.get(userId);
        if (syncs != null) goto L6;
        ArrayList<SyncInfo> syncs2 = new ArrayList();
        this.mCurrentSyncs.put(userId, syncs2);
        return syncs2;
    L6:
        return syncs;
    }

    public Pair<AuthorityInfo, SyncStatusInfo> getCopyOfAuthorityWithSyncStatus(EndPoint info) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        AuthorityInfo authorityInfo = getOrCreateAuthorityLocked(info, -1, true);     // Catch: Throwable -> L8
        Pair<AuthorityInfo, SyncStatusInfo> r2 = createCopyPairOfAuthorityWithSyncStatusLocked(authorityInfo);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    public SyncStatusInfo getStatusByAuthority(EndPoint info) {
        if (info.account != null) goto L5;
    L25:
        return null;
    L5:
        if (info.provider == null) goto L25;
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        int N = this.mSyncStatus.size();     // Catch: Throwable -> L17
        int i = 0;
    L10:
        if (i >= N) goto L21;
        SyncStatusInfo cur = this.mSyncStatus.valueAt(i);     // Catch: Throwable -> L17
        AuthorityInfo ainfo = this.mAuthorities.get(cur.authorityId);     // Catch: Throwable -> L17
        if (ainfo == null) goto L19;
        if (ainfo.target.matchesSpec(info) == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return cur;
    L19:
        i = i + 1;     // Catch: Throwable -> L17
        goto L10
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    public boolean isSyncPending(EndPoint info) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        int N = this.mSyncStatus.size();     // Catch: Throwable -> L17
        int i = 0;
    L5:
        if (i >= N) goto L21;
        SyncStatusInfo cur = this.mSyncStatus.valueAt(i);     // Catch: Throwable -> L17
        AuthorityInfo ainfo = this.mAuthorities.get(cur.authorityId);     // Catch: Throwable -> L17
        if (ainfo != null) goto L10;
    L19:
        i = i + 1;     // Catch: Throwable -> L17
        goto L5
    L10:
        if (ainfo.target.matchesSpec(info) == false) goto L19;
        if (cur.pending == false) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return true;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return false;
    L17:
        th = move-exception;
        throw th;
    }

    public ArrayList<SyncHistoryItem> getSyncHistory() {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        int N = this.mSyncHistory.size();     // Catch: Throwable -> L7
        ArrayList<SyncHistoryItem> items = new ArrayList(N);     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= N) goto L10;
        items.add(this.mSyncHistory.get(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return items;
    L7:
        th = move-exception;
        throw th;
    }

    public DayStats[] getDayStatistics() {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        DayStats[] ds = new DayStats[this.mDayStats.length];     // Catch: Throwable -> L7
        System.arraycopy(this.mDayStats, 0, ds, 0, ds.length);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return ds;
    L7:
        th = move-exception;
        throw th;
    }

    private Pair<AuthorityInfo, SyncStatusInfo> createCopyPairOfAuthorityWithSyncStatusLocked(AuthorityInfo authorityInfo) {
        SyncStatusInfo syncStatusInfo = getOrCreateSyncStatusLocked(authorityInfo.ident);
        return Pair.create(new AuthorityInfo(authorityInfo), new SyncStatusInfo(syncStatusInfo));
    }

    private int getCurrentDayLocked() {
        this.mCal.setTimeInMillis(System.currentTimeMillis());
        int dayOfYear = this.mCal.get(6);
        if (this.mYear == this.mCal.get(1)) goto L6;
        this.mYear = this.mCal.get(1);
        this.mCal.clear();
        this.mCal.set(1, this.mYear);
        this.mYearInDays = (int) (this.mCal.getTimeInMillis() / 86400000);
    L6:
        return this.mYearInDays + dayOfYear;
    }

    private AuthorityInfo getAuthorityLocked(EndPoint info, String tag) {
        AccountAndUser au = new AccountAndUser(info.account, info.userId);
        AccountInfo accountInfo = this.mAccounts.get(au);
        if (accountInfo != null) goto L9;
        if (tag != null) goto L6;
    L8:
        return null;
    L6:
        if (Log.isLoggable("SyncManager", 2) == false) goto L8;
        Slog.v("SyncManager", tag + ": unknown account " + au);
        goto L8
    L9:
        AuthorityInfo authority = accountInfo.authorities.get(info.provider);
        if (authority != null) goto L16;
        if (tag != null) goto L13;
    L15:
        return null;
    L13:
        if (Log.isLoggable("SyncManager", 2) == false) goto L15;
        Slog.v("SyncManager", tag + ": unknown provider " + info.provider);
        goto L15
    L16:
        return authority;
    }

    private AuthorityInfo getOrCreateAuthorityLocked(EndPoint info, int ident, boolean doWrite) {
        AccountAndUser au = new AccountAndUser(info.account, info.userId);
        AccountInfo account = this.mAccounts.get(au);
        if (account != null) goto L5;
        account = new AccountInfo(au);
        this.mAccounts.put(au, account);
    L5:
        AuthorityInfo authority = account.authorities.get(info.provider);
        if (authority != null) goto L9;
        AuthorityInfo authority2 = createAuthorityLocked(info, ident, doWrite);
        account.authorities.put(info.provider, authority2);
        return authority2;
    L9:
        return authority;
    }

    private AuthorityInfo createAuthorityLocked(EndPoint info, int ident, boolean doWrite) {
        if (ident >= 0) goto L5;
        ident = this.mNextAuthorityId;
        this.mNextAuthorityId++;
        doWrite = true;
    L5:
        if (Log.isLoggable("SyncManager", 2) == false) goto L7;
        Slog.v("SyncManager", "created a new AuthorityInfo for " + info);
    L7:
        AuthorityInfo authority = new AuthorityInfo(info, ident);
        this.mAuthorities.put(ident, authority);
        if (doWrite == false) goto L10;
        writeAccountInfoLocked();
    L10:
        return authority;
    }

    public void removeAuthority(EndPoint info) {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        removeAuthorityLocked(info.account, info.userId, info.provider, true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeAuthorityLocked(Account account, int userId, String authorityName, boolean doWrite) {
        AccountInfo accountInfo = this.mAccounts.get(new AccountAndUser(account, userId));
        if (accountInfo == null) goto L13;
        AuthorityInfo authorityInfo = accountInfo.authorities.remove(authorityName);
        if (authorityInfo != null) goto L7;
        return;
    L7:
        if (this.mAuthorityRemovedListener == null) goto L9;
        this.mAuthorityRemovedListener.onAuthorityRemoved(authorityInfo.target);
    L9:
        this.mAuthorities.remove(authorityInfo.ident);
        if (doWrite == false) goto L15;
        writeAccountInfoLocked();
        return;
    L15:
        return;
    }

    private SyncStatusInfo getOrCreateSyncStatusLocked(int authorityId) {
        SyncStatusInfo status = this.mSyncStatus.get(authorityId);
        if (status != null) goto L6;
        SyncStatusInfo status2 = new SyncStatusInfo(authorityId);
        this.mSyncStatus.put(authorityId, status2);
        return status2;
    L6:
        return status;
    }

    public void writeAllState() {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        writeStatusLocked();     // Catch: Throwable -> L7
        writeStatisticsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean shouldGrantSyncAdaptersAccountAccess() {
        return this.mGrantSyncAdaptersAccountAccess;
    }

    public void clearAndReadState() {
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        this.mAuthorities.clear();     // Catch: Throwable -> L7
        this.mAccounts.clear();     // Catch: Throwable -> L7
        this.mServices.clear();     // Catch: Throwable -> L7
        this.mSyncStatus.clear();     // Catch: Throwable -> L7
        this.mSyncHistory.clear();     // Catch: Throwable -> L7
        readAccountInfoLocked();     // Catch: Throwable -> L7
        readStatusLocked();     // Catch: Throwable -> L7
        readStatisticsLocked();     // Catch: Throwable -> L7
        writeAccountInfoLocked();     // Catch: Throwable -> L7
        writeStatusLocked();     // Catch: Throwable -> L7
        writeStatisticsLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void readAccountInfoLocked() {
        int highestAuthorityId = -1;
        FileInputStream fis = null;
        fis = this.mAccountInfoFile.openRead();     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10
        if (Log.isLoggable(TAG_FILE, 2) == false) goto L12;
        Slog.v(TAG_FILE, "Reading " + this.mAccountInfoFile.getBaseFile());     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10
    L12:
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10
        int eventType = parser.getEventType();     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10
    L14:
        if (eventType == 2) goto L17;
        if (eventType == 1) goto L17;
        eventType = parser.next();     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10
    L17:
        if (eventType != 1) goto L26;
        Slog.i("SyncManager", "No initial accounts");     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10
        this.mNextAuthorityId = Math.max((-1) + 1, this.mNextAuthorityId);
        if (fis == null) goto L140;
        fis.close();     // Catch: IOException -> L23
        return;
    L24:
        return;
    L140:
        return;
    L26:
        if ("accounts".equals(parser.getName()) == false) goto L89;
        boolean listen = parser.getAttributeBoolean(null, XML_ATTR_LISTEN_FOR_TICKLES, true);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        int version = parser.getAttributeInt(null, "version", 0);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        if (version >= 3) goto L30;
        this.mGrantSyncAdaptersAccountAccess = true;     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
    L30:
        int nextId = parser.getAttributeInt(null, XML_ATTR_NEXT_AUTHORITY_ID, 0);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        this.mNextAuthorityId = Math.max(this.mNextAuthorityId, nextId);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        this.mSyncRandomOffset = parser.getAttributeInt(null, XML_ATTR_SYNC_RANDOM_OFFSET, 0);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        if (this.mSyncRandomOffset != 0) goto L34;
        Random random = new Random(System.currentTimeMillis());     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        this.mSyncRandomOffset = random.nextInt(86400);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
    L34:
        this.mMasterSyncAutomatically.put(0, Boolean.valueOf(listen));     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        int eventType2 = parser.next();     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        AuthorityInfo authority = null;
        PeriodicSync periodicSync = null;
        AccountAuthorityValidator validator = new AccountAuthorityValidator(this.mContext);     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
    L36:
        if (eventType2 == 2) goto L122;
        nextId = nextId;
        highestAuthorityId = highestAuthorityId;
        TypedXmlPullParser parser2 = parser;
    L135:
        eventType2 = parser2.next();     // Catch: Throwable -> L53 IOException -> L55 Throwable -> L57
        if (eventType2 == 1) goto L86;
        parser = parser2;
        highestAuthorityId = highestAuthorityId;
        nextId = nextId;
        goto L36
    L86:
        highestAuthorityId = highestAuthorityId;
        goto L89
    L55:
        e = e;
        highestAuthorityId = highestAuthorityId;
    L97:
        IOException e = e;
        if (fis != null) goto L100;
        Slog.i("SyncManager", "No initial accounts");     // Catch: Throwable -> L6
    L101:
        this.mNextAuthorityId = Math.max(highestAuthorityId + 1, this.mNextAuthorityId);
        if (fis == null) goto L142;
        fis.close();     // Catch: IOException -> L105
        return;
    L106:
        return;
    L142:
        return;
    L100:
        Slog.w("SyncManager", "Error reading accounts", e);     // Catch: Throwable -> L6
    L57:
        e = e;
        highestAuthorityId = highestAuthorityId;
    L108:
        Slog.w("SyncManager", "Error reading accounts", e);     // Catch: Throwable -> L6
        this.mNextAuthorityId = Math.max(highestAuthorityId + 1, this.mNextAuthorityId);
        if (fis == null) goto L144;
        fis.close();     // Catch: IOException -> L113
        return;
    L114:
        return;
    L144:
        return;
    L53:
        th = move-exception;
        Throwable r2 = th;
        highestAuthorityId = highestAuthorityId;
    L115:
        this.mNextAuthorityId = Math.max(highestAuthorityId + 1, this.mNextAuthorityId);
        if (fis == null) goto L146;
        fis.close();     // Catch: IOException -> L119
        throw r2;
    L120:
        throw r2;
    L146:
        throw r2;
    L122:
        String tagName = parser.getName();     // Catch: Throwable -> L59 IOException -> L61 Throwable -> L63
        if (parser.getDepth() == 2) goto L40;
        nextId = nextId;
        highestAuthorityId = highestAuthorityId;
        TypedXmlPullParser parser3 = parser;
        if (parser3.getDepth() != 3) goto L76;
        if ("periodicSync".equals(tagName) == false) goto L81;
        if (authority == null) goto L81;
        parser2 = parser3;
        periodicSync = parsePeriodicSync(parser3, authority);     // Catch: Throwable -> L53 IOException -> L55 Throwable -> L57
    L81:
        parser2 = parser3;
        goto L135
    L76:
        if (parser3.getDepth() != 4) goto L81;
        if (periodicSync == null) goto L81;
        if ("extra".equals(tagName) == false) goto L81;
        parseExtra(parser3, periodicSync.extras);     // Catch: Throwable -> L53 IOException -> L55 Throwable -> L57
        goto L81
    L40:
        if ("authority".equals(tagName) == false) goto L65;
        TypedXmlPullParser parser4 = parser;
        authority = parseAuthority(parser4, version, validator);     // Catch: Throwable -> L59 IOException -> L61 Throwable -> L63
        periodicSync = null;
        if (authority != null) goto L45;
    L51:
        EventLog.writeEvent(1397638484, new Object[]{"26513719", -1, "Malformed authority"});     // Catch: Throwable -> L53 IOException -> L55 Throwable -> L57
    L52:
        parser2 = parser4;
        goto L135
    L45:
        if (authority.ident <= highestAuthorityId) goto L52;
        parser2 = parser4;
        nextId = nextId;
        highestAuthorityId = authority.ident;     // Catch: Throwable -> L6 IOException -> L8 Throwable -> L10 Throwable -> L10
        goto L135
    L65:
        nextId = nextId;
        highestAuthorityId = highestAuthorityId;
        parser3 = parser;
        if (XML_TAG_LISTEN_FOR_TICKLES.equals(tagName) == false) goto L81;
        parseListenForTickles(parser3);     // Catch: Throwable -> L53 IOException -> L55 Throwable -> L57
    L63:
        e = e;
    L61:
        e = e;
    L59:
        th = move-exception;
        r2 = th;
    L89:
        this.mNextAuthorityId = Math.max(highestAuthorityId + 1, this.mNextAuthorityId);
        if (fis != null) goto L130;
    L95:
        maybeMigrateSettingsForRenamedAuthorities();
        return;
    L130:
        fis.close();     // Catch: IOException -> L93
    L8:
        e = e;
    L10:
        e = e;
    L6:
        th = move-exception;
        r2 = th;
        goto L115
    }

    private void maybeDeleteLegacyPendingInfoLocked(File syncDir) {
        File file = new File(syncDir, "pending.bin");
        if (file.exists() == true) goto L5;
        return;
    L5:
        file.delete();
    }

    private boolean maybeMigrateSettingsForRenamedAuthorities() {
        boolean writeNeeded = false;
        ArrayList<AuthorityInfo> authoritiesToRemove = new ArrayList();
        int N = this.mAuthorities.size();
        int i = 0;
    L4:
        if (i >= N) goto L16;
        AuthorityInfo authority = this.mAuthorities.valueAt(i);
        String newAuthorityName = sAuthorityRenames.get(authority.target.provider);
        if (newAuthorityName == null) goto L15;
        authoritiesToRemove.add(authority);
        if (authority.enabled == false) goto L15;
        EndPoint newInfo = new EndPoint(authority.target.account, newAuthorityName, authority.target.userId);
        if (getAuthorityLocked(newInfo, "cleanup") != null) goto L15;
        AuthorityInfo newAuthority = getOrCreateAuthorityLocked(newInfo, -1, false);
        newAuthority.enabled = true;
        writeNeeded = true;
    L15:
        i = i + 1;
        goto L4
    L16:
        Iterator<AuthorityInfo> r3 = authoritiesToRemove.iterator();
    L18:
        if (r3.hasNext() == false) goto L20;
        AuthorityInfo authorityInfo = r3.next();
        removeAuthorityLocked(authorityInfo.target.account, authorityInfo.target.userId, authorityInfo.target.provider, false);
        writeNeeded = true;
        goto L18
    L20:
        return writeNeeded;
    }

    private void parseListenForTickles(TypedXmlPullParser parser) {
        int userId = 0;
        userId = parser.getAttributeInt(null, XML_ATTR_USER);     // Catch: XmlPullParserException -> L5
    L7:
        boolean listen = parser.getAttributeBoolean(null, "enabled", true);
        this.mMasterSyncAutomatically.put(userId, Boolean.valueOf(listen));
        return;
    L5:
        e = move-exception;
        Slog.e("SyncManager", "error parsing the user for listen-for-tickles", e);
        goto L7
    }

    /* JADX WARN: Failed to calculate best type for var: r0v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v13 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v10 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    private com.android.server.content.SyncStorageEngine.AuthorityInfo parseAuthority(com.android.modules.utils.TypedXmlPullParser r20, int r21, com.android.server.content.SyncStorageEngine.AccountAuthorityValidator r22) throws org.xmlpull.v1.XmlPullParserException {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x013c: MOVE (r0v13 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9v2 ?? I:??[int, short, byte, float]) A[DECLARE_VAR] (LINE:1927) in method: com.android.server.content.SyncStorageEngine.parseAuthority(com.android.modules.utils.TypedXmlPullParser, int, com.android.server.content.SyncStorageEngine$AccountAuthorityValidator):com.android.server.content.SyncStorageEngine$AuthorityInfo, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.content.SyncStorageEngine.parseAuthority(com.android.modules.utils.TypedXmlPullParser, int, com.android.server.content.SyncStorageEngine$AccountAuthorityValidator):com.android.server.content.SyncStorageEngine$AuthorityInfo");
    }

    private PeriodicSync parsePeriodicSync(TypedXmlPullParser parser, AuthorityInfo authorityInfo) {
        Bundle extras = new Bundle();
        long period = parser.getAttributeLong(null, "period");     // Catch: XmlPullParserException -> L10
        long flextime = parser.getAttributeLong(null, "flex");     // Catch: XmlPullParserException -> L6
    L8:
        PeriodicSync periodicSync = new PeriodicSync(authorityInfo.target.account, authorityInfo.target.provider, extras, period, flextime);
        authorityInfo.periodicSyncs.add(periodicSync);
        return periodicSync;
    L6:
        e = move-exception;
        long flextime2 = calculateDefaultFlexTime(period);
        Slog.e("SyncManager", "Error formatting value parsed for periodic sync flex, using default: " + flextime2, e);
        flextime = flextime2;
    L10:
        e = move-exception;
        Slog.e("SyncManager", "error parsing the period of a periodic sync", e);
        return null;
    }

    private void parseExtra(TypedXmlPullParser parser, Bundle extras) {
        String name = parser.getAttributeValue(null, "name");
        String type = parser.getAttributeValue(null, DatabaseHelper.SoundModelContract.KEY_TYPE);
    L7:
        e = move-exception;
        Slog.e("SyncManager", "error parsing bundle value", e);
        return;
    L5:
        if ("long".equals(type) == false) goto L10;
        extras.putLong(name, parser.getAttributeLong(null, "value1"));     // Catch: XmlPullParserException -> L7
    L30:
        return;
    L10:
        if ("integer".equals(type) == false) goto L13;
        extras.putInt(name, parser.getAttributeInt(null, "value1"));     // Catch: XmlPullParserException -> L7
        goto L30
    L13:
        if ("double".equals(type) == false) goto L16;
        extras.putDouble(name, parser.getAttributeDouble(null, "value1"));     // Catch: XmlPullParserException -> L7
        goto L30
    L16:
        if ("float".equals(type) == false) goto L19;
        extras.putFloat(name, parser.getAttributeFloat(null, "value1"));     // Catch: XmlPullParserException -> L7
        goto L30
    L19:
        if ("boolean".equals(type) == false) goto L22;
        extras.putBoolean(name, parser.getAttributeBoolean(null, "value1"));     // Catch: XmlPullParserException -> L7
        goto L30
    L22:
        if ("string".equals(type) == false) goto L25;
        extras.putString(name, parser.getAttributeValue(null, "value1"));     // Catch: XmlPullParserException -> L7
        goto L30
    L25:
        if ("account".equals(type) == false) goto L30;
        String value1 = parser.getAttributeValue(null, "value1");     // Catch: XmlPullParserException -> L7
        String value2 = parser.getAttributeValue(null, "value2");     // Catch: XmlPullParserException -> L7
        extras.putParcelable(name, new Account(value1, value2));     // Catch: XmlPullParserException -> L7
        goto L30
    }

    private void writeAccountInfoLocked() {
        if (Log.isLoggable(TAG_FILE, 2) == false) goto L5;
        Slog.v(TAG_FILE, "Writing new " + this.mAccountInfoFile.getBaseFile());
    L5:
        FileOutputStream fos = null;
        fos = this.mAccountInfoFile.startWrite();     // Catch: IOException -> L11
        TypedXmlSerializer out = Xml.resolveSerializer(fos);     // Catch: IOException -> L11
        out.startDocument(null, true);     // Catch: IOException -> L11
        out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: IOException -> L11
        out.startTag(null, "accounts");     // Catch: IOException -> L11
        out.attributeInt(null, "version", 3);     // Catch: IOException -> L11
        out.attributeInt(null, XML_ATTR_NEXT_AUTHORITY_ID, this.mNextAuthorityId);     // Catch: IOException -> L11
        out.attributeInt(null, XML_ATTR_SYNC_RANDOM_OFFSET, this.mSyncRandomOffset);     // Catch: IOException -> L11
        int M = this.mMasterSyncAutomatically.size();     // Catch: IOException -> L11
        int m = 0;
    L9:
        if (m >= M) goto L13;
        int userId = this.mMasterSyncAutomatically.keyAt(m);     // Catch: IOException -> L11
        Boolean listen = this.mMasterSyncAutomatically.valueAt(m);     // Catch: IOException -> L11
        out.startTag(null, XML_TAG_LISTEN_FOR_TICKLES);     // Catch: IOException -> L11
        out.attributeInt(null, XML_ATTR_USER, userId);     // Catch: IOException -> L11
        out.attributeBoolean(null, "enabled", listen.booleanValue());     // Catch: IOException -> L11
        out.endTag(null, XML_TAG_LISTEN_FOR_TICKLES);     // Catch: IOException -> L11
        m = m + 1;     // Catch: IOException -> L11
        goto L9
    L13:
        int N = this.mAuthorities.size();     // Catch: IOException -> L11
        int i = 0;
    L14:
        if (i >= N) goto L16;
        AuthorityInfo authority = this.mAuthorities.valueAt(i);     // Catch: IOException -> L11
        EndPoint info = authority.target;     // Catch: IOException -> L11
        out.startTag(null, "authority");     // Catch: IOException -> L11
        out.attributeInt(null, "id", authority.ident);     // Catch: IOException -> L11
        out.attributeInt(null, XML_ATTR_USER, info.userId);     // Catch: IOException -> L11
        out.attributeBoolean(null, "enabled", authority.enabled);     // Catch: IOException -> L11
        out.attribute(null, "account", info.account.name);     // Catch: IOException -> L11
        out.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, info.account.type);     // Catch: IOException -> L11
        out.attribute(null, "authority", info.provider);     // Catch: IOException -> L11
        out.attributeInt(null, "syncable", authority.syncable);     // Catch: IOException -> L11
        out.endTag(null, "authority");     // Catch: IOException -> L11
        i = i + 1;     // Catch: IOException -> L11
        goto L14
    L16:
        out.endTag(null, "accounts");     // Catch: IOException -> L11
        out.endDocument();     // Catch: IOException -> L11
        this.mAccountInfoFile.finishWrite(fos);     // Catch: IOException -> L11
        return;
    L11:
        e1 = move-exception;
        Slog.w("SyncManager", "Error writing accounts", e1);
        if (fos == null) goto L26;
        this.mAccountInfoFile.failWrite(fos);
        return;
    }

    private void readStatusParcelLocked(File parcel) {
        AtomicFile parcelFile = new AtomicFile(parcel);     // Catch: IOException -> L18
        byte[] data = parcelFile.readFully();     // Catch: IOException -> L18
        Parcel in = Parcel.obtain();     // Catch: IOException -> L18
        in.unmarshall(data, 0, data.length);     // Catch: IOException -> L18
        in.setDataPosition(0);     // Catch: IOException -> L18
    L4:
        int token = in.readInt();     // Catch: IOException -> L18
        if (token == 0) goto L36;
        if (token != 100) goto L20;
        SyncStatusInfo status = new SyncStatusInfo(in);     // Catch: Exception -> L13
        if (this.mAuthorities.indexOfKey(status.authorityId) < 0) goto L4;
        status.pending = false;     // Catch: Exception -> L13
        this.mSyncStatus.put(status.authorityId, status);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Slog.e("SyncManager", "Unable to parse some sync status.", e);     // Catch: IOException -> L18
        goto L4
    L20:
        Slog.w("SyncManager", "Unknown status token: " + token);     // Catch: IOException -> L18
        return;
    L36:
        return;
    L22:
        Slog.i("SyncManager", "No initial status");
    }

    private void upgradeStatusIfNeededLocked() {
        File parcelStatus = new File(this.mSyncDir, LEGACY_STATUS_FILE_NAME);
        if (parcelStatus.exists() == false) goto L8;
        if (this.mStatusFile.exists() == true) goto L8;
        readStatusParcelLocked(parcelStatus);
        writeStatusLocked();
    L8:
        if (parcelStatus.exists() == true) goto L10;
        return;
    L10:
        if (this.mStatusFile.exists() == false) goto L14;
        parcelStatus.delete();
        return;
    }

    void readStatusLocked() {
        upgradeStatusIfNeededLocked();
        if (this.mStatusFile.exists() == true) goto L25;
        return;
    L25:
        FileInputStream in = this.mStatusFile.openRead();     // Catch: Exception -> L10
        readStatusInfoLocked(in);     // Catch: Throwable -> L13
        if (in == null) goto L28;
        in.close();     // Catch: Exception -> L10
        return;
    L28:
        return;
    L13:
        th = move-exception;
        if (in != null) goto L23;
    L20:
        throw th;     // Catch: Exception -> L10
    L23:
        in.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Slog.e("SyncManager", "Unable to read status info file.", e);
    }

    private void readStatusInfoLocked(InputStream in) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
    L4:
        switch(proto.nextField()) {
            case -1: goto L12;
            case 0: goto L4;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L4;
        };
    L6:
        this.mIsJobAttributionFixed = proto.readBoolean(1133871366147L);
        goto L4
    L7:
        this.mIsJobNamespaceMigrated = proto.readBoolean(1133871366146L);
        goto L4
    L8:
        long token = proto.start(2246267895809L);
        SyncStatusInfo status = readSyncStatusInfoLocked(proto);
        proto.end(token);
        if (this.mAuthorities.indexOfKey(status.authorityId) < 0) goto L4;
        status.pending = false;
        this.mSyncStatus.put(status.authorityId, status);
        goto L4
    }

    private SyncStatusInfo readSyncStatusInfoLocked(ProtoInputStream proto) throws IOException {
        if (proto.nextField(1120986464258L) == false) goto L5;
        SyncStatusInfo status = new SyncStatusInfo(proto.readInt(1120986464258L));
    L6:
        int successTimesCount = 0;
        int failureTimesCount = 0;
        ArrayList<Pair<Long, String>> lastEventInformation = new ArrayList();
    L8:
        switch(proto.nextField()) {
            case -1: goto L37;
            case 0: goto L8;
            case 1: goto L8;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L28;
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L22;
            case 13: goto L21;
            case 14: goto L20;
            case 15: goto L19;
            case 16: goto L18;
            case 17: goto L14;
            case 18: goto L10;
            default: goto L8;
        };
    L10:
        long failureTime = proto.readLong(2211908157458L);
        if (failureTimesCount == status.perSourceLastFailureTimes.length) goto L12;
        status.perSourceLastFailureTimes[failureTimesCount] = failureTime;
        failureTimesCount = failureTimesCount + 1;
        goto L8
    L12:
        Slog.w("SyncManager", "Attempted to read more per source last failure times than expected; data might be corrupted.");
        goto L8
    L14:
        long successTime = proto.readLong(2211908157457L);
        if (successTimesCount == status.perSourceLastSuccessTimes.length) goto L16;
        status.perSourceLastSuccessTimes[successTimesCount] = successTime;
        successTimesCount = successTimesCount + 1;
        goto L8
    L16:
        Slog.w("SyncManager", "Attempted to read more per source last success times than expected; data might be corrupted.");
        goto L8
    L18:
        long yesterdayStatsToken = proto.start(1146756268048L);
        readSyncStatusStatsLocked(proto, status.yesterdayStats);
        proto.end(yesterdayStatsToken);
        goto L8
    L19:
        long todayStatsToken = proto.start(1146756268047L);
        readSyncStatusStatsLocked(proto, status.todayStats);
        proto.end(todayStatsToken);
        goto L8
    L20:
        long totalStatsToken = proto.start(1146756268046L);
        readSyncStatusStatsLocked(proto, status.totalStats);
        proto.end(totalStatsToken);
        goto L8
    L21:
        status.lastTodayResetTime = proto.readLong(1112396529677L);
        goto L8
    L22:
        long eventToken = proto.start(2246267895820L);
        Pair<Long, String> lastEventInfo = parseLastEventInfoLocked(proto);
        if (lastEventInfo == null) goto L25;
        lastEventInformation.add(lastEventInfo);
    L25:
        proto.end(eventToken);
        goto L8
    L26:
        status.addPeriodicSyncTime(proto.readLong(2211908157451L));
        goto L8
    L27:
        status.initialize = proto.readBoolean(1133871366154L);
        goto L8
    L28:
        status.pending = proto.readBoolean(1133871366153L);
        goto L8
    L29:
        status.initialFailureTime = proto.readLong(1112396529672L);
        goto L8
    L30:
        status.lastFailureMesg = proto.readString(1138166333447L);
        goto L8
    L31:
        status.lastFailureSource = proto.readInt(1120986464262L);
        goto L8
    L32:
        status.lastFailureTime = proto.readLong(1112396529669L);
        goto L8
    L33:
        status.lastSuccessSource = proto.readInt(1120986464260L);
        goto L8
    L34:
        status.lastSuccessTime = proto.readLong(1112396529667L);
        goto L8
    L35:
        Slog.w("SyncManager", "Failed to read the authority id via fast-path; some data might not have been read.");
        status = new SyncStatusInfo(proto.readInt(1120986464258L), status);
        goto L8
    L37:
        status.populateLastEventsInformation(lastEventInformation);
        return status;
    L5:
        status = new SyncStatusInfo(0);
        goto L6
    }

    private Pair<Long, String> parseLastEventInfoLocked(ProtoInputStream proto) throws IOException {
        long time = 0;
        String message = null;
    L4:
        switch(proto.nextField()) {
            case -1: goto L9;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L6:
        message = proto.readString(1138166333442L);
        goto L4
    L7:
        time = proto.readLong(1112396529665L);
        goto L4
    L9:
        if (message != null) goto L12;
        return null;
    L12:
        return new Pair(Long.valueOf(time), message);
    }

    private void readSyncStatusStatsLocked(ProtoInputStream proto, SyncStatusInfo.Stats stats) throws IOException {
    L3:
        switch(proto.nextField()) {
            case -1: goto L16;
            case 0: goto L3;
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L3;
        };
    L5:
        stats.numSourceFeed = proto.readInt(1120986464266L);
        goto L3
    L6:
        stats.numSourcePeriodic = proto.readInt(1120986464265L);
        goto L3
    L7:
        stats.numSourceUser = proto.readInt(1120986464264L);
        goto L3
    L8:
        stats.numSourcePoll = proto.readInt(1120986464263L);
        goto L3
    L9:
        stats.numSourceLocal = proto.readInt(1120986464262L);
        goto L3
    L10:
        stats.numSourceOther = proto.readInt(1120986464261L);
        goto L3
    L11:
        stats.numCancels = proto.readInt(1120986464260L);
        goto L3
    L12:
        stats.numFailures = proto.readInt(1120986464259L);
        goto L3
    L13:
        stats.numSyncs = proto.readInt(1120986464258L);
        goto L3
    L14:
        stats.totalElapsedTime = proto.readLong(1112396529665L);
        goto L3
    }

    void writeStatusLocked() {
        if (Log.isLoggable(TAG_FILE, 2) == false) goto L5;
        Slog.v(TAG_FILE, "Writing new " + this.mStatusFile.getBaseFile());
    L5:
        this.mHandler.removeMessages(1);
        FileOutputStream fos = null;
        fos = this.mStatusFile.startWrite();     // Catch: Throwable -> L9 Throwable -> L11
        writeStatusInfoLocked(fos);     // Catch: Throwable -> L9 Throwable -> L11
        this.mStatusFile.finishWrite(fos);     // Catch: Throwable -> L9 Throwable -> L11
        fos = null;
    L8:
        this.mStatusFile.failWrite(fos);
        return;
    L9:
        th = move-exception;
        this.mStatusFile.failWrite(fos);
        throw th;
    L11:
        e = move-exception;
        Slog.e("SyncManager", "Unable to write sync status to proto.", e);     // Catch: Throwable -> L9
        goto L8
    }

    private void writeStatusInfoLocked(OutputStream out) {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        int size = this.mSyncStatus.size();
        int i = 0;
    L3:
        if (i >= size) goto L17;
        SyncStatusInfo info = this.mSyncStatus.valueAt(i);
        long token = proto.start(2246267895809L);
        proto.write(1120986464258L, info.authorityId);
        proto.write(1112396529667L, info.lastSuccessTime);
        proto.write(1120986464260L, info.lastSuccessSource);
        proto.write(1112396529669L, info.lastFailureTime);
        proto.write(1120986464262L, info.lastFailureSource);
        proto.write(1138166333447L, info.lastFailureMesg);
        proto.write(1112396529672L, info.initialFailureTime);
        proto.write(1133871366153L, info.pending);
        proto.write(1133871366154L, info.initialize);
        int periodicSyncTimesSize = info.getPeriodicSyncTimesSize();
        int j = 0;
    L5:
        if (j >= periodicSyncTimesSize) goto L7;
        proto.write(2211908157451L, info.getPeriodicSyncTime(j));
        j = j + 1;
        goto L5
    L7:
        int lastEventsSize = info.getEventCount();
        int j2 = 0;
    L8:
        if (j2 >= lastEventsSize) goto L10;
        long eventToken = proto.start(2246267895820L);
        proto.write(1112396529665L, info.getEventTime(j2));
        proto.write(1138166333442L, info.getEvent(j2));
        proto.end(eventToken);
        j2 = j2 + 1;
        size = size;
        goto L8
    L10:
        int size2 = size;
        proto.write(1112396529677L, info.lastTodayResetTime);
        long totalStatsToken = proto.start(1146756268046L);
        writeStatusStatsLocked(proto, info.totalStats);
        proto.end(totalStatsToken);
        long todayStatsToken = proto.start(1146756268047L);
        writeStatusStatsLocked(proto, info.todayStats);
        proto.end(todayStatsToken);
        long yesterdayStatsToken = proto.start(1146756268048L);
        writeStatusStatsLocked(proto, info.yesterdayStats);
        proto.end(yesterdayStatsToken);
        int lastSuccessTimesSize = info.perSourceLastSuccessTimes.length;
        int j3 = 0;
    L11:
        if (j3 >= lastSuccessTimesSize) goto L13;
        int j4 = j3;
        proto.write(2211908157457L, info.perSourceLastSuccessTimes[j4]);
        j3 = j4 + 1;
        periodicSyncTimesSize = periodicSyncTimesSize;
        lastEventsSize = lastEventsSize;
        goto L11
    L13:
        int lastFailureTimesSize = info.perSourceLastFailureTimes.length;
        int j5 = 0;
    L14:
        if (j5 >= lastFailureTimesSize) goto L16;
        proto.write(2211908157458L, info.perSourceLastFailureTimes[j5]);
        j5 = j5 + 1;
        lastFailureTimesSize = lastFailureTimesSize;
        goto L14
    L16:
        proto.end(token);
        i = i + 1;
        size = size2;
        goto L3
    L17:
        proto.write(1133871366146L, this.mIsJobNamespaceMigrated);
        proto.write(1133871366147L, this.mIsJobAttributionFixed);
        proto.flush();
    }

    private void writeStatusStatsLocked(ProtoOutputStream proto, SyncStatusInfo.Stats stats) {
        proto.write(1112396529665L, stats.totalElapsedTime);
        proto.write(1120986464258L, stats.numSyncs);
        proto.write(1120986464259L, stats.numFailures);
        proto.write(1120986464260L, stats.numCancels);
        proto.write(1120986464261L, stats.numSourceOther);
        proto.write(1120986464262L, stats.numSourceLocal);
        proto.write(1120986464263L, stats.numSourcePoll);
        proto.write(1120986464264L, stats.numSourceUser);
        proto.write(1120986464265L, stats.numSourcePeriodic);
        proto.write(1120986464266L, stats.numSourceFeed);
    }

    private void requestSync(AuthorityInfo authorityInfo, int reason, Bundle extras, int syncExemptionFlag, int callingUid, int callingPid) {
        if (Process.myUid() == 1000) goto L5;
    L7:
        SyncRequest.Builder req = new SyncRequest.Builder().syncOnce().setExtras(extras);
        req.setSyncAdapter(authorityInfo.target.account, authorityInfo.target.provider);
        ContentResolver.requestSync(req.build());
        return;
    L5:
        if (this.mSyncRequestListener == null) goto L7;
        this.mSyncRequestListener.onSyncRequest(authorityInfo.target, reason, extras, syncExemptionFlag, callingUid, callingPid);
    }

    private void requestSync(Account account, int userId, int reason, String authority, Bundle extras, int syncExemptionFlag, int callingUid, int callingPid) {
        if (Process.myUid() == 1000) goto L5;
    L7:
        ContentResolver.requestSync(account, authority, extras);
        return;
    L5:
        if (this.mSyncRequestListener == null) goto L7;
        this.mSyncRequestListener.onSyncRequest(new EndPoint(account, authority, userId), reason, extras, syncExemptionFlag, callingUid, callingPid);
    }

    private void readStatsParcelLocked(File parcel) {
        Parcel in = Parcel.obtain();
        AtomicFile parcelFile = new AtomicFile(parcel);     // Catch: Throwable -> L11 IOException -> L13
        byte[] data = parcelFile.readFully();     // Catch: Throwable -> L11 IOException -> L13
        in.unmarshall(data, 0, data.length);     // Catch: Throwable -> L11 IOException -> L13
        in.setDataPosition(0);     // Catch: Throwable -> L11 IOException -> L13
        int index = 0;
    L4:
        int token = in.readInt();     // Catch: Throwable -> L11 IOException -> L13
        if (token == 0) goto L24;
        if (token == 101) goto L15;
        if (token == 100) goto L15;
        Slog.w("SyncManager", "Unknown stats token: " + token);     // Catch: Throwable -> L11 IOException -> L13
    L15:
        int day = in.readInt();     // Catch: Throwable -> L11 IOException -> L13
        if (token != 100) goto L18;
        day = (day - 2009) + 14245;     // Catch: Throwable -> L11 IOException -> L13
    L18:
        DayStats ds = new DayStats(day);     // Catch: Throwable -> L11 IOException -> L13
        ds.successCount = in.readInt();     // Catch: Throwable -> L11 IOException -> L13
        ds.successTime = in.readLong();     // Catch: Throwable -> L11 IOException -> L13
        ds.failureCount = in.readInt();     // Catch: Throwable -> L11 IOException -> L13
        ds.failureTime = in.readLong();     // Catch: Throwable -> L11 IOException -> L13
        if (index >= this.mDayStats.length) goto L4;
        this.mDayStats[index] = ds;     // Catch: Throwable -> L11 IOException -> L13
        index = index + 1;
    L24:
        in.recycle();
        return;
    L11:
        th = move-exception;
        in.recycle();
        throw th;
    L26:
        Slog.i("SyncManager", "No initial statistics");     // Catch: Throwable -> L11
        goto L24
    }

    private void upgradeStatisticsIfNeededLocked() {
        File parcelStats = new File(this.mSyncDir, LEGACY_STATISTICS_FILE_NAME);
        if (parcelStats.exists() == false) goto L8;
        if (this.mStatisticsFile.exists() == true) goto L8;
        readStatsParcelLocked(parcelStats);
        writeStatisticsLocked();
    L8:
        if (parcelStats.exists() == true) goto L10;
        return;
    L10:
        if (this.mStatisticsFile.exists() == false) goto L14;
        parcelStats.delete();
        return;
    }

    private void readStatisticsLocked() {
        upgradeStatisticsIfNeededLocked();
        if (this.mStatisticsFile.exists() == true) goto L25;
        return;
    L25:
        FileInputStream in = this.mStatisticsFile.openRead();     // Catch: Exception -> L10
        readDayStatsLocked(in);     // Catch: Throwable -> L13
        if (in == null) goto L28;
        in.close();     // Catch: Exception -> L10
        return;
    L28:
        return;
    L13:
        th = move-exception;
        if (in != null) goto L23;
    L20:
        throw th;     // Catch: Exception -> L10
    L23:
        in.close();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Slog.e("SyncManager", "Unable to read day stats file.", e);
    }

    private void readDayStatsLocked(InputStream in) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
        int statsCount = 0;
    L4:
        switch(proto.nextField()) {
            case -1: goto L10;
            case 0: goto L4;
            case 1: goto L6;
            default: goto L4;
        };
    L6:
        long token = proto.start(2246267895809L);
        DayStats stats = readIndividualDayStatsLocked(proto);
        proto.end(token);
        this.mDayStats[statsCount] = stats;
        statsCount = statsCount + 1;
        if (statsCount != this.mDayStats.length) goto L4;
        return;
    }

    private DayStats readIndividualDayStatsLocked(ProtoInputStream proto) throws IOException {
        if (proto.nextField(1120986464257L) == false) goto L5;
        DayStats stats = new DayStats(proto.readInt(1120986464257L));
    L7:
        switch(proto.nextField()) {
            case -1: goto L15;
            case 0: goto L7;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            default: goto L7;
        };
    L9:
        stats.failureTime = proto.readLong(1112396529669L);
        goto L7
    L10:
        stats.failureCount = proto.readInt(1120986464260L);
        goto L7
    L11:
        stats.successTime = proto.readLong(1112396529667L);
        goto L7
    L12:
        stats.successCount = proto.readInt(1120986464258L);
        goto L7
    L13:
        Slog.w("SyncManager", "Failed to read the day via fast-path; some data might not have been read.");
        DayStats temp = new DayStats(proto.readInt(1120986464257L));
        temp.successCount = stats.successCount;
        temp.successTime = stats.successTime;
        temp.failureCount = stats.failureCount;
        temp.failureTime = stats.failureTime;
        stats = temp;
        goto L7
    L15:
        return stats;
    L5:
        stats = new DayStats(0);
        goto L7
    }

    void writeStatisticsLocked() {
        if (Log.isLoggable(TAG_FILE, 2) == false) goto L5;
        Slog.v("SyncManager", "Writing new " + this.mStatisticsFile.getBaseFile());
    L5:
        this.mHandler.removeMessages(2);
        FileOutputStream fos = null;
        fos = this.mStatisticsFile.startWrite();     // Catch: Throwable -> L9 Throwable -> L11
        writeDayStatsLocked(fos);     // Catch: Throwable -> L9 Throwable -> L11
        this.mStatisticsFile.finishWrite(fos);     // Catch: Throwable -> L9 Throwable -> L11
        fos = null;
    L8:
        this.mStatisticsFile.failWrite(fos);
        return;
    L9:
        th = move-exception;
        this.mStatisticsFile.failWrite(fos);
        throw th;
    L11:
        e = move-exception;
        Slog.e("SyncManager", "Unable to write day stats to proto.", e);     // Catch: Throwable -> L9
        goto L8
    }

    private void writeDayStatsLocked(OutputStream out) throws IOException, IllegalArgumentException {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        int size = this.mDayStats.length;
        int i = 0;
    L3:
        if (i >= size) goto L8;
        DayStats stats = this.mDayStats[i];
        if (stats == null) goto L8;
        long token = proto.start(2246267895809L);
        proto.write(1120986464257L, stats.day);
        proto.write(1120986464258L, stats.successCount);
        proto.write(1112396529667L, stats.successTime);
        proto.write(1120986464260L, stats.failureCount);
        proto.write(1112396529669L, stats.failureTime);
        proto.end(token);
        i = i + 1;
    L8:
        proto.flush();
    }

    public void queueBackup() {
        BackupManager.dataChanged(PackageManagerService.PLATFORM_PACKAGE_NAME);
    }

    public void setClockValid() {
        if (this.mIsClockValid == true) goto L6;
        this.mIsClockValid = true;
        Slog.w("SyncManager", "Clock is valid now.");
        return;
    }

    public boolean isClockValid() {
        return this.mIsClockValid;
    }

    public void resetTodayStats(boolean force) {
        if (force == false) goto L4;
        Log.w("SyncManager", "Force resetting today stats.");
    L4:
        SparseArray<AuthorityInfo> r0 = this.mAuthorities;
        monitor-enter(r0);
        int N = this.mSyncStatus.size();     // Catch: Throwable -> L9
        int i = 0;
    L7:
        if (i >= N) goto L11;
        SyncStatusInfo cur = this.mSyncStatus.valueAt(i);     // Catch: Throwable -> L9
        cur.maybeResetTodayStats(isClockValid(), force);     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L7
    L11:
        writeStatusLocked();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
