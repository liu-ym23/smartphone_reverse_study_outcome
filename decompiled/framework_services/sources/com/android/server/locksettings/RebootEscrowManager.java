package com.android.server.locksettings;

import android.content.Context;
import android.content.pm.UserInfo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.widget.RebootEscrowListener;
import com.android.server.pm.UserManagerInternal;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
class RebootEscrowManager {
    private static final int BOOT_COUNT_TOLERANCE = 5;
    private static final int DEFAULT_LOAD_ESCROW_BASE_TIMEOUT_MILLIS = 180000;
    private static final int DEFAULT_LOAD_ESCROW_DATA_RETRY_COUNT = 3;
    private static final int DEFAULT_LOAD_ESCROW_DATA_RETRY_INTERVAL_SECONDS = 30;
    private static final int DEFAULT_LOAD_ESCROW_TIMEOUT_EXTENSION_MILLIS = 5000;
    static final int ERROR_KEYSTORE_FAILURE = 7;
    static final int ERROR_LOAD_ESCROW_KEY = 3;
    static final int ERROR_NONE = 0;
    static final int ERROR_NO_NETWORK = 8;
    static final int ERROR_NO_PROVIDER = 2;
    static final int ERROR_PROVIDER_MISMATCH = 6;
    static final int ERROR_RETRY_COUNT_EXHAUSTED = 4;
    static final int ERROR_TIMEOUT_EXHAUSTED = 9;
    static final int ERROR_UNKNOWN = 1;
    static final int ERROR_UNLOCK_ALL_USERS = 5;
    static final String OTHER_VBMETA_DIGEST_PROP_NAME = "ota.other.vbmeta_digest";
    public static final String REBOOT_ESCROW_ARMED_KEY = "reboot_escrow_armed_count";
    static final String REBOOT_ESCROW_KEY_ARMED_TIMESTAMP = "reboot_escrow_key_stored_timestamp";
    static final String REBOOT_ESCROW_KEY_OTHER_VBMETA_DIGEST = "reboot_escrow_key_other_vbmeta_digest";
    static final String REBOOT_ESCROW_KEY_PROVIDER = "reboot_escrow_key_provider";
    static final String REBOOT_ESCROW_KEY_VBMETA_DIGEST = "reboot_escrow_key_vbmeta_digest";
    private static final String TAG = "RebootEscrowManager";
    static final String VBMETA_DIGEST_PROP_NAME = "ro.boot.vbmeta.digest";
    private final Callbacks mCallbacks;
    private final RebootEscrowEventLog mEventLog;
    private final Handler mHandler;
    private final Injector mInjector;
    private final Object mKeyGenerationLock;
    private final RebootEscrowKeyStoreManager mKeyStoreManager;
    private int mLoadEscrowDataErrorCode;
    private boolean mLoadEscrowDataWithRetry;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private RebootEscrowKey mPendingRebootEscrowKey;
    private RebootEscrowListener mRebootEscrowListener;
    private boolean mRebootEscrowReady;
    private boolean mRebootEscrowTimedOut;
    private boolean mRebootEscrowWanted;
    private final LockSettingsStorage mStorage;
    private final UserManager mUserManager;
    PowerManager.WakeLock mWakeLock;

    interface Callbacks {
        boolean isUserSecure(int r1);

        void onRebootEscrowRestored(byte r1, byte[] r2, int r3);
    }

    static class Injector {
        protected Context mContext;
        private final RebootEscrowKeyStoreManager mKeyStoreManager;
        private RebootEscrowProviderInterface mRebootEscrowProvider;
        private final LockSettingsStorage mStorage;
        private final UserManagerInternal mUserManagerInternal;

        Injector(Context context, LockSettingsStorage storage, UserManagerInternal userManagerInternal) {
            this.mContext = context;
            this.mStorage = storage;
            this.mKeyStoreManager = new RebootEscrowKeyStoreManager();
            this.mUserManagerInternal = userManagerInternal;
        }

        private RebootEscrowProviderInterface createRebootEscrowProvider() {
            if (serverBasedResumeOnReboot() == false) goto L5;
            Slog.i(RebootEscrowManager.TAG, "Using server based resume on reboot");
            RebootEscrowProviderInterface rebootEscrowProvider = new RebootEscrowProviderServerBasedImpl(this.mContext, this.mStorage);
        L7:
            if (rebootEscrowProvider.hasRebootEscrowSupport() == false) goto L9;
            return rebootEscrowProvider;
        L9:
            return null;
        L5:
            Slog.i(RebootEscrowManager.TAG, "Using HAL based resume on reboot");
            rebootEscrowProvider = new RebootEscrowProviderHalImpl();
            goto L7
        }

        void post(Handler handler, Runnable runnable) {
            handler.post(runnable);
        }

