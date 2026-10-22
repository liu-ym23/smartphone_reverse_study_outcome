package com.bytedance.server.security.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import vendor.qti.hardware.soter.ISoter;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    private static final String SOTER_CA_NAME = "vendor.qti.hardware.soter.ISoter/default";
    private static final String TAG = "SecurityUtils";

    /* JADX INFO: renamed from: $r8$lambda$YXT782-GqOBOtcFVTWmg5hd5quk, reason: not valid java name */
    public static /* synthetic */ IBinder m10562$r8$lambda$YXT782GqOBOtcFVTWmg5hd5quk() {
        return lambda$getISoter$0();
    }

    public Utils() {
    }

    public static int getUidFromPkgName(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();     // Catch: Exception -> L4
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);     // Catch: Exception -> L4
        return applicationInfo.uid;
    L4:
        e = move-exception;
        Log.e("getUidFromPkgName", "Get uid failed, error:" + e.getMessage());
        return -1;
    }

    public static int getUserIdFromUid(int uid) {
        return UserHandle.getUserId(uid);
    }

    public static int getUidByPackageName(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();     // Catch: PackageManager.NameNotFoundException -> L4
        ApplicationInfo appInfo = pm.getApplicationInfo(packageName, 0);     // Catch: PackageManager.NameNotFoundException -> L4
        return appInfo.uid;
    L4:
        e = move-exception;
        Log.i("getUidByPackageName ", e.getMessage());
        return -1;
    }

    public static ISoter getISoter(long timeoutMs) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<IBinder> future = executor.submit(new Utils$$ExternalSyntheticLambda0());
        IBinder binder = future.get(timeoutMs, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8 Exception -> L10 TimeoutException -> L12
        if (binder == null) goto L15;
        ISoter r0 = ISoter.Stub.asInterface(binder);     // Catch: Throwable -> L8 Exception -> L10 TimeoutException -> L12
        executor.shutdownNow();
        return r0;
    L15:
        executor.shutdownNow();
        return null;
    L8:
        th = move-exception;
        executor.shutdownNow();
        throw th;
    L10:
        e = move-exception;
        Log.e(TAG, "Waiting for vendor.qti.hardware.soter.ISoter/default failed, exception: " + e.getMessage());     // Catch: Throwable -> L8
    L18:
        Log.e(TAG, "Timeout waiting for vendor.qti.hardware.soter.ISoter/default");     // Catch: Throwable -> L8
        goto L15
    }

    private static /* synthetic */ IBinder lambda$getISoter$0() throws Exception {
        return ServiceManager.waitForDeclaredService(SOTER_CA_NAME);
    }
}
