package com.bytedance.apm.n;

import java.util.LinkedList;

/* JADX INFO: compiled from: LimitQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<T> f4731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4732b;

    public a(int r2) {
        this.f4731a = new LinkedList();
        this.f4732b = r2;
    }

    public void a(T r3) {
        if (this.f4731a.size() <= this.f4732b) goto L5;
        this.f4731a.removeFirst();
    L5:
        this.f4731a.addLast(r3);
    }

    public LinkedList<T> a() {
        return this.f4731a;
    }
}
