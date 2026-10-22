package com.bytedance.android.live.wallet.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f102682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f102683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f102684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f102685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f102686e;

    public final String toString() {
        return "OrderData(orderId='" + this.f102682a + "', cjMerchantId='" + this.f102683b + "', cjAppId='" + this.f102684c + "', iapProductId='" + this.f102685d + "', sdkParam='" + this.f102686e + "')";
    }

    public g(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "orderId");
        Intrinsics.checkNotNullParameter(r101, "cjMerchantId");
        Intrinsics.checkNotNullParameter(r102, "cjAppId");
        Intrinsics.checkNotNullParameter(r103, "iapProductId");
        Intrinsics.checkNotNullParameter(r104, "sdkParam");
        this.f102682a = r100;
        this.f102683b = r101;
        this.f102684c = r102;
        this.f102685d = r103;
        this.f102686e = r104;
    }
}
