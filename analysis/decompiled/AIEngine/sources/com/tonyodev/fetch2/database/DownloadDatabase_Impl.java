package com.tonyodev.fetch2.database;

import android.content.Context;
import android.database.SQLException;
import androidx.room.RoomDatabase;
import androidx.room.f;
import androidx.room.k;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.stepos.statsrpk.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import q2.j;
import q2.s;
import v1.b;
import v1.c;
import y1.c;
import za.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadDatabase_Impl extends DownloadDatabase {

    /* renamed from: l, reason: collision with root package name */
    public volatile g f8200l;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends k.a {
        public a() {
            super(7);
        }

        @Override // androidx.room.k.a
        public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `requests` (`_id` INTEGER NOT NULL, `_namespace` TEXT NOT NULL, `_url` TEXT NOT NULL, `_file` TEXT NOT NULL, `_group` INTEGER NOT NULL, `_priority` INTEGER NOT NULL, `_headers` TEXT NOT NULL, `_written_bytes` INTEGER NOT NULL, `_total_bytes` INTEGER NOT NULL, `_status` INTEGER NOT NULL, `_error` INTEGER NOT NULL, `_network_type` INTEGER NOT NULL, `_created` INTEGER NOT NULL, `_tag` TEXT, `_enqueue_action` INTEGER NOT NULL, `_identifier` INTEGER NOT NULL, `_download_on_enqueue` INTEGER NOT NULL, `_extras` TEXT NOT NULL, `_auto_retry_max_attempts` INTEGER NOT NULL, `_auto_retry_attempts` INTEGER NOT NULL, PRIMARY KEY(`_id`))");
            frameworkSQLiteDatabase.n("CREATE UNIQUE INDEX IF NOT EXISTS `index_requests__file` ON `requests` (`_file`)");
            frameworkSQLiteDatabase.n("CREATE INDEX IF NOT EXISTS `index_requests__group__status` ON `requests` (`_group`, `_status`)");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            frameworkSQLiteDatabase.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '460643a974555d792b8f5a6e1a5d323c')");
        }

        @Override // androidx.room.k.a
        public final void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `requests`");
            List<? extends RoomDatabase.b> list = DownloadDatabase_Impl.this.f2496f;
            if (list != null) {
                Iterator<? extends RoomDatabase.b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            }
        }

        @Override // androidx.room.k.a
        public final void c(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            List<? extends RoomDatabase.b> list = DownloadDatabase_Impl.this.f2496f;
            if (list != null) {
                Iterator<? extends RoomDatabase.b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            }
        }

        @Override // androidx.room.k.a
        public final void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            DownloadDatabase_Impl.this.f2491a = frameworkSQLiteDatabase;
            DownloadDatabase_Impl.this.l(frameworkSQLiteDatabase);
            List<? extends RoomDatabase.b> list = DownloadDatabase_Impl.this.f2496f;
            if (list != null) {
                Iterator<? extends RoomDatabase.b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(frameworkSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.k.a
        public final void e(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            b.a(frameworkSQLiteDatabase);
        }

        @Override // androidx.room.k.a
        public final k.b f(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            HashMap map = new HashMap(20);
            map.put("_id", new c.a("_id", "INTEGER", true, 1, null, 1));
            map.put("_namespace", new c.a("_namespace", "TEXT", true, 0, null, 1));
            map.put("_url", new c.a("_url", "TEXT", true, 0, null, 1));
            map.put("_file", new c.a("_file", "TEXT", true, 0, null, 1));
            map.put("_group", new c.a("_group", "INTEGER", true, 0, null, 1));
            map.put("_priority", new c.a("_priority", "INTEGER", true, 0, null, 1));
            map.put("_headers", new c.a("_headers", "TEXT", true, 0, null, 1));
            map.put("_written_bytes", new c.a("_written_bytes", "INTEGER", true, 0, null, 1));
            map.put("_total_bytes", new c.a("_total_bytes", "INTEGER", true, 0, null, 1));
            map.put("_status", new c.a("_status", "INTEGER", true, 0, null, 1));
            map.put("_error", new c.a("_error", "INTEGER", true, 0, null, 1));
            map.put("_network_type", new c.a("_network_type", "INTEGER", true, 0, null, 1));
            map.put("_created", new c.a("_created", "INTEGER", true, 0, null, 1));
            map.put("_tag", new c.a("_tag", "TEXT", false, 0, null, 1));
            map.put("_enqueue_action", new c.a("_enqueue_action", "INTEGER", true, 0, null, 1));
            map.put("_identifier", new c.a("_identifier", "INTEGER", true, 0, null, 1));
            map.put("_download_on_enqueue", new c.a("_download_on_enqueue", "INTEGER", true, 0, null, 1));
            map.put("_extras", new c.a("_extras", "TEXT", true, 0, null, 1));
            map.put("_auto_retry_max_attempts", new c.a("_auto_retry_max_attempts", "INTEGER", true, 0, null, 1));
            map.put("_auto_retry_attempts", new c.a("_auto_retry_attempts", "INTEGER", true, 0, null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new c.d("index_requests__file", true, Arrays.asList("_file"), Arrays.asList("ASC")));
            hashSet2.add(new c.d("index_requests__group__status", false, Arrays.asList("_group", "_status"), Arrays.asList("ASC", "ASC")));
            c cVar = new c("requests", map, hashSet, hashSet2);
            c cVarA = c.a(frameworkSQLiteDatabase, "requests");
            if (cVar.equals(cVarA)) {
                return new k.b(null, true);
            }
            return new k.b("requests(com.tonyodev.fetch2.database.DownloadInfo).\n Expected:\n" + cVar + "\n Found:\n" + cVarA, false);
        }
    }

    @Override // androidx.room.RoomDatabase
    public final f e() {
        return new f(this, new HashMap(0), new HashMap(0), "requests");
    }

    @Override // androidx.room.RoomDatabase
    public final y1.c f(androidx.room.c cVar) {
        k kVar = new k(cVar, new a(), "460643a974555d792b8f5a6e1a5d323c", "946eca6b182e63ebe50cf82e483715bf");
        Context context = cVar.f2526a;
        kotlin.jvm.internal.g.f(context, "context");
        return cVar.f2528c.b(new c.b(context, cVar.f2527b, kVar, false, false));
    }

    @Override // androidx.room.RoomDatabase
    public final List<u1.a> g(Map<Class<Object>, Object> map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public final Set<Class<Object>> i() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map<Class<?>, List<Class<?>>> j() {
        HashMap map = new HashMap();
        map.put(za.b.class, Collections.EMPTY_LIST);
        return map;
    }

    @Override // com.tonyodev.fetch2.database.DownloadDatabase
    public final za.b r() {
        g gVar;
        if (this.f8200l != null) {
            return this.f8200l;
        }
        synchronized (this) {
            try {
                if (this.f8200l == null) {
                    g gVar2 = new g();
                    gVar2.f8087a = this;
                    gVar2.f8088b = new za.c(this, 1);
                    gVar2.f8089c = new d(this);
                    gVar2.f8090d = new s(gVar2, this);
                    new j(this, 10);
                    this.f8200l = gVar2;
                }
                gVar = this.f8200l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }
}
