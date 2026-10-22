package com.obric.oui.animation.style;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final List a(View r10) {
        q.g(r10, "view");
        ArrayList r11 = new ArrayList();
        if ((r10 instanceof ViewGroup) == false) goto L8;
        ViewGroup r12 = (ViewGroup) r10;
        int r13 = r12.getChildCount();
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L10;
        int r15 = r14 + 1;
        View r16 = r12.getChildAt(r14);
        q.f(r16, "child");
        r11.addAll(a(r16));
        r14 = r15;
    L10:
        return r11;
    L8:
        if ((r10 instanceof EditText) == false) goto L10;
        r11.add(r10);
        goto L10
    }

    public static final void b(View r10) {
        q.g(r10, "rootView");
        List r11 = a(r10);
        Object r12 = r10.getContext().getSystemService("input_method");
        if (r12 == null) goto L12;
        InputMethodManager r13 = (InputMethodManager) r12;
        Iterator r14 = r11.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        EditText r15 = (EditText) r14.next();
        if (r13.isActive(r15) == false) goto L6;
        r13.hideSoftInputFromWindow(r15.getWindowToken(), 0);
        goto L6
    L10:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
