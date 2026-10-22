package com.android.server.locksettings.recoverablekeystore.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
class RecoverableKeyStoreDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "recoverablekeystore.db";
    static final int DATABASE_VERSION_7 = 7;
    private static final String SQL_CREATE_KEYS_ENTRY = "CREATE TABLE keys( _id INTEGER PRIMARY KEY,user_id INTEGER,uid INTEGER,alias TEXT,nonce BLOB,wrapped_key BLOB,platform_key_generation_id INTEGER,last_synced_at INTEGER,recovery_status INTEGER,key_metadata BLOB,UNIQUE(uid,alias))";
    private static final String SQL_CREATE_RECOVERY_SERVICE_METADATA_ENTRY = "CREATE TABLE recovery_service_metadata (_id INTEGER PRIMARY KEY,user_id INTEGER,uid INTEGER,snapshot_version INTEGER,should_create_snapshot INTEGER,active_root_of_trust TEXT,public_key BLOB,cert_path BLOB,cert_serial INTEGER,secret_types TEXT,counter_id INTEGER,server_params BLOB,UNIQUE(user_id,uid))";
    private static final String SQL_CREATE_ROOT_OF_TRUST_ENTRY = "CREATE TABLE root_of_trust (_id INTEGER PRIMARY KEY,user_id INTEGER,uid INTEGER,root_alias TEXT,cert_path BLOB,cert_serial INTEGER,UNIQUE(user_id,uid,root_alias))";
    private static final String SQL_CREATE_USER_METADATA_ENTRY = "CREATE TABLE user_metadata( _id INTEGER PRIMARY KEY,user_id INTEGER UNIQUE,platform_key_generation_id INTEGER,user_serial_number INTEGER DEFAULT -1)";
    private static final String SQL_CREATE_USER_METADATA_ENTRY_FOR_V7 = "CREATE TABLE user_metadata( _id INTEGER PRIMARY KEY,user_id INTEGER UNIQUE,platform_key_generation_id INTEGER,user_serial_number INTEGER DEFAULT -1,bad_remote_guess_counter INTEGER DEFAULT 0)";
    private static final String SQL_DELETE_KEYS_ENTRY = "DROP TABLE IF EXISTS keys";
    private static final String SQL_DELETE_RECOVERY_SERVICE_METADATA_ENTRY = "DROP TABLE IF EXISTS recovery_service_metadata";
    private static final String SQL_DELETE_ROOT_OF_TRUST_ENTRY = "DROP TABLE IF EXISTS root_of_trust";
    private static final String SQL_DELETE_USER_METADATA_ENTRY = "DROP TABLE IF EXISTS user_metadata";
    private static final String TAG = "RecoverableKeyStoreDbHp";

    RecoverableKeyStoreDbHelper(Context context) {
        super(context, DATABASE_NAME, null, getDbVersion(context));
    }

    private static int getDbVersion(Context context) {
        return 7;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_KEYS_ENTRY);
        db.execSQL(SQL_CREATE_USER_METADATA_ENTRY_FOR_V7);
        db.execSQL(SQL_CREATE_RECOVERY_SERVICE_METADATA_ENTRY);
        db.execSQL(SQL_CREATE_ROOT_OF_TRUST_ENTRY);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "Recreating recoverablekeystore after unexpected version downgrade.");
        dropAllKnownTables(db);
        onCreate(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= 2) goto L9;
        dropAllKnownTables(db);     // Catch: SQLiteException -> L6
        onCreate(db);     // Catch: SQLiteException -> L6
        return;
    L9:
        if (oldVersion >= 3) goto L13;
        if (newVersion < 3) goto L13;
        upgradeDbForVersion3(db);     // Catch: SQLiteException -> L6
        oldVersion = 3;
    L13:
        if (oldVersion >= 4) goto L17;
        if (newVersion < 4) goto L17;
        upgradeDbForVersion4(db);     // Catch: SQLiteException -> L6
        oldVersion = 4;
    L17:
        if (oldVersion >= 5) goto L21;
        if (newVersion < 5) goto L21;
        upgradeDbForVersion5(db);     // Catch: SQLiteException -> L6
        oldVersion = 5;
    L21:
        if (oldVersion >= 6) goto L26;
        if (newVersion < 6) goto L26;
        upgradeDbForVersion6(db);     // Catch: SQLiteException -> L6
        oldVersion = 6;
    L26:
        if (oldVersion >= 7) goto L36;
        if (newVersion < 7) goto L36;
        upgradeDbForVersion7(db);     // Catch: SQLiteException -> L30
    L32:
        oldVersion = 7;
        goto L36
    L30:
        e = move-exception;
        Log.w(TAG, "Column was added without version update - ignore error", e);     // Catch: SQLiteException -> L6
    L36:
        if (oldVersion == newVersion) goto L42;
        Log.e(TAG, "Failed to update recoverablekeystore database to the most recent version");
        return;
    L42:
        return;
    L6:
        e = move-exception;
        Log.e(TAG, "Recreating recoverablekeystore after unexpected upgrade error.", e);
        dropAllKnownTables(db);
        onCreate(db);
    }

    private void dropAllKnownTables(SQLiteDatabase db) {
        db.execSQL(SQL_DELETE_KEYS_ENTRY);
        db.execSQL(SQL_DELETE_USER_METADATA_ENTRY);
        db.execSQL(SQL_DELETE_RECOVERY_SERVICE_METADATA_ENTRY);
        db.execSQL(SQL_DELETE_ROOT_OF_TRUST_ENTRY);
    }

    private void upgradeDbForVersion3(SQLiteDatabase db) {
        addColumnToTable(db, "recovery_service_metadata", "cert_path", "BLOB", null);
        addColumnToTable(db, "recovery_service_metadata", "cert_serial", "INTEGER", null);
    }

    private void upgradeDbForVersion4(SQLiteDatabase db) {
        Log.d(TAG, "Updating recoverable keystore database to version 4");
        db.execSQL(SQL_CREATE_ROOT_OF_TRUST_ENTRY);
        addColumnToTable(db, "recovery_service_metadata", "active_root_of_trust", "TEXT", null);
    }

    private void upgradeDbForVersion5(SQLiteDatabase db) {
        Log.d(TAG, "Updating recoverable keystore database to version 5");
        addColumnToTable(db, "keys", "key_metadata", "BLOB", null);
    }

    private void upgradeDbForVersion6(SQLiteDatabase db) {
        Log.d(TAG, "Updating recoverable keystore database to version 6");
        addColumnToTable(db, "user_metadata", "user_serial_number", "INTEGER DEFAULT -1", null);
    }

    private void upgradeDbForVersion7(SQLiteDatabase db) {
        Log.d(TAG, "Updating recoverable keystore database to version 7");
        addColumnToTable(db, "user_metadata", "bad_remote_guess_counter", "INTEGER DEFAULT 0", null);
    }

    private static void addColumnToTable(SQLiteDatabase db, String tableName, String column, String columnType, String defaultStr) {
        Log.d(TAG, "Adding column " + column + " to " + tableName + ".");
        String alterStr = "ALTER TABLE " + tableName + " ADD COLUMN " + column + " " + columnType;
        if (defaultStr != null) goto L5;
    L7:
        db.execSQL(alterStr + ";");
        return;
    L5:
        if (defaultStr.isEmpty() == true) goto L7;
        alterStr = alterStr + " DEFAULT " + defaultStr;
        goto L7
    }
}
