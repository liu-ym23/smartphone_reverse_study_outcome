package com.stepos.alphame.activityclick;

import android.database.Cursor;
import android.util.Log;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import java.util.ArrayList;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class ActivityClickStorable extends Storable {
    private static final String COLUMN_ACTIVITY_NAME = "activityName";
    private static final String COLUMN_CLICK_COUNT = "clickCount";
    private static final String COLUMN_CLONE_ID = "clone_id";
    private static final String COLUMN_LAST_CLICK_TIME = "lastClickTime";
    private static final String COLUMN_MODEL = "mode";
    private static final String COLUMN_PACKAGE_NAME = "packageName";
    private static final String COLUMN_TOTAL_CLICK_COUNT = "totalClickCount";
    private static final String CREATE_TABLE_SQL = "create table if not exists activity_clickinfo (activityName text,packageName text,clickCount text,totalClickCount text,lastClickTime text,mode text,clone_id text,PRIMARY KEY(activityName,mode,clone_id))";
    public static final int PERIOD_DAYS = 7;
    private static final String QUERY_ALL_ITEMS = "select * from activity_clickinfo";
    private static final String SQL_SELECTION = "activityName = ? and mode = ? and clone_id = ?";
    private static final String TABLE_NAME = "activity_clickinfo";
    private static final String TAG = "ActivityClickStorable";

    public ActivityClickStorable() {
        Database.getInstance().addTable(TABLE_NAME, CREATE_TABLE_SQL);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0180 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void saveActivityClickInfo(java.util.ArrayList<com.stepos.alphame.data.DataItem> r28) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.activityclick.ActivityClickStorable.saveActivityClickInfo(java.util.ArrayList):void");
    }

    @Override // com.stepos.alphame.data.Storable
    public DataItem fillItem(Cursor cursor, DataItem dataItem) {
        if (cursor == null) {
            return null;
        }
        String string = cursor.getString(cursor.getColumnIndexOrThrow("activityName"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("packageName"));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLICK_COUNT));
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_TOTAL_CLICK_COUNT)));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LAST_CLICK_TIME));
        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_MODEL));
        int i5 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_CLONE_ID));
        ActivityClickDataItem activityClickDataItem = (ActivityClickDataItem) dataItem;
        if (activityClickDataItem == null) {
            activityClickDataItem = new ActivityClickDataItem();
        }
        try {
            activityClickDataItem.fill(string2, string, string3, lValueOf, Long.valueOf(Long.parseLong(string4)), i4, i5);
        } catch (Exception e4) {
            Log.d(TAG, "fill exception:" + e4.getMessage());
        }
        return activityClickDataItem;
    }

    @Override // com.stepos.alphame.data.Storable
    public Cursor getCursor() {
        Cursor cursor;
        Cursor cursorRawQuery;
        synchronized (ActivityClickStorable.class) {
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

    @Override // com.stepos.alphame.data.Storable
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override // com.stepos.alphame.data.Storable
    public void writeItem(ArrayList<DataItem> arrayList) {
        synchronized (ActivityClickStorable.class) {
            saveActivityClickInfo(arrayList);
        }
    }
}
