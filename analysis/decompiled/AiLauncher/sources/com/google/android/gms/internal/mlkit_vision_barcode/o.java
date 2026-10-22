package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import z2.C6195m;
import z2.C6265t;

/* loaded from: classes2.dex */
public abstract class o implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f19961a;

    /* renamed from: b, reason: collision with root package name */
    public int f19962b;

    /* renamed from: c, reason: collision with root package name */
    public int f19963c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzci f19964d;

    public /* synthetic */ o(zzci zzciVar, C6265t c6265t) {
        this.f19964d = zzciVar;
        this.f19961a = zzciVar.f19977e;
        this.f19962b = zzciVar.j();
    }

    public abstract Object a(int i10);

    public final void b() {
        if (this.f19964d.f19977e != this.f19961a) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f19962b >= 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        b();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f19962b;
        this.f19963c = i10;
        Object objA = a(i10);
        this.f19962b = this.f19964d.l(this.f19962b);
        return objA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        b();
        C6195m.e(this.f19963c >= 0, "no calls to next() since the last call to remove()");
        this.f19961a += 32;
        int i10 = this.f19963c;
        zzci zzciVar = this.f19964d;
        zzciVar.remove(zzci.m(zzciVar, i10));
        this.f19962b--;
        this.f19963c = -1;
    }
}
