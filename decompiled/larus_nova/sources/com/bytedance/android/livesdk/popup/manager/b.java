package com.bytedance.android.livesdk.popup.manager;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f156300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f156301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f156302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f156303d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f156300a, r101.f156300a) == true) goto L8;
        return false;
    L8:
        if (this.f156301b == r101.f156301b) goto L10;
        return false;
    L10:
        if (this.f156302c == r101.f156302c) goto L12;
        return false;
    L12:
        if (this.f156303d == r101.f156303d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f156300a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + this.f156301b) * 31) + this.f156302c) * 31) + this.f156303d;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "DropDownParams(anchor=" + this.f156300a + ", xoff=" + this.f156301b + ", yoff=" + this.f156302c + ", gravity=" + this.f156303d + ")";
    }

    public b(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        this.f156300a = r100;
        this.f156301b = r101;
        this.f156302c = r102;
        this.f156303d = r103;
    }
}
