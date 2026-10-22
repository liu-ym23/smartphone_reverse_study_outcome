package com.android.server.storage;

import android.app.usage.CacheQuotaHint;
import android.app.usage.ICacheQuotaService;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.Environment;
import android.os.RemoteCallback;
import android.os.StatFs;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseLongArray;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.Installer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class CacheQuotaStrategy implements RemoteCallback.OnResultListener {
    private static final String ATTR_PREVIOUS_BYTES = "previousBytes";
    private static final String ATTR_QUOTA_IN_BYTES = "bytes";
    private static final String ATTR_UID = "uid";
    private static final String ATTR_UUID = "uuid";
    private static final String CACHE_INFO_TAG = "cache-info";
    private static final String TAG = "CacheQuotaStrategy";
    private static final String TAG_QUOTA = "quota";
    private final Context mContext;
    private final Installer mInstaller;
    private final Object mLock;
    private AtomicFile mPreviousValuesFile;
    private final ArrayMap<String, SparseLongArray> mQuotaMap;
    private ICacheQuotaService mRemoteService;
    private ServiceConnection mServiceConnection;
    private final UsageStatsManagerInternal mUsageStats;

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m8419$$Nest$fgetmLock(CacheQuotaStrategy r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ICacheQuotaService m8420$$Nest$fgetmRemoteService(CacheQuotaStrategy r0) {
        return r0.mRemoteService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemoteService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8421$$Nest$fputmRemoteService(CacheQuotaStrategy r0, ICacheQuotaService r1) {
        r0.mRemoteService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUnfulfilledRequests, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m8422$$Nest$mgetUnfulfilledRequests(CacheQuotaStrategy r0) {
        return r0.getUnfulfilledRequests();
    }

    public CacheQuotaStrategy(Context context, UsageStatsManagerInternal usageStatsManager, Installer installer, ArrayMap<String, SparseLongArray> quotaMap) {
        this.mLock = new Object();
        context.getClass();
        this.mContext = context;
        usageStatsManager.getClass();
        this.mUsageStats = usageStatsManager;
        installer.getClass();
        this.mInstaller = installer;
        quotaMap.getClass();
        this.mQuotaMap = quotaMap;
        this.mPreviousValuesFile = new AtomicFile(new File(new File(Environment.getDataDirectory(), "system"), "cachequota.xml"));
    }

    public void recalculateQuotas() {
        createServiceConnection();
        ComponentName component = getServiceComponentName();
        if (component == null) goto L6;
        Intent intent = new Intent();
        intent.setComponent(component);
        this.mContext.bindServiceAsUser(intent, this.mServiceConnection, 1, UserHandle.CURRENT);
        return;
    }

    private void createServiceConnection() {
        if (this.mServiceConnection == null) goto L5;
        return;
    L5:
        this.mServiceConnection = new AnonymousClass1(this);
    }

    private List<CacheQuotaHint> getUnfulfilledRequests() {
        CacheQuotaStrategy r1 = this;
        long timeNow = System.currentTimeMillis();
        long oneYearAgo = timeNow - 31449600000L;
        List<CacheQuotaHint> requests = new ArrayList();
        UserManager um = (UserManager) r1.mContext.getSystemService(UserManager.class);
        List<UserInfo> users = um.getUsers();
        PackageManager packageManager = r1.mContext.getPackageManager();
        Iterator<UserInfo> r14 = users.iterator();
    L4:
        if (r14.hasNext() == false) goto L27;
        UserInfo info = r14.next();
        List<UsageStats> stats = r1.mUsageStats.queryUsageStatsForUser(info.id, 4, oneYearAgo, timeNow, false);
        if (stats == null) goto L4;
        int i = 0;
    L10:
        if (i >= stats.size()) goto L26;
        UsageStats stat = stats.get(i);
        String packageName = stat.getPackageName();
        ApplicationInfo appInfo = packageManager.getApplicationInfoAsUser(packageName, 0, info.id);     // Catch: PackageManager.NameNotFoundException -> L22
        List<UsageStats> stats2 = stats;
        int i2 = i;
        requests.add(new CacheQuotaHint.Builder().setVolumeUuid(appInfo.volumeUuid).setUid(appInfo.uid).setUsageStats(stat).setQuota(-1).build());     // Catch: PackageManager.NameNotFoundException -> L18
    L25:
        i = i2 + 1;
        stats = stats2;
    L21:
        i2 = i;
    L23:
        stats2 = stats;
        i2 = i;
        goto L25
    L26:
        r1 = this;
        goto L4
    L27:
        return requests;
    }

    public void onResult(Bundle data) {
        List<CacheQuotaHint> processedRequests = data.getParcelableArrayList("requests", CacheQuotaHint.class);
        pushProcessedQuotas(processedRequests);
        writeXmlToFile(processedRequests);
    }

    private void pushProcessedQuotas(List<CacheQuotaHint> processedRequests) {
        Iterator<CacheQuotaHint> r1 = processedRequests.iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        CacheQuotaHint request = r1.next();
        long proposedQuota = request.getQuota();
        if (proposedQuota == (-1)) goto L4;
        int uid = request.getUid();     // Catch: Installer.InstallerException -> L10
        this.mInstaller.setAppQuota(request.getVolumeUuid(), UserHandle.getUserId(uid), UserHandle.getAppId(uid), proposedQuota);     // Catch: Installer.InstallerException -> L10
        insertIntoQuotaMap(request.getVolumeUuid(), UserHandle.getUserId(uid), UserHandle.getAppId(uid), proposedQuota);     // Catch: Installer.InstallerException -> L10
    L10:
        ex = move-exception;
        Slog.w(TAG, "Failed to set cache quota for " + request.getUid(), ex);
        goto L4
    L13:
        disconnectService();
    }

    private void insertIntoQuotaMap(String volumeUuid, int userId, int appId, long quota) {
        SparseLongArray volumeMap = this.mQuotaMap.get(volumeUuid);
        if (volumeMap != null) goto L5;
        volumeMap = new SparseLongArray();
        this.mQuotaMap.put(volumeUuid, volumeMap);
    L5:
        volumeMap.put(UserHandle.getUid(userId, appId), quota);
    }

    private void disconnectService() {
        if (this.mServiceConnection == null) goto L6;
        this.mContext.unbindService(this.mServiceConnection);
        this.mServiceConnection = null;
        return;
    }

    private ComponentName getServiceComponentName() {
        String packageName = this.mContext.getPackageManager().getServicesSystemSharedLibraryPackageName();
        if (packageName != null) goto L6;
        Slog.w(TAG, "could not access the cache quota service: no package!");
        return null;
    L6:
        Intent intent = new Intent("android.app.usage.CacheQuotaService");
        intent.setPackage(packageName);
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveService(intent, 132);
        if (resolveInfo != null) goto L9;
    L13:
        Slog.w(TAG, "No valid components found.");
        return null;
    L9:
        if (resolveInfo.serviceInfo == null) goto L13;
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    private void writeXmlToFile(List<CacheQuotaHint> processedRequests) {
        FileOutputStream fileStream = null;
        fileStream = this.mPreviousValuesFile.startWrite();     // Catch: Exception -> L5
        TypedXmlSerializer out = Xml.resolveSerializer(fileStream);     // Catch: Exception -> L5
        StatFs stats = new StatFs(Environment.getDataDirectory().getAbsolutePath());     // Catch: Exception -> L5
        saveToXml(out, processedRequests, stats.getAvailableBytes());     // Catch: Exception -> L5
        this.mPreviousValuesFile.finishWrite(fileStream);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "An error occurred while writing the cache quota file.", e);
        this.mPreviousValuesFile.failWrite(fileStream);
    }

    public long setupQuotasFromFile() throws IOException {
        FileInputStream stream = this.mPreviousValuesFile.openRead();     // Catch: FileNotFoundException -> L9
        Pair<Long, List<CacheQuotaHint>> cachedValues = readFromXml(stream);     // Catch: Throwable -> L17 XmlPullParserException -> L19
        goto L30
    L6:
        if (stream == null) goto L12;
        stream.close();     // Catch: FileNotFoundException -> L9
    L12:
        if (cachedValues != null) goto L15;
        Slog.e(TAG, "An error occurred while parsing the cache quota file.");
        return -1;
    L15:
        pushProcessedQuotas((List) cachedValues.second);
        return ((Long) cachedValues.first).longValue();
    L17:
        th = move-exception;
        if (stream != null) goto L32;
    L28:
        throw th;     // Catch: FileNotFoundException -> L9
    L32:
        stream.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: FileNotFoundException -> L9
    L19:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());     // Catch: Throwable -> L17
    L30:
        return -1;
    }

    static void saveToXml(TypedXmlSerializer out, List<CacheQuotaHint> requests, long bytesWhenCalculated) throws IOException {
        out.startDocument(null, true);
        out.startTag(null, CACHE_INFO_TAG);
        out.attributeLong(null, ATTR_PREVIOUS_BYTES, bytesWhenCalculated);
        Iterator<CacheQuotaHint> r2 = requests.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        CacheQuotaHint request = r2.next();
        out.startTag(null, TAG_QUOTA);
        String uuid = request.getVolumeUuid();
        if (uuid == null) goto L8;
        out.attribute(null, ATTR_UUID, request.getVolumeUuid());
    L8:
        out.attributeInt(null, "uid", request.getUid());
        out.attributeLong(null, ATTR_QUOTA_IN_BYTES, request.getQuota());
        out.endTag(null, TAG_QUOTA);
        goto L4
    L9:
        out.endTag(null, CACHE_INFO_TAG);
        out.endDocument();
    }

    protected static Pair<Long, List<CacheQuotaHint>> readFromXml(InputStream inputStream) throws XmlPullParserException, IOException {
        TypedXmlPullParser parser = Xml.resolvePullParser(inputStream);
        int eventType = parser.getEventType();
    L4:
        if (eventType == 2) goto L8;
        if (eventType == 1) goto L8;
        eventType = parser.next();
    L8:
        if (eventType != 1) goto L11;
        Slog.d(TAG, "No quotas found in quota file.");
        return null;
    L11:
        String tagName = parser.getName();
        if (CACHE_INFO_TAG.equals(tagName) == false) goto L31;
        List<CacheQuotaHint> quotas = new ArrayList();
        long previousBytes = parser.getAttributeLong(null, ATTR_PREVIOUS_BYTES);     // Catch: NumberFormatException -> L27
        int eventType2 = parser.next();
    L16:
        if (eventType2 != 2) goto L23;
        String tagName2 = parser.getName();
        if (TAG_QUOTA.equals(tagName2) == false) goto L23;
        CacheQuotaHint request = getRequestFromXml(parser);
        if (request == null) goto L23;
        quotas.add(request);
    L23:
        eventType2 = parser.next();
        if (eventType2 != 1) goto L16;
        return new Pair(Long.valueOf(previousBytes), quotas);
    L29:
        throw new IllegalStateException("Previous bytes formatted incorrectly; aborting quota read.");
    L31:
        throw new IllegalStateException("Invalid starting tag.");
    }

    static CacheQuotaHint getRequestFromXml(TypedXmlPullParser parser) {
        String uuid = parser.getAttributeValue(null, ATTR_UUID);     // Catch: XmlPullParserException -> L5
        int uid = parser.getAttributeInt(null, "uid");     // Catch: XmlPullParserException -> L5
        long bytes = parser.getAttributeLong(null, ATTR_QUOTA_IN_BYTES);     // Catch: XmlPullParserException -> L5
        return new CacheQuotaHint.Builder().setVolumeUuid(uuid).setUid(uid).setQuota(bytes).build();
    L6:
        Slog.e(TAG, "Invalid cache quota request, skipping.");
        return null;
    }
}
