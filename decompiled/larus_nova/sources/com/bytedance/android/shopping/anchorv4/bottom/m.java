package com.bytedance.android.shopping.anchorv4.bottom;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f165854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentManager f165855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f165856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f165857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f165858e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f165859f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f165860g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L20;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f165854a, r101.f165854a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f165855b, r101.f165855b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f165856c, r101.f165856c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f165857d, r101.f165857d) == true) goto L14;
        return false;
    L14:
        if (this.f165858e == r101.f165858e) goto L16;
        return false;
    L16:
        if (this.f165859f == r101.f165859f) goto L18;
        return false;
    L18:
        if (this.f165860g == r101.f165860g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        FragmentActivity r100 = this.f165854a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FragmentManager r104 = this.f165855b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f165856c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f165857d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.f165858e;
        ?? r113 = 1;
        ?? r114 = r112;
        if (r112 == false) goto L20;
        r114 = 1;
    L20:
        int r115 = (r111 + r114) * 31;
        boolean r116 = this.f165859f;
        ?? r117 = r116;
        if (r116 == false) goto L23;
        r117 = 1;
    L23:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f165860g;
        if (r119 == true) goto L28;
        r113 = r119;
    L28:
        return r118 + r113;
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
        return "BuyNativeParam(activity=" + this.f165854a + ", fragmentManager=" + this.f165855b + ", btmView=" + this.f165856c + ", promotionLogId=" + this.f165857d + ", isFromFeedProductGuessULike=" + this.f165858e + ", isGroupBuying=" + this.f165859f + ", isCustomBuying=" + this.f165860g + ")";
    }

    public final FragmentActivity getActivity() {
        return this.f165854a;
    }

    public m(FragmentActivity r100, FragmentManager r101, View r102, String r103, boolean r104, boolean r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        this.f165854a = r100;
        this.f165855b = r101;
        this.f165856c = r102;
        this.f165857d = r103;
        this.f165858e = r104;
        this.f165859f = r105;
        this.f165860g = r106;
    }
}
