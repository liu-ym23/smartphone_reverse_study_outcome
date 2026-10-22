package com.android.server.ondeviceintelligence;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.service.ondeviceintelligence.IOnDeviceSandboxedInferenceService;
import com.android.internal.infra.ServiceConnector;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteOnDeviceSandboxedInferenceService extends ServiceConnector.Impl<IOnDeviceSandboxedInferenceService> {
    private static final long LONG_TIMEOUT = 0;

    static {
        LONG_TIMEOUT = TimeUnit.HOURS.toMillis(1);
    }

    RemoteOnDeviceSandboxedInferenceService(Context context, ComponentName serviceName, int userId) {
        super(context, new Intent("android.service.ondeviceintelligence.OnDeviceSandboxedInferenceService").setComponent(serviceName), 67112960, userId, new RemoteOnDeviceSandboxedInferenceService$$ExternalSyntheticLambda0());
        connect();
    }

    protected long getRequestTimeoutMs() {
        return LONG_TIMEOUT;
    }

    protected long getAutoDisconnectTimeoutMs() {
        return Settings.Secure.getLongForUser(((ServiceConnector.Impl) this).mContext.getContentResolver(), "on_device_inference_unbind_timeout_ms", TimeUnit.SECONDS.toMillis(30), ((ServiceConnector.Impl) this).mContext.getUserId());
    }
}
