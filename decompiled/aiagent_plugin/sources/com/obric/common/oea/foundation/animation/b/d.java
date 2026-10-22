package com.obric.common.oea.foundation.animation.b;

/* JADX INFO: compiled from: SpringSimulation.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f32323a;

    public d(long r1) {
        this.f32323a = r1;
    }

    public final float a() {
        return Float.intBitsToFloat((int) (this.f32323a >> 32));
    }

    public final float b() {
        return Float.intBitsToFloat((int) (this.f32323a & 4294967295L));
    }
}
