package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface g {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public static final class a {

        /* JADX INFO: renamed from: d.c.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContext.kt */
        static final class C1036a extends p implements m<g, b, g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1036a f38422a = null;

            static {
                f38422a = new C1036a();
            }

            C1036a() {
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ g invoke(g r3, b r4) {
                return a((g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.aiagent.plugin"));
            }

            public final g a(g r4, b r5) {
                g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
                b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
                o.e(r3, "acc");
                o.e(r6, "element");
                g r7 = r3.minusKey(r6.getKey());
                if (r7 == h.f38423a) goto L14;
                e r8 = (e) ZeusTransformUtils.preCheckCast(r7.get((c) ZeusTransformUtils.preCheckCast(e.f38420b, c.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin");
                if (r8 != null) goto L8;
                d.c.c r9 = new d.c.c(r7, r6);
            L13:
                return (g) ZeusTransformUtils.preCheckCast(r9, g.class, "com.obric.aiagent.plugin");
            L8:
                g r10 = r7.minusKey((c) ZeusTransformUtils.preCheckCast(e.f38420b, c.class, "com.obric.aiagent.plugin"));
                if (r10 != h.f38423a) goto L11;
                r9 = new d.c.c((g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin"));
                goto L13
            L11:
                r9 = new d.c.c((g) ZeusTransformUtils.preCheckCast(new d.c.c(r10, r6), g.class, "com.obric.aiagent.plugin"), (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin"));
                goto L13
            L14:
                return (g) ZeusTransformUtils.preCheckCast(r6, g.class, "com.obric.aiagent.plugin");
            }
        }

        public static g a(g r3, g r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            if (r6 != h.f38423a) goto L6;
            return r5;
        L6:
            return (g) ZeusTransformUtils.preCheckCast(r6.fold(r5, (m) ZeusTransformUtils.preCheckCast(C1036a.f38422a, m.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface b extends g {

        /* JADX INFO: compiled from: CoroutineContext.kt */
        public static final class a {
            public static g a(b r2, g r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
                g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin");
                o.e(r5, "context");
                return a.a((g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin"), r5);
            }

            public static <E extends b> E a(b r2, c<E> r3) {
                E r4 = (E) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
                c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
                o.e(r5, "key");
                if (o.a(r4.getKey(), r5) == false) goto L5;
                o.a(r4, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return r4;
            L5:
                return null;
            }

            public static <R> R a(b r2, R r3, m<? super R, ? super b, ? extends R> r4) {
                b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
                m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
                o.e(r6, "operation");
                return (R) r6.invoke(r3, r5);
            }

            public static g b(b r2, c<?> r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
                c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
                o.e(r5, "key");
                boolean r6 = o.a(r4.getKey(), r5);
                Object r7 = r4;
                if (r6 == false) goto L6;
                r7 = h.f38423a;
            L6:
                return (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
            }
        }

        @Override // d.c.g
        <E extends b> E get(c<E> r1);

        c<?> getKey();
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    public interface c<E extends b> {
    }

    <R> R fold(R r1, m<? super R, ? super b, ? extends R> r2);

    <E extends b> E get(c<E> r1);

    g minusKey(c<?> r1);

    g plus(g r1);
}
