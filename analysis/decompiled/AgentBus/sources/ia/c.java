package ia;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class c extends k1 {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f4922m = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;

    /* renamed from: j, reason: collision with root package name */
    public final m f4923j;

    /* renamed from: k, reason: collision with root package name */
    public p0 f4924k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ e f4925l;

    public c(e eVar, m mVar) {
        this.f4925l = eVar;
        this.f4923j = mVar;
    }

    @Override // ia.k1
    public final boolean k() {
        return false;
    }

    @Override // ia.k1
    public final void l(Throwable th) throws k0 {
        m mVar = this.f4923j;
        if (th != null) {
            mVar.getClass();
            f8.x xVarF = mVar.F(new v(th, false), null, null);
            if (xVarF != null) {
                mVar.x(xVarF);
                d dVar = (d) f4922m.get(this);
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e.f4947b;
        e eVar = this.f4925l;
        if (atomicIntegerFieldUpdater.decrementAndGet(eVar) == 0) {
            g0[] g0VarArr = eVar.f4948a;
            ArrayList arrayList = new ArrayList(g0VarArr.length);
            for (g0 g0Var : g0VarArr) {
                arrayList.add(g0Var.g());
            }
            mVar.resumeWith(arrayList);
        }
    }
}
