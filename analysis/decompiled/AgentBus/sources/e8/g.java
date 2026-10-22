package e8;

import d7.b0;
import i8.a0;
import java.util.Collection;
import q7.w;
import q7.x;
import w7.t;

/* loaded from: classes.dex */
public final class g implements h8.c {

    /* renamed from: d, reason: collision with root package name */
    public static final e f3140d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ t[] f3141e;

    /* renamed from: f, reason: collision with root package name */
    public static final e9.c f3142f;

    /* renamed from: g, reason: collision with root package name */
    public static final e9.f f3143g;

    /* renamed from: h, reason: collision with root package name */
    public static final e9.b f3144h;

    /* renamed from: a, reason: collision with root package name */
    public final a0 f3145a;

    /* renamed from: b, reason: collision with root package name */
    public final p7.k f3146b = f.f3138h;

    /* renamed from: c, reason: collision with root package name */
    public final u9.i f3147c;

    static {
        x xVar = w.f8821a;
        f3141e = new t[]{xVar.f(new q7.p(xVar.b(g.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
        f3140d = new e();
        f3142f = c8.n.f2066k;
        e9.e eVar = c8.m.f2031c;
        e9.f fVarF = eVar.f();
        q7.k.d(fVarF, "cloneable.shortName()");
        f3143g = fVarF;
        f3144h = e9.b.j(eVar.g());
    }

    public g(u9.k kVar, a0 a0Var) {
        this.f3145a = a0Var;
        this.f3147c = new u9.i(kVar, new a8.e(2, this, kVar));
    }

    @Override // h8.c
    public final boolean a(e9.c cVar, e9.f fVar) {
        q7.k.e(cVar, "packageFqName");
        q7.k.e(fVar, "name");
        return fVar.equals(f3143g) && cVar.equals(f3142f);
    }

    @Override // h8.c
    public final Collection b(e9.c cVar) {
        q7.k.e(cVar, "packageFqName");
        if (!cVar.equals(f3142f)) {
            return b0.f2947f;
        }
        return ib.k.S((i8.k) n7.b.q(this.f3147c, f3141e[0]));
    }

    @Override // h8.c
    public final f8.e c(e9.b bVar) {
        q7.k.e(bVar, "classId");
        if (!bVar.equals(f3144h)) {
            return null;
        }
        return (i8.k) n7.b.q(this.f3147c, f3141e[0]);
    }
}
