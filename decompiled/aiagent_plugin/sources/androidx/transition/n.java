package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: compiled from: ObjectAnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
class n {
    static <T> ObjectAnimator a(T r2, Property<T, PointF> r3, Path r4) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return ObjectAnimator.ofObject(r2, r3, null, r4);
    L7:
        return ObjectAnimator.ofFloat(r2, new PathProperty(r3, r4), new float[]{0.0f, 1.0f});
    }
}
