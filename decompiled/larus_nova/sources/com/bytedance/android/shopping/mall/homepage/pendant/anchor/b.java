package com.bytedance.android.shopping.mall.homepage.pendant.anchor;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f178357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final of3.a f178358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f178359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f178360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f178361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f178362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f178363g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f178357a, r101.f178357a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f178358b, r101.f178358b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f178359c, r101.f178359c) == true) goto L12;
        return false;
    L12:
        if (this.f178360d == r101.f178360d) goto L14;
        return false;
    L14:
        if (this.f178361e == r101.f178361e) goto L16;
        return false;
    L16:
        if (this.f178362f == r101.f178362f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f178363g, r101.f178363g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f178357a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        of3.a r104 = this.f178358b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f178359c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f178360d;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f178361e;
        ?? r115 = r114;
        if (r114 == false) goto L20;
        r115 = 1;
    L20:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f178362f;
        if (r117 == true) goto L24;
        r111 = r117;
    L24:
        int r118 = (r116 + r111) * 31;
        Integer r119 = this.f178363g;
        if (r119 == null) goto L28;
        r101 = r119.hashCode();
    L28:
        return r118 + r101;
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
        return "AnchorPendantExtra(schema=" + this.f178357a + ", lynxPendant=" + this.f178358b + ", lynxView=" + this.f178359c + ", fixedLocation=" + this.f178360d + ", isSticky=" + this.f178361e + ", recycleAfterDismiss=" + this.f178362f + ", sceneType=" + this.f178363g + ")";
    }

    public b(String r100, of3.a r101, View r102, boolean r103, boolean r104, boolean r105, Integer r106) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "lynxPendant");
        this.f178357a = r100;
        this.f178358b = r101;
        this.f178359c = r102;
        this.f178360d = r103;
        this.f178361e = r104;
        this.f178362f = r105;
        this.f178363g = r106;
    }
}
