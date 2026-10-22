package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import java.util.ArrayList;
import n4a.c4;
import n4a.x4;

/* JADX INFO: loaded from: classes28.dex */
public class UmidtokenInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Handler f26777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f26778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static boolean f26779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AMapLocationClient f26780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f26781e;

    public static class a implements AMapLocationListener {
        public a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation r110) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r110};
            b r111 = new b();
            g06.a r102 = ApiHookConfig.f245611b.get(101329);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r112 = r103;
            int r104 = r112.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r112[r105];
            int r113 = r105;
            int r114 = r104;
            d r107 = r106.preInvoke(101329, "com/amap/api/location/UmidtokenInfo$a", "onLocationChanged", this, r101, "void", r111);     // Catch: Exception -> L26
            if (r107.f474982a == true) goto L12;
            r100.add(r106);     // Catch: Exception -> L26
            goto L14
        L12:
            Object r108 = null;
        L17:
            if (r107.f474982a == false) goto L27;
            return;
        L27:
        L23:
            th = move-exception;
            c4.g(th, "UmidListener", "onLocationChanged");
            return;
        L20:
            if (UmidtokenInfo.a() == null) goto L34;
            UmidtokenInfo.f26777a.removeCallbacksAndMessages(r108);     // Catch: Throwable -> L23
            UmidtokenInfo.a().onDestroy();     // Catch: Throwable -> L23
            return;
        L34:
            return;
        L14:
            r105 = r113 + 1;
            r104 = r114;
            goto L8
        L15:
            r108 = null;
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    static {
        f26777a = new Handler();
        f26778b = null;
        f26781e = 30000;
        f26779c = true;
    }

    public UmidtokenInfo() {
    }

    public static /* synthetic */ AMapLocationClient a() {
        return f26780d;
    }

    public static String getUmidtoken() {
        return f26778b;
    }

    public static void setLocAble(boolean r100) {
        f26779c = r100;
    }

    public static synchronized void setUmidtoken(Context r100, String r101) {
        monitor-enter(UmidtokenInfo.class);
        f26778b = r101;     // Catch: Throwable -> L11
        x4.f517927d = r101;     // Catch: Throwable -> L11
        if (f26780d == null) goto L7;
    L9:
        monitor-exit(UmidtokenInfo.class);
        return;
    L7:
        if (f26779c == false) goto L9;
        a r102 = new a();     // Catch: Throwable -> L11
        f26780d = new AMapLocationClient(r100);     // Catch: Throwable -> L11
        AMapLocationClientOption r103 = new AMapLocationClientOption();     // Catch: Throwable -> L11
        r103.setOnceLocation(true);     // Catch: Throwable -> L11
        r103.setNeedAddress(false);     // Catch: Throwable -> L11
        f26780d.setLocationOption(r103);     // Catch: Throwable -> L11
        f26780d.setLocationListener(r102);     // Catch: Throwable -> L11
        f26780d.startLocation();     // Catch: Throwable -> L11
        f26777a.postDelayed(new AnonymousClass1(), 30000);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        c4.g(th, "UmidListener", "setUmidtoken");     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
