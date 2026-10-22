package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import z2.C6058B;
import z2.C6062F;

/* loaded from: classes2.dex */
public final class e extends C6062F {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbr f19946b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zzbr zzbrVar, Map map) {
        super(map);
        this.f19946b = zzbrVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        C6058B.a(iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.f44654a.keySet().containsAll(collection);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        return this == obj || this.f44654a.keySet().equals(obj);
    }

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f44654a.keySet().hashCode();
    }

    @Override // z2.C6062F, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new d(this, this.f44654a.entrySet().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.f44654a.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        this.f19946b.f19971d -= size;
        return size > 0;
    }
}
