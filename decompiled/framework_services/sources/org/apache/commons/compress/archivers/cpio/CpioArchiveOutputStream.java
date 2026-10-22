package org.apache.commons.compress.archivers.cpio;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes3.dex */
public class CpioArchiveOutputStream extends ArchiveOutputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private final short entryFormat;
    private boolean finished;
    private final HashMap<String, CpioArchiveEntry> names;
    private long nextArtificalDeviceAndInode;
    private final OutputStream out;
    private long written;
    private final ZipEncoding zipEncoding;

    public CpioArchiveOutputStream(OutputStream out, short format) {
        this(out, format, 512, CharsetNames.US_ASCII);
    }

    public CpioArchiveOutputStream(OutputStream out, short format, int blockSize) {
        this(out, format, blockSize, CharsetNames.US_ASCII);
    }

    public CpioArchiveOutputStream(OutputStream out, short format, int blockSize, String encoding) {
        this.closed = false;
        this.names = new HashMap();
        this.crc = 0;
        this.nextArtificalDeviceAndInode = 1;
        this.out = out;
        switch(format) {
            case 1: goto L6;
            case 2: goto L6;
            case 4: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        this.entryFormat = format;
        this.blockSize = blockSize;
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
        return;
    L5:
        throw new IllegalArgumentException("Unknown format: " + format);
    }

    public CpioArchiveOutputStream(OutputStream out) {
        this(out, 1);
    }

    public CpioArchiveOutputStream(OutputStream out, String encoding) {
        this(out, 1, 512, encoding);
    }

    private void ensureOpen() throws IOException {
        if (this.closed == true) goto L6;
        return;
    L6:
        throw new IOException("Stream closed");
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry entry) throws IOException {
        if (this.finished == true) goto L21;
        CpioArchiveEntry e = (CpioArchiveEntry) entry;
        ensureOpen();
        if (this.entry == null) goto L8;
        closeArchiveEntry();
    L8:
        if (e.getTime() != (-1)) goto L10;
        e.setTime(System.currentTimeMillis() / 1000);
    L10:
        short format = e.getFormat();
        if (format != this.entryFormat) goto L19;
        if (this.names.put(e.getName(), e) != null) goto L17;
        writeHeader(e);
        this.entry = e;
        this.written = 0;
        return;
    L17:
        throw new IOException("duplicate entry: " + e.getName());
    L19:
        throw new IOException("Header format: " + format + " does not match existing format: " + this.entryFormat);
    L21:
        throw new IOException("Stream has already been finished");
    }

    private void writeHeader(CpioArchiveEntry e) throws IOException {
        switch(e.getFormat()) {
            case 1: goto L9;
            case 2: goto L8;
            case 4: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        writeBinaryLong(29127, 2, true);
        writeOldBinaryEntry(e, true);
        return;
    L7:
        this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_OLD_ASCII));
        count(6);
        writeOldAsciiEntry(e);
        return;
    L8:
        this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW_CRC));
        count(6);
        writeNewEntry(e);
        return;
    L9:
        this.out.write(ArchiveUtils.toAsciiBytes(CpioConstants.MAGIC_NEW));
        count(6);
        writeNewEntry(e);
        return;
    L5:
        throw new IOException("unknown format " + e.getFormat());
    }

    private void writeNewEntry(CpioArchiveEntry entry) throws IOException {
        long inode = entry.getInode();
        long devMin = entry.getDeviceMin();
        if (CpioConstants.CPIO_TRAILER.equals(entry.getName()) == false) goto L6;
        devMin = 0;
        inode = 0;
    L11:
        writeAsciiLong(inode, 8, 16);
        writeAsciiLong(entry.getMode(), 8, 16);
        writeAsciiLong(entry.getUID(), 8, 16);
        writeAsciiLong(entry.getGID(), 8, 16);
        writeAsciiLong(entry.getNumberOfLinks(), 8, 16);
        writeAsciiLong(entry.getTime(), 8, 16);
        writeAsciiLong(entry.getSize(), 8, 16);
        writeAsciiLong(entry.getDeviceMaj(), 8, 16);
        writeAsciiLong(devMin, 8, 16);
        writeAsciiLong(entry.getRemoteDeviceMaj(), 8, 16);
        writeAsciiLong(entry.getRemoteDeviceMin(), 8, 16);
        byte[] name = encode(entry.getName());
        writeAsciiLong(((long) name.length) + 1, 8, 16);
        writeAsciiLong(entry.getChksum(), 8, 16);
        writeCString(name);
        pad(entry.getHeaderPadCount(name.length));
        return;
    L6:
        if (inode == 0) goto L8;
    L10:
        this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (4294967296L * devMin) + inode) + 1;
        goto L11
    L8:
        if (devMin != 0) goto L10;
        inode = this.nextArtificalDeviceAndInode & (-1);
        long r7 = this.nextArtificalDeviceAndInode;
        this.nextArtificalDeviceAndInode = r7 + 1;
        devMin = (r7 >> 32) & (-1);
        goto L11
    }

    private void writeOldAsciiEntry(CpioArchiveEntry entry) throws IOException {
        long inode = entry.getInode();
        long device = entry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(entry.getName()) == false) goto L6;
        device = 0;
        inode = 0;
    L11:
        writeAsciiLong(device, 6, 8);
        writeAsciiLong(inode, 6, 8);
        writeAsciiLong(entry.getMode(), 6, 8);
        writeAsciiLong(entry.getUID(), 6, 8);
        writeAsciiLong(entry.getGID(), 6, 8);
        writeAsciiLong(entry.getNumberOfLinks(), 6, 8);
        writeAsciiLong(entry.getRemoteDevice(), 6, 8);
        writeAsciiLong(entry.getTime(), 11, 8);
        byte[] name = encode(entry.getName());
        writeAsciiLong(((long) name.length) + 1, 6, 8);
        writeAsciiLong(entry.getSize(), 11, 8);
        writeCString(name);
        return;
    L6:
        if (inode == 0) goto L8;
    L10:
        this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (262144 * device) + inode) + 1;
        goto L11
    L8:
        if (device != 0) goto L10;
        inode = this.nextArtificalDeviceAndInode & 262143;
        long r7 = this.nextArtificalDeviceAndInode;
        this.nextArtificalDeviceAndInode = r7 + 1;
        device = (r7 >> 18) & 262143;
        goto L11
    }

    private void writeOldBinaryEntry(CpioArchiveEntry entry, boolean swapHalfWord) throws IOException {
        long inode = entry.getInode();
        long device = entry.getDevice();
        if (CpioConstants.CPIO_TRAILER.equals(entry.getName()) == false) goto L6;
        device = 0;
        inode = 0;
    L11:
        writeBinaryLong(device, 2, swapHalfWord);
        writeBinaryLong(inode, 2, swapHalfWord);
        writeBinaryLong(entry.getMode(), 2, swapHalfWord);
        writeBinaryLong(entry.getUID(), 2, swapHalfWord);
        writeBinaryLong(entry.getGID(), 2, swapHalfWord);
        writeBinaryLong(entry.getNumberOfLinks(), 2, swapHalfWord);
        writeBinaryLong(entry.getRemoteDevice(), 2, swapHalfWord);
        writeBinaryLong(entry.getTime(), 4, swapHalfWord);
        byte[] name = encode(entry.getName());
        writeBinaryLong(((long) name.length) + 1, 2, swapHalfWord);
        writeBinaryLong(entry.getSize(), 4, swapHalfWord);
        writeCString(name);
        pad(entry.getHeaderPadCount(name.length));
        return;
    L6:
        if (inode == 0) goto L8;
    L10:
        this.nextArtificalDeviceAndInode = Math.max(this.nextArtificalDeviceAndInode, (65536 * device) + inode) + 1;
        goto L11
    L8:
        if (device != 0) goto L10;
        inode = this.nextArtificalDeviceAndInode & 65535;
        long r7 = this.nextArtificalDeviceAndInode;
        this.nextArtificalDeviceAndInode = r7 + 1;
        device = (r7 >> 16) & 65535;
        goto L11
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        if (this.finished == true) goto L22;
        ensureOpen();
        if (this.entry == null) goto L20;
        if (this.entry.getSize() != this.written) goto L18;
        pad(this.entry.getDataPadCount());
        if (this.entry.getFormat() == 2) goto L11;
    L15:
        this.entry = null;
        this.crc = 0;
        this.written = 0;
        return;
    L11:
        if (this.crc == this.entry.getChksum()) goto L15;
        throw new IOException("CRC Error");
    L18:
        throw new IOException("invalid entry size (expected " + this.entry.getSize() + " but got " + this.written + " bytes)");
    L20:
        throw new IOException("Trying to close non-existent entry");
    L22:
        throw new IOException("Stream has already been finished");
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        ensureOpen();
        if (off < 0) goto L25;
        if (len < 0) goto L25;
        if (off > (b.length - len)) goto L25;
        if (len != 0) goto L10;
        return;
    L10:
        if (this.entry == null) goto L23;
        if ((this.written + ((long) len)) > this.entry.getSize()) goto L21;
        this.out.write(b, off, len);
        this.written += (long) len;
        if (this.entry.getFormat() != 2) goto L18;
        int pos = 0;
    L16:
        if (pos >= len) goto L18;
        this.crc += (long) (b[pos] & CecDeviceType.INACTIVE);
        this.crc &= 4294967295L;
        pos = pos + 1;
    L18:
        count(len);
        return;
    L21:
        throw new IOException("attempt to write past end of STORED entry");
    L23:
        throw new IOException("no current CPIO entry");
    L25:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        ensureOpen();
        if (this.finished == true) goto L14;
        if (this.entry != null) goto L12;
        this.entry = new CpioArchiveEntry(this.entryFormat);
        this.entry.setName(CpioConstants.CPIO_TRAILER);
        this.entry.setNumberOfLinks(1);
        writeHeader(this.entry);
        closeArchiveEntry();
        int lengthOfLastBlock = (int) (getBytesWritten() % ((long) this.blockSize));
        if (lengthOfLastBlock == 0) goto L9;
        pad(this.blockSize - lengthOfLastBlock);
    L9:
        this.finished = true;
        return;
    L12:
        throw new IOException("This archive contains unclosed entries.");
    L14:
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

    private void pad(int count) throws IOException {
        if (count <= 0) goto L5;
        byte[] buff = new byte[count];
        this.out.write(buff);
        count(count);
        return;
    }

    private void writeBinaryLong(long number, int length, boolean swapHalfWord) throws IOException {
        byte[] tmp = CpioUtil.long2byteArray(number, length, swapHalfWord);
        this.out.write(tmp);
        count(tmp.length);
    }

    private void writeAsciiLong(long number, int length, int radix) throws IOException {
        StringBuilder tmp = new StringBuilder();
        if (radix != 16) goto L6;
        tmp.append(Long.toHexString(number));
    L10:
        if (tmp.length() > length) goto L15;
        int insertLength = length - tmp.length();
        int pos = 0;
    L12:
        if (pos >= insertLength) goto L14;
        tmp.insert(0, "0");
        pos = pos + 1;
        goto L12
    L14:
        String tmpStr = tmp.toString();
    L16:
        byte[] b = ArchiveUtils.toAsciiBytes(tmpStr);
        this.out.write(b);
        count(b.length);
        return;
    L15:
        tmpStr = tmp.substring(tmp.length() - length);
        goto L16
    L6:
        if (radix != 8) goto L8;
        tmp.append(Long.toOctalString(number));
        goto L10
    L8:
        tmp.append(Long.toString(number));
        goto L10
    }

    private byte[] encode(String str) throws IOException {
        ByteBuffer buf = this.zipEncoding.encode(str);
        int len = buf.limit() - buf.position();
        return Arrays.copyOfRange(buf.array(), buf.arrayOffset(), buf.arrayOffset() + len);
    }

    private void writeCString(byte[] str) throws IOException {
        this.out.write(str);
        this.out.write(0);
        count(str.length + 1);
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        if (this.finished == true) goto L7;
        return new CpioArchiveEntry(inputFile, entryName);
    L7:
        throw new IOException("Stream has already been finished");
    }
}
