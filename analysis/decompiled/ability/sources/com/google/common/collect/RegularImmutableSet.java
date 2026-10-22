package com.google.common.collect;

import N9.j;
import m3.AbstractC1677d;
import m3.C1674a;

/* loaded from: classes3.dex */
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    public static final Object[] i;

    /* renamed from: j, reason: collision with root package name */
    public static final RegularImmutableSet f2751j;
    public final transient Object[] d;
    public final transient int e;
    public final transient Object[] f;
    public final transient int g;
    public final transient int h;

    static {
        Object[] objArr = new Object[0];
        i = objArr;
        f2751j = new RegularImmutableSet(objArr, objArr, 0, 0, 0);
    }

    public RegularImmutableSet(Object[] objArr, Object[] objArr2, int i6, int i10, int i11) {
        this.d = objArr;
        this.e = i6;
        this.f = objArr2;
        this.g = i10;
        this.h = i11;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.d;
        int i6 = this.h;
        System.arraycopy(objArr2, 0, objArr, 0, i6);
        return i6;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final Object[] c() {
        return this.d;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f;
            if (objArr.length != 0) {
                int iP = j.P(obj.hashCode());
                while (true) {
                    int i6 = iP & this.g;
                    Object obj2 = objArr[i6];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iP = i6 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int e() {
        return this.h;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int f() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: g */
    public final AbstractC1677d iterator() {
        return h().listIterator(0);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }

    @Override // com.google.common.collect.ImmutableSet
    public final ImmutableList l() {
        C1674a c1674a = ImmutableList.b;
        int i6 = this.h;
        return i6 == 0 ? RegularImmutableList.e : new RegularImmutableList(this.d, i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.h;
    }
}
