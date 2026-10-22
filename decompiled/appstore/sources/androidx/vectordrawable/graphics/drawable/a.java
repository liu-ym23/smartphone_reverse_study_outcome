package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Interpolator a(Context r10, int r11) {
        return AnimationUtils.loadInterpolator(r10, r11);
    }
}
