package com.google.common.collect;

import B7.a;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import k3.AbstractC1622a;
import m3.AbstractC1677d;
import m3.C1674a;

/* loaded from: classes3.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    public static final C1674a b = new C1674a(RegularImmutableList.e, 0);

    public static class SerializedForm implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f2747a;

        public SerializedForm(Object[] objArr) {
            this.f2747a = objArr;
        }

        public Object readResolve() {
            C1674a c1674a = ImmutableList.b;
            Object[] objArr = this.f2747a;
            if (objArr.length == 0) {
                return RegularImmutableList.e;
            }
            Object[] objArr2 = (Object[]) objArr.clone();
            int length = objArr2.length;
            for (int i = 0; i < length; i++) {
                if (objArr2[i] == null) {
                    throw new NullPointerException(a.h(i, "at index "));
                }
            }
            int length2 = objArr2.length;
            return length2 == 0 ? RegularImmutableList.e : new RegularImmutableList(objArr2, length2);
        }
    }

    public class SubList extends ImmutableList<E> {
        public final transient int c;
        public final transient int d;

        public SubList(int i, int i6) {
            this.c = i;
            this.d = i6;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final Object[] c() {
            return ImmutableList.this.c();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int e() {
            return ImmutableList.this.f() + this.c + this.d;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final int f() {
            return ImmutableList.this.f() + this.c;
        }

        @Override // java.util.List
        public final Object get(int i) {
            AbstractC1622a.b(i, this.d);
            return ImmutableList.this.get(i + this.c);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final ImmutableList subList(int i, int i6) {
            AbstractC1622a.d(i, i6, this.d);
            int i10 = this.c;
            return ImmutableList.this.subList(i + i10, i6 + i10);
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.d;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return listIterator(i);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int b(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
        return size;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (!(list instanceof RandomAccess)) {
                        Iterator<E> it = list.iterator();
                        for (E e : this) {
                            if (it.hasNext()) {
                                E next = it.next();
                                if (e != next && (e == null || !e.equals(next))) {
                                    return false;
                                }
                            }
                        }
                        return !it.hasNext();
                    }
                    for (int i = 0; i < size; i++) {
                        E e6 = get(i);
                        Object obj2 = list.get(i);
                        if (e6 != obj2 && (e6 == null || !e6.equals(obj2))) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: g */
    public final AbstractC1677d iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final C1674a listIterator(int i) {
        AbstractC1622a.c(i, size());
        return isEmpty() ? b : new C1674a(this, i);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i6 = 0; i6 < size; i6++) {
            i = ~(~(get(i6).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    /* renamed from: i */
    public ImmutableList subList(int i, int i6) {
        AbstractC1622a.d(i, i6, size());
        int i10 = i6 - i;
        return i10 == size() ? this : i10 == 0 ? RegularImmutableList.e : new SubList(i, i10);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray(ImmutableCollection.f2746a));
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }
}
