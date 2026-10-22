package com.bytedance.android.btm.api;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h extends f<Fragment> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Fragment f41985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f41986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f41987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f41988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f41989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f41990l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L18;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f41985g, r101.f41985g) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f41986h, r101.f41986h) == true) goto L10;
        return false;
    L10:
        if (this.f41987i == r101.f41987i) goto L12;
        return false;
    L12:
        if (this.f41988j == r101.f41988j) goto L14;
        return false;
    L14:
        if (this.f41989k == r101.f41989k) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f41990l, r101.f41990l) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Fragment r100 = this.f41985g;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f41986h;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f41987i;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f41988j;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f41989k;
        if (r114 == true) goto L20;
        r108 = r114;
    L20:
        int r115 = (r113 + r108) * 31;
        String r116 = this.f41990l;
        if (r116 == null) goto L24;
        r101 = r116.hashCode();
    L24:
        return r115 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FragmentPageInstance(page=" + this.f41985g + ", btm=" + this.f41986h + ", auto=" + this.f41987i + ", singleton=" + this.f41988j + ", reuse=" + this.f41989k + ", sourceBtmToken=" + this.f41990l + ")";
    }

    public h(Fragment r110, String r111, String r112, int r113) {
        if ((r113 & 2) == 0) goto L6;
        r111 = "";
    L6:
        if ((r113 & 4) == 0) goto L8;
        boolean r100 = true;
    L10:
        if ((r113 & 32) == 0) goto L12;
        r112 = null;
    L12:
        super(r110, r111, r100, false, false, r112);
        this.f41985g = r110;
        this.f41986h = r111;
        this.f41987i = r100;
        this.f41988j = false;
        this.f41989k = false;
        this.f41990l = r112;
        return;
    L8:
        r100 = false;
        goto L10
    }
}
