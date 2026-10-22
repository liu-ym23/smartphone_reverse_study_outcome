package com.obric.oui.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: classes4.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    private static class Impl16 {
        private Impl16() {
        }

        static void setDecorFitsSystemWindows(Window r1, boolean r2) {
            View r3 = r1.getDecorView();
            int r0 = r3.getSystemUiVisibility();
            if (r2 == false) goto L5;
            int r4 = r0 & (-1793);
        L6:
            r3.setSystemUiVisibility(r4);
            return;
        L5:
            r4 = r0 | 1792;
            goto L6
        }
    }

    private static class Impl30 {
        private Impl30() {
        }

        static void setDecorFitsSystemWindows(Window r0, boolean r1) {
            r0.setDecorFitsSystemWindows(r1);
        }

        static WindowInsetsControllerCompat getInsetsController(Window r0) {
            WindowInsetsController r1 = r0.getInsetsController();
            if (r1 != null) goto L5;
            return null;
        L5:
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(r1);
        }
    }

    private WindowCompat() {
    }

    public static <T extends View> T requireViewById(Window r0, int r1) {
        return (T) r0.requireViewById(r1);
    }

    public static void setDecorFitsSystemWindows(Window r0, boolean r1) {
        Impl30.setDecorFitsSystemWindows(r0, r1);
    }

    public static WindowInsetsControllerCompat getInsetsController(Window r0, View r1) {
        return Impl30.getInsetsController(r0);
    }
}
