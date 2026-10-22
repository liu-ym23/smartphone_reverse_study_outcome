package com.stepos.alphame.screen;

import B0.g;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ScreenEventStorable extends Storable {
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_ELAPSED = "elapsed";
    public static final String COLUMN_EVENT = "event";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_RTC = "rtc";
    public static final String COLUMN_YEAR = "year";
    public static final String CREATE_TABLE = "create table if not exists screen_event (id integer primary key autoincrement,rtc long,elapsed long,year integer,day integer,event integer)";
    public static final String TABLE_NAME = "screen_event";
    private static final String TAG = "AlphaMe";
    private int mDeleteCount = 0;

    public ScreenEventStorable() {
        Database.getInstance().addTable(TABLE_NAME, CREATE_TABLE);
    }

    private void deleteOldData() {
        int i4 = this.mDeleteCount;
        if (i4 < 10) {
            this.mDeleteCount = i4 + 1;
            return;
        }
        this.mDeleteCount = 0;
        int i5 = Calendar.getInstance().get(6);
        StringBuilder sbT = g.t("day != ", i5, " and day != ");
        sbT.append(i5 - 1);
        String string = sbT.toString();
        if (i5 > 3) {
            Database.getInstance().delete(Database.getInstance().getElement(TABLE_NAME).uri, string, null);
        }
    }

    @Override // com.stepos.alphame.data.Storable
    public DataItem fillItem(Cursor cursor, DataItem dataItem) {
        if (cursor == null) {
            return null;
        }
        long j4 = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_RTC));
        long j5 = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ELAPSED));
        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_EVENT));
        ScreenEventDataItem screenEventDataItem = (ScreenEventDataItem) dataItem;
        if (screenEventDataItem == null) {
            screenEventDataItem = new ScreenEventDataItem();
        }
        screenEventDataItem.fill(i4, j4, j5);
        return screenEventDataItem;
    }

    @Override // com.stepos.alphame.data.Storable
    public Cursor getCursor() {
        return Database.getInstance().query(Database.getInstance().getElement(TABLE_NAME).uri, null, null, null, null);
    }

    @Override // com.stepos.alphame.data.Storable
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override // com.stepos.alphame.data.Storable
    public void writeItem(ArrayList<DataItem> arrayList) {
        deleteOldData();
        ContentValues contentValues = new ContentValues();
        Calendar calendar = Calendar.getInstance();
        Uri uri = Database.getInstance().getElement(TABLE_NAME).uri;
        Iterator<DataItem> it = arrayList.iterator();
        while (it.hasNext()) {
            ScreenEventDataItem screenEventDataItem = (ScreenEventDataItem) it.next();
            calendar.setTimeInMillis(screenEventDataItem.getRtcTime());
            contentValues.put(COLUMN_RTC, Long.valueOf(screenEventDataItem.getRtcTime()));
            contentValues.put(COLUMN_ELAPSED, Long.valueOf(screenEventDataItem.getElapsedTime()));
            contentValues.put(COLUMN_EVENT, Integer.valueOf(screenEventDataItem.getEvent()));
            contentValues.put("year", Integer.valueOf(calendar.get(1)));
            contentValues.put("day", Integer.valueOf(calendar.get(6)));
            Database.getInstance().insert(uri, contentValues);
        }
    }
}
