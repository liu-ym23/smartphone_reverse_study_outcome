package com.bytedance.crypto.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommonUtils {
    public static final String TAG = "CommonUtils";
    private static final HashMap<String, String> assistantAppMap = null;

    static {
        assistantAppMap = new AnonymousClass1();
    }

    public CommonUtils() {
    }

    public static boolean containsAssistantApp(String r1) {
        return assistantAppMap.containsKey(r1);
    }

    public static String getAssistantAppPkgName(String r2) {
        return (String) ZeusTransformUtils.preCheckCast(assistantAppMap.get(r2), String.class, "com.obric.aiagent.plugin");
    }

    public static List<byte[]> getContextSignature(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L31;
        LogUtils.e(TAG, "Context is null");
        return null;
    L31:
        PackageManager r1 = r6.getPackageManager();     // Catch: Exception -> L28
        if (r1 != null) goto L10;
        LogUtils.e(TAG, "getPackageManager failed");     // Catch: Exception -> L28
        return null;
    L10:
        PackageInfo r7 = r1.getPackageInfo(r6.getPackageName(), 134217728);     // Catch: Exception -> L28
        if (r7 == null) goto L26;
        SigningInfo r8 = r7.signingInfo;     // Catch: Exception -> L28
        if (r8 == null) goto L26;
        Signature[] r9 = r8.getApkContentsSigners();     // Catch: Exception -> L28
        if (r9 != null) goto L18;
    L24:
        LogUtils.e(TAG, "getApkContentsSigners failed");     // Catch: Exception -> L28
        return null;
    L18:
        if (r9.length == 0) goto L24;
        ArrayList r2 = new ArrayList();     // Catch: Exception -> L28
        int r3 = r9.length;     // Catch: Exception -> L28
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L23;
        r2.add(r9[r4].toByteArray());     // Catch: Exception -> L28
        r4 = r4 + 1;     // Catch: Exception -> L28
        goto L21
    L23:
        return r2;
    L26:
        LogUtils.e(TAG, "getPackageInfo failed");     // Catch: Exception -> L28
        return null;
    L28:
        e = move-exception;
        LogUtils.d(TAG, "getContextSignature failed, exception: " + e.getMessage());
        return null;
    }

    public static String getSystemProperty(String r9) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, new Object[]{r9, SensitiveType.UNKNOWN}), String.class, "com.obric.aiagent.plugin");
    L5:
        e = move-exception;
        LogUtils.e(TAG, "Get system property failed!! error:" + e.getMessage());
        return SensitiveType.UNKNOWN;
    }
}
