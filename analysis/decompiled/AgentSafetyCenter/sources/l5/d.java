package l5;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import g5.u;
import kc.z;
import mc.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f7736a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f7737b;

    public d(z zVar, r rVar) {
        this.f7736a = zVar;
        this.f7737b = rVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        network.getClass();
        networkCapabilities.getClass();
        this.f7736a.e(null);
        u.d().a(k.f7750a, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        this.f7737b.h(a.f7734a);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        network.getClass();
        this.f7736a.e(null);
        u.d().a(k.f7750a, "NetworkRequestConstraintController onLost callback");
        this.f7737b.h(new b(7));
    }
}
