package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
abstract class AbstractProtobufList<E> extends AbstractList<E> implements Internal.ProtobufList<E> {
    protected static final int DEFAULT_CAPACITY = 10;
    private boolean isMutable;

    public AbstractProtobufList() {
        this.isMutable = true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r10) {
        ensureIsMutable();
        return super.add(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r10) {
        ensureIsMutable();
        return super.addAll(r10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ensureIsMutable();
        super.clear();
    }

    public void ensureIsMutable() {
        if (this.isMutable == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof List) == true) goto L9;
        return false;
    L9:
        if ((r10 instanceof RandomAccess) == false) goto L11;
        List r11 = (List) r10;
        int r12 = size();
        if (r12 == r11.size()) goto L15;
        return false;
    L15:
        int r13 = 0;
    L16:
        if (r13 >= r12) goto L21;
        if (get(r13).equals(r11.get(r13)) == false) goto L19;
        r13 = r13 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L11:
        return super.equals(r10);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r10 = size();
        int r11 = 1;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11 = (r11 * 31) + get(r12).hashCode();
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public boolean isModifiable() {
        return this.isMutable;
    }

    @Override // com.google.protobuf.Internal.ProtobufList
    public final void makeImmutable() {
        this.isMutable = false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r10) {
        ensureIsMutable();
        return (E) super.remove(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r10) {
        ensureIsMutable();
        return super.removeAll(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r10) {
        ensureIsMutable();
        return super.retainAll(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        ensureIsMutable();
        return (E) super.set(r10, r11);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        ensureIsMutable();
        super.add(r10, r11);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r10, Collection<? extends E> r11) {
        ensureIsMutable();
        return super.addAll(r10, r11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r10) {
        ensureIsMutable();
        return super.remove(r10);
    }
}
