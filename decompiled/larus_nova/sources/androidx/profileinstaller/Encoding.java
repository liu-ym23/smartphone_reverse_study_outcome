package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import kotlin.UByte;

/* JADX INFO: loaded from: classes6.dex */
class Encoding {
    static final int SIZEOF_BYTE = 8;
    static final int UINT_16_SIZE = 2;
    static final int UINT_32_SIZE = 4;
    static final int UINT_8_SIZE = 1;

    private Encoding() {
    }

    public static int bitsToBytes(int r100) {
        return (((r100 + 8) - 1) & (-8)) / 8;
    }

    public static byte[] compress(byte[] r100) throws IOException {
        Deflater r101 = new Deflater(1);
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        DeflaterOutputStream r103 = new DeflaterOutputStream(r102, r101);     // Catch: Throwable -> L14
        r103.write(r100);     // Catch: Throwable -> L8
        r103.close();     // Catch: Throwable -> L14
        r101.end();
        return r102.toByteArray();
    L8:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r101.end();
        throw th;
    }

    public static RuntimeException error(String r100) {
        return new IllegalStateException(r100);
    }

    public static int readUInt16(InputStream r100) throws IOException {
        return (int) readUInt(r100, 2);
    }

    public static long readUInt32(InputStream r100) throws IOException {
        return readUInt(r100, 4);
    }

    public static int readUInt8(InputStream r100) throws IOException {
        return (int) readUInt(r100, 1);
    }

    public static int utf8Length(String r100) {
        return r100.getBytes(StandardCharsets.UTF_8).length;
    }

    public static byte[] read(InputStream r100, int r101) throws IOException {
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L9;
        int r104 = r100.read(r102, r103, r101 - r103);
        if (r104 < 0) goto L8;
        r103 = r103 + r104;
        goto L3
    L8:
        throw error("Not enough bytes to read: " + r101);
    L9:
        return r102;
    }

    public static String readString(InputStream r100, int r101) throws IOException {
        return new String(read(r100, r101), StandardCharsets.UTF_8);
    }

    public static long readUInt(InputStream r100, int r101) throws IOException {
        byte[] r102 = read(r100, r101);
        long r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r103 = r103 + (((long) (r102[r104] & UByte.MAX_VALUE)) << (r104 * 8));
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public static void writeCompressed(OutputStream r100, byte[] r101) throws IOException {
        writeUInt32(r100, r101.length);
        byte[] r102 = compress(r101);
        writeUInt32(r100, r102.length);
        r100.write(r102);
    }

    public static void writeString(OutputStream r100, String r101) throws IOException {
        r100.write(r101.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeUInt16(OutputStream r100, int r101) throws IOException {
        writeUInt(r100, r101, 2);
    }

    public static void writeUInt32(OutputStream r100, long r101) throws IOException {
        writeUInt(r100, r101, 4);
    }

    public static void writeUInt8(OutputStream r100, int r101) throws IOException {
        writeUInt(r100, r101, 1);
    }

    public static byte[] readCompressed(InputStream r100, int r101, int r110) throws IOException {
        Inflater r102 = new Inflater();
        byte[] r103 = new byte[r110];     // Catch: Throwable -> L29
        byte[] r104 = new byte[2048];     // Catch: Throwable -> L29
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r102.finished() == true) goto L20;
        if (r102.needsDictionary() == true) goto L20;
        if (r105 >= r101) goto L20;
        int r107 = r100.read(r104);     // Catch: Throwable -> L29
        if (r107 < 0) goto L19;
        r102.setInput(r104, 0, r107);     // Catch: Throwable -> L29
        r106 = r106 + r102.inflate(r103, r106, r110 - r106);
        r105 = r105 + r107;
        goto L5
    L15:
        e = move-exception;
        throw error(e.getMessage());     // Catch: Throwable -> L29
    L19:
        throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + r101 + " bytes");     // Catch: Throwable -> L29
    L20:
        if (r105 != r101) goto L28;
        if (r102.finished() == false) goto L26;
        r102.end();
        return r103;
    L26:
        throw error("Inflater did not finish");     // Catch: Throwable -> L29
    L28:
        throw error("Didn't read enough bytes during decompression. expected=" + r101 + " actual=" + r105);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        r102.end();
        throw th;
    }

    public static void writeAll(InputStream r100, OutputStream r101, FileLock r102) throws IOException {
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L15;
        byte[] r104 = new byte[512];
    L10:
        int r105 = r100.read(r104);
        if (r105 <= 0) goto L13;
        r101.write(r104, 0, r105);
        goto L10
    L13:
        return;
    L15:
        throw new IOException("Unable to acquire a lock on the underlying file channel.");
    L5:
        if (r102.isValid() == false) goto L7;
        r103 = true;
        goto L8
    }

    public static void writeUInt(OutputStream r100, long r101, int r102) throws IOException {
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103[r104] = (byte) ((r101 >> (r104 * 8)) & 255);
        r104 = r104 + 1;
        goto L3
    L5:
        r100.write(r103);
    }
}
