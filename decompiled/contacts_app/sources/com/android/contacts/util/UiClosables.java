package com.android.contacts.util;

import android.widget.ListPopupWindow;
import obric.app.MenuDialog;

/* JADX INFO: loaded from: classes2.dex */
public class UiClosables {
    public UiClosables() {
    }

    public static boolean closeQuietly(ListPopupWindow r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.isShowing() == false) goto L9;
        r1.dismiss();
        return true;
    L9:
        return false;
    }

    public static boolean closeQuietly(MenuDialog r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.isShowing() == false) goto L9;
        r1.dismiss();
        return true;
    L9:
        return false;
    }
}
