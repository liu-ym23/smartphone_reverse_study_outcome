package com.obric.oui.panel.anim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class AnimController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimProcessType f15823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimProcessType f15824b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "", "(Ljava/lang/String;I)V", "NONE", "DOING", "DONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        private static final /* synthetic */ AnimProcessType[] $VALUES = null;
        public static final AnimProcessType DOING = null;
        public static final AnimProcessType DONE = null;
        public static final AnimProcessType NONE = null;

        private static final /* synthetic */ AnimProcessType[] $values() {
            return new AnimProcessType[]{NONE, DOING, DONE};
        }

        static {
            NONE = new AnimProcessType("NONE", 0);
            DOING = new AnimProcessType("DOING", 1);
            DONE = new AnimProcessType("DONE", 2);
            $VALUES = $values();
        }

        private AnimProcessType(String r10, int r11) {
            super(r10, r11);
        }

        public static AnimProcessType valueOf(String r10) {
            return (AnimProcessType) Enum.valueOf(AnimProcessType.class, r10);
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) $VALUES.clone();
        }
    }

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimController f15825a;

        public a(AnimController r10) {
            this.f15825a = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            this.f15825a.i(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            this.f15825a.i(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            q.g(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            q.g(r10, "animation");
            this.f15825a.i(AnimProcessType.DOING);
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimController f15826a;

        public b(AnimController r10) {
            this.f15826a = r10;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            this.f15826a.j(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            this.f15826a.j(AnimProcessType.DONE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            q.g(r10, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            q.g(r10, "animation");
            this.f15826a.j(AnimProcessType.DOING);
        }
    }

    public AnimController() {
        AnimProcessType r10 = AnimProcessType.NONE;
        this.f15823a = r10;
        this.f15824b = r10;
    }

    public static /* synthetic */ void a(Function1 r10, ValueAnimator r11) {
        h(r10, r11);
    }

    public static /* synthetic */ void b(Function1 r10, ValueAnimator r11) {
        f(r10, r11);
    }

    public static final void f(Function1 r10, ValueAnimator r11) {
        q.g(r10, "$animProgressListener");
        q.g(r11, "animation");
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L5
        r10.invoke(Float.valueOf(r11.getAnimatedFraction()));     // Catch: Throwable -> L5
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.a r13 = Result.Companion;
        Result.m35constructorimpl(c.a(th));
    }

    public static final void h(Function1 r10, ValueAnimator r11) {
        q.g(r10, "$animProgressListener");
        q.g(r11, "animation");
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L5
        Result.m35constructorimpl((Unit) r10.invoke(Float.valueOf(r11.getAnimatedFraction())));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.a r13 = Result.Companion;
        Result.m35constructorimpl(c.a(th));
    }

    public final void c(ObjectAnimator r10, Function1 r11) {
        q.g(r11, "animProgressListener");
        if (this.f15823a == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        e(r10, r11).start();
    }

    public final void d(ObjectAnimator r10, Function1 r11) {
        q.g(r11, "animProgressListener");
        if (this.f15824b == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        g(r10, r11).start();
    }

    public final ObjectAnimator e(ObjectAnimator r10, final Function1 r11) {
        r10.addListener(new a(this));
        r10.addUpdateListener(new id.b(r11));
        return r10;
    }

    public final ObjectAnimator g(ObjectAnimator r10, final Function1 r11) {
        r10.addListener(new b(this));
        r10.addUpdateListener(new id.a(r11));
        return r10;
    }

    public final void i(AnimProcessType r10) {
        q.g(r10, "<set-?>");
        this.f15823a = r10;
    }

    public final void j(AnimProcessType r10) {
        q.g(r10, "<set-?>");
        this.f15824b = r10;
    }
}
