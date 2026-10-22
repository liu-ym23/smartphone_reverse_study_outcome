package com.bytedance.android.accessibilityLib_Core.util;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static boolean a(ViewGroup r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.getChildCount()) goto L21;
        View r102 = r100.getChildAt(r101);
        if (r102 != null) goto L11;
        boolean r103 = false;
    L13:
        if (r103 == true) goto L14;
        if ((r102 instanceof ViewGroup) == false) goto L20;
        if (a((ViewGroup) r102) == false) goto L20;
        return true;
    L20:
        r101 = r101 + 1;
        goto L7
    L14:
        return true;
    L11:
        r103 = r102.isImportantForAccessibility();
        goto L13
    L21:
        return false;
    }

    public static boolean b(View r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Object r101 = r100.getParentForAccessibility();
        if ((r101 instanceof View) == true) goto L8;
        return false;
    L8:
        View r102 = (View) r101;
        if (d(r102) == false) goto L13;
        return true;
    L13:
        return b(r102);
    }

    public static boolean c(View r100) {
        if (TextUtils.isEmpty(r100.getContentDescription()) == true) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextView) == false) goto L14;
        TextView r101 = (TextView) r100;
        if (TextUtils.isEmpty(r101.getText()) == true) goto L10;
        return true;
    L10:
        if (TextUtils.isEmpty(r101.getHint()) == false) goto L16;
        return false;
    L16:
        return true;
    L14:
        return false;
    }

    public static boolean d(View r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getVisibility() == 0) goto L9;
        return false;
    L9:
        if (r100.isImportantForAccessibility() == true) goto L12;
        return false;
    L12:
        if (r100.isClickable() == false) goto L14;
    L19:
        boolean r101 = true;
    L20:
        if (r101 == false) goto L22;
        return true;
    L22:
        Object r102 = r100.getParentForAccessibility();
        if (r102 != null) goto L25;
    L39:
        boolean r103 = false;
    L40:
        if (r103 == true) goto L42;
        return false;
    L42:
        if (e(r100) == false) goto L46;
        return true;
    L46:
        return false;
    L25:
        if ((r102 instanceof View) == false) goto L39;
        View r104 = (View) r102;
        if (r104.isScrollContainer() == false) goto L31;
    L38:
        r103 = true;
        goto L40
    L31:
        if ((r104 instanceof AdapterView) == true) goto L37;
        if ((r104 instanceof ScrollView) == true) goto L37;
        if ((r104 instanceof HorizontalScrollView) == false) goto L39;
    L37:
        if ((r104 instanceof Spinner) == true) goto L39;
    L14:
        if (r100.isLongClickable() == true) goto L19;
        if (r100.isFocusable() == true) goto L19;
        r101 = false;
        goto L20
    }

    public static boolean e(View r100) {
        if (c(r100) == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof Checkable) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof ViewGroup) == false) goto L27;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = 0;
    L13:
        if (r102 >= r101.getChildCount()) goto L27;
        View r103 = r101.getChildAt(r102);
        if (r103 == null) goto L26;
        if (r103.getVisibility() != 0) goto L26;
        if (d(r103) == true) goto L26;
        if (r103.isImportantForAccessibility() == false) goto L26;
        if (e(r103) == false) goto L26;
        boolean r104 = true;
    L28:
        if (r104 == false) goto L30;
        return true;
    L30:
        return false;
    L26:
        r102 = r102 + 1;
    L27:
        r104 = false;
        goto L28
    }
}
