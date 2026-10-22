package com.amap.api.col.jmsl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class L0 implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f16177f = Charset.forName("US-ASCII");

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f16178a;

    /* renamed from: b, reason: collision with root package name */
    public final Charset f16179b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f16180c;

    /* renamed from: d, reason: collision with root package name */
    public int f16181d;

    /* renamed from: e, reason: collision with root package name */
    public int f16182e;

    public class a extends ByteArrayOutputStream {
        public a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0) {
                int i11 = i10 - 1;
                if (((ByteArrayOutputStream) this).buf[i11] == 13) {
                    i10 = i11;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, L0.this.f16179b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public L0(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f16178a
            monitor-enter(r0)
            byte[] r1 = r7.f16180c     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L83
            int r1 = r7.f16181d     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f16182e     // Catch: java.lang.Throwable -> L11
            if (r1 < r2) goto L14
            r7.g()     // Catch: java.lang.Throwable -> L11
            goto L14
        L11:
            r7 = move-exception
            goto L8b
        L14:
            int r1 = r7.f16181d     // Catch: java.lang.Throwable -> L11
        L16:
            int r2 = r7.f16182e     // Catch: java.lang.Throwable -> L11
            r3 = 10
            if (r1 == r2) goto L45
            byte[] r2 = r7.f16180c     // Catch: java.lang.Throwable -> L11
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L11
            if (r4 != r3) goto L42
            int r3 = r7.f16181d     // Catch: java.lang.Throwable -> L11
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
            java.nio.charset.Charset r6 = r7.f16179b     // Catch: java.lang.Throwable -> L11
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L11
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L11
            int r1 = r1 + 1
            r7.f16181d = r1     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r5
        L42:
            int r1 = r1 + 1
            goto L16
        L45:
            com.amap.api.col.jmsl.L0$a r1 = new com.amap.api.col.jmsl.L0$a     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f16182e     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f16181d     // Catch: java.lang.Throwable -> L11
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
        L51:
            byte[] r2 = r7.f16180c     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f16181d     // Catch: java.lang.Throwable -> L11
            int r5 = r7.f16182e     // Catch: java.lang.Throwable -> L11
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L11
            r2 = -1
            r7.f16182e = r2     // Catch: java.lang.Throwable -> L11
            r7.g()     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f16181d     // Catch: java.lang.Throwable -> L11
        L63:
            int r4 = r7.f16182e     // Catch: java.lang.Throwable -> L11
            if (r2 == r4) goto L51
            byte[] r4 = r7.f16180c     // Catch: java.lang.Throwable -> L11
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L11
            if (r5 != r3) goto L80
            int r3 = r7.f16181d     // Catch: java.lang.Throwable -> L11
            if (r2 == r3) goto L76
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L11
        L76:
            int r2 = r2 + 1
            r7.f16181d = r2     // Catch: java.lang.Throwable -> L11
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
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.L0.b():java.lang.String");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f16178a) {
            try {
                if (this.f16180c != null) {
                    this.f16180c = null;
                    this.f16178a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() throws IOException {
        InputStream inputStream = this.f16178a;
        byte[] bArr = this.f16180c;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 == -1) {
            throw new EOFException();
        }
        this.f16181d = 0;
        this.f16182e = i10;
    }

    public L0(InputStream inputStream, Charset charset, byte b10) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(f16177f)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f16178a = inputStream;
        this.f16179b = charset;
        this.f16180c = new byte[com.stepos.agentframework.chatui.longtext.b.THRESHOLD];
    }
}
