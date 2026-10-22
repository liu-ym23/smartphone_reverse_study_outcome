package com.google.android.gms.internal.location;

/* loaded from: classes.dex */
public final class h extends f {

    /* renamed from: c, reason: collision with root package name */
    public final j f9966c;

    public h(j jVar, int i4) {
        super(jVar.size(), i4);
        this.f9966c = jVar;
    }

    @Override // com.google.android.gms.internal.location.f
    public final Object b(int i4) {
        return this.f9966c.get(i4);
    }
}
