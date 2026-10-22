package X2;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;
import t0.C5502d;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6849a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f6850b = {R.attr.state_focused};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f6851c = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f6852d = {R.attr.state_selected};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6853e = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    public static final String f6854f = a.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = f6850b;
        return new ColorStateList(new int[][]{f6852d, iArr, StateSet.NOTHING}, new int[]{c(colorStateList, f6851c), c(colorStateList, iArr), c(colorStateList, f6849a)});
    }

    public static int b(int i10) {
        return C5502d.k(i10, Math.min(Color.alpha(i10) * 2, 255));
    }

    public static int c(ColorStateList colorStateList, int[] iArr) {
        return b(colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0);
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        return colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
    }

    public static boolean e(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
