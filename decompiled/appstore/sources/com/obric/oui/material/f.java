package com.obric.oui.material;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {
    public static final void a(View r10, boolean r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 == false) goto L5;
        OMaterialHelper.H(r10, r12, 1);
        return;
    L5:
        OMaterialHelper.H(r10, 0, 1);
    }

    public static final void b(View r10, boolean r11, boolean r12) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r12 == false) goto L5;
        o.a(r10, r11);
        return;
    L5:
        o.b(r10, r11);
    }

    public static final void c(Iterable r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((MaterialOwner) r12.next()).applyContentMaterial(r11);
        goto L4
    }

    public static final void d(ViewGroup[] r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        ViewGroup r14 = r10[r13];
        int r15 = r14.getChildCount();
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L14;
        int r17 = r16 + 1;
        KeyEvent.Callback r18 = r14.getChildAt(r16);
        if ((r18 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r19 = (MaterialOwner) r18;
    L10:
        if (r19 == null) goto L13;
        r19.applyContentMaterial(r11);
    L13:
        r16 = r17;
        goto L5
    L9:
        r19 = null;
        goto L10
    L14:
        r13 = r13 + 1;
        goto L3
    }

    public static final void e(Iterable r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((MaterialOwner) r12.next()).updateBackdropSrcType(r11);
        goto L4
    }

    public static final void f(ViewGroup[] r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        ViewGroup r14 = r10[r13];
        int r15 = r14.getChildCount();
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L14;
        int r17 = r16 + 1;
        KeyEvent.Callback r18 = r14.getChildAt(r16);
        if ((r18 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r19 = (MaterialOwner) r18;
    L10:
        if (r19 == null) goto L13;
        r19.updateBackdropSrcType(r11);
    L13:
        r16 = r17;
        goto L5
    L9:
        r19 = null;
        goto L10
    L14:
        r13 = r13 + 1;
        goto L3
    }

    public static final void g(Iterable r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((MaterialOwner) r12.next()).setBackdropTarget(r11);
        goto L4
    }

    public static final void h(ViewGroup[] r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        ViewGroup r14 = r10[r13];
        int r15 = r14.getChildCount();
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L14;
        int r17 = r16 + 1;
        KeyEvent.Callback r18 = r14.getChildAt(r16);
        if ((r18 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r19 = (MaterialOwner) r18;
    L10:
        if (r19 == null) goto L13;
        r19.setBackdropTarget(r11);
    L13:
        r16 = r17;
        goto L5
    L9:
        r19 = null;
        goto L10
    L14:
        r13 = r13 + 1;
        goto L3
    }

    public static final void i(Iterable r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ((MaterialOwner) r12.next()).updateBackdropTargetType(r11);
        goto L4
    }

    public static final void j(ViewGroup[] r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        ViewGroup r14 = r10[r13];
        int r15 = r14.getChildCount();
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L14;
        int r17 = r16 + 1;
        KeyEvent.Callback r18 = r14.getChildAt(r16);
        if ((r18 instanceof MaterialOwner) == false) goto L9;
        MaterialOwner r19 = (MaterialOwner) r18;
    L10:
        if (r19 == null) goto L13;
        r19.updateBackdropTargetType(r11);
    L13:
        r16 = r17;
        goto L5
    L9:
        r19 = null;
        goto L10
    L14:
        r13 = r13 + 1;
        goto L3
    }
}
