package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Interruptible.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class bx {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Interruptible.kt */
    @d.c.b.a.f(b = "Interruptible.kt", c = {}, d = "invokeSuspend", e = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2")
    static final class a<T> extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super T>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f39173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<T> f39174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f39175c;

        a(d.h.a.a<? extends T> r3, d.c.d<? super a> r4) {
            d.h.a.a<T> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f39174b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super T> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            a r0 = new a(this.f39174b, r5);
            r0.f39175c = r3;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, Object r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            d.c.a.b.a();
            if (this.f39173a != 0) goto L7;
            d.o.a(r3);
            return bx.a(((am) ZeusTransformUtils.preCheckCast(this.f39175c, am.class, "com.obric.aiagent.plugin")).a(), this.f39174b);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final /* synthetic */ Object a(d.c.g r2, d.h.a.a r3) {
        return b((d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final <T> Object a(d.c.g r3, d.h.a.a<? extends T> r4, d.c.d<? super T> r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return i.a(r6, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r8);
    }

    private static final <T> T b(d.c.g r2, d.h.a.a<? extends T> r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        dd r0 = new dd(ce.c(r4));     // Catch: InterruptedException -> L10
        r0.a();     // Catch: InterruptedException -> L10
        T r6 = (T) r5.invoke();
        r0.b();     // Catch: InterruptedException -> L10
        return r6;
    L7:
        th = move-exception;
        r0.b();     // Catch: InterruptedException -> L10
        throw th;     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
