package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ConcreteBeanPropertyBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class w implements com.fasterxml.jackson.databind.d, Serializable {
    protected final com.fasterxml.jackson.databind.w t;
    protected transient List<com.fasterxml.jackson.databind.x> u;

    public w(com.fasterxml.jackson.databind.w r1) {
        if (r1 != null) goto L5;
        r1 = com.fasterxml.jackson.databind.w.f13127c;
    L5:
        this.t = r1;
    }

    public w(w r1) {
        this.t = r1.t;
    }

    public boolean s() {
        return this.t.a();
    }

    @Override // com.fasterxml.jackson.databind.d
    public com.fasterxml.jackson.databind.w c() {
        return this.t;
    }

    @Override // com.fasterxml.jackson.databind.d
    public JsonFormat.Value a(com.fasterxml.jackson.databind.a.m<?> r1, Class<?> r2) {
        JsonFormat.Value r3 = r1.f(r2);
        com.fasterxml.jackson.databind.b r4 = r1.j();
        if (r4 == null) goto L7;
        j r0 = d();
        if (r0 == null) goto L7;
        JsonFormat.Value r5 = r4.f(r0);
    L8:
        if (r3 != null) goto L12;
        if (r5 == null) goto L11;
        return r5;
    L11:
        return f12557a;
    L12:
        if (r5 != null) goto L15;
        return r3;
    L15:
        return r3.withOverrides(r5);
    L7:
        r5 = null;
        goto L8
    }

    @Override // com.fasterxml.jackson.databind.d
    public JsonInclude.Value b(com.fasterxml.jackson.databind.a.m<?> r3, Class<?> r4) {
        com.fasterxml.jackson.databind.b r0 = r3.j();
        j r2 = d();
        if (r2 == null) goto L5;
        JsonInclude.Value r5 = r3.a(r4, r2.c());
        if (r0 != null) goto L9;
        return r5;
    L9:
        JsonInclude.Value r6 = r0.s(r2);
        if (r5 != null) goto L13;
        return r6;
    L13:
        return r5.withOverrides(r6);
    L5:
        return r3.e(r4);
    }

    public List<com.fasterxml.jackson.databind.x> a(com.fasterxml.jackson.databind.a.m<?> r3) {
        List<com.fasterxml.jackson.databind.x> r0 = this.u;
        if (r0 != null) goto L12;
        com.fasterxml.jackson.databind.b r4 = r3.j();
        if (r4 == null) goto L9;
        j r1 = d();
        if (r1 == null) goto L9;
        r0 = r4.k(r1);
    L9:
        if (r0 != null) goto L11;
        r0 = Collections.emptyList();
    L11:
        this.u = r0;
    L12:
        return r0;
    }
}
