package com.bytedance.android.shopping.feed;

import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PromotionPackResponse f175100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f175101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f175102c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L12;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f175100a, r101.f175100a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f175101b, r101.f175101b) == true) goto L10;
        return false;
    L10:
        if (this.f175102c == r101.f175102c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        PromotionPackResponse r100 = this.f175100a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f175101b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f175102c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PromotionResponseCacheStruct(curResponse=" + this.f175100a + ", awemeId=" + this.f175101b + ", timeStamp=" + this.f175102c + ")";
    }

    public j(PromotionPackResponse r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "curResponse");
        Intrinsics.checkNotNullParameter(r101, "awemeId");
        this.f175100a = r100;
        this.f175101b = r101;
        this.f175102c = r102;
    }
}
