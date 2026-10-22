package com.stepos.alphame.appinfo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.stepos.alphame.ApplicationImpl;

/* loaded from: classes.dex */
public class AlphaMeContentProvider extends ContentProvider {
    private static final String ATHORITY = "com.stepos.alphame.sceneupdate.provider";
    private static final int CODE_ACTIVITIES = 2;
    private static final int CODE_EXTRA = 3;
    private static final int CODE_GAMEMODELIST = 1;
    private static final int CODE_UNBOUNDED_APP = 4;
    private static final boolean DEBUG = true;
    private static final UriMatcher MATCHER;
    private static final String TAG = "AphaMeContentProvider";
    private AppInfoDbHelper mDatabase;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        MATCHER = uriMatcher;
        uriMatcher.addURI(ATHORITY, "apps", 1);
        uriMatcher.addURI(ATHORITY, AppInfoDbHelper.TABLE_ACTIVITIES, 2);
        uriMatcher.addURI(ATHORITY, AppInfoDbHelper.TABLE_EXTRA_LIST, 3);
        uriMatcher.addURI(ATHORITY, AppInfoDbHelper.TABLE_UNBOUNDED_APPS, 4);
    }

    private AppInfoDbHelper getDatabase() {
        if (this.mDatabase == null) {
            this.mDatabase = AppInfoDbHelper.getInstance();
        }
        return this.mDatabase;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Log.d(TAG, "delete");
        MATCHER.match(uri);
        Log.w(TAG, "Unkown uri", new IllegalArgumentException("Unkown uri:" + uri));
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(Uri uri) {
        Log.d(TAG, "getType");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.d(TAG, "insert");
        MATCHER.match(uri);
        Log.w(TAG, "Unkown uri", new IllegalArgumentException("Unkown uri:" + uri));
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.d(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Log.d(TAG, "query");
        if (ApplicationImpl.isBootFailed()) {
            return null;
        }
        SQLiteDatabase readableDatabase = getDatabase().getReadableDatabase();
        int iMatch = MATCHER.match(uri);
        if (iMatch == 1) {
            return readableDatabase.query("apps", strArr, str, strArr2, null, null, str2);
        }
        if (iMatch == 2) {
            return readableDatabase.query(AppInfoDbHelper.TABLE_ACTIVITIES, strArr, str, strArr2, null, null, str2);
        }
        if (iMatch == 3) {
            return readableDatabase.query(AppInfoDbHelper.TABLE_EXTRA_LIST, strArr, str, strArr2, null, null, str2);
        }
        if (iMatch == 4) {
            return readableDatabase.query(AppInfoDbHelper.TABLE_UNBOUNDED_APPS, strArr, str, strArr2, null, null, str2);
        }
        Log.w(TAG, "Unkown uri", new IllegalArgumentException("Unkown uri:" + uri));
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Log.d(TAG, "update");
        MATCHER.match(uri);
        Log.w(TAG, "Unkown uri", new IllegalArgumentException("Unkown uri:" + uri));
        return 0;
    }
}
