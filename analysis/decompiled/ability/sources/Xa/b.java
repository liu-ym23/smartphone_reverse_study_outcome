package Xa;

import android.view.ViewGroup;
import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes4.dex */
public final class b implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f1540a;
    public final /* synthetic */ e b;

    public b(e eVar, boolean z10) {
        this.b = eVar;
        this.f1540a = z10;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f7) {
        e eVar = this.b;
        ViewGroup viewGroup = eVar.b;
        eVar.d(viewGroup.getTranslationX(), viewGroup.getTranslationY());
        eVar.f1544B = this.f1540a ? viewGroup.getTranslationY() : viewGroup.getTranslationX();
    }
}
