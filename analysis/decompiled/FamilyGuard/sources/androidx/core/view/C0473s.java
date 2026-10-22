package androidx.core.view;

import android.view.MotionEvent;

/* renamed from: androidx.core.view.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0473s {
    @Deprecated
    public static int a(MotionEvent motionEvent, int i5) {
        return motionEvent.findPointerIndex(i5);
    }

    @Deprecated
    public static int b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    @Deprecated
    public static int c(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int d(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    @Deprecated
    public static int e(MotionEvent motionEvent, int i5) {
        return motionEvent.getPointerId(i5);
    }

    @Deprecated
    public static float f(MotionEvent motionEvent, int i5) {
        return motionEvent.getX(i5);
    }

    @Deprecated
    public static float g(MotionEvent motionEvent, int i5) {
        return motionEvent.getY(i5);
    }

    public static boolean h(MotionEvent motionEvent, int i5) {
        return (motionEvent.getSource() & i5) == i5;
    }
}
