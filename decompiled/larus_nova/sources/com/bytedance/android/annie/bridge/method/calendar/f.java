package com.bytedance.android.annie.bridge.method.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38592a = 0;

    static {
    }

    public static Activity a(Context r100) {
    L2:
        if (r100 == null) goto L16;
        if ((r100 instanceof Activity) == true) goto L6;
        if ((r100 instanceof ContextWrapper) == false) goto L10;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L2
    L10:
        r100.toString();
        return null;
    L6:
        return (Activity) r100;
    L16:
        return null;
    }
}
