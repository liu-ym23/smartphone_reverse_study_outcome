package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.animation.Animator;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import o12.b;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComboBottomAnimationView.c f128699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f128700b;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.a$a, reason: collision with other inner class name */
    public static final class C2061a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f128701a;

        public C2061a(a r100) {
            this.f128701a = r100;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            FrameLayout r101 = (FrameLayout) this.f128701a.f128699a.f128616a.a(R.id.combo_bottom_effect_container);
            if (r101 == null) goto L5;
            Integer r102 = Integer.valueOf(r101.indexOfChild(this.f128701a.f128700b));
        L7:
            if (r102.intValue() < 0) goto L12;
            FrameLayout r103 = (FrameLayout) this.f128701a.f128699a.f128616a.a(R.id.combo_bottom_effect_container);
            if (r103 == null) goto L13;
            r103.removeView(this.f128701a.f128700b);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r102 = null;
            goto L7
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100, r101);
            FrameLayout r102 = (FrameLayout) this.f128701a.f128699a.f128616a.a(R.id.combo_bottom_effect_container);
            if (r102 == null) goto L5;
            Integer r103 = Integer.valueOf(r102.indexOfChild(this.f128701a.f128700b));
        L7:
            if (r103.intValue() < 0) goto L12;
            FrameLayout r104 = (FrameLayout) this.f128701a.f128699a.f128616a.a(R.id.combo_bottom_effect_container);
            if (r104 == null) goto L13;
            r104.removeView(this.f128701a.f128700b);
            return;
        L13:
            return;
        L12:
            return;
        L5:
            r103 = null;
            goto L7
        }
    }

    public a(ComboBottomAnimationView.c r100, LottieAnimationView r101) {
        this.f128699a = r100;
        this.f128700b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f128700b.setAnimation("combo/ttlive_gift_combo_bottom_effect.json");     // Catch: Throwable -> L4
        this.f128700b.addAnimatorListener(new C2061a(this));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
