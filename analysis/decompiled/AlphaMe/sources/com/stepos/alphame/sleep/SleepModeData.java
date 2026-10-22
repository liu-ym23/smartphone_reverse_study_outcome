package com.stepos.alphame.sleep;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.database.Database;
import java.io.PrintWriter;
import java.util.List;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public final class SleepModeData {
    public static final String CREATE_TABLE = " create table IF NOT EXISTS sleep_mode (  week     INTEGER,  day          INTEGER,  sleep_time            INTEGER,  wakeup_time           INTEGER,  location_x            TEXT,  location_y           TEXT,  spare_int        INTEGER, spare_text       TEXT, primary key (week, day) ); ";
    public static final String DAY = "day";
    private static final boolean DEBUG = true;
    public static final String LOCATION_X = "location_x";
    public static final String LOCATION_Y = "location_y";
    public static final String PATH = "sleep_mode";
    private static final String QUERY_ALL_ITEMS = "select * from sleep_mode";
    private static final String QUERY_SLEEP_TIME_ITEMS = "select avg(sleep_time) as avg_sleep, avg(wakeup_time) as avg_wakeup from sleep_mode";
    public static final String SLEEP_TIME = "sleep_time";
    public static final String TABLE_NAME = "sleep_mode";
    private static final String TAG = "SleepModeData";
    public static final String WAKEUP_TIME = "wakeup_time";
    public static final String WEEK = "week";
    private static SleepModeData mInstance;

    private SleepModeData(Context context) {
        Database.getInstance().addTable("sleep_mode", CREATE_TABLE);
    }

    private DataItem fillItem(Cursor cursor, DataItem dataItem) {
        if (cursor == null) {
            return null;
        }
        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow(WEEK));
        int i5 = cursor.getInt(cursor.getColumnIndexOrThrow("day"));
        int i6 = cursor.getInt(cursor.getColumnIndexOrThrow(SLEEP_TIME));
        int i7 = cursor.getInt(cursor.getColumnIndexOrThrow(WAKEUP_TIME));
        String string = cursor.getString(cursor.getColumnIndexOrThrow(LOCATION_X));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(LOCATION_Y));
        SleepDataItem sleepDataItem = (SleepDataItem) dataItem;
        if (sleepDataItem == null) {
            sleepDataItem = new SleepDataItem();
        }
        sleepDataItem.fill(i4, i5, i6, i7, string, string2);
        return sleepDataItem;
    }

    private Cursor getCursor() {
        Cursor cursor;
        Cursor cursorRawQuery;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            cursorRawQuery = null;
            cursorRawQuery = null;
            sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase db = Database.getInstance().getDb();
                    if (db != null) {
                        try {
                            db.beginTransaction();
                            cursorRawQuery = db.rawQuery(QUERY_ALL_ITEMS, (String[]) null);
                            db.setTransactionSuccessful();
                        } catch (Exception e4) {
                            e = e4;
                            cursor = cursorRawQuery;
                            sQLiteDatabase = db;
                            Log.e(TAG, "Query error : " + e.getMessage());
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            cursorRawQuery = cursor;
                            return cursorRawQuery;
                        } catch (Throwable th) {
                            th = th;
                            sQLiteDatabase = db;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            throw th;
                        }
                    }
                    if (db != null) {
                        db.endTransaction();
                    }
                } catch (Exception e5) {
                    e = e5;
                    cursor = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return cursorRawQuery;
    }

    public static SleepModeData getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SleepModeData(context);
        }
        return mInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[DONT_GENERATE, PHI: r6 r7
      0x004d: PHI (r6v5 android.database.Cursor) = (r6v4 android.database.Cursor), (r6v7 android.database.Cursor) binds: [B:21:0x0069, B:16:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x004d: PHI (r7v5 java.util.ArrayList) = (r7v3 java.util.ArrayList), (r7v6 java.util.ArrayList) binds: [B:21:0x0069, B:16:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.Integer> getWeekDataList(int r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String[] r2 = new java.lang.String[]{r8}
            java.lang.String r3 = "week = ?"
            java.lang.String r6 = java.lang.String.valueOf(r7)
            java.lang.String[] r4 = new java.lang.String[]{r6}
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L51
            r7.<init>()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L51
            com.stepos.alphame.database.Database r0 = com.stepos.alphame.database.Database.getInstance()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.String r1 = "sleep_mode"
            com.stepos.alphame.database.Database$Element r0 = r0.getElement(r1)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            android.net.Uri r1 = r0.uri     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            com.stepos.alphame.database.Database r0 = com.stepos.alphame.database.Database.getInstance()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r5 = 0
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r6 == 0) goto L4b
            int r0 = r6.getCount()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 <= 0) goto L4b
        L31:
            boolean r0 = r6.moveToNext()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            if (r0 == 0) goto L4b
            int r0 = r6.getColumnIndexOrThrow(r8)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            int r0 = r6.getInt(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            r7.add(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49
            goto L31
        L47:
            r7 = move-exception
            goto L6d
        L49:
            r8 = move-exception
            goto L53
        L4b:
            if (r6 == 0) goto L6c
        L4d:
            r6.close()
            goto L6c
        L51:
            r8 = move-exception
            r7 = r6
        L53:
            java.lang.String r0 = "SleepModeData"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r1.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r2 = "getWeekDataList exception: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L47
            r1.append(r8)     // Catch: java.lang.Throwable -> L47
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L47
            android.util.Log.e(r0, r8)     // Catch: java.lang.Throwable -> L47
            if (r6 == 0) goto L6c
            goto L4d
        L6c:
            return r7
        L6d:
            if (r6 == 0) goto L72
            r6.close()
        L72:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.sleep.SleepModeData.getWeekDataList(int, java.lang.String):java.util.List");
    }

    public void dump(PrintWriter printWriter) {
        Cursor cursor = getCursor();
        if (cursor == null || cursor.getCount() == 0) {
            return;
        }
        printWriter.println("sleep_mode size = " + cursor.getCount());
        DataItem dataItemFillItem = null;
        while (cursor.moveToNext()) {
            if (dataItemFillItem == null) {
                dataItemFillItem = fillItem(cursor, null);
            } else {
                fillItem(cursor, dataItemFillItem);
            }
            printWriter.println(dataItemFillItem.toString());
        }
        cursor.close();
    }

    public List<Integer> getSleepEndList(int i4) {
        return getWeekDataList(i4, WAKEUP_TIME);
    }

    public List<Integer> getSleepStartList(int i4) {
        return getWeekDataList(i4, SLEEP_TIME);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a A[PHI: r1 r2
      0x004a: PHI (r1v5 net.zetetic.database.sqlcipher.SQLiteDatabase) = (r1v4 net.zetetic.database.sqlcipher.SQLiteDatabase), (r1v7 net.zetetic.database.sqlcipher.SQLiteDatabase) binds: [B:30:0x0071, B:19:0x0048] A[DONT_GENERATE, DONT_INLINE]
      0x004a: PHI (r2v3 int[]) = (r2v1 int[]), (r2v6 int[]) binds: [B:30:0x0071, B:19:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] getSleepTime() throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r6 = "getSleepTime error : "
            r0 = 0
            com.stepos.alphame.database.Database r1 = com.stepos.alphame.database.Database.getInstance()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            net.zetetic.database.sqlcipher.SQLiteDatabase r1 = r1.getDb()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L54
            r2 = 2
            int[] r2 = new int[r2]     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L4e
            if (r1 == 0) goto L43
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = "select avg(sleep_time) as avg_sleep, avg(wakeup_time) as avg_wakeup from sleep_mode"
            android.database.Cursor r0 = r1.rawQuery(r3, r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r0 == 0) goto L40
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r3 == 0) goto L40
            java.lang.String r3 = "avg_sleep"
            int r3 = r0.getColumnIndexOrThrow(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            int r3 = r0.getInt(r3)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r4 = "avg_wakeup"
            int r4 = r0.getColumnIndexOrThrow(r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            int r4 = r0.getInt(r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r5 = 0
            r2[r5] = r3     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3 = 1
            r2[r3] = r4     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            goto L40
        L3c:
            r6 = move-exception
            goto L75
        L3e:
            r3 = move-exception
            goto L57
        L40:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
        L43:
            if (r0 == 0) goto L48
            r0.close()
        L48:
            if (r1 == 0) goto L74
        L4a:
            r1.endTransaction()
            goto L74
        L4e:
            r3 = move-exception
            r2 = r0
            goto L57
        L51:
            r6 = move-exception
            r1 = r0
            goto L75
        L54:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L57:
            java.lang.String r4 = "SleepModeData"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r6 = r3.getMessage()     // Catch: java.lang.Throwable -> L3c
            r5.append(r6)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r6 = r5.toString()     // Catch: java.lang.Throwable -> L3c
            android.util.Log.e(r4, r6)     // Catch: java.lang.Throwable -> L3c
            if (r0 == 0) goto L71
            r0.close()
        L71:
            if (r1 == 0) goto L74
            goto L4a
        L74:
            return r2
        L75:
            if (r0 == 0) goto L7a
            r0.close()
        L7a:
            if (r1 == 0) goto L7f
            r1.endTransaction()
        L7f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.sleep.SleepModeData.getSleepTime():int[]");
    }

    public String getTableName() {
        return "sleep_mode";
    }

    public synchronized void setSleepEvent(int i4, int i5, int i6, int i7, int i8) {
        Uri uri;
        Cursor cursorQuery;
        String[] strArr = {"day"};
        String[] strArr2 = {String.valueOf(i4)};
        Cursor cursor = null;
        try {
            try {
                uri = Database.getInstance().getElement("sleep_mode").uri;
                cursorQuery = Database.getInstance().query(uri, strArr, "week = ? ", strArr2, "day DESC");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            e = e4;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(WEEK, Integer.valueOf(i4));
            contentValues.put(SLEEP_TIME, Integer.valueOf(i5));
            contentValues.put(WAKEUP_TIME, Integer.valueOf(i6));
            contentValues.put(LOCATION_X, Integer.valueOf(i7));
            contentValues.put(LOCATION_Y, Integer.valueOf(i8));
            if (cursorQuery == null || !cursorQuery.moveToNext()) {
                Log.d(TAG, "cursor is null");
                contentValues.put("day", (Integer) 0);
                Database.getInstance().insert(uri, contentValues);
            } else {
                int count = cursorQuery.getCount();
                Log.d(TAG, "setSleepEvent count = " + count);
                if (count == 0) {
                    contentValues.put("day", (Integer) 0);
                    Database.getInstance().insert(uri, contentValues);
                } else {
                    int i9 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("day"));
                    Log.d(TAG, "setSleepEvent maxDay = " + i9);
                    int i10 = i9 + (-6);
                    contentValues.put("day", Integer.valueOf(i9 + 1));
                    if (count >= 7) {
                        Database.getInstance().delete(uri, "week = '" + i4 + "' and day = '" + i10 + "'", null);
                    }
                    Database.getInstance().insert(uri, contentValues);
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e5) {
            e = e5;
            cursor = cursorQuery;
            Log.e(TAG, "setSleepEvent exception: " + e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
