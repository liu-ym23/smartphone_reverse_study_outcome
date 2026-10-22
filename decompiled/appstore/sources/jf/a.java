package jf;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.security.NetworkSecurityPolicy;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static Network a(ConnectivityManager r10) {
        return r10.getActiveNetwork();
    }

    public static Network b(ConnectivityManager r10) {
        return r10.getBoundNetworkForProcess();
    }

    public static long c(Network r10) {
        return r10.getNetworkHandle();
    }

    public static NetworkInfo d(ConnectivityManager r10, Network r11) {
        return r10.getNetworkInfo(r11);
    }

    public static boolean e() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }
}
