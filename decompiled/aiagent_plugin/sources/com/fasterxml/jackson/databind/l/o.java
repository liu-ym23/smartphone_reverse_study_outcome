package com.fasterxml.jackson.databind.l;

/* JADX INFO: compiled from: LinkedNode.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f13046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o<T> f13047b;

    public o(T r1, o<T> r2) {
        this.f13046a = r1;
        this.f13047b = r2;
    }

    public void a(o<T> r2) {
        if (this.f13047b != null) goto L7;
        this.f13047b = r2;
        return;
    L7:
        throw new IllegalStateException();
    }

    public o<T> a() {
        return this.f13047b;
    }

    public T b() {
        return this.f13046a;
    }
}
