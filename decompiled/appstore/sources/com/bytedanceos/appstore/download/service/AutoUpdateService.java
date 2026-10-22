package com.bytedanceos.appstore.download.service;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedanceos.appstore.datacache.a;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.database.DataBaseManager;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import com.bytedanceos.common.utils.r;
import com.obric.appstore.R;
import com.smt.obric.appstore.domain.downloader.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(3)
public class AutoUpdateService extends IntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AutoUpdateServiceKtx f9413a;

    public AutoUpdateService() {
        super("AppsUpdateService");
        this.f9413a = new AutoUpdateServiceKtx();
    }

    public final long a(AppInfo r10) {
        AppInfo r11 = a.N0().s(r10.appPackageName);
        if (r11 != null) goto L6;
        return 0;
    L6:
        if (r11.downloadStatus != 4) goto L18;
        long r12 = r11.pauseCode;
        if (r12 != 4) goto L10;
    L11:
        long r13 = r11.downloadTotalBytes;
        if (r13 > 0) goto L16;
        return r11.appBytes;
    L16:
        return r13 - r11.downloadCurrentBytes;
    L10:
        if (r12 == 5) goto L11;
    L18:
        return r11.appBytes;
    }

    public final void b() {
        ArrayList r10 = q8.a.b().h();
        if (r10.size() <= 0) goto L5;
        e.h0();
    L5:
        j.n("auto update size:" + r10.size());
    }

    public final void c() {
        t8.a.d(4399);
        List r10 = a.N0().v("DOWNLOAD");
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        AppInfo r14 = (AppInfo) r13.next();
        if (r14.isAutoDownload == false) goto L4;
        if (d.b(Long.valueOf(r14.downloadId)) == true) goto L9;
        r12.add(r14);
        goto L4
    L9:
        r11.add(Long.valueOf(r14.downloadId));
        goto L4
    L11:
        int r15 = 0;
        if (r12.size() <= 0) goto L18;
        a.N0().o0(r12);
        Iterator r16 = r12.iterator();
    L15:
        if (r16.hasNext() == false) goto L18;
        ((AppInfo) r16.next()).isAutoDownload = false;
    L18:
        if (r11.size() <= 0) goto L27;
        long[] r17 = new long[r11.size()];
    L21:
        if (r15 >= r11.size()) goto L29;
        r17[r15] = ((Long) r11.get(r15)).longValue();
        r15 = r15 + 1;
        goto L21
    L29:
        q8.a.d(r17);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L27:
        j.n("[AutoUpdate][AppStatus] pause update,stop size:" + r12.size() + "| pause size:" + r11.size());
    }

    public final void d(boolean r10, int r11) {
        com.bytedanceos.appstore.utils.e.a(getApplicationContext(), true);
        if (r10 == false) goto L5;
    L10:
        if (r10 == false) goto L18;
        if (e.u0() == true) goto L18;
        j.n("[AutoUpdate][AppStatus] startAutoUpdate skip! AutoDownload condition not satisfied 2. remaining retry times: " + r11);
        if (r11 <= 0) goto L94;
        t8.a.a(c8.a.l(r11 - 1));
        return;
    L94:
        return;
    L18:
        if (com.bytedanceos.appstore.utils.a.b(BaseApplication.c()) == false) goto L21;
        j.n("[AutoUpdate][AppStatus] startAutoUpdate skip! SafeMode is true, No need to auto-update. isReserve:" + r10);
        return;
    L21:
        long r12 = e.I();
        if (r12 > 0) goto L25;
        a8.a.N().S();
        j.n("[AutoUpdate][AppStatus] startAutoUpdate skip!. disk space is full! isReserve:" + r10);
        return;
    L25:
        if (r10 == false) goto L27;
        Map<String, AppInfo> r13 = DataBaseManager.ReserveApps.getReserveApps();
    L29:
        if (r13.isEmpty() == false) goto L32;
        j.n("[AutoUpdate][AppStatus] startAutoUpdate skip! auto-update apps is empty. isReserve:" + r10);
        return;
    L32:
        j.n("[AutoUpdate][AppStatus] startAutoUpdate. Execute auto-update apps, apps size: " + r13.size() + ", isReserve:" + r10);
        a.N0().C0();
        Iterator<AppInfo> r14 = r13.values().iterator();
    L34:
        if (r14.hasNext() == false) goto L68;
        AppInfo r15 = r14.next();
        if (r.c(r15.appPackageName) == false) goto L67;
        if (r.b(r15.appPackageName) == false) goto L67;
        if (r10 == true) goto L48;
        if (a.N0().b0(r15.appPackageName) == false) goto L46;
        if (a.N0().U(r15.appPackageName) == true) goto L48;
    L46:
        j.n("[AutoUpdate][AppStatus] startAutoUpdate Execute skip! Execute auto-update apps, skip app: " + r15.appPackageName + " for installed/cannotUpdate");
    L48:
        if (a.N0().X(r15.appPackageName) == true) goto L49;
        if (a.N0().c0(r15.appPackageName) == true) goto L52;
        if (r10 == false) goto L55;
        long r16 = r15.appBytes;
    L57:
        if (r16 == 0) goto L34;
        r12 = r12 - r16;
        if (r12 <= 0) goto L61;
        r15.tabSource = "AppsUpdateService";
        r15.isAutoDownload = true;
        if (com.bytedanceos.appstore.utils.a.c(r15.appDownloadUrl) == true) goto L65;
        e0.e(R.string.download_error_url);
        goto L34
    L65:
        s.g(getApplicationContext());
        com.bytedanceos.appstore.utils.a.r(getApplicationContext());
        this.f9413a.b(r15);
        goto L34
    L61:
        a8.a.N().S();
        j.n("[AutoUpdate][AppStatus] startAutoUpdate skip! disk space is full,stop auto-update!");
        return;
    L55:
        r16 = a(r15);
        goto L57
    L52:
        com.bytedanceos.common.utils.j.c(getApplicationContext(), r15, false);
        goto L34
    L49:
        j.n("[AutoUpdate][AppStatus] startAutoUpdate Execute skip! Execute auto-update apps, skip app: " + r15.appPackageName + " for downloading");
    L67:
        j.n("[AutoUpdate][AppStatus] startAutoUpdate Execute skip! Execute auto-update apps, hide app: " + r15.appPackageName);
        goto L34
    L68:
        return;
    L27:
        r13 = a.N0().z();
        goto L29
    L5:
        if (e.l0() == true) goto L10;
        j.n("[AutoUpdate][AppStatus] startAutoUpdate skip! AutoDownload condition not satisfied 1. remaining retry times: " + r11);
        if (r11 <= 0) goto L93;
        t8.a.a(c8.a.k(r11 - 1));
        return;
    }

    public final void e() {
        t8.a.d(4399);
        List r10 = a.N0().v("DOWNLOAD");
        ArrayList r11 = new ArrayList();
        Iterator r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        AppInfo r13 = (AppInfo) r12.next();
        if (r13.isAutoDownload == false) goto L4;
        r11.add(r13);
        goto L4
    L9:
        if (r11.size() <= 0) goto L11;
        a.N0().o0(r11);
    L11:
        List r14 = a.N0().v("UPDATE");
        if (r14 == null) goto L17;
        Iterator r15 = r14.iterator();
    L15:
        if (r15.hasNext() == false) goto L17;
        ((AppInfo) r15.next()).isAutoDownload = false;
    L17:
        j.n("stop update:" + r11.size());
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        setIntentRedelivery(false);
        BaseApplication.u("AppsUpdateService", false);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.u("AppsUpdateService", true);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent r10) {
        if (r10 != null) goto L5;
        j.n("[AutoUpdate] AutoUpdateService updateService input params error.");
        return;
    L5:
        j.n("[AutoUpdate] AutoUpdateService acton:" + r10.getAction());
        if (TextUtils.equals(r10.getAction(), "com.bytedance.appstore.autoupdate.download") == false) goto L9;
        d(false, r10.getIntExtra("retry_time", 0));
        return;
    L9:
        if (TextUtils.equals(r10.getAction(), "com.bytedance.appstore.autoupdate.switch") == false) goto L15;
        boolean r11 = r10.getBooleanExtra("isChecked", false);
        s.r(BaseApplication.c(), r11);
        if (r11 == false) goto L13;
        e.j(this, 1000);
        return;
    L13:
        e();
        return;
    L15:
        if (TextUtils.equals(r10.getAction(), "com.bytedance.appstore.autoupdate.install") == false) goto L18;
        b();
        return;
    L18:
        if (TextUtils.equals(r10.getAction(), "com.bytedance.appstore.autoupdate.pause") == false) goto L21;
        c();
        return;
    L21:
        if (TextUtils.equals(r10.getAction(), "com.bytedance.appstore.autoupdate.download.reserve") == false) goto L29;
        d(true, r10.getIntExtra("retry_time", 0));
        return;
    }
}
