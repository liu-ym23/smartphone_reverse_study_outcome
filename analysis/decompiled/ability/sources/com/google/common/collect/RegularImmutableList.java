package com.google.common.collect;

import java.util.Objects;
import k3.AbstractC1622a;

/* loaded from: classes3.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    public static final ImmutableList e = new RegularImmutableList(new Object[0], 0);
    public final transient Object[] c;
    public final transient int d;

    public RegularImmutableList(Object[] objArr, int i) {
        this.c = objArr;
        this.d = i;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.c;
        int i = this.d;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] c() {
        return this.c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int e() {
        return this.d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i) {
        AbstractC1622a.b(i, this.d);
        Object obj = this.c[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.d;
    }
}
