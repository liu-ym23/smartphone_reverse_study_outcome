package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.e3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f96588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3 f96589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3 f96590c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L12;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f96588a, r101.f96588a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f96589b, r101.f96589b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f96590c, r101.f96590c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        s r100 = this.f96588a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e3 r104 = this.f96589b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        c3 r107 = this.f96590c;
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
        return "PenalBattleStats(penalInfo=" + this.f96588a + ", message=" + this.f96589b + ", battleStatsMeta=" + this.f96590c + ")";
    }

    public r(s r100, c3 r101) {
        Intrinsics.checkNotNullParameter(r100, "penalInfo");
        this.f96588a = r100;
        this.f96589b = null;
        this.f96590c = r101;
    }
}
