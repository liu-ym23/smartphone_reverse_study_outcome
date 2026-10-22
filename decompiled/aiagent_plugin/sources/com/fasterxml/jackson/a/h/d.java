package com.fasterxml.jackson.a.h;

/* JADX INFO: compiled from: DefaultIndenter.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12098a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f12099b = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final char[] f12100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12101e;
    private final String f;

    @Override // com.fasterxml.jackson.a.h.e.c, com.fasterxml.jackson.a.h.e.b
    public boolean a() {
        return false;
    }

    static {
        String r0 = System.getProperty("line.separator");     // Catch: Throwable -> L4
    L5:
        f12098a = r0;
        f12099b = new d("  ", r0);
        return;
    L4:
        r0 = "\n";
        goto L5
    }

    public d() {
        this("  ", f12098a);
    }

    public d(String r7, String r8) {
        this.f12101e = r7.length();
        this.f12100d = new char[r7.length() * 16];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= 16) goto L5;
        r7.getChars(0, r7.length(), this.f12100d, r3);
        r3 = r3 + r7.length();
        r2 = r2 + 1;
        goto L3
    L5:
        this.f = r8;
    }

    @Override // com.fasterxml.jackson.a.h.e.c, com.fasterxml.jackson.a.h.e.b
    public void a(com.fasterxml.jackson.a.h r4, int r5) {
        r4.c(this.f);
        if (r5 <= 0) goto L11;
        int r6 = r5 * this.f12101e;
    L5:
        char[] r0 = this.f12100d;
        if (r6 <= r0.length) goto L8;
        r4.b(r0, 0, r0.length);
        r6 = r6 - this.f12100d.length;
        goto L5
    L8:
        r4.b(r0, 0, r6);
        return;
    }
}
