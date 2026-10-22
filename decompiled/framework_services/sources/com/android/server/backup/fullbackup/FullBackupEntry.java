package com.android.server.backup.fullbackup;

/* JADX INFO: loaded from: classes.dex */
public class FullBackupEntry implements Comparable<FullBackupEntry> {
    public long lastBackup;
    public String packageName;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(FullBackupEntry r1) {
        return compareTo2(r1);
    }

    public FullBackupEntry(String pkg, long when) {
        this.packageName = pkg;
        this.lastBackup = when;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(FullBackupEntry other) {
        if (this.lastBackup >= other.lastBackup) goto L7;
        return -1;
    L7:
        if (this.lastBackup <= other.lastBackup) goto L10;
        return 1;
    L10:
        return 0;
    }
}
