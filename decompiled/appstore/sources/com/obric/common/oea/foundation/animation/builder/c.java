package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final b.a a(View r10, float r11) {
        q.g(r10, "$this$animator");
        return new b.a(r10).a(r11, 90.0f);
    }

    public static /* synthetic */ b.a b(View r10, float r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = 1.0f;
    L6:
        return a(r10, r11);
    }
}
