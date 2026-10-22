package com.android.server.biometrics.sensors;

import android.content.Context;
import android.hardware.biometrics.BiometricAuthenticator;
import android.hardware.biometrics.BiometricAuthenticator.Identifier;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.IInvalidationCallback;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;

/* JADX INFO: loaded from: classes.dex */
public class InvalidationRequesterClient<S extends BiometricAuthenticator.Identifier> extends BaseClientMonitor {
    private final BiometricManager mBiometricManager;
    private final IInvalidationCallback mInvalidationCallback;
    private final BiometricUtils<S> mUtils;

    /* JADX INFO: renamed from: -$$Nest$fgetmUtils, reason: not valid java name */
    static /* bridge */ /* synthetic */ BiometricUtils m2627$$Nest$fgetmUtils(InvalidationRequesterClient r0) {
        return r0.mUtils;
    }

    public InvalidationRequesterClient(Context context, int userId, int sensorId, BiometricLogger logger, BiometricContext biometricContext, BiometricUtils<S> utils) {
        super(context, null, null, userId, context.getOpPackageName(), 0, sensorId, logger, biometricContext);
        this.mInvalidationCallback = new AnonymousClass1(this);
        this.mBiometricManager = (BiometricManager) context.getSystemService(BiometricManager.class);
        this.mUtils = utils;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void start(ClientMonitorCallback callback) {
        super.start(callback);
        this.mUtils.setInvalidationInProgress(getContext(), getTargetUserId(), true);
        this.mBiometricManager.invalidateAuthenticatorIds(getTargetUserId(), getSensorId(), this.mInvalidationCallback);
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 14;
    }
}
