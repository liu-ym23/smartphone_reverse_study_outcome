package com.google.android.gms.internal.location;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f9967c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9968d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f9969e;

    public i(j jVar, int i4, int i5) {
        this.f9969e = jVar;
        this.f9967c = i4;
        this.f9968d = i5;
    }

    @Override // com.google.android.gms.internal.location.g
    public final int c() {
        return this.f9969e.d() + this.f9967c + this.f9968d;
    }

    @Override // com.google.android.gms.internal.location.g
    public final int d() {
        return this.f9969e.d() + this.f9967c;
    }

    @Override // com.google.android.gms.internal.location.g
    public final boolean e() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.g
    public final Object[] f() {
        return this.f9969e.f();
    }

    @Override // com.google.android.gms.internal.location.j, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final j subList(int i4, int i5) {
        com.airbnb.lottie.h.O(i4, i5, this.f9968d);
        int i6 = this.f9967c;
        return this.f9969e.subList(i4 + i6, i5 + i6);
    }

    @Override // java.util.List
    public final Object get(int i4) {
        com.airbnb.lottie.h.M(i4, this.f9968d);
        return this.f9969e.get(i4 + this.f9967c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9968d;
    }
}
