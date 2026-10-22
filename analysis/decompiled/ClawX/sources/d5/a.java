package d5;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements ListIterator, q5.a {

    /* renamed from: b, reason: collision with root package name */
    public int f1816b;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public final c5.g f1818e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1815a = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f1817c = -1;

    public a(c cVar, int i8) {
        this.f1818e = cVar;
        this.f1816b = i8;
        this.d = ((AbstractList) cVar).modCount;
    }

    public void a() {
        if (((AbstractList) ((b) this.f1818e).f1822e).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f1815a) {
            case 0:
                a();
                b bVar = (b) this.f1818e;
                int i8 = this.f1816b;
                this.f1816b = i8 + 1;
                bVar.add(i8, obj);
                this.f1817c = -1;
                this.d = ((AbstractList) bVar).modCount;
                break;
            default:
                b();
                c cVar = (c) this.f1818e;
                int i9 = this.f1816b;
                this.f1816b = i9 + 1;
                cVar.add(i9, obj);
                this.f1817c = -1;
                this.d = ((AbstractList) cVar).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((c) this.f1818e)).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1815a) {
            case 0:
                if (this.f1816b < ((b) this.f1818e).f1821c) {
                }
                break;
            default:
                if (this.f1816b < ((c) this.f1818e).f1824b) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f1815a) {
            case 0:
                if (this.f1816b > 0) {
                }
                break;
            default:
                if (this.f1816b > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f1815a) {
            case 0:
                a();
                int i8 = this.f1816b;
                b bVar = (b) this.f1818e;
                if (i8 >= bVar.f1821c) {
                    throw new NoSuchElementException();
                }
                this.f1816b = i8 + 1;
                this.f1817c = i8;
                return bVar.f1819a[bVar.f1820b + i8];
            default:
                b();
                int i9 = this.f1816b;
                c cVar = (c) this.f1818e;
                if (i9 >= cVar.f1824b) {
                    throw new NoSuchElementException();
                }
                this.f1816b = i9 + 1;
                this.f1817c = i9;
                return cVar.f1823a[i9];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f1815a) {
        }
        return this.f1816b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f1815a) {
            case 0:
                a();
                int i8 = this.f1816b;
                if (i8 <= 0) {
                    throw new NoSuchElementException();
                }
                int i9 = i8 - 1;
                this.f1816b = i9;
                this.f1817c = i9;
                b bVar = (b) this.f1818e;
                return bVar.f1819a[bVar.f1820b + i9];
            default:
                b();
                int i10 = this.f1816b;
                if (i10 <= 0) {
                    throw new NoSuchElementException();
                }
                int i11 = i10 - 1;
                this.f1816b = i11;
                this.f1817c = i11;
                return ((c) this.f1818e).f1823a[i11];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i8;
        switch (this.f1815a) {
            case 0:
                i8 = this.f1816b;
                break;
            default:
                i8 = this.f1816b;
                break;
        }
        return i8 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f1815a) {
            case 0:
                b bVar = (b) this.f1818e;
                a();
                int i8 = this.f1817c;
                if (i8 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                bVar.g(i8);
                this.f1816b = this.f1817c;
                this.f1817c = -1;
                this.d = ((AbstractList) bVar).modCount;
                return;
            default:
                c cVar = (c) this.f1818e;
                b();
                int i9 = this.f1817c;
                if (i9 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                cVar.g(i9);
                this.f1816b = this.f1817c;
                this.f1817c = -1;
                this.d = ((AbstractList) cVar).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f1815a) {
            case 0:
                a();
                int i8 = this.f1817c;
                if (i8 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((b) this.f1818e).set(i8, obj);
                return;
            default:
                b();
                int i9 = this.f1817c;
                if (i9 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((c) this.f1818e).set(i9, obj);
                return;
        }
    }

    public a(b bVar, int i8) {
        this.f1818e = bVar;
        this.f1816b = i8;
        this.d = ((AbstractList) bVar).modCount;
    }
}
