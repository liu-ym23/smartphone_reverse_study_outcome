package com.zyql.ai.selector.animators;

import android.view.View;
import androidx.core.view.N;

/* loaded from: classes4.dex */
public final class ViewHelper {
    public static void clear(View view) {
        view.setAlpha(1.0f);
        view.setScaleY(1.0f);
        view.setScaleX(1.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setPivotY(view.getMeasuredHeight() / 2);
        view.setPivotX(view.getMeasuredWidth() / 2);
        N.d(view).g(null).j(0L);
    }
}
