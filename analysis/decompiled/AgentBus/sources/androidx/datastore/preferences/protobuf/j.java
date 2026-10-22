package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public int f881a;

    /* renamed from: b, reason: collision with root package name */
    public Object f882b;

    public static int d(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    public static long e(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static com.google.crypto.tink.shaded.protobuf.i h(byte[] bArr, int i2, int i10, boolean z4) {
        com.google.crypto.tink.shaded.protobuf.i iVar = new com.google.crypto.tink.shaded.protobuf.i(bArr, i2, i10, z4);
        try {
            iVar.l(i10);
            return iVar;
        } catch (com.google.crypto.tink.shaded.protobuf.b0 e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i2);

    public ByteBuffer a(int i2, byte[] bArr) {
        int[] iArrC = c(i2, v3.a.c(bArr));
        int[] iArr = (int[]) iArrC.clone();
        v3.a.b(iArr);
        for (int i10 = 0; i10 < iArrC.length; i10++) {
            iArrC[i10] = iArrC[i10] + iArr[i10];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrC, 0, 16);
        return byteBufferOrder;
    }

    public abstract void b(int i2);

    public abstract int[] c(int i2, int[] iArr);

    public abstract int f();

    public abstract boolean g();

    public abstract int i();

    public abstract void j(int i2);

    public void k(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != i()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + i());
        }
        int iRemaining = byteBuffer2.remaining();
        int i2 = iRemaining / 64;
        int i10 = i2 + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBufferA = a(this.f881a + i11, bArr);
            if (i11 == i2) {
                w7.e0.P(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                w7.e0.P(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }

    public abstract int l(int i2);

    public abstract boolean m();

    public abstract g n();

    public abstract com.google.crypto.tink.shaded.protobuf.g o();

    public abstract double p();

    public abstract int q();

    public abstract int r();

    public abstract long s();

    public abstract float t();

    public abstract int u();

    public abstract long v();

    public abstract int w();

    public abstract long x();

    public abstract int y();

    public abstract long z();
}
