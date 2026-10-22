package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import android.app.Application;
import android.content.Context;
import androidx.room.p;
import com.obric.aiagent.platform.depend.IAppContext;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: TaskDatabase.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TaskDatabase extends p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f16687e = null;
    private static final b f = null;
    private static final c g = null;
    private static final d h = null;
    private static final e i = null;
    private static final f j = null;
    private static final g k = null;

    /* JADX INFO: compiled from: TaskDatabase.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TaskDatabase.kt */
        public static final class C0340a extends p.b {
            @Override // androidx.room.p.b
            public void a(androidx.sqlite.db.c r2) {
                o.e((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"), MonitorConstants.DB);
            }

            C0340a() {
            }
        }

        /* JADX INFO: compiled from: TaskDatabase.kt */
        public static final class b extends p.b {
            @Override // androidx.room.p.b
            public void a(androidx.sqlite.db.c r2) {
                o.e((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"), MonitorConstants.DB);
            }

            b() {
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        public final String a() {
            return "condition_task.db";
        }

        private a() {
        }

        public final String a(String r2) {
            o.e(r2, "userId");
            return "condition_task_" + r2 + ".db";
        }

        public final TaskDatabase b(String r5) {
            o.e(r5, "userId");
            p r4 = androidx.room.o.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), TaskDatabase.class, a(r5)).a((p.b) ZeusTransformUtils.preCheckCast(new C0340a(), p.b.class, "com.obric.aiagent.plugin")).a(new androidx.room.a.b[]{TaskDatabase.u()}).a(new androidx.room.a.b[]{TaskDatabase.v()}).a(new androidx.room.a.b[]{TaskDatabase.w()}).a(new androidx.room.a.b[]{TaskDatabase.x()}).a(new androidx.room.a.b[]{TaskDatabase.y()}).a(new androidx.room.a.b[]{TaskDatabase.z()}).a().b();
            o.c(r4, "build(...)");
            return (TaskDatabase) ZeusTransformUtils.preCheckCast(r4, TaskDatabase.class, "com.obric.aiagent.plugin");
        }

        public final TaskDatabase a(Context r3, File r4, String r5) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            o.e(r4, "importedDbFile");
            o.e(r5, "newDbName");
            p r6 = androidx.room.o.a(r2, TaskDatabase.class, r5).a(r4).a((p.b) ZeusTransformUtils.preCheckCast(new b(), p.b.class, "com.obric.aiagent.plugin")).a(new androidx.room.a.b[]{TaskDatabase.u()}).a(new androidx.room.a.b[]{TaskDatabase.v()}).a(new androidx.room.a.b[]{TaskDatabase.w()}).a(new androidx.room.a.b[]{TaskDatabase.x()}).a(new androidx.room.a.b[]{TaskDatabase.y()}).a(new androidx.room.a.b[]{TaskDatabase.z()}).b();
            o.c(r6, "build(...)");
            return (TaskDatabase) ZeusTransformUtils.preCheckCast(r6, TaskDatabase.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: TaskDatabase.kt */
    public static final class b extends androidx.room.a.b {
        b() {
            super(1, 2);
        }

        @Override // androidx.room.a.b
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("ALTER TABLE `condition_task_bean` ADD COLUMN `task_mode` INTEGER");
            r1.b("ALTER TABLE `condition_task_bean` ADD COLUMN `task_knowledge` TEXT");
            r1.b("ALTER TABLE `condition_task_bean` ADD COLUMN `template_id` TEXT");
            r1.b("ALTER TABLE `condition_task_record_bean` ADD COLUMN `create_time` INTEGER NOT NULL DEFAULT 0");
            r1.b("CREATE TABLE IF NOT EXISTS `task_execution_record_bean` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `task_id` TEXT,\n    `task_type` INTEGER NOT NULL,\n    `task_mode` INTEGER NOT NULL,\n    `query` TEXT,\n    `trigger_time` INTEGER NOT NULL,\n    `duration` INTEGER NOT NULL,\n    `result_code` INTEGER NOT NULL,\n    `result_message` TEXT,\n    `ext` TEXT,\n    `create_time` INTEGER NOT NULL,\n    `source_from` TEXT\n)");
            r1.b("CREATE UNIQUE INDEX IF NOT EXISTS `index_task_execution_record_bean_id` ON `task_execution_record_bean` (`id`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_task_execution_record_bean_task_id` ON `task_execution_record_bean` (`task_id`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_task_execution_record_bean_source_from` ON `task_execution_record_bean` (`source_from`)");
            r1.b("CREATE TABLE IF NOT EXISTS `shortcut_task_record_bean` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `task_id` TEXT NOT NULL,\n    `trigger_time` INTEGER NOT NULL,\n    `source_from` TEXT,\n    `create_time` INTEGER NOT NULL,\n    `result` INTEGER NOT NULL\n)");
            r1.b("CREATE UNIQUE INDEX IF NOT EXISTS `index_shortcut_task_record_bean_id` ON `shortcut_task_record_bean` (`id`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_shortcut_task_record_bean_task_id` ON `shortcut_task_record_bean` (`task_id`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_shortcut_task_record_bean_source_from` ON `shortcut_task_record_bean` (`source_from`)");
            r1.b("CREATE TABLE IF NOT EXISTS `shortcut_task_bean` (\n    `task_id` TEXT NOT NULL,\n    `actions` TEXT NOT NULL,\n    `name` TEXT,\n    `task_mode` INTEGER NOT NULL,\n    `task_knowledge` TEXT,\n    `template_id` TEXT,\n    `short_instruct` TEXT,\n    `is_short_instruct_enable` INTEGER NOT NULL,\n    `source_from` TEXT NOT NULL,\n    `task_status` INTEGER NOT NULL,\n    `enable_status` INTEGER NOT NULL,\n    `create_time` INTEGER NOT NULL,\n    `ext` TEXT,\n    PRIMARY KEY (`task_id`)\n)");
            r1.b("CREATE UNIQUE INDEX IF NOT EXISTS `index_shortcut_task_bean_task_id` ON `shortcut_task_bean` (`task_id`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_shortcut_task_bean_name` ON `shortcut_task_bean` (`name`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_shortcut_task_bean_source_from` ON `shortcut_task_bean` (`source_from`)");
        }
    }

    /* JADX INFO: compiled from: TaskDatabase.kt */
    public static final class c extends androidx.room.a.b {
        c() {
            super(2, 3);
        }

        @Override // androidx.room.a.b
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("CREATE TABLE IF NOT EXISTS `task_execution_record_detail_bean` (\n    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n    `session_id` TEXT,\n    `exec_time` INTEGER NOT NULL,\n    `package_name` TEXT,\n    `app_name` TEXT,\n    `detail_text` TEXT,\n    `detail_type` INTEGER NOT NULL,\n    `ext` TEXT\n)");
            r1.b("CREATE UNIQUE INDEX IF NOT EXISTS `index_task_execution_detail_record_bean_id` ON `task_execution_record_detail_bean` (`id`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_task_execution_detail_record_bean_session_id` ON `task_execution_record_detail_bean` (`session_id`)");
            r1.b("CREATE INDEX IF NOT EXISTS `index_task_execution_detail_record_bean_exec_time` ON `task_execution_record_detail_bean` (`exec_time`)");
        }
    }

    /* JADX INFO: compiled from: TaskDatabase.kt */
    public static final class d extends androidx.room.a.b {
        d() {
            super(3, 4);
        }

        @Override // androidx.room.a.b
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("UPDATE condition_task_bean SET source_from = 'com.larus.nova' WHERE source_from = 'com.obric.autoaction'");
            r1.b("UPDATE condition_task_record_bean SET source_from = 'com.larus.nova' WHERE source_from = 'com.obric.autoaction'");
            r1.b("UPDATE shortcut_task_bean SET source_from = 'com.larus.nova' WHERE source_from = 'com.obric.autoaction'");
            r1.b("UPDATE shortcut_task_record_bean SET source_from = 'com.larus.nova' WHERE source_from = 'com.obric.autoaction'");
            r1.b("UPDATE task_execution_record_bean SET source_from = 'com.larus.nova' WHERE source_from = 'com.obric.autoaction'");
        }
    }

    /* JADX INFO: compiled from: TaskDatabase.kt */
    public static final class e extends androidx.room.a.b {
        e() {
            super(4, 5);
        }

        @Override // androidx.room.a.b
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("ALTER TABLE `condition_task_bean` ADD COLUMN `trigger_control_policy` TEXT");
        }
    }

    /* JADX INFO: compiled from: TaskDatabase.kt */
    public static final class f extends androidx.room.a.b {
        f() {
            super(5, 6);
        }

        @Override // androidx.room.a.b
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("ALTER TABLE `condition_task_bean` ADD COLUMN `display_order` INTEGER NOT NULL DEFAULT 0");
            r1.b("UPDATE `condition_task_bean` SET `display_order` = `create_time` WHERE `display_order` = 0");
            r1.b("ALTER TABLE `shortcut_task_bean` ADD COLUMN `display_order` INTEGER NOT NULL DEFAULT 0");
            r1.b("UPDATE `shortcut_task_bean` SET `display_order` = `create_time` WHERE `display_order` = 0");
        }
    }

    /* JADX INFO: compiled from: TaskDatabase.kt */
    public static final class g extends androidx.room.a.b {
        g() {
            super(6, 7);
        }

        @Override // androidx.room.a.b
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("ALTER TABLE `condition_task_bean` ADD COLUMN `omni_model` TEXT");
            r1.b("ALTER TABLE `shortcut_task_bean` ADD COLUMN `omni_model` TEXT");
            r1.b("ALTER TABLE `task_execution_record_bean` ADD COLUMN `complex_task_model` TEXT");
        }
    }

    public abstract com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a o();

    public abstract com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d p();

    public abstract com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a q();

    public abstract com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r();

    public abstract com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a s();

    public abstract com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a t();

    public static final /* synthetic */ b u() {
        return f;
    }

    public static final /* synthetic */ c v() {
        return g;
    }

    public static final /* synthetic */ d w() {
        return h;
    }

    public static final /* synthetic */ e x() {
        return i;
    }

    public static final /* synthetic */ f y() {
        return j;
    }

    public static final /* synthetic */ g z() {
        return k;
    }

    public TaskDatabase() {
    }

    static {
        f16687e = new a(null);
        f = new b();
        g = new c();
        h = new d();
        i = new e();
        j = new f();
        k = new g();
    }
}
