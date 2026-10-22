package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.livesdk.gift.model.c1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f130616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f130617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c1> f130618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f130619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Long> f130620e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L16;
        k r101 = (k) r100;
        if (this.f130616a == r101.f130616a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f130617b, r101.f130617b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f130618c, r101.f130618c) == true) goto L12;
        return false;
    L12:
        if (this.f130619d == r101.f130619d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f130620e, r101.f130620e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f130616a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<Long> r102 = this.f130617b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        List<c1> r106 = this.f130618c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        long r108 = this.f130619d;
        int r109 = (((r105 + r107) * 31) + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        List<Long> r110 = this.f130620e;
        if (r110 == null) goto L14;
        r103 = r110.hashCode();
    L14:
        return r109 + r103;
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "PagingGiftListModel(pagingId=" + this.f130616a + ", giftListIds=" + this.f130617b + ", remainingBaseGifts=" + this.f130618c + ", curRequestLastGiftId=" + this.f130619d + ", curResponseLoadGiftIds=" + this.f130620e + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(long r100, List<Long> r101, List<? extends c1> r102, long r103, List<Long> r104) {
        Intrinsics.checkNotNullParameter(r101, "giftListIds");
        Intrinsics.checkNotNullParameter(r102, "remainingBaseGifts");
        Intrinsics.checkNotNullParameter(r104, "curResponseLoadGiftIds");
        this.f130616a = r100;
        this.f130617b = r101;
        this.f130618c = r102;
        this.f130619d = r103;
        this.f130620e = r104;
    }
}
