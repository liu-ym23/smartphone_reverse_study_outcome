package com.bytedance.android.live.core.utils;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.bytedance.android.livesdkapi.util.JavaCalls;

/* JADX INFO: loaded from: classes45.dex */
public final class x0 {
    public static void a(EditText r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        InputMethodManager r101 = (InputMethodManager) s1.getContext().getSystemService("input_method");
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.hideSoftInputFromWindow(r100.getWindowToken(), 0) == true) goto L18;
        Integer r102 = (Integer) JavaCalls.callMethod(r101, "getInputMethodWindowVisibleHeight", new Object[0]);
        if (r102 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L19;
        r101.toggleSoftInput(0, 2);
        return;
    L19:
        return;
    L11:
        if (r102.intValue() <= 0) goto L13;
        r103 = true;
        goto L14
    }

    public static void b(final EditText r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.postDelayed(new w0(r100), 100);
    }
}
