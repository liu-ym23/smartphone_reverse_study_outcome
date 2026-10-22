package com.bytedance.location.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    private boolean isMutable;

    AbstractProtobufList() {
        this.isMutable = true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object o) {
        if (o != this) goto L6;
        return true;
    L6:
        if ((o instanceof List) == true) goto L9;
        return false;
    L9:
        if ((o instanceof RandomAccess) == false) goto L11;
        List<?> other = (List) o;
        int size = size();
        if (size == other.size()) goto L15;
        return false;
    L15:
        int i = 0;
    L16:
        if (i >= size) goto L22;
        if (get(i).equals(other.get(i)) == false) goto L19;
        i = i + 1;
        goto L16
    L19:
        return false;
    L22:
        return true;
    L11:
        return super.equals(o);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int hashCode = 1;
        int i = 0;
    L3:
        if (i >= size) goto L6;
        hashCode = (hashCode * 31) + get(i).hashCode();
        i = i + 1;
        goto L3
    L6:
        return hashCode;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        ensureIsMutable();
        return super.add(e);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        ensureIsMutable();
        super.add(index, element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> c) {
        ensureIsMutable();
        return super.addAll(c);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> c) {
        ensureIsMutable();
        return super.addAll(index, c);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        super.clear();
    }

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList
    public boolean isModifiable() {
        return this.isMutable;
    }

    @Override // com.bytedance.location.protobuf.Internal.ProtobufList
    public final void makeImmutable() {
        this.isMutable = false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r2) {
        ensureIsMutable();
        return (E) super.remove(r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object o) {
        ensureIsMutable();
        int index = indexOf(o);
        if (index != (-1)) goto L6;
        return false;
    L6:
        remove(index);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> c) {
        ensureIsMutable();
        return super.removeAll(c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> c) {
        ensureIsMutable();
        return super.retainAll(c);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r2, E r3) {
        ensureIsMutable();
        return (E) super.set(r2, r3);
    }

    protected void ensureIsMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }
}
