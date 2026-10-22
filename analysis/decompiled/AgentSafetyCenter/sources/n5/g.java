package n5;

import android.net.ConnectivityManager;
import g5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends e {

    /* renamed from: f, reason: collision with root package name */
    public ConnectivityManager f8771f;

    /* renamed from: g, reason: collision with root package name */
    public d6.f f8772g;

    @Override // n5.e
    public final Object a() {
        return h.a(this.f8771f);
    }

    @Override // n5.e
    public final void c() {
        try {
            u.d().a(h.f8773a, "Registering network callback");
            ConnectivityManager connectivityManager = this.f8771f;
            d6.f fVar = this.f8772g;
            connectivityManager.getClass();
            fVar.getClass();
            connectivityManager.registerDefaultNetworkCallback(fVar);
        } catch (IllegalArgumentException e10) {
            u.d().c(h.f8773a, "Received exception while registering network callback", e10);
        } catch (SecurityException e11) {
            u.d().c(h.f8773a, "Received exception while registering network callback", e11);
        }
    }

    @Override // n5.e
    public final void d() {
        try {
            u.d().a(h.f8773a, "Unregistering network callback");
            ConnectivityManager connectivityManager = this.f8771f;
            d6.f fVar = this.f8772g;
            connectivityManager.getClass();
            fVar.getClass();
            connectivityManager.unregisterNetworkCallback(fVar);
        } catch (IllegalArgumentException e10) {
            u.d().c(h.f8773a, "Received exception while unregistering network callback", e10);
        } catch (SecurityException e11) {
            u.d().c(h.f8773a, "Received exception while unregistering network callback", e11);
        }
    }
}
