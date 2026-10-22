package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadDirUtils {
    public static final long CALL_TIME = 0;
    public static String EXT_PUBLIC_DIR = "ByteDownload";
    private static String FAST_TEMP_PATH = null;
    private static final String TAG = "DownloadDirUtils";
    private static volatile File dataDir;
    private static volatile File externalCacheDir;
    private static volatile File externalFilesDir;
    private static volatile File externalStorageDirectory;
    private static volatile File externalStoragePublicDirectory;
    private static volatile File filesDir;
    private static volatile Boolean isExternalStorageLegacy;
    private static volatile File obbDir;

    public DownloadDirUtils() {
    }

    public static String getDefaultExtPublicPath() {
        return getExternalStorageDirectory(false).getPath() + File.separator + DownloadSetting.obtainGlobal().optString(DownloadSettingKeys.DEFAULT_SAVE_DIR_NAME, EXT_PUBLIC_DIR);
    L4:
        e = move-exception;
        Logger.globalError(TAG, "getDefaultExtPublicPath", "Error:" + e);
        return null;
    }

    public static String getExtPublicDownloadPath() {
        return getExternalStoragePublicDirectory(false).getAbsolutePath();
    L5:
        e = move-exception;
        Logger.globalError(TAG, "getExtPublicDownloadPath", "Error:" + e);
        return null;
    }

    public static String getDefaultExtPrivatePath() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L7
        if (r0 == null) goto L13;
        return getExternalFilesDir(r0, false).getAbsolutePath();
    L13:
        return null;
    L7:
        e = move-exception;
        Logger.globalError(TAG, "getDefaultExtPrivatePath", "Error:" + e);
        return null;
    }

    public static String getGlobalSavePath() {
        File r0 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getGlobalSaveDir();     // Catch: Exception -> L7
        if (r0 == null) goto L13;
        return r0.getAbsolutePath();
    L13:
        return null;
    L7:
        e = move-exception;
        Logger.globalError(TAG, "getGlobalSavePath", "Error:" + e);
        return null;
    }

    public static String getDefaultDataPath() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L8;
        File r1 = getFilesDir(r0, false);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getAbsolutePath();
    L8:
        return null;
    }

    public static String getDownloadPath() {
        return getValidDownloadPath(Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getGlobalSaveDir());
    }

    public static String getDownloadTempPath() {
        return getValidDownloadPath(Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getGlobalSaveTempDir());
    }

    public static String getValidDownloadPath(File r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (isValidDirectory(r3) == true) goto L5;
        if (r0 != null) goto L10;
        Logger.globalError(TAG, "getValidDownloadPath", "Context is null");
        return null;
    L10:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_SAVE_EXTERNAL_DIR) > 0) goto L12;
        File r4 = getExternalFilesDir(r0, false);
        if (isValidDirectory(r4) == false) goto L18;
        return r4.getAbsolutePath();
    L18:
        return getDefaultDataPath();
    L12:
        return getDefaultDataPath();
    L5:
        return r3.getAbsolutePath();
    }

    public static boolean isValidDirectory(File r2) {
        if (r2 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L6:
        if (r2.exists() == false) goto L8;
    L10:
        if (r2.isDirectory() == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (r2.mkdirs() == true) goto L10;
        return false;
    }

    public static Uri getRootContentUri() {
        return MediaStore.Files.getContentUri("external");
    }

    public static boolean isSavePathSecurity(String r4) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        File r2 = getDataDirectory(false);     // Catch: Exception -> L17
        if (r2 != null) goto L10;
    L12:
        File r1 = getExternalCacheDir(r0, false);     // Catch: Exception -> L17
        if (r1 == null) goto L19;
        if (r4.startsWith(r1.getParent()) == false) goto L19;
        return true;
    L10:
        if (r4.startsWith(r2.getAbsolutePath()) == false) goto L12;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.globalError(TAG, "isSavePathSecurity", "Error:" + e);
        goto L19
    }

    static {
        CALL_TIME = SystemClock.uptimeMillis();
        FAST_TEMP_PATH = null;
        externalCacheDir = null;
        obbDir = null;
        filesDir = null;
        externalFilesDir = null;
        externalStorageDirectory = null;
        dataDir = null;
        externalStoragePublicDirectory = null;
        isExternalStorageLegacy = null;
    }

    public static String getDownloadFastTempPath() {
        String r1 = FAST_TEMP_PATH;
        if (r1 == null) goto L10;
        return r1;
    L10:
        String r0 = getFilesDir((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((IDownloadComponentManagerService) ZeusTransformUtils.preCheckCast(DownloadServiceManager.getService(IDownloadComponentManagerService.class), IDownloadComponentManagerService.class, "com.obric.aiagent.plugin")).getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), false) + File.separator + "download" + File.separator + "temp_fast_download" + File.separator + CALL_TIME;     // Catch: Throwable -> L7
        FAST_TEMP_PATH = r0;     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "getDownloadFastTempPath", "Error:" + th);
        return null;
    }

    public static File getExternalCacheDir(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (externalCacheDir == null) goto L13;
        if (r3 == true) goto L13;
        return externalCacheDir;
    L13:
        externalCacheDir = r4.getExternalCacheDir();     // Catch: Throwable -> L9
    L12:
        return externalCacheDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalCacheDir", "Error:" + th);
        goto L12
    }

    public static File getObbDirStr(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (obbDir == null) goto L13;
        if (r3 == true) goto L13;
        return obbDir;
    L13:
        obbDir = r4.getObbDir();     // Catch: Throwable -> L9
    L12:
        return obbDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getObbDirStr", "Error:" + th);
        goto L12
    }

    public static File getFilesDir(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (filesDir == null) goto L13;
        if (r3 == true) goto L13;
        return filesDir;
    L13:
        filesDir = r4.getFilesDir();     // Catch: Throwable -> L9
    L12:
        return filesDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getFilesDir", "Error:" + th);
        goto L12
    }

    public static File getExternalFilesDir(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (externalFilesDir == null) goto L13;
        if (r3 == true) goto L13;
        return externalFilesDir;
    L13:
        externalFilesDir = r4.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return externalFilesDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalFilesDir", "Error:" + th);
        goto L12
    }

    public static File getExternalStorageDirectory(boolean r2) {
        if (externalStorageDirectory == null) goto L13;
        if (r2 == true) goto L13;
        return externalStorageDirectory;
    L13:
        externalStorageDirectory = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L9
    L12:
        return externalStorageDirectory;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalStorageDirectory", "Error:" + th);
        goto L12
    }

    public static File getDataDirectory(boolean r2) {
        if (dataDir == null) goto L13;
        if (r2 == true) goto L13;
        return dataDir;
    L13:
        dataDir = Environment.getDataDirectory();     // Catch: Throwable -> L9
    L12:
        return dataDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getDataDirectory", "Error:" + th);
        goto L12
    }

    public static File getExternalStoragePublicDirectory(boolean r2) {
        if (externalStoragePublicDirectory == null) goto L13;
        if (r2 == true) goto L13;
        return externalStoragePublicDirectory;
    L13:
        externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return externalStoragePublicDirectory;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalStoragePublicDirectory", "Error:" + th);
        goto L12
    }

    public static boolean isExternalStorageLegacy(boolean r2) {
        if (isExternalStorageLegacy == null) goto L16;
        if (r2 == true) goto L16;
        return isExternalStorageLegacy.booleanValue();
    L16:
    L12:
        th = move-exception;
        Logger.globalError(TAG, "isExternalStorageLegacy", "Error:" + th);
    L15:
        return isExternalStorageLegacy.booleanValue();
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        isExternalStorageLegacy = Boolean.valueOf(Environment.isExternalStorageLegacy());     // Catch: Throwable -> L12
        goto L15
    L10:
        isExternalStorageLegacy = false;     // Catch: Throwable -> L12
        goto L15
    }

    public static void forceLoadStoragePathCache(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        getExternalCacheDir(r3, true);
        getObbDirStr(r3, true);
        getFilesDir(r3, true);
        getExternalFilesDir(r3, true);
        getExternalStorageDirectory(true);
        getDataDirectory(true);
        getExternalStoragePublicDirectory(true);
        isExternalStorageLegacy(true);
    }
}
