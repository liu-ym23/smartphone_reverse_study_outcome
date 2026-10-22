package com.obric.oui.blur;

/* JADX INFO: compiled from: BlurConfigCore.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f34066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f34068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f34070e;

    public b() {
        this(0.0f, 0, 1.0f, 0, 1.0f);
    }

    public b(float r1, int r2, float r3, int r4, float r5) {
        this.f34066a = r1;
        this.f34067b = r2;
        this.f34068c = r3;
        this.f34069d = r4;
        this.f34070e = r5;
    }

    public float a() {
        return this.f34066a;
    }

    public int b() {
        return this.f34067b;
    }

    public float c() {
        return this.f34068c;
    }

    public int d() {
        return this.f34069d;
    }

    public float e() {
        return this.f34070e;
    }

    public b f() {
        return a(this);
    }

    public static b a(b r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        return new b(r7.f34066a, r7.f34067b, r7.f34068c, r7.f34069d, r7.f34070e);
    }
}
