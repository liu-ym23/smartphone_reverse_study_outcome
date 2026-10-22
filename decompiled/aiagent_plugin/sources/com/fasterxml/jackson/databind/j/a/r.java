package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.j.b.aj;

/* JADX INFO: compiled from: UnsupportedTypeSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends aj<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f12849b;

    public r(com.fasterxml.jackson.databind.k r2, String r3) {
        super(Object.class);
        this.f12848a = r2;
        this.f12849b = r3;
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, ac r3) {
        r3.b(this.f12848a, this.f12849b);
    }
}
