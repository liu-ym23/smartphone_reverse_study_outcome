package a6;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends l1 {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f138h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;

    /* renamed from: e, reason: collision with root package name */
    public final m f139e;

    /* renamed from: f, reason: collision with root package name */
    public s0 f140f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f141g;

    public c(e eVar, m mVar) {
        this.f141g = eVar;
        this.f139e = mVar;
    }

    @Override // a6.l1
    public final boolean k() {
        return false;
    }

    @Override // a6.l1
    public final void l(Throwable th) throws o0 {
        m mVar = this.f139e;
        if (th != null) {
            mVar.getClass();
            androidx.emoji2.text.r rVarE = mVar.E(new v(th, false), null);
            if (rVarE != null) {
                mVar.m(rVarE);
                d dVar = (d) f138h.get(this);
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = e.f151b;
        e eVar = this.f141g;
        if (atomicIntegerFieldUpdater.decrementAndGet(eVar) == 0) {
            l0[] l0VarArr = eVar.f152a;
            ArrayList arrayList = new ArrayList(l0VarArr.length);
            for (l0 l0Var : l0VarArr) {
                arrayList.add(l0Var.g());
            }
            mVar.resumeWith(arrayList);
        }
    }
}
