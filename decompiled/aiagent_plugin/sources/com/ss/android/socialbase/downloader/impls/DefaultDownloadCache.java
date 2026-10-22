package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultDownloadCache implements IDownloadCache {
    private static final int MSG_RESUME = 1;
    private static final String TAG = "DefaultDownloadCache";
    private static AtomicBoolean isInitFinish;
    private static AtomicBoolean isRunInit;
    private WeakDownloadHandler.IHandler IHandler;
    private int bizCloseDBBatchInit;
    private final DownloadCache downloadCache;
    private volatile boolean hasInitSqlDownloadCache;
    private int loadDBWaitTime;
    private ThreadLocal<Boolean> mThreadDownloadCacheLoaded;
    private boolean mThreadLoadDownloadCacheOnlyOnce;
    private ISqlDownloadCache sqlDownloadCache;
    private volatile boolean unCompleteTaskResumed;
    private WeakDownloadHandler weakHandler;

    static /* synthetic */ ISqlDownloadCache access$002(DefaultDownloadCache r2, ISqlDownloadCache r3) {
        ISqlDownloadCache r4 = (ISqlDownloadCache) ZeusTransformUtils.wrapperContextForParams(r3, ISqlDownloadCache.class, "com.obric.aiagent.plugin");
        r2.sqlDownloadCache = r4;
        return r4;
    }

    static /* synthetic */ DownloadCache access$100(DefaultDownloadCache r0) {
        return r0.downloadCache;
    }

    static /* synthetic */ void access$200(DefaultDownloadCache r0) {
        r0.initFinish();
    }

    static {
        isRunInit = new AtomicBoolean(false);
        isInitFinish = new AtomicBoolean(false);
    }

    public DefaultDownloadCache() {
        boolean r0 = false;
        this.mThreadLoadDownloadCacheOnlyOnce = false;
        this.mThreadDownloadCacheLoaded = new ThreadLocal();
        this.IHandler = new AnonymousClass1(this);
        this.weakHandler = null;
        if (DownloadHelper.isMainProcess() == false) goto L5;
    L8:
        this.sqlDownloadCache = new SqlDownloadCache();
    L9:
        this.hasInitSqlDownloadCache = false;
        this.weakHandler = new WeakDownloadHandler(Looper.getMainLooper(), this.IHandler);
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_LRU_DOWNLOAD_INFO_CACHE_ENABLE, 0) <= 0) goto L12;
    L15:
        this.downloadCache = new LruDownloadCache(this.sqlDownloadCache);
    L16:
        this.loadDBWaitTime = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.LOAD_DB_WAIT_TIME_MS, DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        this.bizCloseDBBatchInit = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.BIZ_CLOSE_DB_BATCH_INIT, 0);
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.THREAD_LOAD_DOWNLOAD_CACHE_ONLY_ONCE) <= 0) goto L19;
        r0 = true;
    L19:
        this.mThreadLoadDownloadCacheOnlyOnce = r0;
        Runnable r1 = new AnonymousClass3(this);
        long r2 = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.DELAY_INIT_DOWNLOAD_CACHE_MS);
        if (r2 <= 0) goto L22;
        DownloadComponentManager.submitScheduleTask(r1, r2, TimeUnit.MILLISECONDS);
        return;
    L22:
        r1.run();
        return;
    L12:
        if (DownloadComponentManager.isEnableLruCache() == true) goto L15;
        this.downloadCache = new DownloadCache(this.sqlDownloadCache);
        goto L16
    L5:
        if (DownloadComponentManager.supportMultiProc() == false) goto L8;
        this.sqlDownloadCache = DownloadComponentManager.getIndependentHolderCreator().createCache(new AnonymousClass2(this));
        goto L9
    }

    public DownloadCache getDownloadCache() {
        return this.downloadCache;
    }

    public ISqlDownloadCache getSqlDownloadCache() {
        return this.sqlDownloadCache;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r2) {
        DownloadInfo r3 = this.downloadCache.onDownloadTaskStart(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r9) {
        if (isRunInit.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.globalDebug(TAG, "init", "Run");
    L8:
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_START);
        final SparseArray<DownloadInfo> r3 = new SparseArray();
        this.downloadCache.copyDownloadInfoMap(r3);
        this.sqlDownloadCache.init(r3, this.downloadCache.getUnreadDBMap(), this.downloadCache.getAutoResumeList(), this.downloadCache.getMimeTypes(), new AnonymousClass4(this, r3));
        int r10 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.INIT_DOWNLOAD_CACHE_TIMEOUT_MS);
        if (Logger.debug() == false) goto L11;
        Logger.globalDebug(TAG, "init", "InitTimeout:" + r10);
    L11:
        if (r10 > 0) goto L13;
        return;
    L13:
        DownloadComponentManager.submitScheduleTask(new AnonymousClass5(this), r10, TimeUnit.MILLISECONDS);
    }

    private void initFinish() {
        if (isInitFinish.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        onDownloadCacheSyncSuccess();
        resumeUnCompleteTaskMayDelayed();
        DownloadComponentManager.onDownloadCacheSyncCallback(DownloadCacheSyncStatus.SYNC_SUCCESS);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "initImmediately", "Run isRunInit:" + isRunInit.get());
    L5:
        init(ZeusTransformUtils.instanceOf(this.downloadCache, LruDownloadCache.class));
    }

    private void onDownloadCacheSyncSuccess() {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "onDownloadCacheSyncSuccess", "Run");
    L6:
        if (this.downloadCache.isActiveLoadDownloadCache() == false) goto L9;
        newOnDownloadCacheSyncSuccess();
        return;
    L9:
        monitor-enter(this);
        this.hasInitSqlDownloadCache = true;     // Catch: Throwable -> L14
        notifyAll();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void newOnDownloadCacheSyncSuccess() {
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r0);
        this.hasInitSqlDownloadCache = true;     // Catch: Throwable -> L8
        r0.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        if (this.hasInitSqlDownloadCache == false) goto L7;
        return true;
    L7:
        if (this.downloadCache.isActiveLoadDownloadCache() == false) goto L10;
        newEnsureDownloadCacheSyncSuccess();
        return this.hasInitSqlDownloadCache;
    L10:
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.hasInitSqlDownloadCache == false) goto L14;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L29
        return this.hasInitSqlDownloadCache;
    L14:
        if (Logger.debug() == false) goto L17;
        Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting start:" + this.loadDBWaitTime);     // Catch: Throwable -> L29
    L17:
        if (this.bizCloseDBBatchInit <= 0) goto L23;
        ISqlDownloadCache r0 = this.sqlDownloadCache;     // Catch: Throwable -> L29
        if (r0 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r0, SqlDownloadCache.class) == false) goto L23;
        ((SqlDownloadCache) ZeusTransformUtils.preCheckCast(this.sqlDownloadCache, SqlDownloadCache.class, "com.obric.aiagent.plugin")).resetNewBatchInit();     // Catch: Throwable -> L29
    L23:
        waitDBLoad(this);     // Catch: Throwable -> L29
        if (Logger.debug() == false) goto L26;
        Logger.globalDebug(TAG, "ensureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L29
        goto L26
    }

    private void newEnsureDownloadCacheSyncSuccess() {
        AbsDownloadEngine r0 = DownloadComponentManager.getDownloadEngine();
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.hasInitSqlDownloadCache == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting start");     // Catch: Throwable -> L14
    L9:
        initImmediately();     // Catch: Throwable -> L14
        waitDBLoad(r0);     // Catch: Throwable -> L14
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "newEnsureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L14
        goto L12
    }

    private void waitDBLoad(Object r6) {
        if (this.mThreadLoadDownloadCacheOnlyOnce == false) goto L9;
        if (this.mThreadDownloadCacheLoaded.get() == null) goto L7;
        return;
    L7:
        this.mThreadDownloadCacheLoaded.set(true);
    L9:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "waitDBLoad", "Run loadDBWaitTime:" + this.loadDBWaitTime);
    L16:
        r6.wait(this.loadDBWaitTime);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "waitDBLoad", "Error:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return this.hasInitSqlDownloadCache;
    }

    public void resumeUnCompleteTaskMayDelayed() {
        Message r0 = this.weakHandler.obtainMessage(1);
        this.weakHandler.sendMessageDelayed(r0, 4000);
    }

    public void resumeUnCompleteTask() {
        if (this.hasInitSqlDownloadCache == true) goto L6;
        return;
    L6:
        if (this.unCompleteTaskResumed == true) goto L8;
        this.unCompleteTaskResumed = true;
        if (DownloadHelper.isMainProcess() == true) goto L14;
        return;
    L14:
        IDownloadLaunchHandler r1 = DownloadComponentManager.getDownloadLaunchHandler();
        List<DownloadInfo> r3 = this.downloadCache.getAutoResumeList();
        if (r1 == null) goto L22;
        if (r3 != null) goto L18;
        return;
    L18:
        if (r3.isEmpty() == true) goto L24;
        r1.onLaunchResume(r3, 1);
        return;
    L24:
        return;
    L22:
        return;
    L8:
        if (Logger.debug() == false) goto L21;
        Logger.globalDebug(TAG, "resumeUnCompleteTask", "Has resumed, return");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r1) {
        if (getDownloadInfo(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r1) {
        return this.downloadCache.getDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r1) {
        return this.downloadCache.getDownloadInfoList(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
        return this.downloadCache.getSuccessedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
        return this.downloadCache.getUnCompletedDownloadInfosWithMimeType(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
        return this.downloadCache.getDownloadInfosByFileExtension(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        return this.downloadCache.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
        return this.downloadCache.getDownloadInfosByFilters(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        boolean r0 = this.downloadCache.updateDownloadInfo(r2);
        updateDownloadInfoInDB(r2);
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r2) {
    L10:
        e = move-exception;
        e.printStackTrace();
    L13:
        return this.downloadCache.removeDownloadInfo(r2);
    L3:
        if (DownloadHelper.needNotifyDownloaderProcess() == false) goto L8;
        IDownloadProxy r0 = DownloadProxy.get(true);     // Catch: SQLiteException -> L10
        if (r0 == null) goto L7;
        r0.removeDownloadInfo(r2);     // Catch: SQLiteException -> L10
    L14:
        goto L13
    L7:
        this.sqlDownloadCache.removeDownloadInfo(r2);     // Catch: SQLiteException -> L10
        goto L14
    L8:
        this.sqlDownloadCache.removeDownloadInfo(r2);     // Catch: SQLiteException -> L10
        goto L14
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r2) {
        if (DownloadHelper.needNotifyDownloaderProcess() == false) goto L8;
        IDownloadProxy r0 = DownloadProxy.get(true);
        if (r0 == null) goto L7;
        r0.removeDownloadTaskData(r2);
    L10:
        return this.downloadCache.removeDownloadTaskData(r2);
    L7:
        this.sqlDownloadCache.removeDownloadTaskData(r2);
        goto L10
    L8:
        this.sqlDownloadCache.removeDownloadTaskData(r2);
        goto L10
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        this.downloadCache.clearData();     // Catch: SQLiteException -> L4
    L7:
        if (DownloadHelper.needNotifyDownloaderProcess() == false) goto L12;
        IDownloadProxy r0 = DownloadProxy.get(true);
        if (r0 == null) goto L11;
        r0.clearData();
        return;
    L11:
        this.sqlDownloadCache.clearData();
        return;
    L12:
        this.sqlDownloadCache.clearData();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r1) {
        this.downloadCache.clearMemoryCacheData(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int r7, long r8, String r10, String r11) {
        DownloadInfo r9 = this.downloadCache.OnDownloadTaskConnected(r7, r8, r10, r11);
        updateDownloadInfoInDB(r9);
        return r9;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskProgress(r2, r3);
        updateDownloadInfoInDB(r4, false);
        return r4;
    }

    private void updateDownloadInfoInDB(DownloadInfo r2) {
        updateDownloadInfoInDB(r2, true);
    }

    private void updateDownloadInfoInDB(DownloadInfo r2, boolean r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (DownloadHelper.needNotifyDownloaderProcess() == false) goto L11;
        if (r3 == false) goto L13;
        IDownloadProxy r4 = DownloadProxy.get(true);
        if (r4 == null) goto L10;
        r4.updateDownloadInfo(r2);
        return;
    L10:
        this.sqlDownloadCache.updateDownloadInfo(r2);
        return;
    L13:
        return;
    L11:
        this.sqlDownloadCache.updateDownloadInfo(r2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskError(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r2) {
        DownloadInfo r3 = this.downloadCache.OnDownloadTaskRetry(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskCompleted(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskPause(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r2, long r3) {
        DownloadInfo r4 = this.downloadCache.OnDownloadTaskCancel(r2, r3);
        syncDownloadInfoFromOtherCache(r2);
        return r4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r2) {
        DownloadInfo r3 = this.downloadCache.OnDownloadTaskPrepare(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r2) {
        DownloadInfo r3 = this.downloadCache.OnDownloadTaskIntercept(r2);
        updateDownloadInfoInDB(r3);
        return r3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.downloadCache.updateDownloadInfo(r1);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int r2) {
        updateDownloadInfo(this.downloadCache.getDownloadInfo(r2));     // Catch: Exception -> L10
        if (DownloadHelper.needNotifyDownloaderProcess() == false) goto L8;
        IDownloadProxy r0 = DownloadProxy.get(true);     // Catch: Exception -> L10
        if (r0 == null) goto L7;
        r0.syncDownloadInfoFromOtherCache(r2);     // Catch: Exception -> L10
    L13:
        return;
    L7:
        this.sqlDownloadCache.syncDownloadInfoFromOtherCache(r2);     // Catch: Exception -> L10
        goto L13
    L8:
        this.sqlDownloadCache.syncDownloadInfoFromOtherCache(r2);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<Segment> getSegments(int r3) {
        List<Segment> r0 = this.downloadCache.getSegments(r3);
        if (r0 == null) goto L7;
        if (r0.size() == 0) goto L7;
        return r0;
    L7:
        return this.sqlDownloadCache.getSegments(r3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r3) {
        Map<Long, Segment> r0 = this.downloadCache.getSegmentMap(r3);
        if (r0 != null) goto L5;
    L6:
        Map<Long, Segment> r1 = this.sqlDownloadCache.getSegmentMap(r3);
        this.downloadCache.updateSegments(r3, r1);
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L6;
        return r0;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r3, Map<Long, Segment> r4) {
        Map<Long, Segment> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        this.downloadCache.updateSegments(r3, r5);
        this.sqlDownloadCache.updateSegments(r3, r5);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r2) {
        this.downloadCache.removeSegments(r2);
        this.sqlDownloadCache.removeSegments(r2);
    }

    public void updateDownloadSpInfo() {
        if (this.hasInitSqlDownloadCache == true) goto L5;
        return;
    L5:
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        DownloadComponentManager.submitIOTask(new AnonymousClass6(this, r0));
    }
}
