package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f146942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f146943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146944c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f146942a, r101.f146942a) == true) goto L8;
        return false;
    L8:
        if (this.f146943b == r101.f146943b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f146944c, r101.f146944c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        String r100 = this.f146942a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f146943b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f146944c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoChorusMixConfig(leadSingerRtcUid=" + this.f146942a + ", isAccompanist=" + this.f146943b + ", subRoomID=" + this.f146944c + ")";
    }

    public d(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "leadSingerRtcUid");
        Intrinsics.checkNotNullParameter(r102, "subRoomID");
        this.f146942a = r100;
        this.f146943b = r101;
        this.f146944c = r102;
    }
}
