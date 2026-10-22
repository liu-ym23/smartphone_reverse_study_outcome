package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class h1 extends AbstractList implements e0, RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public final d0 f2214f;

    public h1(d0 d0Var) {
        this.f2214f = d0Var;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final void e(h hVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        return (String) this.f2214f.get(i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final Object getRaw(int i2) {
        return this.f2214f.f2195g.get(i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f2214f.f2195g);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final e0 getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        g1 g1Var = new g1();
        g1Var.f2208f = this.f2214f.iterator();
        return g1Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        f1 f1Var = new f1();
        f1Var.f2206f = this.f2214f.listIterator(i2);
        return f1Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2214f.size();
    }
}
