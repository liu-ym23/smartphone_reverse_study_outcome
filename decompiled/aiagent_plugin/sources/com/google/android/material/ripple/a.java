package com.google.android.material.ripple;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.e;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: RippleUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f13528a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f13529b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f13530c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f13531d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f13532e = null;
    private static final int[] f = null;
    private static final int[] g = null;
    private static final int[] h = null;
    private static final int[] i = null;
    private static final int[] j = null;
    private static final int[] k = null;
    private static final int[] l = null;

    static {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r0 = true;
    L6:
        f13528a = r0;
        f13530c = new int[]{R.attr.state_pressed};
        f13531d = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f13532e = new int[]{R.attr.state_focused};
        f = new int[]{R.attr.state_hovered};
        g = new int[]{R.attr.state_selected, R.attr.state_pressed};
        h = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        i = new int[]{R.attr.state_selected, R.attr.state_focused};
        j = new int[]{R.attr.state_selected, R.attr.state_hovered};
        k = new int[]{R.attr.state_selected};
        l = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f13529b = a.class.getSimpleName();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private a() {
    }

    public static ColorStateList a(ColorStateList r6) {
        if (f13528a == true) goto L5;
        int[] r5 = g;
        int[] r7 = h;
        int[] r2 = i;
        int[] r3 = j;
        int[] r4 = f13530c;
        int[] r8 = f13531d;
        int[] r9 = f13532e;
        int[] r10 = f;
        return new ColorStateList(new int[][]{r5, r7, r2, r3, k, r4, r8, r9, r10, StateSet.NOTHING}, new int[]{a(r6, r5), a(r6, r7), a(r6, r2), a(r6, r3), 0, a(r6, r4), a(r6, r8), a(r6, r9), a(r6, r10), 0});
    L5:
        return new ColorStateList(new int[][]{k, StateSet.NOTHING}, new int[]{a(r6, g), a(r6, f13530c)});
    }

    public static ColorStateList b(ColorStateList r3) {
        if (r3 == null) goto L15;
        if (Build.VERSION.SDK_INT >= 22) goto L7;
    L13:
        return r3;
    L7:
        if (Build.VERSION.SDK_INT > 27) goto L13;
        if (Color.alpha(r3.getDefaultColor()) != 0) goto L13;
        if (Color.alpha(r3.getColorForState(l, 0)) == 0) goto L13;
        a(f13529b, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        goto L13
    L15:
        return ColorStateList.valueOf(0);
    }

    public static boolean a(int[] r8) {
        int r0 = r8.length;
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
    L4:
        if (r2 >= r0) goto L18;
        int r6 = r8[r2];
        if (r6 != 16842910) goto L9;
        r3 = true;
    L17:
        r2 = r2 + 1;
        goto L4
    L9:
        if (r6 != 16842908) goto L12;
    L10:
        r4 = true;
        goto L17
    L12:
        if (r6 == 16842919) goto L10;
        if (r6 != 16843623) goto L17;
    L18:
        if (r3 == false) goto L26;
        if (r4 == true) goto L21;
        return false;
    L21:
        return true;
    L26:
        return false;
    }

    private static int a(ColorStateList r1, int[] r2) {
        if (r1 == null) goto L4;
        int r3 = r1.getColorForState(r2, r1.getDefaultColor());
    L6:
        if (f13528a == true) goto L8;
        return r3;
    L8:
        return a(r3);
    L4:
        r3 = 0;
        goto L6
    }

    private static int a(int r2) {
        return e.b(r2, Math.min(Color.alpha(r2) * 2, 255));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
