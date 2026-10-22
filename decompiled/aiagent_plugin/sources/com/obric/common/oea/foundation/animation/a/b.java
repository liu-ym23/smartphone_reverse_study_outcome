package com.obric.common.oea.foundation.animation.a;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.q;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PropertyAnimatable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f32301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f32302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f32303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f32304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<com.obric.common.oea.foundation.animation.c.a<?>> f32305e;
    private q<? super String, Object, Object, x> f;
    private m<? super Boolean, ? super Throwable, x> g;

    /* JADX INFO: compiled from: PropertyAnimatable.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f32306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f32307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<com.obric.common.oea.foundation.animation.c.a<?>> f32308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private q<? super String, Object, Object, x> f32309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private m<? super Boolean, ? super Throwable, x> f32310e;
        private final View f;

        public a(View r3) {
            o.e(r3, "view");
            this.f = r3;
            this.f32306a = 1.0f;
            this.f32307b = 60.0f;
            this.f32308c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public final View a() {
            return this.f;
        }

        public final a a(float r2, float r3) {
            if (r2 > 0) goto L5;
            com.obric.common.oea.foundation.animation.h.d.a("animationSpeed必须大于 0");
        L5:
            this.f32306a = r2;
            this.f32307b = r3;
            return this;
        }

        public static /* synthetic */ a a(a r7, com.obric.common.oea.foundation.animation.h.a.b r8, Integer r9, int r10, com.obric.common.oea.foundation.animation.g.a r11, Float r12, int r13, Object r14) {
            com.obric.common.oea.foundation.animation.g.a<Integer> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r13 & 16) == 0) goto L6;
            r12 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r7.a(r8, r9, r10, r5, r12);
        }

        public final a a(com.obric.common.oea.foundation.animation.h.a.b r8, Integer r9, int r10, com.obric.common.oea.foundation.animation.g.a<Integer> r11, Float r12) {
            com.obric.common.oea.foundation.animation.g.a<Integer> r4 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r8, "property");
            o.e(r4, "spec");
            return a(r8, r9, r10, r4, r12, false);
        }

        public static /* synthetic */ a b(a r7, com.obric.common.oea.foundation.animation.h.a.b r8, Integer r9, int r10, com.obric.common.oea.foundation.animation.g.a r11, Float r12, int r13, Object r14) {
            com.obric.common.oea.foundation.animation.g.a<Integer> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r13 & 16) == 0) goto L6;
            r12 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r7.b(r8, r9, r10, r5, r12);
        }

        public final a b(com.obric.common.oea.foundation.animation.h.a.b r8, Integer r9, int r10, com.obric.common.oea.foundation.animation.g.a<Integer> r11, Float r12) {
            com.obric.common.oea.foundation.animation.g.a<Integer> r4 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r8, "property");
            o.e(r4, "spec");
            return a(r8, r9, r10, r4, r12, true);
        }

        private final a a(com.obric.common.oea.foundation.animation.h.a.b r10, Integer r11, int r12, com.obric.common.oea.foundation.animation.g.a<Integer> r13, Float r14, boolean r15) {
            com.obric.common.oea.foundation.animation.g.a r7 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L27;
            int r16 = r11.intValue();
        L16:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.b.b.class) == false) goto L19;
            Objects.requireNonNull(r7, "null cannot be cast to non-null type com.obric.common.oea.foundation.animation.spec.tween.IntTweenSpec");
            ((com.obric.common.oea.foundation.animation.g.b.b) ZeusTransformUtils.preCheckCast(r7, com.obric.common.oea.foundation.animation.g.b.b.class, "com.obric.aiagent.plugin")).a(r15);
            com.obric.common.oea.foundation.animation.c.a<?> r17 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.b(r10.a(), Integer.valueOf(r16), Integer.valueOf(r12), aa.b(Integer.TYPE), r7, r14), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
        L21:
            this.f32308c.add(r17);
            return this;
        L19:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.a.d.class) == false) goto L24;
            r17 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.C0880a(r10.a(), Integer.valueOf(r16), Integer.valueOf(r12), aa.b(Integer.TYPE), r7, r14), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
            goto L21
        L24:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("不支持的 spec 类型: " + r7.getClass().getSimpleName()), Throwable.class, "com.obric.aiagent.plugin"));
        L27:
            n.a r18 = n.f38560a;     // Catch: Throwable -> L10
            Object r19 = defpackage.c.a(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f, r10.a());     // Catch: Throwable -> L10
            if (r19 == null) goto L9;
            Object r110 = n.f(Integer.valueOf(((Integer) ZeusTransformUtils.preCheckCast(r19, Integer.class, "com.obric.aiagent.plugin")).intValue()));     // Catch: Throwable -> L10
        L12:
            Throwable r111 = n.c(r110);
            if (r111 != null) goto L26;
            r16 = ((Number) ZeusTransformUtils.preCheckCast(r110, Number.class, "com.obric.aiagent.plugin")).intValue();
            goto L16
        L26:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("获取属性 " + r10.a() + " 的初始值时出错，请检查", r111), Throwable.class, "com.obric.aiagent.plugin"));
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            n.a r112 = n.f38560a;
            r110 = n.f(d.o.a(th));
            goto L12
        }

        public static /* synthetic */ a a(a r1, float r2, float r3, com.obric.common.oea.foundation.animation.g.a r4, Float r5, int r6, Object r7) {
            com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r6 & 8) == 0) goto L6;
            r5 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r1.a(r2, r3, r8, r5);
        }

        public final a a(float r7, float r8, com.obric.common.oea.foundation.animation.g.a<Float> r9, Float r10) {
            com.obric.common.oea.foundation.animation.g.a<Float> r11 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r11, "spec");
            a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32412a, null, r7, r11, r10);
            a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32413b, null, r8, r11, r10);
            return this;
        }

        public static /* synthetic */ a b(a r1, float r2, float r3, com.obric.common.oea.foundation.animation.g.a r4, Float r5, int r6, Object r7) {
            com.obric.common.oea.foundation.animation.g.a<Float> r8 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r6 & 8) == 0) goto L6;
            r5 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r1.b(r2, r3, r8, r5);
        }

        public final a b(float r7, float r8, com.obric.common.oea.foundation.animation.g.a<Float> r9, Float r10) {
            com.obric.common.oea.foundation.animation.g.a<Float> r11 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r9, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r11, "spec");
            a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32414c, null, r7, r11, r10);
            a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a.f32415d, null, r8, r11, r10);
            return this;
        }

        public static /* synthetic */ a a(a r1, float r2, com.obric.common.oea.foundation.animation.g.a r3, Float r4, int r5, Object r6) {
            com.obric.common.oea.foundation.animation.g.a<Float> r7 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L6;
            r4 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r1.a(r2, r7, r4);
        }

        public final a a(float r7, com.obric.common.oea.foundation.animation.g.a<Float> r8, Float r9) {
            com.obric.common.oea.foundation.animation.g.a<Float> r4 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r4, "spec");
            a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a.j, null, r7, r4, r9);
            return this;
        }

        public static /* synthetic */ a a(a r7, com.obric.common.oea.foundation.animation.h.a.EnumC0885a r8, Float r9, float r10, com.obric.common.oea.foundation.animation.g.a r11, Float r12, int r13, Object r14) {
            com.obric.common.oea.foundation.animation.g.a<Float> r5 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            if ((r13 & 16) == 0) goto L6;
            r12 = (Float) ZeusTransformUtils.preCheckCast(null, Float.class, "com.obric.aiagent.plugin");
        L6:
            return r7.a(r8, r9, r10, r5, r12);
        }

        public final a a(com.obric.common.oea.foundation.animation.h.a.EnumC0885a r10, Float r11, float r12, com.obric.common.oea.foundation.animation.g.a<Float> r13, Float r14) {
            com.obric.common.oea.foundation.animation.g.a r7 = (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin");
            o.e(r10, "property");
            o.e(r7, "spec");
            if (r11 == null) goto L27;
            float r15 = r11.floatValue();
        L16:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.b.a.class) == false) goto L19;
            com.obric.common.oea.foundation.animation.c.a<?> r16 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.b(r10.a(), Float.valueOf(r15), Float.valueOf(r12), aa.b(Float.TYPE), r7, r14), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
        L21:
            this.f32308c.add(r16);
            return this;
        L19:
            if (ZeusTransformUtils.instanceOf(r7, com.obric.common.oea.foundation.animation.g.a.b.class) == false) goto L24;
            r16 = (com.obric.common.oea.foundation.animation.c.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.c.a.C0880a(r10.a(), Float.valueOf(r15), Float.valueOf(r12), aa.b(Float.TYPE), r7, r14), com.obric.common.oea.foundation.animation.c.a.class, "com.obric.aiagent.plugin");
            goto L21
        L24:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("不支持的 spec 类型: " + r7.getClass().getSimpleName()), Throwable.class, "com.obric.aiagent.plugin"));
        L27:
            n.a r17 = n.f38560a;     // Catch: Throwable -> L10
            Object r18 = defpackage.c.a(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f, r10.a());     // Catch: Throwable -> L10
            if (r18 == null) goto L9;
            Object r19 = n.f(Float.valueOf(((Float) ZeusTransformUtils.preCheckCast(r18, Float.class, "com.obric.aiagent.plugin")).floatValue()));     // Catch: Throwable -> L10
        L12:
            Throwable r110 = n.c(r19);
            if (r110 != null) goto L26;
            r15 = ((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.aiagent.plugin")).floatValue();
            goto L16
        L26:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("获取属性 " + r10.a() + " 的初始值时出错，请检查", r110), Throwable.class, "com.obric.aiagent.plugin"));
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            n.a r111 = n.f38560a;
            r19 = n.f(d.o.a(th));
            goto L12
        }

        public final a a(q<? super String, Object, Object, x> r3) {
            q<? super String, Object, Object, x> r4 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
            o.e(r4, "callback");
            this.f32309d = r4;
            return this;
        }

        public final a a(m<? super Boolean, ? super Throwable, x> r3) {
            m<? super Boolean, ? super Throwable, x> r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
            o.e(r4, "callback");
            this.f32310e = r4;
            return this;
        }

        public final b b() {
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(this.f32308c, Collection.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            com.obric.common.oea.foundation.animation.h.d.a("必须先调用方法ofXXX方法指定添加动画");
        L12:
            return new b(this.f, this.f32306a, this.f32307b, this.f32308c, this.f32309d, this.f32310e, null);
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    private b(View r3, float r4, float r5, List<com.obric.common.oea.foundation.animation.c.a<?>> r6, q<? super String, Object, Object, x> r7, m<? super Boolean, ? super Throwable, x> r8) {
        List<com.obric.common.oea.foundation.animation.c.a<?>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        q<? super String, Object, Object, x> r10 = (q) ZeusTransformUtils.wrapperContextForParams(r7, q.class, "com.obric.aiagent.plugin");
        m<? super Boolean, ? super Throwable, x> r11 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.aiagent.plugin");
        this.f32302b = r3;
        this.f32303c = r4;
        this.f32304d = r5;
        this.f32305e = r9;
        this.f = r10;
        this.g = r11;
        this.f32301a = "PropertyAnimatable";
    }

    public /* synthetic */ b(View r9, float r10, float r11, List r12, q r13, m r14, h r15) {
        this(r9, r10, r11, (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin"), (q) ZeusTransformUtils.wrapperContextForParams(r13, q.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.wrapperContextForParams(r14, m.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.manager.d a(b r0, com.obric.common.oea.foundation.animation.d.b r1, com.obric.common.oea.foundation.animation.d.a r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = com.obric.common.oea.foundation.animation.d.b.f32344a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = com.obric.common.oea.foundation.animation.d.a.f32340a;
    L9:
        return r0.a(r1, r2);
    }

    public final com.obric.common.oea.foundation.animation.manager.d a(com.obric.common.oea.foundation.animation.d.b r2, com.obric.common.oea.foundation.animation.d.a r3) {
        o.e(r2, "mode");
        o.e(r3, "repeatMode");
        return b(r2, r3, false);
    }

    public final com.obric.common.oea.foundation.animation.manager.d a(com.obric.common.oea.foundation.animation.d.b r2, com.obric.common.oea.foundation.animation.d.a r3, boolean r4) {
        o.e(r2, "mode");
        o.e(r3, "repeatMode");
        return b(r2, r3, r4);
    }

    private final com.obric.common.oea.foundation.animation.manager.d b(com.obric.common.oea.foundation.animation.d.b r10, com.obric.common.oea.foundation.animation.d.a r11, boolean r12) {
        com.obric.common.oea.foundation.b.c.f32472a.b(this.f32301a, "执行start ");
        com.obric.common.oea.foundation.animation.a.a r0 = new com.obric.common.oea.foundation.animation.a.a(r10, r11, this.f32303c, this.f32304d, r12);
        com.obric.common.oea.foundation.animation.f.a r3 = com.obric.common.oea.foundation.animation.f.a.f32384a;
        View r5 = this.f32302b;
        List<com.obric.common.oea.foundation.animation.c.a<?>> r6 = this.f32305e;
        Objects.requireNonNull(r6, "null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
        return r3.a(r0, r5, r6, this.f, this.g);
    }
}
