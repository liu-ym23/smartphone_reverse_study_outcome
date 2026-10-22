package com.obric.common.oea.foundation.animation.i;

/* JADX INFO: compiled from: FloatFloatPair.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32449a;

    public a(long r1) {
        this.f32449a = r1;
    }

    public String toString() {
        return '(' + Float.intBitsToFloat((int) (this.f32449a >> 32)) + ", " + Float.intBitsToFloat((int) (this.f32449a & 4294967295L)) + ')';
    }

    public a(float r5, float r6) {
        long r0 = Float.floatToRawIntBits(r5);
        this((((long) Float.floatToRawIntBits(r6)) & 4294967295L) | (r0 << 32));
    }
}
