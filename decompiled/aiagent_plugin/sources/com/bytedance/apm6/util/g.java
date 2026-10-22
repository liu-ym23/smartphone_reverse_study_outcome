package com.bytedance.apm6.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static boolean a(Context r3) {
        ConnectivityManager r4 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L11
        NetworkInfo r1 = null;
        if (r4 == null) goto L6;
        r1 = r4.getActiveNetworkInfo();     // Catch: Exception -> L11
    L6:
        if (r1 == null) goto L14;
        if (r1.isConnected() == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    public static int b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        ConnectivityManager r2 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        NetworkInfo r3 = null;
        if (androidx.core.content.a.b(r6, "android.permission.ACCESS_NETWORK_STATE") != 0) goto L6;
        r3 = r2.getActiveNetworkInfo();     // Catch: Throwable -> L15
    L6:
        if (r3 == null) goto L14;
        if (r3.isAvailable() == false) goto L14;
        if (r3.getType() != 0) goto L14;
        return ((TelephonyManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getNetworkType();
    L14:
        return -10000;
    }
}
