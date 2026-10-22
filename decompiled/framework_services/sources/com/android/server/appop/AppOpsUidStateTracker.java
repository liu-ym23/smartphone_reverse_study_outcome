package com.android.server.appop;

import android.util.SparseArray;
import java.io.PrintWriter;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
interface AppOpsUidStateTracker {

    public interface UidStateChangedCallback {
        void onUidProcessDeath(int r1);

        void onUidStateChanged(int r1, int r2, boolean r3);
    }

    void addUidStateChangedCallback(Executor r1, UidStateChangedCallback r2);

    void dumpEvents(PrintWriter r1);

    void dumpUidState(PrintWriter r1, int r2, long r3);

    int evalMode(int r1, int r2, int r3);

    int getUidState(int r1);

    boolean isUidInForeground(int r1);

    void removeUidStateChangedCallback(UidStateChangedCallback r1);

    void updateAppWidgetVisibility(SparseArray<String> r1, boolean r2);

    void updateUidProcState(int r1, int r2, int r3);

    static int processStateToUidState(int procState) {
        if (procState != (-1)) goto L6;
        return 700;
    L6:
        if (procState > 1) goto L10;
        return 100;
    L10:
        if (procState > 2) goto L14;
        return 200;
    L14:
        if (procState > 3) goto L17;
        return 500;
    L17:
        if (procState > 4) goto L21;
        return 400;
    L21:
        if (procState > 5) goto L24;
        return 500;
    L24:
        if (procState > 11) goto L28;
        return 600;
    L28:
        if (procState >= 20) goto L30;
        return 700;
    L30:
        return Integer.MAX_VALUE;
    }
}
