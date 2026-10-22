package Xa;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes4.dex */
public final class c implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1541a;

    public c(e eVar) {
        this.f1541a = eVar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f, float f7) {
        e eVar = this.f1541a;
        eVar.f1552v = 0.0f;
        if (z10) {
            return;
        }
        eVar.u = 0;
        eVar.e();
    }
}
