package com.android.server.om;

/* JADX INFO: loaded from: classes2.dex */
final class PackageAndUser {
    public final String packageName;
    public final int userId;

    PackageAndUser(String packageName, int userId) {
        this.packageName = packageName;
        this.userId = userId;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof PackageAndUser) == true) goto L8;
        return false;
    L8:
        PackageAndUser other = (PackageAndUser) obj;
        if (this.packageName.equals(other.packageName) == false) goto L14;
        if (this.userId != other.userId) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int result = (1 * 31) + this.packageName.hashCode();
        return (result * 31) + this.userId;
    }

    public String toString() {
        return String.format("PackageAndUser{packageName=%s, userId=%d}", new Object[]{this.packageName, Integer.valueOf(this.userId)});
    }
}
