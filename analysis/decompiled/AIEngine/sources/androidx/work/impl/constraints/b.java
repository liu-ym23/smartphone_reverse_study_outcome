package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.work.impl.constraints.a;
import h2.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2930a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f2931b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final LinkedHashMap f2932c = new LinkedHashMap();

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        List<Map.Entry> listO0;
        g.f(network, "network");
        g.f(networkCapabilities, "networkCapabilities");
        j.d().a(WorkConstraintsTrackerKt.f2921a, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (f2931b) {
            listO0 = kotlin.collections.a.O0(f2932c.entrySet());
        }
        for (Map.Entry entry : listO0) {
            ((l) entry.getValue()).invoke(((NetworkRequest) entry.getKey()).canBeSatisfiedBy(networkCapabilities) ? a.C0024a.f2928a : new a.b(7));
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        List listO0;
        g.f(network, "network");
        j.d().a(WorkConstraintsTrackerKt.f2921a, "NetworkRequestConstraintController onLost callback");
        synchronized (f2931b) {
            listO0 = kotlin.collections.a.O0(f2932c.values());
        }
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            ((l) it.next()).invoke(new a.b(7));
        }
    }
}
