package stepos.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12746a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12747b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActionBarDropDownView f12748c;

    public /* synthetic */ f(ActionBarDropDownView actionBarDropDownView, int i) {
        this.f12746a = i;
        this.f12748c = actionBarDropDownView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f12746a) {
            case 0:
                super.onAnimationCancel(animator);
                this.f12747b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                this.f12747b = true;
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f12746a) {
            case 0:
                super.onAnimationEnd(animator);
                if (!this.f12747b) {
                    this.f12748c.f12578f = 3;
                    break;
                }
                break;
            default:
                super.onAnimationEnd(animator);
                if (!this.f12747b) {
                    ActionBarDropDownView actionBarDropDownView = this.f12748c;
                    actionBarDropDownView.f12578f = 1;
                    actionBarDropDownView.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f12746a) {
            case 0:
                super.onAnimationStart(animator);
                ActionBarDropDownView actionBarDropDownView = this.f12748c;
                actionBarDropDownView.f12578f = 2;
                actionBarDropDownView.setVisibility(0);
                this.f12747b = false;
                break;
            default:
                super.onAnimationStart(animator);
                this.f12748c.f12578f = 0;
                this.f12747b = false;
                break;
        }
    }
}
