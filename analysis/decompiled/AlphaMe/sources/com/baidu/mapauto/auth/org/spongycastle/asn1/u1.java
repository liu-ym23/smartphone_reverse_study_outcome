package com.baidu.mapauto.auth.org.spongycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class u1 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f7774a = Runtime.getRuntime().maxMemory();

    public static int a(int i4) {
        int i5 = 1;
        if (i4 > 127) {
            int i6 = 1;
            while (true) {
                i4 >>>= 8;
                if (i4 == 0) {
                    break;
                }
                i6++;
            }
            for (int i7 = (i6 - 1) * 8; i7 >= 0; i7 -= 8) {
                i5++;
            }
        }
        return i5;
    }

    public static int b(int i4) throws IOException {
        if (i4 < 31) {
            return 1;
        }
        if (i4 < 128) {
            return 2;
        }
        byte[] bArr = new byte[5];
        int i5 = 4;
        do {
            i4 >>= 7;
            i5--;
            bArr[i5] = (byte) ((i4 & 127) | 128);
        } while (i4 > 127);
        return 6 - i5;
    }

    public static int a(InputStream inputStream) {
        if (inputStream instanceof t1) {
            return ((t1) inputStream).a();
        }
        if (inputStream instanceof i) {
            return ((i) inputStream).f7720a;
        }
        if (inputStream instanceof ByteArrayInputStream) {
            return ((ByteArrayInputStream) inputStream).available();
        }
        if (inputStream instanceof FileInputStream) {
            try {
                FileChannel channel = ((FileInputStream) inputStream).getChannel();
                long size = channel != null ? channel.size() : 2147483647L;
                if (size < 2147483647L) {
                    return (int) size;
                }
            } catch (IOException unused) {
            }
        }
        long j4 = f7774a;
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j4;
    }
}
