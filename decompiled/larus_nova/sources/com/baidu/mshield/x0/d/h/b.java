package com.baidu.mshield.x0.d.h;

/* JADX INFO: loaded from: classes39.dex */
public abstract class b implements a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32493a;

    public b() {
        this(5);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public b(int r100) {
        this.f32493a = r100;
    }

    public int a(b r100) {
        return r100.f32493a - this.f32493a;
    L5:
        th = move-exception;
        com.baidu.mshield.x0.d.d.a(th);
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r100) {
        return a((b) r100);
    }
}
