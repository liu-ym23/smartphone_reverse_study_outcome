package com.fasterxml.jackson.a;

/* JADX INFO: compiled from: JsonStreamContext.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f12149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f12150b;

    public abstract m a();

    public void a(Object r1) {
    }

    public abstract String h();

    public Object i() {
        return null;
    }

    public m() {
    }

    public m(m r2) {
        this.f12149a = r2.f12149a;
        this.f12150b = r2.f12150b;
    }

    public m(int r1, int r2) {
        this.f12149a = r1;
        this.f12150b = r2;
    }

    public final boolean b() {
        if (this.f12149a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean c() {
        if (this.f12149a != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean d() {
        if (this.f12149a != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public String e() {
        int r1 = this.f12149a;
        if (r1 != 0) goto L5;
        return "root";
    L5:
        if (r1 != 1) goto L7;
        return "Array";
    L7:
        if (r1 == 2) goto L10;
        return "?";
    L10:
        return "Object";
    }

    public final int f() {
        return this.f12150b + 1;
    }

    public final int g() {
        int r0 = this.f12150b;
        if (r0 >= 0) goto L6;
        return 0;
    L6:
        return r0;
    }

    public i a(com.fasterxml.jackson.a.d.d r1) {
        return i.f12130a;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(64);
        int r1 = this.f12149a;
        if (r1 != 0) goto L5;
        r0.append("/");
    L14:
        return r0.toString();
    L5:
        if (r1 == 1) goto L11;
        r0.append('{');
        String r3 = h();
        if (r3 == null) goto L9;
        r0.append('\"');
        com.fasterxml.jackson.a.d.b.a(r0, r3);
        r0.append('\"');
    L10:
        r0.append('}');
        goto L14
    L9:
        r0.append('?');
        goto L10
    L11:
        r0.append('[');
        r0.append(g());
        r0.append(']');
        goto L14
    }
}
