package com.android.server.location.provider.proxy;

import android.R;
import android.content.Context;
import android.location.provider.IS2CellIdsCallback;
import android.location.provider.IS2LevelCallback;
import com.android.server.servicewatcher.CurrentUserServiceSupplier;
import com.android.server.servicewatcher.ServiceWatcher;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyPopulationDensityProvider {
    public static final String TAG = "ProxyPopulationDensityProvider";
    final ServiceWatcher mServiceWatcher;

    public static ProxyPopulationDensityProvider createAndRegister(Context context) {
        ProxyPopulationDensityProvider proxy = new ProxyPopulationDensityProvider(context);
        if (proxy.register() == false) goto L5;
        return proxy;
    L5:
        return null;
    }

    private ProxyPopulationDensityProvider(Context context) {
        this.mServiceWatcher = ServiceWatcher.create(context, "PopulationDensityProxy", CurrentUserServiceSupplier.createFromConfig(context, "com.android.location.service.PopulationDensityProvider", R.bool.config_enableSearchTileHideIllustrationInPrivateSpace, R.string.config_useragentprofile_url), null);
    }

    private boolean register() {
        boolean resolves = this.mServiceWatcher.checkServiceResolves();
        if (resolves == false) goto L5;
        this.mServiceWatcher.register();
    L5:
        return resolves;
    }

    public void getDefaultCoarseningLevel(final IS2LevelCallback callback) {
        this.mServiceWatcher.runOnBinder(new AnonymousClass1(this, callback));
    }

    public void getCoarsenedS2Cells(final double latitudeDegrees, final double longitudeDegrees, final int numAdditionalCells, final IS2CellIdsCallback callback) {
        this.mServiceWatcher.runOnBinder(new AnonymousClass2(this, latitudeDegrees, longitudeDegrees, numAdditionalCells, callback));
    }
}
