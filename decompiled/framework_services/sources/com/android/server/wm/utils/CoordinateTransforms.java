package com.android.server.wm.utils;

import android.graphics.Matrix;
import android.view.DisplayInfo;

/* JADX INFO: loaded from: classes3.dex */
public class CoordinateTransforms {
    private CoordinateTransforms() {
    }

    public static void transformPhysicalToLogicalCoordinates(int rotation, int physicalWidth, int physicalHeight, Matrix out) {
        switch(rotation) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        out.setRotate(90.0f);
        out.postTranslate(physicalHeight, 0.0f);
        return;
    L7:
        out.setRotate(180.0f);
        out.postTranslate(physicalWidth, physicalHeight);
        return;
    L8:
        out.setRotate(270.0f);
        out.postTranslate(0.0f, physicalWidth);
        return;
    L9:
        out.reset();
        return;
    L5:
        throw new IllegalArgumentException("Unknown rotation: " + rotation);
    }

    public static void transformLogicalToPhysicalCoordinates(int rotation, int physicalWidth, int physicalHeight, Matrix out) {
        switch(rotation) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        out.setRotate(270.0f);
        out.preTranslate(-physicalHeight, 0.0f);
        return;
    L7:
        out.setRotate(180.0f);
        out.preTranslate(-physicalWidth, -physicalHeight);
        return;
    L8:
        out.setRotate(90.0f);
        out.preTranslate(0.0f, -physicalWidth);
        return;
    L9:
        out.reset();
        return;
    L5:
        throw new IllegalArgumentException("Unknown rotation: " + rotation);
    }

    public static void transformToRotation(int oldRotation, int newRotation, DisplayInfo info, Matrix out) {
        boolean flipped = true;
        if (info.rotation != 1) goto L5;
    L8:
        if (flipped == false) goto L10;
        int h = info.logicalWidth;
    L11:
        if (flipped == false) goto L13;
        int w = info.logicalHeight;
    L14:
        Matrix tmp = new Matrix();
        transformLogicalToPhysicalCoordinates(oldRotation, w, h, out);
        transformPhysicalToLogicalCoordinates(newRotation, w, h, tmp);
        out.postConcat(tmp);
        return;
    L13:
        w = info.logicalWidth;
        goto L14
    L10:
        h = info.logicalHeight;
        goto L11
    L5:
        if (info.rotation == 3) goto L8;
        flipped = false;
        goto L8
    }

    public static void transformToRotation(int oldRotation, int newRotation, int newWidth, int newHeight, Matrix out) {
        boolean flipped = true;
        if (newRotation != 1) goto L5;
    L8:
        if (flipped == false) goto L10;
        int h = newWidth;
    L11:
        if (flipped == false) goto L13;
        int w = newHeight;
    L14:
        Matrix tmp = new Matrix();
        transformLogicalToPhysicalCoordinates(oldRotation, w, h, out);
        transformPhysicalToLogicalCoordinates(newRotation, w, h, tmp);
        out.postConcat(tmp);
        return;
    L13:
        w = newWidth;
        goto L14
    L10:
        h = newHeight;
        goto L11
    L5:
        if (newRotation == 3) goto L8;
        flipped = false;
        goto L8
    }

    public static void computeRotationMatrix(int rotationDelta, int w, int h, Matrix outMatrix) {
        switch(rotationDelta) {
            case 0: goto L8;
            case 1: goto L7;
            case 2: goto L6;
            case 3: goto L5;
            default: goto L13;
        };
    L5:
        outMatrix.setRotate(270.0f);
        outMatrix.postTranslate(0.0f, w);
        return;
    L6:
        outMatrix.setRotate(180.0f);
        outMatrix.postTranslate(w, h);
        return;
    L7:
        outMatrix.setRotate(90.0f);
        outMatrix.postTranslate(h, 0.0f);
        return;
    L8:
        outMatrix.reset();
        return;
    }
}
