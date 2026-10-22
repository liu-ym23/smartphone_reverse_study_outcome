package com.obric.oui.orecyclerview.base;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f15362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f15363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f15364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f15365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f15366e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f15367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f15368b;

        public a(float r10, boolean r11) {
            this.f15367a = r10;
            this.f15368b = r11;
        }

        public final float a() {
            return this.f15367a;
        }

        public final boolean b() {
            return this.f15368b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(Float.valueOf(this.f15367a), Float.valueOf(r11.f15367a)) == true) goto L12;
            return false;
        L12:
            if (this.f15368b == r11.f15368b) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int r10 = Float.hashCode(this.f15367a) * 31;
            boolean r11 = this.f15368b;
            ?? r12 = r11;
            if (r11 == false) goto L6;
            r12 = 1;
        L6:
            return r10 + r12;
        }

        public String toString() {
            return "SpringBackValue(value=" + this.f15367a + ", isFinished=" + this.f15368b + ')';
        }
    }

    public d() {
        this.f15365d = 0.1f;
        this.f15366e = 0.01f;
    }

    public final void a(float r10, float r11) {
        this.f15364c = 10.927279f;
        this.f15362a = r11;
        this.f15363b = (r10 * 1000.0f) + (10.927279f * r11);
    }

    public final a b(float r10) {
        float r11 = r10 / 1000.0f;
        float r12 = (this.f15362a + (this.f15363b * r11)) * ((float) Math.exp((-this.f15364c) * r11));
        float r13 = c(r11);
        if (Math.abs(r12) >= this.f15365d) goto L8;
        if ((Math.abs(r13) / 1000.0f) >= this.f15366e) goto L8;
        return new a(0.0f, true);
    L8:
        return new a(r12, false);
    }

    public final float c(float r10) {
        float r11 = this.f15363b;
        float r12 = this.f15364c;
        return (r11 - ((this.f15362a + (r11 * r10)) * r12)) * ((float) Math.exp((-r12) * r10));
    }
}
