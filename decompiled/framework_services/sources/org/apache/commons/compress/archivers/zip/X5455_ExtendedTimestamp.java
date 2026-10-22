package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.util.Date;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class X5455_ExtendedTimestamp implements ZipExtraField, Cloneable, Serializable {
    public static final byte ACCESS_TIME_BIT = 2;
    public static final byte CREATE_TIME_BIT = 4;
    private static final ZipShort HEADER_ID = null;
    public static final byte MODIFY_TIME_BIT = 1;
    private static final long serialVersionUID = 1;
    private ZipLong accessTime;
    private boolean bit0_modifyTimePresent;
    private boolean bit1_accessTimePresent;
    private boolean bit2_createTimePresent;
    private ZipLong createTime;
    private byte flags;
    private ZipLong modifyTime;

    static {
        HEADER_ID = new ZipShort(21589);
    }

    public X5455_ExtendedTimestamp() {
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        int r2 = 0;
        if (this.bit0_modifyTimePresent == false) goto L5;
        int r1 = 4;
    L6:
        int r3 = r1 + 1;
        if (this.bit1_accessTimePresent == true) goto L9;
    L11:
        int r4 = 0;
    L12:
        int r5 = r3 + r4;
        if (this.bit2_createTimePresent == false) goto L18;
        if (this.createTime == null) goto L18;
        r2 = 4;
    L18:
        return new ZipShort(r5 + r2);
    L9:
        if (this.accessTime == null) goto L11;
        r4 = 4;
        goto L12
    L5:
        r1 = 0;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        if (this.bit0_modifyTimePresent == false) goto L5;
        int r1 = 4;
    L7:
        return new ZipShort(r1 + 1);
    L5:
        r1 = 0;
        goto L7
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] data = new byte[getLocalFileDataLength().getValue()];
        int pos = 0 + 1;
        data[0] = 0;
        if (this.bit0_modifyTimePresent == false) goto L6;
        data[0] = (byte) (data[0] | 1);
        System.arraycopy(this.modifyTime.getBytes(), 0, data, pos, 4);
        pos = pos + 4;
    L6:
        if (this.bit1_accessTimePresent == false) goto L11;
        if (this.accessTime == null) goto L11;
        data[0] = (byte) (data[0] | 2);
        System.arraycopy(this.accessTime.getBytes(), 0, data, pos, 4);
        pos = pos + 4;
    L11:
        if (this.bit2_createTimePresent == true) goto L13;
    L15:
        return data;
    L13:
        if (this.createTime == null) goto L15;
        data[0] = (byte) (data[0] | 4);
        System.arraycopy(this.createTime.getBytes(), 0, data, pos, 4);
        int r2 = pos + 4;
        goto L15
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        byte[] centralData = new byte[getCentralDirectoryLength().getValue()];
        byte[] localData = getLocalFileDataData();
        System.arraycopy(localData, 0, centralData, 0, centralData.length);
        return centralData;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) throws ZipException {
        reset();
        int len = offset + length;
        int offset2 = offset + 1;
        setFlags(data[offset]);
        if (this.bit0_modifyTimePresent == false) goto L6;
        this.modifyTime = new ZipLong(data, offset2);
        offset2 = offset2 + 4;
    L6:
        if (this.bit1_accessTimePresent == false) goto L11;
        if ((offset2 + 4) > len) goto L11;
        this.accessTime = new ZipLong(data, offset2);
        offset2 = offset2 + 4;
    L11:
        if (this.bit2_createTimePresent == true) goto L13;
        return;
    L13:
        if ((offset2 + 4) > len) goto L17;
        this.createTime = new ZipLong(data, offset2);
        int r1 = offset2 + 4;
        return;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
        reset();
        parseFromLocalFileData(buffer, offset, length);
    }

    private void reset() {
        setFlags((byte) 0);
        this.modifyTime = null;
        this.accessTime = null;
        this.createTime = null;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
        boolean r1 = false;
        if ((flags & 1) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.bit0_modifyTimePresent = r0;
        if ((flags & 2) != 2) goto L9;
        boolean r2 = true;
    L10:
        this.bit1_accessTimePresent = r2;
        if ((flags & 4) != 4) goto L13;
        r1 = true;
    L13:
        this.bit2_createTimePresent = r1;
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public byte getFlags() {
        return this.flags;
    }

    public boolean isBit0_modifyTimePresent() {
        return this.bit0_modifyTimePresent;
    }

    public boolean isBit1_accessTimePresent() {
        return this.bit1_accessTimePresent;
    }

    public boolean isBit2_createTimePresent() {
        return this.bit2_createTimePresent;
    }

    public ZipLong getModifyTime() {
        return this.modifyTime;
    }

    public ZipLong getAccessTime() {
        return this.accessTime;
    }

    public ZipLong getCreateTime() {
        return this.createTime;
    }

    public Date getModifyJavaTime() {
        return zipLongToDate(this.modifyTime);
    }

    public Date getAccessJavaTime() {
        return zipLongToDate(this.accessTime);
    }

    public Date getCreateJavaTime() {
        return zipLongToDate(this.createTime);
    }

    public void setModifyTime(ZipLong l) {
        if (l == null) goto L5;
        boolean r1 = true;
    L6:
        this.bit0_modifyTimePresent = r1;
        if (l == null) goto L9;
        int r0 = 1 | this.flags;
    L10:
        this.flags = (byte) r0;
        this.modifyTime = l;
        return;
    L9:
        r0 = this.flags & (-2);
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    public void setAccessTime(ZipLong l) {
        if (l == null) goto L4;
        boolean r0 = true;
    L5:
        this.bit1_accessTimePresent = r0;
        if (l == null) goto L8;
        int r1 = this.flags | 2;
    L9:
        this.flags = (byte) r1;
        this.accessTime = l;
        return;
    L8:
        r1 = this.flags & (-3);
        goto L9
    L4:
        r0 = false;
        goto L5
    }

    public void setCreateTime(ZipLong l) {
        if (l == null) goto L4;
        boolean r0 = true;
    L5:
        this.bit2_createTimePresent = r0;
        if (l == null) goto L8;
        int r1 = this.flags | 4;
    L9:
        this.flags = (byte) r1;
        this.createTime = l;
        return;
    L8:
        r1 = this.flags & (-5);
        goto L9
    L4:
        r0 = false;
        goto L5
    }

    public void setModifyJavaTime(Date d) {
        setModifyTime(dateToZipLong(d));
    }

    public void setAccessJavaTime(Date d) {
        setAccessTime(dateToZipLong(d));
    }

    public void setCreateJavaTime(Date d) {
        setCreateTime(dateToZipLong(d));
    }

    private static ZipLong dateToZipLong(Date d) {
        if (d != null) goto L6;
        return null;
    L6:
        return unixTimeToZipLong(d.getTime() / 1000);
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("0x5455 Zip Extra Field: Flags=");
        buf.append(Integer.toBinaryString(ZipUtil.unsignedIntToSignedByte(this.flags)));
        buf.append(" ");
        if (this.bit0_modifyTimePresent == false) goto L8;
        if (this.modifyTime == null) goto L8;
        Date m = getModifyJavaTime();
        buf.append(" Modify:[");
        buf.append(m);
        buf.append("] ");
    L8:
        if (this.bit1_accessTimePresent == false) goto L13;
        if (this.accessTime == null) goto L13;
        Date a = getAccessJavaTime();
        buf.append(" Access:[");
        buf.append(a);
        buf.append("] ");
    L13:
        if (this.bit2_createTimePresent == false) goto L18;
        if (this.createTime == null) goto L18;
        Date c = getCreateJavaTime();
        buf.append(" Create:[");
        buf.append(c);
        buf.append("] ");
    L18:
        return buf.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o) {
        if ((o instanceof X5455_ExtendedTimestamp) == false) goto L27;
        X5455_ExtendedTimestamp xf = (X5455_ExtendedTimestamp) o;
        if ((this.flags & 7) == (xf.flags & 7)) goto L7;
        return false;
    L7:
        if (this.modifyTime == xf.modifyTime) goto L13;
        if (this.modifyTime != null) goto L11;
        return false;
    L11:
        if (this.modifyTime.equals(xf.modifyTime) == true) goto L13;
        return false;
    L13:
        if (this.accessTime == xf.accessTime) goto L19;
        if (this.accessTime != null) goto L17;
        return false;
    L17:
        if (this.accessTime.equals(xf.accessTime) == true) goto L19;
        return false;
    L19:
        if (this.createTime != xf.createTime) goto L21;
    L24:
        return true;
    L21:
        if (this.createTime != null) goto L23;
        return false;
    L23:
        if (this.createTime.equals(xf.createTime) == true) goto L24;
        return false;
    L27:
        return false;
    }

    public int hashCode() {
        int hc = (this.flags & 7) * (-123);
        if (this.modifyTime == null) goto L6;
        hc = hc ^ this.modifyTime.hashCode();
    L6:
        if (this.accessTime == null) goto L9;
        hc = hc ^ Integer.rotateLeft(this.accessTime.hashCode(), 11);
    L9:
        if (this.createTime != null) goto L11;
        return hc;
    L11:
        return hc ^ Integer.rotateLeft(this.createTime.hashCode(), 22);
    }

    private static Date zipLongToDate(ZipLong unixTime) {
        if (unixTime != null) goto L6;
        return null;
    L6:
        return new Date(((long) unixTime.getIntValue()) * 1000);
    }

    private static ZipLong unixTimeToZipLong(long l) {
        if (l < (-2147483648L)) goto L9;
        if (l > 2147483647L) goto L9;
        return new ZipLong(l);
    L9:
        throw new IllegalArgumentException("X5455 timestamps must fit in a signed 32 bit integer: " + l);
    }
}
