package com.a.c.c.a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OnDayOfCalendarValueGenerator.java */
/* JADX INFO: loaded from: classes.dex */
abstract class l extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f3157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f3158b;

    l(com.a.c.b.a r1, int r2, int r3) {
        super(r1);
        this.f3157a = r2;
        this.f3158b = r3;
    }

    @Override // com.a.c.c.a.h
    public List<Integer> a(int r3, int r4) {
        ArrayList r0 = new ArrayList();
        int r5 = a(r3);     // Catch: j -> L8
    L4:
        if (r5 >= r4) goto L7;
        r0.add(Integer.valueOf(r5));     // Catch: j -> L8
        r5 = a(r5);     // Catch: j -> L8
    L7:
        return r0;
    }
}
