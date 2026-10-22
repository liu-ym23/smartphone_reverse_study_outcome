package fa;

import d7.q;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import k.c0;
import k.d0;

/* loaded from: classes.dex */
public final class h implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3629f;

    /* renamed from: g, reason: collision with root package name */
    public int f3630g;

    /* renamed from: h, reason: collision with root package name */
    public Object f3631h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f3632i;

    public h(Object obj, Map map) {
        this.f3629f = 2;
        this.f3631h = obj;
        this.f3632i = map;
    }

    public void a() {
        Object objInvoke;
        i iVar = (i) this.f3632i;
        if (this.f3630g == -2) {
            objInvoke = ((p7.a) iVar.f3634b).c();
        } else {
            p7.k kVar = (p7.k) iVar.f3635c;
            Object obj = this.f3631h;
            q7.k.b(obj);
            objInvoke = kVar.invoke(obj);
        }
        this.f3631h = objInvoke;
        this.f3630g = objInvoke == null ? 0 : 1;
    }

    public void c() {
        Iterator it = (Iterator) this.f3632i;
        if (it.hasNext()) {
            Object next = it.next();
            f8.j jVar = (f8.j) next;
            q7.k.e(jVar, "it");
            if (jVar instanceof f8.b) {
                this.f3630g = 1;
                this.f3631h = next;
                return;
            }
        }
        this.f3630g = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3629f) {
            case 0:
                if (this.f3630g < 0) {
                    a();
                }
                return this.f3630g == 1;
            case 1:
                if (this.f3630g == -1) {
                    c();
                }
                return this.f3630g == 1;
            case 2:
                return this.f3630g < ((Map) this.f3632i).size();
            default:
                return ((k) this.f3631h).hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3629f) {
            case 0:
                if (this.f3630g < 0) {
                    a();
                }
                if (this.f3630g == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.f3631h;
                q7.k.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.f3630g = -1;
                return obj;
            case 1:
                if (this.f3630g == -1) {
                    c();
                }
                if (this.f3630g == 0) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.f3631h;
                this.f3631h = null;
                this.f3630g = -1;
                return obj2;
            case 2:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Object obj3 = this.f3631h;
                this.f3630g++;
                Object obj4 = ((Map) this.f3632i).get(obj3);
                if (obj4 != null) {
                    this.f3631h = ((h0.a) obj4).f4060b;
                    return obj3;
                }
                throw new ConcurrentModificationException("Hash code of an element (" + obj3 + ") has changed after it was added to the persistent set.");
            default:
                return ((k) this.f3631h).next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3629f) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                int i2 = this.f3630g;
                if (i2 != -1) {
                    ((d0) this.f3632i).f5476g.l(i2);
                    this.f3630g = -1;
                    return;
                }
                return;
        }
    }

    public h(q qVar) {
        this.f3629f = 1;
        this.f3632i = ((j) qVar.f2976b).iterator();
        this.f3630g = -1;
    }

    public h(i iVar) {
        this.f3629f = 0;
        this.f3632i = iVar;
        this.f3630g = -2;
    }

    public h(d0 d0Var) {
        this.f3629f = 3;
        this.f3632i = d0Var;
        this.f3630g = -1;
        this.f3631h = s7.a.F(new c0(d0Var, this, null));
    }
}
