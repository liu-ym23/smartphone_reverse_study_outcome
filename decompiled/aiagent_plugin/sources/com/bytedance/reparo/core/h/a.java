package com.bytedance.reparo.core.h;

/* JADX INFO: compiled from: BasePatch.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f9251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9252b;

    public boolean e() {
        return true;
    }

    public a() {
        this.f9251a = -1;
        this.f9252b = false;
    }

    public boolean a() {
        return this.f9252b;
    }

    public void a(boolean r1) {
        this.f9252b = r1;
    }

    public void b() {
        this.f9251a = 0;
    }

    public void c() {
        this.f9251a = 1;
    }

    public boolean d() {
        if (this.f9251a != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
