package com.ttnet.org.chromium.base.compat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.security.NetworkSecurityPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApiHelperForM.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static long a(Network r2) {
        if (r2 != null) goto L6;
        return 0;
    L6:
        return r2.getNetworkHandle();
    }

    public static Network a(ConnectivityManager r0) {
        return r0.getActiveNetwork();
    }

    public static boolean a() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static void a(ConnectivityManager r0, Network r1, boolean r2) {
        r0.reportNetworkConnectivity(r1, r2);
    }

    public static <T> T a(Context r2, Class<T> r3) {
        return (T) ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService(r3);
    }
}
