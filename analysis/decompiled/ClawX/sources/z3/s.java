package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s extends h5.i implements p5.p {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f6501a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6502b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(boolean z, f5.c cVar) {
        super(2, cVar);
        this.f6502b = z;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        s sVar = new s(this.f6502b, cVar);
        sVar.f6501a = obj;
        return sVar;
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        s sVar = (s) create((f4.c) obj, (f5.c) obj2);
        b5.a0 a0Var = b5.a0.f883a;
        sVar.invokeSuspend(a0Var);
        return a0Var;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        g5.a aVar = g5.a.f2984a;
        a.a.c0(obj);
        r4.d dVar = ((f4.c) this.f6501a).f2595f;
        r4.a aVar2 = x.f6526c;
        final boolean z = this.f6502b;
        dVar.a(aVar2, new p5.a() { // from class: z3.r
            @Override // p5.a
            public final Object invoke() {
                return Boolean.valueOf(z);
            }
        });
        return b5.a0.f883a;
    }
}
