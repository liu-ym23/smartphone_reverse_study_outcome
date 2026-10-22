package com.android.server.power;

/* JADX INFO: loaded from: classes3.dex */
public interface IMonitorCallback {
    void onAudioStateChanged(String r1, int r2, boolean r3);

    void onBleConnectChanged(String r1, boolean r2);

    void onTeardownDone(long r1, long r3);
}
