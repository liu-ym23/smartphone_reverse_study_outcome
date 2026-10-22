package a2;

import androidx.datastore.preferences.protobuf.z;
import com.google.crypto.tink.shaded.protobuf.c0;
import com.google.crypto.tink.shaded.protobuf.h;
import com.google.crypto.tink.shaded.protobuf.j;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public int f85a;

    /* renamed from: b, reason: collision with root package name */
    public Object f86b;

    public static int d(int i8) {
        return (-(i8 & 1)) ^ (i8 >>> 1);
    }

    public static long e(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static j h(byte[] bArr, int i8, int i9, boolean z) {
        j jVar = new j(bArr, i8, i9, z);
        try {
            jVar.l(i9);
            return jVar;
        } catch (c0 e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public abstract String A();

    public abstract String B();

    public abstract int C();

    public abstract int D();

    public abstract long E();

    public abstract boolean F(int i8);

    public void G() {
        int iC;
        do {
            iC = C();
            if (iC == 0) {
                return;
            }
            int i8 = this.f85a;
            if (i8 >= 100) {
                throw new z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.f85a = i8 + 1;
            this.f85a--;
        } while (F(iC));
    }

    public ByteBuffer a(byte[] bArr, int i8) {
        int[] iArrC = c(i8, a.c(bArr));
        int[] iArr = (int[]) iArrC.clone();
        a.b(iArr);
        for (int i9 = 0; i9 < iArrC.length; i9++) {
            iArrC[i9] = iArrC[i9] + iArr[i9];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrC, 0, 16);
        return byteBufferOrder;
    }

    public abstract void b(int i8);

    public abstract int[] c(int i8, int[] iArr);

    public abstract int f();

    public abstract boolean g();

    public abstract int i();

    public abstract void j(int i8);

    public void k(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != i()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + i());
        }
        int iRemaining = byteBuffer2.remaining();
        int i8 = iRemaining / 64;
        int i9 = i8 + 1;
        for (int i10 = 0; i10 < i9; i10++) {
            ByteBuffer byteBufferA = a(bArr, this.f85a + i10);
            if (i10 == i8) {
                v.t0(byteBuffer, byteBuffer2, byteBufferA, iRemaining % 64);
            } else {
                v.t0(byteBuffer, byteBuffer2, byteBufferA, 64);
            }
        }
    }

    public abstract int l(int i8);

    public abstract boolean m();

    public abstract androidx.datastore.preferences.protobuf.g n();

    public abstract h o();

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
