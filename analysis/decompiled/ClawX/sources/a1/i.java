package a1;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.util.Property;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class i {
    public static <T, V> ObjectAnimator a(T t8, Property<T, V> property, Path path) {
        return ObjectAnimator.ofObject(t8, property, (TypeConverter) null, path);
    }
}
