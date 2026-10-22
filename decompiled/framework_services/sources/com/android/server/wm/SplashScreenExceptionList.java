package com.android.server.wm;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.DeviceConfig;
import android.util.Utils;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class SplashScreenExceptionList {
    private static final boolean DEBUG = false;
    private static final String KEY_SPLASH_SCREEN_EXCEPTION_LIST = "splash_screen_exception_list";
    private static final String LOG_TAG = "SplashScreenExceptionList";
    private static final String NAMESPACE = "window_manager";
    private static final String OPT_OUT_METADATA_FLAG = "android.splashscreen.exception_opt_out";
    private final HashSet<String> mDeviceConfigExcludedPackages;
    private final Object mLock;
    final DeviceConfig.OnPropertiesChangedListener mOnPropertiesChangedListener;

    /* JADX INFO: renamed from: $r8$lambda$_hA_DqN4gaVgjs_Ss9uV-gDsca4, reason: not valid java name */
    public static /* synthetic */ void m10149$r8$lambda$_hA_DqN4gaVgjs_Ss9uVgDsca4(SplashScreenExceptionList r0, DeviceConfig.Properties r1) {
        r0.lambda$new$0(r1);
    }

    static {
        DEBUG = Build.isDebuggable();
    }

    SplashScreenExceptionList(Executor executor) {
        this.mDeviceConfigExcludedPackages = new HashSet();
        this.mLock = new Object();
        updateDeviceConfig(DeviceConfig.getString(NAMESPACE, KEY_SPLASH_SCREEN_EXCEPTION_LIST, ""));
        this.mOnPropertiesChangedListener = new SplashScreenExceptionList$$ExternalSyntheticLambda0(this);
        DeviceConfig.addOnPropertiesChangedListener(NAMESPACE, executor, this.mOnPropertiesChangedListener);
    }

    private /* synthetic */ void lambda$new$0(DeviceConfig.Properties properties) {
        updateDeviceConfig(properties.getString(KEY_SPLASH_SCREEN_EXCEPTION_LIST, ""));
    }

    void updateDeviceConfig(String values) {
        parseDeviceConfigPackageList(values);
    }

    public boolean isException(String packageName, int targetSdk, Supplier<ApplicationInfo> infoSupplier) {
        if (Utils.isXtsPkg(packageName) == false) goto L7;
        return false;
    L7:
        return !isOptedOut(infoSupplier);
    }

    private static boolean isOptedOut(Supplier<ApplicationInfo> infoProvider) {
        if (infoProvider != null) goto L5;
        return false;
    L5:
        ApplicationInfo info = infoProvider.get();
        if (info != null) goto L8;
        return false;
    L8:
        if (info.metaData != null) goto L10;
        return false;
    L10:
        if (info.metaData.getBoolean(OPT_OUT_METADATA_FLAG, false) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private void parseDeviceConfigPackageList(String rawList) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDeviceConfigExcludedPackages.clear();     // Catch: Throwable -> L10
        String[] packages = rawList.split(",");     // Catch: Throwable -> L10
        int r2 = packages.length;     // Catch: Throwable -> L10
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L13;
        String packageName = packages[r3];     // Catch: Throwable -> L10
        String packageNameTrimmed = packageName.trim();     // Catch: Throwable -> L10
        if (packageNameTrimmed.isEmpty() == true) goto L12;
        this.mDeviceConfigExcludedPackages.add(packageNameTrimmed);     // Catch: Throwable -> L10
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
