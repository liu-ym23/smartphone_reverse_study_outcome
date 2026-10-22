package com.bytedance.android.ec.window.base.repository.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/WindowMarketingDataDTO;", "Ljava/io/Serializable;", "returnReward", "", "returnRewardPrefix", "returnRewardUnit", "transMeta", "cardType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCardType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getReturnReward", "()Ljava/lang/String;", "getReturnRewardPrefix", "getReturnRewardUnit", "getTransMeta", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/ec/window/base/repository/dto/WindowMarketingDataDTO;", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowMarketingDataDTO implements Serializable {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    private final Integer cardType;

    @SerializedName("return_reward")
    private final String returnReward;

    @SerializedName("return_reward_prefix")
    private final String returnRewardPrefix;

    @SerializedName("return_reward_unit")
    private final String returnRewardUnit;

    @SerializedName("trans_meta")
    private final String transMeta;

    public WindowMarketingDataDTO() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ WindowMarketingDataDTO copy$default(WindowMarketingDataDTO r100, String r101, String r102, String r103, String r104, Integer r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.returnReward;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.returnRewardPrefix;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.returnRewardUnit;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.transMeta;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.cardType;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.returnReward;
    }

    public final String component2() {
        return this.returnRewardPrefix;
    }

    public final String component3() {
        return this.returnRewardUnit;
    }

    public final String component4() {
        return this.transMeta;
    }

    public final Integer component5() {
        return this.cardType;
    }

    public final WindowMarketingDataDTO copy(String r100, String r101, String r110, String r111, Integer r112) {
        return new WindowMarketingDataDTO(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowMarketingDataDTO) == false) goto L16;
        WindowMarketingDataDTO r101 = (WindowMarketingDataDTO) r100;
        if (Intrinsics.areEqual(this.returnReward, r101.returnReward) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.returnRewardPrefix, r101.returnRewardPrefix) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.returnRewardUnit, r101.returnRewardUnit) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.transMeta, r101.transMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cardType, r101.cardType) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.returnReward;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.returnRewardPrefix;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.returnRewardUnit;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.transMeta;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.cardType;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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

    public String toString() {
        return "WindowMarketingDataDTO(returnReward=" + this.returnReward + ", returnRewardPrefix=" + this.returnRewardPrefix + ", returnRewardUnit=" + this.returnRewardUnit + ", transMeta=" + this.transMeta + ", cardType=" + this.cardType + ")";
    }

    public final Integer getCardType() {
        return this.cardType;
    }

    public final String getReturnReward() {
        return this.returnReward;
    }

    public final String getReturnRewardPrefix() {
        return this.returnRewardPrefix;
    }

    public final String getReturnRewardUnit() {
        return this.returnRewardUnit;
    }

    public final String getTransMeta() {
        return this.transMeta;
    }

    public WindowMarketingDataDTO(String r100, String r101, String r102, String r103, Integer r104) {
        this.returnReward = r100;
        this.returnRewardPrefix = r101;
        this.returnRewardUnit = r102;
        this.transMeta = r103;
        this.cardType = r104;
    }

    public /* synthetic */ WindowMarketingDataDTO(String r100, String r101, String r102, String r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
