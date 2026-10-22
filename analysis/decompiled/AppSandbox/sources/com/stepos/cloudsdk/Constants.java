package com.stepos.cloudsdk;

/* loaded from: classes.dex */
public final class Constants {
    public static final String ACTION_CONFIG_UPDATED = "com.stepos.cloudconfig.ACTION_CONFIG_UPDATED";
    public static final String AUTHORITY = "com.stepos.cloudconfig.provider";
    public static final String COLUMN_FILE_ID = "file_id";
    public static final String COLUMN_KEY = "key";
    public static final String COLUMN_PKG = "pkg";
    public static final String COLUMN_RESULT_CODE = "result_code";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_UPDATE_TIME = "update_time";
    public static final String CONTENT_URI_BASE = "content://com.stepos.cloudconfig.provider";
    public static final String EXTRA_KEY = "_key";
    public static final String PATH_CONFIG = "config";
    public static final String PATH_FILE = "file";
    public static final String PATH_STATE = "state";
    public static final String PERMISSION_SEND_CLOUD_CONFIG = "com.stepos.permission.SEND_CLOUD_CONFIG";
    public static final int STATE_FAILED = 2;
    public static final int STATE_PENDING = 0;
    public static final int STATE_SUCCESS = 1;

    private Constants() {
        throw new AssertionError("No ConfigConstants instances for you!");
    }
}
