package com.fasterxml.jackson.a.h;

import java.io.Serializable;

/* JADX INFO: compiled from: MinimalPrettyPrinter.java */
/* JADX INFO: loaded from: classes2.dex */
public class l implements com.fasterxml.jackson.a.p, Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f12112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected n f12113d;

    @Override // com.fasterxml.jackson.a.p
    public void g(com.fasterxml.jackson.a.h r1) {
    }

    @Override // com.fasterxml.jackson.a.p
    public void h(com.fasterxml.jackson.a.h r1) {
    }

    public l() {
        this(f12157b.toString());
    }

    public l(String r1) {
        this.f12112c = r1;
        this.f12113d = f12156a;
    }

    @Override // com.fasterxml.jackson.a.p
    public void a(com.fasterxml.jackson.a.h r1) {
        String r0 = this.f12112c;
        if (r0 == null) goto L6;
        r1.c(r0);
        return;
    }

    @Override // com.fasterxml.jackson.a.p
    public void b(com.fasterxml.jackson.a.h r1) {
        r1.a('{');
    }

    @Override // com.fasterxml.jackson.a.p
    public void d(com.fasterxml.jackson.a.h r1) {
        r1.a(this.f12113d.b());
    }

    @Override // com.fasterxml.jackson.a.p
    public void c(com.fasterxml.jackson.a.h r1) {
        r1.a(this.f12113d.c());
    }

    @Override // com.fasterxml.jackson.a.p
    public void a(com.fasterxml.jackson.a.h r1, int r2) {
        r1.a('}');
    }

    @Override // com.fasterxml.jackson.a.p
    public void e(com.fasterxml.jackson.a.h r1) {
        r1.a('[');
    }

    @Override // com.fasterxml.jackson.a.p
    public void f(com.fasterxml.jackson.a.h r1) {
        r1.a(this.f12113d.d());
    }

    @Override // com.fasterxml.jackson.a.p
    public void b(com.fasterxml.jackson.a.h r1, int r2) {
        r1.a(']');
    }
}
