package com.stepos.ailauncher.common.utils;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001&\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00178\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/common/utils/NetworkStateMonitor;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "f", "(Landroid/content/Context;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "reason", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "", "GRACE_PERIOD_MS", "J", "LXa/k;", "Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "_phase", "LXa/k;", "LXa/t;", "phase", "LXa/t;", "e", "()LXa/t;", "getPhase$annotations", "LUa/M;", "scope", "LUa/M;", "Lkotlinx/coroutines/g;", "demoteJob", "Lkotlinx/coroutines/g;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "com/stepos/ailauncher/common/utils/NetworkStateMonitor$a", "callback", "Lcom/stepos/ailauncher/common/utils/NetworkStateMonitor$a;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkStateMonitor {
    public static final long GRACE_PERIOD_MS = 10000;
    public static final NetworkStateMonitor INSTANCE = new NetworkStateMonitor();
    private static final String TAG = "NetworkStateMonitor";
    private static final Xa.k<NetworkPhase> _phase;
    private static final a callback;
    private static volatile kotlinx.coroutines.g demoteJob;
    private static final AtomicBoolean initialized;
    private static final Xa.t<NetworkPhase> phase;
    private static final M scope;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/common/utils/NetworkStateMonitor$a", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "LY8/t;", "onAvailable", "(Landroid/net/Network;)V", "Landroid/net/NetworkCapabilities;", "capabilities", "onCapabilitiesChanged", "(Landroid/net/Network;Landroid/net/NetworkCapabilities;)V", "onLost", "onUnavailable", "()V", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            kotlin.jvm.internal.p.i(network, "network");
            C4148a.d(NetworkStateMonitor.TAG, "onAvailable network=" + network + ", awaiting VALIDATED", false, 4, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities capabilities) {
            kotlin.jvm.internal.p.i(network, "network");
            kotlin.jvm.internal.p.i(capabilities, "capabilities");
            if (capabilities.hasCapability(12) && capabilities.hasCapability(16)) {
                NetworkStateMonitor.INSTANCE.g();
            } else {
                NetworkStateMonitor.INSTANCE.d("capabilities not validated");
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            kotlin.jvm.internal.p.i(network, "network");
            NetworkStateMonitor.INSTANCE.d("onLost");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            NetworkStateMonitor.INSTANCE.d("onUnavailable");
        }
    }

    static {
        Xa.k<NetworkPhase> kVarA = Xa.u.a(NetworkPhase.AVAILABLE);
        _phase = kVarA;
        phase = Xa.d.c(kVarA);
        scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.a()));
        initialized = new AtomicBoolean(false);
        callback = new a();
    }

    public static final Xa.t<NetworkPhase> e() {
        return phase;
    }

    public static final void f(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        AtomicBoolean atomicBoolean = initialized;
        if (atomicBoolean.compareAndSet(false, true)) {
            Context applicationContext = context.getApplicationContext();
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(ConnectivityManager.class);
            if (connectivityManager == null) {
                atomicBoolean.set(false);
                C4148a.u(TAG, "init failed: ConnectivityManager unavailable, stay AVAILABLE", false, 4, null);
                return;
            }
            Xa.k<NetworkPhase> kVar = _phase;
            I i10 = I.INSTANCE;
            kotlin.jvm.internal.p.f(applicationContext);
            kVar.setValue(i10.b(applicationContext) ? NetworkPhase.AVAILABLE : NetworkPhase.LOST);
            try {
                Result.Companion companion = Result.INSTANCE;
                connectivityManager.registerDefaultNetworkCallback(callback);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.h(objB)) {
                C4148a.k(TAG, "init done, initial phase=" + _phase.getValue(), false, 4, null);
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                initialized.set(false);
                C4148a.t(TAG, "registerDefaultNetworkCallback failed", thE, false, 8, null);
            }
        }
    }

    public final void d(String reason) {
        Xa.k<NetworkPhase> kVar = _phase;
        NetworkPhase value = kVar.getValue();
        NetworkPhase networkPhase = NetworkPhase.CONNECTING;
        if (value == networkPhase) {
            return;
        }
        C4148a.k(TAG, "phase " + kVar.getValue() + " -> CONNECTING (" + reason + "), grace=10000ms", false, 4, null);
        kVar.setValue(networkPhase);
        kotlinx.coroutines.g gVar = demoteJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        demoteJob = C1060i.d(scope, null, null, new NetworkStateMonitor$demote$1(null), 3, null);
    }

    public final void g() {
        kotlinx.coroutines.g gVar = demoteJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        demoteJob = null;
        Xa.k<NetworkPhase> kVar = _phase;
        NetworkPhase value = kVar.getValue();
        NetworkPhase networkPhase = NetworkPhase.AVAILABLE;
        if (value != networkPhase) {
            C4148a.k(TAG, "phase " + kVar.getValue() + " -> AVAILABLE", false, 4, null);
        }
        kVar.setValue(networkPhase);
    }
}
