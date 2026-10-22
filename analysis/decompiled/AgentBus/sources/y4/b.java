package y4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import ia.d0;
import o4.u2;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11552f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f11553g;

    public /* synthetic */ b(h hVar, int i2) {
        this.f11552f = i2;
        this.f11553g = hVar;
    }

    @Override // p7.a
    public final Object c() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        switch (this.f11552f) {
            case 0:
                return new u2(this.f11553g.f11567a);
            case 1:
                k5.s.warn$default(this.f11553g.f11569c, "openclaw-edge", "persistent connect failure", null, 4, null);
                return c7.r.f1986a;
            case 2:
                return n7.o.v(this.f11553g.f11575i);
            case 3:
                h hVar = this.f11553g;
                k5.s.warn$default(hVar.f11569c, "openclaw-cloud", "persistent connect failure — invalidating + pre-fetching fresh token", null, 4, null);
                v5.c cVar = (v5.c) hVar.f11571e;
                cVar.getClass();
                l5.a.invalidate(cVar);
                d0.s(hVar.f11568b, null, null, new g3.c(hVar, null, 7), 3);
                return c7.r.f1986a;
            default:
                Context context = this.f11553g.f11567a;
                q7.k.e(context, "context");
                Object systemService = context.getApplicationContext().getSystemService("connectivity");
                ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
                return Boolean.valueOf((connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12) || !networkCapabilities.hasCapability(16)) ? false : true);
        }
    }
}
