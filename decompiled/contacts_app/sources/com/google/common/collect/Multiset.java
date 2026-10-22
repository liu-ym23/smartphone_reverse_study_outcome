package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object r1);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    int add(@Nullable E r1, int r2);

    boolean add(E r1);

    boolean contains(@Nullable Object r1);

    boolean containsAll(Collection<?> r1);

    int count(@Nullable Object r1);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@Nullable Object r1);

    int hashCode();

    Iterator<E> iterator();

    int remove(@Nullable Object r1, int r2);

    boolean remove(@Nullable Object r1);

    boolean removeAll(Collection<?> r1);

    boolean retainAll(Collection<?> r1);

    int setCount(E r1, int r2);

    boolean setCount(E r1, int r2, int r3);

    String toString();
}
