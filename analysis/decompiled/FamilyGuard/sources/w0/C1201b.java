package w0;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1201b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final InputStream f23517a;

    /* renamed from: b, reason: collision with root package name */
    private final Charset f23518b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f23519c;

    /* renamed from: d, reason: collision with root package name */
    private int f23520d;

    /* renamed from: e, reason: collision with root package name */
    private int f23521e;

    /* renamed from: w0.b$a */
    class a extends ByteArrayOutputStream {
        a(int i5) {
            super(i5);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i5 = ((ByteArrayOutputStream) this).count;
            if (i5 > 0 && ((ByteArrayOutputStream) this).buf[i5 - 1] == 13) {
                i5--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i5, C1201b.this.f23518b.name());
            } catch (UnsupportedEncodingException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    public C1201b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f23517a;
        byte[] bArr = this.f23519c;
        int i5 = inputStream.read(bArr, 0, bArr.length);
        if (i5 == -1) {
            throw new EOFException();
        }
        this.f23520d = 0;
        this.f23521e = i5;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f23517a) {
            try {
                if (this.f23519c != null) {
                    this.f23519c = null;
                    this.f23517a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean f() {
        return this.f23521e == -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String m() {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f23517a
            monitor-enter(r0)
            byte[] r1 = r7.f23519c     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L83
            int r1 = r7.f23520d     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f23521e     // Catch: java.lang.Throwable -> L11
            if (r1 < r2) goto L14
            r7.c()     // Catch: java.lang.Throwable -> L11
            goto L14
        L11:
            r7 = move-exception
            goto L8b
        L14:
            int r1 = r7.f23520d     // Catch: java.lang.Throwable -> L11
        L16:
            int r2 = r7.f23521e     // Catch: java.lang.Throwable -> L11
            r3 = 10
            if (r1 == r2) goto L45
            byte[] r2 = r7.f23519c     // Catch: java.lang.Throwable -> L11
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L11
            if (r4 != r3) goto L42
            int r3 = r7.f23520d     // Catch: java.lang.Throwable -> L11
            if (r1 == r3) goto L2f
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L11
            r6 = 13
            if (r5 != r6) goto L2f
            goto L30
        L2f:
            r4 = r1
        L30:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L11
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f23518b     // Catch: java.lang.Throwable -> L11
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L11
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L11
            int r1 = r1 + 1
            r7.f23520d = r1     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r5
        L42:
            int r1 = r1 + 1
            goto L16
        L45:
            w0.b$a r1 = new w0.b$a     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f23521e     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f23520d     // Catch: java.lang.Throwable -> L11
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
        L51:
            byte[] r2 = r7.f23519c     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f23520d     // Catch: java.lang.Throwable -> L11
            int r5 = r7.f23521e     // Catch: java.lang.Throwable -> L11
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L11
            r2 = -1
            r7.f23521e = r2     // Catch: java.lang.Throwable -> L11
            r7.c()     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f23520d     // Catch: java.lang.Throwable -> L11
        L63:
            int r4 = r7.f23521e     // Catch: java.lang.Throwable -> L11
            if (r2 == r4) goto L51
            byte[] r4 = r7.f23519c     // Catch: java.lang.Throwable -> L11
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L11
            if (r5 != r3) goto L80
            int r3 = r7.f23520d     // Catch: java.lang.Throwable -> L11
            if (r2 == r3) goto L76
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L11
        L76:
            int r2 = r2 + 1
            r7.f23520d = r2     // Catch: java.lang.Throwable -> L11
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r7
        L80:
            int r2 = r2 + 1
            goto L63
        L83:
            java.io.IOException r7 = new java.io.IOException     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = "LineReader is closed"
            r7.<init>(r1)     // Catch: java.lang.Throwable -> L11
            throw r7     // Catch: java.lang.Throwable -> L11
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.C1201b.m():java.lang.String");
    }

    public C1201b(InputStream inputStream, int i5, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f23523a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f23517a = inputStream;
        this.f23518b = charset;
        this.f23519c = new byte[i5];
    }
}
