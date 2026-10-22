package org.tukaani.xz.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
public class EncoderUtil extends Util {
    public EncoderUtil() {
    }

    public static void writeCRC32(OutputStream out, byte[] buf) throws IOException {
        CRC32 crc32 = new CRC32();
        crc32.update(buf);
        long value = crc32.getValue();
        int i = 0;
    L4:
        if (i >= 4) goto L7;
        out.write((byte) (value >>> (i * 8)));
        i = i + 1;
        goto L4
    }

    public static void encodeVLI(OutputStream out, long num) throws IOException {
    L3:
        if (num < 128) goto L5;
        out.write((byte) (128 | num));
        num = num >>> 7;
        goto L3
    L5:
        out.write((byte) num);
    }
}
