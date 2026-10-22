package org.c.a.l;

import java.util.Objects;

/* JADX INFO: compiled from: CommentToken.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.c.a.a.c f40502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40503b;

    public g(org.c.a.a.c r1, String r2, org.c.a.c.a r3, org.c.a.c.a r4) {
        super(r3, r4);
        Objects.requireNonNull(r1);
        this.f40502a = r1;
        Objects.requireNonNull(r2);
        this.f40503b = r2;
    }

    public org.c.a.a.c a() {
        return this.f40502a;
    }

    public String c() {
        return this.f40503b;
    }

    @Override // org.c.a.l.v
    public v.a b() {
        return v.a.v;
    }
}
