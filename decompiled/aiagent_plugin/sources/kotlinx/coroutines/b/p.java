package kotlinx.coroutines.b;

import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.m f39041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f39042b;

        /* JADX INFO: renamed from: kotlinx.coroutines.b.p$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @d.c.b.a.f(b = "Emitters.kt", c = {115, IdlErrors.E_RejectInferDeviceOverheat}, d = "collect", e = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1")
        public static final class AnonymousClass1 extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f39043a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f39044b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f39045c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f39046d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            Object f39047e;
            Object f;

            public AnonymousClass1(a r3, d.c.d r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f39045c = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f39043a = r3;
                this.f39044b |= Integer.MIN_VALUE;
                return this.f39045c.collect(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i<? super T> r7, d.c.d<? super d.x> r8) {
            i<? super T> r9 = (i) ZeusTransformUtils.wrapperContextForParams(r7, i.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r10, AnonymousClass1.class) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r10, AnonymousClass1.class, "com.obric.aiagent.plugin");
            if ((r0.f39044b & Integer.MIN_VALUE) == 0) goto L7;
            r0.f39044b -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.f39043a;
            Object r2 = d.c.a.b.a();
            int r3 = r0.f39044b;
            if (r3 == 0) goto L20;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            d.o.a(r11);
        L29:
            return d.x.f38692a;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            kotlinx.coroutines.b.a.u r6 = (kotlinx.coroutines.b.a.u) ZeusTransformUtils.preCheckCast(r0.f, kotlinx.coroutines.b.a.u.class, "com.obric.aiagent.plugin");
            r9 = (i) ZeusTransformUtils.preCheckCast(r0.f39047e, i.class, "com.obric.aiagent.plugin");
            a<T> r1 = (a) ZeusTransformUtils.preCheckCast(r0.f39046d, a.class, "com.obric.aiagent.plugin");
            d.o.a(r11);     // Catch: Throwable -> L18
        L25:
            r6.releaseIntercepted();
            h r12 = r1.f39042b;
            r0.f39046d = null;
            r0.f39047e = null;
            r0.f = null;
            r0.f39044b = 2;
            if (r12.collect(r9, r0) != r2) goto L29;
            return r2;
        L18:
            th = th;
        L32:
            r6.releaseIntercepted();
            throw th;
        L20:
            d.o.a(r11);
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.a.u r14 = new kotlinx.coroutines.b.a.u(r9, r0.getContext());
            d.h.a.m r4 = this.f39041a;     // Catch: Throwable -> L30
            r0.f39046d = this;     // Catch: Throwable -> L30
            r0.f39047e = r9;     // Catch: Throwable -> L30
            r0.f = r14;     // Catch: Throwable -> L30
            r0.f39044b = 1;     // Catch: Throwable -> L30
            d.h.b.m.a(6);     // Catch: Throwable -> L30
            Object r5 = r4.invoke(r14, r0);     // Catch: Throwable -> L30
            d.h.b.m.a(7);     // Catch: Throwable -> L30
            if (r5 != r2) goto L24;
            return r2;
        L24:
            r1 = this;
            r6 = r14;
        L30:
            th = th;
            r6 = r14;
        L7:
            r0 = new AnonymousClass1(this, r10);
            goto L8
        }

        public a(d.h.a.m r3, h r4) {
            d.h.a.m r5 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin");
            h r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
            this.f39041a = r5;
            this.f39042b = r6;
        }
    }

    public static final void a(i<?> r2) {
        i r3 = (i) ZeusTransformUtils.wrapperContextForParams(r2, i.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ap.class) == true) goto L6;
        return;
    L6:
        throw ((ap) ZeusTransformUtils.preCheckCast(r3, ap.class, "com.obric.aiagent.plugin")).f39010a;
    }

    public static final <T> h<T> a(h<? extends T> r2, d.h.a.m<? super i<? super T>, ? super d.c.d<? super d.x>, ? extends Object> r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        return (h) ZeusTransformUtils.preCheckCast(new a((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.m.class, "com.obric.aiagent.plugin"), r4), h.class, "com.obric.aiagent.plugin");
    }
}
