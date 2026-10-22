package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.databind.e.b;

/* JADX INFO: compiled from: AnnotatedAndMetadata.java */
/* JADX INFO: loaded from: classes2.dex */
public class c<A extends b, M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f12608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final M f12609b;

    public c(A r1, M r2) {
        this.f12608a = r1;
        this.f12609b = r2;
    }

    public static <A extends b, M> c<A, M> a(A r1, M r2) {
        return new c(r1, r2);
    }
}
