package com.android.server.biometrics.sensors;

import android.content.Context;
import android.os.IBinder;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import com.android.server.biometrics.log.OperationContextExt;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class HalClientMonitor<T> extends BaseClientMonitor {
    protected final Supplier<T> mLazyDaemon;
    private final OperationContextExt mOperationContext;

    protected abstract void startHalOperation();

    public abstract void unableToStart();

    public HalClientMonitor(Context context, Supplier<T> lazyDaemon, IBinder token, ClientMonitorCallbackConverter listener, int userId, String owner, int cookie, int sensorId, BiometricLogger biometricLogger, BiometricContext biometricContext, boolean isMandatoryBiometrics) {
        super(context, token, listener, userId, owner, cookie, sensorId, biometricLogger, biometricContext);
        this.mLazyDaemon = lazyDaemon;
        if (listener == null) goto L5;
        int modality = listener.getModality();
    L6:
        this.mOperationContext = new OperationContextExt(isBiometricPrompt(), modality, isMandatoryBiometrics);
        return;
    L5:
        modality = 0;
        goto L6
    }

    public T getFreshDaemon() {
        return this.mLazyDaemon.get();
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public void destroy() {
        super.destroy();
        unsubscribeBiometricContext();
    }

    public boolean isBiometricPrompt() {
        if (getCookie() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected OperationContextExt getOperationContext() {
        return getBiometricContext().updateContext(this.mOperationContext, isCryptoOperation());
    }

    protected ClientMonitorCallback getBiometricContextUnsubscriber() {
        return new AnonymousClass1(this);
    }

    protected void unsubscribeBiometricContext() {
        getBiometricContext().unsubscribe(this.mOperationContext);
    }
}
