package androidx.transition;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class w {
    static {
    }

    public static int a(ViewGroup r10, int r11) {
        return r10.getChildDrawingOrder(r11);
    }

    public static ViewGroupOverlayImpl b(ViewGroup r10) {
        return new v(r10);
    }

    public static void c(ViewGroup r10, boolean r11) {
        r10.suppressLayout(r11);
    }
}
