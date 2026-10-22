package com.bytedance.android.btm.api;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends f<Activity> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Activity f41961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f41962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f41963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f41964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f41965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f41966l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f41961g, r101.f41961g) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f41962h, r101.f41962h) == true) goto L10;
        return false;
    L10:
        if (this.f41963i == r101.f41963i) goto L12;
        return false;
    L12:
        if (this.f41964j == r101.f41964j) goto L14;
        return false;
    L14:
        if (this.f41965k == r101.f41965k) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f41966l, r101.f41966l) == true) goto L28;
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
        Activity r100 = this.f41961g;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f41962h;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f41963i;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f41964j;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f41965k;
        if (r114 == true) goto L20;
        r108 = r114;
    L20:
        int r115 = (r113 + r108) * 31;
        String r116 = this.f41966l;
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
        return "ActivityPageInstance(page=" + this.f41961g + ", btm=" + this.f41962h + ", auto=" + this.f41963i + ", singleton=" + this.f41964j + ", reuse=" + this.f41965k + ", sourceBtmToken=" + this.f41966l + ")";
    }

    public a(Activity r110, String r111, String r112, int r113) {
        if ((r113 & 4) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r113 & 32) == 0) goto L9;
        r112 = null;
    L9:
        super(r110, r111, r100, false, false, r112);
        this.f41961g = r110;
        this.f41962h = r111;
        this.f41963i = r100;
        this.f41964j = false;
        this.f41965k = false;
        this.f41966l = r112;
        return;
    L5:
        r100 = false;
        goto L7
    }
}
