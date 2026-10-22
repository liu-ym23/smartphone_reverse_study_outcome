package t3;

import B3.k;
import Z2.I;
import h3.C0611u;
import y3.j;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f15443a;

    public c(a aVar) {
        this.f15443a = aVar;
    }

    public final c a(f fVar) {
        int i4 = B3.f.f227b;
        if (this instanceof k) {
            return ((k) this).e(fVar);
        }
        a cVar = new y3.c(this.f15443a, new j(fVar, i4), 0);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (a) c0611u.call(cVar);
        }
        return new c(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [D3.a] */
    public final h b(x3.b bVar, x3.b bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        B3.a aVar = new B3.a(bVar, bVar2);
        a aVar2 = this.f15443a;
        if (aVar2 == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        if (!(aVar instanceof D3.a)) {
            aVar = new D3.a(aVar);
        }
        try {
            E3.c.c(this, aVar2);
            aVar2.call(aVar);
            C0611u c0611u = E3.c.f416e;
            return c0611u != null ? (h) c0611u.call(aVar) : aVar;
        } catch (Throwable th) {
            I.D(th);
            if (aVar.f15444a.a()) {
                E3.c.a(E3.c.b(th));
            } else {
                try {
                    aVar.f(E3.c.b(th));
                } catch (Throwable th2) {
                    I.D(th2);
                    w3.d dVar = new w3.d("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    E3.c.b(dVar);
                    throw dVar;
                }
            }
            return G3.f.f653a;
        }
    }

    public final c c(f fVar) {
        if (this instanceof k) {
            return ((k) this).e(fVar);
        }
        a cVar = new y3.c(this, fVar);
        C0611u c0611u = E3.c.f413b;
        if (c0611u != null) {
            cVar = (a) c0611u.call(cVar);
        }
        return new c(cVar);
    }

    public final void d(g gVar) {
        try {
            a aVar = this.f15443a;
            E3.c.c(this, aVar);
            aVar.call(gVar);
            C0611u c0611u = E3.c.f416e;
            if (c0611u != null) {
            }
        } catch (Throwable th) {
            I.D(th);
            try {
                gVar.f(E3.c.b(th));
            } catch (Throwable th2) {
                I.D(th2);
                w3.d dVar = new w3.d("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                E3.c.b(dVar);
                throw dVar;
            }
        }
    }
}
