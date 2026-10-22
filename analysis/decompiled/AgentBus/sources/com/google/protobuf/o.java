package com.google.protobuf;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public int f2464a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.datastore.preferences.protobuf.k f2465b;

    public static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long c(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static m f(byte[] bArr, int i2, int i10, boolean z4) {
        m mVar = new m(bArr, i2, i10, z4);
        try {
            mVar.h(i10);
            return mVar;
        } catch (r2 e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract boolean A(int i2);

    public final void B() throws r2 {
        int iX;
        do {
            iX = x();
            if (iX == 0) {
                return;
            }
            int i2 = this.f2464a;
            if (i2 >= 100) {
                throw new r2("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.f2464a = i2 + 1;
            this.f2464a--;
        } while (A(iX));
    }

    public abstract void a(int i2);

    public abstract int d();

    public abstract boolean e();

    public abstract void g(int i2);

    public abstract int h(int i2);

    public abstract boolean i();

    public abstract k j();

    public abstract double k();

    public abstract int l();

    public abstract int m();

    public abstract long n();

    public abstract float o();

    public abstract int p();

    public abstract long q();

    public abstract int r();

    public abstract long s();

    public abstract int t();

    public abstract long u();

    public abstract String v();

    public abstract String w();

    public abstract int x();

    public abstract int y();

    public abstract long z();
}
