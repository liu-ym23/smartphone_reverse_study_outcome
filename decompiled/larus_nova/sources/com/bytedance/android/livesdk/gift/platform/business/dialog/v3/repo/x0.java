package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Long> f128577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f128578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f128579c;

    public x0() {
        List r100 = null;
        this(r100, false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x0) == false) goto L12;
        x0 r101 = (x0) r100;
        if (Intrinsics.areEqual(this.f128577a, r101.f128577a) == true) goto L8;
        return false;
    L8:
        if (this.f128578b == r101.f128578b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f128579c, r101.f128579c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        List<Long> r100 = this.f128577a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f128578b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f128579c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateGiftData(giftIds=" + this.f128577a + ", needMarketingAnim=" + this.f128578b + ", source=" + this.f128579c + ")";
    }

    public /* synthetic */ x0(List r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r102 & 4) == 0) goto L11;
        String r103 = "";
    L12:
        this(r100, r101, r103);
        return;
    L11:
        r103 = null;
        goto L12
    }

    public x0(List<Long> r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "giftIds");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f128577a = r100;
        this.f128578b = r101;
        this.f128579c = r102;
    }
}
