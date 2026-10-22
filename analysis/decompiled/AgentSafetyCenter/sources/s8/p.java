package s8;

import java.time.ZoneId;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f11854c;

    /* renamed from: f, reason: collision with root package name */
    public int f11855f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f11856g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k8.b f11857h;
    public final /* synthetic */ t i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ List f11858j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Set f11859k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ZoneId f11860l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ n1 f11861m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ x.r f11862n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11863o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k0.c1 f11864p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(boolean z10, k8.b bVar, t tVar, List list, Set set, ZoneId zoneId, n1 n1Var, x.r rVar, k0.c1 c1Var, k0.c1 c1Var2, nb.c cVar) {
        super(2, cVar);
        this.f11856g = z10;
        this.f11857h = bVar;
        this.i = tVar;
        this.f11858j = list;
        this.f11859k = set;
        this.f11860l = zoneId;
        this.f11861m = n1Var;
        this.f11862n = rVar;
        this.f11863o = c1Var;
        this.f11864p = c1Var2;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new p(this.f11856g, this.f11857h, this.i, this.f11858j, this.f11859k, this.f11860l, this.f11861m, this.f11862n, this.f11863o, this.f11864p, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((p) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
    
        if (r11 == r0) goto L47;
     */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.p.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
