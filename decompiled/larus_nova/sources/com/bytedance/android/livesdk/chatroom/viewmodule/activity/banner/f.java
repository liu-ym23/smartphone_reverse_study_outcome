package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f115178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f115179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f115180c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f115178a, r101.f115178a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f115179b, r101.f115179b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f115180c, r101.f115180c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f115178a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        View r104 = this.f115179b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f115180c;
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
        return "PortraitBannerViewHolder(taskIndicator=" + this.f115178a + ", activityIndicator=" + this.f115179b + ", rightSpaceView=" + this.f115180c + ")";
    }

    public f(View r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, "activityIndicator");
        this.f115178a = r100;
        this.f115179b = r101;
        this.f115180c = r102;
    }
}
