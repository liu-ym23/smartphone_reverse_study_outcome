package androidx.work.impl;

import android.content.Context;
import android.database.SQLException;
import androidx.appcompat.widget.l;
import androidx.room.RoomDatabase;
import androidx.room.f;
import androidx.room.k;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.stepos.core.common.notification.ModelDownloadNotifier;
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
import q2.h;
import q2.i;
import q2.m;
import q2.o;
import q2.q;
import q2.r;
import q2.u;
import v1.c;
import y1.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: l, reason: collision with root package name */
    public volatile r f2836l;

    /* renamed from: m, reason: collision with root package name */
    public volatile l f2837m;

    /* renamed from: n, reason: collision with root package name */
    public volatile androidx.preference.c f2838n;

    /* renamed from: o, reason: collision with root package name */
    public volatile g f2839o;

    /* renamed from: p, reason: collision with root package name */
    public volatile l f2840p;

    /* renamed from: q, reason: collision with root package name */
    public volatile g f2841q;
    public volatile l r;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends k.a {
        public a() {
            super(23);
        }

        @Override // androidx.room.k.a
        public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            frameworkSQLiteDatabase.n("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            frameworkSQLiteDatabase.n("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `trace_tag` TEXT, `required_network_type` INTEGER NOT NULL, `required_network_request` BLOB NOT NULL DEFAULT x'', `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
            frameworkSQLiteDatabase.n("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            frameworkSQLiteDatabase.n("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            frameworkSQLiteDatabase.n("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            frameworkSQLiteDatabase.n("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            frameworkSQLiteDatabase.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '86254750241babac4b8d52996a675549')");
        }

        @Override // androidx.room.k.a
        public final void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `Dependency`");
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `WorkSpec`");
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `WorkTag`");
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `SystemIdInfo`");
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `WorkName`");
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `WorkProgress`");
            frameworkSQLiteDatabase.n("DROP TABLE IF EXISTS `Preference`");
            List<? extends RoomDatabase.b> list = WorkDatabase_Impl.this.f2496f;
            if (list != null) {
                Iterator<? extends RoomDatabase.b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            }
        }

        @Override // androidx.room.k.a
        public final void c(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            List<? extends RoomDatabase.b> list = WorkDatabase_Impl.this.f2496f;
            if (list != null) {
                Iterator<? extends RoomDatabase.b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().getClass();
                }
            }
        }

        @Override // androidx.room.k.a
        public final void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
            WorkDatabase_Impl.this.f2491a = frameworkSQLiteDatabase;
            frameworkSQLiteDatabase.n("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.this.l(frameworkSQLiteDatabase);
            List<? extends RoomDatabase.b> list = WorkDatabase_Impl.this.f2496f;
            if (list != null) {
                Iterator<? extends RoomDatabase.b> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(frameworkSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.k.a
        public final void e(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            v1.b.a(frameworkSQLiteDatabase);
        }

        @Override // androidx.room.k.a
        public final k.b f(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            HashMap map = new HashMap(2);
            map.put("work_spec_id", new c.a("work_spec_id", "TEXT", true, 1, null, 1));
            map.put("prerequisite_id", new c.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new c.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(ModelDownloadNotifier.EXTRA_NOTIF_ID)));
            hashSet.add(new c.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList(ModelDownloadNotifier.EXTRA_NOTIF_ID)));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new c.d("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            hashSet2.add(new c.d("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
            v1.c cVar = new v1.c("Dependency", map, hashSet, hashSet2);
            v1.c cVarA = v1.c.a(frameworkSQLiteDatabase, "Dependency");
            if (!cVar.equals(cVarA)) {
                return new k.b("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + cVar + "\n Found:\n" + cVarA, false);
            }
            HashMap map2 = new HashMap(32);
            map2.put(ModelDownloadNotifier.EXTRA_NOTIF_ID, new c.a(ModelDownloadNotifier.EXTRA_NOTIF_ID, "TEXT", true, 1, null, 1));
            map2.put("state", new c.a("state", "INTEGER", true, 0, null, 1));
            map2.put("worker_class_name", new c.a("worker_class_name", "TEXT", true, 0, null, 1));
            map2.put("input_merger_class_name", new c.a("input_merger_class_name", "TEXT", true, 0, null, 1));
            map2.put("input", new c.a("input", "BLOB", true, 0, null, 1));
            map2.put("output", new c.a("output", "BLOB", true, 0, null, 1));
            map2.put("initial_delay", new c.a("initial_delay", "INTEGER", true, 0, null, 1));
            map2.put("interval_duration", new c.a("interval_duration", "INTEGER", true, 0, null, 1));
            map2.put("flex_duration", new c.a("flex_duration", "INTEGER", true, 0, null, 1));
            map2.put("run_attempt_count", new c.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            map2.put("backoff_policy", new c.a("backoff_policy", "INTEGER", true, 0, null, 1));
            map2.put("backoff_delay_duration", new c.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            map2.put("last_enqueue_time", new c.a("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
            map2.put("minimum_retention_duration", new c.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            map2.put("schedule_requested_at", new c.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            map2.put("run_in_foreground", new c.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            map2.put("out_of_quota_policy", new c.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            map2.put("period_count", new c.a("period_count", "INTEGER", true, 0, "0", 1));
            map2.put("generation", new c.a("generation", "INTEGER", true, 0, "0", 1));
            map2.put("next_schedule_time_override", new c.a("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
            map2.put("next_schedule_time_override_generation", new c.a("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
            map2.put("stop_reason", new c.a("stop_reason", "INTEGER", true, 0, "-256", 1));
            map2.put("trace_tag", new c.a("trace_tag", "TEXT", false, 0, null, 1));
            map2.put("required_network_type", new c.a("required_network_type", "INTEGER", true, 0, null, 1));
            map2.put("required_network_request", new c.a("required_network_request", "BLOB", true, 0, "x''", 1));
            map2.put("requires_charging", new c.a("requires_charging", "INTEGER", true, 0, null, 1));
            map2.put("requires_device_idle", new c.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            map2.put("requires_battery_not_low", new c.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            map2.put("requires_storage_not_low", new c.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            map2.put("trigger_content_update_delay", new c.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            map2.put("trigger_max_content_delay", new c.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            map2.put("content_uri_triggers", new c.a("content_uri_triggers", "BLOB", true, 0, null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new c.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
            hashSet4.add(new c.d("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
            v1.c cVar2 = new v1.c("WorkSpec", map2, hashSet3, hashSet4);
            v1.c cVarA2 = v1.c.a(frameworkSQLiteDatabase, "WorkSpec");
            if (!cVar2.equals(cVarA2)) {
                return new k.b("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + cVar2 + "\n Found:\n" + cVarA2, false);
            }
            HashMap map3 = new HashMap(2);
            map3.put("tag", new c.a("tag", "TEXT", true, 1, null, 1));
            map3.put("work_spec_id", new c.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new c.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(ModelDownloadNotifier.EXTRA_NOTIF_ID)));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new c.d("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            v1.c cVar3 = new v1.c("WorkTag", map3, hashSet5, hashSet6);
            v1.c cVarA3 = v1.c.a(frameworkSQLiteDatabase, "WorkTag");
            if (!cVar3.equals(cVarA3)) {
                return new k.b("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + cVar3 + "\n Found:\n" + cVarA3, false);
            }
            HashMap map4 = new HashMap(3);
            map4.put("work_spec_id", new c.a("work_spec_id", "TEXT", true, 1, null, 1));
            map4.put("generation", new c.a("generation", "INTEGER", true, 2, "0", 1));
            map4.put("system_id", new c.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new c.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(ModelDownloadNotifier.EXTRA_NOTIF_ID)));
            v1.c cVar4 = new v1.c("SystemIdInfo", map4, hashSet7, new HashSet(0));
            v1.c cVarA4 = v1.c.a(frameworkSQLiteDatabase, "SystemIdInfo");
            if (!cVar4.equals(cVarA4)) {
                return new k.b("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + cVar4 + "\n Found:\n" + cVarA4, false);
            }
            HashMap map5 = new HashMap(2);
            map5.put("name", new c.a("name", "TEXT", true, 1, null, 1));
            map5.put("work_spec_id", new c.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new c.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(ModelDownloadNotifier.EXTRA_NOTIF_ID)));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new c.d("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
            v1.c cVar5 = new v1.c("WorkName", map5, hashSet8, hashSet9);
            v1.c cVarA5 = v1.c.a(frameworkSQLiteDatabase, "WorkName");
            if (!cVar5.equals(cVarA5)) {
                return new k.b("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + cVar5 + "\n Found:\n" + cVarA5, false);
            }
            HashMap map6 = new HashMap(2);
            map6.put("work_spec_id", new c.a("work_spec_id", "TEXT", true, 1, null, 1));
            map6.put("progress", new c.a("progress", "BLOB", true, 0, null, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new c.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList(ModelDownloadNotifier.EXTRA_NOTIF_ID)));
            v1.c cVar6 = new v1.c("WorkProgress", map6, hashSet10, new HashSet(0));
            v1.c cVarA6 = v1.c.a(frameworkSQLiteDatabase, "WorkProgress");
            if (!cVar6.equals(cVarA6)) {
                return new k.b("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + cVar6 + "\n Found:\n" + cVarA6, false);
            }
            HashMap map7 = new HashMap(2);
            map7.put("key", new c.a("key", "TEXT", true, 1, null, 1));
            map7.put("long_value", new c.a("long_value", "INTEGER", false, 0, null, 1));
            v1.c cVar7 = new v1.c("Preference", map7, new HashSet(0), new HashSet(0));
            v1.c cVarA7 = v1.c.a(frameworkSQLiteDatabase, "Preference");
            if (cVar7.equals(cVarA7)) {
                return new k.b(null, true);
            }
            return new k.b("Preference(androidx.work.impl.model.Preference).\n Expected:\n" + cVar7 + "\n Found:\n" + cVarA7, false);
        }
    }

    @Override // androidx.room.RoomDatabase
    public final f e() {
        return new f(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    @Override // androidx.room.RoomDatabase
    public final y1.c f(androidx.room.c cVar) {
        k kVar = new k(cVar, new a(), "86254750241babac4b8d52996a675549", "1cbd3130fa23b59692c061c594c16cc0");
        Context context = cVar.f2526a;
        kotlin.jvm.internal.g.f(context, "context");
        return cVar.f2528c.b(new c.b(context, cVar.f2527b, kVar, false, false));
    }

    @Override // androidx.room.RoomDatabase
    public final List<u1.a> g(Map<Class<Object>, Object> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i2.c(13, 14, 5));
        arrayList.add(new i2.d(4));
        arrayList.add(new i2.c(16, 17, 6));
        arrayList.add(new i2.d(17, 18, 5));
        arrayList.add(new i2.c(18, 19, 7));
        arrayList.add(new i2.d(6));
        arrayList.add(new i2.c(20, 21, 8));
        arrayList.add(new i2.d(22, 23, 7));
        return arrayList;
    }

    @Override // androidx.room.RoomDatabase
    public final Set<Class<Object>> i() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map<Class<?>, List<Class<?>>> j() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(q.class, list);
        map.put(q2.b.class, list);
        map.put(u.class, list);
        map.put(h.class, list);
        map.put(m.class, list);
        map.put(o.class, list);
        map.put(q2.e.class, list);
        map.put(q2.f.class, list);
        return map;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final q2.b r() {
        l lVar;
        if (this.f2837m != null) {
            return this.f2837m;
        }
        synchronized (this) {
            try {
                if (this.f2837m == null) {
                    this.f2837m = new l(this, 5);
                }
                lVar = this.f2837m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final q2.e s() {
        l lVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new l(this);
                }
                lVar = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final h t() {
        g gVar;
        if (this.f2839o != null) {
            return this.f2839o;
        }
        synchronized (this) {
            try {
                if (this.f2839o == null) {
                    this.f2839o = new g(this, 3);
                }
                gVar = this.f2839o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final m u() {
        l lVar;
        if (this.f2840p != null) {
            return this.f2840p;
        }
        synchronized (this) {
            try {
                if (this.f2840p == null) {
                    this.f2840p = new l(this, 7);
                }
                lVar = this.f2840p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final o v() {
        g gVar;
        if (this.f2841q != null) {
            return this.f2841q;
        }
        synchronized (this) {
            try {
                if (this.f2841q == null) {
                    this.f2841q = new g(this, 4);
                }
                gVar = this.f2841q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final q w() {
        r rVar;
        if (this.f2836l != null) {
            return this.f2836l;
        }
        synchronized (this) {
            try {
                if (this.f2836l == null) {
                    this.f2836l = new r(this);
                }
                rVar = this.f2836l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return rVar;
    }

    @Override // androidx.work.impl.WorkDatabase
    public final u x() {
        androidx.preference.c cVar;
        if (this.f2838n != null) {
            return this.f2838n;
        }
        synchronized (this) {
            try {
                if (this.f2838n == null) {
                    androidx.preference.c cVar2 = new androidx.preference.c();
                    cVar2.f2400a = this;
                    cVar2.f2401b = new q2.c(this, 6);
                    new i(this, 9);
                    this.f2838n = cVar2;
                }
                cVar = this.f2838n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }
}
