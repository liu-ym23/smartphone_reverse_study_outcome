package com.android.server.ondeviceintelligence;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.service.ondeviceintelligence.IOnDeviceIntelligenceService;
import com.android.internal.infra.ServiceConnector;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class RemoteOnDeviceIntelligenceService extends ServiceConnector.Impl<IOnDeviceIntelligenceService> {
    private static final long LONG_TIMEOUT = 0;
    private static final String TAG = null;

    static {
        LONG_TIMEOUT = TimeUnit.HOURS.toMillis(4);
        TAG = RemoteOnDeviceIntelligenceService.class.getSimpleName();
    }

    RemoteOnDeviceIntelligenceService(Context context, ComponentName serviceName, int userId) {
        super(context, new Intent("android.service.ondeviceintelligence.OnDeviceIntelligenceService").setComponent(serviceName), 67112960, userId, new RemoteOnDeviceIntelligenceService$$ExternalSyntheticLambda0());
        connect();
    }

    protected long getRequestTimeoutMs() {
        return LONG_TIMEOUT;
    }

    protected long getAutoDisconnectTimeoutMs() {
        return Settings.Secure.getLongForUser(((ServiceConnector.Impl) this).mContext.getContentResolver(), "on_device_intelligence_unbind_timeout_ms", TimeUnit.SECONDS.toMillis(30), ((ServiceConnector.Impl) this).mContext.getUserId());
    }
}
