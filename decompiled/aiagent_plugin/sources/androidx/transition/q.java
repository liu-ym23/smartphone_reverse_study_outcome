package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: compiled from: PropertyValuesHolderUtils.java */
/* JADX INFO: loaded from: classes.dex */
class q {
    static PropertyValuesHolder a(Property<?, PointF> r2, Path r3) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return PropertyValuesHolder.ofObject(r2, null, r3);
    L7:
        return PropertyValuesHolder.ofFloat(new PathProperty(r2, r3), new float[]{0.0f, 1.0f});
    }
}
