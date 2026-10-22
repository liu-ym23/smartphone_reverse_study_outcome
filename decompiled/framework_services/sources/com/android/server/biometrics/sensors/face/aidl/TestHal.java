package com.android.server.biometrics.sensors.face.aidl;

import android.hardware.biometrics.face.IFace;
import android.hardware.biometrics.face.ISession;
import android.hardware.biometrics.face.ISessionCallback;
import android.hardware.biometrics.face.SensorProps;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class TestHal extends IFace.Stub {
    private static final String TAG = "face.aidl.TestHal";

    public TestHal() {
    }

    public int getInterfaceVersion() {
        return 4;
    }

    public String getInterfaceHash() {
        return "c43fbb9be4a662cc9ace640dba21cccdb84c6c21";
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
