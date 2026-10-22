package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    private final transient ImmutableMap<E, Integer> map;
    private final transient int size;

    @Override // com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    RegularImmutableMultiset(ImmutableMap<E, Integer> r1, int r2) {
        this.map = r1;
        this.size = r2;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object r1) {
        Integer r0 = this.map.get(r1);
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.intValue();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r1) {
        return this.map.containsKey(r1);
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int r1) {
        Map.Entry<E, Integer> r0 = this.map.entrySet().asList().get(r1);
        return Multisets.immutableEntry(r0.getKey(), r0.getValue().intValue());
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return this.map.hashCode();
    }
}
