package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends AbstractC1344g {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f13422c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f13423d = j0.C();

    /* renamed from: a, reason: collision with root package name */
    public C1347j f13424a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13425b;

    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static abstract class b extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f13426e;

        /* renamed from: f, reason: collision with root package name */
        public final int f13427f;

        /* renamed from: g, reason: collision with root package name */
        public int f13428g;

        /* renamed from: h, reason: collision with root package name */
        public int f13429h;

        public b(int i10) {
            super();
            if (i10 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i10, 20)];
            this.f13426e = bArr;
            this.f13427f = bArr.length;
        }

        public final void b1(byte b10) {
            byte[] bArr = this.f13426e;
            int i10 = this.f13428g;
            this.f13428g = i10 + 1;
            bArr[i10] = b10;
            this.f13429h++;
        }

        public final void c1(int i10) {
            byte[] bArr = this.f13426e;
            int i11 = this.f13428g;
            int i12 = i11 + 1;
            this.f13428g = i12;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i11 + 2;
            this.f13428g = i13;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i11 + 3;
            this.f13428g = i14;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f13428g = i11 + 4;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
            this.f13429h += 4;
        }

        public final void d1(long j10) {
            byte[] bArr = this.f13426e;
            int i10 = this.f13428g;
            int i11 = i10 + 1;
            this.f13428g = i11;
            bArr[i10] = (byte) (j10 & 255);
            int i12 = i10 + 2;
            this.f13428g = i12;
            bArr[i11] = (byte) ((j10 >> 8) & 255);
            int i13 = i10 + 3;
            this.f13428g = i13;
            bArr[i12] = (byte) ((j10 >> 16) & 255);
            int i14 = i10 + 4;
            this.f13428g = i14;
            bArr[i13] = (byte) (255 & (j10 >> 24));
            int i15 = i10 + 5;
            this.f13428g = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i10 + 6;
            this.f13428g = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i10 + 7;
            this.f13428g = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f13428g = i10 + 8;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            this.f13429h += 8;
        }

        public final void e1(int i10) {
            if (i10 >= 0) {
                g1(i10);
            } else {
                h1(i10);
            }
        }

        public final void f1(int i10, int i11) {
            g1(WireFormat.c(i10, i11));
        }

        public final void g1(int i10) {
            if (!CodedOutputStream.f13423d) {
                while ((i10 & (-128)) != 0) {
                    byte[] bArr = this.f13426e;
                    int i11 = this.f13428g;
                    this.f13428g = i11 + 1;
                    bArr[i11] = (byte) ((i10 & 127) | 128);
                    this.f13429h++;
                    i10 >>>= 7;
                }
                byte[] bArr2 = this.f13426e;
                int i12 = this.f13428g;
                this.f13428g = i12 + 1;
                bArr2[i12] = (byte) i10;
                this.f13429h++;
                return;
            }
            long j10 = this.f13428g;
            while ((i10 & (-128)) != 0) {
                byte[] bArr3 = this.f13426e;
                int i13 = this.f13428g;
                this.f13428g = i13 + 1;
                j0.H(bArr3, i13, (byte) ((i10 & 127) | 128));
                i10 >>>= 7;
            }
            byte[] bArr4 = this.f13426e;
            int i14 = this.f13428g;
            this.f13428g = i14 + 1;
            j0.H(bArr4, i14, (byte) i10);
            this.f13429h += (int) (this.f13428g - j10);
        }

        public final void h1(long j10) {
            if (!CodedOutputStream.f13423d) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f13426e;
                    int i10 = this.f13428g;
                    this.f13428g = i10 + 1;
                    bArr[i10] = (byte) ((((int) j10) & 127) | 128);
                    this.f13429h++;
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f13426e;
                int i11 = this.f13428g;
                this.f13428g = i11 + 1;
                bArr2[i11] = (byte) j10;
                this.f13429h++;
                return;
            }
            long j11 = this.f13428g;
            while ((j10 & (-128)) != 0) {
                byte[] bArr3 = this.f13426e;
                int i12 = this.f13428g;
                this.f13428g = i12 + 1;
                j0.H(bArr3, i12, (byte) ((((int) j10) & 127) | 128));
                j10 >>>= 7;
            }
            byte[] bArr4 = this.f13426e;
            int i13 = this.f13428g;
            this.f13428g = i13 + 1;
            j0.H(bArr4, i13, (byte) j10);
            this.f13429h += (int) (this.f13428g - j11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int i0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class c extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f13430e;

        /* renamed from: f, reason: collision with root package name */
        public final int f13431f;

        /* renamed from: g, reason: collision with root package name */
        public final int f13432g;

        /* renamed from: h, reason: collision with root package name */
        public int f13433h;

        public c(byte[] bArr, int i10, int i11) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i12 = i10 + i11;
            if ((i10 | i11 | (bArr.length - i12)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)));
            }
            this.f13430e = bArr;
            this.f13431f = i10;
            this.f13433h = i10;
            this.f13432g = i12;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void E0(int i10, int i11) throws IOException {
            W0(i10, 0);
            F0(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void F0(int i10) throws IOException {
            if (i10 >= 0) {
                Y0(i10);
            } else {
                a1(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void I0(int i10, K k10, Z z10) throws IOException {
            W0(i10, 2);
            Y0(((AbstractC1338a) k10).d(z10));
            z10.b(k10, this.f13424a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void J0(K k10) throws IOException {
            Y0(k10.getSerializedSize());
            k10.a(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void K0(int i10, K k10) throws IOException {
            W0(1, 3);
            X0(2, i10);
            c1(3, k10);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void L0(int i10, ByteString byteString) throws IOException {
            W0(1, 3);
            X0(2, i10);
            o0(3, byteString);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void U0(int i10, String str) throws IOException {
            W0(i10, 2);
            V0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void V0(String str) throws IOException {
            int i10 = this.f13433h;
            try {
                int iX = CodedOutputStream.X(str.length() * 3);
                int iX2 = CodedOutputStream.X(str.length());
                if (iX2 != iX) {
                    Y0(Utf8.g(str));
                    this.f13433h = Utf8.f(str, this.f13430e, this.f13433h, i0());
                    return;
                }
                int i11 = i10 + iX2;
                this.f13433h = i11;
                int iF = Utf8.f(str, this.f13430e, i11, i0());
                this.f13433h = i10;
                Y0((iF - i10) - iX2);
                this.f13433h = iF;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.f13433h = i10;
                d0(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void W0(int i10, int i11) throws IOException {
            Y0(WireFormat.c(i10, i11));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void X0(int i10, int i11) throws IOException {
            W0(i10, 0);
            Y0(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void Y0(int i10) throws IOException {
            if (!CodedOutputStream.f13423d || C1341d.c() || i0() < 5) {
                while ((i10 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f13430e;
                        int i11 = this.f13433h;
                        this.f13433h = i11 + 1;
                        bArr[i11] = (byte) ((i10 & 127) | 128);
                        i10 >>>= 7;
                    } catch (IndexOutOfBoundsException e10) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13433h), Integer.valueOf(this.f13432g), 1), e10);
                    }
                }
                byte[] bArr2 = this.f13430e;
                int i12 = this.f13433h;
                this.f13433h = i12 + 1;
                bArr2[i12] = (byte) i10;
                return;
            }
            if ((i10 & (-128)) == 0) {
                byte[] bArr3 = this.f13430e;
                int i13 = this.f13433h;
                this.f13433h = i13 + 1;
                j0.H(bArr3, i13, (byte) i10);
                return;
            }
            byte[] bArr4 = this.f13430e;
            int i14 = this.f13433h;
            this.f13433h = i14 + 1;
            j0.H(bArr4, i14, (byte) (i10 | 128));
            int i15 = i10 >>> 7;
            if ((i15 & (-128)) == 0) {
                byte[] bArr5 = this.f13430e;
                int i16 = this.f13433h;
                this.f13433h = i16 + 1;
                j0.H(bArr5, i16, (byte) i15);
                return;
            }
            byte[] bArr6 = this.f13430e;
            int i17 = this.f13433h;
            this.f13433h = i17 + 1;
            j0.H(bArr6, i17, (byte) (i15 | 128));
            int i18 = i10 >>> 14;
            if ((i18 & (-128)) == 0) {
                byte[] bArr7 = this.f13430e;
                int i19 = this.f13433h;
                this.f13433h = i19 + 1;
                j0.H(bArr7, i19, (byte) i18);
                return;
            }
            byte[] bArr8 = this.f13430e;
            int i20 = this.f13433h;
            this.f13433h = i20 + 1;
            j0.H(bArr8, i20, (byte) (i18 | 128));
            int i21 = i10 >>> 21;
            if ((i21 & (-128)) == 0) {
                byte[] bArr9 = this.f13430e;
                int i22 = this.f13433h;
                this.f13433h = i22 + 1;
                j0.H(bArr9, i22, (byte) i21);
                return;
            }
            byte[] bArr10 = this.f13430e;
            int i23 = this.f13433h;
            this.f13433h = i23 + 1;
            j0.H(bArr10, i23, (byte) (i21 | 128));
            byte[] bArr11 = this.f13430e;
            int i24 = this.f13433h;
            this.f13433h = i24 + 1;
            j0.H(bArr11, i24, (byte) (i10 >>> 28));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void Z0(int i10, long j10) throws IOException {
            W0(i10, 0);
            a1(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.AbstractC1344g
        public final void a(byte[] bArr, int i10, int i11) throws IOException {
            b1(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void a1(long j10) throws IOException {
            if (CodedOutputStream.f13423d && i0() >= 10) {
                while ((j10 & (-128)) != 0) {
                    byte[] bArr = this.f13430e;
                    int i10 = this.f13433h;
                    this.f13433h = i10 + 1;
                    j0.H(bArr, i10, (byte) ((((int) j10) & 127) | 128));
                    j10 >>>= 7;
                }
                byte[] bArr2 = this.f13430e;
                int i11 = this.f13433h;
                this.f13433h = i11 + 1;
                j0.H(bArr2, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f13430e;
                    int i12 = this.f13433h;
                    this.f13433h = i12 + 1;
                    bArr3[i12] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13433h), Integer.valueOf(this.f13432g), 1), e10);
                }
            }
            byte[] bArr4 = this.f13430e;
            int i13 = this.f13433h;
            this.f13433h = i13 + 1;
            bArr4[i13] = (byte) j10;
        }

        public final void b1(byte[] bArr, int i10, int i11) throws IOException {
            try {
                System.arraycopy(bArr, i10, this.f13430e, this.f13433h, i11);
                this.f13433h += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13433h), Integer.valueOf(this.f13432g), Integer.valueOf(i11)), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void c0() {
        }

        public final void c1(int i10, K k10) throws IOException {
            W0(i10, 2);
            J0(k10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final int i0() {
            return this.f13432g - this.f13433h;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j0(byte b10) throws IOException {
            try {
                byte[] bArr = this.f13430e;
                int i10 = this.f13433h;
                this.f13433h = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13433h), Integer.valueOf(this.f13432g), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(int i10, boolean z10) throws IOException {
            W0(i10, 0);
            j0(z10 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void n0(byte[] bArr, int i10, int i11) throws IOException {
            Y0(i11);
            b1(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void o0(int i10, ByteString byteString) throws IOException {
            W0(i10, 2);
            p0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void p0(ByteString byteString) throws IOException {
            Y0(byteString.size());
            byteString.L(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void u0(int i10, int i11) throws IOException {
            W0(i10, 5);
            v0(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void v0(int i10) throws IOException {
            try {
                byte[] bArr = this.f13430e;
                int i11 = this.f13433h;
                int i12 = i11 + 1;
                this.f13433h = i12;
                bArr[i11] = (byte) (i10 & 255);
                int i13 = i11 + 2;
                this.f13433h = i13;
                bArr[i12] = (byte) ((i10 >> 8) & 255);
                int i14 = i11 + 3;
                this.f13433h = i14;
                bArr[i13] = (byte) ((i10 >> 16) & 255);
                this.f13433h = i11 + 4;
                bArr[i14] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13433h), Integer.valueOf(this.f13432g), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void w0(int i10, long j10) throws IOException {
            W0(i10, 1);
            x0(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x0(long j10) throws IOException {
            try {
                byte[] bArr = this.f13430e;
                int i10 = this.f13433h;
                int i11 = i10 + 1;
                this.f13433h = i11;
                bArr[i10] = (byte) (((int) j10) & 255);
                int i12 = i10 + 2;
                this.f13433h = i12;
                bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
                int i13 = i10 + 3;
                this.f13433h = i13;
                bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
                int i14 = i10 + 4;
                this.f13433h = i14;
                bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
                int i15 = i10 + 5;
                this.f13433h = i15;
                bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
                int i16 = i10 + 6;
                this.f13433h = i16;
                bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
                int i17 = i10 + 7;
                this.f13433h = i17;
                bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
                this.f13433h = i10 + 8;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f13433h), Integer.valueOf(this.f13432g), 1), e10);
            }
        }
    }

    public static final class d extends b {

        /* renamed from: i, reason: collision with root package name */
        public final OutputStream f13434i;

        public d(OutputStream outputStream, int i10) {
            super(i10);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f13434i = outputStream;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void E0(int i10, int i11) throws IOException {
            j1(20);
            f1(i10, 0);
            e1(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void F0(int i10) throws IOException {
            if (i10 >= 0) {
                Y0(i10);
            } else {
                a1(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void I0(int i10, K k10, Z z10) throws IOException {
            W0(i10, 2);
            m1(k10, z10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void J0(K k10) throws IOException {
            Y0(k10.getSerializedSize());
            k10.a(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void K0(int i10, K k10) throws IOException {
            W0(1, 3);
            X0(2, i10);
            l1(3, k10);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void L0(int i10, ByteString byteString) throws IOException {
            W0(1, 3);
            X0(2, i10);
            o0(3, byteString);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void U0(int i10, String str) throws IOException {
            W0(i10, 2);
            V0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void V0(String str) throws IOException {
            int iG;
            try {
                int length = str.length() * 3;
                int iX = CodedOutputStream.X(length);
                int i10 = iX + length;
                int i11 = this.f13427f;
                if (i10 > i11) {
                    byte[] bArr = new byte[length];
                    int iF = Utf8.f(str, bArr, 0, length);
                    Y0(iF);
                    a(bArr, 0, iF);
                    return;
                }
                if (i10 > i11 - this.f13428g) {
                    i1();
                }
                int iX2 = CodedOutputStream.X(str.length());
                int i12 = this.f13428g;
                try {
                    if (iX2 == iX) {
                        int i13 = i12 + iX2;
                        this.f13428g = i13;
                        int iF2 = Utf8.f(str, this.f13426e, i13, this.f13427f - i13);
                        this.f13428g = i12;
                        iG = (iF2 - i12) - iX2;
                        g1(iG);
                        this.f13428g = iF2;
                    } else {
                        iG = Utf8.g(str);
                        g1(iG);
                        this.f13428g = Utf8.f(str, this.f13426e, this.f13428g, iG);
                    }
                    this.f13429h += iG;
                } catch (Utf8.UnpairedSurrogateException e10) {
                    this.f13429h -= this.f13428g - i12;
                    this.f13428g = i12;
                    throw e10;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(e11);
                }
            } catch (Utf8.UnpairedSurrogateException e12) {
                d0(str, e12);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void W0(int i10, int i11) throws IOException {
            Y0(WireFormat.c(i10, i11));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void X0(int i10, int i11) throws IOException {
            j1(20);
            f1(i10, 0);
            g1(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void Y0(int i10) throws IOException {
            j1(5);
            g1(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void Z0(int i10, long j10) throws IOException {
            j1(20);
            f1(i10, 0);
            h1(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.AbstractC1344g
        public void a(byte[] bArr, int i10, int i11) throws IOException {
            k1(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void a1(long j10) throws IOException {
            j1(10);
            h1(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void c0() throws IOException {
            if (this.f13428g > 0) {
                i1();
            }
        }

        public final void i1() throws IOException {
            this.f13434i.write(this.f13426e, 0, this.f13428g);
            this.f13428g = 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void j0(byte b10) throws IOException {
            if (this.f13428g == this.f13427f) {
                i1();
            }
            b1(b10);
        }

        public final void j1(int i10) throws IOException {
            if (this.f13427f - this.f13428g < i10) {
                i1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void k0(int i10, boolean z10) throws IOException {
            j1(11);
            f1(i10, 0);
            b1(z10 ? (byte) 1 : (byte) 0);
        }

        public void k1(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f13427f;
            int i13 = this.f13428g;
            if (i12 - i13 >= i11) {
                System.arraycopy(bArr, i10, this.f13426e, i13, i11);
                this.f13428g += i11;
                this.f13429h += i11;
                return;
            }
            int i14 = i12 - i13;
            System.arraycopy(bArr, i10, this.f13426e, i13, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.f13428g = this.f13427f;
            this.f13429h += i14;
            i1();
            if (i16 <= this.f13427f) {
                System.arraycopy(bArr, i15, this.f13426e, 0, i16);
                this.f13428g = i16;
            } else {
                this.f13434i.write(bArr, i15, i16);
            }
            this.f13429h += i16;
        }

        public void l1(int i10, K k10) throws IOException {
            W0(i10, 2);
            J0(k10);
        }

        public void m1(K k10, Z z10) throws IOException {
            Y0(((AbstractC1338a) k10).d(z10));
            z10.b(k10, this.f13424a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void n0(byte[] bArr, int i10, int i11) throws IOException {
            Y0(i11);
            k1(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void o0(int i10, ByteString byteString) throws IOException {
            W0(i10, 2);
            p0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void p0(ByteString byteString) throws IOException {
            Y0(byteString.size());
            byteString.L(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void u0(int i10, int i11) throws IOException {
            j1(14);
            f1(i10, 5);
            c1(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void v0(int i10) throws IOException {
            j1(4);
            c1(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void w0(int i10, long j10) throws IOException {
            j1(18);
            f1(i10, 1);
            d1(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void x0(long j10) throws IOException {
            j1(8);
            d1(j10);
        }
    }

    public static int A(int i10, C1361y c1361y) {
        return V(i10) + B(c1361y);
    }

    public static int B(C1361y c1361y) {
        return C(c1361y.b());
    }

    public static int C(int i10) {
        return X(i10) + i10;
    }

    public static int D(int i10, K k10) {
        return (V(1) * 2) + W(2, i10) + E(3, k10);
    }

    public static int E(int i10, K k10) {
        return V(i10) + G(k10);
    }

    public static int F(int i10, K k10, Z z10) {
        return V(i10) + H(k10, z10);
    }

    public static int G(K k10) {
        return C(k10.getSerializedSize());
    }

    public static int H(K k10, Z z10) {
        return C(((AbstractC1338a) k10).d(z10));
    }

    public static int I(int i10) {
        if (i10 > 4096) {
            return 4096;
        }
        return i10;
    }

    public static int J(int i10, ByteString byteString) {
        return (V(1) * 2) + W(2, i10) + g(3, byteString);
    }

    @Deprecated
    public static int K(int i10) {
        return X(i10);
    }

    public static int L(int i10, int i11) {
        return V(i10) + M(i11);
    }

    public static int M(int i10) {
        return 4;
    }

    public static int N(int i10, long j10) {
        return V(i10) + O(j10);
    }

    public static int O(long j10) {
        return 8;
    }

    public static int P(int i10, int i11) {
        return V(i10) + Q(i11);
    }

    public static int Q(int i10) {
        return X(a0(i10));
    }

    public static int R(int i10, long j10) {
        return V(i10) + S(j10);
    }

    public static int S(long j10) {
        return Z(b0(j10));
    }

    public static int T(int i10, String str) {
        return V(i10) + U(str);
    }

    public static int U(String str) {
        int length;
        try {
            length = Utf8.g(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(C1359w.f13642a).length;
        }
        return C(length);
    }

    public static int V(int i10) {
        return X(WireFormat.c(i10, 0));
    }

    public static int W(int i10, int i11) {
        return V(i10) + X(i11);
    }

    public static int X(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int Y(int i10, long j10) {
        return V(i10) + Z(j10);
    }

    public static int Z(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            i10 += 2;
            j10 >>>= 14;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public static int a0(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    public static long b0(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    public static int d(int i10, boolean z10) {
        return V(i10) + e(z10);
    }

    public static int e(boolean z10) {
        return 1;
    }

    public static int f(byte[] bArr) {
        return C(bArr.length);
    }

    public static CodedOutputStream f0(OutputStream outputStream, int i10) {
        return new d(outputStream, i10);
    }

    public static int g(int i10, ByteString byteString) {
        return V(i10) + h(byteString);
    }

    public static CodedOutputStream g0(byte[] bArr) {
        return h0(bArr, 0, bArr.length);
    }

    public static int h(ByteString byteString) {
        return C(byteString.size());
    }

    public static CodedOutputStream h0(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static int i(int i10, double d10) {
        return V(i10) + j(d10);
    }

    public static int j(double d10) {
        return 8;
    }

    public static int k(int i10, int i11) {
        return V(i10) + l(i11);
    }

    public static int l(int i10) {
        return w(i10);
    }

    public static int m(int i10, int i11) {
        return V(i10) + n(i11);
    }

    public static int n(int i10) {
        return 4;
    }

    public static int o(int i10, long j10) {
        return V(i10) + p(j10);
    }

    public static int p(long j10) {
        return 8;
    }

    public static int q(int i10, float f10) {
        return V(i10) + r(f10);
    }

    public static int r(float f10) {
        return 4;
    }

    @Deprecated
    public static int s(int i10, K k10, Z z10) {
        return (V(i10) * 2) + u(k10, z10);
    }

    @Deprecated
    public static int t(K k10) {
        return k10.getSerializedSize();
    }

    @Deprecated
    public static int u(K k10, Z z10) {
        return ((AbstractC1338a) k10).d(z10);
    }

    public static int v(int i10, int i11) {
        return V(i10) + w(i11);
    }

    public static int w(int i10) {
        if (i10 >= 0) {
            return X(i10);
        }
        return 10;
    }

    public static int x(int i10, long j10) {
        return V(i10) + y(j10);
    }

    public static int y(long j10) {
        return Z(j10);
    }

    public static int z(int i10, C1361y c1361y) {
        return (V(1) * 2) + W(2, i10) + A(3, c1361y);
    }

    @Deprecated
    public final void A0(int i10, K k10) throws IOException {
        W0(i10, 3);
        C0(k10);
        W0(i10, 4);
    }

    @Deprecated
    public final void B0(int i10, K k10, Z z10) throws IOException {
        W0(i10, 3);
        D0(k10, z10);
        W0(i10, 4);
    }

    @Deprecated
    public final void C0(K k10) throws IOException {
        k10.a(this);
    }

    @Deprecated
    public final void D0(K k10, Z z10) throws IOException {
        z10.b(k10, this.f13424a);
    }

    public abstract void E0(int i10, int i11) throws IOException;

    public abstract void F0(int i10) throws IOException;

    public final void G0(int i10, long j10) throws IOException {
        Z0(i10, j10);
    }

    public final void H0(long j10) throws IOException {
        a1(j10);
    }

    public abstract void I0(int i10, K k10, Z z10) throws IOException;

    public abstract void J0(K k10) throws IOException;

    public abstract void K0(int i10, K k10) throws IOException;

    public abstract void L0(int i10, ByteString byteString) throws IOException;

    public final void M0(int i10, int i11) throws IOException {
        u0(i10, i11);
    }

    public final void N0(int i10) throws IOException {
        v0(i10);
    }

    public final void O0(int i10, long j10) throws IOException {
        w0(i10, j10);
    }

    public final void P0(long j10) throws IOException {
        x0(j10);
    }

    public final void Q0(int i10, int i11) throws IOException {
        X0(i10, a0(i11));
    }

    public final void R0(int i10) throws IOException {
        Y0(a0(i10));
    }

    public final void S0(int i10, long j10) throws IOException {
        Z0(i10, b0(j10));
    }

    public final void T0(long j10) throws IOException {
        a1(b0(j10));
    }

    public abstract void U0(int i10, String str) throws IOException;

    public abstract void V0(String str) throws IOException;

    public abstract void W0(int i10, int i11) throws IOException;

    public abstract void X0(int i10, int i11) throws IOException;

    public abstract void Y0(int i10) throws IOException;

    public abstract void Z0(int i10, long j10) throws IOException;

    @Override // androidx.datastore.preferences.protobuf.AbstractC1344g
    public abstract void a(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void a1(long j10) throws IOException;

    public final void c() {
        if (i0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void c0() throws IOException;

    public final void d0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f13422c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(C1359w.f13642a);
        try {
            Y0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new OutOfSpaceException(e11);
        }
    }

    public boolean e0() {
        return this.f13425b;
    }

    public abstract int i0();

    public abstract void j0(byte b10) throws IOException;

    public abstract void k0(int i10, boolean z10) throws IOException;

    public final void l0(boolean z10) throws IOException {
        j0(z10 ? (byte) 1 : (byte) 0);
    }

    public final void m0(byte[] bArr) throws IOException {
        n0(bArr, 0, bArr.length);
    }

    public abstract void n0(byte[] bArr, int i10, int i11) throws IOException;

    public abstract void o0(int i10, ByteString byteString) throws IOException;

    public abstract void p0(ByteString byteString) throws IOException;

    public final void q0(int i10, double d10) throws IOException {
        w0(i10, Double.doubleToRawLongBits(d10));
    }

    public final void r0(double d10) throws IOException {
        x0(Double.doubleToRawLongBits(d10));
    }

    public final void s0(int i10, int i11) throws IOException {
        E0(i10, i11);
    }

    public final void t0(int i10) throws IOException {
        F0(i10);
    }

    public abstract void u0(int i10, int i11) throws IOException;

    public abstract void v0(int i10) throws IOException;

    public abstract void w0(int i10, long j10) throws IOException;

    public abstract void x0(long j10) throws IOException;

    public final void y0(int i10, float f10) throws IOException {
        u0(i10, Float.floatToRawIntBits(f10));
    }

    public final void z0(float f10) throws IOException {
        v0(Float.floatToRawIntBits(f10));
    }

    public CodedOutputStream() {
    }
}
