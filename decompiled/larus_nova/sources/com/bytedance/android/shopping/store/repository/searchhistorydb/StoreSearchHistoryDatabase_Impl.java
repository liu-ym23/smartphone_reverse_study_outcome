package com.bytedance.android.shopping.store.repository.searchhistorydb;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tj3.b;
import tj3.f;

/* JADX INFO: loaded from: classes14.dex */
public final class StoreSearchHistoryDatabase_Impl extends StoreSearchHistoryDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile f f185783a;

    public class a extends RoomOpenHelper.Delegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StoreSearchHistoryDatabase_Impl f185784a;

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPostMigrate(SupportSQLiteDatabase r100) {
        }

        public a(StoreSearchHistoryDatabase_Impl r100) {
            this.f185784a = r100;
            super(1);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void createAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS `store_search_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user_id` TEXT, `store_id` TEXT, `key_word` TEXT, `time_stamp` INTEGER)");
            r100.execSQL(RoomMasterTable.CREATE_QUERY);
            r100.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9df35b2006b016f382caf1d1e77f8b66')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void dropAllTables(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `store_search_history`");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onCreate(SupportSQLiteDatabase r100) {
            if (StoreSearchHistoryDatabase_Impl.d(this.f185784a) == null) goto L7;
            int r101 = StoreSearchHistoryDatabase_Impl.e(this.f185784a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(StoreSearchHistoryDatabase_Impl.f(this.f185784a), r102)).onCreate(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onOpen(SupportSQLiteDatabase r100) {
            StoreSearchHistoryDatabase_Impl.g(this.f185784a, r100);
            this.f185784a.internalInitInvalidationTracker(r100);
            if (StoreSearchHistoryDatabase_Impl.h(this.f185784a) == null) goto L7;
            int r101 = StoreSearchHistoryDatabase_Impl.i(this.f185784a).size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(StoreSearchHistoryDatabase_Impl.j(this.f185784a), r102)).onOpen(r100);
            r102 = r102 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void onPreMigrate(SupportSQLiteDatabase r100) {
            DBUtil.dropFtsSyncTriggers(r100);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public final void validateMigration(SupportSQLiteDatabase r100) {
            HashMap r101 = new HashMap(5);
            r101.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
            r101.put("user_id", new TableInfo.Column("user_id", CardAdapter.TEXT, false, 0));
            r101.put("store_id", new TableInfo.Column("store_id", CardAdapter.TEXT, false, 0));
            r101.put("key_word", new TableInfo.Column("key_word", CardAdapter.TEXT, false, 0));
            r101.put("time_stamp", new TableInfo.Column("time_stamp", "INTEGER", false, 0));
            TableInfo r102 = new TableInfo("store_search_history", r101, new HashSet(0), new HashSet(0));
            TableInfo r103 = TableInfo.read(r100, "store_search_history");
            if (r102.equals(r103) == false) goto L6;
            return;
        L6:
            throw new IllegalStateException("Migration didn't properly handle store_search_history(com.bytedance.android.shopping.store.repository.dto.StoreSearchHistoryDTO).\n Expected:\n" + r102 + "\n Found:\n" + r103);
        }
    }

    @Override // com.bytedance.android.shopping.store.repository.searchhistorydb.StoreSearchHistoryDatabase
    public final b c() {
        if (this.f185783a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f185783a != null) goto L10;
        this.f185783a = new f(this);     // Catch: Throwable -> L13
    L10:
        f r100 = this.f185783a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L5:
        return this.f185783a;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r100 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r100.execSQL("DELETE FROM `store_search_history`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r100.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r100.inTransaction() == true) goto L15;
        r100.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r100.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r100.inTransaction() == true) goto L12;
        r100.execSQL("VACUUM");
    L12:
        throw th;
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"store_search_history"});
    }

    public StoreSearchHistoryDatabase_Impl() {
    }

    public static /* synthetic */ List d(StoreSearchHistoryDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List e(StoreSearchHistoryDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List f(StoreSearchHistoryDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List h(StoreSearchHistoryDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List i(StoreSearchHistoryDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    public static /* synthetic */ List j(StoreSearchHistoryDatabase_Impl r100) {
        return r100.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r100) {
        RoomOpenHelper r101 = new RoomOpenHelper(r100, new a(this), "9df35b2006b016f382caf1d1e77f8b66", "5265a9d32fd0f41c97e0ec0028750874");
        SupportSQLiteOpenHelper.Configuration r102 = SupportSQLiteOpenHelper.Configuration.builder(r100.context).name(r100.name).callback(r101).build();
        return r100.sqliteOpenHelperFactory.create(r102);
    }

    public static /* synthetic */ void g(StoreSearchHistoryDatabase_Impl r100, SupportSQLiteDatabase r101) {
        r100.mDatabase = r101;
    }
}
