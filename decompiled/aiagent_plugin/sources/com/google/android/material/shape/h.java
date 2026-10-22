package com.google.android.material.shape;

/* JADX INFO: compiled from: MarkerEdgeTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f13545a;

    @Override // com.google.android.material.shape.f
    boolean g() {
        return true;
    }

    public h(float r2) {
        this.f13545a = r2 - 0.001f;
    }

    @Override // com.google.android.material.shape.f
    public void a(float r9, float r10, float r11, o r12) {
        float r13 = (float) ((((double) this.f13545a) * Math.sqrt(2.0d)) / 2.0d);
        float r14 = (float) Math.sqrt(Math.pow(this.f13545a, 2.0d) - Math.pow(r13, 2.0d));
        r12.a(r10 - r13, ((float) (-((((double) this.f13545a) * Math.sqrt(2.0d)) - ((double) this.f13545a)))) + r14);
        r12.b(r10, (float) (-((((double) this.f13545a) * Math.sqrt(2.0d)) - ((double) this.f13545a))));
        r12.b(r10 + r13, ((float) (-((((double) this.f13545a) * Math.sqrt(2.0d)) - ((double) this.f13545a)))) + r14);
    }
}
