package v4;

import ia.b0;
import o4.t1;

/* loaded from: classes.dex */
public final class d extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10397f;

    /* renamed from: g, reason: collision with root package name */
    public int f10398g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f10399h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ t1 f10400i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k f10401j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f10402k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(t1 t1Var, k kVar, Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10397f = i2;
        this.f10400i = t1Var;
        this.f10401j = kVar;
        this.f10402k = obj;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10397f) {
            case 0:
                d dVar2 = new d(this.f10400i, this.f10401j, this.f10402k, dVar, 0);
                dVar2.f10399h = obj;
                return dVar2;
            case 1:
                d dVar3 = new d(this.f10400i, this.f10401j, this.f10402k, dVar, 1);
                dVar3.f10399h = obj;
                return dVar3;
            default:
                d dVar4 = new d(this.f10400i, this.f10401j, this.f10402k, dVar, 2);
                dVar4.f10399h = obj;
                return dVar4;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10397f) {
        }
        return ((d) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc A[Catch: all -> 0x00ba, CancellationException -> 0x010d, TRY_ENTER, TryCatch #5 {CancellationException -> 0x010d, all -> 0x00ba, blocks: (B:41:0x00cc, B:44:0x00e4, B:45:0x00e9, B:34:0x00b6), top: B:86:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0036 -> B:16:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x010a -> B:30:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x018a -> B:59:0x0128). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.d.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
