package com.obric.oui.fluid;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FluidConfigCore.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f35254a;

    public b() {
        this(null);
    }

    public b(float[] r1) {
        this.f35254a = r1;
    }

    public float[] a() {
        return this.f35254a;
    }

    public b b() {
        return a(this);
    }

    public static b a(b r3) {
        float[] r0 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        float[] r4 = r3.f35254a;
        if (r4 == null) goto L9;
        r0 = (float[]) ZeusTransformUtils.preCheckCast(r4.clone(), float[].class, "com.obric.aiagent.plugin");
    L9:
        return new b(r0);
    }
}
