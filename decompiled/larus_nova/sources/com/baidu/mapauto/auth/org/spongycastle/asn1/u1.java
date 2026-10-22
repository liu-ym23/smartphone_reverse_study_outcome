package com.baidu.mapauto.auth.org.spongycastle.asn1;

import androidx.collection.SieveCacheKt;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes39.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f31894a = 0;

    static {
        f31894a = Runtime.getRuntime().maxMemory();
    }

    public static int a(int r100) {
        int r101 = 1;
        if (r100 <= 127) goto L11;
        int r102 = 1;
    L5:
        r100 = r100 >>> 8;
        if (r100 == 0) goto L8;
        r102 = r102 + 1;
        goto L5
    L8:
        int r103 = (r102 - 1) * 8;
    L9:
        if (r103 < 0) goto L11;
        r101 = r101 + 1;
        r103 = r103 - 8;
    L11:
        return r101;
    }

    public static int b(int r100) throws IOException {
        if (r100 >= 31) goto L5;
        return 1;
    L5:
        if (r100 >= 128) goto L7;
        return 2;
    L7:
        byte[] r101 = new byte[5];
        int r102 = 4;
    L8:
        r100 = r100 >> 7;
        r102 = r102 - 1;
        r101[r102] = (byte) ((r100 & 127) | 128);
        if (r100 > 127) goto L8;
        return 1 + (5 - r102);
    }

    public static int a(InputStream r100) {
        if ((r100 instanceof t1) == false) goto L7;
        return ((t1) r100).a();
    L7:
        if ((r100 instanceof i) == false) goto L11;
        return ((i) r100).f31840a;
    L11:
        if ((r100 instanceof ByteArrayInputStream) == false) goto L15;
        return ((ByteArrayInputStream) r100).available();
    L15:
        if ((r100 instanceof FileInputStream) == true) goto L32;
    L26:
        long r101 = f31894a;
        if (r101 <= SieveCacheKt.NodeLinkMask) goto L31;
        return Integer.MAX_VALUE;
    L31:
        return (int) r101;
    L32:
        FileChannel r102 = ((FileInputStream) r100).getChannel();     // Catch: IOException -> L25
        if (r102 == null) goto L20;
        long r103 = r102.size();     // Catch: IOException -> L25
    L22:
        if (r103 >= SieveCacheKt.NodeLinkMask) goto L26;
        return (int) r103;
    L20:
        r103 = 2147483647L;
        goto L22
    }
}
