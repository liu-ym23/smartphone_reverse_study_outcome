package com.obric.aiagent.executionengine.eventstaskmanager.timertask.data;

import androidx.room.a.b;
import androidx.room.h;
import androidx.room.r;
import androidx.sqlite.db.c;
import androidx.sqlite.db.d;
import com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class TimerTaskDatabase_Impl extends TimerTaskDatabase {
    public TimerTaskDatabase_Impl() {
    }

    static /* synthetic */ c a(TimerTaskDatabase_Impl r2, c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        r2.f2668a = r4;
        return r4;
    }

    static /* synthetic */ List a(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List b(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ void b(TimerTaskDatabase_Impl r2, c r3) {
        r2.a((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List d(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List e(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List f(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List g(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List h(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List i(TimerTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    @Override // androidx.room.p
    public d b(androidx.room.c r4) {
        final int r2 = 3;
        r r0 = new r(r4, new AnonymousClass1(this, r2), "fccc136b6def34ec9ad74c02fb08be35", "edd7f8d19f00a443a7988e8361831c1a");
        d.b r3 = d.b.a(r4.f2624b).a(r4.f2625c).a(r0).a();
        return r4.f2623a.b(r3);
    }

    @Override // androidx.room.p
    public h c() {
        return new h(this, new HashMap(0), new HashMap(0), new String[]{"timer_task_bean", "timer_task_record_bean"});
    }

    @Override // androidx.room.p
    public Map<Class<?>, List<Class<?>>> d() {
        HashMap r2 = new HashMap();
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.a.class, com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.c.b());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.timertask.data.b.d.class, f.a());
        return r2;
    }

    @Override // androidx.room.p
    public Set<Class<? extends androidx.room.a.a>> e() {
        return new HashSet();
    }

    @Override // androidx.room.p
    public List<b> a(Map<Class<? extends androidx.room.a.a>, androidx.room.a.a> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return Arrays.asList(new b[0]);
    }
}
