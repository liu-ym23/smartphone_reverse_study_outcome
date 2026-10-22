package com.bytedance.android.livesdk.livecommerce.livereplay.model;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/model/ECScrollProductCardData;", "Ljava/io/Serializable;", "promotion", "Lcom/bytedance/android/ec/model/response/ECPromotion;", "explainStartTime", "", "explainEndTime", "isGenera", "", "(Lcom/bytedance/android/ec/model/response/ECPromotion;JJZ)V", "getExplainEndTime", "()J", "getExplainStartTime", "()Z", "getPromotion", "()Lcom/bytedance/android/ec/model/response/ECPromotion;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardData implements Serializable {

    @SerializedName("explain_end_time")
    private final long explainEndTime;

    @SerializedName("explain_start_time")
    private final long explainStartTime;

    @SerializedName("is_genera")
    private final boolean isGenera;

    @SerializedName("promotion")
    private final ECPromotion promotion;

    public ECScrollProductCardData() {
        this(null, 0, 0, false, 15, null);
    }

    public static /* synthetic */ ECScrollProductCardData copy$default(ECScrollProductCardData r100, ECPromotion r101, long r102, long r103, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.promotion;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.explainStartTime;
    L8:
        long r104 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.explainEndTime;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r110 = r100.isGenera;
    L14:
        ECPromotion r106 = r101;
        return r100.copy(r106, r104, r105, r110);
    }

    public final ECPromotion component1() {
        return this.promotion;
    }

    public final long component2() {
        return this.explainStartTime;
    }

    public final long component3() {
        return this.explainEndTime;
    }

    public final boolean component4() {
        return this.isGenera;
    }

    public final ECScrollProductCardData copy(ECPromotion r100, long r110, long r111, boolean r112) {
        return new ECScrollProductCardData(r100, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECScrollProductCardData) == false) goto L14;
        ECScrollProductCardData r101 = (ECScrollProductCardData) r100;
        if (Intrinsics.areEqual(this.promotion, r101.promotion) == true) goto L8;
        return false;
    L8:
        if (this.explainStartTime == r101.explainStartTime) goto L10;
        return false;
    L10:
        if (this.explainEndTime == r101.explainEndTime) goto L12;
        return false;
    L12:
        if (this.isGenera == r101.isGenera) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        ECPromotion r100 = this.promotion;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.explainStartTime;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.explainEndTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        boolean r106 = this.isGenera;
        ?? r107 = r106;
        if (r106 == false) goto L10;
        r107 = 1;
    L10:
        return r105 + r107;
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "ECScrollProductCardData(promotion=" + this.promotion + ", explainStartTime=" + this.explainStartTime + ", explainEndTime=" + this.explainEndTime + ", isGenera=" + this.isGenera + ")";
    }

    public final long getExplainEndTime() {
        return this.explainEndTime;
    }

    public final long getExplainStartTime() {
        return this.explainStartTime;
    }

    public final ECPromotion getPromotion() {
        return this.promotion;
    }

    public final boolean isGenera() {
        return this.isGenera;
    }

    public ECScrollProductCardData(ECPromotion r100, long r101, long r102, boolean r103) {
        this.promotion = r100;
        this.explainStartTime = r101;
        this.explainEndTime = r102;
        this.isGenera = r103;
    }

    public /* synthetic */ ECScrollProductCardData(ECPromotion r100, long r101, long r102, boolean r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r100 = null;
    L5:
        long r103 = 0;
        if ((r111 & 2) == 0) goto L8;
        long r104 = 0;
    L10:
        if ((r111 & 4) != 0) goto L14;
        r103 = r102;
    L14:
        if ((r111 & 8) == 0) goto L16;
        boolean r113 = false;
    L17:
        this(r100, r104, r103, r113);
        return;
    L16:
        r113 = r110;
        goto L17
    L8:
        r104 = r101;
        goto L10
    }
}
