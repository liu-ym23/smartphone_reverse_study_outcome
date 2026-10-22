package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;
import com.smt.obric.appstore.domain.app.entity.Converters;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class MyAppsColumns implements CommonColumns {
    public static final String ADD_APK_SIGN_SHA256_COLUMN_SQL = "ALTER TABLE my_apps ADD COLUMN app_sign_sha256 TEXT";
    public static final String ADD_COLUMN_SQL_HIDE = "ALTER TABLE my_apps ADD COLUMN app_hide INTEGER";
    public static final String ADD_COLUMN_SQL_UPDATE = "ALTER TABLE my_apps ADD COLUMN app_update INTEGER";
    public static final String ADD_DIFF_MD5_COLUMN_SQL = "ALTER TABLE my_apps ADD COLUMN diff_md5 TEXT";
    public static final String ADD_DOWNLOAD_URL_BACKUPS_COLUMN_SQL = "ALTER TABLE my_apps ADD COLUMN app_downloadurl_backups TEXT";
    public static final String ADD_MARK_COLUMN_SQL = "ALTER TABLE my_apps ADD COLUMN app_mark TEXT";
    public static final String ADD_RETRY_DOWNLOAD_URL_COLUMN_SQL = "ALTER TABLE my_apps ADD COLUMN retry_download_url TEXT";
    public static final String APP_DIFF_MD5 = "diff_md5";
    public static final String APP_DM_URL = "app_dm_url";
    public static final String APP_HIDE = "app_hide";
    public static final String APP_INSTALL_STATE = "install_state";
    public static final String APP_MEM_URL = "app_mem_url";
    public static final String APP_UPDATE = "app_update";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS my_apps(_id INTEGER PRIMARY KEY AUTOINCREMENT, create_time INTEGER, app_id TEXT, app_name TEXT, app_packagename TEXT, app_icon TEXT, app_category TEXT, app_scores FLOAT, app_versioncode INTEGER, app_versionname TEXT, app_downloadurl TEXT, app_downloadurl_backups TEXT, app_sign_sha256 TEXT, app_dm_url TEXT, app_mem_url TEXT, app_optime TEXT, app_synced INTEGER, app_report INTEGER, app_size INTEGER, install_state INTEGER, soft_type INTEGER, app_update INTEGER, app_hide INTEGER, app_mark TEXT, diff_md5 TEXT, retry_download_url TEXT );";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS my_apps;";
    public static final String PATH = "/my_apps";
    public static final String PATH_PACKAGENAME = "/my_apps/*";
    public static final String RESET_UPDATE_FLAG_FOR_SIGN = "UPDATE my_apps SET app_update = 0 WHERE app_update > 0";
    public static final String RETRY_DOWNLOAD_URL = "retry_download_url";
    public static final String TABLE = "my_apps";
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public MyAppsColumns() {
    }

    public static ContentValues convertAppInfoToValues(AppInfo r10) {
        ContentValues r11 = new ContentValues();
        r11.put("app_id", r10.appId);
        r11.put("app_name", r10.appName);
        r11.put(CommonColumns.APP_ICON, r10.appIcon);
        r11.put(CommonColumns.APP_CATEGORY, r10.appCategoryName);
        r11.put(CommonColumns.APP_SCORES, Float.valueOf(r10.appScores));
        r11.put(CommonColumns.APP_DOWNLOADURL, r10.appDownloadUrl);
        r11.put(CommonColumns.APP_DOWNLOADURL_BACKUPS, new Converters().f(r10.appDownloadUrlBackups));
        r11.put(CommonColumns.APP_SIGN_SHA256, r10.sha256);
        r11.put(APP_DM_URL, r10.mDmUrl);
        r11.put(APP_MEM_URL, r10.mMemUrl);
        r11.put(CommonColumns.APP_SIZE, Long.valueOf(r10.appBytes));
        r11.put(CommonColumns.APP_REPORT, Integer.valueOf(r10.isAppReport ? 1 : 0));
        r11.put("soft_type", Integer.valueOf(r10.getSoftType()));
        r11.put(CommonColumns.APP_SYNC, Integer.valueOf(!r10.isAppSync ? 1 : 0));
        r11.put(CommonColumns.APP_PACKAGENAME, r10.appPackageName);
        r11.put(CommonColumns.APP_VERSIONCODE, Integer.valueOf(r10.appVersionCode));
        r11.put(CommonColumns.APP_VERSIONNAME, r10.appVersionName);
        r11.put(CommonColumns.APP_OPTIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        r11.put(APP_INSTALL_STATE, Integer.valueOf(r10.appState));
        r11.put("app_update", Integer.valueOf(r10.mAppUpdateType));
        r11.put("app_hide", Integer.valueOf(r10.hideVersionCode));
        AppInfo.From r12 = r10.appFrom;
        if (r12 != null) goto L5;
        String r13 = "";
    L6:
        r11.put(CommonColumns.APP_MARK, r13);
        r11.put("diff_md5", r10.mDiffMD5);
        r11.put(RETRY_DOWNLOAD_URL, r10.mDiffDownloadUrl);
        return r11;
    L5:
        r13 = r12.mark;
        goto L6
    }

    public static AppInfo convertDBToAppInfo(Cursor r28) {
        AppInfo r10 = new AppInfo();
        int r11 = r28.getColumnIndex("app_id");
        int r12 = r28.getColumnIndex("app_name");
        int r13 = r28.getColumnIndex(CommonColumns.APP_PACKAGENAME);
        int r14 = r28.getColumnIndex(CommonColumns.APP_ICON);
        int r15 = r28.getColumnIndex(CommonColumns.APP_CATEGORY);
        int r16 = r28.getColumnIndex(CommonColumns.APP_SCORES);
        int r17 = r28.getColumnIndex(CommonColumns.APP_VERSIONCODE);
        int r18 = r28.getColumnIndex(CommonColumns.APP_VERSIONNAME);
        int r19 = r28.getColumnIndex(CommonColumns.APP_DOWNLOADURL);
        int r110 = r28.getColumnIndex(CommonColumns.APP_DOWNLOADURL_BACKUPS);
        int r111 = r28.getColumnIndex(CommonColumns.APP_SIGN_SHA256);
        int r112 = r28.getColumnIndex(APP_DM_URL);
        int r113 = r28.getColumnIndex(APP_MEM_URL);
        int r114 = r28.getColumnIndex(CommonColumns.APP_OPTIME);
        int r115 = r28.getColumnIndex(CommonColumns.APP_SYNC);
        int r116 = r28.getColumnIndex(CommonColumns.APP_REPORT);
        int r117 = r28.getColumnIndex(CommonColumns.APP_SIZE);
        int r118 = r28.getColumnIndex(APP_INSTALL_STATE);
        int r119 = r28.getColumnIndex("soft_type");
        int r120 = r28.getColumnIndex("app_update");
        int r121 = r28.getColumnIndex("app_hide");
        int r122 = r28.getColumnIndex(CommonColumns.APP_MARK);
        int r123 = r28.getColumnIndex("diff_md5");
        int r124 = r28.getColumnIndex(RETRY_DOWNLOAD_URL);
        if (r115 == (-1)) goto L10;
        boolean r125 = true;
        if (r28.getInt(r11) != 1) goto L7;
        boolean r126 = true;
    L8:
        r10.isAppSync = r126;
    L11:
        if (r116 != (-1)) goto L13;
    L17:
        if (r118 == (-1)) goto L19;
        r10.appState = r28.getInt(r118);
    L19:
        if (r11 == (-1)) goto L21;
        r10.appId = r28.getString(r11);
    L21:
        if (r12 == (-1)) goto L23;
        r10.appName = r28.getString(r12);
    L23:
        if (r13 == (-1)) goto L25;
        r10.appPackageName = r28.getString(r13);
    L25:
        if (r14 == (-1)) goto L27;
        r10.appIcon = r28.getString(r14);
    L27:
        if (r15 == (-1)) goto L29;
        r10.appCategoryName = r28.getString(r15);
    L29:
        if (r16 == (-1)) goto L31;
        r10.appScores = r28.getFloat(r16);
    L31:
        if (r17 == (-1)) goto L33;
        r10.appVersionCode = r28.getInt(r17);
    L33:
        if (r18 == (-1)) goto L35;
        r10.appVersionName = r28.getString(r18);
    L35:
        if (r19 == (-1)) goto L37;
        r10.appDownloadUrl = r28.getString(r19);
    L37:
        if (r110 == (-1)) goto L40;
        r10.appDownloadUrlBackups = new Converters().c(r28.getString(r110));
    L40:
        if (r111 == (-1)) goto L43;
        r10.sha256 = r28.getString(r111);
    L43:
        if (r112 == (-1)) goto L46;
        r10.mDmUrl = r28.getString(r112);
    L46:
        if (r113 == (-1)) goto L49;
        r10.mMemUrl = r28.getString(r113);
    L49:
        if (r117 == (-1)) goto L52;
        r10.appBytes = r28.getLong(r117);
    L52:
        if (r119 == (-1)) goto L55;
        r10.mAppType = r28.getInt(r119);
    L55:
        if (r121 == (-1)) goto L58;
        r10.hideVersionCode = r28.getInt(r121);
    L58:
        if (r114 == (-1)) goto L61;
        r10.appOpTime = r28.getString(r114);
    L61:
        if (r120 == (-1)) goto L68;
        r10.mAppUpdateType = r28.getInt(r120);
        if (r10.mAppUpdateType != 0) goto L66;
        r125 = false;
    L66:
        r10.isAppUpdate = r125;
    L68:
        if (r122 == (-1)) goto L71;
        r10.setFrom(r28.getString(r122));
    L71:
        if (r123 == (-1)) goto L74;
        r10.mDiffMD5 = r28.getString(r123);
    L74:
        if (r124 == (-1)) goto L76;
        r10.mDiffDownloadUrl = r28.getString(r124);
    L76:
        r10.appSource = "local";
        return r10;
    L13:
        if (r28.getInt(r11) != 0) goto L15;
        boolean r127 = r125;
    L16:
        r10.isAppReport = r127;
        goto L17
    L15:
        r127 = false;
        goto L16
    L7:
        r126 = false;
        goto L8
    L10:
        r125 = true;
        goto L11
    }
}
