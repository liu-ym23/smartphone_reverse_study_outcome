package s;

import java.util.Collection;
import t.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface b<E> extends a<E>, Collection, ac.a {
    b P(t.b bVar);

    @Override // java.util.List
    b<E> add(int i10, E e10);

    @Override // java.util.List, java.util.Collection
    b<E> add(E e10);

    @Override // java.util.List, java.util.Collection
    b<E> addAll(Collection<? extends E> collection);

    f builder();

    @Override // java.util.List, java.util.Collection
    b<E> remove(E e10);

    @Override // java.util.List, java.util.Collection
    b<E> removeAll(Collection<? extends E> collection);

    @Override // java.util.List
    b<E> set(int i10, E e10);

    b<E> w(int i10);
}
