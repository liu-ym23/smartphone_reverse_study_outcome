package td;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f24797a = null;

    static {
        f24797a = new d();
    }

    public d() {
    }

    public static final boolean a(Context r10) {
        q.g(r10, "context");
        Object r11 = r10.getSystemService("connectivity");
        if (r11 == null) goto L21;
        ConnectivityManager r12 = (ConnectivityManager) r11;
        Network r13 = r12.getActiveNetwork();
        if (r13 != null) goto L7;
        return false;
    L7:
        NetworkCapabilities r14 = r12.getNetworkCapabilities(r13);
        if (r14 != null) goto L11;
        return false;
    L11:
        if (r14.hasTransport(1) == false) goto L14;
    L19:
        return true;
    L14:
        if (r14.hasTransport(0) == true) goto L19;
        if (r14.hasTransport(3) == true) goto L19;
        return false;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
}
