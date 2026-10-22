package com.bytedance.android.ec.core.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f45663a = null;

    public p() {
    }

    static {
        f45663a = new p();
    }

    public final Activity getActivity(Context r100) {
    L3:
        if (r100 == null) goto L11;
        if ((r100 instanceof Activity) == true) goto L7;
        if ((r100 instanceof ContextWrapper) == false) goto L11;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L7:
        return (Activity) r100;
    L11:
        return null;
    }
}
