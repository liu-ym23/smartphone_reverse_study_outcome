package com.google.protobuf;

/* renamed from: com.google.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0972o {

    /* renamed from: a, reason: collision with root package name */
    public int f2933a;
    public C0976p b;

    public static int c(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long d(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static C0960l h(byte[] bArr, int i, int i6, boolean z10) {
        C0960l c0960l = new C0960l(bArr, i, i6, z10);
        try {
            c0960l.j(i6);
            return c0960l;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract long A();

    public abstract String B();

    public abstract String C();

    public abstract int D();

    public abstract int E();

    public abstract long F();

    public abstract boolean G(int i);

    public abstract void a(int i);

    public final void b() {
        if (this.f2933a >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
    }

    public abstract int e();

    public abstract int f();

    public abstract boolean g();

    public abstract void i(int i);

    public abstract int j(int i);

    public abstract boolean k();

    public abstract ByteString l();

    public abstract double m();

    public abstract int n();

    public abstract int o();

    public abstract long p();

    public abstract float q();

    public abstract void r(int i, W1 w12, R0 r02);

    public abstract int s();

    public abstract long t();

    public abstract X1 u(InterfaceC0955j2 interfaceC0955j2, R0 r02);

    public abstract void v(W1 w12, R0 r02);

    public abstract int w();

    public abstract int x();

    public abstract long y();

    public abstract int z();
}
