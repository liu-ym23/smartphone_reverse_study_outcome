package com.amap.api.col.jmsl;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: f, reason: collision with root package name */
    public static final Map<String, H> f16089f = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f16090a;

    /* renamed from: b, reason: collision with root package name */
    public final File f16091b;

    /* renamed from: c, reason: collision with root package name */
    public final long f16092c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16093d;

    /* renamed from: e, reason: collision with root package name */
    public Y f16094e;

    public H(String str, File file, long j10, int i10) {
        this.f16090a = str;
        this.f16091b = file;
        this.f16092c = j10;
        this.f16093d = i10;
    }

    public static H a(File file, long j10, int i10) {
        H h10;
        String str = file.getAbsoluteFile() + "_" + j10 + "_" + i10;
        Map<String, H> map = f16089f;
        H h11 = map.get(str);
        if (h11 != null) {
            return h11;
        }
        synchronized (H.class) {
            try {
                h10 = map.get(str);
                if (h10 == null) {
                    H h12 = new H(str, file, j10, i10);
                    map.put(str, h12);
                    h10 = h12;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return h10;
    }

    public void b(String str, String str2) throws IOException {
        d("st_" + str, str2.getBytes(), -1);
    }

    public void c(String str, byte[] bArr) throws IOException {
        d("by_" + str, bArr, -1);
    }

    public final void d(String str, byte[] bArr, int i10) throws IOException {
        Y yG;
        if (bArr == null || (yG = g()) == null) {
            return;
        }
        if (i10 >= 0) {
            byte[] bytes = String.format(Locale.getDefault(), "_$%010d$_", Long.valueOf((System.currentTimeMillis() / 1000) + i10)).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            bArr = bArr2;
        }
        File fileE = yG.e(str);
        P.c(fileE, bArr, false, true);
        yG.g(fileE);
        yG.c(fileE);
    }

    public boolean e() {
        Y yG = g();
        if (yG == null) {
            return true;
        }
        return yG.d();
    }

    public byte[] f(String str) {
        return i("by_" + str, null);
    }

    public final Y g() {
        if (this.f16091b.exists()) {
            if (this.f16094e == null) {
                this.f16094e = new Y(this.f16091b, this.f16092c, this.f16093d);
            }
        } else if (this.f16091b.mkdirs()) {
            this.f16094e = new Y(this.f16091b, this.f16092c, this.f16093d);
        } else {
            Log.e("CacheDiskUtils", "can't make dirs in " + this.f16091b.getAbsolutePath());
        }
        return this.f16094e;
    }

    public String h(String str) throws Throwable {
        byte[] bArrI = i("st_" + str, null);
        if (bArrI == null) {
            return null;
        }
        return new String(bArrI);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005a A[Catch: IOException -> 0x0033, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x0033, blocks: (B:15:0x002f, B:27:0x004d, B:35:0x005a), top: B:55:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006b  */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.nio.channels.FileChannel, java.nio.channels.spi.AbstractInterruptibleChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x005e -> B:52:0x0061). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] i(java.lang.String r6, byte[] r7) throws java.lang.Throwable {
        /*
            r5 = this;
            com.amap.api.col.jmsl.Y r5 = r5.g()
            if (r5 != 0) goto L7
            goto Ld
        L7:
            java.io.File r0 = r5.h(r6)
            if (r0 != 0) goto Le
        Ld:
            return r7
        Le:
            boolean r1 = com.amap.api.col.jmsl.P.b(r0)
            r2 = 0
            if (r1 != 0) goto L16
            goto L61
        L16:
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            java.lang.String r3 = "r"
            r1.<init>(r0, r3)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            java.nio.channels.FileChannel r1 = r1.getChannel()     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L53
            if (r1 != 0) goto L3a
            java.lang.String r3 = "FileIOUtils"
            java.lang.String r4 = "fc is null."
            android.util.Log.e(r3, r4)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            r3 = 0
            byte[] r2 = new byte[r3]     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            if (r1 == 0) goto L61
            r1.close()     // Catch: java.io.IOException -> L33
            goto L61
        L33:
            r1 = move-exception
            goto L5e
        L35:
            r5 = move-exception
            r2 = r1
            goto L73
        L38:
            r3 = move-exception
            goto L55
        L3a:
            long r3 = r1.size()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
        L43:
            int r4 = r1.read(r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            if (r4 > 0) goto L43
            byte[] r2 = r3.array()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L38
            r1.close()     // Catch: java.io.IOException -> L33
            goto L61
        L51:
            r5 = move-exception
            goto L73
        L53:
            r3 = move-exception
            r1 = r2
        L55:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L35
            if (r1 == 0) goto L61
            r1.close()     // Catch: java.io.IOException -> L33
            goto L61
        L5e:
            r1.printStackTrace()
        L61:
            boolean r1 = com.amap.api.col.jmsl.P.i(r2)
            if (r1 == 0) goto L6b
            r5.j(r6)
            return r7
        L6b:
            r5.g(r0)
            byte[] r5 = com.amap.api.col.jmsl.P.e(r2)
            return r5
        L73:
            if (r2 == 0) goto L7d
            r2.close()     // Catch: java.io.IOException -> L79
            goto L7d
        L79:
            r6 = move-exception
            r6.printStackTrace()
        L7d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.H.i(java.lang.String, byte[]):byte[]");
    }

    public String toString() {
        return this.f16090a + "@" + Integer.toHexString(hashCode());
    }
}
