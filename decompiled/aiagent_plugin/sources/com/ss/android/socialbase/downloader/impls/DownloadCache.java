package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadCache implements IDownloadCache {
    private static final String TAG = "DownloadCache";
    private boolean activeLoadDownloadCache;
    private final Map<Integer, DownloadInfo> downloadInfoMap;
    private final Map<Integer, Map<Long, Segment>> segmentListMap;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    public List<String> getMimeTypes() {
        return null;
    }

    public HashMap<Integer, Integer> getUnreadDBMap() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int r1) {
    }

    public DownloadCache(ISqlDownloadCache r3) {
        ISqlDownloadCache r4 = (ISqlDownloadCache) ZeusTransformUtils.wrapperContextForParams(r3, ISqlDownloadCache.class, "com.obric.aiagent.plugin");
        this.downloadInfoMap = new ConcurrentHashMap();
        this.segmentListMap = new ConcurrentHashMap();
        boolean r5 = false;
        this.activeLoadDownloadCache = false;
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.ACTIVE_LOAD_DOWNLOAD_CACHE) <= 0) goto L5;
        r5 = true;
    L5:
        this.activeLoadDownloadCache = r5;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(2);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r1) {
        if (getDownloadInfo(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r2) {
        visitDownloadMemoryInfo();
        return (DownloadInfo) ZeusTransformUtils.preCheckCast(this.downloadInfoMap.get(Integer.valueOf(r2)), DownloadInfo.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r5) {
        visitDownloadMemoryInfo();
        ArrayList r0 = new ArrayList();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return r0;
    L5:
        Iterator<DownloadInfo> r4 = this.downloadInfoMap.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (r5.equals(r1.getUrl()) == false) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r5) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.downloadInfoMap.isEmpty() == true) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.downloadInfoMap.values().iterator();
    L9:
        if (r4.hasNext() == false) goto L17;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r1.getMimeType()) == true) goto L9;
        if (r1.getMimeType().equals(r5) == false) goto L9;
        if (r1.getStatus() != (-3)) goto L9;
        r0.add(r1);
        goto L9
    L17:
        return r0;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r5) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.downloadInfoMap.isEmpty() == true) goto L33;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.downloadInfoMap.values().iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        if (TextUtils.isEmpty(r1.getMimeType()) == true) goto L9;
        if (r1.getMimeType().equals(r5) == false) goto L9;
        if (DownloadStatus.isUnCompletedStatus(r1.getStatus()) == false) goto L9;
        r0.add(r1);
        goto L9
    L19:
        return r0;
    L33:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r5) {
        visitDownloadMemoryInfo();
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        if (this.downloadInfoMap.isEmpty() == true) goto L29;
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.downloadInfoMap.values().iterator();
    L9:
        if (r4.hasNext() == false) goto L17;
        DownloadInfo r1 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L9;
        if (TextUtils.isEmpty(r1.getName()) == true) goto L9;
        if (r1.getName().endsWith(r5) == false) goto L9;
        r0.add(r1);
        goto L9
    L17:
        return r0;
    L29:
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        visitDownloadMemoryInfo();
        if (this.downloadInfoMap.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator<DownloadInfo> r4 = this.downloadInfoMap.values().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        r0.add((DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.aiagent.plugin"));
        goto L8
    L10:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r2, String r3) {
        visitDownloadMemoryInfo();
        return getDownloadInfosByFilters(this.downloadInfoMap.values(), r2, r3);
    }

    public List<DownloadInfo> getDownloadInfosByFilters(Collection<DownloadInfo> r5, String r6, String r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        if (r8.isEmpty() == false) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L12;
        DownloadInfo r2 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r9.next(), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (checkFilter(r2, r6, r7) == false) goto L8;
        r0.add(r2);
        goto L8
    L12:
        return r0;
    }

    private boolean checkFilter(DownloadInfo r2, String r3, String r4) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L14;
        if (TextUtils.isEmpty(r2.getMimeType()) == true) goto L14;
        if (r3.equals(r2.getMimeType()) == false) goto L14;
        return true;
    L14:
        if (TextUtils.isEmpty(r4) == false) goto L16;
        return false;
    L16:
        if (TextUtils.isEmpty(r2.getUrl()) == true) goto L30;
        String r5 = null;
        r5 = Uri.parse(r2.getUrl()).getLastPathSegment();     // Catch: Throwable -> L20
    L23:
        if (TextUtils.isEmpty(r5) == false) goto L26;
        return false;
    L26:
        return r5.endsWith(r4);
    L20:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L30:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r4) {
        visitDownloadMemoryInfo();
        boolean r0 = true;
        if (r4 != null) goto L6;
        return true;
    L6:
        if (this.downloadInfoMap.get(Integer.valueOf(r4.getId())) != null) goto L9;
        r0 = false;
    L9:
        this.downloadInfoMap.put(Integer.valueOf(r4.getId()), r4);
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r1) {
        visitDownloadMemoryInfo();
        this.downloadInfoMap.remove(Integer.valueOf(r1));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r1) {
        removeDownloadInfo(r1);
        removeSegments(r1);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        visitDownloadMemoryInfo();
        this.downloadInfoMap.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r8) {
        visitDownloadMemoryInfo();
        if (r8 > 0.0d) goto L5;
        return;
    L5:
        if (r8 > 1.0d) goto L30;
        int r9 = (int) (((double) this.downloadInfoMap.size()) * r8);
        if (Logger.debug() == false) goto L10;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "Before DownloadInfoMap Size:" + this.downloadInfoMap.size() + " ClearSize:" + r9);
    L10:
        int r10 = 0;
        Iterator<Map.Entry<Integer, DownloadInfo>> r2 = this.downloadInfoMap.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L19;
        if (r10 >= r9) goto L19;
        if (DownloadComponentManager.getDownloadEngine().isDownloading(((Integer) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue()) == true) goto L12;
        r2.remove();
        r10 = r10 + 1;
    L19:
        if (Logger.debug() == false) goto L29;
        Logger.globalDebug(TAG, "clearMemoryCacheData", "End DownloadInfoMap Size:" + this.downloadInfoMap.size());
        return;
    L29:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-1);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(5);
        r0.setFirstDownload(false);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
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

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-2);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r1, long r2) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setCurBytes(r2, false);
        r0.setStatus(-4);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(1);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r1) {
        DownloadInfo r0 = getDownloadInfo(r1);
        if (r0 == null) goto L5;
        r0.setStatus(-7);
    L5:
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r1) {
        updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int r2) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.segmentListMap.get(Integer.valueOf(r2)), Map.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r1.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r2) {
        return (Map) ZeusTransformUtils.preCheckCast(this.segmentListMap.get(Integer.valueOf(r2)), Map.class, "com.obric.aiagent.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r3, Map<Long, Segment> r4) {
        Map<Long, Segment> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        this.segmentListMap.put(Integer.valueOf(r3), r5);
        return false;
    L7:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r1) {
        this.segmentListMap.remove(Integer.valueOf(r1));
    }

    public void addToDownloadCacheInfoMap(DownloadInfo r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.downloadInfoMap.put(Integer.valueOf(r2.getId()), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void copyDownloadInfoMap(SparseArray<DownloadInfo> r5) {
        Iterator<Map.Entry<Integer, DownloadInfo>> r4 = this.downloadInfoMap.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L4;
        if (r0.getValue() == null) goto L4;
        r5.put(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue(), r0.getValue());
        goto L4
    }

    public List<DownloadInfo> getAutoResumeList() {
        IDownloadLaunchHandler r0 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r0 == null) goto L10;
        List<String> r1 = r0.getResumeMimeTypes();
        if (r1 != null) goto L7;
    L9:
        ArrayList r2 = null;
    L11:
        SparseArray r3 = new SparseArray();
        Iterator<Map.Entry<Integer, DownloadInfo>> r10 = this.downloadInfoMap.entrySet().iterator();
    L13:
        if (r10.hasNext() == false) goto L20;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue() == 0) goto L13;
        if (r4.getValue() == null) goto L13;
        r3.put(((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.aiagent.plugin")).intValue(), r4.getValue());
        goto L13
    L20:
        if (r3.size() != 0) goto L22;
        return null;
    L22:
        int r5 = 0;
    L24:
        if (r5 >= r3.size()) goto L53;
        int r6 = r3.keyAt(r5);
        if (r6 == 0) goto L52;
        DownloadInfo r7 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r3.get(r6), DownloadInfo.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L52;
        int r8 = r7.getRealStatus();
        int r9 = r7.getStatusAtDbInit();
        if (r9 >= 1) goto L34;
    L36:
        if (r1 == null) goto L52;
        if (r2 == null) goto L52;
        if (r7.getMimeType() == null) goto L52;
        if (r1.contains(r7.getMimeType()) == false) goto L52;
        if (DownloadSetting.obtain(r7.getId()).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2) goto L47;
    L51:
        r7.setDownloadFromReserveWifi(false);
        r2.add(r7);
        goto L52
    L47:
        if (r8 != (-2)) goto L51;
        if (r7.isPauseReserveOnWifi() == true) goto L51;
    L34:
        if (r9 > 11) goto L36;
        DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), null, r7, null, -5);
    L52:
        r5 = r5 + 1;
        goto L24
    L53:
        return r2;
    L7:
        if (r1.isEmpty() == true) goto L9;
        r2 = new ArrayList();
        goto L11
    L10:
        r1 = null;
        r2 = null;
        goto L11
    }

    public boolean isActiveLoadDownloadCache() {
        return this.activeLoadDownloadCache;
    }

    public void visitDownloadMemoryInfo() {
        IDownloadMemoryInfoListener r0 = DownloadComponentManager.getDownloadMemoryInfoListener();
        if (r0 == null) goto L6;
        r0.onVisitMemoryInfo();
    L6:
        if (this.activeLoadDownloadCache == true) goto L8;
        return;
    L8:
        if (DownloadUtils.isMainThread() == true) goto L12;
        DownloadComponentManager.getDownloadCache().ensureDownloadCacheSyncSuccess();
        return;
    }
}
