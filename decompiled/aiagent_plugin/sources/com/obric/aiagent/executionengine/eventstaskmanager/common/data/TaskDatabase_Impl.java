package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import androidx.room.h;
import androidx.room.r;
import com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class TaskDatabase_Impl extends TaskDatabase {
    private volatile com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a f;
    private volatile com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d g;
    private volatile com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a h;
    private volatile com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d i;
    private volatile com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a j;
    private volatile com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a k;

    public TaskDatabase_Impl() {
    }

    static /* synthetic */ androidx.sqlite.db.c a(TaskDatabase_Impl r2, androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        r2.f2668a = r4;
        return r4;
    }

    static /* synthetic */ List a(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List b(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ void b(TaskDatabase_Impl r2, androidx.sqlite.db.c r3) {
        r2.a((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List d(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List e(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List f(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List g(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List h(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List i(TaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    @Override // androidx.room.p
    public androidx.sqlite.db.d b(androidx.room.c r4) {
        final int r2 = 7;
        r r0 = new r(r4, new AnonymousClass1(this, r2), "e303a3dfaa3f1dd1bf8966250a9cd018", "4adb817b4628a8573e7f29aff5cf5161");
        androidx.sqlite.db.d.b r3 = androidx.sqlite.db.d.b.a(r4.f2624b).a(r4.f2625c).a(r0).a();
        return r4.f2623a.b(r3);
    }

    @Override // androidx.room.p
    public h c() {
        return new h(this, new HashMap(0), new HashMap(0), new String[]{"condition_task_bean", "condition_task_record_bean", "shortcut_task_bean", "shortcut_task_record_bean", "task_execution_record_bean", "task_execution_record_detail_bean"});
    }

    @Override // androidx.room.p
    public Map<Class<?>, List<Class<?>>> d() {
        HashMap r2 = new HashMap();
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.c.c());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, f.a());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.c.c());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.f.a());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.c.a());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.c.a());
        return r2;
    }

    @Override // androidx.room.p
    public Set<Class<? extends androidx.room.a.a>> e() {
        return new HashSet();
    }

    @Override // androidx.room.p
    public List<androidx.room.a.b> a(Map<Class<? extends androidx.room.a.a>, androidx.room.a.a> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return Arrays.asList(new androidx.room.a.b[0]);
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase
    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a o() {
        if (this.f != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f != null) goto L10;
        this.f = new com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.c(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a r0 = this.f;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase
    public com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d p() {
        if (this.g != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.g != null) goto L10;
        this.g = new f(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d r0 = this.g;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.g;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase
    public com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a q() {
        if (this.h != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.h != null) goto L10;
        this.h = new com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.c(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a r0 = this.h;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.h;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase
    public com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r() {
        if (this.i != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.i != null) goto L10;
        this.i = new com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.f(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d r0 = this.i;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.i;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase
    public com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a s() {
        if (this.j != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.j != null) goto L10;
        this.j = new com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.c(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a r0 = this.j;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.j;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.common.data.TaskDatabase
    public com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a t() {
        if (this.k != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.k != null) goto L10;
        this.k = new com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.c(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a r0 = this.k;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.k;
    }
}
