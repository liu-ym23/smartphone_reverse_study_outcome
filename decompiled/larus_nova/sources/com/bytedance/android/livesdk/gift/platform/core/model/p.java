package com.bytedance.android.livesdk.gift.platform.core.model;

import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h2 f130921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f130923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f130924d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L14;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f130921a, r101.f130921a) == true) goto L8;
        return false;
    L8:
        if (this.f130922b == r101.f130922b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f130923c, r101.f130923c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f130924d, r101.f130924d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        h2 r100 = this.f130921a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f130922b) * 31;
        DataCenter r104 = this.f130923c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f130924d;
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
        return "GiftTransactionInfo(currentGift=" + this.f130921a + ", sendGiftCount=" + this.f130922b + ", dataCenter=" + this.f130923c + ", transactionId=" + this.f130924d + ")";
    }

    public p(h2 r100, int r101, DataCenter r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r103, "transactionId");
        this.f130921a = r100;
        this.f130922b = r101;
        this.f130923c = r102;
        this.f130924d = r103;
    }
}
