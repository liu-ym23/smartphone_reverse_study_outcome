package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.a5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f96550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5 f96551b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f96550a, r101.f96550a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f96551b, r101.f96551b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        s r100 = this.f96550a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a5 r104 = this.f96551b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BattleFinishToPenalMsg(penalInfo=" + this.f96550a + ", message=" + this.f96551b + ")";
    }

    public b(s r100, a5 r101) {
        Intrinsics.checkNotNullParameter(r100, "penalInfo");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f96550a = r100;
        this.f96551b = r101;
    }
}
