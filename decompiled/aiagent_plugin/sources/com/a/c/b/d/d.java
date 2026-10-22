package com.a.c.b.d;

import java.io.Serializable;

/* JADX INFO: compiled from: SpecialCharFieldValue.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends a<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f3137a;

    @Override // com.a.c.b.d.a
    public /* synthetic */ Serializable a() {
        return b();
    }

    public d(c r2) {
        this.f3137a = c.f;
        com.a.e.a.a(r2, "special char must not be null");
        this.f3137a = r2;
    }

    public c b() {
        return this.f3137a;
    }
}
