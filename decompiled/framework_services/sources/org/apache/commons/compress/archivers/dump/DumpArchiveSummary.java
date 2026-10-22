package org.apache.commons.compress.archivers.dump;

import android.hardware.audio.common.V2_0.AudioDevice;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.compress.archivers.zip.ZipEncoding;

/* JADX INFO: loaded from: classes3.dex */
public class DumpArchiveSummary {
    private String devname;
    private long dumpDate;
    private String filesys;
    private int firstrec;
    private int flags;
    private String hostname;
    private String label;
    private int level;
    private int ntrec;
    private long previousDumpDate;
    private int volume;

    DumpArchiveSummary(byte[] buffer, ZipEncoding encoding) throws IOException {
        this.dumpDate = ((long) DumpArchiveUtil.convert32(buffer, 4)) * 1000;
        this.previousDumpDate = ((long) DumpArchiveUtil.convert32(buffer, 8)) * 1000;
        this.volume = DumpArchiveUtil.convert32(buffer, 12);
        this.label = DumpArchiveUtil.decode(encoding, buffer, 676, 16).trim();
        this.level = DumpArchiveUtil.convert32(buffer, 692);
        this.filesys = DumpArchiveUtil.decode(encoding, buffer, 696, 64).trim();
        this.devname = DumpArchiveUtil.decode(encoding, buffer, 760, 64).trim();
        this.hostname = DumpArchiveUtil.decode(encoding, buffer, 824, 64).trim();
        this.flags = DumpArchiveUtil.convert32(buffer, 888);
        this.firstrec = DumpArchiveUtil.convert32(buffer, 892);
        this.ntrec = DumpArchiveUtil.convert32(buffer, AudioDevice.OUT_ALL_A2DP);
    }

    public Date getDumpDate() {
        return new Date(this.dumpDate);
    }

    public void setDumpDate(Date dumpDate) {
        this.dumpDate = dumpDate.getTime();
    }

    public Date getPreviousDumpDate() {
        return new Date(this.previousDumpDate);
    }

    public void setPreviousDumpDate(Date previousDumpDate) {
        this.previousDumpDate = previousDumpDate.getTime();
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFilesystem() {
        return this.filesys;
    }

    public void setFilesystem(String filesystem) {
        this.filesys = filesystem;
    }

    public String getDevname() {
        return this.devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getFirstRecord() {
        return this.firstrec;
    }

    public void setFirstRecord(int firstrec) {
        this.firstrec = firstrec;
    }

    public int getNTRec() {
        return this.ntrec;
    }

    public void setNTRec(int ntrec) {
        this.ntrec = ntrec;
    }

    public boolean isNewHeader() {
        if ((this.flags & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isNewInode() {
        if ((this.flags & 2) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isCompressed() {
        if ((this.flags & 128) != 128) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isMetaDataOnly() {
        if ((this.flags & 256) != 256) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isExtendedAttributes() {
        if ((this.flags & 32768) != 32768) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        int hash = 17;
        if (this.label == null) goto L5;
        hash = this.label.hashCode();
    L5:
        int hash2 = (int) (((long) hash) + (this.dumpDate * 31));
        if (this.hostname == null) goto L9;
        hash2 = (this.hostname.hashCode() * 31) + 17;
    L9:
        if (this.devname == null) goto L12;
        int hash3 = (this.devname.hashCode() * 31) + 17;
        return hash3;
    L12:
        return hash2;
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L26:
        return false;
    L8:
        if (o.getClass().equals(getClass()) == false) goto L26;
        DumpArchiveSummary rhs = (DumpArchiveSummary) o;
        if (this.dumpDate == rhs.dumpDate) goto L14;
        return false;
    L14:
        if (getHostname() != null) goto L16;
    L25:
        return false;
    L16:
        if (getHostname().equals(rhs.getHostname()) == false) goto L25;
        if (getDevname() != null) goto L21;
    L24:
        return false;
    L21:
        if (getDevname().equals(rhs.getDevname()) == false) goto L24;
        return true;
    }
}
