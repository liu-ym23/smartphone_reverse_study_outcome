package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends h5.i implements p5.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6460a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f6461b;

    /* renamed from: c, reason: collision with root package name */
    public a6.f0 f6462c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6463e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f6464f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f6465g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Long l3, Long l6, Long l8, f5.c cVar) {
        super(3, cVar);
        this.f6463e = l3;
        this.f6464f = l6;
        this.f6465g = l8;
    }

    @Override // p5.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f6460a) {
            case 0:
                j jVar = new j((t3.c) this.f6465g, (f5.c) obj3);
                jVar.d = (v4.f) obj;
                jVar.f6464f = (h4.d) obj2;
                return jVar.invokeSuspend(b5.a0.f883a);
            default:
                j jVar2 = new j((Long) this.f6463e, (Long) this.f6464f, (Long) this.f6465g, (f5.c) obj3);
                jVar2.f6462c = (a4.g) obj;
                jVar2.d = (f4.c) obj2;
                return jVar2.invokeSuspend(b5.a0.f883a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x024f  */
    /* JADX WARN: Type inference failed for: r7v12, types: [h4.d] */
    /* JADX WARN: Type inference failed for: r7v14, types: [h4.d] */
    /* JADX WARN: Type inference failed for: r7v16, types: [h4.d] */
    /* JADX WARN: Type inference failed for: r7v20, types: [h4.d] */
    /* JADX WARN: Type inference failed for: r7v4, types: [h4.d] */
    /* JADX WARN: Type inference failed for: r7v6, types: [h4.d] */
    /* JADX WARN: Type inference failed for: r7v8, types: [h4.d] */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(t3.c cVar, f5.c cVar2) {
        super(3, cVar2);
        this.f6465g = cVar;
    }
}
