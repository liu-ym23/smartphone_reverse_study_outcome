package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f87324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f87326c;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (this.f87324a == r101.f87324a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87325b, r101.f87325b) == true) goto L10;
        return false;
    L10:
        if (this.f87326c == r101.f87326c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f87324a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f87325b;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f87326c;
        if (r107 == true) goto L14;
        r101 = r107;
    L14:
        return r106 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "FansGroupInfo(isGroupLive=" + this.f87324a + ", selectAnchorId=" + this.f87325b + ", isManualSelect=" + this.f87326c + ")";
    }

    public /* synthetic */ l(int r100) {
        this(false, "", false);
    }

    public l(boolean r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "selectAnchorId");
        this.f87324a = r100;
        this.f87325b = r101;
        this.f87326c = r102;
    }
}
