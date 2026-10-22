package com.google.common.collect;

import m3.AbstractC1677d;
import m3.C1676c;

/* loaded from: classes3.dex */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    public final transient Object d;

    public SingletonImmutableSet(Object obj) {
        obj.getClass();
        this.d = obj;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int b(Object[] objArr) {
        objArr[0] = this.d;
        return 1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.d.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: g */
    public final AbstractC1677d iterator() {
        return new C1676c(this.d);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.d.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.d.toString() + ']';
    }
}
