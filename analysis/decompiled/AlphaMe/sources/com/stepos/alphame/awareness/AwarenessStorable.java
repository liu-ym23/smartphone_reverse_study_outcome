package com.stepos.alphame.awareness;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.stepos.alphame.Tags;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import java.util.ArrayList;
import java.util.Iterator;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class AwarenessStorable extends Storable {
    private static final String COLUMN_DATA1 = "data1";
    private static final String COLUMN_DATA2 = "data2";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_ID = "id";
    public static final String COLUMN_SCENE = "scene";
    public static final String COLUMN_STATE = "state";
    private static final String CREATE_TABLE_SQL = "create table if not exists awareness (id integer primary key autoincrement,scene integer,state integer,data1 text,data2 text,date long)";
    private static final String TABLE_NAME = "awareness";

    public AwarenessStorable() {
        Database.getInstance().addTable(TABLE_NAME, CREATE_TABLE_SQL);
    }

    public static void deleteAfter(long j4) {
        Database.getInstance().delete(Database.getInstance().getElement(TABLE_NAME).uri, "date > ?", new String[]{String.valueOf(j4)});
    }

    public static void deleteBefore(long j4) {
        Database.getInstance().delete(Database.getInstance().getElement(TABLE_NAME).uri, "date < ?", new String[]{String.valueOf(j4)});
    }

    public static AwarenessDataItem fillItemByCursor(Cursor cursor, DataItem dataItem) {
        AwarenessDataItem awarenessDataItem = (AwarenessDataItem) dataItem;
        if (awarenessDataItem == null) {
            awarenessDataItem = new AwarenessDataItem();
        }
        if (cursor != null && cursor.getCount() > 0) {
            awarenessDataItem.fill(cursor.getInt(cursor.getColumnIndex("id")), cursor.getInt(cursor.getColumnIndex(COLUMN_SCENE)), cursor.getInt(cursor.getColumnIndex("state")), cursor.getString(cursor.getColumnIndex(COLUMN_DATA1)), cursor.getString(cursor.getColumnIndex(COLUMN_DATA2)), cursor.getLong(cursor.getColumnIndex("date")));
        }
        return awarenessDataItem;
    }

    public static int setEmpty(long j4) {
        Uri uri = Database.getInstance().getElement(TABLE_NAME).uri;
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DATA1, "");
        contentValues.put(COLUMN_DATA2, "");
        return Database.getInstance().update(uri, contentValues, "id = ?", new String[]{String.valueOf(j4)});
    }

    @Override // com.stepos.alphame.data.Storable
    public Cursor getCursor() {
        return getCursor(null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Pair<java.lang.Integer, java.lang.String> getLastWifi() throws java.lang.Throwable {
        /*
            r10 = this;
            com.stepos.alphame.database.Database r10 = com.stepos.alphame.database.Database.getInstance()
            java.lang.String r0 = "awareness"
            com.stepos.alphame.database.Database$Element r10 = r10.getElement(r0)
            android.net.Uri r1 = r10.uri
            r10 = 0
            com.stepos.alphame.database.Database r0 = com.stepos.alphame.database.Database.getInstance()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L57
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L57
            java.lang.String r3 = "state"
            r7 = 0
            r2[r7] = r3     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L57
            java.lang.String r3 = "data1"
            r8 = 1
            r2[r8] = r3     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L57
            java.lang.String r3 = "scene = 1"
            java.lang.String r5 = "id desc"
            java.lang.String r6 = "1"
            r4 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L57
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r1 <= 0) goto L4e
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r1 == 0) goto L4e
            android.util.Pair r1 = new android.util.Pair     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            int r2 = r0.getInt(r7)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r3 = r0.getString(r8)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r0.close()
            return r1
        L4a:
            r10 = move-exception
            goto L64
        L4c:
            r1 = move-exception
            goto L59
        L4e:
            r0.close()
            goto L63
        L52:
            r0 = move-exception
            r9 = r0
            r0 = r10
            r10 = r9
            goto L64
        L57:
            r1 = move-exception
            r0 = r10
        L59:
            java.lang.String r2 = "Awareness"
            java.lang.String r3 = "getLastWifi err"
            android.util.Log.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L4a
            if (r0 == 0) goto L63
            goto L4e
        L63:
            return r10
        L64:
            if (r0 == 0) goto L69
            r0.close()
        L69:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.awareness.AwarenessStorable.getLastWifi():android.util.Pair");
    }

    @Override // com.stepos.alphame.data.Storable
    public String getTableName() {
        return TABLE_NAME;
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
                                AwarenessDataItem awarenessDataItem = (AwarenessDataItem) it.next();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(COLUMN_SCENE, Integer.valueOf(awarenessDataItem.getScene()));
                                contentValues.put("state", Integer.valueOf(awarenessDataItem.getState()));
                                contentValues.put(COLUMN_DATA1, awarenessDataItem.getData1());
                                contentValues.put(COLUMN_DATA2, awarenessDataItem.getData2());
                                contentValues.put("date", Long.valueOf(awarenessDataItem.getDate()));
                                db.insert(TABLE_NAME, (String) null, contentValues);
                            }
                        } catch (Exception e4) {
                            Log.e(Tags.AWARENESS, "writeItem fail!", e4);
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
        boolean z4;
        String str2 = "id desc";
        if (strArr == null || strArr.length <= 2) {
            strValueOf = null;
        } else {
            strValueOf = null;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                String str3 = strArr[i4];
                str3.getClass();
                z4 = true;
                switch (str3) {
                    case "limit":
                        strValueOf = String.valueOf(strArr[i4 + 1]);
                        break;
                    case "order":
                        str2 = strArr[i4 + 1];
                        if (str2.contains("-")) {
                            String[] strArrSplit = str2.split("-");
                            str2 = strArrSplit[0] + AwarenessDataItem.PERMISSION_SPLITTER + strArrSplit[1];
                            break;
                        } else {
                            break;
                        }
                    case "scene":
                        String str4 = strArr[i4 + 1];
                        int length = str4.length();
                        StringBuilder sb = new StringBuilder("scene in (");
                        for (int i5 = 0; i5 < length; i5++) {
                            if (z4) {
                                z4 = false;
                            } else {
                                sb.append(", ");
                            }
                            sb.append(str4.charAt(i5));
                        }
                        sb.append(")");
                        str = sb.toString();
                        break;
                }
            }
        }
        return getCursor(str, null, str2, strValueOf);
    }

    @Override // com.stepos.alphame.data.Storable
    public AwarenessDataItem fillItem(Cursor cursor, DataItem dataItem) {
        return fillItemByCursor(cursor, dataItem);
    }

    public static Cursor getCursor(String str, String[] strArr, String str2, String str3) {
        AwarenessDataSource.getInstance().store(true);
        return Database.getInstance().query(Database.getInstance().getElement(TABLE_NAME).uri, null, str, strArr, str2, str3);
    }
}
