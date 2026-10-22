package com.bytedance.crash.dumper.a;

/* JADX INFO: compiled from: BaseStringDumper.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f7386a;

    abstract void a();

    abstract void a(char r1);

    abstract void a(int r1);

    abstract void a(long r1);

    abstract void a(String r1);

    abstract void a(char[] r1);

    abstract void b();

    a() {
    }

    d a(String r1, int r2) {
        g r0 = g.a(r1, r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return e.b(r1);
    }
}
