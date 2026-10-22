package com.android.server.location.provider.proxy;

import android.R;
import android.content.Context;
import android.location.provider.ForwardGeocodeRequest;
import android.location.provider.IGeocodeCallback;
import android.location.provider.ReverseGeocodeRequest;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyGeocodeProvider {
    private final ServiceWatcher mServiceWatcher;

    public static ProxyGeocodeProvider createAndRegister(Context context) {
        ProxyGeocodeProvider proxy = new ProxyGeocodeProvider(context);
        if (proxy.register() == false) goto L5;
        return proxy;
    L5:
        return null;
    }

    private ProxyGeocodeProvider(Context context) {
        this.mServiceWatcher = ServiceWatcher.create(context, "GeocoderProxy", CurrentUserServiceSupplier.createFromConfig(context, "com.android.location.service.GeocodeProvider", R.bool.config_enableGnssTimeUpdateService, R.string.config_pointing_ui_package), null);
    }

    private boolean register() {
        boolean resolves = this.mServiceWatcher.checkServiceResolves();
        if (resolves == false) goto L5;
        this.mServiceWatcher.register();
    L5:
        return resolves;
    }

    public void reverseGeocode(final ReverseGeocodeRequest request, final IGeocodeCallback callback) {
        this.mServiceWatcher.runOnBinder(new AnonymousClass1(this, request, callback));
    }

    public void forwardGeocode(final ForwardGeocodeRequest request, final IGeocodeCallback callback) {
        this.mServiceWatcher.runOnBinder(new AnonymousClass2(this, request, callback));
    }
}
