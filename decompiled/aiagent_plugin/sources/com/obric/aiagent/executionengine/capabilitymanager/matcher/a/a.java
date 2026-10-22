package com.obric.aiagent.executionengine.capabilitymanager.matcher.a;

import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.m;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.w;
import com.obric.aiagent.executionengine.scheduler.impl.appfunction.registry.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.o;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: AppFunctionCapabilitySource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.obric.aiagent.executionengine.capabilitymanager.matcher.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.a f16470b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Boolean> f16471c = null;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.capabilitymanager.matcher.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppFunctionCapabilitySource.kt */
    @f(b = "AppFunctionCapabilitySource.kt", c = {50}, d = "snapshot", e = "com.obric.aiagent.executionengine.capabilitymanager.matcher.source.AppFunctionCapabilitySource")
    static final class C0334a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f16472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f16474c;

        C0334a(a r3, d.c.d<? super C0334a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16473b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16472a = r3;
            this.f16474c |= Integer.MIN_VALUE;
            return this.f16473b.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ com.obric.aiagent.executionengine.capabilitymanager.api.a.b lambda$E59wWpaUcTLggDOnQdCXPp34koM(m r0) {
        return c(r0);
    }

    public static /* synthetic */ boolean lambda$erTMxCYJ4SDhP539liuX5G9qHY0(m r0) {
        return b(r0);
    }

    private a() {
    }

    static {
        f16469a = new a();
        f16470b = com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16400b;
        f16471c = new ConcurrentHashMap();
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public com.obric.aiagent.executionengine.capabilitymanager.api.a.a getType() {
        return f16470b;
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void a() {
        x.f18310a.a();
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public Object a(d.c.d<? super List<com.obric.aiagent.executionengine.capabilitymanager.api.a.b>> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C0334a.class) == false) goto L7;
        C0334a r0 = (C0334a) ZeusTransformUtils.preCheckCast(r8, C0334a.class, "com.obric.aiagent.plugin");
        if ((r0.f16474c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16474c -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f16472a;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f16474c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r6);
    L18:
        return d.n.m.g(d.n.m.d(d.n.m.a(p.y((Iterable) ZeusTransformUtils.preCheckCast(x.f18310a.c(), Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$a$erTMxCYJ4SDhP539liuX5G9qHY0.INSTANCE), $$Lambda$a$E59wWpaUcTLggDOnQdCXPp34koM.INSTANCE));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r6);
        x r10 = x.f18310a;
        r0.f16474c = 1;
        if (r10.a(800, r0) != r9) goto L18;
        return r9;
    L7:
        r0 = new C0334a(this, r8);
        goto L8
    }

    private static final boolean b(m r1) {
        d.h.b.o.e(r1, "it");
        return f16469a.a(r1);
    }

    private static final com.obric.aiagent.executionengine.capabilitymanager.api.a.b c(m r9) {
        d.h.b.o.e(r9, "entry");
        return new com.obric.aiagent.executionengine.capabilitymanager.api.a.b(com.obric.aiagent.executionengine.capabilitymanager.api.a.a.f16400b, r9.e(), r9.c(), r9.d(), null, 16, null);
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.matcher.b
    public void b() {
        f16471c.clear();
        x.f18310a.b();
    }

    private final boolean a(m r5) {
        if (r5.a() != null) goto L6;
        return true;
    L6:
        String r4 = r5.a();
        String r0 = r5.b();
        if (r0 != null) goto L9;
        return false;
    L9:
        String r6 = r5.c() + 0 + r4 + '_' + r0;
        ConcurrentMap r1 = (ConcurrentMap) ZeusTransformUtils.preCheckCast(f16471c, ConcurrentMap.class, "com.obric.aiagent.plugin");
        Object r2 = r1.get(r6);
        if (r2 != null) goto L15;
        Boolean r7 = Boolean.valueOf(w.f18308a.a(r5));
        Object r8 = r1.putIfAbsent(r6, r7);
        if (r8 != null) goto L14;
        r2 = r7;
        goto L15
    L14:
        r2 = r8;
    L15:
        d.h.b.o.c(r2, "getOrPut(...)");
        return ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }
}