        void postDelayed(Handler handler, Runnable runnable, long delayMillis) {
            handler.postDelayed(runnable, delayMillis);
        }

        public boolean serverBasedResumeOnReboot() {
            if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.reboot_escrow") == true) goto L7;
            return true;
        L7:
            return DeviceConfig.getBoolean("ota", "server_based_ror_enabled", false);
        }

        public boolean isNetworkConnected() {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
            if (connectivityManager != null) goto L5;
            return false;
        L5:
            Network activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities != null) goto L8;
            return false;
        L8:
            if (networkCapabilities.hasCapability(12) == true) goto L10;
            return false;
        L10:
            if (networkCapabilities.hasCapability(16) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public boolean requestNetworkWithInternet(ConnectivityManager.NetworkCallback networkCallback) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
            if (connectivityManager != null) goto L6;
            return false;
        L6:
            NetworkRequest request = new NetworkRequest.Builder().addCapability(12).build();
            connectivityManager.requestNetwork(request, networkCallback, getLoadEscrowTimeoutMillis());
            return true;
        }

        public void stopRequestingNetwork(ConnectivityManager.NetworkCallback networkCallback) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
            if (connectivityManager != null) goto L5;
            return;
        L5:
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }

        public Context getContext() {
            return this.mContext;
        }

        public UserManager getUserManager() {
            return (UserManager) this.mContext.getSystemService("user");
        }

        public UserManagerInternal getUserManagerInternal() {
            return this.mUserManagerInternal;
        }

        public RebootEscrowKeyStoreManager getKeyStoreManager() {
            return this.mKeyStoreManager;
        }

        public RebootEscrowProviderInterface createRebootEscrowProviderIfNeeded() {
            if (this.mRebootEscrowProvider != null) goto L6;
            this.mRebootEscrowProvider = createRebootEscrowProvider();
        L6:
            return this.mRebootEscrowProvider;
        }

        PowerManager.WakeLock getWakeLock() {
            PowerManager pm = (PowerManager) this.mContext.getSystemService(PowerManager.class);
            return pm.newWakeLock(1, RebootEscrowManager.TAG);
        }

        public RebootEscrowProviderInterface getRebootEscrowProvider() {
            return this.mRebootEscrowProvider;
        }

        public void clearRebootEscrowProvider() {
            this.mRebootEscrowProvider = null;
        }

        public int getBootCount() {
            return Settings.Global.getInt(this.mContext.getContentResolver(), "boot_count", 0);
        }

        public long getCurrentTimeMillis() {
            return System.currentTimeMillis();
        }

        public int getLoadEscrowDataRetryLimit() {
            return DeviceConfig.getInt("ota", "load_escrow_data_retry_count", 3);
        }

        public int getLoadEscrowDataRetryIntervalSeconds() {
            return DeviceConfig.getInt("ota", "load_escrow_data_retry_interval_seconds", 30);
        }

        public int getLoadEscrowTimeoutMillis() {
            return RebootEscrowManager.DEFAULT_LOAD_ESCROW_BASE_TIMEOUT_MILLIS;
        }

        public int getWakeLockTimeoutMillis() {
            return getLoadEscrowTimeoutMillis() + 5000;
        }

        public void reportMetric(boolean success, int errorCode, int serviceType, int attemptCount, int escrowDurationInSeconds, int vbmetaDigestStatus, int durationSinceBootCompleteInSeconds) {
            FrameworkStatsLog.write(FrameworkStatsLog.REBOOT_ESCROW_RECOVERY_REPORTED, success, errorCode, serviceType, attemptCount, escrowDurationInSeconds, vbmetaDigestStatus, durationSinceBootCompleteInSeconds);
        }

        public RebootEscrowEventLog getEventLog() {
            return new RebootEscrowEventLog();
        }

        public String getVbmetaDigest(boolean other) {
            if (other == false) goto L5;
            return SystemProperties.get(RebootEscrowManager.OTHER_VBMETA_DIGEST_PROP_NAME);
        L5:
            return SystemProperties.get(RebootEscrowManager.VBMETA_DIGEST_PROP_NAME);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface RebootEscrowErrorCode {
    }

    public static class RebootEscrowEvent {
        static final int CLEARED_LSKF_REQUEST = 3;
        static final int FOUND_ESCROW_DATA = 1;
        static final int REQUESTED_LSKF = 5;
        static final int RETRIEVED_LSKF_FOR_USER = 7;
        static final int RETRIEVED_STORED_KEK = 4;
        static final int SET_ARMED_STATUS = 2;
        static final int STORED_LSKF_FOR_USER = 6;
        final int mEventId;
        final long mTimestamp;
        final Integer mUserId;
        final long mWallTime;

        RebootEscrowEvent(int eventId) {
            this(eventId, null);
        }

        RebootEscrowEvent(int eventId, Integer userId) {
            this.mEventId = eventId;
            this.mUserId = userId;
            this.mTimestamp = SystemClock.uptimeMillis();
            this.mWallTime = System.currentTimeMillis();
        }

        String getEventDescription() {
            switch(this.mEventId) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L5;
            };
        L6:
            return "Retrieved LSKF for user";
        L8:
            return "Stored LSKF for user";
        L10:
            return "Requested LSKF";
        L12:
            return "Retrieved stored KEK";
        L14:
            return "Cleared request for LSKF";
        L16:
            return "Set armed status";
        L18:
            return "Found escrow data";
        L5:
            return "Unknown event ID " + this.mEventId;
        }
    }

