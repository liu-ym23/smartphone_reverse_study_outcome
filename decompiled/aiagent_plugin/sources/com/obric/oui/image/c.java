package com.obric.oui.image;

import d.h.b.o;
import d.k;

/* JADX INFO: compiled from: OImageStyleHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: compiled from: OImageStyleHelper.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35298a = null;

        static {
            int[] r0 = new int[com.obric.oui.image.a.values().length];
            r0[com.obric.oui.image.a.f35289b.ordinal()] = 1;
            r0[com.obric.oui.image.a.f35290c.ordinal()] = 2;
            f35298a = r0;
        }
    }

    public static final float a(com.obric.oui.image.a r1, float r2, float r3) {
        o.e(r1, "shape");
        int r4 = a.f35298a[r1.ordinal()];
        if (r4 != 1) goto L5;
        return r2;
    L5:
        if (r4 != 2) goto L8;
        return r3;
    L8:
        throw new k();
    }
}
