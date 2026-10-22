package com.android.server.biometrics.sensors;

import android.content.Context;
import android.os.IBinder;
import com.android.server.biometrics.log.BiometricContext;
import com.android.server.biometrics.log.BiometricLogger;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
public abstract class StartUserClient<T, U> extends HalClientMonitor<T> {
    protected final UserStartedCallback<U> mUserStartedCallback;

    public interface UserStartedCallback<U> {
        void onUserStarted(int r1, U r2, int r3);
    }

    public StartUserClient(Context context, Supplier<T> lazyDaemon, IBinder token, int userId, int sensorId, BiometricLogger logger, BiometricContext biometricContext, UserStartedCallback<U> callback) {
        super(context, lazyDaemon, token, null, userId, context.getOpPackageName(), 0, sensorId, logger, biometricContext, false);
        this.mUserStartedCallback = callback;
    }

    @Override // com.android.server.biometrics.sensors.BaseClientMonitor
    public int getProtoEnum() {
        return 17;
    }
}
