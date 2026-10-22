package org.yaml.snakeyaml.util;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class ArrayUtils {

    public static class CompositeUnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] array1;
        private final E[] array2;

        public CompositeUnmodifiableArrayList(E[] eArr, E[] eArr2) {
            this.array1 = eArr;
            this.array2 = eArr2;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i10) {
            E[] eArr = this.array1;
            if (i10 < eArr.length) {
                return eArr[i10];
            }
            int length = i10 - eArr.length;
            E[] eArr2 = this.array2;
            if (length < eArr2.length) {
                return eArr2[i10 - eArr.length];
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array1.length + this.array2.length;
        }
    }

    public static class UnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] array;

        public UnmodifiableArrayList(E[] eArr) {
            this.array = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i10) {
            E[] eArr = this.array;
            if (i10 < eArr.length) {
                return eArr[i10];
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array.length;
        }
    }

    private ArrayUtils() {
    }

    public static <E> List<E> toUnmodifiableCompositeList(E[] eArr, E[] eArr2) {
        return eArr.length == 0 ? toUnmodifiableList(eArr2) : eArr2.length == 0 ? toUnmodifiableList(eArr) : new CompositeUnmodifiableArrayList(eArr, eArr2);
    }

    public static <E> List<E> toUnmodifiableList(E[] eArr) {
        return eArr.length == 0 ? Collections.EMPTY_LIST : new UnmodifiableArrayList(eArr);
    }
}
