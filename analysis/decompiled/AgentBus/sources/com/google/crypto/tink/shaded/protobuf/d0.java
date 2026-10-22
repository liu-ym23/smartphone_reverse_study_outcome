package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class d0 extends b implements e0, RandomAccess {

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f2195g;

    static {
        new d0(10).f2176f = false;
    }

    public d0(int i2) {
        this(new ArrayList(i2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        a();
        this.f2195g.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f2195g.size(), collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        a();
        this.f2195g.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final void e(h hVar) {
        a();
        this.f2195g.add(hVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        String str;
        ArrayList arrayList = this.f2195g;
        Object obj = arrayList.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof h)) {
            byte[] bArr = (byte[]) obj;
            String str2 = new String(bArr, z.f2296a);
            if (p1.f2258a.G(bArr, 0, bArr.length)) {
                arrayList.set(i2, str2);
            }
            return str2;
        }
        h hVar = (h) obj;
        Charset charset = z.f2296a;
        if (hVar.size() == 0) {
            str = "";
        } else {
            g gVar = (g) hVar;
            str = new String(gVar.f2207i, gVar.k(), gVar.size(), charset);
        }
        g gVar2 = (g) hVar;
        int iK = gVar2.k();
        if (p1.f2258a.G(gVar2.f2207i, iK, gVar2.size() + iK)) {
            arrayList.set(i2, str);
        }
        return str;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final Object getRaw(int i2) {
        return this.f2195g.get(i2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final List getUnderlyingElements() {
        return Collections.unmodifiableList(this.f2195g);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.e0
    public final e0 getUnmodifiableView() {
        return this.f2176f ? new h1(this) : this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.y
    public final y mutableCopyWithCapacity(int i2) {
        ArrayList arrayList = this.f2195g;
        if (i2 < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i2);
        arrayList2.addAll(arrayList);
        return new d0(arrayList2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        a();
        Object objRemove = this.f2195g.remove(i2);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof h)) {
            return new String((byte[]) objRemove, z.f2296a);
        }
        h hVar = (h) objRemove;
        Charset charset = z.f2296a;
        if (hVar.size() == 0) {
            return "";
        }
        g gVar = (g) hVar;
        return new String(gVar.f2207i, gVar.k(), gVar.size(), charset);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        a();
        Object obj2 = this.f2195g.set(i2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof h)) {
            return new String((byte[]) obj2, z.f2296a);
        }
        h hVar = (h) obj2;
        Charset charset = z.f2296a;
        if (hVar.size() == 0) {
            return "";
        }
        g gVar = (g) hVar;
        return new String(gVar.f2207i, gVar.k(), gVar.size(), charset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2195g.size();
    }

    public d0(ArrayList arrayList) {
        this.f2195g = arrayList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        a();
        if (collection instanceof e0) {
            collection = ((e0) collection).getUnderlyingElements();
        }
        boolean zAddAll = this.f2195g.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
