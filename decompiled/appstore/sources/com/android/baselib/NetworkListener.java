package com.android.baselib;

/* JADX INFO: loaded from: classes.dex */
public interface NetworkListener {
    void onAvailable();

    void onMobileConnected();

    void onNetworkType();

    void onUnConnected();

    void onWifiConnected();
}
