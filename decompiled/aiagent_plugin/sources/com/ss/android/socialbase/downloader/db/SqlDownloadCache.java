package com.ss.android.socialbase.downloader.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.cleaner.Cleaner;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class SqlDownloadCache extends ISqlDownloadCacheAidl.Stub implements ISqlDownloadCache {
    private static final int DEFAULT_MAIN_THREAD_DB_OP_MAX_TIME_MS = 4000;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_DEFAULT = 300;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_MAX = 0;
    public static final int DOWNLOAD_CACHE_LRU_CAPACITY_MIN = 100;
    private static final String TAG = "SqlDownloadCache";
    private static volatile SQLiteDatabase database;
    public static volatile HashMap<String, Integer> lruHotCacheKeysMap;
    private static final boolean mEnableRemoveDownloadSPInfo = false;
    private static final int mainThreadDbOPMaxTime = 0;
    private volatile boolean cacheSynced;
    ISqlCacheLoadCompleteCallbackAidl callback;
    private TableStatements downloadTableStatements;
    private boolean isCheckCacheEnable;
    private TableStatements segmentTableStatements;
    private int singleLoadCountLimit;
    private long singleLoadSleepTimeMs;

    private interface Fallback<T> {
        T getDefaultValue();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void clearMemoryCacheData(double r1) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfosByFilters(String r1, String r2) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void initImmediately() {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo onDownloadTaskStart(int r1) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfo(DownloadInfo r1) {
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void syncDownloadInfoFromOtherCache(int r1) {
    }

    static /* synthetic */ void access$000(SqlDownloadCache r0) {
        r0.ensureDataBaseInit();
    }

    static /* synthetic */ SQLiteDatabase access$100() {
        return database;
    }

    static /* synthetic */ void access$1000(SqlDownloadCache r0, DownloadInfo r1) {
        r0.checkAndReportToMonitor(r1);
    }

    static /* synthetic */ boolean access$1100(String r0) {
        return isHoldDownloadInfo(r0);
    }

    static /* synthetic */ void access$1200(SqlDownloadCache r2, List r3) {
        r2.clearAntiHijackDirIfNeeded((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ void access$1300(SqlDownloadCache r0) {
        r0.deleteChunkTable();
    }

    static /* synthetic */ void access$1400(SqlDownloadCache r2, List r3, SparseArray r4) {
        r2.loadCacheFromDB((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"), r4);
    }

    static /* synthetic */ DownloadInfo access$1500(SqlDownloadCache r0, int r1) {
        return r0.getDownloadInfoImpl(r1);
    }

    static /* synthetic */ List access$1600(SqlDownloadCache r0, String r1) {
        return r0.getDownloadInfoListImpl(r1);
    }

    static /* synthetic */ List access$1700(SqlDownloadCache r0, String r1) {
        return r0.getSuccessedDownloadInfosWithMimeTypeImpl(r1);
    }

    static /* synthetic */ List access$1800(SqlDownloadCache r0, String r1) {
        return r0.getUnCompletedDownloadInfosWithMimeTypeImpl(r1);
    }

    static /* synthetic */ List access$1900(SqlDownloadCache r0, String r1) {
        return r0.getDownloadInfosByFileExtensionImpl(r1);
    }

    static /* synthetic */ List access$2000(SqlDownloadCache r0) {
        return r0.getAllDownloadInfoImpl();
    }

    static /* synthetic */ boolean access$202(SqlDownloadCache r0, boolean r1) {
        r0.cacheSynced = r1;
        return r1;
    }

    static /* synthetic */ TableStatements access$2100(SqlDownloadCache r0) {
        return r0.downloadTableStatements;
    }

    static /* synthetic */ void access$2200(SqlDownloadCache r0, DownloadInfo r1, SQLiteStatement r2) {
        r0.insertDownloadInfoInner(r1, r2);
    }

    static /* synthetic */ void access$2300(SqlDownloadCache r0, DownloadInfo r1) {
        r0.updateDownloadInfoForCurrentThread(r1);
    }

    static /* synthetic */ void access$2400(SqlDownloadCache r0, int r1, SQLiteStatement r2) {
        r0.deleteInner(r1, r2);
    }

    static /* synthetic */ boolean access$2500() {
        return mEnableRemoveDownloadSPInfo;
    }

    static /* synthetic */ void access$2600(SqlDownloadCache r0) {
        r0.clearDataInSubThread();
    }

    static /* synthetic */ void access$2700(SqlDownloadCache r0, int r1, ContentValues r2) {
        r0.updateInner(r1, r2);
    }

    static /* synthetic */ int access$300(SqlDownloadCache r0) {
        return r0.singleLoadCountLimit;
    }

    static /* synthetic */ int access$302(SqlDownloadCache r0, int r1) {
        r0.singleLoadCountLimit = r1;
        return r1;
    }

    static /* synthetic */ long access$400(SqlDownloadCache r2) {
        return r2.singleLoadSleepTimeMs;
    }

    static /* synthetic */ long access$402(SqlDownloadCache r0, long r1) {
        r0.singleLoadSleepTimeMs = r1;
        return r1;
    }

    static /* synthetic */ boolean access$502(SqlDownloadCache r0, boolean r1) {
        r0.isCheckCacheEnable = r1;
        return r1;
    }

    static /* synthetic */ void access$600(SqlDownloadCache r10, DownloadDBInitInfo r11, SparseArray r12, HashMap r13, List r14, List r15, SqlCacheLoadCompleteCallback r16, Cleaner r17) {
        r10.newBatchInit(r11, r12, r13, (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin"), (SqlCacheLoadCompleteCallback) ZeusTransformUtils.wrapperContextForParams(r16, SqlCacheLoadCompleteCallback.class, "com.obric.aiagent.plugin"), r17);
    }

    static /* synthetic */ void access$700() {
        getHotCacheKeys();
    }

    static /* synthetic */ boolean access$800(SqlDownloadCache r0, DownloadInfo r1, boolean r2, long r3, boolean r5) {
        return r0.checkAndRemoveDownloadInfo(r1, r2, r3, r5);
    }

    static /* synthetic */ boolean access$900(SqlDownloadCache r0, DownloadInfo r1, boolean r2, boolean r3, Cleaner r4, boolean r5) {
        return r0.handleSuccess(r1, r2, r3, r4, r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public /* bridge */ /* synthetic */ List getSegments(int r1) {
        return getSegments(r1);
    }

    static {
        DOWNLOAD_CACHE_LRU_CAPACITY_MAX = getLRUCapacityMax();
        lruHotCacheKeysMap = null;
        mainThreadDbOPMaxTime = getMainThreadDbOPMaxTime();
        mEnableRemoveDownloadSPInfo = isRemoveDownloadSPInfo();
    }

    public SqlDownloadCache() {
        this(false);
    }

    public SqlDownloadCache(boolean r3) {
        this.isCheckCacheEnable = false;
        this.callback = null;
        if (r3 == true) goto L5;
        return;
    L5:
        this.cacheSynced = false;
        init(false);
    }

    private static int getLRUCapacityMax() {
        int r0 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_LRU_CAPACITY_MAX, 300);
        if (r0 >= 100) goto L5;
        return 300;
    L5:
        return r0;
    }

    private static int getMainThreadDbOPMaxTime() {
        int r0 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.MAIN_THREAD_DB_OP_MAX_TIME_MS);
        if (r0 >= 0) goto L6;
        return r0;
    L6:
        if (DownloadComponentManager.isEnableLruCache() == false) goto L9;
        return 4000;
    L9:
        return r0;
    }

    private static boolean isRemoveDownloadSPInfo() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_REMOVE_DOWNLOAD_SP_INFO) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static void getHotCacheKeys() {
        if (lruHotCacheKeysMap == null) goto L5;
        return;
    L5:
        lruHotCacheKeysMap = DownloadHelper.jsonObjectToHashMap(DownloadSetting.getGlobalSettings().optJSONObject(DownloadSettingKeys.KEY_HOT_CACHE_KEYS));
    }

    private static boolean isHoldDownloadInfo(String r5) {
        if (lruHotCacheKeysMap != null) goto L5;
    L17:
        return false;
    L5:
        if (lruHotCacheKeysMap.isEmpty() == true) goto L17;
        if (r5 == null) goto L17;
        Iterator<Map.Entry<String, Integer>> r0 = lruHotCacheKeysMap.entrySet().iterator();
    L10:
        if (r0.hasNext() == false) goto L17;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        if (r5.indexOf(r2) == (-1)) goto L10;
        return true;
    }

    private void ensureDataBaseInit() {
        if (database == null) goto L5;
        return;
    L5:
        monitor-enter(SqlDownloadCache.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (database == null) goto L23;
    L17:
        monitor-exit(SqlDownloadCache.class);     // Catch: Throwable -> L19
        return;
    L23:
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        Logger.globalError(TAG, "ensureDataBaseInit", "Error:" + th);     // Catch: Throwable -> L19
        goto L17
    L9:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(DownloadComponentManager.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) != null) goto L13;
        Logger.globalError(TAG, "ensureDataBaseInit", "Context is null");     // Catch: Throwable -> L15
        monitor-exit(SqlDownloadCache.class);     // Catch: Throwable -> L19
        return;
    L13:
        database = DownloadDBHelper.getInstance().getWritableDatabase();     // Catch: Throwable -> L15
        this.downloadTableStatements = new TableStatements(database, DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.DOWNLOAD_ALL_COLUMNS, DBDefinition.DOWNLOAD_PK_COLUMNS);     // Catch: Throwable -> L15
        this.segmentTableStatements = new TableStatements(database, DBDefinition.SEGMENT_TABLE_NAME, DBDefinition.SEGMENT_ALL_COLUMNS, DBDefinition.SEGMENT_PK_COLUMNS);     // Catch: Throwable -> L15
        goto L17
    }

    private List<String> getMimeTypes() {
        IDownloadLaunchHandler r0 = DownloadComponentManager.getDownloadLaunchHandler();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getResumeMimeTypes();
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void init(boolean r13) {
        if (r13 == false) goto L4;
        init(new SparseArray(), new HashMap(), new ArrayList(), getMimeTypes(), null);
        return;
    L4:
        init(new SparseArray(), null, null, null, null);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public void init(final SparseArray<DownloadInfo> r10, final HashMap<Integer, Integer> r11, List<DownloadInfo> r12, List<String> r13, SqlCacheLoadCompleteCallback r14) {
        final List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        final List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        final SqlCacheLoadCompleteCallback r5 = (SqlCacheLoadCompleteCallback) ZeusTransformUtils.wrapperContextForParams(r14, SqlCacheLoadCompleteCallback.class, "com.obric.aiagent.plugin");
        Runnable r15 = new AnonymousClass1(this, r10, r5, r11, r7, r8);     // Catch: Throwable -> L7
        ExecutorService r9 = DownloadComponentManager.getDBThreadExecutorService();     // Catch: Throwable -> L7
        if (r9 == null) goto L12;
        r9.execute(r15);     // Catch: Throwable -> L7
        return;
    L12:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "init", "Error2:" + th);
    }

    private void newBatchInit(DownloadDBInitInfo r36, SparseArray<DownloadInfo> r37, HashMap<Integer, Integer> r38, List<DownloadInfo> r39, List<String> r40, SqlCacheLoadCompleteCallback r41, Cleaner r42) {
        r36 = r36;
        List<DownloadInfo> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.aiagent.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.aiagent.plugin");
        SqlCacheLoadCompleteCallback r14 = (SqlCacheLoadCompleteCallback) ZeusTransformUtils.wrapperContextForParams(r41, SqlCacheLoadCompleteCallback.class, "com.obric.aiagent.plugin");
        SparseArray<DownloadInfo> r15 = new SparseArray();
        ArrayList r8 = new ArrayList();
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQL_DOWNLOAD_CACHE_TIME_OPT) <= 0) goto L5;
        boolean r16 = true;
    L7:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_DOWNLOAD_SUCCESS_AND_NOT_EXISTS) <= 0) goto L9;
        boolean r17 = true;
    L11:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.REMOVE_EXTERNAL_PUBLIC_DIR_TASK_FOR_Q) <= 0) goto L13;
        boolean r18 = true;
    L15:
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.REMOVE_USELESS_MONITOR_REPORT, 0) <= 0) goto L17;
        boolean r19 = true;
    L19:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CLEAN_INSTALLED_APK) <= 0) goto L21;
        boolean r20 = true;
    L22:
        long r21 = DownloadSetting.obtainGlobal().optLong(DownloadSettingKeys.INCOMPLETE_FILE_EXPIRED_TIME);
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CacheCleaner.ASYNC_DB_CLEAN) <= 0) goto L25;
        boolean r23 = true;
    L26:
        Set<String> r4 = DownloadHelper.getSkipDbInitSceneSet();
        Set<String> r5 = DownloadHelper.getSkipDbInitExpectMimeTypeSet();
        Set<String> r3 = DownloadHelper.getDbInitSceneSet();
        Cursor r1 = null;
        r1 = database.rawQuery("SELECT * FROM downloader", null);     // Catch: Throwable -> L224
        if (r13 == null) goto L33;
        if (r38 == null) goto L33;
        getHotCacheKeys();     // Catch: Throwable -> L40
        int r2 = r1.getCount();     // Catch: Throwable -> L40
        int r6 = DOWNLOAD_CACHE_LRU_CAPACITY_MAX;     // Catch: Throwable -> L40
        if (r2 <= r6) goto L33;
        int r7 = r1.getCount() - r6;     // Catch: Throwable -> L40
    L34:
        if (r16 == true) goto L36;
    L42:
        IDownloadIdGeneratorService r9 = null;
        boolean r25 = true;
    L259:
        r36.diskCacheCount = r1.getCount();     // Catch: Throwable -> L221
        if (Logger.alog() == false) goto L52;
        Logger.globalDebug(TAG, "newBatchInit", "DownloadInfo Count:" + r36.diskCacheCount);     // Catch: Throwable -> L47
    L52:
        int r27 = r7;
        int r28 = 0;
    L53:
        if (r1.moveToNext() == false) goto L214;
        DownloadInfo r10 = DownloadHelper.parseDownloadInfo(r1);     // Catch: Throwable -> L210
        long r11 = r10.getCurBytes();     // Catch: Throwable -> L210
        if (r11 <= 0) goto L62;
        r36.diskCacheSize += r11;     // Catch: Throwable -> L47
    L47:
        th = th;
        r8 = r8;
        List<DownloadInfo> r29 = r13;
        r14 = r14;
    L50:
        int r31 = 0;
    L253:
        th.printStackTrace();     // Catch: Throwable -> L234
        Logger.globalError(TAG, "newBatchInit", "Error:" + th);     // Catch: Throwable -> L234
        Cursor[] r12 = new Cursor[1];
        r12[r31] = r1;
        DownloadUtils.safeClose(r12);
        deleteChunkTable();
        if (Logger.alog() == false) goto L230;
        Logger.globalDebug(TAG, "newBatchInit", "Run End");
    L230:
        callbackDownloadInfo(true, r8, r15, r37, r38, r29, r14);
        this.cacheSynced = true;
        r36.initDuration = System.currentTimeMillis() - r36.initDuration;
        r36.memoryCacheCount = r37.size();
        DownloadMonitorHelper.monitorDownloadDB(r36);
        IDownloadDBListener r22 = DownloadComponentManager.getDownloadDBListener();
        if (r22 != null) goto L219;
    L220:
        r42.start();
        return;
    L219:
        r22.onInitFinish(r36);
    L234:
        th = move-exception;
        Cursor[] r24 = new Cursor[1];
        r24[r31] = r1;
        DownloadUtils.safeClose(r24);
        deleteChunkTable();
        if (Logger.alog() == false) goto L238;
        Logger.globalDebug(TAG, "newBatchInit", "Run End");
    L238:
        callbackDownloadInfo(true, r8, r15, r37, r38, r29, r14);
        this.cacheSynced = true;
        r36.initDuration = System.currentTimeMillis() - r36.initDuration;
        r36.memoryCacheCount = r37.size();
        DownloadMonitorHelper.monitorDownloadDB(r36);
        IDownloadDBListener r26 = DownloadComponentManager.getDownloadDBListener();
        if (r26 == null) goto L241;
        r26.onInitFinish(r36);
    L241:
        r42.start();
        throw th;
    L62:
        Set<String> r30 = r3;
        r4 = r4;
        List r210 = r0;
        r3 = r30;
        r14 = r14;
        r5 = r5;
        List<DownloadInfo> r32 = r13;
    L208:
        th = th;
        r29 = r32;
    L212:
        r31 = 0;
    L213:
        r36 = r36;
    L223:
        r1 = r1;
        goto L253
    L64:
        if (checkAndRemoveDownloadInfo(r10, r18, r21, r23) == true) goto L65;
        if (r23 == false) goto L83;
        if (r10.getCacheLifeTimeMax() != 0) goto L83;
        r42.updateCleanDownloadId(r10);     // Catch: Throwable -> L80
    L83:
        if (DownloadHelper.hitSkipDbInitScene(r4, r5, r3, r10.getMimeType(), r10.getMonitorScene()) == true) goto L84;
        if (r19 == true) goto L90;
        r10.setStatusAtDbInit(r10.getRealStatus());     // Catch: Throwable -> L80
    L90:
        if (r10.isCanResumeFromBreakPointStatus() == false) goto L96;
        r10.setDBInitStatus(r10.getStatus());     // Catch: Throwable -> L80
        r10.setStatus(-5);     // Catch: Throwable -> L80
        if (r16 == false) goto L96;
        if (r19 == true) goto L96;
        r15.put(r10.getId(), r10);     // Catch: Throwable -> L80
    L96:
        if (TextUtils.isEmpty(r10.getSavePath()) == false) goto L98;
    L127:
        boolean r33 = true;
    L128:
        if (r33 == true) goto L129;
        if (r16 == false) goto L136;
        if (r25 == true) goto L139;
        int r34 = r10.getId();     // Catch: Throwable -> L80
        int r35 = r9.generate(r10);     // Catch: Throwable -> L80
        if (r35 == r34) goto L139;
        r10.setId(r35);     // Catch: Throwable -> L80
        r15.put(r34, r10);     // Catch: Throwable -> L80
    L139:
        if (r23 == false) goto L141;
    L143:
        if (r32 == null) goto L197;
        if (r38 == null) goto L197;
        if (r19 == true) goto L147;
        checkAndReportToMonitor(r10);     // Catch: Throwable -> L80
    L147:
        if (r210 != null) goto L149;
    L164:
        List r43 = r210;
    L165:
        r29 = r32;
    L166:
        if (r27 <= 0) goto L196;
        int r211 = r27 - 1;
        if (r27 <= 0) goto L195;
    L193:
        th = th;
        r29 = r29;
        goto L212
    L170:
        if (isHoldDownloadInfo(r10.getUrl()) == true) goto L195;
        monitor-enter(r38);     // Catch: Throwable -> L193
        r38.put(Integer.valueOf(r10.getId()), 0);     // Catch: Throwable -> L185
        monitor-exit(r38);     // Catch: Throwable -> L185
        int r44 = r28 + 1;
        if (r44 >= this.singleLoadCountLimit) goto L179;
        r28 = r44;
        r13 = r29;
        r27 = r211;
        r0 = r43;
        goto L53
    L179:
        List<DownloadInfo> r212 = r29;
        List r310 = r43;
        IDownloadIdGeneratorService r311 = r9;
        ArrayList r312 = r8;
        callbackDownloadInfo(false, r8, r15, r37, r38, r212, r14);     // Catch: Throwable -> L206
        r27 = r211;
        r13 = r212;
        r28 = 0;
        r9 = r311;
        r8 = r312;
        r0 = r310;
    L183:
        th = th;
        r29 = r29;
        r8 = r8;
        r31 = 0;
    L185:
        th = th;
        r31 = 0;
    L243:
        monitor-exit(r38);     // Catch: Throwable -> L191
        throw th;     // Catch: Throwable -> L206
    L206:
        th = th;
    L191:
        th = th;
    L187:
        th = th;
        r31 = 0;
    L195:
        r29 = r29;
        List r313 = r43;
        r9 = r9;
        r8 = r8;
        r31 = 0;
        r27 = r211;
    L199:
        r37.put(r10.getId(), r10);     // Catch: Throwable -> L206
    L245:
        int r45 = r28 + 1;     // Catch: Throwable -> L206
        if (r45 < this.singleLoadCountLimit) goto L204;
        callbackDownloadInfo(false, r8, r15, r37, r38, r29, r14);     // Catch: Throwable -> L206
        r28 = r31;
    L205:
        r13 = r29;
        r0 = r313;
        r9 = r9;
        r8 = r8;
        goto L53
    L204:
        r28 = r45;
        goto L205
    L196:
        r29 = r29;
        r313 = r43;
    L198:
        r31 = 0;
        goto L199
    L149:
        if (r210.isEmpty() == true) goto L164;
        String r46 = r10.getMimeType();     // Catch: Throwable -> L80
        r43 = r210;
        if (r43.contains(r46) == false) goto L165;
        int r47 = r10.getRealStatus();     // Catch: Throwable -> L80
        if (DownloadSetting.obtain(r10).optInt(DownloadSettingKeys.OPT_NOTIFICATION_UI) < 2) goto L155;
    L159:
        r29 = r32;
        r29.add(r10);     // Catch: Throwable -> L162
    L162:
        th = th;
        r36 = r36;
        r29 = r29;
        r8 = r8;
        goto L50
    L155:
        if (r47 != (-2)) goto L159;
        if (r10.isPauseReserveOnWifi() == true) goto L159;
    L197:
        r313 = r210;
        r29 = r32;
        goto L198
    L141:
        if (r10.getCacheLifeTimeMax() != 0) goto L143;
        r42.updateCleanDownloadId(r10);     // Catch: Throwable -> L80
        goto L143
    L136:
        int r48 = r10.getId();     // Catch: Throwable -> L208
        int r49 = ((IDownloadIdGeneratorService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadIdGeneratorService.class), IDownloadIdGeneratorService.class, "com.obric.aiagent.plugin")).generate(r10);     // Catch: Throwable -> L208
        if (r49 == r48) goto L139;
        r10.setId(r49);     // Catch: Throwable -> L80
        r15.put(r48, r10);     // Catch: Throwable -> L80
        goto L139
    L129:
        r8.add(r10);     // Catch: Throwable -> L80
        r9 = r9;
        r8 = r8;
        r313 = r210;
        r29 = r32;
        r31 = 0;
        goto L245
    L98:
        if (TextUtils.isEmpty(r10.getName()) == true) goto L127;
        if (r10.getStatus() != 1) goto L106;
        if (r10.getCurBytes() > 0) goto L106;
        boolean r50 = true;
    L114:
        if (r10.getStatus() != 11) goto L116;
        r10.setStatus(-5);     // Catch: Throwable -> L80
    L116:
        if (r20 == false) goto L119;
        r33 = handleSuccess(r10, r17, r50, r42, r23);     // Catch: Throwable -> L80
        goto L128
    L119:
        if (DownloadUtils.isDownloadSuccessAndFileNotExist(r10.getStatus(), r10.getSavePath(), r10.getName()) == true) goto L121;
    L126:
        r33 = r50;
        goto L128
    L121:
        if (Logger.debug() == false) goto L123;
        Logger.taskDebug(TAG, r10, "run", "Download success and file not exist");     // Catch: Throwable -> L80
    L123:
        if (r17 == true) goto L127;
        r10.erase();     // Catch: Throwable -> L80
    L106:
        if (r10.getStatus() != (-3)) goto L108;
    L112:
        r50 = false;
        goto L114
    L108:
        if (r10.getStatus() == 11) goto L112;
        if (r10.isFileDataValid() == true) goto L112;
        r10.reset();     // Catch: Throwable -> L80
        goto L112
    L84:
        if (r27 > 0) goto L85;
    L74:
        r13 = r32;
        r0 = r210;
        goto L53
    L85:
        r27 = r27 - 1;
        goto L74
    L65:
        if (r27 <= 0) goto L67;
        r27 = r27 - 1;
    L67:
        if (r23 == true) goto L257;
        removeDownloadTaskData(r10.getId());     // Catch: Throwable -> L80
    L80:
        th = th;
        r36 = r36;
        r8 = r8;
        r29 = r32;
        goto L50
    L257:
        r42.forceUpdateCleanDownloadId(r10, false);     // Catch: Throwable -> L71
    L71:
        th = th;
        r36 = r36;
        r8 = r8;
        r29 = r32;
        r31 = 0;
    L210:
        th = th;
        r29 = r13;
        r14 = r14;
        goto L212
    L214:
        ArrayList r314 = r8;
        List<DownloadInfo> r213 = r13;
        SqlCacheLoadCompleteCallback r410 = r14;
        DownloadUtils.safeClose(new Cursor[]{r1});
        deleteChunkTable();
        if (Logger.alog() == false) goto L217;
        Logger.globalDebug(TAG, "newBatchInit", "Run End");
    L217:
        callbackDownloadInfo(true, r314, r15, r37, r38, r213, r410);
        this.cacheSynced = true;
        r36 = r36;
        r36.initDuration = System.currentTimeMillis() - r36.initDuration;
        r36.memoryCacheCount = r37.size();
        DownloadMonitorHelper.monitorDownloadDB(r36);
        r22 = DownloadComponentManager.getDownloadDBListener();
        if (r22 == null) goto L220;
    L221:
        th = th;
        r8 = r8;
        r29 = r13;
        r14 = r14;
        r31 = 0;
        goto L223
    L36:
        if (r1.getCount() <= 0) goto L42;
        IDownloadIdGeneratorService r51 = (IDownloadIdGeneratorService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadIdGeneratorService.class), IDownloadIdGeneratorService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L47
        r9 = r51;
        r25 = r51.isDefaultIdGenerator();     // Catch: Throwable -> L47
    L40:
        th = th;
        r31 = 0;
        r8 = r8;
        r29 = r13;
        r14 = r14;
    L33:
        r7 = 0;
    L224:
        th = th;
        r31 = 0;
        r8 = r8;
        r29 = r13;
        r14 = r14;
        goto L253
    L25:
        r23 = false;
        goto L26
    L21:
        r20 = false;
        goto L22
    L17:
        r19 = false;
        goto L19
    L13:
        r18 = false;
        goto L15
    L9:
        r17 = false;
        goto L11
    L5:
        r16 = false;
        goto L7
    }

    private void callbackDownloadInfo(boolean r7, List<DownloadInfo> r8, SparseArray<DownloadInfo> r9, SparseArray<DownloadInfo> r10, HashMap<Integer, Integer> r11, List<DownloadInfo> r12, SqlCacheLoadCompleteCallback r13) {
        List<DownloadInfo> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List<DownloadInfo> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
        SqlCacheLoadCompleteCallback r16 = (SqlCacheLoadCompleteCallback) ZeusTransformUtils.wrapperContextForParams(r13, SqlCacheLoadCompleteCallback.class, "com.obric.aiagent.plugin");
        if (Logger.alog() == false) goto L5;
        Logger.globalDebug(TAG, "callbackDownloadInfo", "Run");
    L5:
        clearAntiHijackDirIfNeeded(r14);
        loadCacheFromDB(r14, r9);
        if (Logger.debug() == false) goto L8;
        Logger.globalDebug(TAG, "callbackDownloadInfo", "Run Callback:" + r16);
    L8:
        if (r16 == null) goto L10;
        r16.callback(r7);
    L10:
        onInitFinish(r10, r11, r15, r7);
        r9.clear();
        r14.clear();
        r10.clear();
        if (r7 == false) goto L21;
        return;
    L21:
    L18:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "newInit", "Sleep:" + th);
        return;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "newInit", "Sleep:" + this.singleLoadSleepTimeMs);     // Catch: Throwable -> L18
    L16:
        Thread.sleep(this.singleLoadSleepTimeMs);     // Catch: Throwable -> L18
    }

    private boolean checkAndRemoveDownloadInfo(DownloadInfo r10, boolean r11, long r12, boolean r14) {
        if (this.isCheckCacheEnable == true) goto L5;
    L14:
        if (r11 == false) goto L23;
        if (DownloadFileUtils.isAtLeastAndroidQ() == false) goto L23;
        if (DownloadFileUtils.isMediaUri(r10.getSavePath()) == true) goto L23;
        if (DownloadFileUtils.isFilePathInExternalPublicDir(r10.getSavePath()) == false) goto L23;
        return true;
    L23:
        if (r12 > 0) goto L25;
    L32:
        return false;
    L25:
        if (r10.getStatus() == (-3)) goto L32;
        if ((r10.getLastDownloadTime() + (r12 * 1000)) >= System.currentTimeMillis()) goto L32;
        if (r14 == false) goto L30;
        return true;
    L30:
        DownloadUtils.deleteAllDownloadFiles(r10, false);
        return true;
    L5:
        if (r10.getCacheLifeTimeMax() <= 0) goto L14;
        if (r10.getDownloadStartTimeStamp() <= 0) goto L14;
        if ((r10.getDownloadStartTimeStamp() + (r10.getCacheLifeTimeMax() * 1000)) >= System.currentTimeMillis()) goto L14;
        if (r14 == false) goto L12;
        return true;
    L12:
        DownloadUtils.deleteAllDownloadFiles(r10, true);
        return true;
    }

    private boolean handleSuccess(DownloadInfo r5, boolean r6, boolean r7, Cleaner r8, boolean r9) {
        if (r5.getStatus() == (-3)) goto L5;
        return r7;
    L5:
        boolean r4 = DownloadUtils.isFileExist(r5.getSavePath(), r5.getName());
        if (r5.getInstalledTimeStamp() > 0) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r4 == false) goto L18;
        if (r0 == false) goto L17;
        if (r9 == false) goto L16;
        r8.forceUpdateCleanDownloadId(r5, true);
        return r7;
    L16:
        DownloadUtils.deleteAllDownloadFiles(r5);
    L17:
        return r7;
    L18:
        if (r6 == false) goto L20;
        return true;
    L20:
        if (r0 == true) goto L22;
        r5.erase();
    L22:
        return r7;
    L8:
        if (DownloadDirUtils.isSavePathSecurity(r5.getSavePath()) == false) goto L10;
        r0 = true;
        goto L11
    }

    public void resetNewBatchInit() {
        this.singleLoadCountLimit = Integer.MAX_VALUE;
    }

    private void checkAndReportToMonitor(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        int r2 = r3.getStatusAtDbInit();
        if (r2 >= 1) goto L7;
        return;
    L7:
        if (r2 > 11) goto L11;
        DownloadMonitorHelper.monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), null, r3, null, -5);
        return;
    }

    private void clearAntiHijackDirIfNeeded(List<DownloadInfo> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L17;
        return;
    L17:
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L14
    L7:
        if (r4.hasNext() == false) goto L26;
        DownloadInfo r5 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r4.next(), DownloadInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r5 == null) goto L7;
        if (r5.isSavePathRedirected() == false) goto L7;
        DownloadUtils.clearAntiHijackDir(r5);     // Catch: Throwable -> L14
        goto L7
    L26:
        return;
    L14:
        th = move-exception;
        Logger.globalError(TAG, "clearAntiHijackDirIfNeeded", "Error:" + th);
    }

    private void safeBeginTransaction() {
        database.beginTransaction();
    }

    private void loadCacheFromDB(List<DownloadInfo> r11, SparseArray<DownloadInfo> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        int r0 = r12.size();
        if (r0 >= 0) goto L5;
        return;
    L5:
        if (database == null) goto L40;
        SQLiteDatabase r1 = database;
        monitor-enter(r1);
        safeBeginTransaction();     // Catch: Throwable -> L22
        if (r13.isEmpty() == true) goto L16;
        String[] r2 = new String[r13.size()];     // Catch: Throwable -> L22
        int r5 = 0;
    L13:
        if (r5 >= r13.size()) goto L15;
        r2[r5] = String.valueOf(((DownloadInfo) ZeusTransformUtils.preCheckCast(r13.get(r5), DownloadInfo.class, "com.obric.aiagent.plugin")).getId());     // Catch: Throwable -> L22
        r5 = r5 + 1;     // Catch: Throwable -> L22
        goto L13
    L15:
        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "CAST(_id AS TEXT) IN (" + new String(new char[r13.size() - 1]).replace("\u0000", "?,") + "?)", r2);     // Catch: Throwable -> L22
    L16:
        int r14 = 0;
    L17:
        if (r14 >= r0) goto L19;
        int r3 = r12.keyAt(r14);     // Catch: Throwable -> L22
        DownloadInfo r6 = (DownloadInfo) ZeusTransformUtils.preCheckCast(r12.get(r3), DownloadInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, "_id = ?", new String[]{String.valueOf(r3)});     // Catch: Throwable -> L22
        database.insert(DBDefinition.DOWNLOAD_TABLE_NAME, null, DownloadHelper.toContentValues(r6));     // Catch: Throwable -> L22
        r14 = r14 + 1;     // Catch: Throwable -> L22
        goto L17
    L19:
        database.setTransactionSuccessful();     // Catch: Throwable -> L22
    L20:
        safeEndTransaction();     // Catch: Throwable -> L30
        monitor-exit(r1);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L27
        Logger.globalError(TAG, "loadCacheFromDB", "Error:" + th);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        safeEndTransaction();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    }

    private void deleteChunkTable() {
        if (database != null) goto L10;
        return;
    L10:
        database.execSQL(DBDefinition.DROP_CHUNK_TABLE);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "deleteChunkTable", "Error:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean cacheExist(int r4) {
        if (getDownloadInfo(r4) == null) goto L12;
        return true;
    L12:
        return false;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r4, "cacheExist", "Error:" + th);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo getDownloadInfo(final int r2) {
        return (DownloadInfo) ZeusTransformUtils.preCheckCast(runImpl(new AnonymousClass2(this, r2), null), DownloadInfo.class, "com.obric.aiagent.plugin");
    }

    private DownloadInfo getDownloadInfoImpl(int r9) {
        ensureDataBaseInit();
        if (database != null) goto L24;
    L21:
        return null;
    L24:
        Cursor r2 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, "_id"}), new String[]{Integer.toString(r9)});     // Catch: Throwable -> L14
    L12:
        th = th;
    L26:
        th.printStackTrace();     // Catch: Throwable -> L18
        Logger.taskError(TAG, r9, "getDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L18
        DownloadUtils.safeClose(new Cursor[]{r2});
    L18:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r2});
        throw th;
    L7:
        if (r2.moveToNext() == false) goto L11;
        DownloadInfo r10 = DownloadHelper.parseDownloadInfo(r2);     // Catch: Throwable -> L12
        DownloadUtils.safeClose(new Cursor[]{r2});
        return r10;
    L11:
        DownloadUtils.safeClose(new Cursor[]{r2});
    L14:
        th = th;
        r2 = null;
        goto L26
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfoList(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(runImpl(new AnonymousClass3(this, r2), new AnonymousClass4(this)), List.class, "com.obric.aiagent.plugin");
    }

    private List<DownloadInfo> getDownloadInfoListImpl(String r8) {
        ensureDataBaseInit();
        ArrayList r7 = new ArrayList();
        if (database == null) goto L17;
        Cursor r0 = null;
        r0 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, "url"}), new String[]{r8});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r7.add(DownloadHelper.parseDownloadInfo(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getDownloadInfoListImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r0});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r0});
        throw th;
    L17:
        return r7;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(runImpl(new AnonymousClass5(this, r2), new AnonymousClass6(this)), List.class, "com.obric.aiagent.plugin");
    }

    private List<DownloadInfo> getSuccessedDownloadInfosWithMimeTypeImpl(String r9) {
        ensureDataBaseInit();
        ArrayList r8 = new ArrayList();
        if (database == null) goto L17;
        Cursor r0 = null;
        r0 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.MIME_TYPE, "status"}), new String[]{r9, String.valueOf(-3)});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r8.add(DownloadHelper.parseDownloadInfo(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getSuccessedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r0});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r0});
        throw th;
    L17:
        return r8;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(runImpl(new AnonymousClass7(this, r2), new AnonymousClass8(this)), List.class, "com.obric.aiagent.plugin");
    }

    private List<DownloadInfo> getUnCompletedDownloadInfosWithMimeTypeImpl(String r10) {
        ensureDataBaseInit();
        ArrayList r9 = new ArrayList();
        if (database == null) goto L17;
        Cursor r0 = null;
        r0 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ? AND %s IN (?,?,?,?,?)", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, DBDefinition.MIME_TYPE, "status"}), new String[]{r10, String.valueOf(-1), String.valueOf(-2), String.valueOf(-7), String.valueOf(-4), String.valueOf(-5)});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r9.add(DownloadHelper.parseDownloadInfo(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getUnCompletedDownloadInfosWithMimeTypeImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r0});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r0});
        throw th;
    L17:
        return r9;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getDownloadInfosByFileExtension(final String r2) {
        return (List) ZeusTransformUtils.preCheckCast(runImpl(new AnonymousClass9(this, r2), new AnonymousClass10(this)), List.class, "com.obric.aiagent.plugin");
    }

    private List<DownloadInfo> getDownloadInfosByFileExtensionImpl(String r9) {
        ensureDataBaseInit();
        ArrayList r8 = new ArrayList();
        if (database == null) goto L17;
        Cursor r0 = null;
        r0 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s LIKE ?", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME, "name"}), new String[]{"%" + r9});     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r8.add(DownloadHelper.parseDownloadInfo(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getDownloadInfosByFileExtensionImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r0});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r0});
        throw th;
    L17:
        return r8;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public List<DownloadInfo> getAllDownloadInfo() {
        return (List) ZeusTransformUtils.preCheckCast(runImpl(new AnonymousClass11(this), new AnonymousClass12(this)), List.class, "com.obric.aiagent.plugin");
    }

    private List<DownloadInfo> getAllDownloadInfoImpl() {
        ensureDataBaseInit();
        ArrayList r8 = new ArrayList();
        if (database == null) goto L17;
        Cursor r0 = null;
        r0 = database.rawQuery(String.format("SELECT * FROM %s", new Object[]{DBDefinition.DOWNLOAD_TABLE_NAME}), null);     // Catch: Throwable -> L11
    L7:
        if (r0.moveToNext() == false) goto L10;
        r8.add(DownloadHelper.parseDownloadInfo(r0));     // Catch: Throwable -> L11
        goto L7
    L10:
        DownloadUtils.safeClose(new Cursor[]{r0});
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.globalError(TAG, "getAllDownloadInfoImpl", "Error:" + th);     // Catch: Throwable -> L14
        DownloadUtils.safeClose(new Cursor[]{r0});
    L14:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r0});
        throw th;
    L17:
        return r8;
    }

    private void deleteInner(int r4, SQLiteStatement r5) {
        if (r5 != null) goto L15;
        return;
    L15:
        monitor-enter(r5);     // Catch: Throwable -> L12
        r5.bindLong(1, r4);     // Catch: Throwable -> L9
        r5.execute();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
    L18:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r4, "deleteInner", "Error:" + th);
    }

    private void insertDownloadInfoInner(DownloadInfo r4, SQLiteStatement r5) {
        if (r4 == null) goto L18;
        if (r5 == null) goto L20;
        monitor-enter(r5);     // Catch: Throwable -> L12
        r4.bindValue(r5);     // Catch: Throwable -> L9
        r5.executeInsert();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
    L19:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r4.getId(), "insertDownloadInfoInner", "Error:" + th);
        return;
    L20:
        return;
    }

    private void updateDownloadInfoInner(DownloadInfo r4, SQLiteStatement r5) {
        if (r4 == null) goto L19;
        if (r5 == null) goto L21;
        monitor-enter(r5);     // Catch: Throwable -> L12
        r4.bindValue(r5);     // Catch: Throwable -> L9
        r5.bindLong(r4.getBindValueCount() + 1, r4.getId());     // Catch: Throwable -> L9
        r5.execute();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
    L20:
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r4.getId(), "updateDownloadInfoInner", "Error:" + th);
        return;
    L21:
        return;
    }

    private void addDownloadInfo(final DownloadInfo r2) {
        DownloadComponentManager.submitDBTask(new AnonymousClass13(this, r2));
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean updateDownloadInfo(final DownloadInfo r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        DownloadComponentManager.submitDBTask(new AnonymousClass14(this, r2));
        return true;
    }

    private synchronized void updateDownloadInfoForCurrentThread(DownloadInfo r6) {
        monitor-enter(this);
        if (r6 != null) goto L23;
        monitor-exit(this);
        return;
    L23:
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        Logger.taskError(TAG, r6.getId(), "updateDownloadInfoForCurrentThread", "Error:" + th);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    L7:
        if (cacheExist(r6.getId()) == true) goto L9;
        addDownloadInfo(r6);     // Catch: Throwable -> L15
    L22:
        goto L17
    L9:
        TableStatements r0 = this.downloadTableStatements;     // Catch: Throwable -> L15
        if (r0 != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        updateDownloadInfoInner(r6, r0.getUpdateStatement());     // Catch: Throwable -> L15
        goto L22
    }

    private void safeEndTransaction() {
    L8:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "safeEndTransaction", "Error:" + th);
        return;
    L3:
        if (database != null) goto L5;
        return;
    L5:
        if (database.inTransaction() == false) goto L14;
        database.endTransaction();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadInfo(final int r2) {
        DownloadComponentManager.submitDBTask(new AnonymousClass15(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean removeDownloadTaskData(final int r2) {
        DownloadComponentManager.submitDBTask(new AnonymousClass16(this, r2));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void clearData() {
        DownloadComponentManager.submitDBTask(new AnonymousClass17(this));
    }

    private synchronized void clearDataInSubThread() {
        monitor-enter(this);
        safeBeginTransaction();     // Catch: Throwable -> L6
        database.delete(DBDefinition.DOWNLOAD_TABLE_NAME, null, null);     // Catch: Throwable -> L6
        database.setTransactionSuccessful();     // Catch: Throwable -> L6
    L4:
        safeEndTransaction();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        Logger.globalError(TAG, "clearDataInSubThread", "Error:" + th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        safeEndTransaction();     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskConnected(int r4, long r5, String r7, String r8) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 3);
        r0.put(DBDefinition.TOTAL_BYTES, Long.valueOf(r5));
        r0.put(DBDefinition.ETAG, r7);
        if (TextUtils.isEmpty(r8) == true) goto L5;
        r0.put("name", r8);
    L5:
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskProgress(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 4);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskError(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -1);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        if (r5 <= 0) goto L5;
        r0.put(DBDefinition.FIRST_DOWNLOAD, 0);
    L5:
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskRetry(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 5);
        r0.put(DBDefinition.FIRST_DOWNLOAD, 0);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCompleted(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -3);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        r0.put(DBDefinition.FIRST_DOWNLOAD, 0);
        r0.put(DBDefinition.FIRST_SUCCESS, 0);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPause(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -2);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskCancel(int r4, long r5) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -4);
        r0.put(DBDefinition.CUR_BYTES, Long.valueOf(r5));
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskPrepare(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", 1);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public DownloadInfo OnDownloadTaskIntercept(int r4) {
        ContentValues r0 = new ContentValues();
        r0.put("status", -7);
        update(r4, r0);
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public boolean isDownloadCacheSyncSuccess() {
        return this.cacheSynced;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public ArrayList<Segment> getSegments(int r1) {
        Map<Long, Segment> r0 = getSegmentMap(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == false) goto L8;
        return null;
    L8:
        return new ArrayList(r0.values());
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public Map<Long, Segment> getSegmentMap(int r11) {
        ensureDataBaseInit();
        if (database != null) goto L32;
    L29:
        return null;
    L32:
        Cursor r2 = database.rawQuery(String.format("SELECT * FROM %s WHERE %s = ?", new Object[]{DBDefinition.SEGMENT_TABLE_NAME, "_id"}), new String[]{Integer.toString(r11)});     // Catch: Throwable -> L22
    L20:
        th = th;
    L34:
        th.printStackTrace();     // Catch: Throwable -> L26
        Logger.taskError(TAG, r11, "getSegmentMap", "Error:" + th);     // Catch: Throwable -> L26
        DownloadUtils.safeClose(new Cursor[]{r2});
    L26:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r2});
        throw th;
    L7:
        if (r2.moveToNext() == false) goto L19;
        int r3 = r2.getColumnIndex(DBDefinition.SEGMENT_INFO);     // Catch: Throwable -> L20
        if (r3 < 0) goto L11;
        String r4 = r2.getString(r3);     // Catch: Throwable -> L20
    L12:
        HashMap r5 = new HashMap();     // Catch: Throwable -> L20
        JSONArray r6 = new JSONArray(r4);     // Catch: Throwable -> L20
        int r7 = 0;
    L13:
        if (r7 >= r6.length()) goto L17;
        Segment r8 = new Segment(r6.getJSONObject(r7));     // Catch: Throwable -> L20
        r5.put(Long.valueOf(r8.getStartOffset()), r8);     // Catch: Throwable -> L20
        r7 = r7 + 1;
        goto L13
    L17:
        DownloadUtils.safeClose(new Cursor[]{r2});
        return r5;
    L11:
        r4 = null;
        goto L12
    L19:
        DownloadUtils.safeClose(new Cursor[]{r2});
    L22:
        th = th;
        r2 = null;
        goto L34
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean updateSegments(int r7, Map<Long, Segment> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        ensureDataBaseInit();
        if (database != null) goto L5;
        return false;
    L5:
        JSONArray r0 = new JSONArray();
        Iterator r10 = r9.entrySet().iterator();     // Catch: Throwable -> L13
    L8:
        if (r10.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        if (r2.getValue() == null) goto L8;
        r0.put(((Segment) ZeusTransformUtils.preCheckCast(r2.getValue(), Segment.class, "com.obric.aiagent.plugin")).toJson());     // Catch: Throwable -> L13
    L15:
        SQLiteStatement r6 = this.segmentTableStatements.getInsertOrReplaceStatement();
        if (r6 != null) goto L19;
        Logger.taskError(TAG, r7, "updateSegments", "UpdateSegments statement is null");
        return false;
    L19:
        monitor-enter(r6);
        r6.clearBindings();     // Catch: Throwable -> L23
        r6.bindLong(1, r7);     // Catch: Throwable -> L23
        r6.bindString(2, r0.toString());     // Catch: Throwable -> L23
        r6.execute();     // Catch: Throwable -> L23
        monitor-exit(r6);     // Catch: Throwable -> L23
        return false;
    L23:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r7, "updateSegments", "Error:" + th);
        goto L15
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void removeSegments(int r3) {
        ensureDataBaseInit();
        if (database != null) goto L10;
        return;
    L10:
        deleteInner(r3, this.segmentTableStatements.getDeleteStatement());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r3, "removeSegments", "Error:" + th);
    }

    private void update(final int r2, final ContentValues r3) {
        DownloadComponentManager.submitDBTask(new AnonymousClass18(this, r2, r3));
    }

    private void updateInner(int r8, ContentValues r9) {
        int r1 = 10;
    L17:
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.taskError(TAG, r8, "updateInner", "Error2:" + th);
        return;
    L4:
        if (database.isDbLockedByCurrentThread() == false) goto L12;
        r1 = r1 - 1;
        if (r1 < 0) goto L12;
        Thread.sleep(5);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L14
        Logger.taskError(TAG, r8, "updateInner", "Error:" + th);     // Catch: Throwable -> L14
    L12:
        database.update(DBDefinition.DOWNLOAD_TABLE_NAME, r9, "_id = ? ", new String[]{String.valueOf(r8)});     // Catch: Throwable -> L14
    }

    @Override // com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl
    public void setInitCallback(ISqlCacheLoadCompleteCallbackAidl r3) {
        this.callback = (ISqlCacheLoadCompleteCallbackAidl) ZeusTransformUtils.wrapperContextForParams(r3, ISqlCacheLoadCompleteCallbackAidl.class, "com.obric.aiagent.plugin");
    }

    public void onInitFinish(SparseArray<DownloadInfo> r5, HashMap<Integer, Integer> r6, List<DownloadInfo> r7, boolean r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L14;
        Logger.globalDebug(TAG, "onInitFinish", "Run onInitFinish:" + this.callback);
    L14:
        HashMap r10 = DownloadHelper.sparseArrayToHashMap(r5);     // Catch: Throwable -> L9
        Map<Integer, DownloadInfo> r11 = DownloadHelper.listConvertToMap(r9);     // Catch: Throwable -> L9
        ISqlCacheLoadCompleteCallbackAidl r4 = this.callback;     // Catch: Throwable -> L9
        if (r4 == null) goto L16;
        r4.callback(r10, r6, r11, r8);     // Catch: Throwable -> L9
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (Logger.debug() == false) goto L17;
        Logger.globalDebug(TAG, "onInitFinish", "Error:" + th);
        return;
    }

    public static boolean checkCacheLifeTimeAndRemove(DownloadInfo r7) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r7.getCacheLifeTimeMax() > 0) goto L8;
        return false;
    L8:
        if (r7.getDownloadStartTimeStamp() > 0) goto L10;
        return false;
    L10:
        if ((r7.getDownloadStartTimeStamp() + (r7.getCacheLifeTimeMax() * 1000)) >= System.currentTimeMillis()) goto L15;
        DownloadUtils.deleteAllDownloadFiles(r7, true);
        return true;
    L15:
        return false;
    }

    private <T> T runImpl(Callable<T> r5, Fallback<T> r6) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.aiagent.plugin");
        Fallback r7 = (Fallback) ZeusTransformUtils.wrapperContextForParams(r6, Fallback.class, "com.obric.aiagent.plugin");
        int r8 = mainThreadDbOPMaxTime;
        if (r8 > 0) goto L5;
    L21:
        return r4.call();
    L14:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "runImpl", "Call Error: " + th);
    L16:
        if (r7 != null) goto L18;
        return null;
    L18:
        return (T) r7.getDefaultValue();
    L5:
        if (DownloadUtils.isMainThread() == false) goto L21;
        return DownloadComponentManager.getDBThreadExecutorService().submit(r4).get(r8, TimeUnit.MILLISECONDS);
    L10:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "runImpl", "Get Error: " + th);
        goto L16
    }
}
