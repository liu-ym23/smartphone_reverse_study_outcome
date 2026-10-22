package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.view.Window;
import androidx.core.view.Y;

/* loaded from: classes2.dex */
public class d {
    public static void a(Window window, boolean z10, Integer num, Integer num2) {
        boolean z11 = num == null || num.intValue() == 0;
        boolean z12 = num2 == null || num2.intValue() == 0;
        if (z11 || z12) {
            int iB = M2.a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z11) {
                num = Integer.valueOf(iB);
            }
            if (z12) {
                num2 = Integer.valueOf(iB);
            }
        }
        Y.b(window, !z10);
        int iC = c(window.getContext(), z10);
        int iB2 = b(window.getContext(), z10);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, M2.a.h(num.intValue())));
        e(window, d(iB2, M2.a.h(num2.intValue())));
    }

    public static int b(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return M2.a.b(context, R.attr.navigationBarColor, -16777216);
    }

    public static int c(Context context, boolean z10) {
        if (z10) {
            return 0;
        }
        return M2.a.b(context, R.attr.statusBarColor, -16777216);
    }

    public static boolean d(int i10, boolean z10) {
        if (M2.a.h(i10)) {
            return true;
        }
        return i10 == 0 && z10;
    }

    public static void e(Window window, boolean z10) {
        Y.a(window, window.getDecorView()).d(z10);
    }

    public static void f(Window window, boolean z10) {
        Y.a(window, window.getDecorView()).e(z10);
    }
}
