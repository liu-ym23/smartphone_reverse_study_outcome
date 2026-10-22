package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class F1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f20018a = -1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f20019b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator f20020c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ J1 f20021d;

    public /* synthetic */ F1(J1 j12, E1 e12) {
        this.f20021d = j12;
    }

    public final Iterator a() {
        if (this.f20020c == null) {
            this.f20020c = this.f20021d.f20031c.entrySet().iterator();
        }
        return this.f20020c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.f20018a + 1;
        J1 j12 = this.f20021d;
        if (i10 >= j12.f20030b) {
            return !j12.f20031c.isEmpty() && a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f20019b = true;
        int i10 = this.f20018a + 1;
        this.f20018a = i10;
        J1 j12 = this.f20021d;
        return i10 < j12.f20030b ? (D1) j12.f20029a[i10] : (Map.Entry) a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f20019b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f20019b = false;
        this.f20021d.r();
        int i10 = this.f20018a;
        J1 j12 = this.f20021d;
        if (i10 >= j12.f20030b) {
            a().remove();
        } else {
            this.f20018a = i10 - 1;
            j12.p(i10);
        }
    }
}
