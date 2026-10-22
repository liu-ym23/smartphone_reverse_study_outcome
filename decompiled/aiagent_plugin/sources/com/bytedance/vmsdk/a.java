package com.bytedance.vmsdk;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.pm.PluginPackageManager;
import com.bytedance.vmsdk.b.b;
import com.bytedance.vmsdk.b.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: VmSdk.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "VmSdk";

    public static String a() {
        return "2.12.1-worker";
    }

    public static boolean a(String r3) {
        if (d() == true) goto L14;
        return false;
    L14:
    L11:
        th = move-exception;
        a(TAG, "preloadPlugin error: " + th.getMessage());
        return false;
    L6:
        if (PluginPackageManager.checkPluginInstalled(r3) == true) goto L9;
        return Mira.loadPlugin(r3);
    L9:
        return true;
    }

    public static boolean b() {
        if (d() == true) goto L9;
        return false;
    L9:
        System.loadLibrary("quick");     // Catch: Throwable -> L8
        b(TAG, "loadQuickJsLibrary in host success");
        return true;
    L8:
        return false;
    }

    public static boolean b(String r9) {
        if (d() == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r9) == false) goto L8;
        r9 = c();
    L8:
        String[] r3 = {"quick", "napi", "worker"};
        int r4 = 0;
    L9:
        if (r4 >= 3) goto L19;
        String r5 = r3[r4];
        String r6 = c(r9, r5);
        if (TextUtils.isEmpty(r6) == true) goto L12;
        System.load(r6);     // Catch: Throwable -> L16
        b(TAG, "loadWorkerLibrary success: soname :" + r6 + ", PluginName: " + r9);
        r4 = r4 + 1;
    L16:
        th = move-exception;
        a(TAG, "loadWorkerLibrary failed: soname: " + r6 + ", PluginName: " + r9 + "error:" + th.getMessage());
        return false;
    L12:
        a(TAG, "loadWorkerLibrary failed: so: " + r5 + ", Plugin: " + r9);
        return false;
    L19:
        return true;
    }

    public static String c(String r4, String r5) {
        if (d() == true) goto L10;
        return "";
    L10:
        return new File(PluginDirHelper.getNativeLibraryDir(r4, PluginPackageManager.getInstalledPluginVersion(r4)), c(r5)).getPath();
    L7:
        th = move-exception;
        a(TAG, "getPluginLibAbsPath failed: soname : lib" + r5 + ".so, PluginName: " + r4 + " error:" + th.getMessage());
        return "";
    }

    private static String c(String r1) {
        if (Pattern.compile("lib\\w+\\.so").matcher(r1).matches() == false) goto L5;
        return r1;
    L5:
        return System.mapLibraryName(r1);
    }

    public static String c() {
        b r0 = (b) ZeusTransformUtils.preCheckCast(c.a().a(b.class), b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.b();
    }

    public static boolean d() {
        b r0 = (b) ZeusTransformUtils.preCheckCast(c.a().a(b.class), b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        b(TAG, "isSettingsEnable: " + r1);
        return r1;
    L5:
        if (r0.a() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
