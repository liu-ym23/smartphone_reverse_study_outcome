package t8;

import f8.g;
import f8.q0;
import i5.l;
import l8.q;
import q7.m;
import v9.m0;

/* loaded from: classes.dex */
public final class b extends m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ l f9778g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q0 f9779h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ a f9780i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ m0 f9781j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ q f9782k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(l lVar, q0 q0Var, a aVar, m0 m0Var, q qVar) {
        super(0);
        this.f9778g = lVar;
        this.f9779h = q0Var;
        this.f9780i = aVar;
        this.f9781j = m0Var;
        this.f9782k = qVar;
    }

    @Override // p7.a
    public final Object c() {
        nb.f fVar = (nb.f) this.f9778g.f4689i;
        g gVarC = this.f9781j.c();
        return fVar.z(this.f9779h, a.a(a.a(this.f9780i, 0, false, null, gVarC != null ? gVarC.k() : null, 31), 0, this.f9782k.d(), null, null, 59));
    }
}
