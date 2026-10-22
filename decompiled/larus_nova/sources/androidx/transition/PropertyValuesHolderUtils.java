package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes17.dex */
class PropertyValuesHolderUtils {
    private PropertyValuesHolderUtils() {
    }

    public static PropertyValuesHolder ofPointF(Property<?, PointF> r100, Path r101) {
        return PropertyValuesHolder.ofObject(r100, null, r101);
    }
}
