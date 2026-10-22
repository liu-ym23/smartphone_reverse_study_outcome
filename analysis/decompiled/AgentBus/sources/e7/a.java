package e7;

import i1.p;
import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import k.z;
import l0.q;
import l0.r;
import n0.l;
import q7.k;

/* loaded from: classes.dex */
public final class a implements ListIterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3076f;

    /* renamed from: g, reason: collision with root package name */
    public int f3077g;

    /* renamed from: h, reason: collision with root package name */
    public int f3078h;

    /* renamed from: i, reason: collision with root package name */
    public int f3079i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f3080j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(p pVar, int i2, int i10) {
        this(pVar, (i10 & 1) != 0 ? 0 : i2, 0, pVar.f4559f.f5557b);
        this.f3076f = 2;
    }

    public void a() {
        if (((AbstractList) ((b) this.f3080j).f3085j).modCount != this.f3079i) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f3076f) {
            case 0:
                a();
                b bVar = (b) this.f3080j;
                int i2 = this.f3077g;
                this.f3077g = i2 + 1;
                bVar.add(i2, obj);
                this.f3078h = -1;
                this.f3079i = ((AbstractList) bVar).modCount;
                return;
            case 1:
                c();
                c cVar = (c) this.f3080j;
                int i10 = this.f3077g;
                this.f3077g = i10 + 1;
                cVar.add(i10, obj);
                this.f3078h = -1;
                this.f3079i = ((AbstractList) cVar).modCount;
                return;
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                d();
                q qVar = (q) this.f3080j;
                qVar.add(this.f3077g + 1, obj);
                this.f3078h = -1;
                this.f3077g++;
                this.f3079i = r.e(qVar);
                return;
        }
    }

    public void c() {
        if (((AbstractList) ((c) this.f3080j)).modCount != this.f3079i) {
            throw new ConcurrentModificationException();
        }
    }

    public void d() {
        if (r.e((q) this.f3080j) != this.f3079i) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3076f) {
            case 0:
                return this.f3077g < ((b) this.f3080j).f3083h;
            case 1:
                return this.f3077g < ((c) this.f3080j).f3088g;
            case 2:
                return this.f3077g < this.f3079i;
            default:
                return this.f3077g < ((q) this.f3080j).size() - 1;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f3076f) {
            case 0:
                if (this.f3077g > 0) {
                }
                break;
            case 1:
                if (this.f3077g > 0) {
                }
                break;
            case 2:
                if (this.f3077g > this.f3078h) {
                }
                break;
            default:
                if (this.f3077g >= 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f3076f) {
            case 0:
                a();
                int i2 = this.f3077g;
                b bVar = (b) this.f3080j;
                if (i2 >= bVar.f3083h) {
                    throw new NoSuchElementException();
                }
                this.f3077g = i2 + 1;
                this.f3078h = i2;
                return bVar.f3081f[bVar.f3082g + i2];
            case 1:
                c();
                int i10 = this.f3077g;
                c cVar = (c) this.f3080j;
                if (i10 >= cVar.f3088g) {
                    throw new NoSuchElementException();
                }
                this.f3077g = i10 + 1;
                this.f3078h = i10;
                return cVar.f3087f[i10];
            case 2:
                z zVar = ((p) this.f3080j).f4559f;
                int i11 = this.f3077g;
                this.f3077g = i11 + 1;
                Object objE = zVar.e(i11);
                k.c(objE, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
                return (l) objE;
            default:
                d();
                int i12 = this.f3077g + 1;
                this.f3078h = i12;
                q qVar = (q) this.f3080j;
                r.a(i12, qVar.size());
                Object obj = qVar.get(i12);
                this.f3077g = i12;
                return obj;
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f3076f) {
            case 0:
                return this.f3077g;
            case 1:
                return this.f3077g;
            case 2:
                return this.f3077g - this.f3078h;
            default:
                return this.f3077g + 1;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f3076f) {
            case 0:
                a();
                int i2 = this.f3077g;
                if (i2 <= 0) {
                    throw new NoSuchElementException();
                }
                int i10 = i2 - 1;
                this.f3077g = i10;
                this.f3078h = i10;
                b bVar = (b) this.f3080j;
                return bVar.f3081f[bVar.f3082g + i10];
            case 1:
                c();
                int i11 = this.f3077g;
                if (i11 <= 0) {
                    throw new NoSuchElementException();
                }
                int i12 = i11 - 1;
                this.f3077g = i12;
                this.f3078h = i12;
                return ((c) this.f3080j).f3087f[i12];
            case 2:
                z zVar = ((p) this.f3080j).f4559f;
                int i13 = this.f3077g - 1;
                this.f3077g = i13;
                Object objE = zVar.e(i13);
                k.c(objE, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
                return (l) objE;
            default:
                d();
                int i14 = this.f3077g;
                q qVar = (q) this.f3080j;
                r.a(i14, qVar.size());
                int i15 = this.f3077g;
                this.f3078h = i15;
                this.f3077g--;
                return qVar.get(i15);
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i2;
        switch (this.f3076f) {
            case 0:
                i2 = this.f3077g;
                break;
            case 1:
                i2 = this.f3077g;
                break;
            case 2:
                return (this.f3077g - this.f3078h) - 1;
            default:
                return this.f3077g;
        }
        return i2 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f3076f) {
            case 0:
                b bVar = (b) this.f3080j;
                a();
                int i2 = this.f3078h;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                bVar.f(i2);
                this.f3077g = this.f3078h;
                this.f3078h = -1;
                this.f3079i = ((AbstractList) bVar).modCount;
                return;
            case 1:
                c cVar = (c) this.f3080j;
                c();
                int i10 = this.f3078h;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                cVar.f(i10);
                this.f3077g = this.f3078h;
                this.f3078h = -1;
                this.f3079i = ((AbstractList) cVar).modCount;
                return;
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                d();
                q qVar = (q) this.f3080j;
                qVar.remove(this.f3078h);
                this.f3077g--;
                this.f3078h = -1;
                this.f3079i = r.e(qVar);
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f3076f) {
            case 0:
                a();
                int i2 = this.f3078h;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((b) this.f3080j).set(i2, obj);
                return;
            case 1:
                c();
                int i10 = this.f3078h;
                if (i10 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((c) this.f3080j).set(i10, obj);
                return;
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                q qVar = (q) this.f3080j;
                d();
                int i11 = this.f3078h;
                if (i11 < 0) {
                    throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
                }
                qVar.set(i11, obj);
                this.f3079i = r.e(qVar);
                return;
        }
    }

    public a(c cVar, int i2) {
        this.f3076f = 1;
        this.f3080j = cVar;
        this.f3077g = i2;
        this.f3078h = -1;
        this.f3079i = ((AbstractList) cVar).modCount;
    }

    public a(q qVar, int i2) {
        this.f3076f = 3;
        this.f3080j = qVar;
        this.f3077g = i2 - 1;
        this.f3078h = -1;
        this.f3079i = r.e(qVar);
    }

    public a(p pVar, int i2, int i10, int i11) {
        this.f3076f = 2;
        this.f3080j = pVar;
        this.f3077g = i2;
        this.f3078h = i10;
        this.f3079i = i11;
    }

    public a(b bVar, int i2) {
        this.f3076f = 0;
        this.f3080j = bVar;
        this.f3077g = i2;
        this.f3078h = -1;
        this.f3079i = ((AbstractList) bVar).modCount;
    }
}
