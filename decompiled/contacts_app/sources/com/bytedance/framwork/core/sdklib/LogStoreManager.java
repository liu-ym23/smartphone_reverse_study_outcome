package com.bytedance.framwork.core.sdklib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.framwork.core.sdklib.model.LocalLog;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class LogStoreManager {
    private static final String CLAUSE_AID_EQUAL = "aid= ?";
    private static final String ORDER_BY_ID_ASC = "_id ASC ";
    static final String[] SAMPLE_LOG_COLS = null;
    private static String SQL_GET_TOTAL_COUNT = null;
    private static String SQL_GET_TOTAL_COUNT_AID = null;
    private static final String TAG = "LogStoreManager";
    static final int WEED_OUT_ROWS_SINGLE_TIME = 500;
    private static LogStoreManager instance = null;
    static boolean isCheckLegacyDb = false;
    static boolean isCheckedDbSize = false;
    static long sMaxLogSaveCount = 5000;
    private Map<String, Integer> mAidLogCountMap;
    private Context mContext;
    private SQLiteDatabase mDb;
    private int mFastReadSampleTimes;
    String sql;

    static {
        SAMPLE_LOG_COLS = new String[]{"_id", "data"};
        instance = null;
        SQL_GET_TOTAL_COUNT_AID = "SELECT count(*) FROM monitor_log WHERE aid = ?";
        SQL_GET_TOTAL_COUNT = "SELECT count(*) FROM monitor_log";
    }

    public static LogStoreManager getInstance(Context r2) {
        if (instance != null) goto L15;
        monitor-enter(DBHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new LogStoreManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DBHelper.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private LogStoreManager(Context r3) {
        this.mAidLogCountMap = new HashMap(2);
        this.mFastReadSampleTimes = 0;
        this.sql = "INSERT INTO monitor_log(aid,type,type2,time,data) VALUES ( ?, ?, ?, ?, ?)";
        this.mContext = r3;
        this.mDb = DBHelper.getInstance(r3).getWritableDatabase();
    }

    public synchronized void insertLocalLogBatch(String r7, List<LocalLog> r8) {
        monitor-enter(this);
    L41:
        th = move-exception;
        throw th;
    L4:
        if (this.mDb != null) goto L6;
    L39:
        monitor-exit(this);
        return;
    L6:
        if (ListUtils.isEmpty(r8) == true) goto L39;
        weedOutLogIfNeed();     // Catch: Throwable -> L41
        this.mDb.beginTransaction();     // Catch: Throwable -> L41
        SQLiteStatement r0 = this.mDb.compileStatement(this.sql);     // Catch: Throwable -> L29 Exception -> L31
        Iterator<LocalLog> r1 = r8.iterator();     // Catch: Throwable -> L29 Exception -> L31
    L11:
        if (r1.hasNext() == false) goto L25;
        LocalLog r2 = r1.next();     // Catch: Throwable -> L29 Exception -> L31
        r0.bindString(1, String.valueOf(r2.aid));     // Catch: Throwable -> L29 Exception -> L31
        if (r2.type != null) goto L15;
        String r3 = "";
    L16:
        r0.bindString(2, r3);     // Catch: Throwable -> L29 Exception -> L31
        if (r2.type2 != null) goto L19;
        String r4 = "";
    L20:
        r0.bindString(3, r4);     // Catch: Throwable -> L29 Exception -> L31
        r0.bindLong(4, r2.createTime);     // Catch: Throwable -> L29 Exception -> L31
        if (r2.data != null) goto L23;
        String r5 = "";
    L24:
        r0.bindString(5, r5);     // Catch: Throwable -> L29 Exception -> L31
        r0.executeInsert();     // Catch: Throwable -> L29 Exception -> L31
        goto L11
    L23:
        r5 = r2.data;     // Catch: Throwable -> L29 Exception -> L31
        goto L24
    L19:
        r4 = r2.type2;     // Catch: Throwable -> L29 Exception -> L31
        goto L20
    L15:
        r3 = r2.type;     // Catch: Throwable -> L29 Exception -> L31
        goto L16
    L25:
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L29 Exception -> L31
        addLogCountBuffer(r7, r8.size());     // Catch: Throwable -> L29 Exception -> L31
        SQLiteDatabase r9 = this.mDb;     // Catch: Throwable -> L41
    L27:
        r9.endTransaction();     // Catch: Throwable -> L41
        monitor-exit(this);
        return;
    L31:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
        r9 = this.mDb;     // Catch: Throwable -> L41
        goto L27
    L29:
        th = move-exception;
        this.mDb.endTransaction();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    }

    private void addLogCountBuffer(String r2, int r3) {
        if (this.mAidLogCountMap.containsKey(r2) == true) goto L6;
        if (r3 <= 0) goto L6;
        this.mAidLogCountMap.put(r2, Integer.valueOf(r3));
        return;
    L6:
        int r4 = Math.max(0, r3 + this.mAidLogCountMap.get(r2).intValue());
        this.mAidLogCountMap.put(r2, Integer.valueOf(r4));
    }

    public List<LocalLog> getLogsLimit(int r11, int r12) {
        Cursor r0 = null;
        Cursor r10 = this.mDb.query("monitor_log", SAMPLE_LOG_COLS, CLAUSE_AID_EQUAL, new String[]{String.valueOf(r11)}, null, null, ORDER_BY_ID_ASC, r12 + "");     // Catch: Throwable -> L18
    L15:
        r0 = r10;
        goto L16
    L5:
        if (r10.getCount() != 0) goto L8;
        safeCloseCursor(r10);
        return null;
    L8:
        LinkedList r13 = new LinkedList();     // Catch: Throwable -> L15
    L10:
        if (r10.moveToNext() == false) goto L13;
        r13.add(new LocalLog(r10.getLong(r10.getColumnIndex("_id")), r10.getString(r10.getColumnIndex("data"))));     // Catch: Throwable -> L15
        goto L10
    L13:
        safeCloseCursor(r10);
        return r13;
    L16:
        safeCloseCursor(r0);
        return Collections.emptyList();
    }

    public synchronized int deleteLogs(String r4, long r5) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mDb != null) goto L6;
    L11:
        monitor-exit(this);
        return -1;
    L6:
        if (r5 < 0) goto L11;
        int r6 = this.mDb.delete("monitor_log", "aid = ? AND _id<= ? ", new String[]{r4, String.valueOf(r5)});     // Catch: Throwable -> L14
        addLogCountBuffer(r4, r6 * (-1));     // Catch: Throwable -> L14
        monitor-exit(this);
        return r6;
    }

    private synchronized int getLogCountFromDbAid(String r7) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L21
        int r1 = -1;
        if (r0 != null) goto L6;
    L19:
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L19;
        Cursor r2 = null;
        r2 = this.mDb.rawQuery(SQL_GET_TOTAL_COUNT_AID, new String[]{r7});     // Catch: Exception -> L24 Throwable -> L14
        if (r2.moveToNext() == false) goto L13;
        r1 = r2.getInt(0);     // Catch: Exception -> L24 Throwable -> L14
        goto L13
    L14:
        th = move-exception;
        safeCloseCursor(r2);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L13:
        safeCloseCursor(r2);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r1;
    L21:
        th = move-exception;
        throw th;
    }

    private synchronized int getLogCountFromDb() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L20
        int r1 = -1;
        if (r0 != null) goto L6;
    L18:
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L18;
        Cursor r2 = null;
        r2 = this.mDb.rawQuery(SQL_GET_TOTAL_COUNT, null);     // Catch: Exception -> L23 Throwable -> L13
        if (r2.moveToNext() == false) goto L12;
        r1 = r2.getInt(0);     // Catch: Exception -> L23 Throwable -> L13
    L13:
        th = move-exception;
        safeCloseCursor(r2);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L12:
        safeCloseCursor(r2);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r1;
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized int getLogCount(String r4) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mFastReadSampleTimes <= 10) goto L6;
    L9:
        int r0 = getLogCountFromDbAid(r4);     // Catch: Throwable -> L13
        this.mAidLogCountMap.put(r4, Integer.valueOf(r0));     // Catch: Throwable -> L13
        this.mFastReadSampleTimes = 0;     // Catch: Throwable -> L13
        int r5 = r0;
    L11:
        monitor-exit(this);
        return r5;
    L6:
        if (this.mAidLogCountMap.containsKey(r4) == false) goto L9;
        r5 = this.mAidLogCountMap.get(r4).intValue();     // Catch: Throwable -> L13
        this.mFastReadSampleTimes++;     // Catch: Throwable -> L13
        goto L11
    }

    private synchronized void weedOutLogIfNeed() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (isCheckedDbSize == true) goto L9;
        isCheckedDbSize = true;     // Catch: Throwable -> L13
        if (getLogCountFromDb() < sMaxLogSaveCount) goto L9;
        weedOutOldLogs(500);     // Catch: Throwable -> L13
    L9:
        if (isCheckLegacyDb == true) goto L11;
        isCheckLegacyDb = true;     // Catch: Throwable -> L13
        deleteLegacyDb();     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
    }

    public synchronized void weedOutOldLogs(long r4) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mDb != null) goto L7;
    L15:
        monitor-exit(this);
        return;
    L7:
        if (r4 <= 0) goto L15;
        this.mDb.execSQL(" DELETE FROM monitor_log WHERE _id IN (SELECT _id FROM monitor_log ORDER BY _id ASC LIMIT " + r4 + ")");     // Catch: Exception -> L11 Throwable -> L17
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        goto L13
    }

    protected static void safeCloseCursor(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    synchronized boolean isOpen() {
        monitor-enter(this);
        monitor-exit(this);
        return true;
    }

    private void deleteLegacyDb() {
        deleteDb("psdkmon");
    }

    private void deleteDb(String r2) {
        File r1 = this.mContext.getDatabasePath(r2 + ".db");     // Catch: Exception -> L6
        if (r1.exists() == false) goto L9;
        r1.delete();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }
}
