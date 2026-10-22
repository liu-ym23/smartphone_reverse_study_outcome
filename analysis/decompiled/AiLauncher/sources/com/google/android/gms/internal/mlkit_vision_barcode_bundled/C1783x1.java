package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.x1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1783x1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f20151a;

    /* renamed from: b, reason: collision with root package name */
    public zzdd f20152b;

    public /* synthetic */ C1783x1(zzdf zzdfVar, C1779w1 c1779w1) {
        if (!(zzdfVar instanceof zzgd)) {
            this.f20151a = null;
            this.f20152b = (zzdd) zzdfVar;
            return;
        }
        zzgd zzgdVar = (zzgd) zzdfVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzgdVar.j());
        this.f20151a = arrayDeque;
        arrayDeque.push(zzgdVar);
        this.f20152b = b(zzgdVar.f20165d);
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzdd next() {
        zzdd zzddVarB;
        zzdd zzddVar = this.f20152b;
        if (zzddVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.f20151a;
            zzddVarB = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzddVarB = b(((zzgd) this.f20151a.pop()).f20166e);
        } while (zzddVarB.f() == 0);
        this.f20152b = zzddVarB;
        return zzddVar;
    }

    public final zzdd b(zzdf zzdfVar) {
        while (zzdfVar instanceof zzgd) {
            zzgd zzgdVar = (zzgd) zzdfVar;
            this.f20151a.push(zzgdVar);
            zzdfVar = zzgdVar.f20165d;
        }
        return (zzdd) zzdfVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f20152b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
