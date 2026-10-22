package q4;

import i4.InterfaceC0772l;
import java.util.Iterator;
import k4.InterfaceC0814a;

/* loaded from: classes.dex */
public final class k<T, R> implements InterfaceC0988b<R> {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0988b<T> f19947a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0772l<T, R> f19948b;

    public static final class a implements Iterator<R>, InterfaceC0814a {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<T> f19949a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k<T, R> f19950b;

        a(k<T, R> kVar) {
            this.f19950b = kVar;
            this.f19949a = ((k) kVar).f19947a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19949a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((k) this.f19950b).f19948b.invoke(this.f19949a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(InterfaceC0988b<? extends T> interfaceC0988b, InterfaceC0772l<? super T, ? extends R> interfaceC0772l) {
        j4.k.g(interfaceC0988b, "sequence");
        j4.k.g(interfaceC0772l, "transformer");
        this.f19947a = interfaceC0988b;
        this.f19948b = interfaceC0772l;
    }

    @Override // q4.InterfaceC0988b
    public Iterator<R> iterator() {
        return new a(this);
    }
}
