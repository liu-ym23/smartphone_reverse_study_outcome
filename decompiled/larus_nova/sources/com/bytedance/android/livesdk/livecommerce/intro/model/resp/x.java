package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/x;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "countDownBg", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCountDownBg", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "openPriceBg", "getOpenPriceBg", "priceConfetti", "getPriceConfetti", "buyButtonFlash", "getBuyButtonFlash", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("buy_button_flash")
    private final ECUrlModel buyButtonFlash;

    @SerializedName("count_down_bg")
    private final ECUrlModel countDownBg;

    @SerializedName("open_price_bg")
    private final ECUrlModel openPriceBg;

    @SerializedName("price_confetti")
    private final ECUrlModel priceConfetti;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L14;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.countDownBg, r101.countDownBg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.openPriceBg, r101.openPriceBg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.priceConfetti, r101.priceConfetti) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buyButtonFlash, r101.buyButtonFlash) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.countDownBg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.openPriceBg;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.priceConfetti;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECUrlModel r110 = this.buyButtonFlash;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "IntroOpenPriceAnimResources(countDownBg=" + this.countDownBg + ", openPriceBg=" + this.openPriceBg + ", priceConfetti=" + this.priceConfetti + ", buyButtonFlash=" + this.buyButtonFlash + ")";
    }

    public x() {
        this.countDownBg = null;
        this.openPriceBg = null;
        this.priceConfetti = null;
        this.buyButtonFlash = null;
    }
}
