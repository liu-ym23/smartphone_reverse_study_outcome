package com.bytedanceos.common.model.database.columns;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedanceos.common.model.AdsReportRecordInfo;

/* JADX INFO: loaded from: classes2.dex */
public class AdsReportRecordColumns implements CommonColumns {
    public static final String ADD_COLUMN_SQL_ADS_RETRY_COUNT = "ALTER TABLE ads_report_record ADD COLUMN retry_count_per_day INTEGER";
    public static final String ADS_EVENT_OWNER = "ads_owner";
    public static final String ADS_EVENT_TIME = "event_time";
    public static final String ADS_EVENT_TYPE = "event_type";
    public static final String ADS_IS_UPDATE = "is_appstore_update";
    public static final String ADS_REPORT_MD5 = "url_md5";
    public static final String ADS_REPORT_URL = "report_url";
    public static final String ADS_RETRY_COUNT = "retry_count_per_day";
    public static final String ADS_TITLE = "title";
    public static final String CREATE_SQL = "CREATE TABLE IF NOT EXISTS ads_report_record(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, report_url TEXT, url_md5 TEXT, event_type INTEGER, ads_owner INTEGER, is_appstore_update INTEGER, event_time INTEGER, retry_count_per_day INTEGER );";
    public static final String DROP_SQL = "DROP TABLE IF EXISTS ads_report_record;";
    public static final int EVENT_TYPE_APPINFO_CLICK = 3;
    public static final int EVENT_TYPE_APPINFO_VISIBLE = 1;
    public static final int EVENT_TYPE_BANNER_CLICK = 4;
    public static final int EVENT_TYPE_BANNER_VISIBLE = 2;
    public static final int EVENT_TYPE_DOWNLOAD_START = 5;
    public static final int EVENT_TYPE_DOWNLOAD_SUCCESS = 6;
    public static final int EVENT_TYPE_INSTALL_SUCCESS = 7;
    public static final String PATH = "/ads_report_record";
    public static final String PATH_PACKAGENAME = "/ads_report_record/*";
    public static final String TABLE = "ads_report_record";
    public static final Uri URI = null;

    static {
        URI = Uri.parse(CommonColumns.SCHEME + CommonColumns.AUTHORITY + PATH);
    }

    public AdsReportRecordColumns() {
    }

    public static AdsReportRecordInfo convertDBToRecordInfo(Cursor r10) {
        AdsReportRecordInfo r11 = new AdsReportRecordInfo();
        r11.mID = r10.getInt(r10.getColumnIndexOrThrow("_id"));
        r11.mTitle = r10.getString(r10.getColumnIndexOrThrow("title"));
        r11.mReportUrl = r10.getString(r10.getColumnIndexOrThrow(ADS_REPORT_URL));
        r11.mEventType = r10.getInt(r10.getColumnIndexOrThrow("event_type"));
        r11.mTaskOwner = r10.getInt(r10.getColumnIndexOrThrow(ADS_EVENT_OWNER));
        r11.mUrlMD5 = r10.getString(r10.getColumnIndexOrThrow(ADS_REPORT_MD5));
        r11.mAppUpdate = r10.getInt(r10.getColumnIndexOrThrow(ADS_IS_UPDATE));
        r11.mEventTime = r10.getLong(r10.getColumnIndexOrThrow(ADS_EVENT_TIME));
        r11.mRetriedCount = r10.getInt(r10.getColumnIndexOrThrow(ADS_RETRY_COUNT));
        return r11;
    }

    public static ContentValues convertRecordInfoValues(AdsReportRecordInfo r10) {
        ContentValues r11 = new ContentValues();
        r11.put("title", Integer.valueOf(r10.mID));
        r11.put("title", r10.mTitle);
        r11.put(ADS_REPORT_URL, r10.mReportUrl);
        r11.put(ADS_REPORT_MD5, r10.mUrlMD5);
        r11.put("event_type", Integer.valueOf(r10.mEventType));
        r11.put(ADS_EVENT_OWNER, Integer.valueOf(r10.mTaskOwner));
        r11.put(ADS_IS_UPDATE, Integer.valueOf(r10.mAppUpdate));
        r11.put(ADS_EVENT_TIME, Long.valueOf(r10.mEventTime));
        r11.put(ADS_RETRY_COUNT, Integer.valueOf(r10.mRetriedCount));
        return r11;
    }
}
