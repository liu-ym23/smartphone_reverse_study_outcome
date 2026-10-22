package com.bytedance.crash.dumper.a;

/* JADX INFO: compiled from: StringDumper.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f7397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f7398b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f7399c;

    static {
        f7397a = new char[]{'t', 'r', 'u', 'e'};
        f7398b = new char[]{'f', 'a', 'l', 's', 'e'};
    }

    public i(String r1) {
        this.f7399c = a(r1);
    }

    private a a(String r1) {
        return new b(r1);
    L5:
        return new c(r1);
    }

    public i b(boolean r2) {
        if (r2 == false) goto L4;
        this.f7399c.a(f7397a);
    L5:
        return this;
    L4:
        this.f7399c.a(f7398b);
        goto L5
    }

    public i a(char r2) {
        this.f7399c.a(r2);
        return this;
    }

    public i b(int r2) {
        this.f7399c.a(r2);
        return this;
    }

    public i b(long r2) {
        this.f7399c.a(r2);
        return this;
    }

    public i a(char[] r2) {
        this.f7399c.a(r2);
        return this;
    }

    public i c(String r2) {
        if (r2 == null) goto L4;
        this.f7399c.a(r2);
    L4:
        return this;
    }

    public i a(Throwable r3) {
        c(r3.getClass().getName());
        String r4 = r3.getLocalizedMessage();
        if (r4 == null) goto L5;
        a(':').a(' ').c(r4);
    L5:
        return this;
    }

    public i f() {
        this.f7399c.b();
        return this;
    }
}
