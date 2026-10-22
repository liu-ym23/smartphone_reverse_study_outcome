package pc;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f23441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f23443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f23445e;

    public a(float r10, int r11, float r12, int r13, float r14) {
        this.f23441a = r10;
        this.f23442b = r11;
        this.f23443c = r12;
        this.f23444d = r13;
        this.f23445e = r14;
    }

    public final float a() {
        return this.f23443c;
    }

    public final float b() {
        return this.f23441a;
    }

    public final int c() {
        return this.f23444d;
    }

    public final int d() {
        return this.f23442b;
    }

    public final float e() {
        return this.f23445e;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (q.b(Float.valueOf(this.f23441a), Float.valueOf(r11.f23441a)) == true) goto L12;
        return false;
    L12:
        if (this.f23442b == r11.f23442b) goto L15;
        return false;
    L15:
        if (q.b(Float.valueOf(this.f23443c), Float.valueOf(r11.f23443c)) == true) goto L18;
        return false;
    L18:
        if (this.f23444d == r11.f23444d) goto L21;
        return false;
    L21:
        if (q.b(Float.valueOf(this.f23445e), Float.valueOf(r11.f23445e)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final void f(float r10) {
        this.f23441a = r10;
    }

    public final void g(int r10) {
        this.f23442b = r10;
    }

    public final b h() {
        return new b(this.f23441a, this.f23442b, this.f23443c, this.f23444d, this.f23445e);
    }

    public int hashCode() {
        return (((((((Float.hashCode(this.f23441a) * 31) + Integer.hashCode(this.f23442b)) * 31) + Float.hashCode(this.f23443c)) * 31) + Integer.hashCode(this.f23444d)) * 31) + Float.hashCode(this.f23445e);
    }

    public String toString() {
        return "BlurConfig(blurRadius=" + this.f23441a + ", direction=" + this.f23442b + ", alpha=" + this.f23443c + ", curveType=" + this.f23444d + ", endPoint=" + this.f23445e + ')';
    }

    public /* synthetic */ a(float r10, int r11, float r12, int r13, float r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        r10 = 0.0f;
    L5:
        int r17 = 0;
        if ((r15 & 2) == 0) goto L8;
        int r18 = 0;
    L9:
        float r19 = 1.0f;
        if ((r15 & 4) == 0) goto L12;
        float r20 = 1.0f;
    L14:
        if ((r15 & 8) != 0) goto L18;
        r17 = r13;
    L18:
        if ((r15 & 16) != 0) goto L21;
        r19 = r14;
    L21:
        this(r10, r18, r20, r17, r19);
        return;
    L12:
        r20 = r12;
        goto L14
    L8:
        r18 = r11;
        goto L9
    }
}
