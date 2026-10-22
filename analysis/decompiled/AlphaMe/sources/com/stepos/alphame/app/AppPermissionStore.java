package com.stepos.alphame.app;

import android.net.Uri;

/* loaded from: classes.dex */
public class AppPermissionStore {

    public static class PackageStore {
        public static final String AUTHORITY = "com.stepos.safe.alphame.provider";
        public static final String LEVEL_VALUE = "levelValue";
        public static final String OPERATION_VALUE = "operationValue";
        public static final String PATH = "PkgNameIndex";
        public static final String PKG_NAME = "pkgName";
        public static final String TABLE_NAME = "PkgNameIndex";
        public static final String TYPE_VALUE = "typeValue";
        public static final Uri URI = Uri.parse("content://com.stepos.safe.alphame.provider/PkgNameIndex");
        public static final String USER_SETTING_VALUE = "userSettingValue";
    }

    public static class PermissionStore {
        public static final int APP_FREEZE = 2;
        public static final int APP_KEEP = 0;
        public static final int APP_KILL = 3;
        public static final int APP_PERMISSION = 1;
        public static final int MODULE_ALARM = 6;
        public static final int MODULE_CPU = 0;
        public static final int MODULE_GPS = 3;
        public static final int MODULE_GSENSOR = 4;
        public static final String MODULE_ID = "moduleId";
        public static final int MODULE_MODEM = 2;
        public static final int MODULE_WAKE_LOCK = 5;
        public static final int MODULE_WIFI = 1;
        public static final int PERMISSION_ALLOW = 1;
        public static final int PERMISSION_ALLOW_MANUAL = 3;
        public static final int PERMISSION_REJECT = 0;
        public static final int PERMISSION_REJECT_MANUAL = 2;
        public static final String PERMISSION_VALUE = "pvalue";
        public static final String PKG_NAME = "pkgName";
        public static final int STATUS_BACKGROUND = 1;
        public static final int STATUS_FORGROUND = 0;
        public static final int STATUS_STANDBY = 2;
        public static final String STATUS_VALUE = "statusValue";
    }
}
