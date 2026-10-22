package com.android.server.biometrics.sensors.face.aidl;

import android.content.Context;
import android.hardware.biometrics.face.ISession;
import android.hardware.biometrics.face.V1_0.IBiometricsFace;
import com.android.server.biometrics.sensors.face.hidl.HidlToAidlSessionAdapter;
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

    public AidlSession(Context context, Supplier<IBiometricsFace> session, int userId, AidlResponseHandler aidlResponseHandler) {
        this.mSession = new HidlToAidlSessionAdapter(context, session, userId, aidlResponseHandler);
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

    public boolean supportsFaceEnrollOptions() {
        if (this.mHalInterfaceVersion < 4) goto L5;
        return true;
    L5:
        return false;
    }
}
