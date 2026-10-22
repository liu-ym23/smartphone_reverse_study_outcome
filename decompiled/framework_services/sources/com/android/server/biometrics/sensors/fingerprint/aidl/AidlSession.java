package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.hardware.biometrics.fingerprint.ISession;
import android.hardware.biometrics.fingerprint.V2_1.IBiometricsFingerprint;
import com.android.server.biometrics.sensors.fingerprint.hidl.HidlToAidlSessionAdapter;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public class AidlSession {
    private final AidlResponseHandler mAidlResponseHandler;
    private final int mHalInterfaceVersion;
    private final ISession mSession;
    private final int mUserId;

    public AidlSession(int halInterfaceVersion, ISession session, int userId, AidlResponseHandler aidlResponseHandler) {
        this.mHalInterfaceVersion = halInterfaceVersion;
        this.mSession = session;
        this.mUserId = userId;
        this.mAidlResponseHandler = aidlResponseHandler;
    }

    public AidlSession(Supplier<IBiometricsFingerprint> session, int userId, AidlResponseHandler aidlResponseHandler) {
        this.mSession = new HidlToAidlSessionAdapter(session, userId, aidlResponseHandler);
        this.mHalInterfaceVersion = 0;
        this.mUserId = userId;
        this.mAidlResponseHandler = aidlResponseHandler;
    }

    public ISession getSession() {
        return this.mSession;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public AidlResponseHandler getHalSessionCallback() {
        return this.mAidlResponseHandler;
    }

    public boolean hasContextMethods() {
        if (this.mHalInterfaceVersion < 2) goto L5;
        return true;
    L5:
        return false;
    }
}
