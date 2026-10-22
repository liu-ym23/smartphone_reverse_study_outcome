package com.bytedance.android.livesdk.livecommerce.room;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f151847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f151848b;

    public g() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f151847a, r101.f151847a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f151848b, r101.f151848b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f151847a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Bundle r104 = this.f151848b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EnterRoomInfo(clickFrom=" + this.f151847a + ", businessArg=" + this.f151848b + ")";
    }

    public g(int r100) {
        Bundle r101 = new Bundle();
        Intrinsics.checkNotNullParameter("UNKNOW", "clickFrom");
        Intrinsics.checkNotNullParameter(r101, "businessArg");
        this.f151847a = "UNKNOW";
        this.f151848b = r101;
    }
}
