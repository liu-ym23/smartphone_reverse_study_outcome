package com.bytedance.apm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetTypeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public static com.bytedance.common.utility.i.b a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        NetworkInfo r0 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin")).getActiveNetworkInfo();     // Catch: Throwable -> L24
        if (r0 == null) goto L23;
        if (r0.isAvailable() == false) goto L23;
        int r1 = r0.getType();     // Catch: Throwable -> L24
        if (1 == r1) goto L11;
        if (r1 != 0) goto L21;
        switch(((TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService("phone"), TelephonyManager.class, "com.obric.aiagent.plugin")).getNetworkType()) {
            case 3: goto L19;
            case 4: goto L27;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L27;
            case 8: goto L19;
            case 9: goto L19;
            case 10: goto L19;
            case 11: goto L27;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L19;
            case 15: goto L19;
            default: goto L27;
        };     // Catch: Throwable -> L24
    L27:
        return com.bytedance.common.utility.i.b.f6737c;
    L17:
        return com.bytedance.common.utility.i.b.g;
    L19:
        return com.bytedance.common.utility.i.b.f6739e;
    L21:
        return com.bytedance.common.utility.i.b.f6737c;
    L11:
        return com.bytedance.common.utility.i.b.f;
    L23:
        return com.bytedance.common.utility.i.b.f6736b;
    L25:
        return com.bytedance.common.utility.i.b.f6737c;
    }
}
