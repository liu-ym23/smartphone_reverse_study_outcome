package com.obric.autogui.database;

import androidx.room.h;
import androidx.room.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionDatabase_Impl extends AutoActionDatabase {
    public AutoActionDatabase_Impl() {
    }

    static /* synthetic */ androidx.sqlite.db.c a(AutoActionDatabase_Impl r2, androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        r2.f2668a = r4;
        return r4;
    }

    static /* synthetic */ List a(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List b(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ void b(AutoActionDatabase_Impl r2, androidx.sqlite.db.c r3) {
        r2.a((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List d(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List e(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List f(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List g(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List h(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List i(AutoActionDatabase_Impl r0) {
        return r0.f2670c;
    }

    @Override // androidx.room.p
    public androidx.sqlite.db.d b(androidx.room.c r4) {
        final int r2 = 5;
        r r0 = new r(r4, new AnonymousClass1(this, r2), "9c985f7445a803e2fa1cbcfde985a93d", "874ac8ab8b4bfb69e6888ed81e8bbfac");
        androidx.sqlite.db.d.b r3 = androidx.sqlite.db.d.b.a(r4.f2624b).a(r4.f2625c).a(r0).a();
        return r4.f2623a.b(r3);
    }

    @Override // androidx.room.p
    public h c() {
        return new h(this, new HashMap(0), new HashMap(0), new String[]{"tasks", "steps", "operations"});
    }

    @Override // androidx.room.p
    public Map<Class<?>, List<Class<?>>> d() {
        HashMap r2 = new HashMap();
        r2.put(com.obric.autogui.database.a.c.class, com.obric.autogui.database.a.d.a());
        r2.put(com.obric.autogui.database.a.a.class, com.obric.autogui.database.a.b.a());
        r2.put(b.class, c.a());
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
