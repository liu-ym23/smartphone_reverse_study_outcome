package com.obric.autoaction.vdplayer.components.cursor.a;

import android.view.View;
import com.obric.common.oea.foundation.animation.a.b;
import com.obric.common.oea.foundation.animation.a.c;
import com.obric.common.oea.foundation.animation.manager.d;
import d.h.b.o;

/* JADX INFO: compiled from: AnimatableExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ b.a a(View r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 1.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 30.0f;
    L9:
        return a(r0, r1, r2);
    }

    public static final b.a a(View r1, float r2, float r3) {
        o.e(r1, "<this>");
        return c.a(r1, r2, r3);
    }

    public static /* synthetic */ d a(b r0, com.obric.common.oea.foundation.animation.d.b r1, com.obric.common.oea.foundation.animation.d.a r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = com.obric.common.oea.foundation.animation.d.b.f32344a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = com.obric.common.oea.foundation.animation.d.a.f32340a;
    L9:
        return a(r0, r1, r2);
    }

    public static final d a(b r1, com.obric.common.oea.foundation.animation.d.b r2, com.obric.common.oea.foundation.animation.d.a r3) {
        o.e(r1, "<this>");
        o.e(r2, "mode");
        o.e(r3, "repeatMode");
        return r1.a(r2, r3, true);
    }

    public static /* synthetic */ d a(com.obric.common.oea.foundation.animation.a.d r0, com.obric.common.oea.foundation.animation.d.b r1, com.obric.common.oea.foundation.animation.d.a r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = com.obric.common.oea.foundation.animation.d.b.f32344a;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = com.obric.common.oea.foundation.animation.d.a.f32340a;
    L9:
        return a(r0, r1, r2);
    }

    public static final d a(com.obric.common.oea.foundation.animation.a.d r1, com.obric.common.oea.foundation.animation.d.b r2, com.obric.common.oea.foundation.animation.d.a r3) {
        o.e(r1, "<this>");
        o.e(r2, "mode");
        o.e(r3, "repeatMode");
        return r1.a(r2, r3, true);
    }
}
