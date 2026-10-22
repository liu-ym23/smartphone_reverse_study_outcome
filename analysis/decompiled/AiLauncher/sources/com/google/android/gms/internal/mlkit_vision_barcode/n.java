package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import z2.C6175k;
import z2.C6275u;

/* loaded from: classes2.dex */
public final class n extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzci f19960a;

    public n(zzci zzciVar) {
        this.f19960a = zzciVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f19960a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map mapU = this.f19960a.u();
        if (mapU != null) {
            return mapU.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iH = this.f19960a.H(entry.getKey());
            if (iH != -1 && C6175k.a(zzci.s(this.f19960a, iH), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzci zzciVar = this.f19960a;
        Map mapU = zzciVar.u();
        return mapU != null ? mapU.entrySet().iterator() : new l(zzciVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map mapU = this.f19960a.u();
        if (mapU != null) {
            return mapU.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzci zzciVar = this.f19960a;
        if (zzciVar.A()) {
            return false;
        }
        int iG = zzciVar.G();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzci zzciVar2 = this.f19960a;
        int iB = C6275u.b(key, value, iG, zzci.q(zzciVar2), zzciVar2.b(), zzciVar2.c(), zzciVar2.d());
        if (iB == -1) {
            return false;
        }
        this.f19960a.z(iB, iG);
        zzci zzciVar3 = this.f19960a;
        zzciVar3.f19978f--;
        this.f19960a.x();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f19960a.size();
    }
}
