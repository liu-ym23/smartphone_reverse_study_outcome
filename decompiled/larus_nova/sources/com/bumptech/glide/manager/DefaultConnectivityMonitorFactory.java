package com.bumptech.glide.manager;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.util.GlideLogUtil;

/* JADX INFO: loaded from: classes39.dex */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    public DefaultConnectivityMonitorFactory() {
    }

    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    public ConnectivityMonitor build(Context r100, ConnectivityMonitor.ConnectivityListener r101) {
        if (ContextCompat.checkSelfPermission(r100, NETWORK_PERMISSION) != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        String r103 = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
    L9:
        GlideLogUtil.d(TAG, r103);
        if (r102 == false) goto L13;
        return new DefaultConnectivityMonitor(r100, r101);
    L13:
        return new NullConnectivityMonitor();
    L8:
        r103 = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
        goto L9
    L5:
        r102 = false;
        goto L6
    }
}
