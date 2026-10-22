package o2;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f10727a;

    public i(j jVar) {
        this.f10727a = jVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
        kotlin.jvm.internal.g.f(network, "network");
        kotlin.jvm.internal.g.f(capabilities, "capabilities");
        h2.j.d().a(k.f10730a, "Network capabilities changed: " + capabilities);
        this.f10727a.b(new m2.b(capabilities.hasCapability(12), capabilities.hasCapability(16), capabilities.hasCapability(11) ^ true, capabilities.hasCapability(18)));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        kotlin.jvm.internal.g.f(network, "network");
        h2.j.d().a(k.f10730a, "Network connection lost");
        j jVar = this.f10727a;
        jVar.b(k.a(jVar.f10728f));
    }
}
