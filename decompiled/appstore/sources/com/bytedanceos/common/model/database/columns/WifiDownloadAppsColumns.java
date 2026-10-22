package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class WifiDownloadAppsColumns implements CommonColumns {
    public static final String APP_TAB_SOURCE = "app_tab_source";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS wifi_apps(_id INTEGER PRIMARY KEY AUTOINCREMENT, create_time INTEGER, app_id TEXT, app_name TEXT, app_packagename TEXT, app_icon TEXT, app_category TEXT, app_scores FLOAT, app_versioncode INTEGER, app_versionname TEXT, app_downloadurl TEXT, app_optime TEXT, app_size INTEGER, app_tab_source TEXT, soft_type INTEGER);";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS wifi_apps;";
    public static final String PATH = "/wifi_apps";
    public static final String PATH_PACKAGENAME = "/wifi_apps/*";
    public static final String TABLE = "wifi_apps";
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public WifiDownloadAppsColumns() {
    }

    public static ContentValues convertAppInfoToValues(AppInfo r10) {
        return null;
    }

    public static AppInfo convertDBToAppInfo(Cursor r15) {
        AppInfo r10 = new AppInfo();
        int r11 = r15.getColumnIndex("app_id");
        int r12 = r15.getColumnIndex("app_name");
        int r13 = r15.getColumnIndex(CommonColumns.APP_PACKAGENAME);
        int r14 = r15.getColumnIndex(CommonColumns.APP_ICON);
        int r16 = r15.getColumnIndex(CommonColumns.APP_CATEGORY);
        int r17 = r15.getColumnIndex(CommonColumns.APP_SCORES);
        int r18 = r15.getColumnIndex(CommonColumns.APP_VERSIONCODE);
        int r19 = r15.getColumnIndex(CommonColumns.APP_VERSIONNAME);
        int r20 = r15.getColumnIndex(CommonColumns.APP_DOWNLOADURL);
        int r110 = r15.getColumnIndex(CommonColumns.APP_OPTIME);
        int r111 = r15.getColumnIndex(CommonColumns.APP_SIZE);
        int r112 = r15.getColumnIndex("app_tab_source");
        int r113 = r15.getColumnIndex("soft_type");
        if (r11 == (-1)) goto L5;
        r10.appId = r15.getString(r11);
    L5:
        if (r12 == (-1)) goto L7;
        r10.appName = r15.getString(r12);
    L7:
        if (r13 == (-1)) goto L9;
        r10.appPackageName = r15.getString(r13);
    L9:
        if (r14 == (-1)) goto L11;
        r10.appIcon = r15.getString(r14);
    L11:
        if (r16 == (-1)) goto L13;
        r10.appCategoryName = r15.getString(r16);
    L13:
        if (r17 == (-1)) goto L15;
        r10.appScores = r15.getFloat(r17);
    L15:
        if (r18 == (-1)) goto L17;
        r10.appVersionCode = r15.getInt(r18);
    L17:
        if (r19 == (-1)) goto L19;
        r10.appVersionName = r15.getString(r19);
    L19:
        if (r20 == (-1)) goto L21;
        r10.appDownloadUrl = r15.getString(r20);
    L21:
        if (r111 == (-1)) goto L23;
        r10.appBytes = r15.getLong(r111);
    L23:
        if (r113 == (-1)) goto L25;
        r10.mAppType = r15.getInt(r113);
    L25:
        if (r112 == (-1)) goto L27;
        r10.tabSource = r15.getString(r112);
    L27:
        if (r110 == (-1)) goto L29;
        r10.appOpTime = r15.getString(r110);
    L29:
        r10.appSource = "local";
        return r10;
    }
}
