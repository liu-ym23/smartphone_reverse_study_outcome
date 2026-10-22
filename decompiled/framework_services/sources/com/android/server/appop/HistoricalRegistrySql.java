package com.android.server.appop;

import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.RemoteCallback;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class HistoricalRegistrySql implements HistoricalRegistryInterface {
    HistoricalRegistrySql(Context context) {
    }

    HistoricalRegistrySql(HistoricalRegistrySql other) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void systemReady(ContentResolver resolver) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void shutdown() {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void dump(String prefix, PrintWriter pw, int filterUid, String filterPackage, String filterAttributionTag, int filterOp, int filter) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void dumpDiscreteData(PrintWriter pw, int uidFilter, String packageNameFilter, String attributionTagFilter, int filter, int dumpOp, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void increaseOpAccessDuration(int op, int uid, String packageName, String deviceId, String attributionTag, int uidState, int flags, long eventStartTime, long increment, int attributionFlags, int attributionChainId) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void incrementOpAccessedCount(int op, int uid, String packageName, String deviceId, String attributionTag, int uidState, int flags, long accessTime, int attributionFlags, int attributionChainId, int accessCount) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void incrementOpRejectedCount(int op, int uid, String packageName, String attributionTag, int uidState, int flags) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void getHistoricalOps(int uid, String packageName, String attributionTag, String[] opNames, int historyFlags, int filter, long beginTimeMillis, long endTimeMillis, int flags, String[] attributionExemptPkgs, RemoteCallback callback) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void clearHistory(int uid, String packageName) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void writeAndClearDiscreteHistory() {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void persistPendingHistory() {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void setHistoryParameters(int mode, long baseSnapshotInterval, long intervalCompressionMultiplier) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void resetHistoryParameters() {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void clearAllHistory() {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void offsetHistory(long offsetMillis) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void getHistoricalOpsFromDiskRaw(int uid, String packageName, String attributionTag, String[] opNames, int historyFlags, int filter, long beginTimeMillis, long endTimeMillis, int flags, String[] attributionExemptedPackages, RemoteCallback callback) {
    }

    @Override // com.android.server.appop.HistoricalRegistryInterface
    public void addHistoricalOps(AppOpsManager.HistoricalOps ops) {
    }
}
