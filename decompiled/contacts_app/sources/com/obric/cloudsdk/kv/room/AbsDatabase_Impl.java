package com.obric.cloudsdk.kv.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.cloudsdk.kv.room.dao.DataSyncStateDao;
import com.obric.cloudsdk.kv.room.dao.DataSyncStateDao_Impl;
import com.obric.cloudsdk.kv.room.dao.KvFileInfoDao;
import com.obric.cloudsdk.kv.room.dao.KvFileInfoDao_Impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class AbsDatabase_Impl extends AbsDatabase {
    private volatile DataSyncStateDao _dataSyncStateDao;
    private volatile KvFileInfoDao _kvFileInfoDao;

    public AbsDatabase_Impl() {
    }

    static /* synthetic */ List access$000(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(AbsDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.mDatabase = r1;
        return r1;
    }

    static /* synthetic */ void access$700(AbsDatabase_Impl r0, SupportSQLiteDatabase r1) {
        r0.internalInitInvalidationTracker(r1);
    }

    static /* synthetic */ List access$800(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(AbsDatabase_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
        final int r2 = 2;
        RoomOpenHelper r0 = new RoomOpenHelper(configuration, new AnonymousClass1(this, r2), "a97891e790d9aed09d656a8a35dfabfb", "d08e729942d169bf760542657db576fa");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(configuration.context).name(configuration.name).callback(r0).build();
        return configuration.sqliteOpenHelperFactory.create(r3);
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"data_sync_state", "kv_file_info"});
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `data_sync_state`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `kv_file_info`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L15;
        r2.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L12;
        r2.execSQL("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r2 = new HashMap();
        r2.put(DataSyncStateDao.class, DataSyncStateDao_Impl.getRequiredConverters());
        r2.put(KvFileInfoDao.class, KvFileInfoDao_Impl.getRequiredConverters());
        return r2;
    }

    @Override // com.obric.cloudsdk.kv.room.AbsDatabase
    public DataSyncStateDao dataSyncStateDao() {
        if (this._dataSyncStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._dataSyncStateDao != null) goto L10;
        this._dataSyncStateDao = new DataSyncStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        DataSyncStateDao r0 = this._dataSyncStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._dataSyncStateDao;
    }

    @Override // com.obric.cloudsdk.kv.room.AbsDatabase
    public KvFileInfoDao kvFileInfoDao() {
        if (this._kvFileInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._kvFileInfoDao != null) goto L10;
        this._kvFileInfoDao = new KvFileInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        KvFileInfoDao r0 = this._kvFileInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._kvFileInfoDao;
    }
}
