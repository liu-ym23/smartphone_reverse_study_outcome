package l0;

/* loaded from: classes.dex */
public final class j extends i7.h implements p7.n {

    /* renamed from: g, reason: collision with root package name */
    public long[] f5758g;

    /* renamed from: h, reason: collision with root package name */
    public int f5759h;

    /* renamed from: i, reason: collision with root package name */
    public int f5760i;

    /* renamed from: j, reason: collision with root package name */
    public int f5761j;

    /* renamed from: k, reason: collision with root package name */
    public /* synthetic */ Object f5762k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k f5763l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, g7.d dVar) {
        super(2, dVar);
        this.f5763l = kVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        j jVar = new j(this.f5763l, dVar);
        jVar.f5762k = obj;
        return jVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((j) create((fa.k) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0083 -> B:26:0x009a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c5 -> B:37:0x00c6). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
