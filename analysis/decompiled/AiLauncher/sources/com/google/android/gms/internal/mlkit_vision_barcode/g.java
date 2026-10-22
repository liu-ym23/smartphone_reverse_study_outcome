package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class g implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f19947a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection f19948b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f19949c;

    public g(h hVar, Iterator it) {
        this.f19949c = hVar;
        this.f19948b = hVar.f19951b;
        this.f19947a = it;
    }

    public final void a() {
        this.f19949c.zzb();
        if (this.f19949c.f19951b != this.f19948b) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.f19947a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        a();
        return this.f19947a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f19947a.remove();
        zzbr zzbrVar = this.f19949c.f19954e;
        zzbrVar.f19971d--;
        this.f19949c.c();
    }

    public g(h hVar) {
        this.f19949c = hVar;
        Collection collection = hVar.f19951b;
        this.f19948b = collection;
        this.f19947a = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }
}
