package G6;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.stepos.common.widget.numberwheel.NumberWheelView;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f677a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f677a = i;
        this.b = obj;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z10, float f, float f7) {
        int i = this.f677a;
        Object obj = this.b;
        switch (i) {
            case 0:
                b bVar = (b) obj;
                if (!z10) {
                    float f9 = bVar.c;
                    bVar.f678a = f9;
                    bVar.f.setValue(f9);
                    bVar.b = bVar.c;
                    if (bVar.d != 0) {
                        bVar.d = 0;
                        break;
                    }
                }
                break;
            default:
                NumberWheelView numberWheelView = (NumberWheelView) obj;
                if (numberWheelView.k != 1) {
                    numberWheelView.d = 0.0f;
                    break;
                } else {
                    numberWheelView.k = 2;
                    break;
                }
        }
    }
}
