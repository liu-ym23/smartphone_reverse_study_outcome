package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> delegate;

    @LazyInit
    private transient int hashCode;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableEnumSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> delegate;

        public EnumSerializedForm(EnumSet<E> r10) {
            this.delegate = r10;
        }

        public Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone(), null);
        }
    }

    public /* synthetic */ ImmutableEnumSet(EnumSet r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static ImmutableSet asImmutable(EnumSet r10) {
        int r11 = r10.size();
        if (r11 == 0) goto L11;
        if (r11 == 1) goto L9;
        return new ImmutableEnumSet(r10);
    L9:
        return ImmutableSet.of(Iterables.getOnlyElement(r10));
    L11:
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r10) {
        return this.delegate.contains(r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r10) {
        if ((r10 instanceof ImmutableEnumSet) == false) goto L6;
        r10 = ((ImmutableEnumSet) r10).delegate;
    L6:
        return this.delegate.containsAll(r10);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ImmutableEnumSet) == false) goto L9;
        r10 = ((ImmutableEnumSet) r10).delegate;
    L9:
        return this.delegate.equals(r10);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = this.delegate.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }

    private ImmutableEnumSet(EnumSet<E> r10) {
        this.delegate = r10;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }
}
