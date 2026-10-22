package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> {
    private static final ProtobufArrayList<Object> EMPTY_LIST = null;
    private final List<E> list;

    static {
        ProtobufArrayList<Object> r10 = new ProtobufArrayList();
        EMPTY_LIST = r10;
        r10.makeImmutable();
    }

    public ProtobufArrayList() {
        this(new ArrayList(10));
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int r10, E r11) {
        ensureIsMutable();
        this.list.add(r10, r11);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r10) {
        return this.list.get(r10);
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public /* bridge */ /* synthetic */ Internal.ProtobufList mutableCopyWithCapacity(int r10) {
        return mutableCopyWithCapacity(r10);
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int r10) {
        ensureIsMutable();
        E r11 = this.list.remove(r10);
        ((AbstractList) this).modCount++;
        return r11;
    }

    @Override // com.google.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int r10, E r11) {
        ensureIsMutable();
        E r12 = this.list.set(r10, r11);
        ((AbstractList) this).modCount++;
        return r12;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.list.size();
    }

    private ProtobufArrayList(List<E> r10) {
        this.list = r10;
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.BooleanList
    public ProtobufArrayList<E> mutableCopyWithCapacity(int r10) {
        if (r10 < size()) goto L7;
        ArrayList r11 = new ArrayList(r10);
        r11.addAll(this.list);
        return new ProtobufArrayList(r11);
    L7:
        throw new IllegalArgumentException();
    }
}
