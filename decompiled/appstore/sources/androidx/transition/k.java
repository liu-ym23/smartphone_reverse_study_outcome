package androidx.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static PropertyValuesHolder a(Property r10, Path r11) {
        return PropertyValuesHolder.ofObject(r10, null, r11);
    }
}
