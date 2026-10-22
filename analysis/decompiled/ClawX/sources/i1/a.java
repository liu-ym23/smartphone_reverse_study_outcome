package i1;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import t1.h;
import t1.j;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3127a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3128b;

    public /* synthetic */ a(int i8, Object obj) {
        this.f3127a = i8;
        this.f3128b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3127a) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                j jVar = ((BottomSheetBehavior) this.f3128b).f1245i;
                if (jVar != null) {
                    h hVar = jVar.f5475b;
                    if (hVar.f5465j != fFloatValue) {
                        hVar.f5465j = fFloatValue;
                        jVar.f5478f = true;
                        jVar.f5479g = true;
                        jVar.invalidateSelf();
                        break;
                    }
                }
                break;
            case 1:
                int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                v0.j jVar2 = (v0.j) this.f3128b;
                jVar2.f5839b.setAlpha(iFloatValue);
                jVar2.f5840c.setAlpha(iFloatValue);
                jVar2.f5850n.invalidate();
                break;
            default:
                ((TextInputLayout) this.f3128b).f1396x0.m(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
