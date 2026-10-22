package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import z2.C6195m;

/* loaded from: classes2.dex */
public final class b implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f19938a;

    /* renamed from: b, reason: collision with root package name */
    public Collection f19939b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f19940c;

    public b(c cVar) {
        this.f19940c = cVar;
        this.f19938a = cVar.f19941c.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f19938a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f19938a.next();
        this.f19939b = (Collection) entry.getValue();
        Object key = entry.getKey();
        return new zzco(key, this.f19940c.f19942d.f(key, (Collection) entry.getValue()));
    }

    @Override // java.util.Iterator
    public final void remove() {
        C6195m.e(this.f19939b != null, "no calls to next() since the last call to remove()");
        this.f19938a.remove();
        this.f19940c.f19942d.f19971d -= this.f19939b.size();
        this.f19939b.clear();
        this.f19939b = null;
    }
}
