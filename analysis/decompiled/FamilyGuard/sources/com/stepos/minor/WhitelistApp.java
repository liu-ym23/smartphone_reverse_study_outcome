package com.stepos.minor;

/* loaded from: classes.dex */
public class WhitelistApp {
    public static final String COLUMN_MINOR_ID = "minor_id";
    public static final String COLUMN_PACKAGE_NAME = "package_name";
    public static final String COLUMN_REMOVABLE = "removable";
    public static final String TABLE_NAME = "whitelist_app";
    public long minorId;
    public String packageName;
    public boolean removable;

    public WhitelistApp(long j5, String str, boolean z5) {
        this.minorId = j5;
        this.packageName = str;
        this.removable = z5;
    }

    public long getMinorId() {
        return this.minorId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isRemovable() {
        return this.removable;
    }

    public void setMinorId(long j5) {
        this.minorId = j5;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setRemovable(boolean z5) {
        this.removable = z5;
    }

    public String toString() {
        return "WhitelistApp{, packageName='" + this.packageName + "', removable=" + this.removable + '}';
    }

    public WhitelistApp(long j5, String str) {
        this(j5, str, true);
    }

    public WhitelistApp() {
    }
}
