package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class SearchHistoryColums implements CommonColumns {
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS search_history(_id INTEGER PRIMARY KEY AUTOINCREMENT, keyword TEXT, create_time INTEGER, use_count INTEGER);";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS search_history;";
    public static final String KEYWORD = "keyword";
    public static final String PATH = "/search_history";
    public static final String PATH_ID = "/search_history/#";
    public static final String PATH_KEYWORD = "/search_history/*";
    public static final String TABLE = "search_history";
    public static final Uri URI = null;
    public static final String USE_COUNT = "use_count";

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public SearchHistoryColums() {
    }

    public static ContentValues convertAppInfoToValues(AppInfo r10) {
        return null;
    }

    public static AppInfo convertDBToAppInfo(Cursor r10) {
        return null;
    }

    public static Uri getUri(Context r10) {
        return Uri.parse(CommonColumns.SCHEME + r10.getPackageName() + PATH);
    }
}
