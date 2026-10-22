package org.apache.commons.compress.archivers.dump;

import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;

/* JADX INFO: loaded from: classes3.dex */
public class DumpArchiveInputStream extends ArchiveInputStream {
    private DumpArchiveEntry active;
    private byte[] blockBuffer;
    final String encoding;
    private long entryOffset;
    private long entrySize;
    private long filepos;
    private boolean hasHitEOF;
    private boolean isClosed;
    private final Map<Integer, Dirent> names;
    private final Map<Integer, DumpArchiveEntry> pending;
    private Queue<DumpArchiveEntry> queue;
    protected TapeInputStream raw;
    private final byte[] readBuf;
    private int readIdx;
    private int recordOffset;
    private DumpArchiveSummary summary;
    private final ZipEncoding zipEncoding;

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public /* bridge */ /* synthetic */ ArchiveEntry getNextEntry() throws IOException {
        return getNextEntry();
    }

    public DumpArchiveInputStream(InputStream is) throws ArchiveException {
        this(is, null);
    }

    public DumpArchiveInputStream(InputStream is, String encoding) throws ArchiveException {
        this.readBuf = new byte[1024];
        this.names = new HashMap();
        this.pending = new HashMap();
        this.raw = new TapeInputStream(is);
        this.hasHitEOF = false;
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        byte[] headerBytes = this.raw.readRecord();     // Catch: IOException -> L8
        if (DumpArchiveUtil.verify(headerBytes) == false) goto L11;
        this.summary = new DumpArchiveSummary(headerBytes, this.zipEncoding);     // Catch: IOException -> L8
        this.raw.resetBlockSize(this.summary.getNTRec(), this.summary.isCompressed());     // Catch: IOException -> L8
        this.blockBuffer = new byte[4096];     // Catch: IOException -> L8
        readCLRI();     // Catch: IOException -> L8
        readBITS();     // Catch: IOException -> L8
        Dirent root = new Dirent(2, 2, 4, ".");
        this.names.put(2, root);
        this.queue = new PriorityQueue(10, new AnonymousClass1(this));
        return;
    L11:
        throw new UnrecognizedFormatException();     // Catch: IOException -> L8
    L8:
        ex = move-exception;
        throw new ArchiveException(ex.getMessage(), ex);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    @Deprecated
    public int getCount() {
        return (int) getBytesRead();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public long getBytesRead() {
        return this.raw.getBytesRead();
    }

    public DumpArchiveSummary getSummary() {
        return this.summary;
    }

    private void readCLRI() throws IOException {
        byte[] buffer = this.raw.readRecord();
        if (DumpArchiveUtil.verify(buffer) == false) goto L15;
        this.active = DumpArchiveEntry.parse(buffer);
        if (DumpArchiveConstants.SEGMENT_TYPE.CLRI != this.active.getHeaderType()) goto L13;
        if (this.raw.skip(((long) this.active.getHeaderCount()) * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == (-1)) goto L11;
        this.readIdx = this.active.getHeaderCount();
        return;
    L11:
        throw new EOFException();
    L13:
        throw new InvalidFormatException();
    L15:
        throw new InvalidFormatException();
    }

    private void readBITS() throws IOException {
        byte[] buffer = this.raw.readRecord();
        if (DumpArchiveUtil.verify(buffer) == false) goto L15;
        this.active = DumpArchiveEntry.parse(buffer);
        if (DumpArchiveConstants.SEGMENT_TYPE.BITS != this.active.getHeaderType()) goto L13;
        if (this.raw.skip(((long) this.active.getHeaderCount()) * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == (-1)) goto L11;
        this.readIdx = this.active.getHeaderCount();
        return;
    L11:
        throw new EOFException();
    L13:
        throw new InvalidFormatException();
    L15:
        throw new InvalidFormatException();
    }

    public DumpArchiveEntry getNextDumpEntry() throws IOException {
        return getNextEntry();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public DumpArchiveEntry getNextEntry() throws IOException {
        DumpArchiveEntry entry = null;
        String path = null;
        if (this.queue.isEmpty() == false) goto L5;
    L6:
        if (entry != null) goto L47;
        if (this.hasHitEOF == true) goto L9;
    L11:
        if (this.readIdx >= this.active.getHeaderCount()) goto L19;
        DumpArchiveEntry r2 = this.active;
        int r4 = this.readIdx;
        this.readIdx = r4 + 1;
        if (r2.isSparseRecord(r4) == true) goto L11;
        if (this.raw.skip(DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) != (-1)) goto L11;
        throw new EOFException();
    L19:
        this.readIdx = 0;
        this.filepos = this.raw.getBytesRead();
        byte[] headerBytes = this.raw.readRecord();
        if (DumpArchiveUtil.verify(headerBytes) == false) goto L46;
        this.active = DumpArchiveEntry.parse(headerBytes);
    L23:
        if (DumpArchiveConstants.SEGMENT_TYPE.ADDR != this.active.getHeaderType()) goto L34;
        if (this.raw.skip(((long) (this.active.getHeaderCount() - this.active.getHeaderHoles())) * DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) == (-1)) goto L32;
        this.filepos = this.raw.getBytesRead();
        byte[] headerBytes2 = this.raw.readRecord();
        if (DumpArchiveUtil.verify(headerBytes2) == false) goto L30;
        this.active = DumpArchiveEntry.parse(headerBytes2);
        goto L23
    L30:
        throw new InvalidFormatException();
    L32:
        throw new EOFException();
    L34:
        if (DumpArchiveConstants.SEGMENT_TYPE.END == this.active.getHeaderType()) goto L35;
        entry = this.active;
        if (entry.isDirectory() == false) goto L40;
        readDirectoryEntry(this.active);
        this.entryOffset = 0;
        this.entrySize = 0;
        this.readIdx = this.active.getHeaderCount();
    L41:
        this.recordOffset = this.readBuf.length;
        path = getPath(entry);
        if (path != null) goto L6;
        entry = null;
        goto L6
    L40:
        this.entryOffset = 0;
        this.entrySize = this.active.getEntrySize();
        this.readIdx = 0;
        goto L41
    L35:
        this.hasHitEOF = true;
        return null;
    L46:
        throw new InvalidFormatException();
    L9:
        return null;
    L47:
        entry.setName(path);
        entry.setSimpleName(this.names.get(Integer.valueOf(entry.getIno())).getName());
        entry.setOffset(this.filepos);
        return entry;
    L5:
        return this.queue.remove();
    }

    private void readDirectoryEntry(DumpArchiveEntry entry) throws IOException {
        long size = entry.getEntrySize();
        boolean first = true;
        long size2 = size;
        DumpArchiveEntry entry2 = entry;
    L4:
        if (first == false) goto L6;
    L9:
        if (first == true) goto L12;
        this.raw.readRecord();
    L12:
        if (this.names.containsKey(Integer.valueOf(entry2.getIno())) == false) goto L14;
    L16:
        int datalen = entry2.getHeaderCount() * 1024;
        if (this.blockBuffer.length >= datalen) goto L20;
        this.blockBuffer = new byte[datalen];
    L20:
        if (this.raw.read(this.blockBuffer, 0, datalen) != datalen) goto L51;
        int i = 0;
    L23:
        if (i >= (datalen - 8)) goto L45;
        if (i >= (size2 - 8)) goto L45;
        int ino = DumpArchiveUtil.convert32(this.blockBuffer, i);
        int reclen = DumpArchiveUtil.convert16(this.blockBuffer, i + 4);
        byte type = this.blockBuffer[i + 6];
        String name = DumpArchiveUtil.decode(this.zipEncoding, this.blockBuffer, i + 8, this.blockBuffer[i + 7]);
        if (".".equals(name) == false) goto L29;
        DumpArchiveEntry entry3 = entry2;
        long size3 = size2;
    L44:
        i = i + reclen;
        entry2 = entry3;
        size2 = size3;
        goto L23
    L29:
        if ("..".equals(name) == false) goto L31;
        entry3 = entry2;
        size3 = size2;
        goto L44
    L31:
        Dirent d = new Dirent(ino, entry2.getIno(), type, name);
        this.names.put(Integer.valueOf(ino), d);
        Iterator<Map.Entry<Integer, DumpArchiveEntry>> r12 = this.pending.entrySet().iterator();
    L33:
        if (r12.hasNext() == false) goto L39;
        Map.Entry<Integer, DumpArchiveEntry> e = r12.next();
        String path = getPath(e.getValue());
        if (path == null) goto L38;
        e.getValue().setName(path);
        e.getValue().setSimpleName(this.names.get(e.getKey()).getName());
        this.queue.add(e.getValue());
    L38:
        entry2 = entry2;
        size2 = size2;
        goto L33
    L39:
        entry3 = entry2;
        size3 = size2;
        Iterator<DumpArchiveEntry> r1 = this.queue.iterator();
    L41:
        if (r1.hasNext() == false) goto L44;
        this.pending.remove(Integer.valueOf(r1.next().getIno()));
    L45:
        long size4 = size2;
        byte[] peekBytes = this.raw.peek();
        if (DumpArchiveUtil.verify(peekBytes) == false) goto L49;
        first = false;
        entry2 = DumpArchiveEntry.parse(peekBytes);
        size2 = size4 - DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
        goto L4
    L49:
        throw new InvalidFormatException();
    L51:
        throw new EOFException();
    L14:
        if (DumpArchiveConstants.SEGMENT_TYPE.INODE != entry2.getHeaderType()) goto L16;
        this.pending.put(Integer.valueOf(entry2.getIno()), entry2);
        goto L16
    L6:
        if (DumpArchiveConstants.SEGMENT_TYPE.ADDR == entry2.getHeaderType()) goto L9;
    }

    private String getPath(DumpArchiveEntry entry) {
        Stack<String> elements = new Stack();
        int i = entry.getIno();
    L4:
        if (this.names.containsKey(Integer.valueOf(i)) == false) goto L5;
        Dirent dirent = this.names.get(Integer.valueOf(i));
        elements.push(dirent.getName());
        if (dirent.getIno() == dirent.getParentIno()) goto L9;
        i = dirent.getParentIno();
    L9:
        if (elements.isEmpty() == false) goto L12;
        this.pending.put(Integer.valueOf(entry.getIno()), entry);
        return null;
    L12:
        StringBuilder sb = new StringBuilder(elements.pop());
    L14:
        if (elements.isEmpty() == true) goto L17;
        sb.append('/');
        sb.append(elements.pop());
        goto L14
    L17:
        return sb.toString();
    L5:
        elements.clear();
        goto L9
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        int totalRead = 0;
        if (this.hasHitEOF == false) goto L5;
        return -1;
    L5:
        if (this.isClosed == false) goto L7;
        return -1;
    L7:
        if (this.entryOffset < this.entrySize) goto L10;
        return -1;
    L10:
        if (this.active == null) goto L43;
        if ((((long) len) + this.entryOffset) <= this.entrySize) goto L14;
        len = (int) (this.entrySize - this.entryOffset);
    L14:
        if (len <= 0) goto L40;
        if (len <= (this.readBuf.length - this.recordOffset)) goto L18;
        int sz = this.readBuf.length - this.recordOffset;
    L20:
        if ((this.recordOffset + sz) > this.readBuf.length) goto L22;
        System.arraycopy(this.readBuf, this.recordOffset, buf, off, sz);
        totalRead = totalRead + sz;
        this.recordOffset += sz;
        len = len - sz;
        off = off + sz;
    L22:
        if (len <= 0) goto L14;
        if (this.readIdx < 512) goto L30;
        byte[] headerBytes = this.raw.readRecord();
        if (DumpArchiveUtil.verify(headerBytes) == false) goto L29;
        this.active = DumpArchiveEntry.parse(headerBytes);
        this.readIdx = 0;
        goto L30
    L29:
        throw new InvalidFormatException();
    L30:
        DumpArchiveEntry r2 = this.active;
        int r3 = this.readIdx;
        this.readIdx = r3 + 1;
        if (r2.isSparseRecord(r3) == true) goto L37;
        int r = this.raw.read(this.readBuf, 0, this.readBuf.length);
        if (r != this.readBuf.length) goto L36;
    L38:
        this.recordOffset = 0;
        goto L14
    L36:
        throw new EOFException();
    L37:
        Arrays.fill(this.readBuf, (byte) 0);
        goto L38
    L18:
        sz = len;
        goto L20
    L40:
        this.entryOffset += (long) totalRead;
        return totalRead;
    L43:
        throw new IllegalStateException("No current dump entry");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.isClosed == true) goto L6;
        this.isClosed = true;
        this.raw.close();
        return;
    }

    public static boolean matches(byte[] buffer, int length) {
        if (length >= 32) goto L6;
        return false;
    L6:
        if (length < 1024) goto L10;
        return DumpArchiveUtil.verify(buffer);
    L10:
        if (60012 != DumpArchiveUtil.convert32(buffer, 24)) goto L13;
        return true;
    L13:
        return false;
    }
}
