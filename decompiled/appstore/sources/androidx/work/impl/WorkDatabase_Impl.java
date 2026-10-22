package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.room.q0;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.ad.param.AdReportParam;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class WorkDatabase_Impl extends WorkDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile WorkSpecDao f5426q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile DependencyDao f5427r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile WorkTagDao f5428s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile SystemIdInfoDao f5429t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile WorkNameDao f5430u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile WorkProgressDao f5431v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile PreferenceDao f5432w;

    public class a extends q0.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WorkDatabase_Impl f5433b;

        public a(WorkDatabase_Impl r10, int r11) {
            this.f5433b = r10;
            super(r11);
        }

        @Override // androidx.room.q0.b
        public void a(SupportSQLiteDatabase r10) {
            r10.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r10.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            r10.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            r10.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r10.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
        }

        @Override // androidx.room.q0.b
        public void b(SupportSQLiteDatabase r10) {
            r10.execSQL("DROP TABLE IF EXISTS `Dependency`");
            r10.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            r10.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            r10.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            r10.execSQL("DROP TABLE IF EXISTS `WorkName`");
            r10.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
            r10.execSQL("DROP TABLE IF EXISTS `Preference`");
            if (WorkDatabase_Impl.N(this.f5433b) == null) goto L7;
            int r11 = WorkDatabase_Impl.O(this.f5433b).size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L9;
            ((RoomDatabase.b) WorkDatabase_Impl.Q(this.f5433b).get(r12)).b(r10);
            r12 = r12 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.q0.b
        public void c(SupportSQLiteDatabase r10) {
            if (WorkDatabase_Impl.R(this.f5433b) == null) goto L7;
            int r11 = WorkDatabase_Impl.S(this.f5433b).size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L9;
            ((RoomDatabase.b) WorkDatabase_Impl.T(this.f5433b).get(r12)).a(r10);
            r12 = r12 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.q0.b
        public void d(SupportSQLiteDatabase r10) {
            WorkDatabase_Impl.U(this.f5433b, r10);
            r10.execSQL("PRAGMA foreign_keys = ON");
            WorkDatabase_Impl.V(this.f5433b, r10);
            if (WorkDatabase_Impl.W(this.f5433b) == null) goto L7;
            int r11 = WorkDatabase_Impl.X(this.f5433b).size();
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L9;
            ((RoomDatabase.b) WorkDatabase_Impl.P(this.f5433b).get(r12)).c(r10);
            r12 = r12 + 1;
            goto L5
        L9:
            return;
        }

        @Override // androidx.room.q0.b
        public void e(SupportSQLiteDatabase r10) {
        }

        @Override // androidx.room.q0.b
        public void f(SupportSQLiteDatabase r10) {
            b0.b.b(r10);
        }

        @Override // androidx.room.q0.b
        public q0.c g(SupportSQLiteDatabase r29) {
            HashMap r10 = new HashMap(2);
            r10.put("work_spec_id", new TableInfo.a("work_spec_id", "TEXT", true, 1, null, 1));
            r10.put("prerequisite_id", new TableInfo.a("prerequisite_id", "TEXT", true, 2, null, 1));
            HashSet r11 = new HashSet(2);
            r11.add(new TableInfo.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            r11.add(new TableInfo.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
            HashSet r12 = new HashSet(2);
            r12.add(new TableInfo.e("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            r12.add(new TableInfo.e("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"ASC"})));
            TableInfo r13 = new TableInfo("Dependency", r10, r11, r12);
            TableInfo r14 = TableInfo.a(r29, "Dependency");
            if (r13.equals(r14) == false) goto L5;
            HashMap r15 = new HashMap(27);
            r15.put("id", new TableInfo.a("id", "TEXT", true, 1, null, 1));
            r15.put(WsConstants.KEY_CONNECTION_STATE, new TableInfo.a(WsConstants.KEY_CONNECTION_STATE, "INTEGER", true, 0, null, 1));
            r15.put("worker_class_name", new TableInfo.a("worker_class_name", "TEXT", true, 0, null, 1));
            r15.put("input_merger_class_name", new TableInfo.a("input_merger_class_name", "TEXT", false, 0, null, 1));
            r15.put("input", new TableInfo.a("input", "BLOB", true, 0, null, 1));
            r15.put("output", new TableInfo.a("output", "BLOB", true, 0, null, 1));
            r15.put("initial_delay", new TableInfo.a("initial_delay", "INTEGER", true, 0, null, 1));
            r15.put("interval_duration", new TableInfo.a("interval_duration", "INTEGER", true, 0, null, 1));
            r15.put("flex_duration", new TableInfo.a("flex_duration", "INTEGER", true, 0, null, 1));
            r15.put("run_attempt_count", new TableInfo.a("run_attempt_count", "INTEGER", true, 0, null, 1));
            r15.put("backoff_policy", new TableInfo.a("backoff_policy", "INTEGER", true, 0, null, 1));
            r15.put("backoff_delay_duration", new TableInfo.a("backoff_delay_duration", "INTEGER", true, 0, null, 1));
            r15.put("last_enqueue_time", new TableInfo.a("last_enqueue_time", "INTEGER", true, 0, null, 1));
            r15.put("minimum_retention_duration", new TableInfo.a("minimum_retention_duration", "INTEGER", true, 0, null, 1));
            r15.put("schedule_requested_at", new TableInfo.a("schedule_requested_at", "INTEGER", true, 0, null, 1));
            r15.put("run_in_foreground", new TableInfo.a("run_in_foreground", "INTEGER", true, 0, null, 1));
            r15.put("out_of_quota_policy", new TableInfo.a("out_of_quota_policy", "INTEGER", true, 0, null, 1));
            r15.put("period_count", new TableInfo.a("period_count", "INTEGER", true, 0, AdReportParam.ClickPosType.SKIP, 1));
            r15.put("generation", new TableInfo.a("generation", "INTEGER", true, 0, AdReportParam.ClickPosType.SKIP, 1));
            r15.put("required_network_type", new TableInfo.a("required_network_type", "INTEGER", true, 0, null, 1));
            r15.put("requires_charging", new TableInfo.a("requires_charging", "INTEGER", true, 0, null, 1));
            r15.put("requires_device_idle", new TableInfo.a("requires_device_idle", "INTEGER", true, 0, null, 1));
            r15.put("requires_battery_not_low", new TableInfo.a("requires_battery_not_low", "INTEGER", true, 0, null, 1));
            r15.put("requires_storage_not_low", new TableInfo.a("requires_storage_not_low", "INTEGER", true, 0, null, 1));
            r15.put("trigger_content_update_delay", new TableInfo.a("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
            r15.put("trigger_max_content_delay", new TableInfo.a("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
            r15.put("content_uri_triggers", new TableInfo.a("content_uri_triggers", "BLOB", true, 0, null, 1));
            HashSet r16 = new HashSet(0);
            HashSet r17 = new HashSet(2);
            r17.add(new TableInfo.e("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"}), Arrays.asList(new String[]{"ASC"})));
            r17.add(new TableInfo.e("index_WorkSpec_last_enqueue_time", false, Arrays.asList(new String[]{"last_enqueue_time"}), Arrays.asList(new String[]{"ASC"})));
            TableInfo r18 = new TableInfo("WorkSpec", r15, r16, r17);
            TableInfo r19 = TableInfo.a(r29, "WorkSpec");
            if (r18.equals(r19) == false) goto L9;
            HashMap r20 = new HashMap(2);
            r20.put("tag", new TableInfo.a("tag", "TEXT", true, 1, null, 1));
            r20.put("work_spec_id", new TableInfo.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet r21 = new HashSet(1);
            r21.add(new TableInfo.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet r22 = new HashSet(1);
            r22.add(new TableInfo.e("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            TableInfo r110 = new TableInfo("WorkTag", r20, r21, r22);
            TableInfo r23 = TableInfo.a(r29, "WorkTag");
            if (r110.equals(r23) == false) goto L13;
            HashMap r24 = new HashMap(3);
            r24.put("work_spec_id", new TableInfo.a("work_spec_id", "TEXT", true, 1, null, 1));
            r24.put("generation", new TableInfo.a("generation", "INTEGER", true, 2, AdReportParam.ClickPosType.SKIP, 1));
            r24.put("system_id", new TableInfo.a("system_id", "INTEGER", true, 0, null, 1));
            HashSet r25 = new HashSet(1);
            r25.add(new TableInfo.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            TableInfo r26 = new TableInfo("SystemIdInfo", r24, r25, new HashSet(0));
            TableInfo r27 = TableInfo.a(r29, "SystemIdInfo");
            if (r26.equals(r27) == false) goto L17;
            HashMap r28 = new HashMap(2);
            r28.put("name", new TableInfo.a("name", "TEXT", true, 1, null, 1));
            r28.put("work_spec_id", new TableInfo.a("work_spec_id", "TEXT", true, 2, null, 1));
            HashSet r30 = new HashSet(1);
            r30.add(new TableInfo.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            HashSet r31 = new HashSet(1);
            r31.add(new TableInfo.e("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
            TableInfo r32 = new TableInfo("WorkName", r28, r30, r31);
            TableInfo r33 = TableInfo.a(r29, "WorkName");
            if (r32.equals(r33) == false) goto L21;
            HashMap r34 = new HashMap(2);
            r34.put("work_spec_id", new TableInfo.a("work_spec_id", "TEXT", true, 1, null, 1));
            r34.put("progress", new TableInfo.a("progress", "BLOB", true, 0, null, 1));
            HashSet r35 = new HashSet(1);
            r35.add(new TableInfo.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
            TableInfo r36 = new TableInfo("WorkProgress", r34, r35, new HashSet(0));
            TableInfo r37 = TableInfo.a(r29, "WorkProgress");
            if (r36.equals(r37) == false) goto L25;
            HashMap r38 = new HashMap(2);
            r38.put("key", new TableInfo.a("key", "TEXT", true, 1, null, 1));
            r38.put("long_value", new TableInfo.a("long_value", "INTEGER", false, 0, null, 1));
            TableInfo r39 = new TableInfo("Preference", r38, new HashSet(0), new HashSet(0));
            TableInfo r40 = TableInfo.a(r29, "Preference");
            if (r39.equals(r40) == true) goto L31;
            return new q0.c(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + r39 + "\n Found:\n" + r40);
        L31:
            return new q0.c(true, null);
        L25:
            return new q0.c(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + r36 + "\n Found:\n" + r37);
        L21:
            return new q0.c(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + r32 + "\n Found:\n" + r33);
        L17:
            return new q0.c(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + r26 + "\n Found:\n" + r27);
        L13:
            return new q0.c(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + r110 + "\n Found:\n" + r23);
        L9:
            return new q0.c(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + r18 + "\n Found:\n" + r19);
        L5:
            return new q0.c(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + r13 + "\n Found:\n" + r14);
        }
    }

    public WorkDatabase_Impl() {
    }

    public static /* synthetic */ List N(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List O(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List P(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List Q(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List R(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List S(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List T(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ SupportSQLiteDatabase U(WorkDatabase_Impl r10, SupportSQLiteDatabase r11) {
        r10.f4459a = r11;
        return r11;
    }

    public static /* synthetic */ void V(WorkDatabase_Impl r10, SupportSQLiteDatabase r11) {
        r10.x(r11);
    }

    public static /* synthetic */ List W(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    public static /* synthetic */ List X(WorkDatabase_Impl r10) {
        return r10.f4466h;
    }

    @Override // androidx.work.impl.WorkDatabase
    public DependencyDao G() {
        if (this.f5427r != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f5427r != null) goto L12;
        this.f5427r = new androidx.work.impl.model.b(this);     // Catch: Throwable -> L10
    L12:
        DependencyDao r10 = this.f5427r;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f5427r;
    }

    @Override // androidx.work.impl.WorkDatabase
    public PreferenceDao H() {
        if (this.f5432w != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f5432w != null) goto L12;
        this.f5432w = new androidx.work.impl.model.d(this);     // Catch: Throwable -> L10
    L12:
        PreferenceDao r10 = this.f5432w;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f5432w;
    }

    @Override // androidx.work.impl.WorkDatabase
    public SystemIdInfoDao I() {
        if (this.f5429t != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f5429t != null) goto L12;
        this.f5429t = new androidx.work.impl.model.g(this);     // Catch: Throwable -> L10
    L12:
        SystemIdInfoDao r10 = this.f5429t;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f5429t;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkNameDao J() {
        if (this.f5430u != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f5430u != null) goto L12;
        this.f5430u = new androidx.work.impl.model.k(this);     // Catch: Throwable -> L10
    L12:
        WorkNameDao r10 = this.f5430u;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f5430u;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkProgressDao K() {
        if (this.f5431v != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f5431v != null) goto L12;
        this.f5431v = new androidx.work.impl.model.m(this);     // Catch: Throwable -> L10
    L12:
        WorkProgressDao r10 = this.f5431v;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f5431v;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkSpecDao L() {
        if (this.f5426q != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f5426q != null) goto L12;
        this.f5426q = new androidx.work.impl.model.p(this);     // Catch: Throwable -> L10
    L12:
        WorkSpecDao r10 = this.f5426q;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f5426q;
    }

    @Override // androidx.work.impl.WorkDatabase
    public WorkTagDao M() {
        if (this.f5428s != null) goto L5;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f5428s != null) goto L12;
        this.f5428s = new androidx.work.impl.model.s(this);     // Catch: Throwable -> L10
    L12:
        WorkTagDao r10 = this.f5428s;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return r10;
    L5:
        return this.f5428s;
    }

    @Override // androidx.room.RoomDatabase
    public androidx.room.m g() {
        return new androidx.room.m(this, new HashMap(0), new HashMap(0), new String[]{"Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper h(androidx.room.h r10) {
        q0 r11 = new q0(r10, new a(this, 16), "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e");
        SupportSQLiteOpenHelper.b r12 = SupportSQLiteOpenHelper.b.a(r10.f4554a).d(r10.f4555b).c(r11).b();
        return r10.f4556c.create(r12);
    }

    @Override // androidx.room.RoomDatabase
    public List j(Map r10) {
        return Arrays.asList(new a0.a[]{new a0(), new b0()});
    }

    @Override // androidx.room.RoomDatabase
    public Set p() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map q() {
        HashMap r10 = new HashMap();
        r10.put(WorkSpecDao.class, androidx.work.impl.model.p.f());
        r10.put(DependencyDao.class, androidx.work.impl.model.b.a());
        r10.put(WorkTagDao.class, androidx.work.impl.model.s.a());
        r10.put(SystemIdInfoDao.class, androidx.work.impl.model.g.a());
        r10.put(WorkNameDao.class, androidx.work.impl.model.k.a());
        r10.put(WorkProgressDao.class, androidx.work.impl.model.m.a());
        r10.put(PreferenceDao.class, androidx.work.impl.model.d.b());
        r10.put(RawWorkInfoDao.class, androidx.work.impl.model.e.a());
        return r10;
    }
}
