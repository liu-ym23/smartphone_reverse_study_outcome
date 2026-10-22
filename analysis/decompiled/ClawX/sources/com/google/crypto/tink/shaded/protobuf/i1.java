package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i1 extends AbstractList implements f0, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final e0 f1470a;

    public i1(e0 e0Var) {
        this.f1470a = e0Var;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final void b(i iVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final Object d(int i8) {
        return this.f1470a.f1453b.get(i8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final List e() {
        return Collections.unmodifiableList(this.f1470a.f1453b);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        return (String) this.f1470a.get(i8);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        h1 h1Var = new h1();
        h1Var.f1464a = this.f1470a.iterator();
        return h1Var;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i8) {
        g1 g1Var = new g1();
        g1Var.f1463a = this.f1470a.listIterator(i8);
        return g1Var;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1470a.size();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final f0 c() {
        return this;
    }
}