    public static class RebootEscrowEventLog {
        private RebootEscrowEvent[] mEntries;
        private int mNextIndex;

        public RebootEscrowEventLog() {
            this.mEntries = new RebootEscrowEvent[16];
            this.mNextIndex = 0;
        }

        void addEntry(int eventId) {
            addEntryInternal(new RebootEscrowEvent(eventId));
        }

        void addEntry(int eventId, int userId) {
            addEntryInternal(new RebootEscrowEvent(eventId, Integer.valueOf(userId)));
        }

        private void addEntryInternal(RebootEscrowEvent event) {
            int index = this.mNextIndex;
            this.mEntries[index] = event;
            this.mNextIndex = (this.mNextIndex + 1) % this.mEntries.length;
        }

        void dump(IndentingPrintWriter pw) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
            int i = 0;
        L4:
            if (i >= this.mEntries.length) goto L13;
            RebootEscrowEvent event = this.mEntries[(this.mNextIndex + i) % this.mEntries.length];
            if (event == null) goto L11;
            pw.print("Event #");
            pw.println(i);
            pw.println(" time=" + sdf.format(new Date(event.mWallTime)) + " (timestamp=" + event.mTimestamp + ")");
            pw.print(" event=");
            pw.println(event.getEventDescription());
            if (event.mUserId == null) goto L11;
            pw.print(" user=");
            pw.println(event.mUserId);
        L11:
            i = i + 1;
            goto L4
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Q-CnLr-XKfdjc7iQEyOLjKkHmAI, reason: not valid java name */
    public static /* synthetic */ void m5462$r8$lambda$QCnLrXKfdjc7iQEyOLjKkHmAI(RebootEscrowManager r0, boolean r1) {
        r0.lambda$setRebootEscrowReady$4(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$f8WdwaS1Kogx-iVAdeEKFEkwF28, reason: not valid java name */
    public static /* synthetic */ void m5463$r8$lambda$f8WdwaS1KogxiVAdeEKFEkwF28(RebootEscrowManager r0) {
        r0.lambda$loadRebootEscrowDataIfAvailable$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$hOBfdfn-GwwJRsbr8BMi0NbwkA4, reason: not valid java name */
    public static /* synthetic */ void m5464$r8$lambda$hOBfdfnGwwJRsbr8BMi0NbwkA4(RebootEscrowManager r0, Handler r1, int r2, List r3, List r4) {
        r0.lambda$scheduleLoadRebootEscrowDataOrFail$3(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$odHzlpU08jQ5XJFnb676M8RWte4(RebootEscrowManager r0, int r1) {
        r0.lambda$setLoadEscrowDataErrorCode$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$s13DP6Opd_6Aslp-C7d-8wPbeOU, reason: not valid java name */
    public static /* synthetic */ void m5465$r8$lambda$s13DP6Opd_6AslpC7d8wPbeOU(RebootEscrowManager r0, Handler r1, List r2, List r3) {
        r0.lambda$loadRebootEscrowDataIfAvailable$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLoadEscrowDataWithRetry, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5466$$Nest$fgetmLoadEscrowDataWithRetry(RebootEscrowManager r0) {
        return r0.mLoadEscrowDataWithRetry;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLoadEscrowDataWithRetry, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5467$$Nest$fputmLoadEscrowDataWithRetry(RebootEscrowManager r0, boolean r1) {
        r0.mLoadEscrowDataWithRetry = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcompareAndSetLoadEscrowDataErrorCode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5468$$Nest$mcompareAndSetLoadEscrowDataErrorCode(RebootEscrowManager r0, int r1, int r2, Handler r3) {
        r0.compareAndSetLoadEscrowDataErrorCode(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monGetRebootEscrowKeyFailed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5469$$Nest$monGetRebootEscrowKeyFailed(RebootEscrowManager r0, List r1, int r2, Handler r3) {
        r0.onGetRebootEscrowKeyFailed(r1, r2, r3);
    }

    RebootEscrowManager(Context context, Callbacks callbacks, LockSettingsStorage storage, Handler handler, UserManagerInternal userManagerInternal) {
        this(new Injector(context, storage, userManagerInternal), callbacks, storage, handler);
    }

    RebootEscrowManager(Injector injector, Callbacks callbacks, LockSettingsStorage storage, Handler handler) {
        this.mLoadEscrowDataErrorCode = 0;
        this.mRebootEscrowTimedOut = false;
        this.mLoadEscrowDataWithRetry = false;
        this.mKeyGenerationLock = new Object();
        this.mInjector = injector;
        this.mCallbacks = callbacks;
        this.mStorage = storage;
        this.mUserManager = injector.getUserManager();
        this.mEventLog = injector.getEventLog();
        this.mKeyStoreManager = injector.getKeyStoreManager();
        this.mHandler = handler;
    }

    private void setLoadEscrowDataErrorCode(final int value, Handler handler) {
        this.mInjector.post(handler, new RebootEscrowManager$$ExternalSyntheticLambda1(this, value));
    }

    private /* synthetic */ void lambda$setLoadEscrowDataErrorCode$0(int value) {
        this.mLoadEscrowDataErrorCode = value;
    }

    private void compareAndSetLoadEscrowDataErrorCode(int expectedValue, int newValue, Handler handler) {
        if (expectedValue != this.mLoadEscrowDataErrorCode) goto L6;
        setLoadEscrowDataErrorCode(newValue, handler);
        return;
    }

    private void onGetRebootEscrowKeyFailed(List<UserInfo> users, int attemptCount, Handler retryHandler) {
        Slog.w(TAG, "Had reboot escrow data for users, but no key; removing escrow storage.");
        Iterator<UserInfo> r0 = users.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        UserInfo user = r0.next();
        this.mStorage.removeRebootEscrow(user.id);
        goto L4
    L6:
        onEscrowRestoreComplete(false, attemptCount, retryHandler);
    }

    private List<UserInfo> getUsersToUnlock(List<UserInfo> users) {
        if (this.mCallbacks.isUserSecure(0) == true) goto L5;
    L8:
        Set<Integer> noEscrowDataUsers = new HashSet();
        Iterator<UserInfo> r1 = users.iterator();
    L10:
        if (r1.hasNext() == false) goto L17;
        UserInfo user = r1.next();
        if (this.mCallbacks.isUserSecure(user.id) == false) goto L10;
        if (this.mStorage.hasRebootEscrow(user.id) == true) goto L10;
        Slog.d(TAG, "No reboot escrow data found for user " + user);
        noEscrowDataUsers.add(Integer.valueOf(user.id));
        goto L10
    L17:
        List<UserInfo> rebootEscrowUsers = new ArrayList();
        Iterator<UserInfo> r2 = users.iterator();
    L19:
        if (r2.hasNext() == false) goto L29;
        UserInfo user2 = r2.next();
        if (this.mCallbacks.isUserSecure(user2.id) == false) goto L19;
        int userId = user2.id;
        if (noEscrowDataUsers.contains(Integer.valueOf(userId)) == true) goto L19;
        if (noEscrowDataUsers.contains(Integer.valueOf(this.mInjector.getUserManagerInternal().getProfileParentId(userId))) == true) goto L19;
        rebootEscrowUsers.add(user2);
        goto L19
    L29:
        return rebootEscrowUsers;
    L5:
        if (this.mStorage.hasRebootEscrow(0) == true) goto L8;
        Slog.i(TAG, "No reboot escrow data found for system user");
        return Collections.emptyList();
    }

    void loadRebootEscrowDataIfAvailable(final Handler retryHandler) {
        final List users = this.mUserManager.getUsers();
        final List<UserInfo> rebootEscrowUsers = getUsersToUnlock(users);
        if (rebootEscrowUsers.isEmpty() == false) goto L6;
        Slog.i(TAG, "No reboot escrow data found for users, skipping loading escrow data");
        clearMetricsStorage();
        return;
    L6:
        this.mWakeLock = this.mInjector.getWakeLock();
        if (this.mWakeLock == null) goto L9;
        this.mWakeLock.setReferenceCounted(false);
        this.mWakeLock.acquire(this.mInjector.getWakeLockTimeoutMillis());
    L9:
        this.mInjector.postDelayed(retryHandler, new RebootEscrowManager$$ExternalSyntheticLambda2(this), this.mInjector.getLoadEscrowTimeoutMillis());
        this.mInjector.post(retryHandler, new RebootEscrowManager$$ExternalSyntheticLambda3(this, retryHandler, users, rebootEscrowUsers));
    }

    private /* synthetic */ void lambda$loadRebootEscrowDataIfAvailable$1() {
        this.mRebootEscrowTimedOut = true;
    }

    private /* synthetic */ void lambda$loadRebootEscrowDataIfAvailable$2(Handler retryHandler, List users, List rebootEscrowUsers) {
        loadRebootEscrowDataOnInternet(retryHandler, users, rebootEscrowUsers);
    }

    void scheduleLoadRebootEscrowDataOrFail(final Handler retryHandler, final int attemptNumber, final List<UserInfo> users, final List<UserInfo> rebootEscrowUsers) {
        retryHandler.getClass();
        int retryLimit = this.mInjector.getLoadEscrowDataRetryLimit();
        int retryIntervalInSeconds = this.mInjector.getLoadEscrowDataRetryIntervalSeconds();
        if (attemptNumber >= retryLimit) goto L9;
        if (this.mRebootEscrowTimedOut == true) goto L9;
        Slog.i(TAG, "Scheduling loadRebootEscrowData retry number: " + attemptNumber);
        this.mInjector.postDelayed(retryHandler, new RebootEscrowManager$$ExternalSyntheticLambda4(this, retryHandler, attemptNumber, users, rebootEscrowUsers), (long) (retryIntervalInSeconds * 1000));
        return;
    L9:
        if (this.mRebootEscrowTimedOut == false) goto L11;
        Slog.w(TAG, "Failed to load reboot escrow data within timeout");
        compareAndSetLoadEscrowDataErrorCode(0, 9, retryHandler);
    L12:
        onGetRebootEscrowKeyFailed(users, attemptNumber, retryHandler);
        return;
    L11:
        Slog.w(TAG, "Failed to load reboot escrow data after " + attemptNumber + " attempts");
        compareAndSetLoadEscrowDataErrorCode(0, 4, retryHandler);
        goto L12
    }

    private /* synthetic */ void lambda$scheduleLoadRebootEscrowDataOrFail$3(Handler retryHandler, int attemptNumber, List users, List rebootEscrowUsers) {
        loadRebootEscrowDataWithRetry(retryHandler, attemptNumber, users, rebootEscrowUsers);
    }

    void loadRebootEscrowDataOnInternet(final Handler retryHandler, final List<UserInfo> users, final List<UserInfo> rebootEscrowUsers) {
        if (this.mInjector.serverBasedResumeOnReboot() == true) goto L6;
        loadRebootEscrowDataWithRetry(retryHandler, 0, users, rebootEscrowUsers);
        return;
    L6:
        this.mNetworkCallback = new AnonymousClass1(this, retryHandler, users, rebootEscrowUsers);
        boolean success = this.mInjector.requestNetworkWithInternet(this.mNetworkCallback);
        if (success == true) goto L10;
        loadRebootEscrowDataWithRetry(retryHandler, 0, users, rebootEscrowUsers);
        return;
    }

    void loadRebootEscrowDataWithRetry(Handler retryHandler, int attemptNumber, List<UserInfo> users, List<UserInfo> rebootEscrowUsers) {
        SecretKey kk = this.mKeyStoreManager.getKeyStoreEncryptionKey();
        if (kk != null) goto L31;
        Slog.i(TAG, "Failed to load the key for resume on reboot from key store.");
    L31:
        RebootEscrowKey escrowKey = getAndClearRebootEscrowKey(kk, retryHandler);     // Catch: IOException -> L28
        int providerType = 1;
        if (escrowKey == null) goto L9;
        this.mEventLog.addEntry(1);
        boolean allUsersUnlocked = true;
        Iterator<UserInfo> r4 = rebootEscrowUsers.iterator();
    L22:
        if (r4.hasNext() == false) goto L24;
        UserInfo user = r4.next();
        allUsersUnlocked = allUsersUnlocked & restoreRebootEscrowForUser(user.id, escrowKey, kk);
        goto L22
    L24:
        if (allUsersUnlocked == true) goto L26;
        compareAndSetLoadEscrowDataErrorCode(0, 5, retryHandler);
    L26:
        onEscrowRestoreComplete(allUsersUnlocked, attemptNumber + 1, retryHandler);
        return;
    L9:
        if (this.mLoadEscrowDataErrorCode == 0) goto L11;
    L18:
        onGetRebootEscrowKeyFailed(users, attemptNumber + 1, retryHandler);
        return;
    L11:
        if (this.mInjector.serverBasedResumeOnReboot() == true) goto L15;
        providerType = 0;
    L15:
        if (providerType == this.mStorage.getInt(REBOOT_ESCROW_KEY_PROVIDER, -1, 0)) goto L17;
        setLoadEscrowDataErrorCode(6, retryHandler);
        goto L18
    L17:
        setLoadEscrowDataErrorCode(3, retryHandler);
    L28:
        e = move-exception;
        Slog.i(TAG, "Failed to load escrow key, scheduling retry.", e);
        scheduleLoadRebootEscrowDataOrFail(retryHandler, attemptNumber + 1, users, rebootEscrowUsers);
    }

    private void clearMetricsStorage() {
        this.mStorage.removeKey(REBOOT_ESCROW_ARMED_KEY, 0);
        this.mStorage.removeKey(REBOOT_ESCROW_KEY_ARMED_TIMESTAMP, 0);
        this.mStorage.removeKey(REBOOT_ESCROW_KEY_VBMETA_DIGEST, 0);
        this.mStorage.removeKey(REBOOT_ESCROW_KEY_OTHER_VBMETA_DIGEST, 0);
        this.mStorage.removeKey(REBOOT_ESCROW_KEY_PROVIDER, 0);
    }

    private int getVbmetaDigestStatusOnRestoreComplete() {
        String currentVbmetaDigest = this.mInjector.getVbmetaDigest(false);
        String vbmetaDigestStored = this.mStorage.getString(REBOOT_ESCROW_KEY_VBMETA_DIGEST, "", 0);
        String vbmetaDigestOtherStored = this.mStorage.getString(REBOOT_ESCROW_KEY_OTHER_VBMETA_DIGEST, "", 0);
        if (vbmetaDigestOtherStored.isEmpty() == false) goto L9;
        if (currentVbmetaDigest.equals(vbmetaDigestStored) == false) goto L7;
        return 0;
    L7:
        return 2;
    L9:
        if (currentVbmetaDigest.equals(vbmetaDigestOtherStored) == false) goto L12;
        return 0;
    L12:
        if (currentVbmetaDigest.equals(vbmetaDigestStored) == false) goto L15;
        return 1;
    L15:
        return 2;
    }

    private void reportMetricOnRestoreComplete(boolean success, int attemptCount, Handler retryHandler) {
        if (this.mInjector.serverBasedResumeOnReboot() == false) goto L5;
        int serviceType = 2;
    L6:
        long armedTimestamp = this.mStorage.getLong(REBOOT_ESCROW_KEY_ARMED_TIMESTAMP, -1, 0);
        long currentTimeStamp = this.mInjector.getCurrentTimeMillis();
        if (armedTimestamp != (-1)) goto L9;
    L11:
        int escrowDurationInSeconds = -1;
    L12:
        int vbmetaDigestStatus = getVbmetaDigestStatusOnRestoreComplete();
        if (success == true) goto L15;
        compareAndSetLoadEscrowDataErrorCode(0, 1, retryHandler);
    L15:
        Slog.i(TAG, "Reporting RoR recovery metrics, success: " + success + ", service type: " + serviceType + ", error code: " + this.mLoadEscrowDataErrorCode);
        this.mInjector.reportMetric(success, this.mLoadEscrowDataErrorCode, serviceType, attemptCount, escrowDurationInSeconds, vbmetaDigestStatus, -1);
        setLoadEscrowDataErrorCode(0, retryHandler);
        return;
    L9:
        if (currentTimeStamp <= armedTimestamp) goto L11;
        int escrowDurationInSeconds2 = ((int) (currentTimeStamp - armedTimestamp)) / 1000;
        escrowDurationInSeconds = escrowDurationInSeconds2;
        goto L12
    L5:
        serviceType = 1;
        goto L6
    }

    private void onEscrowRestoreComplete(boolean success, int attemptCount, Handler retryHandler) {
        int previousBootCount = this.mStorage.getInt(REBOOT_ESCROW_ARMED_KEY, -1, 0);
        int bootCountDelta = this.mInjector.getBootCount() - previousBootCount;
        if (success == true) goto L7;
        if (previousBootCount != (-1)) goto L6;
    L8:
        this.mKeyStoreManager.clearKeyStoreEncryptionKey();
        this.mInjector.clearRebootEscrowProvider();
        clearMetricsStorage();
        if (this.mNetworkCallback == null) goto L12;
        this.mInjector.stopRequestingNetwork(this.mNetworkCallback);
    L12:
        if (this.mWakeLock == null) goto L15;
        this.mWakeLock.release();
        return;
    L15:
        return;
    L6:
        if (bootCountDelta > 5) goto L8;
    L7:
        reportMetricOnRestoreComplete(success, attemptCount, retryHandler);
        goto L8
    }

    private RebootEscrowKey getAndClearRebootEscrowKey(SecretKey kk, Handler retryHandler) throws IOException {
        RebootEscrowProviderInterface rebootEscrowProvider = this.mInjector.createRebootEscrowProviderIfNeeded();
        if (rebootEscrowProvider != null) goto L7;
        Slog.w(TAG, "Had reboot escrow data for users, but RebootEscrowProvider is unavailable");
        setLoadEscrowDataErrorCode(2, retryHandler);
        return null;
    L7:
        if (rebootEscrowProvider.getType() != 1) goto L11;
        if (kk != null) goto L11;
        setLoadEscrowDataErrorCode(7, retryHandler);
        return null;
    L11:
        RebootEscrowKey key = rebootEscrowProvider.getAndClearRebootEscrowKey(kk);
        if (key == null) goto L14;
        this.mEventLog.addEntry(4);
    L14:
        return key;
    }

    private boolean restoreRebootEscrowForUser(int userId, RebootEscrowKey ks, SecretKey kk) {
        if (this.mStorage.hasRebootEscrow(userId) == true) goto L11;
        return false;
    L11:
        byte[] blob = this.mStorage.readRebootEscrow(userId);     // Catch: IOException -> L8
        this.mStorage.removeRebootEscrow(userId);     // Catch: IOException -> L8
        RebootEscrowData escrowData = RebootEscrowData.fromEncryptedData(ks, blob, kk);     // Catch: IOException -> L8
        this.mCallbacks.onRebootEscrowRestored(escrowData.getSpVersion(), escrowData.getSyntheticPassword(), userId);     // Catch: IOException -> L8
        Slog.i(TAG, "Restored reboot escrow data for user " + userId);     // Catch: IOException -> L8
        this.mEventLog.addEntry(7, userId);     // Catch: IOException -> L8
        return true;
    L8:
        e = move-exception;
        Slog.w(TAG, "Could not load reboot escrow data for user " + userId, e);
        return false;
    }

    void callToRebootEscrowIfNeeded(int userId, byte spVersion, byte[] syntheticPassword) {
        if (this.mRebootEscrowWanted == true) goto L6;
        return;
    L6:
        if (this.mInjector.createRebootEscrowProviderIfNeeded() != null) goto L9;
        Slog.w(TAG, "Not storing escrow data, RebootEscrowProvider is unavailable");
        return;
    L9:
        RebootEscrowKey escrowKey = generateEscrowKeyIfNeeded();
        if (escrowKey != null) goto L13;
        Slog.e(TAG, "Could not generate escrow key");
        return;
    L13:
        SecretKey kk = this.mKeyStoreManager.generateKeyStoreEncryptionKeyIfNeeded();
        if (kk != null) goto L23;
        Slog.e(TAG, "Failed to generate encryption key from keystore.");
        return;
    L23:
        RebootEscrowData escrowData = RebootEscrowData.fromSyntheticPassword(escrowKey, spVersion, syntheticPassword, kk);     // Catch: IOException -> L20
        this.mStorage.writeRebootEscrow(userId, escrowData.getBlob());
        this.mEventLog.addEntry(6, userId);
        setRebootEscrowReady(true);
        return;
    L20:
        e = move-exception;
        setRebootEscrowReady(false);
        Slog.w(TAG, "Could not escrow reboot data", e);
    }

    private RebootEscrowKey generateEscrowKeyIfNeeded() {
        Object r0 = this.mKeyGenerationLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingRebootEscrowKey == null) goto L22;
        RebootEscrowKey r1 = this.mPendingRebootEscrowKey;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L22:
        RebootEscrowKey key = RebootEscrowKey.generate();     // Catch: Throwable -> L9 IOException -> L15
        this.mPendingRebootEscrowKey = key;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return key;
    L16:
        Slog.w(TAG, "Could not generate reboot escrow key");     // Catch: Throwable -> L9
        return null;
    }

    private void clearRebootEscrowIfNeeded() {
        this.mRebootEscrowWanted = false;
        setRebootEscrowReady(false);
        RebootEscrowProviderInterface rebootEscrowProvider = this.mInjector.createRebootEscrowProviderIfNeeded();
        if (rebootEscrowProvider != null) goto L5;
        Slog.w(TAG, "RebootEscrowProvider is unavailable for clear request");
    L6:
        this.mInjector.clearRebootEscrowProvider();
        clearMetricsStorage();
        List<UserInfo> users = this.mUserManager.getUsers();
        Iterator<UserInfo> r2 = users.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        UserInfo user = r2.next();
        this.mStorage.removeRebootEscrow(user.id);
        goto L8
    L10:
        this.mEventLog.addEntry(3);
        return;
    L5:
        rebootEscrowProvider.clearRebootEscrowKey();
        goto L6
    }

    int armRebootEscrowIfNeeded() {
        if (this.mRebootEscrowReady == true) goto L5;
        return 2;
    L5:
        RebootEscrowProviderInterface rebootEscrowProvider = this.mInjector.getRebootEscrowProvider();
        if (rebootEscrowProvider != null) goto L10;
        Slog.w(TAG, "Not storing escrow key, RebootEscrowProvider is unavailable");
        clearRebootEscrowIfNeeded();
        return 3;
    L10:
        if (this.mInjector.serverBasedResumeOnReboot() == false) goto L12;
        int expectedProviderType = 1;
    L13:
        int actualProviderType = rebootEscrowProvider.getType();
        if (expectedProviderType == actualProviderType) goto L17;
        Slog.w(TAG, "Expect reboot escrow provider " + expectedProviderType + ", but the RoR is prepared with " + actualProviderType + ". Please prepare the RoR again.");
        clearRebootEscrowIfNeeded();
        return 4;
    L17:
        Object r6 = this.mKeyGenerationLock;
        monitor-enter(r6);
        RebootEscrowKey escrowKey = this.mPendingRebootEscrowKey;     // Catch: Throwable -> L34
        monitor-exit(r6);     // Catch: Throwable -> L34
        if (escrowKey != null) goto L24;
        Slog.e(TAG, "Escrow key is null, but escrow was marked as ready");
        clearRebootEscrowIfNeeded();
        return 5;
    L24:
        SecretKey kk = this.mKeyStoreManager.getKeyStoreEncryptionKey();
        if (kk != null) goto L28;
        Slog.e(TAG, "Failed to get encryption key from keystore.");
        clearRebootEscrowIfNeeded();
        return 6;
    L28:
        boolean armedRebootEscrow = rebootEscrowProvider.storeRebootEscrowKey(escrowKey, kk);
        if (armedRebootEscrow == true) goto L32;
        return 7;
    L32:
        this.mStorage.setInt(REBOOT_ESCROW_ARMED_KEY, this.mInjector.getBootCount(), 0);
        this.mStorage.setLong(REBOOT_ESCROW_KEY_ARMED_TIMESTAMP, this.mInjector.getCurrentTimeMillis(), 0);
        this.mStorage.setString(REBOOT_ESCROW_KEY_VBMETA_DIGEST, this.mInjector.getVbmetaDigest(false), 0);
        this.mStorage.setString(REBOOT_ESCROW_KEY_OTHER_VBMETA_DIGEST, this.mInjector.getVbmetaDigest(true), 0);
        this.mStorage.setInt(REBOOT_ESCROW_KEY_PROVIDER, actualProviderType, 0);
        this.mEventLog.addEntry(2);
        return 0;
    L34:
        th = move-exception;
        throw th;
    L12:
        expectedProviderType = 0;
        goto L13
    }

    private void setRebootEscrowReady(final boolean ready) {
        if (this.mRebootEscrowReady == ready) goto L5;
        this.mHandler.post(new RebootEscrowManager$$ExternalSyntheticLambda0(this, ready));
    L5:
        this.mRebootEscrowReady = ready;
    }

    private /* synthetic */ void lambda$setRebootEscrowReady$4(boolean ready) {
        this.mRebootEscrowListener.onPreparedForReboot(ready);
    }

    boolean prepareRebootEscrow() {
        clearRebootEscrowIfNeeded();
        if (this.mInjector.createRebootEscrowProviderIfNeeded() != null) goto L6;
        Slog.w(TAG, "No reboot escrow provider, skipping resume on reboot preparation.");
        return false;
    L6:
        this.mRebootEscrowWanted = true;
        this.mEventLog.addEntry(5);
        return true;
    }

    boolean clearRebootEscrow() {
        clearRebootEscrowIfNeeded();
        return true;
    }

    void setRebootEscrowListener(RebootEscrowListener listener) {
        this.mRebootEscrowListener = listener;
    }

    void dump(IndentingPrintWriter pw) {
        pw.print("mRebootEscrowWanted=");
        pw.println(this.mRebootEscrowWanted);
        pw.print("mRebootEscrowReady=");
        pw.println(this.mRebootEscrowReady);
        pw.print("mRebootEscrowListener=");
        pw.println(this.mRebootEscrowListener);
        pw.print("mLoadEscrowDataErrorCode=");
        pw.println(this.mLoadEscrowDataErrorCode);
        Object r0 = this.mKeyGenerationLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingRebootEscrowKey == null) goto L7;
        boolean keySet = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L19
        pw.print("mPendingRebootEscrowKey is ");
        if (keySet == false) goto L12;
        String r1 = "set";
    L13:
        pw.println(r1);
        RebootEscrowProviderInterface provider = this.mInjector.getRebootEscrowProvider();
        if (provider != null) goto L16;
        String providerType = "null";
    L17:
        pw.print("RebootEscrowProvider type is " + providerType);
        pw.println();
        pw.println("Event log:");
        pw.increaseIndent();
        this.mEventLog.dump(pw);
        pw.println();
        pw.decreaseIndent();
        return;
    L16:
        providerType = String.valueOf(provider.getType());
        goto L17
    L12:
        r1 = "not set";
        goto L13
    L7:
        keySet = false;
        goto L8
    }
}
