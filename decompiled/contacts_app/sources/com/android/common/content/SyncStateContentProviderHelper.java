package com.android.common.content;

import android.accounts.Account;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class SyncStateContentProviderHelper {
    private static final String[] ACCOUNT_PROJECTION = null;
    private static long DB_VERSION = 1;
    public static final String PATH = "syncstate";
    private static final String QUERY_COUNT_SYNC_STATE_ROWS = "SELECT count(*) FROM _sync_state WHERE _id=?";
    private static final String SELECT_BY_ACCOUNT = "account_name=? AND account_type=?";
    private static final String SYNC_STATE_META_TABLE = "_sync_state_metadata";
    private static final String SYNC_STATE_META_VERSION_COLUMN = "version";
    private static final String SYNC_STATE_TABLE = "_sync_state";

    public SyncStateContentProviderHelper() {
    }

    static {
        ACCOUNT_PROJECTION = new String[]{"account_name", "account_type"};
    }

    public void createDatabase(SQLiteDatabase r3) {
        r3.execSQL("DROP TABLE IF EXISTS _sync_state");
        r3.execSQL("CREATE TABLE _sync_state (_id INTEGER PRIMARY KEY,account_name TEXT NOT NULL,account_type TEXT NOT NULL,data TEXT,UNIQUE(account_name, account_type));");
        r3.execSQL("DROP TABLE IF EXISTS _sync_state_metadata");
        r3.execSQL("CREATE TABLE _sync_state_metadata (version INTEGER);");
        ContentValues r2 = new ContentValues();
        r2.put("version", Long.valueOf(DB_VERSION));
        r3.insert(SYNC_STATE_META_TABLE, "version", r2);
    }

    public void onDatabaseOpened(SQLiteDatabase r5) {
        if (DatabaseUtils.longForQuery(r5, "SELECT version FROM _sync_state_metadata", null) == DB_VERSION) goto L6;
        createDatabase(r5);
        return;
    }

    public Cursor query(SQLiteDatabase r9, String[] r10, String r11, String[] r12, String r13) {
        return r9.query(SYNC_STATE_TABLE, r10, r11, r12, null, null, r13);
    }

    public long insert(SQLiteDatabase r2, ContentValues r3) {
        return r2.replace(SYNC_STATE_TABLE, "account_name", r3);
    }

    public int delete(SQLiteDatabase r1, String r2, String[] r3) {
        return r1.delete(SYNC_STATE_TABLE, r2, r3);
    }

    public int update(SQLiteDatabase r1, ContentValues r2, String r3, String[] r4) {
        return r1.update(SYNC_STATE_TABLE, r2, r3, r4);
    }

    public int update(SQLiteDatabase r6, long r7, Object r9) {
        if (DatabaseUtils.longForQuery(r6, QUERY_COUNT_SYNC_STATE_ROWS, new String[]{Long.toString(r7)}) >= 1) goto L5;
        return 0;
    L5:
        r6.execSQL("UPDATE _sync_state SET data=? WHERE _id=" + r7, new Object[]{r9});
        return 1;
    }

    public void onAccountsChanged(SQLiteDatabase r9, Account[] r10) {
        Cursor r8 = r9.query(SYNC_STATE_TABLE, ACCOUNT_PROJECTION, null, null, null, null, null);
    L14:
    L11:
        th = move-exception;
        r8.close();
        throw th;
    L4:
        if (r8.moveToNext() == false) goto L9;
        String r1 = r8.getString(0);     // Catch: Throwable -> L11
        String r3 = r8.getString(1);     // Catch: Throwable -> L11
        if (contains(r10, new Account(r1, r3)) == true) goto L14;
        r9.delete(SYNC_STATE_TABLE, SELECT_BY_ACCOUNT, new String[]{r1, r3});     // Catch: Throwable -> L11
        goto L14
    L9:
        r8.close();
    }

    private static <T> boolean contains(T[] r5, T r6) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        T r3 = r5[r2];
        if (r3 != null) goto L8;
        if (r6 != null) goto L12;
        return true;
    L12:
        r2 = r2 + 1;
        goto L3
    L8:
        if (r6 == null) goto L12;
        if (r3.equals(r6) == false) goto L12;
        return true;
    L13:
        return false;
    }
}
