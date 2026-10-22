package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes28.dex */
final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {
    private final T[] views;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.views.length;
    }

    public ImmutableList(T[] r100) {
        this.views = r100;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r100) {
        T[] r101 = this.views;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        if (r101[r103] == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r100) {
        return this.views[r100];
    }
}
