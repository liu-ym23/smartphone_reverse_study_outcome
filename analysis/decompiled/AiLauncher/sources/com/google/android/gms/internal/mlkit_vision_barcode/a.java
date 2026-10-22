package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import z2.AbstractC6061E;

/* loaded from: classes2.dex */
public final class a extends AbstractC6061E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f19937a;

    public a(c cVar) {
        this.f19937a = cVar;
    }

    @Override // z2.AbstractC6061E
    public final Map b() {
        return this.f19937a;
    }

    @Override // z2.AbstractC6061E, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Set setEntrySet = this.f19937a.f19941c.entrySet();
        setEntrySet.getClass();
        try {
            return setEntrySet.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new b(this.f19937a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Objects.requireNonNull(entry);
        c cVar = this.f19937a;
        zzbr.l(cVar.f19942d, entry.getKey());
        return true;
    }
}
