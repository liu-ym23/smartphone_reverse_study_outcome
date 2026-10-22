package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes3.dex */
public class X7875_NewUnix implements ZipExtraField, Cloneable, Serializable {
    private static final ZipShort HEADER_ID = null;
    private static final BigInteger ONE_THOUSAND = null;
    private static final ZipShort ZERO = null;
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version;

    static {
        HEADER_ID = new ZipShort(30837);
        ZERO = new ZipShort(0);
        ONE_THOUSAND = BigInteger.valueOf(1000);
    }

    public X7875_NewUnix() {
        this.version = 1;
        reset();
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    public void setUID(long l) {
        this.uid = ZipUtil.longToBig(l);
    }

    public void setGID(long l) {
        this.gid = ZipUtil.longToBig(l);
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getLocalFileDataLength() {
        byte[] b = trimLeadingZeroesForceMinLength(this.uid.toByteArray());
        int gidSize = 0;
        if (b != null) goto L5;
        int uidSize = 0;
    L6:
        byte[] b2 = trimLeadingZeroesForceMinLength(this.gid.toByteArray());
        if (b2 == null) goto L11;
        gidSize = b2.length;
    L11:
        return new ZipShort((uidSize + 3) + gidSize);
    L5:
        uidSize = b.length;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getLocalFileDataData() {
        byte[] uidBytes = this.uid.toByteArray();
        byte[] gidBytes = this.gid.toByteArray();
        byte[] uidBytes2 = trimLeadingZeroesForceMinLength(uidBytes);
        if (uidBytes2 == null) goto L5;
        int uidBytesLen = uidBytes2.length;
    L6:
        byte[] gidBytes2 = trimLeadingZeroesForceMinLength(gidBytes);
        if (gidBytes2 == null) goto L9;
        int gidBytesLen = gidBytes2.length;
    L10:
        byte[] data = new byte[(uidBytesLen + 3) + gidBytesLen];
        if (uidBytes2 == null) goto L13;
        ZipUtil.reverse(uidBytes2);
    L13:
        if (gidBytes2 == null) goto L15;
        ZipUtil.reverse(gidBytes2);
    L15:
        int pos = 0 + 1;
        data[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        int pos2 = pos + 1;
        data[pos] = ZipUtil.unsignedIntToSignedByte(uidBytesLen);
        if (uidBytes2 == null) goto L18;
        System.arraycopy(uidBytes2, 0, data, pos2, uidBytesLen);
    L18:
        int pos3 = pos2 + uidBytesLen;
        int pos4 = pos3 + 1;
        data[pos3] = ZipUtil.unsignedIntToSignedByte(gidBytesLen);
        if (gidBytes2 == null) goto L21;
        System.arraycopy(gidBytes2, 0, data, pos4, gidBytesLen);
    L21:
        return data;
    L9:
        gidBytesLen = 0;
        goto L10
    L5:
        uidBytesLen = 0;
        goto L6
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public byte[] getCentralDirectoryData() {
        return new byte[0];
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromLocalFileData(byte[] data, int offset, int length) throws ZipException {
        reset();
        int offset2 = offset + 1;
        this.version = ZipUtil.signedByteToUnsignedInt(data[offset]);
        int offset3 = offset2 + 1;
        int uidSize = ZipUtil.signedByteToUnsignedInt(data[offset2]);
        byte[] uidBytes = new byte[uidSize];
        System.arraycopy(data, offset3, uidBytes, 0, uidSize);
        int offset4 = offset3 + uidSize;
        this.uid = new BigInteger(1, ZipUtil.reverse(uidBytes));
        int offset5 = offset4 + 1;
        int gidSize = ZipUtil.signedByteToUnsignedInt(data[offset4]);
        byte[] gidBytes = new byte[gidSize];
        System.arraycopy(data, offset5, gidBytes, 0, gidSize);
        this.gid = new BigInteger(1, ZipUtil.reverse(gidBytes));
    }

    @Override // org.apache.commons.compress.archivers.zip.ZipExtraField
    public void parseFromCentralDirectoryData(byte[] buffer, int offset, int length) throws ZipException {
    }

    private void reset() {
        this.uid = ONE_THOUSAND;
        this.gid = ONE_THOUSAND;
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object o) {
        if ((o instanceof X7875_NewUnix) == false) goto L12;
        X7875_NewUnix xf = (X7875_NewUnix) o;
        if (this.version == xf.version) goto L7;
        return false;
    L7:
        if (this.uid.equals(xf.uid) == true) goto L9;
        return false;
    L9:
        if (this.gid.equals(xf.gid) == false) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    public int hashCode() {
        int hc = this.version * (-1234567);
        return (Integer.rotateLeft(this.uid.hashCode(), 16) ^ hc) ^ this.gid.hashCode();
    }

    static byte[] trimLeadingZeroesForceMinLength(byte[] array) {
        if (array != null) goto L4;
        return array;
    L4:
        int pos = 0;
        int r1 = array.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L10;
        byte b = array[r2];
        if (b != 0) goto L10;
        pos = pos + 1;
        r2 = r2 + 1;
    L10:
        byte[] trimmedArray = new byte[Math.max(1, array.length - pos)];
        int startPos = trimmedArray.length - (array.length - pos);
        System.arraycopy(array, pos, trimmedArray, startPos, trimmedArray.length - startPos);
        return trimmedArray;
    }
}
