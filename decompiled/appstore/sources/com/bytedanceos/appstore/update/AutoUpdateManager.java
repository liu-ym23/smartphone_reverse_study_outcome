package com.bytedanceos.appstore.update;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedanceos.appstore.buss.utilities.s;
import com.bytedanceos.appstore.datacache.a;
import com.bytedanceos.appstore.network.ObricAPIHelper;
import com.bytedanceos.appstore.utils.c;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.networkv2.params.NetKey;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.c0;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.d0;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.k;
import com.obric.appstore.R;
import com.smt.obric.appstore.domain.app.entity.AppInstallMode;
import com.smt.obric.appstore.domain.sysapp.autoupdate.GetSysAppAutoUpdateWhitelistUseCase;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AutoUpdateManager {
    private static final String HTTP_PARAMS_APP_NAME = "name";
    private static final String HTTP_PARAMS_APP_VER = "appver";
    private static final String HTTP_PARAMS_IMEI = "imei";
    private static final String HTTP_PARAMS_OS_VER = "osver";
    private static String SPLIT = "#";
    public static final int UPDATE_MODEL_DEFAULT = 1;
    public static final int UPDATE_MODEL_FORCE = 2;
    public static final int UPDATE_MODEL_SILENCE_MOBILE = 4;
    public static final int UPDATE_MODEL_SILENCE_WIFI = 3;
    private static String XML_FILE_NAME = "app_auto_update";
    private LinkedHashMap<String, AppUpdateInfo> mAppUpdateInfos;
    private final Set<String> mAppUpdateRequestKeys;
    private final AutoUpdateManagerKtx mKtx;

    public static class AppUpdateInfo {
        public long mCheckUpdateTime;
        public String mPackageName;
        public Bundle mUpdateInfo;

        public AppUpdateInfo(String r10, long r11, Bundle r12) {
            this.mPackageName = r10;
            this.mCheckUpdateTime = r11;
            this.mUpdateInfo = r12;
        }
    }

    static {
    }

    public AutoUpdateManager() {
        this.mKtx = new AutoUpdateManagerKtx();
        this.mAppUpdateInfos = new LinkedHashMap();
        this.mAppUpdateRequestKeys = new HashSet();
    }

    private String buildAppUpdateRequestKey(String r10, int r11) {
        return r10 + SPLIT + r11;
    }

    private void checkDependApp(Context r10, Bundle r11, String r12) {
        String r13 = r11.getString("auto_update_pkg");
        String r14 = r11.getString("depend_pkg");
        String r15 = r11.getString("depend_url");
        if (TextUtils.isEmpty(r14) == false) goto L5;
    L22:
        j.a("params error:" + r14 + "|" + r15);
        return;
    L5:
        if (TextUtils.equals(r13, r14) == true) goto L22;
        if (TextUtils.isEmpty(r15) == true) goto L22;
        PackageInfo r16 = r10.getPackageManager().getPackageInfo(r14, 0);     // Catch: Exception -> L12
    L14:
        int r17 = r11.getInt("depend_ver");
        if (r16 != null) goto L17;
    L20:
        AppInfo r18 = new AppInfo();
        r18.appSource = r12;
        r18.appPackageName = r14;
        r18.appDownloadUrl = r15;
        r18.mIsNeedGms = false;
        com.bytedanceos.common.utils.j.a(r10, r18, r11.getBoolean("useMobile"));
        return;
    L17:
        if (r16.versionCode < r17) goto L20;
        j.a("dependVer:" + r17 + "| system ver:" + r16.versionCode);
        return;
    L12:
        e = move-exception;
        j.a(e.getMessage());
        r16 = null;
        goto L14
    }

    private void finishAppUpdateRequest(String r10) {
        Set<String> r11 = this.mAppUpdateRequestKeys;
        monitor-enter(r11);
        this.mAppUpdateRequestKeys.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private Bundle getApkInfo(Context r10, String r11, int r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        j.e("getApkInfo path is null");
        return null;
    L6:
        if (r12 != 0) goto L22;
        j.e("getApkInfo versionCode is null");
        return null;
    L22:
        File r13 = new File(e.H(), r11 + "_" + r12 + "_bak.apk");     // Catch: Exception -> L12
        String r14 = c.e(r13);     // Catch: Exception -> L12
        PackageInfo r15 = r10.getPackageManager().getPackageArchiveInfo(r13.toString(), 1);     // Catch: Exception -> L12
        if (r15 == null) goto L14;
        String r16 = r15.packageName;     // Catch: Exception -> L12
    L15:
        if (r15 == null) goto L17;
        int r17 = r15.versionCode;     // Catch: Exception -> L12
    L18:
        Bundle r18 = new Bundle();     // Catch: Exception -> L12
        r18.putString("auto_update_md5", r14);     // Catch: Exception -> L12
        r18.putString("auto_update_pkg", r16);     // Catch: Exception -> L12
        r18.putInt("auto_update_version_code", r17);     // Catch: Exception -> L12
        return r18;
    L17:
        r17 = 0;
        goto L18
    L14:
        r16 = "";
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private Bundle getAppInfoBundle(Context r10, String r11, boolean r12) throws Exception {
        int r13 = r10.getPackageManager().getPackageInfo(r11, 0).versionCode;
        String r14 = buildAppUpdateRequestKey(r11, r13);
        Bundle r15 = null;
        if (r12 == true) goto L25;
        LinkedHashMap<String, AppUpdateInfo> r16 = this.mAppUpdateInfos;
        monitor-enter(r16);
        AppUpdateInfo r17 = this.mAppUpdateInfos.get(r11);     // Catch: Throwable -> L21
        monitor-exit(r16);     // Catch: Throwable -> L21
        if (r17 == null) goto L25;
        if (TextUtils.equals(r11, r17.mPackageName) == false) goto L25;
        if ((System.currentTimeMillis() - r17.mCheckUpdateTime) >= 3600000) goto L25;
        Bundle r18 = r17.mUpdateInfo;
        if (r18 != null) goto L16;
    L19:
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle, update frequently:" + (System.currentTimeMillis() - r17.mCheckUpdateTime));
        return null;
    L16:
        if (r18.getInt("auto_update_version_code") <= r13) goto L19;
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle, use cache data:" + r17.mUpdateInfo);
        return new Bundle(r17.mUpdateInfo);
    L21:
        th = move-exception;
        throw th;
    L25:
        if (markAppUpdateRequestInFlight(r14) == true) goto L54;
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle duplicate request, return null. pkgName:" + r11 + " | versionCode:" + r13 + " | forceCheck:" + r12);
        return null;
    L54:
        LinkedHashMap<String, AppUpdateInfo> r19 = this.mAppUpdateInfos;     // Catch: Throwable -> L42
        monitor-enter(r19);     // Catch: Throwable -> L42
        this.mAppUpdateInfos.remove(r11);     // Catch: Throwable -> L49
        monitor-exit(r19);     // Catch: Throwable -> L49
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle start request. pkgName:" + r11 + " | versionCode:" + r13 + " | forceCheck:" + r12);     // Catch: Throwable -> L42
        Bundle r20 = ObricAPIHelper.f9432a.p(r11, r13);     // Catch: Throwable -> L42
        if (r20 == null) goto L44;
        AppUpdateInfo r21 = new AppUpdateInfo(r11, System.currentTimeMillis(), new Bundle(r20));     // Catch: Throwable -> L42
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle -------> " + r21.mUpdateInfo);     // Catch: Throwable -> L42
        LinkedHashMap<String, AppUpdateInfo> r22 = this.mAppUpdateInfos;     // Catch: Throwable -> L42
        monitor-enter(r22);     // Catch: Throwable -> L42
        this.mAppUpdateInfos.put(r11, r21);     // Catch: Throwable -> L39
        monitor-exit(r22);     // Catch: Throwable -> L39
    L45:
        if (r20 == null) goto L47;
        r15 = new Bundle(r20);     // Catch: Throwable -> L42
    L47:
        finishAppUpdateRequest(r14);
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle finish request. pkgName:" + r11 + " | versionCode:" + r13 + " | forceCheck:" + r12);
        return r15;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L44:
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle bundle is null." + r11);     // Catch: Throwable -> L42
        goto L45
    L49:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        finishAppUpdateRequest(r14);
        j.n("[AutoUpdate] AutoUpdateManager getAppInfoBundle finish request. pkgName:" + r11 + " | versionCode:" + r13 + " | forceCheck:" + r12);
        throw th;
    }

    private File getDownloadFile(String r10, int r11) {
        return new File(e.H(), r10 + "_" + r11 + "_bak.apk");
    }

    @Nullable
    private static AppInstallMode getInstallMode(Bundle r10) {
        if (r10.containsKey("auto_update_install_mode") == true) goto L7;
        return null;
    L7:
        return AppInstallMode.Companion.a(r10.getInt("auto_update_install_mode"));
    }

    private Map<String, String> getRequestParams(Context r10, String r11, int r12) {
        HashMap r13 = new HashMap();
        r13.put("imei", BaseApplication.c().i().getClientId());     // Catch: Exception -> L6
        r13.put("name", r11);     // Catch: Exception -> L6
        r13.put(HTTP_PARAMS_APP_VER, String.valueOf(r12));     // Catch: Exception -> L6
        r13.put(HTTP_PARAMS_OS_VER, e.U(false));     // Catch: Exception -> L6
        r13.put("androidver", String.valueOf(Build.VERSION.RELEASE));     // Catch: Exception -> L6
        String r14 = SystemProperties.get("ro.product.submodel", "");     // Catch: Exception -> L6
        String r15 = String.valueOf(d.f10009a);     // Catch: Exception -> L6
        if (TextUtils.isEmpty(r14) == true) goto L8;
        r15 = r15 + "-" + r14;     // Catch: Exception -> L6
    L8:
        r13.put(NetKey.MODEL, r15);     // Catch: Exception -> L6
    L11:
        return r13;
    L6:
        e = move-exception;
        e.printStackTrace();
        j.a("RequestParams:" + e.getMessage());
        goto L11
    }

    private boolean isAppDownloading(Context r10, String r11) {
        int r12 = 0;
    L4:
        if (a.N0().O0() == true) goto L13;
        if (r12 >= 3) goto L13;
        r12 = r12 + 1;
        j.n("isAppDownloading : packageName = " + r11 + " wait init " + r12);
        Thread.sleep(500);     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L13:
        AppInfo r13 = a.N0().t(r11);
        if (r13 != null) goto L16;
        return false;
    L16:
        int r14 = r13.downloadStatus;
        if (r14 == 2) goto L21;
        if (r14 == 1) goto L21;
        return false;
    L21:
        return true;
    }

    private boolean isFileDownloaded(Context r10, String r11, int r12, String r13) {
        File r14 = getDownloadFile(r13, r12);
        if (r14.exists() == false) goto L10;
        String r15 = k.e(r14);
        if (TextUtils.equals(r11, r15) == true) goto L8;
        r14.delete();
        j.n("appPkgName : fileMD5Code = " + r15 + " | apkMD5Code = " + r11);
        return false;
    L8:
        return true;
    L10:
        return false;
    }

    private boolean isFileExist(Context r10, Bundle r11) {
        String r12 = "";
        if (r11 == null) goto L5;
        String r13 = r11.getString("auto_update_md5");
    L7:
        if (r11 == null) goto L10;
        r12 = r11.getString("auto_update_pkg");
    L10:
        if (r11 == null) goto L12;
        int r14 = r11.getInt("auto_update_version_code", 0);
    L14:
        if (TextUtils.isEmpty(r13) == false) goto L16;
    L37:
        j.n("[AutoUpdate] autoupdate isFileExist extra " + r13 + "," + r12 + "," + r14);
        return false;
    L16:
        if (TextUtils.isEmpty(r12) == true) goto L37;
        if (r14 == 0) goto L37;
        Bundle r15 = getApkInfo(r10, r12, r14);
        if (r15 != null) goto L23;
        j.n("[AutoUpdate] autoupdate isFileExist apkFileInfo null");
        return false;
    L23:
        String r16 = r15.getString("auto_update_md5");
        if (TextUtils.equals(r13, r16) == true) goto L28;
        j.n("[AutoUpdate] autoupdate isFileExist fileMD5Code = " + r16 + " | apkMD5Code = " + r13);
        return false;
    L28:
        if (TextUtils.equals(r15.getString("auto_update_pkg"), r12) == true) goto L31;
        j.n("[AutoUpdate] autoupdate isFileExist fileMD5Code = " + r16 + " | apkMD5Code = " + r13);
        return false;
    L31:
        int r17 = r15.getInt("auto_update_version_code");
        if (r17 == r14) goto L35;
        j.n("[AutoUpdate] autoupdate isFileExist fileVersionCode = " + r17 + " | versionCode = " + r14);
        return false;
    L35:
        j.n("[AutoUpdate] autoupdate isFileExist true " + r12 + "," + r14);
        return true;
    L12:
        r14 = 0;
        goto L14
    L5:
        r13 = "";
        goto L7
    }

    private boolean markAppUpdateRequestInFlight(String r10) {
        Set<String> r11 = this.mAppUpdateRequestKeys;
        monitor-enter(r11);
        boolean r12 = this.mAppUpdateRequestKeys.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public void delayUpdate(Context r10, Bundle r11) {
        String r12 = r11.getString("auto_update_pkg");
        int r13 = r11.getInt("auto_update_version_code");
        StringBuilder r14 = new StringBuilder();
        if (TextUtils.isEmpty(r12) == true) goto L5;
        r14.append(r13);
        r14.append(SPLIT);
        r14.append(System.currentTimeMillis());
        b0.n().H(r12, r14.toString(), XML_FILE_NAME, r10);
    L5:
        j.n("[AutoUpdate] AutoUpdateManager delayUpdate pkgName = " + r12 + "| ingnore = " + r14.toString());
    }

    public void downloadApp(Context r10, Bundle r11, int r12) {
        AppInfo r13 = new AppInfo();
        r13.appName = r11.getString("auto_update_name");
        r13.appPackageName = r11.getString("auto_update_pkg");
        r13.appDownloadUrl = r11.getString("auto_update_url");
        r13.appVersionCode = r11.getInt("auto_update_version_code");
        r13.mUpdateModel = r12;
        r13.mSysAppAutoUpdateComplianceMode = r11.getInt("auto_update_compliance_model", 0);
        if (r12 != 3) goto L5;
    L13:
        if (r12 != 3) goto L15;
        String r14 = "sys_app_silence";
    L16:
        r13.appSource = r14;
        CommonAPIHelper.V(r13);
    L17:
        r13.appState = 64;
        r13.mIsNeedGms = false;
        boolean r15 = r11.getBoolean("useMobile");
        AppInstallMode r16 = getInstallMode(r11);
        j.n("[AutoUpdate] AutoUpdateManager downloadApp. " + r13.appName + ", " + r13.appPackageName + ", version code=" + r13.appVersionCode + ", model=" + r12 + ", complianceMode=" + r13.mSysAppAutoUpdateComplianceMode + ", appSource=" + r13.appSource + ", useMobile=" + r15 + ", installMode=" + r16);
        this.mKtx.downloadSysAppAutoUpdateManually(r13, r16);
        return;
    L15:
        r14 = "sys_app_silence_mobile";
        goto L16
    L5:
        if (r12 == 4) goto L13;
        if (r11.getInt("auto_update_model") != 2) goto L10;
        r13.appSource = "sys_app_force";
        goto L17
    L10:
        r13.appSource = "sys_app_default";
        if (r11.getBoolean("auto_update_custom_ui", false) == true) goto L17;
        s.a(BaseApplication.c(), R.string.auto_download_toast);
        goto L17
    }

    public Bundle findNewVersion(Context r12, Bundle r13) {
        if (com.bytedanceos.appstore.utils.d.b() == true) goto L6;
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion, Not KSA Version, do not support auto update in provider!!!");
        return null;
    L6:
        String r10 = r13.getString("auto_update_pkg");
        if (TextUtils.isEmpty(r10) == false) goto L10;
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion, pkgName is null");
        return null;
    L10:
        int r11 = 0;
        boolean r14 = false;
        r11 = 0;
        r11 = 0;
        boolean r15 = r13.getBoolean("force_check", false);
        com.smt.obric.appstore.domain.app.entity.a r16 = this.mKtx.getAppInstallTaskBlocking(r10);
        if (r16 != null) goto L13;
        Bundle r17 = getAppInfoBundle(r12, r10, r15);     // Catch: Exception -> L19
    L21:
        if (r17 != null) goto L23;
    L68:
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion appinfo is empty. pkgName:" + r10 + " | forceCheck:" + r15);
        return null;
    L23:
        if (r17.isEmpty() == true) goto L68;
        int r18 = r17.getInt("auto_update_model");
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion, update model:" + r18 + " | package:" + r10);
        if (r18 != 1) goto L28;
        String r19 = b0.n().s(r10, XML_FILE_NAME, r12);
        long r20 = 0;
        if (TextUtils.isEmpty(r19) == true) goto L59;
        if (r19.contains(SPLIT) == false) goto L59;
        String[] r110 = r19.split(SPLIT);     // Catch: RuntimeException -> L56
        r11 = c0.b(r110[0]);     // Catch: RuntimeException -> L56
        r20 = d0.b(r110[1]);     // Catch: RuntimeException -> L56
    L56:
        e = move-exception;
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion err 111 :" + e.getMessage());
    L59:
        if (r11 == r17.getInt("auto_update_version_code")) goto L66;
        if (r11 <= 0) goto L62;
    L64:
        r17.putBoolean("auto_update_file_exist", isFileExist(r12, r17));
        return r17;
    L62:
        if ((System.currentTimeMillis() - r20) >= 86400000) goto L64;
    L66:
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion skip update:" + r10);
        return null;
    L28:
        if (r18 != 2) goto L30;
        b0.n().I(r10, XML_FILE_NAME, r12);
        return r17;
    L30:
        if (r18 == 3) goto L33;
        if (r18 == 4) goto L33;
        return null;
    L33:
        int r21 = r17.getInt("auto_update_version_code");
        if (isFileDownloaded(r12, r17.getString("auto_update_md5"), r21, r10) == false) goto L41;
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion, installApp:" + r10 + " | " + r21);
        if (r18 != 3) goto L38;
        String r111 = "sys_app_silence";
    L39:
        installApp(r12, r17, r111);
    L46:
        b0.n().I(r10, XML_FILE_NAME, r12);
        return null;
    L38:
        r111 = "sys_app_silence_mobile";
        goto L39
    L41:
        if (new GetSysAppAutoUpdateWhitelistUseCase(BaseApplication.c()).d().contains(r10) == false) goto L45;
        if (r18 != 4) goto L44;
        r14 = true;
    L44:
        r17.putBoolean("useMobile", r14);
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion, downloadApp:" + r10 + " | " + r21);
        downloadApp(r12, r17, r18);
        goto L46
    L45:
        j.s("[AutoUpdate] AutoUpdateManager findNewVersion, NOT whitelisted :" + r10 + " | " + r21 + "|" + r18);
    L19:
        e = move-exception;
        e.printStackTrace();
        r17 = null;
        goto L21
    L13:
        if ((System.currentTimeMillis() - r16.i()) <= 86400000) goto L15;
        this.mKtx.cancelAppInstallTaskBlocking(r10);
    L15:
        j.n("[AutoUpdate] AutoUpdateManager findNewVersion, app install task exist:" + r10);
        return null;
    }

    public void installApp(Context r10, Bundle r11, String r12) {
        checkDependApp(r10, r11, r12);
        AppInfo r13 = new AppInfo();
        r13.appName = r11.getString("auto_update_name");
        r13.appPackageName = r11.getString("auto_update_pkg", "");
        r13.appSource = r12;
        r13.appState = 64;
        r13.appVersionCode = r11.getInt("auto_update_version_code");
        AppInstallMode r14 = getInstallMode(r11);
        this.mKtx.installSysAppAutoUpdateManually(r13.appPackageName, r14);
    }

    public void stopDownload(Context r10, Bundle r11) {
        AppInfo r12 = new AppInfo();
        r12.appPackageName = r11.getString("auto_update_pkg");
        r12.appSource = "local";
        j.n("[AutoUpdate] AutoUpdateManager stopDownload. pkg=" + r12.appPackageName);
        String r13 = r12.appPackageName;
        if (r13 == null) goto L6;
        this.mKtx.cancelAppInstallTaskBlocking(r13);
        return;
    }
}
