package com.smt.obric.appstore.ktx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.bytedanceos.common.toolbox.j;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ConnectivityManagerNetworkMonitorKt {
    public static final /* synthetic */ boolean a(ConnectivityManager r10, Network r11) {
        return c(r10, r11);
    }

    public static final boolean b(ConnectivityManager r10, Network r11) {
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L5
        NetworkCapabilities r13 = r10.getNetworkCapabilities(r11);     // Catch: Throwable -> L5
        if (r13 == null) goto L7;
        boolean r14 = r13.hasCapability(12);     // Catch: Throwable -> L5
    L8:
        Object r15 = Result.m35constructorimpl(Boolean.valueOf(r14));     // Catch: Throwable -> L5
    L11:
        Throwable r16 = Result.m38exceptionOrNullimpl(r15);
        if (r16 == null) goto L16;
        j.j("[ConnectivityManagerNetworkMonitor] hasInternetCapability failed, err=", r16);
        r15 = Boolean.FALSE;
    L16:
        return ((Boolean) r15).booleanValue();
    L7:
        r14 = false;
    L5:
        th = move-exception;
        Result.a r17 = Result.Companion;
        r15 = Result.m35constructorimpl(c.a(th));
        goto L11
    }

    public static final boolean c(ConnectivityManager r10, Network r11) {
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L5
        NetworkCapabilities r13 = r10.getNetworkCapabilities(r11);     // Catch: Throwable -> L5
        if (r13 == null) goto L7;
        boolean r14 = r13.hasTransport(1);     // Catch: Throwable -> L5
    L8:
        Object r15 = Result.m35constructorimpl(Boolean.valueOf(r14));     // Catch: Throwable -> L5
    L11:
        Throwable r16 = Result.m38exceptionOrNullimpl(r15);
        if (r16 == null) goto L16;
        j.j("[ConnectivityManagerNetworkMonitor] hasWifiTransport failed, err=", r16);
        r15 = Boolean.FALSE;
    L16:
        return ((Boolean) r15).booleanValue();
    L7:
        r14 = false;
    L5:
        th = move-exception;
        Result.a r17 = Result.Companion;
        r15 = Result.m35constructorimpl(c.a(th));
        goto L11
    }

    public static final boolean d(ConnectivityManager r10) {
        q.g(r10, "<this>");
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L9
        Network r12 = r10.getActiveNetwork();     // Catch: Throwable -> L9
        if (r12 != null) goto L6;
        boolean r13 = false;
    L7:
        Object r14 = Result.m35constructorimpl(Boolean.valueOf(r13));     // Catch: Throwable -> L9
    L11:
        Throwable r15 = Result.m38exceptionOrNullimpl(r14);
        if (r15 == null) goto L16;
        j.j("[ConnectivityManagerNetworkMonitor] isCurrentlyConnected failed, err=", r15);
        r14 = Boolean.FALSE;
    L16:
        return ((Boolean) r14).booleanValue();
    L6:
        q.d(r12);     // Catch: Throwable -> L9
        r13 = b(r10, r12);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r14 = Result.m35constructorimpl(c.a(th));
        goto L11
    }

    public static final Flow e(Context r10) {
        q.g(r10, "<this>");
        Object r11 = r10.getSystemService("connectivity");
        q.e(r11, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return kotlinx.coroutines.flow.c.k(kotlinx.coroutines.flow.c.e(new ConnectivityManagerNetworkMonitorKt$isWiFiConnectedFlow$1((ConnectivityManager) r11, null)));
    }

    public static final boolean f(Context r10) {
        q.g(r10, "<this>");
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L5
        Object r12 = r10.getSystemService("connectivity");     // Catch: Throwable -> L5
        q.e(r12, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Throwable -> L5
        Object r13 = Result.m35constructorimpl(Boolean.valueOf(g((ConnectivityManager) r12)));     // Catch: Throwable -> L5
    L7:
        Throwable r14 = Result.m38exceptionOrNullimpl(r13);
        if (r14 == null) goto L12;
        j.j("[ConnectivityManagerNetworkMonitor] Context.isWifiConnected failed, err=", r14);
        r13 = Boolean.FALSE;
    L12:
        return ((Boolean) r13).booleanValue();
    L5:
        th = move-exception;
        Result.a r15 = Result.Companion;
        r13 = Result.m35constructorimpl(c.a(th));
        goto L7
    }

    public static final boolean g(ConnectivityManager r10) {
        q.g(r10, "<this>");
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L9
        Network r12 = r10.getActiveNetwork();     // Catch: Throwable -> L9
        if (r12 != null) goto L6;
        boolean r13 = false;
    L7:
        Object r14 = Result.m35constructorimpl(Boolean.valueOf(r13));     // Catch: Throwable -> L9
    L11:
        Throwable r15 = Result.m38exceptionOrNullimpl(r14);
        if (r15 == null) goto L16;
        j.j("[ConnectivityManagerNetworkMonitor] isWifiConnected failed, err=", r15);
        r14 = Boolean.FALSE;
    L16:
        return ((Boolean) r14).booleanValue();
    L6:
        q.d(r12);     // Catch: Throwable -> L9
        r13 = c(r10, r12);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.a r16 = Result.Companion;
        r14 = Result.m35constructorimpl(c.a(th));
        goto L11
    }
}
