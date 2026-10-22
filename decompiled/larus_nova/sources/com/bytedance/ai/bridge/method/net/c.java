package com.bytedance.ai.bridge.method.net;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends ConnectivityManager.NetworkCallback {
    public c() {
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        d.a();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        d.a();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r100) {
        Intrinsics.checkNotNullParameter(r100, "network");
        d.a();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
        Intrinsics.checkNotNullParameter(r100, "network");
        Intrinsics.checkNotNullParameter(r101, "networkCapabilities");
        d.a();
    }
}
