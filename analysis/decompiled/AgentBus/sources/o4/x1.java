package o4;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class x1 implements NsdManager.DiscoveryListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y1 f7684a;

    public x1(y1 y1Var) {
        this.f7684a = y1Var;
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStarted(String str) {
        q7.k.e(str, "serviceType");
        ((la.u0) this.f7684a.f7703d).f("Searching ".concat(str));
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStopped(String str) {
        q7.k.e(str, "serviceType");
        la.u0 u0Var = (la.u0) this.f7684a.f7703d;
        u0Var.getClass();
        u0Var.g(null, "Stopped");
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceFound(NsdServiceInfo nsdServiceInfo) {
        q7.k.e(nsdServiceInfo, "info");
        Log.d("OpenClaw/Discovery", "service found: " + nsdServiceInfo.getServiceName());
        y1 y1Var = this.f7684a;
        NsdManager nsdManager = (NsdManager) y1Var.f7700a;
        if (nsdManager == null) {
            return;
        }
        try {
            nsdManager.resolveService(nsdServiceInfo, new w1(y1Var));
        } catch (Throwable th) {
            w7.e0.n(th);
        }
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        q7.k.e(nsdServiceInfo, "info");
        String strD = y1.d(nsdServiceInfo, null, null);
        y1 y1Var = this.f7684a;
        if (((ConcurrentHashMap) y1Var.f7701b).remove(strD) != null) {
            y1.a(y1Var);
        }
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStartDiscoveryFailed(String str, int i2) {
        q7.k.e(str, "serviceType");
        Log.w("OpenClaw/Discovery", "onStartDiscoveryFailed: " + i2);
        ((la.u0) this.f7684a.f7703d).f("Start failed: " + i2);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStopDiscoveryFailed(String str, int i2) {
        q7.k.e(str, "serviceType");
        Log.w("OpenClaw/Discovery", "onStopDiscoveryFailed: " + i2);
    }
}
