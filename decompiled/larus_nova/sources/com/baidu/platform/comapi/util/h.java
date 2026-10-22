package com.baidu.platform.comapi.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comjni.base.sdkauth.NASDKAuth;

/* JADX INFO: loaded from: classes39.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f33427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NASDKAuth f33428b;

    public static void a() {
        if (f33427a != null) goto L5;
        return;
    L5:
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33427a == null) goto L9;
        f33427a.c();     // Catch: Throwable -> L11
        f33427a = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    }

    public static h b() {
        if (f33427a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f33427a != null) goto L9;
        f33427a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f33427a;
    }

    private void c() {
        this.f33428b.dispose();
    }

    private h() {
        this.f33428b = new NASDKAuth();
    }

    public boolean a(String r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        com.baidu.platform.comjni.base.sdkauth.a r102 = com.baidu.platform.comjni.base.sdkauth.a.f33432a;
        if ((r102.a() & r101) == 0) goto L8;
        this.f33428b.a(r100, r102.a());
    L8:
        com.baidu.platform.comjni.base.sdkauth.a r103 = com.baidu.platform.comjni.base.sdkauth.a.f33433b;
        if ((r101 & r103.a()) == 0) goto L13;
        String r104 = "token=" + AppMD5.encodeUrlParamsValue(r100);
        this.f33428b.a("https://api.map.baidu.com/sdkproxy/lbs_androidsdk/api_watermark/sdk_get_auth?" + (r104 + "&sign=" + AppMD5.getSignMD5String(r104)), r103.a());
        return true;
    L13:
        return true;
    }
}
