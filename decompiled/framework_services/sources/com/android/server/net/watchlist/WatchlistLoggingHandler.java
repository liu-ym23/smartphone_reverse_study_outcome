package com.android.server.net.watchlist;

import android.R;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.incremental.IncrementalManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.HexDump;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
class WatchlistLoggingHandler extends Handler {
    private static final boolean DEBUG = false;
    private static final String DROPBOX_TAG = "network_watchlist_report";
    static final int FORCE_REPORT_RECORDS_NOW_FOR_TEST_MSG = 3;
    static final int LOG_WATCHLIST_EVENT_MSG = 1;
    private static final long ONE_DAY_MS = 0;
    static final int REPORT_RECORDS_IF_NECESSARY_MSG = 2;
    private static final String TAG = null;
    private final FileHashCache mApkHashCache;
    private final ConcurrentHashMap<Integer, byte[]> mCachedUidDigestMap;
    private final WatchlistConfig mConfig;
    private final Context mContext;
    private final WatchlistReportDbHelper mDbHelper;
    private final DropBoxManager mDropBoxManager;
    private final PackageManager mPm;
    private int mPrimaryUserId;
    private final ContentResolver mResolver;
    private final WatchlistSettings mSettings;

    private interface WatchlistEventKeys {
        public static final String HOST = "host";
        public static final String IP_ADDRESSES = "ipAddresses";
        public static final String TIMESTAMP = "timestamp";
        public static final String UID = "uid";
    }

    public static /* synthetic */ byte[] $r8$lambda$3oa898EmmfbArBKuLLrphHZzvag(WatchlistLoggingHandler r0, int r1, Integer r2) {
        return r0.lambda$getDigestFromUid$0(r1, r2);
    }

    static {
        TAG = WatchlistLoggingHandler.class.getSimpleName();
        ONE_DAY_MS = TimeUnit.DAYS.toMillis(1);
    }

    WatchlistLoggingHandler(Context context, Looper looper) {
        super(looper);
        this.mPrimaryUserId = -1;
        this.mCachedUidDigestMap = new ConcurrentHashMap();
        this.mContext = context;
        this.mPm = this.mContext.getPackageManager();
        this.mResolver = this.mContext.getContentResolver();
        this.mDbHelper = WatchlistReportDbHelper.getInstance(context);
        this.mConfig = WatchlistConfig.getInstance();
        this.mSettings = WatchlistSettings.getInstance();
        this.mDropBoxManager = (DropBoxManager) this.mContext.getSystemService(DropBoxManager.class);
        this.mPrimaryUserId = getPrimaryUserId();
        if (context.getResources().getBoolean(R.bool.config_wirelessConsentRequired) == false) goto L5;
        this.mApkHashCache = new FileHashCache(this);
        Slog.i(TAG, "Using file hashes cache.");
        return;
    L5:
        this.mApkHashCache = null;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        Slog.d(TAG, "WatchlistLoggingHandler received an unknown of message.");
        return;
    L9:
        tryAggregateRecords(getLastMidnightTime());
        return;
    L10:
        Bundle data = msg.getData();
        handleNetworkEvent(data.getString("host"), data.getStringArray(WatchlistEventKeys.IP_ADDRESSES), data.getInt("uid"), data.getLong("timestamp"));
        return;
    L6:
        if ((msg.obj instanceof Long) == false) goto L8;
        long lastRecordTime = ((Long) msg.obj).longValue();
        tryAggregateRecords(lastRecordTime);
        return;
    L8:
        Slog.e(TAG, "Msg.obj needs to be a Long object.");
    }

    private int getPrimaryUserId() {
        UserInfo primaryUserInfo = ((UserManager) this.mContext.getSystemService("user")).getPrimaryUser();
        if (primaryUserInfo != null) goto L5;
        return -1;
    L5:
        return primaryUserInfo.id;
    }

    private boolean isPackageTestOnly(int uid) {
        String[] packageNames = this.mPm.getPackagesForUid(uid);     // Catch: PackageManager.NameNotFoundException -> L13
        if (packageNames == null) goto L15;
        if (packageNames.length == 0) goto L15;
        ApplicationInfo ai = this.mPm.getApplicationInfo(packageNames[0], 0);     // Catch: PackageManager.NameNotFoundException -> L13
        if ((ai.flags & 256) == 0) goto L20;
        return true;
    L20:
        return false;
    L15:
        Slog.e(TAG, "Couldn't find package: " + Arrays.toString(packageNames));     // Catch: PackageManager.NameNotFoundException -> L13
        return false;
    L18:
        return false;
    }

    public void reportWatchlistIfNecessary() {
        Message msg = obtainMessage(2);
        sendMessage(msg);
    }

