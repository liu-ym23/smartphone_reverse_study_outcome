package m8;

import android.content.res.Resources;
import java.util.List;
import u.t0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8410c = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f8411f;

    /* renamed from: g, reason: collision with root package name */
    public Object f8412g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8413h;
    public Object i;

    /* renamed from: j, reason: collision with root package name */
    public Object f8414j;

    /* renamed from: k, reason: collision with root package name */
    public Object f8415k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f8416l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f8417m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f8418n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(t0 t0Var, o1.w wVar, u.w wVar2, b0.n nVar, u.v vVar, u.v vVar2, h0.k kVar, nb.c cVar) {
        super(2, cVar);
        this.f8413h = t0Var;
        this.i = wVar;
        this.f8414j = wVar2;
        this.f8415k = nVar;
        this.f8416l = vVar;
        this.f8417m = vVar2;
        this.f8418n = kVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f8410c) {
            case 0:
                return new k((List) this.f8416l, (k0) this.f8417m, (Resources) this.f8418n, cVar);
            default:
                k kVar = new k((t0) this.f8413h, (o1.w) this.i, (u.w) this.f8414j, (b0.n) this.f8415k, (u.v) this.f8416l, (u.v) this.f8417m, (h0.k) this.f8418n, cVar);
                kVar.f8412g = obj;
                return kVar;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f8410c) {
        }
        return ((k) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0107 -> B:47:0x010c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0119 -> B:51:0x011a). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m8.k.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(List list, k0 k0Var, Resources resources, nb.c cVar) {
        super(2, cVar);
        this.f8416l = list;
        this.f8417m = k0Var;
        this.f8418n = resources;
    }
}
