package com.bytedance.android.gamecp.common.ui.popup.manager;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f57041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f57042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f57044d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f57041a, r101.f57041a) == true) goto L8;
        return false;
    L8:
        if (this.f57042b == r101.f57042b) goto L10;
        return false;
    L10:
        if (this.f57043c == r101.f57043c) goto L12;
        return false;
    L12:
        if (this.f57044d == r101.f57044d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f57041a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + this.f57042b) * 31) + this.f57043c) * 31) + this.f57044d;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "DropDownParams(anchor=" + this.f57041a + ", xoff=" + this.f57042b + ", yoff=" + this.f57043c + ", gravity=" + this.f57044d + ")";
    }

    public a(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "anchor");
        this.f57041a = r100;
        this.f57042b = r101;
        this.f57043c = r102;
        this.f57044d = r103;
    }
}
