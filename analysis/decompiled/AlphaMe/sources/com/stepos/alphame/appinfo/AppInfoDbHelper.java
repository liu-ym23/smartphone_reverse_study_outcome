package com.stepos.alphame.appinfo;

import B0.g;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.BuildConfig;
import com.stepos.alphame.utils.AlphaMeException;
import com.stepos.alphame.utils.AlphaMeLogger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppInfoDbHelper extends SQLiteOpenHelper {
    public static final String COLUMN_ACTIVITY_NAME = "activityName";
    public static final String COLUMN_FCTIME = "fctime";
    public static final String COLUMN_FKEY = "fkey";
    public static final String COLUMN_FLEVEL1 = "flevel1";
    public static final String COLUMN_FLEVEL2 = "flevel2";
    public static final String COLUMN_FREMARK = "fremark";
    public static final String COLUMN_FUTIME = "futime";
    public static final String COLUMN_PERMISSIONID = "permissionId";
    public static final String COLUMN_PERMISSIONVALUE = "permissionValue";
    public static final String COLUMN_PKGNAME = "pkgName";
    public static final String COLUMN_U_APPNAME = "appName";
    public static final String COLUMN_U_CATEGORY = "category";
    public static final String COLUMN_U_PKGNAME = "pkgName";
    public static final String DATABASE_NAME = "appinfo.db";
    public static final String DATABASE_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/com.stepos.alphame/databases/";
    private static final int DATABASE_VERSION = 4;
    public static final String TABLE_ACTIVITIES = "activities";
    public static final String TABLE_APPS = "apps";
    public static final String TABLE_EXTRA_LIST = "extra_list";
    public static final String TABLE_UNBOUNDED_APPS = "unbounded_apps";
    public static final String TAG_ACTIVITY_NAME = "activityName";
    public static final String TAG_FCTIME = "fctime";
    public static final String TAG_FKEY = "fkey";
    public static final String TAG_FLEVEL1 = "flevel1";
    public static final String TAG_FLEVEL2 = "flevel2";
    public static final String TAG_FREMARK = "fremark";
    public static final String TAG_FUTIME = "futime";
    public static final String TAG_PACKAGE_NAME = "packetName";
    public static final String TAG_PERMISSION_ID = "permissionId";
    public static final String TAG_PERMISSION_VALUE = "permissionValue";
    public static final String TAG_U_APP_NAME = "appName";
    public static final String TAG_U_CATEGORY = "category";
    public static final String TAG_U_PACKAGE_NAME = "packageName";
    private static AppInfoDbHelper sInstance;
    private Context mContext;

    public class ActivityInfoInit {
        private final String ASSETS_NAME;

        public /* synthetic */ ActivityInfoInit(AppInfoDbHelper appInfoDbHelper, int i4) {
            this();
        }

        public void firstInit(SQLiteDatabase sQLiteDatabase) {
            AlphaMeLogger.dLog("ActivityInfoInit firstInit");
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AppInfoDbHelper.this.mContext.getAssets().open("activityinfo.dat")));
                    try {
                        ContentValues contentValues = new ContentValues();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            contentValues.put("activityName", jSONObject.getString("activityName"));
                            contentValues.put("pkgName", jSONObject.getString(AppInfoDbHelper.TAG_PACKAGE_NAME));
                            contentValues.put("permissionValue", Integer.valueOf(jSONObject.getString("permissionValue")));
                            contentValues.put("permissionId", Integer.valueOf(jSONObject.getString("permissionId")));
                            sQLiteDatabase.insert(AppInfoDbHelper.TABLE_ACTIVITIES, null, contentValues);
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        private ActivityInfoInit() {
            this.ASSETS_NAME = "activityinfo.dat";
        }
    }

    public class AppInfoInit {
        private final String ASSETS_NAME;

        public /* synthetic */ AppInfoInit(AppInfoDbHelper appInfoDbHelper, int i4) {
            this();
        }

        public void firstInit(SQLiteDatabase sQLiteDatabase) {
            BufferedReader bufferedReader;
            AlphaMeLogger.dLog("AppInfoInit firstInit");
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(AppInfoDbHelper.this.mContext.getAssets().open("appinfo.dat")));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        JSONObject jSONObject = new JSONObject(line);
                        contentValues.put("pkgName", jSONObject.getString(AppInfoDbHelper.TAG_PACKAGE_NAME));
                        contentValues.put("permissionValue", Integer.valueOf(jSONObject.getString("permissionValue")));
                        contentValues.put("permissionId", Integer.valueOf(jSONObject.getString("permissionId")));
                        sQLiteDatabase.insert("apps", null, contentValues);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }

        private AppInfoInit() {
            this.ASSETS_NAME = "appinfo.dat";
        }
    }

    public class ExtraListInit {
        private final String ASSETS_NAME;

        public /* synthetic */ ExtraListInit(AppInfoDbHelper appInfoDbHelper, int i4) {
            this();
        }

        public void firstInit(SQLiteDatabase sQLiteDatabase) {
            AlphaMeLogger.iLog("ExtraListInit firstInit");
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AppInfoDbHelper.this.mContext.getAssets().open("commomwhitelists.dat")));
                    try {
                        ContentValues contentValues = new ContentValues();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            contentValues.put("fkey", jSONObject.getString("fkey"));
                            contentValues.put("fremark", jSONObject.getString("fremark"));
                            contentValues.put("flevel1", Integer.valueOf(jSONObject.getString("flevel1")));
                            contentValues.put("flevel2", Integer.valueOf(jSONObject.getString("flevel2")));
                            contentValues.put("fctime", jSONObject.getString("fctime"));
                            contentValues.put("futime", jSONObject.getString("futime"));
                            sQLiteDatabase.insert(AppInfoDbHelper.TABLE_EXTRA_LIST, null, contentValues);
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        private ExtraListInit() {
            this.ASSETS_NAME = "commomwhitelists.dat";
        }
    }

    public class UnboundedAppsInit {
        private final String ASSETS_NAME;

        public /* synthetic */ UnboundedAppsInit(AppInfoDbHelper appInfoDbHelper, int i4) {
            this();
        }

        public void firstInit(SQLiteDatabase sQLiteDatabase) {
            AlphaMeLogger.dLog("UnboundedAppsInit firstInit");
            sQLiteDatabase.beginTransaction();
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(AppInfoDbHelper.this.mContext.getAssets().open("unbounded_list.dat")));
                    try {
                        ContentValues contentValues = new ContentValues();
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(line);
                            contentValues.put("pkgName", jSONObject.getString(AppInfoDbHelper.TAG_U_PACKAGE_NAME));
                            contentValues.put("appName", jSONObject.getString("appName"));
                            contentValues.put("category", jSONObject.getString("category"));
                            sQLiteDatabase.insert(AppInfoDbHelper.TABLE_UNBOUNDED_APPS, null, contentValues);
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        private UnboundedAppsInit() {
            this.ASSETS_NAME = "unbounded_list.dat";
        }
    }

    private AppInfoDbHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i4) {
        super(context, str, cursorFactory, i4);
        AlphaMeLogger.dLog("AppInfoDbHelper() version " + i4);
        this.mContext = context;
    }

    private void createTableActivities(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists activities(id integer primary key autoincrement, pkgName varchar(200), activityName varchar(200), permissionId integer not null default 0,permissionValue integer not null default 0)");
    }

    private void createTableApps(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists apps(id integer primary key autoincrement, pkgName varchar(200), permissionId integer not null default 0,permissionValue integer not null default 0)");
    }

    private void createTableExtraList(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists extra_list(id integer primary key autoincrement, fkey varchar(200), fremark varchar(200), flevel1 integer not null default 0,flevel2 integer not null default 0,fctime integer not null default 0,futime integer not null default 0)");
    }

    private void createTableUnboundedApps(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("create table if not exists unbounded_apps(id integer primary key autoincrement, pkgName varchar(200), appName varchar(200), category varchar(200) )");
    }

    private void deleteOldTables(SQLiteDatabase sQLiteDatabase, int i4) throws SQLException {
        if (i4 == 3) {
            sQLiteDatabase.execSQL("drop table if exists parking_apps");
            AlphaMeLogger.dLog("AppInfoDbHelper deleteOldTables parking_apps");
        }
    }

    public static synchronized AppInfoDbHelper getInstance() {
        try {
            AlphaMeLogger.dLog("AppInfoDbHelper getInstance");
            if (sInstance == null) {
                sInstance = new AppInfoDbHelper(ApplicationImpl.getApplication(), DATABASE_NAME, null, 4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private boolean isExistsActivityInfo(SQLiteDatabase sQLiteDatabase, String str, String str2, long j4, int i4) {
        boolean z4 = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(TABLE_ACTIVITIES, null, "pkgName=? AND activityName =? AND permissionId=? AND permissionValue=?", new String[]{str, str2, String.valueOf(j4), String.valueOf(i4)}, null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z4 = true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return z4;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private boolean isExistsAppInfo(SQLiteDatabase sQLiteDatabase, String str, long j4, int i4) {
        boolean z4 = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("apps", null, "pkgName=? AND permissionId=? AND permissionValue=?", new String[]{str, String.valueOf(j4), String.valueOf(i4)}, null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z4 = true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return z4;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private boolean isExistsExtra(SQLiteDatabase sQLiteDatabase, String str, String str2, long j4, int i4, long j5, long j6) {
        boolean z4 = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(TABLE_EXTRA_LIST, null, "fkey=? AND fremark =? AND flevel1=? AND flevel2=? AND fctime=? AND futime=?", new String[]{str, str2, String.valueOf(j4), String.valueOf(i4), String.valueOf(j5), String.valueOf(j6)}, null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z4 = true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return z4;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    private boolean isExistsUnboundedApp(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z4 = false;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query(TABLE_UNBOUNDED_APPS, null, "pkgName=?", new String[]{str}, null, null, null, null);
                if (cursorQuery != null) {
                    if (cursorQuery.getCount() > 0) {
                        z4 = true;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            return z4;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public void checkUpgrade() {
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                cursorRawQuery = writableDatabase.rawQuery("SELECT * FROM sqlite_master WHERE type='table' AND name='extra_list'", null);
                if (cursorRawQuery.getCount() == 0) {
                    createTableExtraList(writableDatabase);
                    new ExtraListInit(this, 0).firstInit(writableDatabase);
                }
            } catch (Exception e4) {
                AlphaMeLogger.exceptionLog("checkUpgrade error", e4);
                if (cursorRawQuery == null) {
                    return;
                }
            }
            cursorRawQuery.close();
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public void clearActivityInfo(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("delete from activities");
    }

    public void clearAppInfo(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("delete from apps");
    }

    public void clearExtra(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("delete from extra_list");
    }

    public void clearUnboundedApps(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("delete from unbounded_apps");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        if (BuildConfig.DEBUG) {
            throw new AlphaMeException(" do not close the db !!! -- by lsn");
        }
        AlphaMeLogger.wLog("do  not close the db.");
        super.close();
    }

    public void delete(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
        sQLiteDatabase.execSQL("delete from apps where pkgName='" + str + "'");
    }

    public void dump() throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("apps", null, null, null, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            e = e4;
        }
        try {
            cursorQuery.moveToFirst();
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(cursorQuery.getString(cursorQuery.getColumnIndex("pkgName")) + ", " + cursorQuery.getString(cursorQuery.getColumnIndex("permissionId")) + ", " + cursorQuery.getString(cursorQuery.getColumnIndex("permissionValue")) + "\n");
            } while (cursorQuery.moveToNext());
            AlphaMeLogger.writeToFile(null, "AppInfoDbHelper", sb.toString());
            cursorQuery.close();
        } catch (Exception e5) {
            e = e5;
            cursor = cursorQuery;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public void insert(SQLiteDatabase sQLiteDatabase, String str, long j4, int i4, boolean z4) throws SQLException {
        if (z4 && isExistsAppInfo(sQLiteDatabase, str, j4, i4)) {
            return;
        }
        sQLiteDatabase.execSQL("insert into apps(pkgName,permissionId,permissionValue) values('" + str + "'," + j4 + "," + i4 + ")");
    }

    public void insertActivity(SQLiteDatabase sQLiteDatabase, String str, String str2, long j4, int i4, boolean z4) throws SQLException {
        if (z4 && isExistsActivityInfo(sQLiteDatabase, str, str2, j4, i4)) {
            return;
        }
        StringBuilder sbX = g.x("insert into activities(pkgName,activityName,permissionId,permissionValue) values('", str, "','", str2, "',");
        sbX.append(j4);
        sbX.append(",");
        sbX.append(i4);
        sbX.append(")");
        sQLiteDatabase.execSQL(sbX.toString());
    }

    public void insertExtra(SQLiteDatabase sQLiteDatabase, String str, String str2, long j4, int i4, long j5, long j6, boolean z4) throws SQLException {
        if (z4 && isExistsExtra(sQLiteDatabase, str, str2, j4, i4, j5, j6)) {
            return;
        }
        StringBuilder sbX = g.x("insert into extra_list(fkey, fremark, flevel1, flevel2, fctime, futime) values('", str, "','", str2, "',");
        sbX.append(j4);
        sbX.append(",");
        sbX.append(i4);
        sbX.append(",");
        sbX.append(j5);
        sbX.append(",");
        sbX.append(j6);
        sbX.append(")");
        sQLiteDatabase.execSQL(sbX.toString());
    }

    public void insertOrUpdateUnboundedApp(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, boolean z4) {
        ContentValues contentValues = new ContentValues();
        if (isExistsUnboundedApp(sQLiteDatabase, str)) {
            contentValues.put("appName", str2);
            contentValues.put("category", str3);
            sQLiteDatabase.update(TABLE_UNBOUNDED_APPS, contentValues, "pkgName=?", new String[]{str});
        } else {
            contentValues.put("pkgName", str);
            contentValues.put("appName", str2);
            contentValues.put("category", str3);
            sQLiteDatabase.insertWithOnConflict(TABLE_UNBOUNDED_APPS, null, contentValues, 5);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        AlphaMeLogger.dLog("AppInfoDbHelper onCreate");
        createTableApps(sQLiteDatabase);
        createTableActivities(sQLiteDatabase);
        createTableExtraList(sQLiteDatabase);
        int i4 = 0;
        new AppInfoInit(this, i4).firstInit(sQLiteDatabase);
        new ActivityInfoInit(this, i4).firstInit(sQLiteDatabase);
        new ExtraListInit(this, i4).firstInit(sQLiteDatabase);
        createTableUnboundedApps(sQLiteDatabase);
        new UnboundedAppsInit(this, i4).firstInit(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) throws SQLException {
        AlphaMeLogger.dLog("AppInfoDbHelper getInstance " + i4 + " to " + i5);
        int i6 = 0;
        if (i4 == 1) {
            createTableActivities(sQLiteDatabase);
            new ActivityInfoInit(this, i6).firstInit(sQLiteDatabase);
        } else if (i4 == 3) {
            deleteOldTables(sQLiteDatabase, i4);
        }
        if (i4 < 4) {
            createTableUnboundedApps(sQLiteDatabase);
            new UnboundedAppsInit(this, i6).firstInit(sQLiteDatabase);
        }
    }

    public ArrayList<String> query(int i4, int i5) {
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("apps", new String[]{"pkgName"}, "permissionId=? and permissionValue=?", new String[]{String.valueOf(i4), String.valueOf(i5)}, null, null, null);
                if (cursorQuery.getCount() > 0) {
                    cursorQuery.moveToFirst();
                    do {
                        arrayList.add(cursorQuery.getString(0));
                    } while (cursorQuery.moveToNext());
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (cursorQuery != null) {
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
