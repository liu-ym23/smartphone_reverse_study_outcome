package org.tukaani.xz.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class EncoderUtil extends Util {
    public static void encodeVLI(OutputStream outputStream, long j4) throws IOException {
        while (j4 >= 128) {
            outputStream.write((byte) (128 | j4));
            j4 >>>= 7;
        }
        outputStream.write((byte) j4);
    }

    public static void writeCRC32(OutputStream outputStream, byte[] bArr) throws IOException {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        for (int i8 = 0; i8 < 4; i8++) {
            outputStream.write((byte) (value >>> (i8 * 8)));
        }
    }
}
