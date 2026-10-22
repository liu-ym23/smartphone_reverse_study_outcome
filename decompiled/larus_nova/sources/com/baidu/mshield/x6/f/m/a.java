package com.baidu.mshield.x6.f.m;

import com.baidu.mshield.x6.f.f;

/* JADX INFO: loaded from: classes39.dex */
public abstract class a implements d<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32624a;

    public a() {
        this(5);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public a(int r100) {
        this.f32624a = r100;
    }

    public int a(a r100) {
        return r100.f32624a - this.f32624a;
    L5:
        th = move-exception;
        f.b(th);
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r100) {
        return a((a) r100);
    }
}
