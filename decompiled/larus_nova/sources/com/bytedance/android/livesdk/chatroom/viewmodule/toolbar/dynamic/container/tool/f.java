package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f116075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f116076b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (this.f116075a == r101.f116075a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f116076b, r101.f116076b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f116075a * 31;
        View r101 = this.f116076b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "DataViewItem(id=" + this.f116075a + ", view=" + this.f116076b + ")";
    }

    public f(int r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        this.f116075a = r100;
        this.f116076b = r101;
    }
}
