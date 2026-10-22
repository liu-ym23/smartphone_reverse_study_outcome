package com.bytedance.android.shopping.commentv3.audio;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f172638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f172639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StopReason f172640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f172641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f172642e;

    public u() {
        boolean r100 = false;
        this(r100, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L16;
        u r101 = (u) r100;
        if (this.f172638a == r101.f172638a) goto L8;
        return false;
    L8:
        if (this.f172639b == r101.f172639b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172640c, r101.f172640c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f172641d, r101.f172641d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f172642e, r101.f172642e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r100 = this.f172638a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f172639b;
        if (r104 == true) goto L9;
        r101 = r104;
    L9:
        int r105 = (r103 + r101) * 31;
        StopReason r106 = this.f172640c;
        int r107 = 0;
        if (r106 == null) goto L12;
        int r108 = r106.hashCode();
    L13:
        int r109 = (r105 + r108) * 31;
        y r110 = this.f172641d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        t r113 = this.f172642e;
        if (r113 == null) goto L21;
        r107 = r113.hashCode();
    L21:
        return r112 + r107;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    }

    public final String toString() {
        return "PlayDecision(allowPlay=" + this.f172638a + ", stopCurrent=" + this.f172639b + ", stopReason=" + this.f172640c + ", stopOptions=" + this.f172641d + ", externalAudioRequest=" + this.f172642e + ")";
    }

    public /* synthetic */ u(boolean r100, t r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r111 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r111 & 4) == 0) goto L13;
        StopReason r103 = StopReason.REPLACED_BY_OTHER;
    L15:
        if ((r111 & 8) == 0) goto L17;
        y r104 = new y(false, 7);
    L19:
        if ((r111 & 16) == 0) goto L21;
        t r105 = null;
    L22:
        this(r101, r102, r103, r104, r105);
        return;
    L21:
        r105 = r110;
        goto L22
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public u(boolean r100, boolean r101, StopReason r102, y r103, t r104) {
        Intrinsics.checkNotNullParameter(r102, "stopReason");
        Intrinsics.checkNotNullParameter(r103, "stopOptions");
        this.f172638a = r100;
        this.f172639b = r101;
        this.f172640c = r102;
        this.f172641d = r103;
        this.f172642e = r104;
    }
}
