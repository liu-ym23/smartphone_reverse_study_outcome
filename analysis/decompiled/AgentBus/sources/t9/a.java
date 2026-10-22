package t9;

import java.util.Iterator;
import java.util.List;
import q7.w;
import q7.x;

/* loaded from: classes.dex */
public class a implements g8.j {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ w7.t[] f9788g;

    /* renamed from: f, reason: collision with root package name */
    public final u9.i f9789f;

    static {
        x xVar = w.f8821a;
        f9788g = new w7.t[]{xVar.f(new q7.p(xVar.b(a.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    }

    public a(u9.n nVar, p7.a aVar) {
        q7.k.e(nVar, "storageManager");
        this.f9789f = new u9.i((u9.k) nVar, aVar);
    }

    @Override // g8.j
    public final g8.c b(e9.c cVar) {
        return g8.i.findAnnotation(this, cVar);
    }

    @Override // g8.j
    public final boolean g(e9.c cVar) {
        return g8.i.hasAnnotation(this, cVar);
    }

    @Override // g8.j
    public boolean isEmpty() {
        return ((List) n7.b.q(this.f9789f, f9788g[0])).isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return ((List) n7.b.q(this.f9789f, f9788g[0])).iterator();
    }
}
