package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.j.b.aj;

/* JADX INFO: compiled from: FailingSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends aj<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f12805a;

    public c(String r2) {
        super(Object.class);
        this.f12805a = r2;
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, ac r3) {
        r3.b(this.f12805a, new Object[0]);
    }
}
