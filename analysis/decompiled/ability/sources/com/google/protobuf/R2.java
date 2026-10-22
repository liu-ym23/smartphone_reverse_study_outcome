package com.google.protobuf;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class R2 extends AbstractList implements InterfaceC1009x1, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final C1005w1 f2869a;

    public R2(C1005w1 c1005w1) {
        this.f2869a = c1005w1;
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final void a(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.f2869a.get(i);
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final Object getRaw(int i) {
        return this.f2869a.b.get(i);
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f2869a.b);
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final InterfaceC1009x1 getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        C0997u1 c0997u1 = new C0997u1(1);
        c0997u1.b = this.f2869a.iterator();
        return c0997u1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        Q2 q22 = new Q2();
        q22.f2867a = this.f2869a.listIterator(i);
        return q22;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2869a.b.size();
    }
}
