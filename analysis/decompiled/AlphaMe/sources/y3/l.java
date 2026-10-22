package y3;

/* loaded from: classes2.dex */
public final class l extends t3.g {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Thread f16384e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ m f16385f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, t3.g gVar, Thread thread) {
        super(gVar, true);
        this.f16385f = mVar;
        this.f16384e = thread;
    }

    @Override // t3.g
    public final void e() {
        m mVar = this.f16385f;
        try {
            ((t3.g) mVar.f16388c).e();
        } finally {
            mVar.f16387b.c();
        }
    }

    @Override // t3.g
    public final void f(Throwable th) {
        m mVar = this.f16385f;
        try {
            ((t3.g) mVar.f16388c).f(th);
        } finally {
            mVar.f16387b.c();
        }
    }

    @Override // t3.g
    public final void g(Object obj) {
        ((t3.g) this.f16385f.f16388c).g(obj);
    }

    @Override // t3.g
    public final void i(t3.d dVar) {
        ((t3.g) this.f16385f.f16388c).i(new B0.e(this, dVar, 10));
    }
}
