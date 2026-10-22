package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.pico.utils.IExtBase;
import com.android.server.biometrics.sensors.BaseClientMonitor;
import com.android.server.biometrics.sensors.ClientMonitorCallbackConverter;

/* JADX INFO: loaded from: classes.dex */
public interface IExtAidlResponseHandler extends IExtBase {
    default void registerPostAuthAcquiredFallback(ClientMonitorCallbackConverter listener, long requestId) {
    }

    default void handleAcquiredResponse(int sensorId, int acquiredInfo, int vendorCode, BaseClientMonitor client) {
    }

    default void onSessionClosed() {
    }
}
