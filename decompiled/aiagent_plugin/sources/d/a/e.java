package d.a;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: AbstractMutableList.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e<E> extends AbstractList<E> implements d.h.b.a.e, List<E> {
    public abstract int a();

    public abstract E a(int r1);

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int r1) {
        return a(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return a();
    }

    public e() {
    }
}
