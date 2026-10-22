package com.bytedanceos.appstore.download.manager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import androidx.core.content.FileProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.appstore.download.receiver.AppInstallReceiver;
import com.bytedanceos.appstore.update.InstallSystemAppUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.ad.common.AdReportUtil;
import com.bytedanceos.common.download.AppsDownloadService;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.network.api.CommonAPIHelper;
import com.bytedanceos.common.networkv2.params.NetValue;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.k;
import com.bytedanceos.common.tracker.TrackerElement;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.bytedanceos.common.utils.r;
import com.bytedanceos.common.utils.s;
import com.obric.appstore.R;
import com.obric.capabilitykit.common.ErrorCode;
import java.io.File;
import z7.c;

/* JADX INFO: loaded from: classes2.dex */
public class AppsInstallManager extends com.bytedanceos.common.download.a {
    private static final String TAG = "AppsInstallManager";
    private static AppsInstallManager sInstance;
    private Handler mDelayInstallHandler;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppsInstallManager f9405a;

        public a(AppsInstallManager r10, Looper r11) {
            this.f9405a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            super.handleMessage(r10);
            if ((r10.obj instanceof Intent) == false) goto L6;
            AppInstallReceiver.a(BaseApplication.c(), (Intent) r10.obj);
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppInfo f9406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AppsInstallManager f9407b;

        public class a implements DialogInterface.OnCancelListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9408a;

            public a(b r10) {
                this.f9408a = r10;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface r10) {
                if (TextUtils.isEmpty(this.f9408a.f9406a.downloadFilePath) == false) goto L5;
            L7:
                e.c();
                j.e("GMS file delete from back");
                return;
            L5:
                if (new File(this.f9408a.f9406a.downloadFilePath).exists() == false) goto L7;
                new File(this.f9408a.f9406a.downloadFilePath).delete();
                goto L7
            }
        }

        /* JADX INFO: renamed from: com.bytedanceos.appstore.download.manager.AppsInstallManager$b$b, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0124b implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9409a;

            public DialogInterfaceOnClickListenerC0124b(b r10) {
                this.f9409a = r10;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface r10, int r11) {
                if (TextUtils.isEmpty(this.f9409a.f9406a.downloadFilePath) == false) goto L5;
            L7:
                e.c();
                j.e("GMS file delete from cancle");
                return;
            L5:
                if (new File(this.f9409a.f9406a.downloadFilePath).exists() == false) goto L7;
                new File(this.f9409a.f9406a.downloadFilePath).delete();
                goto L7
            }
        }

        public class c implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f9410a;

            public c(b r10) {
                this.f9410a = r10;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface r10, int r11) {
                b r12 = this.f9410a;
                AppsInstallManager.access$000(r12.f9407b, r12.f9406a.downloadFilePath);
            }
        }

        public b(AppsInstallManager r10, AppInfo r11) {
            this.f9407b = r10;
            this.f9406a = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9407b.cancelAllAboutGmsTask(this.f9406a);
            AlertDialog r10 = new AlertDialog.Builder(new ContextThemeWrapper(BaseApplication.c(), R.style.AppStoreDialogTheme)).setTitle(R.string.alert_gms_title).setMessage(R.string.alert_gms_restart_notice).setPositiveButton(android.R.string.yes, new c(this)).setNegativeButton(android.R.string.cancel, new DialogInterfaceOnClickListenerC0124b(this)).setOnCancelListener(new a(this)).create();
            r10.getWindow().setType(ErrorCode.Clock.UNSUPPORTED_CREATE_ALARM_FOR_PAST_TIMES_ERROR);
            r10.show();
        }
    }

    static {
        sInstance = new AppsInstallManager();
    }

    private AppsInstallManager() {
        this.mDelayInstallHandler = new a(this, Looper.getMainLooper());
    }

    public static /* synthetic */ void a(AppsInstallManager r10, AppInfo r11, int r12) {
        r10.lambda$downloadFailed$1(r11, r12);
    }

    public static /* synthetic */ void access$000(AppsInstallManager r10, String r11) {
        r10.installGmsTask(r11);
    }

    public static /* synthetic */ void b(AppsInstallManager r10, AppInfo r11, int r12) {
        r10.lambda$downloadFailed$0(r11, r12);
    }

    public static /* synthetic */ void c(AppsInstallManager r10, AppInfo r11, int r12) {
        r10.lambda$downloadFailed$2(r11, r12);
    }

    private boolean equalsMD5CodeWithFile(String r10) throws Exception {
        return TextUtils.equals(k.e(new File(r10)), d.f10013e);
    }

