package com.obric.cloudsdk.kv.room.dao;

import android.database.Cursor;
import androidx.core.provider.FontsContractCompat;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.cloudsdk.kv.room.model.KvFileInfoModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class KvFileInfoDao_Impl implements KvFileInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<KvFileInfoModel> __insertionAdapterOfKvFileInfoModel;
    private final EntityDeletionOrUpdateAdapter<KvFileInfoModel> __updateAdapterOfKvFileInfoModel;

    public KvFileInfoDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfKvFileInfoModel = new AnonymousClass1(this, __db);
        this.__updateAdapterOfKvFileInfoModel = new AnonymousClass2(this, __db);
    }

    @Override // com.obric.cloudsdk.kv.room.dao.KvFileInfoDao
    public long insert(final KvFileInfoModel file) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfKvFileInfoModel.insertAndReturnId(file);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.KvFileInfoDao
    public void insertAll(final KvFileInfoModel... fileList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfKvFileInfoModel.insert(fileList);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.KvFileInfoDao
    public int update(final KvFileInfoModel file) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r2 = this.__updateAdapterOfKvFileInfoModel.handle(file) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r2;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.KvFileInfoDao
    public void updateAll(final KvFileInfoModel... fileList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfKvFileInfoModel.handleMultiple(fileList);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.KvFileInfoDao
    public List<KvFileInfoModel> getAll() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("select * from kv_file_info", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r12, "_id");     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r12, "local_path");     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r12, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r12, "user_id");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r12, PerfConsts.PERF_DISK_FILE_SIZE);     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r12, "md5");     // Catch: Throwable -> L30
        ArrayList r8 = new ArrayList(r12.getCount());     // Catch: Throwable -> L30
    L4:
        if (r12.moveToNext() == false) goto L28;
        KvFileInfoModel r9 = new KvFileInfoModel();     // Catch: Throwable -> L30
        r9.set_id(r12.getInt(r1));     // Catch: Throwable -> L30
        if (r12.isNull(r3) == false) goto L9;
        String r10 = null;
    L10:
        r9.setLocalPath(r10);     // Catch: Throwable -> L30
        if (r12.isNull(r4) == false) goto L13;
        String r11 = null;
    L14:
        r9.setFileId(r11);     // Catch: Throwable -> L30
        if (r12.isNull(r5) == false) goto L17;
        String r13 = null;
    L18:
        r9.setUserId(r13);     // Catch: Throwable -> L30
        if (r12.isNull(r6) == false) goto L21;
        Long r14 = null;
    L22:
        r9.setSize(r14);     // Catch: Throwable -> L30
        if (r12.isNull(r7) == false) goto L25;
        String r15 = null;
    L26:
        r9.setMd5(r15);     // Catch: Throwable -> L30
        r8.add(r9);     // Catch: Throwable -> L30
        goto L4
    L25:
        r15 = r12.getString(r7);     // Catch: Throwable -> L30
        goto L26
    L21:
        r14 = Long.valueOf(r12.getLong(r6));     // Catch: Throwable -> L30
        goto L22
    L17:
        r13 = r12.getString(r5);     // Catch: Throwable -> L30
        goto L18
    L13:
        r11 = r12.getString(r4);     // Catch: Throwable -> L30
        goto L14
    L9:
        r10 = r12.getString(r3);     // Catch: Throwable -> L30
        goto L10
    L28:
        r12.close();
        r0.release();
        return r8;
    L30:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.KvFileInfoDao
    public KvFileInfoModel getByFileId(String r9) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("select * from kv_file_info where file_id = ?", 1);
        if (r9 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        KvFileInfoModel r1 = null;
        String r2 = null;
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "_id");     // Catch: Throwable -> L33
        int r3 = CursorUtil.getColumnIndexOrThrow(r8, "local_path");     // Catch: Throwable -> L33
        int r4 = CursorUtil.getColumnIndexOrThrow(r8, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L33
        int r5 = CursorUtil.getColumnIndexOrThrow(r8, "user_id");     // Catch: Throwable -> L33
        int r6 = CursorUtil.getColumnIndexOrThrow(r8, PerfConsts.PERF_DISK_FILE_SIZE);     // Catch: Throwable -> L33
        int r7 = CursorUtil.getColumnIndexOrThrow(r8, "md5");     // Catch: Throwable -> L33
        if (r8.moveToFirst() == false) goto L31;
        KvFileInfoModel r11 = new KvFileInfoModel();     // Catch: Throwable -> L33
        r11.set_id(r8.getInt(r10));     // Catch: Throwable -> L33
        if (r8.isNull(r3) == false) goto L12;
        String r12 = null;
    L13:
        r11.setLocalPath(r12);     // Catch: Throwable -> L33
        if (r8.isNull(r4) == false) goto L16;
        String r13 = null;
    L17:
        r11.setFileId(r13);     // Catch: Throwable -> L33
        if (r8.isNull(r5) == false) goto L20;
        String r14 = null;
    L21:
        r11.setUserId(r14);     // Catch: Throwable -> L33
        if (r8.isNull(r6) == false) goto L24;
        Long r15 = null;
    L25:
        r11.setSize(r15);     // Catch: Throwable -> L33
        if (r8.isNull(r7) == true) goto L29;
        r2 = r8.getString(r7);     // Catch: Throwable -> L33
    L29:
        r11.setMd5(r2);     // Catch: Throwable -> L33
        r1 = r11;
        goto L31
    L24:
        r15 = Long.valueOf(r8.getLong(r6));     // Catch: Throwable -> L33
        goto L25
    L20:
        r14 = r8.getString(r5);     // Catch: Throwable -> L33
        goto L21
    L16:
        r13 = r8.getString(r4);     // Catch: Throwable -> L33
        goto L17
    L12:
        r12 = r8.getString(r3);     // Catch: Throwable -> L33
    L31:
        r8.close();
        r0.release();
        return r1;
    L33:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r9);
        goto L6
    }

    @Override // com.obric.cloudsdk.kv.room.dao.KvFileInfoDao
    public KvFileInfoModel getByLocalPath(String r9) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("select * from kv_file_info where local_path = ?", 1);
        if (r9 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        KvFileInfoModel r1 = null;
        String r2 = null;
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "_id");     // Catch: Throwable -> L33
        int r3 = CursorUtil.getColumnIndexOrThrow(r8, "local_path");     // Catch: Throwable -> L33
        int r4 = CursorUtil.getColumnIndexOrThrow(r8, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L33
        int r5 = CursorUtil.getColumnIndexOrThrow(r8, "user_id");     // Catch: Throwable -> L33
        int r6 = CursorUtil.getColumnIndexOrThrow(r8, PerfConsts.PERF_DISK_FILE_SIZE);     // Catch: Throwable -> L33
        int r7 = CursorUtil.getColumnIndexOrThrow(r8, "md5");     // Catch: Throwable -> L33
        if (r8.moveToFirst() == false) goto L31;
        KvFileInfoModel r11 = new KvFileInfoModel();     // Catch: Throwable -> L33
        r11.set_id(r8.getInt(r10));     // Catch: Throwable -> L33
        if (r8.isNull(r3) == false) goto L12;
        String r12 = null;
    L13:
        r11.setLocalPath(r12);     // Catch: Throwable -> L33
        if (r8.isNull(r4) == false) goto L16;
        String r13 = null;
    L17:
        r11.setFileId(r13);     // Catch: Throwable -> L33
        if (r8.isNull(r5) == false) goto L20;
        String r14 = null;
    L21:
        r11.setUserId(r14);     // Catch: Throwable -> L33
        if (r8.isNull(r6) == false) goto L24;
        Long r15 = null;
    L25:
        r11.setSize(r15);     // Catch: Throwable -> L33
        if (r8.isNull(r7) == true) goto L29;
        r2 = r8.getString(r7);     // Catch: Throwable -> L33
    L29:
        r11.setMd5(r2);     // Catch: Throwable -> L33
        r1 = r11;
        goto L31
    L24:
        r15 = Long.valueOf(r8.getLong(r6));     // Catch: Throwable -> L33
        goto L25
    L20:
        r14 = r8.getString(r5);     // Catch: Throwable -> L33
        goto L21
    L16:
        r13 = r8.getString(r4);     // Catch: Throwable -> L33
        goto L17
    L12:
        r12 = r8.getString(r3);     // Catch: Throwable -> L33
    L31:
        r8.close();
        r0.release();
        return r1;
    L33:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r9);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
