package com.bytedance.android.shopping.api.mall.feed;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallFeedStickyConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f170502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f170503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f170504c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECMallFeedStickyConfig) == false) goto L12;
        ECMallFeedStickyConfig r101 = (ECMallFeedStickyConfig) r100;
        if (Intrinsics.areEqual(this.f170502a, r101.f170502a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f170503b, r101.f170503b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f170504c, r101.f170504c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Function0<Boolean> r100 = this.f170502a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function0<Unit> r104 = this.f170503b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Integer> r107 = this.f170504c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECMallFeedStickyConfig(needSticky=" + this.f170502a + ", doSticky=" + this.f170503b + ", getOffSet=" + this.f170504c + ")";
    }

    public /* synthetic */ ECMallFeedStickyConfig(Function0 r100, Function0 r101) {
        this(r100, r101, AnonymousClass1.INSTANCE);
    }

    public ECMallFeedStickyConfig(Function0<Boolean> r100, Function0<Unit> r101, Function0<Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "needSticky");
        Intrinsics.checkNotNullParameter(r101, "doSticky");
        Intrinsics.checkNotNullParameter(r102, "getOffSet");
        this.f170502a = r100;
        this.f170503b = r101;
        this.f170504c = r102;
    }
}
