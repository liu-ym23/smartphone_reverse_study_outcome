package com.fasterxml.jackson.databind.b.a;

/* JADX INFO: compiled from: UnsupportedTypeDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class ac extends com.fasterxml.jackson.databind.b.b.ab<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f12271b;

    public ac(com.fasterxml.jackson.databind.k r1, String r2) {
        super(r1);
        this.f12270a = r1;
        this.f12271b = r2;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        if (r3.l() != com.fasterxml.jackson.a.n.g) goto L9;
        Object r5 = r3.N();
        if (r5 != null) goto L7;
    L8:
        return r5;
    L7:
        if (this.f12270a.e().isAssignableFrom(r5.getClass()) == true) goto L8;
    L9:
        r4.b(this.f12270a, this.f12271b);
        return null;
    }
}
