package p8;

import d7.a0;
import d7.r;
import f8.n0;
import java.util.Map;
import q7.k;
import q7.p;
import q7.w;
import q7.x;
import u9.n;
import v9.v;
import v9.z;
import w7.t;

/* loaded from: classes.dex */
public class b implements g8.c, q8.g {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ t[] f8503e;

    /* renamed from: a, reason: collision with root package name */
    public final e9.c f8504a;

    /* renamed from: b, reason: collision with root package name */
    public final n0 f8505b;

    /* renamed from: c, reason: collision with root package name */
    public final u9.i f8506c;

    /* renamed from: d, reason: collision with root package name */
    public final v8.a f8507d;

    static {
        x xVar = w.f8821a;
        f8503e = new t[]{xVar.f(new p(xVar.b(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    }

    public b(a3.b bVar, l8.e eVar, e9.c cVar) {
        k.e(bVar, "c");
        r8.a aVar = (r8.a) bVar.f162f;
        k.e(cVar, "fqName");
        this.f8504a = cVar;
        this.f8505b = eVar != null ? aVar.f9011j.c(eVar) : n0.f3487b;
        n nVar = aVar.f9002a;
        a8.e eVar2 = new a8.e(12, bVar, this);
        u9.k kVar = (u9.k) nVar;
        kVar.getClass();
        this.f8506c = new u9.i(kVar, eVar2);
        this.f8507d = eVar != null ? (v8.a) r.O0(eVar.b()) : null;
    }

    @Override // g8.c
    public final e9.c a() {
        return this.f8504a;
    }

    @Override // g8.c
    public Map b() {
        return a0.f2944f;
    }

    @Override // g8.c
    public final v getType() {
        return (z) n7.b.q(this.f8506c, f8503e[0]);
    }

    @Override // g8.c
    public final n0 q() {
        return this.f8505b;
    }
}
