package d.a;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: compiled from: AbstractMutableSet.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f<E> extends AbstractSet<E> implements d.h.b.a.h, Set<E> {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return a();
    }

    public f() {
    }
}
