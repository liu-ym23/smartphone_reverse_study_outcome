package com.bytedance.android.live.openplatform.impl.base.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f84065a = 0;

    static {
    }

    public static void a(Context r100, View r101) throws Exception {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L16;
        return;
    L16:
        Object r102 = r100.getSystemService("input_method");     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        ((InputMethodManager) r102).hideSoftInputFromWindow(r101.getWindowToken(), 0);     // Catch: Exception -> L9
    L14:
        r101.clearFocus();
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
