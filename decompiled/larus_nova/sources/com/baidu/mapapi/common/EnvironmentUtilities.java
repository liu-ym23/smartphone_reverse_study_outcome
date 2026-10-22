package com.baidu.mapapi.common;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes39.dex */
public class EnvironmentUtilities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f30538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f30539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static String f30540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f30541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int f30542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static int f30543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f30544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static f f30545h;

    public static String getAppSDCardPath() {
        String r100 = f30538a + "/BaiduMapSDKNew";
        if (r100.length() == 0) goto L7;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L7;
        r101.mkdirs();
    L7:
        return r100;
    }

    public EnvironmentUtilities() {
    }

    public static String getAppCachePath() {
        return f30539b;
    }

    public static String getAppSecondCachePath() {
        return f30540c;
    }

    public static int getDomTmpStgMax() {
        return f30542e;
    }

    public static int getItsTmpStgMax() {
        return f30543f;
    }

    public static int getMapTmpStgMax() {
        return f30541d;
    }

    public static String getSDCardPath() {
        return f30538a;
    }

    public static int getSsgTmpStgMax() {
        return f30544g;
    }

    public static void initAppDirectory(Context r100) {
        if (f30545h != null) goto L5;
        f r101 = f.b();
        f30545h = r101;
        r101.b(r100);
    L5:
        String r102 = f30538a;
        if (r102 == null) goto L11;
        if (r102.length() <= 0) goto L11;
        StringBuilder r103 = new StringBuilder();
        r103.append(f30538a);
        String r104 = File.separator;
        r103.append(r104);
        r103.append("BaiduMapSDKNew");
        r103.append(r104);
        r103.append("cache");
        f30539b = r103.toString();
    L14:
        if (f30545h.a() == null) goto L16;
        f30540c = f30545h.a().d();
    L16:
        f30541d = ALogDefaultConfig.DEVICE_MAX_LOG_SPACE_SIZE;
        f30542e = ALogDefaultConfig.DEVICE_MAX_LOG_SPACE_SIZE;
        f30543f = 5242880;
        f30544g = ALogDefaultConfig.DEVICE_MAX_LOG_SPACE_SIZE;
        return;
    L11:
        if (f30545h.a() == null) goto L14;
        f30538a = f30545h.a().c();
        f30539b = f30545h.a().b();
        goto L14
    }

    public static void setSDCardPath(String r100) {
        f30538a = r100;
    }
}
