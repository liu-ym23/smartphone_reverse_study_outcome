package i9;

import D7.t;
import h8.InterfaceC1519b;
import h8.InterfaceC1527j;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class h implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4622a;
    public int b;
    public Object c;
    public final Object d;

    public h(m mVar) {
        this.f4622a = 1;
        this.d = mVar;
        this.c = mVar.f4625a.iterator();
    }

    public void a() {
        Object objInvoke;
        O7.h hVar = (O7.h) this.d;
        if (this.b == -2) {
            objInvoke = ((S7.a) hVar.b).invoke();
        } else {
            S7.k kVar = (S7.k) hVar.c;
            Object obj = this.c;
            kotlin.jvm.internal.k.c(obj);
            objInvoke = kVar.invoke(obj);
        }
        this.c = objInvoke;
        this.b = objInvoke == null ? 0 : 1;
    }

    public void b() {
        Iterator it = (Iterator) this.d;
        if (it.hasNext()) {
            Object next = it.next();
            InterfaceC1527j it2 = (InterfaceC1527j) next;
            kotlin.jvm.internal.k.f(it2, "it");
            if (it2 instanceof InterfaceC1519b) {
                this.b = 1;
                this.c = next;
                return;
            }
        }
        this.b = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4622a) {
            case 0:
                if (this.b < 0) {
                    a();
                }
                if (this.b == 1) {
                }
                break;
            case 1:
                m mVar = (m) this.d;
                Iterator it = (Iterator) this.c;
                while (this.b < mVar.b && it.hasNext()) {
                    it.next();
                    this.b++;
                }
                if (this.b >= mVar.c || !it.hasNext()) {
                }
                break;
            default:
                if (this.b == -1) {
                    b();
                }
                if (this.b == 1) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4622a) {
            case 0:
                if (this.b < 0) {
                    a();
                }
                if (this.b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.c;
                kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.b = -1;
                return obj;
            case 1:
                m mVar = (m) this.d;
                Iterator it = (Iterator) this.c;
                while (this.b < mVar.b && it.hasNext()) {
                    it.next();
                    this.b++;
                }
                int i = this.b;
                if (i >= mVar.c) {
                    throw new NoSuchElementException();
                }
                this.b = i + 1;
                return it.next();
            default:
                if (this.b == -1) {
                    b();
                }
                if (this.b == 0) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.c;
                this.c = null;
                this.b = -1;
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4622a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public h(t tVar) {
        this.f4622a = 2;
        this.d = ((i) tVar.b).iterator();
        this.b = -1;
    }

    public h(O7.h hVar) {
        this.f4622a = 0;
        this.d = hVar;
        this.b = -2;
    }
}
