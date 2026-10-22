package com.stepos.core.ota.process;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InterruptedResumeGuard {
    public static final InterruptedResumeGuard INSTANCE = new InterruptedResumeGuard();
    private static final String TAG = "InterruptedResumeGuard";

    private InterruptedResumeGuard() {
    }

    private final boolean isWifiActive(Context context) {
        Object objA;
        ConnectivityManager connectivityManager;
        boolean z;
        NetworkCapabilities networkCapabilities;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService(ConnectivityManager.class);
            z = false;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
            if (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(1)) {
                z = true;
            }
            objA = Boolean.valueOf(z);
            Object obj = Boolean.FALSE;
            if (objA instanceof Result.Failure) {
                objA = obj;
            }
            return ((Boolean) objA).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void reconcile(android.content.Context r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.process.InterruptedResumeGuard.reconcile(android.content.Context, java.lang.String):void");
    }
}
