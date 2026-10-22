package c4;

import C7.r;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import kotlin.jvm.internal.k;

/* renamed from: c4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0878a extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.stepos.ability.manager.reporter.a f2089a;

    public C0878a(com.stepos.ability.manager.reporter.a aVar) {
        this.f2089a = aVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        k.f(network, "network");
        super.onAvailable(network);
        Log.i("AbilityReportProcessor", "Network available, trigger upload.");
        this.f2089a.f.a(r.f317a);
    }
}
