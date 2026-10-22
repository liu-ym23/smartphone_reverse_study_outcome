package com.obric.aiagent.plugin_impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DataMigrationUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "DataMigrationUtils";

    /* JADX INFO: renamed from: lambda$J-rAaxC8VhQ4-SNh0UhMxeqGqFI, reason: not valid java name */
    public static /* synthetic */ void m201lambda$JrAaxC8VhQ4SNh0UhMxeqGqFI(Runnable r0, Handler r1, Runnable r2, Context r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$cHzBmeQYrgmUmKdlqATebwZI8cU(Runnable r0) {
        a(r0);
    }

    public static void a(Context r3, Runnable r4, Runnable r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        final Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        final Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "invokeAfterMigration block: " + r8 + " context: " + r6);
        if (r6 != null) goto L9;
        ILogDepend.Companion.w(TAG, "context is null, skip migration");
        if (r8 == null) goto L16;
        r8.run();
        return;
    L16:
        return;
    L9:
        if (a(r6, "com.obric.assistantaiagent") == true) goto L14;
        ILogDepend.Companion.d(TAG, "old app not enabled, resume init directly");
        if (r8 == null) goto L17;
        r8.run();
        return;
    L17:
        return;
    L14:
        final Handler r0 = new Handler(Looper.getMainLooper());
        new Thread(new $$Lambda$a$JrAaxC8VhQ4SNh0UhMxeqGqFI(r7, r0, r8, r6), "data-migration").start();
    }

    private static /* synthetic */ void a(Runnable r7, Handler r8, Runnable r9, Context r10) {
        Runnable r11 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");
        final Runnable r12 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.aiagent.plugin");
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        Bundle r4 = Bundle.EMPTY;
        if (r11 != null) goto L28;
    L8:
        r8.post(new $$Lambda$a$cHzBmeQYrgmUmKdlqATebwZI8cU(r12));
        if (Build.VERSION.SDK_INT < 29) goto L30;
        ILogDepend.Companion.i(TAG, "clearing old app data");     // Catch: Throwable -> L16
        ZeusProviderTransform.call(r13.getContentResolver(), "com.obric.aiagent.transfer", "method_clear_app_data", null, r4, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
    L23:
        goto L30
    L13:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "clear app data unsupported: " + th.getMessage());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "clear old app data error", th);
    L30:
        ILogDepend.Companion.d(TAG, "wait 5 seconds before disabling old app");     // Catch: InterruptedException -> L20
        Thread.sleep(5000);     // Catch: InterruptedException -> L20
    L21:
        ILogDepend.Companion.i(TAG, "disable old app");
        a(r13, "com.obric.assistantaiagent", false);
        return;
    L20:
        Thread.currentThread().interrupt();
        goto L21
    L28:
        ILogDepend.Companion.i(TAG, "run preTask before clearing old app data");     // Catch: Throwable -> L6
        r11.run();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ILogDepend.Companion.w(TAG, "preTask failed", th);
        goto L8
    }

    private static /* synthetic */ void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "resume init on main thread");
        if (r4 == null) goto L6;
        r4.run();
        return;
    }

    private static void a(Context r3, String r4, boolean r5) {
        PackageManager r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getPackageManager();     // Catch: Throwable -> L13
        if (r5 == false) goto L6;
        int r2 = 1;
    L7:
        r6.setApplicationEnabledSetting(r4, r2, 1);     // Catch: Throwable -> L13
        ILogDepend.Companion r7 = ILogDepend.Companion;     // Catch: Throwable -> L13
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L13
        if (r5 == false) goto L10;
        String r8 = "enable";
    L11:
        r7.i(TAG, r1.append(r8).append(" app: ").append(r4).toString());     // Catch: Throwable -> L13
        return;
    L10:
        r8 = "disable";
        goto L11
    L6:
        r2 = 2;
    L13:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "Error enabling/disabling application: " + r4, th);
    }

    private static boolean a(Context r4, String r5) {
        int r6 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationEnabledSetting(r5);     // Catch: Throwable -> L9
        if (r6 == 1) goto L8;
        if (r6 == 0) goto L8;
        return false;
    L8:
        return true;
    L9:
        th = move-exception;
        ILogDepend.Companion.e(TAG, "Error checking application enabled state: " + r5, th);
        return false;
    }
}
