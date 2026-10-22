package com.bytedance.framwork.core.sdklog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.android.contacts.dialpad.T9Search;
import com.bytedance.framwork.core.sdklib.DBHelper;

/* JADX INFO: loaded from: classes2.dex */
class LogQueueManager {
    static final String[] QUEUE_COLS = null;
    private static final String WHERE_ID = "_id = ?";
    private static LogQueueManager sInstance;
    private SQLiteDatabase mDb;

    static {
        QUEUE_COLS = new String[]{"_id", "value", "type", "timestamp", DBHelper.COL_RETRY_COUNT, DBHelper.COL_RETRY_TIME};
    }

    static LogQueueManager getInstance(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(LogQueueManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LogQueueManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(LogQueueManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private LogQueueManager(Context r1) {
        if (r1 != null) goto L8;
        return;
    L8:
        this.mDb = DBHelper.getInstance(r1).getWritableDatabase();     // Catch: Throwable -> L7
        return;
    }

    synchronized boolean isOpen() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L11:
        LogQueue.log("db not establish and open");     // Catch: Throwable -> L15
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L11;
        monitor-exit(this);
        return true;
    L15:
        th = move-exception;
        throw th;
    }

    synchronized long getEventCount(String r7) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        long r2 = 0;
        if (isOpen() == true) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        Cursor r1 = null;
        String r4 = "select count(*) from queue";
        if (TextUtils.isEmpty(r7) == true) goto L13;
        r4 = "select count(*) from queue " + r7;     // Catch: Throwable -> L22
    L13:
        r1 = this.mDb.rawQuery(r4, null);     // Catch: Throwable -> L22
        if (r1.moveToNext() == false) goto L16;
        r2 = r1.getLong(0);     // Catch: Throwable -> L22
    L16:
        safeCloseCursor(r1);     // Catch: Throwable -> L19
        monitor-exit(this);
        return r2;
    }

    synchronized void closeDatabase() {
        monitor-enter(this);
    L8:
        th = move-exception;
        LogQueue.log("closeDatabase error: " + th);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == false) goto L10;
        this.mDb.close();     // Catch: Throwable -> L8
        this.mDb = null;     // Catch: Throwable -> L8
        goto L10
    }

    synchronized long insertLog(String r4, byte[] r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (isOpen() == false) goto L12;
        if (r5 == null) goto L12;
        if (r5.length <= 0) goto L12;
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L15
        r0.put("value", r5);     // Catch: Throwable -> L15
        r0.put("type", r4);     // Catch: Throwable -> L15
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L15
        r0.put(DBHelper.COL_RETRY_COUNT, 0);     // Catch: Throwable -> L15
        r0.put(DBHelper.COL_RETRY_TIME, 0L);     // Catch: Throwable -> L15
        long r6 = this.mDb.insert(DBHelper.TABLE_QUEUE, null, r0);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r6;
    L12:
        monitor-exit(this);
        return -1;
    }

