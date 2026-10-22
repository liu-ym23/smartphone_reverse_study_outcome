package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f130624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f130626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f130627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f130628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f130629f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L18;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f130624a, r101.f130624a) == true) goto L8;
        return false;
    L8:
        if (this.f130625b == r101.f130625b) goto L10;
        return false;
    L10:
        if (this.f130626c == r101.f130626c) goto L12;
        return false;
    L12:
        if (this.f130627d == r101.f130627d) goto L14;
        return false;
    L14:
        if (this.f130628e == r101.f130628e) goto L16;
        return false;
    L16:
        if (this.f130629f == r101.f130629f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        h1 r100 = this.f130624a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((((((((r101 * 31) + this.f130625b) * 31) + this.f130626c) * 31) + this.f130627d) * 31) + this.f130628e) * 31;
        long r103 = this.f130629f;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "RemindGiftModel(gift=" + this.f130624a + ", newPosition=" + this.f130625b + ", originPageType=" + this.f130626c + ", posDiff=" + this.f130627d + ", priceDiff=" + this.f130628e + ", originGiftId=" + this.f130629f + ")";
    }

    public p(h1 r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PbRequest.SwitchType.GIFT);
        this.f130624a = r100;
        this.f130625b = r101;
        this.f130626c = r102;
        this.f130627d = 1000000;
        this.f130628e = 1000000;
        this.f130629f = -1;
    }
}
