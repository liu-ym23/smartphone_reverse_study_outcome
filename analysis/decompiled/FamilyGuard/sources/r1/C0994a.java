package r1;

import android.R;
import android.content.res.ColorStateList;

/* renamed from: r1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0994a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f19955a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f19956b = {R.attr.state_focused};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f19957c = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f19958d = {R.attr.state_selected};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f19959e = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final String f19960f = C0994a.class.getSimpleName();

    private C0994a() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        return colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
    }

    public static boolean b(int[] iArr) {
        boolean z5 = false;
        boolean z6 = false;
        for (int i5 : iArr) {
            if (i5 == 16842910) {
                z5 = true;
            } else if (i5 == 16842908 || i5 == 16842919 || i5 == 16843623) {
                z6 = true;
            }
        }
        return z5 && z6;
    }
}
