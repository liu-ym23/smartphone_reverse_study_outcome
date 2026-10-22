package i6;

import a6.g2;
import a6.l;
import a6.m;
import a6.o0;
import androidx.emoji2.text.r;
import b5.a0;
import f6.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements a6.k, g2 {

    /* renamed from: a, reason: collision with root package name */
    public final m f3152a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f3153b;

    public b(c cVar, m mVar) {
        this.f3153b = cVar;
        this.f3152a = mVar;
    }

    @Override // a6.k
    public final boolean a() {
        return this.f3152a.a();
    }

    @Override // a6.g2
    public final void b(q qVar, int i8) {
        this.f3152a.b(qVar, i8);
    }

    @Override // f5.c
    public final f5.h getContext() {
        return this.f3152a.f192e;
    }

    @Override // a6.k
    public final void h(Object obj, p5.q qVar) throws o0 {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f3154h;
        c cVar = this.f3153b;
        atomicReferenceFieldUpdater.set(cVar, null);
        c5.a aVar = new c5.a(cVar, this);
        m mVar = this.f3152a;
        mVar.B(a0.f883a, mVar.f209c, new l(0, aVar));
    }

    @Override // a6.k
    public final void m(Object obj) throws o0 {
        this.f3152a.m(obj);
    }

    @Override // a6.k
    public final r p(Object obj, p5.q qVar) {
        c cVar = this.f3153b;
        l lVar = new l(cVar, this);
        r rVarE = this.f3152a.E((a0) obj, lVar);
        if (rVarE != null) {
            c.f3154h.set(cVar, null);
        }
        return rVarE;
    }

    @Override // f5.c
    public final void resumeWith(Object obj) throws o0 {
        this.f3152a.resumeWith(obj);
    }
}
