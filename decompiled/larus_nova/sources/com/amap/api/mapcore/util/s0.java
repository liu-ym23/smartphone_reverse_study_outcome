package com.amap.api.mapcore.util;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes28.dex */
final class s0 {
    public static float a(MotionEvent r100, int r101) {
        if (r101 >= 0) goto L4;
        return Float.MIN_VALUE;
    L4:
        if (r101 >= r100.getPointerCount()) goto L13;
        if (r101 != 0) goto L10;
        return r100.getRawX();
    L10:
        return r100.getX(r101) + (r100.getRawX() - r100.getX());
    L13:
        return Float.MIN_VALUE;
    }

    public static float b(MotionEvent r100, int r101) {
        if (r101 >= 0) goto L4;
        return Float.MIN_VALUE;
    L4:
        if (r101 >= r100.getPointerCount()) goto L13;
        if (r101 != 0) goto L10;
        return r100.getRawY();
    L10:
        return r100.getY(r101) + (r100.getRawY() - r100.getY());
    L13:
        return Float.MIN_VALUE;
    }

    public static float a(MotionEvent r100, int r101, int r102) {
        return a(r100, r101) - r102;
    }

    public static float b(MotionEvent r100, int r101, int r102) {
        return b(r100, r101) - r102;
    }
}
