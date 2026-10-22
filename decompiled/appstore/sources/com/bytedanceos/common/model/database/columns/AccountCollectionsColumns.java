package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class AccountCollectionsColumns implements CommonColumns {
    public static final String ADD_COLUMN_SQL = "ALTER TABLE account_collections ADD COLUMN soft_type INTEGER";
    public static final String ADD_MARK_COLUMN_SQL = "ALTER TABLE account_collections ADD COLUMN app_mark TEXT";
    public static final String APP_COLLECT = "app_collect";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS account_collections(_id INTEGER PRIMARY KEY AUTOINCREMENT, create_time INTEGER, app_id TEXT, app_name TEXT, app_packagename TEXT, app_icon TEXT, app_category TEXT, app_scores FLOAT, app_versioncode INTEGER, app_downloadurl TEXT, app_optime TEXT, app_collect INTEGER, app_synced INTEGER, app_report INTEGER, app_size INTEGER, soft_type INTEGER, app_mark TEXT );";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS account_collections;";
    public static final String PATH = "/account_collections";
    public static final String PATH_PACKAGENAME = "/account_collections/*";
    public static final String TABLE = "account_collections";
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public AccountCollectionsColumns() {
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
        r11.put(APP_COLLECT, Integer.valueOf(r10.isCollected ? 1 : 0));
        r11.put(CommonColumns.APP_SYNC, Integer.valueOf(r10.isAppSync ? 1 : 0));
        r11.put(CommonColumns.APP_OPTIME, r10.appOpTime);
        r11.put("create_time", Long.valueOf(System.currentTimeMillis()));
        r11.put("soft_type", Integer.valueOf(r10.getSoftType()));
        AppInfo.From r12 = r10.appFrom;
        if (r12 != null) goto L5;
        String r13 = "";
    L6:
        r11.put(CommonColumns.APP_MARK, r13);
        return r11;
    L5:
        r13 = r12.mark;
        goto L6
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
        int r18 = r19.getColumnIndex(CommonColumns.APP_DOWNLOADURL);
        int r110 = r19.getColumnIndex(CommonColumns.APP_REPORT);
        int r111 = r19.getColumnIndex(CommonColumns.APP_SIZE);
        int r112 = r19.getColumnIndex("soft_type");
        int r113 = r19.getColumnIndex(CommonColumns.APP_SYNC);
        int r114 = r19.getColumnIndex(CommonColumns.APP_OPTIME);
        int r115 = r19.getColumnIndex(APP_COLLECT);
        int r116 = r19.getColumnIndex(CommonColumns.APP_VERSIONNAME);
        int r117 = r19.getColumnIndex(CommonColumns.APP_MARK);
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
        r10.appDownloadUrl = r19.getString(r18);
    L19:
        boolean r20 = false;
        if (r110 != (-1)) goto L22;
    L26:
        if (r111 == (-1)) goto L28;
        r10.appBytes = r19.getLong(r111);
    L28:
        if (r112 == (-1)) goto L30;
        r10.mAppType = r19.getInt(r112);
    L30:
        if (r113 != (-1)) goto L32;
    L36:
        if (r114 == (-1)) goto L39;
        r10.appOpTime = r19.getString(r114);
    L39:
        if (r115 == (-1)) goto L45;
        if (r19.getInt(r115) != 1) goto L43;
        r20 = true;
    L43:
        r10.isCollected = r20;
    L45:
        if (r116 == (-1)) goto L48;
        r10.appVersionName = r19.getString(r116);
    L48:
        if (r117 == (-1)) goto L50;
        r10.setFrom(r19.getString(r117));
    L50:
        r10.appSource = "local";
        return r10;
    L32:
        if (r19.getInt(r113) != 1) goto L34;
        boolean r21 = true;
    L35:
        r10.isAppSync = r21;
        goto L36
    L34:
        r21 = false;
        goto L35
    L22:
        if (r19.getInt(r110) != 1) goto L24;
        boolean r22 = true;
    L25:
        r10.isAppReport = r22;
        goto L26
    L24:
        r22 = false;
        goto L25
    }
}
