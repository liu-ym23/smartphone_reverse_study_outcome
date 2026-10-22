package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.parser.AnimatableSubmitter;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ib.a f11487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3 f11488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2 f11489f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f11490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ib.a f11492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function3 f11493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Function2 f11494e;

        public a() {
            this.f11490a = 1.0f;
            this.f11491b = 60.0f;
        }

        public static final /* synthetic */ ib.a a(a r10) {
            ib.a r11 = r10.f11492c;
            if (r11 != null) goto L5;
            q.y("valueAnimationCommand");
        L5:
            return r11;
        }

        public static final /* synthetic */ void b(a r10, ib.a r11) {
            r10.f11492c = r11;
        }

        public static /* synthetic */ a e(a r10, float r11, float r12, AnimationSpec r13, Float r14, int r15, Object r16) {
            if ((r15 & 8) == 0) goto L6;
            r14 = null;
        L6:
            return r10.d(r11, r12, r13, r14);
        }

        public final d c() {
            if (this.f11492c != null) goto L5;
            mb.b.i("必须先调用方法ofXXX方法指定动画初始和目标值");
        L5:
            float r10 = this.f11490a;
            float r11 = this.f11491b;
            ib.a r12 = this.f11492c;
            if (r12 != null) goto L9;
            q.y("valueAnimationCommand");
        L9:
            return new d(r10, r11, r12, this.f11493d, this.f11494e, null);
        }

        public final a d(float r10, float r11, AnimationSpec r12, Float r13) {
            q.g(r12, "spec");
            if ((r12 instanceof lb.a) == false) goto L6;
            ib.a r14 = new ib.a.b("valueAnimationPlaceholder", Float.valueOf(r10), Float.valueOf(r11), u.b(Float.TYPE), r12, r13);
        L8:
            this.f11492c = r14;
            return this;
        L6:
            if ((r12 instanceof com.obric.common.oea.foundation.animation.spec.spring.b) == false) goto L11;
            r14 = new ib.a.C0270a("valueAnimationPlaceholder", Float.valueOf(r10), Float.valueOf(r11), u.b(Float.TYPE), r12, r13);
            goto L8
        L11:
            throw new IllegalStateException("不支持的 spec 类型: " + r12.getClass().getSimpleName());
        }

        public final a f(Function2 r10) {
            q.g(r10, "callback");
            this.f11494e = r10;
            return this;
        }

        public final a g(Function3 r10) {
            q.g(r10, "callback");
            this.f11493d = r10;
            return this;
        }
    }

    public d(float r10, float r11, ib.a r12, Function3 r13, Function2 r14) {
        this.f11485b = r10;
        this.f11486c = r11;
        this.f11487d = r12;
        this.f11488e = r13;
        this.f11489f = r14;
        this.f11484a = "ValueAnimatable";
    }

    public final jb.d a() {
        return b(RunMode.PARALLEL, RepeatMode.NORMAL, false);
    }

    public final jb.d b(RunMode r10, RepeatMode r11, boolean r12) {
        qb.b.f23627c.a(this.f11484a, "执行start ");
        com.obric.common.oea.foundation.animation.builder.a r13 = new com.obric.common.oea.foundation.animation.builder.a(r10, r11, this.f11485b, this.f11486c, r12);
        AnimatableSubmitter r14 = AnimatableSubmitter.f11547a;
        ArrayList r15 = new ArrayList();
        r15.add(this.f11487d);
        Unit r16 = Unit.f21064a;
        return r14.c(r13, null, r15, this.f11488e, this.f11489f);
    }

    public /* synthetic */ d(float r10, float r11, ib.a r12, Function3 r13, Function2 r14, DefaultConstructorMarker r15) {
        this(r10, r11, r12, r13, r14);
    }
}
