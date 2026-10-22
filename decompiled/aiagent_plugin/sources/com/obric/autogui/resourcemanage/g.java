package com.obric.autogui.resourcemanage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkGuard.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f30624a = null;

    static {
        f30624a = new g();
    }

    private g() {
    }

    public final boolean a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        Object r3 = r1.getSystemService("connectivity");
        if (ZeusTransformUtils.instanceOf(r3, ConnectivityManager.class) == false) goto L5;
        ConnectivityManager r4 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r3, ConnectivityManager.class, "com.obric.aiagent.plugin");
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        Network r0 = r4.getActiveNetwork();
        if (r0 != null) goto L12;
        return false;
    L12:
        NetworkCapabilities r5 = r4.getNetworkCapabilities(r0);
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.hasCapability(12) == true) goto L18;
        return false;
    L18:
        if (r5.hasCapability(16) == false) goto L22;
        return true;
    L22:
        return false;
    L5:
        r4 = null;
        goto L7
    }

    public final boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        Object r5 = r4.getSystemService("connectivity");
        if (ZeusTransformUtils.instanceOf(r5, ConnectivityManager.class) == false) goto L5;
        ConnectivityManager r6 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r5, ConnectivityManager.class, "com.obric.aiagent.plugin");
    L7:
        if (r6 != null) goto L9;
        return false;
    L9:
        Network r1 = r6.getActiveNetwork();
        if (r1 != null) goto L12;
        return false;
    L12:
        NetworkCapabilities r7 = r6.getNetworkCapabilities(r1);
        if (r7 != null) goto L16;
        return false;
    L16:
        return a(r7);
    L5:
        r6 = null;
        goto L7
    }

    public final boolean a(NetworkCapabilities r5) {
        d.h.b.o.e(r5, "capabilities");
        return ad.a(new f(r5.hasTransport(1), r5.hasCapability(12), r5.hasCapability(16), r5.hasCapability(11)));
    }
}
