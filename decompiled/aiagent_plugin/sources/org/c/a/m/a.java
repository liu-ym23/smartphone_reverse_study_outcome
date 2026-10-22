package org.c.a.m;

import java.util.ArrayList;

/* JADX INFO: compiled from: ArrayStack.java */
/* JADX INFO: loaded from: classes5.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<T> f40519a;

    public a(int r2) {
        this.f40519a = new ArrayList(r2);
    }

    public void a(T r1) {
        this.f40519a.add(r1);
    }

    public T a() {
        ArrayList<T> r1 = this.f40519a;
        return r1.remove(r1.size() - 1);
    }

    public boolean b() {
        return this.f40519a.isEmpty();
    }
}
