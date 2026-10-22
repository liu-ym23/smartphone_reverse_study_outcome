package com.android.server.location.provider.proxy;

import android.R;
import android.content.Context;
import android.location.provider.IGnssAssistanceCallback;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyGnssAssistanceProvider {
    private static final String TAG = "GnssAssistanceProxy";
    private final ServiceWatcher mServiceWatcher;

    public static ProxyGnssAssistanceProvider createAndRegister(Context context) {
        ProxyGnssAssistanceProvider proxy = new ProxyGnssAssistanceProvider(context);
        if (proxy.register() == false) goto L5;
        return proxy;
    L5:
        return null;
    }

    private ProxyGnssAssistanceProvider(Context context) {
        this.mServiceWatcher = ServiceWatcher.create(context, TAG, CurrentUserServiceSupplier.createFromConfig(context, "android.location.provider.action.GNSS_ASSISTANCE_PROVIDER", R.bool.config_enableLockBeforeUnlockScreen, R.string.config_powerStatsThrottlePeriods), null);
    }

    private boolean register() {
        boolean resolves = this.mServiceWatcher.checkServiceResolves();
        if (resolves == false) goto L5;
        this.mServiceWatcher.register();
    L5:
        return resolves;
    }

    public void request(final IGnssAssistanceCallback callback) {
        this.mServiceWatcher.runOnBinder(new AnonymousClass1(this, callback));
    }
}
