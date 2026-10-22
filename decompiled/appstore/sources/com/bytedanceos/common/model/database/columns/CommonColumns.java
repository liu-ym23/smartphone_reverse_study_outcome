package com.bytedanceos.common.model.database.columns;

import android.net.Uri;
import android.provider.BaseColumns;
import com.bytedanceos.common.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public interface CommonColumns extends BaseColumns {
    public static final String APP_CATEGORY = "app_category";
    public static final String APP_DOWNLOADURL = "app_downloadurl";
    public static final String APP_DOWNLOADURL_BACKUPS = "app_downloadurl_backups";
    public static final String APP_ICON = "app_icon";
    public static final String APP_ID = "app_id";
    public static final String APP_MARK = "app_mark";
    public static final String APP_NAME = "app_name";
    public static final String APP_OPTIME = "app_optime";
    public static final String APP_PACKAGENAME = "app_packagename";
    public static final String APP_REPORT = "app_report";
    public static final String APP_RESERVE = "app_reserve";
    public static final String APP_SCORES = "app_scores";
    public static final String APP_SIGN_SHA256 = "app_sign_sha256";
    public static final String APP_SIZE = "app_size";
    public static final String APP_SOFT_TYPE = "soft_type";
    public static final String APP_SUBTITLE = "app_subtitle";
    public static final String APP_SYNC = "app_synced";
    public static final String APP_TITLE = "app_title";
    public static final String APP_VERSIONCODE = "app_versioncode";
    public static final String APP_VERSIONNAME = "app_versionname";
    public static final String AUTHORITY = null;
    public static final Uri CONTENT_URI = null;
    public static final String CREATE_TIME = "create_time";
    public static final String PARAMETER_LIMIT = "limit";
    public static final String SCHEME = "content://";

    static {
        if (BaseApplication.c().o() == false) goto L5;
        String r10 = "com.obric.appstore";
    L6:
        AUTHORITY = r10;
        CONTENT_URI = Uri.parse(SCHEME + r10);
        return;
    L5:
        r10 = "com.bytedanceos.gamestore";
        goto L6
    }
}
