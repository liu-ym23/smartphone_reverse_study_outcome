package androidx.recyclerview.base;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f4007e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f4010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f4011d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.base.b$b, reason: collision with other inner class name */
    public static final class C0041b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f4012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4013b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f4014c;

        public C0041b(float r10, float r11, boolean r12) {
            this.f4012a = r10;
            this.f4013b = r11;
            this.f4014c = r12;
        }

        public final float a() {
            return this.f4012a;
        }

        public final float b() {
            return this.f4013b;
        }

        public final boolean c() {
            return this.f4014c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0041b) == true) goto L8;
            return false;
        L8:
            C0041b r11 = (C0041b) r10;
            if (q.b(Float.valueOf(this.f4012a), Float.valueOf(r11.f4012a)) == true) goto L12;
            return false;
        L12:
            if (q.b(Float.valueOf(this.f4013b), Float.valueOf(r11.f4013b)) == true) goto L15;
            return false;
        L15:
            if (this.f4014c == r11.f4014c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r10 = ((Float.hashCode(this.f4012a) * 31) + Float.hashCode(this.f4013b)) * 31;
            boolean r11 = this.f4014c;
            ?? r12 = r11;
            if (r11 == false) goto L6;
            r12 = 1;
        L6:
            return r10 + r12;
        }

        public String toString() {
            return "ScrollValue(value=" + this.f4012a + ", velocity=" + this.f4013b + ", isFinished=" + this.f4014c + ')';
        }
    }

    static {
        f4007e = new a(null);
    }

    public b(float r10) {
        this.f4008a = r10;
        this.f4011d = 0.099999994f;
    }

    public final float a() {
        float r10 = Math.abs(this.f4010c);
        float r11 = this.f4011d;
        if (r10 >= r11) goto L7;
        return 0.0f;
    L7:
        return c(((float) Math.log(r11 / Math.abs(this.f4010c))) / ((float) Math.log(this.f4008a)));
    }

    public final void b(float r10, float r11) {
        this.f4009b = r10;
        this.f4010c = r11;
    }

    public final float c(float r10) {
        return this.f4009b + (((this.f4010c * (1.0f / ((float) Math.log(this.f4008a)))) * (((float) Math.pow(this.f4008a, r10)) - 1.0f)) * 1.1111112f);
    }

    public final C0041b d(float r10) {
        float r11 = e(r10);
        float r12 = c(r10);
        if (Math.abs(r11) >= this.f4011d) goto L5;
        boolean r13 = true;
    L7:
        return new C0041b(r12, r11, r13);
    L5:
        r13 = false;
        goto L7
    }

    public final float e(float r10) {
        return this.f4010c * ((float) Math.pow(this.f4008a, r10));
    }

    public /* synthetic */ b(float r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 0.998f;
    L5:
        this(r10);
    }
}
