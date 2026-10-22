package l5;

import android.net.ConnectivityManager;
import androidx.lifecycle.l0;
import nc.k0;
import p5.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements m5.d {

    /* renamed from: a, reason: collision with root package name */
    public ConnectivityManager f7738a;

    /* renamed from: b, reason: collision with root package name */
    public long f7739b;

    @Override // m5.d
    public final boolean a(p pVar) {
        if (pVar.f9772j.a() == null) {
            return false;
        }
        od.f.e("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
        return false;
    }

    @Override // m5.d
    public final boolean b(p pVar) {
        return pVar.f9772j.a() != null;
    }

    @Override // m5.d
    public final nc.c c(g5.d dVar) {
        dVar.getClass();
        return k0.e(new l0(dVar, this, (nb.c) null, 11));
    }
}
