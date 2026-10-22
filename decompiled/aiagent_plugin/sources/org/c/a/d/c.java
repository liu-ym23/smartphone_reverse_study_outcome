package org.c.a.d;

import java.util.Objects;

/* JADX INFO: compiled from: CollectionStartEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f40388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.c.a.a.EnumC1093a f40389c;

    public c(String r1, String r2, boolean r3, org.c.a.c.a r4, org.c.a.c.a r5, org.c.a.a.EnumC1093a r6) {
        super(r1, r4, r5);
        this.f40387a = r2;
        this.f40388b = r3;
        Objects.requireNonNull(r6, "Flow style must be provided.");
        this.f40389c = r6;
    }

    public String b() {
        return this.f40387a;
    }

    public boolean c() {
        return this.f40388b;
    }

    @Override // org.c.a.d.k, org.c.a.d.g
    public String d() {
        return super.d() + ", tag=" + this.f40387a + ", implicit=" + this.f40388b;
    }

    public boolean e() {
        if (org.c.a.a.EnumC1093a.f40311a != this.f40389c) goto L5;
        return true;
    L5:
        return false;
    }
}
