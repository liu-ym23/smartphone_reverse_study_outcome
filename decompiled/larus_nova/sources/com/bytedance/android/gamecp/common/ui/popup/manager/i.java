package com.bytedance.android.gamecp.common.ui.popup.manager;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f57051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f57052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f57054d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f57051a, r101.f57051a) == true) goto L8;
        return false;
    L8:
        if (this.f57052b == r101.f57052b) goto L10;
        return false;
    L10:
        if (this.f57053c == r101.f57053c) goto L12;
        return false;
    L12:
        if (this.f57054d == r101.f57054d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f57051a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + this.f57052b) * 31) + this.f57053c) * 31) + this.f57054d;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "LocationParams(parent=" + this.f57051a + ", gravity=" + this.f57052b + ", x=" + this.f57053c + ", y=" + this.f57054d + ")";
    }

    public i(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f57051a = r100;
        this.f57052b = r101;
        this.f57053c = r102;
        this.f57054d = r103;
    }
}
