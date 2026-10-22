package stepos.support.v7.app;

import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;

/* loaded from: classes4.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public static I f6219a;

    public static I a() {
        if (f6219a == null) {
            I i = new I();
            new SpringAnimation(new FloatValueHolder()).addUpdateListener(new G(i));
            new SpringAnimation(new FloatValueHolder()).addUpdateListener(new H(i));
            f6219a = i;
        }
        return f6219a;
    }
}
