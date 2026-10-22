package o2;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10730a;

    static {
        String strF = h2.j.f("NetworkStateTracker");
        kotlin.jvm.internal.g.e(strF, "tagWithPrefix(\"NetworkStateTracker\")");
        f10730a = strF;
    }

    public static final m2.b a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        kotlin.jvm.internal.g.f(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (SecurityException e10) {
            h2.j.d().c(f10730a, "Unable to validate active network", e10);
        }
        boolean zHasCapability = networkCapabilities != null ? networkCapabilities.hasCapability(16) : false;
        return new m2.b(z, zHasCapability, connectivityManager.isActiveNetworkMetered(), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }
}
