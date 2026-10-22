package com.bytedance.android.gamecp.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes44.dex */
public final class s1 {
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
}
