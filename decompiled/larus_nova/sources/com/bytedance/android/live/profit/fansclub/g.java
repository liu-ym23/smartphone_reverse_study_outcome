package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f87296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f87297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f87298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f87299d;

    public g() {
        this(null, null, null, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L14;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f87296a, r101.f87296a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87297b, r101.f87297b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f87298c, r101.f87298c) == true) goto L12;
        return false;
    L12:
        if (this.f87299d == r101.f87299d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        b r100 = this.f87296a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f87297b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b r107 = this.f87298c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f87299d;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FansClubProfile(current=" + this.f87296a + ", personal=" + this.f87297b + ", otherRooms=" + this.f87298c + ", isAPIValue=" + this.f87299d + ")";
    }

    public final int b() {
        b r100 = this.f87296a;
        if (r100 == null) goto L10;
        j r101 = r100.f87278c;
        if (r101 == null) goto L10;
        FansClubUserStatus r102 = r101.f87319a;
        if (r102 == null) goto L10;
        return r102.getValue();
    L10:
        return FansClubUserStatus.Unknown.getValue();
    }

    public final boolean c() {
        if (this.f87296a != null) goto L5;
    L7:
        return false;
    L5:
        if (b() == FansClubUserStatus.Unknown.getValue()) goto L7;
        return true;
    }

    public static g a(g r100, b r101) {
        return new g(r101, r100.f87297b, r100.f87298c, true);
    }

    public g(b r100, b r101, b r102, boolean r103) {
        this.f87296a = r100;
        this.f87297b = r101;
        this.f87298c = r102;
        this.f87299d = r103;
    }
}
