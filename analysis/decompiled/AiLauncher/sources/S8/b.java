package S8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f5652a;

    /* renamed from: b, reason: collision with root package name */
    public int f5653b;

    /* renamed from: c, reason: collision with root package name */
    public int f5654c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f5655d;

    /* renamed from: e, reason: collision with root package name */
    public int f5656e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5657f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5658g;

    /* renamed from: h, reason: collision with root package name */
    public int f5659h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f5660i;

    /* renamed from: j, reason: collision with root package name */
    public int f5661j;

    /* renamed from: k, reason: collision with root package name */
    public int f5662k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5663l;

    /* renamed from: m, reason: collision with root package name */
    public a f5664m;

    /* renamed from: n, reason: collision with root package name */
    public final io.objectbox.flatbuffers.b f5665n;

    public static abstract class a {
        public abstract ByteBuffer a(int i10);

        public void b(ByteBuffer byteBuffer) {
        }
    }

    /* renamed from: S8.b$b, reason: collision with other inner class name */
    public static final class C0100b extends a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0100b f5666a = new C0100b();

        @Override // S8.b.a
        public ByteBuffer a(int i10) {
            return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public b(int i10, a aVar, ByteBuffer byteBuffer, io.objectbox.flatbuffers.b bVar) {
        this.f5654c = 1;
        this.f5655d = null;
        this.f5656e = 0;
        this.f5657f = false;
        this.f5658g = false;
        this.f5660i = new int[16];
        this.f5661j = 0;
        this.f5662k = 0;
        this.f5663l = false;
        i10 = i10 <= 0 ? 1024 : i10;
        this.f5664m = aVar;
        if (byteBuffer != null) {
            this.f5652a = byteBuffer;
            byteBuffer.clear();
            this.f5652a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f5652a = aVar.a(i10);
        }
        this.f5665n = bVar;
        this.f5653b = this.f5652a.capacity();
    }

    public static ByteBuffer s(ByteBuffer byteBuffer, a aVar) {
        int i10;
        int iCapacity = byteBuffer.capacity();
        if (iCapacity == 0) {
            i10 = 1024;
        } else {
            i10 = 2147483639;
            if (iCapacity == 2147483639) {
                throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
            }
            if (((-1073741824) & iCapacity) == 0) {
                i10 = iCapacity << 1;
            }
        }
        byteBuffer.position(0);
        ByteBuffer byteBufferA = aVar.a(i10);
        byteBufferA.position(byteBufferA.clear().capacity() - iCapacity);
        byteBufferA.put(byteBuffer);
        return byteBufferA;
    }

    public void A(long j10) {
        ByteBuffer byteBuffer = this.f5652a;
        int i10 = this.f5653b - 8;
        this.f5653b = i10;
        byteBuffer.putLong(i10, j10);
    }

    public void B(short s10) {
        ByteBuffer byteBuffer = this.f5652a;
        int i10 = this.f5653b - 2;
        this.f5653b = i10;
        byteBuffer.putShort(i10, s10);
    }

    public byte[] C() {
        return D(this.f5653b, this.f5652a.capacity() - this.f5653b);
    }

    public byte[] D(int i10, int i11) {
        q();
        byte[] bArr = new byte[i11];
        this.f5652a.position(i10);
        this.f5652a.get(bArr);
        return bArr;
    }

    public void E(int i10) {
        this.f5655d[i10] = u();
    }

    public void F(int i10) {
        t();
        int[] iArr = this.f5655d;
        if (iArr == null || iArr.length < i10) {
            this.f5655d = new int[i10];
        }
        this.f5656e = i10;
        Arrays.fill(this.f5655d, 0, i10, 0);
        this.f5657f = true;
        this.f5659h = u();
    }

    public void G(int i10, int i11, int i12) {
        t();
        this.f5662k = i11;
        int i13 = i10 * i11;
        w(4, i13);
        w(i12, i13);
        this.f5657f = true;
    }

    public void a(int i10, boolean z10, boolean z11) {
        if (this.f5663l || z10 != z11) {
            b(z10);
            E(i10);
        }
    }

    public void b(boolean z10) {
        w(1, 0);
        x(z10);
    }

    public void c(byte b10) {
        w(1, 0);
        y(b10);
    }

    public void d(int i10) {
        w(4, 0);
        z(i10);
    }

    public void e(int i10, int i11, int i12) {
        if (this.f5663l || i11 != i12) {
            d(i11);
            E(i10);
        }
    }

    public void f(int i10, long j10, long j11) {
        if (this.f5663l || j10 != j11) {
            g(j10);
            E(i10);
        }
    }

    public void g(long j10) {
        w(8, 0);
        A(j10);
    }

    public void h(int i10) {
        w(4, 0);
        z((u() - i10) + 4);
    }

    public void i(int i10, int i11, int i12) {
        if (this.f5663l || i11 != i12) {
            h(i11);
            E(i10);
        }
    }

    public void j(int i10, short s10, int i11) {
        if (this.f5663l || s10 != i11) {
            k(s10);
            E(i10);
        }
    }

    public void k(short s10) {
        w(2, 0);
        B(s10);
    }

    public int l(CharSequence charSequence) {
        int iB = this.f5665n.b(charSequence);
        c((byte) 0);
        G(1, iB, 1);
        ByteBuffer byteBuffer = this.f5652a;
        int i10 = this.f5653b - iB;
        this.f5653b = i10;
        byteBuffer.position(i10);
        this.f5665n.a(charSequence, this.f5652a);
        return n();
    }

    public int m() {
        int i10;
        if (this.f5655d == null || !this.f5657f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        d(0);
        int iU = u();
        int i11 = this.f5656e - 1;
        while (i11 >= 0 && this.f5655d[i11] == 0) {
            i11--;
        }
        for (int i12 = i11; i12 >= 0; i12--) {
            int i13 = this.f5655d[i12];
            k((short) (i13 != 0 ? iU - i13 : 0));
        }
        k((short) (iU - this.f5659h));
        k((short) ((i11 + 3) * 2));
        int i14 = 0;
        loop2: while (true) {
            if (i14 >= this.f5661j) {
                i10 = 0;
                break;
            }
            int iCapacity = this.f5652a.capacity() - this.f5660i[i14];
            int i15 = this.f5653b;
            short s10 = this.f5652a.getShort(iCapacity);
            if (s10 == this.f5652a.getShort(i15)) {
                for (int i16 = 2; i16 < s10; i16 += 2) {
                    if (this.f5652a.getShort(iCapacity + i16) != this.f5652a.getShort(i15 + i16)) {
                        break;
                    }
                }
                i10 = this.f5660i[i14];
                break loop2;
            }
            i14++;
        }
        if (i10 != 0) {
            int iCapacity2 = this.f5652a.capacity() - iU;
            this.f5653b = iCapacity2;
            this.f5652a.putInt(iCapacity2, i10 - iU);
        } else {
            int i17 = this.f5661j;
            int[] iArr = this.f5660i;
            if (i17 == iArr.length) {
                this.f5660i = Arrays.copyOf(iArr, i17 * 2);
            }
            int[] iArr2 = this.f5660i;
            int i18 = this.f5661j;
            this.f5661j = i18 + 1;
            iArr2[i18] = u();
            ByteBuffer byteBuffer = this.f5652a;
            byteBuffer.putInt(byteBuffer.capacity() - iU, u() - iU);
        }
        this.f5657f = false;
        return iU;
    }

    public int n() {
        if (!this.f5657f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f5657f = false;
        z(this.f5662k);
        return u();
    }

    public void o(int i10) {
        p(i10, false);
    }

    public void p(int i10, boolean z10) {
        w(this.f5654c, (z10 ? 4 : 0) + 4);
        h(i10);
        if (z10) {
            d(this.f5652a.capacity() - this.f5653b);
        }
        this.f5652a.position(this.f5653b);
        this.f5658g = true;
    }

    public void q() {
        if (!this.f5658g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public b r(boolean z10) {
        this.f5663l = z10;
        return this;
    }

    public void t() {
        if (this.f5657f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int u() {
        return this.f5652a.capacity() - this.f5653b;
    }

    public void v(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBuffer = this.f5652a;
            int i12 = this.f5653b - 1;
            this.f5653b = i12;
            byteBuffer.put(i12, (byte) 0);
        }
    }

    public void w(int i10, int i11) {
        if (i10 > this.f5654c) {
            this.f5654c = i10;
        }
        int i12 = ((~((this.f5652a.capacity() - this.f5653b) + i11)) + 1) & (i10 - 1);
        while (this.f5653b < i12 + i10 + i11) {
            int iCapacity = this.f5652a.capacity();
            ByteBuffer byteBuffer = this.f5652a;
            ByteBuffer byteBufferS = s(byteBuffer, this.f5664m);
            this.f5652a = byteBufferS;
            if (byteBuffer != byteBufferS) {
                this.f5664m.b(byteBuffer);
            }
            this.f5653b += this.f5652a.capacity() - iCapacity;
        }
        v(i12);
    }

    public void x(boolean z10) {
        ByteBuffer byteBuffer = this.f5652a;
        int i10 = this.f5653b - 1;
        this.f5653b = i10;
        byteBuffer.put(i10, z10 ? (byte) 1 : (byte) 0);
    }

    public void y(byte b10) {
        ByteBuffer byteBuffer = this.f5652a;
        int i10 = this.f5653b - 1;
        this.f5653b = i10;
        byteBuffer.put(i10, b10);
    }

    public void z(int i10) {
        ByteBuffer byteBuffer = this.f5652a;
        int i11 = this.f5653b - 4;
        this.f5653b = i11;
        byteBuffer.putInt(i11, i10);
    }

    public b(int i10) {
        this(i10, C0100b.f5666a, null, io.objectbox.flatbuffers.b.c());
    }

    public b() {
        this(1024);
    }
}
