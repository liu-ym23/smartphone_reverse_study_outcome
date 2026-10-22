package D;

import android.graphics.Matrix;

/* renamed from: D.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0766e extends Z {

    /* renamed from: a, reason: collision with root package name */
    public final K.E0 f2091a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2092b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2093c;

    /* renamed from: d, reason: collision with root package name */
    public final Matrix f2094d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2095e;

    public C0766e(K.E0 e02, long j10, int i10, Matrix matrix, int i11) {
        if (e02 == null) {
            throw new NullPointerException("Null tagBundle");
        }
        this.f2091a = e02;
        this.f2092b = j10;
        this.f2093c = i10;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransformMatrix");
        }
        this.f2094d = matrix;
        this.f2095e = i11;
    }

    @Override // D.Z, D.T
    public int a() {
        return this.f2095e;
    }

    @Override // D.Z
    public Matrix d() {
        return this.f2094d;
    }

    @Override // D.Z, D.T
    public K.E0 e() {
        return this.f2091a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Z) {
            Z z10 = (Z) obj;
            if (this.f2091a.equals(z10.e()) && this.f2092b == z10.getTimestamp() && this.f2093c == z10.f() && this.f2094d.equals(z10.d()) && this.f2095e == z10.a()) {
                return true;
            }
        }
        return false;
    }

    @Override // D.Z, D.T
    public int f() {
        return this.f2093c;
    }

    @Override // D.Z, D.T
    public long getTimestamp() {
        return this.f2092b;
    }

    public int hashCode() {
        int iHashCode = (this.f2091a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f2092b;
        return this.f2095e ^ ((((((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ this.f2093c) * 1000003) ^ this.f2094d.hashCode()) * 1000003);
    }

    public String toString() {
        return "ImmutableImageInfo{tagBundle=" + this.f2091a + ", timestamp=" + this.f2092b + ", rotationDegrees=" + this.f2093c + ", sensorToBufferTransformMatrix=" + this.f2094d + ", flashState=" + this.f2095e + "}";
    }
}
