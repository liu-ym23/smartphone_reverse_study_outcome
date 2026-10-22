package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.e3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f96583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c3 f96584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.link.model.r.b f96585c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L12;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f96583a, r101.f96583a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f96584b, r101.f96584b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f96585c, r101.f96585c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        e3 r100 = this.f96583a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c3 r104 = this.f96584b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        com.bytedance.android.livesdk.link.model.r.b r107 = this.f96585c;
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
        return "LinkBattleStats(message=" + this.f96583a + ", battleStatsMeta=" + this.f96584b + ", bizExtra=" + this.f96585c + ")";
    }

    public o(c3 r100, com.bytedance.android.livesdk.link.model.r.b r101) {
        this.f96583a = null;
        this.f96584b = r100;
        this.f96585c = r101;
    }
}
