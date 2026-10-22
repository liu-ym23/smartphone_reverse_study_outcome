package com.google.android.material.transition;

/* JADX INFO: compiled from: FadeModeResult.java */
/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f13718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f13719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f13720c;

    static c a(int r2, int r3) {
        return new c(r2, r3, false);
    }

    static c b(int r2, int r3) {
        return new c(r2, r3, true);
    }

    private c(int r1, int r2, boolean r3) {
        this.f13718a = r1;
        this.f13719b = r2;
        this.f13720c = r3;
    }
}
