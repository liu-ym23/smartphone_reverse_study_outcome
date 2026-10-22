package com.bytedance.android.shopping.anchorv4.voavhs.head.holder;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.FeaturedComment;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements com.bytedance.android.shopping.anchorv4.voavhs.head.base.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FeaturedComment f168677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f168678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f168679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f168680d;

    public b() {
        this(null, null, null, true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f168677a, r101.f168677a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168678b, r101.f168678b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168679c, r101.f168679c) == true) goto L12;
        return false;
    L12:
        if (this.f168680d == r101.f168680d) goto L22;
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
        FeaturedComment r100 = this.f168677a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f168678b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f168679c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f168680d;
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
        return "FeaturedCommentVO(featuredComment=" + this.f168677a + ", bgImage=" + this.f168678b + ", contentDescription=" + this.f168679c + ", fullscreen=" + this.f168680d + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final List<ECUrlModel> b() {
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final ECUrlModel a() {
        return this.f168678b;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.m
    public final String getDescription() {
        return this.f168679c;
    }

    public b(FeaturedComment r100, ECUrlModel r101, String r102, boolean r103) {
        this.f168677a = r100;
        this.f168678b = r101;
        this.f168679c = r102;
        this.f168680d = r103;
    }
}
