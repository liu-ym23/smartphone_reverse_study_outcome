package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.protobuf.w1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1005w1 extends AbstractC0940g implements InterfaceC1009x1, RandomAccess {
    public static final C1005w1 c = new C1005w1();
    public final List b;

    public C1005w1(InterfaceC1009x1 interfaceC1009x1) {
        super(true);
        this.b = new ArrayList(interfaceC1009x1.size());
        addAll(interfaceC1009x1);
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final void a(ByteString byteString) {
        b();
        this.b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        b();
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.b.size(), collection);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        List list = this.b;
        Object obj = list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String strQ = byteString.q();
            if (byteString.i()) {
                list.set(i, strQ);
            }
            return strQ;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, AbstractC0989s1.f2940a);
        if (Y2.f2904a.C(bArr, 0, bArr.length)) {
            list.set(i, str);
        }
        return str;
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final Object getRaw(int i) {
        return this.b.get(i);
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.b);
    }

    @Override // com.google.protobuf.InterfaceC1009x1
    public final InterfaceC1009x1 getUnmodifiableView() {
        return this.f2920a ? new R2(this) : this;
    }

    @Override // com.google.protobuf.InterfaceC0985r1
    public final InterfaceC0985r1 mutableCopyWithCapacity(int i) {
        List list = this.b;
        if (i < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(list);
        return new C1005w1(arrayList);
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        return objRemove instanceof String ? (String) objRemove : objRemove instanceof ByteString ? ((ByteString) objRemove).q() : new String((byte[]) objRemove, AbstractC0989s1.f2940a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b();
        Object obj2 = this.b.set(i, (String) obj);
        return obj2 instanceof String ? (String) obj2 : obj2 instanceof ByteString ? ((ByteString) obj2).q() : new String((byte[]) obj2, AbstractC0989s1.f2940a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }

    @Override // com.google.protobuf.AbstractC0940g, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        b();
        if (collection instanceof InterfaceC1009x1) {
            collection = ((InterfaceC1009x1) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public C1005w1(ArrayList arrayList) {
        super(true);
        this.b = arrayList;
    }

    public C1005w1() {
        super(false);
        this.b = Collections.EMPTY_LIST;
    }

    public C1005w1(int i) {
        this(new ArrayList(i));
    }
}
