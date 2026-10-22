package org.apache.commons.compress.archivers.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class AsiExtraField implements ZipExtraField, UnixStat, Cloneable {
    private static final ZipShort HEADER_ID = null;
    private static final int WORD = 4;
    private CRC32 crc;
    private boolean dirFlag;
    private int gid;
    private String link;
    private int mode;
    private int uid;

    static {
        HEADER_ID = new ZipShort(30062);
    }

    public AsiExtraField() {
        this.mode = 0;
        this.uid = 0;
        this.gid = 0;
        this.link = "";
        this.dirFlag = false;
        this.crc = new CRC32();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(getLinkedFile().getBytes().length + 14);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] data = new byte[getLocalFileDataLength().getValue() - 4];
        System.arraycopy(ZipShort.getBytes(getMode()), 0, data, 0, 2);
        byte[] linkArray = getLinkedFile().getBytes();
        System.arraycopy(ZipLong.getBytes(linkArray.length), 0, data, 2, 4);
        System.arraycopy(ZipShort.getBytes(getUserId()), 0, data, 6, 2);
        System.arraycopy(ZipShort.getBytes(getGroupId()), 0, data, 8, 2);
        System.arraycopy(linkArray, 0, data, 10, linkArray.length);
        this.crc.reset();
        this.crc.update(data);
        long checksum = this.crc.getValue();
        byte[] result = new byte[data.length + 4];
        System.arraycopy(ZipLong.getBytes(checksum), 0, result, 0, 4);
        System.arraycopy(data, 0, result, 4, data.length);
        return result;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    public void setUserId(int uid) {
        this.uid = uid;
    }

    public int getUserId() {
        return this.uid;
    }

    public void setGroupId(int gid) {
        this.gid = gid;
    }

    public int getGroupId() {
        return this.gid;
    }

    public void setLinkedFile(String name) {
        this.link = name;
        this.mode = getMode(this.mode);
    }

    public String getLinkedFile() {
        return this.link;
    }

    public boolean isLink() {
        if (getLinkedFile().length() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setMode(int mode) {
        this.mode = getMode(mode);
    }

    public int getMode() {
        return this.mode;
    }

    public void setDirectory(boolean dirFlag) {
        this.dirFlag = dirFlag;
        this.mode = getMode(this.mode);
    }

    public boolean isDirectory() {
        if (this.dirFlag == true) goto L5;
    L7:
        return false;
    L5:
        if (isLink() == true) goto L7;
        return true;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) throws ZipException {
        long givenChecksum = ZipLong.getValue(data, offset);
        byte[] tmp = new byte[length - 4];
        boolean r5 = false;
        System.arraycopy(data, offset + 4, tmp, 0, length - 4);
        this.crc.reset();
        this.crc.update(tmp);
        long realChecksum = this.crc.getValue();
        if (givenChecksum != realChecksum) goto L14;
        int newMode = ZipShort.getValue(tmp, 0);
        byte[] linkArray = new byte[(int) ZipLong.getValue(tmp, 2)];
        this.uid = ZipShort.getValue(tmp, 6);
        this.gid = ZipShort.getValue(tmp, 8);
        if (linkArray.length != 0) goto L7;
        this.link = "";
    L9:
        if ((newMode & 16384) == 0) goto L11;
        r5 = true;
    L11:
        setDirectory(r5);
        setMode(newMode);
        return;
    L7:
        System.arraycopy(tmp, 10, linkArray, 0, linkArray.length);
        this.link = new String(linkArray);
        goto L9
    L14:
        throw new ZipException("bad CRC checksum " + Long.toHexString(givenChecksum) + " instead of " + Long.toHexString(realChecksum));
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
        parseFromLocalFileData(buffer, offset, length);
    }

    protected int getMode(int mode) {
        int type = 32768;
        if (isLink() == false) goto L6;
        type = 40960;
    L9:
        return (mode & UnixStat.PERM_MASK) | type;
    L6:
        if (isDirectory() == false) goto L9;
        type = 16384;
        goto L9
    }

    public Object clone() {
        AsiExtraField cloned = (AsiExtraField) super.clone();     // Catch: CloneNotSupportedException -> L4
        cloned.crc = new CRC32();     // Catch: CloneNotSupportedException -> L4
        return cloned;
    L4:
        cnfe = move-exception;
        throw new RuntimeException(cnfe);
    }
}
