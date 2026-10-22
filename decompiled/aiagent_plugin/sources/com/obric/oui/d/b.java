package com.obric.oui.d;

import d.l.n;

/* JADX INFO: compiled from: AnimUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f35011a = null;

    static {
        f35011a = new b();
    }

    public static final float a(float r0, float r1, float r2) {
        return (r0 - r1) / (r2 - r1);
    }

    public static final int a(float r7, int r8, int r9) {
        int r0 = (r8 >> 24) & 255;
        int r1 = (r8 >> 16) & 255;
        int r2 = (r8 >> 8) & 255;
        int r10 = r8 & 255;
        return ((int) (r10 + (r7 * ((r9 & 255) - r10)))) | (((((int) (r0 + ((((r9 >> 24) & 255) - r0) * r7))) << 24) | (((int) (r1 + ((((r9 >> 16) & 255) - r1) * r7))) << 16)) | (((int) (r2 + ((((r9 >> 8) & 255) - r2) * r7))) << 8));
    }

    public static final float b(float r0, float r1, float r2) {
        return r0 + ((r1 - r0) * r2);
    }

    public static final float c(float r1, float r2, float r3) {
        if (r2 != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return 0.0f;
    L10:
        return (r1 - r2) / (r3 - r2);
    L5:
        r0 = false;
        goto L6
    }

    private b() {
    }

    public static final float a(float r1, float r2, float r3, float r4, float r5) {
        if (r2 >= r3) goto L5;
        float r6 = n.a(r1, r2, r3);
    L7:
        return b(r4, r5, c(r6, r2, r3));
    L5:
        r6 = n.a(r1, r3, r2);
        goto L7
    }
}
