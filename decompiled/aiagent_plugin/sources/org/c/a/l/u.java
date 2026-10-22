package org.c.a.l;

import java.util.Objects;

/* JADX INFO: compiled from: TagTuple.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f40511b;

    public u(String r2, String r3) {
        Objects.requireNonNull(r3, "Suffix must be provided.");
        this.f40510a = r2;
        this.f40511b = r3;
    }

    public String a() {
        return this.f40510a;
    }

    public String b() {
        return this.f40511b;
    }
}
