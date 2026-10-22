package com.bytedance.android.livesdk.announce;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f103139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f103140b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f103139a, r101.f103139a) == true) goto L8;
        return false;
    L8:
        if (this.f103140b == r101.f103140b) goto L16;
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
        String r100 = this.f103139a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f103140b;
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
        return "AnnouncementWeekdayInfo(name=" + this.f103139a + ", isSelected=" + this.f103140b + ")";
    }

    public d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f103139a = r100;
        this.f103140b = r101;
    }
}
