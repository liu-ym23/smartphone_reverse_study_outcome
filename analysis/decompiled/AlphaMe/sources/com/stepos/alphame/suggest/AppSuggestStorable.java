package com.stepos.alphame.suggest;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class AppSuggestStorable extends Storable {
    public static final String COLUMN_APP_INSTALLED_LIST = "app_installed_list";
    public static final String COLUMN_CLS_NAME = "cls_name";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_DRIVING = "driving";
    public static final String COLUMN_EARPHONE = "earphone";
    public static final String COLUMN_ENERGY = "energy";
    public static final String COLUMN_EXTEND_1 = "extend_1";
    public static final String COLUMN_EXTEND_2 = "extend_2";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";
    public static final String COLUMN_PKG_NAME = "pkg_name";
    public static final String COLUMN_POSITION = "position";
    public static final String COLUMN_POSITION_TYPE = "position_type";
    public static final String COLUMN_REPORTED = "reported";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_WIFI = "wifi";
    public static final String CREATE_TABLE = "create table if not exists app_suggest_event (id integer primary key autoincrement,pkg_name text,cls_name text,type integer,date text,time text,timestamp long,app_installed_list text,driving integer,position_type integer,position text,latitude text,longitude text,wifi integer,energy integer,earphone integer,reported integer,extend_1 text,extend_2 text)";
    public static final String QUERY_REPORT_DATA = "select * from app_suggest_event where reported=?";
    public static final String TABLE_NAME = "app_suggest_event";
    private static final String TAG = "AlphaMe";
    private static final String UPDATE_REPORT_DATA = "update app_suggest_event set reported=1 where id=?";

    public AppSuggestStorable() {
        Database.getInstance().addTable(TABLE_NAME, CREATE_TABLE);
    }

    public void deleteInvalidData(long j4) {
        AlphaMeLogger.debugLog("AppSuggestReport deleteReportedItem " + Database.getInstance().delete(Database.getInstance().getElement(TABLE_NAME).uri, AbstractC0351g.n("timestamp <= ", j4), null));
    }

    @Override // com.stepos.alphame.data.Storable
    public DataItem fillItem(Cursor cursor, DataItem dataItem) {
        if (cursor == null) {
            return null;
        }
        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        String string = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PKG_NAME));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CLS_NAME));
        int i5 = cursor.getInt(cursor.getColumnIndexOrThrow("type"));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("date"));
        String string4 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIME));
        long j4 = cursor.getLong(cursor.getColumnIndexOrThrow("timestamp"));
        String string5 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_APP_INSTALLED_LIST));
        int i6 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_DRIVING));
        int i7 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_POSITION_TYPE));
        String string6 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POSITION));
        String string7 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LATITUDE));
        String string8 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LONGITUDE));
        int i8 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_WIFI));
        int i9 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ENERGY));
        int i10 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_EARPHONE));
        int i11 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_REPORTED));
        String string9 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EXTEND_1));
        String string10 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EXTEND_2));
        AppSuggestDataItem appSuggestDataItem = (AppSuggestDataItem) dataItem;
        if (appSuggestDataItem == null) {
            appSuggestDataItem = new AppSuggestDataItem();
        }
        appSuggestDataItem.generate(i4, string, string2, i5, string3, string4, j4, string5, i6, i7, string6, string7, string8, i8, i9, i10, i11, string9, string10);
        return appSuggestDataItem;
    }

    @Override // com.stepos.alphame.data.Storable
    public Cursor getCursor() {
        return Database.getInstance().query(Database.getInstance().getElement(TABLE_NAME).uri, null, null, null, null);
    }

    @Override // com.stepos.alphame.data.Storable
    public String getTableName() {
        return TABLE_NAME;
    }

    public ArrayList<AppSuggestDataItem> queryItem(String str) throws Throwable {
        ArrayList<AppSuggestDataItem> arrayList = new ArrayList<>();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase db = Database.getInstance().getDb();
                if (db != null) {
                    try {
                        db.beginTransaction();
                        Cursor cursorRawQuery = db.rawQuery(QUERY_REPORT_DATA, new String[]{str});
                        if (cursorRawQuery != null && cursorRawQuery.getCount() != 0) {
                            cursorRawQuery.moveToFirst();
                            do {
                                arrayList.add((AppSuggestDataItem) fillItem(cursorRawQuery, null));
                            } while (cursorRawQuery.moveToNext());
                            cursorRawQuery.close();
                            db.setTransactionSuccessful();
                        }
                        db.endTransaction();
                        return arrayList;
                    } catch (Exception e4) {
                        e = e4;
                        sQLiteDatabase = db;
                        Log.e(TAG, "Query error : " + e.getMessage());
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        AlphaMeLogger.dLog("AppSuggestReport queryItem size: " + arrayList.size());
                        return arrayList;
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
            }
            AlphaMeLogger.dLog("AppSuggestReport queryItem size: " + arrayList.size());
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean updateItem(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return false;
        }
        SQLiteDatabase db = Database.getInstance().getDb();
        if (db != null) {
            try {
                try {
                    db.beginTransaction();
                    Iterator<Integer> it = arrayList.iterator();
                    while (it.hasNext()) {
                        db.execSQL(UPDATE_REPORT_DATA, new Object[]{it.next()});
                    }
                    db.setTransactionSuccessful();
                    AlphaMeLogger.dLog("AppSuggestReport updateItem size: " + arrayList.size());
                } catch (Exception e4) {
                    Log.e(TAG, "Insert error : " + e4);
                    db.endTransaction();
                    return false;
                }
            } catch (Throwable th) {
                db.endTransaction();
                throw th;
            }
        }
        if (db != null) {
            db.endTransaction();
        }
        return true;
    }

    @Override // com.stepos.alphame.data.Storable
    public void writeItem(ArrayList<DataItem> arrayList) {
        if (arrayList == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        Uri uri = Database.getInstance().getElement(TABLE_NAME).uri;
        Iterator<DataItem> it = arrayList.iterator();
        while (it.hasNext()) {
            AppSuggestDataItem appSuggestDataItem = (AppSuggestDataItem) it.next();
            contentValues.put(COLUMN_PKG_NAME, appSuggestDataItem.getPkgName());
            contentValues.put(COLUMN_CLS_NAME, appSuggestDataItem.getClsName());
            contentValues.put("type", Integer.valueOf(appSuggestDataItem.getType()));
            contentValues.put("date", appSuggestDataItem.getDate());
            contentValues.put(COLUMN_TIME, appSuggestDataItem.getTime());
            contentValues.put("timestamp", Long.valueOf(appSuggestDataItem.getTimestamp()));
            contentValues.put(COLUMN_APP_INSTALLED_LIST, appSuggestDataItem.getAppInstalledList());
            contentValues.put(COLUMN_DRIVING, Integer.valueOf(appSuggestDataItem.getDriving()));
            contentValues.put(COLUMN_POSITION_TYPE, Integer.valueOf(appSuggestDataItem.getPositionType()));
            contentValues.put(COLUMN_POSITION, appSuggestDataItem.getPosition());
            contentValues.put(COLUMN_LATITUDE, appSuggestDataItem.getLatitude());
            contentValues.put(COLUMN_LONGITUDE, appSuggestDataItem.getLongitude());
            contentValues.put(COLUMN_WIFI, Integer.valueOf(appSuggestDataItem.getWifi()));
            contentValues.put(COLUMN_ENERGY, Integer.valueOf(appSuggestDataItem.getEnergy()));
            contentValues.put(COLUMN_EARPHONE, Integer.valueOf(appSuggestDataItem.getEarphone()));
            contentValues.put(COLUMN_REPORTED, Integer.valueOf(appSuggestDataItem.getReported()));
            contentValues.put(COLUMN_EXTEND_1, appSuggestDataItem.getExtend1());
            contentValues.put(COLUMN_EXTEND_2, appSuggestDataItem.getExtend2());
            Database.getInstance().insert(uri, contentValues);
        }
    }
}
