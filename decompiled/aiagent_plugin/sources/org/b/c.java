package org.b;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes5.dex */
public interface c {
    String a();

    void a(String r1, Throwable r2);

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();

    default boolean a(org.b.a.b r3) {
        int r0 = r3.a();
        if (r0 == 0) goto L23;
        if (r0 == 10) goto L21;
        if (r0 == 20) goto L19;
        if (r0 == 30) goto L17;
        if (r0 != 40) goto L15;
        return f();
    L15:
        throw new IllegalArgumentException("Level [" + r3 + "] not recognized.");
    L17:
        return e();
    L19:
        return d();
    L21:
        return c();
    L23:
        return b();
    }
}
