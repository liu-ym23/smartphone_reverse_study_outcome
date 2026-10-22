package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends pb.h implements xb.p {

    /* renamed from: f, reason: collision with root package name */
    public long[] f13662f;

    /* renamed from: g, reason: collision with root package name */
    public int f13663g;

    /* renamed from: h, reason: collision with root package name */
    public int f13664h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f13665j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ k f13666k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, nb.c cVar) {
        super(cVar);
        this.f13666k = kVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        j jVar = new j(this.f13666k, cVar);
        jVar.f13665j = obj;
        return jVar;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((gc.l) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:26:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c3 -> B:37:0x00c4). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
