package androidx.room;

import n3.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends r0 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q f1595f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, int i) {
        super(i);
        this.f1595f = qVar;
    }

    @Override // n3.r0
    public final void c(z4.c cVar) {
        p4.a aVar = new p4.a();
        aVar.f9697c = cVar;
        this.f1595f.f(aVar);
    }

    @Override // n3.r0
    public final void d(z4.c cVar, int i, int i3) {
        j(cVar, i, i3);
    }

    @Override // n3.r0
    public final void f(z4.c cVar) throws Throwable {
        p4.a aVar = new p4.a();
        aVar.f9697c = cVar;
        q qVar = this.f1595f;
        qVar.h(aVar);
        qVar.f1604g = cVar;
    }

    @Override // n3.r0
    public final void j(z4.c cVar, int i, int i3) {
        p4.a aVar = new p4.a();
        aVar.f9697c = cVar;
        this.f1595f.g(aVar, i, i3);
    }
}
