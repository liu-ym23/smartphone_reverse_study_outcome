package com.stepos.pps.data.ouc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.stepos.pps.data.util.Constants;
import com.stepos.pps.data.util.LogUtil;
import com.stepos.pps.data.util.Utils;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class ErrorDatabaseHelper {
    private static final String CELL_ID = "cell_id";
    private static final String CPU_USAGE = "cpu_usage";
    private static final String CREATE_ERROR_TABLE = "CREATE TABLE IF NOT EXISTS app_error_info (_id INTEGER DEFAULT '1' NOT NULL PRIMARY KEY AUTOINCREMENT,uuid TEXT NOT NULL UNIQUE,type TEXT,package_name TEXT NOT NULL,version INTEGER,process_name TEXT,time LONG,error_tag TEXT,error_tag_sign TEXT,dump_file TEXT,dump_sign TEXT,network TEXT,ip TEXT,dns TEXT,cell_id TEXT,location TEXT,cpu_usage TEXT,mem_usage TEXT,ext_file TEXT,ext_sign TEXT,stepos_version TEXT,stepos_inside_id TEXT,package_ver_name TEXT,exp_log_id TEXT,version_type TEXT);";
    private static final String DATABASE_NAME = "ouc_report_v3.db";
    private static final int DATABASE_VERSION = 3;
    private static final String DNS = "dns";
    private static final String DUMP_FILE = "dump_file";
    private static final String DUMP_SIGN = "dump_sign";
    private static final String ERROR_TAG = "error_tag";
    private static final String ERROR_TAG_SIGN = "error_tag_sign";
    private static final String EXP_LOG_ID = "exp_log_id";
    private static final String EXT_FILE = "ext_file";
    private static final String EXT_SIGN = "ext_sign";
    private static final String IP = "ip";
    private static final String LOCATION = "location";
    private static final String MEM_USAGE = "mem_usage";
    private static final String NETWORK = "network";
    private static final String OLD_DATABASE_NAME_V1 = "ouc_report.db";
    private static final String OLD_DATABASE_NAME_V2 = "ouc_report_v2.db";
    private static final String PACKAGE_NAME = "package_name";
    private static final String PACKAGE_VERSION_NAME = "package_ver_name";
    private static final String PROCESS_NAME = "process_name";
    private static final String STEPOS_INSIDE_ID = "stepos_inside_id";
    private static final String STEPOS_VERSION = "stepos_version";
    private static final String TABLE_APP_ERROR_INFO = "app_error_info";
    private static final String TIME = "time";
    private static final String TYPE = "type";
    private static final String UUID = "uuid";
    private static final String VERSION = "version";
    private static final String VERSION_TYPE = "version_type";
    private static final String _ID = "_id";
    private static Object sLock = new Object();
    private static volatile ErrorDatabaseHelper sOLogDatabaseHelper;
    private final String TAG = "PPS:ErrorDatabaseHelper";
    private Context mContext;
    private DatabaseHelper mDatabaseHelper;

    private static final class DatabaseHelper extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        DatabaseHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL(ErrorDatabaseHelper.CREATE_ERROR_TABLE);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
            if (i < 2) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE app_error_info ADD COLUMN exp_log_id TEXT;");
                } catch (Exception unused) {
                }
            }
            if (i < 3) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE app_error_info ADD COLUMN version_type TEXT;");
                } catch (Exception unused2) {
                }
            }
        }
    }

    private ErrorDatabaseHelper(Context context) {
        this.mContext = context;
        this.mDatabaseHelper = new DatabaseHelper(this.mContext, DATABASE_NAME, null, 3);
    }

    public static ErrorDatabaseHelper getInstance(Context context) {
        if (sOLogDatabaseHelper == null) {
            synchronized (sLock) {
                if (sOLogDatabaseHelper == null) {
                    sOLogDatabaseHelper = new ErrorDatabaseHelper(context);
                }
            }
        }
        return sOLogDatabaseHelper;
    }

    void insertErrorInfo(ErrorInfo errorInfo) {
        SQLiteDatabase writableDatabase;
        if (errorInfo == null || (writableDatabase = this.mDatabaseHelper.getWritableDatabase()) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(UUID, errorInfo.uuid);
        contentValues.put(TYPE, errorInfo.type);
        contentValues.put(PACKAGE_NAME, errorInfo.packageName);
        contentValues.put(VERSION, Integer.valueOf(errorInfo.version));
        contentValues.put(PROCESS_NAME, errorInfo.processName);
        contentValues.put(TIME, Long.valueOf(errorInfo.time));
        contentValues.put(ERROR_TAG, errorInfo.tag);
        contentValues.put(ERROR_TAG_SIGN, errorInfo.tagSign);
        contentValues.put(DUMP_SIGN, errorInfo.dumpSign);
        contentValues.put(DUMP_FILE, errorInfo.dumpFile == null ? null : errorInfo.dumpFile.getAbsolutePath());
        contentValues.put(NETWORK, errorInfo.network);
        contentValues.put(IP, errorInfo.ip);
        contentValues.put(DNS, errorInfo.dns);
        contentValues.put(CELL_ID, errorInfo.cellId);
        contentValues.put(LOCATION, errorInfo.location);
        contentValues.put(CPU_USAGE, errorInfo.cpuUsage);
        contentValues.put(MEM_USAGE, errorInfo.memUsage);
        contentValues.put(EXT_FILE, errorInfo.extFile == null ? null : errorInfo.extFile.getAbsolutePath());
        contentValues.put(EXT_SIGN, errorInfo.extFileSign);
        contentValues.put(STEPOS_VERSION, errorInfo.steposVersion);
        contentValues.put(STEPOS_INSIDE_ID, errorInfo.steposInsideId);
        contentValues.put(PACKAGE_VERSION_NAME, errorInfo.versionName);
        contentValues.put(EXP_LOG_ID, errorInfo.expLogId);
        contentValues.put(VERSION_TYPE, errorInfo.versionType);
        writableDatabase.insert(TABLE_APP_ERROR_INFO, null, contentValues);
    }

    Cursor getErrors(int i) {
        SQLiteDatabase readableDatabase = this.mDatabaseHelper.getReadableDatabase();
        if (readableDatabase == null) {
            return null;
        }
        if (i > 0) {
            return readableDatabase.query(TABLE_APP_ERROR_INFO, null, null, null, null, null, "time ASC", "" + i);
        }
        return readableDatabase.query(TABLE_APP_ERROR_INFO, null, null, null, null, null, "time ASC");
    }

    Cursor getErrorByPackageName(String str) {
        SQLiteDatabase readableDatabase = this.mDatabaseHelper.getReadableDatabase();
        if (readableDatabase == null) {
            return null;
        }
        return readableDatabase.query(TABLE_APP_ERROR_INFO, null, "package_name=?", new String[]{str}, null, null, "time DESC");
    }

    String getErrorTag(String str) throws IOException {
        SQLiteDatabase readableDatabase;
        Throwable th;
        Cursor cursorQuery;
        String string = null;
        if (!TextUtils.isEmpty(str) && (readableDatabase = this.mDatabaseHelper.getReadableDatabase()) != null) {
            try {
                cursorQuery = readableDatabase.query(TABLE_APP_ERROR_INFO, new String[]{ERROR_TAG}, "uuid=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToNext()) {
                            string = cursorQuery.getString(0);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                            return null;
                        } finally {
                            Utils.closeQuietly(cursorQuery);
                        }
                    }
                }
                return string;
            } catch (Throwable th3) {
                th = th3;
                cursorQuery = null;
            }
        }
        return null;
    }

    int deleteErrorInfo(String str) {
        SQLiteDatabase writableDatabase;
        if (TextUtils.isEmpty(str) || (writableDatabase = this.mDatabaseHelper.getWritableDatabase()) == null) {
            return 0;
        }
        return writableDatabase.delete(TABLE_APP_ERROR_INFO, "uuid=?", new String[]{str});
    }

    boolean isErrorInfoExists(String str, int i, String str2) throws IOException {
        SQLiteDatabase readableDatabase;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (readableDatabase = this.mDatabaseHelper.getReadableDatabase()) != null) {
            Cursor cursorQuery = null;
            try {
                cursorQuery = readableDatabase.query(TABLE_APP_ERROR_INFO, new String[]{_ID}, "package_name=? AND version=? AND error_tag_sign=?", new String[]{str, String.valueOf(i), str2}, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z = true;
                    }
                }
                return z;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    Utils.closeQuietly(cursorQuery);
                }
            }
        }
        return false;
    }

    boolean isErrorInfoExists(String str) throws IOException {
        SQLiteDatabase readableDatabase;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && (readableDatabase = this.mDatabaseHelper.getReadableDatabase()) != null) {
            Cursor cursorQuery = null;
            try {
                cursorQuery = readableDatabase.query(TABLE_APP_ERROR_INFO, new String[]{_ID}, "uuid=?", new String[]{str}, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z = true;
                    }
                }
                return z;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    Utils.closeQuietly(cursorQuery);
                }
            }
        }
        return false;
    }

    boolean isDumpFileAvailable(String str) throws IOException {
        SQLiteDatabase readableDatabase;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && (readableDatabase = this.mDatabaseHelper.getReadableDatabase()) != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = readableDatabase.rawQuery("select count(*) from app_error_info where dump_file=?", new String[]{str});
                if (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    if (cursorRawQuery.getLong(0) > 0) {
                        z = true;
                    }
                }
                return z;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    Utils.closeQuietly(cursorRawQuery);
                }
            }
        }
        return false;
    }

    boolean isExtFileAvailable(String str) throws IOException {
        SQLiteDatabase readableDatabase;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && (readableDatabase = this.mDatabaseHelper.getReadableDatabase()) != null) {
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = readableDatabase.rawQuery("select count(*) from app_error_info where ext_file=?", new String[]{str});
                if (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    if (cursorRawQuery.getLong(0) > 0) {
                        z = true;
                    }
                }
                return z;
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } finally {
                    Utils.closeQuietly(cursorRawQuery);
                }
            }
        }
        return false;
    }

    void updateSystemRestartErrorInfo(ErrorInfo errorInfo) {
        SQLiteDatabase writableDatabase;
        if (errorInfo == null || (writableDatabase = this.mDatabaseHelper.getWritableDatabase()) == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(TYPE, errorInfo.type);
        contentValues.put(EXT_FILE, errorInfo.extFile == null ? null : errorInfo.extFile.getAbsolutePath());
        contentValues.put(EXT_SIGN, errorInfo.extFileSign);
        writableDatabase.update(TABLE_APP_ERROR_INFO, contentValues, "uuid=?", new String[]{errorInfo.uuid});
    }

    int delErrorInfoByExtFile(String str) {
        SQLiteDatabase writableDatabase;
        if (TextUtils.isEmpty(str) || (writableDatabase = this.mDatabaseHelper.getWritableDatabase()) == null) {
            return 0;
        }
        return writableDatabase.delete(TABLE_APP_ERROR_INFO, "ext_file=?", new String[]{str});
    }

    void clearOldData() throws IOException, SQLException {
        Cursor errors;
        SQLiteDatabase writableDatabase = this.mDatabaseHelper.getWritableDatabase();
        if (writableDatabase == null) {
            return;
        }
        writableDatabase.execSQL("delete from app_error_info where _id not in ( select _id from app_error_info order by time desc limit 100)");
        long jCurrentTimeMillis = System.currentTimeMillis() - 604800000;
        try {
            errors = getErrors(-1);
            if (errors != null) {
                while (errors.moveToNext()) {
                    try {
                        ErrorInfo errorInfoCreateErrorInfo = createErrorInfo(errors);
                        if (errorInfoCreateErrorInfo.time >= jCurrentTimeMillis) {
                            break;
                        }
                        LogUtil.d("PPS:ErrorDatabaseHelper", "clear crash old, uuid=" + errorInfoCreateErrorInfo.uuid);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("age_days", (System.currentTimeMillis() - errorInfoCreateErrorInfo.time) / Constants.CLEAN_CHECK_INTERVAL);
                        } catch (Throwable unused) {
                        }
                        EmsLogDropReporter.report(this.mContext, 3, 308, errorInfoCreateErrorInfo, jSONObject);
                        deleteErrorInfo(errorInfoCreateErrorInfo.uuid);
                        errorInfoCreateErrorInfo.deleteFile();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                        } finally {
                            Utils.closeQuietly(errors);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            errors = null;
        }
    }

    static ErrorInfo createErrorInfo(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ErrorInfo errorInfo = new ErrorInfo();
        int columnIndex = cursor.getColumnIndex(UUID);
        if (columnIndex >= 0) {
            errorInfo.uuid = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex(TYPE);
        if (columnIndex2 >= 0) {
            errorInfo.type = cursor.getString(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex(PACKAGE_NAME);
        if (columnIndex3 >= 0) {
            errorInfo.packageName = cursor.getString(columnIndex3);
        }
        int columnIndex4 = cursor.getColumnIndex(VERSION);
        if (columnIndex4 >= 0) {
            errorInfo.version = cursor.getInt(columnIndex4);
        }
        int columnIndex5 = cursor.getColumnIndex(PROCESS_NAME);
        if (columnIndex5 >= 0) {
            errorInfo.processName = cursor.getString(columnIndex5);
        }
        int columnIndex6 = cursor.getColumnIndex(TIME);
        if (columnIndex6 >= 0) {
            errorInfo.time = cursor.getLong(columnIndex6);
        }
        int columnIndex7 = cursor.getColumnIndex(ERROR_TAG);
        if (columnIndex7 >= 0) {
            errorInfo.tag = cursor.getString(columnIndex7);
        }
        int columnIndex8 = cursor.getColumnIndex(ERROR_TAG_SIGN);
        if (columnIndex8 >= 0) {
            errorInfo.tagSign = cursor.getString(columnIndex8);
        }
        int columnIndex9 = cursor.getColumnIndex(DUMP_SIGN);
        if (columnIndex9 >= 0) {
            errorInfo.dumpSign = cursor.getString(columnIndex9);
        }
        int columnIndex10 = cursor.getColumnIndex(DUMP_FILE);
        if (columnIndex10 >= 0) {
            String string = cursor.getString(columnIndex10);
            errorInfo.dumpFile = TextUtils.isEmpty(string) ? null : new File(string);
        }
        int columnIndex11 = cursor.getColumnIndex(NETWORK);
        if (columnIndex11 >= 0) {
            errorInfo.network = cursor.getString(columnIndex11);
        }
        int columnIndex12 = cursor.getColumnIndex(IP);
        if (columnIndex12 >= 0) {
            errorInfo.ip = cursor.getString(columnIndex12);
        }
        int columnIndex13 = cursor.getColumnIndex(DNS);
        if (columnIndex13 >= 0) {
            errorInfo.dns = cursor.getString(columnIndex13);
        }
        int columnIndex14 = cursor.getColumnIndex(CELL_ID);
        if (columnIndex14 >= 0) {
            errorInfo.cellId = cursor.getString(columnIndex14);
        }
        int columnIndex15 = cursor.getColumnIndex(LOCATION);
        if (columnIndex15 >= 0) {
            errorInfo.location = cursor.getString(columnIndex15);
        }
        int columnIndex16 = cursor.getColumnIndex(CPU_USAGE);
        if (columnIndex16 >= 0) {
            errorInfo.cpuUsage = cursor.getString(columnIndex16);
        }
        int columnIndex17 = cursor.getColumnIndex(MEM_USAGE);
        if (columnIndex17 >= 0) {
            errorInfo.memUsage = cursor.getString(columnIndex17);
        }
        int columnIndex18 = cursor.getColumnIndex(EXT_SIGN);
        if (columnIndex18 >= 0) {
            errorInfo.extFileSign = cursor.getString(columnIndex18);
        }
        int columnIndex19 = cursor.getColumnIndex(EXP_LOG_ID);
        if (columnIndex19 >= 0) {
            errorInfo.expLogId = cursor.getString(columnIndex19);
        }
        int columnIndex20 = cursor.getColumnIndex(VERSION_TYPE);
        if (columnIndex20 >= 0) {
            errorInfo.versionType = cursor.getString(columnIndex20);
        }
        int columnIndex21 = cursor.getColumnIndex(EXT_FILE);
        if (columnIndex21 >= 0) {
            String string2 = cursor.getString(columnIndex21);
            errorInfo.extFile = TextUtils.isEmpty(string2) ? null : new File(string2);
        }
        int columnIndex22 = cursor.getColumnIndex(STEPOS_VERSION);
        if (columnIndex22 >= 0) {
            errorInfo.steposVersion = cursor.getString(columnIndex22);
        }
        int columnIndex23 = cursor.getColumnIndex(STEPOS_INSIDE_ID);
        if (columnIndex23 >= 0) {
            errorInfo.steposInsideId = cursor.getString(columnIndex23);
        }
        int columnIndex24 = cursor.getColumnIndex(PACKAGE_VERSION_NAME);
        if (columnIndex24 >= 0) {
            errorInfo.versionName = cursor.getString(columnIndex24);
        }
        return errorInfo;
    }

    public void checkAndCleanOldDatabase() {
        if (this.mContext != null) {
            deleteDatabaseByName(OLD_DATABASE_NAME_V1);
            deleteDatabaseByName("ouc_report.db-journal");
            deleteDatabaseByName(OLD_DATABASE_NAME_V2);
            deleteDatabaseByName("ouc_report_v2.db-journal");
        }
    }

    private void deleteDatabaseByName(String str) {
        File databasePath = this.mContext.getDatabasePath(str);
        if (databasePath.exists()) {
            if (databasePath.delete()) {
                LogUtil.i("PPS:ErrorDatabaseHelper", "Delete old database success, " + str);
            } else {
                LogUtil.w("PPS:ErrorDatabaseHelper", "Delete old database failed, " + str);
            }
        }
    }
}
