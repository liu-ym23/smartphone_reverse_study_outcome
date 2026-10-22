package com.amap.api.col.jmsl;

import android.content.Context;

/* loaded from: classes.dex */
public class E0 {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f15996a;

    /* renamed from: b, reason: collision with root package name */
    public V0 f15997b;

    /* renamed from: c, reason: collision with root package name */
    public int f15998c = 1;

    public E0(InterfaceC1552f1 interfaceC1552f1, Context context, V0 v02) {
        this.f15996a = interfaceC1552f1;
        this.f15997b = v02;
    }

    public int a() {
        return this.f15998c;
    }

    public void b(int i10) {
        if (this.f15998c == i10) {
            return;
        }
        this.f15998c = i10;
        this.f15997b.f(i10, null);
    }

    public boolean c() {
        return false;
    }
}
