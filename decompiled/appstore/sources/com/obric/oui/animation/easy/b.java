package com.obric.oui.animation.easy;

import android.view.View;
import com.obric.common.animation.R$id;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final ViewPropertySpringAnimator a(View r10) {
        q.g(r10, "<this>");
        int r11 = R$id.view_property_spring_animator_key;
        Object r12 = r10.getTag(r11);
        if ((r12 instanceof ViewPropertySpringAnimator) == false) goto L5;
        ViewPropertySpringAnimator r13 = (ViewPropertySpringAnimator) r12;
    L6:
        if (r13 != null) goto L9;
        ViewPropertySpringAnimator r14 = new ViewPropertySpringAnimator(r10);
        r10.setTag(r11, r14);
        return r14;
    L9:
        return r13;
    L5:
        r13 = null;
        goto L6
    }
}
