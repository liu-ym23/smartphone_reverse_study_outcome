package d.a;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: compiled from: AbstractMutableCollection.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d<E> extends AbstractCollection<E> implements d.h.b.a.b, Collection<E> {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return a();
    }

    public d() {
    }
}
