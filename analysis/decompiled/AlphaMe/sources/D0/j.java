package D0;

/* loaded from: classes.dex */
public final class j extends h {
    public final boolean j(Object obj) {
        if (obj == null) {
            obj = h.f389g;
        }
        if (!h.f388f.h(this, null, obj)) {
            return false;
        }
        h.c(this);
        return true;
    }

    public final boolean k(Throwable th) {
        th.getClass();
        if (!h.f388f.h(this, null, new b(th))) {
            return false;
        }
        h.c(this);
        return true;
    }

    public final boolean l(D1.a aVar) {
        b bVar;
        aVar.getClass();
        Object obj = this.f390a;
        if (obj == null) {
            if (aVar.isDone()) {
                if (!h.f388f.h(this, null, h.f(aVar))) {
                    return false;
                }
                h.c(this);
            } else {
                e eVar = new e(this, aVar);
                if (h.f388f.h(this, null, eVar)) {
                    try {
                        aVar.a(eVar, i.f393a);
                    } catch (Throwable th) {
                        try {
                            bVar = new b(th);
                        } catch (Throwable unused) {
                            bVar = b.f370b;
                        }
                        h.f388f.h(this, eVar, bVar);
                    }
                } else {
                    obj = this.f390a;
                }
            }
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        aVar.cancel(((a) obj).f368a);
        return false;
    }
}
