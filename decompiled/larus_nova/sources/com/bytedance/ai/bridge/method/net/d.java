package com.bytedance.ai.bridge.method.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.google.gson.JsonObject;
import f2.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f35637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f35638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f35639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static f f35640d;

    public d() {
    }

    static {
        f35637a = new Object();
    }

    public static final void a() {
        Context r100 = f35638b;
        if (r100 == null) goto L27;
        f r101 = e.a(r100);
        Object r102 = f35637a;
        monitor-enter(r102);
        f r103 = f35640d;     // Catch: Throwable -> L22
        if (r103 != null) goto L10;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L18;
        monitor-exit(r102);
        return;
    L18:
        f35640d = r101;     // Catch: Throwable -> L22
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r102);
        JsonObject r106 = new JsonObject();
        r106.addProperty("isConnected", Boolean.valueOf(r101.f35753b));
        r106.addProperty("networkType", r101.f35752a);
        l3.d.c(new l3.a("doubao.onNetworkStatusChange", r106, 4));
        return;
    L10:
        if (Intrinsics.areEqual(r101.f35752a, r103.f35752a) == false) goto L14;
        if (r101.f35753b != r103.f35753b) goto L14;
        r104 = true;
    L22:
        th = move-exception;
        throw th;
    }

    public static void b() {
        Context r100 = k.a().getApplicationContext();
        Object r101 = f35637a;
        monitor-enter(r101);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (f35639c == null) goto L8;
        monitor-exit(r101);
        return;
    L8:
        Object r102 = r100.getSystemService("connectivity");     // Catch: Throwable -> L23
        if ((r102 instanceof ConnectivityManager) == false) goto L12;
        ConnectivityManager r103 = (ConnectivityManager) r102;     // Catch: Throwable -> L23
    L13:
        if (r103 != null) goto L16;
        monitor-exit(r101);
        return;
    L16:
        c r104 = new c();     // Catch: Throwable -> L23
        r103.registerNetworkCallback(new NetworkRequest.Builder().build(), r104);     // Catch: RuntimeException -> L19 Throwable -> L23
        f35638b = r100;     // Catch: RuntimeException -> L19 Throwable -> L23
        f35639c = r104;     // Catch: RuntimeException -> L19 Throwable -> L23
        f35640d = e.a(r100);     // Catch: RuntimeException -> L19 Throwable -> L23
    L20:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r101);
        return;
    L19:
        f35638b = null;     // Catch: Throwable -> L23
        f35639c = null;     // Catch: Throwable -> L23
        f35640d = null;     // Catch: Throwable -> L23
        goto L20
    L12:
        r103 = null;
        goto L13
    }
}
