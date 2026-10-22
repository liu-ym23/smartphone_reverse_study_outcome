package com.bytedanceos.appstore.backup;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.webkit.URLUtil;
import com.bytedance.apm.constant.PerfTraceConsts;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.FetchDataCallBack;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class RestoreAppsService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Looper f8282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b f8283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CountDownLatch f8284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8285d;

    public class a implements FetchDataCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RestoreAppsService f8287b;

        public a(RestoreAppsService r10, int r11) {
            this.f8287b = r10;
            this.f8286a = r11;
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataFailed(int r10, Throwable r11, String r12, Object r13) {
            t8.a.a(c8.a.m(this.f8286a, 300000));
            RestoreAppsService.d(this.f8287b).countDown();
        }

        @Override // com.bytedanceos.common.network.FetchDataCallBack
        public void onFetchDataSuccess(int r10, int r11, String r12, Object r13, String r14) {
            Map r15 = com.bytedanceos.appstore.utils.b.e0(600006, r12);
            if (r15 != null) goto L5;
        L30:
            j.a("no backup apps");
            RestoreAppsService.d(this.f8287b).countDown();
            return;
        L5:
            if (r15.isEmpty() == true) goto L30;
            if (com.bytedanceos.appstore.utils.a.n(BaseApplication.c(), this.f8286a) == true) goto L10;
            t8.a.a(c8.a.m(this.f8286a, 0));
        L28:
            RestoreAppsService.d(this.f8287b).countDown();
            return;
        L10:
            if (this.f8286a != 134) goto L12;
            boolean r16 = true;
        L13:
            Iterator r17 = r15.values().iterator();
        L15:
            if (r17.hasNext() == false) goto L26;
            AppInfo r18 = (AppInfo) r17.next();
            if (com.bytedanceos.appstore.datacache.a.N0().b0(r18.appPackageName) == true) goto L25;
            if (com.bytedanceos.appstore.datacache.a.N0().X(r18.appPackageName) == true) goto L25;
            if (URLUtil.isNetworkUrl(r18.appDownloadUrl) == true) goto L23;
            j.a("url invalid:" + r18.appDownloadUrl);
            goto L15
        L23:
            com.bytedanceos.common.utils.j.a(BaseApplication.c(), r18, r16);
        L25:
            j.a("downloaded/downloading:" + r18.appPackageName);
            goto L15
        L26:
            b0.n().I("back_info", null, this.f8287b);
            goto L28
        L12:
            r16 = false;
            goto L13
        }
    }

    public final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RestoreAppsService f8288a;

        public b(RestoreAppsService r10, Looper r11) {
            this.f8288a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            int r11 = r10.what;
            switch(r11) {
                case 129: goto L22;
                case 130: goto L10;
                case 131: goto L9;
                case 132: goto L9;
                case 133: goto L5;
                case 134: goto L5;
                default: goto L4;
            };
        L4:
            j.a("unkown what:" + r10.what);
        L23:
            this.f8288a.stopSelf(r10.arg1);
            j.a("msg:" + r10.what);
            return;
        L5:
            b7.a r12 = com.bytedanceos.appstore.utils.a.s();
            if (r12 == null) goto L8;
            r12.e(r10.what);
            RestoreAppsService.c(this.f8288a, r12);
            goto L23
        L8:
            j.a("app list is null");
            goto L23
        L9:
            RestoreAppsService.b(this.f8288a, r11);
            goto L23
        L10:
            b7.a r13 = com.bytedanceos.appstore.utils.a.s();
            if (r13 != null) goto L15;
            j.a("kitkat app list is null");
            return;
        L15:
            if (r13.d() != 0) goto L17;
        L20:
            j.a("must set msg type and scheduler time.");
            return;
        L17:
            if (r13.a() == 0) goto L20;
            RestoreAppsService.c(this.f8288a, r13);
            goto L23
        L22:
            RestoreAppsService.a(this.f8288a, r10);
            goto L23
        }
    }

    public RestoreAppsService() {
        this.f8284c = new CountDownLatch(1);
        this.f8285d = 50;
    }

    public static /* synthetic */ void a(RestoreAppsService r10, Message r11) {
        r10.i(r11);
    }

    public static /* synthetic */ void b(RestoreAppsService r10, int r11) {
        r10.g(r11);
    }

    public static /* synthetic */ void c(RestoreAppsService r10, b7.a r11) {
        r10.h(r11);
    }

    public static /* synthetic */ CountDownLatch d(RestoreAppsService r10) {
        return r10.f8284c;
    }

    public final void e(ArrayList r10) {
        PackageManager r11 = BaseApplication.c().getPackageManager();
        if (r11 != null) goto L6;
        j.b("pm is null!");
        return;
    L6:
        List<PackageInfo> r12 = r11.getInstalledPackages(0);
        j.a("begin:" + r10);
        Iterator<PackageInfo> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r10.remove(r13.next().packageName);
        goto L8
    L10:
        j.a("end:" + r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.concurrent.CountDownLatch] */
    public final void f(int r10, List r11) {
        com.bytedanceos.appstore.network.a.h0(r11, new a(this, r10));
        this.f8284c.await(60, TimeUnit.SECONDS);     // Catch: Throwable -> L5 InterruptedException -> L7
    L4:
        RestoreAppsService this = this.f8284c;
        this.countDown();
        return;
    L5:
        th = move-exception;
        this.f8284c.countDown();
        throw th;
    L7:
        e = move-exception;
        j.a(e.getMessage());     // Catch: Throwable -> L5
        goto L4
    }

    public final void g(int r10) {
        b7.a r11 = com.bytedanceos.appstore.utils.a.s();
        if (r11 != null) goto L7;
        j.a("package list is null.");
        return;
    L7:
        if ((System.currentTimeMillis() - r11.d()) >= PerfTraceConsts.LAUNCH_TRACE_COLLECT_INFO_TIME_MS) goto L11;
        j.a("dialog has been restarted");
        return;
    L11:
        if (c8.a.s() == false) goto L14;
        return;
    L14:
        if (r11.c() > 0) goto L17;
        b0.n().I("back_info", null, this);
        j.a("reach max retry times");
        return;
    L17:
        r11.e(0);
        r11.h(System.currentTimeMillis());
        r11.g(r11.c() - 1);
        com.bytedanceos.appstore.utils.a.w(r11);
        Intent r12 = new Intent(this, RestoreAppsDialog.class);
        r12.putExtra("start_time", System.currentTimeMillis());
        r12.setFlags(268435456);
        startActivity(r12);
    }

    public final void h(b7.a r10) {
        if (com.bytedanceos.appstore.utils.a.n(this, r10.a()) == true) goto L6;
        j.a("network is not available");
        t8.a.a(c8.a.m(r10.a(), 0));
        return;
    L6:
        ArrayList r11 = r10.b();
        e(r11);
        int r12 = 0;
    L7:
        int r13 = this.f8285d + r12;
        if (r13 < r11.size()) goto L10;
        f(r10.a(), r11.subList(r12, r11.size()));
    L12:
        if (r13 >= r11.size()) goto L13;
        r12 = r13;
        goto L7
    L13:
        return;
    L10:
        f(r10.a(), r11.subList(r12, r13));
        goto L12
    }

    public final void i(Message r10) {
        if (r10.obj == null) goto L7;
        b7.a r11 = new b7.a();
        ArrayList r12 = (ArrayList) r10.obj;
        e(r12);
        if (r12.size() <= 0) goto L9;
        r11.f(r12);
        com.bytedanceos.appstore.utils.a.w(r11);
        Intent r13 = new Intent(this, RestoreAppsDialog.class);
        r13.putExtra("start_time", System.currentTimeMillis());
        r13.addFlags(268468224);
        startActivity(r13);
        return;
    L9:
        return;
    L7:
        j.a("params error.");
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        HandlerThread r10 = new HandlerThread("HandlerThread[RestoreAppsService]");
        r10.start();
        this.f8282a = r10.getLooper();
        if (this.f8282a == null) goto L5;
        this.f8283b = new b(this, this.f8282a);
    L5:
        BaseApplication.u("RestoreAppsService", false);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f8282a.quit();
        BaseApplication.u("RestoreAppsService", true);
    }

    @Override // android.app.Service
    public void onStart(Intent r10, int r11) {
        Message r12 = this.f8283b.obtainMessage();
        int r13 = r10.getIntExtra("type", 0);
        r12.what = r13;
        r12.arg1 = r11;
        if (r13 != 129) goto L6;
        r12.obj = r10.getStringArrayListExtra("packages");
        this.f8283b.sendMessageDelayed(r12, 1000);
    L14:
        j.a("type:" + r12.what);
        return;
    L6:
        if (r13 == 131) goto L8;
        if (r13 != 132) goto L13;
        this.f8283b.removeMessages(131);
        this.f8283b.sendMessageDelayed(r12, 1000);
        goto L14
    L13:
        this.f8283b.sendMessage(r12);
        goto L14
    L8:
        if (this.f8283b.hasMessages(132) == true) goto L10;
        this.f8283b.sendMessageDelayed(r12, 1000);
        goto L14
    L10:
        j.a("reboot msg in queue");
        goto L14
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r10, int r11, int r12) {
        if (r10 == null) goto L6;
        onStart(r10, r12);
        return 3;
    L6:
        return 3;
    }
}
