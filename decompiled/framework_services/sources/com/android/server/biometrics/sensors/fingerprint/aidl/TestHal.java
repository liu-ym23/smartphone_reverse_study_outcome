package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.hardware.biometrics.fingerprint.IFingerprint;
import android.hardware.biometrics.fingerprint.ISession;
import android.hardware.biometrics.fingerprint.ISessionCallback;
import android.hardware.biometrics.fingerprint.SensorProps;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class TestHal extends IFingerprint.Stub {
    private static final String TAG = "fingerprint.aidl.TestHal";

    public TestHal() {
    }

    public int getInterfaceVersion() {
        return 4;
    }

    public String getInterfaceHash() {
        return "41a730a7a6b5aa9cebebce70ee5b5e509b0af6fb";
    }

    public SensorProps[] getSensorProps() {
        Slog.w(TAG, "getSensorProps");
        return new SensorProps[0];
    }

    public ISession createSession(int sensorId, int userId, final ISessionCallback cb) {
        Slog.w(TAG, "createSession, sensorId: " + sensorId + " userId: " + userId);
        return new AnonymousClass1(this, cb);
    }
}
