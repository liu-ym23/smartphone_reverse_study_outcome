package L4;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import org.libpag.BuildConfig;
import r4.C1020c;

/* loaded from: classes.dex */
public final class e implements g, f, Cloneable, ByteChannel {

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f3936c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f3937d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public t f3938a;

    /* renamed from: b, reason: collision with root package name */
    private long f3939b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(j4.g gVar) {
            this();
        }
    }

    public static final class c extends OutputStream {
        c() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return e.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i5) {
            e.this.writeByte(i5);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            j4.k.h(bArr, "data");
            e.this.write(bArr, i5, i6);
        }
    }

    static {
        byte[] bytes = "0123456789abcdef".getBytes(C1020c.f20083b);
        j4.k.c(bytes, "(this as java.lang.String).getBytes(charset)");
        f3936c = bytes;
    }

    public static /* bridge */ /* synthetic */ int V(e eVar, p pVar, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return eVar.U(pVar, z5);
    }

    public final byte A(long j5) {
        L4.c.b(this.f3939b, j5, 1L);
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
            throw null;
        }
        if (size() - j5 < j5) {
            long size = size();
            while (size > j5) {
                tVar = tVar.f3980g;
                if (tVar == null) {
                    j4.k.p();
                }
                size -= tVar.f3976c - tVar.f3975b;
            }
            return tVar.f3974a[(int) ((tVar.f3975b + j5) - size)];
        }
        long j6 = 0;
        while (true) {
            int i5 = tVar.f3976c;
            int i6 = tVar.f3975b;
            long j7 = (i5 - i6) + j6;
            if (j7 > j5) {
                return tVar.f3974a[(int) ((i6 + j5) - j6)];
            }
            tVar = tVar.f3979f;
            if (tVar == null) {
                j4.k.p();
            }
            j6 = j7;
        }
    }

    public long C(byte b6, long j5, long j6) {
        t tVar;
        int i5;
        long size = 0;
        if (0 > j5 || j6 < j5) {
            throw new IllegalArgumentException(("size=" + this.f3939b + " fromIndex=" + j5 + " toIndex=" + j6).toString());
        }
        long j7 = this.f3939b;
        if (j6 > j7) {
            j6 = j7;
        }
        if (j5 == j6 || (tVar = this.f3938a) == null) {
            return -1L;
        }
        if (size() - j5 < j5) {
            size = size();
            while (size > j5) {
                tVar = tVar.f3980g;
                if (tVar == null) {
                    j4.k.p();
                }
                size -= tVar.f3976c - tVar.f3975b;
            }
            while (size < j6) {
                byte[] bArr = tVar.f3974a;
                int iMin = (int) Math.min(tVar.f3976c, (tVar.f3975b + j6) - size);
                i5 = (int) ((tVar.f3975b + j5) - size);
                while (i5 < iMin) {
                    if (bArr[i5] != b6) {
                        i5++;
                    }
                }
                size += tVar.f3976c - tVar.f3975b;
                tVar = tVar.f3979f;
                if (tVar == null) {
                    j4.k.p();
                }
                j5 = size;
            }
            return -1L;
        }
        while (true) {
            long j8 = (tVar.f3976c - tVar.f3975b) + size;
            if (j8 > j5) {
                break;
            }
            tVar = tVar.f3979f;
            if (tVar == null) {
                j4.k.p();
            }
            size = j8;
        }
        while (size < j6) {
            byte[] bArr2 = tVar.f3974a;
            int iMin2 = (int) Math.min(tVar.f3976c, (tVar.f3975b + j6) - size);
            i5 = (int) ((tVar.f3975b + j5) - size);
            while (i5 < iMin2) {
                if (bArr2[i5] != b6) {
                    i5++;
                }
            }
            size += tVar.f3976c - tVar.f3975b;
            tVar = tVar.f3979f;
            if (tVar == null) {
                j4.k.p();
            }
            j5 = size;
        }
        return -1L;
        return (i5 - tVar.f3975b) + size;
    }

    public OutputStream D() {
        return new c();
    }

    public byte[] E() {
        return g0(this.f3939b);
    }

    public h G() {
        return new h(E());
    }

    public int I() {
        return L4.c.c(readInt());
    }

    @Override // L4.g
    public int J(p pVar) throws EOFException {
        j4.k.h(pVar, "options");
        int iV = V(this, pVar, false, 2, null);
        if (iV == -1) {
            return -1;
        }
        skip(pVar.f()[iV].w());
        return iV;
    }

    @Override // L4.g
    public String K(Charset charset) {
        j4.k.h(charset, "charset");
        return N(this.f3939b, charset);
    }

    public short L() {
        return L4.c.d(readShort());
    }

    public String N(long j5, Charset charset) throws EOFException {
        j4.k.h(charset, "charset");
        if (j5 < 0 || j5 > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        }
        if (this.f3939b < j5) {
            throw new EOFException();
        }
        if (j5 == 0) {
            return BuildConfig.FLAVOR;
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        int i5 = tVar.f3975b;
        if (i5 + j5 > tVar.f3976c) {
            return new String(g0(j5), charset);
        }
        int i6 = (int) j5;
        String str = new String(tVar.f3974a, i5, i6, charset);
        int i7 = tVar.f3975b + i6;
        tVar.f3975b = i7;
        this.f3939b -= j5;
        if (i7 == tVar.f3976c) {
            this.f3938a = tVar.b();
            u.a(tVar);
        }
        return str;
    }

    public String O() {
        return N(this.f3939b, C1020c.f20083b);
    }

    public String S(long j5) {
        return N(j5, C1020c.f20083b);
    }

    public final String T(long j5) throws EOFException {
        if (j5 > 0) {
            long j6 = j5 - 1;
            if (A(j6) == ((byte) 13)) {
                String strS = S(j6);
                skip(2L);
                return strS;
            }
        }
        String strS2 = S(j5);
        skip(1L);
        return strS2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        if (r19 == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0082, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int U(L4.p r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L4.e.U(L4.p, boolean):int");
    }

    public final void W(long j5) {
        this.f3939b = j5;
    }

    public final h X() {
        long j5 = this.f3939b;
        if (j5 <= Integer.MAX_VALUE) {
            return Y((int) j5);
        }
        throw new IllegalStateException(("size > Integer.MAX_VALUE: " + this.f3939b).toString());
    }

    public final h Y(int i5) {
        return i5 == 0 ? h.f3942d : new v(this, i5);
    }

    @Override // L4.y
    public z b() {
        return z.f3988d;
    }

    @Override // L4.g
    public String b0() {
        return y(Long.MAX_VALUE);
    }

    public final t c0(int i5) {
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            t tVarB = u.b();
            this.f3938a = tVarB;
            tVarB.f3980g = tVarB;
            tVarB.f3979f = tVarB;
            return tVarB;
        }
        if (tVar == null) {
            j4.k.p();
        }
        t tVar2 = tVar.f3980g;
        if (tVar2 == null) {
            j4.k.p();
        }
        return (tVar2.f3976c + i5 > 8192 || !tVar2.f3978e) ? tVar2.c(u.b()) : tVar2;
    }

    @Override // L4.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // L4.f
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public e R(h hVar) {
        j4.k.h(hVar, "byteString");
        hVar.E(this);
        return this;
    }

    @Override // L4.y
    public long e(e eVar, long j5) {
        j4.k.h(eVar, "sink");
        if (j5 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j5).toString());
        }
        long j6 = this.f3939b;
        if (j6 == 0) {
            return -1L;
        }
        if (j5 > j6) {
            j5 = j6;
        }
        eVar.y0(this, j5);
        return j5;
    }

    @Override // L4.g
    public long e0(w wVar) {
        j4.k.h(wVar, "sink");
        long j5 = this.f3939b;
        if (j5 > 0) {
            wVar.y0(this, j5);
        }
        return j5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        long j5 = this.f3939b;
        e eVar = (e) obj;
        if (j5 != eVar.f3939b) {
            return false;
        }
        if (j5 == 0) {
            return true;
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        t tVar2 = eVar.f3938a;
        if (tVar2 == null) {
            j4.k.p();
        }
        int i5 = tVar.f3975b;
        int i6 = tVar2.f3975b;
        long j6 = 0;
        while (j6 < this.f3939b) {
            long jMin = Math.min(tVar.f3976c - i5, tVar2.f3976c - i6);
            long j7 = 0;
            while (j7 < jMin) {
                int i7 = i5 + 1;
                int i8 = i6 + 1;
                if (tVar.f3974a[i5] != tVar2.f3974a[i6]) {
                    return false;
                }
                j7++;
                i5 = i7;
                i6 = i8;
            }
            if (i5 == tVar.f3976c) {
                tVar = tVar.f3979f;
                if (tVar == null) {
                    j4.k.p();
                }
                i5 = tVar.f3975b;
            }
            if (i6 == tVar2.f3976c) {
                tVar2 = tVar2.f3979f;
                if (tVar2 == null) {
                    j4.k.p();
                }
                i6 = tVar2.f3975b;
            }
            j6 += jMin;
        }
        return true;
    }

    @Override // L4.f, L4.w, java.io.Flushable
    public void flush() {
    }

    @Override // L4.g
    public byte[] g0(long j5) throws EOFException {
        if (j5 < 0 || j5 > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(("byteCount: " + j5).toString());
        }
        if (this.f3939b < j5) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j5];
        readFully(bArr);
        return bArr;
    }

    @Override // L4.f
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public e write(byte[] bArr) {
        j4.k.h(bArr, "source");
        return write(bArr, 0, bArr.length);
    }

    public int hashCode() {
        t tVar = this.f3938a;
        if (tVar == null) {
            return 0;
        }
        int i5 = 1;
        do {
            int i6 = tVar.f3976c;
            for (int i7 = tVar.f3975b; i7 < i6; i7++) {
                i5 = (i5 * 31) + tVar.f3974a[i7];
            }
            tVar = tVar.f3979f;
            if (tVar == null) {
                j4.k.p();
            }
        } while (tVar != this.f3938a);
        return i5;
    }

    @Override // L4.f
    public e i() {
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // L4.g
    public h j(long j5) {
        return new h(g0(j5));
    }

    @Override // L4.f
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public e write(byte[] bArr, int i5, int i6) {
        j4.k.h(bArr, "source");
        long j5 = i6;
        L4.c.b(bArr.length, i5, j5);
        int i7 = i6 + i5;
        while (i5 < i7) {
            t tVarC0 = c0(1);
            int iMin = Math.min(i7 - i5, 8192 - tVarC0.f3976c);
            System.arraycopy(bArr, i5, tVarC0.f3974a, tVarC0.f3976c, iMin);
            i5 += iMin;
            tVarC0.f3976c += iMin;
        }
        this.f3939b += j5;
        return this;
    }

    public long k0(y yVar) {
        j4.k.h(yVar, "source");
        long j5 = 0;
        while (true) {
            long jE = yVar.e(this, 8192);
            if (jE == -1) {
                return j5;
            }
            j5 += jE;
        }
    }

    @Override // L4.f
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public e writeByte(int i5) {
        t tVarC0 = c0(1);
        byte[] bArr = tVarC0.f3974a;
        int i6 = tVarC0.f3976c;
        tVarC0.f3976c = i6 + 1;
        bArr[i6] = (byte) i5;
        this.f3939b++;
        return this;
    }

    @Override // L4.f
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public e r0(long j5) {
        boolean z5;
        if (j5 == 0) {
            return writeByte(48);
        }
        int i5 = 1;
        if (j5 < 0) {
            j5 = -j5;
            if (j5 < 0) {
                return H("-9223372036854775808");
            }
            z5 = true;
        } else {
            z5 = false;
        }
        if (j5 >= 100000000) {
            i5 = j5 < 1000000000000L ? j5 < 10000000000L ? j5 < 1000000000 ? 9 : 10 : j5 < 100000000000L ? 11 : 12 : j5 < 1000000000000000L ? j5 < 10000000000000L ? 13 : j5 < 100000000000000L ? 14 : 15 : j5 < 100000000000000000L ? j5 < 10000000000000000L ? 16 : 17 : j5 < 1000000000000000000L ? 18 : 19;
        } else if (j5 >= 10000) {
            i5 = j5 < 1000000 ? j5 < 100000 ? 5 : 6 : j5 < 10000000 ? 7 : 8;
        } else if (j5 >= 100) {
            i5 = j5 < 1000 ? 3 : 4;
        } else if (j5 >= 10) {
            i5 = 2;
        }
        if (z5) {
            i5++;
        }
        t tVarC0 = c0(i5);
        byte[] bArr = tVarC0.f3974a;
        int i6 = tVarC0.f3976c + i5;
        while (j5 != 0) {
            long j6 = 10;
            i6--;
            bArr[i6] = f3936c[(int) (j5 % j6)];
            j5 /= j6;
        }
        if (z5) {
            bArr[i6 - 1] = (byte) 45;
        }
        tVarC0.f3976c += i5;
        this.f3939b += i5;
        return this;
    }

    @Override // L4.f
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public e Q(long j5) {
        if (j5 == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j5)) / 4) + 1;
        t tVarC0 = c0(iNumberOfTrailingZeros);
        byte[] bArr = tVarC0.f3974a;
        int i5 = tVarC0.f3976c;
        for (int i6 = (i5 + iNumberOfTrailingZeros) - 1; i6 >= i5; i6--) {
            bArr[i6] = f3936c[(int) (15 & j5)];
            j5 >>>= 4;
        }
        tVarC0.f3976c += iNumberOfTrailingZeros;
        this.f3939b += iNumberOfTrailingZeros;
        return this;
    }

    @Override // L4.f
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public e writeInt(int i5) {
        t tVarC0 = c0(4);
        byte[] bArr = tVarC0.f3974a;
        int i6 = tVarC0.f3976c;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i5 >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i5 & 255);
        tVarC0.f3976c = i6 + 4;
        this.f3939b += 4;
        return this;
    }

    @Override // L4.f
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public e writeShort(int i5) {
        t tVarC0 = c0(2);
        byte[] bArr = tVarC0.f3974a;
        int i6 = tVarC0.f3976c;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i5 & 255);
        tVarC0.f3976c = i6 + 2;
        this.f3939b += 2;
        return this;
    }

    @Override // L4.g
    public void q0(long j5) throws EOFException {
        if (this.f3939b < j5) {
            throw new EOFException();
        }
    }

    public int read(byte[] bArr, int i5, int i6) {
        j4.k.h(bArr, "sink");
        L4.c.b(bArr.length, i5, i6);
        t tVar = this.f3938a;
        if (tVar == null) {
            return -1;
        }
        int iMin = Math.min(i6, tVar.f3976c - tVar.f3975b);
        System.arraycopy(tVar.f3974a, tVar.f3975b, bArr, i5, iMin);
        int i7 = tVar.f3975b + iMin;
        tVar.f3975b = i7;
        this.f3939b -= iMin;
        if (i7 == tVar.f3976c) {
            this.f3938a = tVar.b();
            u.a(tVar);
        }
        return iMin;
    }

    @Override // L4.g
    public byte readByte() throws EOFException {
        if (this.f3939b == 0) {
            throw new EOFException();
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        int i5 = tVar.f3975b;
        int i6 = tVar.f3976c;
        int i7 = i5 + 1;
        byte b6 = tVar.f3974a[i5];
        this.f3939b--;
        if (i7 != i6) {
            tVar.f3975b = i7;
            return b6;
        }
        this.f3938a = tVar.b();
        u.a(tVar);
        return b6;
    }

    @Override // L4.g
    public void readFully(byte[] bArr) throws EOFException {
        j4.k.h(bArr, "sink");
        int i5 = 0;
        while (i5 < bArr.length) {
            int i6 = read(bArr, i5, bArr.length - i5);
            if (i6 == -1) {
                throw new EOFException();
            }
            i5 += i6;
        }
    }

    @Override // L4.g
    public int readInt() throws EOFException {
        if (this.f3939b < 4) {
            throw new EOFException();
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        int i5 = tVar.f3975b;
        int i6 = tVar.f3976c;
        if (i6 - i5 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = tVar.f3974a;
        int i7 = i5 + 3;
        int i8 = ((bArr[i5 + 1] & 255) << 16) | ((bArr[i5] & 255) << 24) | ((bArr[i5 + 2] & 255) << 8);
        int i9 = i5 + 4;
        int i10 = (bArr[i7] & 255) | i8;
        this.f3939b -= 4;
        if (i9 != i6) {
            tVar.f3975b = i9;
            return i10;
        }
        this.f3938a = tVar.b();
        u.a(tVar);
        return i10;
    }

    @Override // L4.g
    public short readShort() throws EOFException {
        if (this.f3939b < 2) {
            throw new EOFException();
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        int i5 = tVar.f3975b;
        int i6 = tVar.f3976c;
        if (i6 - i5 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = tVar.f3974a;
        int i7 = i5 + 1;
        int i8 = (bArr[i5] & 255) << 8;
        int i9 = i5 + 2;
        int i10 = (bArr[i7] & 255) | i8;
        this.f3939b -= 2;
        if (i9 == i6) {
            this.f3938a = tVar.b();
            u.a(tVar);
        } else {
            tVar.f3975b = i9;
        }
        return (short) i10;
    }

    @Override // L4.g
    public e s() {
        return this;
    }

    public e s0(String str, int i5, int i6, Charset charset) {
        j4.k.h(str, "string");
        j4.k.h(charset, "charset");
        if (i5 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i5).toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i6 + " < " + i5).toString());
        }
        if (i6 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i6 + " > " + str.length()).toString());
        }
        if (j4.k.b(charset, C1020c.f20083b)) {
            return w0(str, i5, i6);
        }
        String strSubstring = str.substring(i5, i6);
        j4.k.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (strSubstring == null) {
            throw new V3.s("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strSubstring.getBytes(charset);
        j4.k.c(bytes, "(this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    public final long size() {
        return this.f3939b;
    }

    @Override // L4.g
    public void skip(long j5) throws EOFException {
        while (j5 > 0) {
            t tVar = this.f3938a;
            if (tVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j5, tVar.f3976c - tVar.f3975b);
            long j6 = iMin;
            this.f3939b -= j6;
            j5 -= j6;
            int i5 = tVar.f3975b + iMin;
            tVar.f3975b = i5;
            if (i5 == tVar.f3976c) {
                this.f3938a = tVar.b();
                u.a(tVar);
            }
        }
    }

    @Override // L4.g
    public boolean t() {
        return this.f3939b == 0;
    }

    public String toString() {
        return X().toString();
    }

    public final void u() throws EOFException {
        skip(this.f3939b);
    }

    @Override // L4.f
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public e H(String str) {
        j4.k.h(str, "string");
        return w0(str, 0, str.length());
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public e clone() {
        e eVar = new e();
        if (this.f3939b == 0) {
            return eVar;
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        t tVarD = tVar.d();
        eVar.f3938a = tVarD;
        if (tVarD == null) {
            j4.k.p();
        }
        t tVar2 = eVar.f3938a;
        tVarD.f3980g = tVar2;
        if (tVar2 == null) {
            j4.k.p();
        }
        t tVar3 = eVar.f3938a;
        if (tVar3 == null) {
            j4.k.p();
        }
        tVar2.f3979f = tVar3.f3980g;
        t tVar4 = this.f3938a;
        if (tVar4 == null) {
            j4.k.p();
        }
        for (t tVar5 = tVar4.f3979f; tVar5 != this.f3938a; tVar5 = tVar5.f3979f) {
            t tVar6 = eVar.f3938a;
            if (tVar6 == null) {
                j4.k.p();
            }
            t tVar7 = tVar6.f3980g;
            if (tVar7 == null) {
                j4.k.p();
            }
            if (tVar5 == null) {
                j4.k.p();
            }
            tVar7.c(tVar5.d());
        }
        eVar.f3939b = this.f3939b;
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ae A[EDGE_INSN: B:46:0x00ae->B:40:0x00ae BREAK  A[LOOP:0: B:5:0x000b->B:48:?], SYNTHETIC] */
    @Override // L4.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long v0() throws java.io.EOFException {
        /*
            r14 = this;
            long r0 = r14.f3939b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lb5
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            L4.t r6 = r14.f3938a
            if (r6 != 0) goto L12
            j4.k.p()
        L12:
            byte[] r7 = r6.f3974a
            int r8 = r6.f3975b
            int r9 = r6.f3976c
        L18:
            if (r8 >= r9) goto L9a
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L7b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L7b
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            L4.e r14 = new L4.e
            r14.<init>()
            L4.e r14 = r14.Q(r4)
            L4.e r14 = r14.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r14 = r14.O()
            r1.append(r14)
            java.lang.String r14 = r1.toString()
            r0.<init>(r14)
            throw r0
        L7b:
            if (r0 == 0) goto L7f
            r1 = 1
            goto L9a
        L7f:
            java.lang.NumberFormatException r14 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = java.lang.Integer.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        L9a:
            if (r8 != r9) goto La6
            L4.t r7 = r6.b()
            r14.f3938a = r7
            L4.u.a(r6)
            goto La8
        La6:
            r6.f3975b = r8
        La8:
            if (r1 != 0) goto Lae
            L4.t r6 = r14.f3938a
            if (r6 != 0) goto Lb
        Lae:
            long r1 = r14.f3939b
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f3939b = r1
            return r4
        Lb5:
            java.io.EOFException r14 = new java.io.EOFException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: L4.e.v0():long");
    }

    public final long w() {
        long j5 = this.f3939b;
        if (j5 == 0) {
            return 0L;
        }
        t tVar = this.f3938a;
        if (tVar == null) {
            j4.k.p();
        }
        t tVar2 = tVar.f3980g;
        if (tVar2 == null) {
            j4.k.p();
        }
        return (tVar2.f3976c >= 8192 || !tVar2.f3978e) ? j5 : j5 - (r2 - tVar2.f3975b);
    }

    public e w0(String str, int i5, int i6) {
        j4.k.h(str, "string");
        if (i5 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i5).toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i6 + " < " + i5).toString());
        }
        if (i6 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i6 + " > " + str.length()).toString());
        }
        while (i5 < i6) {
            char cCharAt = str.charAt(i5);
            if (cCharAt < 128) {
                t tVarC0 = c0(1);
                byte[] bArr = tVarC0.f3974a;
                int i7 = tVarC0.f3976c - i5;
                int iMin = Math.min(i6, 8192 - i7);
                int i8 = i5 + 1;
                bArr[i5 + i7] = (byte) cCharAt;
                while (i8 < iMin) {
                    char cCharAt2 = str.charAt(i8);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i8 + i7] = (byte) cCharAt2;
                    i8++;
                }
                int i9 = tVarC0.f3976c;
                int i10 = (i7 + i8) - i9;
                tVarC0.f3976c = i9 + i10;
                this.f3939b += i10;
                i5 = i8;
            } else {
                if (cCharAt < 2048) {
                    t tVarC02 = c0(2);
                    byte[] bArr2 = tVarC02.f3974a;
                    int i11 = tVarC02.f3976c;
                    bArr2[i11] = (byte) ((cCharAt >> 6) | 192);
                    bArr2[i11 + 1] = (byte) ((cCharAt & '?') | 128);
                    tVarC02.f3976c = i11 + 2;
                    this.f3939b += 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    t tVarC03 = c0(3);
                    byte[] bArr3 = tVarC03.f3974a;
                    int i12 = tVarC03.f3976c;
                    bArr3[i12] = (byte) ((cCharAt >> '\f') | 224);
                    bArr3[i12 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                    bArr3[i12 + 2] = (byte) ((cCharAt & '?') | 128);
                    tVarC03.f3976c = i12 + 3;
                    this.f3939b += 3;
                } else {
                    int i13 = i5 + 1;
                    char cCharAt3 = i13 < i6 ? str.charAt(i13) : (char) 0;
                    if (cCharAt > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        writeByte(63);
                        i5 = i13;
                    } else {
                        int i14 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        t tVarC04 = c0(4);
                        byte[] bArr4 = tVarC04.f3974a;
                        int i15 = tVarC04.f3976c;
                        bArr4[i15] = (byte) ((i14 >> 18) | 240);
                        bArr4[i15 + 1] = (byte) (((i14 >> 12) & 63) | 128);
                        bArr4[i15 + 2] = (byte) (((i14 >> 6) & 63) | 128);
                        bArr4[i15 + 3] = (byte) ((i14 & 63) | 128);
                        tVarC04.f3976c = i15 + 4;
                        this.f3939b += 4;
                        i5 += 2;
                    }
                }
                i5++;
            }
        }
        return this;
    }

    public final e x(e eVar, long j5, long j6) {
        j4.k.h(eVar, "out");
        long j7 = j5;
        L4.c.b(this.f3939b, j7, j6);
        if (j6 != 0) {
            eVar.f3939b += j6;
            t tVar = this.f3938a;
            while (true) {
                if (tVar == null) {
                    j4.k.p();
                }
                int i5 = tVar.f3976c;
                int i6 = tVar.f3975b;
                if (j7 < i5 - i6) {
                    break;
                }
                j7 -= i5 - i6;
                tVar = tVar.f3979f;
            }
            t tVar2 = tVar;
            long j8 = j6;
            while (j8 > 0) {
                if (tVar2 == null) {
                    j4.k.p();
                }
                t tVarD = tVar2.d();
                int i7 = tVarD.f3975b + ((int) j7);
                tVarD.f3975b = i7;
                tVarD.f3976c = Math.min(i7 + ((int) j8), tVarD.f3976c);
                t tVar3 = eVar.f3938a;
                if (tVar3 == null) {
                    tVarD.f3980g = tVarD;
                    tVarD.f3979f = tVarD;
                    eVar.f3938a = tVarD;
                } else {
                    if (tVar3 == null) {
                        j4.k.p();
                    }
                    t tVar4 = tVar3.f3980g;
                    if (tVar4 == null) {
                        j4.k.p();
                    }
                    tVar4.c(tVarD);
                }
                j8 -= tVarD.f3976c - tVarD.f3975b;
                tVar2 = tVar2.f3979f;
                j7 = 0;
            }
        }
        return this;
    }

    @Override // L4.g
    public InputStream x0() {
        return new b();
    }

    @Override // L4.g
    public String y(long j5) throws EOFException {
        if (j5 < 0) {
            throw new IllegalArgumentException(("limit < 0: " + j5).toString());
        }
        long j6 = j5 != Long.MAX_VALUE ? j5 + 1 : Long.MAX_VALUE;
        byte b6 = (byte) 10;
        long jC = C(b6, 0L, j6);
        if (jC != -1) {
            return T(jC);
        }
        if (j6 < this.f3939b && A(j6 - 1) == ((byte) 13) && A(j6) == b6) {
            return T(j6);
        }
        e eVar = new e();
        x(eVar, 0L, Math.min(32, this.f3939b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f3939b, j5) + " content=" + eVar.G().n() + (char) 8230);
    }

    @Override // L4.w
    public void y0(e eVar, long j5) {
        t tVar;
        j4.k.h(eVar, "source");
        if (eVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        L4.c.b(eVar.f3939b, 0L, j5);
        while (j5 > 0) {
            t tVar2 = eVar.f3938a;
            if (tVar2 == null) {
                j4.k.p();
            }
            int i5 = tVar2.f3976c;
            if (eVar.f3938a == null) {
                j4.k.p();
            }
            if (j5 < i5 - r1.f3975b) {
                t tVar3 = this.f3938a;
                if (tVar3 != null) {
                    if (tVar3 == null) {
                        j4.k.p();
                    }
                    tVar = tVar3.f3980g;
                } else {
                    tVar = null;
                }
                if (tVar != null && tVar.f3978e) {
                    if ((tVar.f3976c + j5) - (tVar.f3977d ? 0 : tVar.f3975b) <= 8192) {
                        t tVar4 = eVar.f3938a;
                        if (tVar4 == null) {
                            j4.k.p();
                        }
                        tVar4.f(tVar, (int) j5);
                        eVar.f3939b -= j5;
                        this.f3939b += j5;
                        return;
                    }
                }
                t tVar5 = eVar.f3938a;
                if (tVar5 == null) {
                    j4.k.p();
                }
                eVar.f3938a = tVar5.e((int) j5);
            }
            t tVar6 = eVar.f3938a;
            if (tVar6 == null) {
                j4.k.p();
            }
            long j6 = tVar6.f3976c - tVar6.f3975b;
            eVar.f3938a = tVar6.b();
            t tVar7 = this.f3938a;
            if (tVar7 == null) {
                this.f3938a = tVar6;
                tVar6.f3980g = tVar6;
                tVar6.f3979f = tVar6;
            } else {
                if (tVar7 == null) {
                    j4.k.p();
                }
                t tVar8 = tVar7.f3980g;
                if (tVar8 == null) {
                    j4.k.p();
                }
                tVar8.c(tVar6).a();
            }
            eVar.f3939b -= j6;
            this.f3939b += j6;
            j5 -= j6;
        }
    }

    public e z0(int i5) {
        if (i5 < 128) {
            writeByte(i5);
            return this;
        }
        if (i5 < 2048) {
            t tVarC0 = c0(2);
            byte[] bArr = tVarC0.f3974a;
            int i6 = tVarC0.f3976c;
            bArr[i6] = (byte) ((i5 >> 6) | 192);
            bArr[i6 + 1] = (byte) ((i5 & 63) | 128);
            tVarC0.f3976c = i6 + 2;
            this.f3939b += 2;
            return this;
        }
        if (55296 <= i5 && 57343 >= i5) {
            writeByte(63);
            return this;
        }
        if (i5 < 65536) {
            t tVarC02 = c0(3);
            byte[] bArr2 = tVarC02.f3974a;
            int i7 = tVarC02.f3976c;
            bArr2[i7] = (byte) ((i5 >> 12) | 224);
            bArr2[i7 + 1] = (byte) (((i5 >> 6) & 63) | 128);
            bArr2[i7 + 2] = (byte) ((i5 & 63) | 128);
            tVarC02.f3976c = i7 + 3;
            this.f3939b += 3;
            return this;
        }
        if (i5 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i5));
        }
        t tVarC03 = c0(4);
        byte[] bArr3 = tVarC03.f3974a;
        int i8 = tVarC03.f3976c;
        bArr3[i8] = (byte) ((i5 >> 18) | 240);
        bArr3[i8 + 1] = (byte) (((i5 >> 12) & 63) | 128);
        bArr3[i8 + 2] = (byte) (((i5 >> 6) & 63) | 128);
        bArr3[i8 + 3] = (byte) ((i5 & 63) | 128);
        tVarC03.f3976c = i8 + 4;
        this.f3939b += 4;
        return this;
    }

    public static final class b extends InputStream {
        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(e.this.size(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (e.this.size() > 0) {
                return e.this.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return e.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            j4.k.h(bArr, "sink");
            return e.this.read(bArr, i5, i6);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        j4.k.h(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i5 = iRemaining;
        while (i5 > 0) {
            t tVarC0 = c0(1);
            int iMin = Math.min(i5, 8192 - tVarC0.f3976c);
            byteBuffer.get(tVarC0.f3974a, tVarC0.f3976c, iMin);
            i5 -= iMin;
            tVarC0.f3976c += iMin;
        }
        this.f3939b += iRemaining;
        return iRemaining;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        j4.k.h(byteBuffer, "sink");
        t tVar = this.f3938a;
        if (tVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), tVar.f3976c - tVar.f3975b);
        byteBuffer.put(tVar.f3974a, tVar.f3975b, iMin);
        int i5 = tVar.f3975b + iMin;
        tVar.f3975b = i5;
        this.f3939b -= iMin;
        if (i5 == tVar.f3976c) {
            this.f3938a = tVar.b();
            u.a(tVar);
        }
        return iMin;
    }
}
