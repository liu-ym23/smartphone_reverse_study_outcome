package org.tukaani.xz.common;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZFormatException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class DecoderUtil extends Util {
    public static boolean areStreamFlagsEqual(StreamFlags streamFlags, StreamFlags streamFlags2) {
        return streamFlags.checkType == streamFlags2.checkType;
    }

    private static StreamFlags decodeStreamFlags(byte[] bArr, int i8) throws UnsupportedOptionsException {
        if (bArr[i8] == 0) {
            int i9 = i8 + 1;
            if ((bArr[i9] & 255) < 16) {
                StreamFlags streamFlags = new StreamFlags();
                streamFlags.checkType = bArr[i9];
                return streamFlags;
            }
        }
        throw new UnsupportedOptionsException();
    }

    public static StreamFlags decodeStreamFooter(byte[] bArr) throws UnsupportedOptionsException, CorruptedInputException {
        byte b9 = bArr[10];
        byte[] bArr2 = XZ.FOOTER_MAGIC;
        if (b9 != bArr2[0] || bArr[11] != bArr2[1]) {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        }
        if (!isCRC32Valid(bArr, 4, 6, 0)) {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        }
        try {
            StreamFlags streamFlagsDecodeStreamFlags = decodeStreamFlags(bArr, 8);
            streamFlagsDecodeStreamFlags.backwardSize = 0L;
            for (int i8 = 0; i8 < 4; i8++) {
                streamFlagsDecodeStreamFlags.backwardSize |= (bArr[i8 + 4] & 255) << (i8 * 8);
            }
            streamFlagsDecodeStreamFlags.backwardSize = (streamFlagsDecodeStreamFlags.backwardSize + 1) * 4;
            return streamFlagsDecodeStreamFlags;
        } catch (UnsupportedOptionsException unused) {
            throw new UnsupportedOptionsException("Unsupported options in XZ Stream Footer");
        }
    }

    public static StreamFlags decodeStreamHeader(byte[] bArr) throws CorruptedInputException, UnsupportedOptionsException, XZFormatException {
        int i8 = 0;
        while (true) {
            byte[] bArr2 = XZ.HEADER_MAGIC;
            if (i8 >= bArr2.length) {
                if (!isCRC32Valid(bArr, bArr2.length, 2, bArr2.length + 2)) {
                    throw new CorruptedInputException("XZ Stream Header is corrupt");
                }
                try {
                    return decodeStreamFlags(bArr, bArr2.length);
                } catch (UnsupportedOptionsException unused) {
                    throw new UnsupportedOptionsException("Unsupported options in XZ Stream Header");
                }
            }
            if (bArr[i8] != bArr2[i8]) {
                throw new XZFormatException();
            }
            i8++;
        }
    }

    public static long decodeVLI(InputStream inputStream) throws IOException {
        int i8 = inputStream.read();
        if (i8 == -1) {
            throw new EOFException();
        }
        long j4 = i8 & 127;
        int i9 = 0;
        while ((i8 & 128) != 0) {
            i9++;
            if (i9 >= 9) {
                throw new CorruptedInputException();
            }
            i8 = inputStream.read();
            if (i8 == -1) {
                throw new EOFException();
            }
            if (i8 == 0) {
                throw new CorruptedInputException();
            }
            j4 |= (i8 & 127) << (i9 * 7);
        }
        return j4;
    }

    public static boolean isCRC32Valid(byte[] bArr, int i8, int i9, int i10) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i8, i9);
        long value = crc32.getValue();
        for (int i11 = 0; i11 < 4; i11++) {
            if (((byte) (value >>> (i11 * 8))) != bArr[i10 + i11]) {
                return false;
            }
        }
        return true;
    }
}
