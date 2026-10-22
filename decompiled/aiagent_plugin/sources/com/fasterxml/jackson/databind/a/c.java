package com.fasterxml.jackson.databind.a;

import java.io.Serializable;

/* JADX INFO: compiled from: CoercionConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12190c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Boolean f12191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final b[] f12192b;

    static {
        f12190c = e.values().length;
    }

    public c() {
        this.f12192b = new b[f12190c];
        this.f12191a = null;
    }

    public b a(e r1) {
        return this.f12192b[r1.ordinal()];
    }

    public Boolean a() {
        return this.f12191a;
    }
}
