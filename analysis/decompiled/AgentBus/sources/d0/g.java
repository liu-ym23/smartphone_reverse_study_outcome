package d0;

import c7.r;
import fa.k;
import k.j0;
import p7.n;

/* loaded from: classes.dex */
public final class g extends i7.h implements n {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f2752g;

    /* renamed from: h, reason: collision with root package name */
    public long[] f2753h;

    /* renamed from: i, reason: collision with root package name */
    public int f2754i;

    /* renamed from: j, reason: collision with root package name */
    public int f2755j;

    /* renamed from: k, reason: collision with root package name */
    public int f2756k;

    /* renamed from: l, reason: collision with root package name */
    public int f2757l;

    /* renamed from: m, reason: collision with root package name */
    public long f2758m;

    /* renamed from: n, reason: collision with root package name */
    public int f2759n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f2760o;

    /* renamed from: p, reason: collision with root package name */
    public Object f2761p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f2762q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f2752g = i2;
        this.f2762q = obj;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f2752g) {
            case 0:
                g gVar = new g((h) this.f2762q, dVar, 0);
                gVar.f2760o = obj;
                return gVar;
            case 1:
                g gVar2 = new g((k.g) this.f2762q, dVar, 1);
                gVar2.f2760o = obj;
                return gVar2;
            case 2:
                g gVar3 = new g((k.g) this.f2762q, dVar, 2);
                gVar3.f2760o = obj;
                return gVar3;
            default:
                g gVar4 = new g((j0) this.f2762q, dVar, 3);
                gVar4.f2760o = obj;
                return gVar4;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        k kVar = (k) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f2752g) {
        }
        return ((g) create(kVar, dVar)).invokeSuspend(r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x006c -> B:23:0x00ae). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x006e -> B:16:0x007f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0085 -> B:20:0x00a5). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0104 -> B:45:0x0146). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0106 -> B:38:0x0117). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x011d -> B:42:0x013d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x01a5 -> B:68:0x01f8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01a7 -> B:60:0x01b9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x01ed -> B:65:0x01ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0255 -> B:85:0x0266). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x026c -> B:76:0x022c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0298 -> B:94:0x0299). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.g.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
