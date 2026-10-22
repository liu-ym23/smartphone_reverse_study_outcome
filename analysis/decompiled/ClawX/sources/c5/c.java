package c5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class c implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public int f1079a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1080b;

    public abstract void a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i8 = this.f1079a;
        if (i8 == 0) {
            this.f1079a = 3;
            a();
            return this.f1079a == 1;
        }
        if (i8 == 1) {
            return true;
        }
        if (i8 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i8 = this.f1079a;
        if (i8 == 1) {
            this.f1079a = 0;
            return this.f1080b;
        }
        if (i8 != 2) {
            this.f1079a = 3;
            a();
            if (this.f1079a == 1) {
                this.f1079a = 0;
                return this.f1080b;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
