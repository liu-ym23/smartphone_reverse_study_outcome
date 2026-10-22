package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.view.ViewGroup;
import fd2.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f146538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f146539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146540c;

    @Override // fd2.g
    public final void a() {
    }

    @Override // fd2.g
    public final void b() {
        ViewGroup r100 = this.f146538a;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // fd2.g
    public final void onSelect() {
        ViewGroup r100 = this.f146538a;
        if (r100 == null) goto L6;
        r100.setVisibility(0);
        return;
    }

    @Override // fd2.g
    public final void unload() {
        c r100 = this.f146539b;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFrom");
        this.f146540c = r100;
    }

    @Override // fd2.g
    public final void c(fd2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f146538a = r100.f476476i;
        this.f146539b = new c();
        c r101 = this.f146539b;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        c r102 = this.f146539b;
        if (r102 == null) goto L9;
        r102.c(r100.f476469b, r100.f476470c, true, this.f146540c);
        return;
    }
}
