package androidx.compose.runtime;

import C7.r;
import S7.n;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1800a;
    public final /* synthetic */ S7.k b;

    public /* synthetic */ l(S7.k kVar, int i) {
        this.f1800a = i;
        this.b = kVar;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f1800a;
        S7.k kVar = this.b;
        r rVar = (r) obj2;
        switch (i) {
            case 0:
                return Updater.init_impl$lambda$4(kVar, obj, rVar);
            default:
                return Updater.reconcile_impl$lambda$5(kVar, obj, rVar);
        }
    }
}
