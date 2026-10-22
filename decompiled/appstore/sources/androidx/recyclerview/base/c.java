package androidx.recyclerview.base;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f4019e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f4020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f4021b;

        public a(float r10, boolean r11) {
            this.f4020a = r10;
            this.f4021b = r11;
        }

        public final float a() {
            return this.f4020a;
        }

        public final boolean b() {
            return this.f4021b;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (q.b(Float.valueOf(this.f4020a), Float.valueOf(r11.f4020a)) == true) goto L12;
            return false;
        L12:
            if (this.f4021b == r11.f4021b) goto L14;
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
            int r10 = Float.hashCode(this.f4020a) * 31;
            boolean r11 = this.f4021b;
            ?? r12 = r11;
            if (r11 == false) goto L6;
            r12 = 1;
        L6:
            return r10 + r12;
        }

        public String toString() {
            return "SpringBackValue(value=" + this.f4020a + ", isFinished=" + this.f4021b + ')';
        }
    }

    public c() {
        this.f4018d = 0.1f;
        this.f4019e = 0.01f;
    }

    public final void a(float r10, float r11) {
        this.f4017c = 10.927279f;
        this.f4015a = r11;
        this.f4016b = (r10 * 1000.0f) + (10.927279f * r11);
    }

    public final a b(float r10) {
        float r11 = r10 / 1000.0f;
        float r12 = (this.f4015a + (this.f4016b * r11)) * ((float) Math.exp((-this.f4017c) * r11));
        float r13 = c(r11);
        if (Math.abs(r12) >= this.f4018d) goto L8;
        if ((Math.abs(r13) / 1000.0f) >= this.f4019e) goto L8;
        return new a(0.0f, true);
    L8:
        return new a(r12, false);
    }

    public final float c(float r10) {
        float r11 = this.f4016b;
        float r12 = this.f4017c;
        return (r11 - ((this.f4015a + (r11 * r10)) * r12)) * ((float) Math.exp((-r12) * r10));
    }
}
