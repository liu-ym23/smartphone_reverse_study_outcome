package stepos.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: stepos.support.v7.widget.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1991h extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6612a;
    public boolean b;
    public final /* synthetic */ ActionBarDropDownView c;

    public /* synthetic */ C1991h(ActionBarDropDownView actionBarDropDownView, int i) {
        this.f6612a = i;
        this.c = actionBarDropDownView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f6612a) {
            case 0:
                super.onAnimationCancel(animator);
                this.b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                this.b = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f6612a) {
            case 0:
                super.onAnimationEnd(animator);
                if (!this.b) {
                    this.c.b = 3;
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                if (!this.b) {
                    ActionBarDropDownView actionBarDropDownView = this.c;
                    actionBarDropDownView.b = 1;
                    actionBarDropDownView.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f6612a) {
            case 0:
                super.onAnimationStart(animator);
                ActionBarDropDownView actionBarDropDownView = this.c;
                actionBarDropDownView.b = 2;
                actionBarDropDownView.setVisibility(0);
                this.b = false;
                break;
            default:
                super.onAnimationStart(animator);
                this.c.b = 0;
                this.b = false;
                break;
        }
    }
}
