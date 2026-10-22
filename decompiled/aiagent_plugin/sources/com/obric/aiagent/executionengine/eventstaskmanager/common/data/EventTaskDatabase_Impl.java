package com.obric.aiagent.executionengine.eventstaskmanager.common.data;

import androidx.room.h;
import androidx.room.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class EventTaskDatabase_Impl extends EventTaskDatabase {
    public EventTaskDatabase_Impl() {
    }

    static /* synthetic */ androidx.sqlite.db.c a(EventTaskDatabase_Impl r2, androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        r2.f2668a = r4;
        return r4;
    }

    static /* synthetic */ List a(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List b(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ void b(EventTaskDatabase_Impl r2, androidx.sqlite.db.c r3) {
        r2.a((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List d(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List e(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List f(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List g(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List h(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List i(EventTaskDatabase_Impl r0) {
        return r0.f2670c;
    }

    @Override // androidx.room.p
    public androidx.sqlite.db.d b(androidx.room.c r4) {
        final int r2 = 5;
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
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.a.class, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.b.c());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.d.class, com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.data.a.e.a());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.a.class, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.b.c());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.d.class, com.obric.aiagent.executionengine.eventstaskmanager.shortcuttask.data.a.e.a());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.a.class, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.b.a());
        r2.put(com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.a.class, com.obric.aiagent.executionengine.eventstaskmanager.executionrecord.detail.b.a());
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
}
