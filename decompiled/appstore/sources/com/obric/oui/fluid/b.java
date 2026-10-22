package com.obric.oui.fluid;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f14567a;

    public b(float[] r10) {
        this.f14567a = r10;
    }

    public static b b(b r10) {
        float[] r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        float[] r12 = r10.f14567a;
        if (r12 == null) goto L9;
        r11 = (float[]) r12.clone();
    L9:
        return new b(r11);
    }

    public b a() {
        return b(this);
    }

    public float[] c() {
        return this.f14567a;
    }
}
