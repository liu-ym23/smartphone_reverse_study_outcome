package c5;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1099a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f1100b;

    /* renamed from: c, reason: collision with root package name */
    public int f1101c;

    public y(Iterator iterator) {
        kotlin.jvm.internal.p.e(iterator, "iterator");
        this.f1100b = iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f1099a) {
            case 0:
                return this.f1100b.hasNext();
        }
        while (true) {
            int i8 = this.f1101c;
            it = this.f1100b;
            if (i8 > 0 && it.hasNext()) {
                it.next();
                this.f1101c--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f1099a) {
            case 0:
                int i8 = this.f1101c;
                this.f1101c = i8 + 1;
                if (i8 >= 0) {
                    return new w(i8, this.f1100b.next());
                }
                n.m0();
                throw null;
        }
        while (true) {
            int i9 = this.f1101c;
            it = this.f1100b;
            if (i9 > 0 && it.hasNext()) {
                it.next();
                this.f1101c--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1099a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public y(w5.c cVar) {
        this.f1100b = cVar.f6205a.iterator();
        this.f1101c = cVar.f6206b;
    }
}
