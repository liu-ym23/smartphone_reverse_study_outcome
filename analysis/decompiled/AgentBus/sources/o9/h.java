package o9;

import d7.z;
import f8.l0;
import java.util.Collection;
import java.util.List;
import q7.w;
import q7.x;

/* loaded from: classes.dex */
public abstract class h extends o {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f7921d;

    /* renamed from: b, reason: collision with root package name */
    public final i8.b f7922b;

    /* renamed from: c, reason: collision with root package name */
    public final u9.i f7923c;

    static {
        x xVar = w.f8821a;
        f7921d = new w7.t[]{xVar.f(new q7.p(xVar.b(h.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    public h(u9.k kVar, i8.b bVar) {
        this.f7922b = bVar;
        this.f7923c = new u9.i(kVar, new a8.c(19, this));
    }

    @Override // o9.o, o9.n
    public final Collection a(e9.f fVar, n8.c cVar) {
        q7.k.e(fVar, "name");
        List list = (List) n7.b.q(this.f7923c, f7921d[0]);
        ea.f fVar2 = new ea.f();
        for (Object obj : list) {
            if ((obj instanceof l0) && q7.k.a(((l0) obj).getName(), fVar)) {
                fVar2.add(obj);
            }
        }
        return fVar2;
    }

    @Override // o9.o, o9.q
    public final Collection e(f fVar, p7.k kVar) {
        q7.k.e(fVar, "kindFilter");
        q7.k.e(kVar, "nameFilter");
        if (!fVar.a(f.f7911n.f7918b)) {
            return z.f2978f;
        }
        return (List) n7.b.q(this.f7923c, f7921d[0]);
    }

    @Override // o9.o, o9.q
    public final Collection f(e9.f fVar, n8.a aVar) {
        q7.k.e(fVar, "name");
        List list = (List) n7.b.q(this.f7923c, f7921d[0]);
        ea.f fVar2 = new ea.f();
        for (Object obj : list) {
            if ((obj instanceof i8.l0) && q7.k.a(((i8.l0) obj).getName(), fVar)) {
                fVar2.add(obj);
            }
        }
        return fVar2;
    }

    public abstract List h();
}
