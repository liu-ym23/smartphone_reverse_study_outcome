package c69;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.dora.impl.onboarding.g.DoraGOnboardingShimmerTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraGOnboardingShimmerTextView f22602a;

    public d(DoraGOnboardingShimmerTextView r100) {
        this.f22602a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        DoraGOnboardingShimmerTextView r101 = this.f22602a;
        r101.f336635b = null;
        r101.f336642i.invoke();
    }
}
