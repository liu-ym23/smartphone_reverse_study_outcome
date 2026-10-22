package org.apache.commons.compress.archivers.cpio;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class CpioArchiveInputStream extends ArchiveInputStream implements CpioConstants {
    private final int blockSize;
    private boolean closed;
    private long crc;
    final String encoding;
    private CpioArchiveEntry entry;
    private long entryBytesRead;
    private boolean entryEOF;
    private final byte[] fourBytesBuf;
    private final InputStream in;
    private final byte[] sixBytesBuf;
    private final byte[] tmpbuf;
    private final byte[] twoBytesBuf;
    private final ZipEncoding zipEncoding;

    public CpioArchiveInputStream(InputStream in) {
        this(in, 512, CharsetNames.US_ASCII);
    }

    public CpioArchiveInputStream(InputStream in, String encoding) {
        this(in, 512, encoding);
    }

    public CpioArchiveInputStream(InputStream in, int blockSize) {
        this(in, blockSize, CharsetNames.US_ASCII);
    }

    public CpioArchiveInputStream(InputStream in, int blockSize, String encoding) {
        this.closed = false;
        this.entryBytesRead = 0;
        this.entryEOF = false;
        this.tmpbuf = new byte[4096];
        this.crc = 0;
        this.twoBytesBuf = new byte[2];
        this.fourBytesBuf = new byte[4];
        this.sixBytesBuf = new byte[6];
        this.in = in;
        this.blockSize = blockSize;
        this.encoding = encoding;
        this.zipEncoding = ZipEncodingHelper.getZipEncoding(encoding);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        ensureOpen();
        if (this.entryEOF == false) goto L6;
        return 0;
    L6:
        return 1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed == true) goto L6;
        this.in.close();
        this.closed = true;
        return;
    }

    private void closeEntry() throws IOException {
    L3:
        if (skip(2147483647L) == 2147483647L) goto L3;
    }

    private void ensureOpen() throws IOException {
        if (this.closed == true) goto L6;
        return;
    L6:
        throw new IOException("Stream closed");
    }

    public CpioArchiveEntry getNextCPIOEntry() throws IOException {
        ensureOpen();
        if (this.entry == null) goto L5;
        closeEntry();
    L5:
        readFully(this.twoBytesBuf, 0, this.twoBytesBuf.length);
        if (CpioUtil.byteArray2long(this.twoBytesBuf, false) != 29127) goto L9;
        this.entry = readOldBinaryEntry(false);
    L30:
        this.entryBytesRead = 0;
        this.entryEOF = false;
        this.crc = 0;
        if (this.entry.getName().equals(CpioConstants.CPIO_TRAILER) == false) goto L35;
        this.entryEOF = true;
        skipRemainderOfLastBlock();
        return null;
    L35:
        return this.entry;
    L9:
        if (CpioUtil.byteArray2long(this.twoBytesBuf, true) != 29127) goto L11;
        this.entry = readOldBinaryEntry(true);
        goto L30
    L11:
        System.arraycopy(this.twoBytesBuf, 0, this.sixBytesBuf, 0, this.twoBytesBuf.length);
        readFully(this.sixBytesBuf, this.twoBytesBuf.length, this.fourBytesBuf.length);
        String magicString = ArchiveUtils.toAsciiString(this.sixBytesBuf);
        switch(magicString.hashCode()) {
            case 1426477263: goto L21;
            case 1426477264: goto L18;
            case 1426477269: goto L15;
            default: goto L23;
        };
    L23:
        byte r3 = -1;
    L24:
        switch(r3) {
            case 0: goto L29;
            case 1: goto L28;
            case 2: goto L27;
            default: goto L26;
        };
    L27:
        this.entry = readOldAsciiEntry();
        goto L30
    L28:
        this.entry = readNewEntry(true);
        goto L30
    L29:
        this.entry = readNewEntry(false);
        goto L30
    L26:
        throw new IOException("Unknown magic [" + magicString + "]. Occured at byte: " + getBytesRead());
    L15:
        if (magicString.equals(CpioConstants.MAGIC_OLD_ASCII) == false) goto L23;
        r3 = 2;
        goto L24
    L18:
        if (magicString.equals(CpioConstants.MAGIC_NEW_CRC) == false) goto L23;
        r3 = 1;
        goto L24
    L21:
        if (magicString.equals(CpioConstants.MAGIC_NEW) == false) goto L23;
        r3 = 0;
        goto L24
    }

    private void skip(int bytes) throws IOException {
        if (bytes <= 0) goto L5;
        readFully(this.fourBytesBuf, 0, bytes);
        return;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        ensureOpen();
        if (off < 0) goto L38;
        if (len < 0) goto L38;
        if (off > (b.length - len)) goto L38;
        if (len != 0) goto L11;
        return 0;
    L11:
        if (this.entry != null) goto L13;
    L36:
        return -1;
    L13:
        if (this.entryEOF == true) goto L36;
        if (this.entryBytesRead != this.entry.getSize()) goto L25;
        skip(this.entry.getDataPadCount());
        this.entryEOF = true;
        if (this.entry.getFormat() == 2) goto L20;
    L24:
        return -1;
    L20:
        if (this.crc == this.entry.getChksum()) goto L24;
        throw new IOException("CRC Error. Occured at byte: " + getBytesRead());
    L25:
        int tmplength = (int) Math.min(len, this.entry.getSize() - this.entryBytesRead);
        if (tmplength >= 0) goto L28;
        return -1;
    L28:
        int tmpread = readFully(b, off, tmplength);
        if (this.entry.getFormat() != 2) goto L33;
        int pos = 0;
    L31:
        if (pos >= tmpread) goto L33;
        this.crc += (long) (b[pos] & CecDeviceType.INACTIVE);
        this.crc &= 4294967295L;
        pos = pos + 1;
    L33:
        if (tmpread <= 0) goto L35;
        this.entryBytesRead += (long) tmpread;
    L35:
        return tmpread;
    L38:
        throw new IndexOutOfBoundsException();
    }

    private final int readFully(byte[] b, int off, int len) throws IOException {
        int count = IOUtils.readFully(this.in, b, off, len);
        count(count);
        if (count < len) goto L6;
        return count;
    L6:
        throw new EOFException();
    }

    private long readBinaryLong(int length, boolean swapHalfWord) throws IOException {
        byte[] tmp = new byte[length];
        readFully(tmp, 0, tmp.length);
        return CpioUtil.byteArray2long(tmp, swapHalfWord);
    }

    private long readAsciiLong(int length, int radix) throws IOException {
        byte[] tmpBuffer = new byte[length];
        readFully(tmpBuffer, 0, tmpBuffer.length);
        return Long.parseLong(ArchiveUtils.toAsciiString(tmpBuffer), radix);
    }

    private CpioArchiveEntry readNewEntry(boolean hasCrc) throws IOException {
        if (hasCrc == false) goto L4;
        CpioArchiveEntry ret = new CpioArchiveEntry(2);
    L5:
        ret.setInode(readAsciiLong(8, 16));
        long mode = readAsciiLong(8, 16);
        if (CpioUtil.fileType(mode) == 0) goto L8;
        ret.setMode(mode);
    L8:
        ret.setUID(readAsciiLong(8, 16));
        ret.setGID(readAsciiLong(8, 16));
        ret.setNumberOfLinks(readAsciiLong(8, 16));
        ret.setTime(readAsciiLong(8, 16));
        ret.setSize(readAsciiLong(8, 16));
        ret.setDeviceMaj(readAsciiLong(8, 16));
        ret.setDeviceMin(readAsciiLong(8, 16));
        ret.setRemoteDeviceMaj(readAsciiLong(8, 16));
        ret.setRemoteDeviceMin(readAsciiLong(8, 16));
        long namesize = readAsciiLong(8, 16);
        ret.setChksum(readAsciiLong(8, 16));
        String name = readCString((int) namesize);
        ret.setName(name);
        if (CpioUtil.fileType(mode) == 0) goto L11;
    L15:
        skip(ret.getHeaderPadCount(namesize - 1));
        return ret;
    L11:
        if (name.equals(CpioConstants.CPIO_TRAILER) == true) goto L15;
        throw new IOException("Mode 0 only allowed in the trailer. Found entry name: " + ArchiveUtils.sanitize(name) + " Occured at byte: " + getBytesRead());
    L4:
        ret = new CpioArchiveEntry(1);
        goto L5
    }

    private CpioArchiveEntry readOldAsciiEntry() throws IOException {
        CpioArchiveEntry ret = new CpioArchiveEntry(4);
        ret.setDevice(readAsciiLong(6, 8));
        ret.setInode(readAsciiLong(6, 8));
        long mode = readAsciiLong(6, 8);
        if (CpioUtil.fileType(mode) == 0) goto L5;
        ret.setMode(mode);
    L5:
        ret.setUID(readAsciiLong(6, 8));
        ret.setGID(readAsciiLong(6, 8));
        ret.setNumberOfLinks(readAsciiLong(6, 8));
        ret.setRemoteDevice(readAsciiLong(6, 8));
        ret.setTime(readAsciiLong(11, 8));
        long namesize = readAsciiLong(6, 8);
        ret.setSize(readAsciiLong(11, 8));
        String name = readCString((int) namesize);
        ret.setName(name);
        if (CpioUtil.fileType(mode) == 0) goto L8;
    L12:
        return ret;
    L8:
        if (name.equals(CpioConstants.CPIO_TRAILER) == true) goto L12;
        throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(name) + " Occured at byte: " + getBytesRead());
    }

    private CpioArchiveEntry readOldBinaryEntry(boolean swapHalfWord) throws IOException {
        CpioArchiveEntry ret = new CpioArchiveEntry(8);
        ret.setDevice(readBinaryLong(2, swapHalfWord));
        ret.setInode(readBinaryLong(2, swapHalfWord));
        long mode = readBinaryLong(2, swapHalfWord);
        if (CpioUtil.fileType(mode) == 0) goto L5;
        ret.setMode(mode);
    L5:
        ret.setUID(readBinaryLong(2, swapHalfWord));
        ret.setGID(readBinaryLong(2, swapHalfWord));
        ret.setNumberOfLinks(readBinaryLong(2, swapHalfWord));
        ret.setRemoteDevice(readBinaryLong(2, swapHalfWord));
        ret.setTime(readBinaryLong(4, swapHalfWord));
        long namesize = readBinaryLong(2, swapHalfWord);
        ret.setSize(readBinaryLong(4, swapHalfWord));
        String name = readCString((int) namesize);
        ret.setName(name);
        if (CpioUtil.fileType(mode) == 0) goto L8;
    L12:
        skip(ret.getHeaderPadCount(namesize - 1));
        return ret;
    L8:
        if (name.equals(CpioConstants.CPIO_TRAILER) == true) goto L12;
        throw new IOException("Mode 0 only allowed in the trailer. Found entry: " + ArchiveUtils.sanitize(name) + "Occured at byte: " + getBytesRead());
    }

    private String readCString(int length) throws IOException {
        byte[] tmpBuffer = new byte[length - 1];
        readFully(tmpBuffer, 0, tmpBuffer.length);
        this.in.read();
        return this.zipEncoding.decode(tmpBuffer);
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (n < 0) goto L16;
        ensureOpen();
        int max = (int) Math.min(n, 2147483647L);
        int total = 0;
    L5:
        if (total >= max) goto L14;
        int len = max - total;
        if (len <= this.tmpbuf.length) goto L9;
        len = this.tmpbuf.length;
    L9:
        int len2 = read(this.tmpbuf, 0, len);
        if (len2 == (-1)) goto L11;
        total = total + len2;
        goto L5
    L11:
        this.entryEOF = true;
    L14:
        return total;
    L16:
        throw new IllegalArgumentException("negative skip length");
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArchiveEntry getNextEntry() throws IOException {
        return getNextCPIOEntry();
    }

    private void skipRemainderOfLastBlock() throws IOException {
        long readFromLastBlock = getBytesRead() % ((long) this.blockSize);
        if (readFromLastBlock != 0) goto L5;
        long remainingBytes = 0;
    L8:
        if (remainingBytes <= 0) goto L13;
        long skipped = skip(((long) this.blockSize) - readFromLastBlock);
        if (skipped <= 0) goto L17;
        remainingBytes = remainingBytes - skipped;
        goto L8
    L17:
        return;
    L13:
        return;
    L5:
        remainingBytes = ((long) this.blockSize) - readFromLastBlock;
        goto L8
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= 6) goto L6;
        return false;
    L6:
        if (signature[0] != 113) goto L11;
        if ((signature[1] & CecDeviceType.INACTIVE) != 199) goto L11;
        return true;
    L11:
        if (signature[1] != 113) goto L16;
        if ((signature[0] & CecDeviceType.INACTIVE) != 199) goto L16;
        return true;
    L16:
        if (signature[0] == 48) goto L19;
        return false;
    L19:
        if (signature[1] == 55) goto L22;
        return false;
    L22:
        if (signature[2] == 48) goto L25;
        return false;
    L25:
        if (signature[3] == 55) goto L28;
        return false;
    L28:
        if (signature[4] == 48) goto L31;
        return false;
    L31:
        if (signature[5] != 49) goto L34;
        return true;
    L34:
        if (signature[5] != 50) goto L37;
        return true;
    L37:
        if (signature[5] != 55) goto L39;
        return true;
    L39:
        return false;
    }
}
