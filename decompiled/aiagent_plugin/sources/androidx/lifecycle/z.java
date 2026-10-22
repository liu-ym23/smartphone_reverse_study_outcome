package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: PausingDispatcher.kt */
    @d.c.b.a.f(b = "PausingDispatcher.kt", c = {203}, d = "invokeSuspend", e = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2")
    static final class a<T> extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f2082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i.b f2083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, Object> f2084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private /* synthetic */ Object f2085e;

        a(i r3, i.b r4, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super T>, ? extends Object> r5, d.c.d<? super a> r6) {
            d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, Object> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f2082b = r3;
            this.f2083c = r4;
            this.f2084d = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super T> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f2082b, this.f2083c, this.f2084d, r7);
            r0.f2085e = r5;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, Object r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f2081a;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            j r8 = (j) ZeusTransformUtils.preCheckCast(this.f2085e, j.class, "com.obric.aiagent.plugin");
            d.o.a(r9);     // Catch: Throwable -> L8
        L19:
            r8.a();
            return r9;
        L8:
            th = th;
        L23:
            r8.a();
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            d.o.a(r9);
            ca r10 = (ca) ZeusTransformUtils.preCheckCast(((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f2085e, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin")).a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin");
            if (r10 == null) goto L26;
            y r2 = new y();
            j r4 = new j(this.f2082b, this.f2083c, r2.f2080a, r10);
            d.c.g r11 = (d.c.g) ZeusTransformUtils.preCheckCast(r2, d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            d.h.a.m<kotlinx.coroutines.am, d.c.d<? super T>, Object> r3 = this.f2084d;     // Catch: Throwable -> L21
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
            this.f2085e = r4;     // Catch: Throwable -> L21
            this.f2081a = 1;     // Catch: Throwable -> L21
            r9 = kotlinx.coroutines.i.a(r11, r3, r5);     // Catch: Throwable -> L21
            if (r9 != r0) goto L18;
            return r0;
        L18:
            r8 = r4;
        L21:
            th = th;
            r8 = r4;
            goto L23
        L26:
            throw new IllegalStateException("when[State] methods should have a parent job".toString());
        }
    }

    public static final <T> Object a(i r2, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super T>, ? extends Object> r3, d.c.d<? super T> r4) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r2, i.b.f2056c, r5, r6);
    }

    public static final <T> Object b(i r2, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super T>, ? extends Object> r3, d.c.d<? super T> r4) {
        d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        return a(r2, i.b.f2058e, r5, r6);
    }

    public static final <T> Object a(i r4, i.b r5, d.h.a.m<? super kotlinx.coroutines.am, ? super d.c.d<? super T>, ? extends Object> r6, d.c.d<? super T> r7) {
        d.h.a.m r8 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.b().a(), d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r4, r5, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r9);
    }
}
