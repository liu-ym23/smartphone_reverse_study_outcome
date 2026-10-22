package org.apache.commons.compress.archivers.zip;

import com.android.server.job.controllers.JobStatus;
import java.util.Date;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class X000A_NTFS implements ZipExtraField {
    private static final long EPOCH_OFFSET = -116444736000000000L;
    private static final ZipShort HEADER_ID = null;
    private static final ZipShort TIME_ATTR_SIZE = null;
    private static final ZipShort TIME_ATTR_TAG = null;
    private ZipEightByteInteger accessTime;
    private ZipEightByteInteger createTime;
    private ZipEightByteInteger modifyTime;

    public X000A_NTFS() {
        this.modifyTime = ZipEightByteInteger.ZERO;
        this.accessTime = ZipEightByteInteger.ZERO;
        this.createTime = ZipEightByteInteger.ZERO;
    }

    static {
        HEADER_ID = new ZipShort(10);
        TIME_ATTR_TAG = new ZipShort(1);
        TIME_ATTR_SIZE = new ZipShort(24);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        return new ZipShort(32);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] data = new byte[getLocalFileDataLength().getValue()];
        System.arraycopy(TIME_ATTR_TAG.getBytes(), 0, data, 4, 2);
        int pos = 4 + 2;
        System.arraycopy(TIME_ATTR_SIZE.getBytes(), 0, data, pos, 2);
        int pos2 = pos + 2;
        System.arraycopy(this.modifyTime.getBytes(), 0, data, pos2, 8);
        int pos3 = pos2 + 8;
        System.arraycopy(this.accessTime.getBytes(), 0, data, pos3, 8);
        byte[] r2 = this.createTime.getBytes();
        System.arraycopy(r2, 0, data, pos3 + 8, 8);
        return data;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) throws ZipException {
        int len = offset + length;
        int offset2 = offset + 4;
    L4:
        if ((offset2 + 4) > len) goto L12;
        ZipShort tag = new ZipShort(data, offset2);
        int offset3 = offset2 + 2;
        if (tag.equals(TIME_ATTR_TAG) == true) goto L7;
        ZipShort size = new ZipShort(data, offset3);
        offset2 = offset3 + (size.getValue() + 2);
        goto L4
    L7:
        readTimeAttr(data, offset3, len - offset3);
        return;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
        reset();
        parseFromLocalFileData(buffer, offset, length);
    }

    public ZipEightByteInteger getModifyTime() {
        return this.modifyTime;
    }

    public ZipEightByteInteger getAccessTime() {
        return this.accessTime;
    }

    public ZipEightByteInteger getCreateTime() {
        return this.createTime;
    }

    public Date getModifyJavaTime() {
        return zipToDate(this.modifyTime);
    }

    public Date getAccessJavaTime() {
        return zipToDate(this.accessTime);
    }

    public Date getCreateJavaTime() {
        return zipToDate(this.createTime);
    }

    public void setModifyTime(ZipEightByteInteger t) {
        if (t != null) goto L4;
        ZipEightByteInteger r0 = ZipEightByteInteger.ZERO;
    L5:
        this.modifyTime = r0;
        return;
    L4:
        r0 = t;
        goto L5
    }

    public void setAccessTime(ZipEightByteInteger t) {
        if (t != null) goto L4;
        ZipEightByteInteger r0 = ZipEightByteInteger.ZERO;
    L5:
        this.accessTime = r0;
        return;
    L4:
        r0 = t;
        goto L5
    }

    public void setCreateTime(ZipEightByteInteger t) {
        if (t != null) goto L4;
        ZipEightByteInteger r0 = ZipEightByteInteger.ZERO;
    L5:
        this.createTime = r0;
        return;
    L4:
        r0 = t;
        goto L5
    }

    public void setModifyJavaTime(Date d) {
        setModifyTime(dateToZip(d));
    }

    public void setAccessJavaTime(Date d) {
        setAccessTime(dateToZip(d));
    }

    public void setCreateJavaTime(Date d) {
        setCreateTime(dateToZip(d));
    }

    public String toString() {
        return "0x000A Zip Extra Field: Modify:[" + getModifyJavaTime() + "]  Access:[" + getAccessJavaTime() + "]  Create:[" + getCreateJavaTime() + "] ";
    }

    public boolean equals(Object o) {
        if ((o instanceof X000A_NTFS) == false) goto L26;
        X000A_NTFS xf = (X000A_NTFS) o;
        if (this.modifyTime == xf.modifyTime) goto L11;
        if (this.modifyTime != null) goto L9;
        return false;
    L9:
        if (this.modifyTime.equals(xf.modifyTime) == true) goto L11;
        return false;
    L11:
        if (this.accessTime == xf.accessTime) goto L17;
        if (this.accessTime != null) goto L15;
        return false;
    L15:
        if (this.accessTime.equals(xf.accessTime) == true) goto L17;
        return false;
    L17:
        if (this.createTime != xf.createTime) goto L19;
    L24:
        return true;
    L19:
        if (this.createTime != null) goto L21;
        return false;
    L21:
        if (this.createTime.equals(xf.createTime) == true) goto L24;
        return false;
    L26:
        return false;
    }

    public int hashCode() {
        int hc = -123;
        if (this.modifyTime == null) goto L6;
        hc = (-123) ^ this.modifyTime.hashCode();
    L6:
        if (this.accessTime == null) goto L9;
        hc = hc ^ Integer.rotateLeft(this.accessTime.hashCode(), 11);
    L9:
        if (this.createTime != null) goto L11;
        return hc;
    L11:
        return hc ^ Integer.rotateLeft(this.createTime.hashCode(), 22);
    }

    private void reset() {
        this.modifyTime = ZipEightByteInteger.ZERO;
        this.accessTime = ZipEightByteInteger.ZERO;
        this.createTime = ZipEightByteInteger.ZERO;
    }

    private void readTimeAttr(byte[] data, int offset, int length) {
        if (length < 26) goto L8;
        ZipShort tagValueLength = new ZipShort(data, offset);
        if (TIME_ATTR_SIZE.equals(tagValueLength) == false) goto L9;
        int offset2 = offset + 2;
        this.modifyTime = new ZipEightByteInteger(data, offset2);
        int offset3 = offset2 + 8;
        this.accessTime = new ZipEightByteInteger(data, offset3);
        this.createTime = new ZipEightByteInteger(data, offset3 + 8);
        return;
    L9:
        return;
    }

    private static ZipEightByteInteger dateToZip(Date d) {
        if (d != null) goto L6;
        return null;
    L6:
        return new ZipEightByteInteger((d.getTime() * JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY) - EPOCH_OFFSET);
    }

    private static Date zipToDate(ZipEightByteInteger z) {
        if (z != null) goto L4;
        return null;
    L4:
        if (ZipEightByteInteger.ZERO.equals(z) == true) goto L10;
        long l = (z.getLongValue() + EPOCH_OFFSET) / JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY;
        return new Date(l);
    L10:
        return null;
    }
}
