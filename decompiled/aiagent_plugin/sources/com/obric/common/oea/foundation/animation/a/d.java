package com.obric.common.oea.foundation.animation.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ValueAnimatable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f32312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f32313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.common.oea.foundation.animation.c.a<?> f32314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q<String, Object, Object, x> f32315e;
    private final m<Boolean, Throwable, x> f;

    /* JADX INFO: compiled from: ValueAnimatable.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f32316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f32317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.obric.common.oea.foundation.animation.c.a<?> f32318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private q<? super String, Object, Object, x> f32319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private m<? super Boolean, ? super Throwable, x> f32320e;

        public a() {
            this.f32316a = 1.0f;
            this.f32317b = 60.0f;
        }

        public static /* synthetic */ a a(a r1, int r2, int r3, com.obric.common.oea.foundation.animation.g.a r4, Float r5, int r6, Object r7) {
            com.obric.common.oea.foundation.animation.g.a<Integer> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r6 & 8) == 0) goto L6;
            r5 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r1.a(r2, r3, r8, r5);
        }

        public final a a(int r10, int r11, com.obric.common.oea.foundation.animation.g.a<Integer> r12, Float r13) {
            com.obric.common.oea.foundation.animation.g.a r7 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r7, "spec");
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.b.b.class) == false) goto L6;
            com.obric.common.oea.foundation.animation.c.a<?> r14 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.b("valueAnimationPlaceholder", Integer.valueOf(r10), Integer.valueOf(r11), aa.b(Integer.TYPE), r7, r13), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
        L8:
            this.f32318c = r14;
            return this;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.a.d.class) == false) goto L11;
            r14 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.C0880a("valueAnimationPlaceholder", Integer.valueOf(r10), Integer.valueOf(r11), aa.b(Integer.TYPE), r7, r13), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
            goto L8
        L11:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("不支持的 spec 类型: " + r7.getClass().getSimpleName()), Throwable.class, "com.obric.aiagent.plugin"));
        }

        public static /* synthetic */ a a(a r1, float r2, float r3, com.obric.common.oea.foundation.animation.g.a r4, Float r5, int r6, Object r7) {
            com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r6 & 8) == 0) goto L6;
            r5 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r1.a(r2, r3, r8, r5);
        }

        public final a a(float r10, float r11, com.obric.common.oea.foundation.animation.g.a<Float> r12, Float r13) {
            com.obric.common.oea.foundation.animation.g.a r7 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r7, "spec");
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.b.a.class) == false) goto L6;
            com.obric.common.oea.foundation.animation.c.a<?> r14 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.b("valueAnimationPlaceholder", Float.valueOf(r10), Float.valueOf(r11), aa.b(Float.TYPE), r7, r13), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
        L8:
            this.f32318c = r14;
            return this;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.a.b.class) == false) goto L11;
            r14 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.C0880a("valueAnimationPlaceholder", Float.valueOf(r10), Float.valueOf(r11), aa.b(Float.TYPE), r7, r13), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
            goto L8
        L11:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("不支持的 spec 类型: " + r7.getClass().getSimpleName()), Throwable.class, "com.obric.aiagent.plugin"));
        }

        public final a a(q<? super String, Object, Object, x> r3) {
            q<? super String, Object, Object, x> r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
            o.e(r4, "callback");
            this.f32319d = r4;
            return this;
        }

        public final a a(m<? super Boolean, ? super Throwable, x> r3) {
            m<? super Boolean, ? super Throwable, x> r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            o.e(r4, "callback");
            this.f32320e = r4;
            return this;
        }

        public final a a(float r1) {
            this.f32316a = r1;
            return this;
        }

        public final a b(float r1) {
            this.f32317b = r1;
            return this;
        }

        public final d a() {
            if (((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f32318c != null) goto L5;
            com.obric.common.oea.foundation.animation.h.d.a("必须先调用方法ofXXX方法指定动画初始和目标值");
        L5:
            float r2 = this.f32316a;
            float r3 = this.f32317b;
            com.obric.common.oea.foundation.animation.c.a<?> r4 = this.f32318c;
            if (r4 != null) goto L9;
            o.c("valueAnimationCommand");
        L9:
            return new d(r2, r3, r4, this.f32319d, this.f32320e, null);
        }
    }

    private d(float r3, float r4, com.obric.common.oea.foundation.animation.c.a<?> r5, q<? super String, Object, Object, x> r6, m<? super Boolean, ? super Throwable, x> r7) {
        q<String, Object, Object, x> r8 = (q) ZeusTransformUtils.wrapperContextForParams(r6, q.class, "com.obric.aiagent.plugin");
        m<Boolean, Throwable, x> r9 = (m) ZeusTransformUtils.wrapperContextForParams(r7, m.class, "com.obric.aiagent.plugin");
        this.f32312b = r3;
        this.f32313c = r4;
        this.f32314d = r5;
        this.f32315e = r8;
        this.f = r9;
        this.f32311a = "ValueAnimatable";
    }

    public /* synthetic */ d(float r8, float r9, com.obric.common.oea.foundation.animation.c.a r10, q r11, m r12, h r13) {
        this(r8, r9, r10, (q) ZeusTransformUtils.wrapperContextForParams(r11, q.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.wrapperContextForParams(r12, m.class, "com.obric.aiagent.plugin"));
    }

    public final com.obric.common.oea.foundation.animation.manager.d a() {
        return b(com.obric.common.oea.foundation.animation.d.b.f32344a, com.obric.common.oea.foundation.animation.d.a.f32340a, false);
    }

    public final com.obric.common.oea.foundation.animation.manager.d a(com.obric.common.oea.foundation.animation.d.b r2, com.obric.common.oea.foundation.animation.d.a r3, boolean r4) {
        o.e(r2, "runMode");
        o.e(r3, "repeatMode");
        return b(r2, r3, r4);
    }

    private final com.obric.common.oea.foundation.animation.manager.d b(com.obric.common.oea.foundation.animation.d.b r10, com.obric.common.oea.foundation.animation.d.a r11, boolean r12) {
        com.obric.common.oea.foundation.b.c.f32472a.b(this.f32311a, "执行start ");
        com.obric.common.oea.foundation.animation.a.a r0 = new com.obric.common.oea.foundation.animation.a.a(r10, r11, this.f32312b, this.f32313c, r12);
        com.obric.common.oea.foundation.animation.f.a r3 = com.obric.common.oea.foundation.animation.f.a.f32384a;
        List<? extends com.obric.common.oea.foundation.animation.c.a<?>> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        r6.add(this.f32314d);
        x r13 = x.f38692a;
        return r3.a(r0, null, r6, this.f32315e, this.f);
    }
}
