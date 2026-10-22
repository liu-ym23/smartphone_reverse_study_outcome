package com.stepos.ability.manager;

import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import com.stepos.ability.commoninternal.NetworkStateBridge;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;

/* loaded from: classes3.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbilityManager f3115a;

    public b(AbilityManager abilityManager) {
        this.f3115a = abilityManager;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        k.f(network, "network");
        AbilityManager abilityManager = this.f3115a;
        com.stepos.ability.manager.sync.a aVar = abilityManager.syncCoordinator;
        if (aVar == null) {
            k.n("syncCoordinator");
            throw null;
        }
        Log.i("AbilityManager", "Network onAvailable phase=" + aVar.e());
        AbstractC1683A.n(abilityManager.setupScope, null, new AbilityManager$startNetworkMonitor$1$onAvailable$1(abilityManager, null), 3);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        k.f(network, "network");
        Log.e("AbilityManager", "Network onLost");
        NetworkStateBridge.INSTANCE.notifyNetworkLost();
    }
}
