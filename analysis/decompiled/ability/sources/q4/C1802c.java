package q4;

import android.net.ConnectivityManager;
import android.net.Network;
import com.stepos.ability.permission.init.SlaPermissionInit;
import kotlin.jvm.internal.k;

/* renamed from: q4.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1802c extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlaPermissionInit f5579a;

    public C1802c(SlaPermissionInit slaPermissionInit) {
        this.f5579a = slaPermissionInit;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        k.f(network, "network");
        SlaPermissionInit slaPermissionInit = this.f5579a;
        if (slaPermissionInit.wasConnected) {
            return;
        }
        slaPermissionInit.wasConnected = true;
        P3.c.b("SlaPermInit", "network available -> force refresh SLA permission cache");
        slaPermissionInit.slaPermissionMng.onNetworkAvailable();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        k.f(network, "network");
        this.f5579a.wasConnected = false;
    }
}
