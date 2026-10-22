package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedanceos.common.model.AppInfo;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadInfoColumns implements CommonColumns {
    public static final String ADD_COLUMN_APP_ID = "ALTER TABLE download_info ADD COLUMN appp_id TEXT";
    public static final String ADD_COLUMN_MD5_FILE_DATA = "ALTER TABLE download_info ADD COLUMN md5_file TEXT";
    public static final String ADD_COLUMN_SQL_ADS_DATA = "ALTER TABLE download_info ADD COLUMN ads_data TEXT";
    public static final String ADD_COLUMN_SQL_API_URL = "ALTER TABLE download_info ADD COLUMN api_url TEXT";
    public static final String ADD_COLUMN_SQL_APP_FROM = "ALTER TABLE download_info ADD COLUMN app_from TEXT";
    public static final String ADD_COLUMN_SQL_APP_STATE = "ALTER TABLE download_info ADD COLUMN app_state INTEGER";
    public static final String ADD_COLUMN_SQL_APP_TYPE = "ALTER TABLE download_info ADD COLUMN app_type INTEGER";
    public static final String ADD_COLUMN_SQL_AUTO_DOWNLOAD = "ALTER TABLE download_info ADD COLUMN auto_dowmload INTEGER";
    public static final String ADD_COLUMN_SQL_BRIEF_RECMD = "ALTER TABLE download_info ADD COLUMN brief_recmd TEXT";
    public static final String ADD_COLUMN_SQL_BYTE = "ALTER TABLE download_info ADD COLUMN bytes TEXT";
    public static final String ADD_COLUMN_SQL_CATEGORY = "ALTER TABLE download_info ADD COLUMN category TEXT";
    public static final String ADD_COLUMN_SQL_DIFFMD5 = "ALTER TABLE download_info ADD COLUMN diff_md5 TEXT";
    public static final String ADD_COLUMN_SQL_DIFF_DOWNLOAD_URL = "ALTER TABLE download_info ADD COLUMN diff_download_url TEXT";
    public static final String ADD_COLUMN_SQL_PAGE_TITLE = "ALTER TABLE download_info ADD COLUMN page_title TEXT";
    public static final String ADD_COLUMN_SQL_RETRY_NUM = "ALTER TABLE download_info ADD COLUMN retryNum INTEGER";
    public static final String ADD_COLUMN_SQL_SCORE = "ALTER TABLE download_info ADD COLUMN score FLOAT";
    public static final String ADD_COLUMN_SQL_TASK_OWNER = "ALTER TABLE download_info ADD COLUMN task_owner TEXT";
    public static final String ADD_COLUMN_SQL_TIME_DOWNLOAD_ENQUEUE = "ALTER TABLE download_info ADD COLUMN time_download_enqueue INTEGER";
    public static final String ADD_COLUMN_SYS_APP_AUTO_UPDATE_TASK_ID = "ALTER TABLE download_info ADD COLUMN sys_app_auto_update_task_id INTEGER";
    public static final String ADD_COLUMN_UPDATE_MODE = "ALTER TABLE download_info ADD COLUMN update_mode INTEGER";
    public static final String APP_FILE_PATH = "app_file_path";
    public static final String APP_SOURCE = "app_source";
    public static final String APP_URL = "app_url";
    public static final String APP_VERSION = "app_version";
    public static final String APP_VERSION_CODE = "app_version_code";
    public static final String COLUMN_ADS_DATA = "ads_data";
    public static final String COLUMN_API_URL = "api_url";
    public static final String COLUMN_APP_FROM = "app_from";
    public static final String COLUMN_APP_ID = "appp_id";
    public static final String COLUMN_APP_STATE = "app_state";
    public static final String COLUMN_APP_TYPE = "app_type";
    public static final String COLUMN_AUTO_DOWNLOAD = "auto_dowmload";
    public static final String COLUMN_BRIEF_RECOMMEND = "brief_recmd";
    public static final String COLUMN_BYTES = "bytes";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_DIFFMD5 = "diff_md5";
    public static final String COLUMN_DIFF_DOWNLOAD_URL = "diff_download_url";
    public static final String COLUMN_MD5_FILE = "md5_file";
    public static final String COLUMN_NEED_GMS = "need_gms";
    public static final String COLUMN_NETWORK_TYPE = "network_type";
    public static final String COLUMN_PAGE_TITLE = "page_title";
    public static final String COLUMN_RETRY_NUM = "retryNum";
    public static final String COLUMN_SCORE = "score";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_SYS_APP_AUTO_UPDATE_TASK_ID = "sys_app_auto_update_task_id";
    public static final String COLUMN_TASK_OWNER = "task_owner";
    public static final String COLUMN_TIME_DOWNLOAD_ENQUEUE = "time_download_enqueue";
    public static final String COLUMN_TRACKER_INFO = "trackerinfo";
    public static final String COLUMN_UPDATE_MODE = "update_mode";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS download_info(_id INTEGER PRIMARY KEY AUTOINCREMENT, app_name TEXT, app_packagename TEXT, app_version TEXT, app_version_code INTEGER, app_url TEXT, app_icon TEXT, app_source TEXT, status INTEGER, network_type INTEGER, need_gms INTEGER, trackerinfo TEXT, bytes INTEGER, score FLOAT, category TEXT, brief_recmd TEXT, app_type INTEGER, md5_file TEXT, app_state INTEGER, diff_md5 TEXT,diff_download_url TEXT,app_from TEXT,auto_dowmload INTEGER,api_url TEXT,page_title TEXT,time_download_enqueue INTEGER,task_owner TEXT,ads_data TEXT,retryNum INTEGER,appp_id TEXT,update_mode INTEGER,sys_app_auto_update_task_id INTEGER);";
    public static final String DROP_COLUMN_SQL_APP_FILE_PATH = "ALTER TABLE download_info DROP COLUMN app_file_path";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS download_info;";
    public static final String PATH = "/download_info";
    public static final String PATH_ID = "/download_info/#";
    public static final String PATH_PACKAGENAME = "/download_info/*";
    public static final String TABLE = "download_info";
    public static final int TASK_OWNER_APPSTORE = 0;
    public static final int TASK_OWNER_GAMESTORE = 1;
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public DownloadInfoColumns() {
    }

    public static ContentValues convertAppInfoToValues(AppInfo r10) {
        ContentValues r11 = new ContentValues();
        r11.put("app_name", r10.appName);
        r11.put(CommonColumns.APP_PACKAGENAME, r10.appPackageName);
        r11.put("app_version", r10.appVersionName);
        r11.put(APP_VERSION_CODE, Integer.valueOf(r10.appVersionCode));
        r11.put(APP_URL, r10.appDownloadUrl);
        r11.put(CommonColumns.APP_ICON, r10.appIcon);
        r11.put(APP_SOURCE, r10.appSource);
        r11.put("status", Integer.valueOf(r10.downloadStatus));
        r11.put("network_type", Integer.valueOf(r10.mAllowMobile ? 1 : 0));
        r11.put(COLUMN_NEED_GMS, Integer.valueOf(r10.mIsNeedGms ? 1 : 0));
        r11.put(COLUMN_TRACKER_INFO, r10.trackerInfo);
        r11.put(COLUMN_BYTES, Long.valueOf(r10.appBytes));
        r11.put("score", Float.valueOf(r10.appScores));
        r11.put("category", r10.appCategoryName);
        r11.put(COLUMN_BRIEF_RECOMMEND, r10.recmd_brief);
        r11.put("app_type", Integer.valueOf(r10.mAppType));
        r11.put("app_state", Integer.valueOf(r10.appState));
        r11.put(COLUMN_AUTO_DOWNLOAD, Integer.valueOf(r10.isAutoDownload ? 1 : 0));
        r11.put(COLUMN_DIFF_DOWNLOAD_URL, r10.mDiffDownloadUrl);
        r11.put("diff_md5", r10.mDiffMD5);
        AppInfo.From r12 = r10.appFrom;
        if (r12 == null) goto L5;
        String r13 = r12.mark;
    L6:
        r11.put(COLUMN_APP_FROM, r13);
        r11.put(COLUMN_API_URL, r10.mApiUrl);
        r11.put("page_title", r10.mPageTitle);
        r11.put(COLUMN_TIME_DOWNLOAD_ENQUEUE, Long.valueOf(r10.timeDownloadEnqueue));
        r11.put(COLUMN_TASK_OWNER, Integer.valueOf(r10.mTaskOwner));
        r11.put(COLUMN_RETRY_NUM, Integer.valueOf(r10.mRetryNum));
        r11.put("md5_file", r10.fileMd5);
        if (TextUtils.isEmpty(r10.mJsonData) == true) goto L9;
        r11.put(COLUMN_ADS_DATA, r10.mJsonData);
    L9:
        r11.put(COLUMN_APP_ID, r10.appId);
        r11.put(COLUMN_UPDATE_MODE, Integer.valueOf(r10.mUpdateModel));
        r11.put(COLUMN_SYS_APP_AUTO_UPDATE_TASK_ID, Long.valueOf(r10.mSysAppAutoUpdateTaskId));
        return r11;
    L5:
        r13 = "";
        goto L6
    }

    public static AppInfo convertDBToAppInfo(Cursor r10) {
        AppInfo r11 = new AppInfo();
        r11.appName = r10.getString(r10.getColumnIndexOrThrow("app_name"));
        r11.appPackageName = r10.getString(r10.getColumnIndexOrThrow(CommonColumns.APP_PACKAGENAME));
        r11.appVersionName = r10.getString(r10.getColumnIndexOrThrow("app_version"));
        r11.appVersionCode = r10.getInt(r10.getColumnIndexOrThrow(APP_VERSION_CODE));
        r11.appDownloadUrl = r10.getString(r10.getColumnIndexOrThrow(APP_URL));
        r11.appIcon = r10.getString(r10.getColumnIndexOrThrow(CommonColumns.APP_ICON));
        r11.appSource = r10.getString(r10.getColumnIndexOrThrow(APP_SOURCE));
        r11.downloadStatus = r10.getInt(r10.getColumnIndexOrThrow("status"));
        boolean r12 = false;
        if (r10.getInt(r10.getColumnIndexOrThrow("network_type")) != 1) goto L5;
        boolean r13 = true;
    L6:
        r11.mAllowMobile = r13;
        if (r10.getInt(r10.getColumnIndexOrThrow(COLUMN_NEED_GMS)) != 1) goto L9;
        boolean r14 = true;
    L10:
        r11.mIsNeedGms = r14;
        r11.trackerInfo = r10.getString(r10.getColumnIndexOrThrow(COLUMN_TRACKER_INFO));
        r11.appBytes = r10.getLong(r10.getColumnIndexOrThrow(COLUMN_BYTES));
        r11.appScores = r10.getFloat(r10.getColumnIndexOrThrow("score"));
        r11.appCategoryName = r10.getString(r10.getColumnIndexOrThrow("category"));
        r11.recmd_brief = r10.getString(r10.getColumnIndexOrThrow(COLUMN_BRIEF_RECOMMEND));
        r11.mAppType = r10.getInt(r10.getColumnIndexOrThrow("app_type"));
        r11.appState = r10.getInt(r10.getColumnIndexOrThrow("app_state"));
        r11.mDiffMD5 = r10.getString(r10.getColumnIndexOrThrow("diff_md5"));
        r11.mDiffDownloadUrl = r10.getString(r10.getColumnIndexOrThrow(COLUMN_DIFF_DOWNLOAD_URL));
        if (r10.getInt(r10.getColumnIndexOrThrow(COLUMN_AUTO_DOWNLOAD)) != 1) goto L13;
        r12 = true;
    L13:
        r11.isAutoDownload = r12;
        AppInfo.From r15 = r11.appFrom;
        if (r15 == null) goto L16;
        r15.mark = r10.getString(r10.getColumnIndexOrThrow(COLUMN_APP_FROM));
    L16:
        r11.mApiUrl = r10.getString(r10.getColumnIndexOrThrow(COLUMN_API_URL));
        r11.mPageTitle = r10.getString(r10.getColumnIndexOrThrow("page_title"));
        r11.timeDownloadEnqueue = r10.getLong(r10.getColumnIndexOrThrow(COLUMN_TIME_DOWNLOAD_ENQUEUE));
        r11.mTaskOwner = r10.getInt(r10.getColumnIndexOrThrow(COLUMN_TASK_OWNER));
        r11.mJsonData = r10.getString(r10.getColumnIndexOrThrow(COLUMN_ADS_DATA));
        r11.mRetryNum = r10.getInt(r10.getColumnIndexOrThrow(COLUMN_RETRY_NUM));
        r11.fileMd5 = r10.getString(r10.getColumnIndexOrThrow("md5_file"));
        r11.appId = r10.getString(r10.getColumnIndexOrThrow(COLUMN_APP_ID));
        r11.mUpdateModel = r10.getInt(r10.getColumnIndexOrThrow(COLUMN_UPDATE_MODE));
        r11.mSysAppAutoUpdateTaskId = r10.getLong(r10.getColumnIndexOrThrow(COLUMN_SYS_APP_AUTO_UPDATE_TASK_ID));
        return r11;
    L9:
        r14 = false;
        goto L10
    L5:
        r13 = false;
        goto L6
    }
}
