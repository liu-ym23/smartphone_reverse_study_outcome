package com.obric.appstore.util;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class NetworkManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkManager f11062a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f11063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f11064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f11065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final NetworkManager$broadcastReceiver$1 f11066e = null;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.appstore.util.NetworkManager$broadcastReceiver$1] */
    static {
        f11062a = new NetworkManager();
        f11066e = new NetworkManager$broadcastReceiver$1();
    }

    public NetworkManager() {
    }

    public static final void b(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        if (f11065d == false) goto L5;
        return;
    L5:
        f11063b = com.bytedanceos.common.toolbox.e.A0(r10);
        f11065d = true;
        f11064c = r10;
        r10.registerReceiver(f11066e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static final void c() {
        if (f11065d == true) goto L5;
        return;
    L5:
        f11065d = false;
        Context r10 = f11064c;
        if (r10 == null) goto L8;
        r10.unregisterReceiver(f11066e);
    L8:
        f11064c = null;
    }

    public final void a(boolean r10) {
        f11063b = r10;
    }
}
