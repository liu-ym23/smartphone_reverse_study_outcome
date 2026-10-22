package com.android.server.wm;

import android.graphics.Point;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatLetterboxUtils {
    AppCompatLetterboxUtils() {
    }

    static void calculateLetterboxPosition(ActivityRecord activity, Point outLetterboxPosition) {
        if (activity.mAppCompatController.getLetterboxPolicy().isRunning() == true) goto L6;
        outLetterboxPosition.set(0, 0);
        return;
    L6:
        activity.getPosition(outLetterboxPosition);
    }

    static void calculateLetterboxOuterBounds(ActivityRecord activity, Rect outOuterBounds) {
        if (activity.mAppCompatController.getLetterboxPolicy().isRunning() == true) goto L6;
        outOuterBounds.setEmpty();
        return;
    L6:
        Rect transformedBounds = activity.getFixedRotationTransformDisplayBounds();
        if (transformedBounds == null) goto L10;
        Rect r1 = transformedBounds;
    L13:
        outOuterBounds.set(r1);
        return;
    L10:
        if (activity.inMultiWindowMode() == false) goto L12;
        r1 = activity.getTaskFragment().getBounds();
        goto L13
    L12:
        r1 = activity.getRootTask().getParent().getBounds();
        goto L13
    }

    static void calculateLetterboxInnerBounds(ActivityRecord activity, WindowState window, Rect outInnerBounds) {
        if (activity.mAppCompatController.getLetterboxPolicy().isRunning() == true) goto L6;
        outInnerBounds.setEmpty();
        return;
    L6:
        TransparentPolicy transparentPolicy = activity.mAppCompatController.getTransparentPolicy();
        if (transparentPolicy.isRunning() == false) goto L9;
        Rect r1 = activity.getBounds();
    L10:
        outInnerBounds.set(r1);
        return;
    L9:
        r1 = window.getFrame();
        goto L10
    }
}
