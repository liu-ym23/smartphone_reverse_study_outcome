package com.bytedance.android.live.revlink.impl.pk.vm.linkout;

import com.bytedance.android.livesdk.link.model.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p0 f97251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f97252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f97253c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f97251a, r101.f97251a) == true) goto L8;
        return false;
    L8:
        if (this.f97252b == r101.f97252b) goto L10;
        return false;
    L10:
        if (this.f97253c == r101.f97253c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        p0 r100 = this.f97251a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f97252b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.f97253c;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "RandomMatchInfo(battleAttachedInfo=" + this.f97251a + ", matchStrategy=" + this.f97252b + ", isSeasonRank=" + this.f97253c + ")";
    }

    public p(String r100, long r101, boolean r102) {
        this.f97251a = e21.c.c(p0.Companion, r100);
        this.f97252b = r101;
        this.f97253c = r102;
    }
}
