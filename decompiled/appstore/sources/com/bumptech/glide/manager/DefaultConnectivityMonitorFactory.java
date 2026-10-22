package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    public DefaultConnectivityMonitorFactory() {
    }

    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    @NonNull
    public ConnectivityMonitor build(@NonNull Context r10, @NonNull ConnectivityMonitor.ConnectivityListener r11) {
        if (ContextCompat.a(r10, NETWORK_PERMISSION) != 0) goto L5;
        boolean r12 = true;
    L7:
        if (Log.isLoggable(TAG, 3) == false) goto L12;
        if (r12 == false) goto L10;
        String r13 = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
    L11:
        Log.d(TAG, r13);
        goto L12
    L10:
        r13 = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
    L12:
        if (r12 == false) goto L15;
        return new DefaultConnectivityMonitor(r10, r11);
    L15:
        return new NullConnectivityMonitor();
    L5:
        r12 = false;
        goto L7
    }
}
