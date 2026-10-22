package com.bytedance.crash.upload;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: NetWorkManager.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f7810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CopyOnWriteArrayList<e> f7811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConnectivityManager.NetworkCallback f7812c;

    static /* synthetic */ CopyOnWriteArrayList a() {
        return f7811b;
    }

    static /* synthetic */ ConnectivityManager b() {
        return f7810a;
    }

    static {
        f7812c = new NetWorkManager$1();
    }

    public static void a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (f7811b != null) goto L7;
        f7811b = new CopyOnWriteArrayList();     // Catch: Throwable -> L14
    L7:
        if (f7811b.isEmpty() == true) goto L9;
    L12:
        f7811b.add(r4);     // Catch: Throwable -> L14
        return;
    L9:
        if (f7810a != null) goto L11;
        f7810a = (ConnectivityManager) ZeusTransformUtils.preCheckCast((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin"), ConnectivityManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L11:
        NetworkRequest r0 = new NetworkRequest.Builder().addCapability(12).build();     // Catch: Throwable -> L14
        f7810a.registerNetworkCallback(r0, f7812c);     // Catch: Throwable -> L14
    }
}
