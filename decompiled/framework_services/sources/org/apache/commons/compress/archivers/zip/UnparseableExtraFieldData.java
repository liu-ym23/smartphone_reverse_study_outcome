package org.apache.commons.compress.archivers.zip;

/* JADX INFO: loaded from: classes3.dex */
public final class UnparseableExtraFieldData implements ZipExtraField {
    private static final ZipShort HEADER_ID = null;
    private byte[] centralDirectoryData;
    private byte[] localFileData;

    public UnparseableExtraFieldData() {
    }

    static {
        HEADER_ID = new ZipShort(44225);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        if (this.localFileData != null) goto L5;
        int r1 = 0;
    L7:
        return new ZipShort(r1);
    L5:
        r1 = this.localFileData.length;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.centralDirectoryData != null) goto L6;
        return getLocalFileDataLength();
    L6:
        return new ZipShort(this.centralDirectoryData.length);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localFileData);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        if (this.centralDirectoryData != null) goto L6;
        return getLocalFileDataData();
    L6:
        return ZipUtil.copy(this.centralDirectoryData);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] buffer, int offset, int length) {
        this.localFileData = new byte[length];
        System.arraycopy(buffer, offset, this.localFileData, 0, length);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) {
        this.centralDirectoryData = new byte[length];
        System.arraycopy(buffer, offset, this.centralDirectoryData, 0, length);
        if (this.localFileData != null) goto L6;
        parseFromLocalFileData(buffer, offset, length);
        return;
    }
}
