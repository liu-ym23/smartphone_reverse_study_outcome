package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.g;

/* JADX INFO: loaded from: classes39.dex */
public class NetworkListener extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31965a = null;

    static {
        f31965a = "NetworkListener";
    }

    public NetworkListener() {
    }

    public void a(Context r100) {
        String r101 = NetworkUtil.getCurrentNetMode(r100);
        String r102 = g.f();
        if (r102 != null) goto L5;
        g.a(r101);
        return;
    L5:
        if (r102.equals(r101) == true) goto L9;
        g.a(r101);
        return;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        a(r100);
        NetworkUtil.updateNetworkProxy(r100);
    }
}
