package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class ResourceAlignmentExtraField implements ZipExtraField {
    private static final int ALLOW_METHOD_MESSAGE_CHANGE_FLAG = 32768;
    public static final int BASE_SIZE = 2;
    public static final ZipShort ID = null;
    private short alignment;
    private boolean allowMethodChange;
    private int padding;

    static {
        ID = new ZipShort(41246);
    }

    public ResourceAlignmentExtraField() {
        this.padding = 0;
    }

    public ResourceAlignmentExtraField(int alignment) {
        this(alignment, false);
    }

    public ResourceAlignmentExtraField(int alignment, boolean allowMethodChange) {
        this(alignment, allowMethodChange, 0);
    }

    public ResourceAlignmentExtraField(int alignment, boolean allowMethodChange, int padding) {
        this.padding = 0;
        if (alignment < 0) goto L9;
        if (alignment > 32767) goto L9;
        this.alignment = (short) alignment;
        this.allowMethodChange = allowMethodChange;
        this.padding = padding;
        return;
    L9:
        throw new IllegalArgumentException("Alignment must be between 0 and 0x7fff, was: " + alignment);
    }

    public short getAlignment() {
        return this.alignment;
    }

    public boolean allowMethodChange() {
        return this.allowMethodChange;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.padding + 2);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return new ZipShort(2);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] content = new byte[this.padding + 2];
        short r1 = this.alignment;
        if (this.allowMethodChange == false) goto L5;
        short r2 = Short.MIN_VALUE;
    L6:
        ZipShort.putShort(r1 | r2, content, 0);
        return content;
    L5:
        r2 = 0;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        short r0 = this.alignment;
        if (this.allowMethodChange == false) goto L5;
        short r1 = Short.MIN_VALUE;
    L7:
        return ZipShort.getBytes(r0 | r1);
    L5:
        r1 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] buffer, int offset, int length) throws ZipException {
        parseFromCentralDirectoryData(buffer, offset, length);
        this.padding = length - 2;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
        if (length < 2) goto L11;
        int alignmentValue = ZipShort.getValue(buffer, offset);
        this.alignment = (short) (alignmentValue & 32767);
        if ((32768 & alignmentValue) == 0) goto L7;
        boolean r1 = true;
    L8:
        this.allowMethodChange = r1;
        return;
    L7:
        r1 = false;
        goto L8
    L11:
        throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + length);
    }
}
