package com.obric.oui.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: NetworkUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f35013a = null;

    static {
        f35013a = new d();
    }

    private d() {
    }

    public static final boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        Object r5 = r4.getSystemService("connectivity");
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r6 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r5, ConnectivityManager.class, "com.obric.aiagent.plugin");
        Network r0 = r6.getActiveNetwork();
        if (r0 != null) goto L5;
        return false;
    L5:
        NetworkCapabilities r7 = r6.getNetworkCapabilities(r0);
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.hasTransport(1) == false) goto L12;
    L17:
        return true;
    L12:
        if (r7.hasTransport(0) == true) goto L17;
        if (r7.hasTransport(3) == true) goto L17;
        return false;
    }
}
