package com.bytedance.android.live.room.api.messagewindow.monitor;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f99000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f99001b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f99000a, r101.f99000a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f99001b, r101.f99001b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f99000a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f99001b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CardLogParams(eventName=" + this.f99000a + ", extra=" + this.f99001b + ")";
    }

    public b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f99000a = r100;
        this.f99001b = r101;
    }
}
