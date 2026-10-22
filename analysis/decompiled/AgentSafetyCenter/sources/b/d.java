package b;

import androidx.fragment.app.s;
import java.lang.invoke.VarHandle;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f1688c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ d.h f1689f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f1690g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ s f1691h;
    public final /* synthetic */ c1 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, d.h hVar, String str, s sVar, c1 c1Var) {
        super(1);
        this.f1688c = aVar;
        this.f1689f = hVar;
        this.f1690g = str;
        this.f1691h = sVar;
        this.i = c1Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        b bVar = new b(0);
        bVar.f1685f = this.i;
        VarHandle.storeStoreFence();
        d.e eVarC = this.f1689f.c(this.f1690g, this.f1691h, bVar);
        a aVar = this.f1688c;
        aVar.f1683a = eVarC;
        c cVar = new c(0);
        cVar.f1687b = aVar;
        VarHandle.storeStoreFence();
        return cVar;
    }
}
