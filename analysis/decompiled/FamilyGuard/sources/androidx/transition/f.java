package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class f {

    static class a {
        static <T, V> ObjectAnimator a(T t5, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t5, property, (TypeConverter) null, path);
        }
    }

    static <T> ObjectAnimator a(T t5, Property<T, PointF> property, Path path) {
        return a.a(t5, property, path);
    }
}
