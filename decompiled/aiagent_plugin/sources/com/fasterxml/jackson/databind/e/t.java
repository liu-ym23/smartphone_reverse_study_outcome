package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Iterator;

/* JADX INFO: compiled from: BeanPropertyDefinition.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t implements com.fasterxml.jackson.databind.l.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final JsonInclude.Value f12668a = null;

    public ac A() {
        return null;
    }

    public abstract JsonInclude.Value B();

    @Override // com.fasterxml.jackson.databind.l.r
    public abstract String a();

    public abstract com.fasterxml.jackson.databind.x b();

    public abstract com.fasterxml.jackson.databind.x c();

    public abstract boolean d();

    public abstract com.fasterxml.jackson.databind.k f();

    public abstract Class<?> g();

    public abstract com.fasterxml.jackson.databind.w h();

    public abstract boolean k();

    public abstract boolean l();

    public abstract boolean m();

    public abstract k n();

    public abstract k o();

    public abstract h p();

    public abstract n q();

    public abstract j v();

    public Class<?>[] w() {
        return null;
    }

    public com.fasterxml.jackson.databind.b.a x() {
        return null;
    }

    public boolean z() {
        return false;
    }

    public t() {
    }

    static {
        f12668a = JsonInclude.Value.empty();
    }

    public boolean a(com.fasterxml.jackson.databind.x r1) {
        return b().equals(r1);
    }

    public boolean e() {
        return d();
    }

    public boolean i() {
        if (t() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean j() {
        if (s() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Iterator<n> r() {
        return com.fasterxml.jackson.databind.l.h.a();
    }

    public j s() {
        k r0 = n();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return p();
    }

    public j t() {
        n r0 = q();
        if (r0 != null) goto L8;
        k r1 = o();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return p();
    L8:
        return r0;
    }

    public j u() {
        k r0 = o();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return p();
    }

    public String y() {
        com.fasterxml.jackson.databind.b.a r0 = x();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }
}
