package com.android.server.biometrics.sensors;

import android.hardware.biometrics.SensorPropertiesInternal;
import android.util.proto.ProtoOutputStream;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface BiometricServiceProvider<T extends SensorPropertiesInternal> {
    boolean containsSensor(int r1);

    void dumpInternal(int r1, PrintWriter r2);

    void dumpProtoMetrics(int r1, FileDescriptor r2);

    void dumpProtoState(int r1, ProtoOutputStream r2, boolean r3);

    long getAuthenticatorId(int r1, int r2);

    int getLockoutModeForUser(int r1, int r2);

    T getSensorProperties(int r1);

    List<T> getSensorProperties();

    boolean hasEnrollments(int r1, int r2);

    boolean isHardwareDetected(int r1);
}
