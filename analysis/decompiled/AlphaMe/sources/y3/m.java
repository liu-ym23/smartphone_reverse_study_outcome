package y3;

/* loaded from: classes2.dex */
public final class m implements x3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16386a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t3.e f16387b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f16388c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16389d;

    public /* synthetic */ m(Object obj, Object obj2, t3.e eVar, int i4) {
        this.f16386a = i4;
        this.f16389d = obj;
        this.f16388c = obj2;
        this.f16387b = eVar;
    }

    @Override // x3.a
    public final void b() {
        int i4 = this.f16386a;
        Object obj = this.f16388c;
        switch (i4) {
            case 0:
                ((t3.c) ((c) this.f16389d).f16353c).d(new l(this, (t3.g) obj, Thread.currentThread()));
                return;
            default:
                t3.e eVar = this.f16387b;
                try {
                    ((x3.a) obj).b();
                    return;
                } finally {
                    eVar.c();
                }
        }
    }
}
