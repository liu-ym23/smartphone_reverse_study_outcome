package com.android.server.apphibernation;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
final class GlobalLevelState {
    private static final SimpleDateFormat DATE_FORMAT = null;
    public boolean hibernated;
    public long lastUnhibernatedMs;
    public String packageName;
    public long savedByte;

    GlobalLevelState() {
    }

    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    }

    public String toString() {
        return "GlobalLevelState{packageName='" + this.packageName + "', hibernated=" + this.hibernated + "', savedByte=" + this.savedByte + "', lastUnhibernated=" + DATE_FORMAT.format(Long.valueOf(this.lastUnhibernatedMs)) + '}';
    }
}
