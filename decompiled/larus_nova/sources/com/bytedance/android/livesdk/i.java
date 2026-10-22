package com.bytedance.android.livesdk;

import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/i;", "", "", TriggerTiming.NOW, "J", "getNow", "()J", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName(TriggerTiming.NOW)
    private final long now;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == true) goto L6;
        return false;
    L6:
        if (this.now == ((i) r100).now) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r100 = this.now;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "ExtraData(now=" + this.now + ")";
    }
}
