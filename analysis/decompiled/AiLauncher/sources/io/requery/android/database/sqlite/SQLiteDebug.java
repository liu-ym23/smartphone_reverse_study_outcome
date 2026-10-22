package io.requery.android.database.sqlite;

import android.util.Log;
import android.util.Printer;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class SQLiteDebug {
    public static final boolean DEBUG_LOG_SLOW_QUERIES = false;
    public static final boolean DEBUG_SQL_LOG = Log.isLoggable("SQLiteLog", 2);
    public static final boolean DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
    public static final boolean DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);

    public static class DbStats {
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j10, long j11, int i10, int i11, int i12, int i13) {
            this.dbName = str;
            this.pageSize = j11 / 1024;
            this.dbSize = (j10 * j11) / 1024;
            this.lookaside = i10;
            this.cache = i11 + "/" + i12 + "/" + i13;
        }
    }

    public static class PagerStats {
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int pageCacheOverflow;
    }

    private SQLiteDebug() {
    }

    public static void dump(Printer printer, String[] strArr) {
        boolean z10 = false;
        for (String str : strArr) {
            if (str.equals("-v")) {
                z10 = true;
            }
        }
        SQLiteDatabase.dumpAll(printer, z10);
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerStats = new PagerStats();
        nativeGetPagerStats(pagerStats);
        pagerStats.dbStats = SQLiteDatabase.getDbStats();
        return pagerStats;
    }

    private static native void nativeGetPagerStats(PagerStats pagerStats);

    public static boolean shouldLogSlowQuery(long j10) throws NumberFormatException {
        int i10 = Integer.parseInt(System.getProperty("db.log.slow_query_threshold", Const.INDOOR_LOCATION_TYPE));
        return i10 >= 0 && j10 >= ((long) i10);
    }
}
