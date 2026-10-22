package com.bytedance.crash.o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Net.java */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f7672a = null;

    static {
        f7672a = new String[]{SensitiveType.UNKNOWN, "wifi", SensitiveType.MOBILE, "2g", "3g", "4g", "5g"};
    }

    public static String a() {
        int r0 = c();
        if (r0 < 7) goto L6;
        r0 = 0;
    L6:
        return f7672a[r0];
    }

    private static int c() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (r0 != null) goto L6;
        return 0;
    L6:
        ConnectivityManager r2 = b(r0);     // Catch: Throwable -> L32
        if (r2 != null) goto L9;
        return 0;
    L9:
        NetworkInfo r3 = r2.getActiveNetworkInfo();     // Catch: Throwable -> L32
        if (r3 == null) goto L31;
        if (r3.isAvailable() == false) goto L31;
        int r4 = r3.getType();     // Catch: Throwable -> L32
        if (1 != r4) goto L18;
        return 1;
    L18:
        if (r4 != 0) goto L30;
        switch(a(r0).getNetworkType()) {
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L21;
            case 5: goto L26;
            case 6: goto L26;
            case 7: goto L21;
            case 8: goto L26;
            case 9: goto L26;
            case 10: goto L26;
            case 11: goto L21;
            case 12: goto L26;
            case 13: goto L24;
            case 14: goto L26;
            case 15: goto L26;
            case 16: goto L21;
            case 17: goto L21;
            case 18: goto L21;
            case 19: goto L21;
            case 20: goto L22;
            default: goto L21;
        };
    L21:
        return 2;
    L22:
        return 6;
    L24:
        return 5;
    L26:
        return 4;
    L28:
        return 3;
    L30:
        return 2;
    L31:
        return 0;
    }

    private static TelephonyManager a(Context r2) {
        return (TelephonyManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin");
    }

    private static ConnectivityManager b(Context r2) {
        return (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");
    }

    public static boolean b() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L16;
        return false;
    L16:
        ConnectivityManager r1 = b(r0);     // Catch: Exception -> L13
        if (r1 == null) goto L15;
        NetworkInfo r2 = r1.getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r2 == null) goto L18;
        if (r2.isAvailable() == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    L15:
        return false;
    L13:
        e = move-exception;
        com.bytedance.crash.c.b.a(e);
        goto L15
    }
}
