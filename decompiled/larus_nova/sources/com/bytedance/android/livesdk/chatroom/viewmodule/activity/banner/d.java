package com.bytedance.android.livesdk.chatroom.viewmodule.activity.banner;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f115174a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f115174a, ((d) r100).f115174a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f115174a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LandscapeBannerViewHolder(activityIndicator=" + this.f115174a + ")";
    }

    public d(View r100) {
        this.f115174a = r100;
    }
}
