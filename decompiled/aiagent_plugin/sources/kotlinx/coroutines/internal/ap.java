package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.cy;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final al f39371a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.h.a.m<Object, d.c.g.b, Object> f39372b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final d.h.a.m<cy<?>, d.c.g.b, cy<?>> f39373c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.h.a.m<at, d.c.g.b, at> f39374d = null;

    /* JADX INFO: compiled from: ThreadContext.kt */
    static final class a extends d.h.b.p implements d.h.a.m<Object, d.c.g.b, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f39375a = null;

        static {
            f39375a = new a();
        }

        a() {
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(Object r3, d.c.g.b r4) {
            return a(r3, (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(Object r2, d.c.g.b r3) {
            d.c.g.b r1 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.b.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r1, cy.class) == true) goto L5;
            return r2;
        L5:
            if (ZeusTransformUtils.instanceOf(r2, Integer.class) == false) goto L7;
            Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r2, Integer.class, "com.obric.aiagent.plugin");
        L9:
            if (r4 == null) goto L11;
            int r5 = r4.intValue();
        L12:
            if (r5 != 0) goto L15;
            return r1;
        L15:
            return Integer.valueOf(r5 + 1);
        L11:
            r5 = 1;
            goto L12
        L7:
            r4 = null;
            goto L9
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    static final class b extends d.h.b.p implements d.h.a.m<cy<?>, d.c.g.b, cy<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f39376a = null;

        static {
            f39376a = new b();
        }

        b() {
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ cy<?> invoke(cy<?> r3, d.c.g.b r4) {
            return a((cy) ZeusTransformUtils.preCheckCast(r3, cy.class, "com.obric.aiagent.plugin"), (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }

        public final cy<?> a(cy<?> r2, d.c.g.b r3) {
            cy<?> r1 = (cy) ZeusTransformUtils.wrapperContextForParams(r2, cy.class, "com.obric.aiagent.plugin");
            d.c.g.b r4 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.b.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L6;
            return r1;
        L6:
            if (ZeusTransformUtils.instanceOf(r4, cy.class) == true) goto L10;
            return null;
        L10:
            return (cy) ZeusTransformUtils.preCheckCast(r4, cy.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ThreadContext.kt */
    static final class c extends d.h.b.p implements d.h.a.m<at, d.c.g.b, at> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f39377a = null;

        static {
            f39377a = new c();
        }

        c() {
            super(2);
        }

        @Override // d.h.a.m
        public /* synthetic */ at invoke(at r3, d.c.g.b r4) {
            return a((at) ZeusTransformUtils.preCheckCast(r3, at.class, "com.obric.aiagent.plugin"), (d.c.g.b) ZeusTransformUtils.preCheckCast(r4, d.c.g.b.class, "com.obric.aiagent.plugin"));
        }

        public final at a(at r3, d.c.g.b r4) {
            d.c.g.b r2 = (d.c.g.b) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.b.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r2, cy.class) == false) goto L5;
            r3.a((cy) ZeusTransformUtils.preCheckCast(r2, cy.class, "com.obric.aiagent.plugin"), ((cy) ZeusTransformUtils.preCheckCast(r2, cy.class, "com.obric.aiagent.plugin")).b(r3.f39380a));
        L5:
            return r3;
        }
    }

    static {
        f39371a = new al("NO_THREAD_ELEMENTS");
        f39372b = (d.h.a.m) ZeusTransformUtils.preCheckCast(a.f39375a, d.h.a.m.class, "com.obric.aiagent.plugin");
        f39373c = (d.h.a.m) ZeusTransformUtils.preCheckCast(b.f39376a, d.h.a.m.class, "com.obric.aiagent.plugin");
        f39374d = (d.h.a.m) ZeusTransformUtils.preCheckCast(c.f39377a, d.h.a.m.class, "com.obric.aiagent.plugin");
    }

    public static final Object a(d.c.g r2) {
        Object r3 = ((d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin")).fold(0, f39372b);
        d.h.b.o.a(r3);
        return r3;
    }

    public static final Object a(d.c.g r3, Object r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L6;
        r4 = a(r5);
    L6:
        if (r4 != 0) goto L9;
        return f39371a;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, Integer.class) == true) goto L14;
        d.h.b.o.a(r4, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((cy) ZeusTransformUtils.preCheckCast(r4, cy.class, "com.obric.aiagent.plugin")).b(r5);
    L14:
        return r5.fold(new at(r5, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue()), f39374d);
    }

    public static final void b(d.c.g r3, Object r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        if (r4 != f39371a) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, at.class) == false) goto L8;
        ((at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.aiagent.plugin")).a(r5);
        return;
    L8:
        Object r0 = r5.fold(null, f39373c);
        d.h.b.o.a(r0, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((cy) ZeusTransformUtils.preCheckCast(r0, cy.class, "com.obric.aiagent.plugin")).a(r5, r4);
    }
}
