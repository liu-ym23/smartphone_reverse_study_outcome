package com.bytedance.android.anya;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f41727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f41728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f41729c;

    public final T a() {
        if (Intrinsics.areEqual(this.f41728b, g0.f41616a) == false) goto L6;
        return null;
    L6:
        return this.f41728b;
    }

    public final T b() {
        if (Intrinsics.areEqual(this.f41727a, g0.f41616a) == false) goto L6;
        return null;
    L6:
        return this.f41727a;
    }

    public j(T r100, T r101, boolean r102) {
        this.f41727a = r100;
        this.f41728b = r101;
        this.f41729c = r102;
    }
}
