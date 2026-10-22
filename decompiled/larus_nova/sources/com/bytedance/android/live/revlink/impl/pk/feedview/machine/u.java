package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.e3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f96596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e3 f96597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c3 f96598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.link.model.r.b f96599d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L14;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f96596a, r101.f96596a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f96597b, r101.f96597b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f96598c, r101.f96598c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f96599d, r101.f96599d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        v r100 = this.f96596a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e3 r104 = this.f96597b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        c3 r107 = this.f96598c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.livesdk.link.model.r.b r110 = this.f96599d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PkBattleStats(pkInfo=" + this.f96596a + ", message=" + this.f96597b + ", battleStatsMeta=" + this.f96598c + ", bizExtra=" + this.f96599d + ")";
    }

    public u(v r100, c3 r101) {
        Intrinsics.checkNotNullParameter(r100, "pkInfo");
        this.f96596a = r100;
        this.f96597b = null;
        this.f96598c = r101;
        this.f96599d = null;
    }
}
