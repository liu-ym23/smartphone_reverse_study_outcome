package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class Zip64ExtendedInformationExtraField implements ZipExtraField {
    private static final byte[] EMPTY = null;
    static final ZipShort HEADER_ID = null;
    private static final String LFH_MUST_HAVE_BOTH_SIZES_MSG = "Zip64 extended information must contain both size values in the local file header.";
    private ZipEightByteInteger compressedSize;
    private ZipLong diskStart;
    private byte[] rawCentralDirectoryData;
    private ZipEightByteInteger relativeHeaderOffset;
    private ZipEightByteInteger size;

    static {
        HEADER_ID = new ZipShort(1);
        EMPTY = new byte[0];
    }

    public Zip64ExtendedInformationExtraField() {
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger size, ZipEightByteInteger compressedSize) {
        this(size, compressedSize, null, null);
    }

    public Zip64ExtendedInformationExtraField(ZipEightByteInteger size, ZipEightByteInteger compressedSize, ZipEightByteInteger relativeHeaderOffset, ZipLong diskStart) {
        this.size = size;
        this.compressedSize = compressedSize;
        this.relativeHeaderOffset = relativeHeaderOffset;
        this.diskStart = diskStart;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        if (this.size == null) goto L5;
        int r1 = 16;
    L7:
        return new ZipShort(r1);
    L5:
        r1 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        int r2 = 8;
        int r3 = 0;
        if (this.size == null) goto L5;
        int r1 = 8;
    L7:
        if (this.compressedSize == null) goto L9;
        int r4 = 8;
    L10:
        int r5 = r1 + r4;
        if (this.relativeHeaderOffset != null) goto L14;
        r2 = 0;
    L14:
        int r6 = r5 + r2;
        if (this.diskStart == null) goto L18;
        r3 = 4;
    L18:
        return new ZipShort(r6 + r3);
    L9:
        r4 = 0;
        goto L10
    L5:
        r1 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        if (this.size != null) goto L10;
        if (this.compressedSize != null) goto L10;
        return EMPTY;
    L10:
        if (this.size == null) goto L16;
        if (this.compressedSize == null) goto L16;
        byte[] data = new byte[16];
        addSizes(data);
        return data;
    L16:
        throw new IllegalArgumentException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] data = new byte[getCentralDirectoryLength().getValue()];
        int off = addSizes(data);
        if (this.relativeHeaderOffset == null) goto L6;
        System.arraycopy(this.relativeHeaderOffset.getBytes(), 0, data, off, 8);
        off = off + 8;
    L6:
        if (this.diskStart == null) goto L8;
        System.arraycopy(this.diskStart.getBytes(), 0, data, off, 4);
        int r1 = off + 4;
    L8:
        return data;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] buffer, int offset, int length) throws ZipException {
        if (length != 0) goto L5;
        return;
    L5:
        if (length < 16) goto L14;
        this.size = new ZipEightByteInteger(buffer, offset);
        int offset2 = offset + 8;
        this.compressedSize = new ZipEightByteInteger(buffer, offset2);
        int offset3 = offset2 + 8;
        int remaining = length - 16;
        if (remaining < 8) goto L10;
        this.relativeHeaderOffset = new ZipEightByteInteger(buffer, offset3);
        offset3 = offset3 + 8;
        remaining = remaining - 8;
    L10:
        if (remaining < 4) goto L15;
        this.diskStart = new ZipLong(buffer, offset3);
        int r4 = offset3 + 4;
        int r1 = remaining - 4;
        return;
    L15:
        return;
    L14:
        throw new ZipException(LFH_MUST_HAVE_BOTH_SIZES_MSG);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
        this.rawCentralDirectoryData = new byte[length];
        System.arraycopy(buffer, offset, this.rawCentralDirectoryData, 0, length);
        if (length < 28) goto L6;
        parseFromLocalFileData(buffer, offset, length);
        return;
    L6:
        if (length != 24) goto L9;
        this.size = new ZipEightByteInteger(buffer, offset);
        int offset2 = offset + 8;
        this.compressedSize = new ZipEightByteInteger(buffer, offset2);
        this.relativeHeaderOffset = new ZipEightByteInteger(buffer, offset2 + 8);
        return;
    L9:
        if ((length % 8) != 4) goto L14;
        this.diskStart = new ZipLong(buffer, (offset + length) - 4);
        return;
    }

    public void reparseCentralDirectoryData(boolean hasUncompressedSize, boolean hasCompressedSize, boolean hasRelativeHeaderOffset, boolean hasDiskStart) throws ZipException {
        if (this.rawCentralDirectoryData == null) goto L31;
        int r0 = 0;
        int r1 = 8;
        if (hasUncompressedSize == false) goto L7;
        int r2 = 8;
    L8:
        if (hasCompressedSize == false) goto L10;
        int r3 = 8;
    L11:
        int r4 = r2 + r3;
        if (hasRelativeHeaderOffset == true) goto L15;
        r1 = 0;
    L15:
        int r5 = r4 + r1;
        if (hasDiskStart == false) goto L18;
        r0 = 4;
    L18:
        int expectedLength = r5 + r0;
        if (this.rawCentralDirectoryData.length < expectedLength) goto L30;
        int offset = 0;
        if (hasUncompressedSize == false) goto L23;
        this.size = new ZipEightByteInteger(this.rawCentralDirectoryData, 0);
        offset = 0 + 8;
    L23:
        if (hasCompressedSize == false) goto L25;
        this.compressedSize = new ZipEightByteInteger(this.rawCentralDirectoryData, offset);
        offset = offset + 8;
    L25:
        if (hasRelativeHeaderOffset == false) goto L27;
        this.relativeHeaderOffset = new ZipEightByteInteger(this.rawCentralDirectoryData, offset);
        offset = offset + 8;
    L27:
        if (hasDiskStart == false) goto L32;
        this.diskStart = new ZipLong(this.rawCentralDirectoryData, offset);
        return;
    L32:
        return;
    L30:
        throw new ZipException("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length " + expectedLength + " but is " + this.rawCentralDirectoryData.length);
    L10:
        r3 = 0;
        goto L11
    L7:
        r2 = 0;
        goto L8
    }

    public ZipEightByteInteger getSize() {
        return this.size;
    }

    public void setSize(ZipEightByteInteger size) {
        this.size = size;
    }

    public ZipEightByteInteger getCompressedSize() {
        return this.compressedSize;
    }

    public void setCompressedSize(ZipEightByteInteger compressedSize) {
        this.compressedSize = compressedSize;
    }

    public ZipEightByteInteger getRelativeHeaderOffset() {
        return this.relativeHeaderOffset;
    }

    public void setRelativeHeaderOffset(ZipEightByteInteger rho) {
        this.relativeHeaderOffset = rho;
    }

    public ZipLong getDiskStartNumber() {
        return this.diskStart;
    }

    public void setDiskStartNumber(ZipLong ds) {
        this.diskStart = ds;
    }

    private int addSizes(byte[] data) {
        int off = 0;
        if (this.size == null) goto L6;
        System.arraycopy(this.size.getBytes(), 0, data, 0, 8);
        off = 0 + 8;
    L6:
        if (this.compressedSize == null) goto L9;
        System.arraycopy(this.compressedSize.getBytes(), 0, data, off, 8);
        return off + 8;
    L9:
        return off;
    }
}
