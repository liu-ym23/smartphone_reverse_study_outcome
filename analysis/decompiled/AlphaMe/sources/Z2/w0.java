package Z2;

import d3.AbstractC0539a;
import d3.AbstractC0540b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class w0 extends AbstractC0540b {

    /* renamed from: b, reason: collision with root package name */
    public final d3.m f2254b;

    /* renamed from: c, reason: collision with root package name */
    public d3.m f2255c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ x0 f2256d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2257e;

    public w0(d3.m mVar, x0 x0Var, Object obj) {
        this.f2256d = x0Var;
        this.f2257e = obj;
        this.f2254b = mVar;
    }

    @Override // d3.AbstractC0540b
    public final void b(Object obj, Object obj2) {
        d3.m mVar = (d3.m) obj;
        boolean z4 = obj2 == null;
        d3.m mVar2 = this.f2254b;
        d3.m mVar3 = z4 ? mVar2 : this.f2255c;
        if (mVar3 != null && d3.m.f12465a.compareAndSet(mVar, this, mVar3) && z4) {
            d3.m mVar4 = this.f2255c;
            Intrinsics.checkNotNull(mVar4);
            mVar2.e(mVar4);
        }
    }

    @Override // d3.AbstractC0540b
    public final X.r c(Object obj) {
        if (this.f2256d.G() == this.f2257e) {
            return null;
        }
        return AbstractC0539a.f12445d;
    }
}
