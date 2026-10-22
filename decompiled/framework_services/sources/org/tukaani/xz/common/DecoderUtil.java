package org.tukaani.xz.common;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZFormatException;

/* JADX INFO: loaded from: classes3.dex */
public class DecoderUtil extends Util {
    public DecoderUtil() {
    }

    public static boolean isCRC32Valid(byte[] buf, int off, int len, int ref_off) {
        CRC32 crc32 = new CRC32();
        crc32.update(buf, off, len);
        long value = crc32.getValue();
        int i = 0;
    L4:
        if (i >= 4) goto L10;
        if (((byte) (value >>> (i * 8))) != buf[ref_off + i]) goto L7;
        i = i + 1;
        goto L4
    L7:
        return false;
    L10:
        return true;
    }

    public static StreamFlags decodeStreamHeader(byte[] buf) throws IOException {
        int i = 0;
    L4:
        if (i >= XZ.HEADER_MAGIC.length) goto L11;
        if (buf[i] != XZ.HEADER_MAGIC[i]) goto L9;
        i = i + 1;
        goto L4
    L9:
        throw new XZFormatException();
    L11:
        if (isCRC32Valid(buf, XZ.HEADER_MAGIC.length, 2, XZ.HEADER_MAGIC.length + 2) == false) goto L18;
        return decodeStreamFlags(buf, XZ.HEADER_MAGIC.length);
    L16:
        throw new UnsupportedOptionsException("Unsupported options in XZ Stream Header");
    L18:
        throw new CorruptedInputException("XZ Stream Header is corrupt");
    }

    public static StreamFlags decodeStreamFooter(byte[] buf) throws IOException {
        if (buf[10] != XZ.FOOTER_MAGIC[0]) goto L21;
        if (buf[11] != XZ.FOOTER_MAGIC[1]) goto L21;
        if (isCRC32Valid(buf, 4, 6, 0) == false) goto L19;
        StreamFlags streamFlags = decodeStreamFlags(buf, 8);     // Catch: UnsupportedOptionsException -> L15
        streamFlags.backwardSize = 0;
        int i = 0;
    L11:
        if (i >= 4) goto L13;
        streamFlags.backwardSize |= (long) ((buf[i + 4] & CecDeviceType.INACTIVE) << (i * 8));
        i = i + 1;
        goto L11
    L13:
        streamFlags.backwardSize = (streamFlags.backwardSize + 1) * 4;
        return streamFlags;
    L17:
        throw new UnsupportedOptionsException("Unsupported options in XZ Stream Footer");
    L19:
        throw new CorruptedInputException("XZ Stream Footer is corrupt");
    L21:
        throw new CorruptedInputException("XZ Stream Footer is corrupt");
    }

    private static StreamFlags decodeStreamFlags(byte[] buf, int off) throws UnsupportedOptionsException {
        if (buf[off] != 0) goto L9;
        if ((buf[off + 1] & CecDeviceType.INACTIVE) >= 16) goto L9;
        StreamFlags streamFlags = new StreamFlags();
        streamFlags.checkType = buf[off + 1];
        return streamFlags;
    L9:
        throw new UnsupportedOptionsException();
    }

    public static boolean areStreamFlagsEqual(StreamFlags a, StreamFlags b) {
        if (a.checkType != b.checkType) goto L5;
        return true;
    L5:
        return false;
    }

    public static long decodeVLI(InputStream in) throws IOException {
        int b = in.read();
        if (b == (-1)) goto L21;
        long num = b & 127;
        int i = 0;
    L6:
        if ((b & 128) == 0) goto L19;
        i = i + 1;
        if (i >= 9) goto L18;
        b = in.read();
        if (b == (-1)) goto L16;
        if (b == 0) goto L14;
        num = num | (((long) (b & 127)) << (i * 7));
        goto L6
    L14:
        throw new CorruptedInputException();
    L16:
        throw new EOFException();
    L18:
        throw new CorruptedInputException();
    L19:
        return num;
    L21:
        throw new EOFException();
    }
}
