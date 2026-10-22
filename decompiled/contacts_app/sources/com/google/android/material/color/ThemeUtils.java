package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes2.dex */
final class ThemeUtils {
    private ThemeUtils() {
    }

    static void applyThemeOverlay(Context r2, int r3) {
        r2.getTheme().applyStyle(r3, true);
        if ((r2 instanceof Activity) == false) goto L8;
        Resources.Theme r4 = getWindowDecorViewTheme((Activity) r2);
        if (r4 == null) goto L9;
        r4.applyStyle(r3, true);
        return;
    L9:
        return;
    }

    private static Resources.Theme getWindowDecorViewTheme(Activity r0) {
        Window r1 = r0.getWindow();
        if (r1 == null) goto L10;
        View r2 = r1.peekDecorView();
        if (r2 == null) goto L12;
        Context r3 = r2.getContext();
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getTheme();
    L12:
        return null;
    L10:
        return null;
    }
}
