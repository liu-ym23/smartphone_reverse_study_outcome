package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import n2.c;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NetworkRequestConstraintController implements c {

    /* renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f2900a;

    public NetworkRequestConstraintController(ConnectivityManager connectivityManager) {
        this.f2900a = connectivityManager;
    }

    @Override // n2.c
    public final boolean a(p pVar) {
        if (b(pVar)) {
            throw new IllegalStateException("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
        }
        return false;
    }

    @Override // n2.c
    public final boolean b(p workSpec) {
        g.f(workSpec, "workSpec");
        return workSpec.f11513j.a() != null;
    }

    @Override // n2.c
    public final Flow<a> c(h2.c constraints) {
        g.f(constraints, "constraints");
        return FlowKt.callbackFlow(new NetworkRequestConstraintController$track$1(constraints, this, null));
    }
}
