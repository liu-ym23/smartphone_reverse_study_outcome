package com.bytedance.android.live.search.impl.search.helper;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f100772a = 0;

    static {
    }

    public static void a(View r100) {
        if (r100 == null) goto L10;
        Object r101 = jc1.a.b().getSystemService("input_method");
        if ((r101 instanceof InputMethodManager) == true) goto L6;
        r101 = null;
    L6:
        InputMethodManager r102 = (InputMethodManager) r101;
        if (r102 == null) goto L11;
        r102.hideSoftInputFromWindow(r100.getWindowToken(), 0);
        return;
    L11:
        return;
    }

    public static void b(View r100) {
        if (r100 == null) goto L10;
        Object r101 = jc1.a.b().getSystemService("input_method");
        if ((r101 instanceof InputMethodManager) == true) goto L6;
        r101 = null;
    L6:
        InputMethodManager r102 = (InputMethodManager) r101;
        if (r102 == null) goto L11;
        r102.showSoftInput(r100, 1);
        return;
    L11:
        return;
    }
}
