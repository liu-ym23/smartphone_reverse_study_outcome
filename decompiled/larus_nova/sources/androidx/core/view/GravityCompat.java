package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: loaded from: classes17.dex */
public final class GravityCompat {
    public static final int END = 8388613;
    public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
    public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
    public static final int START = 8388611;

    private GravityCompat() {
    }

    public static int getAbsoluteGravity(int r100, int r101) {
        return Gravity.getAbsoluteGravity(r100, r101);
    }

    public static void applyDisplay(int r100, Rect r101, Rect r102, int r103) {
        Gravity.applyDisplay(r100, r101, r102, r103);
    }

    public static void apply(int r100, int r101, int r102, Rect r103, Rect r104, int r105) {
        Gravity.apply(r100, r101, r102, r103, r104, r105);
    }

    public static void apply(int r100, int r101, int r102, Rect r103, int r104, int r105, Rect r106, int r107) {
        Gravity.apply(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
