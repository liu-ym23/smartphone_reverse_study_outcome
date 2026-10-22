package com.obric.appstore.util;

import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewUtilsKt {
    public static final void a(ViewGroup r10, List r11, Function1 r12, final Function2 r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, ServerElements.LIST);
        kotlin.jvm.internal.q.g(r12, "childFactory");
        kotlin.jvm.internal.q.g(r13, "update");
        b(r10, r11, r12, new ViewUtilsKt$updateChildren$1(r13));
    }

    public static final void b(ViewGroup r10, List r11, Function1 r12, Function3 r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, ServerElements.LIST);
        kotlin.jvm.internal.q.g(r12, "childFactory");
        kotlin.jvm.internal.q.g(r13, "update");
        c(r10, r11, true, r12, r13);
    }

    public static final void c(ViewGroup r10, List r11, boolean r12, Function1 r13, Function3 r14) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, ServerElements.LIST);
        kotlin.jvm.internal.q.g(r13, "childFactory");
        kotlin.jvm.internal.q.g(r14, "update");
        if (r11.isEmpty() == false) goto L6;
        r10.removeAllViews();
        return;
    L6:
        if (r12 == true) goto L9;
        r10.removeAllViews();
    L9:
        if (r11.size() <= r10.getChildCount()) goto L14;
        int r15 = r10.getChildCount();
        int r16 = r11.size();
    L11:
        if (r15 >= r16) goto L18;
        r10.addView((View) r13.invoke(r10));
        r15 = r15 + 1;
    L18:
        int r17 = r10.getChildCount();
        int r18 = 0;
    L19:
        if (r18 >= r17) goto L21;
        View r19 = r10.getChildAt(r18);
        kotlin.jvm.internal.q.f(r19, "getChildAt(index)");
        kotlin.jvm.internal.q.e(r19, "null cannot be cast to non-null type V of com.obric.appstore.util.ViewUtilsKt.updateChildren$lambda$0");
        r14.invoke(r19, r11.get(r18), Integer.valueOf(r18));
        r18 = r18 + 1;
        goto L19
    L21:
        return;
    L14:
        if (r11.size() >= r10.getChildCount()) goto L18;
        int r20 = r11.size();
        int r21 = r10.getChildCount();
    L16:
        if (r20 >= r21) goto L18;
        r10.removeViewAt(r20);
        r20 = r20 + 1;
        goto L16
    }
}
