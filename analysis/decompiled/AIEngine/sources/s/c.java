package s;

import java.util.Collection;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c<E> extends Set, Collection, ac.a {
    @Override // java.util.Set, java.util.Collection
    v.b add(Object obj);

    @Override // java.util.Set, java.util.Collection
    c<E> addAll(Collection<? extends E> collection);

    v.c builder();

    @Override // java.util.Set, java.util.Collection
    v.b remove(Object obj);

    @Override // java.util.Set, java.util.Collection
    c<E> removeAll(Collection<? extends E> collection);
}
