package com.google.android.material.shape;

/* JADX INFO: compiled from: OffsetEdgeTreatment.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f13546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f13547b;

    public j(f r1, float r2) {
        this.f13546a = r1;
        this.f13547b = r2;
    }

    @Override // com.google.android.material.shape.f
    public void a(float r2, float r3, float r4, o r5) {
        this.f13546a.a(r2, r3 - this.f13547b, r4, r5);
    }

    @Override // com.google.android.material.shape.f
    boolean g() {
        return this.f13546a.g();
    }
}
