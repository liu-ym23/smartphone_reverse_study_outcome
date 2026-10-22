package com.android.server.wm.utils;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public class InsetUtils {
    private InsetUtils() {
    }

    public static void rotateInsets(Rect inOutInsets, int rotationDelta) {
        switch(rotationDelta) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        inOutInsets.set(inOutInsets.bottom, inOutInsets.left, inOutInsets.top, inOutInsets.right);
        return;
    L7:
        inOutInsets.set(inOutInsets.right, inOutInsets.bottom, inOutInsets.left, inOutInsets.top);
        return;
    L8:
        inOutInsets.set(inOutInsets.top, inOutInsets.right, inOutInsets.bottom, inOutInsets.left);
        return;
    L10:
        return;
    L5:
        throw new IllegalArgumentException("Unknown rotation: " + rotationDelta);
    }

    public static void addInsets(Rect inOutInsets, Rect insetsToAdd) {
        inOutInsets.left += insetsToAdd.left;
        inOutInsets.top += insetsToAdd.top;
        inOutInsets.right += insetsToAdd.right;
        inOutInsets.bottom += insetsToAdd.bottom;
    }

    public static void insetsBetweenFrames(Rect outerFrame, Rect innerFrame, Rect outInsets) {
        if (innerFrame != null) goto L5;
        outInsets.setEmpty();
        return;
    L5:
        int w = outerFrame.width();
        int h = outerFrame.height();
        outInsets.set(Math.min(w, Math.max(0, innerFrame.left - outerFrame.left)), Math.min(h, Math.max(0, innerFrame.top - outerFrame.top)), Math.min(w, Math.max(0, outerFrame.right - innerFrame.right)), Math.min(h, Math.max(0, outerFrame.bottom - innerFrame.bottom)));
    }
}
