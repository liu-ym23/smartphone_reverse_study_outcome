package com.android.server.accounts;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.FileUtils;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class AccountsDb implements AutoCloseable {
    private static final String ACCOUNTS_ID = "_id";
    private static final String ACCOUNTS_LAST_AUTHENTICATE_TIME_EPOCH_MILLIS = "last_password_entry_time_millis_epoch";
    private static final String ACCOUNTS_NAME = "name";
    private static final String ACCOUNTS_PASSWORD = "password";
    private static final String ACCOUNTS_PREVIOUS_NAME = "previous_name";
    private static final String ACCOUNTS_TYPE = "type";
    private static final String ACCOUNTS_TYPE_COUNT = "count(type)";
    private static final String ACCOUNT_ACCESS_GRANTS = "SELECT name, uid FROM accounts, grants WHERE accounts_id=_id";
    private static final String[] ACCOUNT_TYPE_COUNT_PROJECTION = null;
    private static final String AUTHTOKENS_ACCOUNTS_ID = "accounts_id";
    private static final String AUTHTOKENS_AUTHTOKEN = "authtoken";
    private static final String AUTHTOKENS_ID = "_id";
    private static final String AUTHTOKENS_TYPE = "type";
    static final String CE_DATABASE_NAME = "accounts_ce.db";
    private static final int CE_DATABASE_VERSION = 10;
    private static final String CE_DB_PREFIX = "ceDb.";
    private static final String CE_TABLE_ACCOUNTS = "ceDb.accounts";
    private static final String CE_TABLE_AUTHTOKENS = "ceDb.authtokens";
    private static final String CE_TABLE_EXTRAS = "ceDb.extras";
    private static final String[] COLUMNS_AUTHTOKENS_TYPE_AND_AUTHTOKEN = null;
    private static final String[] COLUMNS_EXTRAS_KEY_AND_VALUE = null;
    private static final String COUNT_OF_MATCHING_GRANTS = "SELECT COUNT(*) FROM grants, accounts WHERE accounts_id=_id AND uid=? AND auth_token_type=? AND name=? AND type=?";
    private static final String COUNT_OF_MATCHING_GRANTS_ANY_TOKEN = "SELECT COUNT(*) FROM grants, accounts WHERE accounts_id=_id AND uid=? AND name=? AND type=?";
    private static final String DATABASE_NAME = "accounts.db";
    static String DEBUG_ACTION_ACCOUNT_ADD = null;
    static String DEBUG_ACTION_ACCOUNT_REMOVE = null;
    static String DEBUG_ACTION_ACCOUNT_REMOVE_DE = null;
    static String DEBUG_ACTION_ACCOUNT_RENAME = null;
    static String DEBUG_ACTION_AUTHENTICATOR_REMOVE = null;
    static String DEBUG_ACTION_CALLED_ACCOUNT_ADD = null;
    static String DEBUG_ACTION_CALLED_ACCOUNT_REMOVE = null;
    static String DEBUG_ACTION_CALLED_ACCOUNT_SESSION_FINISH = null;
    static String DEBUG_ACTION_CALLED_START_ACCOUNT_ADD = null;
    static String DEBUG_ACTION_CLEAR_PASSWORD = null;
    static String DEBUG_ACTION_SET_PASSWORD = null;
    static String DEBUG_ACTION_SYNC_DE_CE_ACCOUNTS = null;
    private static String DEBUG_TABLE_ACTION_TYPE = null;
    private static String DEBUG_TABLE_CALLER_UID = null;
    private static String DEBUG_TABLE_KEY = null;
    private static String DEBUG_TABLE_TABLE_NAME = null;
    private static String DEBUG_TABLE_TIMESTAMP = null;
    static final String DE_DATABASE_NAME = "accounts_de.db";
    private static final int DE_DATABASE_VERSION = 3;
    private static final String EXTRAS_ACCOUNTS_ID = "accounts_id";
    private static final String EXTRAS_ID = "_id";
    private static final String EXTRAS_KEY = "key";
    private static final String EXTRAS_VALUE = "value";
    private static final String GRANTS_ACCOUNTS_ID = "accounts_id";
    private static final String GRANTS_AUTH_TOKEN_TYPE = "auth_token_type";
    private static final String GRANTS_GRANTEE_UID = "uid";
    static final int MAX_DEBUG_DB_SIZE = 64;
    private static final String META_KEY = "key";
    private static final String META_KEY_DELIMITER = ":";
    private static final String META_KEY_FOR_AUTHENTICATOR_UID_FOR_TYPE_PREFIX = "auth_uid_for_type:";
    private static final String META_VALUE = "value";
    private static final int PRE_N_DATABASE_VERSION = 9;
    private static final String SELECTION_ACCOUNTS_ID_BY_ACCOUNT = "accounts_id=(select _id FROM accounts WHERE name=? AND type=?)";
    private static final String SELECTION_META_BY_AUTHENTICATOR_TYPE = "key LIKE ?";
    private static final String SHARED_ACCOUNTS_ID = "_id";
    static final String TABLE_ACCOUNTS = "accounts";
    private static final String TABLE_AUTHTOKENS = "authtokens";
    private static String TABLE_DEBUG = null;
    private static final String TABLE_EXTRAS = "extras";
    private static final String TABLE_GRANTS = "grants";
    private static final String TABLE_META = "meta";
    static final String TABLE_SHARED_ACCOUNTS = "shared_accounts";
    private static final String TABLE_VISIBILITY = "visibility";
    private static final String TAG = "AccountsDb";
    private static final String VISIBILITY_ACCOUNTS_ID = "accounts_id";
    private static final String VISIBILITY_PACKAGE = "_package";
    private static final String VISIBILITY_VALUE = "value";
    private final Context mContext;
    private final DeDatabaseHelper mDeDatabase;
    private volatile long mDebugDbInsertionPoint;
    private volatile SQLiteStatement mDebugStatementForLogging;
    final Object mDebugStatementLock;
    private final File mPreNDatabaseFile;

    private static class CeDatabaseHelper extends SQLiteOpenHelper {
        CeDatabaseHelper(Context context, String ceDatabaseName) {
            super(context, ceDatabaseName, null, 10);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            Log.i(AccountsDb.TAG, "Creating CE database " + getDatabaseName());
            db.execSQL("CREATE TABLE accounts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, type TEXT NOT NULL, password TEXT, UNIQUE(name,type))");
            db.execSQL("CREATE TABLE authtokens (  _id INTEGER PRIMARY KEY AUTOINCREMENT,  accounts_id INTEGER NOT NULL, type TEXT NOT NULL,  authtoken TEXT,  UNIQUE (accounts_id,type))");
            db.execSQL("CREATE TABLE extras ( _id INTEGER PRIMARY KEY AUTOINCREMENT, accounts_id INTEGER, key TEXT NOT NULL, value TEXT, UNIQUE(accounts_id,key))");
            createAccountsDeletionTrigger(db);
        }

        private void createAccountsDeletionTrigger(SQLiteDatabase db) {
            db.execSQL(" CREATE TRIGGER accountsDelete DELETE ON accounts BEGIN   DELETE FROM authtokens     WHERE accounts_id=OLD._id ;   DELETE FROM extras     WHERE accounts_id=OLD._id ; END");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i(AccountsDb.TAG, "Upgrade CE from version " + oldVersion + " to version " + newVersion);
            if (oldVersion == 9) goto L5;
        L8:
            if (oldVersion == newVersion) goto L11;
            Log.e(AccountsDb.TAG, "failed to upgrade version " + oldVersion + " to version " + newVersion);
            return;
        L11:
            return;
        L5:
            if (Log.isLoggable(AccountsDb.TAG, 2) == false) goto L7;
            Log.v(AccountsDb.TAG, "onUpgrade upgrading to v10");
        L7:
            db.execSQL("DROP TABLE IF EXISTS meta");
            db.execSQL("DROP TABLE IF EXISTS shared_accounts");
            db.execSQL("DROP TRIGGER IF EXISTS accountsDelete");
            createAccountsDeletionTrigger(db);
            db.execSQL("DROP TABLE IF EXISTS grants");
            db.execSQL("DROP TABLE IF EXISTS " + AccountsDb.m940$$Nest$sfgetTABLE_DEBUG());
            oldVersion = oldVersion + 1;
            goto L8
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.e(AccountsDb.TAG, "onDowngrade: recreate accounts CE table");
            AccountsDb.m941$$Nest$smresetDatabase(db);
            onCreate(db);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            if (Log.isLoggable(AccountsDb.TAG, 2) == false) goto L6;
            Log.v(AccountsDb.TAG, "opened database accounts_ce.db");
            return;
        }

        static CeDatabaseHelper create(Context context, File preNDatabaseFile, File ceDatabaseFile) {
            boolean newDbExists = ceDatabaseFile.exists();
            if (Log.isLoggable(AccountsDb.TAG, 2) == false) goto L5;
            Log.v(AccountsDb.TAG, "CeDatabaseHelper.create ceDatabaseFile=" + ceDatabaseFile + " oldDbExists=" + preNDatabaseFile.exists() + " newDbExists=" + newDbExists);
        L5:
            boolean removeOldDb = false;
            if (newDbExists == false) goto L8;
        L10:
            CeDatabaseHelper ceHelper = new CeDatabaseHelper(context, ceDatabaseFile.getPath());
            ceHelper.getWritableDatabase();
            ceHelper.close();
            if (removeOldDb == false) goto L15;
            Slog.i(AccountsDb.TAG, "Migration complete - removing pre-N db " + preNDatabaseFile);
            if (SQLiteDatabase.deleteDatabase(preNDatabaseFile) == true) goto L15;
            Slog.e(AccountsDb.TAG, "Cannot remove pre-N db " + preNDatabaseFile);
        L15:
            return ceHelper;
        L8:
            if (preNDatabaseFile.exists() == false) goto L10;
            removeOldDb = migratePreNDbToCe(preNDatabaseFile, ceDatabaseFile);
            goto L10
        }

        private static boolean migratePreNDbToCe(File oldDbFile, File ceDbFile) {
            Slog.i(AccountsDb.TAG, "Moving pre-N DB " + oldDbFile + " to CE " + ceDbFile);
            FileUtils.copyFileOrThrow(oldDbFile, ceDbFile);     // Catch: IOException -> L6
            return true;
        L6:
            e = move-exception;
            Slog.e(AccountsDb.TAG, "Cannot copy file to " + ceDbFile + " from " + oldDbFile, e);
            AccountsDb.deleteDbFileWarnIfFailed(ceDbFile);
            return false;
        }
    }

    static class DeDatabaseHelper extends SQLiteOpenHelper {
        private volatile boolean mCeAttached;
        private final int mUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmCeAttached, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m942$$Nest$fgetmCeAttached(DeDatabaseHelper r0) {
            return r0.mCeAttached;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmCeAttached, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m943$$Nest$fputmCeAttached(DeDatabaseHelper r0, boolean r1) {
            r0.mCeAttached = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mmigratePreNDbToDe, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m944$$Nest$mmigratePreNDbToDe(DeDatabaseHelper r0, File r1) {
            r0.migratePreNDbToDe(r1);
        }

        /* synthetic */ DeDatabaseHelper(Context r1, int r2, String r3, AccountsDbIA r4) {
            this(r1, r2, r3);
        }

        private DeDatabaseHelper(Context context, int userId, String deDatabaseName) {
            super(context, deDatabaseName, null, 3);
            this.mUserId = userId;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            Log.i(AccountsDb.TAG, "Creating DE database for user " + this.mUserId);
            db.execSQL("CREATE TABLE accounts ( _id INTEGER PRIMARY KEY, name TEXT NOT NULL, type TEXT NOT NULL, previous_name TEXT, last_password_entry_time_millis_epoch INTEGER DEFAULT 0, UNIQUE(name,type))");
            db.execSQL("CREATE TABLE meta ( key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            createGrantsTable(db);
            createSharedAccountsTable(db);
            createAccountsDeletionTrigger(db);
            createDebugTable(db);
            createAccountsVisibilityTable(db);
            createAccountsDeletionVisibilityCleanupTrigger(db);
        }

        private void createSharedAccountsTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE shared_accounts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, type TEXT NOT NULL, UNIQUE(name,type))");
        }

        private void createAccountsDeletionTrigger(SQLiteDatabase db) {
            db.execSQL(" CREATE TRIGGER accountsDelete DELETE ON accounts BEGIN   DELETE FROM grants     WHERE accounts_id=OLD._id ; END");
        }

        private void createGrantsTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE grants (  accounts_id INTEGER NOT NULL, auth_token_type STRING NOT NULL,  uid INTEGER NOT NULL,  UNIQUE (accounts_id,auth_token_type,uid))");
        }

        private void createAccountsVisibilityTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE visibility ( accounts_id INTEGER NOT NULL, _package TEXT NOT NULL, value INTEGER, PRIMARY KEY(accounts_id,_package))");
        }

        static void createDebugTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + AccountsDb.m940$$Nest$sfgetTABLE_DEBUG() + " ( _id INTEGER," + AccountsDb.m935$$Nest$sfgetDEBUG_TABLE_ACTION_TYPE() + " TEXT NOT NULL, " + AccountsDb.m939$$Nest$sfgetDEBUG_TABLE_TIMESTAMP() + " DATETIME," + AccountsDb.m936$$Nest$sfgetDEBUG_TABLE_CALLER_UID() + " INTEGER NOT NULL," + AccountsDb.m938$$Nest$sfgetDEBUG_TABLE_TABLE_NAME() + " TEXT NOT NULL," + AccountsDb.m937$$Nest$sfgetDEBUG_TABLE_KEY() + " INTEGER PRIMARY KEY)");
            StringBuilder r0 = new StringBuilder();
            r0.append("CREATE INDEX timestamp_index ON ");
            r0.append(AccountsDb.m940$$Nest$sfgetTABLE_DEBUG());
            r0.append(" (");
            r0.append(AccountsDb.m939$$Nest$sfgetDEBUG_TABLE_TIMESTAMP());
            r0.append(")");
            db.execSQL(r0.toString());
        }

        private void createAccountsDeletionVisibilityCleanupTrigger(SQLiteDatabase db) {
            db.execSQL(" CREATE TRIGGER accountsDeleteVisibility DELETE ON accounts BEGIN   DELETE FROM visibility     WHERE accounts_id=OLD._id ; END");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.i(AccountsDb.TAG, "upgrade from version " + oldVersion + " to version " + newVersion);
            if (oldVersion != 1) goto L6;
            createAccountsVisibilityTable(db);
            createAccountsDeletionVisibilityCleanupTrigger(db);
            oldVersion = 3;
        L6:
            if (oldVersion != 2) goto L8;
            db.execSQL("DROP TRIGGER IF EXISTS accountsDeleteVisibility");
            db.execSQL("DROP TABLE IF EXISTS visibility");
            createAccountsVisibilityTable(db);
            createAccountsDeletionVisibilityCleanupTrigger(db);
            oldVersion = oldVersion + 1;
        L8:
            if (oldVersion == newVersion) goto L11;
            Log.e(AccountsDb.TAG, "failed to upgrade version " + oldVersion + " to version " + newVersion);
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.e(AccountsDb.TAG, "onDowngrade: recreate accounts DE table");
            AccountsDb.m941$$Nest$smresetDatabase(db);
            onCreate(db);
        }

        public SQLiteDatabase getReadableDatabaseUserIsUnlocked() {
            if (this.mCeAttached == true) goto L6;
            Log.wtf(AccountsDb.TAG, "getReadableDatabaseUserIsUnlocked called while user " + this.mUserId + " is still locked. CE database is not yet available.", new Throwable());
        L6:
            return super.getReadableDatabase();
        }

        public SQLiteDatabase getWritableDatabaseUserIsUnlocked() {
            if (this.mCeAttached == true) goto L6;
            Log.wtf(AccountsDb.TAG, "getWritableDatabaseUserIsUnlocked called while user " + this.mUserId + " is still locked. CE database is not yet available.", new Throwable());
        L6:
            return super.getWritableDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            if (Log.isLoggable(AccountsDb.TAG, 2) == false) goto L6;
            Log.v(AccountsDb.TAG, "opened database accounts_de.db");
            return;
        }

        private void migratePreNDbToDe(File preNDbFile) {
            Log.i(AccountsDb.TAG, "Migrate pre-N database to DE preNDbFile=" + preNDbFile);
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("ATTACH DATABASE '" + preNDbFile.getPath() + "' AS preNDb");
            db.beginTransaction();
            db.execSQL("INSERT INTO accounts(_id,name,type, previous_name, last_password_entry_time_millis_epoch) SELECT _id,name,type, previous_name, last_password_entry_time_millis_epoch FROM preNDb.accounts");
            db.execSQL("INSERT INTO shared_accounts(_id,name,type) SELECT _id,name,type FROM preNDb.shared_accounts");
            db.execSQL("INSERT INTO " + AccountsDb.m940$$Nest$sfgetTABLE_DEBUG() + "(_id," + AccountsDb.m935$$Nest$sfgetDEBUG_TABLE_ACTION_TYPE() + "," + AccountsDb.m939$$Nest$sfgetDEBUG_TABLE_TIMESTAMP() + "," + AccountsDb.m936$$Nest$sfgetDEBUG_TABLE_CALLER_UID() + "," + AccountsDb.m938$$Nest$sfgetDEBUG_TABLE_TABLE_NAME() + "," + AccountsDb.m937$$Nest$sfgetDEBUG_TABLE_KEY() + ") SELECT _id," + AccountsDb.m935$$Nest$sfgetDEBUG_TABLE_ACTION_TYPE() + "," + AccountsDb.m939$$Nest$sfgetDEBUG_TABLE_TIMESTAMP() + "," + AccountsDb.m936$$Nest$sfgetDEBUG_TABLE_CALLER_UID() + "," + AccountsDb.m938$$Nest$sfgetDEBUG_TABLE_TABLE_NAME() + "," + AccountsDb.m937$$Nest$sfgetDEBUG_TABLE_KEY() + " FROM preNDb." + AccountsDb.m940$$Nest$sfgetTABLE_DEBUG());
            db.execSQL("INSERT INTO grants(accounts_id,auth_token_type,uid) SELECT accounts_id,auth_token_type,uid FROM preNDb.grants");
            db.execSQL("INSERT INTO meta(key,value) SELECT key,value FROM preNDb.meta");
            db.setTransactionSuccessful();
            db.endTransaction();
            db.execSQL("DETACH DATABASE preNDb");
        }
    }

    private static class PreNDatabaseHelper extends SQLiteOpenHelper {
        private final Context mContext;
        private final int mUserId;

        PreNDatabaseHelper(Context context, int userId, String preNDatabaseName) {
            super(context, preNDatabaseName, null, 9);
            this.mContext = context;
            this.mUserId = userId;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            throw new IllegalStateException("Legacy database cannot be created - only upgraded!");
        }

        private void createSharedAccountsTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE shared_accounts ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, type TEXT NOT NULL, UNIQUE(name,type))");
        }

        private void addLastSuccessfullAuthenticatedTimeColumn(SQLiteDatabase db) {
            db.execSQL("ALTER TABLE accounts ADD COLUMN last_password_entry_time_millis_epoch DEFAULT 0");
        }

        private void addOldAccountNameColumn(SQLiteDatabase db) {
            db.execSQL("ALTER TABLE accounts ADD COLUMN previous_name");
        }

        private void addDebugTable(SQLiteDatabase db) {
            DeDatabaseHelper.createDebugTable(db);
        }

        private void createAccountsDeletionTrigger(SQLiteDatabase db) {
            db.execSQL(" CREATE TRIGGER accountsDelete DELETE ON accounts BEGIN   DELETE FROM authtokens     WHERE accounts_id=OLD._id ;   DELETE FROM extras     WHERE accounts_id=OLD._id ;   DELETE FROM grants     WHERE accounts_id=OLD._id ; END");
        }

        private void createGrantsTable(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE grants (  accounts_id INTEGER NOT NULL, auth_token_type STRING NOT NULL,  uid INTEGER NOT NULL,  UNIQUE (accounts_id,auth_token_type,uid))");
        }

        static long insertMetaAuthTypeAndUid(SQLiteDatabase db, String authenticatorType, int uid) {
            ContentValues values = new ContentValues();
            values.put("key", AccountsDb.META_KEY_FOR_AUTHENTICATOR_UID_FOR_TYPE_PREFIX + authenticatorType);
            values.put("value", Integer.valueOf(uid));
            return db.insert(AccountsDb.TABLE_META, null, values);
        }

        private void populateMetaTableWithAuthTypeAndUID(SQLiteDatabase db, Map<String, Integer> authTypeAndUIDMap) {
            Iterator<Map.Entry<String, Integer>> r0 = authTypeAndUIDMap.entrySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Map.Entry<String, Integer> entry = r0.next();
            insertMetaAuthTypeAndUid(db, entry.getKey(), entry.getValue().intValue());
            goto L4
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.e(AccountsDb.TAG, "upgrade from version " + oldVersion + " to version " + newVersion);
            if (oldVersion != 1) goto L6;
            oldVersion = oldVersion + 1;
        L6:
            if (oldVersion != 2) goto L9;
            createGrantsTable(db);
            db.execSQL("DROP TRIGGER accountsDelete");
            createAccountsDeletionTrigger(db);
            oldVersion = oldVersion + 1;
        L9:
            if (oldVersion != 3) goto L12;
            db.execSQL("UPDATE accounts SET type = 'com.google' WHERE type == 'com.google.GAIA'");
            oldVersion = oldVersion + 1;
        L12:
            if (oldVersion != 4) goto L15;
            createSharedAccountsTable(db);
            oldVersion = oldVersion + 1;
        L15:
            if (oldVersion != 5) goto L18;
            addOldAccountNameColumn(db);
            oldVersion = oldVersion + 1;
        L18:
            if (oldVersion != 6) goto L21;
            addLastSuccessfullAuthenticatedTimeColumn(db);
            oldVersion = oldVersion + 1;
        L21:
            if (oldVersion != 7) goto L24;
            addDebugTable(db);
            oldVersion = oldVersion + 1;
        L24:
            if (oldVersion != 8) goto L26;
            populateMetaTableWithAuthTypeAndUID(db, AccountManagerService.getAuthenticatorTypeAndUIDForUser(this.mContext, this.mUserId));
            oldVersion = oldVersion + 1;
        L26:
            if (oldVersion == newVersion) goto L29;
            Log.e(AccountsDb.TAG, "failed to upgrade version " + oldVersion + " to version " + newVersion);
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            if (Log.isLoggable(AccountsDb.TAG, 2) == false) goto L6;
            Log.v(AccountsDb.TAG, "opened database accounts.db");
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_TABLE_ACTION_TYPE, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m935$$Nest$sfgetDEBUG_TABLE_ACTION_TYPE() {
        return DEBUG_TABLE_ACTION_TYPE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_TABLE_CALLER_UID, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m936$$Nest$sfgetDEBUG_TABLE_CALLER_UID() {
        return DEBUG_TABLE_CALLER_UID;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_TABLE_KEY, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m937$$Nest$sfgetDEBUG_TABLE_KEY() {
        return DEBUG_TABLE_KEY;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_TABLE_TABLE_NAME, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m938$$Nest$sfgetDEBUG_TABLE_TABLE_NAME() {
        return DEBUG_TABLE_TABLE_NAME;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_TABLE_TIMESTAMP, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m939$$Nest$sfgetDEBUG_TABLE_TIMESTAMP() {
        return DEBUG_TABLE_TIMESTAMP;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTABLE_DEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m940$$Nest$sfgetTABLE_DEBUG() {
        return TABLE_DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smresetDatabase, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m941$$Nest$smresetDatabase(SQLiteDatabase r0) {
        resetDatabase(r0);
    }

    static {
        TABLE_DEBUG = "debug_table";
        DEBUG_TABLE_ACTION_TYPE = "action_type";
        DEBUG_TABLE_TIMESTAMP = "time";
        DEBUG_TABLE_CALLER_UID = "caller_uid";
        DEBUG_TABLE_TABLE_NAME = "table_name";
        DEBUG_TABLE_KEY = "primary_key";
        DEBUG_ACTION_SET_PASSWORD = "action_set_password";
        DEBUG_ACTION_CLEAR_PASSWORD = "action_clear_password";
        DEBUG_ACTION_ACCOUNT_ADD = "action_account_add";
        DEBUG_ACTION_ACCOUNT_REMOVE = "action_account_remove";
        DEBUG_ACTION_ACCOUNT_REMOVE_DE = "action_account_remove_de";
        DEBUG_ACTION_AUTHENTICATOR_REMOVE = "action_authenticator_remove";
        DEBUG_ACTION_ACCOUNT_RENAME = "action_account_rename";
        DEBUG_ACTION_CALLED_ACCOUNT_ADD = "action_called_account_add";
        DEBUG_ACTION_CALLED_ACCOUNT_REMOVE = "action_called_account_remove";
        DEBUG_ACTION_SYNC_DE_CE_ACCOUNTS = "action_sync_de_ce_accounts";
        DEBUG_ACTION_CALLED_START_ACCOUNT_ADD = "action_called_start_account_add";
        DEBUG_ACTION_CALLED_ACCOUNT_SESSION_FINISH = "action_called_account_session_finish";
        ACCOUNT_TYPE_COUNT_PROJECTION = new String[]{DatabaseHelper.SoundModelContract.KEY_TYPE, ACCOUNTS_TYPE_COUNT};
        COLUMNS_AUTHTOKENS_TYPE_AND_AUTHTOKEN = new String[]{DatabaseHelper.SoundModelContract.KEY_TYPE, AUTHTOKENS_AUTHTOKEN};
        COLUMNS_EXTRAS_KEY_AND_VALUE = new String[]{"key", "value"};
    }

    AccountsDb(DeDatabaseHelper deDatabase, Context context, File preNDatabaseFile) {
        this.mDebugStatementLock = new Object();
        this.mDebugDbInsertionPoint = -1;
        this.mDeDatabase = deDatabase;
        this.mContext = context;
        this.mPreNDatabaseFile = preNDatabaseFile;
    }

    Cursor findAuthtokenForAllAccounts(String accountType, String authToken) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabaseUserIsUnlocked();
        return db.rawQuery("SELECT ceDb.authtokens._id, ceDb.accounts.name, ceDb.authtokens.type FROM ceDb.accounts JOIN ceDb.authtokens ON ceDb.accounts._id = ceDb.authtokens.accounts_id WHERE ceDb.authtokens.authtoken = ? AND ceDb.accounts.type = ?", new String[]{authToken, accountType});
    }

    Map<String, String> findAuthTokensByAccount(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabaseUserIsUnlocked();
        HashMap<String, String> authTokensForAccount = new HashMap();
        Cursor cursor = db.query(CE_TABLE_AUTHTOKENS, COLUMNS_AUTHTOKENS_TYPE_AND_AUTHTOKEN, SELECTION_ACCOUNTS_ID_BY_ACCOUNT, new String[]{account.name, account.type}, null, null, null);
    L13:
    L7:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        String type = cursor.getString(0);     // Catch: Throwable -> L7
        String authToken = cursor.getString(1);     // Catch: Throwable -> L7
        authTokensForAccount.put(type, authToken);     // Catch: Throwable -> L7
        goto L13
    L9:
        cursor.close();
        return authTokensForAccount;
    }

    boolean deleteAuthtokensByAccountIdAndType(long accountId, String authtokenType) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        if (db.delete(CE_TABLE_AUTHTOKENS, "accounts_id=? AND type=?", new String[]{String.valueOf(accountId), authtokenType}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean deleteAuthToken(String authTokenId) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        if (db.delete(CE_TABLE_AUTHTOKENS, "_id= ?", new String[]{authTokenId}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    long insertAuthToken(long accountId, String authTokenType, String authToken) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        ContentValues values = new ContentValues();
        values.put("accounts_id", Long.valueOf(accountId));
        values.put(DatabaseHelper.SoundModelContract.KEY_TYPE, authTokenType);
        values.put(AUTHTOKENS_AUTHTOKEN, authToken);
        return db.insert(CE_TABLE_AUTHTOKENS, AUTHTOKENS_AUTHTOKEN, values);
    }

    int updateCeAccountPassword(long accountId, String password) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        ContentValues values = new ContentValues();
        values.put("password", password);
        return db.update(CE_TABLE_ACCOUNTS, values, "_id=?", new String[]{String.valueOf(accountId)});
    }

    boolean renameCeAccount(long accountId, String newName) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        ContentValues values = new ContentValues();
        values.put("name", newName);
        String[] argsAccountId = {String.valueOf(accountId)};
        if (db.update(CE_TABLE_ACCOUNTS, values, "_id=?", argsAccountId) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean deleteAuthTokensByAccountId(long accountId) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        if (db.delete(CE_TABLE_AUTHTOKENS, "accounts_id=?", new String[]{String.valueOf(accountId)}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    long findExtrasIdByAccountId(long accountId, String key) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabaseUserIsUnlocked();
        Cursor cursor = db.query(CE_TABLE_EXTRAS, new String[]{"_id"}, "accounts_id=" + accountId + " AND key=?", new String[]{key}, null, null, null);
    L8:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        long r3 = cursor.getLong(0);     // Catch: Throwable -> L8
        cursor.close();
        return r3;
    L10:
        cursor.close();
        return -1;
    }

    boolean updateExtra(long extrasId, String value) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        ContentValues values = new ContentValues();
        values.put("value", value);
        int rows = db.update(TABLE_EXTRAS, values, "_id=?", new String[]{String.valueOf(extrasId)});
        if (rows == 1) goto L7;
        return false;
    L7:
        return true;
    }

    long insertExtra(long accountId, String key, String value) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        ContentValues values = new ContentValues();
        values.put("key", key);
        values.put("accounts_id", Long.valueOf(accountId));
        values.put("value", value);
        return db.insert(CE_TABLE_EXTRAS, "key", values);
    }

    Map<String, String> findUserExtrasForAccount(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabaseUserIsUnlocked();
        Map<String, String> userExtrasForAccount = new HashMap();
        String[] selectionArgs = {account.name, account.type};
        Cursor cursor = db.query(CE_TABLE_EXTRAS, COLUMNS_EXTRAS_KEY_AND_VALUE, SELECTION_ACCOUNTS_ID_BY_ACCOUNT, selectionArgs, null, null, null);
    L19:
    L7:
        th = move-exception;
        if (cursor == null) goto L23;
        cursor.close();     // Catch: Throwable -> L14
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L23:
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        String tmpkey = cursor.getString(0);     // Catch: Throwable -> L7
        String value = cursor.getString(1);     // Catch: Throwable -> L7
        userExtrasForAccount.put(tmpkey, value);     // Catch: Throwable -> L7
        goto L19
    L9:
        cursor.close();
        return userExtrasForAccount;
    }

    long findCeAccountId(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabaseUserIsUnlocked();
        String[] columns = {"_id"};
        String[] selectionArgs = {account.name, account.type};
        Cursor cursor = db.query(CE_TABLE_ACCOUNTS, columns, "name=? AND type=?", selectionArgs, null, null, null);
    L8:
        th = move-exception;
        if (cursor == null) goto L22;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L22:
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        long r6 = cursor.getLong(0);     // Catch: Throwable -> L8
        cursor.close();
        return r6;
    L10:
        cursor.close();
        return -1;
    }

    String findAccountPasswordByNameAndType(String name, String type) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabaseUserIsUnlocked();
        String[] selectionArgs = {name, type};
        String[] columns = {"password"};
        Cursor cursor = db.query(CE_TABLE_ACCOUNTS, columns, "name=? AND type=?", selectionArgs, null, null, null);
    L8:
        th = move-exception;
        if (cursor == null) goto L22;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L22:
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        String r0 = cursor.getString(0);     // Catch: Throwable -> L8
        cursor.close();
        return r0;
    L10:
        cursor.close();
        return null;
    }

    long insertCeAccount(Account account, String password) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        ContentValues values = new ContentValues();
        values.put("name", account.name);
        values.put(DatabaseHelper.SoundModelContract.KEY_TYPE, account.type);
        values.put("password", password);
        return db.insert(CE_TABLE_ACCOUNTS, "name", values);
    }

    boolean deleteDeAccount(long accountId) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        if (db.delete(TABLE_ACCOUNTS, "_id=" + accountId, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    long insertSharedAccount(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", account.name);
        values.put(DatabaseHelper.SoundModelContract.KEY_TYPE, account.type);
        return db.insert(TABLE_SHARED_ACCOUNTS, "name", values);
    }

    boolean deleteSharedAccount(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        if (db.delete(TABLE_SHARED_ACCOUNTS, "name=? AND type=?", new String[]{account.name, account.type}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    int renameSharedAccount(Account account, String newName) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", newName);
        return db.update(TABLE_SHARED_ACCOUNTS, values, "name=? AND type=?", new String[]{account.name, account.type});
    }

    List<Account> getSharedAccounts() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        ArrayList<Account> accountList = new ArrayList();
        Cursor cursor = null;
        cursor = db.query(TABLE_SHARED_ACCOUNTS, new String[]{"name", DatabaseHelper.SoundModelContract.KEY_TYPE}, null, null, null, null, null);     // Catch: Throwable -> L11
        if (cursor != null) goto L6;
    L13:
        if (cursor == null) goto L15;
        cursor.close();
    L15:
        return accountList;
    L6:
        if (cursor.moveToFirst() == false) goto L13;
        int nameIndex = cursor.getColumnIndex("name");     // Catch: Throwable -> L11
        int typeIndex = cursor.getColumnIndex(DatabaseHelper.SoundModelContract.KEY_TYPE);     // Catch: Throwable -> L11
    L8:
        accountList.add(new Account(cursor.getString(nameIndex), cursor.getString(typeIndex)));     // Catch: Throwable -> L11
        if (cursor.moveToNext() == true) goto L8;
    L11:
        th = move-exception;
        if (cursor == null) goto L18;
        cursor.close();
    L18:
        throw th;
    }

    long findSharedAccountId(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_SHARED_ACCOUNTS, new String[]{"_id"}, "name=? AND type=?", new String[]{account.name, account.type}, null, null, null);
    L8:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        long r3 = cursor.getLong(0);     // Catch: Throwable -> L8
        cursor.close();
        return r3;
    L10:
        cursor.close();
        return -1;
    }

    long findAccountLastAuthenticatedTime(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        return DatabaseUtils.longForQuery(db, "SELECT last_password_entry_time_millis_epoch FROM accounts WHERE name=? AND type=?", new String[]{account.name, account.type});
    }

    boolean updateAccountLastAuthenticatedTime(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ACCOUNTS_LAST_AUTHENTICATE_TIME_EPOCH_MILLIS, Long.valueOf(System.currentTimeMillis()));
        int rowCount = db.update(TABLE_ACCOUNTS, values, "name=? AND type=?", new String[]{account.name, account.type});
        if (rowCount <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void dumpDeAccountsTable(PrintWriter pw) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ACCOUNTS, ACCOUNT_TYPE_COUNT_PROJECTION, null, null, DatabaseHelper.SoundModelContract.KEY_TYPE, null, null);
    L14:
    L7:
        th = move-exception;
        if (cursor == null) goto L13;
        cursor.close();
    L13:
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        pw.println(cursor.getString(0) + "," + cursor.getString(1));     // Catch: Throwable -> L7
        goto L14
    L9:
        cursor.close();
    }

    long findDeAccountId(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        String[] columns = {"_id"};
        String[] selectionArgs = {account.name, account.type};
        Cursor cursor = db.query(TABLE_ACCOUNTS, columns, "name=? AND type=?", selectionArgs, null, null, null);
    L8:
        th = move-exception;
        if (cursor == null) goto L22;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L22:
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        long r6 = cursor.getLong(0);     // Catch: Throwable -> L8
        cursor.close();
        return r6;
    L10:
        cursor.close();
        return -1;
    }

    Map<Long, Account> findAllDeAccounts() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        LinkedHashMap<Long, Account> map = new LinkedHashMap();
        String[] columns = {"_id", DatabaseHelper.SoundModelContract.KEY_TYPE, "name"};
        Cursor cursor = db.query(TABLE_ACCOUNTS, columns, null, null, null, null, "_id");
    L19:
    L7:
        th = move-exception;
        if (cursor == null) goto L23;
        cursor.close();     // Catch: Throwable -> L14
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L23:
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        long accountId = cursor.getLong(0);     // Catch: Throwable -> L7
        String accountType = cursor.getString(1);     // Catch: Throwable -> L7
        String accountName = cursor.getString(2);     // Catch: Throwable -> L7
        Account account = new Account(accountName, accountType);     // Catch: Throwable -> L7
        map.put(Long.valueOf(accountId), account);     // Catch: Throwable -> L7
        goto L19
    L9:
        cursor.close();
        return map;
    }

    String findDeAccountPreviousName(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        String[] columns = {ACCOUNTS_PREVIOUS_NAME};
        String[] selectionArgs = {account.name, account.type};
        Cursor cursor = db.query(TABLE_ACCOUNTS, columns, "name=? AND type=?", selectionArgs, null, null, null);
    L8:
        th = move-exception;
        if (cursor == null) goto L22;
        cursor.close();     // Catch: Throwable -> L15
        throw th;
    L15:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L22:
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        String r0 = cursor.getString(0);     // Catch: Throwable -> L8
        cursor.close();
        return r0;
    L10:
        cursor.close();
        return null;
    }

    long insertDeAccount(Account account, long accountId) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", Long.valueOf(accountId));
        values.put("name", account.name);
        values.put(DatabaseHelper.SoundModelContract.KEY_TYPE, account.type);
        values.put(ACCOUNTS_LAST_AUTHENTICATE_TIME_EPOCH_MILLIS, Long.valueOf(System.currentTimeMillis()));
        return db.insert(TABLE_ACCOUNTS, "name", values);
    }

    boolean renameDeAccount(long accountId, String newName, String previousName) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", newName);
        values.put(ACCOUNTS_PREVIOUS_NAME, previousName);
        String[] argsAccountId = {String.valueOf(accountId)};
        if (db.update(TABLE_ACCOUNTS, values, "_id=?", argsAccountId) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean deleteGrantsByAccountIdAuthTokenTypeAndUid(long accountId, String authTokenType, long uid) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        if (db.delete(TABLE_GRANTS, "accounts_id=? AND auth_token_type=? AND uid=?", new String[]{String.valueOf(accountId), authTokenType, String.valueOf(uid)}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    List<Integer> findAllUidGrants() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        List<Integer> result = new ArrayList();
        Cursor cursor = db.query(TABLE_GRANTS, new String[]{"uid"}, null, null, "uid", null, null);
    L13:
    L7:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        int uid = cursor.getInt(0);     // Catch: Throwable -> L7
        result.add(Integer.valueOf(uid));     // Catch: Throwable -> L7
        goto L13
    L9:
        cursor.close();
        return result;
    }

    long findMatchingGrantsCount(int uid, String authTokenType, Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        String[] args = {String.valueOf(uid), authTokenType, account.name, account.type};
        return DatabaseUtils.longForQuery(db, COUNT_OF_MATCHING_GRANTS, args);
    }

    long findMatchingGrantsCountAnyToken(int uid, Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        String[] args = {String.valueOf(uid), account.name, account.type};
        return DatabaseUtils.longForQuery(db, COUNT_OF_MATCHING_GRANTS_ANY_TOKEN, args);
    }

    long insertGrant(long accountId, String authTokenType, int uid) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("accounts_id", Long.valueOf(accountId));
        values.put(GRANTS_AUTH_TOKEN_TYPE, authTokenType);
        values.put("uid", Integer.valueOf(uid));
        return db.insert(TABLE_GRANTS, "accounts_id", values);
    }

    boolean deleteGrantsByUid(int uid) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        if (db.delete(TABLE_GRANTS, "uid=?", new String[]{Integer.toString(uid)}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean setAccountVisibility(long accountId, String packageName, int visibility) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("accounts_id", String.valueOf(accountId));
        values.put(VISIBILITY_PACKAGE, packageName);
        values.put("value", String.valueOf(visibility));
        if (db.replace(TABLE_VISIBILITY, "value", values) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    Integer findAccountVisibility(Account account, String packageName) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_VISIBILITY, new String[]{"value"}, "accounts_id=(select _id FROM accounts WHERE name=? AND type=?) AND _package=? ", new String[]{account.name, account.type, packageName}, null, null, null);
    L8:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        Integer r0 = Integer.valueOf(cursor.getInt(0));     // Catch: Throwable -> L8
        cursor.close();
        return r0;
    L10:
        cursor.close();
        return null;
    }

    Integer findAccountVisibility(long accountId, String packageName) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_VISIBILITY, new String[]{"value"}, "accounts_id=? AND _package=? ", new String[]{String.valueOf(accountId), packageName}, null, null, null);
    L8:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        Integer r0 = Integer.valueOf(cursor.getInt(0));     // Catch: Throwable -> L8
        cursor.close();
        return r0;
    L10:
        cursor.close();
        return null;
    }

    Account findDeAccountByAccountId(long accountId) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ACCOUNTS, new String[]{"name", DatabaseHelper.SoundModelContract.KEY_TYPE}, "_id=? ", new String[]{String.valueOf(accountId)}, null, null, null);
    L8:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L10;
        Account r0 = new Account(cursor.getString(0), cursor.getString(1));     // Catch: Throwable -> L8
        cursor.close();
        return r0;
    L10:
        cursor.close();
        return null;
    }

    Map<String, Integer> findAllVisibilityValuesForAccount(Account account) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Map<String, Integer> result = new HashMap();
        Cursor cursor = db.query(TABLE_VISIBILITY, new String[]{VISIBILITY_PACKAGE, "value"}, SELECTION_ACCOUNTS_ID_BY_ACCOUNT, new String[]{account.name, account.type}, null, null, null);
    L13:
    L7:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        result.put(cursor.getString(0), Integer.valueOf(cursor.getInt(1)));     // Catch: Throwable -> L7
        goto L13
    L9:
        cursor.close();
        return result;
    }

    Map<Account, Map<String, Integer>> findAllVisibilityValues() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Map<Account, Map<String, Integer>> result = new HashMap();
        Cursor cursor = db.rawQuery("SELECT visibility._package, visibility.value, accounts.name, accounts.type FROM visibility JOIN accounts ON accounts._id = visibility.accounts_id", null);
    L16:
        if (cursor.moveToNext() == false) goto L12;
        String packageName = cursor.getString(0);     // Catch: Throwable -> L8
        Integer visibility = Integer.valueOf(cursor.getInt(1));     // Catch: Throwable -> L8
        String accountName = cursor.getString(2);     // Catch: Throwable -> L8
        String accountType = cursor.getString(3);     // Catch: Throwable -> L8
        Account account = new Account(accountName, accountType);     // Catch: Throwable -> L8
        Map<String, Integer> accountVisibility = result.get(account);     // Catch: Throwable -> L8
        if (accountVisibility != null) goto L10;
        accountVisibility = new HashMap();     // Catch: Throwable -> L8
        result.put(account, accountVisibility);     // Catch: Throwable -> L8
    L10:
        accountVisibility.put(packageName, visibility);     // Catch: Throwable -> L8
        goto L16
    L12:
        cursor.close();
        return result;
    L8:
        th = move-exception;
        cursor.close();
        throw th;
    }

    boolean deleteAccountVisibilityForPackage(String packageName) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        if (db.delete(TABLE_VISIBILITY, "_package=? ", new String[]{packageName}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    long insertOrReplaceMetaAuthTypeAndUid(String authenticatorType, int uid) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("key", META_KEY_FOR_AUTHENTICATOR_UID_FOR_TYPE_PREFIX + authenticatorType);
        values.put("value", Integer.valueOf(uid));
        return db.insertWithOnConflict(TABLE_META, null, values, 5);
    }

    Map<String, Integer> findMetaAuthUid() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor metaCursor = db.query(TABLE_META, new String[]{"key", "value"}, SELECTION_META_BY_AUTHENTICATOR_TYPE, new String[]{"auth_uid_for_type:%"}, null, null, "key");
        Map<String, Integer> map = new LinkedHashMap();
    L19:
        if (metaCursor.moveToNext() == false) goto L15;
        String type = TextUtils.split(metaCursor.getString(0), META_KEY_DELIMITER)[1];     // Catch: Throwable -> L11
        String uidStr = metaCursor.getString(1);     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(type) == true) goto L13;
        if (TextUtils.isEmpty(uidStr) == true) goto L13;
        int uid = Integer.parseInt(metaCursor.getString(1));     // Catch: Throwable -> L11
        map.put(type, Integer.valueOf(uid));     // Catch: Throwable -> L11
    L13:
        Slog.e(TAG, "Auth type empty: " + TextUtils.isEmpty(type) + ", uid empty: " + TextUtils.isEmpty(uidStr));     // Catch: Throwable -> L11
        goto L19
    L15:
        metaCursor.close();
        return map;
    L11:
        th = move-exception;
        metaCursor.close();
        throw th;
    }

    boolean deleteMetaByAuthTypeAndUid(String type, int uid) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        if (db.delete(TABLE_META, "key=? AND value=?", new String[]{META_KEY_FOR_AUTHENTICATOR_UID_FOR_TYPE_PREFIX + type, String.valueOf(uid)}) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    List<Pair<String, Integer>> findAllAccountGrants() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor cursor = db.rawQuery(ACCOUNT_ACCESS_GRANTS, null);
        if (cursor == null) goto L14;
    L12:
        th = move-exception;
        if (cursor != null) goto L25;
    L23:
        throw th;
    L25:
        cursor.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    L5:
        if (cursor.moveToFirst() == false) goto L14;
        List<Pair<String, Integer>> results = new ArrayList();     // Catch: Throwable -> L12
    L8:
        String accountName = cursor.getString(0);     // Catch: Throwable -> L12
        int uid = cursor.getInt(1);     // Catch: Throwable -> L12
        results.add(Pair.create(accountName, Integer.valueOf(uid)));     // Catch: Throwable -> L12
        if (cursor.moveToNext() == true) goto L8;
        cursor.close();
        return results;
    L14:
        List<Pair<String, Integer>> r2 = Collections.emptyList();     // Catch: Throwable -> L12
        if (cursor == null) goto L17;
        cursor.close();
    L17:
        return r2;
    }

    List<Account> findCeAccountsNotInDe() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabaseUserIsUnlocked();
        Cursor cursor = db.rawQuery("SELECT name,type FROM ceDb.accounts WHERE NOT EXISTS  (SELECT _id FROM accounts WHERE _id=ceDb.accounts._id )", null);
        List<Account> accounts = new ArrayList(cursor.getCount());     // Catch: Throwable -> L8
    L5:
        if (cursor.moveToNext() == false) goto L10;
        String accountName = cursor.getString(0);     // Catch: Throwable -> L8
        String accountType = cursor.getString(1);     // Catch: Throwable -> L8
        accounts.add(new Account(accountName, accountType));     // Catch: Throwable -> L8
        goto L5
    L10:
        cursor.close();
        return accounts;
    L8:
        th = move-exception;
        cursor.close();
        throw th;
    }

    boolean deleteCeAccount(long accountId) {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabaseUserIsUnlocked();
        if (db.delete(CE_TABLE_ACCOUNTS, "_id=" + accountId, null) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isCeDatabaseAttached() {
        return DeDatabaseHelper.m942$$Nest$fgetmCeAttached(this.mDeDatabase);
    }

    void beginTransaction() {
        this.mDeDatabase.getWritableDatabase().beginTransaction();
    }

    void setTransactionSuccessful() {
        this.mDeDatabase.getWritableDatabase().setTransactionSuccessful();
    }

    void endTransaction() {
        this.mDeDatabase.getWritableDatabase().endTransaction();
    }

    void attachCeDatabase(File ceDbFile) {
        CeDatabaseHelper.create(this.mContext, this.mPreNDatabaseFile, ceDbFile);
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        db.execSQL("ATTACH DATABASE '" + ceDbFile.getPath() + "' AS ceDb");
        DeDatabaseHelper.m943$$Nest$fputmCeAttached(this.mDeDatabase, true);
    }

    long calculateDebugTableInsertionPoint() {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();     // Catch: SQLiteException -> L8
        String queryCountDebugDbRows = "SELECT COUNT(*) FROM " + TABLE_DEBUG;     // Catch: SQLiteException -> L8
        int size = (int) DatabaseUtils.longForQuery(db, queryCountDebugDbRows, null);     // Catch: SQLiteException -> L8
        if (size < 64) goto L5;
        String queryCountDebugDbRows2 = "SELECT " + DEBUG_TABLE_KEY + " FROM " + TABLE_DEBUG + " ORDER BY " + DEBUG_TABLE_TIMESTAMP + "," + DEBUG_TABLE_KEY + " LIMIT 1";     // Catch: SQLiteException -> L8
        return DatabaseUtils.longForQuery(db, queryCountDebugDbRows2, null);
    L5:
        return size;
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to open debug table" + e);
        return -1;
    }

    SQLiteStatement compileSqlStatementForLogging() {
        SQLiteDatabase db = this.mDeDatabase.getWritableDatabase();
        String sql = "INSERT OR REPLACE INTO " + TABLE_DEBUG + " VALUES (?,?,?,?,?,?)";
        return db.compileStatement(sql);
    }

    SQLiteStatement getStatementForLogging() {
        if (this.mDebugStatementForLogging != null) goto L5;
        this.mDebugStatementForLogging = compileSqlStatementForLogging();     // Catch: SQLiteException -> L8
        return this.mDebugStatementForLogging;
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to open debug table" + e);
        return null;
    L5:
        return this.mDebugStatementForLogging;
    }

    void closeDebugStatement() {
        Object r0 = this.mDebugStatementLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDebugStatementForLogging == null) goto L9;
        this.mDebugStatementForLogging.close();     // Catch: Throwable -> L7
        this.mDebugStatementForLogging = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    long reserveDebugDbInsertionPoint() {
        if (this.mDebugDbInsertionPoint != (-1)) goto L6;
        this.mDebugDbInsertionPoint = calculateDebugTableInsertionPoint();
        return this.mDebugDbInsertionPoint;
    L6:
        this.mDebugDbInsertionPoint = (this.mDebugDbInsertionPoint + 1) % 64;
        return this.mDebugDbInsertionPoint;
    }

    void dumpDebugTable(PrintWriter pw) {
        SQLiteDatabase db = this.mDeDatabase.getReadableDatabase();
        Cursor cursor = db.query(TABLE_DEBUG, null, null, null, null, null, DEBUG_TABLE_TIMESTAMP);
        pw.println("AccountId, Action_Type, timestamp, UID, TableName, Key");
        pw.println("Accounts History");
    L13:
    L7:
        th = move-exception;
        cursor.close();
        throw th;
    L4:
        if (cursor.moveToNext() == false) goto L9;
        pw.println(cursor.getString(0) + "," + cursor.getString(1) + "," + cursor.getString(2) + "," + cursor.getString(3) + "," + cursor.getString(4) + "," + cursor.getString(5));     // Catch: Throwable -> L7
        goto L13
    L9:
        cursor.close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.mDeDatabase.close();
    }

    static void deleteDbFileWarnIfFailed(File dbFile) {
        if (SQLiteDatabase.deleteDatabase(dbFile) == true) goto L6;
        Log.w(TAG, "Database at " + dbFile + " was not deleted successfully");
        return;
    }

    public static AccountsDb create(Context context, int userId, File preNDatabaseFile, File deDatabaseFile) {
        boolean newDbExists = deDatabaseFile.exists();
        DeDatabaseHelper deDatabaseHelper = new DeDatabaseHelper(context, userId, deDatabaseFile.getPath(), null);
        if (newDbExists == true) goto L8;
        if (preNDatabaseFile.exists() == false) goto L8;
        PreNDatabaseHelper preNDatabaseHelper = new PreNDatabaseHelper(context, userId, preNDatabaseFile.getPath());
        preNDatabaseHelper.getWritableDatabase();
        preNDatabaseHelper.close();
        DeDatabaseHelper.m944$$Nest$mmigratePreNDbToDe(deDatabaseHelper, preNDatabaseFile);
    L8:
        return new AccountsDb(deDatabaseHelper, context, preNDatabaseFile);
    }

    private static void resetDatabase(SQLiteDatabase db) {
        Cursor c = db.rawQuery("SELECT name FROM sqlite_master WHERE type ='table'", null);
    L37:
    L12:
        th = move-exception;
        if (c != null) goto L39;
    L34:
        throw th;
    L39:
        c.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.addSuppressed(th);
        goto L34
    L4:
        if (c.moveToNext() == false) goto L14;
        String name = c.getString(0);     // Catch: Throwable -> L12
        if ("android_metadata".equals(name) == true) goto L37;
        if ("sqlite_sequence".equals(name) == true) goto L37;
        db.execSQL("DROP TABLE IF EXISTS " + name);     // Catch: Throwable -> L12
        goto L37
    L14:
        c.close();
        Cursor c2 = db.rawQuery("SELECT name FROM sqlite_master WHERE type ='trigger'", null);
    L35:
    L19:
        th = move-exception;
        if (c2 != null) goto L41;
    L28:
        throw th;
    L41:
        c2.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    L16:
        if (c2.moveToNext() == false) goto L21;
        db.execSQL("DROP TRIGGER IF EXISTS " + c2.getString(0));     // Catch: Throwable -> L19
        goto L35
    L21:
        c2.close();
    }
}
