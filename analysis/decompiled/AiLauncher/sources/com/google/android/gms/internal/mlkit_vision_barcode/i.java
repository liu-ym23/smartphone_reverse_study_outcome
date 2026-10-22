package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public final class i extends g implements ListIterator {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f19955d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar) {
        super(jVar);
        this.f19955d = jVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        boolean zIsEmpty = this.f19955d.isEmpty();
        a();
        ((ListIterator) this.f19947a).add(obj);
        this.f19955d.f19956f.f19971d++;
        if (zIsEmpty) {
            this.f19955d.b();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return ((ListIterator) this.f19947a).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return ((ListIterator) this.f19947a).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        return ((ListIterator) this.f19947a).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return ((ListIterator) this.f19947a).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        ((ListIterator) this.f19947a).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, int i10) {
        super(jVar, ((List) jVar.f19951b).listIterator(i10));
        this.f19955d = jVar;
    }
}
