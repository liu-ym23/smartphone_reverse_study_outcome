package androidx.datastore.preferences.protobuf;

import androidx.datastore.core.c;
import androidx.datastore.preferences.protobuf.Utf8;
import com.stepos.core.common.util.TraceIdKeys;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class CodedOutputStream extends f {

    /* renamed from: c, reason: collision with root package name */
    public static final Logger f1721c = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f1722d = g1.f1820f;

    /* renamed from: b, reason: collision with root package name */
    public j f1723b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException(IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
        }

        public OutOfSpaceException(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(str), indexOutOfBoundsException);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f1724e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1725f;

        /* renamed from: g, reason: collision with root package name */
        public int f1726g;

        public a(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i10, 20)];
            this.f1724e = bArr;
            this.f1725f = bArr.length;
        }

        public final void T(int i10) {
            int i11 = this.f1726g;
            int i12 = i11 + 1;
            this.f1726g = i12;
            byte[] bArr = this.f1724e;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i11 + 2;
            this.f1726g = i13;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i11 + 3;
            this.f1726g = i14;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.f1726g = i11 + 4;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        }

        public final void U(long j10) {
            int i10 = this.f1726g;
            int i11 = i10 + 1;
            this.f1726g = i11;
            byte[] bArr = this.f1724e;
            bArr[i10] = (byte) (j10 & 255);
            int i12 = i10 + 2;
            this.f1726g = i12;
            bArr[i11] = (byte) ((j10 >> 8) & 255);
            int i13 = i10 + 3;
            this.f1726g = i13;
            bArr[i12] = (byte) ((j10 >> 16) & 255);
            int i14 = i10 + 4;
            this.f1726g = i14;
            bArr[i13] = (byte) (255 & (j10 >> 24));
            int i15 = i10 + 5;
            this.f1726g = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i10 + 6;
            this.f1726g = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i10 + 7;
            this.f1726g = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.f1726g = i10 + 8;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        }

        public final void V(int i10, int i11) {
            W((i10 << 3) | i11);
        }

        public final void W(int i10) {
            boolean z = CodedOutputStream.f1722d;
            byte[] bArr = this.f1724e;
            if (z) {
                while ((i10 & (-128)) != 0) {
                    int i11 = this.f1726g;
                    this.f1726g = i11 + 1;
                    g1.j(bArr, i11, (byte) ((i10 & 127) | TraceIdKeys.MAX_LENGTH));
                    i10 >>>= 7;
                }
                int i12 = this.f1726g;
                this.f1726g = i12 + 1;
                g1.j(bArr, i12, (byte) i10);
                return;
            }
            while ((i10 & (-128)) != 0) {
                int i13 = this.f1726g;
                this.f1726g = i13 + 1;
                bArr[i13] = (byte) ((i10 & 127) | TraceIdKeys.MAX_LENGTH);
                i10 >>>= 7;
            }
            int i14 = this.f1726g;
            this.f1726g = i14 + 1;
            bArr[i14] = (byte) i10;
        }

        public final void X(long j10) {
            boolean z = CodedOutputStream.f1722d;
            byte[] bArr = this.f1724e;
            if (z) {
                while ((j10 & (-128)) != 0) {
                    int i10 = this.f1726g;
                    this.f1726g = i10 + 1;
                    g1.j(bArr, i10, (byte) ((((int) j10) & 127) | TraceIdKeys.MAX_LENGTH));
                    j10 >>>= 7;
                }
                int i11 = this.f1726g;
                this.f1726g = i11 + 1;
                g1.j(bArr, i11, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                int i12 = this.f1726g;
                this.f1726g = i12 + 1;
                bArr[i12] = (byte) ((((int) j10) & 127) | TraceIdKeys.MAX_LENGTH);
                j10 >>>= 7;
            }
            int i13 = this.f1726g;
            this.f1726g = i13 + 1;
            bArr[i13] = (byte) j10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends CodedOutputStream {

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f1727e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1728f;

        /* renamed from: g, reason: collision with root package name */
        public int f1729g;

        public b(byte[] bArr, int i10) {
            if (((bArr.length - i10) | i10) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i10)));
            }
            this.f1727e = bArr;
            this.f1729g = 0;
            this.f1728f = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void A(int i10, ByteString byteString) throws OutOfSpaceException {
            O(i10, 2);
            B(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void B(ByteString byteString) throws OutOfSpaceException {
            Q(byteString.size());
            byteString.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void C(int i10, int i11) throws OutOfSpaceException {
            O(i10, 5);
            D(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void D(int i10) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f1727e;
                int i11 = this.f1729g;
                int i12 = i11 + 1;
                this.f1729g = i12;
                bArr[i11] = (byte) (i10 & 255);
                int i13 = i11 + 2;
                this.f1729g = i13;
                bArr[i12] = (byte) ((i10 >> 8) & 255);
                int i14 = i11 + 3;
                this.f1729g = i14;
                bArr[i13] = (byte) ((i10 >> 16) & 255);
                this.f1729g = i11 + 4;
                bArr[i14] = (byte) ((i10 >> 24) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1729g), Integer.valueOf(this.f1728f), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void E(int i10, long j10) throws OutOfSpaceException {
            O(i10, 1);
            F(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void F(long j10) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f1727e;
                int i10 = this.f1729g;
                int i11 = i10 + 1;
                this.f1729g = i11;
                bArr[i10] = (byte) (((int) j10) & 255);
                int i12 = i10 + 2;
                this.f1729g = i12;
                bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
                int i13 = i10 + 3;
                this.f1729g = i13;
                bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
                int i14 = i10 + 4;
                this.f1729g = i14;
                bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
                int i15 = i10 + 5;
                this.f1729g = i15;
                bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
                int i16 = i10 + 6;
                this.f1729g = i16;
                bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
                int i17 = i10 + 7;
                this.f1729g = i17;
                bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
                this.f1729g = i10 + 8;
                bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1729g), Integer.valueOf(this.f1728f), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void G(int i10, int i11) throws OutOfSpaceException {
            O(i10, 0);
            H(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void H(int i10) throws OutOfSpaceException {
            if (i10 >= 0) {
                Q(i10);
            } else {
                S(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void I(int i10, i0 i0Var, w0 w0Var) throws OutOfSpaceException {
            O(i10, 2);
            Q(((androidx.datastore.preferences.protobuf.a) i0Var).g(w0Var));
            w0Var.h(i0Var, this.f1723b);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void J(i0 i0Var) throws OutOfSpaceException {
            Q(i0Var.c());
            i0Var.f(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void K(int i10, i0 i0Var) throws OutOfSpaceException {
            O(1, 3);
            P(2, i10);
            O(3, 2);
            J(i0Var);
            O(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void L(int i10, ByteString byteString) throws OutOfSpaceException {
            O(1, 3);
            P(2, i10);
            A(3, byteString);
            O(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void M(int i10, String str) throws OutOfSpaceException {
            O(i10, 2);
            N(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void N(String str) throws OutOfSpaceException {
            int i10 = this.f1729g;
            try {
                int iU = CodedOutputStream.u(str.length() * 3);
                int iU2 = CodedOutputStream.u(str.length());
                int i11 = this.f1728f;
                byte[] bArr = this.f1727e;
                if (iU2 != iU) {
                    Q(Utf8.b(str));
                    int i12 = this.f1729g;
                    this.f1729g = Utf8.f1765a.b(bArr, i12, i11 - i12, str);
                    return;
                }
                int i13 = i10 + iU2;
                this.f1729g = i13;
                int iB = Utf8.f1765a.b(bArr, i13, i11 - i13, str);
                this.f1729g = i10;
                Q((iB - i10) - iU2);
                this.f1729g = iB;
            } catch (Utf8.UnpairedSurrogateException e10) {
                this.f1729g = i10;
                w(str, e10);
            } catch (IndexOutOfBoundsException e11) {
                throw new OutOfSpaceException(e11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void O(int i10, int i11) throws OutOfSpaceException {
            Q((i10 << 3) | i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void P(int i10, int i11) throws OutOfSpaceException {
            O(i10, 0);
            Q(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void Q(int i10) throws OutOfSpaceException {
            boolean z = CodedOutputStream.f1722d;
            int i11 = this.f1728f;
            byte[] bArr = this.f1727e;
            if (z && !d.a()) {
                int i12 = this.f1729g;
                if (i11 - i12 >= 5) {
                    if ((i10 & (-128)) == 0) {
                        this.f1729g = i12 + 1;
                        g1.j(bArr, i12, (byte) i10);
                        return;
                    }
                    this.f1729g = i12 + 1;
                    g1.j(bArr, i12, (byte) (i10 | TraceIdKeys.MAX_LENGTH));
                    int i13 = i10 >>> 7;
                    if ((i13 & (-128)) == 0) {
                        int i14 = this.f1729g;
                        this.f1729g = i14 + 1;
                        g1.j(bArr, i14, (byte) i13);
                        return;
                    }
                    int i15 = this.f1729g;
                    this.f1729g = i15 + 1;
                    g1.j(bArr, i15, (byte) (i13 | TraceIdKeys.MAX_LENGTH));
                    int i16 = i10 >>> 14;
                    if ((i16 & (-128)) == 0) {
                        int i17 = this.f1729g;
                        this.f1729g = i17 + 1;
                        g1.j(bArr, i17, (byte) i16);
                        return;
                    }
                    int i18 = this.f1729g;
                    this.f1729g = i18 + 1;
                    g1.j(bArr, i18, (byte) (i16 | TraceIdKeys.MAX_LENGTH));
                    int i19 = i10 >>> 21;
                    if ((i19 & (-128)) == 0) {
                        int i20 = this.f1729g;
                        this.f1729g = i20 + 1;
                        g1.j(bArr, i20, (byte) i19);
                        return;
                    } else {
                        int i21 = this.f1729g;
                        this.f1729g = i21 + 1;
                        g1.j(bArr, i21, (byte) (i19 | TraceIdKeys.MAX_LENGTH));
                        int i22 = this.f1729g;
                        this.f1729g = i22 + 1;
                        g1.j(bArr, i22, (byte) (i10 >>> 28));
                        return;
                    }
                }
            }
            while ((i10 & (-128)) != 0) {
                try {
                    int i23 = this.f1729g;
                    this.f1729g = i23 + 1;
                    bArr[i23] = (byte) ((i10 & 127) | TraceIdKeys.MAX_LENGTH);
                    i10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1729g), Integer.valueOf(i11), 1), e10);
                }
            }
            int i24 = this.f1729g;
            this.f1729g = i24 + 1;
            bArr[i24] = (byte) i10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void R(int i10, long j10) throws OutOfSpaceException {
            O(i10, 0);
            S(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void S(long j10) throws OutOfSpaceException {
            boolean z = CodedOutputStream.f1722d;
            int i10 = this.f1728f;
            byte[] bArr = this.f1727e;
            if (z && i10 - this.f1729g >= 10) {
                while ((j10 & (-128)) != 0) {
                    int i11 = this.f1729g;
                    this.f1729g = i11 + 1;
                    g1.j(bArr, i11, (byte) ((((int) j10) & 127) | TraceIdKeys.MAX_LENGTH));
                    j10 >>>= 7;
                }
                int i12 = this.f1729g;
                this.f1729g = i12 + 1;
                g1.j(bArr, i12, (byte) j10);
                return;
            }
            while ((j10 & (-128)) != 0) {
                try {
                    int i13 = this.f1729g;
                    this.f1729g = i13 + 1;
                    bArr[i13] = (byte) ((((int) j10) & 127) | TraceIdKeys.MAX_LENGTH);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e10) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1729g), Integer.valueOf(i10), 1), e10);
                }
            }
            int i14 = this.f1729g;
            this.f1729g = i14 + 1;
            bArr[i14] = (byte) j10;
        }

        public final void T(byte[] bArr, int i10, int i11) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i10, this.f1727e, this.f1729g, i11);
                this.f1729g += i11;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1729g), Integer.valueOf(this.f1728f), Integer.valueOf(i11)), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void j(byte[] bArr, int i10, int i11) throws OutOfSpaceException {
            T(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x(byte b10) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f1727e;
                int i10 = this.f1729g;
                this.f1729g = i10 + 1;
                bArr[i10] = b10;
            } catch (IndexOutOfBoundsException e10) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f1729g), Integer.valueOf(this.f1728f), 1), e10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void y(int i10, boolean z) throws OutOfSpaceException {
            O(i10, 0);
            x(z ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void z(byte[] bArr, int i10) throws OutOfSpaceException {
            Q(i10);
            T(bArr, 0, i10);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c extends a {
        public final c.b h;

        public c(c.b bVar, int i10) {
            super(i10);
            this.h = bVar;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void A(int i10, ByteString byteString) {
            O(i10, 2);
            B(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void B(ByteString byteString) {
            Q(byteString.size());
            byteString.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void C(int i10, int i11) {
            Z(14);
            V(i10, 5);
            T(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void D(int i10) {
            Z(4);
            T(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void E(int i10, long j10) {
            Z(18);
            V(i10, 1);
            U(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void F(long j10) {
            Z(8);
            U(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void G(int i10, int i11) {
            Z(20);
            V(i10, 0);
            if (i11 >= 0) {
                W(i11);
            } else {
                X(i11);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void H(int i10) {
            if (i10 >= 0) {
                Q(i10);
            } else {
                S(i10);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void I(int i10, i0 i0Var, w0 w0Var) {
            O(i10, 2);
            Q(((androidx.datastore.preferences.protobuf.a) i0Var).g(w0Var));
            w0Var.h(i0Var, this.f1723b);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void J(i0 i0Var) {
            Q(i0Var.c());
            i0Var.f(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void K(int i10, i0 i0Var) {
            O(1, 3);
            P(2, i10);
            O(3, 2);
            J(i0Var);
            O(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void L(int i10, ByteString byteString) {
            O(1, 3);
            P(2, i10);
            A(3, byteString);
            O(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void M(int i10, String str) throws OutOfSpaceException {
            O(i10, 2);
            N(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void N(String str) throws OutOfSpaceException {
            try {
                int length = str.length() * 3;
                int iU = CodedOutputStream.u(length);
                int i10 = iU + length;
                int i11 = this.f1725f;
                if (i10 > i11) {
                    byte[] bArr = new byte[length];
                    int iB = Utf8.f1765a.b(bArr, 0, length, str);
                    Q(iB);
                    a0(bArr, 0, iB);
                    return;
                }
                if (i10 > i11 - this.f1726g) {
                    Y();
                }
                int iU2 = CodedOutputStream.u(str.length());
                int i12 = this.f1726g;
                byte[] bArr2 = this.f1724e;
                try {
                    try {
                        if (iU2 == iU) {
                            int i13 = i12 + iU2;
                            this.f1726g = i13;
                            int iB2 = Utf8.f1765a.b(bArr2, i13, i11 - i13, str);
                            this.f1726g = i12;
                            W((iB2 - i12) - iU2);
                            this.f1726g = iB2;
                        } else {
                            int iB3 = Utf8.b(str);
                            W(iB3);
                            this.f1726g = Utf8.f1765a.b(bArr2, this.f1726g, iB3, str);
                        }
                    } catch (Utf8.UnpairedSurrogateException e10) {
                        this.f1726g = i12;
                        throw e10;
                    }
                } catch (ArrayIndexOutOfBoundsException e11) {
                    throw new OutOfSpaceException(e11);
                }
            } catch (Utf8.UnpairedSurrogateException e12) {
                w(str, e12);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void O(int i10, int i11) {
            Q((i10 << 3) | i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void P(int i10, int i11) {
            Z(20);
            V(i10, 0);
            W(i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void Q(int i10) {
            Z(5);
            W(i10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void R(int i10, long j10) {
            Z(20);
            V(i10, 0);
            X(j10);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void S(long j10) {
            Z(10);
            X(j10);
        }

        public final void Y() {
            this.h.write(this.f1724e, 0, this.f1726g);
            this.f1726g = 0;
        }

        public final void Z(int i10) {
            if (this.f1725f - this.f1726g < i10) {
                Y();
            }
        }

        public final void a0(byte[] bArr, int i10, int i11) {
            int i12 = this.f1726g;
            int i13 = this.f1725f;
            int i14 = i13 - i12;
            byte[] bArr2 = this.f1724e;
            if (i14 >= i11) {
                System.arraycopy(bArr, i10, bArr2, i12, i11);
                this.f1726g += i11;
                return;
            }
            System.arraycopy(bArr, i10, bArr2, i12, i14);
            int i15 = i10 + i14;
            int i16 = i11 - i14;
            this.f1726g = i13;
            Y();
            if (i16 > i13) {
                this.h.write(bArr, i15, i16);
            } else {
                System.arraycopy(bArr, i15, bArr2, 0, i16);
                this.f1726g = i16;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void j(byte[] bArr, int i10, int i11) {
            a0(bArr, i10, i11);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x(byte b10) {
            if (this.f1726g == this.f1725f) {
                Y();
            }
            int i10 = this.f1726g;
            this.f1726g = i10 + 1;
            this.f1724e[i10] = b10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void y(int i10, boolean z) {
            Z(11);
            V(i10, 0);
            byte b10 = z ? (byte) 1 : (byte) 0;
            int i11 = this.f1726g;
            this.f1726g = i11 + 1;
            this.f1724e[i11] = b10;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void z(byte[] bArr, int i10) {
            Q(i10);
            a0(bArr, 0, i10);
        }
    }

    public static int k(int i10, ByteString byteString) {
        return l(byteString) + s(i10);
    }

    public static int l(ByteString byteString) {
        int size = byteString.size();
        return u(size) + size;
    }

    public static int m(int i10) {
        return s(i10) + 4;
    }

    public static int n(int i10) {
        return s(i10) + 8;
    }

    @Deprecated
    public static int o(int i10, i0 i0Var, w0 w0Var) {
        return ((androidx.datastore.preferences.protobuf.a) i0Var).g(w0Var) + (s(i10) * 2);
    }

    public static int p(int i10) {
        if (i10 >= 0) {
            return u(i10);
        }
        return 10;
    }

    public static int q(w wVar) {
        int size = wVar.f1897b != null ? wVar.f1897b.size() : wVar.f1896a != null ? wVar.f1896a.c() : 0;
        return u(size) + size;
    }

    public static int r(String str) {
        int length;
        try {
            length = Utf8.b(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(u.f1888a).length;
        }
        return u(length) + length;
    }

    public static int s(int i10) {
        return u(i10 << 3);
    }

    public static int t(int i10, int i11) {
        return u(i11) + s(i10);
    }

    public static int u(int i10) {
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

    public static int v(long j10) {
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

    public abstract void A(int i10, ByteString byteString);

    public abstract void B(ByteString byteString);

    public abstract void C(int i10, int i11);

    public abstract void D(int i10);

    public abstract void E(int i10, long j10);

    public abstract void F(long j10);

    public abstract void G(int i10, int i11);

    public abstract void H(int i10);

    public abstract void I(int i10, i0 i0Var, w0 w0Var);

    public abstract void J(i0 i0Var);

    public abstract void K(int i10, i0 i0Var);

    public abstract void L(int i10, ByteString byteString);

    public abstract void M(int i10, String str);

    public abstract void N(String str);

    public abstract void O(int i10, int i11);

    public abstract void P(int i10, int i11);

    public abstract void Q(int i10);

    public abstract void R(int i10, long j10);

    public abstract void S(long j10);

    public final void w(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws OutOfSpaceException {
        f1721c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(u.f1888a);
        try {
            Q(bytes.length);
            j(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e10) {
            throw e10;
        } catch (IndexOutOfBoundsException e11) {
            throw new OutOfSpaceException(e11);
        }
    }

    public abstract void x(byte b10);

    public abstract void y(int i10, boolean z);

    public abstract void z(byte[] bArr, int i10);
}
