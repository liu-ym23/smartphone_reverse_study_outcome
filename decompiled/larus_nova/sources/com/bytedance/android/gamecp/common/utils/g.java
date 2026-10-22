package com.bytedance.android.gamecp.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes44.dex */
public final class g {
    public static Activity a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Activity) == false) goto L10;
        return (Activity) r100;
    L10:
        if ((r100 instanceof ContextWrapper) == true) goto L12;
        return null;
    L12:
        return a(((ContextWrapper) r100).getBaseContext());
    }

    public static FragmentActivity b(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof FragmentActivity) == false) goto L10;
        return (FragmentActivity) r100;
    L10:
        if ((r100 instanceof ContextWrapper) == true) goto L12;
        return null;
    L12:
        return b(((ContextWrapper) r100).getBaseContext());
    }
}
