package com.android.server.timezonedetector;

/* JADX INFO: loaded from: classes3.dex */
interface DeviceActivityMonitor extends Dumpable {

    public interface Listener {
        void onFlightComplete();
    }

    void addListener(Listener r1);
}
