package com.bytedance.android.livesdk.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: loaded from: classes11.dex */
public final class t2 {
    public static void a(Context r100, EditText r101) {
        i40.h.c("KeyBoardUtil.hideSoftKeyBoard", true);
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        ((InputMethodManager) r100.getSystemService("input_method")).hideSoftInputFromWindow(r101.getWindowToken(), 0);
        return;
    L8:
        return;
    }

    public static void b(Context r100, EditText r101) {
        i40.h.c("KeyBoardUtil.showSoftKeyBoard", true);
        if (r100 != null) goto L5;
        return;
    L5:
        ((InputMethodManager) r100.getSystemService("input_method")).showSoftInput(r101, 1);
    }
}
