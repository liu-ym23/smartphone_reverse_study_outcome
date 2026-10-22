package com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> delegate;
    private transient int hashCode;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableEnumSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> delegate;

        EnumSerializedForm(EnumSet<E> r1) {
            this.delegate = r1;
        }

        Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone(), null);
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* synthetic */ ImmutableEnumSet(EnumSet r1, AnonymousClass1 r2) {
        this(r1);
    }

    static <E extends Enum<E>> ImmutableSet<E> asImmutable(EnumSet<E> r2) {
        int r0 = r2.size();
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return new ImmutableEnumSet(r2);
    L9:
        return ImmutableSet.of(Iterables.getOnlyElement(r2));
    L11:
        return ImmutableSet.of();
    }

    private ImmutableEnumSet(EnumSet<E> r1) {
        this.delegate = r1;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegate.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r1) {
        return this.delegate.contains(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> r1) {
        return this.delegate.containsAll(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (this.delegate.equals(r1) == true) goto L7;
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = this.delegate.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.delegate.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }
}
