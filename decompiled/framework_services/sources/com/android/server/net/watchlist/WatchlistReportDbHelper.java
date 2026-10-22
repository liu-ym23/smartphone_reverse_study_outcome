package com.android.server.net.watchlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Slog;
import com.android.internal.util.HexDump;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class WatchlistReportDbHelper extends SQLiteOpenHelper {
    private static final String CREATE_TABLE_MODEL = "CREATE TABLE records(app_digest BLOB,cnc_domain TEXT,timestamp INTEGER DEFAULT 0 )";
    private static final String[] DIGEST_DOMAIN_PROJECTION = null;
    private static final int IDLE_CONNECTION_TIMEOUT_MS = 30000;
    private static final int INDEX_CNC_DOMAIN = 1;
    private static final int INDEX_DIGEST = 0;
    private static final int INDEX_TIMESTAMP = 2;
    private static final String NAME = "watchlist_report.db";
    private static final String TAG = "WatchlistReportDbHelper";
    private static final int VERSION = 2;
    private static WatchlistReportDbHelper sInstance;

    public static class AggregatedResult {
        final HashMap<String, String> appDigestCNCList;
        final Set<String> appDigestList;
        final String cncDomainVisited;

        public AggregatedResult(Set<String> appDigestList, String cncDomainVisited, HashMap<String, String> appDigestCNCList) {
            this.appDigestList = appDigestList;
            this.cncDomainVisited = cncDomainVisited;
            this.appDigestCNCList = appDigestCNCList;
        }
    }

    private static class WhiteListReportContract {
        private static final String APP_DIGEST = "app_digest";
        private static final String CNC_DOMAIN = "cnc_domain";
        private static final String TABLE = "records";
        private static final String TIMESTAMP = "timestamp";

        private WhiteListReportContract() {
        }
    }

    static {
        DIGEST_DOMAIN_PROJECTION = new String[]{"app_digest", "cnc_domain"};
    }

    static File getSystemWatchlistDbFile() {
        return new File(Environment.getDataSystemDirectory(), NAME);
    }

    private WatchlistReportDbHelper(Context context) {
        super(context, getSystemWatchlistDbFile().getAbsolutePath(), null, 2);
        setIdleConnectionTimeout(30000);
    }

    public static synchronized WatchlistReportDbHelper getInstance(Context context) {
        monitor-enter(WatchlistReportDbHelper.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sInstance == null) goto L11;
        WatchlistReportDbHelper r1 = sInstance;     // Catch: Throwable -> L9
        monitor-exit(WatchlistReportDbHelper.class);
        return r1;
    L11:
        sInstance = new WatchlistReportDbHelper(context);     // Catch: Throwable -> L9
        WatchlistReportDbHelper r2 = sInstance;     // Catch: Throwable -> L9
        monitor-exit(WatchlistReportDbHelper.class);
        return r2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MODEL);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS records");
        onCreate(db);
    }

    public boolean insertNewRecord(byte[] appDigest, String cncDomain, long timestamp) {
        SQLiteDatabase db = getWritableDatabase();     // Catch: SQLiteException -> L8
        ContentValues values = new ContentValues();
        values.put("app_digest", appDigest);
        values.put("cnc_domain", cncDomain);
        values.put("timestamp", Long.valueOf(timestamp));
        if (db.insert("records", null, values) == (-1)) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        Slog.e(TAG, "Error opening the database to insert a new record", e);
        return false;
    }

    public AggregatedResult getAggregatedRecords(long untilTimestamp) {
        SQLiteDatabase db = getReadableDatabase();     // Catch: SQLiteException -> L26
        Cursor c = null;
    L18:
        th = move-exception;
        if (c == null) goto L25;
        c.close();
    L25:
        throw th;
    L6:
        c = db.query(true, "records", DIGEST_DOMAIN_PROJECTION, "timestamp < ?", new String[]{Long.toString(untilTimestamp)}, null, null, null, null);     // Catch: Throwable -> L18
        if (c != null) goto L11;
        if (c == null) goto L10;
        c.close();
    L10:
        return null;
    L11:
        HashSet<String> appDigestList = new HashSet();     // Catch: Throwable -> L18
        HashMap<String, String> appDigestCNCList = new HashMap();     // Catch: Throwable -> L18
        String cncDomainVisited = null;
    L13:
        if (c.moveToNext() == false) goto L20;
        String digestHexStr = HexDump.toHexString(c.getBlob(0));     // Catch: Throwable -> L18
        String cncDomain = c.getString(1);     // Catch: Throwable -> L18
        appDigestList.add(digestHexStr);     // Catch: Throwable -> L18
        if (cncDomainVisited == null) goto L17;
        cncDomainVisited = cncDomain;
    L17:
        appDigestCNCList.put(digestHexStr, cncDomain);     // Catch: Throwable -> L18
        goto L13
    L20:
        AggregatedResult r5 = new AggregatedResult(appDigestList, cncDomainVisited, appDigestCNCList);     // Catch: Throwable -> L18
        c.close();
        return r5;
    L26:
        e = move-exception;
        Slog.e(TAG, "Error opening the database", e);
        return null;
    }

    public boolean cleanup(long untilTimestamp) {
        SQLiteDatabase db = getWritableDatabase();     // Catch: SQLiteException -> L12
        String clause = "timestamp< " + untilTimestamp;
        if (db.delete("records", clause, null) == 0) goto L19;
        return true;
    L19:
        return false;
    L9:
        e = move-exception;
        Slog.e(TAG, "Error deleting records", e);
        return false;
    L12:
        e = move-exception;
        Slog.e(TAG, "Error opening the database to cleanup", e);
        return false;
    }
}
