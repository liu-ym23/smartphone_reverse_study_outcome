package com.stepos.launcher.assistant.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.android.internal.graphics.drawable.BackgroundBlurDrawable;

/* loaded from: classes.dex */
public class BlurDrawableUtils {
    public static BackgroundBlurDrawable createBackgroundBlurDrawable(View view, int i10, int i11, float f10, int i12) {
        if (view == null) {
            return null;
        }
        BackgroundBlurDrawable backgroundBlurDrawableCreateBackgroundBlurDrawable = view.getViewRootImpl().createBackgroundBlurDrawable();
        backgroundBlurDrawableCreateBackgroundBlurDrawable.setBlurRadius(i10);
        backgroundBlurDrawableCreateBackgroundBlurDrawable.setAlpha(i11);
        backgroundBlurDrawableCreateBackgroundBlurDrawable.setCornerRadius(f10, f10, f10, f10);
        backgroundBlurDrawableCreateBackgroundBlurDrawable.setColor(i12);
        return backgroundBlurDrawableCreateBackgroundBlurDrawable;
    }

    public static void releaseBackgroundBlurDrawable(Drawable drawable) {
        if (drawable instanceof BackgroundBlurDrawable) {
            drawable.setCallback(null);
            drawable.setVisible(false, false);
        }
    }
}
