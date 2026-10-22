package com.android.server.biometrics.sensors.fingerprint;

import android.pico.utils.IExtBase;
import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public interface IExtFingerprintServiceRegistry extends IExtBase {
    default Pair<Integer, ServiceProvider> getSingleProvider(int sensorId) {
        return null;
    }
}
