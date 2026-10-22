package com.stepos.ailauncher.taskstore.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.storage.database.cipher.CipherKeyUnavailableException;
import com.stepos.ailauncher.taskstore.dao.InterfaceC3710a;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import d1.AbstractC3942a;
import h8.C4148a;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
import java.io.File;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H ¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH ¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH ¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H ¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "m0", "()Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "Lcom/stepos/ailauncher/taskstore/database/d;", "n0", "()Lcom/stepos/ailauncher/taskstore/database/d;", "Lcom/stepos/ailauncher/taskstore/database/o;", "o0", "()Lcom/stepos/ailauncher/taskstore/database/o;", "Lcom/stepos/ailauncher/taskstore/database/a;", "k0", "()Lcom/stepos/ailauncher/taskstore/database/a;", "Lcom/stepos/ailauncher/taskstore/dao/a;", "l0", "()Lcom/stepos/ailauncher/taskstore/dao/a;", "Companion", "l", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TaskStoreDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "task_info.db";
    private static volatile TaskStoreDatabase INSTANCE = null;
    private static final String TAG = "TaskStoreDatabase";
    private static volatile boolean unavailable;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final d MIGRATION_2_3 = new d();
    private static final e MIGRATION_3_4 = new e();
    private static final f MIGRATION_4_5 = new f();
    private static final g MIGRATION_5_6 = new g();
    private static final h MIGRATION_6_7 = new h();
    private static final i MIGRATION_7_8 = new i();
    private static final j MIGRATION_8_9 = new j();
    private static final AbstractC3942a MIGRATION_9_10 = new k();
    private static final AbstractC3942a MIGRATION_10_11 = new a();
    private static final AbstractC3942a MIGRATION_11_12 = new b();
    private static final AbstractC3942a MIGRATION_12_13 = new c();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$a", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC3942a {
        public a() {
            super(10, 11);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN task_version INTEGER NOT NULL DEFAULT 0");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN active_task_version INTEGER NOT NULL DEFAULT 0");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN no_task_detail INTEGER NOT NULL DEFAULT 0");
            db2.execSQL("CREATE TABLE IF NOT EXISTS task_subtask_snapshots (task_id TEXT NOT NULL, sequence INTEGER NOT NULL, task_version INTEGER NOT NULL, subtasks_json TEXT NOT NULL, saved_at INTEGER NOT NULL, PRIMARY KEY(task_id, sequence))");
            db2.execSQL("CREATE INDEX IF NOT EXISTS index_task_subtask_snapshots_task_id ON task_subtask_snapshots (task_id)");
            db2.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_task_subtask_snapshots_task_id_task_version ON task_subtask_snapshots (task_id, task_version)");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$b", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC3942a {
        public b() {
            super(11, 12);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("CREATE TABLE IF NOT EXISTS `task_info_new` (`task_id` TEXT NOT NULL, `uid` TEXT NOT NULL DEFAULT '', `event_type` TEXT NOT NULL, `seq` INTEGER, `ts` INTEGER, `session_key` TEXT, `parent_task_id` TEXT, `sub_task_ids_json` TEXT, `type` TEXT NOT NULL, `version` INTEGER, `task_version` INTEGER NOT NULL DEFAULT 0, `active_task_version` INTEGER NOT NULL DEFAULT 0, `no_task_detail` INTEGER NOT NULL DEFAULT 0, `status` TEXT NOT NULL, `title` TEXT, `sub_title` TEXT, `progress_json` TEXT, `summary` TEXT, `request_session_key` TEXT, `pending_questions_json` TEXT, `intention` TEXT, `created_at` INTEGER NOT NULL, `started_at` INTEGER, `ended_at` INTEGER, `updated_at` INTEGER NOT NULL, `result_json` TEXT, `extensions_json` TEXT, `sub_tasks_json` TEXT, `answer_json` TEXT, `is_hidden` INTEGER NOT NULL DEFAULT 0, `notification_dismissed_status` TEXT DEFAULT NULL, `duration_ms` INTEGER DEFAULT NULL, `answered_question_texts_json` TEXT DEFAULT NULL, `read_at` INTEGER DEFAULT NULL, PRIMARY KEY(`task_id`))");
            db2.execSQL("INSERT INTO `task_info_new` (task_id, uid, event_type, seq, ts, session_key, parent_task_id, sub_task_ids_json, type, version, task_version, active_task_version, no_task_detail, status, title, sub_title, progress_json, summary, request_session_key, pending_questions_json, intention, created_at, started_at, ended_at, updated_at, result_json, extensions_json, sub_tasks_json, answer_json, is_hidden, notification_dismissed_status, duration_ms, answered_question_texts_json, read_at) SELECT task_id, uid, event_type, seq, ts, session_key, parent_task_id, sub_task_ids_json, type, version, CAST(IFNULL(task_version, 0) AS INTEGER), CAST(IFNULL(active_task_version, 0) AS INTEGER), no_task_detail, status, title, sub_title, progress_json, summary, request_session_key, pending_questions_json, intention, created_at, started_at, ended_at, updated_at, result_json, extensions_json, sub_tasks_json, answer_json, is_hidden, notification_dismissed_status, duration_ms, answered_question_texts_json, read_at FROM `task_info`");
            db2.execSQL("DROP TABLE `task_info`");
            db2.execSQL("ALTER TABLE `task_info_new` RENAME TO `task_info`");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_task_info_parent_task_id` ON `task_info` (`parent_task_id`)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_task_info_status` ON `task_info` (`status`)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_task_info_session_key` ON `task_info` (`session_key`)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_task_info_created_at` ON `task_info` (`created_at`)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_task_info_uid` ON `task_info` (`uid`)");
            db2.execSQL("DROP TABLE IF EXISTS task_subtask_snapshots");
            db2.execSQL("CREATE TABLE IF NOT EXISTS task_subtask_snapshots (task_id TEXT NOT NULL, sequence INTEGER NOT NULL, task_version INTEGER NOT NULL, subtasks_json TEXT NOT NULL, saved_at INTEGER NOT NULL, PRIMARY KEY(task_id, sequence))");
            db2.execSQL("CREATE INDEX IF NOT EXISTS index_task_subtask_snapshots_task_id ON task_subtask_snapshots (task_id)");
            db2.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_task_subtask_snapshots_task_id_task_version ON task_subtask_snapshots (task_id, task_version)");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$c", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC3942a {
        public c() {
            super(12, 13);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN icon_url TEXT DEFAULT NULL");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN version_id TEXT DEFAULT NULL");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$d", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends AbstractC3942a {
        public d() {
            super(2, 3);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN is_hidden INTEGER NOT NULL DEFAULT 0");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$e", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends AbstractC3942a {
        public e() {
            super(3, 4);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN intention TEXT");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$f", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends AbstractC3942a {
        public f() {
            super(4, 5);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN notification_dismissed_status TEXT DEFAULT NULL");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$g", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends AbstractC3942a {
        public g() {
            super(5, 6);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN duration_ms INTEGER DEFAULT NULL");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$h", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends AbstractC3942a {
        public h() {
            super(6, 7);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_result_snapshots ADD COLUMN version INTEGER");
            db2.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS index_task_result_snapshots_task_id_version ON task_result_snapshots (task_id, version)");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$i", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i extends AbstractC3942a {
        public i() {
            super(7, 8);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN answered_question_texts_json TEXT DEFAULT NULL");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$j", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class j extends AbstractC3942a {
        public j() {
            super(8, 9);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN uid TEXT NOT NULL DEFAULT ''");
            db2.execSQL("CREATE INDEX IF NOT EXISTS index_task_info_uid ON task_info (uid)");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$k", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class k extends AbstractC3942a {
        public k() {
            super(9, 10);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            kotlin.jvm.internal.p.i(db2, "db");
            db2.execSQL("ALTER TABLE task_info ADD COLUMN read_at INTEGER DEFAULT NULL");
        }
    }

    @Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0007*\u0007%(+.147\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001a\u0010!\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00108\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010$¨\u0006="}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$l;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "", "reason", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase;", "c", Const.INTENT_KEY_APIKEY, "k", "Ld1/a;", "MIGRATION_9_10", "Ld1/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ld1/a;", "MIGRATION_10_11", Const.INTENT_KEY_UMID, UxipConstants.f30680s, "unavailable", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "MIGRATION_11_12", "e", "MIGRATION_12_13", "f", "DATABASE_NAME", "Ljava/lang/String;", "com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$d", "MIGRATION_2_3", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$d;", "com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$e", "MIGRATION_3_4", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$e;", "com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$f", "MIGRATION_4_5", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$f;", "com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$g", "MIGRATION_5_6", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$g;", "com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$h", "MIGRATION_6_7", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$h;", "com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$i", "MIGRATION_7_8", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$i;", "com/stepos/ailauncher/taskstore/database/TaskStoreDatabase$j", "MIGRATION_8_9", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase$j;", "INSTANCE", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase;", "TAG", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.database.TaskStoreDatabase$l, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final TaskStoreDatabase a(Context context) {
            try {
                return k(context);
            } catch (Throwable th) {
                if (!com.stepos.ailauncher.storage.database.cipher.a.INSTANCE.a(context, TaskStoreDatabase.DATABASE_NAME, th)) {
                    throw th;
                }
                C4148a.u(TaskStoreDatabase.TAG, "task_info.db recreated after unrecoverable open; store starts empty and re-syncs", false, 4, null);
                return this.k(context);
            }
        }

        public final TaskStoreDatabase b(Context context) {
            TaskStoreDatabase taskStoreDatabase;
            Object objB;
            kotlin.jvm.internal.p.i(context, "context");
            if (i()) {
                throw new IllegalStateException("task_info.db unavailable (disk)");
            }
            TaskStoreDatabase taskStoreDatabase2 = TaskStoreDatabase.INSTANCE;
            if (taskStoreDatabase2 != null) {
                return taskStoreDatabase2;
            }
            A5.a aVar = A5.a.INSTANCE;
            if (!A5.a.c(aVar, context, 0L, 2, null)) {
                File filesDir = context.getFilesDir();
                kotlin.jvm.internal.p.h(filesDir, "getFilesDir(...)");
                j("low-space-before-open usable=" + aVar.f(filesDir));
                throw new IllegalStateException("task_info.db skipped: low disk");
            }
            synchronized (this) {
                try {
                    Companion companion = TaskStoreDatabase.INSTANCE;
                    if (companion.i()) {
                        throw new IllegalStateException("task_info.db unavailable (disk)");
                    }
                    taskStoreDatabase = TaskStoreDatabase.INSTANCE;
                    if (taskStoreDatabase == null) {
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            Context applicationContext = context.getApplicationContext();
                            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
                            TaskStoreDatabase taskStoreDatabaseA = companion.a(applicationContext);
                            TaskStoreDatabase.INSTANCE = taskStoreDatabaseA;
                            objB = Result.b(taskStoreDatabaseA);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objB = Result.b(C4849c.a(th));
                        }
                        Throwable thE = Result.e(objB);
                        if (thE != null) {
                            if (A5.a.INSTANCE.d(thE) || (thE instanceof SQLiteException) || (thE instanceof CipherKeyUnavailableException)) {
                                TaskStoreDatabase.INSTANCE.j("taskstore-open:" + thE.getMessage());
                            }
                            throw thE;
                        }
                        taskStoreDatabase = (TaskStoreDatabase) objB;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return taskStoreDatabase;
        }

        public final TaskStoreDatabase c(Context context) {
            Object objB;
            kotlin.jvm.internal.p.i(context, "context");
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(b(context));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TaskStoreDatabase.TAG, "getInstanceOrNull failed", thE, false, 8, null);
            }
            if (Result.g(objB)) {
                objB = null;
            }
            return (TaskStoreDatabase) objB;
        }

        public final AbstractC3942a d() {
            return TaskStoreDatabase.MIGRATION_10_11;
        }

        public final AbstractC3942a e() {
            return TaskStoreDatabase.MIGRATION_11_12;
        }

        public final AbstractC3942a f() {
            return TaskStoreDatabase.MIGRATION_12_13;
        }

        public final AbstractC3942a g() {
            return TaskStoreDatabase.MIGRATION_9_10;
        }

        public final boolean h() {
            return TaskStoreDatabase.unavailable;
        }

        public final boolean i() {
            return h() || A5.a.INSTANCE.a();
        }

        public final void j(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            TaskStoreDatabase.unavailable = true;
            A5.a.INSTANCE.e(reason);
            C4148a.h(TaskStoreDatabase.TAG, "marked unavailable: " + reason, false, 4, null);
        }

        public final TaskStoreDatabase k(Context context) throws Throwable {
            Object objB;
            InterfaceC4757d.c cVarD = com.stepos.ailauncher.storage.database.cipher.a.d(com.stepos.ailauncher.storage.database.cipher.a.INSTANCE, context, TaskStoreDatabase.DATABASE_NAME, false, true, 4, null);
            RoomDatabase.a aVarA = androidx.room.m.a(context, TaskStoreDatabase.class, TaskStoreDatabase.DATABASE_NAME);
            if (cVarD != null) {
                aVarA.e(cVarD);
            }
            TaskStoreDatabase taskStoreDatabase = (TaskStoreDatabase) aVarA.b(TaskStoreDatabase.MIGRATION_2_3, TaskStoreDatabase.MIGRATION_3_4, TaskStoreDatabase.MIGRATION_4_5, TaskStoreDatabase.MIGRATION_5_6, TaskStoreDatabase.MIGRATION_6_7, TaskStoreDatabase.MIGRATION_7_8, TaskStoreDatabase.MIGRATION_8_9, g(), d(), e(), f()).d(true).c();
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(taskStoreDatabase.u().getWritableDatabase());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE == null) {
                return taskStoreDatabase;
            }
            Companion companion3 = TaskStoreDatabase.INSTANCE;
            try {
                taskStoreDatabase.i();
                Result.b(Y8.t.f7040a);
                throw thE;
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
                throw thE;
            }
        }

        public Companion() {
        }
    }

    public abstract com.stepos.ailauncher.taskstore.database.a k0();

    public abstract InterfaceC3710a l0();

    public abstract TaskInfoCardDao m0();

    public abstract com.stepos.ailauncher.taskstore.database.d n0();

    public abstract o o0();
}
