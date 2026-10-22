package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapapi.ISDKInitializerListener;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.RequestAuthResultListener;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.g;
import com.baidu.platform.comapi.util.a.b;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class Initializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f31944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CommonInfo f31945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f31946c;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapsdkplatform_comapi_Initializer$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public a() {
        }

        public void com_baidu_mapsdkplatform_comapi_Initializer$a__run$___twin___() {
            SysOSUtil.updateCuid();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapsdkplatform_comapi_Initializer$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_baidu_mapsdkplatform_comapi_Initializer$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static void onBackground() {
        g.a(false);
    }

    public static void onForeground() {
        g.a(true);
    }

    private Initializer() {
    }

    public static CommonInfo getCommonInfo() {
        return f31945b;
    }

    public static boolean isAgreePrivacyMode() {
        return f31946c;
    }

    public static boolean isInitialized() {
        return f31944a;
    }

    private static boolean a(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isEmpty() == true) goto L22;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.concat("/check.0"));     // Catch: IOException -> L15
        if (r101.exists() == false) goto L10;
        r101.delete();     // Catch: IOException -> L15
    L10:
        r101.createNewFile();     // Catch: IOException -> L15
        if (r101.exists() == false) goto L21;
        r101.delete();     // Catch: IOException -> L15
        return true;
    L21:
        return true;
    L16:
        throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
    L22:
        return false;
    }

    public static void addAuthResultListener(RequestAuthResultListener r100) {
        PermissionCheck.addRequestAuthResultListener(r100);
    }

    public static void removeAuthResultListener(RequestAuthResultListener r100) {
        PermissionCheck.removeRequestAuthResultListener(r100);
    }

    public static void setCommonInfo(CommonInfo r100) {
        f31945b = r100;
    }

    public static void setPrivacyMode(Context r100, boolean r101) {
        if (r100 == null) goto L10;
        if ((r100 instanceof Application) == false) goto L8;
        f31946c = r101;
        LBSAuthManager.getInstance(r100).setPrivacyMode(r101);
        PermissionCheck.setPrivacyMode(r101);
        g.b(r101);
        com.baidu.mapapi.a.a().submit(new a());
        return;
    L8:
        throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
    L10:
        throw new IllegalArgumentException("BDMapSDKException: context can not be null");
    }

    public static void initialize(Context r100, boolean r101, String r102, String r103, String r104, ISDKInitializerListener r105) {
        if (f31944a == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L21;
        if ((r100 instanceof Application) == false) goto L19;
        NativeLoader.setContext(r100);
        NativeLoader.a(r101, r102);
        JNIInitializer.setContext((Application) r100);
        com.baidu.platform.comapi.util.SysOSUtil.getInstance().init(new b(), new com.baidu.platform.comapi.util.a.a());
        if (a(r103) == false) goto L11;
        EnvironmentUtilities.setSDCardPath(r103);
    L11:
        EnvironmentUtilities.initAppDirectory(r100);
        BMapManagerInternal.getInstance().a(r100);
        BMapManagerInternal.getInstance().permcheck();
        if (OpenLogUtil.isNativeLogAnalysisEnable() == false) goto L14;
        com.baidu.mapsdkplatform.comapi.a.a.b.c().a(r100);
    L14:
        f31944a = true;
        if (r105 == null) goto L22;
        r105.initializerFinish();
        return;
    L22:
        return;
    L19:
        throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
    L21:
        throw new IllegalArgumentException("BDMapSDKException: context can not be null");
    }
}
