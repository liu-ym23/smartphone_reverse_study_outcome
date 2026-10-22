package com.obric.common.oea.style.scene.qsanim.common;

/* JADX INFO: compiled from: KtExt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f32563a = null;

    static {
        f32563a = new b();
    }

    private b() {
    }

    public static /* synthetic */ float a(b r0, float r1, float r2, float r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 1.0f;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final float a(float r4, float r5, float r6) {
        boolean r3 = false;
        float r0 = 0;
        if (r5 < r0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L24;
        if (r6 >= r0) goto L10;
    L12:
        if (r3 == false) goto L22;
        if (r4 != 0.0f) goto L17;
        return 0.0f;
    L17:
        if (r5 != 0.0f) goto L20;
        return 0.0f;
    L20:
        return (1.0f - (1.0f / (((Math.abs(r4) * r6) / r5) + 1.0f))) * r5;
    L22:
        throw new IllegalArgumentException("factor must be in the range [0, 1]".toString());
    L10:
        if (r6 > 1.0f) goto L12;
        r3 = true;
        goto L12
    L24:
        throw new IllegalArgumentException("threshold must be non-negative".toString());
    L5:
        r1 = false;
        goto L6
    }
}
