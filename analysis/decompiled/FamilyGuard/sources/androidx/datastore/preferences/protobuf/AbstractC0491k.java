package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.t0;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0491k extends AbstractC0487g {

    /* renamed from: c, reason: collision with root package name */
    private static final Logger f10052c = Logger.getLogger(AbstractC0491k.class.getName());

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f10053d = s0.C();

    /* renamed from: a, reason: collision with root package name */
    C0492l f10054a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10055b;

    /* renamed from: androidx.datastore.preferences.protobuf.k$b */
    private static abstract class b extends AbstractC0491k {

        /* renamed from: e, reason: collision with root package name */
        final byte[] f10056e;

        /* renamed from: f, reason: collision with root package name */
        final int f10057f;

        /* renamed from: g, reason: collision with root package name */
        int f10058g;

        /* renamed from: h, reason: collision with root package name */
        int f10059h;

        b(int i5) {
            super();
            if (i5 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i5, 20)];
            this.f10056e = bArr;
            this.f10057f = bArr.length;
        }

        final void b1(byte b6) {
            byte[] bArr = this.f10056e;
            int i5 = this.f10058g;
            this.f10058g = i5 + 1;
            bArr[i5] = b6;
            this.f10059h++;
        }

        final void c1(int i5) {
            byte[] bArr = this.f10056e;
            int i6 = this.f10058g;
            int i7 = i6 + 1;
            this.f10058g = i7;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i6 + 2;
            this.f10058g = i8;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i6 + 3;
            this.f10058g = i9;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.f10058g = i6 + 4;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
            this.f10059h += 4;
        }

        final void d1(long j5) {
            byte[] bArr = this.f10056e;
            int i5 = this.f10058g;
            int i6 = i5 + 1;
            this.f10058g = i6;
            bArr[i5] = (byte) (j5 & 255);
            int i7 = i5 + 2;
            this.f10058g = i7;
            bArr[i6] = (byte) ((j5 >> 8) & 255);
            int i8 = i5 + 3;
            this.f10058g = i8;
            bArr[i7] = (byte) ((j5 >> 16) & 255);
            int i9 = i5 + 4;
            this.f10058g = i9;
            bArr[i8] = (byte) (255 & (j5 >> 24));
            int i10 = i5 + 5;
            this.f10058g = i10;
            bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
            int i11 = i5 + 6;
            this.f10058g = i11;
            bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
            int i12 = i5 + 7;
            this.f10058g = i12;
            bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
            this.f10058g = i5 + 8;
            bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            this.f10059h += 8;
        }

        final void e1(int i5) {
            if (i5 >= 0) {
                g1(i5);
            } else {
                h1(i5);
            }
        }

        final void f1(int i5, int i6) {
            g1(u0.c(i5, i6));
        }

        final void g1(int i5) {
            if (!AbstractC0491k.f10053d) {
                while ((i5 & (-128)) != 0) {
                    byte[] bArr = this.f10056e;
                    int i6 = this.f10058g;
                    this.f10058g = i6 + 1;
                    bArr[i6] = (byte) ((i5 & 127) | 128);
                    this.f10059h++;
                    i5 >>>= 7;
                }
                byte[] bArr2 = this.f10056e;
                int i7 = this.f10058g;
                this.f10058g = i7 + 1;
                bArr2[i7] = (byte) i5;
                this.f10059h++;
                return;
            }
            long j5 = this.f10058g;
            while ((i5 & (-128)) != 0) {
                byte[] bArr3 = this.f10056e;
                int i8 = this.f10058g;
                this.f10058g = i8 + 1;
                s0.H(bArr3, i8, (byte) ((i5 & 127) | 128));
                i5 >>>= 7;
            }
            byte[] bArr4 = this.f10056e;
            int i9 = this.f10058g;
            this.f10058g = i9 + 1;
            s0.H(bArr4, i9, (byte) i5);
            this.f10059h += (int) (this.f10058g - j5);
        }

        final void h1(long j5) {
            if (!AbstractC0491k.f10053d) {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.f10056e;
                    int i5 = this.f10058g;
                    this.f10058g = i5 + 1;
                    bArr[i5] = (byte) ((((int) j5) & 127) | 128);
                    this.f10059h++;
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.f10056e;
                int i6 = this.f10058g;
                this.f10058g = i6 + 1;
                bArr2[i6] = (byte) j5;
                this.f10059h++;
                return;
            }
            long j6 = this.f10058g;
            while ((j5 & (-128)) != 0) {
                byte[] bArr3 = this.f10056e;
                int i7 = this.f10058g;
                this.f10058g = i7 + 1;
                s0.H(bArr3, i7, (byte) ((((int) j5) & 127) | 128));
                j5 >>>= 7;
            }
            byte[] bArr4 = this.f10056e;
            int i8 = this.f10058g;
            this.f10058g = i8 + 1;
            s0.H(bArr4, i8, (byte) j5);
            this.f10059h += (int) (this.f10058g - j6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final int i0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.k$c */
    private static class c extends AbstractC0491k {

        /* renamed from: e, reason: collision with root package name */
        private final byte[] f10060e;

        /* renamed from: f, reason: collision with root package name */
        private final int f10061f;

        /* renamed from: g, reason: collision with root package name */
        private final int f10062g;

        /* renamed from: h, reason: collision with root package name */
        private int f10063h;

        c(byte[] bArr, int i5, int i6) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i7 = i5 + i6;
            if ((i5 | i6 | (bArr.length - i7)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            this.f10060e = bArr;
            this.f10061f = i5;
            this.f10063h = i5;
            this.f10062g = i7;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void E0(int i5, int i6) throws d {
            W0(i5, 0);
            F0(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void F0(int i5) throws d {
            if (i5 >= 0) {
                Y0(i5);
            } else {
                a1(i5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        final void I0(int i5, S s5, h0 h0Var) throws d {
            W0(i5, 2);
            Y0(((AbstractC0481a) s5).l(h0Var));
            h0Var.e(s5, this.f10054a);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void J0(S s5) throws d {
            Y0(s5.g());
            s5.h(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void K0(int i5, S s5) throws d {
            W0(1, 3);
            X0(2, i5);
            c1(3, s5);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void L0(int i5, AbstractC0488h abstractC0488h) throws d {
            W0(1, 3);
            X0(2, i5);
            o0(3, abstractC0488h);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void U0(int i5, String str) throws d {
            W0(i5, 2);
            V0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void V0(String str) throws d {
            int i5 = this.f10063h;
            try {
                int iX = AbstractC0491k.X(str.length() * 3);
                int iX2 = AbstractC0491k.X(str.length());
                if (iX2 != iX) {
                    Y0(t0.g(str));
                    this.f10063h = t0.f(str, this.f10060e, this.f10063h, i0());
                    return;
                }
                int i6 = i5 + iX2;
                this.f10063h = i6;
                int iF = t0.f(str, this.f10060e, i6, i0());
                this.f10063h = i5;
                Y0((iF - i5) - iX2);
                this.f10063h = iF;
            } catch (t0.d e6) {
                this.f10063h = i5;
                d0(str, e6);
            } catch (IndexOutOfBoundsException e7) {
                throw new d(e7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void W0(int i5, int i6) throws d {
            Y0(u0.c(i5, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void X0(int i5, int i6) throws d {
            W0(i5, 0);
            Y0(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void Y0(int i5) throws d {
            if (!AbstractC0491k.f10053d || C0484d.c() || i0() < 5) {
                while ((i5 & (-128)) != 0) {
                    try {
                        byte[] bArr = this.f10060e;
                        int i6 = this.f10063h;
                        this.f10063h = i6 + 1;
                        bArr[i6] = (byte) ((i5 & 127) | 128);
                        i5 >>>= 7;
                    } catch (IndexOutOfBoundsException e6) {
                        throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f10063h), Integer.valueOf(this.f10062g), 1), e6);
                    }
                }
                byte[] bArr2 = this.f10060e;
                int i7 = this.f10063h;
                this.f10063h = i7 + 1;
                bArr2[i7] = (byte) i5;
                return;
            }
            if ((i5 & (-128)) == 0) {
                byte[] bArr3 = this.f10060e;
                int i8 = this.f10063h;
                this.f10063h = i8 + 1;
                s0.H(bArr3, i8, (byte) i5);
                return;
            }
            byte[] bArr4 = this.f10060e;
            int i9 = this.f10063h;
            this.f10063h = i9 + 1;
            s0.H(bArr4, i9, (byte) (i5 | 128));
            int i10 = i5 >>> 7;
            if ((i10 & (-128)) == 0) {
                byte[] bArr5 = this.f10060e;
                int i11 = this.f10063h;
                this.f10063h = i11 + 1;
                s0.H(bArr5, i11, (byte) i10);
                return;
            }
            byte[] bArr6 = this.f10060e;
            int i12 = this.f10063h;
            this.f10063h = i12 + 1;
            s0.H(bArr6, i12, (byte) (i10 | 128));
            int i13 = i5 >>> 14;
            if ((i13 & (-128)) == 0) {
                byte[] bArr7 = this.f10060e;
                int i14 = this.f10063h;
                this.f10063h = i14 + 1;
                s0.H(bArr7, i14, (byte) i13);
                return;
            }
            byte[] bArr8 = this.f10060e;
            int i15 = this.f10063h;
            this.f10063h = i15 + 1;
            s0.H(bArr8, i15, (byte) (i13 | 128));
            int i16 = i5 >>> 21;
            if ((i16 & (-128)) == 0) {
                byte[] bArr9 = this.f10060e;
                int i17 = this.f10063h;
                this.f10063h = i17 + 1;
                s0.H(bArr9, i17, (byte) i16);
                return;
            }
            byte[] bArr10 = this.f10060e;
            int i18 = this.f10063h;
            this.f10063h = i18 + 1;
            s0.H(bArr10, i18, (byte) (i16 | 128));
            byte[] bArr11 = this.f10060e;
            int i19 = this.f10063h;
            this.f10063h = i19 + 1;
            s0.H(bArr11, i19, (byte) (i5 >>> 28));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void Z0(int i5, long j5) throws d {
            W0(i5, 0);
            a1(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k, androidx.datastore.preferences.protobuf.AbstractC0487g
        public final void a(byte[] bArr, int i5, int i6) throws d {
            b1(bArr, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void a1(long j5) throws d {
            if (AbstractC0491k.f10053d && i0() >= 10) {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.f10060e;
                    int i5 = this.f10063h;
                    this.f10063h = i5 + 1;
                    s0.H(bArr, i5, (byte) ((((int) j5) & 127) | 128));
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.f10060e;
                int i6 = this.f10063h;
                this.f10063h = i6 + 1;
                s0.H(bArr2, i6, (byte) j5);
                return;
            }
            while ((j5 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f10060e;
                    int i7 = this.f10063h;
                    this.f10063h = i7 + 1;
                    bArr3[i7] = (byte) ((((int) j5) & 127) | 128);
                    j5 >>>= 7;
                } catch (IndexOutOfBoundsException e6) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f10063h), Integer.valueOf(this.f10062g), 1), e6);
                }
            }
            byte[] bArr4 = this.f10060e;
            int i8 = this.f10063h;
            this.f10063h = i8 + 1;
            bArr4[i8] = (byte) j5;
        }

        public final void b1(byte[] bArr, int i5, int i6) throws d {
            try {
                System.arraycopy(bArr, i5, this.f10060e, this.f10063h, i6);
                this.f10063h += i6;
            } catch (IndexOutOfBoundsException e6) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f10063h), Integer.valueOf(this.f10062g), Integer.valueOf(i6)), e6);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void c0() {
        }

        public final void c1(int i5, S s5) throws d {
            W0(i5, 2);
            J0(s5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final int i0() {
            return this.f10062g - this.f10063h;
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void j0(byte b6) throws d {
            try {
                byte[] bArr = this.f10060e;
                int i5 = this.f10063h;
                this.f10063h = i5 + 1;
                bArr[i5] = b6;
            } catch (IndexOutOfBoundsException e6) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f10063h), Integer.valueOf(this.f10062g), 1), e6);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void k0(int i5, boolean z5) throws d {
            W0(i5, 0);
            j0(z5 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void n0(byte[] bArr, int i5, int i6) throws d {
            Y0(i6);
            b1(bArr, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void o0(int i5, AbstractC0488h abstractC0488h) throws d {
            W0(i5, 2);
            p0(abstractC0488h);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void p0(AbstractC0488h abstractC0488h) throws d {
            Y0(abstractC0488h.size());
            abstractC0488h.E(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void u0(int i5, int i6) throws d {
            W0(i5, 5);
            v0(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void v0(int i5) throws d {
            try {
                byte[] bArr = this.f10060e;
                int i6 = this.f10063h;
                int i7 = i6 + 1;
                this.f10063h = i7;
                bArr[i6] = (byte) (i5 & 255);
                int i8 = i6 + 2;
                this.f10063h = i8;
                bArr[i7] = (byte) ((i5 >> 8) & 255);
                int i9 = i6 + 3;
                this.f10063h = i9;
                bArr[i8] = (byte) ((i5 >> 16) & 255);
                this.f10063h = i6 + 4;
                bArr[i9] = (byte) ((i5 >> 24) & 255);
            } catch (IndexOutOfBoundsException e6) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f10063h), Integer.valueOf(this.f10062g), 1), e6);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void w0(int i5, long j5) throws d {
            W0(i5, 1);
            x0(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public final void x0(long j5) throws d {
            try {
                byte[] bArr = this.f10060e;
                int i5 = this.f10063h;
                int i6 = i5 + 1;
                this.f10063h = i6;
                bArr[i5] = (byte) (((int) j5) & 255);
                int i7 = i5 + 2;
                this.f10063h = i7;
                bArr[i6] = (byte) (((int) (j5 >> 8)) & 255);
                int i8 = i5 + 3;
                this.f10063h = i8;
                bArr[i7] = (byte) (((int) (j5 >> 16)) & 255);
                int i9 = i5 + 4;
                this.f10063h = i9;
                bArr[i8] = (byte) (((int) (j5 >> 24)) & 255);
                int i10 = i5 + 5;
                this.f10063h = i10;
                bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
                int i11 = i5 + 6;
                this.f10063h = i11;
                bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
                int i12 = i5 + 7;
                this.f10063h = i12;
                bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
                this.f10063h = i5 + 8;
                bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e6) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f10063h), Integer.valueOf(this.f10062g), 1), e6);
            }
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.k$d */
    public static class d extends IOException {
        d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.k$e */
    private static final class e extends b {

        /* renamed from: i, reason: collision with root package name */
        private final OutputStream f10064i;

        e(OutputStream outputStream, int i5) {
            super(i5);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f10064i = outputStream;
        }

        private void i1() throws IOException {
            this.f10064i.write(this.f10056e, 0, this.f10058g);
            this.f10058g = 0;
        }

        private void j1(int i5) throws IOException {
            if (this.f10057f - this.f10058g < i5) {
                i1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void E0(int i5, int i6) throws IOException {
            j1(20);
            f1(i5, 0);
            e1(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void F0(int i5) throws IOException {
            if (i5 >= 0) {
                Y0(i5);
            } else {
                a1(i5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        void I0(int i5, S s5, h0 h0Var) throws IOException {
            W0(i5, 2);
            m1(s5, h0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void J0(S s5) throws IOException {
            Y0(s5.g());
            s5.h(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void K0(int i5, S s5) throws IOException {
            W0(1, 3);
            X0(2, i5);
            l1(3, s5);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void L0(int i5, AbstractC0488h abstractC0488h) throws IOException {
            W0(1, 3);
            X0(2, i5);
            o0(3, abstractC0488h);
            W0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void U0(int i5, String str) throws IOException {
            W0(i5, 2);
            V0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void V0(String str) throws IOException {
            int iG;
            try {
                int length = str.length() * 3;
                int iX = AbstractC0491k.X(length);
                int i5 = iX + length;
                int i6 = this.f10057f;
                if (i5 > i6) {
                    byte[] bArr = new byte[length];
                    int iF = t0.f(str, bArr, 0, length);
                    Y0(iF);
                    a(bArr, 0, iF);
                    return;
                }
                if (i5 > i6 - this.f10058g) {
                    i1();
                }
                int iX2 = AbstractC0491k.X(str.length());
                int i7 = this.f10058g;
                try {
                    if (iX2 == iX) {
                        int i8 = i7 + iX2;
                        this.f10058g = i8;
                        int iF2 = t0.f(str, this.f10056e, i8, this.f10057f - i8);
                        this.f10058g = i7;
                        iG = (iF2 - i7) - iX2;
                        g1(iG);
                        this.f10058g = iF2;
                    } else {
                        iG = t0.g(str);
                        g1(iG);
                        this.f10058g = t0.f(str, this.f10056e, this.f10058g, iG);
                    }
                    this.f10059h += iG;
                } catch (t0.d e6) {
                    this.f10059h -= this.f10058g - i7;
                    this.f10058g = i7;
                    throw e6;
                } catch (ArrayIndexOutOfBoundsException e7) {
                    throw new d(e7);
                }
            } catch (t0.d e8) {
                d0(str, e8);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void W0(int i5, int i6) throws IOException {
            Y0(u0.c(i5, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void X0(int i5, int i6) throws IOException {
            j1(20);
            f1(i5, 0);
            g1(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void Y0(int i5) throws IOException {
            j1(5);
            g1(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void Z0(int i5, long j5) throws IOException {
            j1(20);
            f1(i5, 0);
            h1(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k, androidx.datastore.preferences.protobuf.AbstractC0487g
        public void a(byte[] bArr, int i5, int i6) throws IOException {
            k1(bArr, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void a1(long j5) throws IOException {
            j1(10);
            h1(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void c0() throws IOException {
            if (this.f10058g > 0) {
                i1();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void j0(byte b6) throws IOException {
            if (this.f10058g == this.f10057f) {
                i1();
            }
            b1(b6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void k0(int i5, boolean z5) throws IOException {
            j1(11);
            f1(i5, 0);
            b1(z5 ? (byte) 1 : (byte) 0);
        }

        public void k1(byte[] bArr, int i5, int i6) throws IOException {
            int i7 = this.f10057f;
            int i8 = this.f10058g;
            if (i7 - i8 >= i6) {
                System.arraycopy(bArr, i5, this.f10056e, i8, i6);
                this.f10058g += i6;
                this.f10059h += i6;
                return;
            }
            int i9 = i7 - i8;
            System.arraycopy(bArr, i5, this.f10056e, i8, i9);
            int i10 = i5 + i9;
            int i11 = i6 - i9;
            this.f10058g = this.f10057f;
            this.f10059h += i9;
            i1();
            if (i11 <= this.f10057f) {
                System.arraycopy(bArr, i10, this.f10056e, 0, i11);
                this.f10058g = i11;
            } else {
                this.f10064i.write(bArr, i10, i11);
            }
            this.f10059h += i11;
        }

        public void l1(int i5, S s5) throws IOException {
            W0(i5, 2);
            J0(s5);
        }

        void m1(S s5, h0 h0Var) throws IOException {
            Y0(((AbstractC0481a) s5).l(h0Var));
            h0Var.e(s5, this.f10054a);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void n0(byte[] bArr, int i5, int i6) throws IOException {
            Y0(i6);
            k1(bArr, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void o0(int i5, AbstractC0488h abstractC0488h) throws IOException {
            W0(i5, 2);
            p0(abstractC0488h);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void p0(AbstractC0488h abstractC0488h) throws IOException {
            Y0(abstractC0488h.size());
            abstractC0488h.E(this);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void u0(int i5, int i6) throws IOException {
            j1(14);
            f1(i5, 5);
            c1(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void v0(int i5) throws IOException {
            j1(4);
            c1(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void w0(int i5, long j5) throws IOException {
            j1(18);
            f1(i5, 1);
            d1(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.AbstractC0491k
        public void x0(long j5) throws IOException {
            j1(8);
            d1(j5);
        }
    }

    public static int A(int i5, E e6) {
        return V(i5) + B(e6);
    }

    public static int B(E e6) {
        return C(e6.b());
    }

    static int C(int i5) {
        return X(i5) + i5;
    }

    public static int D(int i5, S s5) {
        return (V(1) * 2) + W(2, i5) + E(3, s5);
    }

    public static int E(int i5, S s5) {
        return V(i5) + G(s5);
    }

    static int F(int i5, S s5, h0 h0Var) {
        return V(i5) + H(s5, h0Var);
    }

    public static int G(S s5) {
        return C(s5.g());
    }

    static int H(S s5, h0 h0Var) {
        return C(((AbstractC0481a) s5).l(h0Var));
    }

    static int I(int i5) {
        return i5 > 4096 ? RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT : i5;
    }

    public static int J(int i5, AbstractC0488h abstractC0488h) {
        return (V(1) * 2) + W(2, i5) + g(3, abstractC0488h);
    }

    @Deprecated
    public static int K(int i5) {
        return X(i5);
    }

    public static int L(int i5, int i6) {
        return V(i5) + M(i6);
    }

    public static int M(int i5) {
        return 4;
    }

    public static int N(int i5, long j5) {
        return V(i5) + O(j5);
    }

    public static int O(long j5) {
        return 8;
    }

    public static int P(int i5, int i6) {
        return V(i5) + Q(i6);
    }

    public static int Q(int i5) {
        return X(a0(i5));
    }

    public static int R(int i5, long j5) {
        return V(i5) + S(j5);
    }

    public static int S(long j5) {
        return Z(b0(j5));
    }

    public static int T(int i5, String str) {
        return V(i5) + U(str);
    }

    public static int U(String str) {
        int length;
        try {
            length = t0.g(str);
        } catch (t0.d unused) {
            length = str.getBytes(A.f9905a).length;
        }
        return C(length);
    }

    public static int V(int i5) {
        return X(u0.c(i5, 0));
    }

    public static int W(int i5, int i6) {
        return V(i5) + X(i6);
    }

    public static int X(int i5) {
        if ((i5 & (-128)) == 0) {
            return 1;
        }
        if ((i5 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i5) == 0) {
            return 3;
        }
        return (i5 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int Y(int i5, long j5) {
        return V(i5) + Z(j5);
    }

    public static int Z(long j5) {
        int i5;
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if (((-34359738368L) & j5) != 0) {
            j5 >>>= 28;
            i5 = 6;
        } else {
            i5 = 2;
        }
        if (((-2097152) & j5) != 0) {
            i5 += 2;
            j5 >>>= 14;
        }
        return (j5 & (-16384)) != 0 ? i5 + 1 : i5;
    }

    public static int a0(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public static long b0(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    public static int d(int i5, boolean z5) {
        return V(i5) + e(z5);
    }

    public static int e(boolean z5) {
        return 1;
    }

    public static int f(byte[] bArr) {
        return C(bArr.length);
    }

    public static AbstractC0491k f0(OutputStream outputStream, int i5) {
        return new e(outputStream, i5);
    }

    public static int g(int i5, AbstractC0488h abstractC0488h) {
        return V(i5) + h(abstractC0488h);
    }

    public static AbstractC0491k g0(byte[] bArr) {
        return h0(bArr, 0, bArr.length);
    }

    public static int h(AbstractC0488h abstractC0488h) {
        return C(abstractC0488h.size());
    }

    public static AbstractC0491k h0(byte[] bArr, int i5, int i6) {
        return new c(bArr, i5, i6);
    }

    public static int i(int i5, double d6) {
        return V(i5) + j(d6);
    }

    public static int j(double d6) {
        return 8;
    }

    public static int k(int i5, int i6) {
        return V(i5) + l(i6);
    }

    public static int l(int i5) {
        return w(i5);
    }

    public static int m(int i5, int i6) {
        return V(i5) + n(i6);
    }

    public static int n(int i5) {
        return 4;
    }

    public static int o(int i5, long j5) {
        return V(i5) + p(j5);
    }

    public static int p(long j5) {
        return 8;
    }

    public static int q(int i5, float f5) {
        return V(i5) + r(f5);
    }

    public static int r(float f5) {
        return 4;
    }

    @Deprecated
    static int s(int i5, S s5, h0 h0Var) {
        return (V(i5) * 2) + u(s5, h0Var);
    }

    @Deprecated
    public static int t(S s5) {
        return s5.g();
    }

    @Deprecated
    static int u(S s5, h0 h0Var) {
        return ((AbstractC0481a) s5).l(h0Var);
    }

    public static int v(int i5, int i6) {
        return V(i5) + w(i6);
    }

    public static int w(int i5) {
        if (i5 >= 0) {
            return X(i5);
        }
        return 10;
    }

    public static int x(int i5, long j5) {
        return V(i5) + y(j5);
    }

    public static int y(long j5) {
        return Z(j5);
    }

    public static int z(int i5, E e6) {
        return (V(1) * 2) + W(2, i5) + A(3, e6);
    }

    @Deprecated
    public final void A0(int i5, S s5) {
        W0(i5, 3);
        C0(s5);
        W0(i5, 4);
    }

    @Deprecated
    final void B0(int i5, S s5, h0 h0Var) {
        W0(i5, 3);
        D0(s5, h0Var);
        W0(i5, 4);
    }

    @Deprecated
    public final void C0(S s5) {
        s5.h(this);
    }

    @Deprecated
    final void D0(S s5, h0 h0Var) {
        h0Var.e(s5, this.f10054a);
    }

    public abstract void E0(int i5, int i6);

    public abstract void F0(int i5);

    public final void G0(int i5, long j5) {
        Z0(i5, j5);
    }

    public final void H0(long j5) {
        a1(j5);
    }

    abstract void I0(int i5, S s5, h0 h0Var);

    public abstract void J0(S s5);

    public abstract void K0(int i5, S s5);

    public abstract void L0(int i5, AbstractC0488h abstractC0488h);

    public final void M0(int i5, int i6) {
        u0(i5, i6);
    }

    public final void N0(int i5) {
        v0(i5);
    }

    public final void O0(int i5, long j5) {
        w0(i5, j5);
    }

    public final void P0(long j5) {
        x0(j5);
    }

    public final void Q0(int i5, int i6) {
        X0(i5, a0(i6));
    }

    public final void R0(int i5) {
        Y0(a0(i5));
    }

    public final void S0(int i5, long j5) {
        Z0(i5, b0(j5));
    }

    public final void T0(long j5) {
        a1(b0(j5));
    }

    public abstract void U0(int i5, String str);

    public abstract void V0(String str);

    public abstract void W0(int i5, int i6);

    public abstract void X0(int i5, int i6);

    public abstract void Y0(int i5);

    public abstract void Z0(int i5, long j5);

    @Override // androidx.datastore.preferences.protobuf.AbstractC0487g
    public abstract void a(byte[] bArr, int i5, int i6);

    public abstract void a1(long j5);

    public final void c() {
        if (i0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void c0();

    final void d0(String str, t0.d dVar) throws d {
        f10052c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(A.f9905a);
        try {
            Y0(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (d e6) {
            throw e6;
        } catch (IndexOutOfBoundsException e7) {
            throw new d(e7);
        }
    }

    boolean e0() {
        return this.f10055b;
    }

    public abstract int i0();

    public abstract void j0(byte b6);

    public abstract void k0(int i5, boolean z5);

    public final void l0(boolean z5) {
        j0(z5 ? (byte) 1 : (byte) 0);
    }

    public final void m0(byte[] bArr) {
        n0(bArr, 0, bArr.length);
    }

    abstract void n0(byte[] bArr, int i5, int i6);

    public abstract void o0(int i5, AbstractC0488h abstractC0488h);

    public abstract void p0(AbstractC0488h abstractC0488h);

    public final void q0(int i5, double d6) {
        w0(i5, Double.doubleToRawLongBits(d6));
    }

    public final void r0(double d6) {
        x0(Double.doubleToRawLongBits(d6));
    }

    public final void s0(int i5, int i6) {
        E0(i5, i6);
    }

    public final void t0(int i5) {
        F0(i5);
    }

    public abstract void u0(int i5, int i6);

    public abstract void v0(int i5);

    public abstract void w0(int i5, long j5);

    public abstract void x0(long j5);

    public final void y0(int i5, float f5) {
        u0(i5, Float.floatToRawIntBits(f5));
    }

    public final void z0(float f5) {
        v0(Float.floatToRawIntBits(f5));
    }

    private AbstractC0491k() {
    }
}
