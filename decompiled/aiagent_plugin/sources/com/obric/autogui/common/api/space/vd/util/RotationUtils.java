package com.obric.autogui.common.api.space.vd.util;

import android.graphics.Insets;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public class RotationUtils {
    public static int deltaRotation(int r0, int r1) {
        int r2 = r1 - r0;
        if (r2 < 0) goto L5;
        return r2;
    L5:
        return r2 + 4;
    }

    public static int reverseRotationDirectionAroundZAxis(int r2) {
        if (r2 == 1) goto L8;
        if (r2 == 3) goto L7;
        return r2;
    L7:
        return 1;
    L8:
        return 3;
    }

    public RotationUtils() {
    }

    public static Insets rotateInsets(Insets r2, int r3) {
        if (r2 != null) goto L4;
        return r2;
    L4:
        if (r2 == Insets.NONE) goto L23;
        if (r3 != 0) goto L8;
        return r2;
    L8:
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L22;
        if (r3 != 3) goto L15;
        return Insets.of(r2.bottom, r2.left, r2.top, r2.right);
    L15:
        throw new IllegalArgumentException("unknown rotation: " + r3);
    L22:
        return Insets.of(r2.right, r2.bottom, r2.left, r2.top);
    L18:
        return Insets.of(r2.top, r2.right, r2.bottom, r2.left);
    L23:
        return r2;
    }

    public static void rotateBounds(Rect r0, Rect r1, int r2, int r3) {
        rotateBounds(r0, r1, deltaRotation(r2, r3));
    }

    public static void rotateBounds(Rect r3, int r4, int r5, int r6) {
        int r0 = r3.left;
        int r1 = r3.top;
        if (r6 != 1) goto L5;
        r3.left = r3.top;
        r3.top = r4 - r3.right;
        r3.right = r3.bottom;
        r3.bottom = r4 - r0;
        return;
    L5:
        if (r6 != 2) goto L7;
        r3.left = r4 - r3.right;
        r3.right = r4 - r0;
        r3.top = r5 - r3.bottom;
        r3.bottom = r5 - r1;
        return;
    L7:
        if (r6 != 3) goto L15;
        r3.left = r5 - r3.bottom;
        r3.bottom = r3.right;
        r3.right = r5 - r3.top;
        r3.top = r0;
        return;
    }

    public static void rotateBounds(Rect r1, Rect r2, int r3) {
        rotateBounds(r1, r2.right, r2.bottom, r3);
    }

    public static void rotatePoint(Point r2, int r3, int r4, int r5) {
        int r0 = r2.x;
        if (r3 != 1) goto L5;
        r2.x = r2.y;
        r2.y = r4 - r0;
        return;
    L5:
        if (r3 != 2) goto L7;
        r2.x = r4 - r2.x;
        r2.y = r5 - r2.y;
        return;
    L7:
        if (r3 != 3) goto L15;
        r2.x = r5 - r2.y;
        r2.y = r0;
        return;
    }

    public static void rotatePointF(PointF r2, int r3, float r4, float r5) {
        float r0 = r2.x;
        if (r3 != 1) goto L5;
        r2.x = r2.y;
        r2.y = r4 - r0;
        return;
    L5:
        if (r3 != 2) goto L7;
        r2.x = r4 - r2.x;
        r2.y = r5 - r2.y;
        return;
    L7:
        if (r3 != 3) goto L15;
        r2.x = r5 - r2.y;
        r2.y = r0;
        return;
    }

    public static void transformPhysicalToLogicalCoordinates(int r2, int r3, int r4, Matrix r5) {
        if (r2 != 0) goto L4;
        r5.reset();
        return;
    L4:
        if (r2 != 1) goto L6;
        r5.setRotate(270.0f);
        r5.postTranslate(0.0f, r3);
        return;
    L6:
        if (r2 != 2) goto L8;
        r5.setRotate(180.0f);
        r5.postTranslate(r3, r4);
        return;
    L8:
        if (r2 != 3) goto L11;
        r5.setRotate(90.0f);
        r5.postTranslate(r4, 0.0f);
        return;
    L11:
        throw new IllegalArgumentException("Unknown rotation: " + r2);
    }
}
