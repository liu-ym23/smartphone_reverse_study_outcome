package com.obric.aiagent.executionengine.capabilitymanager.data;

import androidx.room.h;
import androidx.room.r;
import androidx.sqlite.db.c;
import androidx.sqlite.db.d;
import com.obric.aiagent.executionengine.capabilitymanager.data.b.a;
import com.obric.aiagent.executionengine.capabilitymanager.data.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class CapabilityDatabase_Impl extends CapabilityDatabase {
    private volatile a f;

    public CapabilityDatabase_Impl() {
    }

    static /* synthetic */ c a(CapabilityDatabase_Impl r2, c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        r2.f2668a = r4;
        return r4;
    }

    static /* synthetic */ List a(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List b(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ void b(CapabilityDatabase_Impl r2, c r3) {
        r2.a((c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List d(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List e(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List f(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List g(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List h(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List i(CapabilityDatabase_Impl r0) {
        return r0.f2670c;
    }

    @Override // androidx.room.p
    public d b(androidx.room.c r4) {
        final int r2 = 2;
        r r0 = new r(r4, new AnonymousClass1(this, r2), "29c3452c76400bf91e76f1bff66ee8e9", "56a0e880e7697f9d11d2ad647ac81b49");
        d.b r3 = d.b.a(r4.f2624b).a(r4.f2625c).a(r0).a();
        return r4.f2623a.b(r3);
    }

    @Override // androidx.room.p
    public h c() {
        return new h(this, new HashMap(0), new HashMap(0), new String[]{"capability_bean", "intent_bean"});
    }

    @Override // androidx.room.p
    public Map<Class<?>, List<Class<?>>> d() {
        HashMap r2 = new HashMap();
        r2.put(a.class, b.b());
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

    @Override // com.obric.aiagent.executionengine.capabilitymanager.data.CapabilityDatabase
    public a o() {
        if (this.f != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f != null) goto L10;
        this.f = new b(this);     // Catch: Throwable -> L13
    L10:
        a r0 = this.f;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f;
    }
}
