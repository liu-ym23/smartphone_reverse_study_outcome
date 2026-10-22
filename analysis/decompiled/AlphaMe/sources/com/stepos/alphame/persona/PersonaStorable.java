package com.stepos.alphame.persona;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.stepos.alphame.Tags;
import com.stepos.alphame.dailyusage.DailyUsageLegacyMigrationHandlerKt;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class PersonaStorable extends Storable {
    static final String COLUMN_COMPANY = "company";
    static final String COLUMN_DATE = "date";
    static final String COLUMN_DAY_OFF = "day_off";
    static final String COLUMN_HOLIDAY = "holiday";
    static final String COLUMN_HOME = "home";
    static final String COLUMN_ID = "id";
    static final String COLUMN_OFF_DUTY_COST = "off_duty_cost";
    static final String COLUMN_OFF_DUTY_TIME = "off_duty_time";
    static final String COLUMN_ON_DUTY_COST = "on_duty_cost";
    static final String COLUMN_ON_DUTY_TIME = "on_duty_time";
    static final String COLUMN_PUBLIC_SPACE = "public_space";
    static final String COLUMN_RISE_TIME = "rise_time";
    static final String COLUMN_SLEEP_COST = "sleep_cost";
    static final String COLUMN_SLEEP_TIME = "sleep_time";
    static final String COLUMN_WEATHER = "weather";
    static final String COLUMN_WEEKDAY = "weekday";
    static final String COLUMN_YMD = "ymd";
    static final String CREATE_TABLE_SQL = "create table if not exists persona (id integer primary key autoincrement,ymd text,weekday text,holiday text,day_off integer,weather text,home text,company text,public_space text,on_duty_time long,on_duty_cost long,off_duty_time long,off_duty_cost long,sleep_time long,rise_time long,sleep_cost long,date long)";
    static final String TABLE_NAME = "persona";
    private static final String TAG = "PersonaStorable";

    public PersonaStorable() {
        Database.getInstance().addTable(TABLE_NAME, CREATE_TABLE_SQL);
    }

    private ContentValues itemToValues(PersonaDataItem personaDataItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WEATHER, personaDataItem.weather);
        contentValues.put("home", personaDataItem.home);
        contentValues.put(COLUMN_COMPANY, personaDataItem.company);
        contentValues.put(COLUMN_PUBLIC_SPACE, personaDataItem.public_space);
        contentValues.put(COLUMN_ON_DUTY_TIME, Long.valueOf(personaDataItem.on_duty_time));
        contentValues.put(COLUMN_ON_DUTY_COST, Long.valueOf(personaDataItem.on_duty_cost));
        contentValues.put(COLUMN_OFF_DUTY_TIME, Long.valueOf(personaDataItem.off_duty_time));
        contentValues.put(COLUMN_OFF_DUTY_COST, Long.valueOf(personaDataItem.off_duty_cost));
        contentValues.put("sleep_time", Long.valueOf(personaDataItem.sleep_time));
        contentValues.put(COLUMN_RISE_TIME, Long.valueOf(personaDataItem.rise_time));
        contentValues.put(COLUMN_SLEEP_COST, Long.valueOf(personaDataItem.sleep_cost));
        contentValues.put(COLUMN_YMD, personaDataItem.ymd);
        contentValues.put(COLUMN_WEEKDAY, personaDataItem.weekday);
        contentValues.put(COLUMN_DAY_OFF, Integer.valueOf(personaDataItem.day_off));
        contentValues.put(COLUMN_HOLIDAY, personaDataItem.holiday);
        contentValues.put("date", Long.valueOf(personaDataItem.date));
        return contentValues;
    }

    public void deleteAll() {
        Database.getInstance().delete(Database.getInstance().getElement(TABLE_NAME).uri, null, null);
    }

    public void deleteLast() {
        AlphaMeLogger.iLog("xxx deleteLast");
        Uri uri = Database.getInstance().getElement(TABLE_NAME).uri;
        Cursor cursor = getCursor(null, null, "id desc", "1");
        try {
            if (cursor.moveToFirst()) {
                Database.getInstance().delete(uri, "id = ?", new String[]{String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("id")))});
                AlphaMeLogger.iLog("xxx deleteLast success");
            }
            cursor.close();
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.stepos.alphame.data.Storable
    public DataItem fillItem(Cursor cursor, DataItem dataItem) {
        PersonaDataItem personaDataItem = dataItem == null ? new PersonaDataItem() : (PersonaDataItem) dataItem;
        personaDataItem.fill(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex(COLUMN_YMD)), cursor.getString(cursor.getColumnIndex(COLUMN_WEEKDAY)), cursor.getString(cursor.getColumnIndex(COLUMN_HOLIDAY)), cursor.getInt(cursor.getColumnIndex(COLUMN_DAY_OFF)), cursor.getString(cursor.getColumnIndex(COLUMN_WEATHER)), cursor.getString(cursor.getColumnIndex("home")), cursor.getString(cursor.getColumnIndex(COLUMN_COMPANY)), cursor.getString(cursor.getColumnIndex(COLUMN_PUBLIC_SPACE)), cursor.getLong(cursor.getColumnIndex(COLUMN_ON_DUTY_TIME)), cursor.getLong(cursor.getColumnIndex(COLUMN_ON_DUTY_COST)), cursor.getLong(cursor.getColumnIndex(COLUMN_OFF_DUTY_TIME)), cursor.getLong(cursor.getColumnIndex(COLUMN_OFF_DUTY_COST)), cursor.getLong(cursor.getColumnIndex("sleep_time")), cursor.getLong(cursor.getColumnIndex(COLUMN_RISE_TIME)), cursor.getLong(cursor.getColumnIndex(COLUMN_SLEEP_COST)), cursor.getLong(cursor.getColumnIndex("date")));
        return personaDataItem;
    }

    @Override // com.stepos.alphame.data.Storable
    public Cursor getCursor() {
        return Database.getInstance().query(Database.getInstance().getElement(TABLE_NAME).uri, null, null, null, null);
    }

    public PersonaDataItem getLastPersona() throws Throwable {
        PersonaDataItem personaDataItem;
        Cursor cursor = null;
        personaDataItem = null;
        PersonaDataItem personaDataItem2 = null;
        cursor = null;
        try {
            try {
                Cursor cursorQuery = Database.getInstance().query(Database.getInstance().getElement(TABLE_NAME).uri, null, null, null, "id desc", "1");
                try {
                    try {
                        if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                            personaDataItem = new PersonaDataItem();
                            try {
                                fillItem(cursorQuery, personaDataItem);
                                personaDataItem2 = personaDataItem;
                            } catch (Exception e4) {
                                e = e4;
                                cursor = cursorQuery;
                                Log.e(Tags.AWARENESS, "getLastPersona err", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return personaDataItem;
                            }
                        }
                        cursorQuery.close();
                        return personaDataItem2;
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    personaDataItem = null;
                }
            } catch (Exception e6) {
                e = e6;
                personaDataItem = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public List<PersonaDataItem> getPersonaList(long j4, long j5) {
        Uri uri = Database.getInstance().getElement(TABLE_NAME).uri;
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = Database.getInstance().query(uri, null, "date >= ? AND date <= ?", new String[]{j4 + "", j5 + ""}, "id desc", "7");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        if (cursorQuery.getCount() > 0) {
                            PersonaDataItem personaDataItem = new PersonaDataItem();
                            fillItem(cursorQuery, personaDataItem);
                            AlphaMeLogger.debugLog("Personal", "getPersonaList personaDataItem " + personaDataItem);
                            arrayList.add(personaDataItem);
                        }
                    }
                }
            } catch (Exception e4) {
                Log.e(Tags.AWARENESS, "getPersonaList err", e4);
                if (cursorQuery != null) {
                }
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    @Override // com.stepos.alphame.data.Storable
    public String getTableName() {
        return TABLE_NAME;
    }

    public void updateItem(PersonaDataItem personaDataItem) {
        try {
            Database.getInstance().getDb().update(TABLE_NAME, itemToValues(personaDataItem), DailyUsageLegacyMigrationHandlerKt.SELECTION_WHEN_UPGRADE, new String[]{String.valueOf(personaDataItem.date)});
        } catch (Exception e4) {
            Log.e(Tags.AWARENESS, "updateItem fail!", e4);
        }
    }

    @Override // com.stepos.alphame.data.Storable
    public void writeItem(ArrayList<DataItem> arrayList) {
        synchronized (this) {
            if (arrayList != null) {
                try {
                    if (arrayList.size() != 0) {
                        try {
                            SQLiteDatabase db = Database.getInstance().getDb();
                            Iterator<DataItem> it = arrayList.iterator();
                            while (it.hasNext()) {
                                db.insert(TABLE_NAME, (String) null, itemToValues((PersonaDataItem) it.next()));
                            }
                        } catch (Exception e4) {
                            AlphaMeLogger.exceptionLog("writeItem fail!", e4);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static Cursor getCursor(String str, String[] strArr, String str2, String str3) {
        return Database.getInstance().query(Database.getInstance().getElement(TABLE_NAME).uri, null, str, strArr, str2, str3);
    }
}
