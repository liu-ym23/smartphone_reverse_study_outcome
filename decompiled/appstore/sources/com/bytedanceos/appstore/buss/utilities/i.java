package com.bytedanceos.appstore.buss.utilities;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public static /* synthetic */ void a(Activity r10, View r11) {
        d(r10, r11);
    }

    public static final void b(final Activity r10, long r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        final View r12 = r10.getWindow().peekDecorView();
        if (r12 == null) goto L6;
        r12.postDelayed(new h(r10, r12), r11);
        return;
    }

    public static /* synthetic */ void c(Activity r10, long r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = 0;
    L5:
        b(r10, r11);
    }

    public static final void d(Activity r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "$this_hideKeyboard");
        Object r12 = r10.getSystemService("input_method");
        if ((r12 instanceof InputMethodManager) == false) goto L5;
        InputMethodManager r13 = (InputMethodManager) r12;
    L6:
        r11.clearFocus();
        if (r13 == null) goto L10;
        r13.hideSoftInputFromWindow(r11.getWindowToken(), 0);
        return;
    L10:
        return;
    L5:
        r13 = null;
        goto L6
    }
}
