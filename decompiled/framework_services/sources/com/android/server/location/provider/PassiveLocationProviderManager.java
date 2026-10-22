package com.android.server.location.provider;

import android.content.Context;
import android.location.LocationResult;
import android.location.provider.ProviderRequest;
import android.os.Binder;
import com.android.internal.util.Preconditions;
import com.android.server.location.injector.Injector;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public class PassiveLocationProviderManager extends LocationProviderManager {
    @Override // com.android.server.location.provider.LocationProviderManager, com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ ProviderRequest mergeRegistrations(Collection r1) {
        return mergeRegistrations(r1);
    }

    public PassiveLocationProviderManager(Context context, Injector injector) {
        super(context, injector, "passive", null);
    }

    @Override // com.android.server.location.provider.LocationProviderManager
    public void setRealProvider(AbstractLocationProvider provider) {
        Preconditions.checkArgument(provider instanceof PassiveLocationProvider);
        super.setRealProvider(provider);
    }

    @Override // com.android.server.location.provider.LocationProviderManager
    public void setMockProvider(MockLocationProvider provider) {
        if (provider != null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Cannot mock the passive provider");
    }

    public void updateLocation(LocationResult locationResult) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        PassiveLocationProvider passive = (PassiveLocationProvider) this.mProvider.getProvider();     // Catch: Throwable -> L13
        if (passive == null) goto L7;
        boolean r2 = true;
    L8:
        Preconditions.checkState(r2);     // Catch: Throwable -> L13
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        passive.updateLocation(locationResult);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L7:
        r2 = false;
    L13:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.location.provider.LocationProviderManager, com.android.server.location.listeners.ListenerMultiplexer
    protected ProviderRequest mergeRegistrations(Collection<LocationProviderManager.Registration> registrations) {
        return new ProviderRequest.Builder().setIntervalMillis(0).build();
    }

    @Override // com.android.server.location.provider.LocationProviderManager
    protected long calculateRequestDelayMillis(long newIntervalMs, Collection<LocationProviderManager.Registration> registrations) {
        return 0;
    }

    @Override // com.android.server.location.provider.LocationProviderManager, com.android.server.location.listeners.ListenerMultiplexer
    protected String getServiceState() {
        if (this.mProvider.getCurrentRequest().isActive() == false) goto L5;
        return "registered";
    L5:
        return "unregistered";
    }
}
