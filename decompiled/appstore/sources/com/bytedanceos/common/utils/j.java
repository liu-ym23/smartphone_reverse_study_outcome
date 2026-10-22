package com.bytedanceos.common.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.download.AppsDownloadService;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.e0;
import com.smt.obric.appstore.domain.sysapp.SysAppUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static synchronized void a(Context r10, AppInfo r11, boolean r12) {
        monitor-enter(j.class);
        if (r10 == null) goto L29;
    L8:
        long r13 = com.bytedanceos.common.toolbox.e.I();     // Catch: Throwable -> L6
        if ((r13 - r11.appBytes) <= 0) goto L20;
        if (r11.isAutoDownload == false) goto L16;
        if (r11.mRetryNum != 5) goto L18;
        r11.mRetryNum = 0;     // Catch: Throwable -> L6
    L18:
        Intent r14 = new Intent();     // Catch: Throwable -> L6
        r14.setClass(r10, AppsDownloadService.class);     // Catch: Throwable -> L6
        r14.putExtra(DownloadInfoColumns.TABLE, r11);     // Catch: Throwable -> L6
        r14.setAction("appstore.intent.download.local");     // Catch: Throwable -> L6
        r14.putExtra("mobile", r12);     // Catch: Throwable -> L6
        r10.startService(r14);     // Catch: Throwable -> L6
        com.bytedanceos.common.toolbox.j.n("[AppStatus][DownloadHelper] _addDownloadTask start AppsDownloadService to download:" + com.bytedanceos.common.d.a(r11) + "&useMobile = " + r12 + " &trackerInfo = " + r11.trackerInfo);     // Catch: Throwable -> L6
    L25:
        monitor-exit(j.class);
        return;
    L16:
        if (r11.mRetryNum != 2) goto L18;
        r11.mRetryNum = 0;     // Catch: Throwable -> L6
        goto L18
    L20:
        if (r11.isAutoDownload == false) goto L22;
    L24:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][DownloadHelper] _addDownloadTask. " + com.bytedanceos.common.d.a(r11) + " | device space:" + r13 + "/app size:" + r11.appBytes);     // Catch: Throwable -> L6
        goto L25
    L22:
        if (ReflectTool.isAppInTop(BaseApplication.c().getPackageName()) == false) goto L24;
        e0.g(BaseApplication.c().getString(R$string.download_failed_no_enough_sdcard, new Object[]{r11.appName}));     // Catch: Throwable -> L6
        goto L24
    L29:
        r10 = BaseApplication.c();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(Context r10, ArrayList r11) {
        monitor-enter(j.class);
        Intent r12 = new Intent();     // Catch: Throwable -> L7
        r12.setClass(r10, AppsDownloadService.class);     // Catch: Throwable -> L7
        r12.putExtra("download_info_list", r11);     // Catch: Throwable -> L7
        r12.setAction("appstore.intent.cancel.selected");     // Catch: Throwable -> L7
        r10.startService(r12);     // Catch: Throwable -> L7
        com.bytedanceos.common.toolbox.j.n("[AppStatus][DownloadHelper] _cancelDownloadTask Start AppsDownloadService for cancel ids" + r12);     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void c(Context r10, AppInfo r11, boolean r12) {
        monitor-enter(j.class);
        long r13 = com.bytedanceos.common.toolbox.e.I();     // Catch: Throwable -> L16
        if ((r13 - r11.downloadCurrentBytes) <= 0) goto L21;
        Intent r14 = new Intent();     // Catch: Throwable -> L16
        r14.setClass(r10, AppsDownloadService.class);     // Catch: Throwable -> L16
        r14.putExtra(DownloadInfoColumns.TABLE, r11);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r11.appSource) == false) goto L9;
    L18:
        r14.setAction("appstore.intent.continue.local");     // Catch: Throwable -> L16
    L19:
        r14.putExtra("mobile", r12);     // Catch: Throwable -> L16
        r10.startService(r14);     // Catch: Throwable -> L16
        com.bytedanceos.common.toolbox.j.n("[AppStatus][DownloadHelper] _continueDownloadTask start AppsDownloadService for continue " + com.bytedanceos.common.d.a(r11) + " " + r14);     // Catch: Throwable -> L16
    L26:
        monitor-exit(j.class);
        return;
    L9:
        if (TextUtils.equals(r11.appSource, "local") == true) goto L18;
        if (TextUtils.equals(r11.appSource, "launcher") == true) goto L18;
        if (TextUtils.equals(r11.appSource, "backup") == true) goto L18;
        r14.setAction("appstore.intent.continue.other");     // Catch: Throwable -> L16
        goto L19
    L21:
        if (r11.isAutoDownload == false) goto L23;
    L25:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][DownloadHelper] _continueDownloadTask insufficient space " + com.bytedanceos.common.d.a(r11) + " | device space:" + r13 + "/app current size:" + r11.downloadCurrentBytes);     // Catch: Throwable -> L16
        goto L26
    L23:
        if (ReflectTool.isAppInTop(BaseApplication.c().getPackageName()) == false) goto L25;
        e0.g(BaseApplication.c().getString(R$string.download_failed_no_enough_sdcard, new Object[]{r11.appName}));     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized void d(Context r10, AppInfo r11) {
        monitor-enter(j.class);
        Intent r12 = new Intent();     // Catch: Throwable -> L10
        r12.setClass(r10, AppsDownloadService.class);     // Catch: Throwable -> L10
        r12.putExtra(DownloadInfoColumns.TABLE, r11);     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r11.appSource) == false) goto L7;
    L12:
        r12.setAction("appstore.intent.pause.local");     // Catch: Throwable -> L10
    L13:
        r10.startService(r12);     // Catch: Throwable -> L10
        com.bytedanceos.common.toolbox.j.t("[AppStatus][DownloadHelper] _pauseDownloadTask start AppsDownloadService for pause " + com.bytedanceos.common.d.a(r11) + " " + r12);     // Catch: Throwable -> L10
        monitor-exit(j.class);
        return;
    L7:
        if (TextUtils.equals(r11.appSource, "local") == true) goto L12;
        r12.setAction("appstore.intent.pause.other");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static void e(List r10, String r11) {
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        AppInfo r13 = (AppInfo) r12.next();
        String r14 = r13.appPackageName;
        if (BaseApplication.c().b().b0(r14) == false) goto L11;
        if (BaseApplication.c().b().U(r14) == false) goto L4;
    L11:
        if (BaseApplication.c().b().X(r14) == true) goto L12;
        if (BaseApplication.c().b().c0(r14) == true) goto L15;
        r13.tabSource = r11;
        BaseApplication.c().b().h(r13);
        goto L4
    L15:
        BaseApplication.c().b().h(r13);
        goto L4
    L12:
        d(BaseApplication.c(), r13);
        BaseApplication.c().b().h(r13);
        goto L4
    L17:
        e0.e(R$string.wifi_auto_download);
    }

    public static void f(List r10, boolean r11, String r12) {
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L25;
        AppInfo r14 = (AppInfo) r13.next();
        String r15 = r14.appPackageName;
        BaseApplication.c().b().t0(r14);
        if (BaseApplication.c().b().b0(r15) == false) goto L11;
        if (BaseApplication.c().b().U(r15) == false) goto L4;
    L11:
        if (BaseApplication.c().b().X(r15) == true) goto L13;
        if (BaseApplication.c().b().c0(r15) == true) goto L17;
        r14.tabSource = r12;
        if (TextUtils.isEmpty(r14.mApiUrl) == false) goto L22;
        r14.mApiUrl = BaseApplication.c().j();
    L22:
        if (URLUtil.isNetworkUrl(r14.appDownloadUrl) == true) goto L23;
        e0.e(R$string.download_error_url);
        goto L4
    L23:
        a(BaseApplication.c(), r14, r11);
        goto L4
    L17:
        c(BaseApplication.c(), r14, r11);
        goto L4
    L13:
        if (BaseApplication.c().b().t(r15).downloadStatus != 512) goto L4;
        BaseApplication.c().g().installApp(BaseApplication.c(), r14);
        goto L4
    }

    public static synchronized void g() {
        monitor-enter(j.class);
        Intent r10 = new Intent();     // Catch: Throwable -> L7
        r10.setClass(BaseApplication.c(), AppsDownloadService.class);     // Catch: Throwable -> L7
        r10.setAction("appstore.intent.download.next");     // Catch: Throwable -> L7
        BaseApplication.c().startService(r10);     // Catch: Throwable -> L7
        com.bytedanceos.common.toolbox.j.n("[AppStatus][DownloadHelper] downloadNext start AppsDownloadService to download next");     // Catch: Throwable -> L7
        monitor-exit(j.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void h(boolean r10) {
        Intent r11 = new Intent();
        r11.setClass(BaseApplication.c(), AppsDownloadService.class);
        r11.setAction("appstore.intent.download.update");
        r11.putExtra("mobile", r10);
        BaseApplication.c().startService(r11);
        com.bytedanceos.common.toolbox.j.n("Start service to download all updates");
    }

    public static synchronized void i(Context r10, AppInfo r11) {
        monitor-enter(j.class);
        if (r10 == null) goto L12;
        if (r11 == null) goto L12;
        String r12 = SysAppUtilKt.b(r10, r11);     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        r11.downloadFilePath = r12;     // Catch: Throwable -> L9
        r11.appSource = "obric_sys_app";     // Catch: Throwable -> L9
        r11.downloadStatus = 8;     // Catch: Throwable -> L9
        BaseApplication.c().b().b(r11);     // Catch: Throwable -> L9
        Intent r13 = new Intent();     // Catch: Throwable -> L9
        r13.setPackage(r10.getPackageName());     // Catch: Throwable -> L9
        r13.setAction("com.bytedance.start.install.service");     // Catch: Throwable -> L9
        r13.putExtra("message_what", 109);     // Catch: Throwable -> L9
        r13.putExtra("AppName", r11.appName);     // Catch: Throwable -> L9
        r13.putExtra("PackageName", r11.appPackageName);     // Catch: Throwable -> L9
        r13.putExtra("RemainFileAfterInstall", true);     // Catch: Throwable -> L9
        r10.startService(r13);     // Catch: Throwable -> L9
        com.bytedanceos.common.toolbox.j.n("[AppStatus][SysApp] installObricSystemApp:" + r11.appPackageName);     // Catch: Throwable -> L9
    L13:
        monitor-exit(j.class);
        return;
    L11:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][SysApp] installObricSystemApp err: copy apk file fail.");     // Catch: Throwable -> L9
    L12:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][SysApp] installObricSystemApp err: params is null.");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized void j(Context r10, AppInfo r11) {
        monitor-enter(j.class);
        if (r10 == null) goto L14;
        if (r11 == null) goto L14;
        if (TextUtils.equals("obric_sys_app", r11.appSource) == false) goto L13;
        i(r10, r11);     // Catch: Throwable -> L11
        monitor-exit(j.class);
        return;
    L13:
        Intent r12 = new Intent();     // Catch: Throwable -> L11
        r12.setPackage(r10.getPackageName());     // Catch: Throwable -> L11
        r12.setAction("com.bytedance.start.install.service");     // Catch: Throwable -> L11
        r12.putExtra("message_what", 89);     // Catch: Throwable -> L11
        r12.putExtra("AppName", r11.appName);     // Catch: Throwable -> L11
        r12.putExtra("PackageName", r11.appPackageName);     // Catch: Throwable -> L11
        r10.startService(r12);     // Catch: Throwable -> L11
        r11.appSource = "system";     // Catch: Throwable -> L11
        r11.downloadStatus = 8;     // Catch: Throwable -> L11
        BaseApplication.c().b().b(r11);     // Catch: Throwable -> L11
        com.bytedanceos.common.toolbox.j.n("[AppStatus][SysApp] installSystemApp:" + r11.appPackageName);     // Catch: Throwable -> L11
    L15:
        monitor-exit(j.class);
        return;
    L14:
        com.bytedanceos.common.toolbox.j.n("[AppStatus][SysApp] installSystemApp err: params is null.");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static void k() {
        Intent r10 = new Intent();
        r10.setAction("com.bytedance.appstore.autoupdate.pause");
        r10.setPackage(BaseApplication.c().getPackageName());
        BaseApplication.c().startService(r10);
    }

    public static void l() {
        Intent r10 = new Intent();
        r10.setClass(BaseApplication.c(), AppsDownloadService.class);
        r10.setAction("appstore.intent.pause.update");
        BaseApplication.c().startService(r10);
        com.bytedanceos.common.toolbox.j.n("Start service to pause all updates");
    }
}
