package com.android.server.am;

/* JADX INFO: loaded from: classes.dex */
public interface IZswOomAdjuster {
    void defendApplyOomAdjLSP(ProcessRecord r1, ProcessStateRecord r2);

    void idleUidsLocked(UidRecord r1);

    boolean shouldSkipAmKill(ProcessRecord r1);

    void updateProcCachedTime(String r1, ProcessStateRecord r2);

    void updateUidsLSP(UidRecord r1);
}
