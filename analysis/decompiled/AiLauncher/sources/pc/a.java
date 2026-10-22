package pc;

import io.ktor.network.tls.CertificateType;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f38443a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f38444b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, CertificateType.FORTEZZA_DMS_RESERVED, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f38445c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f38446d = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, CertificateType.FORTEZZA_DMS_RESERVED, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f38447e = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f38448f = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, CertificateType.FORTEZZA_DMS_RESERVED, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    public static int d(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        int i13;
        int i14;
        if (bArr == null) {
            throw new IllegalArgumentException("Source array was null.");
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        }
        if (i10 < 0 || (i13 = i10 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i10)));
        }
        if (i11 < 0 || (i14 = i11 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i11)));
        }
        byte[] bArrK = k(i12);
        byte b10 = bArr[i10 + 2];
        if (b10 == 61) {
            bArr2[i11] = (byte) ((((bArrK[bArr[i10 + 1]] & 255) << 12) | ((bArrK[bArr[i10]] & 255) << 18)) >>> 16);
            return 1;
        }
        byte b11 = bArr[i13];
        if (b11 == 61) {
            int i15 = ((bArrK[bArr[i10 + 1]] & 255) << 12) | ((bArrK[bArr[i10]] & 255) << 18) | ((bArrK[b10] & 255) << 6);
            bArr2[i11] = (byte) (i15 >>> 16);
            bArr2[i11 + 1] = (byte) (i15 >>> 8);
            return 2;
        }
        int i16 = ((bArrK[bArr[i10 + 1]] & 255) << 12) | ((bArrK[bArr[i10]] & 255) << 18) | ((bArrK[b10] & 255) << 6) | (bArrK[b11] & 255);
        bArr2[i11] = (byte) (i16 >> 16);
        bArr2[i11 + 1] = (byte) (i16 >> 8);
        bArr2[i14] = (byte) i16;
        return 3;
    }

    public static byte[] e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12, int i13) {
        byte[] bArrJ = j(i13);
        int i14 = (i11 > 0 ? (bArr[i10] << 24) >>> 8 : 0) | (i11 > 1 ? (bArr[i10 + 1] << 24) >>> 16 : 0) | (i11 > 2 ? (bArr[i10 + 2] << 24) >>> 24 : 0);
        if (i11 == 1) {
            bArr2[i12] = bArrJ[i14 >>> 18];
            bArr2[i12 + 1] = bArrJ[(i14 >>> 12) & 63];
            bArr2[i12 + 2] = 61;
            bArr2[i12 + 3] = 61;
            return bArr2;
        }
        if (i11 == 2) {
            bArr2[i12] = bArrJ[i14 >>> 18];
            bArr2[i12 + 1] = bArrJ[(i14 >>> 12) & 63];
            bArr2[i12 + 2] = bArrJ[(i14 >>> 6) & 63];
            bArr2[i12 + 3] = 61;
            return bArr2;
        }
        if (i11 != 3) {
            return bArr2;
        }
        bArr2[i12] = bArrJ[i14 >>> 18];
        bArr2[i12 + 1] = bArrJ[(i14 >>> 12) & 63];
        bArr2[i12 + 2] = bArrJ[(i14 >>> 6) & 63];
        bArr2[i12 + 3] = bArrJ[i14 & 63];
        return bArr2;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, int i10, int i11) {
        e(bArr2, 0, i10, bArr, 0, i11);
        return bArr;
    }

    public static String g(byte[] bArr) {
        try {
            return h(bArr, 0, bArr.length, 0);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String h(byte[] bArr, int i10, int i11, int i12) throws Throwable {
        byte[] bArrI = i(bArr, i10, i11, i12);
        try {
            return new String(bArrI, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArrI);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] i(byte[] r16, int r17, int r18, int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pc.a.i(byte[], int, int, int):byte[]");
    }

    public static final byte[] j(int i10) {
        return (i10 & 16) == 16 ? f38445c : (i10 & 32) == 32 ? f38447e : f38443a;
    }

    public static final byte[] k(int i10) {
        return (i10 & 16) == 16 ? f38446d : (i10 & 32) == 32 ? f38448f : f38444b;
    }

    /* renamed from: pc.a$a, reason: collision with other inner class name */
    public static class C0498a extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        public boolean f38449a;

        /* renamed from: b, reason: collision with root package name */
        public int f38450b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f38451c;

        /* renamed from: d, reason: collision with root package name */
        public int f38452d;

        /* renamed from: e, reason: collision with root package name */
        public int f38453e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f38454f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f38455g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f38456h;

        /* renamed from: i, reason: collision with root package name */
        public int f38457i;

        /* renamed from: j, reason: collision with root package name */
        public byte[] f38458j;

        public C0498a(OutputStream outputStream, int i10) {
            super(outputStream);
            this.f38454f = (i10 & 8) != 0;
            boolean z10 = (i10 & 1) != 0;
            this.f38449a = z10;
            int i11 = z10 ? 3 : 4;
            this.f38452d = i11;
            this.f38451c = new byte[i11];
            this.f38450b = 0;
            this.f38453e = 0;
            this.f38456h = false;
            this.f38455g = new byte[4];
            this.f38457i = i10;
            this.f38458j = a.k(i10);
        }

        public void b() throws IOException {
            int i10 = this.f38450b;
            if (i10 > 0) {
                if (!this.f38449a) {
                    throw new IOException("Base64 input not properly padded.");
                }
                ((FilterOutputStream) this).out.write(a.f(this.f38455g, this.f38451c, i10, this.f38457i));
                this.f38450b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            b();
            super.close();
            this.f38451c = null;
            ((FilterOutputStream) this).out = null;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i10) throws IOException {
            if (this.f38456h) {
                ((FilterOutputStream) this).out.write(i10);
                return;
            }
            if (!this.f38449a) {
                byte b10 = this.f38458j[i10 & 127];
                if (b10 <= -5) {
                    if (b10 != -5) {
                        throw new IOException("Invalid character in Base64 data.");
                    }
                    return;
                }
                byte[] bArr = this.f38451c;
                int i11 = this.f38450b;
                int i12 = i11 + 1;
                this.f38450b = i12;
                bArr[i11] = (byte) i10;
                if (i12 >= this.f38452d) {
                    ((FilterOutputStream) this).out.write(this.f38455g, 0, a.d(bArr, 0, this.f38455g, 0, this.f38457i));
                    this.f38450b = 0;
                    return;
                }
                return;
            }
            byte[] bArr2 = this.f38451c;
            int i13 = this.f38450b;
            int i14 = i13 + 1;
            this.f38450b = i14;
            bArr2[i13] = (byte) i10;
            int i15 = this.f38452d;
            if (i14 >= i15) {
                ((FilterOutputStream) this).out.write(a.f(this.f38455g, bArr2, i15, this.f38457i));
                int i16 = this.f38453e + 4;
                this.f38453e = i16;
                if (this.f38454f && i16 >= 76) {
                    ((FilterOutputStream) this).out.write(10);
                    this.f38453e = 0;
                }
                this.f38450b = 0;
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            if (this.f38456h) {
                ((FilterOutputStream) this).out.write(bArr, i10, i11);
                return;
            }
            for (int i12 = 0; i12 < i11; i12++) {
                write(bArr[i10 + i12]);
            }
        }
    }
}
