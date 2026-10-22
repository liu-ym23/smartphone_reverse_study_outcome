package com.bytedance.applet.jsb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class e1 implements a88.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f192054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f192055c;

    @Override // a88.d
    public final boolean b() {
        return this.f192055c;
    }

    @Override // a88.d
    public final boolean d() {
        return this.f192054b;
    }

    @Override // a88.d
    public final void a(String r100) {
        int r101 = f.f192056a;
        f.a(this.f192053a, 2);
        c0 r102 = c0.f192045a;
        c0.c(this.f192053a, 2);
    }

    @Override // a88.d
    public final void c(String r100) {
        int r101 = f.f192056a;
        f.a(this.f192053a, 1);
        c0 r102 = c0.f192045a;
        c0.c(this.f192053a, 1);
    }

    public e1(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        this.f192053a = r100;
        this.f192054b = r101;
        this.f192055c = r102;
    }
}
