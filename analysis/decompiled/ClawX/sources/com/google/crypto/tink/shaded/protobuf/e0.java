package com.google.crypto.tink.shaded.protobuf;

import com.stepos.stepclaw.SecurePrefs;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e0 extends b implements f0, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1453b;

    static {
        new e0(10).f1433a = false;
    }

    public e0(int i8) {
        this(new ArrayList(i8));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.z
    public final z a(int i8) {
        ArrayList arrayList = this.f1453b;
        if (i8 < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i8);
        arrayList2.addAll(arrayList);
        return new e0(arrayList2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i8, Object obj) {
        f();
        this.f1453b.add(i8, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f1453b.size(), collection);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final void b(i iVar) {
        f();
        this.f1453b.add(iVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final f0 c() {
        return this.f1433a ? new i1(this) : this;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        this.f1453b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final Object d(int i8) {
        return this.f1453b.get(i8);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.f0
    public final List e() {
        return Collections.unmodifiableList(this.f1453b);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i8) {
        String str;
        ArrayList arrayList = this.f1453b;
        Object obj = arrayList.get(i8);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof i)) {
            byte[] bArr = (byte[]) obj;
            String str2 = new String(bArr, a0.f1428a);
            if (q1.f1510a.R(0, bArr.length, bArr)) {
                arrayList.set(i8, str2);
            }
            return str2;
        }
        i iVar = (i) obj;
        Charset charset = a0.f1428a;
        if (iVar.size() == 0) {
            str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            h hVar = (h) iVar;
            str = new String(hVar.d, hVar.k(), hVar.size(), charset);
        }
        h hVar2 = (h) iVar;
        int iK = hVar2.k();
        byte[] bArr2 = hVar2.d;
        if (q1.f1510a.R(iK, hVar2.size() + iK, bArr2)) {
            arrayList.set(i8, str);
        }
        return str;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final Object remove(int i8) {
        f();
        Object objRemove = this.f1453b.remove(i8);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof i)) {
            return new String((byte[]) objRemove, a0.f1428a);
        }
        i iVar = (i) objRemove;
        Charset charset = a0.f1428a;
        if (iVar.size() == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        h hVar = (h) iVar;
        return new String(hVar.d, hVar.k(), hVar.size(), charset);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i8, Object obj) {
        f();
        Object obj2 = this.f1453b.set(i8, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof i)) {
            return new String((byte[]) obj2, a0.f1428a);
        }
        i iVar = (i) obj2;
        Charset charset = a0.f1428a;
        if (iVar.size() == 0) {
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        h hVar = (h) iVar;
        return new String(hVar.d, hVar.k(), hVar.size(), charset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1453b.size();
    }

    public e0(ArrayList arrayList) {
        this.f1453b = arrayList;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i8, Collection collection) {
        f();
        if (collection instanceof f0) {
            collection = ((f0) collection).e();
        }
        boolean zAddAll = this.f1453b.addAll(i8, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
