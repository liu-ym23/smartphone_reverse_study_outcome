package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface IZswProcessRecord {
    boolean isPreStartProc();

    void killLocked(int r1, String r2);

    void setIsPreStartProc(boolean r1);

    boolean shouldSkipKillForSpecialReason(String r1, String r2);
}
