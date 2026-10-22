package com.bytedance.android.live.broadcast.api.gamepromote;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f59005c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f59003a, r101.f59003a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59004b, r101.f59004b) == true) goto L10;
        return false;
    L10:
        if (this.f59005c == r101.f59005c) goto L19;
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
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f59003a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f59004b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f59005c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InstallIntroCard(roomId=" + this.f59003a + ", gameId=" + this.f59004b + ", withinTimeSpan=" + this.f59005c + ")";
    }

    public a(int r100) {
        Intrinsics.checkNotNullParameter("", "roomId");
        Intrinsics.checkNotNullParameter("", "gameId");
        this.f59003a = "";
        this.f59004b = "";
        this.f59005c = false;
    }
}
