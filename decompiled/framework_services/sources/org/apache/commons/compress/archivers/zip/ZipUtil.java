package org.apache.commons.compress.archivers.zip;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = null;

    public ZipUtil() {
    }

    static {
        DOS_TIME_MIN = ZipLong.getBytes(8448);
    }

    public static ZipLong toDosTime(Date time) {
        return new ZipLong(toDosTime(time.getTime()));
    }

    public static byte[] toDosTime(long t) {
        byte[] result = new byte[4];
        toDosTime(t, result, 0);
        return result;
    }

    public static void toDosTime(long t, byte[] buf, int offset) {
        toDosTime(Calendar.getInstance(), t, buf, offset);
    }

    static void toDosTime(Calendar c, long t, byte[] buf, int offset) {
        c.setTimeInMillis(t);
        int year = c.get(1);
        if (year >= 1980) goto L6;
        System.arraycopy(DOS_TIME_MIN, 0, buf, offset, DOS_TIME_MIN.length);
        return;
    L6:
        int month = c.get(2) + 1;
        long value = (c.get(13) >> 1) | ((((((year - 1980) << 25) | (month << 21)) | (c.get(5) << 16)) | (c.get(11) << 11)) | (c.get(12) << 5));
        ZipLong.putLong(value, buf, offset);
    }

    public static long adjustToLong(int i) {
        if (i >= 0) goto L6;
        return ((long) i) + 4294967296L;
    L6:
        return i;
    }

    public static byte[] reverse(byte[] array) {
        int z = array.length - 1;
        int i = 0;
    L4:
        if (i >= (array.length / 2)) goto L7;
        byte x = array[i];
        array[i] = array[z - i];
        array[z - i] = x;
        i = i + 1;
        goto L4
    L7:
        return array;
    }

    static long bigToLong(BigInteger big) {
        if (big.bitLength() > 63) goto L7;
        return big.longValue();
    L7:
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + big + "]");
    }

    static BigInteger longToBig(long l) {
        if (l < (-2147483648L)) goto L12;
        if (l >= 0) goto L10;
        if (l < (-2147483648L)) goto L10;
        l = adjustToLong((int) l);
    L10:
        return BigInteger.valueOf(l);
    L12:
        throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + l + "]");
    }

    public static int signedByteToUnsignedInt(byte b) {
        if (b < 0) goto L5;
        return b;
    L5:
        return b + 256;
    }

    public static byte unsignedIntToSignedByte(int i) {
        if (i > 255) goto L12;
        if (i < 0) goto L12;
        if (i >= 128) goto L10;
        return (byte) i;
    L10:
        return (byte) (i - 256);
    L12:
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + i + "]");
    }

    public static Date fromDosTime(ZipLong zipDosTime) {
        long dosTime = zipDosTime.getValue();
        return new Date(dosToJavaTime(dosTime));
    }

    public static long dosToJavaTime(long dosTime) {
        Calendar cal = Calendar.getInstance();
        cal.set(1, ((int) ((dosTime >> 25) & 127)) + 1980);
        cal.set(2, ((int) ((dosTime >> 21) & 15)) - 1);
        cal.set(5, ((int) (dosTime >> 16)) & 31);
        cal.set(11, ((int) (dosTime >> 11)) & 31);
        cal.set(12, ((int) (dosTime >> 5)) & 63);
        cal.set(13, ((int) (dosTime << 1)) & 62);
        cal.set(14, 0);
        return cal.getTime().getTime();
    }

    static void setNameAndCommentFromExtraFields(ZipArchiveEntry ze, byte[] originalNameBytes, byte[] commentBytes) {
        UnicodePathExtraField name = (UnicodePathExtraField) ze.getExtraField(UnicodePathExtraField.UPATH_ID);
        String newName = getUnicodeStringIfOriginalMatches(name, originalNameBytes);
        if (newName == null) goto L5;
        ze.setName(newName);
        ze.setNameSource(ZipArchiveEntry.NameSource.UNICODE_EXTRA_FIELD);
    L5:
        if (commentBytes != null) goto L7;
        return;
    L7:
        if (commentBytes.length <= 0) goto L13;
        UnicodeCommentExtraField cmt = (UnicodeCommentExtraField) ze.getExtraField(UnicodeCommentExtraField.UCOM_ID);
        String newComment = getUnicodeStringIfOriginalMatches(cmt, commentBytes);
        if (newComment == null) goto L14;
        ze.setComment(newComment);
        ze.setCommentSource(ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD);
        return;
    L14:
        return;
    }

    private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField f, byte[] orig) {
        if (f == null) goto L10;
        CRC32 crc32 = new CRC32();
        crc32.update(orig);
        long origCRC32 = crc32.getValue();
        if (origCRC32 != f.getNameCRC32()) goto L10;
        return ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(f.getUnicodeName());
    L9:
        return null;
    L10:
        return null;
    }

    static byte[] copy(byte[] from) {
        if (from == null) goto L5;
        byte[] to = new byte[from.length];
        System.arraycopy(from, 0, to, 0, to.length);
        return to;
    L5:
        return null;
    }

    static void copy(byte[] from, byte[] to, int offset) {
        if (from == null) goto L5;
        System.arraycopy(from, 0, to, offset, from.length);
        return;
    }

    static boolean canHandleEntryData(ZipArchiveEntry entry) {
        if (supportsEncryptionOf(entry) == true) goto L5;
    L7:
        return false;
    L5:
        if (supportsMethodOf(entry) == false) goto L7;
        return true;
    }

    private static boolean supportsEncryptionOf(ZipArchiveEntry entry) {
        return !entry.getGeneralPurposeBit().usesEncryption();
    }

    private static boolean supportsMethodOf(ZipArchiveEntry entry) {
        if (entry.getMethod() != 0) goto L5;
    L16:
        return true;
    L5:
        if (entry.getMethod() == ZipMethod.UNSHRINKING.getCode()) goto L16;
        if (entry.getMethod() == ZipMethod.IMPLODING.getCode()) goto L16;
        if (entry.getMethod() == 8) goto L16;
        if (entry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode()) goto L16;
        if (entry.getMethod() == ZipMethod.BZIP2.getCode()) goto L16;
        return false;
    }

    static void checkRequestedFeatures(ZipArchiveEntry ze) throws UnsupportedZipFeatureException {
        if (supportsEncryptionOf(ze) == false) goto L14;
        if (supportsMethodOf(ze) == true) goto L12;
        ZipMethod m = ZipMethod.getMethodByCode(ze.getMethod());
        if (m != null) goto L11;
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, ze);
    L11:
        throw new UnsupportedZipFeatureException(m, ze);
    L12:
        return;
    L14:
        throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, ze);
    }
}
