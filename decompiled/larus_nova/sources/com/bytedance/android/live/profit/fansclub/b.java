package com.bytedance.android.live.profit.fansclub;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f87277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f87278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f87279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f87280e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f87276a, r101.f87276a) == true) goto L8;
        return false;
    L8:
        if (this.f87277b == r101.f87277b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f87278c, r101.f87278c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f87279d, r101.f87279d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f87280e, r101.f87280e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f87276a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f87277b) * 31;
        j r104 = this.f87278c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.f87279d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        m r110 = this.f87280e;
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
        return "FansClubData(clubName=" + this.f87276a + ", level=" + this.f87277b + ", fansClubStatus=" + this.f87278c + ", badge=" + this.f87279d + ", guardInfo=" + this.f87280e + ")";
    }

    public final py.k b() {
        a r100 = this.f87279d;
        if (r100 == null) goto L12;
        py.k r101 = r100.f87275b;
        if (r101 == null) goto L12;
        List<String> r102 = r101.getUrls();
        if (r102 == null) goto L12;
        if ((!r102.isEmpty()) != true) goto L12;
        return this.f87279d.f87275b;
    L12:
        return null;
    }

    public static b a(b r100, a r101) {
        String r102 = r100.f87276a;
        int r103 = r100.f87277b;
        j r104 = r100.f87278c;
        m r105 = r100.f87280e;
        Intrinsics.checkNotNullParameter(r102, "clubName");
        Intrinsics.checkNotNullParameter(r104, "fansClubStatus");
        return new b(r102, r103, r104, r101, r105);
    }

    public b(String r100, int r101, j r102, a r103, m r104) {
        Intrinsics.checkNotNullParameter(r100, "clubName");
        Intrinsics.checkNotNullParameter(r102, "fansClubStatus");
        this.f87276a = r100;
        this.f87277b = r101;
        this.f87278c = r102;
        this.f87279d = r103;
        this.f87280e = r104;
    }
}
