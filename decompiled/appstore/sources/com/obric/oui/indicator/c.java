package com.obric.oui.indicator;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static final boolean a(ViewPager r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.getAdapter() == null) goto L8;
        PagerAdapter r11 = r10.getAdapter();
        q.d(r11);
        if (r11.getCount() != 0) goto L8;
        return true;
    }

    public static final boolean b(ViewPager r10) {
        q.g(r10, "<this>");
        PagerAdapter r11 = r10.getAdapter();
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        if (r12 <= 0) goto L9;
        return true;
    L9:
        return false;
    L5:
        r12 = r11.getCount();
        goto L6
    }

    public static final void c(View r10, int r11) {
        q.g(r10, "<this>");
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        ViewGroup.LayoutParams r13 = null;
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r12;
    L6:
        if (r14 == null) goto L9;
        r14.setMarginStart(r11);
        r14.setMarginEnd(r11);
        r10.requestLayout();
        r13 = r14;
    L9:
        r10.setLayoutParams(r13);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public static final void d(View r10, int r11) {
        q.g(r10, "<this>");
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        ViewGroup.LayoutParams r13 = null;
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r12;
    L6:
        if (r14 == null) goto L25;
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        int r16 = 0;
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        int r17 = androidx.core.view.e.b((ViewGroup.MarginLayoutParams) r15);
    L12:
        ViewGroup.LayoutParams r18 = r10.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L16;
        r13 = r18;
    L16:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r13;
        if (r19 == null) goto L19;
        int r20 = r19.topMargin;
    L20:
        ViewGroup.LayoutParams r21 = r10.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L23;
        r16 = androidx.core.view.e.a((ViewGroup.MarginLayoutParams) r21);
    L23:
        r14.setMargins(r17, r20, r16, r11);
        r10.requestLayout();
        return;
    L19:
        r20 = 0;
        goto L20
    L11:
        r17 = 0;
        goto L12
    L25:
        return;
    L5:
        r14 = null;
        goto L6
    }

    public static final void e(View r10, int r11) {
        q.g(r10, "<this>");
        r10.getLayoutParams().width = r11;
        r10.requestLayout();
    }
}