    private String getGmsUpdateAction() {
        PackageInfo r10 = BaseApplication.c().getPackageManager().getPackageInfo("com.bytedanceos.updater", 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L6:
        if (r10 != null) goto L8;
    L10:
        return "bytedance_update2";
    L8:
        if (r10.versionCode != 2) goto L10;
        return "bytedance_update";
    L5:
        r10 = null;
        goto L6
    }

    public static AppsInstallManager getInstance() {
        return sInstance;
    }

    private void installGmsTask(String r10) {
        String r11 = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (r10.contains(r11) == false) goto L5;
        String r12 = r10.replace(r11, "");
    L10:
        if (TextUtils.isEmpty(r12) == true) goto L12;
        Intent r13 = new Intent();
        r13.setAction(getGmsUpdateAction());
        r13.putExtra("PACKAGE_PATH", r12);
        BaseApplication.c().sendBroadcast(r13);
        return;
    L12:
        e0.e(R.string.alert_gms_restart_failed);
        return;
    L5:
        String r14 = Environment.getDataDirectory().getAbsolutePath();
        if (r10.contains(r14) == false) goto L8;
        r12 = r10.replace(r14, "");
        goto L10
    L8:
        r12 = null;
        goto L10
    }

    public static void installSystemApp(Intent r10) {
        AppInfo r11 = new AppInfo();
        if (r10 == null) goto L8;
        r11.appName = r10.getStringExtra("AppName");     // Catch: Exception -> L5
        r11.appPackageName = r10.getStringExtra("PackageName");     // Catch: Exception -> L5
        InstallSystemAppUtils.installSystemApp(r11);     // Catch: Exception -> L5
        return;
    L8:
        throw new Exception("intent is empty.");     // Catch: Exception -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
        if (TextUtils.isEmpty(r11.appName) == true) goto L13;
        e0.g(BaseApplication.c().getString(R.string.install_failed_try_again, new Object[]{r11.appName}));
    L13:
        if (TextUtils.isEmpty(r11.appPackageName) == true) goto L18;
        com.bytedanceos.appstore.datacache.a.N0().k0(r11);
        return;
    }

    private /* synthetic */ void lambda$downloadFailed$0(AppInfo r10, int r11) {
        retryDownload(r10, r11);
    }

    private /* synthetic */ void lambda$downloadFailed$1(AppInfo r10, int r11) {
        retryDownload(r10, r11);
    }

    private /* synthetic */ void lambda$downloadFailed$2(AppInfo r10, int r11) {
        retryDownload(r10, r11);
    }

    private boolean notifyCaller(AppInfo r10, int r11) {
        if (TextUtils.isEmpty(r10.mSourcePkgName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r10.appDownloadUrl) == false) goto L10;
        Intent r12 = new Intent("com.bytedanceos.appstore.install.app.complete");
        r12.putExtra("status", r11);
        r12.putExtra(AppPermissionActivity.EXTRA_APP_PKG, r10.appPackageName);
        r12.setPackage(r10.mSourcePkgName);
        BaseApplication.c().sendBroadcast(r12);
        j.e("notifyUser:" + r10.mSourcePkgName + " | " + r10.appPackageName + ",returnCode:[" + r11 + "]");
        return true;
    L10:
        return false;
    }

    private void reportInstallTrack(boolean r10, AppInfo r11) {
        d9.a.e().v(r10, r11.trackerInfo);
    }

    private void retryDownload(AppInfo r10, int r11) {
        j.n("AppsInstallManager retryDownload " + r11);
        r10.mRetryNum = r10.mRetryNum + 1;
        r10.downloadId = 0;
        Intent r12 = new Intent();
        r12.setClass(BaseApplication.c(), AppsDownloadService.class);
        r12.setAction("appstore.intent.download.local");
        r12.putExtra(DownloadInfoColumns.TABLE, r10);
        r12.putExtra(WsConstants.ERROR_CODE, r11);
        BaseApplication.c().startService(r12);
    }

    public void cancelAllAboutGmsTask(AppInfo r10) {
        com.bytedanceos.appstore.utils.a.l();
        com.bytedanceos.common.download.b.l().q(true, new long[]{r10.downloadId});
        com.bytedanceos.appstore.datacache.a.N0().k0(r10);
    }

    public void delayInstallApp(Context r10, long r11, long r12) {
        AppInstallWorker.u(r10, r11, r12);
    }

    public void downloadFailed(final AppInfo r10, final int r11, String r12) {
        if (r10.appState != 64) goto L5;
    L8:
        String r13 = "8";
    L10:
        if (r10.isAutoDownload == false) goto L12;
    L16:
        j.n("AppsInstallManager download failed, code: " + r11);
        e.n(r10.appPackageName);
        CommonAPIHelper.U(r13, r10, r12, r11);
        if (ie.a.b(r11) == true) goto L19;
    L21:
        boolean r14 = r10.isAutoDownload;
        if (r14 == true) goto L24;
    L26:
        if (r14 == false) goto L28;
    L31:
        if (r10.isAutoDownload == false) goto L41;
        if (ie.a.b(r11) == false) goto L35;
        return;
    L35:
        if (r10.mRetryNum < 5) goto L37;
        return;
    L37:
        if (ie.a.a(Integer.valueOf(r11)) == false) goto L39;
        new Handler().postDelayed(new z7.a(this, r10, r11), (r10.mRetryNum + 1) * 5000);
        return;
    L39:
        new Handler().postDelayed(new z7.b(this, r10, r11), (r10.mRetryNum + 1) * 500);
        return;
    L41:
        if (ie.a.b(r11) == false) goto L43;
        return;
    L43:
        if (r10.mRetryNum >= 2) goto L51;
        new Handler().postDelayed(new c(this, r10, r11), (r10.mRetryNum + 1) * 500);
        return;
    L51:
        return;
    L28:
        if (r10.mRetryNum != 2) goto L31;
        r10.downloadId = 0;
        com.bytedanceos.appstore.utils.a.y(r10, "bytedanceos.appstore.download.failed", r11);
        goto L31
    L24:
        if (r10.mRetryNum != 5) goto L26;
        r10.downloadId = 0;
        com.bytedanceos.appstore.utils.a.y(r10, "bytedanceos.appstore.download.failed", r11);
        goto L31
    L19:
        if (r10.isAutoDownload == false) goto L21;
        j.n("AppsInstallManager download fail because of less space when auto update");
        goto L31
    L12:
        if (r10.mRetryNum != 2) goto L14;
    L15:
        j.n("AppsInstallManager download failed due to insufficient storage, code: " + r11 + ", retryNum:" + r10.mRetryNum);
        com.bytedanceos.appstore.datacache.a.N0().J0(r10, r11);
        goto L16
    L14:
        if (ie.a.b(r11) == false) goto L16;
    L5:
        if (r10.isAppUpdate == true) goto L8;
        r13 = NetValue.AppStatusType.DOWNLOAD_FAILURE_NEW;
        goto L10
    }

    @Override // com.bytedanceos.common.download.a
    public void install(Context r10, AppInfo r11, boolean r12) {
        Intent r13 = new Intent(BaseApplication.c(), AppInstallReceiver.class);
        r13.setAction("com.bytedanceos.check.install.auto.update");
        AppInfo r14 = com.bytedanceos.appstore.datacache.a.N0().t(r11.appPackageName);
        if (r14 == null) goto L5;
        r11.downloadId = r14.downloadId;
    L5:
        r13.putExtra(DownloadInfoColumns.TABLE, r11);
        r13.putExtra("isDiffPatch", r12);
        r10.sendBroadcast(r13);
        j.n("AppsInstallManager install " + r11.appPackageName + ",isDiffPatch = " + r12);
    }

    @Override // com.bytedanceos.common.download.a
    public void installApp(Context r10, AppInfo r11) {
        if (r10 == null) goto L7;
        if (r11 == null) goto L7;
        r11.downloadFilePath = e.E(com.bytedanceos.appstore.datacache.a.N0(), r11);
        install(r10, r11, false);
        return;
    L7:
        j.n("AppsInstallManager input params error.");
    }

    public void installFailure(AppInfo r10, int r11, String r12) {
        CommonAPIHelper.U("3", r10, r12, r11);
        if (r10.isAutoDownload == false) goto L8;
        if (TextUtils.equals(r12, "install failed: didn't have enough space") == false) goto L8;
        j.n("AppsInstallManager install failed,no enough space:" + r10.appPackageName);
    L29:
        if ((-4) == r11) goto L31;
    L33:
        j.n("AppsInstallManager install failed, code: " + r11);
    L35:
        if (TextUtils.isEmpty(r10.appPackageName) == true) goto L37;
        j.a("AppsInstallManager remove appinfo " + r10.appPackageName + " downloadId " + r10.downloadId);
        com.bytedanceos.appstore.datacache.a.N0().k0(r10);
    L37:
        reportInstallTrack(false, r10);
        e.n(r10.appPackageName);
        return;
    L31:
        if (r10.isAutoDownload == true) goto L33;
        j.n("AppsInstallManager install failed due to insufficient storage, code: " + r11);
    L8:
        if (TextUtils.equals("launcher", r10.appSource) == false) goto L10;
    L28:
        j.n("AppsInstallManager install failed:" + r10.appPackageName);
        goto L29
    L10:
        if (TextUtils.equals("sys_app_silence", r10.appSource) == true) goto L28;
        if (TextUtils.equals("sys_app_silence_mobile", r10.appSource) == true) goto L28;
        if (TextUtils.equals(r12, "install failed: didn't have enough space") == false) goto L18;
        int r13 = -4;
    L22:
        if (r11 == 705) goto L29;
        if (notifyCaller(r10, r13) == true) goto L29;
        if (com.bytedanceos.appstore.datacache.a.N0().W(r10.appPackageName) == false) goto L29;
        com.bytedanceos.appstore.utils.a.y(r10, "bytedanceos.appstore.install.failed", r13);
        goto L29
    L18:
        if (TextUtils.equals(r12, "Install failed: download file is not exists") == false) goto L20;
        r13 = 701;
        goto L22
    L20:
        r13 = r11;
        goto L22
    }

    public void installGMS(AppInfo r10) {
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (equalsMD5CodeWithFile(r10.downloadFilePath) == true) goto L7;
        e0.e(R.string.alert_gms_different_md5);     // Catch: Exception -> L5
    L7:
        new Handler(Looper.getMainLooper()).post(new b(this, r10));     // Catch: Exception -> L5
    }

    public void installOtherApp(AppInfo r10) {
        if (r10 != null) goto L4;
    L17:
        j.n("AppsInstallManager installOtherApp AppInfo is null.");
        return;
    L4:
        if (TextUtils.isEmpty(r10.downloadFilePath) == true) goto L17;
        Intent r11 = new Intent("android.intent.action.VIEW");
        r11.setFlags(268435456);
        File r12 = new File(r10.downloadFilePath);     // Catch: RuntimeException -> L10
        if (r12.exists() == false) goto L12;
        r11.addFlags(1);     // Catch: RuntimeException -> L10
        r11.setDataAndType(FileProvider.f(BaseApplication.c(), "com.obric.appstore.install.app", r12), "application/vnd.android.package-archive");     // Catch: RuntimeException -> L10
        BaseApplication.c().startActivity(r11);     // Catch: RuntimeException -> L10
    L19:
    L15:
        com.bytedanceos.appstore.datacache.a.N0().k0(r10);
        j.n("AppsInstallManager installOtherApp appPackageName = " + r10.appPackageName + " | download_id = " + r10.downloadId);
        return;
    L12:
        j.n("AppsInstallManager installOtherApp file is not exist.");     // Catch: RuntimeException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public void installSuccess(AppInfo r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        BaseApplication r10 = BaseApplication.c();
        s.a(NetValue.AppStatusType.INSTALL_SUCCESS, r11);
        reportInstallTrack(true, r11);
        if ("com.bytedanceos.gamestore".equals(r11.appPackageName) == false) goto L8;
        com.bytedanceos.common.toolbox.s.s(r11);
    L8:
        if (r11.mIsPushReservation == false) goto L11;
        String r12 = e.T(r11.mOnlineTime);
        j.e("onLineTime = " + r12);
        d9.a.e().F(r11.appName, r11.appCategoryName, r12);
        DataBaseManager.ReserveApps.deleteApp(r11.appPackageName);
        Bundle r13 = new Bundle();
        r13.putString(TrackerElement.GAME_NAME, r11.appName);
        r13.putString("game_category", r11.appCategoryName);
        r13.putString("game_online_time", r12);
        f9.b.b("reserved_autoinstall_success", r13);
    L11:
        if (TextUtils.equals(r11.appPackageName, "com.obric.appstore") == false) goto L15;
        j.a("auto update success.");
        return;
    L15:
        if (r.f10223l.contains(r11.appPackageName) == false) goto L28;
        String r14 = com.bytedanceos.common.toolbox.s.c(r10);
        j.a("last hide app package names: " + r14);
        if (TextUtils.isEmpty(r14) == false) goto L19;
        r14 = r11.appPackageName;
    L26:
        com.bytedanceos.common.toolbox.s.q(r10, r14);
        j.a("new hide app package names: " + r14);
    L34:
        if (notifyCaller(r11, 1) == true) goto L39;
        com.bytedanceos.appstore.utils.a.y(r11, "bytedanceos.appstore.install.success", 0);
        return;
    L39:
        return;
    L19:
        String[] r15 = r14.split(";");
        int r16 = r15.length;
        int r17 = 0;
    L20:
        if (r17 >= r16) goto L25;
        if (TextUtils.equals(r15[r17], r11.appPackageName) == true) goto L23;
        r17 = r17 + 1;
        goto L20
    L23:
        j.a("hide app has exist: " + r11.appPackageName);
        goto L26
    L25:
        r14 = r14 + ";" + r11.appPackageName;
        goto L26
    L28:
        if (TextUtils.equals("ad", r11.appSource) == true) goto L30;
        AdsReportManager.h().p(r11.appPackageName);
        goto L34
    L30:
        if (TextUtils.equals(r11.mAdDsp, AdConstant.Dsp.TOUTIAO) == false) goto L34;
        AdReportUtil.reportSnsEvent(3, r11.mAdExtra);
        goto L34
    }
}
