package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes3.dex */
public class CpioArchiveEntry implements CpioConstants, ArchiveEntry {
    private final int alignmentBoundary;
    private long chksum;
    private final short fileFormat;
    private long filesize;
    private long gid;
    private final int headerSize;
    private long inode;
    private long maj;
    private long min;
    private long mode;
    private long mtime;
    private String name;
    private long nlink;
    private long rmaj;
    private long rmin;
    private long uid;

    public CpioArchiveEntry(short format) {
        this.chksum = 0;
        this.filesize = 0;
        this.gid = 0;
        this.inode = 0;
        this.maj = 0;
        this.min = 0;
        this.mode = 0;
        this.mtime = 0;
        this.nlink = 0;
        this.rmaj = 0;
        this.rmin = 0;
        this.uid = 0;
        switch(format) {
            case 1: goto L9;
            case 2: goto L8;
            case 4: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        this.headerSize = 26;
        this.alignmentBoundary = 2;
    L10:
        this.fileFormat = format;
        return;
    L7:
        this.headerSize = 76;
        this.alignmentBoundary = 0;
        goto L10
    L8:
        this.headerSize = 110;
        this.alignmentBoundary = 4;
        goto L10
    L9:
        this.headerSize = 110;
        this.alignmentBoundary = 4;
        goto L10
    L5:
        throw new IllegalArgumentException("Unknown header type");
    }

    public CpioArchiveEntry(String name) {
        this(1, name);
    }

    public CpioArchiveEntry(short format, String name) {
        this(format);
        this.name = name;
    }

    public CpioArchiveEntry(String name, long size) {
        this(name);
        setSize(size);
    }

    public CpioArchiveEntry(short format, String name, long size) {
        this(format, name);
        setSize(size);
    }

    public CpioArchiveEntry(File inputFile, String entryName) {
        this(1, inputFile, entryName);
    }

    public CpioArchiveEntry(short format, File inputFile, String entryName) {
        if (inputFile.isFile() == false) goto L5;
        long r0 = inputFile.length();
    L6:
        this(format, entryName, r0);
        if (inputFile.isDirectory() == false) goto L10;
        setMode(16384);
    L12:
        setTime(inputFile.lastModified() / 1000);
        return;
    L10:
        if (inputFile.isFile() == false) goto L15;
        setMode(32768);
        goto L12
    L15:
        throw new IllegalArgumentException("Cannot determine type of file " + inputFile.getName());
    L5:
        r0 = 0;
        goto L6
    }

    private void checkNewFormat() {
        if ((this.fileFormat & 3) == 0) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    private void checkOldFormat() {
        if ((this.fileFormat & 12) == 0) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    public long getChksum() {
        checkNewFormat();
        return this.chksum & 4294967295L;
    }

    public long getDevice() {
        checkOldFormat();
        return this.min;
    }

    public long getDeviceMaj() {
        checkNewFormat();
        return this.maj;
    }

    public long getDeviceMin() {
        checkNewFormat();
        return this.min;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.filesize;
    }

    public short getFormat() {
        return this.fileFormat;
    }

    public long getGID() {
        return this.gid;
    }

    public int getHeaderSize() {
        return this.headerSize;
    }

    public int getAlignmentBoundary() {
        return this.alignmentBoundary;
    }

    @Deprecated
    public int getHeaderPadCount() {
        return getHeaderPadCount(null);
    }

    public int getHeaderPadCount(Charset charset) {
        if (this.name != null) goto L6;
        return 0;
    L6:
        if (charset != null) goto L10;
        return getHeaderPadCount(this.name.length());
    L10:
        return getHeaderPadCount(this.name.getBytes(charset).length);
    }

    public int getHeaderPadCount(long namesize) {
        if (this.alignmentBoundary != 0) goto L5;
        return 0;
    L5:
        int size = this.headerSize + 1;
        if (this.name == null) goto L8;
        size = (int) (((long) size) + namesize);
    L8:
        int remain = size % this.alignmentBoundary;
        if (remain > 0) goto L11;
        return 0;
    L11:
        return this.alignmentBoundary - remain;
    }

    public int getDataPadCount() {
        if (this.alignmentBoundary != 0) goto L5;
        return 0;
    L5:
        long size = this.filesize;
        int remain = (int) (size % ((long) this.alignmentBoundary));
        if (remain > 0) goto L8;
        return 0;
    L8:
        return this.alignmentBoundary - remain;
    }

    public long getInode() {
        return this.inode;
    }

    public long getMode() {
        if (this.mode != 0) goto L8;
        if (CpioConstants.CPIO_TRAILER.equals(this.name) == true) goto L8;
        return 32768;
    L8:
        return this.mode;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public long getNumberOfLinks() {
        if (this.nlink != 0) goto L9;
        if (isDirectory() == false) goto L7;
        return 2;
    L7:
        return 1;
    L9:
        return this.nlink;
    }

    public long getRemoteDevice() {
        checkOldFormat();
        return this.rmin;
    }

    public long getRemoteDeviceMaj() {
        checkNewFormat();
        return this.rmaj;
    }

    public long getRemoteDeviceMin() {
        checkNewFormat();
        return this.rmin;
    }

    public long getTime() {
        return this.mtime;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return new Date(getTime() * 1000);
    }

    public long getUID() {
        return this.uid;
    }

    public boolean isBlockDevice() {
        if (CpioUtil.fileType(this.mode) != 24576) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCharacterDevice() {
        if (CpioUtil.fileType(this.mode) != 8192) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        if (CpioUtil.fileType(this.mode) != 16384) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNetwork() {
        if (CpioUtil.fileType(this.mode) != 36864) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPipe() {
        if (CpioUtil.fileType(this.mode) != 4096) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRegularFile() {
        if (CpioUtil.fileType(this.mode) != 32768) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSocket() {
        if (CpioUtil.fileType(this.mode) != 49152) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSymbolicLink() {
        if (CpioUtil.fileType(this.mode) != 40960) goto L5;
        return true;
    L5:
        return false;
    }

    public void setChksum(long chksum) {
        checkNewFormat();
        this.chksum = 4294967295L & chksum;
    }

    public void setDevice(long device) {
        checkOldFormat();
        this.min = device;
    }

    public void setDeviceMaj(long maj) {
        checkNewFormat();
        this.maj = maj;
    }

    public void setDeviceMin(long min) {
        checkNewFormat();
        this.min = min;
    }

    public void setSize(long size) {
        if (size < 0) goto L9;
        if (size > 4294967295L) goto L9;
        this.filesize = size;
        return;
    L9:
        throw new IllegalArgumentException("invalid entry size <" + size + ">");
    }

    public void setGID(long gid) {
        this.gid = gid;
    }

    public void setInode(long inode) {
        this.inode = inode;
    }

    public void setMode(long mode) {
        long maskedMode = 61440 & mode;
        switch(((int) maskedMode)) {
            case 4096: goto L6;
            case 8192: goto L6;
            case 16384: goto L6;
            case 24576: goto L6;
            case 32768: goto L6;
            case 36864: goto L6;
            case 40960: goto L6;
            case 49152: goto L6;
            default: goto L5;
        };
    L6:
        this.mode = mode;
        return;
    L5:
        throw new IllegalArgumentException("Unknown mode. Full: " + Long.toHexString(mode) + " Masked: " + Long.toHexString(maskedMode));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfLinks(long nlink) {
        this.nlink = nlink;
    }

    public void setRemoteDevice(long device) {
        checkOldFormat();
        this.rmin = device;
    }

    public void setRemoteDeviceMaj(long rmaj) {
        checkNewFormat();
        this.rmaj = rmaj;
    }

    public void setRemoteDeviceMin(long rmin) {
        checkNewFormat();
        this.rmin = rmin;
    }

    public void setTime(long time) {
        this.mtime = time;
    }

    public void setUID(long uid) {
        this.uid = uid;
    }

    public int hashCode() {
        int r2 = 1 * 31;
        if (this.name != null) goto L5;
        int r3 = 0;
    L6:
        int result = r2 + r3;
        return result;
    L5:
        r3 = this.name.hashCode();
        goto L6
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if (obj != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != obj.getClass()) goto L19;
        CpioArchiveEntry other = (CpioArchiveEntry) obj;
        if (this.name != null) goto L18;
        if (other.name != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        return this.name.equals(other.name);
    }
}
