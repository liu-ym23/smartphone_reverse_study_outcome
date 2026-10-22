package stepos.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: stepos.support.v7.widget.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0886f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15081a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15082b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActionBarDropDownView f15083c;

    public /* synthetic */ C0886f(ActionBarDropDownView actionBarDropDownView, int i4) {
        this.f15081a = i4;
        this.f15083c = actionBarDropDownView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f15081a) {
            case 0:
                super.onAnimationCancel(animator);
                this.f15082b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                this.f15082b = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f15081a;
        ActionBarDropDownView actionBarDropDownView = this.f15083c;
        switch (i4) {
            case 0:
                super.onAnimationEnd(animator);
                if (!this.f15082b) {
                    actionBarDropDownView.f14748b = 3;
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                if (!this.f15082b) {
                    actionBarDropDownView.f14748b = 1;
                    actionBarDropDownView.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i4 = this.f15081a;
        ActionBarDropDownView actionBarDropDownView = this.f15083c;
        switch (i4) {
            case 0:
                super.onAnimationStart(animator);
                actionBarDropDownView.f14748b = 2;
                actionBarDropDownView.setVisibility(0);
                this.f15082b = false;
                break;
            default:
                super.onAnimationStart(animator);
                actionBarDropDownView.f14748b = 0;
                this.f15082b = false;
                break;
        }
    }
}
