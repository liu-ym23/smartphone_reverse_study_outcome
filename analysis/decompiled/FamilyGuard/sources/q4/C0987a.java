package q4;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: q4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0987a<T> implements InterfaceC0988b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<InterfaceC0988b<T>> f19939a;

    public C0987a(InterfaceC0988b<? extends T> interfaceC0988b) {
        j4.k.g(interfaceC0988b, "sequence");
        this.f19939a = new AtomicReference<>(interfaceC0988b);
    }

    @Override // q4.InterfaceC0988b
    public Iterator<T> iterator() {
        InterfaceC0988b<T> andSet = this.f19939a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
