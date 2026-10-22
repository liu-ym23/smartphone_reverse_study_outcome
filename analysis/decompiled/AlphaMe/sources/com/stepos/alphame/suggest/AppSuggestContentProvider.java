package com.stepos.alphame.suggest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.data.DataSource;
import com.stepos.alphame.data.DataSourceManager;
import com.stepos.alphame.database.Database;
import com.stepos.alphame.reflect.UserHandle;
import com.stepos.alphame.utils.AlphaMeLogger;

/* loaded from: classes.dex */
public class AppSuggestContentProvider extends ContentProvider {
    private static final String AUTHORITY = "com.stepos.alphame.suggest.provider";
    private static final String PERMISSION_USER_BEHAVIOR = "stepos.alphame.USER_BEHAVIOR";
    private static final String TAG = "AppSuggestContentProvider";
    public static final Uri URI_APP_SUGGEST = Uri.parse("content://com.stepos.alphame.suggest.provider/app_suggest_event");
    public static final Uri URI_APP_EVENT = Uri.parse("content://com.stepos.alphame.provider/app_suggest_event");

    private void enforceCaller(String str) {
        int callingUid = Binder.getCallingUid();
        if (callingUid == Process.myUid()) {
            return;
        }
        if (UserHandle.getUserId(callingUid) != UserHandle.myUserId()) {
            throw new SecurityException("AppSuggest " + str + " cross-user denied, uid=" + callingUid);
        }
        if (UserHandle.isCore(callingUid)) {
            return;
        }
        Context context = getContext();
        if (context == null) {
            throw new SecurityException("AppSuggest " + str + " denied, context not ready, uid=" + callingUid);
        }
        if (context.getPackageManager().checkSignatures(Process.myUid(), callingUid) == 0 || context.checkCallingPermission(PERMISSION_USER_BEHAVIOR) == 0) {
            return;
        }
        String str2 = "AppSuggest " + str + " denied, uid=" + callingUid + ", pid=" + Binder.getCallingPid();
        AlphaMeLogger.eLog(str2);
        throw new SecurityException(str2);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
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
        AlphaMeLogger.debugLog(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        AlphaMeLogger.debugLog(TAG, "query uri " + uri);
        enforceCaller("query");
        try {
            if (!URI_APP_SUGGEST.equals(uri)) {
                return null;
            }
            DataSource dataSource = DataSourceManager.getInstance().getDataSource(AppSuggestReport.TAG);
            if (dataSource instanceof AppSuggestDataSource) {
                ((AppSuggestDataSource) dataSource).execSave("provider");
            }
            return Database.getInstance().query(URI_APP_EVENT, strArr, str, strArr2, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        AlphaMeLogger.debugLog(TAG, "update uri " + uri);
        enforceCaller("update");
        if (!URI_APP_SUGGEST.equals(uri)) {
            return 0;
        }
        ContentValues contentValues2 = new ContentValues();
        if (contentValues != null && contentValues.containsKey(AppSuggestStorable.COLUMN_REPORTED)) {
            contentValues2.put(AppSuggestStorable.COLUMN_REPORTED, contentValues.getAsInteger(AppSuggestStorable.COLUMN_REPORTED));
        }
        if (contentValues2.size() != 0) {
            return Database.getInstance().update(URI_APP_EVENT, contentValues2, str, strArr);
        }
        AlphaMeLogger.eLog("AppSuggest update rejected, no updatable column in " + contentValues);
        return 0;
    }
}
