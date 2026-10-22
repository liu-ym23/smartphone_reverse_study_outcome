package com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q02.d;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements q02.a {

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f129767a;

        public a(d r100) {
            this.f129767a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f129767a;
            if (r101 == null) goto L6;
            r101.c();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f129767a;
            if (r101 == null) goto L6;
            r101.e();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.normal.anim.compat.b$b, reason: collision with other inner class name */
    public static final class C2073b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f129768a;

        public C2073b(d r100) {
            this.f129768a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f129768a;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f129768a;
            if (r101 == null) goto L6;
            r101.d();
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f129769a;

        public c(d r100) {
            this.f129769a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d r101 = this.f129769a;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public b() {
    }

    @Override // q02.a
    public final Animator b(View r100, d r101) {
        if (r100 == null) goto L5;
        float r102 = r100.getX();
    L6:
        int r103 = ObjectAnimatorCompat.f129752l;
        ObjectAnimatorCompat r104 = ObjectAnimatorCompat.a.a(r100, LiveDegradeFpsAnimator.TRANSLATION_X, r102, 0.0f);
        r104.f129758f = 250;
        r104.f129759g = new PathInterpolator(0.32f, 0.94f, 0.6f, 1.0f);
        r104.addListener(new C2073b(r101));
        return r104;
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // q02.a
    public final Animator c(View r100, d r101) {
        int r102 = ObjectAnimatorCompat.f129752l;
        ObjectAnimatorCompat r103 = ObjectAnimatorCompat.a.a(r100, "alpha", 1.0f, 0.0f);
        r103.f129758f = 250;
        r103.addListener(new c(r101));
        return r103;
    }

    @Override // q02.a
    public final Animator d(View r100, d r101) {
        int r102 = ObjectAnimatorCompat.f129752l;
        List r103 = CollectionsKt.listOf(new String[]{LiveDegradeFpsAnimator.SCALE_X, LiveDegradeFpsAnimator.SCALE_Y});
        Intrinsics.checkNotNullParameter(r103, "methods");
        ObjectAnimatorCompat r104 = new ObjectAnimatorCompat();
        r104.setTarget(r100);
        ArrayList r105 = (ArrayList) r104.f129754b;
        r105.addAll(r103);
        r104.f129756d = 1.35f;
        r104.f129757e = 1.0f;
        r104.f129758f = 200;
        r104.addListener(new a(r101));
        return r104;
    }

    @Override // q02.a
    public final void a(View r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setX(r101);
        r100.setY(r102);
    }
}
