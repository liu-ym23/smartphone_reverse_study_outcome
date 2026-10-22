package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: Collect.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class m {

    /* JADX INFO: compiled from: Collect.kt */
    @d.c.b.a.f(b = "Collect.kt", c = {46}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1")
    static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h<T> f39036b;

        a(h<? extends T> r3, d.c.d<? super a> r4) {
            h<T> r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39036b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f39036b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f39035a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            h<T> r6 = this.f39036b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39035a = 1;
            if (j.a(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    public static final Object a(h<?> r3, d.c.d<? super d.x> r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r7 = r5.collect((i) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.b.a.s.f38937a, i.class, "com.obric.aiagent.plugin"), r6);
        if (r7 != d.c.a.b.a()) goto L6;
        return r7;
    L6:
        return d.x.f38692a;
    }

    public static final <T> ca a(h<? extends T> r8, kotlinx.coroutines.am r9) {
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static final <T> Object a(h<? extends T> r2, d.h.a.m<? super T, ? super d.c.d<? super d.x>, ? extends Object> r3, d.c.d<? super d.x> r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        d.h.a.m r6 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = j.a(j.a(j.b(r5, r6), 0, null, 2, null), r7);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return d.x.f38692a;
    }

    public static final <T> Object a(i<? super T> r2, h<? extends T> r3, d.c.d<? super d.x> r4) {
        i<? super T> r5 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
        h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        d.c.d<? super d.x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        j.a(r5);
        Object r8 = r6.collect(r5, r7);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return d.x.f38692a;
    }
}
