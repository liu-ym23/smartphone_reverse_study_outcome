package com.baidu.mapsdkplatform.comapi.map;

import android.app.Application;
import android.content.Context;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.NativeLoader;
import com.baidu.mapsdkplatform.comapi.commonutils.SysUpdateUtil;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.logstatistics.LogStatistics;
import com.baidu.platform.comapi.longlink.BNLongLink;
import com.baidu.platform.comjni.engine.NAEngine;

/* JADX INFO: loaded from: classes39.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f32158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f32159b;

    public static void a() {
        f32158a--;
        if (OpenLogUtil.isMapLogEnable() == false) goto L6;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap destroy mRef = " + f32158a);
    L6:
        if (f32158a != 0) goto L9;
        SysUpdateObservable.getInstance().clearObserver();
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().c();
        LogStatistics.getInstance().a();
        JNIInitializer.destroy();
        return;
    }

    public static void c() {
        if (f32158a == 0) goto L5;
    L10:
        f32158a++;
        if (OpenLogUtil.isMapLogEnable() == false) goto L14;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("BasicMap init mRef = " + f32158a);
        return;
    L14:
        return;
    L5:
        if (f32159b != null) goto L9;
        Context r100 = JNIInitializer.getCachedContext();
        f32159b = r100;
        if (r100 != null) goto L9;
        return;
    L9:
        SysOSUtil.updateCuid();
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().b();
        JNIInitializer.attach((Application) f32159b, true, false, false, true);
        JNIInitializer.initEngine();
        JNIInitializer.initEngineResource(new AppResList());
        com.baidu.platform.comapi.util.e.a();
        BNLongLink.initLongLink();
        NAEngine.b();
        NAEngine.startRunningRequest();
        SysUpdateObservable.getInstance().addObserver(new SysUpdateUtil());
        SysUpdateObservable.getInstance().init("");
        com.baidu.platform.comapi.util.e.d();
        goto L10
    }

    static {
        f32159b = BMapManager.getContext();
        if (Initializer.isInitialized() == true) goto L6;
        NativeLoader.getInstance().loadLibrary(com.baidu.mapapi.VersionInfo.getKitName());
    L6:
        if (com.baidu.mapapi.VersionInfo.getApiVersion().equals(VersionInfo.getApiVersion()) == false) goto L10;
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        return;
    L10:
        throw new BaiduMapSDKException("the version of map is not match with base");
    }

    public static int b() {
        return f32158a;
    }
}
