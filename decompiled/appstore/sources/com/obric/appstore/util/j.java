package com.obric.appstore.util;

import android.widget.EditText;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static /* synthetic */ void a(EditText r10, Fragment r11) {
        f(r10, r11);
    }

    public static /* synthetic */ void b(Fragment r10, EditText r11) {
        k(r10, r11);
    }

    public static final void c(Fragment r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        FragmentActivity r11 = r10.getActivity();
        if (r11 != null) goto L5;
        return;
    L5:
        androidx.core.view.t.a(r11.getWindow(), r11.getWindow().getDecorView()).a(WindowInsetsCompat.Type.a());
    }

    public static final void d(final Fragment r10, final EditText r11, long r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        k.f11081a.d().postDelayed(new i(r11, r10), r12);
    }

    public static /* synthetic */ void e(Fragment r10, EditText r11, long r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 100;
    L5:
        d(r10, r11, r12);
    }

    public static final void f(EditText r10, Fragment r11) {
        kotlin.jvm.internal.q.g(r11, "$this_hideImeDelayed");
        if (r10 == null) goto L5;
        r10.clearFocus();
    L5:
        c(r11);
    }

    public static final boolean g(Fragment r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        FragmentActivity r11 = r10.getActivity();
        if (r11 != null) goto L5;
        return false;
    L5:
        WindowInsetsCompat r12 = ViewCompat.H(r11.getWindow().getDecorView());
        if (r12 != null) goto L8;
        return false;
    L8:
        return r12.s(WindowInsetsCompat.Type.a());
    }

    public static final void h(Fragment r10, EditText r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        FragmentActivity r12 = r10.getActivity();
        if (r12 != null) goto L5;
        return;
    L5:
        if (r11 == null) goto L7;
        r11.requestFocus();
    L7:
        androidx.core.view.t.a(r12.getWindow(), r12.getWindow().getDecorView()).e(WindowInsetsCompat.Type.a());
    }

    public static final void i(final Fragment r10, final EditText r11, long r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        k.f11081a.d().postDelayed(new h(r10, r11), r12);
    }

    public static /* synthetic */ void j(Fragment r10, EditText r11, long r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = 100;
    L5:
        i(r10, r11, r12);
    }

    public static final void k(Fragment r10, EditText r11) {
        kotlin.jvm.internal.q.g(r10, "$this_showImeDelayed");
        h(r10, r11);
    }
}
