package com.fasterxml.jackson.b.a.a.a;

import com.fasterxml.jackson.a.k;

/* JADX INFO: compiled from: MarkedYAMLException.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class a extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final org.c.a.c.b f12168b;

    public a(k r1, org.c.a.c.b r2) {
        super(r1, r2);
        this.f12168b = r2;
    }

    public static a a(k r1, org.c.a.c.b r2) {
        return new a(r1, r2);
    }

    public String getContext() {
        return this.f12168b.getContext();
    }
}
