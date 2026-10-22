package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.c5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f96552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c5 f96553b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f96552a, r101.f96552a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f96553b, r101.f96553b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        v r100 = this.f96552a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c5 r104 = this.f96553b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleOpenMsg(pkInfo=" + this.f96552a + ", message=" + this.f96553b + ")";
    }

    public c(v r100, c5 r101) {
        Intrinsics.checkNotNullParameter(r100, "pkInfo");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f96552a = r100;
        this.f96553b = r101;
    }
}
