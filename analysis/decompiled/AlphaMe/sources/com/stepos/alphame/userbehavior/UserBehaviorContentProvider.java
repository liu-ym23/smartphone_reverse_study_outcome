package com.stepos.alphame.userbehavior;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.AbstractC0351g;
import com.baidu.mapapi.http.HttpClient;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.StringUtil;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* loaded from: classes.dex */
public class UserBehaviorContentProvider extends ContentProvider {
    private static final String AUTHORITY = "com.stepos.alphame.behavior.provider";
    private Database mDatabase;
    public static final Uri URI_TODAY_SIMPLE = Uri.parse("content://com.stepos.alphame.behavior.provider/today_simple");
    public static final Uri URI_TODAY_SIMPLE_ALL = Uri.parse("content://com.stepos.alphame.behavior.provider/today_simple_all");
    public static final Uri URI_TODAY_HOURS = Uri.parse("content://com.stepos.alphame.behavior.provider/today_hours");
    public static final Uri URI_TODAY_HOURS_ALL = Uri.parse("content://com.stepos.alphame.behavior.provider/today_hours_all");
    public static final Uri URI_DAYS = Uri.parse("content://com.stepos.alphame.behavior.provider/days");
    private static final String[] TODAY_COLUMNS = {UserBehaviorStorable.COLUMN_TOTAL_USED_TIME, UserBehaviorStorable.COLUMN_TOP_USED_TIME, UserBehaviorStorable.COLUMN_SCREEN_ON_TIMES, UserBehaviorStorable.COLUMN_NOTIFICATIONS, UserBehaviorStorable.COLUMN_APP_DETAILS};

    private void ensureReadyForQuery(Uri uri) throws InterruptedException {
        ApplicationImpl application = ApplicationImpl.getApplication();
        if (application != null) {
            application.waitInitializedDone(Binder.getCallingPid());
            application.ensureUserBehaviorInitialized();
        } else {
            UserBehaviorDataSource.getInstance().ensureInitialized();
        }
        UserBehaviorDataSource userBehaviorDataSource = UserBehaviorDataSource.getInstance();
        Log.i("UserBehavior", "query uri=" + uri + ", mInited=" + userBehaviorDataSource.isInited() + ", mCurrApp=" + userBehaviorDataSource.getCurrentAppPkgName() + ", cacheSize=" + userBehaviorDataSource.getCacheSize());
    }

    private static Cursor fillTodayCursor(MatrixCursor matrixCursor, Statistics statistics) {
        if (statistics != null) {
            matrixCursor.addRow(new Object[]{Long.valueOf(statistics.totalUsed), Long.valueOf(statistics.topUseTime), Integer.valueOf(statistics.screenOnTimes), Integer.valueOf(statistics.notifications), statistics.appDetail});
            return matrixCursor;
        }
        Log.i("UserBehavior", "statistics null, return empty row");
        matrixCursor.addRow(new Object[]{0L, 0L, 0, 0, null});
        return matrixCursor;
    }

    private Database getDatabase() {
        if (this.mDatabase == null) {
            this.mDatabase = Database.getInstance();
        }
        return this.mDatabase;
    }

    public static Cursor getTodayHours(boolean z4) {
        Log.i("UserBehavior", "getTodayHours iconRequired=" + z4);
        AlphaMeLogger.iLog("UserBehavior", "getTodayHours " + z4);
        return fillTodayCursor(newTodayCursor(), UserBehaviorDataSource.getInstance().getHoursStatistics(z4));
    }

    public static Cursor getTodaySimple(boolean z4) {
        Log.i("UserBehavior", "getTodaySimple iconRequired=" + z4);
        AlphaMeLogger.iLog("UserBehavior", "getTodaySimple " + z4);
        return fillTodayCursor(newTodayCursor(), UserBehaviorDataSource.getInstance().getTodayStatistics(z4));
    }

    private static MatrixCursor newTodayCursor() {
        return new MatrixCursor(TODAY_COLUMNS);
    }

    public static void notifyTodayDataChanged(@Nullable Context context) {
        if (context == null) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        contentResolver.notifyChange(URI_TODAY_SIMPLE, null);
        contentResolver.notifyChange(URI_TODAY_SIMPLE_ALL, null);
        contentResolver.notifyChange(URI_TODAY_HOURS, null);
        contentResolver.notifyChange(URI_TODAY_HOURS_ALL, null);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        SQLiteDatabase db;
        if (!URI_DAYS.equals(uri) || (db = getDatabase().getDb()) == null) {
            return 0;
        }
        return db.delete(UserBehaviorStorable.TABLE_NAME, (String) null, (String[]) null);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) throws InterruptedException {
        if (URI_TODAY_SIMPLE.equals(uri)) {
            ensureReadyForQuery(uri);
            return getTodaySimple(true);
        }
        if (URI_TODAY_SIMPLE_ALL.equals(uri)) {
            ensureReadyForQuery(uri);
            return getTodaySimple(false);
        }
        if (URI_TODAY_HOURS.equals(uri)) {
            ensureReadyForQuery(uri);
            return getTodayHours(true);
        }
        if (URI_TODAY_HOURS_ALL.equals(uri)) {
            ensureReadyForQuery(uri);
            return getTodayHours(false);
        }
        if (!URI_DAYS.equals(uri)) {
            return null;
        }
        ensureReadyForQuery(uri);
        String dateFull = HttpClient.ENDFLAG;
        if (strArr2 != null) {
            try {
                AlphaMeLogger.debugLog("UserBehavior", "length " + strArr2.length);
                if (strArr2.length == 1) {
                    dateFull = StringUtil.formatDateFull(Long.parseLong(strArr2[0]));
                    AlphaMeLogger.debugLog("UserBehavior", "selectionArg " + dateFull);
                }
            } catch (Exception unused) {
            }
        }
        StringBuilder sb = new StringBuilder("projection ");
        sb.append(strArr);
        AbstractC0351g.C(sb, " selection ", str, " selectionArgs ", dateFull);
        sb.append(" sortOrder ");
        sb.append(str2);
        AlphaMeLogger.iLog("UserBehavior", sb.toString());
        SQLiteDatabase db = getDatabase().getDb();
        if (db != null) {
            return db.query(UserBehaviorStorable.TABLE_NAME, strArr, str, strArr2, null, null, str2);
        }
        if (strArr == null) {
            strArr = TODAY_COLUMNS;
        }
        return new MatrixCursor(strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
