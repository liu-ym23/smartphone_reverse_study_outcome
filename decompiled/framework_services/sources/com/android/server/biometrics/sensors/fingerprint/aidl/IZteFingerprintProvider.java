package com.android.server.biometrics.sensors.fingerprint.aidl;

/* JADX INFO: loaded from: classes.dex */
public interface IZteFingerprintProvider {

    public interface IZteFingerprintProviderExport {
        IZteFingerprintProvider getZteInjectInstance();

        default void binderDiedForZteCmd() {
            if (getZteInjectInstance() == null) goto L6;
            getZteInjectInstance().binderDiedForZteCmd();
            return;
        }

        default int setFpTestCmd(int cmd, int param) {
            if (getZteInjectInstance() != null) goto L5;
            return -1;
        L5:
            return getZteInjectInstance().setFpTestCmd(cmd, param);
        }
    }

    void binderDiedForZteCmd();

    int setFpTestCmd(int r1, int r2);
}
