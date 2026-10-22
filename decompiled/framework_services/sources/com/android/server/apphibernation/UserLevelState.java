package com.android.server.apphibernation;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes.dex */
final class UserLevelState {
    private static final SimpleDateFormat DATE_FORMAT = null;
    public boolean hibernated;
    public long lastUnhibernatedMs;
    public String packageName;
    public long savedByte;

    static {
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    UserLevelState() {
    }

    UserLevelState(UserLevelState state) {
        this.packageName = state.packageName;
        this.hibernated = state.hibernated;
        this.savedByte = state.savedByte;
        this.lastUnhibernatedMs = state.lastUnhibernatedMs;
    }

    public String toString() {
        return "UserLevelState{packageName='" + this.packageName + "', hibernated=" + this.hibernated + "', savedByte=" + this.savedByte + "', lastUnhibernated=" + DATE_FORMAT.format(Long.valueOf(this.lastUnhibernatedMs)) + '}';
    }
}
