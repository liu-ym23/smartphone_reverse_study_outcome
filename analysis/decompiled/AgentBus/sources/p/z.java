package p;

/* loaded from: classes.dex */
public final class z extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8226f = 1;

    /* renamed from: g, reason: collision with root package name */
    public q7.v f8227g;

    /* renamed from: h, reason: collision with root package name */
    public q7.v f8228h;

    /* renamed from: i, reason: collision with root package name */
    public int f8229i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f8230j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ s0 f8231k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(s0 s0Var, g7.d dVar) {
        super(2, dVar);
        this.f8231k = s0Var;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8226f) {
            case 0:
                z zVar = new z(this.f8228h, this.f8231k, dVar);
                zVar.f8230j = obj;
                return zVar;
            default:
                z zVar2 = new z(this.f8231k, dVar);
                zVar2.f8230j = obj;
                return zVar2;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f8226f) {
            case 0:
                return ((z) create((p7.k) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((z) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:36|37|(1:40)|(1:97)|16|92|43|(2:49|(2:51|(1:98)))(2:45|(2:47|94))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d7, code lost:
    
        r1 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c7 A[Catch: CancellationException -> 0x00d7, TryCatch #2 {CancellationException -> 0x00d7, blocks: (B:43:0x00c1, B:45:0x00c7, B:49:0x00d9, B:51:0x00dd), top: B:92:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9 A[Catch: CancellationException -> 0x00d7, TryCatch #2 {CancellationException -> 0x00d7, blocks: (B:43:0x00c1, B:45:0x00c7, B:49:0x00d9, B:51:0x00dd), top: B:92:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008a -> B:21:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00d4 -> B:21:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00db -> B:21:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e8 -> B:21:0x005e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00f6 -> B:13:0x002f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x014b -> B:82:0x014c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0150 -> B:84:0x0151). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.z.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(q7.v vVar, s0 s0Var, g7.d dVar) {
        super(2, dVar);
        this.f8228h = vVar;
        this.f8231k = s0Var;
    }
}
