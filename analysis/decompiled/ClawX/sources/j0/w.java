package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w extends h5.i implements p5.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3449a;

    /* renamed from: b, reason: collision with root package name */
    public int f3450b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ boolean f3451c;
    public final /* synthetic */ c0 d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3452e;

    /* renamed from: f, reason: collision with root package name */
    public Object f3453f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(c0 c0Var, int i8, f5.c cVar, int i9) {
        super(2, cVar);
        this.f3449a = i9;
        this.d = c0Var;
        this.f3452e = i8;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f3449a) {
            case 0:
                w wVar = new w(this.d, this.f3452e, cVar, 0);
                wVar.f3451c = ((Boolean) obj).booleanValue();
                return wVar;
            default:
                w wVar2 = new w(this.d, this.f3452e, cVar, 1);
                wVar2.f3451c = ((Boolean) obj).booleanValue();
                return wVar2;
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) {
        int i8 = this.f3449a;
        Boolean bool = (Boolean) obj;
        bool.booleanValue();
        f5.c cVar = (f5.c) obj2;
        switch (i8) {
        }
        return ((w) create(bool, cVar)).invokeSuspend(b5.a0.f883a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.w.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
