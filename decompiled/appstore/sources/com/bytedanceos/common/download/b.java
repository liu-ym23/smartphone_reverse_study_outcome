package com.bytedanceos.common.download;

import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.tracker.TrackerElement;
import com.smt.obric.appstore.ktx.PackageInfoKTxKt;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedanceos.common.download.a f9815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommonCache f9816b;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.bytedanceos.common.download.b$b, reason: collision with other inner class name */
    public static class C0128b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f9817a;

        static {
            f9817a = new b(null);
        }
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public static b l() {
        return C0128b.f9817a;
    }

    public void a(Intent r10) {
        AppInfo r11 = (AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE);
        if (r11 != null) goto L6;
        j.n("AppInfo is null");
        return;
    L6:
        Map r12 = q8.a.b().g();
        AppInfo r13 = (AppInfo) r12.get(r11.appPackageName);
        if (r13 != null) goto L9;
    L14:
        j.n("AppsDownloadManager cancel auto update failed:" + r11.appPackageName + " | downloading app size:" + r12.size());
        return;
    L9:
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r13.downloadId)) == false) goto L14;
        j.a("Cancel==========================================================================================================");     // Catch: Exception -> L12
        j.n("AppsDownloadManager Cancel [PackageName: " + r11.appPackageName + "]");     // Catch: Exception -> L12
        j.n("AppsDownloadManager Cancel [Request_ID:  " + r13.downloadId + "]");     // Catch: Exception -> L12
        j.a("================================================================================================================");     // Catch: Exception -> L12
        this.f9816b.k0(r13);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }

    public synchronized void b() {
        monitor-enter(this);
        List r10 = this.f9816b.v("DOWNLOAD");     // Catch: Throwable -> L9
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L9
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L9
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L9
    L5:
        if (r13.hasNext() == false) goto L12;
        AppInfo r14 = (AppInfo) r13.next();     // Catch: Throwable -> L9
        if (r14.mIsNeedGms == false) goto L5;
        r11.add(r14);     // Catch: Throwable -> L9
        r12.append(r14.toString());     // Catch: Throwable -> L9
        goto L5
    L12:
        if (r11.size() <= 0) goto L14;
        this.f9816b.o0(r11);     // Catch: Throwable -> L9
    L14:
        j.a("Cancel==========================================================================================================");     // Catch: Throwable -> L9
        j.n("AppsDownloadManager Cancel [GMS Apps:  " + r12.toString() + "]");     // Catch: Throwable -> L9
        j.a("================================================================================================================");     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void c(Intent r10) {
        s((AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void d(Intent r10) {
        s((AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public synchronized void e(Intent r10) {
        monitor-enter(this);
        Serializable r11 = r10.getSerializableExtra("download_info_list");     // Catch: Throwable -> L10
        if (r11 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        ArrayList r12 = (ArrayList) r11;     // Catch: Throwable -> L10
        int r13 = r12.size();     // Catch: Throwable -> L10
        long[] r14 = new long[r13];     // Catch: Throwable -> L10
        int r15 = 0;
    L8:
        if (r15 >= r13) goto L12;
        AppInfo r16 = (AppInfo) r12.get(r15);     // Catch: Throwable -> L10
        j.a("Cancel==========================================================================================================");     // Catch: Throwable -> L10
        j.n("AppsDownloadManager Cancel [PackageName: " + r16.appPackageName + "]");     // Catch: Throwable -> L10
        j.n("AppsDownloadManager Cancel [Request_ID:  " + r16.downloadId + "]");     // Catch: Throwable -> L10
        j.a("================================================================================================================");     // Catch: Throwable -> L10
        r14[r15] = r16.downloadId;     // Catch: Throwable -> L10
        r15 = r15 + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        this.f9816b.o0(r12);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void f(AppInfo r10) {
        boolean r11 = true;
        if (TextUtils.equals(r10.appSource, "gloable_search") == true) goto L15;
        if (TextUtils.equals(r10.appSource, "launcher") == true) goto L15;
        if (TextUtils.equals(r10.appSource, "ad") == true) goto L15;
        if (this.f9816b.R(true, r10.isAutoDownload) == true) goto L15;
        if (TextUtils.equals(r10.appSource, "bootup") == true) goto L15;
        r10.downloadStatus = 1;
        this.f9816b.b(r10);
        return;
    L15:
        if (r10.isSystemApp() == false) goto L17;
    L28:
        j(r10, r11);
        return;
    L17:
        if ("sys_app_default".equalsIgnoreCase(r10.appSource) == true) goto L28;
        if ("sys_app_force".equalsIgnoreCase(r10.appSource) == true) goto L28;
        if ("sys_app_silence".equalsIgnoreCase(r10.appSource) == true) goto L28;
        if ("sys_app_silence_mobile".equalsIgnoreCase(r10.appSource) == true) goto L28;
        if ("ad".equalsIgnoreCase(r10.appSource) == true) goto L28;
        r11 = false;
        goto L28
    }

    public void g(AppInfo r11) {
        r(r11);
        AppInfo r10 = this.f9816b.t(r11.appPackageName);
        if (r10 != null) goto L5;
    L47:
    L41:
        e = move-exception;
        e.printStackTrace();
        this.f9816b.k0(r11);
        return;
    L35:
        if (r11.mIsNeedGms == true) goto L37;
    L43:
        f(r11);     // Catch: Exception -> L41
        return;
    L37:
        if (this.f9816b.X("com.bytedance.gms") == true) goto L43;
        if (e.v0(BaseApplication.c()) == true) goto L43;
        v(r11, false);     // Catch: Exception -> L41
        return;
    L5:
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r10.downloadId)) == false) goto L11;
        if (r10.downloadStatus != 4) goto L11;
        q8.a.j(r11.mAllowMobile, new long[]{r10.downloadId});
        j.n("[AppStatus][AppsDownloadManager] resumeDownload:" + com.bytedanceos.common.d.a(r10));
        return;
    L11:
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r10.downloadId)) == false) goto L16;
        if (r10.downloadStatus != 16) goto L16;
        l().q(true, new long[]{r10.downloadId});
        j.n("[AppStatus][AppsDownloadManager] removeDownloadTasks:" + com.bytedanceos.common.d.a(r10));
    L29:
        if (r10.downloadStatus == 16) goto L47;
        this.f9816b.p0(r10);
        this.f9816b.s0(r10.appPackageName);
        File r12 = new File(e.H(), e.v(r10, true));
        StringBuffer r13 = new StringBuffer();
        r13.append("[AppStatus][AppsDownloadManager] app installed:" + r11.appPackageName + ", version:" + r10.appVersionCode);
        if (r12.exists() == false) goto L33;
        r13.append(",delete =" + r12.delete());
    L33:
        j.n(r13.toString());
    L16:
        if (r11.appVersionCode > r10.appVersionCode) goto L29;
        if (r10.downloadStatus == 16) goto L29;
        StringBuffer r14 = new StringBuffer();
        r14.append("[AppStatus][AppsDownloadManager] app installed:" + r11.appPackageName + ", version:" + r11.appVersionCode + " /" + r10.appVersionCode);
        int r15 = r10.downloadStatus;
        if (r15 != 8) goto L22;
    L25:
        this.f9815a.installApp(BaseApplication.c(), r10);
        r14.append(",install app");
    L26:
        j.n(r14.toString());
        return;
    L22:
        if (r15 == 512) goto L25;
        r14.append(",downloading app");
        goto L26
    }

    public void h() {
        if (e.A0(BaseApplication.c()) == true) goto L6;
        BaseApplication.c().h().downloadNext();
        return;
    L6:
        int r10 = 0;
    L8:
        if (r10 >= 200) goto L26;
        AppInfo r11 = this.f9816b.E();
        if (r11 == null) goto L11;
        if (this.f9816b.R(false, r11.isAutoDownload) == false) goto L15;
        if (r11.isAutoDownload == false) goto L23;
        if (e.l0() == true) goto L23;
        j.n("AppsDownloadManager stop auto download:" + r11.appPackageName);
        this.f9816b.k0(r11);
    L25:
        r10 = r10 + 1;
    L23:
        if (r11.downloadStatus != 1) goto L25;
        j(r11, false);
        goto L25
    L15:
        j.n("AppsDownloadManager Downloading apps reach max num");
        return;
    L11:
        j.n("AppsDownloadManager no download task");
        return;
    }

    public void i(Intent r11) {
        int r10 = 0;
        boolean r12 = r11.getBooleanExtra("mobile", false);
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        Iterator r16 = this.f9816b.v("UPDATE").iterator();
    L4:
        if (r16.hasNext() == false) goto L20;
        AppInfo r17 = (AppInfo) r16.next();
        if (PackageInfoKTxKt.d(BaseApplication.c(), r17.appPackageName, r17.sha256) == true) goto L4;
        if (r17.mAppUpdateType == 0) goto L4;
        r(r17);
        r17.mAllowMobile = r12;
        AppInfo r18 = this.f9816b.t(r17.appPackageName);
        if (r18 == null) goto L12;
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r18.downloadId)) == false) goto L15;
        if (r13.size() < 200) goto L18;
        j.l("downloadUpdateApps downloadingApp 3-2" + r18.appPackageName + ", " + r18.downloadId);
        r18.mAllowMobile = r12;
        r14.add(r18);
        goto L4
    L18:
        j.l("downloadUpdateApps downloadingApp 3-1" + r18.appPackageName + ", " + r18.downloadId);
        r13.add(r18);
        goto L4
    L15:
        j.b("downloadUpdateApps downloadingApp 2" + r18.appPackageName + ", " + r18.downloadId);
        r18.mAllowMobile = r12;
        r14.add(r18);
        goto L4
    L12:
        j.l("downloadUpdateApps downloadingApp 1");
        r17.mAllowMobile = r12;
        r15.add(r17);
        goto L4
    L20:
        int r19 = r13.size();
        if (r19 <= 0) goto L27;
        long[] r20 = new long[r19];
    L23:
        if (r10 >= r19) goto L25;
        r20[r10] = ((AppInfo) r13.get(r10)).downloadId;
        r10 = r10 + 1;
        goto L23
    L25:
        this.f9816b.E0(r13, 2);
        q8.a.b();
        q8.a.j(r12, r20);
    L27:
        if (r14.size() <= 0) goto L30;
        this.f9816b.E0(r14, 1);
    L30:
        if (r15.size() <= 0) goto L32;
        this.f9816b.c(r15, 1);
    L32:
        if (r19 < 200) goto L34;
    L38:
        j.n("AppsDownloadManager pauseDownloadingApps:" + r19 + " | pausePendingApps:" + r14.size() + " | pendingApps:" + r15.size());
        return;
    L34:
        if (r15.size() <= 0) goto L36;
    L37:
        h();
        goto L38
    L36:
        if (r14.size() <= 0) goto L38;
        goto L37
    }

    public final synchronized void j(AppInfo r10, boolean r11) {
        monitor-enter(this);
        j.n("[AppStatus][AppsDownloadManager] enQueueDownloadRequest enter " + com.bytedanceos.common.d.a(r10) + r10);     // Catch: Throwable -> L8
        if (e.j0(r10) == false) goto L10;
        r10.downloadStatus = 8;     // Catch: Throwable -> L8
        this.f9816b.b(r10);     // Catch: Throwable -> L8
        j.n("[AppStatus][AppsDownloadManager] ApkDownloaded, installApp " + com.bytedanceos.common.d.a(r10));     // Catch: Throwable -> L8
        this.f9815a.installApp(BaseApplication.c(), r10);     // Catch: Throwable -> L8
        this.f9816b.l(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        AppInfo r12 = this.f9816b.D(r10.appPackageName);     // Catch: Throwable -> L8
        if (r12 == null) goto L18;
        if (r12.appVersionCode < r10.appVersionCode) goto L18;
        this.f9816b.p0(r10);     // Catch: Throwable -> L8
        this.f9816b.s0(r10.appPackageName);     // Catch: Throwable -> L8
        this.f9816b.m0(r10.appPackageName);     // Catch: Throwable -> L8
        j.n("[AppStatus][AppsDownloadManager] app has installed:" + r10.appPackageName);     // Catch: Throwable -> L8
        this.f9816b.l(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L18:
        if (e.d(this.f9816b, r10.appPackageName) == false) goto L23;
        this.f9816b.l(0);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L23:
        if (e.b(r10.appPackageName) == true) goto L27;
        monitor-exit(this);
        return;
    L27:
        if (r11 == false) goto L30;
        r10.downloadStatus = 1;     // Catch: Throwable -> L8
        this.f9816b.b(r10);     // Catch: Throwable -> L8
    L56:
        k(r10, r11);     // Catch: Throwable -> L8 Exception -> L46
        monitor-exit(this);
        return;
    L46:
        e = move-exception;
        j.a("AppsDownloadManager AppsDownloadManager API onError" + e.getMessage());     // Catch: Throwable -> L8
        if (r10.isAutoDownload == true) goto L50;
        e0.e(R$string.tip_bandwidth_state);     // Catch: Throwable -> L8
    L50:
        this.f9816b.k0(r10);     // Catch: Throwable -> L8
        e.printStackTrace();     // Catch: Throwable -> L8
        return;
    L30:
        if (TextUtils.equals(r10.appSource, "local") == false) goto L41;
        if (r10.appState == 64) goto L36;
        if (r10.isAppUpdate == false) goto L41;
    L36:
        if (e.U0(this.f9816b, r10, r12) == true) goto L56;
        this.f9815a.install(BaseApplication.c(), r10, true);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L41:
        if (this.f9816b.J() == false) goto L56;
        r10.downloadStatus = 1;     // Catch: Throwable -> L8
        this.f9816b.b(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public final long k(AppInfo r10, boolean r11) {
        return 0;
    }

    public final void m() {
    }

    public void n(Intent r10) {
        u((AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void o(Intent r10) {
        u((AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public void p() {
        List r10 = this.f9816b.v("UPDATE");
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L18;
        AppInfo r14 = (AppInfo) r13.next();
        AppInfo r15 = this.f9816b.t(r14.appPackageName);
        if (r15 == null) goto L7;
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r15.downloadId)) == false) goto L10;
        int r16 = r15.downloadStatus;
        if (r16 == 1) goto L17;
        if (r16 == 2) goto L17;
        if (r15.pauseCode == 4) goto L4;
    L17:
        r12.add(r15);
        goto L4
    L10:
        r11.add(r14);
        goto L4
    L7:
        j.n("AppsDownloadManager ignore pause new app");
        goto L4
    L18:
        Iterator r17 = r11.iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        AppInfo r18 = (AppInfo) r17.next();
        this.f9816b.D0(r18, 4);
        j.l("pauseUpdateApps pause " + r18.downloadStatus + ", " + r18.downloadStatus);
        goto L20
    L22:
        int r19 = r12.size();
        if (r19 <= 0) goto L44;
        long[] r20 = new long[r19];
        int r21 = 0;
    L25:
        if (r21 >= r19) goto L27;
        r20[r21] = ((AppInfo) r12.get(r21)).downloadId;
        r21 = r21 + 1;
        goto L25
    L27:
        q8.a.d(r20);
        this.f9816b.E0(r12, 4);
        return;
    }

    public int q(boolean r10, long... r11) {
        return -1;
    }

    public final void r(AppInfo r10) {
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L20
        r11.put(TrackerElement.PACKAGE_NAME, r10.appPackageName);     // Catch: Exception -> L20
        String r12 = r10.appName;     // Catch: Exception -> L20
        String r13 = "";
        if (r12 != null) goto L7;
        r12 = "";
    L7:
        r11.put("display_name", r12);     // Catch: Exception -> L20
        String r14 = r10.appCategoryName;     // Catch: Exception -> L20
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        r11.put("category", r14);     // Catch: Exception -> L20
        String r15 = r10.appBrief;     // Catch: Exception -> L20
        if (r15 == null) goto L14;
        r13 = r15;
    L14:
        r11.put("app_brief", r13);     // Catch: Exception -> L20
        if (r10.isAppUpdate == false) goto L17;
        int r16 = 2;
    L18:
        r11.put("event_type", r16);     // Catch: Exception -> L20
        v8.a.a(200000016, r11.toString());     // Catch: Exception -> L20
        return;
    L17:
        r16 = 1;
    L20:
        e = move-exception;
        j.b("MemoryDataEventReport download-event fail:" + e.getMessage());
        e.printStackTrace();
    }

    public final synchronized void s(AppInfo r10) {
        monitor-enter(this);
        if (r10 != null) goto L16;
        monitor-exit(this);
        return;
    L16:
        AppInfo r11 = this.f9816b.s(r10.appPackageName);     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        j.a("remove failed download record, pkg: " + r10.appPackageName);     // Catch: Throwable -> L9
        this.f9816b.k0(r10);     // Catch: Throwable -> L9
    L12:
        monitor-exit(this);
        return;
    L11:
        j.a("Cancel==========================================================================================================");     // Catch: Throwable -> L9
        j.n("AppsDownloadManager Cancel [PackageName: " + r10.appPackageName + "]");     // Catch: Throwable -> L9
        j.n("AppsDownloadManager Cancel [Request_ID:  " + r11.downloadId + "]");     // Catch: Throwable -> L9
        j.a("================================================================================================================");     // Catch: Throwable -> L9
        this.f9816b.k0(r11);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void t(Intent r10) {
        AppInfo r11 = (AppInfo) r10.getSerializableExtra(DownloadInfoColumns.TABLE);
        if (r11 != null) goto L24;
        return;
    L24:
        r11.mAllowMobile = r10.getBooleanExtra("mobile", false);     // Catch: Exception -> L8
        AppInfo r12 = this.f9816b.t(r11.appPackageName);     // Catch: Exception -> L8
        long[] r13 = {0};     // Catch: Exception -> L8
        if (r12 != null) goto L11;
        j(r11, false);     // Catch: Exception -> L8
        r13[0] = r11.downloadId;     // Catch: Exception -> L8
    L15:
        j.a("Continue========================================================================================================");     // Catch: Exception -> L8
        j.n("AppsDownloadManager Continue [Package: " + r11.appPackageName + "][ID:  " + r13[0] + "][Mobile:" + r11.mAllowMobile);     // Catch: Exception -> L8
        j.a("================================================================================================================");     // Catch: Exception -> L8
        return;
    L11:
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r12.downloadId)) == true) goto L25;
        this.f9816b.D0(r11, 1);     // Catch: Exception -> L8
        goto L15
    L25:
        long r14 = r12.downloadId;     // Catch: Exception -> L16
        r13[0] = r14;     // Catch: Exception -> L16
        q8.a.j(r11.mAllowMobile, new long[]{r14});     // Catch: Exception -> L16
    L16:
        e = move-exception;
        j.a("AppsDownloadManager API onError" + e.getMessage());     // Catch: Exception -> L8
        if (r11.isAutoDownload == true) goto L20;
        e0.e(R$string.tip_bandwidth_state);     // Catch: Exception -> L8
    L20:
        this.f9816b.k0(r11);     // Catch: Exception -> L8
        e.printStackTrace();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        this.f9816b.D0(r11, 4);
    }

    public final synchronized void u(AppInfo r10) {
        monitor-enter(this);
        if (r10 != null) goto L24;
        monitor-exit(this);
        return;
    L24:
        AppInfo r11 = this.f9816b.t(r10.appPackageName);     // Catch: Throwable -> L13
        if (r11 != null) goto L10;
    L15:
        j(r10, false);     // Catch: Throwable -> L13
        long r12 = r10.downloadId;     // Catch: Throwable -> L13
    L17:
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r12)) == false) goto L19;
        q8.a.d(new long[]{r12});     // Catch: Throwable -> L13
    L19:
        this.f9816b.D0(r10, 4);     // Catch: Throwable -> L13
        j.a("Pause===========================================================================================================");     // Catch: Throwable -> L13
        j.n("AppsDownloadManager Pause [PackageName: " + r10.appPackageName + "][Request_ID:  " + r12 + "]");     // Catch: Throwable -> L13
        j.a("================================================================================================================");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L10:
        if (com.smt.obric.appstore.domain.downloader.d.b(Long.valueOf(r11.downloadId)) == false) goto L15;
        r12 = r11.downloadId;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void v(AppInfo r10, boolean r11) {
    }

    public b() {
        this.f9816b = BaseApplication.c().b();
        this.f9815a = BaseApplication.c().g();
        m();
    }
}
