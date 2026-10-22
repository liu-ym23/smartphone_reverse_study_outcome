package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k;", "breathingPrice", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k;", "getBreathingPrice", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/k;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "description", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getDescription", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("breathing_price")
    private final k breathingPrice;

    @SerializedName("description")
    private final ECUrlModel description;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.breathingPrice, r101.breathingPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        k r100 = this.breathingPrice;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.description;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroBreathingLightPrice(breathingPrice=" + this.breathingPrice + ", description=" + this.description + ")";
    }

    public j() {
        this.breathingPrice = null;
        this.description = null;
    }
}