    synchronized void recreateTableQueue() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.mDb.execSQL("DROP TABLE IF EXISTS queue");     // Catch: Exception -> L10 Throwable -> L14
        this.mDb.execSQL(DBHelper.CREATE_TABLE_QUEUE);     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        LogQueue.log("recreateTableQueue db exception " + e);     // Catch: Throwable -> L14
        goto L12
    }

    synchronized void cleanExpireLog(String r7, int r8, long r9) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        long r3 = System.currentTimeMillis() - r9;     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r7) == false) goto L11;
        String r10 = "timestamp <= ? ";
        String[] r11 = {String.valueOf(r3)};     // Catch: Throwable -> L19
    L24:
        this.mDb.delete(DBHelper.TABLE_QUEUE, r10, r11);     // Catch: Exception -> L15 Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        LogQueue.log("delete expire log error:" + e);     // Catch: Throwable -> L19
        goto L17
    L11:
        String r12 = "(timestamp <= ? OR retry_count > " + r8 + ") and type = ?";     // Catch: Throwable -> L19
        String[] r13 = {String.valueOf(r3), r7};     // Catch: Throwable -> L19
        r10 = r12;
        r11 = r13;
        goto L24
    }

    synchronized LogItem getLog(long r13) {
        monitor-enter(this);
    L35:
        th = move-exception;
        throw th;
    L5:
        Cursor r2 = null;
        LogItem r3 = null;
        r2 = null;
        if (isOpen() == true) goto L41;
        monitor-exit(this);
        return null;
    L41:
        Cursor r14 = this.mDb.query(DBHelper.TABLE_QUEUE, QUEUE_COLS, "_id > ?", new String[]{String.valueOf(r13)}, null, null, T9Search.ContactQuery.CONTACT_SORT, "1");     // Catch: Throwable -> L24 Exception -> L26
    L19:
        th = th;
        r2 = r14;
    L33:
        safeCloseCursor(r2);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L21:
        e = e;
        LogItem r4 = null;
    L23:
        r2 = r14;
    L28:
        LogQueue.log("getLog exception " + e);     // Catch: Throwable -> L24
        safeCloseCursor(r2);     // Catch: Throwable -> L35
        r3 = r4;
    L31:
        monitor-exit(this);
        return r3;
    L11:
        if (r14.moveToNext() == false) goto L17;
        r4 = new LogItem();     // Catch: Throwable -> L19 Exception -> L21
        r4.id = r14.getLong(0);     // Catch: Exception -> L15 Throwable -> L19
        r4.value = r14.getBlob(1);     // Catch: Exception -> L15 Throwable -> L19
        r4.type = r14.getString(2);     // Catch: Exception -> L15 Throwable -> L19
        r4.timestamp = r14.getLong(3);     // Catch: Exception -> L15 Throwable -> L19
        r4.retryCount = r14.getInt(4);     // Catch: Exception -> L15 Throwable -> L19
        r4.retryTime = r14.getLong(5);     // Catch: Exception -> L15 Throwable -> L19
        r3 = r4;
        goto L17
    L15:
        e = e;
    L17:
        safeCloseCursor(r14);     // Catch: Throwable -> L35
    L26:
        e = e;
        r4 = null;
    L24:
        th = th;
        goto L33
    }

    synchronized boolean onLogSent(long r18, boolean r20, long r21, int r23) {
        monitor-enter(this);
    L48:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == true) goto L7;
    L46:
        monitor-exit(this);
        return false;
    L7:
        if (r18 <= 0) goto L46;
        boolean r0 = true;
        String[] r15 = {String.valueOf(r18)};     // Catch: Throwable -> L48
        if (r20 == true) goto L39;
        Cursor r16 = null;
        Cursor r7 = this.mDb.query(DBHelper.TABLE_QUEUE, new String[]{"timestamp", DBHelper.COL_RETRY_COUNT}, WHERE_ID, r15, null, null, null);     // Catch: Throwable -> L32 Exception -> L34
    L30:
        e = e;
        r16 = r7;
    L35:
        LogQueue.log("onLogSent exception: " + e);     // Catch: Throwable -> L32
        safeCloseCursor(r16);     // Catch: Throwable -> L48
        r0 = false;
    L28:
        th = th;
        r16 = r7;
    L37:
        safeCloseCursor(r16);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L14:
        if (r7.moveToNext() == true) goto L18;
        safeCloseCursor(r7);     // Catch: Throwable -> L48
        monitor-exit(this);
        return false;
    L18:
        long r8 = r7.getLong(0);     // Catch: Throwable -> L28 Exception -> L30
        int r10 = r7.getInt(1);     // Catch: Throwable -> L28 Exception -> L30
        long r11 = System.currentTimeMillis();     // Catch: Throwable -> L28 Exception -> L30
        if ((r11 - r8) < r21) goto L21;
    L26:
        safeCloseCursor(r7);     // Catch: Throwable -> L48
        goto L39
    L21:
        if (r10 >= r23) goto L26;
        ContentValues r9 = new ContentValues();     // Catch: Throwable -> L28 Exception -> L30
        r9.put(DBHelper.COL_RETRY_COUNT, Integer.valueOf(r10 + 1));     // Catch: Throwable -> L28 Exception -> L30
        r9.put(DBHelper.COL_RETRY_TIME, Long.valueOf(r11));     // Catch: Throwable -> L28 Exception -> L30
        this.mDb.update(DBHelper.TABLE_QUEUE, r9, WHERE_ID, r15);     // Catch: Throwable -> L28 Exception -> L30
        safeCloseCursor(r7);     // Catch: Throwable -> L48
        monitor-exit(this);
        return true;
    L34:
        e = e;
    L32:
        th = th;
    L39:
        if (r0 == true) goto L52;
        monitor-exit(this);
        return false;
    L52:
        this.mDb.delete(DBHelper.TABLE_QUEUE, WHERE_ID, r15);     // Catch: Throwable -> L51
    L41:
        LogQueue.log("delete app_log: " + r18);     // Catch: Throwable -> L48
        monitor-exit(this);
        return false;
    }

    static void safeCloseCursor(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }
}
