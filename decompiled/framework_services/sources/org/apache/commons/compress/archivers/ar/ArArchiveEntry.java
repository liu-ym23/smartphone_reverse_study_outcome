package org.apache.commons.compress.archivers.ar;

import java.io.File;
import java.util.Date;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes3.dex */
public class ArArchiveEntry implements ArchiveEntry {
    private static final int DEFAULT_MODE = 33188;
    public static final String HEADER = "!<arch>\n";
    public static final String TRAILER = "`\n";
    private final int groupId;
    private final long lastModified;
    private final long length;
    private final int mode;
    private final String name;
    private final int userId;

    public ArArchiveEntry(String name, long length) {
        this(name, length, 0, 0, 33188, System.currentTimeMillis() / 1000);
    }

    public ArArchiveEntry(String name, long length, int userId, int groupId, int mode, long lastModified) {
        this.name = name;
        this.length = length;
        this.userId = userId;
        this.groupId = groupId;
        this.mode = mode;
        this.lastModified = lastModified;
    }

    public ArArchiveEntry(File inputFile, String entryName) {
        if (inputFile.isFile() == false) goto L6;
        long r0 = inputFile.length();
    L5:
        long r4 = r0;
        this(entryName, r4, 0, 0, 33188, inputFile.lastModified() / 1000);
        return;
    L6:
        r0 = 0;
        goto L5
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public long getSize() {
        return getLength();
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public String getName() {
        return this.name;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public int getMode() {
        return this.mode;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public Date getLastModifiedDate() {
        return new Date(getLastModified() * 1000);
    }

    public long getLength() {
        return this.length;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveEntry
    public boolean isDirectory() {
        return false;
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
        ArArchiveEntry other = (ArArchiveEntry) obj;
        if (this.name != null) goto L18;
        if (other.name != null) goto L16;
        return true;
    L16:
        return false;
    L18:
        return this.name.equals(other.name);
    }
}
