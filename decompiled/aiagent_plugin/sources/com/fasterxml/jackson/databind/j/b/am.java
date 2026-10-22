package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

/* JADX INFO: compiled from: ToEmptyObjectSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class am extends aj<Object> {
    @Override // com.fasterxml.jackson.databind.p
    public boolean a(com.fasterxml.jackson.databind.ac r1, Object r2) {
        return true;
    }

    public am(Class<?> r2) {
        super(r2, false);
    }

    public am(com.fasterxml.jackson.databind.k r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3) {
        r2.b(r1, 0);
        r2.k();
    }

    @Override // com.fasterxml.jackson.databind.p
    public void a(Object r1, com.fasterxml.jackson.a.h r2, com.fasterxml.jackson.databind.ac r3, com.fasterxml.jackson.databind.h.h r4) {
        r4.b(r2, r4.a(r2, r4.a(r1, com.fasterxml.jackson.a.n.f12152b)));
    }
}
