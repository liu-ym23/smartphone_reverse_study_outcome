package com.autonavi.aps.protocol.aps.common.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class e {
    public static int a(byte b10) {
        return b10 & 255;
    }

    public static byte[] b(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i10 = gZIPInputStream.read(bArr2, 0, 1024);
            if (i10 == -1) {
                gZIPInputStream.close();
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr2, 0, i10);
        }
    }

    public static byte[] a(byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[1024];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        while (true) {
            int i10 = byteArrayInputStream.read(bArr2, 0, 1024);
            if (i10 == -1) {
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return byteArray;
            }
            gZIPOutputStream.write(bArr2, 0, i10);
        }
    }

    public static int a(ByteBuffer byteBuffer) {
        byte b10 = byteBuffer.get();
        int i10 = b10 & 127;
        while ((b10 & 128) == 0) {
            b10 = byteBuffer.get();
            i10 = (i10 << 7) | (b10 & 127);
        }
        return i10;
    }

    public static void a(ByteBuffer byteBuffer, int i10) {
        byte[] bArr = new byte[8];
        int i11 = 7;
        while ((i10 & (-128)) != 0) {
            bArr[i11] = (byte) (i10 & 127);
            i10 >>>= 7;
            i11--;
        }
        bArr[i11] = (byte) (i10 & 127);
        bArr[7] = (byte) (bArr[7] | 128);
        while (i11 <= 7) {
            byteBuffer.put(bArr[i11]);
            i11++;
        }
    }
}
