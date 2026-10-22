package net.zetetic.database.sqlcipher;

import android.util.Printer;
import java.util.ArrayList;
import net.zetetic.database.Logger;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes2.dex */
public final class SQLiteDebug {
    public static final boolean DEBUG_LOG_SLOW_QUERIES = false;
    public static final boolean DEBUG_SQL_LOG = Logger.isLoggable("SQLiteLog", 2);
    public static final boolean DEBUG_SQL_STATEMENTS = Logger.isLoggable("SQLiteStatements", 2);
    public static final boolean DEBUG_SQL_TIME = Logger.isLoggable("SQLiteTime", 2);

    public static class DbStats {
        public String cache;
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String str, long j4, long j5, int i4, int i5, int i6, int i7) {
            this.dbName = str;
            this.pageSize = j5 / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
            this.dbSize = (j4 * j5) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
            this.lookaside = i4;
            this.cache = i5 + "/" + i6 + "/" + i7;
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
        boolean z4 = false;
        for (String str : strArr) {
            if (str.equals("-v")) {
                z4 = true;
            }
        }
        SQLiteDatabase.dumpAll(printer, z4);
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats pagerStats = new PagerStats();
        nativeGetPagerStats(pagerStats);
        pagerStats.dbStats = SQLiteDatabase.getDbStats();
        return pagerStats;
    }

    private static native void nativeGetPagerStats(PagerStats pagerStats);

    public static final boolean shouldLogSlowQuery(long j4) throws NumberFormatException {
        int i4 = Integer.parseInt(System.getProperty("db.log.slow_query_threshold", "10000"));
        return i4 >= 0 && j4 >= ((long) i4);
    }
}
