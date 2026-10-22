package com.bytedanceos.appstore.download.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.appstore.download.manager.AppsInstallManager;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.ad.common.AdConstant;
import com.bytedanceos.common.ad.common.AdReportUtil;
import com.bytedanceos.common.core.install.GmsInstallService;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.obric.appstore.util.SimpleLRU;
import d9.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class AppInstallDispatchService extends IntentService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9411b = "AppInstallDispatchService";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f9412a;

    static {
    }

    public AppInstallDispatchService() {
        super(f9411b);
        this.f9412a = Collections.newSetFromMap(new SimpleLRU(100));
    }

    public final void a(AppInfo r10, int r11, boolean r12) {
        Context r13 = BaseApplication.c();
        Intent r14 = new Intent();
        if (TextUtils.equals(r10.appPackageName, "com.bytedance.gms") == false) goto L5;
        r14.setClass(r13, GmsInstallService.class);
        r14.putExtra("message_what", 1001);
    L6:
        r14.putExtra(DownloadInfoColumns.TABLE, r10);
        r14.putExtra(WsConstants.ERROR_CODE, r11);
        r14.putExtra("message_system_broadcast", r12);
        r13.startService(r14);
        a.e().p(false, r10.trackerInfo);
        return;
    L5:
        r14.setClass(r13, AppsInstallService.class);
        r14.putExtra("message_what", 29);
        goto L6
    }

    public final void b(AppInfo r10, boolean r11) {
        BaseApplication r12 = BaseApplication.c();
        if (TextUtils.equals(r10.appPackageName, "com.bytedance.gms") == false) goto L7;
        Intent r13 = new Intent(r12, GmsInstallService.class);
        r13.putExtra("message_what", 1000);
        r13.putExtra(DownloadInfoColumns.TABLE, r10);
        r13.putExtra("message_system_broadcast", r11);
        r12.startService(r13);
        return;
    L7:
        if ("local".equals(r10.appSource) == false) goto L9;
    L31:
        boolean r14 = e.S0(r10);
        int r15 = 9;
    L32:
        if (r14 == false) goto L34;
        Intent r16 = new Intent(r12, AppsInstallService.class);
        r16.putExtra("message_what", r15);
        r16.putExtra("message_system_broadcast", r11);
        r16.putExtra(DownloadInfoColumns.TABLE, r10);
        r12.startService(r16);
        return;
    L34:
        j.n(f9411b + r10.appPackageName + " | app_source:" + r10.appSource + " | path=" + r10.downloadFilePath);
        a(r10, 701, r11);
        return;
    L9:
        if ("backup".equals(r10.appSource) == true) goto L31;
        if ("launcher".equals(r10.appSource) == true) goto L31;
        if ("gloable_search".equals(r10.appSource) == true) goto L31;
        if ("sys_app_default".equals(r10.appSource) == true) goto L31;
        if ("sys_app_force".equals(r10.appSource) == true) goto L31;
        if ("sys_app_silence".equals(r10.appSource) == true) goto L31;
        if ("sys_app_silence_mobile".equals(r10.appSource) == true) goto L31;
        if ("ad".equals(r10.appSource) == true) goto L31;
        if ("bootup".equals(r10.appSource) == true) goto L31;
        if ("gms".equals(r10.appSource) == false) goto L30;
        com.bytedanceos.appstore.utils.a.I();
        r14 = e.S0(r10);
        r15 = 39;
        goto L32
    L30:
        r14 = e.S0(r10);
        r15 = 19;
        goto L32
    }

    public final void c(Context r10, AppInfo r11, boolean r12) {
        if (com.bytedanceos.appstore.datacache.a.N0().W(r11.appPackageName) == true) goto L5;
    L8:
        Intent r13 = new Intent(r10, AppsInstallService.class);
        if (r12 == false) goto L11;
        r13.putExtra("message_what", 9);
    L12:
        r13.putExtra("message_system_broadcast", false);
        r13.putExtra(DownloadInfoColumns.TABLE, r11);
        r10.startService(r13);
        return;
    L11:
        r13.putExtra("message_what", 69);
        goto L12
    L5:
        if (e.S0(r11) == true) goto L8;
        j.n(f9411b + " rename file failed " + r11.appPackageName);
        AppsInstallManager.getInstance().installFailure(r11, 702, null);
    }

    public final void d(AppInfo r10, String r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.equals("com.bytedanceos.app.download_complete", r11) == false) goto L25;
        String r12 = r10.appSource;
        switch(r12.hashCode()) {
            case -2092690800: goto L20;
            case -1200716349: goto L19;
            case -1091966885: goto L18;
            case 3107: goto L13;
            case 103145323: goto L11;
            case 814389169: goto L10;
            case 1362212369: goto L8;
            default: goto L21;
        };
    L8:
        String r13 = "sys_app_silence";
    L9:
        r12.equals(r13);
        goto L21
    L10:
        r13 = "sys_app_default";
        goto L9
    L11:
        r13 = "local";
        goto L9
    L18:
        r13 = "sys_app_force";
        goto L9
    L19:
        r13 = "gloable_search";
        goto L9
    L20:
        r13 = "sys_app_silence_mobile";
    L21:
        AdsReportManager.h().o(r10);
        a.e().p(true, r10.trackerInfo);
        return;
    L13:
        if (r12.equals("ad") == false) goto L21;
        if (TextUtils.equals(r10.mAdDsp, AdConstant.Dsp.TOUTIAO) == false) goto L23;
        AdReportUtil.reportSnsEvent(2, r10.mAdExtra);
        return;
    L23:
        return;
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent r14) {
        String r10 = f9411b;
        BaseApplication.u(r10, false);
        if (r14 != null) goto L6;
        j.e(r10 + " dispatchIntent is null.");
        return;
    L6:
        Intent r15 = (Intent) r14.getParcelableExtra("android.intent.extra.INTENT");
        if (r15 != null) goto L10;
        j.e(r10 + "intent is null.");
        return;
    L10:
        String r11 = r15.getAction();
        if (TextUtils.equals("com.bytedanceos.check.install.auto.update", r11) == false) goto L16;
        AppInfo r12 = (AppInfo) r15.getSerializableExtra(DownloadInfoColumns.TABLE);
        boolean r16 = r15.getBooleanExtra("isDiffPatch", false);
        if (r12 == null) goto L108;
        c(getBaseContext(), r12, r16);
    L108:
        BaseApplication.u(f9411b, true);
        return;
    L16:
        if (TextUtils.equals("com.bytedanceos.check.install.app", r11) == false) goto L18;
    L42:
        long r13 = r15.getLongExtra("extra_download_id", -1);
        if (r13 != (-1)) goto L47;
        j.n(r10 + " error download_id = " + r13);
        return;
    L47:
        if (this.f9412a.contains(Long.valueOf(r13)) == false) goto L50;
        j.n(r10 + " error mDownloadCompleteIds contains id = " + r13);
        return;
    L50:
        this.f9412a.add(Long.valueOf(r13));
        AppInfo r17 = q8.a.b().f(r13, true);
        if (r17 == null) goto L53;
        String r18 = q8.a.b().i(r13);
        if (TextUtils.isEmpty(r18) == true) goto L64;
        r17.mDownloadFailReason = r18;
    L65:
        com.bytedanceos.appstore.datacache.a.N0().t0(r17);
        int r19 = r17.downloadStatus;
        if (r19 != 8) goto L85;
        j.n(r10 + " AppInstallReceiver:id = " + r13 + " | " + r17.appPackageName + " | filePath: " + r17.downloadFilePath);
        j.n(r10 + " AppInstallReceiver:id = " + r13 + " | " + r17.appPackageName + " | appDownloadUrl: " + r17.appDownloadUrl + " | memUrl: " + r17.mMemUrl + " | dmUrl: " + r17.mDmUrl);
        if (TextUtils.equals(r17.appDownloadUrl, r17.mMemUrl) == false) goto L75;
        r17.mMemFilePath = r17.downloadFilePath;
        if (com.bytedanceos.appstore.datacache.a.N0().A(r17.appName) == null) goto L72;
        r17.mDmFilePath = com.bytedanceos.appstore.datacache.a.N0().A(r17.appName).mDmFilePath;
    L72:
        com.bytedanceos.appstore.datacache.a.N0().d(r17.appName, r17);
        return;
    L75:
        if (TextUtils.equals(r17.appDownloadUrl, r17.mDmUrl) == false) goto L82;
        r17.mDmFilePath = r17.downloadFilePath;
        if (com.bytedanceos.appstore.datacache.a.N0().A(r17.appName) == null) goto L79;
        r17.mMemFilePath = com.bytedanceos.appstore.datacache.a.N0().A(r17.appName).mMemFilePath;
    L79:
        com.bytedanceos.appstore.datacache.a.N0().d(r17.appName, r17);
        return;
    L82:
        if (com.bytedanceos.appstore.datacache.a.N0().A(r17.appName) == null) goto L84;
        AppInfo r110 = com.bytedanceos.appstore.datacache.a.N0().A(r17.appName);
        r17.mMemFilePath = r110.mMemFilePath;
        r17.mDmFilePath = r110.mDmFilePath;
    L84:
        j.n(r10 + " AppInstallReceiver:id = " + r13 + " | " + r17.appPackageName + " | filePath: " + r17.downloadFilePath + " | memFilePath: " + r17.mMemFilePath + " | dmFilePath: " + r17.mDmFilePath);
        com.bytedanceos.appstore.datacache.a.N0().n0(r17.appName);
        com.bytedanceos.appstore.datacache.a.N0().D0(r17, 8);
        d(r17, r11);
        b(r17, TextUtils.equals("com.bytedanceos.app.download_complete", r11));
    L95:
        if (TextUtils.equals("com.bytedanceos.app.download_complete", r11) == false) goto L108;
        if (r17.downloadStatus != 16) goto L107;
        boolean r111 = r17.isAutoDownload;
        if (r111 == true) goto L101;
    L103:
        if (r111 == true) goto L108;
        if (r17.mRetryNum != 2) goto L108;
        com.bytedanceos.appstore.datacache.a.N0().K0(r17);
        goto L108
    L101:
        if (r17.mRetryNum != 5) goto L103;
        com.bytedanceos.appstore.datacache.a.N0().K0(r17);
        goto L108
    L107:
        com.bytedanceos.appstore.datacache.a.N0().K0(r17);
        goto L108
    L85:
        if (r19 != 16) goto L93;
        j.n(r10 + " AppInstallReceiver:id = " + r13 + " | " + r17.appPackageName + " | failReason: " + r17.mDownloadFailReason);
        if (TextUtils.equals(r17.appDownloadUrl, r17.mMemUrl) == false) goto L89;
        return;
    L89:
        if (TextUtils.equals(r17.appDownloadUrl, r17.mDmUrl) == true) goto L118;
        com.bytedanceos.appstore.datacache.a.N0().D0(r17, 16);
        a(r17, (int) r17.pauseCode, true);
        goto L95
    L118:
        return;
    L93:
        j.n(r10 + " AppInstallReceiver:id = " + r13 + "|" + r17.downloadStatus);
        goto L95
    L64:
        r17.mDownloadFailReason = "reason null";
        goto L65
    L53:
        if (r15.hasExtra("is_removed") == true) goto L55;
        String r112 = "unknown";
    L59:
        j.n("[AppStatus][AppInstallDispatchService] info is null,id = " + r13 + ", isRemovedEvent = " + r112 + ". sync DownloadCache");
        BaseApplication.c().x();
        return;
    L55:
        if (r15.getBooleanExtra("is_removed", false) == false) goto L57;
        r112 = "true";
        goto L59
    L57:
        r112 = "false";
        goto L59
    L18:
        if (TextUtils.equals("com.bytedanceos.app.download_complete", r11) == true) goto L42;
        if (TextUtils.equals("com.bytedanceos.check.install.app.list", r11) == false) goto L108;
        ArrayList r113 = com.bytedanceos.appstore.datacache.a.N0().C();     // Catch: Exception -> L25
        StringBuilder r20 = new StringBuilder();     // Catch: Exception -> L25
        StringBuilder r21 = new StringBuilder();     // Catch: Exception -> L25
        r21.append("apps list: ");     // Catch: Exception -> L25
        if (r113 == null) goto L27;
        int r22 = r113.size();     // Catch: Exception -> L25
    L28:
        r21.append(r22);     // Catch: Exception -> L25
        r21.append(" | ");     // Catch: Exception -> L25
        r20.append(r21.toString());     // Catch: Exception -> L25
        if (r113 != null) goto L31;
    L39:
        j.e(r20.toString());     // Catch: Exception -> L25
        goto L108
    L31:
        if (r113.size() <= 0) goto L39;
        Iterator r114 = r113.iterator();     // Catch: Exception -> L25
    L34:
        if (r114.hasNext() == false) goto L39;
        AppInfo r23 = (AppInfo) r114.next();     // Catch: Exception -> L25
        if (r23.downloadFilePath == null) goto L37;
        r20.append("[" + r23.appName + "]");     // Catch: Exception -> L25
        b(r23, false);     // Catch: Exception -> L25
        goto L34
    L37:
        j.e("install apps error data," + r23.appPackageName + ",path = " + r23.downloadFilePath);     // Catch: Exception -> L25
        goto L34
    L27:
        r22 = 0;
    L25:
        e = move-exception;
        e.printStackTrace();
        j.e(f9411b + " object " + e.getMessage());
        goto L108
    }
}
