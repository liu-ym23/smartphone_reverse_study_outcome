package com.bytedance.reparo.core.b;

/* JADX INFO: compiled from: PatchException.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9157a;

    public d(String r1, int r2) {
        super(r1);
        this.f9157a = 0;
        this.f9157a = r2;
    }

    public d(String r1, Throwable r2, int r3) {
        super(r1, r2);
        this.f9157a = 0;
        this.f9157a = r3;
    }

    public int a() {
        return this.f9157a;
    }
}
