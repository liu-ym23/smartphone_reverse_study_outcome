package android.app;

import android.app.CtaPermissionTexts;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSPermissionManager {

    @Deprecated
    public static final int AOSP_OP = 10000;
    public static final String CTA_REVIEW_ACTION = "com.stepos.permission.intent.action.CTA_REVIEW";

    @Deprecated
    public static final String DIRECTORY_ALARMS = "Alarms";

    @Deprecated
    public static final String DIRECTORY_ANDROID = "Android";

    @Deprecated
    public static final String DIRECTORY_AUDIOBOOKS = "Audiobooks";

    @Deprecated
    public static final String DIRECTORY_DCIM = "DCIM";

    @Deprecated
    public static final String DIRECTORY_DOCUMENTS = "Documents";

    @Deprecated
    public static final String DIRECTORY_DOWNLOADS = "Download";

    @Deprecated
    public static final String DIRECTORY_MEDIA = "media";

    @Deprecated
    public static final String DIRECTORY_MOVIES = "Movies";

    @Deprecated
    public static final String DIRECTORY_MUSIC = "Music";

    @Deprecated
    public static final String DIRECTORY_NOTIFICATIONS = "Notifications";

    @Deprecated
    public static final String DIRECTORY_PICTURES = "Pictures";

    @Deprecated
    public static final String DIRECTORY_PODCASTS = "Podcasts";

    @Deprecated
    public static final String DIRECTORY_RINGTONES = "Ringtones";

    @Deprecated
    public static final String DIRECTORY_THUMBNAILS = ".thumbnails";
    public static final String INTENT_NETMSG = "INTENT_NETMSG";
    public static final String INTENT_SHORTCUT = "INTENT_SHORTCUT";

    @Deprecated
    public static final int MODE_ALLOWED = 0;

    @Deprecated
    public static final int MODE_DIR_ALLOWED = 0;

    @Deprecated
    public static final int MODE_DIR_DEFAULT = -1;

    @Deprecated
    public static final int MODE_DIR_DENIED = 2;

    @Deprecated
    public static final int MODE_DIR_PART_ALLOWED = 1;

    @Deprecated
    public static final int MODE_DIR_PART_ALLOWED_RETURN_TO_MEDIA = 10;

    @Deprecated
    public static final int MODE_ERRORED = 2;

    @Deprecated
    public static final int MODE_IGNORED = 1;

    @Deprecated
    public static final int OP_ACCESS_EM_ACCOUNT = 104;

    @Deprecated
    public static final int OP_ACCESS_EM_APPS = 107;

    @Deprecated
    public static final int OP_ACCESS_EM_CALENDAR = 106;

    @Deprecated
    public static final int OP_ACCESS_EM_CALL_LOG = 105;

    @Deprecated
    public static final int OP_ACCESS_EM_CLIPBOARD = 108;

    @Deprecated
    public static final int OP_ACCESS_EM_CONTACTS = 103;

    @Deprecated
    public static final int OP_ACCESS_EM_IMEI = 101;

    @Deprecated
    public static final int OP_ACCESS_EM_SMS_MMS = 102;

    @Deprecated
    public static final int OP_ACCESS_EM_SMS_RECEIVED = 114;

    @Deprecated
    public static final int OP_ACCESS_LIMIT_URL = 113;

    @Deprecated
    public static final int OP_ACCESS_MEDIA_LOCATION = 100;

    @Deprecated
    public static final int OP_ACCESS_NETWORK = 111;

    @Deprecated
    public static final int OP_ACCESS_NOTIFICATIONS = 25;

    @Deprecated
    public static final int OP_ACTIVITY_RECOGNITION = 79;

    @Deprecated
    public static final int OP_AI_READ_CLIPBOARD = 200;

    @Deprecated
    public static final int OP_AUDIO_ALARM_VOLUME = 37;

    @Deprecated
    public static final int OP_AUDIO_BLUETOOTH_VOLUME = 39;

    @Deprecated
    public static final int OP_AUDIO_FM_VOLUME = 43;

    @Deprecated
    public static final int OP_AUDIO_MASTER_VOLUME = 33;

    @Deprecated
    public static final int OP_AUDIO_MATV_VOLUME = 44;

    @Deprecated
    public static final int OP_AUDIO_MEDIA_VOLUME = 36;

    @Deprecated
    public static final int OP_AUDIO_NOTIFICATION_VOLUME = 38;

    @Deprecated
    public static final int OP_AUDIO_RING_VOLUME = 35;

    @Deprecated
    public static final int OP_AUDIO_VOICE_VOLUME = 34;

    @Deprecated
    public static final int OP_AUTORUN = 65;

    @Deprecated
    public static final int OP_CALL_PHONE = 13;

    @Deprecated
    public static final int OP_CAMERA = 76;

    @Deprecated
    public static final int OP_COARSE_LOCATION = 0;

    @Deprecated
    public static final int OP_CONNECT_INTERNET = 58;

    @Deprecated
    public static final int OP_DELETE_CALL_LOG = 64;

    @Deprecated
    public static final int OP_DELETE_CONTACTS = 63;

    @Deprecated
    public static final int OP_DELETE_MMS = 62;

    @Deprecated
    public static final int OP_DELETE_SMS = 61;

    @Deprecated
    public static final int OP_DIR_FILES = 202;

    @Deprecated
    public static final int OP_DIR_GALLERY = 201;

    @Deprecated
    public static final int OP_DIR_STORAGE_FG = 211;

    @Deprecated
    public static final int OP_ENABLE_BLUETOOTH = 77;

    @Deprecated
    public static final int OP_ENABLE_MOBILE_DATA = 69;

    @Deprecated
    public static final int OP_ENABLE_WIFI = 68;

    @Deprecated
    public static final int OP_FINE_LOCATION = 1;

    @Deprecated
    public static final int OP_FUZZY_LOCATION = 110;

    @Deprecated
    public static final int OP_GET_INSTALL_PKG = 56;

    @Deprecated
    public static final int OP_GPS = 2;

    @Deprecated
    public static final int OP_LOCAL_NETWORK = 112;

    @Deprecated
    public static final int OP_LOCATION = 75;

    @Deprecated
    public static final int OP_MAC_ADDRESS = 80;

    @Deprecated
    public static final int OP_MONITOR_HIGH_POWER_LOCATION = 42;

    @Deprecated
    public static final int OP_MONITOR_LOCATION = 41;

    @Deprecated
    public static final int OP_NEIGHBORING_CELLS = 12;

    @Deprecated
    public static final int OP_NONE = -1;

    @Deprecated
    public static final int OP_PLAY_AUDIO = 28;

    @Deprecated
    public static final int OP_POST_NOTIFICATION = 11;

    @Deprecated
    public static final int OP_PROJECT_MEDIA = 46;

    @Deprecated
    public static final int OP_READ_CALENDAR = 8;

    @Deprecated
    public static final int OP_READ_CALL_LOG = 6;

    @Deprecated
    public static final int OP_READ_CLIPBOARD = 29;

    @Deprecated
    public static final int OP_READ_CONTACTS = 4;

    @Deprecated
    public static final int OP_READ_DIR_ANDROID = 207;

    @Deprecated
    public static final int OP_READ_DIR_AUDIO = 203;

    @Deprecated
    public static final int OP_READ_DIR_DOCUMENTS = 206;

    @Deprecated
    public static final int OP_READ_DIR_DOWNLOAD = 205;

    @Deprecated
    public static final int OP_READ_DIR_GALLERY = 204;

    @Deprecated
    public static final int OP_READ_DIR_HIDE = 209;

    @Deprecated
    public static final int OP_READ_DIR_OTHER = 208;

    @Deprecated
    public static final int OP_READ_DIR_ROOT_FILE = 210;

    @Deprecated
    public static final int OP_READ_ICC_SMS = 21;

    @Deprecated
    public static final int OP_READ_MMS = 66;

    @Deprecated
    public static final int OP_READ_PHONE_STATE = 73;

    @Deprecated
    public static final int OP_READ_SMS = 14;

    @Deprecated
    public static final int OP_RECEIVE_EMERGECY_SMS = 17;

    @Deprecated
    public static final int OP_RECEIVE_MMS = 18;

    @Deprecated
    public static final int OP_RECEIVE_SMS = 16;

    @Deprecated
    public static final int OP_RECEIVE_WAP_PUSH = 19;

    @Deprecated
    public static final int OP_RECORD_AUDIO = 27;

    @Deprecated
    public static final int OP_SEND_MMS = 67;

    @Deprecated
    public static final int OP_SEND_SHORTCUT_BROADCAST = 59;

    @Deprecated
    public static final int OP_SEND_SMS = 20;

    @Deprecated
    public static final int OP_SENSOR_EVENT = 78;

    @Deprecated
    public static final int OP_SYSTEM_ALERT_WINDOW = 24;

    @Deprecated
    public static final int OP_TAKE_AUDIO_FOCUS = 32;

    @Deprecated
    public static final int OP_TAKE_MEDIA_BUTTONS = 31;

    @Deprecated
    public static final int OP_VIBRATE = 3;

    @Deprecated
    public static final int OP_WAKE_LOCK = 40;

    @Deprecated
    public static final int OP_WIFI_SCAN = 10;

    @Deprecated
    public static final int OP_WRITE_CALENDAR = 9;

    @Deprecated
    public static final int OP_WRITE_CALL_LOG = 7;

    @Deprecated
    public static final int OP_WRITE_CLIPBOARD = 30;

    @Deprecated
    public static final int OP_WRITE_CONTACTS = 5;

    @Deprecated
    public static final int OP_WRITE_ICC_SMS = 22;

    @Deprecated
    public static final int OP_WRITE_MMS = 60;

    @Deprecated
    public static final int OP_WRITE_SETTINGS = 23;

    @Deprecated
    public static final int OP_WRITE_SMS = 15;
    public static final boolean SUPPORT_GET_INSTALLPKG_PERMISSION = true;
    public static final boolean SUPPORT_SHORTCUT_PERMISSION = true;

    @Deprecated
    public static final int _NUM_OP = 80;
    public static final String TAG_CTA = "cnalifs";
    public static boolean DEBUG_CTA = Log.isLoggable(TAG_CTA, 3);
    public static final String TAG = "StepOSPermissionManager";
    public static boolean DEBUG = Log.isLoggable(TAG, 3);
    public static boolean ISCHECK = true;
    public static boolean IS_CTA_LEVEL_4_CHECK = false;
    public static final boolean IS_CTA_TESTER = SystemProperties.getBoolean("persist.sys.perm.ctatester", false);

    @Deprecated
    public static final int[] DIR_OP_ALL = CtaOpCodes.DIR_OP_ALL;

    @Deprecated
    public static final int[] DIR_VIRTUAL_OP = CtaOpCodes.DIR_VIRTUAL_OP;
    private static boolean deviceProvisioned = false;

    @Deprecated
    public static boolean isGranted(int privilege, String hostMsg) {
        return CtaPermissionGate.isGranted(privilege, hostMsg);
    }

    @Deprecated
    public static boolean isGranted(int privilege, String callingPkg, int uid, int pid) {
        return CtaPermissionGate.isGranted(privilege, callingPkg, uid, pid);
    }

    @Deprecated
    public static boolean isGranted(int privilege, int uid, int pid) {
        return CtaPermissionGate.isGranted(privilege, uid, pid);
    }

    @Deprecated
    public static boolean isGranted(int privilege, int uid, int pid, Intent intent) {
        return CtaPermissionGate.isGranted(privilege, uid, pid, intent);
    }

    @Deprecated
    public static int checkDirFilePermission(int privilege, int uid, int pid, String topName, String path, Intent intent) {
        return CtaPermissionGate.checkDirFilePermission(privilege, uid, pid, topName, path, intent);
    }

    @Deprecated
    public static int isGrantedForTopDir(int privilege, int uid, int pid, String topName, String path, Intent intent) {
        return CtaPermissionGate.isGrantedForTopDir(privilege, uid, pid, topName, path, intent);
    }

    @Deprecated
    public static int[] isGrantedForMedia(int privilege, int uid, int pid) {
        return CtaPermissionGate.isGrantedForMedia(privilege, uid, pid);
    }

    @Deprecated
    public static boolean isGranted(int privilege, String callingPkg, int uid, int pid, Intent intent) {
        return CtaPermissionGate.isGranted(privilege, callingPkg, uid, pid, intent);
    }

    @Deprecated
    public static boolean isStepOSPermissionGranted(int privilege) {
        return CtaPermissionGate.isStepOSPermissionGranted(privilege);
    }

    @Deprecated
    public static boolean isSendBroacastGranted(int privilege, Intent intent) {
        return CtaPermissionGate.isSendBroacastGranted(privilege, intent);
    }

    @Deprecated
    public static boolean isStepOSPermissionGranted(int privilege, String callingPkg) {
        return CtaPermissionGate.isStepOSPermissionGranted(privilege, callingPkg);
    }

    @Deprecated
    public static boolean isStepOSPermissionGranted(int privilege, int uid, String callingPkg) {
        return CtaPermissionGate.isStepOSPermissionGranted(privilege, uid, callingPkg);
    }

    @Deprecated
    public static boolean checkWriteSms(String callingPkg, Uri uri) {
        return CtaPermissionGate.checkWriteSms(callingPkg, uri);
    }

    @Deprecated
    public static class TitleAndContent extends CtaPermissionTexts.TitleAndContent {
        TitleAndContent(String title, String content) {
            super(title, content);
        }
    }

    @Deprecated
    public static TitleAndContent getAppOpsDetails(Context context, int op) throws Resources.NotFoundException {
        CtaPermissionTexts.TitleAndContent r = CtaPermissionTexts.getAppOpsDetails(context, op);
        return new TitleAndContent(r.title, r.content);
    }

    @Deprecated
    public static TitleAndContent getPermissonTypeDetails(Context mContext, int code) throws Resources.NotFoundException {
        CtaPermissionTexts.TitleAndContent r = CtaPermissionTexts.getPermissonTypeDetails(mContext, code);
        return new TitleAndContent(r.title, r.content);
    }

    @Deprecated
    public static boolean isSystemSignatures(String packageName) {
        return CtaPackageLists.isSystemSignatures(packageName);
    }

    @Deprecated
    public static boolean isSystemApp(String packageName) {
        return CtaPackageLists.isSystemApp(packageName);
    }

    @Deprecated
    public static boolean isLegacyApp(String packageName) {
        return CtaPackageLists.isLegacyApp(packageName);
    }

    @Deprecated
    public static boolean isLegacyAppRequstMedia(String packageName) {
        return CtaPackageLists.isLegacyAppRequestMedia(packageName);
    }

    @Deprecated
    private static boolean isSystemApp(int uid) {
        return CtaPackageLists.isSystemAppByUid(uid);
    }

    @Deprecated
    private static void printPermissionTrace(String pkg, int op) {
        CtaPermissionTrace.printPermissionTrace(pkg, op);
    }

    @Deprecated
    public static void printPermissionTrace(String msg) {
        CtaPermissionTrace.printPermissionTraceConnect(msg);
    }

    @Deprecated
    public static void printPermissionTrace(int uid, int op, String pkg) {
        CtaPermissionTrace.printPermissionTrace(uid, op, pkg);
    }

    @Deprecated
    public static void printPermissionTraceForCtaTest(String stackTrace, int op, String pkg, int uid, int pid, boolean isOp) {
        CtaPermissionTrace.printPermissionTraceForCtaTest(stackTrace, op, pkg, uid, pid, isOp);
    }

    @Deprecated
    public static boolean isCtaOps(int op) {
        return CtaOpCodes.isCtaOps(op);
    }

    private static boolean isNotShowOp(int op) {
        return CtaOpCodes.isNotShowOp(op);
    }

    @Deprecated
    public static void printPermissionTrace(int uid, int pid, String pkg, int op) {
        CtaPermissionTrace.printPermissionTrace(uid, pid, pkg, op);
    }

    @Deprecated
    public static void askOpsOperation(int uid, String packageName, int switchCode) {
        CtaPermissionNotifier.askOpsOperation(uid, packageName, switchCode);
    }

    @Deprecated
    public static void clearOpsOperation(int uid) {
        CtaPermissionNotifier.clearOpsOperation(uid);
    }

    @Deprecated
    public static void writeOpAskState() {
        CtaPermissionNotifier.writeOpAskState();
    }

    @Deprecated
    public static void systemReady() {
        CtaPermissionNotifier.systemReady();
    }

    @Deprecated
    public static boolean isCtaPermissionsReviewRequired(Context context, String pkg, int userId) {
        return CtaPermissionNotifier.isCtaPermissionsReviewRequired(context, pkg, userId);
    }

    @Deprecated
    public static void setCtaPermissionsReviewRequired(Context context, String pkg, int value, int userId) {
        CtaPermissionNotifier.setCtaPermissionsReviewRequired(context, pkg, value, userId);
    }

    @Deprecated
    public static void showPermissionNotice(int uid, int op, String pkg, boolean isNote) {
        CtaPermissionNotifier.showPermissionNotice(uid, op, pkg, isNote);
    }

    @Deprecated
    public static void cancelPermissionNotice(int op, String pkg) {
        CtaPermissionNotifier.cancelPermissionNotice(op, pkg);
    }

    @Deprecated
    public static void cancelUninstallPermissionNotice(int op, String pkg) {
        CtaPermissionNotifier.cancelUninstallPermissionNotice(op, pkg);
    }

    @Deprecated
    public static boolean filterOp(int op) {
        return CtaOpCodes.filterOp(op);
    }

    @Deprecated
    public static boolean filterBackgroundOp(int op) {
        return CtaOpCodes.filterBackgroundOp(op);
    }

    @Deprecated
    public static boolean filterAppHistoricalsOp(int op) {
        return CtaOpCodes.filterAppHistoricalsOp(op);
    }

    @Deprecated
    public static boolean isSysAppSpecificPerm(String packageName, int op) {
        return CtaPackageLists.isSysAppSpecificPerm(packageName, op);
    }

    @Deprecated
    public static boolean needRecordPermission(String packageName, int op) {
        return CtaPermissionTrace.needRecordPermission(packageName, op);
    }

    @Deprecated
    public static String getRealTime(long timestap) {
        return CtaPermissionTrace.getRealTime(timestap);
    }

    @Deprecated
    public static boolean sameAppHistorical(String lastpkg, int lastop, String laststatus, String lastpermuse, long lasttimestap, String nowpkg, int nowop, String nowstatus, String nowpermuse, long nowtimestap) {
        return CtaPermissionTrace.sameAppHistorical(lastpkg, lastop, laststatus, lastpermuse, lasttimestap, nowpkg, nowop, nowstatus, nowpermuse, nowtimestap);
    }

    @Deprecated
    public static boolean filterUidStateStatus(int uidStateTime) {
        return CtaPermissionTrace.filterUidStateStatus(uidStateTime);
    }

    @Deprecated
    public static boolean filterAccessTime(long accessTime, long beforeTime) {
        return CtaPermissionTrace.filterAccessTime(accessTime, beforeTime);
    }

    @Deprecated
    public static boolean outOfTime(String oldTime, String nowTime) {
        return CtaPermissionTrace.outOfTime(oldTime, nowTime);
    }

    @Deprecated
    public static int matchUriToOp(String authority) {
        return CtaOpCodes.matchUriToOp(authority);
    }

    @Deprecated
    public static boolean matchEmOp(int op) {
        return CtaOpCodes.matchEmOp(op);
    }

    private static boolean checkEmptyPermission(int op, String callingPkg, int uid) {
        return CtaPermissionGate.checkEmptyPermission(op, callingPkg, uid);
    }

    @Deprecated
    public static boolean needShowSensitiveNotice(String pkg) {
        return CtaPackageLists.needShowSensitiveNotice(pkg);
    }

    @Deprecated
    public static boolean isControlApps(String pkg) {
        return CtaPackageLists.isControlApps(pkg);
    }

    @Deprecated
    public static boolean isGMSApps(String pkg) {
        return CtaPackageLists.isGMSApps(pkg);
    }

    @Deprecated
    public static boolean isNeedShowPermissionManagementApps(String pkg) {
        return CtaPackageLists.isNeedShowPermissionManagementApps(pkg);
    }

    @Deprecated
    public static boolean isExposeSystemAppAppListPermission(String packageName, int privilege) {
        return CtaPackageLists.isExposeSystemAppAppListPermission(packageName, privilege);
    }

    @Deprecated
    public static List<String> getExposeInstallPkgPermissionPkgsList() {
        return CtaPackageLists.getExposeInstallPkgPermissionPkgsList();
    }

    @Deprecated
    private static void getLaunchSystemApp() {
        CtaPackageLists.registerLaunchSystemAppCollector();
    }

    @Deprecated
    public static boolean hasLaunchSystemApp(String pkg) {
        return CtaPackageLists.hasLaunchSystemApp(pkg);
    }

    @Deprecated
    public static boolean sysAppConfigPerm(String packageName, int op) {
        return CtaPackageLists.sysAppConfigPerm(packageName, op);
    }

    @Deprecated
    public static String getFileName(String filepath) {
        return CtaDirAccessStore.getFileName(filepath);
    }

    @Deprecated
    public static boolean accept(File file, String path, String name) {
        return CtaDirAccessStore.accept(file, path, name);
    }

    @Deprecated
    public static boolean isDirOp(int op) {
        return CtaOpCodes.isDirOp(op);
    }

    @Deprecated
    public static String getDirName(int op) {
        return CtaPermissionTexts.getDirName(op);
    }

    @Deprecated
    public static int checkTopDirAccessPermission(String pkg, String topName, String path) {
        return CtaDirAccessStore.checkTopDirAccessPermission(pkg, topName, path);
    }

    @Deprecated
    public static void wirteTopDirAccessPermission(String pkg, String topName, int value) {
        CtaDirAccessStore.wirteTopDirAccessPermission(pkg, topName, value);
    }

    @Deprecated
    public static void wirteTopDirAccessPermissionDefault(String pkg, String topName, int value, int tag, int priority) {
        CtaDirAccessStore.wirteTopDirAccessPermissionDefault(pkg, topName, value, tag, priority);
    }

    @Deprecated
    public static String getPkgForExclusiveDirectory(String callerPkg, String topName, String path) {
        return CtaDirAccessStore.getPkgForExclusiveDirectory(callerPkg, topName, path);
    }

    @Deprecated
    public static int checkPkgForExclusiveDirectory(String pkg, String topName, String path) {
        return CtaDirAccessStore.checkPkgForExclusiveDirectory(pkg, topName, path);
    }

    public static int isWebViewNetBlocked() {
        if (deviceProvisioned) {
            return -1;
        }
        try {
            Application application = ActivityThread.currentApplication();
            int anInt = Settings.Global.getInt(application.getContentResolver(), "device_provisioned");
            if (anInt == 1) {
                deviceProvisioned = true;
                return -1;
            }
            if (!"com.google.android.webview".equals(application.getPackageName())) {
                return 0;
            }
            new Exception("block com.google.android.webview 联网").printStackTrace();
            return 1;
        } catch (Throwable t) {
            t.printStackTrace();
            return 0;
        }
    }
}
