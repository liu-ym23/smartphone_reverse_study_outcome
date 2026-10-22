package com.android.server.backup.keyvalue;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BackupRequest {
    public String packageName;

    public BackupRequest(String pkgName) {
        this.packageName = pkgName;
    }

    public String toString() {
        return "BackupRequest{pkg=" + this.packageName + "}";
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if ((o instanceof BackupRequest) == true) goto L9;
        return false;
    L9:
        BackupRequest that = (BackupRequest) o;
        return Objects.equals(this.packageName, that.packageName);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.packageName});
    }
}
