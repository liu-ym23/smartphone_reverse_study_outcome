package org.c.a.d;

import java.util.Objects;

/* JADX INFO: compiled from: ScalarEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.c.a.a.d f40407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f40408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h f40409d;

    public l(String r1, String r2, h r3, String r4, org.c.a.c.a r5, org.c.a.c.a r6, org.c.a.a.d r7) {
        super(r1, r5, r6);
        this.f40406a = r2;
        this.f40409d = r3;
        Objects.requireNonNull(r4, "Value must be provided.");
        this.f40408c = r4;
        Objects.requireNonNull(r7, "Style must be provided.");
        this.f40407b = r7;
    }

    public String b() {
        return this.f40406a;
    }

    public org.c.a.a.d c() {
        return this.f40407b;
    }

    public String e() {
        return this.f40408c;
    }

    public h i() {
        return this.f40409d;
    }

    @Override // org.c.a.d.k, org.c.a.d.g
    public String d() {
        return super.d() + ", tag=" + this.f40406a + ", " + this.f40409d + ", value=" + this.f40408c;
    }

    @Override // org.c.a.d.g
    public g.a a() {
        return g.a.g;
    }

    public boolean j() {
        if (this.f40407b != org.c.a.a.d.f40328e) goto L5;
        return true;
    L5:
        return false;
    }
}
