package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class InstalledAppsColumns implements CommonColumns {
    public static final String ADD_COLUMN_SQL = "ALTER TABLE installed_apps ADD COLUMN soft_type INTEGER";
    public static final String ADD_COLUMN_SQL_HIDE = "ALTER TABLE installed_apps ADD COLUMN app_hide INTEGER";
    public static final String ADD_COLUMN_SQL_MD5 = "ALTER TABLE installed_apps ADD COLUMN base_apk_md5 TEXT";
    public static final String ADD_COLUMN_SQL_SYNC = "ALTER TABLE installed_apps ADD COLUMN app_synced INTEGER";
    public static final String APP_HIDE = "app_hide";
    public static final String APP_INSTALLEDTIME = "app_installedtime";
    public static final String APP_MD5 = "base_apk_md5";
    public static final String APP_UPDATE = "app_update";
    public static final String APP_UPDATETIME = "app_updatetime";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS installed_apps(_id INTEGER PRIMARY KEY AUTOINCREMENT, create_time INTEGER, app_id TEXT, app_name TEXT, app_packagename TEXT, app_icon TEXT, app_category TEXT, app_scores FLOAT, app_versioncode INTEGER, app_downloadurl TEXT, app_versionname TEXT, app_installedtime INTEGER, app_updatetime INTEGER, app_update INTEGER, app_report INTEGER, app_size INTEGER, soft_type INTEGER, app_synced INTEGER, base_apk_md5 TEXT);";
    public static final String DROP_COLUMN_SQL_HIDE = "ALTER TABLE installed_apps DROP COLUMN app_hide";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS installed_apps;";
    public static final String PATH = "/installed_apps";
    public static final String PATH_PACKAGENAME = "/installed_apps/*";
    public static final String TABLE = "installed_apps";
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public InstalledAppsColumns() {
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
        r11.put(CommonColumns.APP_DOWNLOADURL, r10.appDownloadUrl);
        r11.put(CommonColumns.APP_REPORT, Integer.valueOf(r10.isAppReport ? 1 : 0));
        r11.put(CommonColumns.APP_SIZE, Long.valueOf(r10.appBytes));
        r11.put(CommonColumns.APP_VERSIONNAME, r10.appVersionName);
        r11.put(APP_INSTALLEDTIME, Long.valueOf(r10.appFirstInstallTime));
        r11.put(APP_UPDATETIME, Long.valueOf(r10.appLastUpdateTime));
        r11.put("app_update", Integer.valueOf(r10.isAppUpdate ? 1 : 0));
        r11.put("soft_type", Integer.valueOf(r10.getSoftType()));
        r11.put(CommonColumns.APP_SYNC, Integer.valueOf(!r10.isNeededSync ? 1 : 0));
        r11.put(APP_MD5, r10.mBaseApkMd5);
        return r11;
    }

    public static AppInfo convertDBToAppInfo(Cursor r20) {
        AppInfo r10 = new AppInfo();
        int r11 = r20.getColumnIndex("app_id");
        int r12 = r20.getColumnIndex("app_name");
        int r13 = r20.getColumnIndex(CommonColumns.APP_PACKAGENAME);
        int r14 = r20.getColumnIndex(CommonColumns.APP_ICON);
        int r15 = r20.getColumnIndex(CommonColumns.APP_CATEGORY);
        int r16 = r20.getColumnIndex(CommonColumns.APP_SCORES);
        int r17 = r20.getColumnIndex(CommonColumns.APP_VERSIONCODE);
        int r18 = r20.getColumnIndex(CommonColumns.APP_DOWNLOADURL);
        int r19 = r20.getColumnIndex(CommonColumns.APP_VERSIONNAME);
        int r110 = r20.getColumnIndex(APP_INSTALLEDTIME);
        int r111 = r20.getColumnIndex(APP_UPDATETIME);
        int r112 = r20.getColumnIndex("app_update");
        int r113 = r20.getColumnIndex(CommonColumns.APP_REPORT);
        int r114 = r20.getColumnIndex(CommonColumns.APP_SIZE);
        int r115 = r20.getColumnIndex("soft_type");
        int r116 = r20.getColumnIndex(CommonColumns.APP_SYNC);
        int r117 = r20.getColumnIndex(APP_MD5);
        if (r11 == (-1)) goto L5;
        r10.appId = r20.getString(r11);
    L5:
        if (r12 == (-1)) goto L7;
        r10.appName = r20.getString(r12);
    L7:
        if (r13 == (-1)) goto L9;
        r10.appPackageName = r20.getString(r13);
    L9:
        if (r14 == (-1)) goto L11;
        r10.appIcon = r20.getString(r14);
    L11:
        if (r15 == (-1)) goto L13;
        r10.appCategoryName = r20.getString(r15);
    L13:
        if (r16 == (-1)) goto L15;
        r10.appScores = r20.getFloat(r16);
    L15:
        if (r17 == (-1)) goto L17;
        r10.appVersionCode = r20.getInt(r17);
    L17:
        if (r18 == (-1)) goto L19;
        r10.appDownloadUrl = r20.getString(r18);
    L19:
        boolean r21 = false;
        if (r113 != (-1)) goto L22;
    L26:
        if (r114 == (-1)) goto L28;
        r10.appBytes = r20.getLong(r114);
    L28:
        if (r115 == (-1)) goto L30;
        r10.mAppType = r20.getInt(r115);
    L30:
        if (r116 != (-1)) goto L32;
    L36:
        if (r19 == (-1)) goto L39;
        r10.appVersionName = r20.getString(r19);
    L39:
        if (r110 == (-1)) goto L42;
        r10.appFirstInstallTime = r20.getInt(r110);
    L42:
        if (r111 == (-1)) goto L45;
        r10.appLastUpdateTime = r20.getInt(r111);
    L45:
        if (r112 == (-1)) goto L51;
        if (r20.getInt(r112) != 1) goto L49;
        r21 = true;
    L49:
        r10.isAppUpdate = r21;
    L51:
        if (r117 == (-1)) goto L53;
        r10.mBaseApkMd5 = r20.getString(r117);
    L53:
        r10.appState = 128;
        return r10;
    L32:
        if (r20.getInt(r116) != 1) goto L34;
        boolean r22 = true;
    L35:
        r10.isAppSync = r22;
        goto L36
    L34:
        r22 = false;
        goto L35
    L22:
        if (r20.getInt(r113) != 1) goto L24;
        boolean r23 = true;
    L25:
        r10.isAppReport = r23;
        goto L26
    L24:
        r23 = false;
        goto L25
    }
}
