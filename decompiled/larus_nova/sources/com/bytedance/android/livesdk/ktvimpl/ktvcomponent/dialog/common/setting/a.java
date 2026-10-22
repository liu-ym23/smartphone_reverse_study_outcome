package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CloseChallengeType f144114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f144115b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f144114a, r101.f144114a) == true) goto L8;
        return false;
    L8:
        if (this.f144115b == r101.f144115b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        CloseChallengeType r100 = this.f144114a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f144115b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "CloseChallengeEvent(closeChallengeType=" + this.f144114a + ", isCloseSuccess=" + this.f144115b + ")";
    }

    public a() {
        this(CloseChallengeType.UNKNOWN, false);
    }

    public a(CloseChallengeType r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "closeChallengeType");
        this.f144114a = r100;
        this.f144115b = r101;
    }
}
