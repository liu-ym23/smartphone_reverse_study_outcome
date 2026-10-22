package com.obric.common.oea.foundation.animation.b;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f32329a = Float.MAX_VALUE;

    static {
    }

    public static final d a(float r5, float r6) {
        long r1 = Float.floatToRawIntBits(r5);
        return new d((((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r1 << 32));
    }

    public static final float a() {
        return f32329a;
    }
}
