package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TarArchiveInputStream extends ArchiveInputStream {
    private static final int SMALL_BUFFER_SIZE = 256;
    private final int blockSize;
    private TarArchiveEntry currEntry;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private Map<String, String> globalPaxHeaders;
    private boolean hasHitEOF;
    private final InputStream is;
    private final int recordSize;
    private final byte[] smallBuf;
    private final ZipEncoding zipEncoding;

    public TarArchiveInputStream(InputStream is) {
        this(is, TarConstants.DEFAULT_BLKSIZE, 512);
    }

    public TarArchiveInputStream(InputStream is, String encoding) {
        this(is, TarConstants.DEFAULT_BLKSIZE, 512, encoding);
    }

    public TarArchiveInputStream(InputStream is, int blockSize) {
        this(is, blockSize, 512);
    }

    public TarArchiveInputStream(InputStream is, int blockSize, String encoding) {
        this(is, blockSize, 512, encoding);
    }

    public TarArchiveInputStream(InputStream is, int blockSize, int recordSize) {
        this(is, blockSize, recordSize, null);
    }

    public TarArchiveInputStream(InputStream is, int blockSize, int recordSize, String encoding) {
        this.smallBuf = new byte[256];
        this.globalPaxHeaders = new HashMap();
        this.is = is;
        this.hasHitEOF = false;
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        this.recordSize = recordSize;
        this.blockSize = blockSize;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.is.close();
    }

    public int getRecordSize() {
        return this.recordSize;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (isDirectory() == false) goto L7;
        return 0;
    L7:
        if ((this.entrySize - this.entryOffset) <= 2147483647L) goto L11;
        return Integer.MAX_VALUE;
    L11:
        return (int) (this.entrySize - this.entryOffset);
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (n > 0) goto L5;
    L9:
        return 0;
    L5:
        if (isDirectory() == true) goto L9;
        long available = this.entrySize - this.entryOffset;
        long skipped = IOUtils.skip(this.is, Math.min(n, available));
        count(skipped);
        this.entryOffset += skipped;
        return skipped;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public void mark(int markLimit) {
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        monitor-exit(this);
    }

    public TarArchiveEntry getNextTarEntry() throws IOException {
        if (isAtEOF() == false) goto L6;
        return null;
    L6:
        if (this.currEntry == null) goto L8;
        IOUtils.skip(this, Long.MAX_VALUE);
        skipRecordPadding();
    L8:
        byte[] headerBuf = getRecord();
        if (headerBuf != null) goto L42;
        this.currEntry = null;
        return null;
    L42:
        this.currEntry = new TarArchiveEntry(headerBuf, this.zipEncoding);     // Catch: IllegalArgumentException -> L39
        this.entryOffset = 0;
        this.entrySize = this.currEntry.getSize();
        if (this.currEntry.isGNULongLinkEntry() == false) goto L20;
        byte[] longLinkData = getLongNameData();
        if (longLinkData != null) goto L18;
        return null;
    L18:
        this.currEntry.setLinkName(this.zipEncoding.decode(longLinkData));
    L20:
        if (this.currEntry.isGNULongNameEntry() == false) goto L26;
        byte[] longNameData = getLongNameData();
        if (longNameData != null) goto L24;
        return null;
    L24:
        this.currEntry.setName(this.zipEncoding.decode(longNameData));
    L26:
        if (this.currEntry.isGlobalPaxHeader() == false) goto L29;
        readGlobalPaxHeaders();
    L29:
        if (this.currEntry.isPaxHeader() == false) goto L32;
        paxHeaders();
    L35:
        if (this.currEntry.isOldGNUSparse() == false) goto L37;
        readOldGNUSparse();
    L37:
        this.entrySize = this.currEntry.getSize();
        return this.currEntry;
    L32:
        if (this.globalPaxHeaders.isEmpty() == true) goto L35;
        applyPaxHeadersToCurrentEntry(this.globalPaxHeaders);
    L39:
        e = move-exception;
        throw new IOException("Error detected parsing the header", e);
    }

    private void skipRecordPadding() throws IOException {
        if (isDirectory() == false) goto L5;
        return;
    L5:
        if (this.entrySize > 0) goto L7;
        return;
    L7:
        if ((this.entrySize % ((long) this.recordSize)) == 0) goto L12;
        long numRecords = (this.entrySize / ((long) this.recordSize)) + 1;
        long padding = (((long) this.recordSize) * numRecords) - this.entrySize;
        long skipped = IOUtils.skip(this.is, padding);
        count(skipped);
        return;
    }

    protected byte[] getLongNameData() throws IOException {
        ByteArrayOutputStream longName = new ByteArrayOutputStream();
    L3:
        int length = read(this.smallBuf);
        if (length < 0) goto L6;
        longName.write(this.smallBuf, 0, length);
        goto L3
    L6:
        getNextEntry();
        if (this.currEntry != null) goto L10;
        return null;
    L10:
        byte[] longNameData = longName.toByteArray();
        int length2 = longNameData.length;
    L11:
        if (length2 <= 0) goto L16;
        if (longNameData[length2 - 1] != 0) goto L16;
        length2 = length2 - 1;
    L16:
        if (length2 == longNameData.length) goto L22;
        byte[] l = new byte[length2];
        System.arraycopy(longNameData, 0, l, 0, length2);
        return l;
    L22:
        return longNameData;
    }

    private byte[] getRecord() throws IOException {
        byte[] headerBuf = readRecord();
        setAtEOF(isEOFRecord(headerBuf));
        if (isAtEOF() == false) goto L7;
        if (headerBuf == null) goto L8;
        tryToConsumeSecondEOFRecord();
        consumeRemainderOfLastBlock();
        return null;
    L8:
        return headerBuf;
    L7:
        return headerBuf;
    }

    protected boolean isEOFRecord(byte[] record) {
        if (record != null) goto L4;
    L7:
        return true;
    L4:
        if (ArchiveUtils.isArrayZero(record, this.recordSize) == true) goto L7;
        return false;
    }

    protected byte[] readRecord() throws IOException {
        byte[] record = new byte[this.recordSize];
        int readNow = IOUtils.readFully(this.is, record);
        count(readNow);
        if (readNow == this.recordSize) goto L6;
        return null;
    L6:
        return record;
    }

    private void readGlobalPaxHeaders() throws IOException {
        this.globalPaxHeaders = parsePaxHeaders(this);
        getNextEntry();
    }

    private void paxHeaders() throws IOException {
        Map<String, String> headers = parsePaxHeaders(this);
        getNextEntry();
        applyPaxHeadersToCurrentEntry(headers);
    }

    Map<String, String> parsePaxHeaders(InputStream i) throws IOException {
        Map<String, String> headers = new HashMap(this.globalPaxHeaders);
    L3:
        int len = 0;
        int read = 0;
    L4:
        int r3 = i.read();
        int ch = r3;
        if (r3 == (-1)) goto L26;
        read = read + 1;
        if (ch == 10) goto L26;
        if (ch == 32) goto L11;
        len = (len * 10) + (ch - 48);
        goto L4
    L11:
        ByteArrayOutputStream coll = new ByteArrayOutputStream();
    L12:
        int r6 = i.read();
        ch = r6;
        if (r6 == (-1)) goto L26;
        read = read + 1;
        if (ch == 61) goto L16;
        coll.write((byte) ch);
        goto L12
    L16:
        String keyword = coll.toString(CharsetNames.UTF_8);
        int restLen = len - read;
        if (restLen != 1) goto L19;
        headers.remove(keyword);
        goto L26
    L19:
        byte[] rest = new byte[restLen];
        int got = IOUtils.readFully(i, rest);
        if (got != restLen) goto L23;
        String value = new String(rest, 0, restLen - 1, CharsetNames.UTF_8);
        headers.put(keyword, value);
        goto L26
    L23:
        throw new IOException("Failed to read Paxheader. Expected " + restLen + " bytes, read " + got);
    L26:
        if (ch != (-1)) goto L3;
        return headers;
    }

    private void applyPaxHeadersToCurrentEntry(Map<String, String> headers) {
        this.currEntry.updateEntryFromPaxHeaders(headers);
    }

    private void readOldGNUSparse() throws IOException {
        if (this.currEntry.isExtended() == false) goto L9;
    L4:
        byte[] headerBuf = getRecord();
        if (headerBuf == null) goto L6;
        TarArchiveSparseEntry entry = new TarArchiveSparseEntry(headerBuf);
        if (entry.isExtended() == true) goto L4;
        return;
    L6:
        this.currEntry = null;
        return;
    }

    private boolean isDirectory() {
        if (this.currEntry != null) goto L5;
    L7:
        return false;
    L5:
        if (this.currEntry.isDirectory() == false) goto L7;
        return true;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextTarEntry();
    }

    private void tryToConsumeSecondEOFRecord() throws IOException {
        boolean marked = this.is.markSupported();
        if (marked == false) goto L16;
        this.is.mark(this.recordSize);
    L16:
        boolean shouldReset = !isEOFRecord(readRecord());
        if (shouldReset == false) goto L18;
        if (marked == false) goto L19;
        pushedBackBytes(this.recordSize);
        this.is.reset();
        return;
    L19:
        return;
    L18:
        return;
    L11:
        th = move-exception;
        if (1 == 0) goto L15;
        if (marked == false) goto L15;
        pushedBackBytes(this.recordSize);
        this.is.reset();
    L15:
        throw th;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int offset, int numToRead) throws IOException {
        if (isAtEOF() == false) goto L5;
    L21:
        return -1;
    L5:
        if (isDirectory() == true) goto L21;
        if (this.entryOffset >= this.entrySize) goto L21;
        if (this.currEntry == null) goto L20;
        int numToRead2 = Math.min(numToRead, available());
        int totalRead = this.is.read(buf, offset, numToRead2);
        if (totalRead != (-1)) goto L17;
        if (numToRead2 > 0) goto L16;
        setAtEOF(true);
    L18:
        return totalRead;
    L16:
        throw new IOException("Truncated TAR archive");
    L17:
        count(totalRead);
        this.entryOffset += (long) totalRead;
        goto L18
    L20:
        throw new IllegalStateException("No current tar entry");
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry ae) {
        if ((ae instanceof TarArchiveEntry) == false) goto L6;
        TarArchiveEntry te = (TarArchiveEntry) ae;
        return !te.isSparse();
    L6:
        return false;
    }

    public TarArchiveEntry getCurrentEntry() {
        return this.currEntry;
    }

    protected final void setCurrentEntry(TarArchiveEntry e) {
        this.currEntry = e;
    }

    protected final boolean isAtEOF() {
        return this.hasHitEOF;
    }

    protected final void setAtEOF(boolean b) {
        this.hasHitEOF = b;
    }

    private void consumeRemainderOfLastBlock() throws IOException {
        long bytesReadOfLastBlock = getBytesRead() % ((long) this.blockSize);
        if (bytesReadOfLastBlock <= 0) goto L6;
        long skipped = IOUtils.skip(this.is, ((long) this.blockSize) - bytesReadOfLastBlock);
        count(skipped);
        return;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= 265) goto L6;
        return false;
    L6:
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", signature, 257, 6) == false) goto L11;
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_POSIX, signature, 263, 2) == false) goto L11;
        return true;
    L11:
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.MAGIC_GNU, signature, 257, 6) == false) goto L18;
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_SPACE, signature, 263, 2) == false) goto L15;
    L16:
        return true;
    L15:
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_GNU_ZERO, signature, 263, 2) == true) goto L16;
    L18:
        if (ArchiveUtils.matchAsciiBuffer("ustar\u0000", signature, 257, 6) == true) goto L20;
        return false;
    L20:
        if (ArchiveUtils.matchAsciiBuffer(TarConstants.VERSION_ANT, signature, 263, 2) == true) goto L23;
        return false;
    L23:
        return true;
    }
}
