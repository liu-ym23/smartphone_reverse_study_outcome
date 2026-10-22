package com.fasterxml.jackson.databind.b.a;

import java.io.Serializable;

/* JADX INFO: compiled from: NullsAsEmptyProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class p implements com.fasterxml.jackson.databind.b.s, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<?> f12321a;

    public p(com.fasterxml.jackson.databind.l<?> r1) {
        this.f12321a = r1;
    }

    @Override // com.fasterxml.jackson.databind.b.s
    public Object a(com.fasterxml.jackson.databind.h r1) {
        return this.f12321a.c(r1);
    }
}
