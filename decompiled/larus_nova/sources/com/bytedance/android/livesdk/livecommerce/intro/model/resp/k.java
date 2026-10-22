package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k;", "", "", "price", "Ljava/lang/String;", "getPrice", "()Ljava/lang/String;", "", "fontSize", "I", "getFontSize", "()I", "breathingTimes", "getBreathingTimes", "", "breathingInterval", "J", "getBreathingInterval", "()J", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("breathing_interval")
    private final long breathingInterval;

    @SerializedName("breathing_times")
    private final int breathingTimes;

    @SerializedName("font_size")
    private final int fontSize;

    @SerializedName("price")
    private final String price;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L14;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.price, r101.price) == true) goto L8;
        return false;
    L8:
        if (this.fontSize == r101.fontSize) goto L10;
        return false;
    L10:
        if (this.breathingTimes == r101.breathingTimes) goto L12;
        return false;
    L12:
        if (this.breathingInterval == r101.breathingInterval) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.price;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((((r101 * 31) + this.fontSize) * 31) + this.breathingTimes) * 31;
        long r103 = this.breathingInterval;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroBreathingPrice(price=" + this.price + ", fontSize=" + this.fontSize + ", breathingTimes=" + this.breathingTimes + ", breathingInterval=" + this.breathingInterval + ")";
    }

    public k() {
        this.price = null;
        this.fontSize = 0;
        this.breathingTimes = 0;
        this.breathingInterval = 0;
    }
}
