package com.android.internal.chooser.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ViewCompat {
    public static final int SCROLL_AXIS_HORIZONTAL = 1;
    public static final int SCROLL_AXIS_NONE = 0;
    public static final int SCROLL_AXIS_VERTICAL = 2;
    public static final int TYPE_NON_TOUCH = 1;
    public static final int TYPE_TOUCH = 0;
    private static WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NestedScrollType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollAxis {
    }

    public static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }

    public static boolean startNestedScroll(View view, int axes) {
        return view.startNestedScroll(axes);
    }

    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void postOnAnimationDelayed(View view, Runnable action, long delayMillis) {
        view.postOnAnimationDelayed(action, delayMillis);
    }

    public static void setAlpha(View view, float value) {
        view.setAlpha(value);
    }

    public static float getAlpha(View view) {
        return view.getAlpha();
    }

    public static void setScaleX(View view, float value) {
        view.setScaleX(value);
    }

    public static void setScaleY(View view, float value) {
        view.setScaleY(value);
    }

    public static void setTranslationY(View view, float value) {
        view.setTranslationY(value);
    }

    public static void setTranslationX(View view, float value) {
        view.setTranslationX(value);
    }

    public static ViewPropertyAnimatorCompat animate(View view) {
        if (mViewPropertyAnimatorCompatMap == null) {
            mViewPropertyAnimatorCompatMap = new WeakHashMap<>();
        }
        ViewPropertyAnimatorCompat vpa = mViewPropertyAnimatorCompatMap.get(view);
        if (vpa == null) {
            ViewPropertyAnimatorCompat vpa2 = new ViewPropertyAnimatorCompat(view);
            mViewPropertyAnimatorCompatMap.put(view, vpa2);
            return vpa2;
        }
        return vpa;
    }

    public static float getTranslationX(View view) {
        return view.getTranslationX();
    }

    public static float getTranslationY(View view) {
        return view.getTranslationY();
    }

    public static void setTranslationZ(View view, float translationZ) {
        view.setTranslationZ(translationZ);
    }

    public static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    public static void setZ(View view, float z) {
        view.setZ(z);
    }

    public static float getZ(View view) {
        return view.getZ();
    }
}
