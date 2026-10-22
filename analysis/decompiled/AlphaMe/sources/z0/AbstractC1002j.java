package z0;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import kotlin.jvm.internal.Intrinsics;
import s0.t;

/* renamed from: z0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1002j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f16406a;

    static {
        String strF = t.f("NetworkStateTracker");
        Intrinsics.checkNotNullExpressionValue(strF, "tagWithPrefix(\"NetworkStateTracker\")");
        f16406a = strF;
    }

    public static final x0.d a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilitiesA;
        Intrinsics.checkNotNullParameter(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z4 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        Intrinsics.checkNotNullParameter(connectivityManager, "<this>");
        try {
            networkCapabilitiesA = C0.j.a(connectivityManager, C0.k.a(connectivityManager));
        } catch (SecurityException e4) {
            t.d().c(f16406a, "Unable to validate active network", e4);
        }
        boolean zB = networkCapabilitiesA != null ? C0.j.b(networkCapabilitiesA, 16) : false;
        return new x0.d(z4, zB, connectivityManager.isActiveNetworkMetered(), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }
}
