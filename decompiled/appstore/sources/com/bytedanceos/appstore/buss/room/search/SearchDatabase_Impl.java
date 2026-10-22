package com.bytedanceos.appstore.buss.room.search;

import androidx.room.RoomDatabase;
import androidx.room.h;
import androidx.room.m;
import androidx.room.q0;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import b0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchDatabase_Impl extends SearchDatabase {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile SearchHistoryDao f8824r;

    public class a extends q0.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SearchDatabase_Impl f8825b;

        public a(SearchDatabase_Impl r10, int r11) {
            this.f8825b = r10;
            super(r11);
        }

        @Override // androidx.room.q0.b
        public void a(SupportSQLiteDatabase r10) {
            r10.execSQL("CREATE TABLE IF NOT EXISTS `tv_search_history_table` (`id` TEXT NOT NULL, `createTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            r10.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r10.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bd43c0ce2daa57c9cbdaa71fe99f0c6f')");
        }

        @Override // androidx.room.q0.b
        public void b(SupportSQLiteDatabase r10) {
            r10.execSQL("DROP TABLE IF EXISTS `tv_search_history_table`");
            List r11 = SearchDatabase_Impl.I(this.f8825b);
            if (r11 == null) goto L8;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L10;
            ((RoomDatabase.b) r12.next()).b(r10);
            goto L6
        L10:
            return;
        }

        @Override // androidx.room.q0.b
        public void c(SupportSQLiteDatabase r10) {
            List r11 = SearchDatabase_Impl.J(this.f8825b);
            if (r11 == null) goto L8;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L10;
            ((RoomDatabase.b) r12.next()).a(r10);
            goto L6
        L10:
            return;
        }

        @Override // androidx.room.q0.b
        public void d(SupportSQLiteDatabase r10) {
            SearchDatabase_Impl.K(this.f8825b, r10);
            SearchDatabase_Impl.L(this.f8825b, r10);
            List r11 = SearchDatabase_Impl.M(this.f8825b);
            if (r11 == null) goto L8;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L10;
            ((RoomDatabase.b) r12.next()).c(r10);
            goto L6
        L10:
            return;
        }

        @Override // androidx.room.q0.b
        public void e(SupportSQLiteDatabase r10) {
        }

        @Override // androidx.room.q0.b
        public void f(SupportSQLiteDatabase r10) {
            b.b(r10);
        }

        @Override // androidx.room.q0.b
        public q0.c g(SupportSQLiteDatabase r10) {
            HashMap r11 = new HashMap(2);
            r11.put("id", new TableInfo.a("id", "TEXT", true, 1, null, 1));
            r11.put("createTime", new TableInfo.a("createTime", "INTEGER", true, 0, null, 1));
            TableInfo r12 = new TableInfo("tv_search_history_table", r11, new HashSet(0), new HashSet(0));
            TableInfo r13 = TableInfo.a(r10, "tv_search_history_table");
            if (r12.equals(r13) == true) goto L7;
            return new q0.c(false, "tv_search_history_table(com.bytedanceos.appstore.buss.entity.bean.SearchHistoryEntityBean).\n Expected:\n" + r12 + "\n Found:\n" + r13);
        L7:
            return new q0.c(true, null);
        }
    }

    public SearchDatabase_Impl() {
    }

    public static /* synthetic */ List I(SearchDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List J(SearchDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ SupportSQLiteDatabase K(SearchDatabase_Impl r10, SupportSQLiteDatabase r11) {
        r10.f4459a = r11;
        return r11;
    }

    public static /* synthetic */ void L(SearchDatabase_Impl r10, SupportSQLiteDatabase r11) {
        r10.x(r11);
    }

    public static /* synthetic */ List M(SearchDatabase_Impl r10) {
        return r10.f4466h;
    }

    @Override // com.bytedanceos.appstore.buss.room.search.SearchDatabase
    public SearchHistoryDao H() {
        if (this.f8824r != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f8824r != null) goto L12;
        this.f8824r = new s7.a(this);     // Catch: Throwable -> L10
    L12:
        SearchHistoryDao r10 = this.f8824r;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f8824r;
    }

    @Override // androidx.room.RoomDatabase
    public m g() {
        return new m(this, new HashMap(0), new HashMap(0), new String[]{"tv_search_history_table"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper h(h r10) {
        q0 r11 = new q0(r10, new a(this, 1), "bd43c0ce2daa57c9cbdaa71fe99f0c6f", "2552aa8997755034c1c7293787d314ba");
        SupportSQLiteOpenHelper.b r12 = SupportSQLiteOpenHelper.b.a(r10.f4554a).d(r10.f4555b).c(r11).b();
        return r10.f4556c.create(r12);
    }

    @Override // androidx.room.RoomDatabase
    public List j(Map r10) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public Set p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map q() {
        HashMap r10 = new HashMap();
        r10.put(SearchHistoryDao.class, s7.a.d());
        return r10;
    }
}
