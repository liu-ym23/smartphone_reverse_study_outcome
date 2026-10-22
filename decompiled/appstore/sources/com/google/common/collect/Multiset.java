package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object r10);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    @CanIgnoreReturnValue
    int add(@NullableDecl E r10, int r11);

    @CanIgnoreReturnValue
    boolean add(E r10);

    boolean contains(@NullableDecl Object r10);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> r10);

    int count(@NullableDecl @CompatibleWith("E") Object r10);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@NullableDecl Object r10);

    int hashCode();

    Iterator<E> iterator();

    @CanIgnoreReturnValue
    int remove(@NullableDecl @CompatibleWith("E") Object r10, int r11);

    @CanIgnoreReturnValue
    boolean remove(@NullableDecl Object r10);

    @CanIgnoreReturnValue
    boolean removeAll(Collection<?> r10);

    @CanIgnoreReturnValue
    boolean retainAll(Collection<?> r10);

    @CanIgnoreReturnValue
    int setCount(E r10, int r11);

    @CanIgnoreReturnValue
    boolean setCount(E r10, int r11, int r12);

    int size();

    String toString();
}
