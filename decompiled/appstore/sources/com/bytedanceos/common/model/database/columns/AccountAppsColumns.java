package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class AccountAppsColumns implements CommonColumns {
    public static final String ADD_COLUMN_SQL = "ALTER TABLE account_apps ADD COLUMN soft_type INTEGER";
    public static final String ADD_MARK_COLUMN_SQL = "ALTER TABLE account_apps ADD COLUMN app_mark TEXT";
    public static final String ADD_MARK_DELETED_COLUMN_SQL = "ALTER TABLE account_apps ADD COLUMN mark_deleted INTEGER DEFAULT 0";
    public static final String ADD_MD5_FILE_COLUMN_SQL = "ALTER TABLE account_apps ADD COLUMN app_mark TEXT";
    public static final String ADD_VERSION_NAME_COLUMN_SQL = "ALTER TABLE account_apps ADD COLUMN app_versionname TEXT";
    public static final String APP_HIDE = "app_hide";
    public static final String APP_MARK_DELETED = "mark_deleted";
    public static final String APP_MD5_FILE = "md5_file";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS account_apps(_id INTEGER PRIMARY KEY AUTOINCREMENT, create_time INTEGER, app_id TEXT, app_name TEXT, app_packagename TEXT, app_icon TEXT, app_category TEXT, app_scores FLOAT, app_versioncode INTEGER, app_versionname TEXT, app_downloadurl TEXT, app_optime TEXT, app_hide INTEGER, app_synced INTEGER, app_report INTEGER, app_size INTEGER, md5_file TEXT, soft_type INTEGER, mark_deleted INTEGER DEFAULT 0, app_mark TEXT );";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS account_apps;";
    public static final String PATH = "/account_apps";
    public static final String PATH_PACKAGENAME = "/account_apps/*";
    public static final String TABLE = "account_apps";
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public AccountAppsColumns() {
    }

    public static ContentValues convertAppInfoToValues(AppInfo r10) {
        return convertAppInfoToValues(r10, 0);
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
        int r19 = r20.getColumnIndex(CommonColumns.APP_REPORT);
        int r110 = r20.getColumnIndex(CommonColumns.APP_SIZE);
        int r111 = r20.getColumnIndex("soft_type");
        int r112 = r20.getColumnIndex("app_hide");
        int r113 = r20.getColumnIndex(CommonColumns.APP_SYNC);
        int r114 = r20.getColumnIndex(CommonColumns.APP_OPTIME);
        int r115 = r20.getColumnIndex(CommonColumns.APP_VERSIONNAME);
        int r116 = r20.getColumnIndex(CommonColumns.APP_MARK);
        int r117 = r20.getColumnIndex("md5_file");
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
        if (r19 != (-1)) goto L22;
    L26:
        if (r110 == (-1)) goto L28;
        r10.appBytes = r20.getLong(r110);
    L28:
        if (r111 == (-1)) goto L30;
        r10.mAppType = r20.getInt(r111);
    L30:
        if (r112 == (-1)) goto L32;
        r10.hideVersionCode = r20.getInt(r112);
    L32:
        if (r113 == (-1)) goto L38;
        if (r20.getInt(r113) != 1) goto L36;
        r21 = true;
    L36:
        r10.isAppSync = r21;
    L38:
        if (r114 == (-1)) goto L41;
        r10.appOpTime = r20.getString(r114);
    L41:
        if (r115 == (-1)) goto L44;
        r10.appVersionName = r20.getString(r115);
    L44:
        if (r116 == (-1)) goto L46;
        r10.setFrom(r20.getString(r116));
    L46:
        r10.appSource = "local";
        if (r117 == (-1)) goto L49;
        r10.fileMd5 = r20.getString(r117);
    L49:
        return r10;
    L22:
        if (r20.getInt(r19) != 1) goto L24;
        boolean r22 = true;
    L25:
        r10.isAppReport = r22;
        goto L26
    L24:
        r22 = false;
        goto L25
    }

    public static ContentValues convertAppInfoToValues(AppInfo r10, long r11) {
        ContentValues r12 = new ContentValues();
        r12.put("app_id", r10.appId);
        r12.put("app_name", r10.appName);
        r12.put(CommonColumns.APP_PACKAGENAME, r10.appPackageName);
        r12.put(CommonColumns.APP_ICON, r10.appIcon);
        r12.put(CommonColumns.APP_CATEGORY, r10.appCategoryName);
        r12.put(CommonColumns.APP_SCORES, Float.valueOf(r10.appScores));
        r12.put(CommonColumns.APP_VERSIONCODE, Integer.valueOf(r10.appVersionCode));
        r12.put(CommonColumns.APP_VERSIONNAME, r10.appVersionName);
        r12.put(CommonColumns.APP_DOWNLOADURL, r10.appDownloadUrl);
        r12.put(CommonColumns.APP_REPORT, Integer.valueOf(r10.isAppReport ? 1 : 0));
        r12.put(CommonColumns.APP_SIZE, Long.valueOf(r10.appBytes));
        if (r10.isNeededSync == false) goto L5;
        r12.put(CommonColumns.APP_SYNC, 0);
    L6:
        r12.put("create_time", Long.valueOf(r11));
        if (TextUtils.isEmpty(r10.appOpTime) == false) goto L9;
        r12.put(CommonColumns.APP_OPTIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(r11)));
    L10:
        r12.put(CommonColumns.APP_OPTIME, r10.appOpTime);
        r12.put("soft_type", Integer.valueOf(r10.getSoftType()));
        AppInfo.From r13 = r10.appFrom;
        if (r13 != null) goto L13;
        String r14 = "";
    L14:
        r12.put(CommonColumns.APP_MARK, r14);
        return r12;
    L13:
        r14 = r13.mark;
        goto L14
    L9:
        r12.put(CommonColumns.APP_OPTIME, r10.appOpTime);
        goto L10
    L5:
        r12.put(CommonColumns.APP_SYNC, 1);
        goto L6
    }
}
