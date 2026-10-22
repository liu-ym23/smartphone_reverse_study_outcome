package com.bytedance.android.livesdk.livecommerce.network.response;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u001a\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECPromotionCountResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "component1", "count", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "getCount", "()J", "<init>", "(J)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionCountResponse extends g implements Serializable {

    @SerializedName("count")
    private final long count;

    public ECPromotionCountResponse() {
        long r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ ECPromotionCountResponse copy$default(ECPromotionCountResponse r100, long r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.count;
    L6:
        return r100.copy(r101);
    }

    public final long component1() {
        return this.count;
    }

    public final ECPromotionCountResponse copy(long r100) {
        return new ECPromotionCountResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionCountResponse) == true) goto L6;
        return false;
    L6:
        if (this.count == ((ECPromotionCountResponse) r100).count) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        long r100 = this.count;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public String toString() {
        return "ECPromotionCountResponse(count=" + this.count + ")";
    }

    public final long getCount() {
        return this.count;
    }

    public ECPromotionCountResponse(long r100) {
        this.count = r100;
    }

    public /* synthetic */ ECPromotionCountResponse(long r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
