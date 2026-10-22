package com.google.android.material.transition.platform;

/* JADX INFO: compiled from: FadeModeResult.java */
/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f13752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f13753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f13754c;

    static c a(int r2, int r3) {
        return new c(r2, r3, false);
    }

    static c b(int r2, int r3) {
        return new c(r2, r3, true);
    }

    private c(int r1, int r2, boolean r3) {
        this.f13752a = r1;
        this.f13753b = r2;
        this.f13754c = r3;
    }
}
