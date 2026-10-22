package com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements q02.a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.a$a, reason: collision with other inner class name */
    public static final class C2072a {
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q02.d f129764a;

        public b(q02.d r100) {
            this.f129764a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f129764a;
            if (r101 == null) goto L6;
            r101.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f129764a;
            if (r101 == null) goto L6;
            r101.e();
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q02.d f129765a;

        public c(q02.d r100) {
            this.f129765a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f129765a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f129765a;
            if (r101 == null) goto L6;
            r101.d();
            return;
        }
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q02.d f129766a;

        public d(q02.d r100) {
            this.f129766a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            q02.d r101 = this.f129766a;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    static {
    }

    public a() {
    }

    @Override // q02.a
    public final Animator b(View r100, q02.d r101) {
        if (r100 == null) goto L4;
        float r102 = r100.getAlpha();
    L5:
        int r103 = ObjectAnimatorCompat.f129752l;
        ObjectAnimatorCompat r104 = ObjectAnimatorCompat.a.a(r100, "alpha", r102, 1.0f);
        r104.f129758f = 200;
        r104.addListener(new c(r101));
        return r104;
    L4:
        r102 = 0.0f;
        goto L5
    }

    @Override // q02.a
    public final Animator c(View r100, q02.d r101) {
        int r102 = ObjectAnimatorCompat.f129752l;
        ObjectAnimatorCompat r103 = ObjectAnimatorCompat.a.a(r100, "alpha", 1.0f, 0.0f);
        r103.f129758f = 200;
        r103.addListener(new d(r101));
        return r103;
    }

    @Override // q02.a
    public final Animator d(View r100, q02.d r101) {
        int r102 = ObjectAnimatorCompat.f129752l;
        ObjectAnimatorCompat r103 = ObjectAnimatorCompat.a.a(r100, LiveDegradeFpsAnimator.SCALE_Y, 1.35f, 1.0f);
        r103.f129758f = 200;
        r103.f129759g = new PathInterpolator(0.29f, 0.22f, 0.21f, 1.5f);
        r103.addListener(new b(r101));
        return r103;
    }

    @Override // q02.a
    public final void a(View r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setX(0.0f);
        r100.setY(r102);
        r100.setAlpha(0.0f);
    }
}
