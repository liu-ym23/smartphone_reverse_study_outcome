package z1;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import z1.InterfaceC6056f;

@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\b\u0005*\u0001\u0017\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\r*\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0018R\u0014\u0010\u000e\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u001a¨\u0006\u001b"}, d2 = {"Lz1/h;", "Lz1/f;", "Landroid/net/ConnectivityManager;", "connectivityManager", "Lz1/f$a;", "listener", "<init>", "(Landroid/net/ConnectivityManager;Lz1/f$a;)V", "LY8/t;", "shutdown", "()V", "Landroid/net/Network;", "network", "", "isOnline", Const.INTENT_KEY_UMID, "(Landroid/net/Network;Z)V", "c", "(Landroid/net/Network;)Z", Const.INTENT_KEY_APIKEY, "Landroid/net/ConnectivityManager;", Const.INTENT_KEY_PKGNAME, "Lz1/f$a;", "z1/h$a", "Lz1/h$a;", "networkCallback", "()Z", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public final class h implements InterfaceC6056f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ConnectivityManager connectivityManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6056f.a listener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final a networkCallback;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"z1/h$a", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "LY8/t;", "onAvailable", "(Landroid/net/Network;)V", "onLost", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            h.this.d(network, true);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            h.this.d(network, false);
        }
    }

    public h(ConnectivityManager connectivityManager, InterfaceC6056f.a aVar) {
        this.connectivityManager = connectivityManager;
        this.listener = aVar;
        a aVar2 = new a();
        this.networkCallback = aVar2;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), aVar2);
    }

    @Override // z1.InterfaceC6056f
    public boolean a() {
        for (Network network : this.connectivityManager.getAllNetworks()) {
            if (c(network)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Network network) {
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }

    public final void d(Network network, boolean isOnline) {
        Network[] allNetworks = this.connectivityManager.getAllNetworks();
        int length = allNetworks.length;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Network network2 = allNetworks[i10];
            if (p.d(network2, network) ? isOnline : c(network2)) {
                z10 = true;
                break;
            }
            i10++;
        }
        this.listener.a(z10);
    }

    @Override // z1.InterfaceC6056f
    public void shutdown() {
        this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
    }
}
