package t0;

import androidx.work.impl.WorkDatabase_Impl;
import ch.qos.logback.core.joran.action.Action;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0910E extends androidx.room.B {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WorkDatabase_Impl f15319a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0910E(WorkDatabase_Impl workDatabase_Impl) {
        super(20);
        this.f15319a = workDatabase_Impl;
    }

    @Override // androidx.room.B
    public final void createAllTables(InterfaceC0674b interfaceC0674b) {
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        interfaceC0674b.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        interfaceC0674b.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT NOT NULL, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL DEFAULT -1, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `next_schedule_time_override` INTEGER NOT NULL DEFAULT 9223372036854775807, `next_schedule_time_override_generation` INTEGER NOT NULL DEFAULT 0, `stop_reason` INTEGER NOT NULL DEFAULT -256, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
        interfaceC0674b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        interfaceC0674b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        interfaceC0674b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        interfaceC0674b.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        interfaceC0674b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
    }

    @Override // androidx.room.B
    public final void dropAllTables(InterfaceC0674b db) {
        db.execSQL("DROP TABLE IF EXISTS `Dependency`");
        db.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
        db.execSQL("DROP TABLE IF EXISTS `WorkTag`");
        db.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
        db.execSQL("DROP TABLE IF EXISTS `WorkName`");
        db.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
        db.execSQL("DROP TABLE IF EXISTS `Preference`");
        WorkDatabase_Impl workDatabase_Impl = this.f15319a;
        if (((androidx.room.A) workDatabase_Impl).mCallbacks != null) {
            int size = ((androidx.room.A) workDatabase_Impl).mCallbacks.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((C0916b) ((androidx.room.A) workDatabase_Impl).mCallbacks.get(i4)).getClass();
                Intrinsics.checkNotNullParameter(db, "db");
            }
        }
    }

    @Override // androidx.room.B
    public final void onCreate(InterfaceC0674b db) {
        WorkDatabase_Impl workDatabase_Impl = this.f15319a;
        if (((androidx.room.A) workDatabase_Impl).mCallbacks != null) {
            int size = ((androidx.room.A) workDatabase_Impl).mCallbacks.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((C0916b) ((androidx.room.A) workDatabase_Impl).mCallbacks.get(i4)).getClass();
                Intrinsics.checkNotNullParameter(db, "db");
            }
        }
    }

    @Override // androidx.room.B
    public final void onOpen(InterfaceC0674b interfaceC0674b) {
        WorkDatabase_Impl workDatabase_Impl = this.f15319a;
        ((androidx.room.A) workDatabase_Impl).mDatabase = interfaceC0674b;
        interfaceC0674b.execSQL("PRAGMA foreign_keys = ON");
        workDatabase_Impl.internalInitInvalidationTracker(interfaceC0674b);
        if (((androidx.room.A) workDatabase_Impl).mCallbacks != null) {
            int size = ((androidx.room.A) workDatabase_Impl).mCallbacks.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((C0916b) ((androidx.room.A) workDatabase_Impl).mCallbacks.get(i4)).a(interfaceC0674b);
            }
        }
    }

    @Override // androidx.room.B
    public final void onPostMigrate(InterfaceC0674b interfaceC0674b) {
    }

    @Override // androidx.room.B
    public final void onPreMigrate(InterfaceC0674b interfaceC0674b) {
        J.u(interfaceC0674b);
    }

    @Override // androidx.room.B
    public final androidx.room.C onValidateSchema(InterfaceC0674b interfaceC0674b) {
        HashMap map = new HashMap(2);
        map.put("work_spec_id", new i0.b("work_spec_id", "TEXT", true, 1, null, 1));
        map.put("prerequisite_id", new i0.b("prerequisite_id", "TEXT", true, 2, null, 1));
        HashSet hashSet = new HashSet(2);
        hashSet.add(new i0.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        hashSet.add(new i0.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("prerequisite_id"), Arrays.asList("id")));
        HashSet hashSet2 = new HashSet(2);
        hashSet2.add(new i0.e("index_Dependency_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        hashSet2.add(new i0.e("index_Dependency_prerequisite_id", false, Arrays.asList("prerequisite_id"), Arrays.asList("ASC")));
        i0.f fVar = new i0.f("Dependency", map, hashSet, hashSet2);
        i0.f fVarA = i0.f.a(interfaceC0674b, "Dependency");
        if (!fVar.equals(fVarA)) {
            return new androidx.room.C(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + fVar + "\n Found:\n" + fVarA);
        }
        HashMap map2 = new HashMap(30);
        map2.put("id", new i0.b("id", "TEXT", true, 1, null, 1));
        map2.put("state", new i0.b("state", "INTEGER", true, 0, null, 1));
        map2.put("worker_class_name", new i0.b("worker_class_name", "TEXT", true, 0, null, 1));
        map2.put("input_merger_class_name", new i0.b("input_merger_class_name", "TEXT", true, 0, null, 1));
        map2.put("input", new i0.b("input", "BLOB", true, 0, null, 1));
        map2.put("output", new i0.b("output", "BLOB", true, 0, null, 1));
        map2.put("initial_delay", new i0.b("initial_delay", "INTEGER", true, 0, null, 1));
        map2.put("interval_duration", new i0.b("interval_duration", "INTEGER", true, 0, null, 1));
        map2.put("flex_duration", new i0.b("flex_duration", "INTEGER", true, 0, null, 1));
        map2.put("run_attempt_count", new i0.b("run_attempt_count", "INTEGER", true, 0, null, 1));
        map2.put("backoff_policy", new i0.b("backoff_policy", "INTEGER", true, 0, null, 1));
        map2.put("backoff_delay_duration", new i0.b("backoff_delay_duration", "INTEGER", true, 0, null, 1));
        map2.put("last_enqueue_time", new i0.b("last_enqueue_time", "INTEGER", true, 0, "-1", 1));
        map2.put("minimum_retention_duration", new i0.b("minimum_retention_duration", "INTEGER", true, 0, null, 1));
        map2.put("schedule_requested_at", new i0.b("schedule_requested_at", "INTEGER", true, 0, null, 1));
        map2.put("run_in_foreground", new i0.b("run_in_foreground", "INTEGER", true, 0, null, 1));
        map2.put("out_of_quota_policy", new i0.b("out_of_quota_policy", "INTEGER", true, 0, null, 1));
        map2.put("period_count", new i0.b("period_count", "INTEGER", true, 0, "0", 1));
        map2.put("generation", new i0.b("generation", "INTEGER", true, 0, "0", 1));
        map2.put("next_schedule_time_override", new i0.b("next_schedule_time_override", "INTEGER", true, 0, "9223372036854775807", 1));
        map2.put("next_schedule_time_override_generation", new i0.b("next_schedule_time_override_generation", "INTEGER", true, 0, "0", 1));
        map2.put("stop_reason", new i0.b("stop_reason", "INTEGER", true, 0, "-256", 1));
        map2.put("required_network_type", new i0.b("required_network_type", "INTEGER", true, 0, null, 1));
        map2.put("requires_charging", new i0.b("requires_charging", "INTEGER", true, 0, null, 1));
        map2.put("requires_device_idle", new i0.b("requires_device_idle", "INTEGER", true, 0, null, 1));
        map2.put("requires_battery_not_low", new i0.b("requires_battery_not_low", "INTEGER", true, 0, null, 1));
        map2.put("requires_storage_not_low", new i0.b("requires_storage_not_low", "INTEGER", true, 0, null, 1));
        map2.put("trigger_content_update_delay", new i0.b("trigger_content_update_delay", "INTEGER", true, 0, null, 1));
        map2.put("trigger_max_content_delay", new i0.b("trigger_max_content_delay", "INTEGER", true, 0, null, 1));
        map2.put("content_uri_triggers", new i0.b("content_uri_triggers", "BLOB", true, 0, null, 1));
        HashSet hashSet3 = new HashSet(0);
        HashSet hashSet4 = new HashSet(2);
        hashSet4.add(new i0.e("index_WorkSpec_schedule_requested_at", false, Arrays.asList("schedule_requested_at"), Arrays.asList("ASC")));
        hashSet4.add(new i0.e("index_WorkSpec_last_enqueue_time", false, Arrays.asList("last_enqueue_time"), Arrays.asList("ASC")));
        i0.f fVar2 = new i0.f("WorkSpec", map2, hashSet3, hashSet4);
        i0.f fVarA2 = i0.f.a(interfaceC0674b, "WorkSpec");
        if (!fVar2.equals(fVarA2)) {
            return new androidx.room.C(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + fVar2 + "\n Found:\n" + fVarA2);
        }
        HashMap map3 = new HashMap(2);
        map3.put("tag", new i0.b("tag", "TEXT", true, 1, null, 1));
        map3.put("work_spec_id", new i0.b("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet5 = new HashSet(1);
        hashSet5.add(new i0.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet6 = new HashSet(1);
        hashSet6.add(new i0.e("index_WorkTag_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        i0.f fVar3 = new i0.f("WorkTag", map3, hashSet5, hashSet6);
        i0.f fVarA3 = i0.f.a(interfaceC0674b, "WorkTag");
        if (!fVar3.equals(fVarA3)) {
            return new androidx.room.C(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + fVar3 + "\n Found:\n" + fVarA3);
        }
        HashMap map4 = new HashMap(3);
        map4.put("work_spec_id", new i0.b("work_spec_id", "TEXT", true, 1, null, 1));
        map4.put("generation", new i0.b("generation", "INTEGER", true, 2, "0", 1));
        map4.put("system_id", new i0.b("system_id", "INTEGER", true, 0, null, 1));
        HashSet hashSet7 = new HashSet(1);
        hashSet7.add(new i0.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        i0.f fVar4 = new i0.f("SystemIdInfo", map4, hashSet7, new HashSet(0));
        i0.f fVarA4 = i0.f.a(interfaceC0674b, "SystemIdInfo");
        if (!fVar4.equals(fVarA4)) {
            return new androidx.room.C(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + fVar4 + "\n Found:\n" + fVarA4);
        }
        HashMap map5 = new HashMap(2);
        map5.put("name", new i0.b("name", "TEXT", true, 1, null, 1));
        map5.put("work_spec_id", new i0.b("work_spec_id", "TEXT", true, 2, null, 1));
        HashSet hashSet8 = new HashSet(1);
        hashSet8.add(new i0.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        HashSet hashSet9 = new HashSet(1);
        hashSet9.add(new i0.e("index_WorkName_work_spec_id", false, Arrays.asList("work_spec_id"), Arrays.asList("ASC")));
        i0.f fVar5 = new i0.f("WorkName", map5, hashSet8, hashSet9);
        i0.f fVarA5 = i0.f.a(interfaceC0674b, "WorkName");
        if (!fVar5.equals(fVarA5)) {
            return new androidx.room.C(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + fVar5 + "\n Found:\n" + fVarA5);
        }
        HashMap map6 = new HashMap(2);
        map6.put("work_spec_id", new i0.b("work_spec_id", "TEXT", true, 1, null, 1));
        map6.put("progress", new i0.b("progress", "BLOB", true, 0, null, 1));
        HashSet hashSet10 = new HashSet(1);
        hashSet10.add(new i0.c("WorkSpec", "CASCADE", "CASCADE", Arrays.asList("work_spec_id"), Arrays.asList("id")));
        i0.f fVar6 = new i0.f("WorkProgress", map6, hashSet10, new HashSet(0));
        i0.f fVarA6 = i0.f.a(interfaceC0674b, "WorkProgress");
        if (!fVar6.equals(fVarA6)) {
            return new androidx.room.C(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + fVar6 + "\n Found:\n" + fVarA6);
        }
        HashMap map7 = new HashMap(2);
        map7.put(Action.KEY_ATTRIBUTE, new i0.b(Action.KEY_ATTRIBUTE, "TEXT", true, 1, null, 1));
        map7.put("long_value", new i0.b("long_value", "INTEGER", false, 0, null, 1));
        i0.f fVar7 = new i0.f("Preference", map7, new HashSet(0), new HashSet(0));
        i0.f fVarA7 = i0.f.a(interfaceC0674b, "Preference");
        if (fVar7.equals(fVarA7)) {
            return new androidx.room.C(true, null);
        }
        return new androidx.room.C(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + fVar7 + "\n Found:\n" + fVarA7);
    }
}
