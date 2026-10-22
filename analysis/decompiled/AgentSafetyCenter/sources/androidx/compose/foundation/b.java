package androidx.compose.foundation;

import a2.g;
import k0.m;
import k0.s;
import t.n0;
import v.k;
import xb.q;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends l implements q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n0 f858c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f859f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f860g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g f861h;
    public final /* synthetic */ xb.a i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n0 n0Var, boolean z10, String str, g gVar, xb.a aVar) {
        super(3);
        this.f858c = n0Var;
        this.f859f = z10;
        this.f860g = str;
        this.f861h = gVar;
        this.i = aVar;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        s sVar = (s) obj2;
        ((Number) obj3).intValue();
        sVar.X(-1525724089);
        Object objM = sVar.M();
        if (objM == m.f6974a) {
            objM = t0.a.a();
            sVar.i0(objM);
        }
        k kVar = (k) objM;
        w0.m mVarD = c.a(this.f858c, kVar).d(new ClickableElement(kVar, null, this.f859f, this.f860g, this.f861h, this.i));
        sVar.q(false);
        return mVarD;
    }
}
