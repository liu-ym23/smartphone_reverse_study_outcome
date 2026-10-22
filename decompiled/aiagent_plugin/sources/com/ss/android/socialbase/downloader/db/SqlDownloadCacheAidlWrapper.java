package com.ss.android.socialbase.downloader.db;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public class SqlDownloadCacheAidlWrapper implements ServiceConnection, ISqlDownloadCache {
    private static final int BIND_MAIN_PROCESS_MAX_TIME = 5;
    private static final int BIND_MAIN_PROCESS_MIN_INTERVAL = 15000;
    private static final int MAIN_PROCESS_BIND_DELAY = 1000;
    private static final String TAG = "SqlDownloadCacheAidlWra";
    private static int sBindMainProcessTimes;
    private static boolean sIsMainProcessAlive;
    private static long sLastBindMainProcessTimeMills;
    private Runnable mCheckAliveRunnable;
    private Handler mHandler;
    private ISqlDownloadCacheAidl mISqlDownloadCache;
    private CountDownLatch mInitLock;
    private ISqlCacheLoadCompleteCallbackAidl mPengingCallback;
    private DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener mRebindErrorListener;
    private Future<?> mSetInitCallbackFuture;

    public interface OnMainProcessRebindErrorListener {
        void onRebindError();
    }

    static {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r1) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r1, Map<Long, Segment> r2) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return false;
    }

    static /* synthetic */ boolean access$000() {
        return sIsMainProcessAlive;
    }

    static /* synthetic */ boolean access$002(boolean r0) {
        sIsMainProcessAlive = r0;
        return r0;
    }

    static /* synthetic */ DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener access$100(SqlDownloadCacheAidlWrapper r0) {
        return r0.mRebindErrorListener;
    }

    static /* synthetic */ ISqlCacheLoadCompleteCallbackAidl access$200(SqlDownloadCacheAidlWrapper r0) {
        return r0.mPengingCallback;
    }

    static /* synthetic */ ISqlDownloadCacheAidl access$300(SqlDownloadCacheAidlWrapper r0) {
        return r0.mISqlDownloadCache;
    }

    static /* synthetic */ CountDownLatch access$400(SqlDownloadCacheAidlWrapper r0) {
        return r0.mInitLock;
    }

    static /* synthetic */ boolean access$500(SqlDownloadCacheAidlWrapper r0) {
        return r0.bindMainProcessDelayed();
    }

    static /* synthetic */ Runnable access$600(SqlDownloadCacheAidlWrapper r0) {
        return r0.mCheckAliveRunnable;
    }

    static /* synthetic */ Handler access$700(SqlDownloadCacheAidlWrapper r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Future access$800(SqlDownloadCacheAidlWrapper r0) {
        return r0.mSetInitCallbackFuture;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public /* bridge */ /* synthetic */ List getSegments(int r1) {
        return getSegments(r1);
    }

    public SqlDownloadCacheAidlWrapper() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mPengingCallback = null;
        this.mCheckAliveRunnable = new AnonymousClass1(this);
        this.mInitLock = new CountDownLatch(1);
        SqlDownloadCacheService.startServiceAndBind((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this);
    }

    public void setOnMainProcessRebindErrorCallback(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener r3) {
        this.mRebindErrorListener = (DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener) ZeusTransformUtils.wrapperContextForParams(r3, DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener.class, "com.obric.aiagent.plugin");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r2, IBinder r3) {
        final IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.aiagent.plugin");
        sIsMainProcessAlive = true;
        this.mHandler.removeCallbacks(this.mCheckAliveRunnable);
        this.mISqlDownloadCache = ISqlDownloadCacheAidl.Stub.asInterface(r4);     // Catch: Throwable -> L5
    L7:
        this.mSetInitCallbackFuture = DownloadComponentManager.getCPUThreadExecutor().submit(new AnonymousClass2(this, r4));
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
        this.mISqlDownloadCache = null;
        sIsMainProcessAlive = false;
    }

    private boolean bindMainProcessDelayed() {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return false;
    L6:
        if (sIsMainProcessAlive == false) goto L9;
        return false;
    L9:
        if (sBindMainProcessTimes > 5) goto L11;
        long r5 = System.currentTimeMillis();
        if ((r5 - sLastBindMainProcessTimeMills) < 15000) goto L17;
        sBindMainProcessTimes++;
        sLastBindMainProcessTimeMills = r5;
        this.mHandler.postDelayed(new AnonymousClass3(this), 1000);
        return true;
    L17:
        if (Logger.debug() == false) goto L19;
        Logger.globalDebug(TAG, "bindMainProcessDelayed", "Time too short since last bin");
    L19:
        return false;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "bindMainProcessDelayed", "Bind too many times");
    L13:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> r9, final HashMap<Integer, Integer> r10, List<DownloadInfo> r11, List<String> r12, SqlCacheLoadCompleteCallback r13) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        final SqlCacheLoadCompleteCallback r7 = (SqlCacheLoadCompleteCallback) ZeusTransformUtils.wrapperContextForParams(r13, SqlCacheLoadCompleteCallback.class, "com.obric.aiagent.plugin");
        DownloadComponentManager.getCPUThreadExecutor().submit(new AnonymousClass4(this, r9, r10, r6, r7));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r3) {
        ISqlCacheLoadCompleteCallbackAidl r4 = (ISqlCacheLoadCompleteCallbackAidl) ZeusTransformUtils.wrapperContextForParams(r3, ISqlCacheLoadCompleteCallbackAidl.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: Throwable -> L13
        if (r0 != null) goto L16;
        this.mPengingCallback = r4;     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L16:
        r0.setInitCallback(r4);     // Catch: RemoteException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init(boolean r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.init(r1);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.cacheExist(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo getDownloadInfo(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfo(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfoList(String r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfoList(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getSuccessedDownloadInfosWithMimeType(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getUnCompletedDownloadInfosWithMimeType(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFileExtension(String r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfosByFileExtension(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getAllDownloadInfo() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getAllDownloadInfo();
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.getDownloadInfosByFilters(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateDownloadInfo(DownloadInfo r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.updateDownloadInfo(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadInfo(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.removeDownloadInfo(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.removeDownloadTaskData(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearData() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.clearData();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo onDownloadTaskStart(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.onDownloadTaskStart(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskConnected(int r7, long r8, String r10, String r11) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskConnected(r7, r8, r10, r11);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskProgress(int r1, long r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskProgress(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskError(int r1, long r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskError(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskRetry(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskRetry(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCompleted(int r1, long r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskCompleted(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPause(int r1, long r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskPause(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskCancel(int r1, long r2) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskCancel(r1, r2);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskPrepare(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskPrepare(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public DownloadInfo OnDownloadTaskIntercept(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.OnDownloadTaskIntercept(r1);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.isDownloadCacheSyncSuccess();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L12;
        return r0.ensureDownloadCacheSyncSuccess();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(DownloadInfo r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.syncDownloadInfo(r1);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int r1) {
        ISqlDownloadCacheAidl r0 = this.mISqlDownloadCache;     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        r0.syncDownloadInfoFromOtherCache(r1);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }
}
