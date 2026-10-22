package com.obric.common.oea.foundation.animation.g;

import com.obric.common.oea.foundation.animation.g.a.d;
import com.obric.common.oea.foundation.animation.h.e;
import d.h.b.o;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final com.obric.common.oea.foundation.animation.g.b.a a(e.c r1, e.b r2, e.d r3) {
        o.e(r1, "duration");
        o.e(r2, "delay");
        o.e(r3, "easing");
        return new com.obric.common.oea.foundation.animation.g.b.a(r1.a(), r2.a(), r3);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.g.b.a a(int r0, int r1, e.d r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = e.d.f32444b;
    L6:
        return a(r0, r1, r2);
    }

    public static final com.obric.common.oea.foundation.animation.g.b.a a(int r1, int r2, e.d r3) {
        o.e(r3, "easing");
        return new com.obric.common.oea.foundation.animation.g.b.a(r1, r2, r3);
    }

    public static final com.obric.common.oea.foundation.animation.g.b.b b(e.c r8, e.b r9, e.d r10) {
        o.e(r8, "duration");
        o.e(r9, "delay");
        o.e(r10, "easing");
        return new com.obric.common.oea.foundation.animation.g.b.b(r8.a(), r9.a(), r10, false, 8, null);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.g.a.b a(float r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = 1.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r1 = 1500.0f;
    L9:
        if ((r3 & 4) == 0) goto L12;
        r2 = 0;
    L12:
        return a(r0, r1, r2);
    }

    public static final com.obric.common.oea.foundation.animation.g.a.b a(float r8, float r9, int r10) {
        return new com.obric.common.oea.foundation.animation.g.a.b(r8, r9, r10, 0.0f, 8, null);
    }

    public static final com.obric.common.oea.foundation.animation.g.a.b a(e.a r8, e.c r9, e.b r10) {
        o.e(r8, "bounce");
        o.e(r9, "duration");
        o.e(r10, "delay");
        return new com.obric.common.oea.foundation.animation.g.a.b(r8.b(), r9.b(), r10.a(), 0.0f, 8, null);
    }

    public static /* synthetic */ com.obric.common.oea.foundation.animation.g.a.b a(e.a r0, e.c r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return a(r0, r1, r2);
    }

    public static final com.obric.common.oea.foundation.animation.g.a.b a(e.a r8, e.c r9, int r10) {
        o.e(r8, "bounce");
        o.e(r9, "duration");
        return new com.obric.common.oea.foundation.animation.g.a.b(r8.b(), r9.b(), r10, 0.0f, 8, null);
    }

    public static /* synthetic */ d b(e.a r0, e.c r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return b(r0, r1, r2);
    }

    public static final d b(e.a r9, e.c r10, int r11) {
        o.e(r9, "bounce");
        o.e(r10, "duration");
        return new d(r9.b(), r10.b(), r11, 0.0f, false, 24, null);
    }
}
