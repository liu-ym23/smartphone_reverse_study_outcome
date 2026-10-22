package o2;

import android.content.Context;
import android.net.ConnectivityManager;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends g<m2.b> {

    /* renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f10728f;

    /* renamed from: g, reason: collision with root package name */
    public final i f10729g;

    public j(Context context, s2.c cVar) {
        super(context, cVar);
        Object systemService = this.f10722b.getSystemService("connectivity");
        kotlin.jvm.internal.g.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f10728f = (ConnectivityManager) systemService;
        this.f10729g = new i(this);
    }

    @Override // o2.g
    public final m2.b a() {
        return k.a(this.f10728f);
    }

    @Override // o2.g
    public final void c() {
        try {
            h2.j.d().a(k.f10730a, "Registering network callback");
            ConnectivityManager connectivityManager = this.f10728f;
            i networkCallback = this.f10729g;
            kotlin.jvm.internal.g.f(connectivityManager, "<this>");
            kotlin.jvm.internal.g.f(networkCallback, "networkCallback");
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        } catch (IllegalArgumentException e10) {
            h2.j.d().c(k.f10730a, "Received exception while registering network callback", e10);
        } catch (SecurityException e11) {
            h2.j.d().c(k.f10730a, "Received exception while registering network callback", e11);
        }
    }

    @Override // o2.g
    public final void d() {
        try {
            h2.j.d().a(k.f10730a, "Unregistering network callback");
            ConnectivityManager connectivityManager = this.f10728f;
            i networkCallback = this.f10729g;
            kotlin.jvm.internal.g.f(connectivityManager, "<this>");
            kotlin.jvm.internal.g.f(networkCallback, "networkCallback");
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (IllegalArgumentException e10) {
            h2.j.d().c(k.f10730a, "Received exception while unregistering network callback", e10);
        } catch (SecurityException e11) {
            h2.j.d().c(k.f10730a, "Received exception while unregistering network callback", e11);
        }
    }
}
