package com.obric.common.upgrade.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: NetworkUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f32652a = null;

    static {
        f32652a = new d();
    }

    private d() {
    }

    public final boolean a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        Object r4 = r2.getSystemService("connectivity");
        if (ZeusTransformUtils.instanceOf(r4, ConnectivityManager.class) == false) goto L5;
        ConnectivityManager r5 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r4, ConnectivityManager.class, "com.obric.aiagent.plugin");
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        NetworkInfo r0 = r5.getActiveNetworkInfo();
        if (r0 != null) goto L12;
        return false;
    L12:
        if (r0.isAvailable() == false) goto L26;
        NetworkInfo r6 = r5.getNetworkInfo(1);
        if (r6 == null) goto L23;
        NetworkInfo.State r7 = r6.getState();
        if (r7 != null) goto L19;
        return false;
    L19:
        if (r7 == NetworkInfo.State.CONNECTED) goto L21;
        return false;
    L21:
        return true;
    L23:
        return false;
    L26:
        return false;
    L5:
        r5 = null;
        goto L7
    }
}
