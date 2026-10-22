package o9;

import f8.l0;
import java.util.Collection;
import java.util.List;
import q7.w;
import q7.x;

/* loaded from: classes.dex */
public final class s extends o {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f7937e;

    /* renamed from: b, reason: collision with root package name */
    public final t9.i f7938b;

    /* renamed from: c, reason: collision with root package name */
    public final u9.i f7939c;

    /* renamed from: d, reason: collision with root package name */
    public final u9.i f7940d;

    static {
        x xVar = w.f8821a;
        f7937e = new w7.t[]{xVar.f(new q7.p(xVar.b(s.class), "functions", "getFunctions()Ljava/util/List;")), xVar.f(new q7.p(xVar.b(s.class), "properties", "getProperties()Ljava/util/List;"))};
    }

    public s(u9.k kVar, t9.i iVar) {
        q7.k.e(kVar, "storageManager");
        this.f7938b = iVar;
        this.f7939c = new u9.i(kVar, new r(this, 0));
        this.f7940d = new u9.i(kVar, new r(this, 1));
    }

    @Override // o9.o, o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        List list = (List) n7.b.q(this.f7940d, f7937e[1]);
        ea.f fVar2 = new ea.f();
        for (Object obj : list) {
            if (q7.k.a(((l0) obj).getName(), fVar)) {
                fVar2.add(obj);
            }
        }
        return fVar2;
    }

    @Override // o9.o, o9.q
    public final f8.g b(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        q7.k.e(aVar, "location");
        return null;
    }

    @Override // o9.o, o9.q
    public final Collection e(f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        w7.t[] tVarArr = f7937e;
        return d7.r.c1((List) n7.b.q(this.f7939c, tVarArr[0]), (List) n7.b.q(this.f7940d, tVarArr[1]));
    }

    @Override // o9.o, o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        List list = (List) n7.b.q(this.f7939c, f7937e[0]);
        ea.f fVar2 = new ea.f();
        for (Object obj : list) {
            if (q7.k.a(((i8.l0) obj).getName(), fVar)) {
                fVar2.add(obj);
            }
        }
        return fVar2;
    }
}
