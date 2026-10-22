package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import z2.AbstractC6064H;
import z2.C6058B;
import z2.C6065I;

/* loaded from: classes2.dex */
public final class c extends AbstractC6064H {

    /* renamed from: c, reason: collision with root package name */
    public final transient Map f19941c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbr f19942d;

    public c(zzbr zzbrVar, Map map) {
        this.f19942d = zzbrVar;
        this.f19941c = map;
    }

    @Override // z2.AbstractC6064H
    public final Set b() {
        return new a(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Collection get(Object obj) {
        Collection collection = (Collection) C6065I.a(this.f19941c, obj);
        if (collection == null) {
            return null;
        }
        return this.f19942d.f(obj, collection);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzbr zzbrVar = this.f19942d;
        if (this.f19941c == zzbrVar.f19970c) {
            zzbrVar.m();
        } else {
            C6058B.a(new b(this));
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return C6065I.b(this.f19941c, obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        return this == obj || this.f19941c.equals(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        return this.f19941c.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f19942d.zzw();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.f19941c.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection collectionE = this.f19942d.e();
        collectionE.addAll(collection);
        this.f19942d.f19971d -= collection.size();
        collection.clear();
        return collectionE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f19941c.size();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        return this.f19941c.toString();
    }
}
