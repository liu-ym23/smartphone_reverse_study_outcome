package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.utils.logger.FLogger;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import me.ele.lancet.base.This;
import n4a.c4;
import n4a.o3;
import n4a.s2;

/* JADX INFO: loaded from: classes28.dex */
public class APSService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    o3 f26757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f26758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f26759c;

    public APSService() {
        this.f26758b = 0;
        this.f26759c = false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return this.f26757a.a(r100);
    L4:
        th = move-exception;
        c4.g(th, "APSService", "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        a(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        return com_amap_api_location_APSService_com_larus_common_location_impl_hook_AMapHook_onStartCommand(this, r100, r101, r102);
    }

    @Override // android.app.Service
    public void onDestroy() {
        o3 r100 = this.f26757a;     // Catch: Throwable -> L14
        r100.getClass();     // Catch: Throwable -> L14
        s2 r101 = r100.f517576a;     // Catch: Throwable -> L8
        if (r101 == null) goto L11;
        r101.f517686g.sendEmptyMessage(11);     // Catch: Throwable -> L8
    L11:
        if (this.f26759c == false) goto L16;
        stopForeground(true);     // Catch: Throwable -> L14
    L16:
        super.onDestroy();
        return;
    L8:
        th = move-exception;
        c4.g(th, "ApsServiceCore", LiveCommonConstants.REASON_ON_DEDTROY);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        c4.g(th, "APSService", LiveCommonConstants.REASON_ON_DEDTROY);
        goto L16
    }

    private void a(Context r100) {
    L13:
        th = move-exception;
        c4.g(th, "APSService", WidgetCostModule.TYPE_ON_CREATE);
    L15:
        super.onCreate();
        return;
    L4:
        if (this.f26757a != null) goto L6;
        this.f26757a = new o3(r100);     // Catch: Throwable -> L13
    L6:
        o3 r101 = this.f26757a;     // Catch: Throwable -> L13
        r101.getClass();     // Catch: Throwable -> L13
        s2.f517679w = false;     // Catch: Throwable -> L10
        s2 r102 = r101.f517576a;     // Catch: Throwable -> L10
        r102.f517692m = SystemClock.elapsedRealtime();     // Catch: Throwable -> L10
        s2 r103 = r101.f517576a;     // Catch: Throwable -> L10
        r103.f517693n = System.currentTimeMillis();     // Catch: Throwable -> L10
        r101.f517576a.i();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        c4.g(th, "ApsServiceCore", WidgetCostModule.TYPE_ON_CREATE);     // Catch: Throwable -> L13
        goto L15
    }

    public int com_amap_api_location_APSService__onStartCommand$___twin___(Intent r100, int r101, int r102) {
        if (r100 == null) goto L32;
        int r103 = r100.getIntExtra(ce.f26391f, 0);     // Catch: Throwable -> L30
        if (r103 != 1) goto L10;
        int r104 = r100.getIntExtra(RXScreenCaptureService.KEY_INDEX, 0);     // Catch: Throwable -> L30
        Notification r105 = (Notification) r100.getParcelableExtra("h");     // Catch: Throwable -> L30
        if (r104 == 0) goto L32;
        if (r105 == null) goto L32;
        startForeground(r104, r105);     // Catch: Throwable -> L30
        this.f26759c = true;     // Catch: Throwable -> L30
        this.f26758b++;     // Catch: Throwable -> L30
        goto L32
    L10:
        if (r103 != 2) goto L32;
        if (r100.getBooleanExtra(ce.f26395j, true) == false) goto L17;
        int r106 = this.f26758b;     // Catch: Throwable -> L30
        if (r106 <= 0) goto L17;
        this.f26758b = r106 - 1;     // Catch: Throwable -> L30
    L17:
        if (this.f26758b > 0) goto L19;
        stopForeground(true);     // Catch: Throwable -> L30
        this.f26759c = false;     // Catch: Throwable -> L30
        goto L32
    L19:
        stopForeground(false);     // Catch: Throwable -> L30
    L32:
        s2 r107 = this.f26757a.f517576a;     // Catch: Throwable -> L27
        if (r107 == null) goto L25;
        if (r107.f517701v.isSelfStartServiceEnable() == true) goto L25;
        return 2;
    L25:
        return 3;
    L27:
        th = move-exception;
        c4.g(th, "APSService", "onStartCommand");
        return super.onStartCommand(r100, r101, r102);
    }

    public static int com_amap_api_location_APSService_com_larus_common_location_impl_hook_AMapHook_onStartCommand(APSService r100, Intent r101, int r102, int r103) {
        int r104 = r100.com_amap_api_location_APSService__onStartCommand$___twin___(r101, r102, r103);
        FLogger.f375446a.i("ServiceHook", "Service Name" + This.CLASS_NAME + ", Return Value" + r104);
        return 2;
    }
}
