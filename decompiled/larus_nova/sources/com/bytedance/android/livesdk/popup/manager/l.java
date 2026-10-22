package com.bytedance.android.livesdk.popup.manager;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class l implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f156311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f156312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f156313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f156314d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L14;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f156311a, r101.f156311a) == true) goto L8;
        return false;
    L8:
        if (this.f156312b == r101.f156312b) goto L10;
        return false;
    L10:
        if (this.f156313c == r101.f156313c) goto L12;
        return false;
    L12:
        if (this.f156314d == r101.f156314d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f156311a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + this.f156312b) * 31) + this.f156313c) * 31) + this.f156314d;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "LocationParams(parent=" + this.f156311a + ", gravity=" + this.f156312b + ", x=" + this.f156313c + ", y=" + this.f156314d + ")";
    }

    public l(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f156311a = r100;
        this.f156312b = r101;
        this.f156313c = r102;
        this.f156314d = r103;
    }
}
