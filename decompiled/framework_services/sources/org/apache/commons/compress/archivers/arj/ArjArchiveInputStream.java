package org.apache.commons.compress.archivers.arj;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.CRC32VerifyingInputStream;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ArjArchiveInputStream extends ArchiveInputStream {
    private static final int ARJ_MAGIC_1 = 96;
    private static final int ARJ_MAGIC_2 = 234;
    private final String charsetName;
    private InputStream currentInputStream;
    private LocalFileHeader currentLocalFileHeader;
    private final DataInputStream in;
    private final MainHeader mainHeader;

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public /* bridge */ /* synthetic */ ArchiveEntry getNextEntry() throws IOException {
        return getNextEntry();
    }

    public ArjArchiveInputStream(InputStream inputStream, String charsetName) throws ArchiveException {
        this.currentLocalFileHeader = null;
        this.currentInputStream = null;
        this.in = new DataInputStream(inputStream);
        this.charsetName = charsetName;
        this.mainHeader = readMainHeader();     // Catch: IOException -> L10
        if ((this.mainHeader.arjFlags & 1) != 0) goto L13;
        if ((this.mainHeader.arjFlags & 4) != 0) goto L9;
        return;
    L9:
        throw new ArchiveException("Multi-volume ARJ files are unsupported");     // Catch: IOException -> L10
    L13:
        throw new ArchiveException("Encrypted ARJ files are unsupported");     // Catch: IOException -> L10
    L10:
        ioException = move-exception;
        throw new ArchiveException(ioException.getMessage(), ioException);
    }

    public ArjArchiveInputStream(InputStream inputStream) throws ArchiveException {
        this(inputStream, "CP437");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    private int read8(DataInputStream dataIn) throws IOException {
        int value = dataIn.readUnsignedByte();
        count(1);
        return value;
    }

    private int read16(DataInputStream dataIn) throws IOException {
        int value = dataIn.readUnsignedShort();
        count(2);
        return Integer.reverseBytes(value) >>> 16;
    }

    private int read32(DataInputStream dataIn) throws IOException {
        int value = dataIn.readInt();
        count(4);
        return Integer.reverseBytes(value);
    }

    private String readString(DataInputStream dataIn) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    L3:
        int nextByte = dataIn.readUnsignedByte();
        if (nextByte == 0) goto L7;
        buffer.write(nextByte);
        goto L3
    L7:
        if (this.charsetName == null) goto L11;
        return new String(buffer.toByteArray(), this.charsetName);
    L11:
        return new String(buffer.toByteArray());
    }

    private void readFully(DataInputStream dataIn, byte[] b) throws IOException {
        dataIn.readFully(b);
        count(b.length);
    }

    private byte[] readHeader() throws IOException {
        boolean found = false;
        byte[] basicHeaderBytes = null;
    L3:
        int second = read8(this.in);
    L4:
        int first = second;
        second = read8(this.in);
        if (first == 96) goto L8;
        if (second != ARJ_MAGIC_2) goto L4;
    L8:
        int basicHeaderSize = read16(this.in);
        if (basicHeaderSize == 0) goto L10;
        if (basicHeaderSize > 2600) goto L17;
        basicHeaderBytes = new byte[basicHeaderSize];
        readFully(this.in, basicHeaderBytes);
        long basicHeaderCrc32 = ((long) read32(this.in)) & 4294967295L;
        CRC32 crc32 = new CRC32();
        crc32.update(basicHeaderBytes);
        if (basicHeaderCrc32 != crc32.getValue()) goto L17;
        found = true;
    L17:
        if (found == false) goto L3;
        return basicHeaderBytes;
    L10:
        return null;
    }

    private MainHeader readMainHeader() throws IOException {
        byte[] basicHeaderBytes = readHeader();
        if (basicHeaderBytes == null) goto L16;
        DataInputStream basicHeader = new DataInputStream(new ByteArrayInputStream(basicHeaderBytes));
        int firstHeaderSize = basicHeader.readUnsignedByte();
        byte[] firstHeaderBytes = new byte[firstHeaderSize - 1];
        basicHeader.readFully(firstHeaderBytes);
        DataInputStream firstHeader = new DataInputStream(new ByteArrayInputStream(firstHeaderBytes));
        MainHeader hdr = new MainHeader();
        hdr.archiverVersionNumber = firstHeader.readUnsignedByte();
        hdr.minVersionToExtract = firstHeader.readUnsignedByte();
        hdr.hostOS = firstHeader.readUnsignedByte();
        hdr.arjFlags = firstHeader.readUnsignedByte();
        hdr.securityVersion = firstHeader.readUnsignedByte();
        hdr.fileType = firstHeader.readUnsignedByte();
        hdr.reserved = firstHeader.readUnsignedByte();
        hdr.dateTimeCreated = read32(firstHeader);
        hdr.dateTimeModified = read32(firstHeader);
        hdr.archiveSize = ((long) read32(firstHeader)) & 4294967295L;
        hdr.securityEnvelopeFilePosition = read32(firstHeader);
        hdr.fileSpecPosition = read16(firstHeader);
        hdr.securityEnvelopeLength = read16(firstHeader);
        pushedBackBytes(20);
        hdr.encryptionVersion = firstHeader.readUnsignedByte();
        hdr.lastChapter = firstHeader.readUnsignedByte();
        if (firstHeaderSize < 33) goto L7;
        hdr.arjProtectionFactor = firstHeader.readUnsignedByte();
        hdr.arjFlags2 = firstHeader.readUnsignedByte();
        firstHeader.readUnsignedByte();
        firstHeader.readUnsignedByte();
    L7:
        hdr.name = readString(basicHeader);
        hdr.comment = readString(basicHeader);
        int extendedHeaderSize = read16(this.in);
        if (extendedHeaderSize <= 0) goto L14;
        hdr.extendedHeaderBytes = new byte[extendedHeaderSize];
        readFully(this.in, hdr.extendedHeaderBytes);
        long extendedHeaderCrc32 = ((long) read32(this.in)) & 4294967295L;
        CRC32 crc32 = new CRC32();
        crc32.update(hdr.extendedHeaderBytes);
        if (extendedHeaderCrc32 == crc32.getValue()) goto L14;
        throw new IOException("Extended header CRC32 verification failure");
    L14:
        return hdr;
    L16:
        throw new IOException("Archive ends without any headers");
    }

    private LocalFileHeader readLocalFileHeader() throws IOException {
        byte[] basicHeaderBytes = readHeader();
        if (basicHeaderBytes != null) goto L6;
        return null;
    L6:
        DataInputStream basicHeader = new DataInputStream(new ByteArrayInputStream(basicHeaderBytes));
        int firstHeaderSize = basicHeader.readUnsignedByte();     // Catch: Throwable -> L23
        byte[] firstHeaderBytes = new byte[firstHeaderSize - 1];     // Catch: Throwable -> L23
        basicHeader.readFully(firstHeaderBytes);     // Catch: Throwable -> L23
        DataInputStream firstHeader = new DataInputStream(new ByteArrayInputStream(firstHeaderBytes));     // Catch: Throwable -> L23
        LocalFileHeader localFileHeader = new LocalFileHeader();     // Catch: Throwable -> L15
        localFileHeader.archiverVersionNumber = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.minVersionToExtract = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.hostOS = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.arjFlags = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.method = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.fileType = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.reserved = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.dateTimeModified = read32(firstHeader);     // Catch: Throwable -> L15
        localFileHeader.compressedSize = ((long) read32(firstHeader)) & 4294967295L;     // Catch: Throwable -> L15
        localFileHeader.originalSize = ((long) read32(firstHeader)) & 4294967295L;     // Catch: Throwable -> L15
        localFileHeader.originalCrc32 = ((long) read32(firstHeader)) & 4294967295L;     // Catch: Throwable -> L15
        localFileHeader.fileSpecPosition = read16(firstHeader);     // Catch: Throwable -> L15
        localFileHeader.fileAccessMode = read16(firstHeader);     // Catch: Throwable -> L15
        pushedBackBytes(20);     // Catch: Throwable -> L15
        localFileHeader.firstChapter = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        localFileHeader.lastChapter = firstHeader.readUnsignedByte();     // Catch: Throwable -> L15
        readExtraData(firstHeaderSize, firstHeader, localFileHeader);     // Catch: Throwable -> L15
        localFileHeader.name = readString(basicHeader);     // Catch: Throwable -> L15
        localFileHeader.comment = readString(basicHeader);     // Catch: Throwable -> L15
        ArrayList<byte[]> extendedHeaders = new ArrayList();     // Catch: Throwable -> L15
    L10:
        int extendedHeaderSize = read16(this.in);     // Catch: Throwable -> L15
        if (extendedHeaderSize <= 0) goto L19;
        byte[] extendedHeaderBytes = new byte[extendedHeaderSize];     // Catch: Throwable -> L15
        readFully(this.in, extendedHeaderBytes);     // Catch: Throwable -> L15
        long extendedHeaderCrc32 = ((long) read32(this.in)) & 4294967295L;     // Catch: Throwable -> L15
        CRC32 crc32 = new CRC32();     // Catch: Throwable -> L15
        crc32.update(extendedHeaderBytes);     // Catch: Throwable -> L15
        if (extendedHeaderCrc32 != crc32.getValue()) goto L18;
        extendedHeaders.add(extendedHeaderBytes);     // Catch: Throwable -> L15
        goto L10
    L18:
        throw new IOException("Extended header CRC32 verification failure");     // Catch: Throwable -> L15
    L19:
        localFileHeader.extendedHeaders = (byte[][]) extendedHeaders.toArray(new byte[extendedHeaders.size()][]);     // Catch: Throwable -> L15
        firstHeader.close();     // Catch: Throwable -> L23
        basicHeader.close();
        return localFileHeader;
    L15:
        th = move-exception;
        firstHeader.close();     // Catch: Throwable -> L27
    L43:
        throw th;     // Catch: Throwable -> L23
    L27:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        basicHeader.close();     // Catch: Throwable -> L32
        throw th;
    L32:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    }

    private void readExtraData(int firstHeaderSize, DataInputStream firstHeader, LocalFileHeader localFileHeader) throws IOException {
        if (firstHeaderSize < 33) goto L9;
        localFileHeader.extendedFilePosition = read32(firstHeader);
        if (firstHeaderSize < 45) goto L7;
        localFileHeader.dateTimeAccessed = read32(firstHeader);
        localFileHeader.dateTimeCreated = read32(firstHeader);
        localFileHeader.originalSizeEvenForVolumes = read32(firstHeader);
        pushedBackBytes(12);
    L7:
        pushedBackBytes(4);
        return;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= 2) goto L5;
        return false;
    L5:
        if ((signature[0] & CecDeviceType.INACTIVE) == 96) goto L7;
        return false;
    L7:
        if ((signature[1] & CecDeviceType.INACTIVE) == ARJ_MAGIC_2) goto L9;
        return false;
    L9:
        return true;
    }

    public String getArchiveName() {
        return this.mainHeader.name;
    }

    public String getArchiveComment() {
        return this.mainHeader.comment;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public ArjArchiveEntry getNextEntry() throws IOException {
        if (this.currentInputStream == null) goto L5;
        IOUtils.skip(this.currentInputStream, Long.MAX_VALUE);
        this.currentInputStream.close();
        this.currentLocalFileHeader = null;
        this.currentInputStream = null;
    L5:
        this.currentLocalFileHeader = readLocalFileHeader();
        if (this.currentLocalFileHeader == null) goto L12;
        this.currentInputStream = new BoundedInputStream(this.in, this.currentLocalFileHeader.compressedSize);
        if (this.currentLocalFileHeader.method != 0) goto L11;
        this.currentInputStream = new CRC32VerifyingInputStream(this.currentInputStream, this.currentLocalFileHeader.originalSize, this.currentLocalFileHeader.originalCrc32);
    L11:
        return new ArjArchiveEntry(this.currentLocalFileHeader);
    L12:
        this.currentInputStream = null;
        return null;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveInputStream
    public boolean canReadEntryData(ArchiveEntry ae) {
        if ((ae instanceof ArjArchiveEntry) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ArjArchiveEntry) ae).getMethod() != 0) goto L7;
        return true;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.currentLocalFileHeader == null) goto L11;
        if (this.currentLocalFileHeader.method != 0) goto L9;
        return this.currentInputStream.read(b, off, len);
    L9:
        throw new IOException("Unsupported compression method " + this.currentLocalFileHeader.method);
    L11:
        throw new IllegalStateException("No current arj entry");
    }
}
