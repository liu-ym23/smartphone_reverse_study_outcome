package com.stepos.core.ability.speech;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import com.stepos.base.strategy.NetworkPolicy;
import com.stepos.core.common.log.LogModule;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudNetworkEvaluator {
    private static final String TAG = "CloudNetworkEvaluator";
    public static final CloudNetworkEvaluator INSTANCE = new CloudNetworkEvaluator();
    private static final Set<Integer> WEAK_2G_TYPES = mb.l.s0(new Integer[]{1, 2, 4, 7, 11});
    private static final Set<Integer> WEAK_3G_TYPES = mb.l.s0(new Integer[]{3, 5, 6, 8, 9, 10, 12, 14, 15});

    private CloudNetworkEvaluator() {
    }

    private final Context context() {
        Context context = l7.a.f10344a;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("ContextHolder must be initialized before use!");
    }

    public final NetworkTransport activeTransport() {
        NetworkCapabilities networkCapabilities;
        Object systemService = context().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return NetworkTransport.UNKNOWN;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? NetworkTransport.UNKNOWN : networkCapabilities.hasTransport(1) ? NetworkTransport.WIFI : networkCapabilities.hasTransport(0) ? NetworkTransport.CELLULAR : networkCapabilities.hasTransport(3) ? NetworkTransport.OTHER : networkCapabilities.hasTransport(4) ? NetworkTransport.OTHER : NetworkTransport.OTHER;
    }

    public final CloudNetworkStatus evaluate(NetworkPolicy policy) {
        kotlin.jvm.internal.g.f(policy, "policy");
        return evaluateWithSnapshot$ability_release(policy, isNetworkAvailable(), activeTransport(), isWeakCellular());
    }

    public final CloudNetworkStatus evaluateWithSnapshot$ability_release(NetworkPolicy policy, boolean z, NetworkTransport transport, boolean z3) {
        kotlin.jvm.internal.g.f(policy, "policy");
        kotlin.jvm.internal.g.f(transport, "transport");
        return policy == NetworkPolicy.f6392c ? CloudNetworkStatus.POLICY_OFFLINE : !z ? CloudNetworkStatus.OFFLINE : (policy == NetworkPolicy.f6391b && transport == NetworkTransport.CELLULAR) ? CloudNetworkStatus.WIFI_REQUIRED : (transport == NetworkTransport.CELLULAR && z3) ? CloudNetworkStatus.WEAK_CELLULAR : CloudNetworkStatus.AVAILABLE;
    }

    public final boolean isNetworkAvailable() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = context().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        return (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) ? false : true;
    }

    public final boolean isWeakCellular() {
        if (activeTransport() != NetworkTransport.CELLULAR) {
            return false;
        }
        Object systemService = context().getSystemService("phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        if (telephonyManager == null) {
            return false;
        }
        try {
            return isWeakCellularNetworkType$ability_release(telephonyManager.getDataNetworkType());
        } catch (SecurityException e10) {
            ai.onnxruntime.a.w("dataNetworkType unavailable: ", e10.getMessage(), LogModule.ABILITY, TAG);
            return false;
        }
    }

    public final boolean isWeakCellularNetworkType$ability_release(int i10) {
        return WEAK_2G_TYPES.contains(Integer.valueOf(i10)) || WEAK_3G_TYPES.contains(Integer.valueOf(i10));
    }
}
