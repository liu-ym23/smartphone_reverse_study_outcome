package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a0;", "", "", "serverTime", "J", "getServerTime", "()J", "endTime", "getEndTime", "Lcom/bytedance/android/ec/model/ECUrlModel;", "suffix", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getSuffix", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "getTrack", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("suffix")
    private final ECUrlModel suffix;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final b0 track;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L14;
        a0 r101 = (a0) r100;
        if (this.serverTime == r101.serverTime) goto L8;
        return false;
    L8:
        if (this.endTime == r101.endTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.suffix, r101.suffix) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.serverTime;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.endTime;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        ECUrlModel r104 = this.suffix;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        b0 r108 = this.track;
        if (r108 == null) goto L10;
        r105 = r108.hashCode();
    L10:
        return r107 + r105;
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroOpenPriceCountDown(serverTime=" + this.serverTime + ", endTime=" + this.endTime + ", suffix=" + this.suffix + ", track=" + this.track + ")";
    }

    public a0() {
        this.serverTime = 0;
        this.endTime = 0;
        this.suffix = null;
        this.track = null;
    }
}
