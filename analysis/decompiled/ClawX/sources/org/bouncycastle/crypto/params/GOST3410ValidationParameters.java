package org.bouncycastle.crypto.params;

/* loaded from: classes.dex */
public class GOST3410ValidationParameters {

    /* renamed from: c, reason: collision with root package name */
    private int f4566c;
    private long cL;

    /* renamed from: x0, reason: collision with root package name */
    private int f4567x0;
    private long x0L;

    public GOST3410ValidationParameters(int i8, int i9) {
        this.f4567x0 = i8;
        this.f4566c = i9;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        return gOST3410ValidationParameters.f4566c == this.f4566c && gOST3410ValidationParameters.f4567x0 == this.f4567x0 && gOST3410ValidationParameters.cL == this.cL && gOST3410ValidationParameters.x0L == this.x0L;
    }

    public int getC() {
        return this.f4566c;
    }

    public long getCL() {
        return this.cL;
    }

    public int getX0() {
        return this.f4567x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int i8 = this.f4567x0 ^ this.f4566c;
        long j4 = this.x0L;
        int i9 = (i8 ^ ((int) j4)) ^ ((int) (j4 >> 32));
        long j8 = this.cL;
        return (((int) j8) ^ i9) ^ ((int) (j8 >> 32));
    }

    public GOST3410ValidationParameters(long j4, long j8) {
        this.x0L = j4;
        this.cL = j8;
    }
}
