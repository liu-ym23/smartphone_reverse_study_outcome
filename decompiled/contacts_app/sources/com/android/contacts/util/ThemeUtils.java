package com.android.contacts.util;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes2.dex */
public class ThemeUtils {
    public ThemeUtils() {
    }

    public static int getAttribute(Resources.Theme r2, int r3) {
        TypedValue r0 = new TypedValue();
        r2.resolveAttribute(r3, r0, true);
        return r0.resourceId;
    }

    public static int getSelectableItemBackground(Resources.Theme r1) {
        return getAttribute(r1, R.attr.selectableItemBackground);
    }

    public static int getActivatedBackground(Resources.Theme r1) {
        return getAttribute(r1, R.attr.activatedBackgroundIndicator);
    }

    public static int getStatusBarHeight(Context r4) {
        int r0 = r4.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r0 > 0) goto L7;
        return 0;
    L7:
        return r4.getResources().getDimensionPixelSize(r0);
    }
}
