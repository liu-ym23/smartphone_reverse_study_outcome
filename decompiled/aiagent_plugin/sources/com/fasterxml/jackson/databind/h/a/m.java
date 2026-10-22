package com.fasterxml.jackson.databind.h.a;

/* JADX INFO: compiled from: MinimalClassNameIdResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f12722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f12723c;

    public m(com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.k.o r3, com.fasterxml.jackson.databind.h.c r4) {
        super(r2, r3, r4);
        String r5 = r2.e().getName();
        int r6 = r5.lastIndexOf(46);
        if (r6 >= 0) goto L5;
        this.f12722b = "";
        this.f12723c = ".";
        return;
    L5:
        this.f12723c = r5.substring(0, r6 + 1);
        this.f12722b = r5.substring(0, r6);
    }

    public static m b(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.h.c r3) {
        return new m(r1, r2.o(), r3);
    }

    @Override // com.fasterxml.jackson.databind.h.a.k, com.fasterxml.jackson.databind.h.f
    public String a(Object r2) {
        String r3 = r2.getClass().getName();
        if (r3.startsWith(this.f12723c) == true) goto L5;
        return r3;
    L5:
        return r3.substring(this.f12723c.length() - 1);
    }

    @Override // com.fasterxml.jackson.databind.h.a.k
    public com.fasterxml.jackson.databind.k a(String r4, com.fasterxml.jackson.databind.e r5) {
        if (r4.startsWith(".") == false) goto L10;
        StringBuilder r0 = new StringBuilder(r4.length() + this.f12722b.length());
        if (this.f12722b.isEmpty() == false) goto L7;
        r0.append(r4.substring(1));
    L8:
        r4 = r0.toString();
        goto L10
    L7:
        r0.append(this.f12722b).append(r4);
    L10:
        return super.a(r4, r5);
    }
}
