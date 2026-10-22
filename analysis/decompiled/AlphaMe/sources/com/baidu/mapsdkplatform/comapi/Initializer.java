package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.CommonInfo;
import com.baidu.mapapi.ISDKInitializerListener;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.http.wrapper.ThreadPoolUtils;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.platform.comapi.util.a.b;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class Initializer {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7820a = false;

    /* renamed from: b, reason: collision with root package name */
    private static CommonInfo f7821b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f7822c = false;

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            SysOSUtil.updateCuid();
        }
    }

    private Initializer() {
    }

    private static boolean a(String str) throws IOException {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            File file = new File(str.concat("/check.0"));
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            if (!file.exists()) {
                return true;
            }
            file.delete();
            return true;
        } catch (IOException e4) {
            Log.e("SDKInitializer", "SDCard cache path invalid", e4);
            throw new IllegalArgumentException("BDMapSDKException: Provided sdcard cache path invalid can not used.");
        }
    }

    public static CommonInfo getCommonInfo() {
        return f7821b;
    }

    public static void initialize(Context context, boolean z4, String str, String str2, String str3, ISDKInitializerListener iSDKInitializerListener) {
        if (f7820a) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("BDMapSDKException: context can not be null");
        }
        if (!(context instanceof Application)) {
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        NativeLoader.setContext(context);
        NativeLoader.a(z4, str);
        JNIInitializer.setContext((Application) context);
        com.baidu.platform.comapi.util.SysOSUtil.getInstance().init(new b(), new com.baidu.platform.comapi.util.a.a());
        if (a(str2)) {
            EnvironmentUtilities.setSDCardPath(str2);
        }
        EnvironmentUtilities.initAppDirectory(context);
        BMapManagerInternal.getInstance().a(context);
        BMapManagerInternal.getInstance().permcheck();
        if (OpenLogUtil.isNativeLogAnalysisEnable()) {
            com.baidu.mapsdkplatform.comapi.a.a.b.c().a(context);
        }
        f7820a = true;
        if (iSDKInitializerListener != null) {
            iSDKInitializerListener.initializerFinish();
        }
    }

    public static boolean isAgreePrivacyMode() {
        return f7822c;
    }

    public static boolean isInitialized() {
        return f7820a;
    }

    public static void onBackground() {
        f.a(false);
    }

    public static void onForeground() {
        f.a(true);
    }

    public static void setCommonInfo(CommonInfo commonInfo) {
        f7821b = commonInfo;
    }

    public static void setPrivacyMode(Context context, boolean z4) {
        if (context == null) {
            throw new IllegalArgumentException("BDMapSDKException: context can not be null");
        }
        if (!(context instanceof Application)) {
            throw new RuntimeException("BDMapSDKException: context must be an ApplicationContext");
        }
        f7822c = z4;
        PermissionCheck.setPrivacyMode(z4);
        f.b(z4);
        LBSAuthManager.getInstance(context).setPrivacyMode(z4);
        ThreadPoolUtils.getThreadPool().submit(new a());
    }
}
