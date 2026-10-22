package d6;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import g5.u;
import n5.g;
import n5.h;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3288a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3289b;

    public /* synthetic */ f(Object obj, int i) {
        this.f3288a = i;
        this.f3289b = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        switch (this.f3288a) {
            case 0:
                m.b((m) this.f3289b, network, true);
                break;
            default:
                super.onAvailable(network);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        switch (this.f3288a) {
            case 1:
                network.getClass();
                networkCapabilities.getClass();
                u.d().a(h.f8773a, "Network capabilities changed: " + networkCapabilities);
                ((g) this.f3289b).b(new l5.f(networkCapabilities.hasCapability(12), networkCapabilities.hasCapability(16), networkCapabilities.hasCapability(11) ^ true, networkCapabilities.hasCapability(18)));
                break;
            default:
                super.onCapabilitiesChanged(network, networkCapabilities);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.f3288a) {
            case 0:
                m.b((m) this.f3289b, network, false);
                break;
            default:
                network.getClass();
                u.d().a(h.f8773a, "Network connection lost");
                g gVar = (g) this.f3289b;
                gVar.b(h.a(gVar.f8771f));
                break;
        }
    }
}
