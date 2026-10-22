package org.brotli.integration;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class BundleHelper {
    private static final long CRC_64_POLY = 0;

    private BundleHelper() {
    }

    public static List<String> listEntries(InputStream input) throws IOException {
        List<String> result = new ArrayList();
        ZipInputStream zis = new ZipInputStream(input);
    L16:
        ZipEntry entry = zis.getNextEntry();     // Catch: Throwable -> L8
        if (entry == null) goto L12;
        if (entry.isDirectory() == true) goto L10;
        result.add(entry.getName());     // Catch: Throwable -> L8
    L10:
        zis.closeEntry();     // Catch: Throwable -> L8
        goto L16
    L12:
        zis.close();
        return result;
    L8:
        th = move-exception;
        zis.close();
        throw th;
    }

    public static byte[] readStream(InputStream input) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[65536];
    L3:
        int bytesRead = input.read(buffer);
        if (bytesRead == (-1)) goto L7;
        result.write(buffer, 0, bytesRead);
        goto L3
    L7:
        return result.toByteArray();
    }

    public static byte[] readEntry(InputStream input, String entryName) throws IOException {
        ZipInputStream zis = new ZipInputStream(input);
    L18:
        ZipEntry entry = zis.getNextEntry();     // Catch: Throwable -> L10
        if (entry == null) goto L14;
        if (entry.getName().equals(entryName) == true) goto L7;
        zis.closeEntry();     // Catch: Throwable -> L10
        goto L18
    L7:
        byte[] result = readStream(zis);     // Catch: Throwable -> L10
        zis.closeEntry();     // Catch: Throwable -> L10
        zis.close();
        return result;
    L14:
        zis.close();
        return null;
    L10:
        th = move-exception;
        zis.close();
        throw th;
    }

    static {
        CRC_64_POLY = new BigInteger("C96C5795D7870F42", 16).longValue();
    }

    public static long updateCrc64(long crc, byte[] data, int offset, int length) {
        int i = offset;
    L4:
        if (i >= (offset + length)) goto L15;
        long c = (((long) (data[i] & CecDeviceType.INACTIVE)) ^ crc) & 255;
        int k = 0;
    L7:
        if (k >= 8) goto L13;
        if ((c & 1) != 1) goto L11;
        long r4 = c >>> 1;
        long r5 = r4 ^ CRC_64_POLY;
    L12:
        c = r5;
        k = k + 1;
        goto L7
    L11:
        r5 = c >>> 1;
        goto L12
    L13:
        crc = c ^ (crc >>> 8);
        i = i + 1;
        goto L4
    L15:
        return crc;
    }

    public static long fingerprintStream(InputStream input) throws IOException {
        byte[] buffer = new byte[65536];
        long crc = -1;
    L3:
        int len = input.read(buffer);
        if (len <= 0) goto L6;
        crc = updateCrc64(crc, buffer, 0, len);
        goto L3
    L6:
        return ~crc;
    }

    public static long getExpectedFingerprint(String entryName) {
        int dotIndex = entryName.indexOf(46);
        if (dotIndex != (-1)) goto L5;
        String entryCrcString = entryName;
    L7:
        return new BigInteger(entryCrcString, 16).longValue();
    L5:
        entryCrcString = entryName.substring(0, dotIndex);
        goto L7
    }
}
