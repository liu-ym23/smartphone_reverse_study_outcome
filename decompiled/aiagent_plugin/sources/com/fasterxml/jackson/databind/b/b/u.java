package com.fasterxml.jackson.databind.b.b;

/* JADX INFO: compiled from: NullifyingDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends ab<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f12467a = null;

    static {
        f12467a = new u();
    }

    public u() {
        super(Object.class);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        if (r1.a(com.fasterxml.jackson.a.n.f) == false) goto L10;
    L4:
        com.fasterxml.jackson.a.n r0 = r1.g();
        if (r0 == null) goto L15;
        if (r0 == com.fasterxml.jackson.a.n.f12153c) goto L16;
        r1.k();
        goto L4
    L16:
        return null;
    L15:
        return null;
    L10:
        r1.k();
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.h.e r4) {
        int r1 = r2.m();
        if (r1 == 1) goto L11;
        if (r1 == 3) goto L11;
        if (r1 == 5) goto L11;
        return null;
    L11:
        return r4.d(r2, r3);
    }
}
