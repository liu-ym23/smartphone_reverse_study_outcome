package com.bytedance.android.live.liveinteract.utils;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f78786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f78787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f78788c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f78789d;

    public k0() {
    }

    public final void b() {
        this.f78786a = null;
        this.f78787b = 0;
        this.f78788c = 0;
    }

    public final void a(String[] r100, int[] r101) {
        String r102 = this.f78786a;
        if (r102 == null) goto L25;
        if (r100 == null) goto L26;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r100.length != r101.length) goto L30;
        Integer r103 = Integer.valueOf(ArraysKt.indexOf(r100, r102));
        if (r103.intValue() == (-1)) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 != null) goto L18;
        return;
    L18:
        if (j22.c.c(r101[r103.intValue()], this.f78789d) > 0) goto L20;
        this.f78788c = 0;
        return;
    L20:
        if (this.f78788c <= 0) goto L22;
        this.f78787b += System.currentTimeMillis() - this.f78788c;
    L22:
        this.f78788c = System.currentTimeMillis();
        return;
    L12:
        r104 = false;
        goto L13
    L30:
        return;
    L26:
        return;
    }

    public final void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f78786a = r100;
        this.f78787b = 0;
        this.f78788c = 0;
        this.f78789d = r101;
    }
}
