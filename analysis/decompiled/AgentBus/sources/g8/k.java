package g8;

import d7.r;
import d7.y;
import f8.f0;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k implements j {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3889f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3890g;

    public /* synthetic */ k(int i2, List list) {
        this.f3889f = i2;
        this.f3890g = list;
    }

    @Override // g8.j
    public final c b(e9.c cVar) {
        switch (this.f3889f) {
            case 0:
                return i.findAnnotation(this, cVar);
            case 1:
                q7.k.e(cVar, "fqName");
                fa.e eVar = new fa.e(fa.l.u0(r.H0((List) this.f3890g), new f0(cVar, 1)));
                return (c) (!eVar.hasNext() ? null : eVar.next());
            default:
                q7.k.e(cVar, "fqName");
                if (cVar.equals((e9.c) this.f3890g)) {
                    return w8.b.f10885a;
                }
                return null;
        }
    }

    @Override // g8.j
    public final boolean g(e9.c cVar) {
        switch (this.f3889f) {
            case 1:
                q7.k.e(cVar, "fqName");
                Iterator it = ((Iterable) r.H0((List) this.f3890g).f2976b).iterator();
                while (it.hasNext()) {
                    if (((j) it.next()).g(cVar)) {
                        break;
                    }
                }
                break;
        }
        return i.hasAnnotation(this, cVar);
    }

    @Override // g8.j
    public final boolean isEmpty() {
        switch (this.f3889f) {
            case 0:
                return ((List) this.f3890g).isEmpty();
            case 1:
                List list = (List) this.f3890g;
                if (list != null && list.isEmpty()) {
                    return true;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((j) it.next()).isEmpty()) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f3889f) {
            case 0:
                return ((List) this.f3890g).iterator();
            case 1:
                return new fa.e(new fa.g(r.H0((List) this.f3890g), m.f3895g, fa.n.f3639n));
            default:
                return y.f2977f;
        }
    }

    public String toString() {
        switch (this.f3889f) {
            case 0:
                return ((List) this.f3890g).toString();
            default:
                return super.toString();
        }
    }

    public k(j[] jVarArr) {
        this.f3889f = 1;
        this.f3890g = d7.n.w0(jVarArr);
    }

    public k(e9.c cVar) {
        this.f3889f = 2;
        q7.k.e(cVar, "fqNameToMatch");
        this.f3890g = cVar;
    }
}
