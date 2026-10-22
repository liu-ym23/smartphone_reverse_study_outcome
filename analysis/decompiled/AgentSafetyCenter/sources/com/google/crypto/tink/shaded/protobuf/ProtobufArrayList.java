package com.google.crypto.tink.shaded.protobuf;

import g5.f;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST;
    private E[] array;
    private int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    public ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] createArray(int i) {
        return (E[]) new Object[i];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return (ProtobufArrayList<E>) EMPTY_LIST;
    }

    private void ensureIndexInRange(int i) {
        if (i < 0 || i >= this.size) {
            f.q(makeOutOfBoundsExceptionMessage(i));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i) {
        StringBuilder sbT = a.t(i, "Index:", ", Size:");
        sbT.append(this.size);
        return sbT.toString();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i, E e10) {
        int i3;
        ensureIsMutable();
        if (i < 0 || i > (i3 = this.size)) {
            f.q(makeOutOfBoundsExceptionMessage(i));
            return;
        }
        E[] eArr = this.array;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i3 - i);
        } else {
            E[] eArr2 = (E[]) createArray(((i3 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, eArr2, 0, i);
            System.arraycopy(this.array, i, eArr2, i + 1, this.size - i);
            this.array = eArr2;
        }
        this.array[i] = e10;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        ensureIndexInRange(i);
        return this.array[i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* renamed from: mutableCopyWithCapacity */
    public ProtobufArrayList<E> mutableCopyWithCapacity2(int i) {
        if (i >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i), this.size);
        }
        od.f.b();
        return null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E remove(int i) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.array;
        E e10 = eArr[i];
        if (i < this.size - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public E set(int i, E e10) {
        ensureIsMutable();
        ensureIndexInRange(i);
        E[] eArr = this.array;
        E e11 = eArr[i];
        eArr[i] = e10;
        ((AbstractList) this).modCount++;
        return e11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i) {
        this.array = eArr;
        this.size = i;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e10) {
        ensureIsMutable();
        int i = this.size;
        E[] eArr = this.array;
        if (i == eArr.length) {
            this.array = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        eArr2[i3] = e10;
        ((AbstractList) this).modCount++;
        return true;
    }
}
