package com.stepos.pps.data.util;

/* loaded from: classes.dex */
public abstract class FileListContent implements Comparable<FileListContent> {
    public long size;
    public long time;
    public String uuid;

    public abstract boolean deleteFile();

    @Override // java.lang.Comparable
    public int compareTo(FileListContent fileListContent) {
        if (this == fileListContent) {
            return 0;
        }
        if (fileListContent == null) {
            return 1;
        }
        long j = this.time;
        long j2 = fileListContent.time;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }
}
