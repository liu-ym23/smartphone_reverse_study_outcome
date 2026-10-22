package com.bytedance.android.livesdk.livecommerce.livereplay.model;

import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0011\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J\t\u0010\n\u001a\u00020\u0006HÆ\u0003JA\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0012\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/model/ECScrollProductCardResponse;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/g;", "", "Lcom/bytedance/android/livesdk/livecommerce/livereplay/model/ECScrollProductCardData;", "component1", "", "component2", "", "component3", "component4", "replayCards", "pageTimestamp", "count", "serverTime", "copy", "", "toString", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getReplayCards", "()Ljava/util/List;", "getPageTimestamp", "I", "getCount", "()I", "J", "getServerTime", "()J", "<init>", "(Ljava/util/List;Ljava/util/List;IJ)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardResponse extends g implements Serializable {

    @SerializedName("card_count")
    private final int count;

    @SerializedName("page_timestamp")
    private final List<Long> pageTimestamp;

    @SerializedName("promotions")
    private final List<ECScrollProductCardData> replayCards;

    @SerializedName("server_time")
    private final long serverTime;

    public ECScrollProductCardResponse() {
        this(null, null, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECScrollProductCardResponse copy$default(ECScrollProductCardResponse r100, List r101, List r102, int r103, long r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.replayCards;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.pageTimestamp;
    L8:
        List r111 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.count;
    L11:
        int r106 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.serverTime;
    L14:
        List r107 = r101;
        return r100.copy(r107, r111, r106, r104);
    }

    public final List<ECScrollProductCardData> component1() {
        return this.replayCards;
    }

    public final List<Long> component2() {
        return this.pageTimestamp;
    }

    public final int component3() {
        return this.count;
    }

    public final long component4() {
        return this.serverTime;
    }

    public final ECScrollProductCardResponse copy(List<ECScrollProductCardData> r100, List<Long> r101, int r110, long r111) {
        return new ECScrollProductCardResponse(r100, r101, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECScrollProductCardResponse) == false) goto L14;
        ECScrollProductCardResponse r101 = (ECScrollProductCardResponse) r100;
        if (Intrinsics.areEqual(this.replayCards, r101.replayCards) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pageTimestamp, r101.pageTimestamp) == true) goto L10;
        return false;
    L10:
        if (this.count == r101.count) goto L12;
        return false;
    L12:
        if (this.serverTime == r101.serverTime) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<ECScrollProductCardData> r100 = this.replayCards;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Long> r104 = this.pageTimestamp;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((r103 + r101) * 31) + this.count) * 31;
        long r106 = this.serverTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECScrollProductCardResponse(replayCards=" + this.replayCards + ", pageTimestamp=" + this.pageTimestamp + ", count=" + this.count + ", serverTime=" + this.serverTime + ")";
    }

    public final int getCount() {
        return this.count;
    }

    public final List<Long> getPageTimestamp() {
        return this.pageTimestamp;
    }

    public final List<ECScrollProductCardData> getReplayCards() {
        return this.replayCards;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public ECScrollProductCardResponse(List<ECScrollProductCardData> r100, List<Long> r101, int r102, long r103) {
        this.replayCards = r100;
        this.pageTimestamp = r101;
        this.count = r102;
        this.serverTime = r103;
    }

    public /* synthetic */ ECScrollProductCardResponse(List r100, List r101, int r102, long r103, int r104, DefaultConstructorMarker r105) {
        List r106 = null;
        if ((r104 & 1) == 0) goto L5;
        List r107 = null;
    L7:
        if ((r104 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r104 & 4) == 0) goto L13;
        int r108 = 0;
    L15:
        if ((r104 & 8) == 0) goto L17;
        r103 = 0;
    L17:
        this(r107, r106, r108, r103);
        return;
    L13:
        r108 = r102;
        goto L15
    L5:
        r107 = r100;
        goto L7
    }
}
