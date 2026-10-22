package z0;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.jvm.internal.Intrinsics;
import s0.t;

/* renamed from: z0.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1000h extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C1001i f16403a;

    public C1000h(C1001i c1001i) {
        this.f16403a = c1001i;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        t.d().a(AbstractC1002j.f16406a, "Network capabilities changed: " + capabilities);
        C1001i c1001i = this.f16403a;
        c1001i.b(AbstractC1002j.a(c1001i.f16404f));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        t.d().a(AbstractC1002j.f16406a, "Network connection lost");
        C1001i c1001i = this.f16403a;
        c1001i.b(AbstractC1002j.a(c1001i.f16404f));
    }
}
