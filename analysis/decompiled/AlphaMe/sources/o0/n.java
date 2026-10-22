package o0;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class n {
    @DoNotInline
    public static <T, V> ObjectAnimator a(T t4, Property<T, V> property, Path path) {
        return ObjectAnimator.ofObject(t4, property, (TypeConverter) null, path);
    }
}
