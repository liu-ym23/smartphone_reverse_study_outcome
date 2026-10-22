package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ReservedAppsColumns implements CommonColumns {
    public static final String APP_TAB_SOURCE = "app_tab_source";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS reserve_apps(_id INTEGER PRIMARY KEY AUTOINCREMENT, create_time INTEGER, app_id TEXT, app_name TEXT, app_packagename TEXT, app_icon TEXT, app_category TEXT, app_scores FLOAT, app_versioncode INTEGER, app_versionname TEXT, app_downloadurl TEXT, app_optime TEXT, app_size INTEGER, app_tab_source TEXT, soft_type INTEGER,app_reserve INTEGER, app_title TEXT, app_subtitle TEXT);";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS reserve_apps;";
    public static final String PATH = "/reserve_apps";
    public static final String PATH_PACKAGENAME = "/reserve_apps/*";
    public static final String TABLE = "reserve_apps";
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public ReservedAppsColumns() {
    }

    public static ContentValues convertAppInfoToValues(AppInfo r10) {
        ContentValues r11 = new ContentValues();
        r11.put("app_id", r10.appId);
        r11.put("app_name", r10.appName);
        r11.put(CommonColumns.APP_PACKAGENAME, r10.appPackageName);
        r11.put(CommonColumns.APP_ICON, r10.appIcon);
        r11.put(CommonColumns.APP_CATEGORY, r10.appCategoryName);
        r11.put(CommonColumns.APP_SCORES, Float.valueOf(r10.appScores));
        r11.put(CommonColumns.APP_VERSIONCODE, Integer.valueOf(r10.appVersionCode));
        r11.put(CommonColumns.APP_VERSIONNAME, r10.appVersionName);
        r11.put(CommonColumns.APP_DOWNLOADURL, r10.appDownloadUrl);
        r11.put(CommonColumns.APP_OPTIME, r10.appOpTime);
        r11.put(CommonColumns.APP_SIZE, Long.valueOf(r10.appBytes));
        r11.put("app_tab_source", r10.tabSource);
        r11.put("soft_type", Integer.valueOf(r10.getSoftType()));
        r11.put(CommonColumns.APP_RESERVE, Integer.valueOf(r10.mIsPushReservation ? 1 : 0));
        r11.put(CommonColumns.APP_TITLE, r10.mTitle);
        r11.put(CommonColumns.APP_SUBTITLE, r10.mSubtitle);
        return r11;
    }

    public static AppInfo convertDBToAppInfo(Cursor r19) {
        AppInfo r10 = new AppInfo();
        int r11 = r19.getColumnIndex("app_id");
        int r12 = r19.getColumnIndex("app_name");
        int r13 = r19.getColumnIndex(CommonColumns.APP_PACKAGENAME);
        int r14 = r19.getColumnIndex(CommonColumns.APP_ICON);
        int r15 = r19.getColumnIndex(CommonColumns.APP_CATEGORY);
        int r16 = r19.getColumnIndex(CommonColumns.APP_SCORES);
        int r17 = r19.getColumnIndex(CommonColumns.APP_VERSIONCODE);
        int r18 = r19.getColumnIndex(CommonColumns.APP_VERSIONNAME);
        int r110 = r19.getColumnIndex(CommonColumns.APP_DOWNLOADURL);
        int r111 = r19.getColumnIndex(CommonColumns.APP_OPTIME);
        int r112 = r19.getColumnIndex(CommonColumns.APP_SIZE);
        int r113 = r19.getColumnIndex("app_tab_source");
        int r114 = r19.getColumnIndex("soft_type");
        int r115 = r19.getColumnIndex(CommonColumns.APP_RESERVE);
        int r116 = r19.getColumnIndex(CommonColumns.APP_TITLE);
        int r117 = r19.getColumnIndex(CommonColumns.APP_SUBTITLE);
        if (r11 == (-1)) goto L5;
        r10.appId = r19.getString(r11);
    L5:
        if (r12 == (-1)) goto L7;
        r10.appName = r19.getString(r12);
    L7:
        if (r13 == (-1)) goto L9;
        r10.appPackageName = r19.getString(r13);
    L9:
        if (r14 == (-1)) goto L11;
        r10.appIcon = r19.getString(r14);
    L11:
        if (r15 == (-1)) goto L13;
        r10.appCategoryName = r19.getString(r15);
    L13:
        if (r16 == (-1)) goto L15;
        r10.appScores = r19.getFloat(r16);
    L15:
        if (r17 == (-1)) goto L17;
        r10.appVersionCode = r19.getInt(r17);
    L17:
        if (r18 == (-1)) goto L19;
        r10.appVersionName = r19.getString(r18);
    L19:
        if (r110 == (-1)) goto L21;
        r10.appDownloadUrl = r19.getString(r110);
    L21:
        if (r112 == (-1)) goto L23;
        r10.appBytes = r19.getLong(r112);
    L23:
        if (r114 == (-1)) goto L25;
        r10.mAppType = r19.getInt(r114);
    L25:
        if (r113 == (-1)) goto L27;
        r10.tabSource = r19.getString(r113);
    L27:
        if (r111 == (-1)) goto L30;
        r10.appOpTime = r19.getString(r111);
    L30:
        if (r115 == (-1)) goto L37;
        boolean r20 = true;
        if (r19.getInt(r115) == 1) goto L35;
        r20 = false;
    L35:
        r10.mIsPushReservation = r20;
    L37:
        if (r116 == (-1)) goto L40;
        r10.mTitle = r19.getString(r116);
    L40:
        if (r117 == (-1)) goto L42;
        r10.mSubtitle = r19.getString(r117);
    L42:
        r10.appSource = "local";
        return r10;
    }
}
