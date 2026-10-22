package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.CountingOutputStream;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class TarArchiveOutputStream extends ArchiveOutputStream {
    private static final ZipEncoding ASCII = null;
    public static final int BIGNUMBER_ERROR = 0;
    public static final int BIGNUMBER_POSIX = 2;
    public static final int BIGNUMBER_STAR = 1;
    private static final int BLOCK_SIZE_UNSPECIFIED = -511;
    public static final int LONGFILE_ERROR = 0;
    public static final int LONGFILE_GNU = 2;
    public static final int LONGFILE_POSIX = 3;
    public static final int LONGFILE_TRUNCATE = 1;
    private static final int RECORD_SIZE = 512;
    private boolean addPaxHeadersForNonAsciiNames;
    private int bigNumberMode;
    private boolean closed;
    private final CountingOutputStream countingOut;
    private long currBytes;
    private String currName;
    private long currSize;
    final String encoding;
    private boolean finished;
    private boolean haveUnclosedEntry;
    private int longFileMode;
    private final FixedLengthBlockOutputStream out;
    private final byte[] recordBuf;
    private final int recordsPerBlock;
    private int recordsWritten;
    private final ZipEncoding zipEncoding;

    static {
        ASCII = ZipEncodingHelper.getZipEncoding("ASCII");
    }

    public TarArchiveOutputStream(OutputStream os) {
        this(os, BLOCK_SIZE_UNSPECIFIED);
    }

    public TarArchiveOutputStream(OutputStream os, String encoding) {
        this(os, BLOCK_SIZE_UNSPECIFIED, encoding);
    }

    public TarArchiveOutputStream(OutputStream os, int blockSize) {
        this(os, blockSize, null);
    }

    @Deprecated
    public TarArchiveOutputStream(OutputStream os, int blockSize, int recordSize) {
        this(os, blockSize, recordSize, null);
    }

    @Deprecated
    public TarArchiveOutputStream(OutputStream os, int blockSize, int recordSize, String encoding) {
        this(os, blockSize, encoding);
        if (recordSize != 512) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Tar record size must always be 512 bytes. Attempt to set size of " + recordSize);
    }

    public TarArchiveOutputStream(OutputStream os, int blockSize, String encoding) {
        this.longFileMode = 0;
        this.bigNumberMode = 0;
        this.closed = false;
        this.haveUnclosedEntry = false;
        this.finished = false;
        this.addPaxHeadersForNonAsciiNames = false;
        if (BLOCK_SIZE_UNSPECIFIED != blockSize) goto L5;
        int realBlockSize = 512;
    L6:
        if (realBlockSize <= 0) goto L12;
        if ((realBlockSize % 512) != 0) goto L12;
        CountingOutputStream r2 = new CountingOutputStream(os);
        this.countingOut = r2;
        this.out = new FixedLengthBlockOutputStream(r2, 512);
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        this.recordBuf = new byte[512];
        this.recordsPerBlock = realBlockSize / 512;
        return;
    L12:
        throw new IllegalArgumentException("Block size must be a multiple of 512 bytes. Attempt to use set size of " + blockSize);
    L5:
        realBlockSize = blockSize;
        goto L6
    }

    public void setLongFileMode(int longFileMode) {
        this.longFileMode = longFileMode;
    }

    public void setBigNumberMode(int bigNumberMode) {
        this.bigNumberMode = bigNumberMode;
    }

    public void setAddPaxHeadersForNonAsciiNames(boolean b) {
        this.addPaxHeadersForNonAsciiNames = b;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    @Deprecated
    public int getCount() {
        return (int) getBytesWritten();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public long getBytesWritten() {
        return this.countingOut.getBytesWritten();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        if (this.finished == true) goto L11;
        if (this.haveUnclosedEntry == true) goto L9;
        writeEOFRecord();
        writeEOFRecord();
        padAsNeeded();
        this.out.flush();
        this.finished = true;
        return;
    L9:
        throw new IOException("This archive contains unclosed entries.");
    L11:
        throw new IOException("This archive has already been finished");
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    L7:
        th = move-exception;
        if (this.closed == true) goto L16;
        this.out.close();
        this.closed = true;
    L16:
        throw th;
    L4:
        if (this.finished == true) goto L10;
        finish();     // Catch: Throwable -> L7
    L10:
        if (this.closed == true) goto L19;
        this.out.close();
        this.closed = true;
        return;
    }

    @Deprecated
    public int getRecordSize() {
        return 512;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry archiveEntry) throws IOException {
        if (this.finished == true) goto L54;
        TarArchiveEntry entry = (TarArchiveEntry) archiveEntry;
        boolean r10 = false;
        if (entry.isGlobalPaxHeader() == false) goto L10;
        byte[] data = encodeExtendedPaxHeadersContents(entry.getExtraPaxHeaders());
        entry.setSize(data.length);
        byte[] r1 = this.recordBuf;
        ZipEncoding r3 = this.zipEncoding;
        if (this.bigNumberMode != 1) goto L9;
        r10 = true;
    L9:
        entry.writeEntryHeader(r1, r3, r10);
        writeRecord(this.recordBuf);
        this.currSize = entry.getSize();
        this.currBytes = 0;
        this.haveUnclosedEntry = true;
        write(data);
        closeArchiveEntry();
        return;
    L10:
        Map<String, String> paxHeaders = new HashMap();
        String entryName = entry.getName();
        boolean paxHeaderContainsPath = handleLongName(entry, entryName, paxHeaders, "path", (byte) 76, "file name");
        String linkName = entry.getLinkName();
        if (linkName != null) goto L13;
    L17:
        TarArchiveOutputStream r2 = this;
    L18:
        boolean paxHeaderContainsLinkPath = false;
    L20:
        if (r2.bigNumberMode != 2) goto L23;
        addPaxHeadersForBigNumbers(paxHeaders, entry);
    L26:
        if (r2.addPaxHeadersForNonAsciiNames == false) goto L32;
        if (paxHeaderContainsPath == true) goto L32;
        if (ASCII.canEncode(entryName) == true) goto L32;
        paxHeaders.put("path", entryName);
    L32:
        if (r2.addPaxHeadersForNonAsciiNames == false) goto L41;
        if (paxHeaderContainsLinkPath == true) goto L41;
        if (entry.isLink() == true) goto L39;
        if (entry.isSymbolicLink() == false) goto L41;
    L39:
        if (ASCII.canEncode(linkName) == true) goto L41;
        paxHeaders.put("linkpath", linkName);
    L41:
        paxHeaders.putAll(entry.getExtraPaxHeaders());
        if (paxHeaders.size() <= 0) goto L44;
        writePaxHeaders(entry, entryName, paxHeaders);
    L44:
        byte[] r6 = r2.recordBuf;
        ZipEncoding r7 = r2.zipEncoding;
        if (r2.bigNumberMode != 1) goto L47;
        r10 = true;
    L47:
        entry.writeEntryHeader(r6, r7, r10);
        writeRecord(r2.recordBuf);
        r2.currBytes = 0;
        if (entry.isDirectory() == false) goto L50;
        r2.currSize = 0;
    L51:
        r2.currName = entryName;
        r2.haveUnclosedEntry = true;
        return;
    L50:
        r2.currSize = entry.getSize();
        goto L51
    L23:
        if (r2.bigNumberMode == 1) goto L26;
        failForBigNumbers(entry);
        goto L26
    L13:
        if (linkName.length() <= 0) goto L17;
        r2 = this;
        if (r2.handleLongName(entry, linkName, paxHeaders, "linkpath", (byte) 75, "link name") == false) goto L18;
        paxHeaderContainsLinkPath = true;
        goto L20
    L54:
        throw new IOException("Stream has already been finished");
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        if (this.finished == true) goto L18;
        if (this.haveUnclosedEntry == false) goto L16;
        this.out.flushBlock();
        if (this.currBytes < this.currSize) goto L14;
        this.recordsWritten = (int) (((long) this.recordsWritten) + (this.currSize / 512));
        if (0 == (this.currSize % 512)) goto L11;
        this.recordsWritten++;
    L11:
        this.haveUnclosedEntry = false;
        return;
    L14:
        throw new IOException("entry '" + this.currName + "' closed at '" + this.currBytes + "' before the '" + this.currSize + "' bytes specified in the header were written");
    L16:
        throw new IOException("No current entry to close");
    L18:
        throw new IOException("Stream has already been finished");
    }

    @Override // java.io.OutputStream
    public void write(byte[] wBuf, int wOffset, int numToWrite) throws IOException {
        if (this.haveUnclosedEntry == false) goto L11;
        if ((this.currBytes + ((long) numToWrite)) > this.currSize) goto L9;
        this.out.write(wBuf, wOffset, numToWrite);
        this.currBytes += (long) numToWrite;
        return;
    L9:
        throw new IOException("request to write '" + numToWrite + "' bytes exceeds size in header of '" + this.currSize + "' bytes for entry '" + this.currName + "'");
    L11:
        throw new IllegalStateException("No current tar entry");
    }

    void writePaxHeaders(TarArchiveEntry entry, String entryName, Map<String, String> headers) throws IOException {
        String name = "./PaxHeaders.X/" + stripTo7Bits(entryName);
        if (name.length() < 100) goto L5;
        name = name.substring(0, 99);
    L5:
        TarArchiveEntry pex = new TarArchiveEntry(name, TarConstants.LF_PAX_EXTENDED_HEADER_LC);
        transferModTime(entry, pex);
        byte[] data = encodeExtendedPaxHeadersContents(headers);
        pex.setSize(data.length);
        putArchiveEntry(pex);
        write(data);
        closeArchiveEntry();
    }

    private byte[] encodeExtendedPaxHeadersContents(Map<String, String> headers) throws UnsupportedEncodingException {
        StringWriter w = new StringWriter();
        Iterator<Map.Entry<String, String>> r1 = headers.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, String> h = r1.next();
        String key = h.getKey();
        String value = h.getValue();
        int len = ((key.length() + value.length()) + 3) + 2;
        String line = len + " " + key + "=" + value + "\n";
        int actualLength = line.getBytes(CharsetNames.UTF_8).length;
    L6:
        if (len == actualLength) goto L8;
        len = actualLength;
        line = len + " " + key + "=" + value + "\n";
        actualLength = line.getBytes(CharsetNames.UTF_8).length;
        goto L6
    L8:
        w.write(line);
        goto L4
    L10:
        return w.toString().getBytes(CharsetNames.UTF_8);
    }

    private String stripTo7Bits(String name) {
        int length = name.length();
        StringBuilder result = new StringBuilder(length);
        int i = 0;
    L3:
        if (i >= length) goto L10;
        char stripped = (char) (name.charAt(i) & 127);
        if (shouldBeReplaced(stripped) == false) goto L7;
        result.append("_");
    L8:
        i = i + 1;
        goto L3
    L7:
        result.append(stripped);
        goto L8
    L10:
        return result.toString();
    }

    private boolean shouldBeReplaced(char c) {
        if (c != 0) goto L4;
    L9:
        return true;
    L4:
        if (c == '/') goto L9;
        if (c == '\\') goto L9;
        return false;
    }

    private void writeEOFRecord() throws IOException {
        Arrays.fill(this.recordBuf, (byte) 0);
        writeRecord(this.recordBuf);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        if (this.finished == true) goto L7;
        return new TarArchiveEntry(inputFile, entryName);
    L7:
        throw new IOException("Stream has already been finished");
    }

    private void writeRecord(byte[] record) throws IOException {
        if (record.length != 512) goto L7;
        this.out.write(record);
        this.recordsWritten++;
        return;
    L7:
        throw new IOException("record to write has length '" + record.length + "' which is not the record size of '512'");
    }

    private void padAsNeeded() throws IOException {
        int start = this.recordsWritten % this.recordsPerBlock;
        if (start == 0) goto L8;
        int i = start;
    L6:
        if (i >= this.recordsPerBlock) goto L10;
        writeEOFRecord();
        i = i + 1;
        goto L6
    L10:
        return;
    }

    private void addPaxHeadersForBigNumbers(Map<String, String> paxHeaders, TarArchiveEntry entry) {
        addPaxHeaderForBigNumber(paxHeaders, "size", entry.getSize(), TarConstants.MAXSIZE);
        addPaxHeaderForBigNumber(paxHeaders, "gid", entry.getLongGroupId(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(paxHeaders, "mtime", entry.getModTime().getTime() / 1000, TarConstants.MAXSIZE);
        addPaxHeaderForBigNumber(paxHeaders, "uid", entry.getLongUserId(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(paxHeaders, "SCHILY.devmajor", entry.getDevMajor(), TarConstants.MAXID);
        addPaxHeaderForBigNumber(paxHeaders, "SCHILY.devminor", entry.getDevMinor(), TarConstants.MAXID);
        failForBigNumber("mode", entry.getMode(), TarConstants.MAXID);
    }

    private void addPaxHeaderForBigNumber(Map<String, String> paxHeaders, String header, long value, long maxValue) {
        if (value >= 0) goto L5;
    L6:
        paxHeaders.put(header, String.valueOf(value));
        return;
    L5:
        if (value > maxValue) goto L6;
    }

    private void failForBigNumbers(TarArchiveEntry entry) {
        failForBigNumber("entry size", entry.getSize(), TarConstants.MAXSIZE);
        failForBigNumberWithPosixMessage("group id", entry.getLongGroupId(), TarConstants.MAXID);
        failForBigNumber("last modification time", entry.getModTime().getTime() / 1000, TarConstants.MAXSIZE);
        failForBigNumber("user id", entry.getLongUserId(), TarConstants.MAXID);
        failForBigNumber("mode", entry.getMode(), TarConstants.MAXID);
        failForBigNumber("major device number", entry.getDevMajor(), TarConstants.MAXID);
        failForBigNumber("minor device number", entry.getDevMinor(), TarConstants.MAXID);
    }

    private void failForBigNumber(String field, long value, long maxValue) {
        failForBigNumber(field, value, maxValue, "");
    }

    private void failForBigNumberWithPosixMessage(String field, long value, long maxValue) {
        failForBigNumber(field, value, maxValue, " Use STAR or POSIX extensions to overcome this limit");
    }

    private void failForBigNumber(String field, long value, long maxValue, String additionalMsg) {
        if (value < 0) goto L8;
        if (value > maxValue) goto L8;
        return;
    L8:
        throw new RuntimeException(field + " '" + value + "' is too big ( > " + maxValue + " )." + additionalMsg);
    }

    private boolean handleLongName(TarArchiveEntry entry, String name, Map<String, String> paxHeaders, String paxHeaderName, byte linkType, String fieldName) throws IOException {
        ByteBuffer encodedName = this.zipEncoding.encode(name);
        int len = encodedName.limit() - encodedName.position();
        if (len >= 100) goto L5;
    L17:
        return false;
    L5:
        if (this.longFileMode != 3) goto L9;
        paxHeaders.put(paxHeaderName, name);
        return true;
    L9:
        if (this.longFileMode != 2) goto L13;
        TarArchiveEntry longLinkEntry = new TarArchiveEntry(TarConstants.GNU_LONGLINK, linkType);
        longLinkEntry.setSize(((long) len) + 1);
        transferModTime(entry, longLinkEntry);
        putArchiveEntry(longLinkEntry);
        write(encodedName.array(), encodedName.arrayOffset(), len);
        write(0);
        closeArchiveEntry();
        goto L17
    L13:
        if (this.longFileMode == 1) goto L17;
        throw new RuntimeException(fieldName + " '" + name + "' is too long ( > 100 bytes)");
    }

    private void transferModTime(TarArchiveEntry from, TarArchiveEntry to) {
        Date fromModTime = from.getModTime();
        long fromModTimeSeconds = fromModTime.getTime() / 1000;
        if (fromModTimeSeconds >= 0) goto L5;
    L6:
        fromModTime = new Date(0);
    L7:
        to.setModTime(fromModTime);
        return;
    L5:
        if (fromModTimeSeconds <= TarConstants.MAXSIZE) goto L7;
        goto L6
    }
}
