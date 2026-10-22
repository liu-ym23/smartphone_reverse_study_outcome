package com.fasterxml.jackson.databind.h.a;

/* JADX INFO: compiled from: TypeIdResolverBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r implements com.fasterxml.jackson.databind.h.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k.o f12738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12739e;

    @Override // com.fasterxml.jackson.databind.h.f
    public void a(com.fasterxml.jackson.databind.k r1) {
    }

    @Override // com.fasterxml.jackson.databind.h.f
    public String b() {
        return null;
    }

    public r(com.fasterxml.jackson.databind.k r1, com.fasterxml.jackson.databind.k.o r2) {
        this.f12739e = r1;
        this.f12738d = r2;
    }

    @Override // com.fasterxml.jackson.databind.h.f
    public String a() {
        return a(null, this.f12739e.e());
    }

    @Override // com.fasterxml.jackson.databind.h.f
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.e r2, String r3) {
        throw new IllegalStateException("Sub-class " + getClass().getName() + " MUST implement `typeFromId(DatabindContext,String)");
    }
}
