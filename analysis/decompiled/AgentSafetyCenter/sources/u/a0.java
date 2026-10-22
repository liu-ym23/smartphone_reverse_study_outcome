package u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13417c = 1;

    /* renamed from: f, reason: collision with root package name */
    public yb.u f13418f;

    /* renamed from: g, reason: collision with root package name */
    public yb.u f13419g;

    /* renamed from: h, reason: collision with root package name */
    public int f13420h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ t0 f13421j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(yb.u uVar, t0 t0Var, nb.c cVar) {
        super(2, cVar);
        this.f13419g = uVar;
        this.f13421j = t0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f13417c) {
            case 0:
                a0 a0Var = new a0(this.f13419g, this.f13421j, cVar);
                a0Var.i = obj;
                return a0Var;
            default:
                a0 a0Var2 = new a0(this.f13421j, cVar);
                a0Var2.i = obj;
                return a0Var2;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f13417c) {
            case 0:
                return ((a0) create((xb.l) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((a0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:35|36|(1:39)|(1:96)|15|90|42|(2:48|(2:50|(1:97)))(2:44|(2:46|93))) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d9, code lost:
    
        r1 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9 A[Catch: CancellationException -> 0x00d9, TryCatch #2 {CancellationException -> 0x00d9, blocks: (B:42:0x00c3, B:44:0x00c9, B:48:0x00db, B:50:0x00df), top: B:90:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00db A[Catch: CancellationException -> 0x00d9, TryCatch #2 {CancellationException -> 0x00d9, blocks: (B:42:0x00c3, B:44:0x00c9, B:48:0x00db, B:50:0x00df), top: B:90:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0089 -> B:20:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d6 -> B:20:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00dd -> B:20:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ea -> B:20:0x005d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00f8 -> B:12:0x002e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x014c -> B:80:0x014d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0151 -> B:82:0x0152). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.a0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(t0 t0Var, nb.c cVar) {
        super(2, cVar);
        this.f13421j = t0Var;
    }
}
