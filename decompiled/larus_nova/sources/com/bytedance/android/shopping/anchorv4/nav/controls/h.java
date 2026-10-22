package com.bytedance.android.shopping.anchorv4.nav.controls;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f167143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<e> f167144b;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (this.f167143a == r101.f167143a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167144b, r101.f167144b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f167143a * 31;
        List<e> r101 = this.f167144b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ShareBtnAnimRecord(day=" + this.f167143a + ", recordList=" + this.f167144b + ")";
    }

    public /* synthetic */ h(int r100) {
        this(-1, CollectionsKt.emptyList());
    }

    public h(int r100, List<e> r101) {
        Intrinsics.checkNotNullParameter(r101, "recordList");
        this.f167143a = r100;
        this.f167144b = r101;
    }
}
