package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LruDownloadCache extends DownloadCache {
    static final String TAG = "LruDownloadCache";
    private final List<DownloadInfo> autoResumeList;
    private final LinkedHashMap<Integer, DownloadInfo> lruDownloadInfoMap;
    private final SparseArray<Map<Long, Segment>> lruSegmentListMap;
    private ISqlDownloadCache sqlDownloadCache;
    private final HashMap<Integer, Integer> unreadDBMap;

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r1) {
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    static /* synthetic */ void access$000(LruDownloadCache r0, Integer r1) {
        r0.addToUnreadMap(r1);
    }

    private void addToUnreadMap(Integer r5) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "addToUnreadMap", "Key: " + r5);
    L5:
        HashMap<Integer, Integer> r0 = this.unreadDBMap;
        monitor-enter(r0);
        this.unreadDBMap.put(r5, 0);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeFromUnreadMap(Integer r2) {
        if (r2.intValue() != 0) goto L5;
        return;
    L5:
        HashMap<Integer, Integer> r0 = this.unreadDBMap;
        monitor-enter(r0);
        this.unreadDBMap.remove(r2);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private boolean isExistInUnreadMap(Integer r2) {
        if (r2.intValue() != 0) goto L6;
        return false;
    L6:
        HashMap<Integer, Integer> r0 = this.unreadDBMap;
        monitor-enter(r0);
        boolean r1 = this.unreadDBMap.containsKey(r2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    private void addToLruSegmentListMap(int r3, Map<Long, Segment> r4) {
        Map<Long, Segment> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r3 != 0) goto L5;
        return;
    L5:
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        this.lruSegmentListMap.put(r3, r5);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeFromLruSegmentListMap(Integer r2) {
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        this.lruSegmentListMap.remove(r2.intValue());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Map<Long, Segment> getFromLruSegmentListMap(Integer r3) {
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        Map<Long, Segment> r2 = (Map) ZeusTransformUtils.preCheckCast(this.lruSegmentListMap.get(r3.intValue()), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private void addToLruDownloadInfoMap(Integer r2, DownloadInfo r3) {
        if (r2.intValue() != 0) goto L5;
        return;
    L5:
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        this.lruDownloadInfoMap.put(r2, r3);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void removeFromLruDownloadInfoMap(Integer r2) {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        this.lruDownloadInfoMap.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private DownloadInfo getFromLruDownloadInfoMap(Integer r3) {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(this.lruDownloadInfoMap.get(r3), DownloadInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearUnreadMap() {
        HashMap<Integer, Integer> r0 = this.unreadDBMap;
        monitor-enter(r0);
        this.unreadDBMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearLruSegmentListMap() {
        SparseArray<Map<Long, Segment>> r0 = this.lruSegmentListMap;
        monitor-enter(r0);
        this.lruSegmentListMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearLruDownloadInfoMap() {
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        this.lruDownloadInfoMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public LruDownloadCache(ISqlDownloadCache r5) {
        ISqlDownloadCache r6 = (ISqlDownloadCache) ZeusTransformUtils.wrapperContextForParams(r5, ISqlDownloadCache.class, "com.obric.aiagent.plugin");
        super(r6);
        this.lruSegmentListMap = new SparseArray();
        this.unreadDBMap = new HashMap();
        this.autoResumeList = new ArrayList();
        final int r1 = 0;
        final float r2 = 0.75f;
        final boolean r3 = true;
        this.lruDownloadInfoMap = new AnonymousClass1(this, r1, r2, r3);
        this.sqlDownloadCache = r6;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r1) {
        if (getDownloadInfo(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r3) {
        visitDownloadMemoryInfo();
        DownloadInfo r0 = null;
        r0 = getFromLruDownloadInfoMap(Integer.valueOf(r3));     // Catch: Exception -> L12
        if (r0 == null) goto L6;
    L14:
        return r0;
    L6:
        if (isExistInUnreadMap(Integer.valueOf(r3)) == false) goto L14;
        r0 = this.sqlDownloadCache.getDownloadInfo(r3);     // Catch: Exception -> L12
        if (r0 == null) goto L10;
        addToLruDownloadInfoMap(Integer.valueOf(r3), r0);     // Catch: Exception -> L12
    L10:
        removeFromUnreadMap(Integer.valueOf(r3));     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r1) {
        visitDownloadMemoryInfo();
        return this.sqlDownloadCache.getDownloadInfoList(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r2) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.sqlDownloadCache.getSuccessedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r2) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.sqlDownloadCache.getUnCompletedDownloadInfosWithMimeType(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r2) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return null;
    L7:
        return this.sqlDownloadCache.getDownloadInfosByFileExtension(r2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        visitDownloadMemoryInfo();
        return this.sqlDownloadCache.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        visitDownloadMemoryInfo();
        return getDownloadInfosByFilters(this.sqlDownloadCache.getAllDownloadInfo(), r2, r3);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r3) {
        visitDownloadMemoryInfo();
        boolean r0 = true;
        if (r3 != null) goto L6;
        return true;
    L6:
        if (getDownloadInfo(r3.getId()) != null) goto L9;
        r0 = false;
    L9:
        addToLruDownloadInfoMap(Integer.valueOf(r3.getId()), r3);
        removeFromUnreadMap(Integer.valueOf(r3.getId()));
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r2) {
        visitDownloadMemoryInfo();
        removeFromLruDownloadInfoMap(Integer.valueOf(r2));
        removeFromUnreadMap(Integer.valueOf(r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r1) {
        removeDownloadInfo(r1);
        removeSegments(r1);
        removeFromUnreadMap(Integer.valueOf(r1));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        visitDownloadMemoryInfo();
        clearLruDownloadInfoMap();
        clearUnreadMap();
        clearLruSegmentListMap();
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r7) {
        visitDownloadMemoryInfo();
        if (r7 > 0.0d) goto L5;
        return;
    L5:
        if (r7 > 1.0d) goto L36;
        LinkedHashMap<Integer, DownloadInfo> r0 = this.lruDownloadInfoMap;
        monitor-enter(r0);
        int r8 = (int) (((double) this.lruDownloadInfoMap.size()) * r7);     // Catch: Throwable -> L26
        int r9 = 0;
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "Before LruDownloadInfoMap Size:" + this.lruDownloadInfoMap.size() + " ClearSize:" + r8);     // Catch: Throwable -> L26
    L12:
        Iterator<Map.Entry<Integer, DownloadInfo>> r1 = this.lruDownloadInfoMap.entrySet().iterator();     // Catch: Throwable -> L26
    L14:
        if (r1.hasNext() == false) goto L22;
        if (r9 >= r8) goto L22;
        if (DownloadComponentManager.getDownloadEngine().isDownloading(((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue()) == true) goto L20;
        r1.remove();     // Catch: Throwable -> L26
    L20:
        r9 = r9 + 1;     // Catch: Throwable -> L26
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "End LruDownloadInfoMap Size:" + this.lruDownloadInfoMap.size());     // Catch: Throwable -> L26
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(2);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int r1, long r2, String r4, String r5) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L10;
        r0.setTotalBytes(r2);
        r0.seteTag(r4);
        if (TextUtils.isEmpty(r0.getName()) == true) goto L7;
    L9:
        r0.setStatus(3);
        goto L10
    L7:
        if (TextUtils.isEmpty(r5) == true) goto L9;
        r0.setName(r5);
    L10:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L13;
        r0.setCurBytes(r2, false);
        if (r0.getStatus() == (-3)) goto L13;
        if (r0.getStatus() == (-2)) goto L13;
        if (DownloadStatus.isFailedStatus(r0.getStatus()) == true) goto L13;
        if (r0.getStatus() == (-4)) goto L13;
        r0.setStatus(4);
    L13:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-1);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(5);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-3);
        r0.setFirstDownload(false);
        r0.setFirstSuccess(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-2);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-4);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(1);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(-7);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r1) {
        updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int r1) {
        Map<Long, Segment> r0 = getSegmentMap(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r0.values());
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r2) {
        Map<Long, Segment> r0 = getFromLruSegmentListMap(Integer.valueOf(r2));
        if (r0 != null) goto L9;
        r0 = this.sqlDownloadCache.getSegmentMap(r2);
        if (r0 != null) goto L8;
        return null;
    L8:
        addToLruSegmentListMap(r2, r0);
    L9:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r3, Map<Long, Segment> r4) {
        addToLruSegmentListMap(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache, com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r1) {
        removeFromLruSegmentListMap(Integer.valueOf(r1));
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public void addToDownloadCacheInfoMap(DownloadInfo r2) {
        addToLruDownloadInfoMap(Integer.valueOf(r2.getId()), r2);
        removeFromUnreadMap(Integer.valueOf(r2.getId()));
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public HashMap<Integer, Integer> getUnreadDBMap() {
        return this.unreadDBMap;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public List<DownloadInfo> getAutoResumeList() {
        return this.autoResumeList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.DownloadCache
    public List<String> getMimeTypes() {
        IDownloadLaunchHandler r0 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getResumeMimeTypes();
    }
}
