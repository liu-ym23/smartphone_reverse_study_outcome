package org.apache.commons.compress.archivers.ar;

import com.android.server.slice.SliceClientPermissions;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ArArchiveInputStream extends ArchiveInputStream {
    private static final String BSD_LONGNAME_PATTERN = "^#1/\\d+";
    static final String BSD_LONGNAME_PREFIX = "#1/";
    private static final int BSD_LONGNAME_PREFIX_LEN = 0;
    private static final int FILE_MODE_LEN = 8;
    private static final int FILE_MODE_OFFSET = 40;
    private static final String GNU_LONGNAME_PATTERN = "^/\\d+";
    private static final String GNU_STRING_TABLE_NAME = "//";
    private static final int GROUP_ID_LEN = 6;
    private static final int GROUP_ID_OFFSET = 34;
    private static final int LAST_MODIFIED_LEN = 12;
    private static final int LAST_MODIFIED_OFFSET = 16;
    private static final int LENGTH_LEN = 10;
    private static final int LENGTH_OFFSET = 48;
    private static final int NAME_LEN = 16;
    private static final int NAME_OFFSET = 0;
    private static final int USER_ID_LEN = 6;
    private static final int USER_ID_OFFSET = 28;
    private boolean closed;
    private ArArchiveEntry currentEntry;
    private long entryOffset;
    private final InputStream input;
    private final byte[] metaData;
    private byte[] namebuffer;
    private long offset;

    public ArArchiveInputStream(InputStream pInput) {
        this.offset = 0;
        this.currentEntry = null;
        this.namebuffer = null;
        this.entryOffset = -1;
        this.metaData = new byte[58];
        this.input = pInput;
        this.closed = false;
    }

    public ArArchiveEntry getNextArEntry() throws IOException {
        if (this.currentEntry == null) goto L5;
        long entryEnd = this.entryOffset + this.currentEntry.getLength();
        long skipped = IOUtils.skip(this.input, entryEnd - this.offset);
        trackReadBytes(skipped);
        this.currentEntry = null;
    L5:
        long entryEnd2 = this.offset;
        if (entryEnd2 != 0) goto L20;
        byte[] expected = ArchiveUtils.toAsciiBytes(ArArchiveEntry.HEADER);
        byte[] realized = new byte[expected.length];
        int read = IOUtils.readFully(this.input, realized);
        trackReadBytes(read);
        if (read != expected.length) goto L18;
        int i = 0;
    L11:
        if (i >= expected.length) goto L20;
        if (expected[i] != realized[i]) goto L16;
        i = i + 1;
        goto L11
    L16:
        throw new IOException("invalid header " + ArchiveUtils.toAsciiString(realized));
    L18:
        throw new IOException("failed to read header. Occured at byte: " + getBytesRead());
    L20:
        if ((this.offset % 2) == 0) goto L26;
        if (this.input.read() >= 0) goto L24;
        return null;
    L24:
        trackReadBytes(1);
    L26:
        if (this.input.available() != 0) goto L28;
        return null;
    L28:
        int read2 = IOUtils.readFully(this.input, this.metaData);
        trackReadBytes(read2);
        if (read2 < this.metaData.length) goto L59;
        byte[] expected2 = ArchiveUtils.toAsciiBytes(ArArchiveEntry.TRAILER);
        byte[] realized2 = new byte[expected2.length];
        int read3 = IOUtils.readFully(this.input, realized2);
        trackReadBytes(read3);
        if (read3 != expected2.length) goto L57;
        int i2 = 0;
    L34:
        if (i2 >= expected2.length) goto L40;
        if (expected2[i2] != realized2[i2]) goto L39;
        i2 = i2 + 1;
        goto L34
    L39:
        throw new IOException("invalid entry trailer. not read the content? Occured at byte: " + getBytesRead());
    L40:
        this.entryOffset = this.offset;
        String temp = ArchiveUtils.toAsciiString(this.metaData, 0, 16).trim();
        if (isGNUStringTable(temp) == false) goto L44;
        this.currentEntry = readGNUStringTable(this.metaData, 48, 10);
        return getNextArEntry();
    L44:
        long len = asLong(this.metaData, 48, 10);
        if (temp.endsWith(SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L48;
        String temp2 = temp.substring(0, temp.length() - 1);
        long len2 = len;
    L54:
        this.currentEntry = new ArArchiveEntry(temp2, len2, asInt(this.metaData, 28, 6, true), asInt(this.metaData, 34, 6, true), asInt(this.metaData, 40, 8, 8), asLong(this.metaData, 16, 12));
        return this.currentEntry;
    L48:
        if (isGNULongName(temp) == false) goto L52;
        int off = Integer.parseInt(temp.substring(1));
        temp = getExtendedName(off);
    L50:
        temp2 = temp;
        len2 = len;
        goto L54
    L52:
        if (isBSDLongName(temp) == false) goto L50;
        String temp3 = getBSDLongName(temp);
        int nameLen = temp3.length();
        this.entryOffset += (long) nameLen;
        temp2 = temp3;
        len2 = len - ((long) nameLen);
        goto L54
    L57:
        throw new IOException("failed to read entry trailer. Occured at byte: " + getBytesRead());
    L59:
        throw new IOException("truncated ar archive");
    }

    private String getExtendedName(int offset) throws IOException {
        if (this.namebuffer == null) goto L21;
        int i = offset;
    L6:
        if (i >= this.namebuffer.length) goto L19;
        if (this.namebuffer[i] == 10) goto L14;
        if (this.namebuffer[i] == 0) goto L14;
        i = i + 1;
    L14:
        if (this.namebuffer[i - 1] != 47) goto L17;
        i = i - 1;
    L17:
        return ArchiveUtils.toAsciiString(this.namebuffer, offset, i - offset);
    L19:
        throw new IOException("Failed to read entry: " + offset);
    L21:
        throw new IOException("Cannot process GNU long filename as no // record was found");
    }

    private long asLong(byte[] byteArray, int offset, int len) {
        return Long.parseLong(ArchiveUtils.toAsciiString(byteArray, offset, len).trim());
    }

    private int asInt(byte[] byteArray, int offset, int len) {
        return asInt(byteArray, offset, len, 10, false);
    }

    private int asInt(byte[] byteArray, int offset, int len, boolean treatBlankAsZero) {
        return asInt(byteArray, offset, len, 10, treatBlankAsZero);
    }

    private int asInt(byte[] byteArray, int offset, int len, int base) {
        return asInt(byteArray, offset, len, base, false);
    }

    private int asInt(byte[] byteArray, int offset, int len, int base, boolean treatBlankAsZero) {
        String string = ArchiveUtils.toAsciiString(byteArray, offset, len).trim();
        if (string.length() != 0) goto L8;
        if (treatBlankAsZero == false) goto L8;
        return 0;
    L8:
        return Integer.parseInt(string, base);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextArEntry();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L5;
        this.closed = true;
        this.input.close();
    L5:
        this.currentEntry = null;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.currentEntry == null) goto L14;
        long entryEnd = this.entryOffset + this.currentEntry.getLength();
        if (len >= 0) goto L7;
        return -1;
    L7:
        if (this.offset >= entryEnd) goto L15;
        int toRead = (int) Math.min(len, entryEnd - this.offset);
        int ret = this.input.read(b, off, toRead);
        trackReadBytes(ret);
        return ret;
    L15:
        return -1;
    L14:
        throw new IllegalStateException("No current ar entry");
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= 8) goto L5;
        return false;
    L5:
        if (signature[0] == 33) goto L7;
        return false;
    L7:
        if (signature[1] == 60) goto L9;
        return false;
    L9:
        if (signature[2] == 97) goto L11;
        return false;
    L11:
        if (signature[3] == 114) goto L13;
        return false;
    L13:
        if (signature[4] == 99) goto L15;
        return false;
    L15:
        if (signature[5] == 104) goto L17;
        return false;
    L17:
        if (signature[6] == 62) goto L19;
        return false;
    L19:
        if (signature[7] == 10) goto L21;
        return false;
    L21:
        return true;
    }

    static {
        BSD_LONGNAME_PREFIX_LEN = BSD_LONGNAME_PREFIX.length();
    }

    private static boolean isBSDLongName(String name) {
        if (name != null) goto L4;
    L6:
        return false;
    L4:
        if (name.matches(BSD_LONGNAME_PATTERN) == false) goto L6;
        return true;
    }

    private String getBSDLongName(String bsdLongName) throws IOException {
        int nameLen = Integer.parseInt(bsdLongName.substring(BSD_LONGNAME_PREFIX_LEN));
        byte[] name = new byte[nameLen];
        int read = IOUtils.readFully(this.input, name);
        trackReadBytes(read);
        if (read != nameLen) goto L7;
        return ArchiveUtils.toAsciiString(name);
    L7:
        throw new EOFException();
    }

    private static boolean isGNUStringTable(String name) {
        return GNU_STRING_TABLE_NAME.equals(name);
    }

    private void trackReadBytes(long read) {
        count(read);
        if (read <= 0) goto L6;
        this.offset += read;
        return;
    }

    private ArArchiveEntry readGNUStringTable(byte[] length, int offset, int len) throws IOException {
        int bufflen = asInt(length, offset, len);
        this.namebuffer = new byte[bufflen];
        int read = IOUtils.readFully(this.input, this.namebuffer, 0, bufflen);
        trackReadBytes(read);
        if (read != bufflen) goto L7;
        return new ArArchiveEntry(GNU_STRING_TABLE_NAME, bufflen);
    L7:
        throw new IOException("Failed to read complete // record: expected=" + bufflen + " read=" + read);
    }

    private boolean isGNULongName(String name) {
        if (name != null) goto L4;
    L6:
        return false;
    L4:
        if (name.matches(GNU_LONGNAME_PATTERN) == false) goto L6;
        return true;
    }
}
