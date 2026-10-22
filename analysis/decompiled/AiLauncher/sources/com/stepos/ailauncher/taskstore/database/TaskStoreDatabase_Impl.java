package com.stepos.ailauncher.taskstore.database;

import Z8.C1172u;
import Z8.C1173v;
import androidx.room.InvalidationTracker;
import androidx.room.w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.dao.InterfaceC3710a;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao_Impl;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.ame.sdk.SkillStoreKt;
import d1.AbstractC3942a;
import f1.C4031a;
import f1.C4044n;
import i1.C4159a;
import i1.InterfaceC4160b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\f0\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b\u0012\u0004\u0012\u00020\u00100\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0010¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0010¢\u0006\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00170&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001d0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020 0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010(R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020#0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010(¨\u0006-"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase_Impl;", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase;", "<init>", "()V", "Landroidx/room/w;", "A0", "()Landroidx/room/w;", "Landroidx/room/InvalidationTracker;", "m", "()Landroidx/room/InvalidationTracker;", "", "Lw9/d;", "", "y", "()Ljava/util/Map;", "", "", "w", "()Ljava/util/Set;", "autoMigrationSpecs", "Ld1/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;)Ljava/util/List;", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "m0", "()Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardDao;", "Lcom/stepos/ailauncher/taskstore/database/d;", "n0", "()Lcom/stepos/ailauncher/taskstore/database/d;", "Lcom/stepos/ailauncher/taskstore/database/o;", "o0", "()Lcom/stepos/ailauncher/taskstore/database/o;", "Lcom/stepos/ailauncher/taskstore/database/a;", "k0", "()Lcom/stepos/ailauncher/taskstore/database/a;", "Lcom/stepos/ailauncher/taskstore/dao/a;", "l0", "()Lcom/stepos/ailauncher/taskstore/dao/a;", "LY8/h;", "_taskInfoCardDao", "LY8/h;", "_taskResultSnapshotDao", "_taskSubTaskSnapshotDao", "_downloadedArtifactDao", "_launcherVectorDao", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStoreDatabase_Impl extends TaskStoreDatabase {
    private final Y8.h<TaskInfoCardDao> _taskInfoCardDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.database.j
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskStoreDatabase_Impl.w0(this.f29253a);
        }
    });
    private final Y8.h<d> _taskResultSnapshotDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.database.k
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskStoreDatabase_Impl.x0(this.f29254a);
        }
    });
    private final Y8.h<o> _taskSubTaskSnapshotDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.database.l
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskStoreDatabase_Impl.y0(this.f29255a);
        }
    });
    private final Y8.h<com.stepos.ailauncher.taskstore.database.a> _downloadedArtifactDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.database.m
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskStoreDatabase_Impl.u0(this.f29256a);
        }
    });
    private final Y8.h<InterfaceC3710a> _launcherVectorDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.database.n
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return TaskStoreDatabase_Impl.v0(this.f29257a);
        }
    });

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/taskstore/database/TaskStoreDatabase_Impl$a", "Landroidx/room/w;", "Li1/b;", "connection", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Li1/b;)V", Const.INTENT_KEY_PKGNAME, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/room/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Li1/b;)Landroidx/room/w$a;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends w {
        public a() {
            super(13, "688dde3888465bda9a45fa9e6df8b981", "db295aa329d4e625a7fff000887a045e");
        }

        @Override // androidx.room.w
        public void a(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `task_info` (`task_id` TEXT NOT NULL, `uid` TEXT NOT NULL DEFAULT '', `event_type` TEXT NOT NULL, `seq` INTEGER, `ts` INTEGER, `session_key` TEXT, `parent_task_id` TEXT, `sub_task_ids_json` TEXT, `type` TEXT NOT NULL, `version` INTEGER, `version_id` TEXT, `task_version` INTEGER NOT NULL DEFAULT 0, `active_task_version` INTEGER NOT NULL DEFAULT 0, `no_task_detail` INTEGER NOT NULL DEFAULT 0, `status` TEXT NOT NULL, `title` TEXT, `sub_title` TEXT, `icon_url` TEXT, `progress_json` TEXT, `summary` TEXT, `request_session_key` TEXT, `pending_questions_json` TEXT, `intention` TEXT, `created_at` INTEGER NOT NULL, `started_at` INTEGER, `ended_at` INTEGER, `updated_at` INTEGER NOT NULL, `result_json` TEXT, `extensions_json` TEXT, `sub_tasks_json` TEXT, `answer_json` TEXT, `is_hidden` INTEGER NOT NULL DEFAULT 0, `notification_dismissed_status` TEXT DEFAULT NULL, `duration_ms` INTEGER DEFAULT NULL, `answered_question_texts_json` TEXT DEFAULT NULL, `read_at` INTEGER DEFAULT NULL, PRIMARY KEY(`task_id`))");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_info_parent_task_id` ON `task_info` (`parent_task_id`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_info_status` ON `task_info` (`status`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_info_session_key` ON `task_info` (`session_key`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_info_created_at` ON `task_info` (`created_at`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_info_uid` ON `task_info` (`uid`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `task_result_snapshots` (`task_id` TEXT NOT NULL, `sequence` INTEGER NOT NULL, `version` INTEGER, `result_json` TEXT NOT NULL, `saved_at` INTEGER NOT NULL, PRIMARY KEY(`task_id`, `sequence`))");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_result_snapshots_task_id` ON `task_result_snapshots` (`task_id`)");
            C4159a.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_task_result_snapshots_task_id_version` ON `task_result_snapshots` (`task_id`, `version`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `task_subtask_snapshots` (`task_id` TEXT NOT NULL, `sequence` INTEGER NOT NULL, `task_version` INTEGER NOT NULL, `subtasks_json` TEXT NOT NULL, `saved_at` INTEGER NOT NULL, PRIMARY KEY(`task_id`, `sequence`))");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_task_subtask_snapshots_task_id` ON `task_subtask_snapshots` (`task_id`)");
            C4159a.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_task_subtask_snapshots_task_id_task_version` ON `task_subtask_snapshots` (`task_id`, `task_version`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `downloaded_artifacts` (`art_key` TEXT NOT NULL, `task_id` TEXT NOT NULL, `downloaded_at` INTEGER NOT NULL, PRIMARY KEY(`art_key`))");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `launcher_vector_entities` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bizKey` TEXT NOT NULL, `bizType` TEXT NOT NULL, `entityClassName` TEXT NOT NULL DEFAULT 'LauncherVectorEntity', `bizId` TEXT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `metadata` TEXT NOT NULL, `updateTime` INTEGER NOT NULL)");
            C4159a.a(connection, "CREATE UNIQUE INDEX IF NOT EXISTS `index_launcher_vector_entities_bizKey` ON `launcher_vector_entities` (`bizKey`)");
            C4159a.a(connection, "CREATE INDEX IF NOT EXISTS `index_launcher_vector_entities_bizType` ON `launcher_vector_entities` (`bizType`)");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            C4159a.a(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '688dde3888465bda9a45fa9e6df8b981')");
        }

        @Override // androidx.room.w
        public void b(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            C4159a.a(connection, "DROP TABLE IF EXISTS `task_info`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `task_result_snapshots`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `task_subtask_snapshots`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `downloaded_artifacts`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `launcher_vector_entities`");
        }

        @Override // androidx.room.w
        public void f(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
        }

        @Override // androidx.room.w
        public void g(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            TaskStoreDatabase_Impl.this.K(connection);
        }

        @Override // androidx.room.w
        public void h(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
        }

        @Override // androidx.room.w
        public void i(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            C4031a.a(connection);
        }

        @Override // androidx.room.w
        public w.a j(InterfaceC4160b connection) {
            kotlin.jvm.internal.p.i(connection, "connection");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("task_id", new C4044n.a("task_id", "TEXT", true, 1, null, 1));
            linkedHashMap.put("uid", new C4044n.a("uid", "TEXT", true, 0, "''", 1));
            linkedHashMap.put(c.a.COL_EVENT_TYPE, new C4044n.a(c.a.COL_EVENT_TYPE, "TEXT", true, 0, null, 1));
            linkedHashMap.put(c.a.COL_SEQ, new C4044n.a(c.a.COL_SEQ, "INTEGER", false, 0, null, 1));
            linkedHashMap.put("ts", new C4044n.a("ts", "INTEGER", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_SESSION_KEY, new C4044n.a(c.a.COL_SESSION_KEY, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_PARENT_TASK_ID, new C4044n.a(c.a.COL_PARENT_TASK_ID, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_SUB_TASK_IDS_JSON, new C4044n.a(c.a.COL_SUB_TASK_IDS_JSON, "TEXT", false, 0, null, 1));
            linkedHashMap.put("type", new C4044n.a("type", "TEXT", true, 0, null, 1));
            linkedHashMap.put("version", new C4044n.a("version", "INTEGER", false, 0, null, 1));
            linkedHashMap.put("version_id", new C4044n.a("version_id", "TEXT", false, 0, null, 1));
            linkedHashMap.put("task_version", new C4044n.a("task_version", "INTEGER", true, 0, "0", 1));
            linkedHashMap.put("active_task_version", new C4044n.a("active_task_version", "INTEGER", true, 0, "0", 1));
            linkedHashMap.put("no_task_detail", new C4044n.a("no_task_detail", "INTEGER", true, 0, "0", 1));
            linkedHashMap.put("status", new C4044n.a("status", "TEXT", true, 0, null, 1));
            linkedHashMap.put("title", new C4044n.a("title", "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_SUB_TITLE, new C4044n.a(c.a.COL_SUB_TITLE, "TEXT", false, 0, null, 1));
            linkedHashMap.put("icon_url", new C4044n.a("icon_url", "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_PROGRESS_JSON, new C4044n.a(c.a.COL_PROGRESS_JSON, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_SUMMARY, new C4044n.a(c.a.COL_SUMMARY, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_REQUEST_SESSION_KEY, new C4044n.a(c.a.COL_REQUEST_SESSION_KEY, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_PENDING_QUESTIONS_JSON, new C4044n.a(c.a.COL_PENDING_QUESTIONS_JSON, "TEXT", false, 0, null, 1));
            linkedHashMap.put("intention", new C4044n.a("intention", "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_CREATED_AT, new C4044n.a(c.a.COL_CREATED_AT, "INTEGER", true, 0, null, 1));
            linkedHashMap.put(c.a.COL_STARTED_AT, new C4044n.a(c.a.COL_STARTED_AT, "INTEGER", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_ENDED_AT, new C4044n.a(c.a.COL_ENDED_AT, "INTEGER", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_UPDATED_AT, new C4044n.a(c.a.COL_UPDATED_AT, "INTEGER", true, 0, null, 1));
            linkedHashMap.put(c.a.COL_RESULT_JSON, new C4044n.a(c.a.COL_RESULT_JSON, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_EXTENSIONS_JSON, new C4044n.a(c.a.COL_EXTENSIONS_JSON, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_SUB_TASKS_JSON, new C4044n.a(c.a.COL_SUB_TASKS_JSON, "TEXT", false, 0, null, 1));
            linkedHashMap.put(c.a.COL_ANSWER_JSON, new C4044n.a(c.a.COL_ANSWER_JSON, "TEXT", false, 0, null, 1));
            linkedHashMap.put("is_hidden", new C4044n.a("is_hidden", "INTEGER", true, 0, "0", 1));
            linkedHashMap.put("notification_dismissed_status", new C4044n.a("notification_dismissed_status", "TEXT", false, 0, "NULL", 1));
            linkedHashMap.put("duration_ms", new C4044n.a("duration_ms", "INTEGER", false, 0, "NULL", 1));
            linkedHashMap.put("answered_question_texts_json", new C4044n.a("answered_question_texts_json", "TEXT", false, 0, "NULL", 1));
            linkedHashMap.put("read_at", new C4044n.a("read_at", "INTEGER", false, 0, "NULL", 1));
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            linkedHashSet2.add(new C4044n.d("index_task_info_parent_task_id", false, C1172u.e(c.a.COL_PARENT_TASK_ID), C1172u.e("ASC")));
            linkedHashSet2.add(new C4044n.d("index_task_info_status", false, C1172u.e("status"), C1172u.e("ASC")));
            linkedHashSet2.add(new C4044n.d("index_task_info_session_key", false, C1172u.e(c.a.COL_SESSION_KEY), C1172u.e("ASC")));
            linkedHashSet2.add(new C4044n.d("index_task_info_created_at", false, C1172u.e(c.a.COL_CREATED_AT), C1172u.e("ASC")));
            linkedHashSet2.add(new C4044n.d("index_task_info_uid", false, C1172u.e("uid"), C1172u.e("ASC")));
            C4044n c4044n = new C4044n(c.a.TABLE, linkedHashMap, linkedHashSet, linkedHashSet2);
            C4044n.Companion companion = C4044n.INSTANCE;
            C4044n c4044nA = companion.a(connection, c.a.TABLE);
            if (!c4044n.equals(c4044nA)) {
                return new w.a(false, "task_info(com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity).\n Expected:\n" + c4044n + "\n Found:\n" + c4044nA);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("task_id", new C4044n.a("task_id", "TEXT", true, 1, null, 1));
            linkedHashMap2.put("sequence", new C4044n.a("sequence", "INTEGER", true, 2, null, 1));
            linkedHashMap2.put("version", new C4044n.a("version", "INTEGER", false, 0, null, 1));
            linkedHashMap2.put(c.a.COL_RESULT_JSON, new C4044n.a(c.a.COL_RESULT_JSON, "TEXT", true, 0, null, 1));
            linkedHashMap2.put("saved_at", new C4044n.a("saved_at", "INTEGER", true, 0, null, 1));
            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
            LinkedHashSet linkedHashSet4 = new LinkedHashSet();
            linkedHashSet4.add(new C4044n.d("index_task_result_snapshots_task_id", false, C1172u.e("task_id"), C1172u.e("ASC")));
            linkedHashSet4.add(new C4044n.d("index_task_result_snapshots_task_id_version", true, C1173v.p("task_id", "version"), C1173v.p("ASC", "ASC")));
            C4044n c4044n2 = new C4044n("task_result_snapshots", linkedHashMap2, linkedHashSet3, linkedHashSet4);
            C4044n c4044nA2 = companion.a(connection, "task_result_snapshots");
            if (!c4044n2.equals(c4044nA2)) {
                return new w.a(false, "task_result_snapshots(com.stepos.ailauncher.taskstore.database.TaskResultSnapshotEntity).\n Expected:\n" + c4044n2 + "\n Found:\n" + c4044nA2);
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            linkedHashMap3.put("task_id", new C4044n.a("task_id", "TEXT", true, 1, null, 1));
            linkedHashMap3.put("sequence", new C4044n.a("sequence", "INTEGER", true, 2, null, 1));
            linkedHashMap3.put("task_version", new C4044n.a("task_version", "INTEGER", true, 0, null, 1));
            linkedHashMap3.put("subtasks_json", new C4044n.a("subtasks_json", "TEXT", true, 0, null, 1));
            linkedHashMap3.put("saved_at", new C4044n.a("saved_at", "INTEGER", true, 0, null, 1));
            LinkedHashSet linkedHashSet5 = new LinkedHashSet();
            LinkedHashSet linkedHashSet6 = new LinkedHashSet();
            linkedHashSet6.add(new C4044n.d("index_task_subtask_snapshots_task_id", false, C1172u.e("task_id"), C1172u.e("ASC")));
            linkedHashSet6.add(new C4044n.d("index_task_subtask_snapshots_task_id_task_version", true, C1173v.p("task_id", "task_version"), C1173v.p("ASC", "ASC")));
            C4044n c4044n3 = new C4044n("task_subtask_snapshots", linkedHashMap3, linkedHashSet5, linkedHashSet6);
            C4044n c4044nA3 = companion.a(connection, "task_subtask_snapshots");
            if (!c4044n3.equals(c4044nA3)) {
                return new w.a(false, "task_subtask_snapshots(com.stepos.ailauncher.taskstore.database.TaskSubTaskSnapshotEntity).\n Expected:\n" + c4044n3 + "\n Found:\n" + c4044nA3);
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap();
            linkedHashMap4.put("art_key", new C4044n.a("art_key", "TEXT", true, 1, null, 1));
            linkedHashMap4.put("task_id", new C4044n.a("task_id", "TEXT", true, 0, null, 1));
            linkedHashMap4.put("downloaded_at", new C4044n.a("downloaded_at", "INTEGER", true, 0, null, 1));
            C4044n c4044n4 = new C4044n("downloaded_artifacts", linkedHashMap4, new LinkedHashSet(), new LinkedHashSet());
            C4044n c4044nA4 = companion.a(connection, "downloaded_artifacts");
            if (!c4044n4.equals(c4044nA4)) {
                return new w.a(false, "downloaded_artifacts(com.stepos.ailauncher.taskstore.database.DownloadedArtifactEntity).\n Expected:\n" + c4044n4 + "\n Found:\n" + c4044nA4);
            }
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            linkedHashMap5.put("id", new C4044n.a("id", "INTEGER", true, 1, null, 1));
            linkedHashMap5.put("bizKey", new C4044n.a("bizKey", "TEXT", true, 0, null, 1));
            linkedHashMap5.put("bizType", new C4044n.a("bizType", "TEXT", true, 0, null, 1));
            linkedHashMap5.put("entityClassName", new C4044n.a("entityClassName", "TEXT", true, 0, "'LauncherVectorEntity'", 1));
            linkedHashMap5.put("bizId", new C4044n.a("bizId", "TEXT", true, 0, null, 1));
            linkedHashMap5.put("title", new C4044n.a("title", "TEXT", true, 0, null, 1));
            linkedHashMap5.put(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, new C4044n.a(SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "TEXT", true, 0, null, 1));
            linkedHashMap5.put("metadata", new C4044n.a("metadata", "TEXT", true, 0, null, 1));
            linkedHashMap5.put("updateTime", new C4044n.a("updateTime", "INTEGER", true, 0, null, 1));
            LinkedHashSet linkedHashSet7 = new LinkedHashSet();
            LinkedHashSet linkedHashSet8 = new LinkedHashSet();
            linkedHashSet8.add(new C4044n.d("index_launcher_vector_entities_bizKey", true, C1172u.e("bizKey"), C1172u.e("ASC")));
            linkedHashSet8.add(new C4044n.d("index_launcher_vector_entities_bizType", false, C1172u.e("bizType"), C1172u.e("ASC")));
            C4044n c4044n5 = new C4044n("launcher_vector_entities", linkedHashMap5, linkedHashSet7, linkedHashSet8);
            C4044n c4044nA5 = companion.a(connection, "launcher_vector_entities");
            if (c4044n5.equals(c4044nA5)) {
                return new w.a(true, null);
            }
            return new w.a(false, "launcher_vector_entities(com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity).\n Expected:\n" + c4044n5 + "\n Found:\n" + c4044nA5);
        }
    }

    public static final b u0(TaskStoreDatabase_Impl taskStoreDatabase_Impl) {
        return new b(taskStoreDatabase_Impl);
    }

    public static final com.stepos.ailauncher.taskstore.dao.g v0(TaskStoreDatabase_Impl taskStoreDatabase_Impl) {
        return new com.stepos.ailauncher.taskstore.dao.g(taskStoreDatabase_Impl);
    }

    public static final TaskInfoCardDao_Impl w0(TaskStoreDatabase_Impl taskStoreDatabase_Impl) {
        return new TaskInfoCardDao_Impl(taskStoreDatabase_Impl);
    }

    public static final h x0(TaskStoreDatabase_Impl taskStoreDatabase_Impl) {
        return new h(taskStoreDatabase_Impl);
    }

    public static final s y0(TaskStoreDatabase_Impl taskStoreDatabase_Impl) {
        return new s(taskStoreDatabase_Impl);
    }

    @Override // androidx.room.RoomDatabase
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public w n() {
        return new a();
    }

    @Override // androidx.room.RoomDatabase
    public List<AbstractC3942a> j(Map<InterfaceC5745d<Object>, Object> autoMigrationSpecs) {
        kotlin.jvm.internal.p.i(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // com.stepos.ailauncher.taskstore.database.TaskStoreDatabase
    public com.stepos.ailauncher.taskstore.database.a k0() {
        return this._downloadedArtifactDao.getValue();
    }

    @Override // com.stepos.ailauncher.taskstore.database.TaskStoreDatabase
    public InterfaceC3710a l0() {
        return this._launcherVectorDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker m() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), c.a.TABLE, "task_result_snapshots", "task_subtask_snapshots", "downloaded_artifacts", "launcher_vector_entities");
    }

    @Override // com.stepos.ailauncher.taskstore.database.TaskStoreDatabase
    public TaskInfoCardDao m0() {
        return this._taskInfoCardDao.getValue();
    }

    @Override // com.stepos.ailauncher.taskstore.database.TaskStoreDatabase
    public d n0() {
        return this._taskResultSnapshotDao.getValue();
    }

    @Override // com.stepos.ailauncher.taskstore.database.TaskStoreDatabase
    public o o0() {
        return this._taskSubTaskSnapshotDao.getValue();
    }

    @Override // androidx.room.RoomDatabase
    public Set<InterfaceC5745d<Object>> w() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<InterfaceC5745d<?>, List<InterfaceC5745d<?>>> y() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(kotlin.jvm.internal.t.b(TaskInfoCardDao.class), TaskInfoCardDao_Impl.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(d.class), h.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(o.class), s.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(com.stepos.ailauncher.taskstore.database.a.class), b.INSTANCE.a());
        linkedHashMap.put(kotlin.jvm.internal.t.b(InterfaceC3710a.class), com.stepos.ailauncher.taskstore.dao.g.INSTANCE.a());
        return linkedHashMap;
    }
}
