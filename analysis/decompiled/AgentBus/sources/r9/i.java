package r9;

import f8.e0;
import f8.h0;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final u9.k f9047a;

    /* renamed from: b, reason: collision with root package name */
    public final f8.z f9048b;

    /* renamed from: c, reason: collision with root package name */
    public final j f9049c;

    /* renamed from: d, reason: collision with root package name */
    public final e f9050d;

    /* renamed from: e, reason: collision with root package name */
    public final a f9051e;

    /* renamed from: f, reason: collision with root package name */
    public final h0 f9052f;

    /* renamed from: g, reason: collision with root package name */
    public final j f9053g;

    /* renamed from: h, reason: collision with root package name */
    public final l f9054h;

    /* renamed from: i, reason: collision with root package name */
    public final n8.b f9055i;

    /* renamed from: j, reason: collision with root package name */
    public final m f9056j;

    /* renamed from: k, reason: collision with root package name */
    public final Iterable f9057k;

    /* renamed from: l, reason: collision with root package name */
    public final i5.f f9058l;

    /* renamed from: m, reason: collision with root package name */
    public final j f9059m;

    /* renamed from: n, reason: collision with root package name */
    public final h8.b f9060n;

    /* renamed from: o, reason: collision with root package name */
    public final h8.d f9061o;

    /* renamed from: p, reason: collision with root package name */
    public final f9.h f9062p;

    /* renamed from: q, reason: collision with root package name */
    public final w9.l f9063q;

    /* renamed from: r, reason: collision with root package name */
    public final h8.a f9064r;

    /* renamed from: s, reason: collision with root package name */
    public final List f9065s;

    /* renamed from: t, reason: collision with root package name */
    public final g f9066t;

    public i(u9.k kVar, f8.z zVar, e eVar, a aVar, h0 h0Var, l lVar, m mVar, Iterable iterable, i5.f fVar, h8.b bVar, h8.d dVar, f9.h hVar, w9.l lVar2, h4.n nVar, List list, int i2) {
        w9.l lVar3;
        j jVar = j.f9067b;
        j jVar2 = j.f9069d;
        if ((i2 & 65536) != 0) {
            w9.l.f10948b.getClass();
            lVar3 = w9.k.f10947b;
        } else {
            lVar3 = lVar2;
        }
        h8.a aVar2 = h8.a.f4225e;
        List listS = (i2 & 524288) != 0 ? a.a.S(v9.k.f10563a) : list;
        q7.k.e(zVar, "moduleDescriptor");
        q7.k.e(hVar, "extensionRegistryLite");
        q7.k.e(lVar3, "kotlinTypeChecker");
        this.f9047a = kVar;
        this.f9048b = zVar;
        this.f9049c = jVar;
        this.f9050d = eVar;
        this.f9051e = aVar;
        this.f9052f = h0Var;
        this.f9053g = jVar2;
        this.f9054h = lVar;
        this.f9055i = n8.b.f6876a;
        this.f9056j = mVar;
        this.f9057k = iterable;
        this.f9058l = fVar;
        this.f9059m = h.f9046a;
        this.f9060n = bVar;
        this.f9061o = dVar;
        this.f9062p = hVar;
        this.f9063q = lVar3;
        this.f9064r = aVar2;
        this.f9065s = listS;
        this.f9066t = new g(this);
    }

    public final k a(e0 e0Var, b9.f fVar, b9.g gVar, b9.h hVar, b9.a aVar, t9.j jVar) {
        q7.k.e(fVar, "nameResolver");
        q7.k.e(aVar, "metadataVersion");
        return new k(this, fVar, e0Var, gVar, hVar, aVar, jVar, null, d7.z.f2978f);
    }

    public final f8.e b(e9.b bVar) {
        q7.k.e(bVar, "classId");
        Set set = g.f9043c;
        return this.f9066t.a(bVar, null);
    }
}
