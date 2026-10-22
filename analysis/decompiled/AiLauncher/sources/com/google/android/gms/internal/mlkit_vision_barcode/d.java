package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import z2.C6195m;

/* loaded from: classes2.dex */
public final class d implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public Map.Entry f19943a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f19944b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f19945c;

    public d(e eVar, Iterator it) {
        this.f19944b = it;
        this.f19945c = eVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f19944b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f19944b.next();
        this.f19943a = entry;
        return entry.getKey();
    }

    @Override // java.util.Iterator
    public final void remove() {
        C6195m.e(this.f19943a != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.f19943a.getValue();
        this.f19944b.remove();
        this.f19945c.f19946b.f19971d -= collection.size();
        collection.clear();
        this.f19943a = null;
    }
}
