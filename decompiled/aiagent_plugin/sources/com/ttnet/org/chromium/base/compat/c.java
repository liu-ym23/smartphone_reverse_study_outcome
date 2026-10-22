package com.ttnet.org.chromium.base.compat;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApiHelperForO.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static String[] a(ApplicationInfo r0) {
        return r0.splitNames;
    }

    public static void a(ConnectivityManager r0, NetworkRequest r1, ConnectivityManager.NetworkCallback r2, Handler r3) {
        r0.registerNetworkCallback(r1, r2, r3);
    }

    public static void a(ConnectivityManager r0, ConnectivityManager.NetworkCallback r1, Handler r2) {
        r0.registerDefaultNetworkCallback(r1, r2);
    }

    public static Intent registerReceiver(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
        return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, "com.obric.aiagent.plugin");
    }
}
