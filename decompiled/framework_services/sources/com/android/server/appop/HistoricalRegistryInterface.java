package com.android.server.appop;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.os.RemoteCallback;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public interface HistoricalRegistryInterface {
    void addHistoricalOps(AppOpsManager.HistoricalOps r1);

    void clearAllHistory();

    void clearHistory(int r1, String r2);

    void dump(String r1, PrintWriter r2, int r3, String r4, String r5, int r6, int r7);

    void dumpDiscreteData(PrintWriter r1, int r2, String r3, String r4, int r5, int r6, SimpleDateFormat r7, Date r8, String r9, int r10);

    void getHistoricalOps(int r1, String r2, String r3, String[] r4, int r5, int r6, long r7, long r9, int r11, String[] r12, RemoteCallback r13);

    void getHistoricalOpsFromDiskRaw(int r1, String r2, String r3, String[] r4, int r5, int r6, long r7, long r9, int r11, String[] r12, RemoteCallback r13);

    void increaseOpAccessDuration(int r1, int r2, String r3, String r4, String r5, int r6, int r7, long r8, long r10, int r12, int r13);

    void incrementOpAccessedCount(int r1, int r2, String r3, String r4, String r5, int r6, int r7, long r8, int r10, int r11, int r12);

    void incrementOpRejectedCount(int r1, int r2, String r3, String r4, int r5, int r6);

    void offsetHistory(long r1);

    void persistPendingHistory();

    void resetHistoryParameters();

    void setHistoryParameters(int r1, long r2, long r4);

    void shutdown();

    void systemReady(ContentResolver r1);

    void writeAndClearDiscreteHistory();
}
