package E6;

import S7.k;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.stepos.common.widget.numberwheel.NumberWheelView;
import g1.AbstractC1451a;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f478a;
    public final /* synthetic */ Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f478a = i;
        this.b = obj;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f7) {
        int i = this.f478a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((k) obj).invoke(Float.valueOf(f));
                break;
            case 1:
                G6.b bVar = (G6.b) obj;
                float fT = AbstractC1451a.t(f, 0.0f, 2.0f);
                bVar.f678a = fT;
                bVar.f.setValue(fT);
                break;
            default:
                NumberWheelView numberWheelView = (NumberWheelView) obj;
                numberWheelView.d = f;
                numberWheelView.invalidate();
                if (numberWheelView.k != 0) {
                    numberWheelView.requestLayout();
                    break;
                }
                break;
        }
    }
}
