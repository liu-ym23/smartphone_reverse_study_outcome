package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
class DumpArchiveUtil {
    private DumpArchiveUtil() {
    }

    public static int calculateChecksum(byte[] buffer) {
        int calc = 0;
        int i = 0;
    L4:
        if (i >= 256) goto L7;
        calc = calc + convert32(buffer, i * 4);
        i = i + 1;
        goto L4
    L7:
        return DumpArchiveConstants.CHECKSUM - (calc - convert32(buffer, 28));
    }

    public static final boolean verify(byte[] buffer) {
        int magic = convert32(buffer, 24);
        if (magic == 60012) goto L5;
        return false;
    L5:
        int checksum = convert32(buffer, 28);
        if (checksum != calculateChecksum(buffer)) goto L9;
        return true;
    L9:
        return false;
    }

    public static final int getIno(byte[] buffer) {
        return convert32(buffer, 20);
    }

    public static final long convert64(byte[] buffer, int offset) {
        return ByteUtils.fromLittleEndian(buffer, offset, 8);
    }

    public static final int convert32(byte[] buffer, int offset) {
        return (int) ByteUtils.fromLittleEndian(buffer, offset, 4);
    }

    public static final int convert16(byte[] buffer, int offset) {
        return (int) ByteUtils.fromLittleEndian(buffer, offset, 2);
    }

    static String decode(ZipEncoding encoding, byte[] b, int offset, int len) throws IOException {
        return encoding.decode(Arrays.copyOfRange(b, offset, offset + len));
    }
}
