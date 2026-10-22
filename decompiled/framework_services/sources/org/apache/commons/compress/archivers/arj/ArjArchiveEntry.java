package org.apache.commons.compress.archivers.arj;

import com.android.server.slice.SliceClientPermissions;
import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipUtil;

/* JADX INFO: loaded from: classes3.dex */
public class ArjArchiveEntry implements ArchiveEntry {
    private final LocalFileHeader localFileHeader;

    public static class HostOs {
        public static final int AMIGA = 3;
        public static final int APPLE_GS = 6;
        public static final int ATARI_ST = 7;
        public static final int DOS = 0;
        public static final int MAC_OS = 4;
        public static final int NEXT = 8;
        public static final int OS_2 = 5;
        public static final int PRIMOS = 1;
        public static final int UNIX = 2;
        public static final int VAX_VMS = 9;
        public static final int WIN32 = 11;
        public static final int WIN95 = 10;

        public HostOs() {
        }
    }

    public ArjArchiveEntry() {
        this.localFileHeader = new LocalFileHeader();
    }

    ArjArchiveEntry(LocalFileHeader localFileHeader) {
        this.localFileHeader = localFileHeader;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        if ((this.localFileHeader.arjFlags & 16) == 0) goto L7;
        return this.localFileHeader.name.replaceAll(SliceClientPermissions.SliceAuthority.DELIMITER, Matcher.quoteReplacement(File.separator));
    L7:
        return this.localFileHeader.name;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return this.localFileHeader.originalSize;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        if (this.localFileHeader.fileType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        if (isHostOsUnix() == false) goto L5;
        long ts = ((long) this.localFileHeader.dateTimeModified) * 1000;
    L7:
        return new Date(ts);
    L5:
        ts = ZipUtil.dosToJavaTime(((long) this.localFileHeader.dateTimeModified) & 4294967295L);
        goto L7
    }

    public int getMode() {
        return this.localFileHeader.fileAccessMode;
    }

    public int getUnixMode() {
        if (isHostOsUnix() == true) goto L7;
        return 0;
    L7:
        return getMode();
    }

    public int getHostOs() {
        return this.localFileHeader.hostOS;
    }

    public boolean isHostOsUnix() {
        if (getHostOs() != 2) goto L5;
    L8:
        return true;
    L5:
        if (getHostOs() == 8) goto L8;
        return false;
    }

    int getMethod() {
        return this.localFileHeader.method;
    }
}
