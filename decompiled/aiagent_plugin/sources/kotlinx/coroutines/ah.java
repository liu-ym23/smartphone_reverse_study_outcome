package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ah {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    static final class a extends d.h.b.p implements d.h.a.m<d.c.g, d.c.g.b, d.c.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38833a = null;

        static {
            f38833a = new a();
        }

        a() {
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.c.g invoke(d.c.g r3, d.c.g.b r4) {
            return a((d.c.g) ZeusTransformUtils.preCheckCast(r3, d.c.g.class, "com.obric.aiagent.plugin"), (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }

        public final d.c.g a(d.c.g r2, d.c.g.b r3) {
            d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
            d.c.g.b r4 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.b.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r4, af.class) == false) goto L7;
            return r1.plus((d.c.g) ZeusTransformUtils.preCheckCast(((af) ZeusTransformUtils.preCheckCast(r4, af.class, "com.obric.aiagent.plugin")).a(), d.c.g.class, "com.obric.aiagent.plugin"));
        L7:
            return r1.plus((d.c.g) ZeusTransformUtils.preCheckCast(r4, d.c.g.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    static final class b extends d.h.b.p implements d.h.a.m<d.c.g, d.c.g.b, d.c.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.b.z.f<d.c.g> f38834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f38835b;

        b(d.h.b.z.f<d.c.g> r1, boolean r2) {
            this.f38834a = r1;
            this.f38835b = r2;
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.c.g invoke(d.c.g r3, d.c.g.b r4) {
            return a((d.c.g) ZeusTransformUtils.preCheckCast(r3, d.c.g.class, "com.obric.aiagent.plugin"), (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [T, d.c.g] */
        public final d.c.g a(d.c.g r5, d.c.g.b r6) {
            d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
            d.c.g.b r8 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r6, d.c.g.b.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, af.class) == false) goto L5;
            d.c.g.b r0 = ((d.c.g) ZeusTransformUtils.preCheckCast(this.f38834a.f38504a, d.c.g.class, "com.obric.aiagent.plugin")).get(r8.getKey());
            if (r0 == null) goto L9;
            d.h.b.z.f<d.c.g> r4 = this.f38834a;
            r4.f38504a = ((d.c.g) ZeusTransformUtils.preCheckCast(r4.f38504a, d.c.g.class, "com.obric.aiagent.plugin")).minusKey(r8.getKey());
            return r7.plus(((af) ZeusTransformUtils.preCheckCast(r8, af.class, "com.obric.aiagent.plugin")).a(r0));
        L9:
            if (this.f38835b == false) goto L11;
            af r9 = ((af) ZeusTransformUtils.preCheckCast(r8, af.class, "com.obric.aiagent.plugin")).a();
        L13:
            return r7.plus((d.c.g) ZeusTransformUtils.preCheckCast(r9, d.c.g.class, "com.obric.aiagent.plugin"));
        L11:
            r9 = (af) ZeusTransformUtils.preCheckCast(r8, af.class, "com.obric.aiagent.plugin");
            goto L13
        L5:
            return r7.plus((d.c.g) ZeusTransformUtils.preCheckCast(r8, d.c.g.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    static final class c extends d.h.b.p implements d.h.a.m<Boolean, d.c.g.b, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f38836a = null;

        static {
            f38836a = new c();
        }

        c() {
            super(2);
        }

        public final Boolean a(boolean r2, d.c.g.b r3) {
            d.c.g.b r1 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.b.class, "com.obric.aiagent.plugin");
            if (r2 == false) goto L5;
        L8:
            boolean r4 = true;
        L10:
            return Boolean.valueOf(r4);
        L5:
            if (ZeusTransformUtils.instanceOf(r1, af.class) == true) goto L8;
            r4 = false;
            goto L10
        }

        @Override // d.h.a.m
        public /* synthetic */ Boolean invoke(Boolean r3, d.c.g.b r4) {
            return a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }
    }

    public static final d.c.g a(am r4, d.c.g r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.aiagent.plugin");
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        d.c.g r8 = a(r6.a(), r7, true);
        if (aq.b() == false) goto L5;
        d.c.g r9 = r8.plus((d.c.g) ZeusTransformUtils.preCheckCast(new ak(aq.d().incrementAndGet()), d.c.g.class, "com.obric.aiagent.plugin"));
    L7:
        if (r8 != bd.a()) goto L9;
        return r9;
    L9:
        if (r8.get((d.c.g.c) ZeusTransformUtils.preCheckCast(d.c.e.f38420b, d.c.g.c.class, "com.obric.aiagent.plugin")) == null) goto L11;
        return r9;
    L11:
        return r9.plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.a(), d.c.g.class, "com.obric.aiagent.plugin"));
    L5:
        r9 = r8;
        goto L7
    }

    public static final d.c.g a(d.c.g r2, d.c.g r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if (b(r5) == true) goto L7;
        return r4.plus(r5);
    L7:
        return a(r4, r5, false);
    }

    private static final boolean b(d.c.g r4) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin")).fold(false, (d.h.a.m) ZeusTransformUtils.preCheckCast(c.f38836a, d.h.a.m.class, "com.obric.aiagent.plugin")), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, d.c.g] */
    private static final d.c.g a(d.c.g r4, d.c.g r5, boolean r6) {
        d.c.g r7 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        ?? r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        boolean r0 = b(r7);
        boolean r2 = b(r8);
        if (r0 == true) goto L7;
        if (r2 == true) goto L7;
        return r7.plus(r8);
    L7:
        d.h.b.z.f r1 = new d.h.b.z.f();
        r1.f38504a = r8;
        d.c.g r9 = (d.c.g) ZeusTransformUtils.preCheckCast(r7.fold(d.c.h.f38423a, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r1, r6), d.h.a.m.class, "com.obric.aiagent.plugin")), d.c.g.class, "com.obric.aiagent.plugin");
        if (r2 == false) goto L11;
        r1.f38504a = ((d.c.g) ZeusTransformUtils.preCheckCast(r1.f38504a, d.c.g.class, "com.obric.aiagent.plugin")).fold(d.c.h.f38423a, (d.h.a.m) ZeusTransformUtils.preCheckCast(a.f38833a, d.h.a.m.class, "com.obric.aiagent.plugin"));
    L11:
        return r9.plus((d.c.g) ZeusTransformUtils.preCheckCast(r1.f38504a, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final di<?> a(d.c.d<?> r4, d.c.g r5, Object r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.g r8 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, d.c.b.a.e.class) == true) goto L6;
        return null;
    L6:
        if (r8.get((d.c.g.c) ZeusTransformUtils.preCheckCast(dj.f39266a, d.c.g.c.class, "com.obric.aiagent.plugin")) == null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        return null;
    L11:
        di<?> r9 = a((d.c.b.a.e) ZeusTransformUtils.preCheckCast(r7, d.c.b.a.e.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L14;
        r9.a(r8, r6);
    L14:
        return r9;
    L8:
        r0 = false;
        goto L9
    }

    public static final di<?> a(d.c.b.a.e r3) {
        d.c.b.a.e r4 = (d.c.b.a.e) ZeusTransformUtils.wrapperContextForParams(r3, d.c.b.a.e.class, "com.obric.aiagent.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r4, az.class) == true) goto L5;
        r4 = r4.getCallerFrame();
        if (r4 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r4, di.class) == false) goto L4;
        return (di) ZeusTransformUtils.preCheckCast(r4, di.class, "com.obric.aiagent.plugin");
    L8:
        return null;
    L5:
        return null;
    }

    public static final String a(d.c.g r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        if (aq.b() == true) goto L5;
        return null;
    L5:
        ak r0 = (ak) ZeusTransformUtils.preCheckCast(r5.get((d.c.g.c) ZeusTransformUtils.preCheckCast(ak.f38839a, d.c.g.c.class, "com.obric.aiagent.plugin")), ak.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return null;
    L8:
        al r6 = (al) ZeusTransformUtils.preCheckCast(r5.get((d.c.g.c) ZeusTransformUtils.preCheckCast(al.f38841a, d.c.g.c.class, "com.obric.aiagent.plugin")), al.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        String r7 = r6.a();
        if (r7 == null) goto L12;
    L14:
        return r7 + '#' + r0.a();
    L12:
        r7 = "coroutine";
        goto L14
    }
}
