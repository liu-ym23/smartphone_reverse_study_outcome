package c6;

import a6.g2;
import a6.i0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements g2 {

    /* renamed from: a, reason: collision with root package name */
    public Object f1105a = e.f1132p;

    /* renamed from: b, reason: collision with root package name */
    public a6.m f1106b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f1107c;

    public b(c cVar) {
        this.f1107c = cVar;
    }

    public final Object a(h5.c cVar) {
        k kVar;
        k kVar2;
        Object obj = this.f1105a;
        boolean z = true;
        if (obj == e.f1132p || obj == e.f1128l) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f1112g;
            c cVar2 = this.f1107c;
            k kVar3 = (k) atomicReferenceFieldUpdater.get(cVar2);
            while (true) {
                if (cVar2.v(c.f1108b.get(cVar2), true)) {
                    this.f1105a = e.f1128l;
                    Throwable thQ = cVar2.q();
                    if (thQ != null) {
                        int i8 = f6.r.f2660a;
                        throw thQ;
                    }
                    z = false;
                } else {
                    long andIncrement = c.f1109c.getAndIncrement(cVar2);
                    long j4 = e.f1119b;
                    long j8 = andIncrement / j4;
                    int i9 = (int) (andIncrement % j4);
                    if (kVar3.f2659c != j8) {
                        k kVarP = cVar2.p(j8, kVar3);
                        if (kVarP == null) {
                            continue;
                        } else {
                            kVar = kVarP;
                        }
                    } else {
                        kVar = kVar3;
                    }
                    Object objD = cVar2.D(kVar, i9, andIncrement, null);
                    androidx.emoji2.text.r rVar = e.f1129m;
                    if (objD == rVar) {
                        throw new IllegalStateException("unreachable");
                    }
                    androidx.emoji2.text.r rVar2 = e.f1131o;
                    if (objD == rVar2) {
                        if (andIncrement < cVar2.t()) {
                            kVar.b();
                        }
                        kVar3 = kVar;
                    } else {
                        if (objD == e.f1130n) {
                            a6.m mVarM = i0.m(b8.h.u(cVar));
                            try {
                                this.f1106b = mVarM;
                                Object objD2 = cVar2.D(kVar, i9, andIncrement, this);
                                if (objD2 == rVar) {
                                    b(kVar, i9);
                                } else {
                                    if (objD2 == rVar2) {
                                        if (andIncrement < cVar2.t()) {
                                            kVar.b();
                                        }
                                        k kVar4 = (k) c.f1112g.get(cVar2);
                                        while (true) {
                                            if (cVar2.v(c.f1108b.get(cVar2), true)) {
                                                a6.m mVar = this.f1106b;
                                                kotlin.jvm.internal.p.b(mVar);
                                                this.f1106b = null;
                                                this.f1105a = e.f1128l;
                                                Throwable thQ2 = cVar2.q();
                                                if (thQ2 == null) {
                                                    mVar.resumeWith(Boolean.FALSE);
                                                } else {
                                                    mVar.resumeWith(a.a.o(thQ2));
                                                }
                                            } else {
                                                long andIncrement2 = c.f1109c.getAndIncrement(cVar2);
                                                long j9 = e.f1119b;
                                                long j10 = andIncrement2 / j9;
                                                int i10 = (int) (andIncrement2 % j9);
                                                if (kVar4.f2659c != j10) {
                                                    k kVarP2 = cVar2.p(j10, kVar4);
                                                    if (kVarP2 != null) {
                                                        kVar2 = kVarP2;
                                                    }
                                                } else {
                                                    kVar2 = kVar4;
                                                }
                                                Object objD3 = cVar2.D(kVar2, i10, andIncrement2, this);
                                                k kVar5 = kVar2;
                                                if (objD3 == e.f1129m) {
                                                    b(kVar5, i10);
                                                    break;
                                                }
                                                if (objD3 == e.f1131o) {
                                                    if (andIncrement2 < cVar2.t()) {
                                                        kVar5.b();
                                                    }
                                                    kVar4 = kVar5;
                                                } else {
                                                    if (objD3 == e.f1130n) {
                                                        throw new IllegalStateException("unexpected");
                                                    }
                                                    kVar5.b();
                                                    this.f1105a = objD3;
                                                    this.f1106b = null;
                                                }
                                            }
                                        }
                                    } else {
                                        kVar.b();
                                        this.f1105a = objD2;
                                        this.f1106b = null;
                                    }
                                    mVarM.h(Boolean.TRUE, null);
                                }
                                Object objS = mVarM.s();
                                g5.a aVar = g5.a.f2984a;
                                return objS;
                            } catch (Throwable th) {
                                mVarM.A();
                                throw th;
                            }
                        }
                        kVar.b();
                        this.f1105a = objD;
                    }
                }
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // a6.g2
    public final void b(f6.q qVar, int i8) {
        a6.m mVar = this.f1106b;
        if (mVar != null) {
            mVar.b(qVar, i8);
        }
    }

    public final Object c() throws Throwable {
        Object obj = this.f1105a;
        androidx.emoji2.text.r rVar = e.f1132p;
        if (obj == rVar) {
            throw new IllegalStateException("`hasNext()` has not been invoked");
        }
        this.f1105a = rVar;
        if (obj != e.f1128l) {
            return obj;
        }
        Throwable thR = this.f1107c.r();
        int i8 = f6.r.f2660a;
        throw thR;
    }
}
