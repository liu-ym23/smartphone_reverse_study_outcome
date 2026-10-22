package com.obric.common.oea.foundation.animation.a;

import android.view.View;
import d.h.b.o;

/* JADX INFO: compiled from: PropertyAnimatable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ b.a a(View r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        return a(r0, r1);
    }

    public static final b.a a(View r1, float r2) {
        o.e(r1, "$this$animator");
        return new b.a(r1).a(r2, 90.0f);
    }

    public static final b.a a(View r1, float r2, float r3) {
        o.e(r1, "$this$animator");
        return new b.a(r1).a(r2, r3);
    }
}
