package d2;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {
    public static <T, V> ObjectAnimator a(T t8, Property<T, V> property, Path path) {
        return ObjectAnimator.ofObject(t8, property, (TypeConverter) null, path);
    }
}
