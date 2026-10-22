package androidx.databinding;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class ObservableArrayList<T> extends ArrayList<T> implements ObservableList<T> {
    private transient f mListeners;

    public ObservableArrayList() {
        this.mListeners = new f();
    }

    private void notifyAdd(int r10, int r11) {
        f r12 = this.mListeners;
        if (r12 == null) goto L6;
        r12.o(this, r10, r11);
        return;
    }

    private void notifyRemove(int r10, int r11) {
        f r12 = this.mListeners;
        if (r12 == null) goto L6;
        r12.p(this, r10, r11);
        return;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T r10) {
        super.add(r10);
        notifyAdd(size() - 1, 1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> r10) {
        int r11 = size();
        boolean r12 = super.addAll(r10);
        if (r12 == false) goto L5;
        notifyAdd(r11, size() - r11);
    L5:
        return r12;
    }

    @Override // androidx.databinding.ObservableList
    public void addOnListChangedCallback(ObservableList.a r10) {
        if (this.mListeners != null) goto L5;
        this.mListeners = new f();
    L5:
        this.mListeners.a(r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r10 = size();
        super.clear();
        if (r10 == 0) goto L6;
        notifyRemove(0, r10);
        return;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int r10) {
        T r11 = (T) super.remove(r10);
        notifyRemove(r10, 1);
        return r11;
    }

    @Override // androidx.databinding.ObservableList
    public void removeOnListChangedCallback(ObservableList.a r10) {
        f r11 = this.mListeners;
        if (r11 == null) goto L6;
        r11.i(r10);
        return;
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int r10, int r11) {
        super.removeRange(r10, r11);
        notifyRemove(r10, r11 - r10);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int r10, T r11) {
        T r12 = (T) super.set(r10, r11);
        f r13 = this.mListeners;
        if (r13 == null) goto L5;
        r13.n(this, r10, 1);
    L5:
        return r12;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int r10, T r11) {
        super.add(r10, r11);
        notifyAdd(r10, 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        int r11 = indexOf(r10);
        if (r11 < 0) goto L6;
        remove(r11);
        return true;
    L6:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends T> r11) {
        boolean r12 = super.addAll(r10, r11);
        if (r12 == false) goto L5;
        notifyAdd(r10, r11.size());
    L5:
        return r12;
    }
}
