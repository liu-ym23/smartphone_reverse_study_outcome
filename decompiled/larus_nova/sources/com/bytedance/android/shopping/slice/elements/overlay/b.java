package com.bytedance.android.shopping.slice.elements.overlay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f183318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f183319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f183320c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f183318a, r101.f183318a) == true) goto L8;
        return false;
    L8:
        if (this.f183319b == r101.f183319b) goto L10;
        return false;
    L10:
        if (this.f183320c == r101.f183320c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f183318a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.f183319b) * 31) + this.f183320c;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "SlcImage(url=" + this.f183318a + ", width=" + this.f183319b + ", height=" + this.f183320c + ")";
    }

    public b(String r100, int r101, int r102) {
        this.f183318a = r100;
        this.f183319b = r101;
        this.f183320c = r102;
    }
}