    public void forceReportWatchlistForTest(long lastReportTime) {
        Message msg = obtainMessage(3);
        msg.obj = Long.valueOf(lastReportTime);
        sendMessage(msg);
    }

    public void asyncNetworkEvent(String host, String[] ipAddresses, int uid) {
        Message msg = obtainMessage(1);
        Bundle bundle = new Bundle();
        bundle.putString("host", host);
        bundle.putStringArray(WatchlistEventKeys.IP_ADDRESSES, ipAddresses);
        bundle.putInt("uid", uid);
        bundle.putLong("timestamp", System.currentTimeMillis());
        msg.setData(bundle);
        sendMessage(msg);
    }

    private void handleNetworkEvent(String hostname, String[] ipAddresses, int uid, long timestamp) {
        if (this.mPrimaryUserId != (-1)) goto L6;
        this.mPrimaryUserId = getPrimaryUserId();
    L6:
        if (UserHandle.getUserId(uid) == this.mPrimaryUserId) goto L8;
        return;
    L8:
        String cncDomain = searchAllSubDomainsInWatchlist(hostname);
        if (cncDomain == null) goto L11;
        insertRecord(uid, cncDomain, timestamp);
        return;
    L11:
        String cncIp = searchIpInWatchlist(ipAddresses);
        if (cncIp == null) goto L16;
        insertRecord(uid, cncIp, timestamp);
        return;
    }

    private void insertRecord(int uid, String cncHost, long timestamp) {
        if (this.mConfig.isConfigSecure() == false) goto L5;
    L7:
        byte[] digest = getDigestFromUid(uid);
        if (digest != null) goto L11;
        return;
    L11:
        if (this.mDbHelper.insertNewRecord(digest, cncHost, timestamp) == false) goto L14;
        Slog.w(TAG, "Unable to insert record for uid: " + uid);
        return;
    L14:
        return;
    L5:
        if (isPackageTestOnly(uid) == true) goto L7;
    }

    private boolean shouldReportNetworkWatchlist(long lastRecordTime) {
        long lastReportTime = Settings.Global.getLong(this.mResolver, "network_watchlist_last_report_time", 0);
        if (lastRecordTime >= lastReportTime) goto L7;
        Slog.i(TAG, "Last report time is larger than current time, reset report");
        this.mDbHelper.cleanup(lastReportTime);
        return false;
    L7:
        if (lastRecordTime < (ONE_DAY_MS + lastReportTime)) goto L10;
        return true;
    L10:
        return false;
    }

    private void tryAggregateRecords(long lastRecordTime) {
        long startTime = System.currentTimeMillis();
    L8:
        th = move-exception;
        long endTime = System.currentTimeMillis();
        Slog.i(TAG, "Milliseconds spent on tryAggregateRecords(): " + (endTime - startTime));
        throw th;
    L4:
        if (shouldReportNetworkWatchlist(lastRecordTime) == true) goto L10;
        Slog.i(TAG, "No need to aggregate record yet.");     // Catch: Throwable -> L8
        long endTime2 = System.currentTimeMillis();
        Slog.i(TAG, "Milliseconds spent on tryAggregateRecords(): " + (endTime2 - startTime));
        return;
    L10:
        Slog.i(TAG, "Start aggregating watchlist records.");     // Catch: Throwable -> L8
        if (this.mDropBoxManager != null) goto L13;
    L23:
        Slog.w(TAG, "Network Watchlist dropbox tag is not enabled");     // Catch: Throwable -> L8
    L24:
        this.mDbHelper.cleanup(lastRecordTime);     // Catch: Throwable -> L8
        long endTime3 = System.currentTimeMillis();
        Slog.i(TAG, "Milliseconds spent on tryAggregateRecords(): " + (endTime3 - startTime));
        return;
    L13:
        if (this.mDropBoxManager.isTagEnabled(DROPBOX_TAG) == false) goto L23;
        Settings.Global.putLong(this.mResolver, "network_watchlist_last_report_time", lastRecordTime);     // Catch: Throwable -> L8
        WatchlistReportDbHelper.AggregatedResult aggregatedResult = this.mDbHelper.getAggregatedRecords(lastRecordTime);     // Catch: Throwable -> L8
        if (aggregatedResult != null) goto L19;
        Slog.i(TAG, "Cannot get result from database");     // Catch: Throwable -> L8
        long endTime4 = System.currentTimeMillis();
        Slog.i(TAG, "Milliseconds spent on tryAggregateRecords(): " + (endTime4 - startTime));
        return;
    L19:
        List<String> digestsForReport = getAllDigestsForReport(aggregatedResult);     // Catch: Throwable -> L8
        byte[] secretKey = this.mSettings.getPrivacySecretKey();     // Catch: Throwable -> L8
        byte[] encodedResult = ReportEncoder.encodeWatchlistReport(this.mConfig, secretKey, digestsForReport, aggregatedResult);     // Catch: Throwable -> L8
        if (encodedResult == null) goto L24;
        addEncodedReportToDropBox(encodedResult);     // Catch: Throwable -> L8
        goto L24
    }

