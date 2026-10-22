package org.c.a.d;

import java.util.Objects;

/* JADX INFO: compiled from: CommentEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.c.a.a.c f40390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40391b;

    public d(org.c.a.a.c r1, String r2, org.c.a.c.a r3, org.c.a.c.a r4) {
        super(r3, r4);
        Objects.requireNonNull(r1, "Event Type must be provided.");
        this.f40390a = r1;
        Objects.requireNonNull(r2, "Value must be provided.");
        this.f40391b = r2;
    }

    public String b() {
        return this.f40391b;
    }

    public org.c.a.a.c c() {
        return this.f40390a;
    }

    @Override // org.c.a.d.g
    public String d() {
        return super.d() + "type=" + this.f40390a + ", value=" + this.f40391b;
    }

    @Override // org.c.a.d.g
    public g.a a() {
        return g.a.f40399b;
    }
}
