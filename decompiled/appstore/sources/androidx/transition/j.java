package androidx.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static ObjectAnimator a(Object r10, Property r11, Path r12) {
        return ObjectAnimator.ofObject(r10, r11, null, r12);
    }
}
