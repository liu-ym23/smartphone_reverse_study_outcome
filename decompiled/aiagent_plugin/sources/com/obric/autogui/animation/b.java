package com.obric.autogui.animation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import d.x;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: TextFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a implements h<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f28906a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f28907b;

        /* JADX INFO: renamed from: com.obric.autogui.animation.b$a$1, reason: invalid class name */
        /* JADX INFO: compiled from: Emitters.kt */
        public static final class AnonymousClass1<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ i f28908a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f28909b;

            /* JADX INFO: renamed from: com.obric.autogui.animation.b$a$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @f(b = "TextFlow.kt", c = {219}, d = "emit", e = "com.obric.autogui.animation.TextFlowKt$animateText$$inlined$map$1$2")
            public static final class C07211 extends d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                /* synthetic */ Object f28910a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                int f28911b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ AnonymousClass1 f28912c;

                public C07211(AnonymousClass1 r3, d.c.d r4) {
                    d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f28912c = r3;
                    super(r5);
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    this.f28910a = r3;
                    this.f28911b |= Integer.MIN_VALUE;
                    return this.f28912c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                }
            }

            public AnonymousClass1(i r3, String r4) {
                this.f28908a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                this.f28909b = r4;
            }

            @Override // kotlinx.coroutines.b.i
            public final Object emit(Object r6, d.c.d r7) {
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                if (ZeusTransformUtils.instanceOf(r8, C07211.class) == false) goto L7;
                C07211 r0 = (C07211) ZeusTransformUtils.preCheckCast(r8, C07211.class, "com.obric.aiagent.plugin");
                if ((r0.f28911b & Integer.MIN_VALUE) == 0) goto L7;
                r0.f28911b -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.f28910a;
                Object r2 = d.c.a.b.a();
                int r3 = r0.f28911b;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                o.a(r9);
            L18:
                return x.f38692a;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                o.a(r9);
                i r10 = this.f28908a;
                d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                int r11 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
                String r5 = this.f28909b;
                String r12 = d.o.o.e(r5, r5.length() - r11);
                r0.f28911b = 1;
                if (r10.emit(r12, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new C07211(this, r8);
                goto L8
            }
        }

        public a(h r3, String r4) {
            this.f28906a = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            this.f28907b = r4;
        }

        @Override // kotlinx.coroutines.b.h
        public Object collect(i<? super String> r4, d.c.d r5) {
            i r6 = (i) ZeusTransformUtils.wrapperContextForParams(r4, i.class, "com.obric.aiagent.plugin");
            d.c.d<? super x> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            Object r3 = this.f28906a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f28907b), i.class, "com.obric.aiagent.plugin"), r7);
            if (r3 != d.c.a.b.a()) goto L6;
            return r3;
        L6:
            return x.f38692a;
        }
    }

    private static final float a(float r0) {
        return r0;
    }

    /* JADX INFO: renamed from: lambda$4cPAcYStE1l-RMlbHwfuvyseda8, reason: not valid java name */
    public static /* synthetic */ float m794lambda$4cPAcYStE1lRMlbHwfuvyseda8(d.h.a.b r0, float r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ float lambda$yyBvbruvgNY3ZVQDhI7dS2XbpsE(float r0) {
        return a(r0);
    }

    public static /* synthetic */ h a(String r1, long r2, d.h.a.b r4, int r5, Object r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 1000;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r7 = $$Lambda$b$yyBvbruvgNY3ZVQDhI7dS2XbpsE.INSTANCE;
    L9:
        return a(r1, r2, r7);
    }

    public static final h<String> a(String r10, long r11, d.h.a.b<? super Float, Float> r13) {
        final d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r14, "interpolator");
        return (h) ZeusTransformUtils.preCheckCast(new a(com.obric.autogui.animation.a.a(r10.length(), 0, r11, false, new $$Lambda$b$4cPAcYStE1lRMlbHwfuvyseda8(r14), 4, null), r10), h.class, "com.obric.aiagent.plugin");
    }

    private static final float a(d.h.a.b r2, float r3) {
        return ((Number) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(Float.valueOf(r3)), Number.class, "com.obric.aiagent.plugin")).floatValue();
    }
}
