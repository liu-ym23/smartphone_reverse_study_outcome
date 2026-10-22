package com.obric.aiagent.executionengine.eventstaskmanager.timertask;

import androidx.room.h;
import androidx.room.r;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class OldTimerTaskDatabase_Impl extends OldTimerTaskDatabase {
    private volatile com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a f;
    private volatile d g;

    public OldTimerTaskDatabase_Impl() {
    }

    static /* synthetic */ androidx.sqlite.db.c a(OldTimerTaskDatabase_Impl r2, androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        r2.f2668a = r4;
        return r4;
    }

    static /* synthetic */ List a(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List b(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ void b(OldTimerTaskDatabase_Impl r2, androidx.sqlite.db.c r3) {
        r2.a((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List d(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List e(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List f(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List g(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List h(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List i(OldTimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    @Override // androidx.room.p
    public androidx.sqlite.db.d b(androidx.room.c r4) {
        final int r2 = 3;
        r r0 = new r(r4, new AnonymousClass1(this, r2), "fccc136b6def34ec9ad74c02fb08be35", "edd7f8d19f00a443a7988e8361831c1a");
        androidx.sqlite.db.d.b r3 = androidx.sqlite.db.d.b.a(r4.f2624b).a(r4.f2625c).a(r0).a();
        return r4.f2623a.b(r3);
    }

    @Override // androidx.room.p
    public h c() {
        return new h(this, new HashMap(0), new HashMap(0), new String[]{"timer_task_bean", "timer_task_record_bean"});
    }

    @Override // androidx.room.p
    public Map<Class<?>, List<Class<?>>> d() {
        HashMap r2 = new HashMap();
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a.class, com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.b.b());
        r2.put(d.class, e.a());
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

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.OldTimerTaskDatabase
    public com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a o() {
        if (this.f != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f != null) goto L10;
        this.f = new com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.b(this);     // Catch: Throwable -> L13
    L10:
        com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a r0 = this.f;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f;
    }

    @Override // com.obric.aiagent.executionengine.eventstaskmanager.timertask.OldTimerTaskDatabase
    public d p() {
        if (this.g != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.g != null) goto L10;
        this.g = new e(this);     // Catch: Throwable -> L13
    L10:
        d r0 = this.g;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.g;
    }
}
