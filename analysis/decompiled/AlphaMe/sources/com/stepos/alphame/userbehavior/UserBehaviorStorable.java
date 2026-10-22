package com.stepos.alphame.userbehavior;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.dailyusage.DailyUsageLegacyMigrationHandlerKt;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class UserBehaviorStorable extends Storable {
    public static final String COLUMN_APP_DETAILS = "app_details";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_HOURS_DETAILS = "hour_details";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTIFICATIONS = "notifications";
    public static final String COLUMN_SCREEN_ON_TIMES = "screen_on_times";
    public static final String COLUMN_TOP_USED_TIME = "top_used_time";
    public static final String COLUMN_TOTAL_USED_TIME = "total_used_time";
    private static final String CREATE_TABLE_SQL = "create table if not exists user_behavior (id integer primary key autoincrement,date long,total_used_time long,top_used_time long,screen_on_times integer,notifications integer,app_details text,hour_details text)";
    public static final String TABLE_NAME = "user_behavior";

    public UserBehaviorStorable() {
        AlphaMeLogger.printLogStack("UserBehaviorStorable");
        Database.getInstance().addTable(TABLE_NAME, CREATE_TABLE_SQL);
    }

    @Override // com.stepos.alphame.data.Storable
    public DataItem fillItem(Cursor cursor, DataItem dataItem) {
        UserBehaviorDataItem userBehaviorDataItem = dataItem == null ? new UserBehaviorDataItem() : (UserBehaviorDataItem) dataItem;
        try {
            userBehaviorDataItem.fill(cursor.getInt(cursor.getColumnIndex("id")), cursor.getLong(cursor.getColumnIndex("date")), cursor.getLong(cursor.getColumnIndex(COLUMN_TOTAL_USED_TIME)), cursor.getLong(cursor.getColumnIndex(COLUMN_TOP_USED_TIME)), cursor.getInt(cursor.getColumnIndex(COLUMN_SCREEN_ON_TIMES)), cursor.getInt(cursor.getColumnIndex(COLUMN_NOTIFICATIONS)), cursor.getString(cursor.getColumnIndex(COLUMN_APP_DETAILS)), cursor.getString(cursor.getColumnIndex(COLUMN_HOURS_DETAILS)));
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("UserBehaviorStorable fillItem error!!", e4);
        }
        return userBehaviorDataItem;
    }

    @Override // com.stepos.alphame.data.Storable
    public Cursor getCursor() {
        return getCursor(null, null);
    }

    @Override // com.stepos.alphame.data.Storable
    public String getTableName() {
        return TABLE_NAME;
    }

    public void rebuildTable() throws SQLException {
        SQLiteDatabase db = Database.getInstance().getDb();
        if (db == null) {
            return;
        }
        db.execSQL("drop table user_behavior");
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override // com.stepos.alphame.data.Storable
    public void writeItem(ArrayList<DataItem> arrayList) {
        AlphaMeLogger.dLog("UserBehaviorStorable write item");
        synchronized (this) {
            if (arrayList != null) {
                try {
                    if (arrayList.size() != 0) {
                        try {
                            SQLiteDatabase db = Database.getInstance().getDb();
                            Iterator<DataItem> it = arrayList.iterator();
                            while (it.hasNext()) {
                                UserBehaviorDataItem userBehaviorDataItem = (UserBehaviorDataItem) it.next();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("date", Long.valueOf(userBehaviorDataItem.date));
                                contentValues.put(COLUMN_TOTAL_USED_TIME, Long.valueOf(userBehaviorDataItem.totalUsedTime));
                                contentValues.put(COLUMN_TOP_USED_TIME, Long.valueOf(userBehaviorDataItem.topUsedTime));
                                contentValues.put(COLUMN_NOTIFICATIONS, Integer.valueOf(userBehaviorDataItem.notifications));
                                contentValues.put(COLUMN_SCREEN_ON_TIMES, Integer.valueOf(userBehaviorDataItem.screenOnCount));
                                contentValues.put(COLUMN_APP_DETAILS, userBehaviorDataItem.appDetails);
                                contentValues.put(COLUMN_HOURS_DETAILS, userBehaviorDataItem.hoursDetails);
                                int iUpdate = db.update(TABLE_NAME, contentValues, DailyUsageLegacyMigrationHandlerKt.SELECTION_WHEN_UPGRADE, new String[]{String.valueOf(userBehaviorDataItem.date)});
                                AlphaMeLogger.iLog("UserBehaviorStorable.writeItem update=" + iUpdate + ", row=" + (iUpdate <= 0 ? db.insert(TABLE_NAME, (String) null, contentValues) : -1L) + ", item=" + userBehaviorDataItem);
                            }
                        } catch (Exception e4) {
                            AlphaMeLogger.exceptionLog("UserBehavior writeItem fail!", e4);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static Cursor getCursor(String str, String[] strArr) {
        String strValueOf;
        String str2 = "id desc";
        if (strArr == null || strArr.length <= 2) {
            strValueOf = null;
        } else {
            strValueOf = null;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                String str3 = strArr[i4];
                str3.getClass();
                if (str3.equals("limit")) {
                    strValueOf = String.valueOf(strArr[i4 + 1]);
                } else if (str3.equals("order")) {
                    str2 = strArr[i4 + 1];
                    if (str2.contains("-")) {
                        String[] strArrSplit = str2.split("-");
                        str2 = strArrSplit[0] + AwarenessDataItem.PERMISSION_SPLITTER + strArrSplit[1];
                    }
                }
            }
        }
        return getCursor(str, null, str2, strValueOf);
    }

    private static Cursor getCursor(String str, String[] strArr, String str2, String str3) {
        return Database.getInstance().query(Database.getInstance().getElement(TABLE_NAME).uri, null, str, strArr, str2, str3);
    }
}