    List<String> getAllDigestsForReport(WatchlistReportDbHelper.AggregatedResult record) {
        List<ApplicationInfo> apps = this.mContext.getPackageManager().getInstalledApplications(131072);
        HashSet<String> result = new HashSet(apps.size() + record.appDigestCNCList.size());
        int size = apps.size();
        int i = 0;
    L3:
        if (i >= size) goto L8;
        byte[] digest = getDigestFromUid(apps.get(i).uid);
        if (digest == null) goto L7;
        result.add(HexDump.toHexString(digest));
    L7:
        i = i + 1;
        goto L3
    L8:
        result.addAll(record.appDigestCNCList.keySet());
        return new ArrayList(result);
    }

    private void addEncodedReportToDropBox(byte[] encodedReport) {
        this.mDropBoxManager.addData(DROPBOX_TAG, encodedReport, 0);
    }

    private byte[] getDigestFromUid(final int uid) {
        return this.mCachedUidDigestMap.computeIfAbsent(Integer.valueOf(uid), new WatchlistLoggingHandler$$ExternalSyntheticLambda0(this, uid));
    }

    private /* synthetic */ byte[] lambda$getDigestFromUid$0(int uid, Integer key) {
        String[] packageNames = this.mPm.getPackagesForUid(key.intValue());
        int userId = UserHandle.getUserId(uid);
        if (ArrayUtils.isEmpty(packageNames) == true) goto L24;
        int r2 = packageNames.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L24;
        String packageName = packageNames[r4];
        String apkPath = this.mPm.getPackageInfoAsUser(packageName, 786432, userId).applicationInfo.publicSourceDir;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(apkPath) == false) goto L14;
        Slog.w(TAG, "Cannot find apkPath for " + packageName);     // Catch: Throwable -> L11
    L16:
        r4 = r4 + 1;     // Catch: Throwable -> L11
        goto L6
    L14:
        if (IncrementalManager.isIncrementalPath(apkPath) == false) goto L18;
        Slog.i(TAG, "Skipping incremental path: " + packageName);     // Catch: Throwable -> L11
        goto L16
    L18:
        if (this.mApkHashCache == null) goto L21;
        return this.mApkHashCache.getSha256Hash(new File(apkPath));
    L21:
        return DigestUtils.getSha256Hash(new File(apkPath));
    L11:
        e = move-exception;
        Slog.e(TAG, "Cannot get digest from uid: " + key + ",pkg: " + packageName, e);
        return null;
    L24:
        return null;
    }

    private String searchIpInWatchlist(String[] ipAddresses) {
        int r0 = ipAddresses.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String ipAddress = ipAddresses[r1];
        if (isIpInWatchlist(ipAddress) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return ipAddress;
    L8:
        return null;
    }

    private boolean isIpInWatchlist(String ipAddr) {
        if (ipAddr != null) goto L6;
        return false;
    L6:
        return this.mConfig.containsIp(ipAddr);
    }

    private boolean isHostInWatchlist(String host) {
        if (host != null) goto L6;
        return false;
    L6:
        return this.mConfig.containsDomain(host);
    }

    private String searchAllSubDomainsInWatchlist(String host) {
        if (host != null) goto L5;
        return null;
    L5:
        String[] subDomains = getAllSubDomains(host);
        int r2 = subDomains.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L11;
        String subDomain = subDomains[r3];
        if (isHostInWatchlist(subDomain) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return subDomain;
    L11:
        return null;
    }

    static String[] getAllSubDomains(String host) {
        if (host != null) goto L5;
        return null;
    L5:
        ArrayList<String> subDomainList = new ArrayList();
        subDomainList.add(host);
        int index = host.indexOf(".");
    L7:
        if (index == (-1)) goto L13;
        host = host.substring(index + 1);
        if (TextUtils.isEmpty(host) == true) goto L11;
        subDomainList.add(host);
    L11:
        index = host.indexOf(".");
        goto L7
    L13:
        return (String[]) subDomainList.toArray(new String[0]);
    }

    static long getLastMidnightTime() {
        return getMidnightTimestamp(0);
    }

    static long getMidnightTimestamp(int daysBefore) {
        Calendar date = new GregorianCalendar();
        date.set(11, 0);
        date.set(12, 0);
        date.set(13, 0);
        date.set(14, 0);
        date.add(5, -daysBefore);
        return date.getTimeInMillis();
    }
}
