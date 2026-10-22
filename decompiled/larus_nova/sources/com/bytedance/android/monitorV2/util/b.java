package com.bytedance.android.monitorV2.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static Activity a(Context r100) {
    L14:
    L10:
        e = move-exception;
        f.b(e);
        return null;
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L18;
        if ((r100 instanceof Activity) == true) goto L6;
        r100 = ((ContextWrapper) r100).getBaseContext();     // Catch: Exception -> L10
        goto L14
    L6:
        return (Activity) r100;
    L18:
        return null;
    }
}
