package com.stepos.pps.data.stats.helper.exceptioncode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MetricLogDbHelper extends SQLiteOpenHelper {
    private static final String COL_CREATE_TIME = "create_time";
    private static final String COL_DATA_SIZE = "data_size";
    private static final String COL_EVENT_JSON = "event_json";
    private static final String COL_EVENT_NAME = "event_name";
    private static final String COL_ID = "_id";
    private static final String DB_NAME = "Metric_log.db";
    private static final int DB_VERSION = 2;
    private static final long MAX_BYTES = 20971520;
    private static final int MAX_ROWS = 50000;
    private static final String TABLE = "metric_log";
    private static final String TAG = "MetricLogDbHelper";
    private static final int TRIM_BATCH = 200;
    private static volatile MetricLogDbHelper sInstance;

    static MetricLogDbHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (MetricLogDbHelper.class) {
                if (sInstance == null) {
                    sInstance = new MetricLogDbHelper(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private MetricLogDbHelper(Context context) {
        super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS metric_log (_id INTEGER PRIMARY KEY AUTOINCREMENT,event_name TEXT,event_json TEXT,create_time INTEGER,data_size INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS metric_log");
        onCreate(sQLiteDatabase);
    }

    synchronized void insert(String str, String str2) {
        synchronized (this) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(COL_EVENT_NAME, str);
                contentValues.put(COL_EVENT_JSON, str2);
                contentValues.put(COL_CREATE_TIME, Long.valueOf(System.currentTimeMillis()));
                contentValues.put(COL_DATA_SIZE, Integer.valueOf(byteSize(str, str2)));
                writableDatabase.insert(TABLE, null, contentValues);
                trimIfNeeded(writableDatabase);
            } finally {
            }
        }
    }

    private static int byteSize(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        sb.append(str);
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString().getBytes(StandardCharsets.UTF_8).length;
    }

    private void trimIfNeeded(SQLiteDatabase sQLiteDatabase) {
        try {
            long jQueryLong = queryLong(sQLiteDatabase, "SELECT COUNT(*) FROM metric_log");
            if (jQueryLong > 50000) {
                deleteOldest(sQLiteDatabase, (int) (jQueryLong - 50000));
            }
            int i = 0;
            while (queryLong(sQLiteDatabase, "SELECT SUM(data_size) FROM metric_log") > MAX_BYTES) {
                int i2 = i + 1;
                if (i >= 1000) {
                    return;
                }
                deleteOldest(sQLiteDatabase, TRIM_BATCH);
                i = i2;
            }
        } catch (Throwable th) {
            Log.e(TAG, "trim failed: " + th.getMessage());
        }
    }

    private void deleteOldest(SQLiteDatabase sQLiteDatabase, int i) throws SQLException {
        if (i <= 0) {
            return;
        }
        sQLiteDatabase.execSQL("DELETE FROM metric_log WHERE _id IN (SELECT _id FROM metric_log ORDER BY _id ASC LIMIT " + i + ")");
    }

    private long queryLong(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery(str, null);
            if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                return cursorRawQuery.getLong(0);
            }
            if (cursorRawQuery == null) {
                return 0L;
            }
            cursorRawQuery.close();
            return 0L;
        } finally {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        }
    }

    synchronized List<Record> queryAll() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            cursorQuery = getReadableDatabase().query(TABLE, null, null, null, null, null, "_id ASC");
            if (cursorQuery != null) {
                int columnIndex = cursorQuery.getColumnIndex(COL_ID);
                int columnIndex2 = cursorQuery.getColumnIndex(COL_EVENT_NAME);
                int columnIndex3 = cursorQuery.getColumnIndex(COL_EVENT_JSON);
                int columnIndex4 = cursorQuery.getColumnIndex(COL_DATA_SIZE);
                while (cursorQuery.moveToNext()) {
                    Record record = new Record();
                    record.id = cursorQuery.getLong(columnIndex);
                    record.eventName = cursorQuery.getString(columnIndex2);
                    record.eventJson = cursorQuery.getString(columnIndex3);
                    record.size = columnIndex4 >= 0 ? cursorQuery.getInt(columnIndex4) : 0;
                    arrayList.add(record);
                }
            }
        } catch (Throwable th) {
            try {
                Log.e(TAG, "queryAll failed: " + th.getMessage());
                if (cursorQuery != null) {
                }
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        }
        return arrayList;
    }

    synchronized List<Record> queryUpToSize(long j) {
        ArrayList arrayList = new ArrayList();
        long j2 = 0;
        if (j <= 0) {
            return arrayList;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = getReadableDatabase().query(TABLE, null, null, null, null, null, "_id ASC");
            if (cursorQuery != null) {
                int columnIndex = cursorQuery.getColumnIndex(COL_ID);
                int columnIndex2 = cursorQuery.getColumnIndex(COL_EVENT_NAME);
                int columnIndex3 = cursorQuery.getColumnIndex(COL_EVENT_JSON);
                int columnIndex4 = cursorQuery.getColumnIndex(COL_DATA_SIZE);
                while (cursorQuery.moveToNext()) {
                    int i = columnIndex4 >= 0 ? cursorQuery.getInt(columnIndex4) : 0;
                    if (!arrayList.isEmpty() && i + j2 > j) {
                        break;
                    }
                    Record record = new Record();
                    record.id = cursorQuery.getLong(columnIndex);
                    record.eventName = cursorQuery.getString(columnIndex2);
                    record.eventJson = cursorQuery.getString(columnIndex3);
                    record.size = i;
                    arrayList.add(record);
                    j2 += i;
                    if (j2 >= j) {
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                Log.e(TAG, "queryUpToSize failed: " + th.getMessage());
                if (cursorQuery != null) {
                }
            } finally {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    synchronized long count() {
        try {
        } catch (Throwable th) {
            Log.e(TAG, "count failed: " + th.getMessage());
            return 0L;
        }
        return queryLong(getReadableDatabase(), "SELECT COUNT(*) FROM metric_log");
    }

    synchronized long totalPendingSize() {
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT SUM(data_size) FROM metric_log", null);
        } catch (Throwable th) {
            try {
                Log.e(TAG, "totalPendingSize failed: " + th.getMessage());
                if (cursorRawQuery != null) {
                }
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
        if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
            return cursorRawQuery.getLong(0);
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return 0L;
    }

    synchronized void delete(long j) {
        synchronized (this) {
            try {
                getWritableDatabase().delete(TABLE, "_id=?", new String[]{String.valueOf(j)});
            } finally {
            }
        }
    }

    static class Record {
        String eventJson;
        String eventName;
        long id;
        int size;

        Record() {
        }
    }
}
