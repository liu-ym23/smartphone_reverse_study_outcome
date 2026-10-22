package com.stepos.alphame.app;

import android.database.Cursor;
import android.util.Log;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.data.Storable;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.utils.Utils;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class AppClickStorable extends Storable {
    public static final String COLUMN_CLICK = "click";
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PACKAGE = "package";
    public static final String CREATE_TABLE = "create table if not exists app_click (id integer primary key autoincrement,package text,day integer,click integer)";
    private static final String DELETE_OLDER_ITEMS = "delete from app_click where day <= ?";
    private static final String INSERT_ITEM = "insert into app_click values (null, ?, ?, ?)";
    public static final int MAX_RESERVE_DAY = 15;
    private static final String QUERY_ALL_ITEMS = "select * from app_click";
    public static final String QUERY_ITEM_0 = "select * from app_click where package=? and day=?";
    public static final String QUERY_ITEM_1 = "select * from app_click where day > ? and day <= ?";
    public static final String QUERY_ITEM_2 = "select * from app_click where package=? and day > ? and day <= ?";
    public static final String TABLE_NAME = "app_click";
    private static final String TAG = "AlphaMe";
    private static final String UPDATE_ITEM = "update app_click set click=click+? where package=? and day=?";

    public AppClickStorable() {
        Database.getInstance().addTable(TABLE_NAME, CREATE_TABLE);
    }

    @Override // com.stepos.alphame.data.Storable
    public DataItem fillItem(Cursor cursor, DataItem dataItem) {
        if (cursor == null) {
            return null;
        }
        String string = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PACKAGE));
        int i4 = cursor.getInt(cursor.getColumnIndexOrThrow("day"));
        int i5 = cursor.getInt(cursor.getColumnIndexOrThrow("click"));
        AppClickDataItem appClickDataItem = (AppClickDataItem) dataItem;
        if (appClickDataItem == null) {
            appClickDataItem = new AppClickDataItem();
        }
        appClickDataItem.fill(string, i4, i5);
        return appClickDataItem;
    }

    @Override // com.stepos.alphame.data.Storable
    public Cursor getCursor() {
        return getCursor(null, null);
    }

    @Override // com.stepos.alphame.data.Storable
    public String getTableName() {
        return TABLE_NAME;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
    @Override // com.stepos.alphame.data.Storable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writeItem(java.util.ArrayList<com.stepos.alphame.data.DataItem> r9) {
        /*
            r8 = this;
            java.lang.Class<com.stepos.alphame.app.AppClickStorable> r8 = com.stepos.alphame.app.AppClickStorable.class
            monitor-enter(r8)
            com.stepos.alphame.database.Database r0 = com.stepos.alphame.database.Database.getInstance()     // Catch: java.lang.Throwable -> Lb5
            net.zetetic.database.sqlcipher.SQLiteDatabase r0 = r0.getDb()     // Catch: java.lang.Throwable -> Lb5
            if (r0 == 0) goto Lbb
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
        L14:
            boolean r1 = r9.hasNext()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            if (r1 == 0) goto L97
            java.lang.Object r1 = r9.next()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            com.stepos.alphame.data.DataItem r1 = (com.stepos.alphame.data.DataItem) r1     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            com.stepos.alphame.app.AppClickDataItem r1 = (com.stepos.alphame.app.AppClickDataItem) r1     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r2 = "select * from app_click where package=? and day=?"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r5 = r1.getPackageName()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r5 = r1.getDay()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r5 = java.lang.Integer.toString(r5)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r7 = 1
            r4[r7] = r5     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            android.database.Cursor r2 = r0.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4 = 3
            if (r2 == 0) goto L74
            int r5 = r2.getCount()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            if (r5 <= 0) goto L48
            r5 = r7
            goto L49
        L48:
            r5 = r6
        L49:
            r2.close()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            if (r5 == 0) goto L74
            java.lang.String r2 = "update app_click set click=click+? where package=? and day=?"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r5 = r1.getClick()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4[r6] = r5     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r5 = r1.getPackageName()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4[r7] = r5     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r1 = r1.getDay()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4[r3] = r1     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r0.execSQL(r2, r4)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            goto L14
        L70:
            r9 = move-exception
            goto Lb7
        L72:
            r9 = move-exception
            goto L9b
        L74:
            java.lang.String r2 = "insert into app_click values (null, ?, ?, ?)"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.String r5 = r1.getPackageName()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4[r6] = r5     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r5 = r1.getDay()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4[r7] = r5     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            int r1 = r1.getClick()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r4[r3] = r1     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            r0.execSQL(r2, r4)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            goto L14
        L97:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L72
            goto Lbb
        L9b:
            java.lang.String r1 = "AlphaMe"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r2.<init>()     // Catch: java.lang.Throwable -> L70
            java.lang.String r3 = "Insert error : "
            r2.append(r3)     // Catch: java.lang.Throwable -> L70
            r2.append(r9)     // Catch: java.lang.Throwable -> L70
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Throwable -> L70
            android.util.Log.e(r1, r9)     // Catch: java.lang.Throwable -> L70
        Lb1:
            r0.endTransaction()     // Catch: java.lang.Throwable -> Lb5
            goto Lbe
        Lb5:
            r9 = move-exception
            goto Lc0
        Lb7:
            r0.endTransaction()     // Catch: java.lang.Throwable -> Lb5
            throw r9     // Catch: java.lang.Throwable -> Lb5
        Lbb:
            if (r0 == 0) goto Lbe
            goto Lb1
        Lbe:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lb5
            return
        Lc0:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Lb5
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.app.AppClickStorable.writeItem(java.util.ArrayList):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [net.zetetic.database.sqlcipher.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public static Cursor getCursor(String str, String[] strArr) {
        ?? r22;
        Cursor cursor;
        synchronized (AppClickStorable.class) {
            r22 = 0;
            Cursor cursorRawQuery = null;
            r22 = 0;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase db = Database.getInstance().getDb();
                    if (db != null) {
                        try {
                            db.beginTransaction();
                            db.execSQL(DELETE_OLDER_ITEMS, new Object[]{Integer.valueOf(Utils.currentDay() - 15)});
                            if (str == null) {
                                str = QUERY_ALL_ITEMS;
                            }
                            cursorRawQuery = db.rawQuery(str, strArr);
                            db.setTransactionSuccessful();
                            r22 = cursorRawQuery;
                        } catch (Exception e4) {
                            e = e4;
                            cursor = cursorRawQuery;
                            sQLiteDatabase = db;
                            Log.e(TAG, "Query error : " + e.getMessage());
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            r22 = cursor;
                            return r22;
                        } catch (Throwable th) {
                            th = th;
                            r22 = db;
                            if (r22 != 0) {
                                r22.endTransaction();
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
        return r22;
    }
}
