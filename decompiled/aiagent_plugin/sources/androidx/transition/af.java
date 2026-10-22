package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class af {
    private static final String TAG = "ViewUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Property<View, Float> f2791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Property<View, Rect> f2792b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final al f2793c = null;

    static {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        f2793c = new ak();
    L18:
        final Class<Float> r1 = Float.class;
        final String r2 = "translationAlpha";
        f2791a = new ViewUtils$1(r1, r2);
        final Class<Rect> r3 = Rect.class;
        final String r4 = "clipBounds";
        f2792b = new ViewUtils$2(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        f2793c = new aj();
        goto L18
    L9:
        if (Build.VERSION.SDK_INT < 22) goto L12;
        f2793c = new ai();
        goto L18
    L12:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        f2793c = new ah();
        goto L18
    L15:
        if (Build.VERSION.SDK_INT < 19) goto L17;
        f2793c = new ag();
        goto L18
    L17:
        f2793c = new al();
        goto L18
    }

    static ae a(View r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new ad(r2);
    L7:
        return ViewOverlayApi14.d(r2);
    }

    static ao b(View r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return new an(r2);
    L7:
        return new am(r2.getWindowToken());
    }

    static void a(View r1, float r2) {
        f2793c.a(r1, r2);
    }

    static float c(View r1) {
        return f2793c.a(r1);
    }

    static void d(View r1) {
        f2793c.b(r1);
    }

    static void e(View r1) {
        f2793c.c(r1);
    }

    static void a(View r1, int r2) {
        f2793c.a(r1, r2);
    }

    static void a(View r1, Matrix r2) {
        f2793c.a(r1, r2);
    }

    static void b(View r1, Matrix r2) {
        f2793c.b(r1, r2);
    }

    static void c(View r1, Matrix r2) {
        f2793c.c(r1, r2);
    }

    static void a(View r6, int r7, int r8, int r9, int r10) {
        f2793c.a(r6, r7, r8, r9, r10);
    }
}
