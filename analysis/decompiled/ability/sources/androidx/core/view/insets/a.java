package androidx.core.view.insets;

import android.animation.ValueAnimator;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1939a;
    public final /* synthetic */ Protection b;

    public /* synthetic */ a(Protection protection, int i) {
        this.f1939a = i;
        this.b = protection;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.f1939a;
        Protection protection = this.b;
        switch (i) {
            case 0:
                protection.lambda$animateInsetsAmount$1(valueAnimator);
                break;
            default:
                protection.lambda$animateAlpha$0(valueAnimator);
                break;
        }
    }
}
