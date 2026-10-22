package com.baidu.platform.comapi.util;

import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comjni.base.sdkauth.NASDKAuth;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static volatile h f9307a;

    /* renamed from: b, reason: collision with root package name */
    private NASDKAuth f9308b = new NASDKAuth();

    private h() {
    }

    public static void a() {
        if (f9307a != null) {
            synchronized (h.class) {
                try {
                    if (f9307a != null) {
                        f9307a.c();
                        f9307a = null;
                    }
                } finally {
                }
            }
        }
    }

    public static h b() {
        if (f9307a == null) {
            synchronized (h.class) {
                try {
                    if (f9307a == null) {
                        f9307a = new h();
                    }
                } finally {
                }
            }
        }
        return f9307a;
    }

    private void c() {
        this.f9308b.dispose();
    }

    public boolean a(String str, int i4) {
        if (str == null) {
            return false;
        }
        com.baidu.platform.comjni.base.sdkauth.a aVar = com.baidu.platform.comjni.base.sdkauth.a.ParkingSpace;
        if ((aVar.a() & i4) != 0) {
            this.f9308b.a(str, aVar.a());
        }
        com.baidu.platform.comjni.base.sdkauth.a aVar2 = com.baidu.platform.comjni.base.sdkauth.a.WaterMark;
        if ((i4 & aVar2.a()) == 0) {
            return true;
        }
        String str2 = "token=" + AppMD5.encodeUrlParamsValue(str);
        StringBuilder sbV = B0.g.v(str2, "&sign=");
        sbV.append(AppMD5.getSignMD5String(str2));
        this.f9308b.a(B0.g.m("https://api.map.baidu.com/sdkproxy/lbs_androidsdk/api_watermark/sdk_get_auth?", sbV.toString()), aVar2.a());
        return true;
    }
}
