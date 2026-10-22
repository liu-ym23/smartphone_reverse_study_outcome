package E6;

import S7.k;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import g1.AbstractC1451a;

/* loaded from: classes3.dex */
public final class c {
    public static final float a(float f, float f7) {
        if (f7 <= 0.0f) {
            return 0.0f;
        }
        float fT = AbstractC1451a.t(f / f7, 0.0f, 1.0f);
        return androidx.compose.foundation.b.a(fT, 2.0f, 3.0f, fT * fT);
    }

    public static final SpringAnimation b(FloatValueHolder floatValueHolder, float f, float f7, k kVar) {
        SpringAnimation springAnimation = new SpringAnimation(floatValueHolder);
        springAnimation.setSpring(new SpringForce(0.0f).setStiffness(f).setDampingRatio(0.5f));
        springAnimation.setMinimumVisibleChange(f7);
        springAnimation.addUpdateListener(new b(kVar, 0));
        return springAnimation;
    }
}
