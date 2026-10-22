package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f39064a = 0;

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: compiled from: Merge.kt */
    @d.c.b.a.f(b = "Merge.kt", c = {213, 213}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1")
    static final class a<R, T> extends d.c.b.a.l implements d.h.a.q<i<? super R>, T, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f39066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<T, d.c.d<? super R>, Object> f39067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f39068d;

        a(d.h.a.m<? super T, ? super d.c.d<? super R>, ? extends Object> r3, d.c.d<? super a> r4) {
            d.h.a.m<T, d.c.d<? super R>, Object> r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39067c = r5;
            super(3, r6);
        }

        public final Object a(i<? super R> r3, T r4, d.c.d<? super d.x> r5) {
            i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f39067c, r7);
            r0.f39068d = r6;
            r0.f39066b = r4;
            return r0.invokeSuspend(d.x.f38692a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.h.a.q
        public /* synthetic */ Object invoke(Object r3, Object r4, d.c.d<? super d.x> r5) {
            return a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.preCheckCast(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.b.r$a<R, T> for r6v4 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // d.c.b.a.a
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            java.lang.Object r0 = d.c.a.b.a();
            int r1 = r6.f39065a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L7;
            d.o.a(r7);
        L16:
            d.x r6 = d.x.f38692a;
            return r6;
        L7:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r6;
        L9:
            java.lang.Object r1 = r6.f39068d;
            java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.i r1 = (kotlinx.coroutines.b.i) r1;
            d.o.a(r7);
            kotlinx.coroutines.b.i r1 = r1;
        L13:
            java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin");
            d.c.d<? super d.x> r3 = (d.c.d) r3;
            r6.f39068d = null;
            r6.f39065a = 2;
            java.lang.Object r6 = r1.emit(r7, r3);
            if (r6 != r0) goto L16;
            return r0;
        L10:
            d.o.a(r7);
            java.lang.Object r7 = r6.f39068d;
            java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.i r1 = (kotlinx.coroutines.b.i) r7;
            java.lang.Object r7 = r6.f39066b;
            d.h.a.m<T, d.c.d<? super R>, java.lang.Object> r5 = r6.f39067c;
            r6.f39068d = r1;
            r6.f39065a = 1;
            T r7 = (T) r7;
            java.lang.Object r6 = (d.c.d<? super R>) r6;
            r7 = r5.invoke(r7, r6);
            r1 = r1;
            if (r7 != r0) goto L13;
            return r0;
        }
    }

    static {
        f39064a = kotlinx.coroutines.internal.am.a("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);
    }

    public static final <T> h<T> a(Iterable<? extends h<? extends T>> r9) {
        return (h) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.b.a.j((Iterable) ZeusTransformUtils.wrapperContextForParams(r9, Iterable.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T> h<T> a(h<? extends T>... r0) {
        return j.a(d.a.i.j(r0));
    }

    public static final <T, R> h<R> a(h<? extends T> r10, d.h.a.q<? super i<? super R>, ? super T, ? super d.c.d<? super d.x>, ? extends Object> r11) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.aiagent.plugin");
        return (h) ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.b.a.i((d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.q.class, "com.obric.aiagent.plugin"), r4, null, 0, null, 28, null), h.class, "com.obric.aiagent.plugin");
    }

    public static final <T, R> h<R> a(h<? extends T> r3, d.h.a.m<? super T, ? super d.c.d<? super R>, ? extends Object> r4) {
        return j.b((h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.preCheckCast(new a((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin"), null), d.h.a.q.class, "com.obric.aiagent.plugin"));
    }
}
