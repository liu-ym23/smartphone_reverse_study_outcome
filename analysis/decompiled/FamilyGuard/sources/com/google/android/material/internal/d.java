package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.view.Window;
import androidx.core.view.W;
import j1.C0777a;

/* loaded from: classes.dex */
public class d {
    public static void a(Window window, boolean z5, Integer num, Integer num2) {
        boolean z6 = num == null || num.intValue() == 0;
        boolean z7 = num2 == null || num2.intValue() == 0;
        if (z6 || z7) {
            int iB = C0777a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z6) {
                num = Integer.valueOf(iB);
            }
            if (z7) {
                num2 = Integer.valueOf(iB);
            }
        }
        W.b(window, !z5);
        int iC = c(window.getContext(), z5);
        int iB2 = b(window.getContext(), z5);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, C0777a.h(num.intValue())));
        e(window, d(iB2, C0777a.h(num2.intValue())));
    }

    private static int b(Context context, boolean z5) {
        if (z5) {
            return 0;
        }
        return C0777a.b(context, R.attr.navigationBarColor, -16777216);
    }

    private static int c(Context context, boolean z5) {
        if (z5) {
            return 0;
        }
        return C0777a.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i5, boolean z5) {
        if (C0777a.h(i5)) {
            return true;
        }
        return i5 == 0 && z5;
    }

    public static void e(Window window, boolean z5) {
        W.a(window, window.getDecorView()).a(z5);
    }

    public static void f(Window window, boolean z5) {
        W.a(window, window.getDecorView()).b(z5);
    }
}
