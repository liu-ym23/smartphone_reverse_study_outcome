package com.android.server.appop;

import android.app.AppOpsManager;
import android.os.SystemClock;
import android.util.ArraySet;
import android.util.Log;
import android.util.Slog;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class DiscreteOpsTestingShim extends DiscreteOpsRegistry {
    private static final int FLAGS_MASK = -1;
    private static final String LOG_TAG = "DiscreteOpsTestingShim";
    private final DiscreteOpsRegistry mSqlRegistry;
    private final DiscreteOpsRegistry mXmlRegistry;

    DiscreteOpsTestingShim(DiscreteOpsRegistry xmlRegistry, DiscreteOpsRegistry sqlRegistry) {
        this.mXmlRegistry = xmlRegistry;
        this.mSqlRegistry = sqlRegistry;
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void recordDiscreteAccess(int uid, String packageName, String deviceId, int op, String attributionTag, int flags, int uidState, long accessTime, long accessDuration, int attributionFlags, int attributionChainId) {
        long start = SystemClock.uptimeMillis();
        this.mXmlRegistry.recordDiscreteAccess(uid, packageName, deviceId, op, attributionTag, flags, uidState, accessTime, accessDuration, attributionFlags, attributionChainId);
        long start2 = SystemClock.uptimeMillis();
        this.mSqlRegistry.recordDiscreteAccess(uid, packageName, deviceId, op, attributionTag, flags, uidState, accessTime, accessDuration, attributionFlags, attributionChainId);
        long end = SystemClock.uptimeMillis();
        long xmlTimeTaken = start2 - start;
        long sqlTimeTaken = end - start2;
        Log.i(LOG_TAG, "recordDiscreteAccess: XML time taken : " + xmlTimeTaken + ", SQL time taken : " + sqlTimeTaken + ", diff (sql - xml): " + (sqlTimeTaken - xmlTimeTaken));
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void writeAndClearOldAccessHistory() {
        this.mXmlRegistry.writeAndClearOldAccessHistory();
        this.mSqlRegistry.writeAndClearOldAccessHistory();
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void clearHistory() {
        this.mXmlRegistry.clearHistory();
        this.mSqlRegistry.clearHistory();
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void clearHistory(int uid, String packageName) {
        this.mXmlRegistry.clearHistory(uid, packageName);
        this.mSqlRegistry.clearHistory(uid, packageName);
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void offsetHistory(long offset) {
        this.mXmlRegistry.offsetHistory(offset);
        this.mSqlRegistry.offsetHistory(offset);
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void addFilteredDiscreteOpsToHistoricalOps(AppOpsManager.HistoricalOps result, long beginTimeMillis, long endTimeMillis, int filter, int uidFilter, String packageNameFilter, String[] opNamesFilter, String attributionTagFilter, int flagsFilter, Set<String> attributionExemptPkgs) {
        AppOpsManager.HistoricalOps result2 = new AppOpsManager.HistoricalOps(beginTimeMillis, endTimeMillis);
        long start = System.currentTimeMillis();
        this.mXmlRegistry.addFilteredDiscreteOpsToHistoricalOps(result2, beginTimeMillis, endTimeMillis, filter, uidFilter, packageNameFilter, opNamesFilter, attributionTagFilter, flagsFilter, attributionExemptPkgs);
        long start2 = System.currentTimeMillis();
        this.mSqlRegistry.addFilteredDiscreteOpsToHistoricalOps(result, beginTimeMillis, endTimeMillis, filter, uidFilter, packageNameFilter, opNamesFilter, attributionTagFilter, flagsFilter, attributionExemptPkgs);
        long end = System.currentTimeMillis();
        long xmlTimeTaken = start2 - start;
        long sqlTimeTaken = end - start2;
        assertHistoricalOpsAreEquals(result, result2);     // Catch: Exception -> L5
        String r11 = LOG_TAG;
    L7:
        Log.i(r11, "Read: XML time taken : " + xmlTimeTaken + ", SQL time taken : " + sqlTimeTaken + ", diff (sql - xml): " + (sqlTimeTaken - xmlTimeTaken));
        return;
    L5:
        ex = move-exception;
        r11 = LOG_TAG;
        Slog.e(r11, "different output when reading discrete ops", ex);
        goto L7
    }

    void assertHistoricalOpsAreEquals(AppOpsManager.HistoricalOps sqlResult, AppOpsManager.HistoricalOps xmlResult) {
        assertEquals(Integer.valueOf(sqlResult.getUidCount()), Integer.valueOf(xmlResult.getUidCount()));
        int uidCount = sqlResult.getUidCount();
        int i = 0;
    L3:
        if (i >= uidCount) goto L21;
        AppOpsManager.HistoricalUidOps sqlUidOps = sqlResult.getUidOpsAt(i);
        AppOpsManager.HistoricalUidOps xmlUidOps = xmlResult.getUidOpsAt(i);
        Slog.i(LOG_TAG, "sql uid: " + sqlUidOps.getUid() + ", xml uid: " + xmlUidOps.getUid());
        assertEquals(Integer.valueOf(sqlUidOps.getUid()), Integer.valueOf(xmlUidOps.getUid()));
        assertEquals(Integer.valueOf(sqlUidOps.getPackageCount()), Integer.valueOf(xmlUidOps.getPackageCount()));
        int packageCount = sqlUidOps.getPackageCount();
        int p = 0;
    L5:
        if (p >= packageCount) goto L19;
        AppOpsManager.HistoricalPackageOps sqlPackageOps = sqlUidOps.getPackageOpsAt(p);
        AppOpsManager.HistoricalPackageOps xmlPackageOps = xmlUidOps.getPackageOpsAt(p);
        Slog.i(LOG_TAG, "sql package: " + sqlPackageOps.getPackageName() + ", xml package: " + xmlPackageOps.getPackageName());
        assertEquals(sqlPackageOps.getPackageName(), xmlPackageOps.getPackageName());
        assertEquals(Integer.valueOf(sqlPackageOps.getAttributedOpsCount()), Integer.valueOf(xmlPackageOps.getAttributedOpsCount()));
        int attrCount = sqlPackageOps.getAttributedOpsCount();
        int a = 0;
    L7:
        if (a >= attrCount) goto L18;
        AppOpsManager.AttributedHistoricalOps sqlAttrOps = sqlPackageOps.getAttributedOpsAt(a);
        AppOpsManager.AttributedHistoricalOps xmlAttrOps = xmlPackageOps.getAttributedOpsAt(a);
        int uidCount2 = uidCount;
        StringBuilder r1 = new StringBuilder();
        int i2 = i;
        r1.append("sql tag: ");
        r1.append(sqlAttrOps.getTag());
        r1.append(", xml tag: ");
        r1.append(xmlAttrOps.getTag());
        Slog.i(LOG_TAG, r1.toString());
        assertEquals(sqlAttrOps.getTag(), xmlAttrOps.getTag());
        assertEquals(Integer.valueOf(sqlAttrOps.getOpCount()), Integer.valueOf(xmlAttrOps.getOpCount()));
        int opCount = sqlAttrOps.getOpCount();
        int accessCount = 0;
    L9:
        if (accessCount >= opCount) goto L17;
        int opCount2 = opCount;
        AppOpsManager.HistoricalOp sqlHistoricalOp = sqlAttrOps.getOpAt(accessCount);
        AppOpsManager.HistoricalOp xmlHistoricalOp = xmlAttrOps.getOpAt(accessCount);
        int o = accessCount;
        StringBuilder r2 = new StringBuilder();
        AppOpsManager.HistoricalUidOps sqlUidOps2 = sqlUidOps;
        r2.append("sql op: ");
        r2.append(sqlHistoricalOp.getOpName());
        r2.append(", xml op: ");
        r2.append(xmlHistoricalOp.getOpName());
        Slog.i(LOG_TAG, r2.toString());
        assertEquals(sqlHistoricalOp.getOpName(), xmlHistoricalOp.getOpName());
        assertEquals(Integer.valueOf(sqlHistoricalOp.getDiscreteAccessCount()), Integer.valueOf(xmlHistoricalOp.getDiscreteAccessCount()));
        int accessCount2 = sqlHistoricalOp.getDiscreteAccessCount();
        int keyCount = 0;
    L11:
        if (keyCount >= accessCount2) goto L16;
        int accessCount3 = accessCount2;
        AppOpsManager.AttributedOpEntry sqlOpEntry = sqlHistoricalOp.getDiscreteAccessAt(keyCount);
        AppOpsManager.HistoricalOp sqlHistoricalOp2 = sqlHistoricalOp;
        AppOpsManager.AttributedOpEntry xmlOpEntry = xmlHistoricalOp.getDiscreteAccessAt(keyCount);
        AppOpsManager.HistoricalOp xmlHistoricalOp2 = xmlHistoricalOp;
        StringBuilder r3 = new StringBuilder();
        int x = keyCount;
        r3.append("sql keys: ");
        r3.append(sqlOpEntry.collectKeys());
        r3.append(", xml keys: ");
        r3.append(xmlOpEntry.collectKeys());
        Slog.i(LOG_TAG, r3.toString());
        assertEquals(sqlOpEntry.collectKeys(), xmlOpEntry.collectKeys());
        assertEquals(Boolean.valueOf(sqlOpEntry.isRunning()), Boolean.valueOf(xmlOpEntry.isRunning()));
        ArraySet<Long> keys = sqlOpEntry.collectKeys();
        int keyCount2 = keys.size();
        int k = 0;
    L13:
        if (k >= keyCount2) goto L15;
        long key = keys.valueAt(k).longValue();
        ArraySet<Long> keys2 = keys;
        int flags = extractFlagsFromKey(key);
        assertEquals(Long.valueOf(sqlOpEntry.getLastDuration(flags)), Long.valueOf(xmlOpEntry.getLastDuration(flags)));
        assertEquals(sqlOpEntry.getLastProxyInfo(flags), xmlOpEntry.getLastProxyInfo(flags));
        assertEquals(Long.valueOf(sqlOpEntry.getLastAccessTime(flags)), Long.valueOf(xmlOpEntry.getLastAccessTime(flags)));
        k = k + 1;
        keys = keys2;
        keyCount2 = keyCount2;
        goto L13
    L15:
        keyCount = x + 1;
        accessCount2 = accessCount3;
        sqlHistoricalOp = sqlHistoricalOp2;
        xmlHistoricalOp = xmlHistoricalOp2;
        goto L11
    L16:
        accessCount = o + 1;
        opCount = opCount2;
        sqlUidOps = sqlUidOps2;
        goto L9
    L17:
        a = a + 1;
        uidCount = uidCount2;
        i = i2;
        goto L7
    L18:
        p = p + 1;
        goto L5
    L19:
        i = i + 1;
        goto L3
    }

    public static int extractFlagsFromKey(long key) {
        return (int) ((-1) & key);
    }

    private void assertEquals(Object actual, Object expected) {
        if (Objects.equals(actual, expected) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Actual (" + actual + ") is not equal to expected (" + expected + ")");
    }

    @Override // com.android.server.appop.DiscreteOpsRegistry
    void dump(PrintWriter pw, int uidFilter, String packageNameFilter, String attributionTagFilter, int filter, int dumpOp, SimpleDateFormat sdf, Date date, String prefix, int nDiscreteOps) {
        this.mXmlRegistry.dump(pw, uidFilter, packageNameFilter, attributionTagFilter, filter, dumpOp, sdf, date, prefix, nDiscreteOps);
        pw.println("--------------------------------------------------------");
        pw.println("--------------------------------------------------------");
        this.mSqlRegistry.dump(pw, uidFilter, packageNameFilter, attributionTagFilter, filter, dumpOp, sdf, date, prefix, nDiscreteOps);
    }
}
