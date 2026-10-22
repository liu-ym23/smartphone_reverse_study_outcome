package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.parser.AnimatableSubmitter;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f11472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f11475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3 f11476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2 f11477g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f11478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f11480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function3 f11481d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function2 f11482e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f11483f;

        public a(View r10) {
            q.g(r10, "view");
            this.f11483f = r10;
            this.f11478a = 1.0f;
            this.f11479b = 60.0f;
            this.f11480c = new ArrayList();
        }

        public static /* synthetic */ a e(a r10, AnimationProperty$FloatProperty r11, Float r12, float r13, AnimationSpec r14, Float r15, int r16, Object r17) {
            if ((r16 & 16) == 0) goto L6;
            r15 = null;
        L6:
            return r10.d(r11, r12, r13, r14, r15);
        }

        public final a a(float r10, float r11) {
            if (r10 > 0) goto L5;
            mb.b.i("animationSpeed必须大于 0");
        L5:
            this.f11478a = r10;
            this.f11479b = r11;
            return this;
        }

        public final b b() {
            List r10 = this.f11480c;
            if (r10 != null) goto L5;
        L6:
            mb.b.i("必须先调用方法ofXXX方法指定添加动画");
        L8:
            return new b(this.f11483f, this.f11478a, this.f11479b, this.f11480c, this.f11481d, this.f11482e, null);
        L5:
            if (r10.isEmpty() == false) goto L8;
            goto L6
        }

        public final View c() {
            return this.f11483f;
        }

        public final a d(AnimationProperty$FloatProperty r10, Float r11, float r12, AnimationSpec r13, Float r14) {
            q.g(r10, "property");
            q.g(r13, "spec");
            if (r11 == null) goto L28;
            float r15 = r11.floatValue();
        L17:
            if ((r13 instanceof lb.a) == false) goto L20;
            Object r16 = new ib.a.b(r10.getPropertyName(), Float.valueOf(r15), Float.valueOf(r12), u.b(Float.TYPE), r13, r14);
        L22:
            this.f11480c.add(r16);
            return this;
        L20:
            if ((r13 instanceof com.obric.common.oea.foundation.animation.spec.spring.b) == false) goto L25;
            r16 = new ib.a.C0270a(r10.getPropertyName(), Float.valueOf(r15), Float.valueOf(r12), u.b(Float.TYPE), r13, r14);
            goto L22
        L25:
            throw new IllegalStateException("不支持的 spec 类型: " + r13.getClass().getSimpleName());
        L28:
            Result.a r17 = Result.Companion;     // Catch: Throwable -> L8
            Object r18 = defpackage.d.c(this.f11483f, r10.getPropertyName());     // Catch: Throwable -> L8
            if (r18 == null) goto L11;
            Object r19 = Result.m35constructorimpl((Float) r18);     // Catch: Throwable -> L8
        L13:
            Throwable r20 = Result.m38exceptionOrNullimpl(r19);
            if (r20 != null) goto L27;
            r15 = ((Number) r19).floatValue();
            goto L17
        L27:
            throw new IllegalArgumentException("获取属性 " + r10.getPropertyName() + " 的初始值时出错，请检查", r20);
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            Result.a r21 = Result.Companion;
            r19 = Result.m35constructorimpl(kotlin.c.a(th));
            goto L13
        }

        public final a f(Function2 r10) {
            q.g(r10, "callback");
            this.f11482e = r10;
            return this;
        }

        public final a g(Function3 r10) {
            q.g(r10, "callback");
            this.f11481d = r10;
            return this;
        }
    }

    public b(View r10, float r11, float r12, List r13, Function3 r14, Function2 r15) {
        this.f11472b = r10;
        this.f11473c = r11;
        this.f11474d = r12;
        this.f11475e = r13;
        this.f11476f = r14;
        this.f11477g = r15;
        this.f11471a = "PropertyAnimatable";
    }

    public static /* synthetic */ jb.d b(b r10, RunMode r11, RepeatMode r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = RunMode.PARALLEL;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = RepeatMode.NORMAL;
    L9:
        return r10.a(r11, r12);
    }

    public final jb.d a(RunMode r10, RepeatMode r11) {
        q.g(r10, "mode");
        q.g(r11, "repeatMode");
        return c(r10, r11, false);
    }

    public final jb.d c(RunMode r10, RepeatMode r11, boolean r12) {
        qb.b.f23627c.a(this.f11471a, "执行start ");
        com.obric.common.oea.foundation.animation.builder.a r13 = new com.obric.common.oea.foundation.animation.builder.a(r10, r11, this.f11473c, this.f11474d, r12);
        AnimatableSubmitter r14 = AnimatableSubmitter.f11547a;
        View r15 = this.f11472b;
        List r16 = this.f11475e;
        if (r16 == null) goto L7;
        return r14.c(r13, r15, r16, this.f11476f, this.f11477g);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
    }

    public /* synthetic */ b(View r10, float r11, float r12, List r13, Function3 r14, Function2 r15, DefaultConstructorMarker r16) {
        this(r10, r11, r12, r13, r14, r15);
    }
}
