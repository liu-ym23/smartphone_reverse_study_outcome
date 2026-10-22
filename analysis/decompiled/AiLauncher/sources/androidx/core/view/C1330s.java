package androidx.core.view;

import android.view.MotionEvent;

/* renamed from: androidx.core.view.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1330s {
    @Deprecated
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    @Deprecated
    public static int b(MotionEvent motionEvent, int i10) {
        return motionEvent.getPointerId(i10);
    }

    public static boolean c(MotionEvent motionEvent, int i10) {
        return (motionEvent.getSource() & i10) == i10;
    }
}
