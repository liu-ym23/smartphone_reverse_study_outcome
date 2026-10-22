package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data;

import androidx.sqlite.db.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TimerTaskDatabaseMigration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final androidx.room.a.b f17914b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final androidx.room.a.b f17915c = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TimerTaskDatabaseMigration.kt */
    public static final class C0367a extends androidx.room.a.b {
        C0367a() {
            super(1, 2);
        }

        @Override // androidx.room.a.b
        public void a(c r2) {
            c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("ALTER TABLE timer_task_bean ADD COLUMN ext TEXT DEFAULT NULL");
        }
    }

    /* JADX INFO: compiled from: TimerTaskDatabaseMigration.kt */
    public static final class b extends androidx.room.a.b {
        b() {
            super(2, 3);
        }

        @Override // androidx.room.a.b
        public void a(c r2) {
            c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
            o.e(r1, "database");
            r1.b("UPDATE timer_task_bean SET source_from = 'com.larus.nova' WHERE source_from = 'com.obric.autoaction'");
            r1.b("UPDATE timer_task_record_bean SET source_from = 'com.larus.nova' WHERE source_from = 'com.obric.autoaction'");
        }
    }

    private a() {
    }

    static {
        f17913a = new a();
        f17914b = (androidx.room.a.b) ZeusTransformUtils.preCheckCast(new C0367a(), androidx.room.a.b.class, "com.obric.aiagent.plugin");
        f17915c = (androidx.room.a.b) ZeusTransformUtils.preCheckCast(new b(), androidx.room.a.b.class, "com.obric.aiagent.plugin");
    }

    public final androidx.room.a.b a() {
        return f17914b;
    }

    public final androidx.room.a.b b() {
        return f17915c;
    }
}
