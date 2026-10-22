package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECCategoryData;", "Ljava/io/Serializable;", "firstCid", "", "secondCid", "thirdCid", "fourthCid", "(JJJJ)V", "getFirstCid", "()J", "getFourthCid", "getSecondCid", "getThirdCid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECCategoryData implements Serializable {

    @SerializedName("first_cid")
    private final long firstCid;

    @SerializedName("fourth_cid")
    private final long fourthCid;

    @SerializedName("second_cid")
    private final long secondCid;

    @SerializedName("third_cid")
    private final long thirdCid;

    public ECCategoryData() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ECCategoryData copy$default(ECCategoryData r100, long r110, long r111, long r112, long r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r101 = r100.firstCid;
    L7:
        if ((r114 & 2) == 0) goto L9;
        long r102 = r100.secondCid;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r103 = r100.thirdCid;
    L15:
        if ((r114 & 8) == 0) goto L17;
        long r104 = r100.fourthCid;
    L19:
        return r100.copy(r101, r102, r103, r104);
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final long component1() {
        return this.firstCid;
    }

    public final long component2() {
        return this.secondCid;
    }

    public final long component3() {
        return this.thirdCid;
    }

    public final long component4() {
        return this.fourthCid;
    }

    public final ECCategoryData copy(long r110, long r111, long r112, long r113) {
        return new ECCategoryData(r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECCategoryData) == false) goto L14;
        ECCategoryData r101 = (ECCategoryData) r100;
        if (this.firstCid == r101.firstCid) goto L8;
        return false;
    L8:
        if (this.secondCid == r101.secondCid) goto L10;
        return false;
    L10:
        if (this.thirdCid == r101.thirdCid) goto L12;
        return false;
    L12:
        if (this.fourthCid == r101.fourthCid) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        long r100 = this.firstCid;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.secondCid;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.thirdCid;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.fourthCid;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public String toString() {
        return "ECCategoryData(firstCid=" + this.firstCid + ", secondCid=" + this.secondCid + ", thirdCid=" + this.thirdCid + ", fourthCid=" + this.fourthCid + ")";
    }

    public final long getFirstCid() {
        return this.firstCid;
    }

    public final long getFourthCid() {
        return this.fourthCid;
    }

    public final long getSecondCid() {
        return this.secondCid;
    }

    public final long getThirdCid() {
        return this.thirdCid;
    }

    public ECCategoryData(long r100, long r101, long r102, long r103) {
        this.firstCid = r100;
        this.secondCid = r101;
        this.thirdCid = r102;
        this.fourthCid = r103;
    }

    public /* synthetic */ ECCategoryData(long r110, long r111, long r112, long r113, int r114, DefaultConstructorMarker r115) {
        long r100 = 0;
        if ((r114 & 1) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r114 & 2) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r114 & 8) != 0) goto L18;
        r100 = r113;
    L18:
        this(r101, r102, r103, r100);
        return;
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
