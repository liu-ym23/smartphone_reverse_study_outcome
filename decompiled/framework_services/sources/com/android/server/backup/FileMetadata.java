package com.android.server.backup;

import android.util.Slog;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class FileMetadata {
    public String domain;
    public boolean hasApk;
    public String installerPackageName;
    public long mode;
    public long mtime;
    public String packageName;
    public String path;
    public long size;
    public int type;
    public long version;

    public FileMetadata() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FileMetadata{");
        sb.append(this.packageName);
        sb.append(',');
        sb.append(this.type);
        sb.append(',');
        sb.append(this.domain);
        sb.append(':');
        sb.append(this.path);
        sb.append(',');
        sb.append(this.size);
        sb.append('}');
        return sb.toString();
    }

    public void dump() {
        StringBuilder b = new StringBuilder(128);
        char r3 = '-';
        if (this.type != 2) goto L5;
        char r1 = 'd';
    L6:
        b.append(r1);
        char r2 = 'r';
        if ((this.mode & 256) == 0) goto L9;
        char r4 = 'r';
    L10:
        b.append(r4);
        char r6 = 'w';
        if ((this.mode & 128) == 0) goto L13;
        char r5 = 'w';
    L14:
        b.append(r5);
        if ((this.mode & 64) == 0) goto L17;
        char r7 = 'x';
    L18:
        b.append(r7);
        if ((this.mode & 32) == 0) goto L21;
        char r8 = 'r';
    L22:
        b.append(r8);
        if ((this.mode & 16) == 0) goto L25;
        char r9 = 'w';
    L26:
        b.append(r9);
        if ((this.mode & 8) == 0) goto L29;
        char r10 = 'x';
    L30:
        b.append(r10);
        if ((this.mode & 4) != 0) goto L34;
        r2 = '-';
    L34:
        b.append(r2);
        if ((this.mode & 2) != 0) goto L38;
        r6 = '-';
    L38:
        b.append(r6);
        if ((this.mode & 1) == 0) goto L41;
        r3 = 'x';
    L41:
        b.append(r3);
        b.append(String.format(" %9d ", new Object[]{Long.valueOf(this.size)}));
        Date stamp = new Date(this.mtime);
        b.append(new SimpleDateFormat("MMM dd HH:mm:ss ").format(stamp));
        b.append(this.packageName);
        b.append(" :: ");
        b.append(this.domain);
        b.append(" :: ");
        b.append(this.path);
        Slog.i(BackupManagerService.TAG, b.toString());
        return;
    L29:
        r10 = '-';
        goto L30
    L25:
        r9 = '-';
        goto L26
    L21:
        r8 = '-';
        goto L22
    L17:
        r7 = '-';
        goto L18
    L13:
        r5 = '-';
        goto L14
    L9:
        r4 = '-';
        goto L10
    L5:
        r1 = '-';
        goto L6
    }
}
