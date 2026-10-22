package com.stepos.common.alphame;

/* loaded from: classes.dex */
abstract class b {

    /* renamed from: b, reason: collision with root package name */
    private static int f13552b;

    /* renamed from: a, reason: collision with root package name */
    private int f13553a = b();

    private static synchronized int b() {
        int i5;
        i5 = f13552b + 1;
        f13552b = i5;
        return i5;
    }

    public int a() {
        return this.f13553a;
    }
}
