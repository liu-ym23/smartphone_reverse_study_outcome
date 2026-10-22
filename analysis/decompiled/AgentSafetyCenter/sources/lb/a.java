package lb;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import p.a0;
import u0.q;
import u0.r;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements ListIterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7822c;

    /* renamed from: f, reason: collision with root package name */
    public int f7823f;

    /* renamed from: g, reason: collision with root package name */
    public int f7824g;

    /* renamed from: h, reason: collision with root package name */
    public int f7825h;
    public Object i;

    public a(q qVar, int i) {
        this.f7822c = 2;
        this.i = qVar;
        this.f7823f = i - 1;
        this.f7824g = -1;
        this.f7825h = r.f(qVar);
    }

    public void a() {
        if (((AbstractList) ((b) this.i).i).modCount != this.f7825h) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f7822c) {
            case 0:
                a();
                b bVar = (b) this.i;
                int i = this.f7823f;
                this.f7823f = i + 1;
                bVar.add(i, obj);
                this.f7824g = -1;
                this.f7825h = ((AbstractList) bVar).modCount;
                return;
            case 1:
                b();
                c cVar = (c) this.i;
                int i3 = this.f7823f;
                this.f7823f = i3 + 1;
                cVar.add(i3, obj);
                this.f7824g = -1;
                this.f7825h = ((AbstractList) cVar).modCount;
                return;
            case 2:
                c();
                q qVar = (q) this.i;
                qVar.add(this.f7823f + 1, obj);
                this.f7824g = -1;
                this.f7823f++;
                this.f7825h = r.f(qVar);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public void b() {
        if (((AbstractList) ((c) this.i)).modCount != this.f7825h) {
            throw new ConcurrentModificationException();
        }
    }

    public void c() {
        if (r.f((q) this.i) != this.f7825h) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f7822c) {
            case 0:
                return this.f7823f < ((b) this.i).f7828g;
            case 1:
                return this.f7823f < ((c) this.i).f7832f;
            case 2:
                return this.f7823f < ((q) this.i).size() - 1;
            default:
                return this.f7823f < this.f7825h;
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f7822c) {
            case 0:
                if (this.f7823f > 0) {
                }
                break;
            case 1:
                if (this.f7823f > 0) {
                }
                break;
            case 2:
                if (this.f7823f >= 0) {
                }
                break;
            default:
                if (this.f7823f > this.f7824g) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f7822c) {
            case 0:
                a();
                int i = this.f7823f;
                b bVar = (b) this.i;
                if (i >= bVar.f7828g) {
                    g5.f.k();
                    return null;
                }
                this.f7823f = i + 1;
                this.f7824g = i;
                return bVar.f7826c[bVar.f7827f + i];
            case 1:
                b();
                int i3 = this.f7823f;
                c cVar = (c) this.i;
                if (i3 >= cVar.f7832f) {
                    g5.f.k();
                    return null;
                }
                this.f7823f = i3 + 1;
                this.f7824g = i3;
                return cVar.f7831c[i3];
            case 2:
                c();
                int i10 = this.f7823f + 1;
                this.f7824g = i10;
                q qVar = (q) this.i;
                r.a(i10, qVar.size());
                Object obj = qVar.get(i10);
                this.f7823f = i10;
                return obj;
            default:
                a0 a0Var = ((u1.q) this.i).f13903c;
                int i11 = this.f7823f;
                this.f7823f = i11 + 1;
                Object objE = a0Var.e(i11);
                objE.getClass();
                return (l) objE;
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f7822c) {
            case 0:
                return this.f7823f;
            case 1:
                return this.f7823f;
            case 2:
                return this.f7823f + 1;
            default:
                return this.f7823f - this.f7824g;
        }
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f7822c) {
            case 0:
                a();
                int i = this.f7823f;
                if (i <= 0) {
                    g5.f.k();
                    return null;
                }
                int i3 = i - 1;
                this.f7823f = i3;
                this.f7824g = i3;
                b bVar = (b) this.i;
                return bVar.f7826c[bVar.f7827f + i3];
            case 1:
                b();
                int i10 = this.f7823f;
                if (i10 <= 0) {
                    g5.f.k();
                    return null;
                }
                int i11 = i10 - 1;
                this.f7823f = i11;
                this.f7824g = i11;
                return ((c) this.i).f7831c[i11];
            case 2:
                c();
                int i12 = this.f7823f;
                q qVar = (q) this.i;
                r.a(i12, qVar.size());
                int i13 = this.f7823f;
                this.f7824g = i13;
                this.f7823f--;
                return qVar.get(i13);
            default:
                a0 a0Var = ((u1.q) this.i).f13903c;
                int i14 = this.f7823f - 1;
                this.f7823f = i14;
                Object objE = a0Var.e(i14);
                objE.getClass();
                return (l) objE;
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i;
        switch (this.f7822c) {
            case 0:
                i = this.f7823f;
                break;
            case 1:
                i = this.f7823f;
                break;
            case 2:
                return this.f7823f;
            default:
                return (this.f7823f - this.f7824g) - 1;
        }
        return i - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f7822c) {
            case 0:
                b bVar = (b) this.i;
                a();
                int i = this.f7824g;
                if (i == -1) {
                    od.f.e("Call next() or previous() before removing element from the iterator.");
                    return;
                }
                bVar.b(i);
                this.f7823f = this.f7824g;
                this.f7824g = -1;
                this.f7825h = ((AbstractList) bVar).modCount;
                return;
            case 1:
                c cVar = (c) this.i;
                b();
                int i3 = this.f7824g;
                if (i3 == -1) {
                    od.f.e("Call next() or previous() before removing element from the iterator.");
                    return;
                }
                cVar.b(i3);
                this.f7823f = this.f7824g;
                this.f7824g = -1;
                this.f7825h = ((AbstractList) cVar).modCount;
                return;
            case 2:
                c();
                q qVar = (q) this.i;
                qVar.remove(this.f7824g);
                this.f7823f--;
                this.f7824g = -1;
                this.f7825h = r.f(qVar);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f7822c) {
            case 0:
                a();
                int i = this.f7824g;
                if (i != -1) {
                    ((b) this.i).set(i, obj);
                    return;
                } else {
                    od.f.e("Call next() or previous() before replacing element from the iterator.");
                    return;
                }
            case 1:
                b();
                int i3 = this.f7824g;
                if (i3 != -1) {
                    ((c) this.i).set(i3, obj);
                    return;
                } else {
                    od.f.e("Call next() or previous() before replacing element from the iterator.");
                    return;
                }
            case 2:
                q qVar = (q) this.i;
                c();
                int i10 = this.f7824g;
                if (i10 < 0) {
                    od.f.e("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
                    return;
                } else {
                    qVar.set(i10, obj);
                    this.f7825h = r.f(qVar);
                    return;
                }
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(u1.q qVar, int i, int i3) {
        this(qVar, (i3 & 1) != 0 ? 0 : i, 0, qVar.f13903c.f9517b);
        this.f7822c = 3;
    }

    public /* synthetic */ a(int i) {
        this.f7822c = i;
    }

    public a(u1.q qVar, int i, int i3, int i10) {
        this.f7822c = 3;
        this.i = qVar;
        this.f7823f = i;
        this.f7824g = i3;
        this.f7825h = i10;
    }
}
