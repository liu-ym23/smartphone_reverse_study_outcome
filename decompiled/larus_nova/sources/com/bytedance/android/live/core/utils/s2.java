package com.bytedance.android.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes45.dex */
public final class s2 {
    public static Activity a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof ContextWrapper) == false) goto L12;
        if ((r100 instanceof Activity) == true) goto L10;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L6
    L10:
        return (Activity) r100;
    L12:
        return null;
    }

    public static Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L12;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L11:
        Logger.w("ViewUtils", "find non-ContextWrapper in view: " + r100);
        goto L12
    L7:
        return (Activity) r100;
    L12:
        return null;
    }
}
