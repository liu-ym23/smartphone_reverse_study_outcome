package com.bytedance.android.livesdk.gift.platform.business.dialog.topview;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f126598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout.LayoutParams f126599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f126600c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f126598a, r101.f126598a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f126599b, r101.f126599b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f126600c, r101.f126600c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f126598a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FrameLayout.LayoutParams r104 = this.f126599b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.f126600c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PanelTopView(view=" + this.f126598a + ", layoutParams=" + this.f126599b + ", callback=" + this.f126600c + ")";
    }

    public g(View r100, FrameLayout.LayoutParams r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        this.f126598a = r100;
        this.f126599b = r101;
        this.f126600c = r102;
    }
}
