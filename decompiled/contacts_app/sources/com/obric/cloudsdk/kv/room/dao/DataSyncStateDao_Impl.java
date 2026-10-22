package com.obric.cloudsdk.kv.room.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.cloudsdk.kv.base.KvConstant;
import com.obric.cloudsdk.kv.room.model.DataSyncStateModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class DataSyncStateDao_Impl implements DataSyncStateDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<DataSyncStateModel> __deletionAdapterOfDataSyncStateModel;
    private final EntityInsertionAdapter<DataSyncStateModel> __insertionAdapterOfDataSyncStateModel;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;
    private final EntityDeletionOrUpdateAdapter<DataSyncStateModel> __updateAdapterOfDataSyncStateModel;

    public DataSyncStateDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDataSyncStateModel = new AnonymousClass1(this, __db);
        this.__deletionAdapterOfDataSyncStateModel = new AnonymousClass2(this, __db);
        this.__updateAdapterOfDataSyncStateModel = new AnonymousClass3(this, __db);
        this.__preparedStmtOfUpdate = new AnonymousClass4(this, __db);
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public long insert(final DataSyncStateModel state) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfDataSyncStateModel.insertAndReturnId(state);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public void insertAll(final DataSyncStateModel... stateList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfDataSyncStateModel.insert(stateList);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public int delete(final DataSyncStateModel state) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r2 = this.__deletionAdapterOfDataSyncStateModel.handle(state) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r2;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public int delete(final List<DataSyncStateModel> stateList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r2 = this.__deletionAdapterOfDataSyncStateModel.handleMultiple(stateList) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r2;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public int update(final DataSyncStateModel syncStateModel) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r2 = this.__updateAdapterOfDataSyncStateModel.handle(syncStateModel) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r2;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public void updateAll(final DataSyncStateModel... fileList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfDataSyncStateModel.handleMultiple(fileList);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public int update(final String syncId, final long updateTime, final long updateTime2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdate.acquire();
        r0.bindLong(1, updateTime);
        r0.bindLong(2, updateTime2);
        if (syncId != null) goto L5;
        r0.bindNull(3);
    L6:
        this.__db.beginTransaction();
        int r3 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdate.release(r0);
        return r3;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdate.release(r0);
        throw th;
    L5:
        r0.bindString(3, syncId);
        goto L6
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public List<DataSyncStateModel> getAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("select * from data_sync_state", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "_id");     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, KvConstant.KV_DATA_ID);     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "uid");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "sync_id");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "operate_cursor");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "deleted");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "dirty");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "should_sync");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "table_name");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "last_update_time");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "last_sync_time");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "hash");     // Catch: Throwable -> L34
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "sync_type");     // Catch: Throwable -> L34
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, KvConstant.KV_CLOUD_ID);     // Catch: Throwable -> L34
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, KvConstant.KV_UNIQUE_ID);     // Catch: Throwable -> L32
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "last_update_time2");     // Catch: Throwable -> L32
        int r19 = r3;
        ArrayList r20 = new ArrayList(r2.getCount());     // Catch: Throwable -> L32
    L6:
        if (r2.moveToNext() == false) goto L30;
        int r21 = r14;
        int r22 = r15;
        long r110 = r2.getLong(r4);     // Catch: Throwable -> L32
        int r23 = r4;
        int r24 = r2.getInt(r10);     // Catch: Throwable -> L32
        if (r2.isNull(r11) == false) goto L11;
        String r111 = null;
    L12:
        DataSyncStateModel r112 = new DataSyncStateModel(r110, r111, r24);     // Catch: Throwable -> L32
        r112.set_id(r2.getInt(r0));     // Catch: Throwable -> L32
        if (r2.isNull(r5) == false) goto L15;
        String r25 = null;
    L16:
        r112.setUserId(r25);     // Catch: Throwable -> L32
        if (r2.isNull(r6) == false) goto L19;
        String r26 = null;
    L20:
        r112.setSyncId(r26);     // Catch: Throwable -> L32
        r112.setOperateCursor(r2.getLong(r7));     // Catch: Throwable -> L32
        r112.setDeleted(r2.getInt(r8));     // Catch: Throwable -> L32
        r112.setDirty(r2.getInt(r9));     // Catch: Throwable -> L32
        r112.setLastUpdateTime(r2.getLong(r12));     // Catch: Throwable -> L32
        r112.setLastSyncTime(r2.getLong(r13));     // Catch: Throwable -> L32
        r112.setHash(r2.getInt(r21));     // Catch: Throwable -> L32
        r112.setSyncType(r2.getInt(r22));     // Catch: Throwable -> L32
        int r113 = r19;
        if (r2.isNull(r113) == false) goto L23;
        String r114 = null;
    L24:
        r112.setCloudId(r114);     // Catch: Throwable -> L32
        int r115 = r17;
        if (r2.isNull(r115) == false) goto L27;
        String r116 = null;
    L28:
        r112.setUniqueId(r116);     // Catch: Throwable -> L32
        int r117 = r18;
        r112.setLastUpdateTime2(r2.getLong(r117));     // Catch: Throwable -> L32
        r20.add(r112);     // Catch: Throwable -> L32
        r19 = r113;
        r18 = r117;
        r15 = r22;
        r4 = r23;
        r11 = r11;
        r10 = r10;
        r17 = r115;
        r14 = r21;
        goto L6
    L27:
        r116 = r2.getString(r115);     // Catch: Throwable -> L32
        goto L28
    L23:
        r114 = r2.getString(r113);     // Catch: Throwable -> L32
        goto L24
    L19:
        r26 = r2.getString(r6);     // Catch: Throwable -> L32
        goto L20
    L15:
        r25 = r2.getString(r5);     // Catch: Throwable -> L32
        goto L16
    L11:
        r111 = r2.getString(r11);     // Catch: Throwable -> L32
        goto L12
    L30:
        r2.close();
        r16.release();
        return r20;
    L32:
        th = th;
    L36:
        r2.close();
        r16.release();
        throw th;
    L34:
        th = th;
        r16 = r1;
        goto L36
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public List<DataSyncStateModel> getDataSyncState(final long dataId, final String tableName) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("select * from data_sync_state where data_id = ? AND table_name = ?", 2);
        r2.bindLong(1, dataId);
        if (tableName != null) goto L5;
        r2.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "_id");     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, KvConstant.KV_DATA_ID);     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "uid");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "sync_id");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "operate_cursor");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "deleted");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "dirty");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "should_sync");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "table_name");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "last_update_time");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "last_sync_time");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "hash");     // Catch: Throwable -> L38
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "sync_type");     // Catch: Throwable -> L38
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, KvConstant.KV_CLOUD_ID);     // Catch: Throwable -> L38
        RoomSQLiteQuery r16 = r2;
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, KvConstant.KV_UNIQUE_ID);     // Catch: Throwable -> L36
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, "last_update_time2");     // Catch: Throwable -> L36
        int r24 = r3;
        ArrayList r17 = new ArrayList(r1.getCount());     // Catch: Throwable -> L36
    L10:
        if (r1.moveToNext() == false) goto L34;
        ArrayList r18 = r17;
        long r19 = r1.getLong(r4);     // Catch: Throwable -> L36
        int r110 = r4;
        int r20 = r1.getInt(r10);     // Catch: Throwable -> L36
        if (r1.isNull(r11) == false) goto L15;
        String r111 = null;
    L16:
        DataSyncStateModel r112 = new DataSyncStateModel(r19, r111, r20);     // Catch: Throwable -> L36
        r112.set_id(r1.getInt(r0));     // Catch: Throwable -> L36
        if (r1.isNull(r5) == false) goto L19;
        String r21 = null;
    L20:
        r112.setUserId(r21);     // Catch: Throwable -> L36
        if (r1.isNull(r6) == false) goto L23;
        String r25 = null;
    L24:
        r112.setSyncId(r25);     // Catch: Throwable -> L36
        r112.setOperateCursor(r1.getLong(r7));     // Catch: Throwable -> L36
        r112.setDeleted(r1.getInt(r8));     // Catch: Throwable -> L36
        r112.setDirty(r1.getInt(r9));     // Catch: Throwable -> L36
        r112.setLastUpdateTime(r1.getLong(r12));     // Catch: Throwable -> L36
        r112.setLastSyncTime(r1.getLong(r13));     // Catch: Throwable -> L36
        r112.setHash(r1.getInt(r14));     // Catch: Throwable -> L36
        r112.setSyncType(r1.getInt(r15));     // Catch: Throwable -> L36
        int r26 = r24;
        if (r1.isNull(r26) == false) goto L27;
        String r27 = null;
    L28:
        r112.setCloudId(r27);     // Catch: Throwable -> L36
        int r28 = r22;
        if (r1.isNull(r28) == false) goto L31;
        String r29 = null;
    L32:
        r112.setUniqueId(r29);     // Catch: Throwable -> L36
        int r30 = r23;
        r24 = r26;
        r22 = r28;
        r112.setLastUpdateTime2(r1.getLong(r30));     // Catch: Throwable -> L36
        r17 = r18;
        r17.add(r112);     // Catch: Throwable -> L36
        r23 = r30;
        r4 = r110;
        r11 = r11;
        r10 = r10;
        goto L10
    L31:
        r29 = r1.getString(r28);     // Catch: Throwable -> L36
        goto L32
    L27:
        r27 = r1.getString(r26);     // Catch: Throwable -> L36
        goto L28
    L23:
        r25 = r1.getString(r6);     // Catch: Throwable -> L36
        goto L24
    L19:
        r21 = r1.getString(r5);     // Catch: Throwable -> L36
        goto L20
    L15:
        r111 = r1.getString(r11);     // Catch: Throwable -> L36
        goto L16
    L34:
        r1.close();
        r16.release();
        return r17;
    L36:
        th = th;
    L40:
        r1.close();
        r16.release();
        throw th;
    L38:
        th = th;
        r16 = r2;
        goto L40
    L5:
        r2.bindString(2, tableName);
        goto L6
    }

    @Override // com.obric.cloudsdk.kv.room.dao.DataSyncStateDao
    public DataSyncStateModel getSyncId(final long dataId, final String tableName) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("select * from data_sync_state where data_id = ? AND table_name = ?", 2);
        r2.bindLong(1, dataId);
        if (tableName != null) goto L5;
        r2.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "_id");     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, KvConstant.KV_DATA_ID);     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "uid");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "sync_id");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "operate_cursor");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "deleted");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "dirty");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "should_sync");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "table_name");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "last_update_time");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "last_sync_time");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "hash");     // Catch: Throwable -> L38
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "sync_type");     // Catch: Throwable -> L38
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, KvConstant.KV_CLOUD_ID);     // Catch: Throwable -> L38
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, KvConstant.KV_UNIQUE_ID);     // Catch: Throwable -> L36
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "last_update_time2");     // Catch: Throwable -> L36
        if (r1.moveToFirst() == false) goto L33;
        long r19 = r1.getLong(r4);     // Catch: Throwable -> L36
        int r20 = r1.getInt(r10);     // Catch: Throwable -> L36
        if (r1.isNull(r11) == false) goto L14;
        String r110 = null;
    L15:
        DataSyncStateModel r111 = new DataSyncStateModel(r19, r110, r20);     // Catch: Throwable -> L36
        r111.set_id(r1.getInt(r0));     // Catch: Throwable -> L36
        if (r1.isNull(r5) == false) goto L18;
        String r21 = null;
    L19:
        r111.setUserId(r21);     // Catch: Throwable -> L36
        if (r1.isNull(r6) == false) goto L22;
        String r22 = null;
    L23:
        r111.setSyncId(r22);     // Catch: Throwable -> L36
        r111.setOperateCursor(r1.getLong(r7));     // Catch: Throwable -> L36
        r111.setDeleted(r1.getInt(r8));     // Catch: Throwable -> L36
        r111.setDirty(r1.getInt(r9));     // Catch: Throwable -> L36
        r111.setLastUpdateTime(r1.getLong(r12));     // Catch: Throwable -> L36
        r111.setLastSyncTime(r1.getLong(r13));     // Catch: Throwable -> L36
        r111.setHash(r1.getInt(r14));     // Catch: Throwable -> L36
        r111.setSyncType(r1.getInt(r15));     // Catch: Throwable -> L36
        if (r1.isNull(r3) == false) goto L26;
        String r23 = null;
    L27:
        r111.setCloudId(r23);     // Catch: Throwable -> L36
        if (r1.isNull(r17) == false) goto L30;
        String r24 = null;
    L31:
        r111.setUniqueId(r24);     // Catch: Throwable -> L36
        r111.setLastUpdateTime2(r1.getLong(r18));     // Catch: Throwable -> L36
        DataSyncStateModel r25 = r111;
    L34:
        r1.close();
        r16.release();
        return r25;
    L30:
        r24 = r1.getString(r17);     // Catch: Throwable -> L36
        goto L31
    L26:
        r23 = r1.getString(r3);     // Catch: Throwable -> L36
        goto L27
    L22:
        r22 = r1.getString(r6);     // Catch: Throwable -> L36
        goto L23
    L18:
        r21 = r1.getString(r5);     // Catch: Throwable -> L36
        goto L19
    L14:
        r110 = r1.getString(r11);     // Catch: Throwable -> L36
        goto L15
    L33:
        r25 = null;
    L36:
        th = th;
    L40:
        r1.close();
        r16.release();
        throw th;
    L38:
        th = th;
        r16 = r2;
        goto L40
    L5:
        r2.bindString(2, tableName);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
