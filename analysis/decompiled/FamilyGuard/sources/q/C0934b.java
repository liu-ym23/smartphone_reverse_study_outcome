package q;

import W3.C0396g;
import W3.C0403n;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import k4.InterfaceC0815b;
import r.C0990a;

/* renamed from: q.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0934b<E> implements Collection<E>, Set<E>, InterfaceC0815b {

    /* renamed from: a, reason: collision with root package name */
    private int[] f19622a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f19623b;

    /* renamed from: c, reason: collision with root package name */
    private int f19624c;

    /* renamed from: q.b$a */
    private final class a extends AbstractC0937e<E> {
        public a() {
            super(C0934b.this.i());
        }

        @Override // q.AbstractC0937e
        protected E b(int i5) {
            return C0934b.this.q(i5);
        }

        @Override // q.AbstractC0937e
        protected void c(int i5) {
            C0934b.this.m(i5);
        }
    }

    public C0934b() {
        this(0, 1, null);
    }

    public final void a(int i5) {
        int i6 = i();
        if (f().length < i5) {
            int[] iArrF = f();
            Object[] objArrC = c();
            C0936d.a(this, i5);
            if (i() > 0) {
                C0396g.g(iArrF, f(), 0, 0, i(), 6, null);
                C0396g.h(objArrC, c(), 0, 0, i(), 6, null);
            }
        }
        if (i() != i6) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e6) {
        int i5;
        int iC;
        int i6 = i();
        if (e6 == null) {
            iC = C0936d.d(this);
            i5 = 0;
        } else {
            int iHashCode = e6.hashCode();
            i5 = iHashCode;
            iC = C0936d.c(this, e6, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i7 = ~iC;
        if (i6 >= f().length) {
            int i8 = 8;
            if (i6 >= 8) {
                i8 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i8 = 4;
            }
            int[] iArrF = f();
            Object[] objArrC = c();
            C0936d.a(this, i8);
            if (i6 != i()) {
                throw new ConcurrentModificationException();
            }
            if (!(f().length == 0)) {
                C0396g.g(iArrF, f(), 0, 0, iArrF.length, 6, null);
                C0396g.h(objArrC, c(), 0, 0, objArrC.length, 6, null);
            }
        }
        if (i7 < i6) {
            int i9 = i7 + 1;
            C0396g.d(f(), f(), i9, i7, i6);
            C0396g.f(c(), c(), i9, i7, i6);
        }
        if (i6 != i() || i7 >= f().length) {
            throw new ConcurrentModificationException();
        }
        f()[i7] = i5;
        c()[i7] = e6;
        p(i() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        j4.k.g(collection, "elements");
        a(i() + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object[] c() {
        return this.f19623b;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (i() != 0) {
            o(C0990a.f19951a);
            n(C0990a.f19953c);
            p(0);
        }
        if (i() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        j4.k.g(collection, "elements");
        Iterator<? extends Object> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i5 = i();
            for (int i6 = 0; i6 < i5; i6++) {
                if (!((Set) obj).contains(q(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final int[] f() {
        return this.f19622a;
    }

    public int h() {
        return this.f19624c;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrF = f();
        int i5 = i();
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += iArrF[i7];
        }
        return i6;
    }

    public final int i() {
        return this.f19624c;
    }

    public final int indexOf(Object obj) {
        return obj == null ? C0936d.d(this) : C0936d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return i() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    public final E m(int i5) {
        int i6;
        Object[] objArr;
        int i7 = i();
        E e6 = (E) c()[i5];
        if (i7 <= 1) {
            clear();
            return e6;
        }
        int i8 = i7 - 1;
        if (f().length <= 8 || i() >= f().length / 3) {
            if (i5 < i8) {
                int i9 = i5 + 1;
                C0396g.d(f(), f(), i5, i9, i7);
                C0396g.f(c(), c(), i5, i9, i7);
            }
            c()[i8] = null;
        } else {
            int i10 = i() > 8 ? i() + (i() >> 1) : 8;
            int[] iArrF = f();
            Object[] objArrC = c();
            C0936d.a(this, i10);
            if (i5 > 0) {
                C0396g.g(iArrF, f(), 0, 0, i5, 6, null);
                objArr = objArrC;
                C0396g.h(objArr, c(), 0, 0, i5, 6, null);
                i6 = i5;
            } else {
                i6 = i5;
                objArr = objArrC;
            }
            if (i6 < i8) {
                int i11 = i6 + 1;
                C0396g.d(iArrF, f(), i6, i11, i7);
                C0396g.f(objArr, c(), i6, i11, i7);
            }
        }
        if (i7 != i()) {
            throw new ConcurrentModificationException();
        }
        p(i8);
        return e6;
    }

    public final void n(Object[] objArr) {
        j4.k.g(objArr, "<set-?>");
        this.f19623b = objArr;
    }

    public final void o(int[] iArr) {
        j4.k.g(iArr, "<set-?>");
        this.f19622a = iArr;
    }

    public final void p(int i5) {
        this.f19624c = i5;
    }

    public final E q(int i5) {
        return (E) c()[i5];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        m(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        j4.k.g(collection, "elements");
        Iterator<? extends Object> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        j4.k.g(collection, "elements");
        boolean z5 = false;
        for (int i5 = i() - 1; -1 < i5; i5--) {
            if (!C0403n.x(collection, c()[i5])) {
                m(i5);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return h();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return C0396g.i(this.f19623b, 0, this.f19624c);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i() * 14);
        sb.append('{');
        int i5 = i();
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E eQ = q(i6);
            if (eQ != this) {
                sb.append(eQ);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        j4.k.f(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public C0934b(int i5) {
        this.f19622a = C0990a.f19951a;
        this.f19623b = C0990a.f19953c;
        if (i5 > 0) {
            C0936d.a(this, i5);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        j4.k.g(tArr, "array");
        T[] tArr2 = (T[]) C0935c.a(tArr, this.f19624c);
        C0396g.f(this.f19623b, tArr2, 0, 0, this.f19624c);
        j4.k.f(tArr2, "result");
        return tArr2;
    }

    public /* synthetic */ C0934b(int i5, int i6, j4.g gVar) {
        this((i6 & 1) != 0 ? 0 : i5);
    }
}
