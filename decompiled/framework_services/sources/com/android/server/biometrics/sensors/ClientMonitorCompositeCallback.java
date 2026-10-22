package com.android.server.biometrics.sensors;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ClientMonitorCompositeCallback implements ClientMonitorCallback {
    private final List<ClientMonitorCallback> mCallbacks;

    public ClientMonitorCompositeCallback(ClientMonitorCallback... callbacks) {
        this.mCallbacks = new ArrayList();
        int r0 = callbacks.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        ClientMonitorCallback callback = callbacks[r1];
        if (callback == null) goto L7;
        this.mCallbacks.add(callback);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
    public final void onClientStarted(BaseClientMonitor clientMonitor) {
        int i = 0;
    L4:
        if (i >= this.mCallbacks.size()) goto L7;
        this.mCallbacks.get(i).onClientStarted(clientMonitor);
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
    public final void onBiometricAction(int action) {
        int i = 0;
    L4:
        if (i >= this.mCallbacks.size()) goto L7;
        this.mCallbacks.get(i).onBiometricAction(action);
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.biometrics.sensors.ClientMonitorCallback
    public final void onClientFinished(BaseClientMonitor clientMonitor, boolean success) {
        int i = this.mCallbacks.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mCallbacks.get(i).onClientFinished(clientMonitor, success);
        i = i - 1;
        goto L3
    }
}
