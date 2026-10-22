package com.bytedanceos.common;

import android.app.IntentService;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.toolbox.s;
import com.bytedanceos.common.utils.ReflectTool;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class BackgroundWorkerService extends IntentService {
    public BackgroundWorkerService() {
        super("BackgroundWorkerService");
    }

    public final void a() {
        String r10 = b0.n().s("LOCALE_LANGUAGE", null, this);
        String r11 = Locale.getDefault().getCountry();
        if (TextUtils.equals(r11, r10) == true) goto L5;
        b0.n().H("LOCALE_LANGUAGE", Locale.getDefault().getCountry(), null, this);
        BaseApplication.c().b().w0("UPDATE");
        BaseApplication.c().b().w0("LOCAL_APPS_ONLINE");
        BaseApplication.c().b().w0("MYAPPS");
        BaseApplication.c().b().w0("COLLECT");
        y8.f.f(true);
    L5:
        j.n("language changed, " + r10 + LibrarianImpl.Constants.SEPARATOR + r11);
    }

    public final void b() {
        int r10 = b0.n().o("app_download_count", null, this);
        if (r10 <= 0) goto L6;
        d9.a.e().H(r10);
        b0.n().E("app_download_count", 0, null, this);
        return;
    }

    public final void c() {
        if (BaseApplication.c().o() == false) goto L5;
        BaseApplication.c().h().addUploadInstalledAppsScheduler();
    L5:
        com.bytedanceos.common.toolbox.e.j(this, 60000);
        j.n("boot completed");
    }

    public final void d() {
        if (BaseApplication.c().o() == false) goto L5;
        BaseApplication.c().a();
        BaseApplication.c().i();
    L5:
        ReflectTool.setAllowAutoStart(this);
        BaseApplication.c().b().L();
        AdsReportManager.h().u();
        j.n("initStore finish");
    }

    public final void e() {
        d9.a.e().f();
        boolean r10 = AccountDataCache.b().n();
        boolean r11 = s.l(this);
        boolean r12 = s.i(this);
        boolean r13 = s.g(this);
        boolean r14 = s.n(this);
        boolean r15 = s.m(this);
        boolean r16 = s.k(this);
        d9.a.e().g(r10 ? 1 : 0, r11 ? 1 : 0, r12 ? 1 : 0, r13 ? 1 : 0, r14 ? 1 : 0, r15 ? 1 : 0, r16 ? 1 : 0);
        d9.a.e().c();
    }

    public final void f(Intent r10) {
        if (TextUtils.equals("bytedanceos.appstore.recommend.app.detail.internal", r10.getAction()) == false) goto L7;
        if (TextUtils.equals("update", r10.getType()) == false) goto L7;
    L9:
        BaseApplication.c().b().N(false);
    L10:
        com.bytedanceos.common.toolbox.e.c1();
        if (BaseApplication.c().o() == false) goto L13;
        com.bytedanceos.common.toolbox.e.Q0(this);
        com.bytedanceos.common.toolbox.e.i(BaseApplication.c());
    L13:
        e();
        b();
        j.m("startStore finish");
        return;
    L7:
        if (s.i(BaseApplication.c()) == false) goto L9;
        BaseApplication.c().b().N(true);
        goto L10
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        BaseApplication.u("BackgroundWorkerService", false);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BaseApplication.u("BackgroundWorkerService", true);
    }

    @Override // android.app.IntentService
    public void onHandleIntent(Intent r10) {
        if (r10 != null) goto L6;
        j.n("intent params is null");
        return;
    L6:
        switch(r10.getIntExtra("background_worker_type", 0)) {
            case 129: goto L11;
            case 130: goto L10;
            case 131: goto L9;
            case 132: goto L8;
            default: goto L16;
        };
    L8:
        c();
        return;
    L9:
        a();
        return;
    L10:
        f(r10);
        return;
    L11:
        d();
        return;
    }
}
