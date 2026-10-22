package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes17.dex */
class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    public static <T> ObjectAnimator ofPointF(T r100, Property<T, PointF> r101, Path r102) {
        return ObjectAnimator.ofObject(r100, r101, null, r102);
    }
}
